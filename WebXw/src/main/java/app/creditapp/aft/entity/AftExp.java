package app.creditapp.aft.entity;
import app.base.BaseDomain;
/**
* Title: AftExp.java
* Description:
* @version��1.0
**/
public class AftExp extends BaseDomain {
	private String expId;//չ��ID
	private String pactId;//��ͬID
	private String pactNo;//��ͬ��
	private String brNo;//��������
	private String begDate;//չ����ʼ��
	private String endDate;//չ�ڵ�����
	private Double expRate;//չ������
	private Double expAmt;//չ�ڽ��
	private String expReason;//չ��ԭ��
	private String expSts;//չ��״̬[01������02��չ��03��չ��04չ��ʧ��]
	private String opNo;//����Ա
	private String txDate;//�Ǽ�����
	private String upDate;//��������
	private String traceNo;//���ļ���ˮ��
	private String brName;//������������
	private String opName;//����Ա����

	/**
	 * @return չ��ID
	 */
	public String getExpId() {
	 	return expId;
	}
	/**
	 * @���� չ��ID
	 * @param expId
	 */
	public void setExpId(String expId) {
	 	this.expId = expId;
	}
	/**
	 * @return ��ͬID
	 */
	public String getPactId() {
	 	return pactId;
	}
	/**
	 * @���� ��ͬID
	 * @param pactId
	 */
	public void setPactId(String pactId) {
	 	this.pactId = pactId;
	}
	/**
	 * @return ��ͬ��
	 */
	public String getPactNo() {
	 	return pactNo;
	}
	/**
	 * @���� ��ͬ��
	 * @param pactNo
	 */
	public void setPactNo(String pactNo) {
	 	this.pactNo = pactNo;
	}
	/**
	 * @return ��������
	 */
	public String getBrNo() {
	 	return brNo;
	}
	/**
	 * @���� ��������
	 * @param brNo
	 */
	public void setBrNo(String brNo) {
	 	this.brNo = brNo;
	}
	/**
	 * @return չ����ʼ��
	 */
	public String getBegDate() {
	 	return begDate;
	}
	/**
	 * @���� չ����ʼ��
	 * @param begDate
	 */
	public void setBegDate(String begDate) {
	 	this.begDate = begDate;
	}
	/**
	 * @return չ�ڵ�����
	 */
	public String getEndDate() {
	 	return endDate;
	}
	/**
	 * @���� չ�ڵ�����
	 * @param endDate
	 */
	public void setEndDate(String endDate) {
	 	this.endDate = endDate;
	}
	/**
	 * @return չ������
	 */
	public Double getExpRate() {
	 	return expRate;
	}
	/**
	 * @���� չ������
	 * @param expRate
	 */
	public void setExpRate(Double expRate) {
	 	this.expRate = expRate;
	}
	/**
	 * @return չ�ڽ��
	 */
	public Double getExpAmt() {
	 	return expAmt;
	}
	/**
	 * @���� չ�ڽ��
	 * @param expAmt
	 */
	public void setExpAmt(Double expAmt) {
	 	this.expAmt = expAmt;
	}
	/**
	 * @return չ��ԭ��
	 */
	public String getExpReason() {
	 	return expReason;
	}
	/**
	 * @���� չ��ԭ��
	 * @param expReason
	 */
	public void setExpReason(String expReason) {
	 	this.expReason = expReason;
	}
	/**
	 * @return չ��״̬[01������02��չ��03��չ��04չ��ʧ��]
	 */
	public String getExpSts() {
	 	return expSts;
	}
	/**
	 * @���� չ��״̬[01������02��չ��03��չ��04չ��ʧ��]
	 * @param expSts
	 */
	public void setExpSts(String expSts) {
	 	this.expSts = expSts;
	}
	/**
	 * @return ����Ա
	 */
	public String getOpNo() {
	 	return opNo;
	}
	/**
	 * @���� ����Ա
	 * @param opNo
	 */
	public void setOpNo(String opNo) {
	 	this.opNo = opNo;
	}
	/**
	 * @return �Ǽ�����
	 */
	public String getTxDate() {
	 	return txDate;
	}
	/**
	 * @���� �Ǽ�����
	 * @param txDate
	 */
	public void setTxDate(String txDate) {
	 	this.txDate = txDate;
	}
	/**
	 * @return ��������
	 */
	public String getUpDate() {
	 	return upDate;
	}
	/**
	 * @���� ��������
	 * @param upDate
	 */
	public void setUpDate(String upDate) {
	 	this.upDate = upDate;
	}
	public String getTraceNo() {
		return traceNo;
	}
	public void setTraceNo(String traceNo) {
		this.traceNo = traceNo;
	}
	public String getBrName() {
		return brName;
	}
	public void setBrName(String brName) {
		this.brName = brName;
	}
	public String getOpName() {
		return opName;
	}
	public void setOpName(String opName) {
		this.opName = opName;
	}
}