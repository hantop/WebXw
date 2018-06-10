package  app.creditapp.sys.dao;

import java.util.List;
import app.base.DAOException;
import app.creditapp.sys.entity.AccessCheckInfo;
/**
* Title: AccessCheckInfoDao.java
* Description:
**/
public interface AccessCheckInfoDao {

	public AccessCheckInfo getById(AccessCheckInfo accessCheckInfo) throws DAOException;
		
	public List<AccessCheckInfo > findByPage(AccessCheckInfo accessCheckInfo) throws DAOException;

	//1����ǰѡ��ĺ����������Ƿ������TA�Ŀͻ���Ϣ  ����ֵ ����� > 0 �͡��ǡ������0 ���ǡ���
	public int countForMsg(AccessCheckInfo accessCheckInfo) throws DAOException;
	
	//2����������ά�ȵ����ò����Ƿ��������  ����ֵ�����0 ���� ���� �������1 ���� ���ǡ�
	public int countForConf(AccessCheckInfo accessCheckInfo) throws DAOException;

	//3�����������Ƿ��Ѿ�����������Ŀ  ����ֵ�����0 ���� ���� �������0 ���� ���ǡ�
	public int countForRele(AccessCheckInfo accessCheckInfo) throws DAOException;
	
	//4��������Ŀά���Ƿ�������������
	//�������Ϊ0 ��û��������ɣ�������������ݣ���ִ�еڶ���SQL 
	public int countForParam(AccessCheckInfo accessCheckInfo) throws DAOException;	
	// �������ֵΪ0����������ɣ��������ֵ����0����û���������
	public int countForParamConf(AccessCheckInfo accessCheckInfo) throws DAOException;
	
	//5����������������������Ŀ����Ӫ��Ա�Ƿ��Ѿ�ȫ��ָ��  ����ֵ�����0 ���Ѿ�ȫ��ָ�ɣ�����ֵ�������0 ����δָ�ɵ���Ŀ
	public int countForDesig(AccessCheckInfo accessCheckInfo) throws DAOException;
	
}