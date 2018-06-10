package  app.creditapp.sys.dao.impl;
import java.util.List;
import java.util.Map;

import app.base.BaseIbatisDao;
import app.base.DAOException;
import app.creditapp.sys.dao.SysLoginLogDao;
import app.creditapp.sys.entity.SysLoginLog;
/**
* Title: SysLoginLogDaoImpl.java
* Description:
**/

public class SysLoginLogDaoImpl extends BaseIbatisDao implements SysLoginLogDao {
	/*
	 * (non-Javadoc)
	 * @see app.creditapp.dao.SysLoginLogDAO#del(java.lang.String)
	 */
public void del(String id) throws DAOException {
    try {
      getSqlMapClientTemplate().delete("SysLoginLog.del", id);
    }catch (Exception e) {
      log.error(e);
      throw new DAOException("ɾ��ʧ��");
    }
  }
/*
 * (non-Javadoc)
 * @see app.creditapp.dao.SysLoginLogDAO#findByPage(java.util.Map)
 */
  public List<SysLoginLog> findByPage(Map map) throws DAOException {
    List sysloginloglist = null;
    try {
      sysloginloglist =  getSqlMapClientTemplate().queryForList("SysLoginLog.findByPage",map);
    } catch (Exception e) {
      log.error(e);
      throw new DAOException("��ҳ��ѯʧ��");
    }
    return sysloginloglist;
  }
  /*
   * (non-Javadoc)
   * @see app.creditapp.dao.SysLoginLogDAO#getById(java.lang.String)
   */
  public SysLoginLog getById(String id) throws DAOException {
    SysLoginLog sysloginlog = null;
    try {
      sysloginlog = (SysLoginLog)getSqlMapClientTemplate().queryForObject("SysLoginLog.getById", id);
    }catch (Exception e) {
      log.error(e);
      throw new DAOException("��ѯʧ��");
    }
    return sysloginlog;
  }
  /*
   * (non-Javadoc)
   * @see app.creditapp.dao.SysLoginLogDAO#getCount(app.creditapp.entity.SysLoginLog)
   */
  public int getCount(SysLoginLog sysloginlog) throws DAOException {
    
    int count = 0;
    try {
      count = (Integer)getSqlMapClientTemplate().queryForObject("SysLoginLog.findPage.count",sysloginlog);
    } catch (Exception e) {
      log.error(e);
      throw new DAOException("��ѯͳ��ʧ��");
    }
    return count;
  }
  /*
   * @overload ���ڵ�½��ʱ���ѯ�Ƿ��и�SessionID����ʷ��¼����
   * (non-Javadoc)
   * @see app.creditapp.dao.SysLoginLogDAO#getCount(java.lang.String)
   */
  public int getCount(String sessionid) throws DAOException {
	    
	    int count = 0;
	    try {
	    	SysLoginLog sysloginlog = new SysLoginLog();
	    	sysloginlog.setSessionId(sessionid);
	      count = (Integer)getSqlMapClientTemplate().queryForObject("SysLoginLog.findPage.count",sysloginlog);
	    } catch (Exception e) {
	      log.error(e);
	      throw new DAOException("��ѯͳ��ʧ��");
	    }
	    return count;
	  }
  /*
   * (non-Javadoc)
   * @see app.creditapp.dao.SysLoginLogDAO#insert(app.creditapp.entity.SysLoginLog)
   */
  public void insert(SysLoginLog sysloginlog) throws DAOException {
    try {
      getSqlMapClientTemplate().insert("SysLoginLog.insert", sysloginlog);
    }catch (Exception e) {
      log.error(e);
      throw new DAOException("����ʧ��");
    }
    
  }
  /*
   * (non-Javadoc)
   * @see app.creditapp.dao.SysLoginLogDAO#update(app.creditapp.entity.SysLoginLog)
   */
  public void update(SysLoginLog sysloginlog) throws DAOException {
    try {
      getSqlMapClientTemplate().update("SysLoginLog.update", sysloginlog);
    } catch (Exception e) {
      log.error(e);
      throw new DAOException("����ʧ��");
    }    
  }
  }
