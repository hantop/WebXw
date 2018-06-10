package app.creditapp.fund.entity;
import app.base.BaseDomain;
/**
* Title: FundSplit.java
* Description:
* @version��1.0
**/
public class FundSplit extends BaseDomain {
	private String partNo;//�������
	private String partName;//�������
	private String fundNo;//�ʽ���
	private Integer partLevel;//��������	
	private Double partAmt;//������ģ
	private Float invRate;//������
	private String payType;//�Ҹ���ʽ
	private String begDate;//��ʼ����
	private String endDate;//��������
	private String txDate;//�Ǽ�����
	private String opNo;//�Ǽ���
	private Integer yearDays;//������
	private String payDay;//�Ҹ�����
	
	private String query;//ֻ��

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
	 * @return ��������
	 */
	public String getPartName() {
		return partName;
	}
	/**
	 * @���� ��������
	 * @param partName
	 */
	public void setPartName(String partName) {
		this.partName = partName;
	}
	/**
	 * @return �ʽ���
	 */
	public Integer getPartLevel() {
	 	return partLevel;
	}
	/**
	 * @���� �ʽ���
	 * @param fundNo
	 */
	public void setPartLevel(Integer partLevel) {
	 	this.partLevel = partLevel;
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
	 * @return ������ģ
	 */
	public Double getPartAmt() {
	 	return partAmt;
	}
	/**
	 * @���� ������ģ
	 * @param partAmt
	 */
	public void setPartAmt(Double partAmt) {
	 	this.partAmt = partAmt;
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
	 * @return �Ҹ���ʽ
	 */
	public String getPayType() {
	 	return payType;
	}
	/**
	 * @���� �Ҹ���ʽ
	 * @param payType
	 */
	public void setPayType(String payType) {
	 	this.payType = payType;
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
	 * @return �Ǽ�����
	 */
	public String getTxDate() {
	 	return txDate;
	}
	/**
	 * @���� �Ǽ�����
	 * @param txDate
	 */
	public void setTxDate(String txDate) {
	 	this.txDate = txDate;
	}
	/**
	 * @return �Ǽ���
	 */
	public String getOpNo() {
	 	return opNo;
	}
	/**
	 * @���� �Ǽ���
	 * @param opNo
	 */
	public void setOpNo(String opNo) {
	 	this.opNo = opNo;
	}
	/**
	 * @return ������
	 */
	public Integer getYearDays() {
	 	return yearDays;
	}
	/**
	 * @���� ������
	 * @param yearDays
	 */
	public void setYearDays(Integer yearDays) {
	 	this.yearDays = yearDays;
	}
	public String getPayDay() {
		return payDay;
	}
	public void setPayDay(String payDay) {
		this.payDay = payDay;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
}