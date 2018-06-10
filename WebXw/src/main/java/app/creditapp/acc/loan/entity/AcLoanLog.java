package app.creditapp.acc.loan.entity;
import app.base.BaseDomain;
/**
* Title: AcLoanLog.java
* Description:
* @version��1.0
**/
public class AcLoanLog extends BaseDomain {
	private String loanLogNo;//�ſ���ˮ��
	private String traceNo;//������ˮ��
	private String loanNo;//��ݺ�
	private String pactNo;//��ͬ��
	private String brNo;//������
	private Double loanAmt;//�ſ���
	private String xtAcNo;//�����˺�
	private String loanAcNo;//�ſ��˺�
	private String loanAcType;//�˻�����[11�����˻�12��ҵ�˻�]
	private String loanAcName;//�˻�����
	private String loanBankCode;//�������д���
	private String loanBankProv;//������������ʡ
	private String loanBankCity;//��������������
	private String loanBankSite;//������������
	private String loanSts;//�ſ�״̬[01-������,02-�ѷ���,03-�ſ�ɹ�,04-�ſ�ʧ��]
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

	/**
	 * @return �ſ���ˮ��
	 */
	public String getLoanLogNo() {
	 	return loanLogNo;
	}
	/**
	 * @���� �ſ���ˮ��
	 * @param loanLogNo
	 */
	public void setLoanLogNo(String loanLogNo) {
	 	this.loanLogNo = loanLogNo;
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
	 * @return �ſ���
	 */
	public Double getLoanAmt() {
	 	return loanAmt;
	}
	/**
	 * @���� �ſ���
	 * @param loanAmt
	 */
	public void setLoanAmt(Double loanAmt) {
	 	this.loanAmt = loanAmt;
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
	 * @return �ſ��˺�
	 */
	public String getLoanAcNo() {
	 	return loanAcNo;
	}
	/**
	 * @���� �ſ��˺�
	 * @param loanAcNo
	 */
	public void setLoanAcNo(String loanAcNo) {
	 	this.loanAcNo = loanAcNo;
	}
	/**
	 * @return �˻�����[11�����˻�12��ҵ�˻�]
	 */
	public String getLoanAcType() {
	 	return loanAcType;
	}
	/**
	 * @���� �˻�����[11�����˻�12��ҵ�˻�]
	 * @param loanAcType
	 */
	public void setLoanAcType(String loanAcType) {
	 	this.loanAcType = loanAcType;
	}
	/**
	 * @return �˻�����
	 */
	public String getLoanAcName() {
	 	return loanAcName;
	}
	/**
	 * @���� �˻�����
	 * @param loanAcName
	 */
	public void setLoanAcName(String loanAcName) {
	 	this.loanAcName = loanAcName;
	}
	/**
	 * @return �������д���
	 */
	public String getLoanBankCode() {
	 	return loanBankCode;
	}
	/**
	 * @���� �������д���
	 * @param loanBankCode
	 */
	public void setLoanBankCode(String loanBankCode) {
	 	this.loanBankCode = loanBankCode;
	}
	/**
	 * @return ������������ʡ
	 */
	public String getLoanBankProv() {
	 	return loanBankProv;
	}
	/**
	 * @���� ������������ʡ
	 * @param loanBankProv
	 */
	public void setLoanBankProv(String loanBankProv) {
	 	this.loanBankProv = loanBankProv;
	}
	/**
	 * @return ��������������
	 */
	public String getLoanBankCity() {
	 	return loanBankCity;
	}
	/**
	 * @���� ��������������
	 * @param loanBankCity
	 */
	public void setLoanBankCity(String loanBankCity) {
	 	this.loanBankCity = loanBankCity;
	}
	/**
	 * @return ������������
	 */
	public String getLoanBankSite() {
	 	return loanBankSite;
	}
	/**
	 * @���� ������������
	 * @param loanBankSite
	 */
	public void setLoanBankSite(String loanBankSite) {
	 	this.loanBankSite = loanBankSite;
	}
	/**
	 * @return �ſ�״̬[01-������,02-�ѷ���,03-�ſ�ɹ�,04-�ſ�ʧ��]
	 */
	public String getLoanSts() {
	 	return loanSts;
	}
	/**
	 * @���� �ſ�״̬[01-������,02-�ѷ���,03-�ſ�ɹ�,04-�ſ�ʧ��]
	 * @param loanSts
	 */
	public void setLoanSts(String loanSts) {
	 	this.loanSts = loanSts;
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