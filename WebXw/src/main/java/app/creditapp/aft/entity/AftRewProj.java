package app.creditapp.aft.entity;
import app.base.BaseDomain;
/**
* Title: AftRewProj.java
* Description:
* @version��1.0
**/
public class AftRewProj extends BaseDomain {
	private String rewType;//Ԥ������[01Ԥ��02��Ϣ]
	private String rewId;//Ԥ��ID
	private String rewNo;//Ԥ�����
	private Double rewValue;//Ԥ��ֵ
	private String rewDate;//Ԥ����������
	private String projNo;//��Ŀ���
	private String projName;//��Ŀ����
	private String projNatu;//��Ŀ����
	private Double projAmt;//��Ŀ��ģ
	private String setupDate;//��������
	private String endDate;//��������
	private Double projBal;//ר�����
	private Double overRate;//����������
	private String rewCont;//Ԥ������
	private String acptNo;//������
	private String dealRest;//������[01δ����02�Ѵ���]
	private String rewSts;//Ԥ��״̬[01Ԥ��02��Ԥ��]
	private String txDate;//�Ǽ�����
	private String upDate;//��������
	private String rewName;//Ԥ������

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
	 * @return ��Ŀ����
	 */
	public String getProjName() {
	 	return projName;
	}
	/**
	 * @���� ��Ŀ����
	 * @param projName
	 */
	public void setProjName(String projName) {
	 	this.projName = projName;
	}
	/**
	 * @return ��Ŀ����
	 */
	public String getProjNatu() {
	 	return projNatu;
	}
	/**
	 * @���� ��Ŀ����
	 * @param projNatu
	 */
	public void setProjNatu(String projNatu) {
	 	this.projNatu = projNatu;
	}
	/**
	 * @return ��Ŀ��ģ
	 */
	public Double getProjAmt() {
	 	return projAmt;
	}
	/**
	 * @���� ��Ŀ��ģ
	 * @param projAmt
	 */
	public void setProjAmt(Double projAmt) {
	 	this.projAmt = projAmt;
	}
	/**
	 * @return ��������
	 */
	public String getSetupDate() {
	 	return setupDate;
	}
	/**
	 * @���� ��������
	 * @param setupDate
	 */
	public void setSetupDate(String setupDate) {
	 	this.setupDate = setupDate;
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
	 * @return ר�����
	 */
	public Double getProjBal() {
	 	return projBal;
	}
	/**
	 * @���� ר�����
	 * @param projBal
	 */
	public void setProjBal(Double projBal) {
	 	this.projBal = projBal;
	}
	/**
	 * @return ����������
	 */
	public Double getOverRate() {
	 	return overRate;
	}
	/**
	 * @���� ����������
	 * @param overRate
	 */
	public void setOverRate(Double overRate) {
	 	this.overRate = overRate;
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