package app.creditapp.approve.entity;

import app.base.BaseDomain;

/**
 * ������������������� ������LN_APP_IDEA
 * 
 * @see
 * @�޸���־��
 * 
 */
public class LnAppIdea extends BaseDomain implements java.io.Serializable {
	public LnAppIdea() {
	}
	
	private String ideaId; // ���ID
	private String appId; // ����ID
	private String apprId; // ��������ID
	private String apprType; // ��������[01�Զ�02�˹�]
	private String apprTime; // ����ʱ��
	private String apprOpt; // ������
	private String apprIdea; // �������[01ͬ��02���03����04�˻�]
	private String apprDesc; // ��������
	private String apprOp; // ������
	
	//��������
	private String batchNo;  //���κ�
	private String brNo;     //�������
	private String projNo;   //��Ŀ���
	private String lnType;   //��������
	private String numAppr;   //����
	private String sumPactAmt;  //���ܽ��
	private String averPactAmt;  //ƽ�����
	
	
	
	
	
	public String getIdeaId() {
		return ideaId;
	}
	public void setIdeaId(String ideaId) {
		this.ideaId = ideaId;
	}
	public String getAppId() {
		return appId;
	}
	public void setAppId(String appId) {
		this.appId = appId;
	}
	public String getApprId() {
		return apprId;
	}
	public void setApprId(String apprId) {
		this.apprId = apprId;
	}
	public String getApprType() {
		return apprType;
	}
	public void setApprType(String apprType) {
		this.apprType = apprType;
	}
	public String getApprTime() {
		return apprTime;
	}
	public void setApprTime(String apprTime) {
		this.apprTime = apprTime;
	}
	public String getApprOpt() {
		return apprOpt;
	}
	public void setApprOpt(String apprOpt) {
		this.apprOpt = apprOpt;
	}
	public String getApprIdea() {
		return apprIdea;
	}
	public void setApprIdea(String apprIdea) {
		this.apprIdea = apprIdea;
	}
	public String getApprDesc() {
		return apprDesc;
	}
	public void setApprDesc(String apprDesc) {
		this.apprDesc = apprDesc;
	}
	public String getApprOp() {
		return apprOp;
	}
	public void setApprOp(String apprOp) {
		this.apprOp = apprOp;
	}
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
	public String getProjNo() {
		return projNo;
	}
	public void setProjNo(String projNo) {
		this.projNo = projNo;
	}
	public String getLnType() {
		return lnType;
	}
	public void setLnType(String lnType) {
		this.lnType = lnType;
	}
	public String getNumAppr() {
		return numAppr;
	}
	public void setNumAppr(String numAppr) {
		this.numAppr = numAppr;
	}
	public String getSumPactAmt() {
		return sumPactAmt;
	}
	public void setSumPactAmt(String sumPactAmt) {
		this.sumPactAmt = sumPactAmt;
	}
	public String getAverPactAmt() {
		return averPactAmt;
	}
	public void setAverPactAmt(String averPactAmt) {
		this.averPactAmt = averPactAmt;
	}
}