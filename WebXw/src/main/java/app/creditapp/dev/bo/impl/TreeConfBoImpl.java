package app.creditapp.dev.bo.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import app.base.BaseService;
import app.base.ServiceException;
import app.creditapp.dev.bo.TreeConfBo;
import app.creditapp.dev.dao.TreeConfDao;
import app.creditapp.dev.entity.TreeConf;
import app.util.DBUtils;
import app.util.toolkit.Ipage;

/**
 * Title: TreeConfBoImplImpl.java Description:
 * 
 **/
public class TreeConfBoImpl extends BaseService implements TreeConfBo {

    private TreeConfDao treeConfDao;

    public void del(TreeConf treeConf) throws ServiceException {
	try {
	    treeConfDao.del(treeConf);
	} catch (Exception e) {
	    throw new ServiceException(e.getMessage());
	}
    }

    public Ipage findByPage(Ipage ipg, TreeConf treeConf)
	    throws ServiceException {
	try {
	    ipg.initPageCounts(new Integer[] { (Integer) treeConfDao
		    .getCount(treeConf) });// ��ʼ����ҳ��
	    treeConf.setStartNumAndEndNum(ipg);
	    ipg.setResult(treeConfDao.findByPage(treeConf));
	} catch (Exception e) {
	    throw new ServiceException(e.getMessage());
	}
	return ipg;
    }

    public Map createSql(String scene_id, Map<String,Object> params) throws ServiceException {
	TreeConf treeConf = new TreeConf();
	treeConf.setScene_id(scene_id);
	treeConf = getById(treeConf);
	String sql = treeConf.getSql();
	
	// SQL�����滻
	Pattern pattern = Pattern.compile("\\$[\\w\\d]+\\$");
	Matcher matcher = pattern.matcher(sql);
	System.out.println("SQL���: " + treeConf.getScene_desc());
	System.out.println("SQL����: " + treeConf.getScene_desc());
	log("SQL����: " + treeConf.getScene_desc());
	while (matcher.find()) {
	    String str = matcher.group();
	    System.out.println(str);
	    String parm = str.substring(1, str.length() - 1).toLowerCase();
	    String value="";
	    if(params.get(parm) instanceof Double || params.get(parm) instanceof Integer) {
		value = params.get(parm).toString();
	    } else {
		value = (String) params.get(parm);
	    }
	    sql = sql.replace(str, value);
	}
	System.out.println("sql: " + sql);
	log("sql: " + sql);
	
	Map map = new HashMap();	
	// SQL��ѯ�ֶκ�ʵ���ϵ
	String db_bean_rel = treeConf.getParams();
	map.put("sql", sql);
	map.put("rel", db_bean_rel);
	map.put("tri_lev", treeConf.getTri_lev());
	map.put("tri_func", treeConf.getTri_func());
	map.put("select_type", treeConf.getSelect_type());
	return map;
    }
    public Map createSqlPot(String scene_id, Map<String,Object> params) throws ServiceException {
    	TreeConf treeConf = new TreeConf();
    	treeConf.setScene_id(scene_id);
    	treeConf = getById(treeConf);
    	String sql = treeConf.getSql();
    	
    	// SQL�����滻
    	Pattern pattern = Pattern.compile("\\$[\\w\\d]+.+\\$");
    	Matcher matcher = pattern.matcher(sql);
    	System.out.println("SQL���: " + treeConf.getScene_desc());
    	System.out.println("SQL����: " + treeConf.getScene_desc());
    	log("SQL����: " + treeConf.getScene_desc());
    	while (matcher.find()) {
    	    String str = matcher.group();
    	    System.out.println(str);
    	    String parm = str.substring(1, str.length() - 1).toLowerCase();
    	    String value="";
    	    if(params.get(parm) instanceof Double || params.get(parm) instanceof Integer) {
    		value = params.get(parm).toString();
    	    } else {
    		value = (String) params.get(parm);
    	    }
    	    sql = sql.replace(str, value);
    	}
    	System.out.println("sql: " + sql);
    	log("sql: " + sql);
    	
    	Map map = new HashMap();	
    	// SQL��ѯ�ֶκ�ʵ���ϵ
    	String db_bean_rel = treeConf.getParams();
    	map.put("sql", sql);
    	map.put("rel", db_bean_rel);
    	map.put("tri_lev", treeConf.getTri_lev());
    	map.put("tri_func", treeConf.getTri_func());
    	map.put("select_type", treeConf.getSelect_type());
    	return map;
    }

    public String getTreeJson(String sql) throws ServiceException {
	StringBuilder json = new StringBuilder("");
	json.append("[");

	java.sql.Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	try {
	    conn = DBUtils.getConn();
	    ps = conn.prepareStatement(sql);
	    rs = ps.executeQuery();
	    
	    // sql��ѯ����� ˳��Ϊ ��š�����š�����
	    while (rs.next()) {
	    	
		json.append("{");
		json.append("'id':'" + rs.getString(1) + "',");
		json.append("'pId':'" + rs.getString(2) + "',");
		json.append("'text':'" + rs.getString(3) + "',");
		for(int i=1;i<=rs.getMetaData().getColumnCount();i++){
			if(rs.getMetaData().getColumnName(i).equalsIgnoreCase("cif_type")){
				json.append("'cif_type':'" + (rs.getString("cif_type")==null?"":rs.getString("cif_type")) + "',");
				break;
			}
		}
		json.append("'name':'" + rs.getString(3) + "'");
		json.append("}");
		json.append(",");
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	} finally {
	    DBUtils.closeResultset(rs);
	    DBUtils.closeStatement(ps);
	    DBUtils.closeConnection(conn);
	}
	json.substring(0, json.length() - 1);
	json.append("]");
	return json.toString();
    }

    public TreeConf getById(TreeConf treeConf) throws ServiceException {
	try {
	    treeConf = treeConfDao.getById(treeConf);
	} catch (Exception e) {
	    throw new ServiceException(e.getMessage());
	}
	return treeConf;
    }

    public void insert(TreeConf treeConf) throws ServiceException {
	try {
	    treeConfDao.insert(treeConf);
	} catch (Exception e) {
	    throw new ServiceException(e.getMessage());
	}
    }

    public void update(TreeConf treeConf) throws ServiceException {
	try {
	    treeConfDao.update(treeConf);
	} catch (Exception e) {
	    throw new ServiceException(e.getMessage());
	}
    }

    public TreeConfDao getTreeConfDao() {
	return treeConfDao;
    }

    public void setTreeConfDao(TreeConfDao treeConfDao) {
	this.treeConfDao = treeConfDao;
    }
}