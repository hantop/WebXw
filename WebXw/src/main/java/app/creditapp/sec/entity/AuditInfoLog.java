package app.creditapp.sec.entity;

/**
* Title: AuditInfoLog.java
* Description:
* @version��1.0
**/

public class AuditInfoLog implements java.io.Serializable{
	private long  logId;//���
	private String  auditType;//�޸�����
	private String  userId;//���޸��˱��
	private String  userName;//���޸�������
	private String  changeUserId;//�޸��˱��
	private String  changeUserName;//�޸�������
	private String  auditTime;//�޸�ʱ��
	private String  remark1;//�޸ļ�¼1
	private String  remark2;//�޸ļ�¼2

	/**
	 * @return ���
	 */
	 public long getLogId() {
	 	return logId;
	 }
	 /**
	 * @���� ���
	 * @param logId
	 */
	 public void setLogId(long logId) {
	 	this.logId = logId;
	 }
	/**
	 * @return �޸�����
	 */
	 public String getAuditType() {
	 	return auditType;
	 }
	 /**
	 * @���� �޸�����
	 * @param auditType
	 */
	 public void setAuditType(String auditType) {
	 	this.auditType = auditType;
	 }
	/**
	 * @return ���޸��˱��
	 */
	 public String getUserId() {
	 	return userId;
	 }
	 /**
	 * @���� ���޸��˱��
	 * @param userId
	 */
	 public void setUserId(String userId) {
	 	this.userId = userId;
	 }
	/**
	 * @return ���޸�������
	 */
	 public String getUserName() {
	 	return userName;
	 }
	 /**
	 * @���� ���޸�������
	 * @param userName
	 */
	 public void setUserName(String userName) {
	 	this.userName = userName;
	 }
	/**
	 * @return �޸��˱��
	 */
	 public String getChangeUserId() {
	 	return changeUserId;
	 }
	 /**
	 * @���� �޸��˱��
	 * @param changeUserId
	 */
	 public void setChangeUserId(String changeUserId) {
	 	this.changeUserId = changeUserId;
	 }
	/**
	 * @return �޸�������
	 */
	 public String getChangeUserName() {
	 	return changeUserName;
	 }
	 /**
	 * @���� �޸�������
	 * @param changeUserName
	 */
	 public void setChangeUserName(String changeUserName) {
	 	this.changeUserName = changeUserName;
	 }
	/**
	 * @return �޸�ʱ��
	 */
	 public String getAuditTime() {
	 	return auditTime;
	 }
	 /**
	 * @���� �޸�ʱ��
	 * @param auditTime
	 */
	 public void setAuditTime(String auditTime) {
	 	this.auditTime = auditTime;
	 }
	/**
	 * @return �޸ļ�¼1
	 */
	 public String getRemark1() {
	 	return remark1;
	 }
	 /**
	 * @���� �޸ļ�¼1
	 * @param remark1
	 */
	 public void setRemark1(String remark1) {
	 	this.remark1 = remark1;
	 }
	/**
	 * @return �޸ļ�¼2
	 */
	 public String getRemark2() {
	 	return remark2;
	 }
	 /**
	 * @���� �޸ļ�¼2
	 * @param remark2
	 */
	 public void setRemark2(String remark2) {
	 	this.remark2 = remark2;
	 }
}
