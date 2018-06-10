package accounting.domain.loan;
import app.base.BaseDomain;
/**
* Title: AftReliefDtl.java
* Description:
* @���� su
* @���� 2018-3-20
* @version��1.0
**/
public class AftReliefDtl extends accounting.domain.sys.CMISDomain {
	private String perdNo;//�ڴκ�
	private String reliefType;//��������[01-������,02-����]
	private String traceNo;//��־����ˮ
	private String loanNo;//��ݺ�
	private String pactNo;//��ͬ��
	private String brNo;//������
	private Double refAmt;//���Ȿ��
	private Double refIntst;//������Ϣ
	private Double refFine;//���ⷣϢ
	private Double refFee;//�������
	private String txDt;//�Ǽ�����

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
	 * @return ��������[01-������,02-����]
	 */
	public String getReliefType() {
	 	return reliefType;
	}
	/**
	 * @���� ��������[01-������,02-����]
	 * @param reliefType
	 */
	public void setReliefType(String reliefType) {
	 	this.reliefType = reliefType;
	}
	/**
	 * @return ��־����ˮ
	 */
	public String getTraceNo() {
	 	return traceNo;
	}
	/**
	 * @���� ��־����ˮ
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
	 * @return ���Ȿ��
	 */
	public Double getRefAmt() {
	 	return refAmt;
	}
	/**
	 * @���� ���Ȿ��
	 * @param refAmt
	 */
	public void setRefAmt(Double refAmt) {
	 	this.refAmt = refAmt;
	}
	/**
	 * @return ������Ϣ
	 */
	public Double getRefIntst() {
	 	return refIntst;
	}
	/**
	 * @���� ������Ϣ
	 * @param refIntst
	 */
	public void setRefIntst(Double refIntst) {
	 	this.refIntst = refIntst;
	}
	/**
	 * @return ���ⷣϢ
	 */
	public Double getRefFine() {
	 	return refFine;
	}
	/**
	 * @���� ���ⷣϢ
	 * @param refFine
	 */
	public void setRefFine(Double refFine) {
	 	this.refFine = refFine;
	}
	/**
	 * @return �������
	 */
	public Double getRefFee() {
	 	return refFee;
	}
	/**
	 * @���� �������
	 * @param refFee
	 */
	public void setRefFee(Double refFee) {
	 	this.refFee = refFee;
	}
	/**
	 * @return �Ǽ�����
	 */
	public String getTxDt() {
	 	return txDt;
	}
	/**
	 * @���� �Ǽ�����
	 * @param txDt
	 */
	public void setTxDt(String txDt) {
	 	this.txDt = txDt;
	}
}