package app.creditapp.ln.entity;

import app.base.BaseDomain;

/**
 * @title �ۿ�ͳ��
 * @author supenghui
 */
public class DebitCount extends BaseDomain {
//	private String debitNo; //�ۿ��
	private String txTime;  //����
	private String brNo;   //����������
	private String projNo;  //��Ŀ��
	private String pactNo;  //��ͬ��
	private String perdNo;  //�ڴ�
	private String cifName;  //�ͻ���
	private String repayPrcpAmt;  //����
	private String repayNormInt;  //��Ϣ
	private String repayFineInt;  //��Ϣ
	private String repayFeeAmt;   //����
	private String repayCount;    //��������
	private String txCde;    //����
	private String areaName;  //����
	private String begDt;    //��ʼ����
	private String endDt;    //��ֹ����
	private String loginid;//��¼��Ա
	
	public String getLoginid() {
		return loginid;
	}
	public void setLoginid(String loginid) {
		this.loginid = loginid;
	}
	//	public String getDebitNo() {
//		return debitNo;
//	}
//	public void setDebitNo(String debitNo) {
//		this.debitNo = debitNo;
//	}
	public String getTxTime() {
		return txTime;
	}
	public void setTxTime(String txTime) {
		this.txTime = txTime;
	}
	public String getProjNo() {
		return projNo;
	}
	public void setProjNo(String projNo) {
		this.projNo = projNo;
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
	public String getRepayPrcpAmt() {
		return repayPrcpAmt;
	}
	public void setRepayPrcpAmt(String repayPrcpAmt) {
		this.repayPrcpAmt = repayPrcpAmt;
	}
	public String getRepayNormInt() {
		return repayNormInt;
	}
	public void setRepayNormInt(String repayNormInt) {
		this.repayNormInt = repayNormInt;
	}
	public String getRepayFineInt() {
		return repayFineInt;
	}
	public void setRepayFineInt(String repayFineInt) {
		this.repayFineInt = repayFineInt;
	}
	public String getRepayFeeAmt() {
		return repayFeeAmt;
	}
	public void setRepayFeeAmt(String repayFeeAmt) {
		this.repayFeeAmt = repayFeeAmt;
	}
	public String getRepayCount() {
		return repayCount;
	}
	public void setRepayCount(String repayCount) {
		this.repayCount = repayCount;
	}
	public String getTxCde() {
		return txCde;
	}
	public void setTxCde(String txCde) {
		this.txCde = txCde;
	}
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
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
	public String getPerdNo() {
		return perdNo;
	}
	public void setPerdNo(String perdNo) {
		this.perdNo = perdNo;
	}
	public String getBrNo() {
		return brNo;
	}
	public void setBrNo(String brNo) {
		this.brNo = brNo;
	}
	
	

}
