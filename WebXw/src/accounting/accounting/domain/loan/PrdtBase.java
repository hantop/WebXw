package accounting.domain.loan;

import app.base.BaseDomain;

/**
 * Title: PrdtBase.java Description:
 * 
* @���� su
* @���� 2018-3-20
 * @version��1.0
 **/
public class PrdtBase extends accounting.domain.sys.CMISDomain {
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
	private String allowArea;

	private Double offRate;// �ۿ���
	private Double minRate;// ��С������
	private String endDate;// ��������
	private Integer failDays;//��ʧ�������[Ĭ��Ϊ30��]N��֮�����Զ��ۿ��ʧ�������[Ĭ��Ϊ30��]N��֮�����Զ��ۿ�
	
	private String repaySeqCde;//����˳������
	
	public String getRepaySeqCde() {
		return repaySeqCde;
	}

	public void setRepaySeqCde(String repaySeqCde) {
		this.repaySeqCde = repaySeqCde;
	}

	public PrdtBase() {
		offRate = 1.0d;//�ۿ��� Ĭ��ֵ 1
		prdtVer = 1; //�汾�� Ĭ��ֵ 1
	}

	/**
	 * @return ��Ʒ���
	 */
	public String getPrdtNo() {
		return prdtNo;
	}

	/**
	 * @���� ��Ʒ���
	 * @param prdtNo
	 */
	public void setPrdtNo(String prdtNo) {
		this.prdtNo = prdtNo;
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
	 * @return ��Ʒ����
	 */
	public String getPrdtName() {
		return prdtName;
	}

	/**
	 * @���� ��Ʒ����
	 * @param prdtName
	 */
	public void setPrdtName(String prdtName) {
		this.prdtName = prdtName;
	}

	/**
	 * @return ��Ʒ����[01��Ӫ��02������]
	 */
	public String getPrdtType() {
		return prdtType;
	}

	/**
	 * @���� ��Ʒ����[01��Ӫ��02������]
	 * @param prdtType
	 */
	public void setPrdtType(String prdtType) {
		this.prdtType = prdtType;
	}

	/**
	 * @return �������
	 */
	public Double getMinAmt() {
		return minAmt;
	}

	/**
	 * @���� �������
	 * @param minAmt
	 */
	public void setMinAmt(Double minAmt) {
		this.minAmt = minAmt;
	}

	/**
	 * @return �������
	 */
	public Double getMaxAmt() {
		return maxAmt;
	}

	/**
	 * @���� �������
	 * @param maxAmt
	 */
	public void setMaxAmt(Double maxAmt) {
		this.maxAmt = maxAmt;
	}

	/**
	 * @return ��������(��)
	 */
	public Integer getMinMon() {
		return minMon;
	}

	/**
	 * @���� ��������(��)
	 * @param minMon
	 */
	public void setMinMon(Integer minMon) {
		this.minMon = minMon;
	}

	/**
	 * @return ��������(��)
	 */
	public Integer getMaxMon() {
		return maxMon;
	}

	/**
	 * @���� ��������(��)
	 * @param maxMon
	 */
	public void setMaxMon(Integer maxMon) {
		this.maxMon = maxMon;
	}

	/**
	 * @return ��Ʒ˵��
	 */
	public String getPrdtDesc() {
		return prdtDesc;
	}

	/**
	 * @���� ��Ʒ˵��
	 * @param prdtDesc
	 */
	public void setPrdtDesc(String prdtDesc) {
		this.prdtDesc = prdtDesc;
	}

	/**
	 * @return �汾��
	 */
	public Integer getPrdtVer() {
		return prdtVer;
	}

	/**
	 * @���� �汾��
	 * @param prdtVer
	 */
	public void setPrdtVer(Integer prdtVer) {
		this.prdtVer = prdtVer;
	}

	/**
	 * @return ��Ʒ״̬
	 */
	public String getPrdtSts() {
		return prdtSts;
	}

	/**
	 * @���� ��Ʒ״̬
	 * @param prdtSts
	 */
	public void setPrdtSts(String prdtSts) {
		this.prdtSts = prdtSts;
	}

	/**
	 * @return �Ǽ���
	 */
	public String getOpNo() {
		return opNo;
	}

	/**
	 * @���� �Ǽ���
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

	public String getPrdtId() {
		return prdtId;
	}

	public void setPrdtId(String prdtId) {
		this.prdtId = prdtId;
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


	public String getBrAccType() {
		return brAccType;
	}

	public void setBrAccType(String brAccType) {
		this.brAccType = brAccType;
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

	public Integer getFailDays() {
		return failDays;
	}

	public void setFailDays(Integer failDays) {
		this.failDays = failDays;
	}

	public String getAllowArea() {
		return allowArea;
	}

	public void setAllowArea(String allowArea) {
		this.allowArea = allowArea;
	}
	
}