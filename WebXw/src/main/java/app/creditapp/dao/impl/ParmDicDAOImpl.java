package app.creditapp.dao.impl;

import java.util.List;
import java.util.Map;
import app.base.BaseIbatisDao;
import app.base.DAOException;
import app.creditapp.dao.ParmDicDAO;
import app.creditapp.entity.ParmDic;

public class ParmDicDAOImpl extends BaseIbatisDao implements ParmDicDAO {

	public List<ParmDic> findByPage(Map map) throws DAOException {
		List<ParmDic> parmkeylist = null;
		try {
			parmkeylist = this.getSqlMapClientTemplate().queryForList(
					"ParmDic.findByPage", map);
		} catch (Exception e) {
			log.error(e);
			throw new DAOException("��ҳ��ѯʧ��");
		}
		return parmkeylist;
	}

	public ParmDic getById(ParmDic parmdic) throws DAOException {
		ParmDic parm = null;
		try {
			parm = (ParmDic) getSqlMapClientTemplate().queryForObject(
					"ParmDic.getById", parmdic);
		} catch (Exception e) {
			log.error(e);
			throw new DAOException("��ѯʧ��");
		}
		return parm;
	}
	public String getOptName(ParmDic parmdic) throws DAOException {
		String opt_name = null;
		try {
			opt_name = (String) getSqlMapClientTemplate().queryForObject(
					"ParmDic.getOptName", parmdic);
		} catch (Exception e) {
			log.error(e);
			throw new DAOException("��ѯ��������ʧ��");
		}
		return opt_name;
	}
 
	public String getOptCode(ParmDic parmdic) throws DAOException {
		String opt_code = null;
		try {
			opt_code = (String) getSqlMapClientTemplate().queryForObject(
					"ParmDic.getOptCode", parmdic);
		} catch (Exception e) {
			log.error(e);
			throw new DAOException("��ѯ��������ʧ��");
		}
		return opt_code;
	}

	public int getCount(ParmDic parmdic) throws DAOException {

		int count = 0;
		try {
			count = (Integer) getSqlMapClientTemplate().queryForObject(
					"ParmDic.findPage.count", parmdic);
		} catch (Exception e) {
			log.error(e);
			throw new DAOException("��ѯͳ��ʧ��");
		}
		return count;
	}

	public void insert(ParmDic parmdic) throws DAOException {
		try {
			getSqlMapClientTemplate().insert("ParmDic.insert", parmdic);
		} catch (Exception e) {
			log.error(e);
			throw new DAOException("����ʧ��");
		}

	}

	public void update(ParmDic parmkey) throws DAOException {
		try {
			getSqlMapClientTemplate().insert("ParmDic.update", parmkey);
		} catch (Exception e) {
			log.error(e);
			throw new DAOException("����ʧ��");
		}
	}

	public void del(ParmDic parmdic) throws DAOException {
		// TODO Auto-generated method stub
		try {
			getSqlMapClientTemplate().delete("ParmDic.del", parmdic);
		} catch (Exception e) {
			log.error(e);
			throw new DAOException("ɾ��ʧ��");
		}

	}

	public void delte(String keyname) throws DAOException {
		// TODO Auto-generated method stub
		try {
			getSqlMapClientTemplate().delete("ParmDic.delte", keyname);
		} catch (Exception e) {
			log.error(e);
			throw new DAOException("ɾ��ʧ��");
		}
	}

	public List<ParmDic> findlist(ParmDic parmDic) throws DAOException {
		// TODO Auto-generated method stub
		List<ParmDic> list = this.getSqlMapClientTemplate().queryForList(
				"ParmDic.find", parmDic);
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<ParmDic> getBykeyname4AuthAmt(ParmDic parmdic)
			throws DAOException {
		// TODO Auto-generated method stub
		List<ParmDic> list = null;
		try {
			list = getSqlMapClientTemplate().queryForList("ParmDic.authAmySplit.find",
					parmdic);
		} catch (Exception e) {
			log.error(e);
			throw new DAOException("ɾ��ʧ��");
		}
		return list;
	}
	 public String getBusiName(String busi_type) throws DAOException{
		String opt_code = null;
		try {
			opt_code = (String) getSqlMapClientTemplate().queryForObject(
					"ParmDic.getBusiName", busi_type);
		} catch (Exception e) {
			log.error(e);
			throw new DAOException("��ѯ��������ʧ��");
		}
		return opt_code;		
	}
		 
}