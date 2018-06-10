package  app.creditapp.sec.dao.impl;

import java.util.List;
import java.util.Map;

import app.base.BaseIbatisDao;
import app.base.DAOException;
import app.creditapp.sec.dao.UserMarkInfoDao;
import app.creditapp.sec.entity.UserMarkInfo;


/**
* Title: UserMarkInfoDaoImpl.java
* Description:
**/

public class UserMarkInfoDaoImpl extends BaseIbatisDao implements UserMarkInfoDao {

	public void del(String id) throws DAOException {
		try {
			getSqlMapClientTemplate().delete("UserMarkInfo.del", id);
		} catch (Exception e) {
			log.error(e);
			throw new DAOException("ɾ��ʧ��");
		}
	}

	public List<UserMarkInfo> findByPage(Map map) throws DAOException {
		List userMarkInfoList = null;
		try {
			userMarkInfoList = getSqlMapClientTemplate().queryForList(
					"UserMarkInfo.findByPage", map);
		} catch (Exception e) {
			log.error(e);
			throw new DAOException("��ҳ��ѯʧ��");
		}
		return userMarkInfoList;
	}

	public UserMarkInfo getById(String id) throws DAOException {
		UserMarkInfo userMarkInfo = null;
		try {
			userMarkInfo = (UserMarkInfo) getSqlMapClientTemplate()
					.queryForObject("UserMarkInfo.getById", id);
		} catch (Exception e) {
			log.error(e);
			throw new DAOException("��ѯʧ��");
		}
		return userMarkInfo;
	}

	public int getCount(UserMarkInfo userMarkInfo) throws DAOException {
		int count = 0;
		try {
			count = (Integer) getSqlMapClientTemplate().queryForObject(
					"UserMarkInfo.findPage.count", userMarkInfo);
		} catch (Exception e) {
			log.error(e);
			throw new DAOException("��ѯͳ��ʧ��");
		}
		return count;
	}

	public void insert(UserMarkInfo userMarkInfo) throws DAOException {
		try {
			getSqlMapClientTemplate().insert("UserMarkInfo.insert",
					userMarkInfo);
		} catch (Exception e) {
			log.error(e);
			throw new DAOException("����ʧ��");
		}

	}

	public void update(UserMarkInfo userMarkInfo) throws DAOException {
		try {
			getSqlMapClientTemplate().update("UserMarkInfo.update",
					userMarkInfo);
		} catch (Exception e) {
			log.error(e);
			throw new DAOException("����ʧ��");
		}
	}
	public UserMarkInfo getAllLogin(String login) throws DAOException {
		UserMarkInfo userMarkInfo =null;
		try {
			userMarkInfo = (UserMarkInfo) getSqlMapClientTemplate()
			.queryForObject("UserMarkInfo.getAllLogin", login);
		} catch (Exception e) {
			log.error(e);
			throw new DAOException("��ѯʧ��");
		}
		return userMarkInfo;
	}

	@Override
	public void updateSts(UserMarkInfo userMarkInfo) throws DAOException {
		try {
			getSqlMapClientTemplate().update("UserMarkInfo.updateSta",
					userMarkInfo);
		} catch (Exception e) {
			log.error(e);
			throw new DAOException("����ʧ��");
		}
		
	}
}
