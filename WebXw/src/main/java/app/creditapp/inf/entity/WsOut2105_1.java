package app.creditapp.inf.entity;
/**
 * @���� DHCC-ZKX
 * @���� July 26, 2016
 * @����   ��ͬ��Ϣ��ѯ--���ʵ����list
 */
public class WsOut2105_1 {

	private String pactNo;//��ͬ��
	private String custName;//���������
	private String prdtNo;//��Ʒ���
	private String projNo;//��Ŀ���
	private double pactAmt;//��ͬ���
	private double bal;//��ͬ���
	private String begDate;//�ſ�����
	private String endDate;//��������
	private String expMtrDt;//չ�ڵ�����
	private double expRate;//չ������
	private String repayDay;//������
	private double lnRate;//������
	private double lnRateYear;//������
	private String lnSts;//��ͬ״̬[01-���� 02-������ 03-���� 04-���� 05-�ѻع� 06-��ͬȡ��]
	
	
	public double getLnRateYear() {
		return lnRateYear;
	}
	public void setLnRateYear(double lnRateYear) {
		this.lnRateYear = lnRateYear;
	}
	public String getPactNo() {
		return pactNo;
	}
	public void setPactNo(String pactNo) {
		this.pactNo = pactNo;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getPrdtNo() {
		return prdtNo;
	}
	public void setPrdtNo(String prdtNo) {
		this.prdtNo = prdtNo;
	}
	public String getProjNo() {
		return projNo;
	}
	public void setProjNo(String projNo) {
		this.projNo = projNo;
	}
	public String getBegDate() {
		return begDate;
	}
	public void setBegDate(String begDate) {
		this.begDate = begDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getExpMtrDt() {
		return expMtrDt;
	}
	public void setExpMtrDt(String expMtrDt) {
		this.expMtrDt = expMtrDt;
	}
	public String getRepayDay() {
		return repayDay;
	}
	public void setRepayDay(String repayDay) {
		this.repayDay = repayDay;
	}
	public String getLnSts() {
		return lnSts;
	}
	public void setLnSts(String lnSts) {
		this.lnSts = lnSts;
	}
	public double getPactAmt() {
		return pactAmt;
	}
	public void setPactAmt(double pactAmt) {
		this.pactAmt = pactAmt;
	}
	public double getBal() {
		return bal;
	}
	public void setBal(double bal) {
		this.bal = bal;
	}
	public double getExpRate() {
		return expRate;
	}
	public void setExpRate(double expRate) {
		this.expRate = expRate;
	}
	public double getLnRate() {
		return lnRate;
	}
	public void setLnRate(double lnRate) {
		this.lnRate = lnRate;
	}

}
