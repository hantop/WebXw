package app.creditapp.sys.entity;
import app.base.BaseDomain;
/**
* Title: SysLog.java
* Description:
* @version��1.0
**/

public class SysLog extends BaseDomain {
	private String  logId;//��¼ID
	private String  opId;//��������
	private String  opDesc;//��������
	private String  opClass;//��־������������
	private String  logTime;//��־ʱ��
	private String  opNo;//����Ա��
	private String  logDate;//��־����
	//�����ֶ�
	private String userName;//����Ա����
	
	public String getLogId() {
		return logId;
	}
	public void setLogId(String logId) {
		this.logId = logId;
	}
	public String getOpId() {
		return opId;
	}
	public void setOpId(String opId) {
		this.opId = opId;
	}
	public String getOpDesc() {
		return opDesc;
	}
	public void setOpDesc(String opDesc) {
		this.opDesc = opDesc;
	}
	public String getOpClass() {
		return opClass;
	}
	public void setOpClass(String opClass) {
		this.opClass = opClass;
	}
	public String getLogTime() {
		return logTime;
	}
	public void setLogTime(String logTime) {
		this.logTime = logTime;
	}
	public String getOpNo() {
		return opNo;
	}
	public void setOpNo(String opNo) {
		this.opNo = opNo;
	}
	public String getLogDate() {
		return logDate;
	}
	public void setLogDate(String logDate) {
		this.logDate = logDate;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserName() {
		return userName;
	}
}
