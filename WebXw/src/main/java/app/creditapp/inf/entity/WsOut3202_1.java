package app.creditapp.inf.entity;

import java.util.List;

/**
 * @���� DHCC-LIU
 * @���� Jun 23, 2016 list
 * @����   �˻���ˮ��ѯ[3202] �����Ϣ
 */
public class WsOut3202_1{

	private String traceNo;//��ˮ��
	private String pactNo;//��ͬ��
	private String txCode;//������
	private String txDate;//��������
	private String txTime;//����ʱ��
	private double txAmt;//������
	private String memo;//ժҪ
	
	public String getTraceNo() {
		return traceNo;
	}
	public void setTraceNo(String traceNo) {
		this.traceNo = traceNo;
	}
	public String getPactNo() {
		return pactNo;
	}
	public void setPactNo(String pactNo) {
		this.pactNo = pactNo;
	}
	public String getTxCode() {
		return txCode;
	}
	public void setTxCode(String txCode) {
		this.txCode = txCode;
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
	public double getTxAmt() {
		return txAmt;
	}
	public void setTxAmt(double txAmt) {
		this.txAmt = txAmt;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}

	
}
