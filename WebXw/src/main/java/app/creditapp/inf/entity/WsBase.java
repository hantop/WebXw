package app.creditapp.inf.entity;
import app.base.BaseDomain;
/**
* Title: WsBase.java
* Description:
* @version��1.0
**/
public class WsBase extends BaseDomain {
	private String wsBaseId;//ͨѶID:����/WS_BASE_SEQ
	private String wsDate;//ͨѶ����
	private String wsTime;//ͨѶʱ��
	private String txCode;//�ӿڱ��
	private String wsToken;//����
	private String wsSerial;//��ˮ��
	private String respTime;//��Ӧʱ��
	private String respCode;//��Ӧ��
	private String respDesc;//��Ӧ˵��
	private String wsSts;//״̬[01δ����02�Ѵ���]
	private String reqContent;//��������:JSON����
	private String respContent;//��Ӧ����:JSON����
	private String brNo;//����������
	private String brName;//����������

	/**
	 * @return ͨѶID:����/WS_BASE_SEQ
	 */
	public String getWsBaseId() {
	 	return wsBaseId;
	}
	/**
	 * @���� ͨѶID:����/WS_BASE_SEQ
	 * @param wsBaseId
	 */
	public void setWsBaseId(String wsBaseId) {
	 	this.wsBaseId = wsBaseId;
	}
	/**
	 * @return ͨѶ����
	 */
	public String getWsDate() {
	 	return wsDate;
	}
	/**
	 * @���� ͨѶ����
	 * @param wsDate
	 */
	public void setWsDate(String wsDate) {
	 	this.wsDate = wsDate;
	}
	/**
	 * @return ͨѶʱ��
	 */
	public String getWsTime() {
	 	return wsTime;
	}
	/**
	 * @���� ͨѶʱ��
	 * @param wsTime
	 */
	public void setWsTime(String wsTime) {
	 	this.wsTime = wsTime;
	}
	/**
	 * @return �ӿڱ��
	 */
	public String getTxCode() {
	 	return txCode;
	}
	/**
	 * @���� �ӿڱ��
	 * @param txCode
	 */
	public void setTxCode(String txCode) {
	 	this.txCode = txCode;
	}
	/**
	 * @return ����
	 */
	public String getWsToken() {
	 	return wsToken;
	}
	/**
	 * @���� ����
	 * @param wsToken
	 */
	public void setWsToken(String wsToken) {
	 	this.wsToken = wsToken;
	}
	/**
	 * @return ��ˮ��
	 */
	public String getWsSerial() {
	 	return wsSerial;
	}
	/**
	 * @���� ��ˮ��
	 * @param wsSerial
	 */
	public void setWsSerial(String wsSerial) {
	 	this.wsSerial = wsSerial;
	}
	/**
	 * @return ��Ӧʱ��
	 */
	public String getRespTime() {
	 	return respTime;
	}
	/**
	 * @���� ��Ӧʱ��
	 * @param respTime
	 */
	public void setRespTime(String respTime) {
	 	this.respTime = respTime;
	}
	/**
	 * @return ��Ӧ��
	 */
	public String getRespCode() {
	 	return respCode;
	}
	/**
	 * @���� ��Ӧ��
	 * @param respCode
	 */
	public void setRespCode(String respCode) {
	 	this.respCode = respCode;
	}
	/**
	 * @return ��Ӧ˵��
	 */
	public String getRespDesc() {
	 	return respDesc;
	}
	/**
	 * @���� ��Ӧ˵��
	 * @param respDesc
	 */
	public void setRespDesc(String respDesc) {
	 	this.respDesc = respDesc;
	}
	/**
	 * @return ״̬[01δ����02�Ѵ���]
	 */
	public String getWsSts() {
	 	return wsSts;
	}
	/**
	 * @���� ״̬[01δ����02�Ѵ���]
	 * @param wsSts
	 */
	public void setWsSts(String wsSts) {
	 	this.wsSts = wsSts;
	}
	/**
	 * @return ��������:JSON����
	 */
	public String getReqContent() {
	 	return reqContent;
	}
	/**
	 * @���� ��������:JSON����
	 * @param reqContent
	 */
	public void setReqContent(String reqContent) {
	 	this.reqContent = reqContent;
	}
	/**
	 * @return ��Ӧ����:JSON����
	 */
	public String getRespContent() {
	 	return respContent;
	}
	/**
	 * @���� ��Ӧ����:JSON����
	 * @param respContent
	 */
	public void setRespContent(String respContent) {
	 	this.respContent = respContent;
	}
	public String getBrNo() {
		return brNo;
	}
	public void setBrNo(String brNo) {
		this.brNo = brNo;
	}
	public String getBrName() {
		return brName;
	}
	public void setBrName(String brName) {
		this.brName = brName;
	}
}