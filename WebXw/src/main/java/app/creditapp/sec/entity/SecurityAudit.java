package app.creditapp.sec.entity;

/**
* Title: SecurityAudit.java
* Description:
* @version��1.0
**/

public class SecurityAudit implements java.io.Serializable{
	private String  itemNo;//���
	private String  codeType;//��������
	private String  itemName;//��������
	private String  itemValues;//����ֵ
	private String  isUse;//���ñ�־
	private int  isEdit;//�Ƿ�ɱ༭
	private String item_desc;
	public String getItem_desc() {
		return item_desc;
	}
	public void setItem_desc(String itemDesc) {
		item_desc = itemDesc;
	}
	public int getIsEdit() {
		return isEdit;
	}
	public void setIsEdit(int isEdit) {
		this.isEdit = isEdit;
	}
	/**
	 * @return ���
	 */
	 public String getItemNo() {
	 	return itemNo;
	 }
	 /**
	 * @���� ���
	 * @param itemNo
	 */
	 public void setItemNo(String itemNo) {
	 	this.itemNo = itemNo;
	 }
	/**
	 * @return ��������
	 */
	 public String getCodeType() {
	 	return codeType;
	 }
	 /**
	 * @���� ��������
	 * @param codeType
	 */
	 public void setCodeType(String codeType) {
	 	this.codeType = codeType;
	 }
	/**
	 * @return ��������
	 */
	 public String getItemName() {
	 	return itemName;
	 }
	 /**
	 * @���� ��������
	 * @param itemName
	 */
	 public void setItemName(String itemName) {
	 	this.itemName = itemName;
	 }
	/**
	 * @return ����ֵ
	 */
	 public String getItemValues() {
	 	return itemValues;
	 }
	 /**
	 * @���� ����ֵ
	 * @param itemValues
	 */
	 public void setItemValues(String itemValues) {
	 	this.itemValues = itemValues;
	 }
	/**
	 * @return ���ñ�־
	 */
	 public String getIsUse() {
	 	return isUse;
	 }
	 /**
	 * @���� ���ñ�־
	 * @param isUse
	 */
	 public void setIsUse(String isUse) {
	 	this.isUse = isUse;
	 }
}
