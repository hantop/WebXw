package app.creditapp.acc.loan.entity;
import app.base.BaseDomain;
/**
* Title: AcDebitDtl.java
* Description:
* @version��1.0
**/
public class AcDebitDtl extends BaseDomain {
	private String traceNo;//������ˮ��
	private String ddtlNo;//�ۿ���ϸ��ˮ��
	private String loanNo;//��ݺ�
	private String pactNo;//��ͬ��
	private String brNo;//������
	private String perdNo;//����
	private Double ddtlPrcpAmt;//ʵ�۱���
	private Double ddtlNormInt;//ʵ����Ϣ
	private Double ddtlFineInt;//ʵ�۷�Ϣ
	private Double ddtlFeeAmt;//ʵ�۷����ܼ�
	private Double ddtlAmt;//ʵ���ܽ��
	private String ddtlDate;//�ۿ���
	private String xtAcNo;//�����˺�
	private String ddtlAcNo;//�ۿ��˺�
	private String ddtlAcName;//�˻�����
	private String ddtlBankCode;//�������д���
	private String ddtlBankProv;//������������ʡ
	private String ddtlBankCity;//��������������
	private String ddtlBankSite;//������������
	private String ddtlSts;//�ۿ�״̬
	private String txDate;//�Ǽ�����
	private String txTime;//�Ǽ�ʱ��
	private String upDate;//����ʱ��

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
	 * @return �ۿ���ϸ��ˮ��
	 */
	public String getDdtlNo() {
	 	return ddtlNo;
	}
	/**
	 * @���� �ۿ���ϸ��ˮ��
	 * @param ddtlNo
	 */
	public void setDdtlNo(String ddtlNo) {
	 	this.ddtlNo = ddtlNo;
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
	 * @return ����
	 */
	public String getPerdNo() {
	 	return perdNo;
	}
	/**
	 * @���� ����
	 * @param perdNo
	 */
	public void setPerdNo(String perdNo) {
	 	this.perdNo = perdNo;
	}
	/**
	 * @return ʵ�۱���
	 */
	public Double getDdtlPrcpAmt() {
	 	return ddtlPrcpAmt;
	}
	/**
	 * @���� ʵ�۱���
	 * @param ddtlPrcpAmt
	 */
	public void setDdtlPrcpAmt(Double ddtlPrcpAmt) {
	 	this.ddtlPrcpAmt = ddtlPrcpAmt;
	}
	/**
	 * @return ʵ����Ϣ
	 */
	public Double getDdtlNormInt() {
	 	return ddtlNormInt;
	}
	/**
	 * @���� ʵ����Ϣ
	 * @param ddtlNormInt
	 */
	public void setDdtlNormInt(Double ddtlNormInt) {
	 	this.ddtlNormInt = ddtlNormInt;
	}
	/**
	 * @return ʵ�۷�Ϣ
	 */
	public Double getDdtlFineInt() {
	 	return ddtlFineInt;
	}
	/**
	 * @���� ʵ�۷�Ϣ
	 * @param ddtlFineInt
	 */
	public void setDdtlFineInt(Double ddtlFineInt) {
	 	this.ddtlFineInt = ddtlFineInt;
	}
	/**
	 * @return ʵ�۷����ܼ�
	 */
	public Double getDdtlFeeAmt() {
	 	return ddtlFeeAmt;
	}
	/**
	 * @���� ʵ�۷����ܼ�
	 * @param ddtlFeeAmt
	 */
	public void setDdtlFeeAmt(Double ddtlFeeAmt) {
	 	this.ddtlFeeAmt = ddtlFeeAmt;
	}
	/**
	 * @return ʵ���ܽ��
	 */
	public Double getDdtlAmt() {
	 	return ddtlAmt;
	}
	/**
	 * @���� ʵ���ܽ��
	 * @param ddtlAmt
	 */
	public void setDdtlAmt(Double ddtlAmt) {
	 	this.ddtlAmt = ddtlAmt;
	}
	/**
	 * @return �ۿ���
	 */
	public String getDdtlDate() {
	 	return ddtlDate;
	}
	/**
	 * @���� �ۿ���
	 * @param ddtlDate
	 */
	public void setDdtlDate(String ddtlDate) {
	 	this.ddtlDate = ddtlDate;
	}
	/**
	 * @return �����˺�
	 */
	public String getXtAcNo() {
	 	return xtAcNo;
	}
	/**
	 * @���� �����˺�
	 * @param xtAcNo
	 */
	public void setXtAcNo(String xtAcNo) {
	 	this.xtAcNo = xtAcNo;
	}
	/**
	 * @return �ۿ��˺�
	 */
	public String getDdtlAcNo() {
	 	return ddtlAcNo;
	}
	/**
	 * @���� �ۿ��˺�
	 * @param ddtlAcNo
	 */
	public void setDdtlAcNo(String ddtlAcNo) {
	 	this.ddtlAcNo = ddtlAcNo;
	}
	/**
	 * @return �˻�����
	 */
	public String getDdtlAcName() {
	 	return ddtlAcName;
	}
	/**
	 * @���� �˻�����
	 * @param ddtlAcName
	 */
	public void setDdtlAcName(String ddtlAcName) {
	 	this.ddtlAcName = ddtlAcName;
	}
	/**
	 * @return �������д���
	 */
	public String getDdtlBankCode() {
	 	return ddtlBankCode;
	}
	/**
	 * @���� �������д���
	 * @param ddtlBankCode
	 */
	public void setDdtlBankCode(String ddtlBankCode) {
	 	this.ddtlBankCode = ddtlBankCode;
	}
	/**
	 * @return ������������ʡ
	 */
	public String getDdtlBankProv() {
	 	return ddtlBankProv;
	}
	/**
	 * @���� ������������ʡ
	 * @param ddtlBankProv
	 */
	public void setDdtlBankProv(String ddtlBankProv) {
	 	this.ddtlBankProv = ddtlBankProv;
	}
	/**
	 * @return ��������������
	 */
	public String getDdtlBankCity() {
	 	return ddtlBankCity;
	}
	/**
	 * @���� ��������������
	 * @param ddtlBankCity
	 */
	public void setDdtlBankCity(String ddtlBankCity) {
	 	this.ddtlBankCity = ddtlBankCity;
	}
	/**
	 * @return ������������
	 */
	public String getDdtlBankSite() {
	 	return ddtlBankSite;
	}
	/**
	 * @���� ������������
	 * @param ddtlBankSite
	 */
	public void setDdtlBankSite(String ddtlBankSite) {
	 	this.ddtlBankSite = ddtlBankSite;
	}
	/**
	 * @return �ۿ�״̬
	 */
	public String getDdtlSts() {
	 	return ddtlSts;
	}
	/**
	 * @���� �ۿ�״̬
	 * @param ddtlSts
	 */
	public void setDdtlSts(String ddtlSts) {
	 	this.ddtlSts = ddtlSts;
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
	 * @return �Ǽ�ʱ��
	 */
	public String getTxTime() {
	 	return txTime;
	}
	/**
	 * @���� �Ǽ�ʱ��
	 * @param txTime
	 */
	public void setTxTime(String txTime) {
	 	this.txTime = txTime;
	}
	/**
	 * @return ����ʱ��
	 */
	public String getUpDate() {
	 	return upDate;
	}
	/**
	 * @���� ����ʱ��
	 * @param upDate
	 */
	public void setUpDate(String upDate) {
	 	this.upDate = upDate;
	}
}