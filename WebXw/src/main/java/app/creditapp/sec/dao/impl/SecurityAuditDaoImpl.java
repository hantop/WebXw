package  app.creditapp.sec.dao.impl;

import java.util.List;
import java.util.Map;

import app.base.BaseIbatisDao;
import app.base.DAOException;
import app.creditapp.sec.dao.SecurityAuditDao;
import app.creditapp.sec.entity.SecurityAudit;


/**
* Title: SecurityAuditDaoImpl.java
* Description:
**/

public class SecurityAuditDaoImpl extends BaseIbatisDao implements SecurityAuditDao {

	public void del(String id) throws DAOException {
		try {
			getSqlMapClientTemplate().delete("SecurityAudit.del", id);
		} catch (Exception e) {
			log.error(e);
			throw new DAOException("ɾ��ʧ��");
		}
	}

	public List<SecurityAudit> findByPage(Map map) throws DAOException {
		List secAuditList = null;
		try {
			secAuditList = getSqlMapClientTemplate().queryForList(
					"SecurityAudit.findByPage", map);
		} catch (Exception e) {
			log.error(e);
			throw new DAOException("��ҳ��ѯʧ��");
		}
		return secAuditList;
	}

	public SecurityAudit getById(String id) throws DAOException {
		SecurityAudit secAudit = null;
		try {
			secAudit = (SecurityAudit) getSqlMapClientTemplate()
					.queryForObject("SecurityAudit.getById", id);
		} catch (Exception e) {
			log.error(e);
			throw new DAOException("��ѯʧ��");
		}
		return secAudit;
	}

	public int getCount(SecurityAudit secAudit) throws DAOException {
		int count = 0;
		try {
			count = (Integer) getSqlMapClientTemplate().queryForObject(
					"SecurityAudit.findPage.count", secAudit);
		} catch (Exception e) {
			log.error(e);
			throw new DAOException("��ѯͳ��ʧ��");
		}
		return count;
	}

	public void insert(SecurityAudit secAudit) throws DAOException {
		try {
			getSqlMapClientTemplate().insert("SecurityAudit.insert",
					secAudit);
		} catch (Exception e) {
			log.error(e);
			throw new DAOException("����ʧ��");
		}

	}

	public void update(SecurityAudit secAudit) throws DAOException {
		try {
			getSqlMapClientTemplate().update("SecurityAudit.update",
					secAudit);
		} catch (Exception e) {
			log.error(e);
			throw new DAOException("����ʧ��");
		}
	}
	
	public void updateIsUse(SecurityAudit secAudit) throws DAOException {
		try {
			getSqlMapClientTemplate().update("SecurityAudit.updateIsUse",
					secAudit);
		} catch (Exception e) {
			log.error(e);
			throw new DAOException("����ʧ��");
		}
	}
	/**Xl ��ȫ�������У�����
	 * @return List
	 */
	public List<SecurityAudit> getListForSec(SecurityAudit secAudit) throws DAOException {
		List secAuditList = null;
		try {
			secAuditList = getSqlMapClientTemplate().queryForList("SecurityAudit.getListForSec", secAudit);
		} catch (Exception e) {
			log.error(e);
			throw new DAOException("��ѯʧ��");
		}
		return secAuditList;
	}
	
	public List<SecurityAudit> findAuditListByCode(SecurityAudit secAudit) throws DAOException {
		List secAuditList = null;
		try {
			secAuditList = getSqlMapClientTemplate().queryForList("SecurityAudit.findAuditListByCode", secAudit);
		} catch (Exception e) {
			log.error(e);
			throw new DAOException("��ѯʧ��");
		}
		return secAuditList;
	}
}
