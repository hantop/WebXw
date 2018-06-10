package  app.creditapp.dev.bo.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.struts2.ServletActionContext;

import app.base.BaseService;
import app.base.ServiceException;
import app.creditapp.dev.bo.PopParmConfBo;
import app.creditapp.dev.dao.PopParmConfDao;
import app.creditapp.dev.entity.PopParmConf;
import app.util.PopUtil;
import app.util.User;
import app.util.toolkit.Ipage;
/**
* Title: PopParmConfBoImplImpl.java
* Description:
**/
public class PopParmConfBoImpl extends BaseService implements PopParmConfBo {

	private PopParmConfDao popParmConfDao;
	private DataSource dataSource;

	public void del(PopParmConf popParmConf) throws ServiceException {
		try {
			popParmConfDao.del(popParmConf);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}

	public Ipage findByPage(Ipage ipg, PopParmConf popParmConf)
			throws ServiceException {
		try {
			ipg.initPageCounts(new Integer[] { (Integer) popParmConfDao
					.getCount(popParmConf) });// ��ʼ����ҳ��
			popParmConf.setStartNumAndEndNum (ipg);
			ipg.setResult(popParmConfDao.findByPage(popParmConf));
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return ipg;
	}
	@Override
	public Map findByPopChB(String sceneId, String parms)
			throws ServiceException {
		Map<String,Object> map = new HashMap<String,Object>();
		Connection conn = null;

		try{
			//1����ѯ��POP���������
			PopParmConf popParmConf = new PopParmConf();
			popParmConf.setScene_id(sceneId);
			popParmConf = popParmConfDao.getById(popParmConf);
			//2��������õ�SQL�����в����滻
			String sql = popParmConf.getSql();
			String dyn_or = popParmConf.getDyn_or();
			String dyn_and = popParmConf.getDyn_and();
			String orderBy = popParmConf.getOrderby();
			if( dyn_and!=null && !"".equals(dyn_and) ){
				sql = PopUtil.getSql(sql, dyn_and, parms, "AND");
			}
			if( dyn_or!=null && !"".equals(dyn_or) ){
				sql = PopUtil.getSql(sql, dyn_and, parms, "OR");
			}
			if( orderBy!=null && !"".equals(orderBy) ){
				sql = sql+" "+orderBy;
			}
			String count_sql = "SELECT count(*) from (" + sql +")";
			conn = dataSource.getConnection();
			int count = popParmConfDao.getCountPop(conn, count_sql);
			//3��map��صĸ�ֵ
			map.put("sql", sql);
			map.put("rel", popParmConf.getDb_bean_rel());
			map.put("sceneId", sceneId);
			map.put("size", count);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return map;
	}

	public Map findByPop(String sceneId, String parms,String query_sql) throws ServiceException {
		Map<String,Object> map = new HashMap<String,Object>();
		Connection conn = null;
		try{
			//1����ѯ��POP���������
			PopParmConf popParmConf = new PopParmConf();
			popParmConf.setScene_id(sceneId);
			popParmConf = popParmConfDao.getById(popParmConf);
			//2��������õ�SQL�����в����滻
			String sql = popParmConf.getSql();
			String dyn_or = popParmConf.getDyn_or();
			String dyn_and = popParmConf.getDyn_and();
			String orderBy = popParmConf.getOrderby();
			String if_query = popParmConf.getIf_query();
			
			
			if( dyn_and!=null && !"".equals(dyn_and) ){
				
				//sql = PopUtil.getSql(sql, dyn_and, parms, "AND");
				if( query_sql!=null && !"".equals(query_sql) ){
					sql = PopUtil.getSql(query_sql, dyn_and, parms, "AND");
				}else{
					sql = PopUtil.getSql(sql, dyn_and, parms, "AND");
				}
			}
			if( dyn_or!=null && !"".equals(dyn_or) ){
				// sql�Ѿ���dyn_and�ӹ���ֱ��ƴ��	
				sql = PopUtil.getSql(sql, dyn_or, parms, "OR");
			}
			
			// ��ѯȨ�޿���
			String loginid = User.getLoginIdByAuth(ServletActionContext.getRequest());
			if(!"".equals(loginid) && !parms.contains("proj_no")){
				if("POP031".equals(sceneId)){ // �ʽ��ϲ�ѯ��Ŀ��POP
					sql = sql + " AND PROJ_NO IN (SELECT PROJ_NO FROM proj_mang WHERE login_id='"+loginid+"') ";
				}
			}
////			if("POP056".equals(sceneId) || "POP061".equals(sceneId)){//start with
//			if("POP056".equals(sceneId)){//start with
//				sql = sql + " START WITH br_no=(select br_no from sys_user_info where user_no = '" + User.getLoginid(ServletActionContext.getRequest()) + "') connect by prior br_no=parent";
//			}
			//System.out.println("û��ûƴ��order by��POP");
			System.out.println("POP_SQL = " + sql);
		    //3�����count
			String count_sql = "SELECT count(*) from (" + sql +")";
			conn = dataSource.getConnection();
			int count = popParmConfDao.getCountPop(conn, count_sql);
			//4����÷�ҳ��ѯ��sql
			StringBuilder sb = new StringBuilder();
			sb.append("SELECT * FROM (SELECT m.*, rownum as rnum  FROM (");
			sb.append(sql);
			if( orderBy!=null && !"".equals(orderBy) ){
				sb.append(" "+orderBy);
			}
			sb.append(") m WHERE  rownum < ? ) WHERE rnum >= ? ");
			//5��map��صĸ�ֵ
			map.put("sql", sb.toString());
			map.put("query_sql", sql);//��������--������ѯ��ʱ��ƴ��ʹ��
			map.put("size", count);
			map.put("col_name", popParmConf.getCol_name());
			map.put("query_name", popParmConf.getQuery_name());
			map.put("disName", popParmConf.getQuery_disName());
			map.put("pageNo", popParmConf.getPage_no());
			map.put("rel", popParmConf.getDb_bean_rel());
			map.put("sceneId", sceneId);
			if( if_query!=null && !"".equals(if_query) ){
				map.put("if_query", if_query);
			}else{
				map.put("if_query", "null");
			}
			String hidden = popParmConf.getHidden_col();
			if( hidden!=null && !"".equals(hidden) ){
				map.put("hidden_col", hidden);
			}else{
				map.put("hidden_col", "null");
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return map;
	}
	
	public PopParmConf getById(PopParmConf popParmConf) throws ServiceException {
		try {
			popParmConf = popParmConfDao.getById(popParmConf);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return popParmConf;
	}
	
	public void insert(PopParmConf popParmConf) throws ServiceException {
		int maxId = 0;
		try {
//			maxId = popParmConfDao.getMaxId();
//			if( maxId<10 ){//�����һλ��ǰ���"00"
//				popParmConf.setScene_id("pop_00"+maxId);
//			}else if( maxId<100 && maxId>9 ){//�������λ��ǰ�ӡ�0��
//				popParmConf.setScene_id("pop_0"+maxId);
//			}else{
//				popParmConf.setScene_id("pop_"+maxId);
//			}
			popParmConfDao.insert(popParmConf);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}
	
	public Map queryAjax(String scene_id,String parms) throws ServiceException{
		Connection conn = null;
		Map map = new HashMap();
		String sql = "";
		try{
			conn = dataSource.getConnection();
			map = createSql(scene_id,parms);
			sql = (String) map.get("sql");
			map = popParmConfDao.queryAjax(conn, sql,map);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return map;
	}
	/**
	 * @description ͨ���������Լ�ҳ�洫���������̬���ɲ�ѯ��SQL���
	 * @param scene_id
	 * @param parms
	 * @return
	 * @throws ServiceException
	 * @version 1.0
	 */
	public Map createSql(String scene_id,String parms) throws ServiceException {
		Map map = new HashMap();
		String col = "";
		//�����ѯ���� {cif_no=22,cif_name=jk}
		String[] arr = new String[] {};
		//�����Զ��ŷָ� {cif_no,22}
		String[] arr_split = new String[]{};
		//���ݿ��Ӧʵ���ϵ{cif_no-cif_no,cif_name-cifname}
		String[] db_bean_arr = new String[] {};
		//��"-"�ָ�{cif_no,cif_no}
		String[] db_b_arr_split = new String[] {};
		PopParmConf popParmConf = new PopParmConf();
		popParmConf.setScene_id(scene_id);
		popParmConf = getById(popParmConf);
		String sql = popParmConf.getSql();
		//���ݿ���ʵ�����Զ�Ӧ��ϵ
		String db_bean_rel = popParmConf.getDb_bean_rel();
		db_bean_arr = db_bean_rel.split(",");
		//��̬����sql���һ����
		if( !"".equals(parms) ){//�����ѯ������cif_no=222,cif_type=1
			arr = parms.split(",");
			for( int i=0;i<arr.length;i++ ){
				arr_split = arr[i].split("=");
				for (int j = 0; j < db_bean_arr.length; j++) {
					db_b_arr_split = db_bean_arr[j].split("-");
					if( arr_split[0].contains("@") ){
						if (db_b_arr_split[1].equals(arr_split[0].split("@")[0])) {
							col += "" + db_b_arr_split[0]+" like "+"'%"+arr_split[1]+"%'" ;
							if( i==arr.length-1 ){
								col += " " ;
							}else{
								col += " and " ;
							}
								
						}
					}else{
						if (db_b_arr_split[1].equals(arr_split[0])) {
							col += "" + db_b_arr_split[0]+"="+"'"+arr_split[1]+"'" ;
							if( i==arr.length-1 ){
								col += " " ;
							}else{
								col += " and " ;
							}
								
						}
					}
				}
			}
			sql = sql + " where " + col ;
		}
		System.out.println("POP��ѯSQL:"+sql);
		map.put("sql", sql);
		map.put("rel", db_bean_rel);
		map.put("col_name", popParmConf.getCol_name());
		return map;
	}
	public void update(PopParmConf popParmConf) throws ServiceException {
		try {
			popParmConfDao.update(popParmConf);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}
	public PopParmConfDao getPopParmConfDao() {
		return popParmConfDao;
	}

	public void setPopParmConfDao(PopParmConfDao popParmConfDao) {
		this.popParmConfDao = popParmConfDao;
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

}