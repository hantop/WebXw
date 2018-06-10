package app.creditapp.fund.entity;
import app.base.BaseDomain;
/**
* Title: FundSplitDetail.java
* Description:
* @version��1.0
**/
public class FundSplitDetail extends BaseDomain {
	private String partId;//������ˮID
	private String partNo;//�������
	private Double bfTxAmt;//����ǰ���
	private Double txAmt;//�������
	private Double afTxAmt;//��������
	private Float invRate;//������
	private String tradeType;//��������
	private String txDate;//�Ǽ�����
	private String opNo;//�Ǽ���

	/**
	 * @return ������ˮID
	 */
	public String getPartId() {
	 	return partId;
	}
	/**
	 * @���� ������ˮID
	 * @param partId
	 */
	public void setPartId(String partId) {
	 	this.partId = partId;
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
	 * @return ����ǰ���
	 */
	public Double getBfTxAmt() {
	 	return bfTxAmt;
	}
	/**
	 * @���� ����ǰ���
	 * @param bfTxAmt
	 */
	public void setBfTxAmt(Double bfTxAmt) {
	 	this.bfTxAmt = bfTxAmt;
	}
	/**
	 * @return �������
	 */
	public Double getTxAmt() {
	 	return txAmt;
	}
	/**
	 * @���� �������
	 * @param txAmt
	 */
	public void setTxAmt(Double txAmt) {
	 	this.txAmt = txAmt;
	}
	/**
	 * @return ��������
	 */
	public Double getAfTxAmt() {
	 	return afTxAmt;
	}
	/**
	 * @���� ��������
	 * @param afTxAmt
	 */
	public void setAfTxAmt(Double afTxAmt) {
	 	this.afTxAmt = afTxAmt;
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
	 * @return ��������
	 */
	public String getTradeType() {
	 	return tradeType;
	}
	/**
	 * @���� ��������
	 * @param tradeType
	 */
	public void setTradeType(String tradeType) {
	 	this.tradeType = tradeType;
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
}