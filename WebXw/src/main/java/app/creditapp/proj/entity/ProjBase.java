package app.creditapp.proj.entity;
import app.base.BaseDomain;
/**
* Title: ProjBase.java
* Description:
* @version��1.0
**/
public class ProjBase extends BaseDomain {
	private String projSts;//��Ŀ״̬[01��������02����]
	private String incDisFre;//�������Ƶ��[00:��01:Ѯ02:�¶�03:����04:���05:����һ�θ���06:����]
	private String incDisWay;//������䷽ʽ[00:����01�����ڻ�����Ϣ02:���ڸ�Ϣ03:���ڻ���]
	private Double projAmt;//Ԥ����Ŀ��ģ��Ԫ��
	private String projStr;//��Ŀ�ṹ����[ȡֵ00:�ṹ��01:�ǽṹ��]
	private String projNatu;//��Ŀ����[01:��һ02:����]
	private String brName;//������������
	private String brNo;//�����������
	private String projName;//��Ŀ����
	private String projNo;//��Ŀ���
	private String mpactNo;//����ͬ���
	private String assType;//�ʲ�����[��Ŀ����Ϊ���Ʋ����С��ۺ�����ʱ����]
	private String keepBkno;//�����б���[��Ŀ����Ϊ������ʱ����]
	private String secPayWay;//���ϻ�����ɷ�ʽ[ȡֵ01:���вƲ��е�02:���вƲ��е�03:�������е�04:������]
	private String secRepayWay;//���ϻ��𷵻���ʽ[ȡֵ01:��Ӫ����02:���ϻ��𷵻������]
	private String quitWay;//�˳���ʽ[01:����Ȩת�� ���е��ڷ��� 02����� ����Ȩת�� ���е��ڷ��� 03����]
	private String proFloat;//��������Ȩ�����԰���[01����Ȩת�á����������02����Ȩת�á����е��ڷ���]
	private String infdisWay;//��Ϣ��¶��ʽ[01���й��� 02�ʼ� 03����¶ 04��]
	private String funType;//���ܷ���[01:������02:Ͷ����03:������]
	private float payRate;//���к�ͬԼ�����б�����(%)
	private String payRateDesc;//���к�ͬԼ�����б�����(����)
	private Double othFee;//�����б������������ý��
	private float othRate;//�����껯�����ʣ�%��
	private String prepubBeg;//Ԥ�Ʒ��п�ʼ����
	private String setupDate;//��Ŀ��������
	private String prepubEnd;//Ԥ�Ʒ��н�������
	private String begDate;//��Ŀ��Ч����
	private String setupCond;//��������˵��
	private String endDate;//��ĿԤ�ƽ�������
	private String ifObo;//�Ƿ�ֱʵ���[0-��1-��]
	private Integer projTerm;//��Ŀ����
	private String termUnit;//���޵�λ
	private String termDesc;//����˵��
	private String filler;//��ע
	private String deptNo;//�Ǽǲ���
	private String opNo;//����Ա
	private String opName;//����Ա����
	private String txDate;//�Ǽ�����
	private String upDate;//�޸�����
	private String upOpno;//�޸���Ա
	private String upOpname;//�޸���Ա����
	private String bankAcntNo;//ר���˺�
	
	private String id;//�޸���Ա
	private String managers;//�޸���Ա
	private String loginid;//��¼��Ա
	private String vipFlag;//���
	private String projId;//��ͨ��Ŀ���
	private String brNoSts;
	private String projCode;//��ͨ��Ŀ����
	private String tenantNo;//�⻧��
	/**
	 * @return ��Ŀ״̬[01��������02����]
	 */
	public String getProjSts() {
	 	return projSts;
	}
	/**
	 * @���� ��Ŀ״̬[01��������02����]
	 * @param projSts
	 */
	public void setProjSts(String projSts) {
	 	this.projSts = projSts;
	}
	/**
	 * @return �������Ƶ��[00:��01:Ѯ02:�¶�03:����04:���05:����һ�θ���06:����]
	 */
	public String getIncDisFre() {
	 	return incDisFre;
	}
	/**
	 * @���� �������Ƶ��[00:��01:Ѯ02:�¶�03:����04:���05:����һ�θ���06:����]
	 * @param incDisFre
	 */
	public void setIncDisFre(String incDisFre) {
	 	this.incDisFre = incDisFre;
	}
	/**
	 * @return ������䷽ʽ[00:����01�����ڻ�����Ϣ02:���ڸ�Ϣ03:���ڻ���]
	 */
	public String getIncDisWay() {
	 	return incDisWay;
	}
	/**
	 * @���� ������䷽ʽ[00:����01�����ڻ�����Ϣ02:���ڸ�Ϣ03:���ڻ���]
	 * @param incDisWay
	 */
	public void setIncDisWay(String incDisWay) {
	 	this.incDisWay = incDisWay;
	}
	/**
	 * @return Ԥ����Ŀ��ģ��Ԫ��
	 */
	public Double getProjAmt() {
	 	return projAmt;
	}
	/**
	 * @���� Ԥ����Ŀ��ģ��Ԫ��
	 * @param projAmt
	 */
	public void setProjAmt(Double projAmt) {
	 	this.projAmt = projAmt;
	}
	/**
	 * @return ��Ŀ�ṹ����[ȡֵ00:�ṹ��01:�ǽṹ��]
	 */
	public String getProjStr() {
	 	return projStr;
	}
	/**
	 * @���� ��Ŀ�ṹ����[ȡֵ00:�ṹ��01:�ǽṹ��]
	 * @param projStr
	 */
	public void setProjStr(String projStr) {
	 	this.projStr = projStr;
	}
	/**
	 * @return ��Ŀ����[01:��һ02:����]
	 */
	public String getProjNatu() {
	 	return projNatu;
	}
	/**
	 * @���� ��Ŀ����[01:��һ02:����]
	 * @param projNatu
	 */
	public void setProjNatu(String projNatu) {
	 	this.projNatu = projNatu;
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
	 * @return ����ͬ���
	 */
	public String getMpactNo() {
	 	return mpactNo;
	}
	/**
	 * @���� ����ͬ���
	 * @param mpactNo
	 */
	public void setMpactNo(String mpactNo) {
	 	this.mpactNo = mpactNo;
	}
	/**
	 * @return �ʲ�����[��Ŀ����Ϊ���Ʋ����С��ۺ�����ʱ����]
	 */
	public String getAssType() {
	 	return assType;
	}
	/**
	 * @���� �ʲ�����[��Ŀ����Ϊ���Ʋ����С��ۺ�����ʱ����]
	 * @param assType
	 */
	public void setAssType(String assType) {
	 	this.assType = assType;
	}
	/**
	 * @return �����б���[��Ŀ����Ϊ������ʱ����]
	 */
	public String getKeepBkno() {
	 	return keepBkno;
	}
	/**
	 * @���� �����б���[��Ŀ����Ϊ������ʱ����]
	 * @param keepBkno
	 */
	public void setKeepBkno(String keepBkno) {
	 	this.keepBkno = keepBkno;
	}
	/**
	 * @return ���ϻ�����ɷ�ʽ[ȡֵ01:���вƲ��е�02:���вƲ��е�03:�������е�04:������]
	 */
	public String getSecPayWay() {
	 	return secPayWay;
	}
	/**
	 * @���� ���ϻ�����ɷ�ʽ[ȡֵ01:���вƲ��е�02:���вƲ��е�03:�������е�04:������]
	 * @param secPayWay
	 */
	public void setSecPayWay(String secPayWay) {
	 	this.secPayWay = secPayWay;
	}
	/**
	 * @return ���ϻ��𷵻���ʽ[ȡֵ01:��Ӫ����02:���ϻ��𷵻������]
	 */
	public String getSecRepayWay() {
	 	return secRepayWay;
	}
	/**
	 * @���� ���ϻ��𷵻���ʽ[ȡֵ01:��Ӫ����02:���ϻ��𷵻������]
	 * @param secRepayWay
	 */
	public void setSecRepayWay(String secRepayWay) {
	 	this.secRepayWay = secRepayWay;
	}
	/**
	 * @return �˳���ʽ[01:����Ȩת�� ���е��ڷ��� 02����� ����Ȩת�� ���е��ڷ��� 03����]
	 */
	public String getQuitWay() {
	 	return quitWay;
	}
	/**
	 * @���� �˳���ʽ[01:����Ȩת�� ���е��ڷ��� 02����� ����Ȩת�� ���е��ڷ��� 03����]
	 * @param quitWay
	 */
	public void setQuitWay(String quitWay) {
	 	this.quitWay = quitWay;
	}
	/**
	 * @return ��������Ȩ�����԰���[01����Ȩת�á����������02����Ȩת�á����е��ڷ���]
	 */
	public String getProFloat() {
	 	return proFloat;
	}
	/**
	 * @���� ��������Ȩ�����԰���[01����Ȩת�á����������02����Ȩת�á����е��ڷ���]
	 * @param proFloat
	 */
	public void setProFloat(String proFloat) {
	 	this.proFloat = proFloat;
	}
	/**
	 * @return ��Ϣ��¶��ʽ[01���й��� 02�ʼ� 03����¶ 04��]
	 */
	public String getInfdisWay() {
	 	return infdisWay;
	}
	/**
	 * @���� ��Ϣ��¶��ʽ[01���й��� 02�ʼ� 03����¶ 04��]
	 * @param infdisWay
	 */
	public void setInfdisWay(String infdisWay) {
	 	this.infdisWay = infdisWay;
	}
	/**
	 * @return ���ܷ���[01:������02:Ͷ����03:������]
	 */
	public String getFunType() {
	 	return funType;
	}
	/**
	 * @���� ���ܷ���[01:������02:Ͷ����03:������]
	 * @param funType
	 */
	public void setFunType(String funType) {
	 	this.funType = funType;
	}
	/**
	 * @return ���к�ͬԼ�����б�����(%)
	 */
	public Float getPayRate() {
	 	return payRate;
	}
	/**
	 * @���� ���к�ͬԼ�����б�����(%)
	 * @param payRate
	 */
	public void setPayRate(Float payRate) {
	 	this.payRate = payRate;
	}
	/**
	 * @return ���к�ͬԼ�����б�����(����)
	 */
	public String getPayRateDesc() {
	 	return payRateDesc;
	}
	/**
	 * @���� ���к�ͬԼ�����б�����(����)
	 * @param payRateDesc
	 */
	public void setPayRateDesc(String payRateDesc) {
	 	this.payRateDesc = payRateDesc;
	}
	/**
	 * @return �����б������������ý��
	 */
	public Double getOthFee() {
	 	return othFee;
	}
	/**
	 * @���� �����б������������ý��
	 * @param othFee
	 */
	public void setOthFee(Double othFee) {
	 	this.othFee = othFee;
	}
	/**
	 * @return �����껯�����ʣ�%��
	 */
	public Float getOthRate() {
	 	return othRate;
	}
	/**
	 * @���� �����껯�����ʣ�%��
	 * @param othRate
	 */
	public void setOthRate(Float othRate) {
	 	this.othRate = othRate;
	}
	/**
	 * @return Ԥ�Ʒ��п�ʼ����
	 */
	public String getPrepubBeg() {
	 	return prepubBeg;
	}
	/**
	 * @���� Ԥ�Ʒ��п�ʼ����
	 * @param prepubBeg
	 */
	public void setPrepubBeg(String prepubBeg) {
	 	this.prepubBeg = prepubBeg;
	}
	/**
	 * @return ��Ŀ��������
	 */
	public String getSetupDate() {
	 	return setupDate;
	}
	/**
	 * @���� ��Ŀ��������
	 * @param setupDate
	 */
	public void setSetupDate(String setupDate) {
	 	this.setupDate = setupDate;
	}
	/**
	 * @return Ԥ�Ʒ��н�������
	 */
	public String getPrepubEnd() {
	 	return prepubEnd;
	}
	/**
	 * @���� Ԥ�Ʒ��н�������
	 * @param prepubEnd
	 */
	public void setPrepubEnd(String prepubEnd) {
	 	this.prepubEnd = prepubEnd;
	}
	/**
	 * @return ��Ŀ��Ч����
	 */
	public String getBegDate() {
	 	return begDate;
	}
	/**
	 * @���� ��Ŀ��Ч����
	 * @param begDate
	 */
	public void setBegDate(String begDate) {
	 	this.begDate = begDate;
	}
	/**
	 * @return ��������˵��
	 */
	public String getSetupCond() {
	 	return setupCond;
	}
	/**
	 * @���� ��������˵��
	 * @param setupCond
	 */
	public void setSetupCond(String setupCond) {
	 	this.setupCond = setupCond;
	}
	/**
	 * @return ��ĿԤ�ƽ�������
	 */
	public String getEndDate() {
	 	return endDate;
	}
	/**
	 * @���� ��ĿԤ�ƽ�������
	 * @param endDate
	 */
	public void setEndDate(String endDate) {
	 	this.endDate = endDate;
	}
	/**
	 * @return �Ƿ�ֱʵ���[0-��1-��]
	 */
	public String getIfObo() {
	 	return ifObo;
	}
	/**
	 * @���� �Ƿ�ֱʵ���[0-��1-��]
	 * @param ifObo
	 */
	public void setIfObo(String ifObo) {
	 	this.ifObo = ifObo;
	}
	/**
	 * @return ��Ŀ����
	 */
	public Integer getProjTerm() {
	 	return projTerm;
	}
	/**
	 * @���� ��Ŀ����
	 * @param projTerm
	 */
	public void setProjTerm(Integer projTerm) {
	 	this.projTerm = projTerm;
	}
	/**
	 * @return ���޵�λ
	 */
	public String getTermUnit() {
	 	return termUnit;
	}
	/**
	 * @���� ���޵�λ
	 * @param termUnit
	 */
	public void setTermUnit(String termUnit) {
	 	this.termUnit = termUnit;
	}
	/**
	 * @return ����˵��
	 */
	public String getTermDesc() {
	 	return termDesc;
	}
	/**
	 * @���� ����˵��
	 * @param termDesc
	 */
	public void setTermDesc(String termDesc) {
	 	this.termDesc = termDesc;
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
	public void setPayRate(float payRate) {
		this.payRate = payRate;
	}
	public void setOthRate(float othRate) {
		this.othRate = othRate;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getManagers() {
		return managers;
	}
	public void setManagers(String managers) {
		this.managers = managers;
	}
	public String getLoginid() {
		return loginid;
	}
	public void setLoginid(String loginid) {
		this.loginid = loginid;
	}
	public String getVipFlag() {
		return vipFlag;
	}
	public void setVipFlag(String vipFlag) {
		this.vipFlag = vipFlag;
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
	public String getProjId() {
		return projId;
	}
	public void setProjId(String projId) {
		this.projId = projId;
	}
	public String getBankAcntNo() {
		return bankAcntNo;
	}
	public void setBankAcntNo(String bankAcntNo) {
		this.bankAcntNo = bankAcntNo;
	}
	public String getBrNoSts() {
		return brNoSts;
	}
	public void setBrNoSts(String brNoSts) {
		this.brNoSts = brNoSts;
	}
	public String getProjCode() {
		return projCode;
	}
	public void setProjCode(String projCode) {
		this.projCode = projCode;
	}
	public String getTenantNo() {
		return tenantNo;
	}
	public void setTenantNo(String tenantNo) {
		this.tenantNo = tenantNo;
	}
	
	
}