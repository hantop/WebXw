package app.creditapp.inf.entity;

/**
 * @���� DHCC-ZKX
 * @���� July 18, 2016
 * list
 * @����   ����ƻ��ϴ�--����ʵ����
 */
public class WsIn2201_1 {
	private String pactNo;//��ͬ�ţ���ͬ��+�ڴ�Ϊ����
	private int cnt;//�ڴ�
	private int begDate;//��ʼ����
	private int endDate;//��ֹ����
	private double totalAmt;//�ڹ���=���ڱ���+������Ϣ
	private double prcpAmt;//���ڱ���
	private double normInt;//������Ϣ
	//���ݿ����У�����������û�е�
	private String brNo;//�����������
	private String batchNo;//���κ�
	
	public String getPactNo() {
		return pactNo;
	}
	public void setPactNo(String pactNo) {
		this.pactNo = pactNo;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public int getEndDate() {
		return endDate;
	}
	public void setEndDate(int endDate) {
		this.endDate = endDate;
	}
	public double getTotalAmt() {
		return totalAmt;
	}
	public void setTotalAmt(double totalAmt) {
		this.totalAmt = totalAmt;
	}
	public double getPrcpAmt() {
		return prcpAmt;
	}
	public void setPrcpAmt(double prcpAmt) {
		this.prcpAmt = prcpAmt;
	}
	public double getNormInt() {
		return normInt;
	}
	public void setNormInt(double normInt) {
		this.normInt = normInt;
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
	public int getBegDate() {
		return begDate;
	}
	public void setBegDate(int begDate) {
		this.begDate = begDate;
	}
	
}
