package accounting.domain.fee;
/**
* Title: AcChrgLog.java
* Description:
* @���� su
* @���� 2018-4-25
* @version��1.0
**/
public class AcChrgLog extends accounting.domain.sys.CMISDomain {
	private String chrgId;//����ID
	private String traceNo;//��ˮ��
	private String loanNo;//��ݺ�
	private String pactNo;//��ͬ��
	private String brNo;//������
	private String feeParmId;//���ö�����
	private String feeKind;//��������
	private String perdNo;//�ڴκ�
	private Double chrgAmt;//���ý��
	private Double repayChrgAmt;//�ۼ�ʵ�ս��
	private Double wvChrgAmt;//�������
	private String chrgSts;//����״̬
	private String txDate;//�Ǽ�����
	private String txTime;//�Ǽ�ʱ��
	private String upDate;//����ʱ��
	private Double payChrgAmt;//ʵ������
	private String feeType;//��������
	
	
	
	public String getFeeType() {
		return feeType;
	}
	public void setFeeType(String feeType) {
		this.feeType = feeType;
	}
	public String getTxDate() {
		return txDate;
	}
	public String getTxTime() {
		return txTime;
	}
	public String getUpDate() {
		return upDate;
	}
	public void setTxDate(String txDate) {
		this.txDate = txDate;
	}
	public void setTxTime(String txTime) {
		this.txTime = txTime;
	}
	public void setUpDate(String upDate) {
		this.upDate = upDate;
	}
	/**
	 * @return ��ˮ��
	 */
	public String getTraceNo() {
	 	return traceNo;
	}
	/**
	 * @���� ��ˮ��
	 * @param traceNo
	 */
	public void setTraceNo(String traceNo) {
	 	this.traceNo = traceNo;
	}
	/**
	 * @return ��ݺ�
	 */
	public String getLoanNo() {
	 	return loanNo;
	}
	/**
	 * @���� ��ݺ�
	 * @param loanNo
	 */
	public void setLoanNo(String loanNo) {
	 	this.loanNo = loanNo;
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
	 * @return ������
	 */
	public String getBrNo() {
	 	return brNo;
	}
	/**
	 * @���� ������
	 * @param brNo
	 */
	public void setBrNo(String brNo) {
	 	this.brNo = brNo;
	}
	/**
	 * @return ���ö�����
	 */
	public String getFeeParmId() {
	 	return feeParmId;
	}
	/**
	 * @���� ���ö�����
	 * @param feeParmId
	 */
	public void setFeeParmId(String feeParmId) {
	 	this.feeParmId = feeParmId;
	}
	/**
	 * @return �ڴκ�
	 */
	public String getPerdNo() {
	 	return perdNo;
	}
	/**
	 * @���� �ڴκ�
	 * @param perdNo
	 */
	public void setPerdNo(String perdNo) {
	 	this.perdNo = perdNo;
	}
	/**
	 * @return ���ý��
	 */
	public Double getChrgAmt() {
	 	return chrgAmt;
	}
	/**
	 * @���� ���ý��
	 * @param chrgAmt
	 */
	public void setChrgAmt(Double chrgAmt) {
	 	this.chrgAmt = chrgAmt;
	}
	/**
	 * @return �ۼ�ʵ�ս��
	 */
	public Double getRepayChrgAmt() {
	 	return repayChrgAmt;
	}
	/**
	 * @���� �ۼ�ʵ�ս��
	 * @param repayChrgAmt
	 */
	public void setRepayChrgAmt(Double repayChrgAmt) {
	 	this.repayChrgAmt = repayChrgAmt;
	}
	/**
	 * @return ����״̬
	 */
	public String getChrgSts() {
	 	return chrgSts;
	}
	/**
	 * @���� ����״̬
	 * @param chrgSts
	 */
	public void setChrgSts(String chrgSts) {
	 	this.chrgSts = chrgSts;
	}
	public String getFeeKind() {
		return feeKind;
	}
	public void setFeeKind(String feeKind) {
		this.feeKind = feeKind;
	}
	public Double getWvChrgAmt() {
		return wvChrgAmt;
	}
	public void setWvChrgAmt(Double wvChrgAmt) {
		this.wvChrgAmt = wvChrgAmt;
	}
	public String getChrgId() {
		return chrgId;
	}
	public void setChrgId(String chrgId) {
		this.chrgId = chrgId;
	}
	public Double getPayChrgAmt() {
		return payChrgAmt;
	}
	public void setPayChrgAmt(Double payChrgAmt) {
		this.payChrgAmt = payChrgAmt;
	}
}