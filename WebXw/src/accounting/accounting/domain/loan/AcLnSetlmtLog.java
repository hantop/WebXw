package accounting.domain.loan;

/**
 * Title: AcLnSetlmtLog.java Description:
 * 
* @���� su
* @���� 2018-3-20
 * @version��1.0
 **/
public class AcLnSetlmtLog extends accounting.domain.sys.CMISDomain {
	private Integer acId; 		// �˻�ID
	private Integer acSeq; 		// �˻����
	private String loanNo; 		// ��ݺ�
	private String traceNo; 	// ������ˮ��
	private long dcNo; 			// ��Ʒ�¼��ˮ��
	private String txDt; 		// ��������
	private String loanTyp; 	// ����ҵ������
	private String setlMode; 	// ����ģʽ
	private String setlTyp; 	// ��������
	private double recvAmt; 	// �յ����
	private double prcpAmt; 	// �黹Ƿ�����
	private double normInt; 	// �黹������Ϣ���
	private double overInt; 	// �黹������Ϣ���
	private double cmpdInt; 	// �黹�������
	private double remPrcpAmt; 	// ��ǰ�������
	private double curInt; 		// �黹������Ϣ���
	private String cancelInd;	// ����������־
	private String cancelTraceNo;	// ����������ˮ��
	private String cancelDt; 	// ����������������
	private String cancelUsrId;	// ���������û�
	private String fdrpIntstOpt; 	// ��Ϣ���㵽
	private String fdrpIntstBase;	// ��Ϣ�������
	private String memo; 		// ��ע
	private double feeAmtCredit;// ����(�ⲿ)
	private double feeAmtAcc ;	// ����(����)
	private String repayAdvOpt ;// ����ѡ��
	
	private double damageAmt;    // ΥԼ��  
	private double compenAmt;	// ������
 
	

	/**
	 * @return ���� �˻�ID
	 */
	public Integer getAcId() {
		return acId;
	}

	/**
	 * @���� �˻�ID
	 * @param acId
	 */
	public void setAcId(Integer acId) {
		this.acId = acId;
	}

	/**
	 * @return ���� �˻����
	 */
	public Integer getAcSeq() {
		return acSeq;
	}

	/**
	 * @���� �˻����
	 * @param acSeq
	 */
	public void setAcSeq(Integer acSeq) {
		this.acSeq = acSeq;
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
	 * @return ��Ʒ�¼��ˮ��
	 */
	public long getDcNo() {
		return dcNo;
	}

	/**
	 * @param ��Ʒ�¼��ˮ��
	 */
	public void setDcNo(long dcNo) {
		this.dcNo = dcNo;
	}

	/**
	 * @return ���� ��������
	 */
	public String getTxDt() {
		return txDt;
	}

	/**
	 * @���� ��������
	 * @param txDt
	 */
	public void setTxDt(String txDt) {
		this.txDt = txDt;
	}

	/**
	 * @return ���� ����ҵ������
	 */
	public String getLoanTyp() {
		return loanTyp;
	}

	/**
	 * @���� ����ҵ������
	 * @param loanTyp
	 */
	public void setLoanTyp(String loanTyp) {
		this.loanTyp = loanTyp;
	}

	/**
	 * @return ���� ����ģʽ
	 */
	public String getSetlMode() {
		return setlMode;
	}

	/**
	 * @���� ����ģʽ
	 * @param setlMode
	 */
	public void setSetlMode(String setlMode) {
		this.setlMode = setlMode;
	}

	/**
	 * @return ���� ��������
	 */
	public String getSetlTyp() {
		return setlTyp;
	}

	/**
	 * @���� ��������
	 * @param setlTyp
	 */
	public void setSetlTyp(String setlTyp) {
		this.setlTyp = setlTyp;
	}

	/**
	 * @return ���� �յ����
	 */
	public double getRecvAmt() {
		return recvAmt;
	}

	/**
	 * @���� �յ����
	 * @param recvAmt
	 */
	public void setRecvAmt(double recvAmt) {
		this.recvAmt = recvAmt;
	}

	/**
	 * @return ���� �黹Ƿ�����
	 */
	public double getPrcpAmt() {
		return prcpAmt;
	}

	/**
	 * @���� �黹Ƿ�����
	 * @param prcpAmt
	 */
	public void setPrcpAmt(double prcpAmt) {
		this.prcpAmt = prcpAmt;
	}

	/**
	 * @return ���� �黹������Ϣ���
	 */
	public double getNormInt() {
		return normInt;
	}

	/**
	 * @���� �黹������Ϣ���
	 * @param normIntst
	 */
	public void setNormInt(double normInt) {
		this.normInt = normInt;
	}

	/**
	 * @return ���� �黹������Ϣ���
	 */
	public double getOverInt() {
		return overInt;
	}

	/**
	 * @���� �黹������Ϣ���
	 * @param overIntst
	 */
	public void setOverInt(double overInt) {
		this.overInt = overInt;
	}

	/**
	 * @return ���� �黹�������
	 */
	public double getCmpdInt() {
		return cmpdInt;
	}

	/**
	 * @���� �黹�������
	 * @param cmpdIntst
	 */
	public void setCmpdInt(double cmpdInt) {
		this.cmpdInt = cmpdInt;
	}

	/**
	 * @return ���� ��ǰ�������
	 */
	public double getRemPrcpAmt() {
		return remPrcpAmt;
	}

	/**
	 * @���� ��ǰ�������
	 * @param remPrcpPaym
	 */
	public void setRemPrcpAmt(double remPrcpAmt) {
		this.remPrcpAmt = remPrcpAmt;
	}

	/**
	 * @return ���� ������Ϣ
	 */
	public double getCurInt() {
		return curInt;
	}

	/**
	 * @���� ������Ϣ
	 * @param curIntst
	 */
	public void setCurInt(double curInt) {
		this.curInt = curInt;
	}

	/**
	 * @return ���� ����������־
	 */
	public String getCancelInd() {
		return cancelInd;
	}

	/**
	 * @���� ����������־
	 * @param revseRolInd
	 */
	public void setCancelInd(String cancelInd) {
		this.cancelInd = cancelInd;
	}

	/**
	 * @return ���� ����������ˮ��
	 */
	public String getCancelTraceNo() {
		return cancelTraceNo;
	}

	/**
	 * @���� ����������ˮ��
	 * @param cancelTracdeNo
	 */
	public void setCancelTraceNo(String cancelTraceNo) {
		this.cancelTraceNo = cancelTraceNo;
	}

	/**
	 * @return ���� ����������������
	 */
	public String getCancelDt() {
		return cancelDt;
	}

	/**
	 * @���� ����������������
	 * @param cancelDt
	 */
	public void setCancelDt(String cancelDt) {
		this.cancelDt = cancelDt;
	}

	/**
	 * @return ���� ���������û�
	 */
	public String getCancelUsrId() {
		return cancelUsrId;
	}

	/**
	 * @���� ���������û�
	 * @param cancelUsrId
	 */
	public void setCancelUsrId(String cancelUsrId) {
		this.cancelUsrId = cancelUsrId;
	}

	
	/**
	 * ��ǰ���ǰ��Ϣ���㵽
	 * @return ��ǰ���ǰ��Ϣ���㵽
	 */
	public String getFdrpIntstOpt() {
		return fdrpIntstOpt;
	}
	/**
	 * ��ǰ���ǰ��Ϣ���㵽
	 * @param fdrpIntstOpt
	 */
	public void setFdrpIntstOpt(String fdrpIntstOpt) {
		this.fdrpIntstOpt = fdrpIntstOpt;
	}
	/**
	 * ��ǰ������Ϣ�������
	 * @return ��ǰ������Ϣ�������
	 */
	public String getFdrpIntstBase() {
		return fdrpIntstBase;
	}

	/**
	 * ��ǰ������Ϣ������� 
	 * @param fdrpIntstBase
	 */
	public void setFdrpIntstBase(String fdrpIntstBase) {
		this.fdrpIntstBase = fdrpIntstBase;
	}

	/**
	 * @return ���� ��ע
	 */
	public String getMemo() {
		return memo;
	}

	/**
	 * @���� ��ע
	 * @param memo
	 */
	public void setMemo(String memo) {
		this.memo = memo;
	}

	/**
	 * @return ����(�ⲿ)
	 */
	public double getFeeAmtCredit() {
		return feeAmtCredit;
	}

	/**
	 * @param ����(�ⲿ)
	 */
	public void setFeeAmtCredit(double feeAmtCredit) {
		this.feeAmtCredit = feeAmtCredit;
	}
	/**
	 * @return ����(����)
	 */
	public double getFeeAmtAcc() {
		return feeAmtAcc;
	}
	/**
	 * @param ����(����)
	 */
	public void setFeeAmtAcc(double feeAmtAcc) {
		this.feeAmtAcc = feeAmtAcc;
	}
	/**
	 * @return ����ѡ��
	 */
	public String getRepayAdvOpt() {
		return repayAdvOpt ;
	}
	/**
	 * @param ����ѡ��
	 */
	public void setRepayAdvOpt(String repayAdvOpt) {
		this.repayAdvOpt = repayAdvOpt;
	}
	/**
	 * ΥԼ��
	 * @return ΥԼ��
	 */
	public double getDamageAmt() {
		return damageAmt;
	}
	/**
	 * ΥԼ��
	 * @param damagAmt
	 */
	public void setDamageAmt(double damageAmt) {
		this.damageAmt = damageAmt;
	}
	/**
	 * ������
	 * @return ������
	 */
	public double getCompenAmt() {
		return compenAmt;
	}
	/**
	 * ������
	 * @param compenAmt 
	 */
	public void setCompenAmt(double compenAmt) {
		this.compenAmt = compenAmt;
	}

}