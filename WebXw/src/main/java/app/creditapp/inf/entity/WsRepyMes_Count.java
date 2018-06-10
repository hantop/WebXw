package app.creditapp.inf.entity;

import app.base.BaseDomain;
/**
* Title: WsRepyMes_Count.java
* Description:
* @version��1.0
**/
public class WsRepyMes_Count extends BaseDomain {
	
	private String brNo;//�����������
	private String brName;//������������
	private String deal_sts;//�ۿ�״̬[]
	private String deal_desc;//�ۿ�����
	private Integer repay_count;//����
	private Double repay_sum;//���۷��ܶ�:������������ȡ
	private String txDate;//�ۿ�����
	private String txTime;//��ʼʱ��
	private String endTime;//����ʱ��
	
	public String getBrNo() {
		return brNo;
	}
	public void setBrNo(String brNo) {
		this.brNo = brNo;
	}
	public String getBrName() {
		return brName;
	}
	public void setBrName(String brName) {
		this.brName = brName;
	}
	public String getDeal_sts() {
		return deal_sts;
	}
	public void setDeal_sts(String deal_sts) {
		this.deal_sts = deal_sts;
	}
	public String getDeal_desc() {
		return deal_desc;
	}
	public void setDeal_desc(String deal_desc) {
		this.deal_desc = deal_desc;
	}
	public Integer getRepay_count() {
		return repay_count;
	}
	public void setRepay_count(Integer repay_count) {
		this.repay_count = repay_count;
	}
	public Double getRepay_sum() {
		return repay_sum;
	}
	public void setRepay_sum(Double repay_sum) {
		this.repay_sum = repay_sum;
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
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	
}