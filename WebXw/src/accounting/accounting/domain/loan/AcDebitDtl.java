package accounting.domain.loan;
import app.base.BaseDomain;
/**
* Title: AcDebitDtl.java
* Description:
* @���� su
* @���� 2018-3-20
* @version��1.0
**/
public class AcDebitDtl extends accounting.domain.sys.CMISDomain {
	private String traceNo;//������ˮ��
	private String ddtlNo;//�ۿ���ϸ��ˮ��
	private String loanNo;//��ݺ�
	private String pactNo;//��ͬ��
	private String brNo;//������
	private String perdNo;//�ڴκ�
	private double ddtlPrcpAmt;//ʵ�۱���
	private double ddtlNormInt;//ʵ����Ϣ
	private double ddtlFineInt;//ʵ�۷�Ϣ
	private double ddtlFeeAmt;//ʵ�۷����ܼ�
	private double ddtlAmt;//ʵ���ܽ��
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
	
	public String getTraceNo() {
		return traceNo;
	}
	public String getDdtlNo() {
		return ddtlNo;
	}
	public String getLoanNo() {
		return loanNo;
	}
	public String getPactNo() {
		return pactNo;
	}
	public String getBrNo() {
		return brNo;
	}
	public double getDdtlPrcpAmt() {
		return ddtlPrcpAmt;
	}
	public double getDdtlNormInt() {
		return ddtlNormInt;
	}
	public double getDdtlFineInt() {
		return ddtlFineInt;
	}
	public double getDdtlFeeAmt() {
		return ddtlFeeAmt;
	}
	public double getDdtlAmt() {
		return ddtlAmt;
	}
	public String getXtAcNo() {
		return xtAcNo;
	}
	public String getDdtlAcNo() {
		return ddtlAcNo;
	}
	public String getDdtlAcName() {
		return ddtlAcName;
	}
	public String getDdtlBankCode() {
		return ddtlBankCode;
	}
	public String getDdtlBankProv() {
		return ddtlBankProv;
	}
	public String getDdtlBankCity() {
		return ddtlBankCity;
	}
	public String getDdtlBankSite() {
		return ddtlBankSite;
	}
	public String getDdtlSts() {
		return ddtlSts;
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
	public void setTraceNo(String traceNo) {
		this.traceNo = traceNo;
	}
	public void setDdtlNo(String ddtlNo) {
		this.ddtlNo = ddtlNo;
	}
	public void setLoanNo(String loanNo) {
		this.loanNo = loanNo;
	}
	public void setPactNo(String pactNo) {
		this.pactNo = pactNo;
	}
	public void setBrNo(String brNo) {
		this.brNo = brNo;
	}
	public void setDdtlPrcpAmt(double ddtlPrcpAmt) {
		this.ddtlPrcpAmt = ddtlPrcpAmt;
	}
	public void setDdtlNormInt(double ddtlNormInt) {
		this.ddtlNormInt = ddtlNormInt;
	}
	public void setDdtlFineInt(double ddtlFineInt) {
		this.ddtlFineInt = ddtlFineInt;
	}
	public void setDdtlFeeAmt(double ddtlFeeAmt) {
		this.ddtlFeeAmt = ddtlFeeAmt;
	}
	public void setDdtlAmt(double ddtlAmt) {
		this.ddtlAmt = ddtlAmt;
	}
	public void setXtAcNo(String xtAcNo) {
		this.xtAcNo = xtAcNo;
	}
	public void setDdtlAcNo(String ddtlAcNo) {
		this.ddtlAcNo = ddtlAcNo;
	}
	public void setDdtlAcName(String ddtlAcName) {
		this.ddtlAcName = ddtlAcName;
	}
	public void setDdtlBankCode(String ddtlBankCode) {
		this.ddtlBankCode = ddtlBankCode;
	}
	public void setDdtlBankProv(String ddtlBankProv) {
		this.ddtlBankProv = ddtlBankProv;
	}
	public void setDdtlBankCity(String ddtlBankCity) {
		this.ddtlBankCity = ddtlBankCity;
	}
	public void setDdtlBankSite(String ddtlBankSite) {
		this.ddtlBankSite = ddtlBankSite;
	}
	public void setDdtlSts(String ddtlSts) {
		this.ddtlSts = ddtlSts;
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
	public String getDdtlDate() {
		return ddtlDate;
	}
	public void setDdtlDate(String ddtlDate) {
		this.ddtlDate = ddtlDate;
	}
	public String getPerdNo() {
		return perdNo;
	}
	public void setPerdNo(String perdNo) {
		this.perdNo = perdNo;
	}
}