package app.creditapp.sys.entity;

import app.base.BaseDomain;

/**
 * Title: PrdtBase.java Description:
 * 
 * @version��1.0
 **/
public class PrdtBase extends BaseDomain {
	private String prdtId;// ��Ʒ���
	private String prdtNo;// ��Ʒ���
	private String brNo;// ����������
	private String prdtName;// ��Ʒ����
	private String prdtType;// ��Ʒ����[01��Ӫ��02������]
	private Double minAmt;// �������
	private Double maxAmt;// �������
	private Integer minMon;// ��������(��)
	private Integer maxMon;// ��������(��)
	private String repayNo;// ��������
	private String defNo;// ��Ϣ��ʽ���
	private String damNo;// ΥԼ��ʽ���
	private Double maxRate;// ���������
	private Double overRate;// ����������
	private String feeNo;// ���շѱ��@�ָ�
	private String prdtDesc;// ��Ʒ˵��
	private Integer prdtVer;// �汾��
	private String prdtSts;// ��Ʒ״̬
	private String opNo;// �Ǽ���
	private String txDate;// �Ǽ�����
	private String upDate;// ��������
	private String brAccType;// ��������

	private String repayName;// ���������
	private String brName;// ������������

	private Double offRate;// �ۿ���
	private Double minRate;// ��С������
	private String endDate;// ��������
	
	private String damName;//ΥԼ��ʽ����
	private String defName;//��Ϣ��ʽ����
	
	private String prdtByte;//��Ӫ��ʽ[01����02����]
	private String allowArea;//����չҵ����
	private String allowAreaNo;//��������
	//�������
	private Float rgAppRate;//�˹����˱�����ֵ
	private Integer failDays; //��ʧ�������[Ĭ��Ϊ30��]N��֮�����Զ��ۿ�
	private Integer regretDate;//������[Ĭ��7��]����֮���൱����Ϣ����
	
	private String rulesName;//���ù�������
	
	private String uploadDoc;//�˲�Ʒ�±ش��ĵ�
	private String intopDoc;//�˲�Ʒ������������ĵ�
	private String args;//�����ֶΣ����������Ҫ����ɺϲ�������@�ָ�
	public PrdtBase() {
		offRate = 1.0d;//�ۿ��� Ĭ��ֵ 1
		prdtVer = 1; //�汾�� Ĭ��ֵ 1
	}


	public String getUploadDoc() {
		return uploadDoc;
	}


	public void setUploadDoc(String uploadDoc) {
		this.uploadDoc = uploadDoc;
	}


	public String getIntopDoc() {
		return intopDoc;
	}


	public void setIntopDoc(String intopDoc) {
		this.intopDoc = intopDoc;
	}


	public String getArgs() {
		return args;
	}


	public void setArgs(String args) {
		this.args = args;
	}


	public String getPrdtId() {
		return prdtId;
	}


	public void setPrdtId(String prdtId) {
		this.prdtId = prdtId;
	}


	public String getPrdtNo() {
		return prdtNo;
	}


	public void setPrdtNo(String prdtNo) {
		this.prdtNo = prdtNo;
	}


	public String getBrNo() {
		return brNo;
	}


	public void setBrNo(String brNo) {
		this.brNo = brNo;
	}


	public String getPrdtName() {
		return prdtName;
	}


	public void setPrdtName(String prdtName) {
		this.prdtName = prdtName;
	}


	public String getPrdtType() {
		return prdtType;
	}


	public void setPrdtType(String prdtType) {
		this.prdtType = prdtType;
	}


	public Double getMinAmt() {
		return minAmt;
	}


	public void setMinAmt(Double minAmt) {
		this.minAmt = minAmt;
	}


	public Double getMaxAmt() {
		return maxAmt;
	}


	public void setMaxAmt(Double maxAmt) {
		this.maxAmt = maxAmt;
	}


	public Integer getMinMon() {
		return minMon;
	}


	public void setMinMon(Integer minMon) {
		this.minMon = minMon;
	}


	public Integer getMaxMon() {
		return maxMon;
	}


	public void setMaxMon(Integer maxMon) {
		this.maxMon = maxMon;
	}


	public String getRepayNo() {
		return repayNo;
	}


	public void setRepayNo(String repayNo) {
		this.repayNo = repayNo;
	}


	public String getDefNo() {
		return defNo;
	}


	public void setDefNo(String defNo) {
		this.defNo = defNo;
	}


	public String getDamNo() {
		return damNo;
	}


	public void setDamNo(String damNo) {
		this.damNo = damNo;
	}


	public Double getMaxRate() {
		return maxRate;
	}


	public void setMaxRate(Double maxRate) {
		this.maxRate = maxRate;
	}


	public Double getOverRate() {
		return overRate;
	}


	public void setOverRate(Double overRate) {
		this.overRate = overRate;
	}


	public String getFeeNo() {
		return feeNo;
	}


	public void setFeeNo(String feeNo) {
		this.feeNo = feeNo;
	}


	public String getPrdtDesc() {
		return prdtDesc;
	}


	public void setPrdtDesc(String prdtDesc) {
		this.prdtDesc = prdtDesc;
	}


	public Integer getPrdtVer() {
		return prdtVer;
	}


	public void setPrdtVer(Integer prdtVer) {
		this.prdtVer = prdtVer;
	}


	public String getPrdtSts() {
		return prdtSts;
	}


	public void setPrdtSts(String prdtSts) {
		this.prdtSts = prdtSts;
	}


	public String getOpNo() {
		return opNo;
	}


	public void setOpNo(String opNo) {
		this.opNo = opNo;
	}


	public String getTxDate() {
		return txDate;
	}


	public void setTxDate(String txDate) {
		this.txDate = txDate;
	}


	public String getUpDate() {
		return upDate;
	}


	public void setUpDate(String upDate) {
		this.upDate = upDate;
	}


	public String getBrAccType() {
		return brAccType;
	}


	public void setBrAccType(String brAccType) {
		this.brAccType = brAccType;
	}


	public String getRepayName() {
		return repayName;
	}


	public void setRepayName(String repayName) {
		this.repayName = repayName;
	}


	public String getBrName() {
		return brName;
	}


	public void setBrName(String brName) {
		this.brName = brName;
	}


	public Double getOffRate() {
		return offRate;
	}


	public void setOffRate(Double offRate) {
		this.offRate = offRate;
	}


	public Double getMinRate() {
		return minRate;
	}


	public void setMinRate(Double minRate) {
		this.minRate = minRate;
	}


	public String getEndDate() {
		return endDate;
	}


	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}


	public String getDamName() {
		return damName;
	}


	public void setDamName(String damName) {
		this.damName = damName;
	}


	public String getDefName() {
		return defName;
	}


	public void setDefName(String defName) {
		this.defName = defName;
	}


	public String getPrdtByte() {
		return prdtByte;
	}


	public void setPrdtByte(String prdtByte) {
		this.prdtByte = prdtByte;
	}


	public String getAllowArea() {
		return allowArea;
	}


	public void setAllowArea(String allowArea) {
		this.allowArea = allowArea;
	}


	public String getAllowAreaNo() {
		return allowAreaNo;
	}

	public void setAllowAreaNo(String allowAreaNo) {
		this.allowAreaNo = allowAreaNo;
	}

	public Float getRgAppRate() {
		return rgAppRate;
	}

	public void setRgAppRate(Float rgAppRate) {
		this.rgAppRate = rgAppRate;
	}

	public Integer getFailDays() {
		return failDays;
	}

	public void setFailDays(Integer failDays) {
		this.failDays = failDays;
	}

	public Integer getRegretDate() {
		return regretDate;
	}


	public void setRegretDate(Integer regretDate) {
		this.regretDate = regretDate;
	}


	public String getRulesName() {
		return rulesName;
	}


	public void setRulesName(String rulesName) {
		this.rulesName = rulesName;
	}

}