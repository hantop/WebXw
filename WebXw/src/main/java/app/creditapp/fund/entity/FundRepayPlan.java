package app.creditapp.fund.entity;
import app.base.BaseDomain;
/**
* Title: FundRepayPlan.java
* Description:
* @version��1.0
**/
public class FundRepayPlan extends BaseDomain {
	private String repayPlanNo;//����ƻ����
	private String fundNo;//�ʽ���
	private Integer totalIssue;//������
	private Double totalAmt;//�ܽ��
	private Integer repayIssue;//�����ڴ�
	private String repayDate;//Ӧ������
	private Double repayAmt;//Ӧ�����
	private Double payAmt;//�Ƹ�����
	private Double cashManager;//�ֽ����
	private Double unrepayAmt;//δ�����
	private String filler;//��ע
	
	private String query;//ֻ��

	/**
	 * @return ����ƻ����
	 */
	public String getRepayPlanNo() {
	 	return repayPlanNo;
	}
	/**
	 * @���� ����ƻ����
	 * @param repayPlanNo
	 */
	public void setRepayPlanNo(String repayPlanNo) {
	 	this.repayPlanNo = repayPlanNo;
	}
	/**
	 * @return �������
	 */
	public String getFundNo() {
	 	return fundNo;
	}
	/**
	 * @���� �������
	 * @param termNo
	 */
	public void setFundNo(String fundNo) {
	 	this.fundNo = fundNo;
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
	 * @return �����ڴ�
	 */
	public Integer getRepayIssue() {
	 	return repayIssue;
	}
	/**
	 * @���� �����ڴ�
	 * @param repayIssue
	 */
	public void setRepayIssue(Integer repayIssue) {
	 	this.repayIssue = repayIssue;
	}
	/**
	 * @return Ӧ������
	 */
	public String getRepayDate() {
	 	return repayDate;
	}
	/**
	 * @���� Ӧ������
	 * @param repayDate
	 */
	public void setRepayDate(String repayDate) {
	 	this.repayDate = repayDate;
	}
	/**
	 * @return Ӧ�����
	 */
	public Double getRepayAmt() {
	 	return repayAmt;
	}
	/**
	 * @���� Ӧ�����
	 * @param repayAmt
	 */
	public void setRepayAmt(Double repayAmt) {
	 	this.repayAmt = repayAmt;
	}
	/**
	 * @return �Ƹ�����
	 */
	public Double getPayAmt() {
	 	return payAmt;
	}
	/**
	 * @���� �Ƹ�����
	 * @param payAmt
	 */
	public void setPayAmt(Double payAmt) {
	 	this.payAmt = payAmt;
	}
	/**
	 * @return �ֽ����
	 */
	public Double getCashManager() {
	 	return cashManager;
	}
	/**
	 * @���� �ֽ����
	 * @param cashManager
	 */
	public void setCashManager(Double cashManager) {
	 	this.cashManager = cashManager;
	}
	/**
	 * @return δ�����
	 */
	public Double getUnrepayAmt() {
	 	return unrepayAmt;
	}
	/**
	 * @���� δ�����
	 * @param unrepayAmt
	 */
	public void setUnrepayAmt(Double unrepayAmt) {
	 	this.unrepayAmt = unrepayAmt;
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
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
}