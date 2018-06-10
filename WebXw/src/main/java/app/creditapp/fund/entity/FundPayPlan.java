package app.creditapp.fund.entity;
import app.base.BaseDomain;
/**
* Title: FundPayPlan.java
* Description:
* @version��1.0
**/
public class FundPayPlan extends BaseDomain {
	private String payPlanNo;//�Ҹ����
	private String fundNo;//�ʽ���	
	private String partNo;//�������
	private Integer totalIssue;//������
	private Double totalAmt;//�ܽ��
	private Integer payIssue;//�Ҹ��ڴ�
	private String payDate;//�Ҹ�����
	private Double recPayAmt;//Ӧ�ҽ��
	private Double payAmt;//ʵ�ҽ��
	private Double unpayAmt;//δ�ҽ��
	private String filler;//��ע
	private String warnDate;//��ǰ���ѹ�����
	
	private String fdType;//
	
	private String query;//ֻ�� 

	/**
	 * @return �Ҹ����
	 */
	public String getPayPlanNo() {
	 	return payPlanNo;
	}
	/**
	 * @���� �Ҹ����
	 * @param payPlanNo
	 */
	public void setPayPlanNo(String payPlanNo) {
	 	this.payPlanNo = payPlanNo;
	}
	/**
	 * @return �ʽ���
	 */
	public String getFundNo() {
	 	return fundNo;
	}
	/**
	 * @���� �ʽ���
	 * @param payPlanNo
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
	 * @return ������
	 */
	public Integer getTotalIssue() {
	 	return totalIssue;
	}
	/**
	 * @���� ������
	 * @param totalIssue
	 */
	public void setTotalIssue(Integer totalIssue) {
	 	this.totalIssue = totalIssue;
	}
	/**
	 * @return �ܽ��
	 */
	public Double getTotalAmt() {
	 	return totalAmt;
	}
	/**
	 * @���� �ܽ��
	 * @param totalAmt
	 */
	public void setTotalAmt(Double totalAmt) {
	 	this.totalAmt = totalAmt;
	}
	/**
	 * @return �Ҹ��ڴ�
	 */
	public Integer getPayIssue() {
	 	return payIssue;
	}
	/**
	 * @���� �Ҹ��ڴ�
	 * @param payIssue
	 */
	public void setPayIssue(Integer payIssue) {
	 	this.payIssue = payIssue;
	}
	/**
	 * @return �Ҹ�����
	 */
	public String getPayDate() {
	 	return payDate;
	}
	/**
	 * @���� �Ҹ�����
	 * @param payDate
	 */
	public void setPayDate(String payDate) {
	 	this.payDate = payDate;
	}
	/**
	 * @return Ӧ�ҽ��
	 */
	public Double getRecPayAmt() {
	 	return recPayAmt;
	}
	/**
	 * @���� Ӧ�ҽ��
	 * @param recPayAmt
	 */
	public void setRecPayAmt(Double recPayAmt) {
	 	this.recPayAmt = recPayAmt;
	}
	/**
	 * @return ʵ�ҽ��
	 */
	public Double getPayAmt() {
	 	return payAmt;
	}
	/**
	 * @���� ʵ�ҽ��
	 * @param payAmt
	 */
	public void setPayAmt(Double payAmt) {
	 	this.payAmt = payAmt;
	}
	/**
	 * @return δ�ҽ��
	 */
	public Double getUnpayAmt() {
	 	return unpayAmt;
	}
	/**
	 * @���� δ�ҽ��
	 * @param unpayAmt
	 */
	public void setUnpayAmt(Double unpayAmt) {
	 	this.unpayAmt = unpayAmt;
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
	 * @return ��ǰ���ѹ�����
	 */
	public String getWarnDate() {
	 	return warnDate;
	}
	/**
	 * @���� ��ǰ���ѹ�����
	 * @param warnDate
	 */
	public void setWarnDate(String warnDate) {
	 	this.warnDate = warnDate;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public String getFdType() {
		return fdType;
	}
	public void setFdType(String fdType) {
		this.fdType = fdType;
	}
}