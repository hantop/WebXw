package app.creditapp.acc.option.entity;
import app.base.BaseDomain;
/**
* Title: AcLnSetlmtLog.java
* Description:
* @version��1.0
**/
public class AcLnSetlmtLog extends BaseDomain {
	private String traceNo;//������ˮ��
	private Double remPrcpAmt;//��ǰ�������
	private Double curInt;//�黹������Ϣ
	private Double feeAmt;//����
	private String txDt;//��������
	private String cancelInd;//����������־
	private String cancelTraceNo;//����������ˮ��
	private String cancelDt;//��������
	private String cancelUsrId;//�����û�
	private String memo;//��ע
	private String loanNo;//��ݺ�
	private String pactNo;//��ͬ��
	private String brNo;//������
	private Double recvAmt;//��ǰ������
	private String recvDt;//��ǰ��������
	private Double prcpAmt;//�黹Ƿ�����
	private Double normInt;//�黹������Ϣ���
	private Double fineInt;//�黹��Ϣ
	private Double damAmt;//�黹��ǰ����ΥԼ��
	private String repayType;//��������[01-�������䣬�����ڹ� 02-�ڹ����䣬��������]
	private String endDate;//��������
	private String loginid;//��¼��Ա
	
	public String getLoginid() {
		return loginid;
	}
	public void setLoginid(String loginid) {
		this.loginid = loginid;
	}
	/**
	 * @return ������ˮ��
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
	 * @return ��ǰ�������
	 */
	public Double getRemPrcpAmt() {
	 	return remPrcpAmt;
	}
	/**
	 * @���� ��ǰ�������
	 * @param remPrcpAmt
	 */
	public void setRemPrcpAmt(Double remPrcpAmt) {
	 	this.remPrcpAmt = remPrcpAmt;
	}
	/**
	 * @return �黹������Ϣ
	 */
	public Double getCurInt() {
	 	return curInt;
	}
	/**
	 * @���� �黹������Ϣ
	 * @param curInt
	 */
	public void setCurInt(Double curInt) {
	 	this.curInt = curInt;
	}
	/**
	 * @return ����
	 */
	public Double getFeeAmt() {
	 	return feeAmt;
	}
	/**
	 * @���� ����
	 * @param feeAmt
	 */
	public void setFeeAmt(Double feeAmt) {
	 	this.feeAmt = feeAmt;
	}
	/**
	 * @return ��������
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
	 * @return ����������־
	 */
	public String getCancelInd() {
	 	return cancelInd;
	}
	/**
	 * @���� ����������־
	 * @param cancelInd
	 */
	public void setCancelInd(String cancelInd) {
	 	this.cancelInd = cancelInd;
	}
	/**
	 * @return ����������ˮ��
	 */
	public String getCancelTraceNo() {
	 	return cancelTraceNo;
	}
	/**
	 * @���� ����������ˮ��
	 * @param cancelTraceNo
	 */
	public void setCancelTraceNo(String cancelTraceNo) {
	 	this.cancelTraceNo = cancelTraceNo;
	}
	/**
	 * @return ��������
	 */
	public String getCancelDt() {
	 	return cancelDt;
	}
	/**
	 * @���� ��������
	 * @param cancelDt
	 */
	public void setCancelDt(String cancelDt) {
	 	this.cancelDt = cancelDt;
	}
	/**
	 * @return �����û�
	 */
	public String getCancelUsrId() {
	 	return cancelUsrId;
	}
	/**
	 * @���� �����û�
	 * @param cancelUsrId
	 */
	public void setCancelUsrId(String cancelUsrId) {
	 	this.cancelUsrId = cancelUsrId;
	}
	/**
	 * @return ��ע
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
	 * @return ��ǰ������
	 */
	public Double getRecvAmt() {
	 	return recvAmt;
	}
	/**
	 * @���� ��ǰ������
	 * @param recvAmt
	 */
	public void setRecvAmt(Double recvAmt) {
	 	this.recvAmt = recvAmt;
	}
	/**
	 * @return ��ǰ��������
	 */
	public String getRecvDt() {
	 	return recvDt;
	}
	/**
	 * @���� ��ǰ��������
	 * @param recvDt
	 */
	public void setRecvDt(String recvDt) {
	 	this.recvDt = recvDt;
	}
	/**
	 * @return �黹Ƿ�����
	 */
	public Double getPrcpAmt() {
	 	return prcpAmt;
	}
	/**
	 * @���� �黹Ƿ�����
	 * @param prcpAmt
	 */
	public void setPrcpAmt(Double prcpAmt) {
	 	this.prcpAmt = prcpAmt;
	}
	/**
	 * @return �黹������Ϣ���
	 */
	public Double getNormInt() {
	 	return normInt;
	}
	/**
	 * @���� �黹������Ϣ���
	 * @param normInt
	 */
	public void setNormInt(Double normInt) {
	 	this.normInt = normInt;
	}
	/**
	 * @return �黹��Ϣ
	 */
	public Double getFineInt() {
	 	return fineInt;
	}
	/**
	 * @���� �黹��Ϣ
	 * @param fineInt
	 */
	public void setFineInt(Double fineInt) {
	 	this.fineInt = fineInt;
	}
	/**
	 * @return �黹��ǰ����ΥԼ��
	 */
	public Double getDamAmt() {
	 	return damAmt;
	}
	/**
	 * @���� �黹��ǰ����ΥԼ��
	 * @param damAmt
	 */
	public void setDamAmt(Double damAmt) {
	 	this.damAmt = damAmt;
	}
	public String getRepayType() {
		return repayType;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setRepayType(String repayType) {
		this.repayType = repayType;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
}