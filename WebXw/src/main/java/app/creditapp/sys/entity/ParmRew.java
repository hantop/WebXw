package app.creditapp.sys.entity;
import app.base.BaseDomain;
/**
* Title: ParmRew.java
* Description:
* @version��1.0
**/
public class ParmRew extends BaseDomain {
	private String rewNo;//�������
	private String rewName;//��������
	private String rewType;//Ԥ������[01Ԥ��02��Ϣ]
	private String rewLevel;//Ԥ������[01��ɫ02��ɫ03��ɫ]
	private Double rewValue;//Ԥ����ֵ
	private String rewUnit;//��ֵ��λ
	private String rewDeal;//����ʽ[01����02�ʼ�03FTP]
	private String rewCyc;//��������[01ÿ��]
	private String rewAcpt;//������[01��Ӫ��Ա02��������03ȫ��]
	private String rewSts;//״̬[01����02ͣ��]
	private String txDate;//�Ǽ�ʱ��
	private String upDate;//����ʱ��

	/**
	 * @return �������
	 */
	public String getRewNo() {
	 	return rewNo;
	}
	/**
	 * @���� �������
	 * @param rewNo
	 */
	public void setRewNo(String rewNo) {
	 	this.rewNo = rewNo;
	}
	/**
	 * @return ��������
	 */
	public String getRewName() {
	 	return rewName;
	}
	/**
	 * @���� ��������
	 * @param rewName
	 */
	public void setRewName(String rewName) {
	 	this.rewName = rewName;
	}
	/**
	 * @return Ԥ������[01Ԥ��02��Ϣ]
	 */
	public String getRewType() {
	 	return rewType;
	}
	/**
	 * @���� Ԥ������[01Ԥ��02��Ϣ]
	 * @param rewType
	 */
	public void setRewType(String rewType) {
	 	this.rewType = rewType;
	}
	/**
	 * @return Ԥ������[01��ɫ02��ɫ03��ɫ]
	 */
	public String getRewLevel() {
	 	return rewLevel;
	}
	/**
	 * @���� Ԥ������[01��ɫ02��ɫ03��ɫ]
	 * @param rewLevel
	 */
	public void setRewLevel(String rewLevel) {
	 	this.rewLevel = rewLevel;
	}
	/**
	 * @return Ԥ����ֵ
	 */
	public Double getRewValue() {
	 	return rewValue;
	}
	/**
	 * @���� Ԥ����ֵ
	 * @param rewValue
	 */
	public void setRewValue(Double rewValue) {
	 	this.rewValue = rewValue;
	}
	/**
	 * @return ��ֵ��λ
	 */
	public String getRewUnit() {
	 	return rewUnit;
	}
	/**
	 * @���� ��ֵ��λ
	 * @param rewUnit
	 */
	public void setRewUnit(String rewUnit) {
	 	this.rewUnit = rewUnit;
	}
	/**
	 * @return ����ʽ[01����02�ʼ�03FTP]
	 */
	public String getRewDeal() {
	 	return rewDeal;
	}
	/**
	 * @���� ����ʽ[01����02�ʼ�03FTP]
	 * @param rewDeal
	 */
	public void setRewDeal(String rewDeal) {
	 	this.rewDeal = rewDeal;
	}
	/**
	 * @return ��������[01ÿ��]
	 */
	public String getRewCyc() {
	 	return rewCyc;
	}
	/**
	 * @���� ��������[01ÿ��]
	 * @param rewCyc
	 */
	public void setRewCyc(String rewCyc) {
	 	this.rewCyc = rewCyc;
	}
	/**
	 * @return ������[01��Ӫ��Ա02��������03ȫ��]
	 */
	public String getRewAcpt() {
	 	return rewAcpt;
	}
	/**
	 * @���� ������[01��Ӫ��Ա02��������03ȫ��]
	 * @param rewAcpt
	 */
	public void setRewAcpt(String rewAcpt) {
	 	this.rewAcpt = rewAcpt;
	}
	/**
	 * @return ״̬[01����02ͣ��]
	 */
	public String getRewSts() {
	 	return rewSts;
	}
	/**
	 * @���� ״̬[01����02ͣ��]
	 * @param rewSts
	 */
	public void setRewSts(String rewSts) {
	 	this.rewSts = rewSts;
	}
	/**
	 * @return �Ǽ�ʱ��
	 */
	public String getTxDate() {
	 	return txDate;
	}
	/**
	 * @���� �Ǽ�ʱ��
	 * @param txDate
	 */
	public void setTxDate(String txDate) {
	 	this.txDate = txDate;
	}
	/**
	 * @return ����ʱ��
	 */
	public String getUpDate() {
	 	return upDate;
	}
	/**
	 * @���� ����ʱ��
	 * @param upDate
	 */
	public void setUpDate(String upDate) {
	 	this.upDate = upDate;
	}
}