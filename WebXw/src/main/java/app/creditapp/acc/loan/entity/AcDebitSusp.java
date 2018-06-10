package app.creditapp.acc.loan.entity;
import app.base.BaseDomain;
/**
* Title: AcDebitSusp.java
* Description:
* @version��1.0
**/
public class AcDebitSusp extends BaseDomain {
	private String wsId;//��������ID
	private String batchNo;//���α��
	private String brNo;//�����������
	private String pactNo;//��ͬ���
	private String acName;//�˻�����
	private String acNo;//�����˺�
	private String opnCode;//���д���
	private String opnName;//������
	private Double payOver;//Ӧ�շ�Ϣ
	private Double feeRec;//Ӧ�մ��۷��ܶ�
	private Double repayTotal;//�ۿ���:11=12+13
	private Double repayAmt;//�ۿ��
	private Double repayInte;//�ۿ���Ϣ
	private Double repayOver;//�ۿϢ
	private Double feeTotal;//���۷��ܶ�:������������ȡ
	private String serialNo;//�ۿ���ˮ��
	private String dealSts;//�ۿ�״̬[01δ����02������03����ɹ�04����ʧ��]
	private String dealDesc;//�ۿ�����
	private String txDate;//������������
	private String brName;//��������
	private String cardChn;//֧������
	private String txCde;//���״���


	public String getBrName() {
		return brName;
	}
	public void setBrName(String brName) {
		this.brName = brName;
	}
	/**
	 * @return ��������ID
	 */
	public String getWsId() {
	 	return wsId;
	}
	/**
	 * @���� ��������ID
	 * @param wsId
	 */
	public void setWsId(String wsId) {
	 	this.wsId = wsId;
	}
	/**
	 * @return ���α��
	 */
	public String getBatchNo() {
	 	return batchNo;
	}
	/**
	 * @���� ���α��
	 * @param batchNo
	 */
	public void setBatchNo(String batchNo) {
	 	this.batchNo = batchNo;
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
	 * @return ��ͬ���
	 */
	public String getPactNo() {
	 	return pactNo;
	}
	/**
	 * @���� ��ͬ���
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
	 * @return �ۿ���:11=12+13
	 */
	public Double getRepayTotal() {
	 	return repayTotal;
	}
	/**
	 * @���� �ۿ���:11=12+13
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
	 * @return ���۷��ܶ�:������������ȡ
	 */
	public Double getFeeTotal() {
	 	return feeTotal;
	}
	/**
	 * @���� ���۷��ܶ�:������������ȡ
	 * @param feeTotal
	 */
	public void setFeeTotal(Double feeTotal) {
	 	this.feeTotal = feeTotal;
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
	 * @return �ۿ�״̬[01δ����02������03����ɹ�04����ʧ��]
	 */
	public String getDealSts() {
	 	return dealSts;
	}
	/**
	 * @���� �ۿ�״̬[01δ����02������03����ɹ�04����ʧ��]
	 * @param dealSts
	 */
	public void setDealSts(String dealSts) {
	 	this.dealSts = dealSts;
	}
	/**
	 * @return �ۿ�����
	 */
	public String getDealDesc() {
	 	return dealDesc;
	}
	/**
	 * @���� �ۿ�����
	 * @param dealDesc
	 */
	public void setDealDesc(String dealDesc) {
	 	this.dealDesc = dealDesc;
	}
	/**
	 * @return ������������
	 */
	public String getTxDate() {
	 	return txDate;
	}
	/**
	 * @���� ������������
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
	public String getTxCde() {
		return txCde;
	}
	public void setTxCde(String txCde) {
		this.txCde = txCde;
	}
}