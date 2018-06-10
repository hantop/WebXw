package app.creditapp.inf.client;

import app.creditapp.inf.client.IBody;


public class ZFSerchHead implements IBody{
	
	private String RequestType;//��������
	private String UUID;//Ψһ����
	private String ComId;//ƽ̨����
	private String ComIP;//ƽ̨ip��ַ
	private String SendTime;//����ʱ��
	private String Asyn;//�Ƿ��첽�ӿ�
	private String ReturnUrl;//�ص�Url
	private String Signed;//ǩ����
	private String ClientType;//����ϵͳ
	private String PageSize;//����ϵͳ
	private String PageNo;//����ϵͳ
	
	public String toXml() {
		StringBuffer s = new StringBuffer();

		s.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>");
		s.append("<Package><Header>");
		s.append("<RequestType>" + this.RequestType + "</RequestType>");
		s.append("<UUID>" + this.UUID + "</UUID>");
		s.append("<ComId>" + this.ComId + "</ComId>");
		s.append("<ComIP>" + this.ComIP + "</ComIP>");
		s.append("<SendTime>" + this.SendTime + "</SendTime>");
		s.append("<Asyn>" + this.Asyn + "</Asyn>");
		s.append("<ReturnUrl>" + this.ReturnUrl + "</ReturnUrl>");
		s.append("<Signed>" + this.Signed + "</Signed>");
		s.append("<ClientType>" + this.ClientType + "</ClientType>");
		s.append("<PageSize>" + this.PageSize + "</PageSize>");
		s.append("<PageNo>" + this.PageNo + "</PageNo>");
		s.append("</Header>");

		return s.toString();
	}

	public String getRequestType() {
		return RequestType;
	}

	public void setRequestType(String requestType) {
		RequestType = requestType;
	}

	public String getUUID() {
		return UUID;
	}

	public void setUUID(String uUID) {
		UUID = uUID;
	}

	public String getComId() {
		return ComId;
	}

	public void setComId(String comId) {
		ComId = comId;
	}

	public String getComIP() {
		return ComIP;
	}

	public void setComIP(String comIP) {
		ComIP = comIP;
	}

	public String getSendTime() {
		return SendTime;
	}

	public void setSendTime(String sendTime) {
		SendTime = sendTime;
	}

	public String getAsyn() {
		return Asyn;
	}

	public void setAsyn(String asyn) {
		Asyn = asyn;
	}

	public String getReturnUrl() {
		return ReturnUrl;
	}

	public void setReturnUrl(String returnUrl) {
		ReturnUrl = returnUrl;
	}

	public String getSigned() {
		return Signed;
	}

	public void setSigned(String signed) {
		Signed = signed;
	}

	public String getClientType() {
		return ClientType;
	}

	public void setClientType(String clientType) {
		ClientType = clientType;
	}

	public String getPageSize() {
		return PageSize;
	}

	public void setPageSize(String pageSize) {
		PageSize = pageSize;
	}

	public String getPageNo() {
		return PageNo;
	}

	public void setPageNo(String pageNo) {
		PageNo = pageNo;
	}
	
}