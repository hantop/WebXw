package app.creditapp.aft.entity;
import app.base.BaseDomain;
/**
* Title: AftRewFund.java
* Description:
* @version��1.0
**/
public class AftRewFund extends BaseDomain {
	private String rewType;//Ԥ������[01Ԥ��02��Ϣ]
	private String rewId;//Ԥ��ID
	private String rewNo;//Ԥ�����
	private Double rewValue;//Ԥ��ֵ
	private String rewDate;//Ԥ����������
	private String projNo;//��Ŀ���
	private String projName;//��Ŀ���
	private String fundNo;//�ʽ���
	private String fundName;//�ʽ�����
	private Double fdAmt;//�ʽ�ǰ��ģ
	private String begDate;//��ʵ����
	private String endDate;//��������
	private Double cashBal;//�ֽ����
	private String repayType;//��Ϣ��ʽ
	private String rewCont;//Ԥ������
	private String acptNo;//������
	private String dealRest;//������[01δ����02�Ѵ���]
	private String rewSts;//Ԥ��״̬[01Ԥ��02��Ԥ��]
	private String txDate;//�Ǽ�����
	private String upDate;//��������
	private String rewName;//Ԥ������
	
	private String brNo;//����������
	private String brName;//����������

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
	 * @return �ʽ�����
	 */
	public String getFundName() {
	 	return fundName;
	}
	/**
	 * @���� �ʽ�����
	 * @param fundName
	 */
	public void setFundName(String fundName) {
	 	this.fundName = fundName;
	}
	/**
	 * @return �ʽ�ǰ��ģ
	 */
	public Double getFdAmt() {
	 	return fdAmt;
	}
	/**
	 * @���� �ʽ�ǰ��ģ
	 * @param fdAmt
	 */
	public void setFdAmt(Double fdAmt) {
	 	this.fdAmt = fdAmt;
	}
	/**
	 * @return ��ʵ����
	 */
	public String getBegDate() {
	 	return begDate;
	}
	/**
	 * @���� ��ʵ����
	 * @param begDate
	 */
	public void setBegDate(String begDate) {
	 	this.begDate = begDate;
	}
	/**
	 * @return ��������
	 */
	public String getEndDate() {
	 	return endDate;
	}
	/**
	 * @���� ��������
	 * @param endDate
	 */
	public void setEndDate(String endDate) {
	 	this.endDate = endDate;
	}
	/**
	 * @return �ֽ����
	 */
	public Double getCashBal() {
	 	return cashBal;
	}
	/**
	 * @���� �ֽ����
	 * @param cashBal
	 */
	public void setCashBal(Double cashBal) {
	 	this.cashBal = cashBal;
	}
	/**
	 * @return ��Ϣ��ʽ
	 */
	public String getRepayType() {
	 	return repayType;
	}
	/**
	 * @���� ��Ϣ��ʽ
	 * @param repayType
	 */
	public void setRepayType(String repayType) {
	 	this.repayType = repayType;
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
	public String getRewName() {
		return rewName;
	}
	public void setRewName(String rewName) {
		this.rewName = rewName;
	}
	public String getProjName() {
		return projName;
	}
	public void setProjName(String projName) {
		this.projName = projName;
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