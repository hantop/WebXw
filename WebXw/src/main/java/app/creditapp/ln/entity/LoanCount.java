package app.creditapp.ln.entity;

import app.base.BaseDomain;

/**
 * @title �ſ�ͳ��
 * @author supenghui
 */
public class LoanCount extends BaseDomain{
//	private String loanCountNo;
	private String batchNo;  //���κ�
	private String brNo;     //����������
	private String pactNo;   //��ͬ��
	private String cifName;  //�ͻ���
	private String upDate;   //����ʱ��
	private String curNo;    //����
	private String loanAmt;  //�ſ���
	private String loanSts;  //�ſ�״̬
	private String loanBankCode;  //�������д���
	private String loanAcNo;  //�ſ��˺�
	private String cardChn;    //֧������
	private String projNo;    //��Ŀ��
	private String begDt;    //��ʼ����
	private String endDt;    //��ֹ����
	private String loginid;//��¼��Ա
	
	public String getLoginid() {
		return loginid;
	}
	public void setLoginid(String loginid) {
		this.loginid = loginid;
	}
	//	public String getLoanCountNo() {
//		return loanCountNo;
//	}
//	public void setLoanCountNo(String loanCountNo) {
//		this.loanCountNo = loanCountNo;
//	}
	public String getBatchNo() {
		return batchNo;
	}
	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}
	public String getBrNo() {
		return brNo;
	}
	public void setBrNo(String brNo) {
		this.brNo = brNo;
	}
	public String getPactNo() {
		return pactNo;
	}
	public void setPactNo(String pactNo) {
		this.pactNo = pactNo;
	}
	public String getCifName() {
		return cifName;
	}
	public void setCifName(String cifName) {
		this.cifName = cifName;
	}
	public String getUpDate() {
		return upDate;
	}
	public void setUpDate(String upDate) {
		this.upDate = upDate;
	}
	public String getCurNo() {
		return curNo;
	}
	public void setCurNo(String curNo) {
		this.curNo = curNo;
	}
	public String getLoanSts() {
		return loanSts;
	}
	public void setLoanSts(String loanSts) {
		this.loanSts = loanSts;
	}
	public String getLoanBankCode() {
		return loanBankCode;
	}
	public void setLoanBankCode(String loanBankCode) {
		this.loanBankCode = loanBankCode;
	}
	public String getLoanAcNo() {
		return loanAcNo;
	}
	public void setLoanAcNo(String loanAcNo) {
		this.loanAcNo = loanAcNo;
	}
	public String getCardChn() {
		return cardChn;
	}
	public void setCardChn(String cardChn) {
		this.cardChn = cardChn;
	}
	public String getProjNo() {
		return projNo;
	}
	public void setProjNo(String projNo) {
		this.projNo = projNo;
	}
	public String getBegDt() {
		return begDt;
	}
	public void setBegDt(String begDt) {
		this.begDt = begDt;
	}
	public String getEndDt() {
		return endDt;
	}
	public void setEndDt(String endDt) {
		this.endDt = endDt;
	}
	public String getLoanAmt() {
		return loanAmt;
	}
	public void setLoanAmt(String loanAmt) {
		this.loanAmt = loanAmt;
	}
	
	

}
