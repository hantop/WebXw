package app.creditapp.inf.entity;

/**
 * @���� DHCC-zhangwei
 * @���� Jun 23, 2016
 * @���� �ӿ��������ʵ��
 */
public class ResponseParm {
	public ResponseParm() {

	}

	private String respCode; // ��Ӧ����
	private String batNo; // ���κ�
	private int dataCnt; // ��¼����
	private String respDesc; // ��Ӧ����
	private String content; // ��Ӧ���ݣ�json��ʽ��
	private String reqSerial;// ������ˮ��

	public int getDataCnt() {
		return dataCnt;
	}

	public void setDataCnt(int dataCnt) {
		this.dataCnt = dataCnt;
	}

	public String getRespCode() {
		return respCode;
	}

	public void setRespCode(String respCode) {
		this.respCode = respCode;
	}

	public String getBatNo() {
		return batNo;
	}

	public void setBatNo(String batNo) {
		this.batNo = batNo;
	}

	public String getRespDesc() {
		return respDesc;
	}

	public void setRespDesc(String respDesc) {
		this.respDesc = respDesc;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getReqSerial() {
		return reqSerial;
	}

	public void setReqSerial(String reqSerial) {
		this.reqSerial = reqSerial;
	}

}
