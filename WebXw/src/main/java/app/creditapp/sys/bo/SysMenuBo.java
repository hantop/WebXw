package  app.creditapp.sys.bo;

import java.util.List;
import app.base.ServiceException;
import app.creditapp.sys.entity.SysMenu;

/**
* Title: SysMenuBo.java
* Description:
**/

public interface SysMenuBo {
	/**
	 * ������в˵�
	 * @param stats
	 * @return
	 * @throws DAOException
	 */
//	public List<SysMenu> findAll(String stats) throws ServiceException;
	/**
	 * ��ý�ɫ��Ӧ�Ĳ˵�
	 * @param role_no
	 * @return
	 * @throws ServiceException
	 */
//	public List<SysRoleMenu> getSysMenuByRole_no(String role_no) throws ServiceException;
	/**
	 * ����û���Ӧ�Ĳ˵�
	 * @param userid
	 * @return
	 * @throws ServiceException
	 */
//	public List<SysRoleMenu> getSysMenuByUser_id(String userid)throws ServiceException;
	/**
	 * ��ý�ɫ��Ӧ�������Ӳ˵�������nav.js
	 * @param role_no
	 * @return 
	 * @throws ServiceException
	 */
//	public List<SysMenu> getAllMenuByRole(String role_no) throws ServiceException;
	/**
	 * ��ý�ɫ��Ӧ������1,2,3�˵�
	 * @param role_no
	 * @return 
	 * @throws ServiceException
	 */
//	public List<SysMenu> getAllMenuByRoles(String role_no) throws ServiceException;
	/**
	 * ����û���Ӧ�������Ӳ˵�������nav.js
	 * @param userid
	 * @return
	 * @throws ServiceException
	 */
//	public List<SysMenu> getAllMenuByUserId(String userid)throws ServiceException;
	/**
	 * �������Json��ʽ�˵�
	 * @return
	 * @throws ServiceException
	 */
//	public String getAllJsonMenu() throws ServiceException;
	public String getAllJsonMenu1() throws ServiceException;
	public String getAllJsonMenu2() throws ServiceException;
	/**
	 * ��ҳ��ѯ
	 * @param ipg
	 * @param sm
	 * @return
	 * @throws ServiceException
	 */
//	public Ipage findPage(Ipage ipg,SysMenu sm) throws ServiceException;
	/**
	 * �����͸���
	 * @param sm
	 * @throws ServiceException
	 */
//	public void saveOrUpdate(SysMenu sm) throws ServiceException;
	
	public void insert(SysMenu sm) throws ServiceException;
	
	public void update(SysMenu sm) throws ServiceException;
	/**
	 * �˵���ɾ��
	 * @param menu_no
	 * @throws ServiceException
	 */
	public void delete(String menuNo) throws ServiceException;
	
	public String getallsysmenu()throws ServiceException;
	public String getallrolemenu(String roleNo)throws ServiceException;
	public List<SysMenu> getmu()throws ServiceException;
	/**
	 * ��ѯһ������Ա�������Ӧ�����в˵�������
	 * @param role_no
	 * @return 
	 * @throws ServiceException
	 */
	public String getAllMenuByRoleNo(String role_no) throws ServiceException;
	/*
	 * ���ݿ�ݲ˵��Ų�ѯ�ϼ������ϼ��Ĳ˵�����
	 */
	public String[] getParentMenuNameByMenuNo(String menuNo)throws ServiceException;
	
	/**
	 * ���ݽ�ɫ�Ų�ѯ���в˵�
	 * @param roleNo
	 * @return
	 * @throws ServiceException
	 */
	public List<SysMenu> getAllMenuByRole_no(String roleNo) throws ServiceException;
	
	public List<SysMenu> getAllMenuByParent(String menuNo) throws ServiceException;
	
	public SysMenu getById(String menuNo) throws ServiceException;
	/**
	 * ��ѯ��ɫ������һ���˵�
	 * @param roleNo
	 * @return
	 * @throws ServiceException
	 */
	public List<SysMenu> findMenuLev1ByRole(String roleNo) throws ServiceException ;
	
	/*
	 * ��ק�˵��޸ģ���Ҫ��̬�޸���ţ�
	 */
	public void moveUpdate(SysMenu entity) throws ServiceException ;
	
	/*
	 * ͬ���ڵ���ק
	 */
	public boolean changeMenuSeqForMove(SysMenu moveSm, SysMenu targetSm) throws ServiceException ;
	public boolean changeSysmenuSeq(SysMenu moveSm, SysMenu targetSm) throws ServiceException ;
}