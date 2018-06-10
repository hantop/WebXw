package app.creditapp.acc.loan.entity;
import accounting.plat.util.NumberUtil;
import app.base.BaseDomain;
/**
* Title: AcLnRepayPlnCur.java
* Description:
* @version��1.0
**/
public class AcLnRepayPlnCur extends BaseDomain {
	private String loanNo;//��ݺ�
	private String pactNo;//��ͬ��
	private String brNo;//������
	private Double ttlAmt;//�ܽ��
	private Integer perdNo;//��ǰ����
	private Double prcpAmt;//����
	private Double normInt;//��Ϣ
	private String wrkDt;//�Ǽ�����
	private String payDt;//Ӧ������
	private String endDt;//��������
	private Double repayPrcpAmt;//�ѻ�����
	private Double repayNormInt;//�ѻ���Ϣ
	private Double wvPrcpAmt;//���Ȿ��
	private Double wvNormInt;//������Ϣ

	/**
	 * @return ��ݺ�
	 */
	public String getLoanNo() {
	 	return loanNo;
	}
	/**
	 * @���� ��ݺ�
	 * @param loanNo
	 */
	public void setLoanNo(String loanNo) {
	 	this.loanNo = loanNo;
	}
	/**
	 * @return ��ͬ��
	 */
	public String getPactNo() {
	 	return pactNo;
	}
	/**
	 * @���� ��ͬ��
	 * @param pactNo
	 */
	public void setPactNo(String pactNo) {
	 	this.pactNo = pactNo;
	}
	/**
	 * @return ������
	 */
	public String getBrNo() {
	 	return brNo;
	}
	/**
	 * @���� ������
	 * @param brNo
	 */
	public void setBrNo(String brNo) {
	 	this.brNo = brNo;
	}
	/**
	 * @return �ܽ��
	 */
	public Double getTtlAmt() {
	 	return ttlAmt;
	}
	/**
	 * @���� �ܽ��
	 * @param ttlAmt
	 */
	public void setTtlAmt(Double ttlAmt) {
	 	this.ttlAmt = ttlAmt;
	}
	/**
	 * @return ��ǰ����
	 */
	public Integer getPerdNo() {
	 	return perdNo;
	}
	/**
	 * @���� ��ǰ����
	 * @param perdNo
	 */
	public void setPerdNo(Integer perdNo) {
	 	this.perdNo = perdNo;
	}
	/**
	 * @return ����
	 */
	public Double getPrcpAmt() {
	 	return prcpAmt;
	}
	/**
	 * @���� ����
	 * @param prcpAmt
	 */
	public void setPrcpAmt(Double prcpAmt) {
	 	this.prcpAmt = prcpAmt;
	}
	/**
	 * @return ��Ϣ
	 */
	public Double getNormInt() {
	 	return normInt;
	}
	/**
	 * @���� ��Ϣ
	 * @param normInt
	 */
	public void setNormInt(Double normInt) {
	 	this.normInt = normInt;
	}
	/**
	 * @return �Ǽ�����
	 */
	public String getWrkDt() {
	 	return wrkDt;
	}
	/**
	 * @���� �Ǽ�����
	 * @param wrkDt
	 */
	public void setWrkDt(String wrkDt) {
	 	this.wrkDt = wrkDt;
	}
	/**
	 * @return Ӧ������
	 */
	public String getPayDt() {
	 	return payDt;
	}
	/**
	 * @���� Ӧ������
	 * @param payDt
	 */
	public void setPayDt(String payDt) {
	 	this.payDt = payDt;
	}
	/**
	 * @return ��������
	 */
	public String getEndDt() {
	 	return endDt;
	}
	/**
	 * @���� ��������
	 * @param endDt
	 */
	public void setEndDt(String endDt) {
	 	this.endDt = endDt;
	}
	/**
	 * @return �ѻ�����
	 */
	public Double getRepayPrcpAmt() {
	 	return repayPrcpAmt;
	}
	/**
	 * @���� �ѻ�����
	 * @param repayPrcpAmt
	 */
	public void setRepayPrcpAmt(Double repayPrcpAmt) {
	 	this.repayPrcpAmt = repayPrcpAmt;
	}
	/**
	 * @return �ѻ���Ϣ
	 */
	public Double getRepayNormInt() {
	 	return repayNormInt;
	}
	/**
	 * @���� �ѻ���Ϣ
	 * @param repayNormInt
	 */
	public void setRepayNormInt(Double repayNormInt) {
	 	this.repayNormInt = repayNormInt;
	}
	public Double getWvPrcpAmt() {
		return wvPrcpAmt;
	}
	public void setWvPrcpAmt(Double wvPrcpAmt) {
		this.wvPrcpAmt = wvPrcpAmt;
	}
	public Double getWvNormInt() {
		return wvNormInt;
	}
	public void setWvNormInt(Double wvNormInt) {
		this.wvNormInt = wvNormInt;
	}
	public Double getAmt(){
		return NumberUtil.amtAdd(this.prcpAmt, this.normInt);
	}
}