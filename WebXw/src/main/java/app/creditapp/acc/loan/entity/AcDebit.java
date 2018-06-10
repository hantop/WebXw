package app.creditapp.acc.loan.entity;
import app.base.BaseDomain;
/**
* Title: AcDebit.java
* @version��1.0
**/
public class AcDebit extends BaseDomain {
	private String traceNo;//������ˮ��
	private Integer traceCnt;//������ˮ�����
	private String debitNo;//������ˮ��
	private String txDt;//������
	private Integer dcNo;//��¼��ˮ��
	private String loanNo;//��ݺ�
	private String pactNo;//��ͬ��
	private String brNo;//������
	private String acctBankCde;//�ۿ��ʺ����д���
	private String acNo;//�ۿ��˺�
	private String xtAcNo;//�����˺�/���������˺�
	private String curNo;//�ۿ����
	private String debitType;//�ۿ����[01-��������02-����]
	private Double atpyAmt;//Ӧ�۽��
	private Double loAmt;//Ӧ��Ƿ����
	private Double curAmt;//Ӧ�۱��ڽ��
	private Double myFeeAmt;//���շѽ��
	private Double otherFeeAmt;//���շѽ��
	private Double repayAmt;//ʵ�����
	private String sts;//����״̬
	private String createDt;//��������
	private String spoolDt;//�����ļ�����
	private String rtnDt;//�ۿ������
	private String rtnTime;//�ۿ��ʱ��
	private Integer rtnTraceNo;//���Ĵ�����ˮ��
	private Integer revseTraceNo;//����������ˮ��
	private String errDesc;//ʧ��ԭ��
	private String acType;//�˻�����[10-���˴��ǿ��˻� 11-���˽�ǿ��˻� 12-��ҵ�˻�]
	private String acName;//�ʻ�����
	private String bankCode;//�������д���
	private String bankProv;//������������ʡ
	private String bankCity;//��������������
	private String bankSite;//������������
	private String cardChn;//֧������
	private String busEntryType;//��Ŀ��������
	private String idType;
	private String idNo;
	private String phoneNo;
	private String validDate;
	private String cvvNo;

	private String failCaus;
	private String debitMold;//��������
	private String loginid;//��¼��Ա
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
	 * @return ������ˮ�����
	 */
	public Integer getTraceCnt() {
	 	return traceCnt;
	}
	/**
	 * @���� ������ˮ�����
	 * @param traceCnt
	 */
	public void setTraceCnt(Integer traceCnt) {
	 	this.traceCnt = traceCnt;
	}
	/**
	 * @return ������ˮ��
	 */
	public String getDebitNo() {
	 	return debitNo;
	}
	/**
	 * @���� ������ˮ��
	 * @param debitNo
	 */
	public void setDebitNo(String debitNo) {
	 	this.debitNo = debitNo;
	}
	/**
	 * @return ������
	 */
	public String getTxDt() {
	 	return txDt;
	}
	/**
	 * @���� ������
	 * @param txDt
	 */
	public void setTxDt(String txDt) {
	 	this.txDt = txDt;
	}
	/**
	 * @return ��¼��ˮ��
	 */
	public Integer getDcNo() {
	 	return dcNo;
	}
	/**
	 * @���� ��¼��ˮ��
	 * @param dcNo
	 */
	public void setDcNo(Integer dcNo) {
	 	this.dcNo = dcNo;
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
	 * @return �ۿ��ʺ����д���
	 */
	public String getAcctBankCde() {
	 	return acctBankCde;
	}
	/**
	 * @���� �ۿ��ʺ����д���
	 * @param acctBankCde
	 */
	public void setAcctBankCde(String acctBankCde) {
	 	this.acctBankCde = acctBankCde;
	}
	/**
	 * @return �ۿ��˺�
	 */
	public String getAcNo() {
	 	return acNo;
	}
	/**
	 * @���� �ۿ��˺�
	 * @param acNo
	 */
	public void setAcNo(String acNo) {
	 	this.acNo = acNo;
	}
	/**
	 * @return �����˺�/���������˺�
	 */
	public String getXtAcNo() {
	 	return xtAcNo;
	}
	/**
	 * @���� �����˺�/���������˺�
	 * @param xtAcNo
	 */
	public void setXtAcNo(String xtAcNo) {
	 	this.xtAcNo = xtAcNo;
	}
	/**
	 * @return �ۿ����
	 */
	public String getCurNo() {
	 	return curNo;
	}
	/**
	 * @���� �ۿ����
	 * @param curNo
	 */
	public void setCurNo(String curNo) {
	 	this.curNo = curNo;
	}
	/**
	 * @return �ۿ����[01-��������02-����]
	 */
	public String getDebitType() {
	 	return debitType;
	}
	/**
	 * @���� �ۿ����[01-��������02-����]
	 * @param debitType
	 */
	public void setDebitType(String debitType) {
	 	this.debitType = debitType;
	}
	/**
	 * @return Ӧ�۽��
	 */
	public Double getAtpyAmt() {
	 	return atpyAmt;
	}
	/**
	 * @���� Ӧ�۽��
	 * @param atpyAmt
	 */
	public void setAtpyAmt(Double atpyAmt) {
	 	this.atpyAmt = atpyAmt;
	}
	/**
	 * @return Ӧ��Ƿ����
	 */
	public Double getLoAmt() {
	 	return loAmt;
	}
	/**
	 * @���� Ӧ��Ƿ����
	 * @param loAmt
	 */
	public void setLoAmt(Double loAmt) {
	 	this.loAmt = loAmt;
	}
	/**
	 * @return Ӧ�۱��ڽ��
	 */
	public Double getCurAmt() {
	 	return curAmt;
	}
	/**
	 * @���� Ӧ�۱��ڽ��
	 * @param curAmt
	 */
	public void setCurAmt(Double curAmt) {
	 	this.curAmt = curAmt;
	}
	/**
	 * @return ʵ�����
	 */
	public Double getRepayAmt() {
	 	return repayAmt;
	}
	/**
	 * @���� ʵ�����
	 * @param repayAmt
	 */
	public void setRepayAmt(Double repayAmt) {
	 	this.repayAmt = repayAmt;
	}
	/**
	 * @return ����״̬
	 */
	public String getSts() {
	 	return sts;
	}
	/**
	 * @���� ����״̬
	 * @param sts
	 */
	public void setSts(String sts) {
	 	this.sts = sts;
	}
	/**
	 * @return ��������
	 */
	public String getCreateDt() {
	 	return createDt;
	}
	/**
	 * @���� ��������
	 * @param createDt
	 */
	public void setCreateDt(String createDt) {
	 	this.createDt = createDt;
	}
	/**
	 * @return �����ļ�����
	 */
	public String getSpoolDt() {
	 	return spoolDt;
	}
	/**
	 * @���� �����ļ�����
	 * @param spoolDt
	 */
	public void setSpoolDt(String spoolDt) {
	 	this.spoolDt = spoolDt;
	}
	/**
	 * @return �ۿ������
	 */
	public String getRtnDt() {
	 	return rtnDt;
	}
	/**
	 * @���� �ۿ������
	 * @param rtnDt
	 */
	public void setRtnDt(String rtnDt) {
	 	this.rtnDt = rtnDt;
	}
	/**
	 * @return �ۿ��ʱ��
	 */
	public String getRtnTime() {
	 	return rtnTime;
	}
	/**
	 * @���� �ۿ��ʱ��
	 * @param rtnTime
	 */
	public void setRtnTime(String rtnTime) {
	 	this.rtnTime = rtnTime;
	}
	/**
	 * @return ���Ĵ�����ˮ��
	 */
	public Integer getRtnTraceNo() {
	 	return rtnTraceNo;
	}
	/**
	 * @���� ���Ĵ�����ˮ��
	 * @param rtnTraceNo
	 */
	public void setRtnTraceNo(Integer rtnTraceNo) {
	 	this.rtnTraceNo = rtnTraceNo;
	}
	/**
	 * @return ����������ˮ��
	 */
	public Integer getRevseTraceNo() {
	 	return revseTraceNo;
	}
	/**
	 * @���� ����������ˮ��
	 * @param revseTraceNo
	 */
	public void setRevseTraceNo(Integer revseTraceNo) {
	 	this.revseTraceNo = revseTraceNo;
	}
	/**
	 * @return ʧ��ԭ��
	 */
	public String getErrDesc() {
	 	return errDesc;
	}
	/**
	 * @���� ʧ��ԭ��
	 * @param errDesc
	 */
	public void setErrDesc(String errDesc) {
	 	this.errDesc = errDesc;
	}
	public Double getMyFeeAmt() {
		return myFeeAmt;
	}
	public Double getOtherFeeAmt() {
		return otherFeeAmt;
	}
	public void setMyFeeAmt(Double myFeeAmt) {
		this.myFeeAmt = myFeeAmt;
	}
	public void setOtherFeeAmt(Double otherFeeAmt) {
		this.otherFeeAmt = otherFeeAmt;
	}
	public String getAcName() {
		return acName;
	}
	public String getBankCode() {
		return bankCode;
	}
	public String getBankProv() {
		return bankProv;
	}
	public String getBankCity() {
		return bankCity;
	}
	public String getBankSite() {
		return bankSite;
	}
	public void setAcName(String acName) {
		this.acName = acName;
	}
	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}
	public void setBankProv(String bankProv) {
		this.bankProv = bankProv;
	}
	public void setBankCity(String bankCity) {
		this.bankCity = bankCity;
	}
	public void setBankSite(String bankSite) {
		this.bankSite = bankSite;
	}
	public String getAcType() {
		return acType;
	}
	public void setAcType(String acType) {
		this.acType = acType;
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
	public String getFailCaus() {
		return failCaus;
	}
	public void setFailCaus(String failCaus) {
		this.failCaus = failCaus;
	}
	public String getDebitMold() {
		return debitMold;
	}
	public void setDebitMold(String debitMold) {
		this.debitMold = debitMold;
	}
	public String getLoginid() {
		return loginid;
	}
	public void setLoginid(String loginid) {
		this.loginid = loginid;
	}
}