package app.creditapp.corp.entity;
import app.base.BaseDomain;
/**
* Title: CorpCert.java
* Description:
* @version��1.0
**/
public class CorpCert extends BaseDomain {
	private String regBegDate;//��֤����
	private String certAudOrg;//��֤����
	private String certName;//����֤������
	private String certId;//���ʱ��
	private String brName;//������������
	private String brNo;//�����������
	private String certLev;//���ʵȼ�
	private String regEndDate;//��������
	private String certDesc;//����֤������
	private String certImg;//����֤��ͼƬ
	private String filler;//��ע
	private String certCode;//����֤����
	private String deptNo;//�Ǽǲ���
	private String opNo;//����Ա
	private String opName;//����Ա����
	private String upOpNo;//�����²���Ա
	private String upOpName;//�����²���Ա����
	private String txDate;//�Ǽ�����
	private String upDate;//��������

	/**
	 * @return ��֤����
	 */
	public String getRegBegDate() {
	 	return regBegDate;
	}
	/**
	 * @���� ��֤����
	 * @param regBegDate
	 */
	public void setRegBegDate(String regBegDate) {
	 	this.regBegDate = regBegDate;
	}
	/**
	 * @return ��֤����
	 */
	public String getCertAudOrg() {
	 	return certAudOrg;
	}
	/**
	 * @���� ��֤����
	 * @param certAudOrg
	 */
	public void setCertAudOrg(String certAudOrg) {
	 	this.certAudOrg = certAudOrg;
	}
	/**
	 * @return ����֤������
	 */
	public String getCertName() {
	 	return certName;
	}
	/**
	 * @���� ����֤������
	 * @param certName
	 */
	public void setCertName(String certName) {
	 	this.certName = certName;
	}
	/**
	 * @return ���ʱ��
	 */
	public String getCertId() {
	 	return certId;
	}
	/**
	 * @���� ���ʱ��
	 * @param certId
	 */
	public void setCertId(String certId) {
	 	this.certId = certId;
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
	/**
	 * @return ���ʵȼ�
	 */
	public String getCertLev() {
	 	return certLev;
	}
	/**
	 * @���� ���ʵȼ�
	 * @param certLev
	 */
	public void setCertLev(String certLev) {
	 	this.certLev = certLev;
	}
	/**
	 * @return ��������
	 */
	public String getRegEndDate() {
	 	return regEndDate;
	}
	/**
	 * @���� ��������
	 * @param regEndDate
	 */
	public void setRegEndDate(String regEndDate) {
	 	this.regEndDate = regEndDate;
	}
	/**
	 * @return ����֤������
	 */
	public String getCertDesc() {
	 	return certDesc;
	}
	/**
	 * @���� ����֤������
	 * @param certDesc
	 */
	public void setCertDesc(String certDesc) {
	 	this.certDesc = certDesc;
	}
	/**
	 * @return ����֤��ͼƬ
	 */
	public String getCertImg() {
	 	return certImg;
	}
	/**
	 * @���� ����֤��ͼƬ
	 * @param certImg
	 */
	public void setCertImg(String certImg) {
	 	this.certImg = certImg;
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
	 * @return ����֤����
	 */
	public String getCertCode() {
	 	return certCode;
	}
	/**
	 * @���� ����֤����
	 * @param certCode
	 */
	public void setCertCode(String certCode) {
	 	this.certCode = certCode;
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
	 * @return �����²���Ա
	 */
	public String getUpOpNo() {
	 	return upOpNo;
	}
	/**
	 * @���� �����²���Ա
	 * @param upOpNo
	 */
	public void setUpOpNo(String upOpNo) {
	 	this.upOpNo = upOpNo;
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
	public String getOpName() {
		return opName;
	}
	public void setOpName(String opName) {
		this.opName = opName;
	}
	public String getUpOpName() {
		return upOpName;
	}
	public void setUpOpName(String upOpName) {
		this.upOpName = upOpName;
	}
}