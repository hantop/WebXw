package app.creditapp.fund.entity;
import app.base.BaseDomain;
/**
* Title: FundSplitTerm.java
* Description:
* @version��1.0
**/
public class FundSplitTerm extends BaseDomain {
	private String termNo;//�������
	private String fundNo;//�ʽ���
	private String partNo;//�������
	private Double termAmt;//��ģ
	private Float invRate;//������
	private String begDate;//��ʼ����
	private String endDate;//��������
	private Integer days;//��������
	private String filler;//��ע
	private String curNo;//����

	/**
	 * @return �������
	 */
	public String getTermNo() {
	 	return termNo;
	}
	/**
	 * @���� �������
	 * @param termNo
	 */
	public void setTermNo(String termNo) {
	 	this.termNo = termNo;
	}
	/**
	 * @return �ʽ���
	 */
	public String getFundNo() {
	 	return fundNo;
	}
	/**
	 * @���� �ʽ���
	 * @param fundNo
	 */
	public void setFundNo(String fundNo) {
	 	this.fundNo = fundNo;
	}
	/**
	 * @return �������
	 */
	public String getPartNo() {
	 	return partNo;
	}
	/**
	 * @���� �������
	 * @param partNo
	 */
	public void setPartNo(String partNo) {
	 	this.partNo = partNo;
	}
	/**
	 * @return ��ģ
	 */
	public Double getTermAmt() {
	 	return termAmt;
	}
	/**
	 * @���� ��ģ
	 * @param termAmt
	 */
	public void setTermAmt(Double termAmt) {
	 	this.termAmt = termAmt;
	}
	/**
	 * @return ������
	 */
	public Float getInvRate() {
	 	return invRate;
	}
	/**
	 * @���� ������
	 * @param invRate
	 */
	public void setInvRate(Float invRate) {
	 	this.invRate = invRate;
	}
	/**
	 * @return ��ʼ����
	 */
	public String getBegDate() {
	 	return begDate;
	}
	/**
	 * @���� ��ʼ����
	 * @param begDate
	 */
	public void setBegDate(String begDate) {
	 	this.begDate = begDate;
	}
	/**
	 * @return ��������
	 */
	public String getEndDate() {
	 	return endDate;
	}
	/**
	 * @���� ��������
	 * @param endDate
	 */
	public void setEndDate(String endDate) {
	 	this.endDate = endDate;
	}
	/**
	 * @return ��������
	 */
	public Integer getDays() {
	 	return days;
	}
	/**
	 * @���� ��������
	 * @param days
	 */
	public void setDays(Integer days) {
	 	this.days = days;
	}
	/**
	 * @return ��ע
	 */
	public String getFiller() {
	 	return filler;
	}
	/**
	 * @���� ��ע
	 * @param filler
	 */
	public void setFiller(String filler) {
	 	this.filler = filler;
	}
	/**
	 * @return ����
	 */
	public String getCurNo() {
	 	return curNo;
	}
	/**
	 * @���� ����
	 * @param curNo
	 */
	public void setCurNo(String curNo) {
	 	this.curNo = curNo;
	}
}