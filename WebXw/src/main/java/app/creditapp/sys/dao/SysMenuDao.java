package  app.creditapp.sys.dao;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import app.base.DAOException;
import app.base.ServiceException;
import app.creditapp.sys.entity.SysMenu;
import app.creditapp.sys.entity.SysRoleMenu;
/**
* Title: SysMenuDao.java
* Description:
**/

public interface SysMenuDao {
	
	/**
	 * ������в˵�
	 * @param stats
	 * @return
	 * @throws DAOException
	 */
	public List<SysMenu> findAll(String stats) throws DAOException;
	
	/**
	 * ����
	 * @param entity
	 * @throws DAOException
	 */
	public void insert(SysMenu entity)  throws DAOException;
	
	/**
	 * ����
	 * @param entity
	 * @throws DAOException
	 */
	public void update(SysMenu entity) throws DAOException;
	
	/**
	 * ��ҳ����
	 * @param map
	 * @return
	 * @throws DAOException
	 */
	public List<SysMenu> findPage(Map<String,Object> map) throws DAOException;
	
	/**
	 * �˵���ɾ��
	 * @param menu_no
	 * @return
	 * @throws DAOException
	 */
	public String delete(String menuNo) throws DAOException;
	/**
	 * ��ü���
	 * @param sm
	 * @return
	 * @throws DAOException
	 */
	public int getCount(SysMenu sm) throws DAOException;
/**
 * 
 * @param roleno
 * @return ���ݽ�ɫ��ȡһ���˵�
 * @throws DAOException
 */
	public List<SysRoleMenu> getSysMenuByRoleNo(String roleno) throws DAOException;
	/**
	 * �����û���ȡһ���˵�
	 * @param userid
	 * @return
	 * @throws DAOException
	 */
	public List<SysRoleMenu> getSysMenuByUserId(String roleNo)throws DAOException;
	/**
	 * 
	 * @param roleno
	 * @return ���ݽ�ɫ��ȡһ���˵�
	 * @throws DAOException
	 */
	public List<SysMenu> getAllMenuByRole(String roleno) throws DAOException;
	/**
	 * 
	 * @param roleno
	 * @return ���ݽ�ɫ��ȡ1,2,3���˵�
	 * @throws DAOException
	 */
	public List<SysMenu> getAllMenuByRoles(String roleno) throws DAOException;
	/**
	 * 
	 * @param userid
	 * @return
	 * @throws DAOException
	 */
	public List<SysMenu> getAllMenuByUserId(String roleNo)throws DAOException;
	
	
	/**
	 * Url��ѯ���˵�
	 * @param menu_url
	 * @return
	 * @throws DAOException
	 */
	public SysMenu getParentByMenuUrl(String menu_url) throws DAOException;
	/**
	 * ������ж����˵�
	 * @return
	 * @throws DAOException
	 */
	public List<SysMenu> getAllLev2Menu() throws DAOException;
	/**
	 * 
	 */
	public List<SysMenu> getallsysmenu()throws DAOException;
	/**
	 * ������ж����˵�
	 * @return
	 * @throws DAOException
	 */
	public List<SysMenu> getAllMenuByRoleNo(String role_no) throws DAOException;
	/**
	 * 
	 * @param roleno
	 * @return
	 * @throws DAOException
	 * @desc ���ݽ�ɫ�Ų�ѯ���в˵�
	 * List<SysRoleMenu>
	 */
	public List<SysMenu> getAllMenuByRole_no(String roleno) throws DAOException;
	public SysMenu getParentByMenuNo(String menuNo) throws DAOException ;
	public List<SysMenu> findAll1() throws DAOException;

	public List<SysMenu> getAllMenuByParent(String menuParent) throws DAOException;

	public SysMenu getById(String menuNo) throws DAOException;

	public List<SysMenu> findMenuLev1ByRole(String roleno)throws DAOException ;
	
	/*
	 * ��ק�˵��޸ģ���Ҫ��̬�޸���ţ�
	 */
	public void moveUpdate(SysMenu entity) throws DAOException ;
	/*
	 * ��ק���޸Ĳ˵����
	 */
	public void updateMenuSeq(SysMenu entity) throws DAOException ;
}
