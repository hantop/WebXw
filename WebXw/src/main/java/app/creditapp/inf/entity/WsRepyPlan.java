package app.creditapp.inf.entity;
import app.base.BaseDomain;
/**
* Title: WsRepyPlan.java
* Description:
* @version��1.0  ����ƻ��ϴ���ϸ��
**/
public class WsRepyPlan extends BaseDomain {
	private String wsId;//�������ݱ��
	private String batchNo;//���κ�
	private String brNo;//�����������
	private String pactNo;//��ͬ��:��ͬ��+�ڴ�Ϊ����
	private Integer cnt;//�ڴ�
	private String begDate;//��ʼ����
	private String endDate;//��ֹ����
	private Double totalAmt;//�ڹ����:6=7+8
	private Double prcpAmt;//���ڱ���
	private Double normInt;//������Ϣ
	private String sts;//����״̬[01δ����02�ѽ���]
	private String txDate;//������������
	private String brName;//������������
	/**
	 * @return �������ݱ��
	 */
	public String getWsId() {
	 	return wsId;
	}
	/**
	 * @���� �������ݱ��
	 * @param wsId
	 */
	public void setWsId(String wsId) {
	 	this.wsId = wsId;
	}
	/**
	 * @return ���κ�
	 */
	public String getBatchNo() {
	 	return batchNo;
	}
	/**
	 * @���� ���κ�
	 * @param batchNo
	 */
	public void setBatchNo(String batchNo) {
	 	this.batchNo = batchNo;
	}
	/**
	 * @return �����������
	 */
	public String getBrNo() {
	 	return brNo;
	}
	/**
	 * @���� �����������
	 * @param brNo
	 */
	public void setBrNo(String brNo) {
	 	this.brNo = brNo;
	}
	/**
	 * @return ��ͬ��:��ͬ��+�ڴ�Ϊ����
	 */
	public String getPactNo() {
	 	return pactNo;
	}
	/**
	 * @���� ��ͬ��:��ͬ��+�ڴ�Ϊ����
	 * @param pactNo
	 */
	public void setPactNo(String pactNo) {
	 	this.pactNo = pactNo;
	}
	/**
	 * @return �ڴ�
	 */
	public Integer getCnt() {
	 	return cnt;
	}
	/**
	 * @���� �ڴ�
	 * @param cnt
	 */
	public void setCnt(Integer cnt) {
	 	this.cnt = cnt;
	}
	/**
	 * @return ��ʼ����
	 */
	public String getBegDate() {
	 	return begDate;
	}
	/**
	 * @���� ��ʼ����
	 * @param begDate
	 */
	public void setBegDate(String begDate) {
	 	this.begDate = begDate;
	}
	/**
	 * @return ��ֹ����
	 */
	public String getEndDate() {
	 	return endDate;
	}
	/**
	 * @���� ��ֹ����
	 * @param endDate
	 */
	public void setEndDate(String endDate) {
	 	this.endDate = endDate;
	}
	/**
	 * @return �ڹ����:6=7+8
	 */
	public Double getTotalAmt() {
	 	return totalAmt;
	}
	/**
	 * @���� �ڹ����:6=7+8
	 * @param totalAmt
	 */
	public void setTotalAmt(Double totalAmt) {
	 	this.totalAmt = totalAmt;
	}
	/**
	 * @return ���ڱ���
	 */
	public Double getPrcpAmt() {
	 	return prcpAmt;
	}
	/**
	 * @���� ���ڱ���
	 * @param prcpAmt
	 */
	public void setPrcpAmt(Double prcpAmt) {
	 	this.prcpAmt = prcpAmt;
	}
	/**
	 * @return ������Ϣ
	 */
	public Double getNormInt() {
	 	return normInt;
	}
	/**
	 * @���� ������Ϣ
	 * @param normInt
	 */
	public void setNormInt(Double normInt) {
	 	this.normInt = normInt;
	}
	/**
	 * @return ����״̬[01δ����02�ѽ���]
	 */
	public String getSts() {
	 	return sts;
	}
	/**
	 * @���� ����״̬[01δ����02�ѽ���]
	 * @param sts
	 */
	public void setSts(String sts) {
	 	this.sts = sts;
	}
	public String getTxDate() {
		return txDate;
	}
	public void setTxDate(String txDate) {
		this.txDate = txDate;
	}
	public String getBrName() {
		return brName;
	}
	public void setBrName(String brName) {
		this.brName = brName;
	}
}