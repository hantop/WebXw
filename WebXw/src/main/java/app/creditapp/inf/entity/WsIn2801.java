package app.creditapp.inf.entity;

/**
 * A����ǰ���������[2801]
 *��������ʵ����
 */
public class WsIn2801 {
	private String brNo;//	����������
	private String pactNo;//	��ͬ��  : ����
	private double payTotal;//	������
	private String onlinOff;//���� 01 ���� 02
	private String debitType; // ��������  01-���ֻ���  02-ȫ���
	private double payAmt;//	�������
	
	private String dealSts;//����״̬
	private String dealDesc;//��������
	
	public WsIn2801() {
	
		dealSts = "01";
		dealDesc = "";
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
	public double getPayTotal() {
		return payTotal;
	}
	public void setPayTotal(double payTotal) {
		this.payTotal = payTotal;
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


	public String getOnlinOff() {
		return onlinOff;
	}


	public void setOnlinOff(String onlinOff) {
		this.onlinOff = onlinOff;
	}


	public String getDebitType() {
		return debitType;
	}


	public void setDebitType(String debitType) {
		this.debitType = debitType;
	}


	public double getPayAmt() {
		return payAmt;
	}


	public void setPayAmt(double payAmt) {
		this.payAmt = payAmt;
	}
	
}
