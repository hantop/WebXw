package app.creditapp.corp.entity;
import app.base.BaseDomain;
/**
* Title: CorpGdinfo.java
* Description:
* @version��1.0
**/
public class CorpGdinfo extends BaseDomain {
	private Double invAmt;//����ܽ��
	private String curNo;//����
	private String gdName;//�ɶ�����
	private String gdId;//�ɶ���ϢID
	private String brName;//������������
	private String brNo;//�����������
	private String gdType;//�ɶ�����[01����02��Ȼ��]
	private String stkcNo;//��Ȩ֤���
	private String gdIdType;//�ɶ�֤������
	private String gdIdNo;//֤���ţ����֤����֯�����������ͳһ������ô���֤��
	private String invDate;//�������
	private Double cashAmt;//�ֽ���
	private Double objAmt;//ʵ����
	private Double invRate;//�ɶ��ֹɱ���
	private String credNo;//�������
	private String license;//Ӫҵִ�պ�
	private String ctlFlag;//ʵ�ʿ�����/��һ��ɶ���־
	private String phone;//��ϵ�绰
	private String address;//ͨѶ��ַ
	private String filer;//��ע
	private String deptNo;//�Ǽǲ���
	private String opNo;//����Ա
	private String opName;//����Ա����
	private String txDate;//�Ǽ�����
	private String upDate;//�޸�����
	private String upOpno;//�޸���Ա
	private String upOpname;//�޸���Ա����

	/**
	 * @return ����ܽ��
	 */
	public Double getInvAmt() {
	 	return invAmt;
	}
	/**
	 * @���� ����ܽ��
	 * @param invAmt
	 */
	public void setInvAmt(Double invAmt) {
	 	this.invAmt = invAmt;
	}
	/**
	 * @return ����
	 */
	public String getCurNo() {
	 	return curNo;
	}
	/**
	 * @���� ����
	 * @param curNo
	 */
	public void setCurNo(String curNo) {
	 	this.curNo = curNo;
	}
	/**
	 * @return �ɶ�����
	 */
	public String getGdName() {
	 	return gdName;
	}
	/**
	 * @���� �ɶ�����
	 * @param gdName
	 */
	public void setGdName(String gdName) {
	 	this.gdName = gdName;
	}
	/**
	 * @return �ɶ���ϢID
	 */
	public String getGdId() {
	 	return gdId;
	}
	/**
	 * @���� �ɶ���ϢID
	 * @param gdId
	 */
	public void setGdId(String gdId) {
	 	this.gdId = gdId;
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
	 * @return �ɶ�����[01����02��Ȼ��]
	 */
	public String getGdType() {
	 	return gdType;
	}
	/**
	 * @���� �ɶ�����[01����02��Ȼ��]
	 * @param gdType
	 */
	public void setGdType(String gdType) {
	 	this.gdType = gdType;
	}
	/**
	 * @return ��Ȩ֤���
	 */
	public String getStkcNo() {
	 	return stkcNo;
	}
	/**
	 * @���� ��Ȩ֤���
	 * @param stkcNo
	 */
	public void setStkcNo(String stkcNo) {
	 	this.stkcNo = stkcNo;
	}
	/**
	 * @return �ɶ�֤������
	 */
	public String getGdIdType() {
	 	return gdIdType;
	}
	/**
	 * @���� �ɶ�֤������
	 * @param gdIdType
	 */
	public void setGdIdType(String gdIdType) {
	 	this.gdIdType = gdIdType;
	}
	/**
	 * @return ֤���ţ����֤����֯�����������ͳһ������ô���֤��
	 */
	public String getGdIdNo() {
	 	return gdIdNo;
	}
	/**
	 * @���� ֤���ţ����֤����֯�����������ͳһ������ô���֤��
	 * @param gdIdNo
	 */
	public void setGdIdNo(String gdIdNo) {
	 	this.gdIdNo = gdIdNo;
	}
	/**
	 * @return �������
	 */
	public String getInvDate() {
	 	return invDate;
	}
	/**
	 * @���� �������
	 * @param invDate
	 */
	public void setInvDate(String invDate) {
	 	this.invDate = invDate;
	}
	/**
	 * @return �ֽ���
	 */
	public Double getCashAmt() {
	 	return cashAmt;
	}
	/**
	 * @���� �ֽ���
	 * @param cashAmt
	 */
	public void setCashAmt(Double cashAmt) {
	 	this.cashAmt = cashAmt;
	}
	/**
	 * @return ʵ����
	 */
	public Double getObjAmt() {
	 	return objAmt;
	}
	/**
	 * @���� ʵ����
	 * @param objAmt
	 */
	public void setObjAmt(Double objAmt) {
	 	this.objAmt = objAmt;
	}
	/**
	 * @return �ɶ��ֹɱ���
	 */
	public Double getInvRate() {
	 	return invRate;
	}
	/**
	 * @���� �ɶ��ֹɱ���
	 * @param invRate
	 */
	public void setInvRate(Double invRate) {
	 	this.invRate = invRate;
	}
	/**
	 * @return �������
	 */
	public String getCredNo() {
	 	return credNo;
	}
	/**
	 * @���� �������
	 * @param credNo
	 */
	public void setCredNo(String credNo) {
	 	this.credNo = credNo;
	}
	/**
	 * @return Ӫҵִ�պ�
	 */
	public String getLicense() {
	 	return license;
	}
	/**
	 * @���� Ӫҵִ�պ�
	 * @param license
	 */
	public void setLicense(String license) {
	 	this.license = license;
	}
	/**
	 * @return ʵ�ʿ�����/��һ��ɶ���־
	 */
	public String getCtlFlag() {
	 	return ctlFlag;
	}
	/**
	 * @���� ʵ�ʿ�����/��һ��ɶ���־
	 * @param ctlFlag
	 */
	public void setCtlFlag(String ctlFlag) {
	 	this.ctlFlag = ctlFlag;
	}
	/**
	 * @return ��ϵ�绰
	 */
	public String getPhone() {
	 	return phone;
	}
	/**
	 * @���� ��ϵ�绰
	 * @param phone
	 */
	public void setPhone(String phone) {
	 	this.phone = phone;
	}
	/**
	 * @return ͨѶ��ַ
	 */
	public String getAddress() {
	 	return address;
	}
	/**
	 * @���� ͨѶ��ַ
	 * @param address
	 */
	public void setAddress(String address) {
	 	this.address = address;
	}
	/**
	 * @return ��ע
	 */
	public String getFiler() {
	 	return filer;
	}
	/**
	 * @���� ��ע
	 * @param filer
	 */
	public void setFiler(String filer) {
	 	this.filer = filer;
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
	public String getOpName() {
		return opName;
	}
	public void setOpName(String opName) {
		this.opName = opName;
	}
	public String getUpOpname() {
		return upOpname;
	}
	public void setUpOpname(String upOpname) {
		this.upOpname = upOpname;
	}
}