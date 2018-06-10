package  app.creditapp.wkf.dao;
import java.util.List;
import java.util.Map;

import app.base.DAOException;
import app.creditapp.wkf.entity.WkfApprovalUser;
/**
* Title: WkfApprovalUserDao.java
* Description:
**/
public interface WkfApprovalUserDao {

	public WkfApprovalUser getById(WkfApprovalUser wkfApprovalUser) throws DAOException;
	
	public WkfApprovalUser getById2(WkfApprovalUser wkfApprovalUser) throws DAOException;

	public void del(WkfApprovalUser wkfApprovalUser) throws DAOException;
	
	public void delForRole(WkfApprovalUser wkfApprovalUser) throws DAOException;

	public void insert(WkfApprovalUser wkfApprovalUser) throws DAOException;

	public void update(WkfApprovalUser wkfApprovalUser) throws DAOException;
	
	public int getCount(WkfApprovalUser wkfApprovalUser) throws DAOException;

	public List<WkfApprovalUser > findByPage(WkfApprovalUser wkfApprovalUser) throws DAOException;

	public String getSeq() throws DAOException;

	public List<WkfApprovalUser> getByIdAndBrNo(WkfApprovalUser wkfApprovalUser) throws DAOException;
	
	public WkfApprovalUser getByUser(WkfApprovalUser wkfApprovalUser) throws DAOException;
	
	public int getUserCount(String wkfUserName) throws DAOException;

	public List<String> getWkfApprovalUserList(WkfApprovalUser wkfApprovalUser)throws DAOException;

	public List<Map<String,Object>> findByPageMapPop(WkfApprovalUser wkfApprovalUser)throws DAOException;

	public List<WkfApprovalUser> getAllList(WkfApprovalUser wkfApprovalUser)throws DAOException;
	public List<WkfApprovalUser> getAllList(String wkf_user_name)throws DAOException;

	public void delByWkfRoleNo(WkfApprovalUser wkfApprovalUser)throws DAOException;

	public Integer getApprovalUserCount(WkfApprovalUser wkfApprovalUser)throws DAOException;

	public List<Map<String,Object>> findApprovalUserByPage(WkfApprovalUser wkfApprovalUser)throws DAOException;
	
	/**
	 * 
	 * ������������ѯ��ǰ�ڵ�Ļ�ǩ��Ա
	 * @param wkfApprovalUser
	 * @return
	 * @throws DAOException
	 * @�޸���־��
	 */
	public List<Map<String, Object>> findApproveUserByPage(WkfApprovalUser wkfApprovalUser)throws DAOException;
	
	/**
	 * 
	 * ������������ѯ��ǰ�ڵ��ǩ�����ѡ����Ա
	 * @param wkfApprovalUser
	 * @return
	 * @throws DAOException
	 * @�޸���־��
	 */
	public Integer getApproveUserCount(WkfApprovalUser wkfApprovalUser)throws DAOException;
	
	/**
	 * 
	 * ���������� ���ݲ���Ա�ţ�ȡ������Ա����
	 * @return
	 * @throws DAOException
	 * @�޸���־��
	 */
	public Integer getSignType(String op_no) throws DAOException;
	/**
	 * �����û�����������ɫ������ѯʵ��
	 * @param wkfApprovalUser
	 * @return
	 * @throws DAOException
	 */
	public WkfApprovalUser getByRoleName(WkfApprovalUser wkfApprovalUser) throws DAOException;

}