package app.creditapp.wkf.entity;
import app.base.BaseDomain;
/**
* Title: WkfAppProcess.java
* Description:
* @version1.0
**/
public class WkfAppProcess extends BaseDomain 
{
	private String appNo;//������
	private String processInstanceId;//����ʵ�����
	private String tableName;//ҵ����������
	private String primaryKeyName;//ҵ��������������
	public void setAppNo(String appNo) {
		this.appNo = appNo;
	}
	public String getAppNo() {
		return appNo;
	}
	public void setProcessInstanceId(String processInstanceId) {
		this.processInstanceId = processInstanceId;
	}
	public String getProcessInstanceId() {
		return processInstanceId;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public String getTableName() {
		return tableName;
	}
	public String getPrimaryKeyName() {
		return primaryKeyName;
	}
	public void setPrimaryKeyName(String primaryKeyName) {
		this.primaryKeyName = primaryKeyName;
	}
}