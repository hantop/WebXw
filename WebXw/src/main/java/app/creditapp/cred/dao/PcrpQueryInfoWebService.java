package app.creditapp.cred.dao;


import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * 
  * �ӿ������ƣ�PcrpQueryInfoWebService
  * ����������ѯ���ű������ͻ��˽ӿڣ��ȴ�ӳ��
  *�����ˣ�sunmingyi dhcc 
  * ����ʱ�䣺2016-6-28 ����01:21:47
  * �޸��ˣ�  
 * @version
 */
@WebService(targetNamespace = "entity.batchWS.creditapp.app")
public interface PcrpQueryInfoWebService {

	public String analyticForResult(@WebParam(name="selBatchNoJson") String selBatchNoJson);
	
	public String analyticForOneOnLocal(@WebParam(name="selBatchJson") String selBatchJson);
}
