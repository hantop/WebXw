package app.creditapp.cred.dao;


import java.util.List;

import javax.jws.WebParam;

import app.base.DAOException;
import app.creditapp.cred.entity.PcrpQueryInfo;

/**
 * 
  * �ӿ������ƣ�PcrpQueryInfoDao
  * ������������ҵ�����ʵ�ַ��� 
  *�����ˣ�lidong dhcc 
  * ����ʱ�䣺2015-7-15 ����01:21:47
  * �޸��ˣ�Administrator  
 * @version
 */
public interface PcrpQueryInfoDao {

	//��ҳ��ѯ
	public List<PcrpQueryInfo> findByPage(PcrpQueryInfo pcrpDocInfo)throws DAOException;
	//���ñ����ѯ
	public List<PcrpQueryInfo> singleFindByPage(PcrpQueryInfo pcrpDocInfo)throws DAOException;
	//��ҳ��������ѯ
	public int getCount(PcrpQueryInfo pcrpDocInfo) throws DAOException;
	//���ñ�����������ѯ
	public int singleGetCount(PcrpQueryInfo pcrpDocInfo) throws DAOException;
	//���ñ�������
	public void insert(PcrpQueryInfo pcrpDocInfo) throws DAOException;
    //�������ñ����Ų�ѯ���ñ���
	public PcrpQueryInfo getByCrpId(PcrpQueryInfo pcrpQueryInfo);
	
	//���ݿͻ���Ϣ��ѯ�������ñ���
	public List<PcrpQueryInfo> getByCrp(PcrpQueryInfo pcrpQueryInfo);
	
	//���ݿͻ���Ϣ����URL
	public String getByUrl(PcrpQueryInfo pcrpQueryInfo);
	
	public List ExportDate(PcrpQueryInfo pcrpQueryInfo) throws DAOException;
	
	//���ݿͻ�֤�����룬��ѯ������Ϣ������������
	public PcrpQueryInfo existValid(PcrpQueryInfo pcrpQueryInfo) throws DAOException;
	
	//���ݿͻ�֤�����룬����״̬
	public void update(PcrpQueryInfo pcrpQueryInfo) throws DAOException;

	//���ݲ�ѯ������ѯ���в�������
	public int getBankCount(PcrpQueryInfo pcrpQueryInfo) throws DAOException;
	
	//���ݲ�ѯ������ѯ��������
	public int getBatchCount(PcrpQueryInfo pcrpQueryInfo) throws DAOException;
}
