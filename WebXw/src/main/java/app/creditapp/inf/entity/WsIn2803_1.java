package app.creditapp.inf.entity;
/**
 * A����ǰ������������[2803]
 *��������listʵ����
 */
public class WsIn2803_1 {

	private String pactNo;//��ͬ��[����]
	private double payTotal;//������
	
	private String dealSts;//����״̬
	private String dealDesc;//��������
	
	public WsIn2803_1() {
	
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
