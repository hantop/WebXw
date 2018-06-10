package app.creditapp.inf.entity;
import app.base.BaseDomain;
/**
* Title: WsRedctn.java
* Description:
* @version��1.0
**/
public class WsRedctn extends BaseDomain {
	private String wsId;//����ID
	private String batchNo;//���α��
	private String brNo;//�����������
	private String pactNo;//��ͬ��:����
	private Double refAmt;//���Ȿ��:û����0
	private Double refInte;//������Ϣ:û����0
	private Double refOver;//���ⷣϢ:û����0
	private Double refFee;//�������:û����0
	private String txDate;//������������
	private String dealSts;//����״̬[01δ����02������03����ɹ�04����ʧ��]
	private String dealDesc;//����˵��
	private String brName;//������������

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
	 * @return ���Ȿ��:û����0
	 */
	public Double getRefAmt() {
	 	return refAmt;
	}
	/**
	 * @���� ���Ȿ��:û����0
	 * @param refAmt
	 */
	public void setRefAmt(Double refAmt) {
	 	this.refAmt = refAmt;
	}
	/**
	 * @return ������Ϣ:û����0
	 */
	public Double getRefInte() {
	 	return refInte;
	}
	/**
	 * @���� ������Ϣ:û����0
	 * @param refInte
	 */
	public void setRefInte(Double refInte) {
	 	this.refInte = refInte;
	}
	/**
	 * @return ���ⷣϢ:û����0
	 */
	public Double getRefOver() {
	 	return refOver;
	}
	/**
	 * @���� ���ⷣϢ:û����0
	 * @param refOver
	 */
	public void setRefOver(Double refOver) {
	 	this.refOver = refOver;
	}
	/**
	 * @return �������:û����0
	 */
	public Double getRefFee() {
	 	return refFee;
	}
	/**
	 * @���� �������:û����0
	 * @param refFee
	 */
	public void setRefFee(Double refFee) {
	 	this.refFee = refFee;
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
	/**
	 * @return ����״̬[01δ����02������03����ɹ�04����ʧ��]
	 */
	public String getDealSts() {
	 	return dealSts;
	}
	/**
	 * @���� ����״̬[01δ����02������03����ɹ�04����ʧ��]
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
	public String getBrName() {
		return brName;
	}
	public void setBrName(String brName) {
		this.brName = brName;
	}
}