package  app.creditapp.sys.bo;

import app.base.DAOException;
import app.base.ServiceException;
import app.util.toolkit.Ipage;

import app.creditapp.sys.entity.AccessCheckInfo;

/**
* Title: AccessCheckInfoBo.java
* Description:
**/
public interface AccessCheckInfoBo {

	public AccessCheckInfo getById(AccessCheckInfo accessCheckInfo) throws ServiceException;

	public Ipage findByPage(Ipage ipg, AccessCheckInfo accessCheckInfo) throws ServiceException;

	//1����ǰѡ��ĺ����������Ƿ������TA�Ŀͻ���Ϣ  ����ֵ ����� > 0 �͡��ǡ������0 ���ǡ���
	public int countForMsg(AccessCheckInfo accessCheckInfo) throws ServiceException;
	
	//2����������ά�ȵ����ò����Ƿ��������  ����ֵ�����0 ���� ���� �������1 ���� ���ǡ�
	public int countForConf(AccessCheckInfo accessCheckInfo) throws ServiceException;
	
	//3�����������Ƿ��Ѿ�����������Ŀ  ����ֵ�����0 ���� ���� �������0 ���� ���ǡ�
	public int countForRele(AccessCheckInfo accessCheckInfo) throws ServiceException;
	
	//4��������Ŀά���Ƿ�������������
	//�������Ϊ0 ��û��������ɣ�������������ݣ���ִ�еڶ���SQL 
	public int countForParam(AccessCheckInfo accessCheckInfo) throws DAOException;
	// �������ֵΪ0����������ɣ��������ֵ����0����û���������
	public int countForParamConf(AccessCheckInfo accessCheckInfo) throws DAOException;
	
	//5����������������������Ŀ����Ӫ��Ա�Ƿ��Ѿ�ȫ��ָ��  ����ֵ�����0 ���Ѿ�ȫ��ָ�ɣ�����ֵ�������0 ����δָ�ɵ���Ŀ
	public int countForDesig(AccessCheckInfo accessCheckInfo) throws DAOException;
}