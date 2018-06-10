package accounting.domain.loan;

/**
 * Title: AcLnPmLog.java Description:
 * 
* @���� su
* @���� 2018-3-20
 * @version��1.0
 **/
public class AcLnPmLog extends accounting.domain.sys.CMISDomain {
	private String loanNo; // ��ݺ�
	private String pactNo; //��ͬ��
	private String brNo;   //������
	private String traceNo; // ������ˮ��
	private String perdNo; // �ں�
	private String txDt; // ��������
	private double repayPrcpAmt; // ���ڻ������
	private double repayNormInt; // ���ڻ���Ϣ���
	private double repayFineInt;
	private double repayFeeAmt;//���ڻ�����
	private String prcpSts; // ����״̬
	private String intSts; // ��Ϣ״̬
	private String chrgSts;//����״̬
	private String cancelInd; 		// ����������־
	private long cancelTraceNo; 	// �����������׺�
	private String cancelDt; 		// ��������������������
	private String chrgId;			//���ñ�ID
	private String comPst;			//����������

	
	public double getRepayFineInt() {
		return repayFineInt;
	}

	public void setRepayFineInt(double repayFineInt) {
		this.repayFineInt = repayFineInt;
	}


	/**
	 * @return ���� ��ݺ�
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
	 * @return ���� ������ˮ��
	 */
	public String getTraceNo() {
		return traceNo;
	}

	/**
	 * @���� ������ˮ��
	 * @param traceNo
	 */
	public void setTraceNo(String traceNo) {
		this.traceNo = traceNo;
	}

	/**
	 * @return ���� �ں�
	 */
	public String getPerdNo() {
		return perdNo;
	}

	/**
	 * @���� �ں�
	 * @param perdNo
	 */
	public void setPerdNo(String perdNo) {
		this.perdNo = perdNo;
	}

	/**
	 * @return ���� ��������
	 */
	public String getTxDt() {
		return txDt;
	}

	/**
	 * @���� ��������
	 * @param txDate
	 */
	public void setTxDt(String txDt) {
		this.txDt = txDt;
	}

	/**
	 * @return repayPrcpAmt
	 */
	public double getRepayPrcpAmt() {
		return repayPrcpAmt;
	}

	/**
	 * @param repayPrcpAmt
	 */
	public void setRepayPrcpAmt(double repayPrcpAmt) {
		this.repayPrcpAmt = repayPrcpAmt;
	}

	/**
	 * @return repayNormIntst
	 */
	public double getRepayNormInt() {
		return repayNormInt;
	}

	/**
	 * @param repayNormIntst
	 */
	public void setRepayNormInt(double repayNormInt) {
		this.repayNormInt = repayNormInt;
	}


	/**
	 * @return the revseRolInd
	 */
	public String getCancelInd() {
		return cancelInd;
	}

	/**
	 * @param revseRolInd
	 *            the revseRolInd to set
	 */
	public void setCancelInd(String cancelInd) {
		this.cancelInd = cancelInd;
	}

	/**
	 * @return ���� ����״̬
	 */
	public String getPrcpSts() {
		return prcpSts;
	}

	/**
	 * @���� ����״̬
	 * @param prcpState
	 */
	public void setPrcpSts(String prcpSts) {
		this.prcpSts = prcpSts;
	}

	/**
	 * @return ���� ��Ϣ״̬
	 */
	public String getIntSts() {
		return intSts;
	}

	/**
	 * @���� ��Ϣ״̬
	 * @param intstState
	 */
	public void setIntSts(String intSts) {
		this.intSts = intSts;
	}

	/**
	 * @return the cancelTraceNo
	 */
	public long getCancelTraceNo() {
		return cancelTraceNo;
	}

	/**
	 * @param cancelTraceNo
	 *            the cancelTraceNo to set
	 */
	public void setCancelTraceNo(long cancelTraceNo) {
		this.cancelTraceNo = cancelTraceNo;
	}

	/**
	 * @return ���� ������������
	 */
	public String getCancelDt() {
		return cancelDt;
	}
	/**
	 * @���� ������������
	 * @param usrId
	 */
	public void setCancelDt(String cancelDt) {
		this.cancelDt = cancelDt;
	}

	public double getRepayFeeAmt() {
		return repayFeeAmt;
	}

	public void setRepayFeeAmt(double repayFeeAmt) {
		this.repayFeeAmt = repayFeeAmt;
	}

	public String getPactNo() {
		return pactNo;
	}

	public String getBrNo() {
		return brNo;
	}

	public String getChrgSts() {
		return chrgSts;
	}

	public void setPactNo(String pactNo) {
		this.pactNo = pactNo;
	}

	public void setBrNo(String brNo) {
		this.brNo = brNo;
	}

	public void setChrgSts(String chrgSts) {
		this.chrgSts = chrgSts;
	}

	public String getChrgId() {
		return chrgId;
	}

	public void setChrgId(String chrgId) {
		this.chrgId = chrgId;
	}

	public String getComPst() {
		return comPst;
	}

	public void setComPst(String comPst) {
		this.comPst = comPst;
	}

}