package app.creditapp.fund.entity;
import app.base.BaseDomain;
/**
* Title: FundProvSplitTerm.java
* Description:
* @version��1.0
**/
public class FundProvSplitTerm extends BaseDomain {
	private String provTermNo;//�������������
	private String provProjNo;//��Ŀ���������
	private String projNo;//��Ŀ���
	private String fundNo;//�ʽ���
	private String partNo;//���䷽�����
	private String termNo;//���䷽���������
	private Double termAmt;//���䷽���������
	private String begDate;//������ʼ����
	private String endDate;//������������
	private String jtBegDate;//������ʼ����
	private String jtEndDate;//���ᵽ������
	private Integer days;//�������ڼ�������������
	private Integer yearDays;//������
	private Float invRate;//������
	private Double payAmt;//����
	private Float financeRate;//��������
	private Double finCost;//���ʳɱ�	
	private Double finlIncome;//���ʱ���
	private Float managerRate;//�������	

	private Double managerFee;//�����
	private String opNo;//������Ա
	private String txDate;//��������
	private String filler;//��ע

	/**
	 * @return �������������
	 */
	public String getProvTermNo() {
	 	return provTermNo;
	}
	/**
	 * @���� �������������
	 * @param provTermNo
	 */
	public void setProvTermNo(String provTermNo) {
	 	this.provTermNo = provTermNo;
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
	/**
	 * @return ���䷽�����
	 */
	public String getPartNo() {
	 	return partNo;
	}
	/**
	 * @���� ���䷽�����
	 * @param partNo
	 */
	public void setPartNo(String partNo) {
	 	this.partNo = partNo;
	}
	/**
	 * @return ���䷽���������
	 */
	public String getTermNo() {
	 	return termNo;
	}
	/**
	 * @���� ���䷽���������
	 * @param termNo
	 */
	public void setTermNo(String termNo) {
	 	this.termNo = termNo;
	}
	/**
	 * @return ���䷽���������
	 */
	public Double getTermAmt() {
	 	return termAmt;
	}
	/**
	 * @���� ���䷽���������
	 * @param termAmt
	 */
	public void setTermAmt(Double termAmt) {
	 	this.termAmt = termAmt;
	}
	/**
	 * @return ������ʼ����
	 */
	public String getBegDate() {
	 	return begDate;
	}
	/**
	 * @���� ������ʼ����
	 * @param begDate
	 */
	public void setBegDate(String begDate) {
	 	this.begDate = begDate;
	}
	/**
	 * @return ������������
	 */
	public String getEndDate() {
	 	return endDate;
	}
	/**
	 * @���� ������������
	 * @param endDate
	 */
	public void setEndDate(String endDate) {
	 	this.endDate = endDate;
	}
	/**
	 * @return ������ʼ����
	 */
	public String getJtBegDate() {
	 	return jtBegDate;
	}
	/**
	 * @���� ������ʼ����
	 * @param jtBegDate
	 */
	public void setJtBegDate(String jtBegDate) {
	 	this.jtBegDate = jtBegDate;
	}
	/**
	 * @return ���ᵽ������
	 */
	public String getJtEndDate() {
	 	return jtEndDate;
	}
	/**
	 * @���� ���ᵽ������
	 * @param jtEndDate
	 */
	public void setJtEndDate(String jtEndDate) {
	 	this.jtEndDate = jtEndDate;
	}
	/**
	 * @return �������ڼ�������������
	 */
	public Integer getDays() {
	 	return days;
	}
	/**
	 * @���� �������ڼ�������������
	 * @param days
	 */
	public void setDays(Integer days) {
	 	this.days = days;
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
	 * @return ���ʱ���
	 */
	public Double getManagerFee() {
	 	return managerFee;
	}
	/**
	 * @���� ���ʱ���
	 * @param managerFee
	 */
	public void setManagerFee(Double managerFee) {
	 	this.managerFee = managerFee;
	}
	/**
	 * @return ��������
	 */
	public Float getFinanceRate() {
	 	return financeRate;
	}
	/**
	 * @���� ��������
	 * @param financeRate
	 */
	public void setFinanceRate(Float financeRate) {
	 	this.financeRate = financeRate;
	}
	/**
	 * @return ����
	 */
	public Double getPayAmt() {
	 	return payAmt;
	}
	/**
	 * @���� ����
	 * @param payAmt
	 */
	public void setPayAmt(Double payAmt) {
	 	this.payAmt = payAmt;
	}
	/**
	 * @return ���ʳɱ�
	 */
	public Double getFinCost() {
	 	return finCost;
	}
	public Double getFinlIncome() {
		return finlIncome;
	}
	public void setFinlIncome(Double finlIncome) {
		this.finlIncome = finlIncome;
	}
	public Float getManagerRate() {
		return managerRate;
	}
	public void setManagerRate(Float managerRate) {
		this.managerRate = managerRate;
	}
	/**
	 * @���� ���ʳɱ�
	 * @param finIncome
	 */
	public void setFinCost(Double finCost) {
	 	this.finCost = finCost;
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