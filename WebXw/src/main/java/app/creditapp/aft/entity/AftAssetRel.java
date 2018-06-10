package app.creditapp.aft.entity;
import app.base.BaseDomain;
/**
* Title: AftAssetRel.java
* Description:
* @version��1.0
**/
public class AftAssetRel extends BaseDomain {
	private String brNo;//����������
	private String pactNo;//��ͬ���
	private String pactId;//��ͬID
	private String assId;//��ծ��ID
	private String recId;//��¼ID
	private Double assAmt;//��ծ���
	private String opNo;//����Ա
	private String txDate;//�Ǽ�����
	private String upDate;//�Ǽ�����
	private String cifNo;//�ͻ���
	private String cifName;//�ͻ�����
	private String brName;//������������

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
	 * @return ��ͬID
	 */
	public String getPactId() {
	 	return pactId;
	}
	/**
	 * @���� ��ͬID
	 * @param pactId
	 */
	public void setPactId(String pactId) {
	 	this.pactId = pactId;
	}
	/**
	 * @return ��ծ��ID
	 */
	public String getAssId() {
	 	return assId;
	}
	/**
	 * @���� ��ծ��ID
	 * @param assId
	 */
	public void setAssId(String assId) {
	 	this.assId = assId;
	}
	/**
	 * @return ��¼ID
	 */
	public String getRecId() {
	 	return recId;
	}
	/**
	 * @���� ��¼ID
	 * @param recId
	 */
	public void setRecId(String recId) {
	 	this.recId = recId;
	}
	/**
	 * @return ��ծ���
	 */
	public Double getAssAmt() {
	 	return assAmt;
	}
	/**
	 * @���� ��ծ���
	 * @param assAmt
	 */
	public void setAssAmt(Double assAmt) {
	 	this.assAmt = assAmt;
	}
	/**
	 * @return ����Ա
	 */
	public String getOpNo() {
	 	return opNo;
	}
	/**
	 * @���� ����Ա
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
	 * @return ��������
	 */
	public String getUpDate() {
	 	return upDate;
	}
	/**
	 * @���� ��������
	 * @param upDate
	 */
	public void setUpDate(String upDate) {
	 	this.upDate = upDate;
	}
	public String getCifNo() {
		return cifNo;
	}
	public void setCifNo(String cifNo) {
		this.cifNo = cifNo;
	}
	public String getCifName() {
		return cifName;
	}
	public void setCifName(String cifName) {
		this.cifName = cifName;
	}
	public String getBrName() {
		return brName;
	}
	public void setBrName(String brName) {
		this.brName = brName;
	}
}