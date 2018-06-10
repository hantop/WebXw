package app.creditapp.sysConfig.proxy;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.orm.ibatis.SqlMapClientTemplate;

import app.creditapp.sysConfig.bo.SysUpdateRecordBo;
import app.creditapp.sysConfig.entity.SysUpdateRecord;
import app.creditapp.sysConfig.java.SerachTable;
import app.oscache.MBaseCache;
import app.util.User;

import com.ibatis.sqlmap.engine.impl.SqlMapClientImpl;
import com.ibatis.sqlmap.engine.impl.SqlMapExecutorDelegate;
import com.ibatis.sqlmap.engine.mapping.result.ResultMap;
import com.ibatis.sqlmap.engine.mapping.result.ResultMapping;
import com.ibatis.sqlmap.engine.mapping.sql.Sql;
import com.ibatis.sqlmap.engine.mapping.statement.MappedStatement;
import com.ibatis.sqlmap.engine.scope.SessionScope;
import com.ibatis.sqlmap.engine.scope.StatementScope;

/**
 * @description 	���ֶ��޸ļ�¼��־
 * @version 1.0
 */
public class UpdateTableHandler {

	private SysUpdateRecordBo sysUpdateRecordBo;
	
	/**
	 * @description ��¼���޸���־��Ҫ��¼�ı�������Sys_Require_Table
	 * 				�������طŻ���
	 * @param point
	 * @return
	 * @throws Throwable
	 * @version 1.0
	 */
	public Object runOnAround(ProceedingJoinPoint point) throws Throwable {
		Object object = null;
		Connection conn = null;
		try {
			SqlMapClientTemplate sqlMapClientTemplate = (SqlMapClientTemplate)point.getTarget();
			//�������Դ��ȡ���ݿ�����
			conn = sqlMapClientTemplate.getDataSource().getConnection();
			//���SqlMapClient
			SqlMapClientImpl sqlMapClientImpl = (SqlMapClientImpl)sqlMapClientTemplate.getSqlMapClient();
			SqlMapExecutorDelegate delegate = sqlMapClientImpl.delegate;
			SessionScope sessionScope = new SessionScope();
			StatementScope statementScope = new StatementScope(sessionScope);
			//��ò�������
			Object args[] = point.getArgs();
			MappedStatement statement = delegate.getMappedStatement(args[0].toString());
			//���sql
			Sql sql = statement.getSql();
			String sqlStr = sql.getSql(statementScope, args[1]).toUpperCase();
			String[] arr = sqlStr.split("SET");
			//ȡ����-->�ж�
			String tablename = arr[0].split("UPDATE")[1].trim(); 
			boolean tableifexist = MBaseCache.getCache().getBeanCacheForLogTable(tablename);
			if(!tableifexist){
				return null;
			}
			ResultMap s = delegate.getResultMap("RM."+args[0].toString().split("\\.")[0]);
			ResultMapping[] rm_arr = s.getResultMappings();
			//���ʵ�������������ݿ��ֶζ�Ӧ��ϵ--->�ֶ�ֵ��Ҫ�޸ĵ�ֵ
			Map<String,Object> map_col = new HashMap<String,Object>(); 
			int t = rm_arr.length;
			Class clz = args[1].getClass();
			Object value = null;
			for( int i=0;i<t;i++ ){
				Method method = clz.getMethod("get"+getMethodName(rm_arr[i].getPropertyName()));
				value = method.invoke(args[1]);
				System.out.println("rm_arr[i].getColumnName():"+rm_arr[i].getColumnName());
				map_col.put(rm_arr[i].getColumnName(), value);
			}
			String up_col = getUpdateSqlColumn(arr[1]);
			String select_sql = getSql4QueryOld(sqlStr,map_col,tablename,up_col);
			//�ֶ�ֵ�����ݿ����ֶ�ֵ
			Map<String,String> old_map = executeQuery(select_sql, conn);
			//�Ƚ���������������
			String modify_d = "";
			String n_new = "";
			String o_old = "";
			Map<String,String> map_col_name = SerachTable.getColName(tablename, conn);
			for( String new_ : map_col.keySet() ){
				for( String old_ : old_map.keySet() ){
					if( new_.equals(old_) ){
						if( !map_col.get(new_).equals(old_map.get(old_)) ){
							if( map_col.get(new_)==null || map_col.get(new_).equals("") ){
								n_new = "��";
							}else{
								n_new = String.valueOf(map_col.get(new_));
							}
							if(old_map.get(old_)==null || old_map.get(old_).equals("") ){
								o_old = "��";
							}else{
								o_old = old_map.get(old_);
							}
							modify_d += ","+new_+ "@"+map_col_name.get(new_)+"#"+n_new+"@"+o_old;
						}
					}
				}
			}
			modify_d = modify_d.replaceFirst(",", "");
			//�����¼��
			String table_comment = SerachTable.getTblName(tablename, conn);
			SysUpdateRecord tableUpdateRecord = new SysUpdateRecord();
			tableUpdateRecord.setModifyRecord(modify_d);
			tableUpdateRecord.setModifyTime(User.getTime());
			tableUpdateRecord.setModifyUserNo(User.getLoginid(ServletActionContext.getRequest()));
			tableUpdateRecord.setTableName(tablename);
			tableUpdateRecord.setTableComment(table_comment);
			object = point.proceed();
			sysUpdateRecordBo.insert(tableUpdateRecord);
			
		} catch (Exception e) {
			object = point.proceed();
			e.printStackTrace();
		} finally {
			if (conn != null && !conn.isClosed()) {
				conn.close();
			}
		}

		return object;
	}
	/**
	 * @description ���Ҫ���µ��ֶ�
	 * @param sql_part
	 * @return
	 * @version 1.0
	 */
	public String getUpdateSqlColumn(String sql_part){
		String update_ = sql_part.split("WHERE")[0].trim();
		String up_col = "";
		String [] up_col_arr = null;
		if( update_.indexOf(",") > -1 ){
			up_col_arr = update_.split(",");
			for( int i=0;i<up_col_arr.length;i++ ){
				up_col += ","+up_col_arr[i].split("=")[0];
			}
			up_col = up_col.replaceFirst(",", "");
		}else{
			up_col = update_.split("=")[0];//���µ��ֶ�
		}
		return up_col;
	}
	
	/**
	 * @description ͨ��ԭ����sql����ѯ������
	 * @param sqlstr
	 * @param col
	 * @version 1.0
	 */
	public String getSql4QueryOld(String sqlStr,Map<String,Object> map_col,String tablename,String up_col){
		String sql = "";
		String condtion =  sqlStr.split("WHERE")[1].trim();
		String cond_col = "";
		String [] cond_col_arr = null;
		String temp = "";
		if( cond_col.indexOf("AND") > -1 ){
			cond_col_arr = cond_col.split("AND");
			for( int i=0;i<cond_col_arr.length;i++ ){
				temp = cond_col_arr[i].split("=")[0].trim();
				cond_col += " AND " + temp+ "='" +map_col.get(temp)+"'";
			}
			cond_col = cond_col.replaceFirst("AND", "");
		}else{
			temp = condtion.split("=")[0].trim();
			cond_col =  temp +"='"+map_col.get(temp)+"'";
		}
		sql = "SELECT "+ up_col +" FROM " + tablename + " WHERE " +cond_col;
		return sql;
	}
	
	/**
	 * @description ��ѯsql--->��Ҫ���ڲ�ѯ�ñ��ֶ�ԭ����ֵ
	 * @param sql
	 * @param conn
	 * @return
	 * @version 1.0
	 */
	public Map<String,String> executeQuery(String sql , Connection conn) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		ResultSetMetaData rsmd=null;
		Map<String,String> map = null;
		try{
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			rsmd = rs.getMetaData();
			String columName;
			while( rs.next() ){
				map = new HashMap<String,String>();
				for(int i=0;i<rsmd.getColumnCount();i++){
					columName = rsmd.getColumnLabel(i+1);
					String value = format(rs.getString(columName));
					map.put(columName,value);
				}
			}
		}catch(Exception e){
			
		}finally{
			try {
				rs.close();
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return map;
	}
	/**
	 * @description ����ĸ��д
	 * @param fildeName
	 * @return
	 * @version 1.0
	 */
	private static String getMethodName(String fildeName) {  
		byte[] items = fildeName.getBytes();  
		items[0] = (byte) ((char) items[0] - 'a' + 'A');  
		return new String(items);  
	} 
	/**
	 * @description ��ʽ��
	 * @param object
	 * @return
	 * @version 1.0
	 */
	public static String format(Object object){
		String result = "";
		String val = String.valueOf(object);
		if(val==null||"0".equals(val)||"0.0".equals(val)||"null".equals(val)){
			result = "";
		}else{
			result = val;
		}
		return result;
	}
	
	public SysUpdateRecordBo getSysUpdateRecordBo() {
		return sysUpdateRecordBo;
	}

	public void setSysUpdateRecordBo(SysUpdateRecordBo sysUpdateRecordBo) {
		this.sysUpdateRecordBo = sysUpdateRecordBo;
	}


}
