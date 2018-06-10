package app.creditapp.acc.chg.entity;
import app.base.BaseDomain;
/**
* Title: AcRepydayChga.java
* Description:
* @version��1.0
**/
public class AcRepydayChga extends BaseDomain {
	private String batchNo;//���κ�
	private String pactNo;//��ͬ��
	private String brNo;//������
	private Integer newPayDay;//�¿ۿ���
	private String chgReason;//���ԭ��
	private String chgaSts;//���״̬

	/**
	 * @return ���κ�
	 */
	public String getBatchNo() {
	 	return batchNo;
	}
	/**
	 * @���� ���κ�
	 * @param batchNo
	 */
	public void setBatchNo(String batchNo) {
	 	this.batchNo = batchNo;
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
	 * @return �¿ۿ���
	 */
	public Integer getNewPayDay() {
	 	return newPayDay;
	}
	/**
	 * @���� �¿ۿ���
	 * @param newPayDay
	 */
	public void setNewPayDay(Integer newPayDay) {
	 	this.newPayDay = newPayDay;
	}
	/**
	 * @return ���ԭ��
	 */
	public String getChgReason() {
	 	return chgReason;
	}
	/**
	 * @���� ���ԭ��
	 * @param chgReason
	 */
	public void setChgReason(String chgReason) {
	 	this.chgReason = chgReason;
	}
	/**
	 * @return ���״̬
	 */
	public String getChgaSts() {
	 	return chgaSts;
	}
	/**
	 * @���� ���״̬
	 * @param chgaSts
	 */
	public void setChgaSts(String chgaSts) {
	 	this.chgaSts = chgaSts;
	}
}