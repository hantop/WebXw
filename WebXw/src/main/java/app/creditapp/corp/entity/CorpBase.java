package app.creditapp.corp.entity;
import app.base.BaseDomain;
/**
* Title: CorpBase.java
* Description:
* @version��1.0
**/
public class CorpBase extends BaseDomain {
	private String orgTerm;//��֯��������֤��Ч����
	private String brNo;//�����������
	private String brName;//������������
	private String brType;//"������������[01С����˾02������˾03�䵱��˾04���ѽ��ڹ�˾]"
	private String setupDate;//����ʱ��
	private String areaName;//��������
	private String cifArea;//������������
	private String license;//Ӫҵִ�պ�
	private String licBegDate;//Ӫҵִ�յǼ�ע��ʱ��
	private String licEndDate;//Ӫҵִ�յ���ʱ��
	private String regAddr;//Ӫҵִ��ע���ַ
	private String regArea;//��ҵע���ַ��������
	private String locTaxNo;//��˰�Ǽ�֤����
	private String cenTaxNo;//��˰�Ǽ�֤����
	private String orgNo;//��֯��������
	private String screditNo;//������ô���֤
	private String cardNo;//����֤��[�������]
	private String ifLnuse;//�Ƿ�������÷�[0��1��]
	private Double totalAssets;//��ҵ���ʲ�
	private Double totalDebts;//��ҵ�ܸ�ծ
	private Double regFund;//ע���ʱ�
	private Double factFund;//ʵ���ʱ�
	private String corpType;//��ҵ����[01-������ҵ02-������ҵ03-С����ҵ04-΢С����ҵ05-��ҵ��λ06-ȫ������]
	private String runMan;//��Ӫ�����
	private String mainBus;//��Ӫҵ�����
	private String comAddr;//Ӫҵ��ַ
	private String postCode;//��������
	private String partner;//���ƹɶ�/ʵ�ʿ�����
	private String outGrade;//����������������[�ⲿ����]
	private String inGrade;//������������[����]
	private String brSts;//����ͣ�ñ�־[00-ͣ�� 01-����]
	private String filler;//��ע
	private String deptNo;//�Ǽǲ���
	private String opNo;//����Ա��
	private String opName;//����Ա
	private String txDate;//�Ǽ�����
	private String upDate;//�޸�����
	private String upOpno;//�޸���Ա
	private String upOpname;//�޸���Ա����
	private String brAccType;//��������[A�ࡢB��]
	private String sts;//��������[A�ࡢB��]
	private String stateSts;//�Թ������־[01-���� 02-�Թ�]
	private String loginid;//��¼��Ա

	public String getBrAccType() {
		return brAccType;
	}
	public void setBrAccType(String brAccType) {
		this.brAccType = brAccType;
	}
	/**
	 * @return ��֯��������֤��Ч����
	 */
	public String getBrNo() {
	 	return brNo;
	}
	public String getOrgTerm() {
		return orgTerm;
	}

	/**
	 * @return �����������
	 */
	public void setOrgTerm(String orgTerm) {
		this.orgTerm = orgTerm;
	}
	/**
	 * @���� �����������
	 * @param brNo
	 */
	public void setBrNo(String brNo) {
	 	this.brNo = brNo;
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
	 * @return "������������[01С����˾02������˾03�䵱��˾04���ѽ��ڹ�˾]"
	 */
	public String getBrType() {
	 	return brType;
	}
	/**
	 * @���� "������������[01С����˾02������˾03�䵱��˾04���ѽ��ڹ�˾]"
	 * @param brType
	 */
	public void setBrType(String brType) {
	 	this.brType = brType;
	}
	/**
	 * @return ����ʱ��
	 */
	public String getSetupDate() {
	 	return setupDate;
	}
	/**
	 * @���� ����ʱ��
	 * @param setupDate
	 */
	public void setSetupDate(String setupDate) {
	 	this.setupDate = setupDate;
	}
	/**
	 * @return ��������
	 */
	public String getAreaName() {
	 	return areaName;
	}
	/**
	 * @���� ��������
	 * @param areaName
	 */
	public void setAreaName(String areaName) {
	 	this.areaName = areaName;
	}
	/**
	 * @return ������������
	 */
	public String getCifArea() {
	 	return cifArea;
	}
	/**
	 * @���� ������������
	 * @param cifArea
	 */
	public void setCifArea(String cifArea) {
	 	this.cifArea = cifArea;
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
	 * @return Ӫҵִ�յǼ�ע��ʱ��
	 */
	public String getLicBegDate() {
	 	return licBegDate;
	}
	/**
	 * @���� Ӫҵִ�յǼ�ע��ʱ��
	 * @param licBegDate
	 */
	public void setLicBegDate(String licBegDate) {
	 	this.licBegDate = licBegDate;
	}
	/**
	 * @return Ӫҵִ�յ���ʱ��
	 */
	public String getLicEndDate() {
	 	return licEndDate;
	}
	/**
	 * @���� Ӫҵִ�յ���ʱ��
	 * @param licEndDate
	 */
	public void setLicEndDate(String licEndDate) {
	 	this.licEndDate = licEndDate;
	}
	/**
	 * @return Ӫҵִ��ע���ַ
	 */
	public String getRegAddr() {
	 	return regAddr;
	}
	/**
	 * @���� Ӫҵִ��ע���ַ
	 * @param regAddr
	 */
	public void setRegAddr(String regAddr) {
	 	this.regAddr = regAddr;
	}
	/**
	 * @return ��ҵע���ַ��������
	 */
	public String getRegArea() {
	 	return regArea;
	}
	/**
	 * @���� ��ҵע���ַ��������
	 * @param regArea
	 */
	public void setRegArea(String regArea) {
	 	this.regArea = regArea;
	}
	/**
	 * @return ��˰�Ǽ�֤����
	 */
	public String getLocTaxNo() {
	 	return locTaxNo;
	}
	/**
	 * @���� ��˰�Ǽ�֤����
	 * @param locTaxNo
	 */
	public void setLocTaxNo(String locTaxNo) {
	 	this.locTaxNo = locTaxNo;
	}
	/**
	 * @return ��˰�Ǽ�֤����
	 */
	public String getCenTaxNo() {
	 	return cenTaxNo;
	}
	/**
	 * @���� ��˰�Ǽ�֤����
	 * @param cenTaxNo
	 */
	public void setCenTaxNo(String cenTaxNo) {
	 	this.cenTaxNo = cenTaxNo;
	}
	/**
	 * @return ��֯��������
	 */
	public String getOrgNo() {
	 	return orgNo;
	}
	/**
	 * @���� ��֯��������
	 * @param orgNo
	 */
	public void setOrgNo(String orgNo) {
	 	this.orgNo = orgNo;
	}
	/**
	 * @return ������ô���֤
	 */
	public String getScreditNo() {
	 	return screditNo;
	}
	/**
	 * @���� ������ô���֤
	 * @param screditNo
	 */
	public void setScreditNo(String screditNo) {
	 	this.screditNo = screditNo;
	}
	/**
	 * @return ����֤��[�������]
	 */
	public String getCardNo() {
	 	return cardNo;
	}
	/**
	 * @���� ����֤��[�������]
	 * @param cardNo
	 */
	public void setCardNo(String cardNo) {
	 	this.cardNo = cardNo;
	}
	/**
	 * @return �Ƿ�������÷�[0��1��]
	 */
	public String getIfLnuse() {
	 	return ifLnuse;
	}
	/**
	 * @���� �Ƿ�������÷�[0��1��]
	 * @param sfdkyyf
	 */
	public void setIfLnuse(String ifLnuse) {
	 	this.ifLnuse = ifLnuse;
	}
	/**
	 * @return ��ҵ���ʲ�
	 */
	public Double getTotalAssets() {
	 	return totalAssets;
	}
	/**
	 * @���� ��ҵ���ʲ�
	 * @param totalAssets
	 */
	public void setTotalAssets(Double totalAssets) {
	 	this.totalAssets = totalAssets;
	}
	/**
	 * @return ��ҵ�ܸ�ծ
	 */
	public Double getTotalDebts() {
	 	return totalDebts;
	}
	/**
	 * @���� ��ҵ�ܸ�ծ
	 * @param totalDebts
	 */
	public void setTotalDebts(Double totalDebts) {
	 	this.totalDebts = totalDebts;
	}
	/**
	 * @return ע���ʱ�
	 */
	public Double getRegFund() {
	 	return regFund;
	}
	/**
	 * @���� ע���ʱ�
	 * @param regFund
	 */
	public void setRegFund(Double regFund) {
	 	this.regFund = regFund;
	}
	/**
	 * @return ʵ���ʱ�
	 */
	public Double getFactFund() {
	 	return factFund;
	}
	/**
	 * @���� ʵ���ʱ�
	 * @param factFund
	 */
	public void setFactFund(Double factFund) {
	 	this.factFund = factFund;
	}
	/**
	 * @return ��ҵ����[01-������ҵ02-������ҵ03-С����ҵ04-΢С����ҵ05-��ҵ��λ06-ȫ������]
	 */
	public String getCorpType() {
	 	return corpType;
	}
	/**
	 * @���� ��ҵ����[01-������ҵ02-������ҵ03-С����ҵ04-΢С����ҵ05-��ҵ��λ06-ȫ������]
	 * @param corpType
	 */
	public void setCorpType(String corpType) {
	 	this.corpType = corpType;
	}
	/**
	 * @return ��Ӫ�����
	 */
	public String getRunMan() {
	 	return runMan;
	}
	/**
	 * @���� ��Ӫ�����
	 * @param runMan
	 */
	public void setRunMan(String runMan) {
	 	this.runMan = runMan;
	}
	/**
	 * @return ��Ӫҵ�����
	 */
	public String getMainBus() {
	 	return mainBus;
	}
	/**
	 * @���� ��Ӫҵ�����
	 * @param mainBus
	 */
	public void setMainBus(String mainBus) {
	 	this.mainBus = mainBus;
	}
	/**
	 * @return Ӫҵ��ַ
	 */
	public String getComAddr() {
	 	return comAddr;
	}
	/**
	 * @���� Ӫҵ��ַ
	 * @param comAddr
	 */
	public void setComAddr(String comAddr) {
	 	this.comAddr = comAddr;
	}
	/**
	 * @return ��������
	 */
	public String getPostCode() {
	 	return postCode;
	}
	/**
	 * @���� ��������
	 * @param postCode
	 */
	public void setPostCode(String postCode) {
	 	this.postCode = postCode;
	}
	/**
	 * @return ���ƹɶ�/ʵ�ʿ�����
	 */
	public String getPartner() {
	 	return partner;
	}
	/**
	 * @���� ���ƹɶ�/ʵ�ʿ�����
	 * @param partner
	 */
	public void setPartner(String partner) {
	 	this.partner = partner;
	}
	/**
	 * @return ����������������[�ⲿ����]
	 */
	public String getOutGrade() {
	 	return outGrade;
	}
	/**
	 * @���� ����������������[�ⲿ����]
	 * @param outGrade
	 */
	public void setOutGrade(String outGrade) {
	 	this.outGrade = outGrade;
	}
	/**
	 * @return ������������[����]
	 */
	public String getInGrade() {
	 	return inGrade;
	}
	/**
	 * @���� ������������[����]
	 * @param inGrade
	 */
	public void setInGrade(String inGrade) {
	 	this.inGrade = inGrade;
	}
	/**
	 * @return ����ͣ�ñ�־[00-ͣ�� 01-����]
	 */
	public String getBrSts() {
	 	return brSts;
	}
	/**
	 * @���� ����ͣ�ñ�־[00-ͣ�� 01-����]
	 * @param brSts
	 */
	public void setBrSts(String brSts) {
	 	this.brSts = brSts;
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
	public String getSts() {
		return sts;
	}
	public void setSts(String sts) {
		this.sts = sts;
	}
	/**
	 * @return the stateSts
	 */
	public String getStateSts() {
		return stateSts;
	}
	/**
	 * @param stateSts the stateSts to set
	 */
	public void setStateSts(String stateSts) {
		this.stateSts = stateSts;
	}
	public String getLoginid() {
		return loginid;
	}
	public void setLoginid(String loginid) {
		this.loginid = loginid;
	}
}