package app.creditapp.cred.bo;

import java.util.List;

import javax.jws.WebParam;

import app.base.DAOException;
import app.base.ServiceException;
import app.creditapp.cred.entity.PcrpQueryInfo;
import app.creditapp.inf.entity.WsIn4103;
import app.util.toolkit.Ipage;
/**
 * 
  * �ӿ����ƣ�PcrpQueryInfoBo
  * �ӿ�����������������ط��� 
  *�����ˣ�lidong dhcc
  * ����ʱ�䣺2015-7-15 ����01:08:11
  * �޸��ˣ�Administrator  
 * @version
 */
public interface PcrpQueryInfoBo {
	
	public Ipage findByPage(Ipage ipg,PcrpQueryInfo pcrpQueryInfo) throws ServiceException;
	
	public Ipage singleSearch(Ipage ipg,PcrpQueryInfo pcrpQueryInfo) throws ServiceException;
	
	public void insert(PcrpQueryInfo pcrpQueryInfo) throws ServiceException;

	public PcrpQueryInfo getByCrpId(PcrpQueryInfo pcrpQueryInfo) throws ServiceException;
	
	//���ݿͻ���Ϣ��ѯ�������ñ���
	//public List<PcrpQueryInfo> getByCrp(PcrpQueryInfo pcrpQueryInfo) throws ServiceException;
	
	//���ݿͻ���Ϣ����URL
	public String getByUrl(PcrpQueryInfo pcrpQueryInfo) throws ServiceException;
	
	public List ExportDate( PcrpQueryInfo pcrpQueryInfo)throws ServiceException;
	
	//���ݿͻ�֤�����룬��ѯ������Ϣ������������
	public PcrpQueryInfo existValid(PcrpQueryInfo pcrpQueryInfo) throws ServiceException;
	
	//���ݿͻ�֤�����룬����״̬
	public void update(PcrpQueryInfo pcrpQueryInfo) throws ServiceException;
	
	/**
	 * ���ʲ�ѯ���Ž������ ������
	 */
	public String getByCrp(@WebParam(name="pcrpQueryInfoJson") PcrpQueryInfo pcrpQueryInfo);
	
	/**
	 * ������ѯ���Ž������ ������
	 */
	public String analyticForResult(@WebParam(name="pcrpQueryInfoJson") WsIn4103 wsIn4103);

	//���ݲ�ѯ�����������в���������ѯ
	public int getBankCount(PcrpQueryInfo pcrpQueryInfo) throws DAOException;
	
	//����������ѯ���ű���
	public int getBatchCount(PcrpQueryInfo pcrpQueryInfo) throws ServiceException;
}
