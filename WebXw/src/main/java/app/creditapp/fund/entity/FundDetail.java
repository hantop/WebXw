package app.creditapp.fund.entity;
import app.base.BaseDomain;
/**
* Title: FundDetail.java
* Description:
* @version��1.0
**/
public class FundDetail extends BaseDomain {
	private String detailId;//�ʽ���ϸ��ˮ��
	private String fundNo;//�ʽ���
	private String tradeType;//��������
	private String fdType;//�ʽ�����
	private Double txAmt;//�������
	private String termNo;//�������**
	private String txDate;//��������
	private String opNo;//�Ǽ���Ա
	private String filler;//��ע
	
	private String query;//ֻ��
	/**
	 * @return �ʽ���ϸ��ˮ��
	 */
	public String getDetailId() {
	 	return detailId;
	}
	/**
	 * @���� �ʽ���ϸ��ˮ��
	 * @param detailId
	 */
	public void setDetailId(String detailId) {
	 	this.detailId = detailId;
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
	public String getFdType() {
		return fdType;
	}
	public void setFdType(String fdType) {
		this.fdType = fdType;
	}
	public String getTermNo() {
		return termNo;
	}
	public void setTermNo(String termNo) {
		this.termNo = termNo;
	}

}