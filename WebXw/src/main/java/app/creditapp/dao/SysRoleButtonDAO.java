package app.creditapp.dao;

import java.util.List;
import java.util.Map;

import app.base.DAOException;
import app.creditapp.entity.SysRoleButton;

/**
 * ����������Ȩ�޶�Ӧ��ť DAO interface
 *
 */
public interface SysRoleButtonDAO {
	
	public List<SysRoleButton> getById(Map<String,String> map) throws DAOException;
	public List<SysRoleButton> getAll() throws DAOException;
	/**
	 * ͨ����ť��ż��˵����ɾ�� Ȩ�޼�¼
	 * @param menuNo �˵����
	 * @param buttonNo ��ť���
	 * @throws DAOException
	 */
	public void deleteByMenuButtonNo(String menuNo, String buttonNo) throws DAOException;
}
