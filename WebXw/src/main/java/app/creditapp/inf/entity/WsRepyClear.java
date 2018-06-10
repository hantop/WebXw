package app.creditapp.inf.entity;
import app.base.BaseDomain;
/**
* Title: WsRepyClear.java
* Description:
* @version��1.0
**/
public class WsRepyClear extends BaseDomain {
	
	private String wsId;//����ID
	private String brNo;//�����������
	private String pactNo;//��ͬ��:����
	private String acName;//�˻�����
	private String acNo;//�����˺�
	private String opnCode;//���д���
	private String opnName;//������
	private String serialNo;//�ۿ���ˮ��
	private Double payOver;//Ӧ�շ�Ϣ
	private Double feeRec;//Ӧ�մ��۷��ܶ�
	private Double repayTotal;//�ۿ���
	private Double repayAmt;//�ۿ��
	private Double repayInte;//�ۿ���Ϣ
	private Double repayOver;//�ۿϢ
	private Double feeTotal;//���۷��ܶ�
	private String dealSts;//����״̬[01δ���� 02������03����ɹ�04����ʧ��]
	private String dealDesc;//����˵��
	private String txDate;//��������
	
	private String cardChn;//�����˻�����
	

	/**
	 * @return ����ID
	 */
	public String getWsId() {
	 	return wsId;
	}
	/**
	 * @���� ����ID
	 * @param wsId
	 */
	public void setWsId(String wsId) {
	 	this.wsId = wsId;
	}
	/**
	 * @return �����������
	 */
	public String getBrNo() {
	 	return brNo;
	}
	/**
	 * @���� �����������
	 * @param brNo
	 */
	public void setBrNo(String brNo) {
	 	this.brNo = brNo;
	}
	/**
	 * @return ��ͬ��:����
	 */
	public String getPactNo() {
	 	return pactNo;
	}
	/**
	 * @���� ��ͬ��:����
	 * @param pactNo
	 */
	public void setPactNo(String pactNo) {
	 	this.pactNo = pactNo;
	}
	/**
	 * @return �˻�����
	 */
	public String getAcName() {
	 	return acName;
	}
	/**
	 * @���� �˻�����
	 * @param acName
	 */
	public void setAcName(String acName) {
	 	this.acName = acName;
	}
	/**
	 * @return �����˺�
	 */
	public String getAcNo() {
	 	return acNo;
	}
	/**
	 * @���� �����˺�
	 * @param acNo
	 */
	public void setAcNo(String acNo) {
	 	this.acNo = acNo;
	}
	/**
	 * @return ���д���
	 */
	public String getOpnCode() {
	 	return opnCode;
	}
	/**
	 * @���� ���д���
	 * @param opnCode
	 */
	public void setOpnCode(String opnCode) {
	 	this.opnCode = opnCode;
	}
	/**
	 * @return ������
	 */
	public String getOpnName() {
	 	return opnName;
	}
	/**
	 * @���� ������
	 * @param opnName
	 */
	public void setOpnName(String opnName) {
	 	this.opnName = opnName;
	}
	/**
	 * @return �ۿ���ˮ��
	 */
	public String getSerialNo() {
	 	return serialNo;
	}
	/**
	 * @���� �ۿ���ˮ��
	 * @param serialNo
	 */
	public void setSerialNo(String serialNo) {
	 	this.serialNo = serialNo;
	}
	/**
	 * @return Ӧ�շ�Ϣ
	 */
	public Double getPayOver() {
	 	return payOver;
	}
	/**
	 * @���� Ӧ�շ�Ϣ
	 * @param payOver
	 */
	public void setPayOver(Double payOver) {
	 	this.payOver = payOver;
	}
	/**
	 * @return Ӧ�մ��۷��ܶ�
	 */
	public Double getFeeRec() {
	 	return feeRec;
	}
	/**
	 * @���� Ӧ�մ��۷��ܶ�
	 * @param feeRec
	 */
	public void setFeeRec(Double feeRec) {
	 	this.feeRec = feeRec;
	}
	/**
	 * @return �ۿ���
	 */
	public Double getRepayTotal() {
	 	return repayTotal;
	}
	/**
	 * @���� �ۿ���
	 * @param repayTotal
	 */
	public void setRepayTotal(Double repayTotal) {
	 	this.repayTotal = repayTotal;
	}
	/**
	 * @return �ۿ��
	 */
	public Double getRepayAmt() {
	 	return repayAmt;
	}
	/**
	 * @���� �ۿ��
	 * @param repayAmt
	 */
	public void setRepayAmt(Double repayAmt) {
	 	this.repayAmt = repayAmt;
	}
	/**
	 * @return �ۿ���Ϣ
	 */
	public Double getRepayInte() {
	 	return repayInte;
	}
	/**
	 * @���� �ۿ���Ϣ
	 * @param repayInte
	 */
	public void setRepayInte(Double repayInte) {
	 	this.repayInte = repayInte;
	}
	/**
	 * @return �ۿϢ
	 */
	public Double getRepayOver() {
	 	return repayOver;
	}
	/**
	 * @���� �ۿϢ
	 * @param repayOver
	 */
	public void setRepayOver(Double repayOver) {
	 	this.repayOver = repayOver;
	}
	/**
	 * @return ���۷��ܶ�
	 */
	public Double getFeeTotal() {
	 	return feeTotal;
	}
	/**
	 * @���� ���۷��ܶ�
	 * @param feeTotal
	 */
	public void setFeeTotal(Double feeTotal) {
	 	this.feeTotal = feeTotal;
	}
	/**
	 * @return ����״̬[01δ���� 02������03����ɹ�04����ʧ��]
	 */
	public String getDealSts() {
	 	return dealSts;
	}
	/**
	 * @���� ����״̬[01δ���� 02������03����ɹ�04����ʧ��]
	 * @param dealSts
	 */
	public void setDealSts(String dealSts) {
	 	this.dealSts = dealSts;
	}
	/**
	 * @return ����˵��
	 */
	public String getDealDesc() {
	 	return dealDesc;
	}
	/**
	 * @���� ����˵��
	 * @param dealDesc
	 */
	public void setDealDesc(String dealDesc) {
	 	this.dealDesc = dealDesc;
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
	public String getCardChn() {
		return cardChn;
	}
	public void setCardChn(String cardChn) {
		this.cardChn = cardChn;
	}
	
}