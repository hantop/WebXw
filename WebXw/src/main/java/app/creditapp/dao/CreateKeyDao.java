package app.creditapp.dao;

import app.base.DAOException;

public interface CreateKeyDao {
	
	/**
	 * @����˵������ȡԤ�������α��
	 * @���ز��� String
	 */
	public String getPreBatchNo()throws DAOException;
	
	public String getQueBatchNo()throws DAOException;
	
	public String getUUID()throws DAOException;
	
	public String getBatchNo()throws DAOException;
	
	public String getWsId()throws DAOException;
	
	public String getPreAppId()throws DAOException;
	
	public String getLnBatchNo()throws DAOException;
	
	public String getLnApplyId()throws DAOException;
	
	/**
	 * ��ú�ͬ��
	 * @param 
	 * @return 
	 * @throws DAOException
	 */
	public String getKeyByDate( String sys_date )throws DAOException;
	/**
	 * ��ÿͻ���
	 * @param 
	 * @return 
	 * @throws DAOException
	 */
	public String getCif_no( String sys_date )throws DAOException;
	/**
	 * ���������
	 * @param 
	 * @return 
	 * @throws DAOException
	 */
	public String getOutInId()throws DAOException;
	
	/**
	 * @description ֪ͨ�����
	 * @return
	 * @throws DAOException
	 * @version 1.0
	 */
	public String getNoteModelId() throws DAOException;
	
	/**
	 * ��ȡϵͳ����ͻ������������
	 * @return
	 * @throws DAOException
	 */
	public String getGroupNo(String sys_date) throws DAOException;
	
	public String getPublicKeyByDate(String sysDate, String tableName, String id) throws DAOException;
	
	/**
	 * ��ȡ�ʲ��ر��
	 * @return
	 * @throws DAOException
	 */
	public String getPoolId() throws DAOException;
	

}
