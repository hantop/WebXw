package app.creditapp.inf.entity;

/**
 * @���� DHCC-ZKX
 * @���� July 22, 2016 
 * @����   B����ǰ����������������[2804] �������� list
 */
public class WsIn2804_1 {
	
	private String pactNo;//��ͬ�� [����]
	private double payTotal;//������[=4+5+6+7+8]
	private double payAmt;//�����
	private double payInte;//������Ϣ
	private double payOver;//��Ϣ
	private double feeTotal;//����
	private double feeDam	;//ΥԼ��
	
	private String dealSts;//����״̬
	private String dealDesc;//��������
	
	public WsIn2804_1() {
	
		dealSts = "01";
		dealDesc = "";
	}
	
	
	public String getPactNo() {
		return pactNo;
	}
	public void setPactNo(String pactNo) {
		this.pactNo = pactNo;
	}
	public double getPayTotal() {
		return payTotal;
	}
	public void setPayTotal(double payTotal) {
		this.payTotal = payTotal;
	}
	public double getPayAmt() {
		return payAmt;
	}
	public void setPayAmt(double payAmt) {
		this.payAmt = payAmt;
	}
	public double getPayInte() {
		return payInte;
	}
	public void setPayInte(double payInte) {
		this.payInte = payInte;
	}
	public double getPayOver() {
		return payOver;
	}
	public void setPayOver(double payOver) {
		this.payOver = payOver;
	}
	public double getFeeTotal() {
		return feeTotal;
	}
	public void setFeeTotal(double feeTotal) {
		this.feeTotal = feeTotal;
	}
	public double getFeeDam() {
		return feeDam;
	}
	public void setFeeDam(double feeDam) {
		this.feeDam = feeDam;
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
	
}
