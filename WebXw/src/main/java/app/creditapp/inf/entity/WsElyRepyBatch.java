package app.creditapp.inf.entity;
import app.base.BaseDomain;
/**
* Title: WsElyRepyBatch.java
* Description:
* @version��1.0
**/
public class WsElyRepyBatch extends BaseDomain {
	private String batchNo;//���α��
	private String brNo;//����������
	private Integer dataCnt;//��¼��
	private String txTime;//���ν�������ʱ��

	private String brName;//������������
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
	 * @return ����������
	 */
	public String getBrNo() {
	 	return brNo;
	}
	/**
	 * @���� ����������
	 * @param brNo
	 */
	public void setBrNo(String brNo) {
	 	this.brNo = brNo;
	}
	/**
	 * @return ��¼��
	 */
	public Integer getDataCnt() {
	 	return dataCnt;
	}
	/**
	 * @���� ��¼��
	 * @param dataCnt
	 */
	public void setDataCnt(Integer dataCnt) {
	 	this.dataCnt = dataCnt;
	}
	/**
	 * @return ���ν�������ʱ��
	 */
	public String getTxTime() {
	 	return txTime;
	}
	/**
	 * @���� ���ν�������ʱ��
	 * @param txTime
	 */
	public void setTxTime(String txTime) {
	 	this.txTime = txTime;
	}
	public void setBrName(String brName) {
		this.brName = brName;
	}
	public String getBrName() {
		return brName;
	}
}