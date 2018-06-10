package accounting.domain.loan;
import app.base.BaseDomain;
/**
* Title: AcLoanLog.java
* Description:
* @���� su
* @���� 2018-3-20
* @version��1.0
**/
public class AcLoanLog extends accounting.domain.sys.CMISDomain {
	private String loanLogNo;//�ſ���ˮ��
	private String traceNo;//������ˮ��
	private String loanNo;//��ݺ�
	private String pactNo;//��ͬ��
	private String brNo;//������
	private double loanAmt;//�ſ���
	private String xtAcNo;//�����˺�
	private String loanAcNo;//�ſ��˺�
	private String loanAcType;//�˻�����[11�����˻�12��ҵ�˻�]
	private String loanAcName;//�˻�����
	private String loanBankCode;//�������д���
	private String loanBankProv;//������������ʡ
	private String loanBankCity;//��������������
	private String loanBankSite;//������������
	private String loanSts;//�ſ�״̬[01-�ѷ���,02-�ſ�ɹ�,03-�ſ�ʧ��]
	private String txDate;//�Ǽ�����
	private String txTime;//�Ǽ�ʱ��
	private String upDate;//����ʱ��
	private String cardChn;//֧������
	private String busEntryType;//��Ŀ��������
	private String idType;
	private String idNo;
	private String phoneNo;
	private String validDate;
	private String cvvNo;
	
	public String getLoanLogNo() {
		return loanLogNo;
	}
	public void setLoanLogNo(String loanLogNo) {
		this.loanLogNo = loanLogNo;
	}
	public String getTraceNo() {
		return traceNo;
	}
	public void setTraceNo(String traceNo) {
		this.traceNo = traceNo;
	}
	public String getLoanNo() {
		return loanNo;
	}
	public void setLoanNo(String loanNo) {
		this.loanNo = loanNo;
	}
	public String getPactNo() {
		return pactNo;
	}
	public void setPactNo(String pactNo) {
		this.pactNo = pactNo;
	}
	public String getBrNo() {
		return brNo;
	}
	public void setBrNo(String brNo) {
		this.brNo = brNo;
	}
	public double getLoanAmt() {
		return loanAmt;
	}
	public void setLoanAmt(double loanAmt) {
		this.loanAmt = loanAmt;
	}
	public String getLoanSts() {
		return loanSts;
	}
	public void setLoanSts(String loanSts) {
		this.loanSts = loanSts;
	}
	public String getXtAcNo() {
		return xtAcNo;
	}
	public void setXtAcNo(String xtAcNo) {
		this.xtAcNo = xtAcNo;
	}
	public String getLoanAcNo() {
		return loanAcNo;
	}
	public void setLoanAcNo(String loanAcNo) {
		this.loanAcNo = loanAcNo;
	}
	public String getLoanAcType() {
		return loanAcType;
	}
	public void setLoanAcType(String loanAcType) {
		this.loanAcType = loanAcType;
	}
	public String getLoanBankCode() {
		return loanBankCode;
	}
	public void setLoanBankCode(String loanBankCode) {
		this.loanBankCode = loanBankCode;
	}
	public String getLoanBankProv() {
		return loanBankProv;
	}
	public void setLoanBankProv(String loanBankProv) {
		this.loanBankProv = loanBankProv;
	}
	public String getLoanBankCity() {
		return loanBankCity;
	}
	public void setLoanBankCity(String loanBankCity) {
		this.loanBankCity = loanBankCity;
	}
	public String getLoanBankSite() {
		return loanBankSite;
	}
	public void setLoanBankSite(String loanBankSite) {
		this.loanBankSite = loanBankSite;
	}
	public String getTxDate() {
		return txDate;
	}
	public void setTxDate(String txDate) {
		this.txDate = txDate;
	}
	public String getTxTime() {
		return txTime;
	}
	public void setTxTime(String txTime) {
		this.txTime = txTime;
	}
	public String getUpDate() {
		return upDate;
	}
	public void setUpDate(String upDate) {
		this.upDate = upDate;
	}
	public String getLoanAcName() {
		return loanAcName;
	}
	public void setLoanAcName(String loanAcName) {
		this.loanAcName = loanAcName;
	}
	public String getCardChn() {
		return cardChn;
	}
	public void setCardChn(String cardChn) {
		this.cardChn = cardChn;
	}
	public String getBusEntryType() {
		return busEntryType;
	}
	public void setBusEntryType(String busEntryType) {
		this.busEntryType = busEntryType;
	}
	public String getIdType() {
		return idType;
	}
	public String getIdNo() {
		return idNo;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public String getValidDate() {
		return validDate;
	}
	public String getCvvNo() {
		return cvvNo;
	}
	public void setIdType(String idType) {
		this.idType = idType;
	}
	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public void setValidDate(String validDate) {
		this.validDate = validDate;
	}
	public void setCvvNo(String cvvNo) {
		this.cvvNo = cvvNo;
	}

	
}