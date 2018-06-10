package app.creditapp.dao.impl;

import app.base.BaseIbatisDao;
import app.base.DAOException;
import app.creditapp.dao.SysGlobalDAO;
import app.creditapp.entity.SysGlobal;

/**
 * ϵͳ����״̬��
 * @see 
 * �޸ļ�¼:
 */
public class SysGlobalDAOImpl extends BaseIbatisDao implements SysGlobalDAO {

	/* 
	 * @see app.creditapp.dao.SysGlobalDAO#update(app.creditapp.entity.SysGlobal)
	 */
	public void update(SysGlobal sysGlobal) throws DAOException {
		try {
			this.getSqlMapClientTemplate().update("sys_global.update", sysGlobal);
		} catch (Exception e) {
			log.error(e);
			throw new DAOException("����ʧ��");
		}
	}
	
	public void updateSts(SysGlobal sysGlobal) throws DAOException {
		try {
			this.getSqlMapClientTemplate().update("sys_global.updateSts", sysGlobal);
		} catch (Exception e) {
			log.error(e);
			throw new DAOException("����ʧ��");
		}
	}

	/* 
	 * @see app.creditapp.dao.SysGlobalDAO#getSysGlobal()
	 */
	public SysGlobal getSysGlobal() throws DAOException {
		SysGlobal sysGlobal = null;
		try{
			sysGlobal = (SysGlobal)getSqlMapClientTemplate().queryForObject("sys_global.getSysGlobal");
		} catch (Exception e) {
			log.error(e);
			throw new DAOException("��ѯʧ��");
		}
		return sysGlobal;
	}

}
