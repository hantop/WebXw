package accounting.domain.ws;
/**
* Title: WsAcnoChg.java
* Description:
* @���� su
* @���� 2018-3-20
* @version��1.0
**/
public class WsAcnoChg extends accounting.domain.sys.CMISDomain {
	private String idType;//֤������
	private String idNo;//֤������
	private String phoneNo;//�ֻ�����
	private String validDate;//���ÿ���Ч����λ����,ǰ��λ Ϊ��ݣ�����λΪ�·�
	private String cvvNo;//���ÿ�ʹ����֤��CVN2(���������롱)
	private String newBanksite;//�¿�������
	private String wsId;//����ID
	private String batchNo;//���α��
	private String brNo;//����������
	private String pactNo;//��ͬ��
	private String acUse;//�˻���;[1�ۿ��˻� 2�ſ��˻�]
	private String newAcno;//�»����˺�
	private String newAcname;//�»����˻���
	private String newAcbankno;//�»����˻������к�
	private String newAcbankname;//�»����˻�����������
	private String chgReason;//���ԭ��
	private String ifAuth;//�Ƿ��пۿ���Ȩ��:1-��0-��
	private String dealSts;//������[01δ����02������03����ɹ�04����ʧ��]
	private String dealDesc;//��������
	private String txDate;//������������
	private String oldAcno;//ԭ�����˺�
	private String acType;//�˻�����

	/**
	 * @return ֤������
	 */
	public String getIdType() {
	 	return idType;
	}
	/**
	 * @���� ֤������
	 * @param idType
	 */
	public void setIdType(String idType) {
	 	this.idType = idType;
	}
	/**
	 * @return ֤������
	 */
	public String getIdNo() {
	 	return idNo;
	}
	/**
	 * @���� ֤������
	 * @param idNo
	 */
	public void setIdNo(String idNo) {
	 	this.idNo = idNo;
	}
	/**
	 * @return �ֻ�����
	 */
	public String getPhoneNo() {
	 	return phoneNo;
	}
	/**
	 * @���� �ֻ�����
	 * @param phoneNo
	 */
	public void setPhoneNo(String phoneNo) {
	 	this.phoneNo = phoneNo;
	}
	/**
	 * @return ���ÿ���Ч����λ����,ǰ��λ Ϊ��ݣ�����λΪ�·�
	 */
	public String getValidDate() {
	 	return validDate;
	}
	/**
	 * @���� ���ÿ���Ч����λ����,ǰ��λ Ϊ��ݣ�����λΪ�·�
	 * @param validDate
	 */
	public void setValidDate(String validDate) {
	 	this.validDate = validDate;
	}
	/**
	 * @return ���ÿ�ʹ����֤��CVN2(���������롱)
	 */
	public String getCvvNo() {
	 	return cvvNo;
	}
	/**
	 * @���� ���ÿ�ʹ����֤��CVN2(���������롱)
	 * @param cvvNo
	 */
	public void setCvvNo(String cvvNo) {
	 	this.cvvNo = cvvNo;
	}
	/**
	 * @return �¿�������
	 */
	public String getNewBanksite() {
	 	return newBanksite;
	}
	/**
	 * @���� �¿�������
	 * @param newBanksite
	 */
	public void setNewBanksite(String newBanksite) {
	 	this.newBanksite = newBanksite;
	}
	/**
	 * @return ����ID
	 */
	public String getWsId() {
	 	return wsId;
	}
	/**
	 * @���� ����ID
	 * @param wsId
	 */
	public void setWsId(String wsId) {
	 	this.wsId = wsId;
	}
	/**
	 * @return ���α��
	 */
	public String getBatchNo() {
	 	return batchNo;
	}
	/**
	 * @���� ���α��
	 * @param batchNo
	 */
	public void setBatchNo(String batchNo) {
	 	this.batchNo = batchNo;
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
	 * @return �˻���;[1�ۿ��˻� 2�ſ��˻�]
	 */
	public String getAcUse() {
	 	return acUse;
	}
	/**
	 * @���� �˻���;[1�ۿ��˻� 2�ſ��˻�]
	 * @param acUse
	 */
	public void setAcUse(String acUse) {
	 	this.acUse = acUse;
	}
	/**
	 * @return �»����˺�
	 */
	public String getNewAcno() {
	 	return newAcno;
	}
	/**
	 * @���� �»����˺�
	 * @param newAcno
	 */
	public void setNewAcno(String newAcno) {
	 	this.newAcno = newAcno;
	}
	/**
	 * @return �»����˻���
	 */
	public String getNewAcname() {
	 	return newAcname;
	}
	/**
	 * @���� �»����˻���
	 * @param newAcname
	 */
	public void setNewAcname(String newAcname) {
	 	this.newAcname = newAcname;
	}
	/**
	 * @return �»����˻������к�
	 */
	public String getNewAcbankno() {
	 	return newAcbankno;
	}
	/**
	 * @���� �»����˻������к�
	 * @param newAcbankno
	 */
	public void setNewAcbankno(String newAcbankno) {
	 	this.newAcbankno = newAcbankno;
	}
	/**
	 * @return �»����˻�����������
	 */
	public String getNewAcbankname() {
	 	return newAcbankname;
	}
	/**
	 * @���� �»����˻�����������
	 * @param newAcbankname
	 */
	public void setNewAcbankname(String newAcbankname) {
	 	this.newAcbankname = newAcbankname;
	}
	/**
	 * @return ���ԭ��
	 */
	public String getChgReason() {
	 	return chgReason;
	}
	/**
	 * @���� ���ԭ��
	 * @param chgReason
	 */
	public void setChgReason(String chgReason) {
	 	this.chgReason = chgReason;
	}
	/**
	 * @return �Ƿ��пۿ���Ȩ��:1-��0-��
	 */
	public String getIfAuth() {
	 	return ifAuth;
	}
	/**
	 * @���� �Ƿ��пۿ���Ȩ��:1-��0-��
	 * @param ifAuth
	 */
	public void setIfAuth(String ifAuth) {
	 	this.ifAuth = ifAuth;
	}
	/**
	 * @return ������[01δ����02������03����ɹ�04����ʧ��]
	 */
	public String getDealSts() {
	 	return dealSts;
	}
	/**
	 * @���� ������[01δ����02������03����ɹ�04����ʧ��]
	 * @param dealSts
	 */
	public void setDealSts(String dealSts) {
	 	this.dealSts = dealSts;
	}
	/**
	 * @return ��������
	 */
	public String getDealDesc() {
	 	return dealDesc;
	}
	/**
	 * @���� ��������
	 * @param dealDesc
	 */
	public void setDealDesc(String dealDesc) {
	 	this.dealDesc = dealDesc;
	}
	/**
	 * @return ������������
	 */
	public String getTxDate() {
	 	return txDate;
	}
	/**
	 * @���� ������������
	 * @param txDate
	 */
	public void setTxDate(String txDate) {
	 	this.txDate = txDate;
	}
	/**
	 * @return ԭ�����˺�
	 */
	public String getOldAcno() {
	 	return oldAcno;
	}
	/**
	 * @���� ԭ�����˺�
	 * @param oldAcno
	 */
	public void setOldAcno(String oldAcno) {
	 	this.oldAcno = oldAcno;
	}
	/**
	 * @return �˻�����
	 */
	public String getAcType() {
	 	return acType;
	}
	/**
	 * @���� �˻�����
	 * @param acType
	 */
	public void setAcType(String acType) {
	 	this.acType = acType;
	}
}