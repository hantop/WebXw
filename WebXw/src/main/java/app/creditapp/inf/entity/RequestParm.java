package app.creditapp.inf.entity;

/**
 * @���� DHCC-zhangwei
 * @���� Jun 23, 2016
 * @���� �������ʵ��
 */
public class RequestParm {
	private String reqNo; // ������
	private String txCode; // ��Ϣ���
	private String reqDate; // ����
	private String reqTime; // ʱ��
	private String token; // ��ʶ
	private String reqSerial; // ���к�
	private String content; // �������ݣ�json��ʽ��
	//�����brNo�����������
	private String brNo; // �����������

	public String getReqNo() {
		return reqNo;
	}

	public void setReqNo(String reqNo) {
		this.reqNo = reqNo;
	}

	public String getTxCode() {
		return txCode;
	}

	public void setTxCode(String txCode) {
		this.txCode = txCode;
	}

	public String getReqDate() {
		return reqDate;
	}

	public void setReqDate(String reqDate) {
		this.reqDate = reqDate;
	}

	public String getReqTime() {
		return reqTime;
	}

	public void setReqTime(String reqTime) {
		this.reqTime = reqTime;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getReqSerial() {
		return reqSerial;
	}

	public void setReqSerial(String reqSerial) {
		this.reqSerial = reqSerial;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getBrNo() {
		return brNo;
	}

	public void setBrNo(String brNo) {
		this.brNo = brNo;
	}
	

}
