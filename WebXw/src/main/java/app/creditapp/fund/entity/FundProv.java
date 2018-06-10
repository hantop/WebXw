package app.creditapp.fund.entity;

import app.base.BaseDomain;
/**
* Title: FundProv.java
* Description:
* @version��1.0
**/
public class FundProv extends BaseDomain {
	private String provNo;//������
	private String provProjNo;//��Ŀ���������
	private String projNo;//��Ŀ���
	private String fundNo;//�ʽ���
	private String fundName;//�ʽ�����
	private String begDate;//��ʼ����
	private String endDate;//��������
	private Integer days;//��������
	private Double fdAmt;//�ʽ��ģ
	private Float finRate;//��������
	private Double fineCost;//���ʳɱ�
	private Double payAmt;//����������
	private Double finIncome;//���ʱ���
	private String opNo;//������Ա
	private String txDate;//��������
	private String filler;//��ע

	/**
	 * @return ������
	 */
	public String getProvNo() {
	 	return provNo;
	}
	/**
	 * @���� ������
	 * @param provNo
	 */
	public void setProvNo(String provNo) {
	 	this.provNo = provNo;
	}
	/**
	 * @return ��Ŀ���������
	 */
	public String getProvProjNo() {
	 	return provProjNo;
	}
	/**
	 * @���� ��Ŀ���������
	 * @param provProjNo
	 */
	public void setProvProjNo(String provProjNo) {
	 	this.provProjNo = provProjNo;
	}
	/**
	 * @return ��Ŀ���
	 */
	public String getProjNo() {
	 	return projNo;
	}
	/**
	 * @���� ��Ŀ���
	 * @param projNo
	 */
	public void setProjNo(String projNo) {
	 	this.projNo = projNo;
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
	public String getFundName() {
		return fundName;
	}
	public void setFundName(String fundName) {
		this.fundName = fundName;
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
	 * @return �ʽ��ģ
	 */
	public Double getFdAmt() {
	 	return fdAmt;
	}
	/**
	 * @���� �ʽ��ģ
	 * @param fdAmt
	 */
	public void setFdAmt(Double fdAmt) {
	 	this.fdAmt = fdAmt;
	}
	/**
	 * @return ��������
	 */
	public Float getFinRate() {
	 	return finRate;
	}
	/**
	 * @���� ��������
	 * @param finRate
	 */
	public void setFinRate(Float finRate) {
	 	this.finRate = finRate;
	}
	/**
	 * @return ���ʳɱ�
	 */
	public Double getFineCost() {
	 	return fineCost;
	}
	/**
	 * @���� ���ʳɱ�
	 * @param fineCost
	 */
	public void setFineCost(Double fineCost) {
	 	this.fineCost = fineCost;
	}
	/**
	 * @return ����������
	 */
	public Double getPayAmt() {
	 	return payAmt;
	}
	/**
	 * @���� ����������
	 * @param payAmt
	 */
	public void setPayAmt(Double payAmt) {
	 	this.payAmt = payAmt;
	}
	/**
	 * @return ���ʱ���
	 */
	public Double getFinIncome() {
	 	return finIncome;
	}
	/**
	 * @���� ���ʱ���
	 * @param finIncome
	 */
	public void setFinIncome(Double finIncome) {
	 	this.finIncome = finIncome;
	}
	/**
	 * @return ������Ա
	 */
	public String getOpNo() {
	 	return opNo;
	}
	/**
	 * @���� ������Ա
	 * @param opNo
	 */
	public void setOpNo(String opNo) {
	 	this.opNo = opNo;
	}
	/**
	 * @return ��������
	 */
	public String getTxDate() {
	 	return txDate;
	}
	/**
	 * @���� ��������
	 * @param txDate
	 */
	public void setTxDate(String txDate) {
	 	this.txDate = txDate;
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
}