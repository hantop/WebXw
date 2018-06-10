package app.creditapp.ln.entity;
import app.base.BaseDomain;
/**
* Title: LnAcctMid.java
* Description:
* @version��1.0
**/
public class LnAcctMid extends BaseDomain {
	private String bankSite;//������������
	private String bankCity;//��������������
	private String bankProv;//������������ʡ
	private String bankCode;//�������д���
	private String acName;//�˻�����
	private String acNo;//�˻�����
	private String acType;//�˻�����[11�����˻�12��ҵ�˻�]
	private Double acAmt;//�ſ���
	private String acUse;//�˻���;[1�ۿ��˻�2�ſ��˻�]
	private String appId;//����ID
	private String pactNo;//��ͬ��
	private String idType;   //�˻�����
	private String idNo;   //�˻�����
	private String phoneNo;   //�˻�����
	private String validDate; //��ͬ��
	private String cvvNo; //��ͬ��
	
	private String payType;//֧����ʽ

	public String getPactNo() {
		return pactNo;
	}
	public void setPactNo(String pactNo) {
		this.pactNo = pactNo;
	}
	/**
	 * @return ������������
	 */
	public String getBankSite() {
	 	return bankSite;
	}
	/**
	 * @���� ������������
	 * @param bankSite
	 */
	public void setBankSite(String bankSite) {
	 	this.bankSite = bankSite;
	}
	/**
	 * @return ��������������
	 */
	public String getBankCity() {
	 	return bankCity;
	}
	/**
	 * @���� ��������������
	 * @param bankCity
	 */
	public void setBankCity(String bankCity) {
	 	this.bankCity = bankCity;
	}
	/**
	 * @return ������������ʡ
	 */
	public String getBankProv() {
	 	return bankProv;
	}
	/**
	 * @���� ������������ʡ
	 * @param bankProv
	 */
	public void setBankProv(String bankProv) {
	 	this.bankProv = bankProv;
	}
	/**
	 * @return �������д���
	 */
	public String getBankCode() {
	 	return bankCode;
	}
	/**
	 * @���� �������д���
	 * @param bankCode
	 */
	public void setBankCode(String bankCode) {
	 	this.bankCode = bankCode;
	}
	/**
	 * @return �˻�����
	 */
	public String getAcName() {
	 	return acName;
	}
	/**
	 * @���� �˻�����
	 * @param acName
	 */
	public void setAcName(String acName) {
	 	this.acName = acName;
	}
	/**
	 * @return �˻�����
	 */
	public String getAcNo() {
	 	return acNo;
	}
	/**
	 * @���� �˻�����
	 * @param acNo
	 */
	public void setAcNo(String acNo) {
	 	this.acNo = acNo;
	}
	/**
	 * @return �˻�����[11�����˻�12��ҵ�˻�]
	 */
	public String getAcType() {
	 	return acType;
	}
	/**
	 * @���� �˻�����[11�����˻�12��ҵ�˻�]
	 * @param acType
	 */
	public void setAcType(String acType) {
	 	this.acType = acType;
	}
	/**
	 * @return �ſ���
	 */
	public Double getAcAmt() {
	 	return acAmt;
	}
	/**
	 * @���� �ſ���
	 * @param acAmt
	 */
	public void setAcAmt(Double acAmt) {
	 	this.acAmt = acAmt;
	}
	/**
	 * @return �˻���;[1�ۿ��˻�2�ſ��˻�]
	 */
	public String getAcUse() {
	 	return acUse;
	}
	/**
	 * @���� �˻���;[1�ۿ��˻�2�ſ��˻�]
	 * @param acUse
	 */
	public void setAcUse(String acUse) {
	 	this.acUse = acUse;
	}
	/**
	 * @return ����ID
	 */
	public String getAppId() {
	 	return appId;
	}
	/**
	 * @���� ����ID
	 * @param appId
	 */
	public void setAppId(String appId) {
	 	this.appId = appId;
	}
	public String getPayType() {
		return payType;
	}
	public void setPayType(String payType) {
		this.payType = payType;
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
}