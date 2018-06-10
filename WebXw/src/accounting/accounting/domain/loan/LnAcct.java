package accounting.domain.loan;
import app.base.BaseDomain;
/**
* Title: AcLnAcct.java
* Description:
* @���� su
* @���� 2018-3-20
* @version��1.0
**/
public class LnAcct extends accounting.domain.sys.CMISDomain {
	private String appId;//����ID
	private String cifNo;//�ͻ���
	private String acUse;//�˻���;[1�ۿ��˻�2�ſ��˻�]
	private Double acAmt;//�ſ���
	private String acType;//�˻�����[11�����˻�12��ҵ�˻�]
	private String acNo;//�˻�����
	private String acName;//�˻�����
	private String bankCode;//�������д���
	private String bankProv;//������������ʡ
	private String bankCity;//��������������
	private String bankSite;//������������
	
	private String idType;//֤������
	private String idNo;//֤������
	private String phoneNo;//�ֻ�����
	private String validDate;//���ÿ���Ч��
	private String cvvNo;//���п�CVV2��

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
	public String getIdType() {
		return idType;
	}
	public String getIdNo() {
		return idNo;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public String getValidDate() {
		return validDate;
	}
	public String getCvvNo() {
		return cvvNo;
	}
	public void setIdType(String idType) {
		this.idType = idType;
	}
	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public void setValidDate(String validDate) {
		this.validDate = validDate;
	}
	public void setCvvNo(String cvvNo) {
		this.cvvNo = cvvNo;
	}
}