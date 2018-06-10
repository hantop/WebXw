package app.creditapp.aft.entity;
import app.base.BaseDomain;
/**
* Title: AftRewReal.java
* Description:
* @version��1.0
**/
public class AftRewReal extends BaseDomain {
	private String rewType;//Ԥ������[01Ԥ��02��Ϣ]
	private String rewId;//Ԥ��ID
	private String rewNo;//Ԥ�����
	private Double rewValue;//Ԥ��ֵ
	private String rewDate;//Ԥ����������
	private String projNo;//��Ŀ���
	private String fundNo;//�ʽ���
	private String dueNo;//��ݺ�
	private String brNo;//��������
	private String pactNo;//��ͬ��
	private Double rewAmt;//Ԥ�����
	private String rewCont;//Ԥ������
	private String acptNo;//������
	private String dealRest;//������[01δ����02�Ѵ���]
	private String rewSts;//Ԥ��״̬[01Ԥ��02��Ԥ��]
	private String txDate;//�Ǽ�����
	private String upDate;//��������
	
	private String rewName;//Ԥ�����
	private String projName;//��Ŀ���
	private String brName;//Ԥ�����
	private String loginid;//��¼����Ա ����Ȩ��
	/**
	 * @return Ԥ������[01Ԥ��02��Ϣ]
	 */
	public String getRewType() {
	 	return rewType;
	}
	/**
	 * @���� Ԥ������[01Ԥ��02��Ϣ]
	 * @param rewType
	 */
	public void setRewType(String rewType) {
	 	this.rewType = rewType;
	}
	/**
	 * @return Ԥ��ID
	 */
	public String getRewId() {
	 	return rewId;
	}
	/**
	 * @���� Ԥ��ID
	 * @param rewId
	 */
	public void setRewId(String rewId) {
	 	this.rewId = rewId;
	}
	/**
	 * @return Ԥ�����
	 */
	public String getRewNo() {
	 	return rewNo;
	}
	/**
	 * @���� Ԥ�����
	 * @param rewNo
	 */
	public void setRewNo(String rewNo) {
	 	this.rewNo = rewNo;
	}
	/**
	 * @return Ԥ��ֵ
	 */
	public Double getRewValue() {
	 	return rewValue;
	}
	/**
	 * @���� Ԥ��ֵ
	 * @param rewValue
	 */
	public void setRewValue(Double rewValue) {
	 	this.rewValue = rewValue;
	}
	/**
	 * @return Ԥ����������
	 */
	public String getRewDate() {
	 	return rewDate;
	}
	/**
	 * @���� Ԥ����������
	 * @param rewDate
	 */
	public void setRewDate(String rewDate) {
	 	this.rewDate = rewDate;
	}
	/**
	 * @return ��Ŀ���
	 */
	public String getProjNo() {
	 	return projNo;
	}
	/**
	 * @���� ��Ŀ���
	 * @param projNo
	 */
	public void setProjNo(String projNo) {
	 	this.projNo = projNo;
	}
	/**
	 * @return �ʽ���
	 */
	public String getFundNo() {
	 	return fundNo;
	}
	/**
	 * @���� �ʽ���
	 * @param fundNo
	 */
	public void setFundNo(String fundNo) {
	 	this.fundNo = fundNo;
	}
	/**
	 * @return ��ݺ�
	 */
	public String getDueNo() {
	 	return dueNo;
	}
	/**
	 * @���� ��ݺ�
	 * @param dueNo
	 */
	public void setDueNo(String dueNo) {
	 	this.dueNo = dueNo;
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
	 * @return Ԥ�����
	 */
	public Double getRewAmt() {
	 	return rewAmt;
	}
	/**
	 * @���� Ԥ�����
	 * @param rewAmt
	 */
	public void setRewAmt(Double rewAmt) {
	 	this.rewAmt = rewAmt;
	}
	/**
	 * @return Ԥ������
	 */
	public String getRewCont() {
	 	return rewCont;
	}
	/**
	 * @���� Ԥ������
	 * @param rewCont
	 */
	public void setRewCont(String rewCont) {
	 	this.rewCont = rewCont;
	}
	/**
	 * @return ������
	 */
	public String getAcptNo() {
	 	return acptNo;
	}
	/**
	 * @���� ������
	 * @param acptNo
	 */
	public void setAcptNo(String acptNo) {
	 	this.acptNo = acptNo;
	}
	/**
	 * @return ������[01δ����02�Ѵ���]
	 */
	public String getDealRest() {
	 	return dealRest;
	}
	/**
	 * @���� ������[01δ����02�Ѵ���]
	 * @param dealRest
	 */
	public void setDealRest(String dealRest) {
	 	this.dealRest = dealRest;
	}
	/**
	 * @return Ԥ��״̬[01Ԥ��02��Ԥ��]
	 */
	public String getRewSts() {
	 	return rewSts;
	}
	/**
	 * @���� Ԥ��״̬[01Ԥ��02��Ԥ��]
	 * @param rewSts
	 */
	public void setRewSts(String rewSts) {
	 	this.rewSts = rewSts;
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
	/**
	 * @return the rewName
	 */
	public String getRewName() {
		return rewName;
	}
	/**
	 * @param rewName the rewName to set
	 */
	public void setRewName(String rewName) {
		this.rewName = rewName;
	}
	/**
	 * @return the projName
	 */
	public String getProjName() {
		return projName;
	}
	/**
	 * @param projName the projName to set
	 */
	public void setProjName(String projName) {
		this.projName = projName;
	}
	/**
	 * @return the brName
	 */
	public String getBrName() {
		return brName;
	}
	/**
	 * @param brName the brName to set
	 */
	public void setBrName(String brName) {
		this.brName = brName;
	}
	/**
	 * @return the loginid
	 */
	public String getLoginid() {
		return loginid;
	}
	/**
	 * @param loginid the loginid to set
	 */
	public void setLoginid(String loginid) {
		this.loginid = loginid;
	}
}