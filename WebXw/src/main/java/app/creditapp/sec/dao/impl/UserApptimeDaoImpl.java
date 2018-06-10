package app.creditapp.sec.dao.impl;

import java.util.List;
import java.util.Map;

import app.base.BaseIbatisDao;
import app.base.DAOException;
import app.creditapp.sec.dao.UserApptimeDao;
import app.creditapp.sec.entity.UserApptime;


/**
* Title: UserApptimeDaoImpl.java
* Description:
**/

public class UserApptimeDaoImpl extends BaseIbatisDao implements UserApptimeDao {

	public void del(long id) throws DAOException {
		try {
			getSqlMapClientTemplate().delete("UserApptime.del", id);
		} catch (Exception e) {
			log.error(e);
			throw new DAOException("ɾ��ʧ��");
		}
	}

	public List<UserApptime> findByPage(Map map) throws DAOException {
		List userApptimeList = null;
		try {
			userApptimeList = getSqlMapClientTemplate().queryForList(
					"UserApptime.findByPage", map);
		} catch (Exception e) {
			log.error(e);
			throw new DAOException("��ҳ��ѯʧ��");
		}
		return userApptimeList;
	}

	public UserApptime getById(long id) throws DAOException {
		UserApptime userApptime = null;
		try {
			userApptime = (UserApptime) getSqlMapClientTemplate()
					.queryForObject("UserApptime.getById", id);
		} catch (Exception e) {
			log.error(e);
			throw new DAOException("��ѯʧ��");
		}
		return userApptime;
	}

	public int getCount(UserApptime userApptime) throws DAOException {
		int count = 0;
		try {
			count = (Integer) getSqlMapClientTemplate().queryForObject(
					"UserApptime.findPage.count", userApptime);
		} catch (Exception e) {
			log.error(e);
			throw new DAOException("��ѯͳ��ʧ��");
		}
		return count;
	}
	public int getAllCount(UserApptime userApptime) throws DAOException {
		int count = 0;
		try {
			count = (Integer) getSqlMapClientTemplate().queryForObject(
					"UserApptime.allFindPage.count", userApptime);
		} catch (Exception e) {
			log.error(e);
			throw new DAOException("��ѯͳ��ʧ��");
		}
		return count;
	}
	public void insert(UserApptime userApptime) throws DAOException {
		try {
			getSqlMapClientTemplate().insert("UserApptime.insert",
					userApptime);
		} catch (Exception e) {
			log.error(e);
			throw new DAOException("����ʧ��");
		}

	}

	public void update(UserApptime userApptime) throws DAOException {
		try {
			getSqlMapClientTemplate().update("UserApptime.update",
					userApptime);
		} catch (Exception e) {
			log.error(e);
			throw new DAOException("����ʧ��");
		}
	}
	
	public List<UserApptime> allFindByPage(Map map) throws DAOException {
		List userApptimeList = null;
		try {
			userApptimeList = getSqlMapClientTemplate().queryForList(
					"UserApptime.allFindByPage", map);
		} catch (Exception e) {
			log.error(e);
			throw new DAOException("��ҳ��ѯʧ��");
		}
		return userApptimeList;
	}
}
