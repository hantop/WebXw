package app.creditapp.fund.entity;
import app.base.BaseDomain;
/**
* Title: RptFundDaily.java
* Description:
* @version��1.0
**/
public class RptFundDaily extends BaseDomain {
	private String rptDate;//��������
	private String rptType;//��������
	private String projNo;//��Ŀ���
	private String fundNo;//�ʽ���
	private String fdType;//�ʽ�����
	private Double fdAmt;//�ʽ��ģ
	private Double cashBal;//�ֽ����
	private Double rightBal;//ծȨ���
	private Double addAmt;//�ۼ�����
	private Double payAmt;//�ۼƶҸ�

	/**
	 * @return ��������
	 */
	public String getRptDate() {
	 	return rptDate;
	}
	/**
	 * @���� ��������
	 * @param rptDate
	 */
	public void setRptDate(String rptDate) {
	 	this.rptDate = rptDate;
	}
	/**
	 * @return ��������
	 */
	public String getRptType() {
	 	return rptType;
	}
	/**
	 * @���� ��������
	 * @param rptType
	 */
	public void setRptType(String rptType) {
	 	this.rptType = rptType;
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
	 * @return �ʽ�����
	 */
	public String getFdType() {
	 	return fdType;
	}
	/**
	 * @���� �ʽ�����
	 * @param fdType
	 */
	public void setFdType(String fdType) {
	 	this.fdType = fdType;
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
	 * @return �ֽ����
	 */
	public Double getCashBal() {
	 	return cashBal;
	}
	/**
	 * @���� �ֽ����
	 * @param cashBal
	 */
	public void setCashBal(Double cashBal) {
	 	this.cashBal = cashBal;
	}
	/**
	 * @return ծȨ���
	 */
	public Double getRightBal() {
	 	return rightBal;
	}
	/**
	 * @���� ծȨ���
	 * @param rightBal
	 */
	public void setRightBal(Double rightBal) {
	 	this.rightBal = rightBal;
	}
	/**
	 * @return �ۼ�����
	 */
	public Double getAddAmt() {
	 	return addAmt;
	}
	/**
	 * @���� �ۼ�����
	 * @param addAmt
	 */
	public void setAddAmt(Double addAmt) {
	 	this.addAmt = addAmt;
	}
	/**
	 * @return �ۼƶҸ�
	 */
	public Double getPayAmt() {
	 	return payAmt;
	}
	/**
	 * @���� �ۼƶҸ�
	 * @param payAmt
	 */
	public void setPayAmt(Double payAmt) {
	 	this.payAmt = payAmt;
	}
}