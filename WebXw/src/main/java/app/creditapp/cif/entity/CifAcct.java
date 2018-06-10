package app.creditapp.cif.entity;
import app.base.BaseDomain;
/**
* Title: CifAcct.java
* Description:
* @version��1.0
**/
public class CifAcct extends BaseDomain {
	private String appId;//����ID
	private String cifNo;//�ͻ�����
	private String acNo;//�˻�����
	private String acName;//�˻���
	private String acType;//�˻�����
	private String acUse;//ʹ������[01����02����]
	private String opnCode;//�������д���
	private String opnNo;//�������к���
	private String opnName;//������������
	private String opnProv;//������������ʡ
	private String opnCity;//��������������
	private String acSts;//�˻�״̬[01����02ע��03��ʧ]

	private String idType;   //�˻�����
	private String idNo;   //�˻�����
	private String phoneNo;   //�˻�����
	private String validDate; //��ͬ��
	private String cvvNo; //��ͬ��
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
	 * @return �ͻ�����
	 */
	public String getCifNo() {
	 	return cifNo;
	}
	/**
	 * @���� �ͻ�����
	 * @param cifNo
	 */
	public void setCifNo(String cifNo) {
	 	this.cifNo = cifNo;
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
	 * @return �˻���
	 */
	public String getAcName() {
	 	return acName;
	}
	/**
	 * @���� �˻���
	 * @param acName
	 */
	public void setAcName(String acName) {
	 	this.acName = acName;
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
	/**
	 * @return ʹ������[01����02����]
	 */
	public String getAcUse() {
	 	return acUse;
	}
	/**
	 * @���� ʹ������[01����02����]
	 * @param acUse
	 */
	public void setAcUse(String acUse) {
	 	this.acUse = acUse;
	}
	/**
	 * @return �������д���
	 */
	public String getOpnCode() {
	 	return opnCode;
	}
	/**
	 * @���� �������д���
	 * @param opnCode
	 */
	public void setOpnCode(String opnCode) {
	 	this.opnCode = opnCode;
	}
	/**
	 * @return �������к���
	 */
	public String getOpnNo() {
	 	return opnNo;
	}
	/**
	 * @���� �������к���
	 * @param opnNo
	 */
	public void setOpnNo(String opnNo) {
	 	this.opnNo = opnNo;
	}
	/**
	 * @return ������������
	 */
	public String getOpnName() {
	 	return opnName;
	}
	/**
	 * @���� ������������
	 * @param opnName
	 */
	public void setOpnName(String opnName) {
	 	this.opnName = opnName;
	}
	/**
	 * @return ������������ʡ
	 */
	public String getOpnProv() {
	 	return opnProv;
	}
	/**
	 * @���� ������������ʡ
	 * @param opnProv
	 */
	public void setOpnProv(String opnProv) {
	 	this.opnProv = opnProv;
	}
	/**
	 * @return ��������������
	 */
	public String getOpnCity() {
	 	return opnCity;
	}
	/**
	 * @���� ��������������
	 * @param opnCity
	 */
	public void setOpnCity(String opnCity) {
	 	this.opnCity = opnCity;
	}
	/**
	 * @return �˻�״̬[01����02ע��03��ʧ]
	 */
	public String getAcSts() {
	 	return acSts;
	}
	/**
	 * @���� �˻�״̬[01����02ע��03��ʧ]
	 * @param acSts
	 */
	public void setAcSts(String acSts) {
	 	this.acSts = acSts;
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