package app.creditapp.fund.entity;
import app.base.BaseDomain;
/**
* Title: FundProvProj.java
* Description:
* @version��1.0
**/
public class FundProvProj extends BaseDomain {
	private String provProjNo;//��Ŀ���������
	private String projNo;//��Ŀ���
	private String projName;//��Ŀ����
	private String begDate;//��ʼ����
	private String endDate;//��������
	private Double finCost;//�����ܳɱ�
	private Double payAmt;//������������
	private Double finlIncome;//�����ܱ���
	private Double managerFee;//��Ŀ�����
	private Double serviceFee;//�Ŵ������
	private Double drawingAmt;//�����ܽ��
	private String opNo;//������Ա
	private String txDate;//��������
	private String filler;//��ע
// Ϊ��ȡRPT_PRDT_DAILY�в�Ʒ�Ÿ��ۼƽ��
	private String prdtNo;//��Ʒ��
	private Double amtTot;//�ۼƽ��
	private Double maxAmt;//���ݷŴ���ģ����
	private Float offRate;//��Ʒ�ۿ���
	private String nowDate;//��ǰ����
	
	private String loginid;//�޸���Ա

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
	public String getProjName() {
		return projName;
	}
	public void setProjName(String projName) {
		this.projName = projName;
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
	 * @return �����ܳɱ�
	 */
	public Double getFinCost() {
	 	return finCost;
	}
	/**
	 * @���� �����ܳɱ�
	 * @param finCost
	 */
	public void setFinCost(Double finCost) {
	 	this.finCost = finCost;
	}
	/**
	 * @return ������������
	 */
	public Double getPayAmt() {
	 	return payAmt;
	}
	/**
	 * @���� ������������
	 * @param payAmt
	 */
	public void setPayAmt(Double payAmt) {
	 	this.payAmt = payAmt;
	}
	/**
	 * @return �����ܱ���
	 */
	public Double getFinlIncome() {
	 	return finlIncome;
	}
	/**
	 * @���� �����ܱ���
	 * @param finlIncome
	 */
	public void setFinlIncome(Double finlIncome) {
	 	this.finlIncome = finlIncome;
	}
	/**
	 * @return ��Ŀ�����
	 */
	public Double getManagerFee() {
	 	return managerFee;
	}
	/**
	 * @���� ��Ŀ�����
	 * @param managerFee
	 */
	public void setManagerFee(Double managerFee) {
	 	this.managerFee = managerFee;
	}
	/**
	 * @return �Ŵ������
	 */
	public Double getServiceFee() {
	 	return serviceFee;
	}
	/**
	 * @���� �Ŵ������
	 * @param serviceFee
	 */
	public void setServiceFee(Double serviceFee) {
	 	this.serviceFee = serviceFee;
	}
	/**
	 * @return �����ܽ��
	 */
	public Double getDrawingAmt() {
	 	return drawingAmt;
	}
	/**
	 * @���� �����ܽ��
	 * @param drawingAmt
	 */
	public void setDrawingAmt(Double drawingAmt) {
	 	this.drawingAmt = drawingAmt;
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
	/**
	 * 
	 * @���� DHCC-ZLC
	 * @���� 2016-6-23
	 * @����˵����
	 * @���ز��� String
	 */
	public String getPrdtNo() {
		return prdtNo;
	}
	public void setPrdtNo(String prdtNo) {
		this.prdtNo = prdtNo;
	}
	public Double getAmtTot() {
		return amtTot;
	}
	public void setAmtTot(Double amtTot) {
		this.amtTot = amtTot;
	}
	public Double getMaxAmt() {
		return maxAmt;
	}
	public void setMaxAmt(Double maxAmt) {
		this.maxAmt = maxAmt;
	}
	public Float getOffRate() {
		return offRate;
	}
	public void setOffRate(Float offRate) {
		this.offRate = offRate;
	}
	public String getNowDate() {
		return nowDate;
	}
	public void setNowDate(String nowDate) {
		this.nowDate = nowDate;
	}
	public String getLoginid() {
		return loginid;
	}
	public void setLoginid(String loginid) {
		this.loginid = loginid;
	}
}