package app.creditapp.inf.entity;

/**
 * @���� DHCC-LIU
 * @���� Jun 23, 2016
 * @����   A��ۿ�����ѯ[2305]list ������
 */
public class WsOut2305_1 {
	
	private String pactNo;//��ͬ��
	private String serialNo;//�ۿ���ˮ��	
	private double repayTotal;//	ʵ�۽��
	private String  txDate;//��������
	private double feeTotal;//ʵ�۷��ܶ�
	private String dealSts;//�ۿ�״̬
	private String dealDesc;//�ۿ�����
	
	
	public String getPactNo() {
		return pactNo;
	}
	public void setPactNo(String pactNo) {
		this.pactNo = pactNo;
	}
	public String getSerialNo() {
		return serialNo;
	}
	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}
	public double getRepayTotal() {
		return repayTotal;
	}
	public void setRepayTotal(double repayTotal) {
		this.repayTotal = repayTotal;
	}
	public double getFeeTotal() {
		return feeTotal;
	}
	public void setFeeTotal(double feeTotal) {
		this.feeTotal = feeTotal;
	}
	public String getDealSts() {
		return dealSts;
	}
	public void setDealSts(String dealSts) {
		this.dealSts = dealSts;
	}
	public String getDealDesc() {
		return dealDesc;
	}
	public void setDealDesc(String dealDesc) {
		this.dealDesc = dealDesc;
	}
	public String getTxDate() {
		return txDate;
	}
	public void setTxDate(String txDate) {
		this.txDate = txDate;
	}
	
	
	
}
