package app.creditapp.sysConfig.entity;

/**
* Title: RequireLogTable.java
* Description:
* @version��1.0
**/

public class SysRequireTable   {
	private String  tableCode;//��
	private String  tableName;//������

	/**
	 * @return ��
	 */
	 public String getTableCode() {
	 	return tableCode;
	 }
	 /**
	 * @���� ��
	 * @param tableCode
	 */
	 public void setTableCode(String tableCode) {
	 	this.tableCode = tableCode;
	 }
	/**
	 * @return ������
	 */
	 public String getTableName() {
	 	return tableName;
	 }
	 /**
	 * @���� ������
	 * @param tableName
	 */
	 public void setTableName(String tableName) {
	 	this.tableName = tableName;
	 }
}
