package  app.creditapp.proj.dao.impl;

import java.util.List;

import app.base.BaseIbatisDao;
import app.base.DAOException;
import app.creditapp.proj.dao.ProjBaseDao;
import app.creditapp.proj.entity.ProjBase;
/**
* Title: ProjBaseDaoImpl.java
* Description:
**/
public class ProjBaseDaoImpl extends BaseIbatisDao implements ProjBaseDao {

	public void del(ProjBase projBase) throws DAOException {
		try {
			getSqlMapClientTemplate().delete("ProjBase.del", projBase);
		} catch (Exception e) {
			log.error(e);
			throw new DAOException(e.getMessage());
		}
	}

	public List<ProjBase> findByPage(ProjBase projBase) throws DAOException {
		List projBaseList = null;
		try {
			projBaseList = getSqlMapClientTemplate().queryForList(
					"ProjBase.findByPage", projBase);
		} catch (Exception e) {
			log.error(e);
			throw new DAOException(e.getMessage());
		}
		return projBaseList;
	}
	public List<ProjBase> findByPageForUser(ProjBase projBase) throws DAOException {
		List projBaseList = null;
		try {
			projBaseList = getSqlMapClientTemplate().queryForList(
					"ProjBase.findByPageForUser", projBase);
		} catch (Exception e) {
			log.error(e);
			throw new DAOException(e.getMessage());
		}
		return projBaseList;
	}
	public List<ProjBase> findByMyPage(ProjBase projBase) throws DAOException {
		List projBaseList = null;
		try {
			projBaseList = getSqlMapClientTemplate().queryForList(
					"ProjBase.findByPage", projBase);
		} catch (Exception e) {
			log.error(e);
			throw new DAOException(e.getMessage());
		}
		return projBaseList;
	}
	
	public ProjBase getByIdForBrNo(ProjBase projBase) throws DAOException {
		try {
			projBase = (ProjBase) getSqlMapClientTemplate()
					.queryForObject("ProjBase.getByIdForBrNo", projBase);
		} catch (Exception e) {
			log.error(e);
			throw new DAOException(e.getMessage());
		}
		return projBase;
	}
	
	public ProjBase getById(ProjBase projBase) throws DAOException {
		try {
			projBase = (ProjBase) getSqlMapClientTemplate()
					.queryForObject("ProjBase.getById", projBase);
		} catch (Exception e) {
			log.error(e);
			throw new DAOException(e.getMessage());
		}
		return projBase;
	}
	public ProjBase getByIdForProjNo(ProjBase projBase) throws DAOException {
		try {
			projBase = (ProjBase) getSqlMapClientTemplate()
					.queryForObject("ProjBase.getByIdForProjNo", projBase);
		} catch (Exception e) {
			log.error(e);
			throw new DAOException(e.getMessage());
		}
		return projBase;
	}
	public ProjBase getByIdForFlag(ProjBase projBase) throws DAOException {
		try {
			projBase = (ProjBase) getSqlMapClientTemplate()
					.queryForObject("ProjBase.getByIdForFlag", projBase);
		} catch (Exception e) {
			log.error(e);
			throw new DAOException(e.getMessage());
		}
		return projBase;
	}

	public int getCount(ProjBase projBase) throws DAOException {
		int count = 0;
		try {
			count = (Integer) getSqlMapClientTemplate().queryForObject(
					"ProjBase.findPage.count", projBase);
		} catch (Exception e) {
			log.error(e);
			throw new DAOException(e.getMessage());
		}
		return count;
	}
	public int getCountForUser(ProjBase projBase) throws DAOException {
		int count = 0;
		try {
			count = (Integer) getSqlMapClientTemplate().queryForObject(
					"ProjBase.findPageForUser.count", projBase);
		} catch (Exception e) {
			log.error(e);
			throw new DAOException(e.getMessage());
		}
		return count;
	}

	public void insert(ProjBase projBase) throws DAOException {
		try {
			getSqlMapClientTemplate().insert("ProjBase.insert",
					projBase);
		} catch (Exception e) {
			log.error(e);
			throw new DAOException(e.getMessage());
		}

	}
	public void merge(ProjBase projBase) throws DAOException {
		try {
			getSqlMapClientTemplate().update("ProjBase.merge", projBase);
		} catch (Exception e) {
			log.error(e);
			throw new DAOException(e.getMessage());
		}

	}
	
	public void update(ProjBase projBase) throws DAOException {
		try {
			getSqlMapClientTemplate().update("ProjBase.update",
					projBase);
		} catch (Exception e) {
			log.error(e);
			throw new DAOException(e.getMessage());
		}
	}
	public void update_Read(ProjBase projBase) throws DAOException {
		try {
			getSqlMapClientTemplate().update("ProjBase.update_Read",
					projBase);
		} catch (Exception e) {
			log.error(e);
			throw new DAOException(e.getMessage());
		}
	}
	//������Ŀ״̬
	public void updateSts(ProjBase projBase) throws DAOException {
		try {
			getSqlMapClientTemplate().update("ProjBase.updateSts",
					projBase);
		} catch (Exception e) {
			log.error(e);
			throw new DAOException(e.getMessage());
		}
	}
	//������������360��ͼ��Ŀ��Ϣչʾ
	public List<ProjBase> getByIdforCorp(ProjBase projBase) throws DAOException {
		List projBaseList = null;
		try {
			projBaseList =  getSqlMapClientTemplate()
					.queryForList("ProjBase.getByIdforCorp", projBase);
		} catch (Exception e) {
			log.error(e);
			throw new DAOException(e.getMessage());
		}
		return projBaseList;
	}
	//��ȡ��������brno�����������з�ҳ����
	public int getCountforCorp(ProjBase projBase) throws DAOException {
		int count = 0;
		try {
			count = (Integer) getSqlMapClientTemplate().queryForObject(
					"ProjBase.findPageforCorp.count", projBase);
		} catch (Exception e) {
			log.error(e);
			throw new DAOException(e.getMessage());
		}
		return count;
	}
	//echarts
	public List<ProjBase> myProj_echarts(ProjBase projBase) throws DAOException {
		List projBaseList = null;
		try {
			projBaseList = getSqlMapClientTemplate().queryForList("ProjBase.myProj_echarts", projBase);
		} catch (Exception e) {
			log.error(e);
			throw new DAOException(e.getMessage());
		}
		return projBaseList;
	}
	public List<ProjBase> myProj_day_echarts(ProjBase projBase) throws DAOException {
		List projBaseList = null;
		try {
			projBaseList = getSqlMapClientTemplate().queryForList("ProjBase.myProj_day_echarts", projBase);
		} catch (Exception e) {
			log.error(e);
			throw new DAOException(e.getMessage());
		}
		return projBaseList;
	}	
	public List<ProjBase> myProj_fdtype_day_echarts(ProjBase projBase) throws DAOException {
		List projBaseList = null;
		try {
			projBaseList = getSqlMapClientTemplate().queryForList("ProjBase.myProj_fdtype_day_echarts", projBase);
		} catch (Exception e) {
			log.error(e);
			throw new DAOException(e.getMessage());
		}
		return projBaseList;
	}
	//ͬ��ʱ ���� ר����Ϣ�� ��ȡ �û����µ�������Ŀ
	public List<ProjBase> findpageFormer(ProjBase projBase) throws DAOException {
		List projBaseList = null;
		try {
			projBaseList = getSqlMapClientTemplate().queryForList("ProjBase.findByPageFormer", projBase);
		} catch (Exception e) {
			log.error(e);
			throw new DAOException(e.getMessage());
		}
		return projBaseList;
	}	
	

}