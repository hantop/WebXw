package app.creditapp.inf.entity;

/**
 * @���� DHCC-LIU
 * @���� Jun 23, 2016
 * @����   �ۿ�����ѯ[2302]list ������
 */
public class WsOut2302_1 {
	
	private String pactNo;//��ͬ��
	private String serialNo;//�ۿ���ˮ��	
	private double repayTotal;//	ʵ�۽��
	private double repayAmt;//ʵ�۱���
	private double repayInte;//ʵ����Ϣ
	private double repayOver;//ʵ�۷�Ϣ
	private double feeTotal;//ʵ�۷��ܶ�
	private String dealSts;//�ۿ�״̬
	private String dealDesc;//�ۿ�����
	
	//���ݿ����У����ӿ��ĵ���û�е��ֶ�
	private String batchNo;//���κ�
	
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
	public double getRepayAmt() {
		return repayAmt;
	}
	public void setRepayAmt(double repayAmt) {
		this.repayAmt = repayAmt;
	}
	public double getRepayInte() {
		return repayInte;
	}
	public void setRepayInte(double repayInte) {
		this.repayInte = repayInte;
	}
	public double getRepayOver() {
		return repayOver;
	}
	public void setRepayOver(double repayOver) {
		this.repayOver = repayOver;
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
	public String getBatchNo() {
		return batchNo;
	}
	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}
	
	
	
	
}
