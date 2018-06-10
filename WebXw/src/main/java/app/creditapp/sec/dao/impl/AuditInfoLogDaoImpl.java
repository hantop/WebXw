package  app.creditapp.sec.dao.impl;

import java.util.List;
import java.util.Map;

import app.base.BaseIbatisDao;
import app.base.DAOException;
import app.creditapp.sec.dao.AuditInfoLogDao;
import app.creditapp.sec.entity.AuditInfoLog;


/**
* Title: AuditInfoLogDaoImpl.java
* Description:
**/

public class AuditInfoLogDaoImpl extends BaseIbatisDao implements AuditInfoLogDao {

	public void del(long id) throws DAOException {
		try {
			getSqlMapClientTemplate().delete("AuditInfoLog.del", id);
		} catch (Exception e) {
			log.error(e);
			throw new DAOException("ɾ��ʧ��");
		}
	}

	public List<AuditInfoLog> findByPage(Map map) throws DAOException {
		List auditInfoLogList = null;
		try {
			auditInfoLogList = getSqlMapClientTemplate().queryForList(
					"AuditInfoLog.findByPage", map);
		} catch (Exception e) {
			log.error(e);
			throw new DAOException("��ҳ��ѯʧ��");
		}
		return auditInfoLogList;
	}

	public AuditInfoLog getById(long id) throws DAOException {
		AuditInfoLog auditInfoLog = null;
		try {
			auditInfoLog = (AuditInfoLog) getSqlMapClientTemplate()
					.queryForObject("AuditInfoLog.getById", id);
		} catch (Exception e) {
			log.error(e);
			throw new DAOException("��ѯʧ��");
		}
		return auditInfoLog;
	}

	public int getCount(AuditInfoLog auditInfoLog) throws DAOException {
		int count = 0;
		try {
			count = (Integer) getSqlMapClientTemplate().queryForObject(
					"AuditInfoLog.findPage.count", auditInfoLog);
		} catch (Exception e) {
			log.error(e);
			throw new DAOException("��ѯͳ��ʧ��");
		}
		return count;
	}

	public void insert(AuditInfoLog auditInfoLog) throws DAOException {
		try {
			getSqlMapClientTemplate().insert("AuditInfoLog.insert",
					auditInfoLog);
		} catch (Exception e) {
			log.error(e);
			throw new DAOException("����ʧ��");
		}

	}

	public void update(AuditInfoLog auditInfoLog) throws DAOException {
		try {
			getSqlMapClientTemplate().update("AuditInfoLog.update",
					auditInfoLog);
		} catch (Exception e) {
			log.error(e);
			throw new DAOException("����ʧ��");
		}
	}
}
