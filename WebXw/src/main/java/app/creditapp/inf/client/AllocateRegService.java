package app.creditapp.inf.client;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

/**
 * ����Ԥ����ӿڣ��ȴ�ӳ��
 **/

@WebService(targetNamespace = "http://webservice.iss.com")
public interface AllocateRegService {
	// ���ʵ����ղ���ӿ�
	@WebResult(name = "out", targetNamespace = "http://webservice.iss.com")
	@WebMethod
	public String saveActTransactionInfos(
			@WebParam(name = "in0", targetNamespace = "http://webservice.iss.com") String reqData);

	@WebResult(name = "out", targetNamespace = "http://webservice.iss.com")
	@WebMethod
	public java.lang.String getActTransactionState(
			@WebParam(name = "in0", targetNamespace = "http://webservice.iss.com") java.lang.String in0);
}