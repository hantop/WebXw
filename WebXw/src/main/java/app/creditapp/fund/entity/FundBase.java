package app.creditapp.fund.entity;
import app.base.BaseDomain;
/**
* Title: FundBase.java
* Description:
* @version��1.0
**/
public class FundBase extends BaseDomain {
	private String fundNo;//�ʽ���
	private String fundName;//�ʽ�����
	private String projNo;//��Ŀ���
	private String projName;//��Ŀ����
	private String curNo;//����
	private Double fdInitialAmt;//�ʽ��ʼ��ģ
	private Double fdAmt;//�ʽ�ǰ��ģ
	private Double cashBal;//�ֽ����
	private Double rightBal;//ծȨ���
	private String begDate;//��ʼ����
	private String endDate;//��������
	private float financeRate;//��������
	private String repayType;//��Ϣ��ʽ
	private String repayDay;//ָ����Ϣ��
	private Integer yearDays;//������
	private String fdType;//�ʽ�����
	private String reDeem;//�����־
	private String fdFlag;//��Ч��־	
	private String fdState;//�ʽ�״̬
	private String packetSts;//�����־
	private String packetDate;//���ʱ��
	private String tranSts;//ת�ñ�־
	private String tranDate;//ת��ʱ��
	private String filler;//��ע
	private String opNo;//�Ǽ���Ա
	private String txDate;//�Ǽ�����
	private String upDate;//�޸�����
	private String upOpno;//�޸���Ա
	
	private String loginid;//����Ա��
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
	public String getFundName() {
	 	return fundName;
	}
	/**
	 * @���� �ʽ�����
	 * @param fundName
	 */
	public void setFundName(String fundName) {
	 	this.fundName = fundName;
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
	 * @return ��Ŀ����
	 */
	public String getProjName() {
	 	return projName;
	}
	/**
	 * @���� ��Ŀ����
	 * @param projName
	 */
	public void setProjName(String projName) {
	 	this.projName = projName;
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
	/**
	 * @return �ʽ��ʼ��ģ
	 */
	public Double getFdInitialAmt() {
	 	return fdInitialAmt;
	}
	/**
	 * @���� �ʽ��ʼ��ģ
	 * @param fdInitialAmt
	 */
	public void setFdInitialAmt(Double fdInitialAmt) {
	 	this.fdInitialAmt = fdInitialAmt;
	}
	/**
	 * @return �ʽ�ǰ��ģ
	 */
	public Double getFdAmt() {
	 	return fdAmt;
	}
	/**
	 * @���� �ʽ�ǰ��ģ
	 * @param fdAmt
	 */
	public void setFdAmt(Double fdAmt) {
	 	this.fdAmt = fdAmt;
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
	 * @return ��Ϣ��ʽ
	 */
	public String getRepayType() {
	 	return repayType;
	}
	/**
	 * @���� ��Ϣ��ʽ
	 * @param repayType
	 */
	public void setRepayType(String repayType) {
	 	this.repayType = repayType;
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
	 * @return �ʽ�״̬
	 */
	public String getFdState() {
	 	return fdState;
	}
	/**
	 * @���� �ʽ�״̬
	 * @param fdState
	 */
	public void setFdState(String fdState) {
	 	this.fdState = fdState;
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
	 * @return �Ǽ���Ա
	 */
	public String getOpNo() {
	 	return opNo;
	}
	/**
	 * @���� �Ǽ���Ա
	 * @param opNo
	 */
	public void setOpNo(String opNo) {
	 	this.opNo = opNo;
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
	 * @return �޸�����
	 */
	public String getUpDate() {
	 	return upDate;
	}
	/**
	 * @���� �޸�����
	 * @param upDate
	 */
	public void setUpDate(String upDate) {
	 	this.upDate = upDate;
	}
	/**
	 * @return �޸���Ա
	 */
	public String getUpOpno() {
	 	return upOpno;
	}
	/**
	 * @���� �޸���Ա
	 * @param upOpno
	 */
	public void setUpOpno(String upOpno) {
	 	this.upOpno = upOpno;
	}
	/**
	 * @���� ָ����Ϣ��
	 * @param SubpayType
	 */
	public String getRepayDay() {
		return repayDay;
	}
	public void setRepayDay(String repayDay) {
		this.repayDay = repayDay;
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
	public String getReDeem() {
		return reDeem;
	}
	public void setReDeem(String reDeem) {
		this.reDeem = reDeem;
	}
	public String getFdFlag() {
		return fdFlag;
	}
	public void setFdFlag(String fdFlag) {
		this.fdFlag = fdFlag;
	}
	public String getPacketSts() {
		return packetSts;
	}
	public void setPacketSts(String packetSts) {
		this.packetSts = packetSts;
	}
	public String getPacketDate() {
		return packetDate;
	}
	public void setPacketDate(String packetDate) {
		this.packetDate = packetDate;
	}
	public String getTranSts() {
		return tranSts;
	}
	public void setTranSts(String tranSts) {
		this.tranSts = tranSts;
	}
	public String getTranDate() {
		return tranDate;
	}
	public void setTranDate(String tranDate) {
		this.tranDate = tranDate;
	}
	public String getLoginid() {
		return loginid;
	}
	public void setLoginid(String loginid) {
		this.loginid = loginid;
	}
	public void setFinanceRate(float financeRate) {
		this.financeRate = financeRate;
	}
}