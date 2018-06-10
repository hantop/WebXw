package app.creditapp.corp.entity;
import app.base.BaseDomain;
/**
* Title: CorpAcct.java
* Description:
* @version��1.0
**/
public class CorpAcct extends BaseDomain {
	private String upOpno;//�޸���Ա
	private String upOpname;//�޸���Ա����
	private String upDate;//�޸�����
	private String txDate;//�Ǽ�����
	private String opNo;//����Ա
	private String opName;//����Ա����
	private String deptNo;//�Ǽǲ���
	private String filler;//��ע
	private String areaid;//����ID
	private String city;//�������ڵ�����
	private String province;//�������ڵ�ʡ��
	private String exchange;//���к�
	private String orgNo;//������
	private String opnAddr;//�������ڵ�
	private String acName;//�ʻ�����
	private String opnAcno;//�ʻ����
	private String opnBank;//��������
	private String acctId;//�˻���ϢID
	private String brName;//������������
	private String brNo;//�����������
	private String acctUse;//�˻�����
	private String acctBal;//�˻����
	private String sendSts;//�Ƿ񿪻�[01δ����02�ѿ���03--]CARD_STS
	
	private String acType;//�����˻�����
	private String idType;//֤������
	private String idNo;//֤������
	private String phoneNo;//�ֻ�����
	private String validDate;//���ÿ���Ч��
	private String cvvNo;//���п�CVV2��
	private String acctNoJs;//�������п���
	private String acctNameJs;//�������п��˻�����
	
	private String corpAcctType;//ֻ����������ʱ��ֵʹ��
	private String projNo;//ֻ����������ʱ��ֵʹ��
	private String projName;//ֻ����������ʱ��ֵʹ��
	private String projAcNo;//ֻ����Ŀ��ѯ��Ӧ���������˻�ʱʹ��
	private String corpAcctSts;
	
	public String getSendSts() {
		return sendSts;
	}
	public void setSendSts(String sendSts) {
		this.sendSts = sendSts;
	}

	/**
	 * @return �޸���Ա
	 */
	public String getUpOpno() {
	 	return upOpno;
	}
	/**
	 * @���� �޸���Ա
	 * @param upOpno
	 */
	public void setUpOpno(String upOpno) {
	 	this.upOpno = upOpno;
	}
	/**
	 * @return �޸�����
	 */
	public String getUpDate() {
	 	return upDate;
	}
	/**
	 * @���� �޸�����
	 * @param upDate
	 */
	public void setUpDate(String upDate) {
	 	this.upDate = upDate;
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
	 * @return �Ǽǲ���
	 */
	public String getDeptNo() {
	 	return deptNo;
	}
	/**
	 * @���� �Ǽǲ���
	 * @param deptNo
	 */
	public void setDeptNo(String deptNo) {
	 	this.deptNo = deptNo;
	}
	/**
	 * @return ��ע
	 */
	public String getFiller() {
	 	return filler;
	}
	/**
	 * @���� ��ע
	 * @param filler
	 */
	public void setFiller(String filler) {
	 	this.filler = filler;
	}
	/**
	 * @return ����ID
	 */
	public String getAreaid() {
	 	return areaid;
	}
	/**
	 * @���� ����ID
	 * @param areaid
	 */
	public void setAreaid(String areaid) {
	 	this.areaid = areaid;
	}
	/**
	 * @return �������ڵ�����
	 */
	public String getCity() {
	 	return city;
	}
	/**
	 * @���� �������ڵ�����
	 * @param city
	 */
	public void setCity(String city) {
	 	this.city = city;
	}
	/**
	 * @return �������ڵ�ʡ��
	 */
	public String getProvince() {
	 	return province;
	}
	/**
	 * @���� �������ڵ�ʡ��
	 * @param province
	 */
	public void setProvince(String province) {
	 	this.province = province;
	}
	/**
	 * @return ���к�
	 */
	public String getExchange() {
	 	return exchange;
	}
	/**
	 * @���� ���к�
	 * @param exchange
	 */
	public void setExchange(String exchange) {
	 	this.exchange = exchange;
	}
	/**
	 * @return ������
	 */
	public String getOrgNo() {
	 	return orgNo;
	}
	/**
	 * @���� ������
	 * @param orgNo
	 */
	public void setOrgNo(String orgNo) {
	 	this.orgNo = orgNo;
	}
	/**
	 * @return �������ڵ�
	 */
	public String getOpnAddr() {
	 	return opnAddr;
	}
	/**
	 * @���� �������ڵ�
	 * @param opnAddr
	 */
	public void setOpnAddr(String opnAddr) {
	 	this.opnAddr = opnAddr;
	}
	/**
	 * @return �ʻ�����
	 */
	public String getAcName() {
	 	return acName;
	}
	/**
	 * @���� �ʻ�����
	 * @param acName
	 */
	public void setAcName(String acName) {
	 	this.acName = acName;
	}
	/**
	 * @return �ʻ����
	 */
	public String getOpnAcno() {
	 	return opnAcno;
	}
	/**
	 * @���� �ʻ����
	 * @param opnAcno
	 */
	public void setOpnAcno(String opnAcno) {
	 	this.opnAcno = opnAcno;
	}
	/**
	 * @return ��������
	 */
	public String getOpnBank() {
	 	return opnBank;
	}
	/**
	 * @���� ��������
	 * @param opnBank
	 */
	public void setOpnBank(String opnBank) {
	 	this.opnBank = opnBank;
	}
	/**
	 * @return �˻���ϢID
	 */
	public String getAcctId() {
	 	return acctId;
	}
	/**
	 * @���� �˻���ϢID
	 * @param acctId
	 */
	public void setAcctId(String acctId) {
	 	this.acctId = acctId;
	}
	/**
	 * @return ������������
	 */
	public String getBrName() {
	 	return brName;
	}
	/**
	 * @���� ������������
	 * @param brName
	 */
	public void setBrName(String brName) {
	 	this.brName = brName;
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
	public String getUpOpname() {
		return upOpname;
	}
	public void setUpOpname(String upOpname) {
		this.upOpname = upOpname;
	}
	public String getOpName() {
		return opName;
	}
	public void setOpName(String opName) {
		this.opName = opName;
	}
	public String getAcctUse() {
		return acctUse;
	}
	public void setAcctUse(String acctUse) {
		this.acctUse = acctUse;
	}
	/**
	 * @return the acctBal
	 */
	public String getAcctBal() {
		return acctBal;
	}
	/**
	 * @param acctBal the acctBal to set
	 */
	public void setAcctBal(String acctBal) {
		this.acctBal = acctBal;
	}
	/**
	 * @return the corpAcctType
	 */
	public String getCorpAcctType() {
		return corpAcctType;
	}
	/**
	 * @param corpAcctType the corpAcctType to set
	 */
	public void setCorpAcctType(String corpAcctType) {
		this.corpAcctType = corpAcctType;
	}
	/**
	 * @return the projNo
	 */
	public String getProjNo() {
		return projNo;
	}
	/**
	 * @param projNo the projNo to set
	 */
	public void setProjNo(String projNo) {
		this.projNo = projNo;
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
	 * @return the projAcNo
	 */
	public String getProjAcNo() {
		return projAcNo;
	}
	/**
	 * @param projAcNo the projAcNo to set
	 */
	public void setProjAcNo(String projAcNo) {
		this.projAcNo = projAcNo;
	}
	/**
	 * @return the corpAcctSts
	 */
	public String getCorpAcctSts() {
		return corpAcctSts;
	}
	/**
	 * @param corpAcctSts the corpAcctSts to set
	 */
	public void setCorpAcctSts(String corpAcctSts) {
		this.corpAcctSts = corpAcctSts;
	}
	/**
	 * @return the acType
	 */
	public String getAcType() {
		return acType;
	}
	/**
	 * @param acType the acType to set
	 */
	public void setAcType(String acType) {
		this.acType = acType;
	}
	/**
	 * @return the idType
	 */
	public String getIdType() {
		return idType;
	}
	/**
	 * @param idType the idType to set
	 */
	public void setIdType(String idType) {
		this.idType = idType;
	}
	/**
	 * @return the idNo
	 */
	public String getIdNo() {
		return idNo;
	}
	/**
	 * @param idNo the idNo to set
	 */
	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}
	/**
	 * @return the phoneNo
	 */
	public String getPhoneNo() {
		return phoneNo;
	}
	/**
	 * @param phoneNo the phoneNo to set
	 */
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	/**
	 * @return the validDate
	 */
	public String getValidDate() {
		return validDate;
	}
	/**
	 * @param validDate the validDate to set
	 */
	public void setValidDate(String validDate) {
		this.validDate = validDate;
	}
	/**
	 * @return the cvvNo
	 */
	public String getCvvNo() {
		return cvvNo;
	}
	/**
	 * @param cvvNo the cvvNo to set
	 */
	public void setCvvNo(String cvvNo) {
		this.cvvNo = cvvNo;
	}
	/**
	 * @return the acctNoJs
	 */
	public String getAcctNoJs() {
		return acctNoJs;
	}
	/**
	 * @param acctNoJs the acctNoJs to set
	 */
	public void setAcctNoJs(String acctNoJs) {
		this.acctNoJs = acctNoJs;
	}
	/**
	 * @return the acctNameJs
	 */
	public String getAcctNameJs() {
		return acctNameJs;
	}
	/**
	 * @param acctNameJs the acctNameJs to set
	 */
	public void setAcctNameJs(String acctNameJs) {
		this.acctNameJs = acctNameJs;
	}
	
}