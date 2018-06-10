package app.creditapp.acc.loan.entity;
import app.base.BaseDomain;
/**
* Title: AcLnPmLog.java
* Description:
* @version��1.0
**/
public class AcLnPmLog extends BaseDomain {
	private String perdNo;//�ں�
	private String loanNo;//��ݺ�
	private String traceNo;//������ˮ��
	private Integer cancelTraceNo;//����������ˮ��
	private String cancelDt;//������������
	private String pactNo;//��ͬ��
	private String brNo;//������
	private Double repayPrcpAmt;//�������
	private Double repayNormInt;//����Ϣ���
	private Double repayFineInt;//����Ϣ
	private Double repayFeeAmt;//������
	private String prcpSts;//����״̬
	private String intSts;//��Ϣ״̬
	private String chrgSts;//����״̬
	private String txDt;//��������
	private String cancelInd;//����������־
	private String chrgId;//���ñ�ID
	private String cifName;//�ͻ�����
	private String brName;//������������
	private double dueAmt;//������
	private double bal;//�������
	private String loginid;//��¼��Ա
	
	public String getLoginid() {
		return loginid;
	}
	public void setLoginid(String loginid) {
		this.loginid = loginid;
	}
	/**
	 * @return �ں�
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
	 * @return ����������ˮ��
	 */
	public Integer getCancelTraceNo() {
	 	return cancelTraceNo;
	}
	/**
	 * @���� ����������ˮ��
	 * @param cancelTraceNo
	 */
	public void setCancelTraceNo(Integer cancelTraceNo) {
	 	this.cancelTraceNo = cancelTraceNo;
	}
	/**
	 * @return ������������
	 */
	public String getCancelDt() {
	 	return cancelDt;
	}
	/**
	 * @���� ������������
	 * @param cancelDt
	 */
	public void setCancelDt(String cancelDt) {
	 	this.cancelDt = cancelDt;
	}
	/**
	 * @return ���������û�
	 */
	
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
	 * @return �������
	 */
	public Double getRepayPrcpAmt() {
	 	return repayPrcpAmt;
	}
	/**
	 * @���� �������
	 * @param repayPrcpAmt
	 */
	public void setRepayPrcpAmt(Double repayPrcpAmt) {
	 	this.repayPrcpAmt = repayPrcpAmt;
	}
	/**
	 * @return ����Ϣ���
	 */
	public Double getRepayNormInt() {
	 	return repayNormInt;
	}
	/**
	 * @���� ����Ϣ���
	 * @param repayNormInt
	 */
	public void setRepayNormInt(Double repayNormInt) {
	 	this.repayNormInt = repayNormInt;
	}
	/**
	 * @return ����Ϣ
	 */
	public Double getRepayFineInt() {
	 	return repayFineInt;
	}
	/**
	 * @���� ����Ϣ
	 * @param repayFineInt
	 */
	public void setRepayFineInt(Double repayFineInt) {
	 	this.repayFineInt = repayFineInt;
	}
	/**
	 * @return ������
	 */
	public Double getRepayFeeAmt() {
	 	return repayFeeAmt;
	}
	/**
	 * @���� ������
	 * @param repayFeeAmt
	 */
	public void setRepayFeeAmt(Double repayFeeAmt) {
	 	this.repayFeeAmt = repayFeeAmt;
	}
	/**
	 * @return ����״̬
	 */
	public String getPrcpSts() {
	 	return prcpSts;
	}
	/**
	 * @���� ����״̬
	 * @param prcpSts
	 */
	public void setPrcpSts(String prcpSts) {
	 	this.prcpSts = prcpSts;
	}
	/**
	 * @return ��Ϣ״̬
	 */
	public String getIntSts() {
	 	return intSts;
	}
	/**
	 * @���� ��Ϣ״̬
	 * @param intSts
	 */
	public void setIntSts(String intSts) {
	 	this.intSts = intSts;
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
	public String getCifName() {
		return cifName;
	}
	public void setCifName(String cifName) {
		this.cifName = cifName;
	}
	public String getBrName() {
		return brName;
	}
	public void setBrName(String brName) {
		this.brName = brName;
	}
	public double getDueAmt() {
		return dueAmt;
	}
	public void setDueAmt(double dueAmt) {
		this.dueAmt = dueAmt;
	}
	public double getBal() {
		return bal;
	}
	public void setBal(double bal) {
		this.bal = bal;
	}
	/**
	 * @���� ����������־
	 * @param cancelInd
	 */
	public void setCancelInd(String cancelInd) {
	 	this.cancelInd = cancelInd;
	}
	public String getChrgId() {
		return chrgId;
	}
	public void setChrgId(String chrgId) {
		this.chrgId = chrgId;
	}

}