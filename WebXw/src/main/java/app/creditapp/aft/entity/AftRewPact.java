package app.creditapp.aft.entity;
import app.base.BaseDomain;
/**
* Title: AftRewPact.java
* Description:
* @version��1.0
**/
public class AftRewPact extends BaseDomain {
	private String rewNo;//Ԥ�����
	private String rewType;//Ԥ������[01Ԥ��02��Ϣ]
	private String rewId;//Ԥ��ID
	private String rewDate;//Ԥ����������
	private Double rewValue;//Ԥ��ֵ
	private String projNo;//��Ŀ���
	private String brNo;//����������
	private String pactId;//��ͬID
	private String pactNo;//��ͬ���
	private String cifNo;//�ͻ���
	private String cifName;//�ͻ�����
	private String prdtNo;//��Ʒ��
	private Double pactAmt;//��ͬ���
	private Double bal;//��ͬ���/���˽��
	private Double intst;//ǷϢ
	private String begDate;//��ʼ����/��������
	private String endDate;//��������
	private String relId;//����ҵ��ID/ѺƷID
	private String rewCont;//Ԥ������
	private String acptNo;//������
	private String dealRest;//������[01δ����02�Ѵ���]
	private String rewSts;//Ԥ��״̬[01Ԥ��02��Ԥ��]
	private String txDate;//�Ǽ�����
	private String upDate;//��������
	private String rewName;//Ԥ������
	private String prdtName;//��Ʒ����
	private String brName;//������������
	private String projName;//��Ŀ����
	
	private String backId;
	private String collWay;
	private String lastDate;
	private String collResult;
	
	
	private int sumCount;//����ʱʹ�ã�������Ŀ����ʱͳ������
	private String loginid;//��¼����Ա ����Ȩ��
	
	public int getSumCount() {
		return sumCount;
	}
	public void setSumCount(int sumCount) {
		this.sumCount = sumCount;
	}
	public String getBrName() {
		return brName;
	}
	public void setBrName(String brName) {
		this.brName = brName;
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
	 * @return ����������
	 */
	public String getBrNo() {
	 	return brNo;
	}
	/**
	 * @���� ����������
	 * @param brNo
	 */
	public void setBrNo(String brNo) {
	 	this.brNo = brNo;
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
	 * @return ��ͬ���
	 */
	public String getPactNo() {
	 	return pactNo;
	}
	/**
	 * @���� ��ͬ���
	 * @param pactNo
	 */
	public void setPactNo(String pactNo) {
	 	this.pactNo = pactNo;
	}
	/**
	 * @return �ͻ���
	 */
	public String getCifNo() {
	 	return cifNo;
	}
	/**
	 * @���� �ͻ���
	 * @param cifNo
	 */
	public void setCifNo(String cifNo) {
	 	this.cifNo = cifNo;
	}
	/**
	 * @return �ͻ�����
	 */
	public String getCifName() {
	 	return cifName;
	}
	/**
	 * @���� �ͻ�����
	 * @param cifName
	 */
	public void setCifName(String cifName) {
	 	this.cifName = cifName;
	}
	/**
	 * @return ��Ʒ��
	 */
	public String getPrdtNo() {
	 	return prdtNo;
	}
	/**
	 * @���� ��Ʒ��
	 * @param prdtNo
	 */
	public void setPrdtNo(String prdtNo) {
	 	this.prdtNo = prdtNo;
	}
	/**
	 * @return ��ͬ���
	 */
	public Double getPactAmt() {
	 	return pactAmt;
	}
	/**
	 * @���� ��ͬ���
	 * @param pactAmt
	 */
	public void setPactAmt(Double pactAmt) {
	 	this.pactAmt = pactAmt;
	}
	/**
	 * @return ��ͬ���/���˽��
	 */
	public Double getBal() {
	 	return bal;
	}
	/**
	 * @���� ��ͬ���/���˽��
	 * @param bal
	 */
	public void setBal(Double bal) {
	 	this.bal = bal;
	}
	/**
	 * @return ǷϢ
	 */
	public Double getIntst() {
	 	return intst;
	}
	/**
	 * @���� ǷϢ
	 * @param intst
	 */
	public void setIntst(Double intst) {
	 	this.intst = intst;
	}
	/**
	 * @return ��ʼ����/��������
	 */
	public String getBegDate() {
	 	return begDate;
	}
	/**
	 * @���� ��ʼ����/��������
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
	 * @return ����ҵ��ID/ѺƷID
	 */
	public String getRelId() {
	 	return relId;
	}
	/**
	 * @���� ����ҵ��ID/ѺƷID
	 * @param relId
	 */
	public void setRelId(String relId) {
	 	this.relId = relId;
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
	public String getPrdtName() {
		return prdtName;
	}
	public void setPrdtName(String prdtName) {
		this.prdtName = prdtName;
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
	/**
	 * @return the collWay
	 */
	public String getCollWay() {
		return collWay;
	}
	/**
	 * @param collWay the collWay to set
	 */
	public void setCollWay(String collWay) {
		this.collWay = collWay;
	}

	/**
	 * @return the lastDate
	 */
	public String getLastDate() {
		return lastDate;
	}
	/**
	 * @param lastDate the lastDate to set
	 */
	public void setLastDate(String lastDate) {
		this.lastDate = lastDate;
	}
	/**
	 * @return the collResult
	 */
	public String getCollResult() {
		return collResult;
	}
	/**
	 * @param collResult the collResult to set
	 */
	public void setCollResult(String collResult) {
		this.collResult = collResult;
	}
	/**
	 * @return the backId
	 */
	public String getBackId() {
		return backId;
	}
	/**
	 * @param backId the backId to set
	 */
	public void setBackId(String backId) {
		this.backId = backId;
	}
}