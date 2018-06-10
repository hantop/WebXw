package app.creditapp.aft.entity;
import app.base.BaseDomain;
/**
* Title: AftRewDeal.java
* Description:
* @version��1.0
**/
public class AftRewDeal extends BaseDomain {
	private String rewId;//Ԥ��ID
	private String recId;//��¼ID
	private String dealDate;//��������
	private String dealType;//����ʽ
	private String dealDesc;//����˵��
	private String dealRest;//������
	private String opNo;//������
	private String txDate;//�Ǽ�����
	private String upDate;//��������
	private String opName;//����Ա����
	private String rewName;//Ԥ������
	
	private String rewFlag;//Ԥ����־ 01ҵ��Ԥ�� 02��ĿԤ�� 03�ʽ�Ԥ��

	/**
	 * @return Ԥ��ID
	 */
	public String getRewId() {
	 	return rewId;
	}
	/**
	 * @���� Ԥ��ID
	 * @param rewId
	 */
	public void setRewId(String rewId) {
	 	this.rewId = rewId;
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
	 * @return ��������
	 */
	public String getDealDate() {
	 	return dealDate;
	}
	/**
	 * @���� ��������
	 * @param dealDate
	 */
	public void setDealDate(String dealDate) {
	 	this.dealDate = dealDate;
	}
	/**
	 * @return ����ʽ
	 */
	public String getDealType() {
	 	return dealType;
	}
	/**
	 * @���� ����ʽ
	 * @param dealType
	 */
	public void setDealType(String dealType) {
	 	this.dealType = dealType;
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
	 * @return ������
	 */
	public String getDealRest() {
	 	return dealRest;
	}
	/**
	 * @���� ������
	 * @param dealRest
	 */
	public void setDealRest(String dealRest) {
	 	this.dealRest = dealRest;
	}
	/**
	 * @return ������
	 */
	public String getOpNo() {
	 	return opNo;
	}
	/**
	 * @���� ������
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
	public String getOpName() {
		return opName;
	}
	public void setOpName(String opName) {
		this.opName = opName;
	}
	public String getRewName() {
		return rewName;
	}
	public void setRewName(String rewName) {
		this.rewName = rewName;
	}
	public String getRewFlag() {
		return rewFlag;
	}
	public void setRewFlag(String rewFlag) {
		this.rewFlag = rewFlag;
	}
}