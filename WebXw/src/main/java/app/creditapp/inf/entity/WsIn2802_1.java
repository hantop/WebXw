package app.creditapp.inf.entity;

/**
 * @���� DHCC-ZKX
 * @���� July 22, 2016
 * listPlan
 * @����   B����ǰ��������[2802] �������� 
 */
public class WsIn2802_1 {
	private String pactNo;//��ͬ�ţ���ͬ��+�ڴ�Ϊ����
	private int cnt;//�ڴ�
	private int begDt;//��ʼ����
	private int endDt;//��ֹ����
	private double instmAmt;//�ڹ���=���ڱ���+������Ϣ
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
	public int getBegDt() {
		return begDt;
	}
	public void setBegDt(int begDt) {
		this.begDt = begDt;
	}
	public int getEndDt() {
		return endDt;
	}
	public void setEndDt(int endDt) {
		this.endDt = endDt;
	}
	public double getInstmAmt() {
		return instmAmt;
	}
	public void setInstmAmt(double instmAmt) {
		this.instmAmt = instmAmt;
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
	
}
