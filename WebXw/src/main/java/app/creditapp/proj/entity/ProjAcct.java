package app.creditapp.proj.entity;
import app.base.BaseDomain;
/**
* Title: ProjAcct.java
* Description:
* @version��1.0
**/
public class ProjAcct extends BaseDomain {
	private String upOpno;//�޸���Ա
	private String upOpname;//�޸���Ա����
	private String upDate;//�޸�����
	private String txDate;//�Ǽ�����
	private String opNo;//����Ա
	private String opName;//����Ա����
	private String deptNo;//�Ǽǲ���
	private String filler;//��ע
	private String acctDesc;//�˻�˵��
	private String cardNo;//���������˺�[�����˻���Ҫ��д]
	private String acctUse;//�˻���;[01-���Ŵ���02������03���շ���]
	private Double acctBal;//�˻����
	private String opnBank;//�˻�������
	private String acctName;//�˻�����
	private String acctType;//�˻�����[01-ר��02-���⻧-03�鼯��]
	private String acctNo;//��hu��
	private String acctId;//�˺�ID[����]
	private String projName;//��Ŀ����
	private String projNo;//��Ŀ���[���]
	private String cardSts;//�˻�״̬[01��Ч02ʧЧ]
	private String cardName;//�������˻�����

	private String orgNo;//�̻���
	private String cardChn;//C�����˻�������[]  channelNo
	private String bankProv;//������������ʡ
	private String bankCity;//��������������
	private String query;
	
	//���
	private String sendSts;
	private String projId;//��Ŀ���[���]
	private String loginid;//�޸���Ա
	private String taCity;//��ͨ�����˺�������
	private String sellFlag;//�����ʶSETT_FLAG
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
	 * @return �˻�˵��
	 */
	public String getAcctDesc() {
	 	return acctDesc;
	}
	/**
	 * @���� �˻�˵��
	 * @param acctDesc
	 */
	public void setAcctDesc(String acctDesc) {
	 	this.acctDesc = acctDesc;
	}
	/**
	 * @return ���������˺�[�����˻���Ҫ��д]
	 */
	public String getCardNo() {
	 	return cardNo;
	}
	/**
	 * @���� ���������˺�[�����˻���Ҫ��д]
	 * @param cardNo
	 */
	public void setCardNo(String cardNo) {
	 	this.cardNo = cardNo;
	}
	/**
	 * @return �˻���;[01-���Ŵ���02������03���շ���]
	 */
	public String getAcctUse() {
	 	return acctUse;
	}
	/**
	 * @���� �˻���;[01-���Ŵ���02������03���շ���]
	 * @param acctUse
	 */
	public void setAcctUse(String acctUse) {
	 	this.acctUse = acctUse;
	}
	/**
	 * @return �˻����
	 */
	public Double getAcctBal() {
	 	return acctBal;
	}
	/**
	 * @���� �˻����
	 * @param acctBal
	 */
	public void setAcctBal(Double acctBal) {
	 	this.acctBal = acctBal;
	}
	/**
	 * @return �˻�������
	 */
	public String getOpnBank() {
	 	return opnBank;
	}
	/**
	 * @���� �˻�������
	 * @param opnBank
	 */
	public void setOpnBank(String opnBank) {
	 	this.opnBank = opnBank;
	}
	/**
	 * @return �˻�����
	 */
	public String getAcctName() {
	 	return acctName;
	}
	/**
	 * @���� �˻�����
	 * @param acctName
	 */
	public void setAcctName(String acctName) {
	 	this.acctName = acctName;
	}
	/**
	 * @return �˻�����[01-ר��02-���⻧-03�鼯��]
	 */
	public String getAcctType() {
	 	return acctType;
	}
	/**
	 * @���� �˻�����[01-ר��02-���⻧-03�鼯��]
	 * @param acctType
	 */
	public void setAcctType(String acctType) {
	 	this.acctType = acctType;
	}
	/**
	 * @return �˺�
	 */
	public String getAcctNo() {
	 	return acctNo;
	}
	/**
	 * @���� �˺�
	 * @param acctNo
	 */
	public void setAcctNo(String acctNo) {
	 	this.acctNo = acctNo;
	}
	/**
	 * @return �˺�ID[����]
	 */
	public String getAcctId() {
	 	return acctId;
	}
	/**
	 * @���� �˺�ID[����]
	 * @param acctId
	 */
	public void setAcctId(String acctId) {
	 	this.acctId = acctId;
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
	 * @return ��Ŀ���[���]
	 */
	public String getProjNo() {
	 	return projNo;
	}
	/**
	 * @���� ��Ŀ���[���]
	 * @param projNo
	 */
	public void setProjNo(String projNo) {
	 	this.projNo = projNo;
	}
	public String getCardSts() {
		return cardSts;
	}
	public void setCardSts(String cardSts) {
		this.cardSts = cardSts;
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
	public void setOrgNo(String orgNo) {
		this.orgNo = orgNo;
	}
	public String getOrgNo() {
		return orgNo;
	}
	public String getBankProv() {
		return bankProv;
	}
	public void setBankProv(String bankProv) {
		this.bankProv = bankProv;
	}
	public String getBankCity() {
		return bankCity;
	}
	public void setBankCity(String bankCity) {
		this.bankCity = bankCity;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public String getCardChn() {
		return cardChn;
	}
	public void setCardChn(String cardChn) {
		this.cardChn = cardChn;
	}
	public String getLoginid() {
		return loginid;
	}
	public void setLoginid(String loginid) {
		this.loginid = loginid;
	}
	public String getProjId() {
		return projId;
	}
	public void setProjId(String projId) {
		this.projId = projId;
	}
	public String getSendSts() {
		return sendSts;
	}
	public void setSendSts(String sendSts) {
		this.sendSts = sendSts;
	}
	public String getCardName() {
		return cardName;
	}
	public void setCardName(String cardName) {
		this.cardName = cardName;
	}
	public String getTaCity() {
		return taCity;
	}
	public void setTaCity(String taCity) {
		this.taCity = taCity;
	}
	public String getSellFlag() {
		return sellFlag;
	}
	public void setSellFlag(String sellFlag) {
		this.sellFlag = sellFlag;
	}
	
	
}