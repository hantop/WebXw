package app.creditapp.inf.client;

import javax.jws.WebParam;
import javax.jws.WebService;
/**
��ѯ���ſͻ��˽ӿڣ��ȴ�ӳ��
**/
@WebService(targetNamespace = "entity.batchWS.creditapp.app")
public interface CreditSelService {
    //public String analytic(@WebParam(name="receiveJson") ArrayList<CreditSelPreApply> preList);
	//public String analytic(@WebParam(name="receiveJson") String receiveJson);
	
	// �������Ų�ѯ�ӿ�
	public String analyticForOne(@WebParam(name="receiveJson") String receiveJson);
	// ������ѯ���Žӿ�
	public String analyticForBatch(@WebParam(name="receiveJson") String receiveJson);
	
	// ���ʲ�ѯ����ӿ�  ֻ��ѯ���ؿ�
	public String analyticForOneOnLocal(@WebParam(name="selBatchJson") String selBatchJson);
	// ���������ѯ�ӿ�  ֻ��ѯ���ؿ�
	public String analyticForResult(@WebParam(name="selBatchNoJson") String selBatchNoJson);

//	public int getCount(WsQueryCreditBean wsQueryCreditBean) throws DAOException;
	
}