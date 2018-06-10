/**
 * 
 */
package app.creditapp.dao;

import app.base.DAOException;
import app.creditapp.entity.SysGlobal;

/**
 * ϵͳ״̬������
 * @see 
 * �޸ļ�¼:
 */
public interface SysGlobalDAO {
	/**
	 * ����
	 * @param sysGlobal
	 * @throws DAOException
	 */
	public void update(SysGlobal sysGlobal) throws DAOException;
	
	public void updateSts(SysGlobal sysGlobal) throws DAOException;
	/**
	 * ��ȡ
	 * @return
	 * @throws DAOException
	 */
	public SysGlobal getSysGlobal() throws DAOException;

}
