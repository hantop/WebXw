package app.creditapp.sec.entity;

/**
* Title: UserApptime.java
* Description:
* @version��1.0
**/

public class UserApptime   {
	private long  id;//��ʶ
	private String  userId;//�û�����
	private String  userName;//�û�����
	private String  startTime;//��ʼʱ��
	private String  endTime;//����ʱ��
	private double  timeConsuming;//����ʱ��
	private String  actionName;//������
	private String  actionPara;//��������
	private String  belongDate;//������
	private long allAction;//���ʴ���

	public long getAllAction() {
		return allAction;
	}
	public void setAllAction(long allAction) {
		this.allAction = allAction;
	}
	/**
	 * @return ��ʶ
	 */
	 public long getId() {
	 	return id;
	 }
	 /**
	 * @���� ��ʶ
	 * @param id
	 */
	 public void setId(long id) {
	 	this.id = id;
	 }
	/**
	 * @return �û�����
	 */
	 public String getUserId() {
	 	return userId;
	 }
	 /**
	 * @���� �û�����
	 * @param userId
	 */
	 public void setUserId(String userId) {
	 	this.userId = userId;
	 }
	/**
	 * @return �û�����
	 */
	 public String getUserName() {
	 	return userName;
	 }
	 /**
	 * @���� �û�����
	 * @param userName
	 */
	 public void setUserName(String userName) {
	 	this.userName = userName;
	 }
	/**
	 * @return ��ʼʱ��
	 */
	 public String getStartTime() {
	 	return startTime;
	 }
	 /**
	 * @���� ��ʼʱ��
	 * @param startTime
	 */
	 public void setStartTime(String startTime) {
	 	this.startTime = startTime;
	 }
	/**
	 * @return ����ʱ��
	 */
	 public String getEndTime() {
	 	return endTime;
	 }
	 /**
	 * @���� ����ʱ��
	 * @param endTime
	 */
	 public void setEndTime(String endTime) {
	 	this.endTime = endTime;
	 }
	/**
	 * @return ����ʱ��
	 */
	 public double getTimeConsuming() {
	 	return timeConsuming;
	 }
	 /**
	 * @���� ����ʱ��
	 * @param timeConsuming
	 */
	 public void setTimeConsuming(double timeConsuming) {
	 	this.timeConsuming = timeConsuming;
	 }
	/**
	 * @return ������
	 */
	 public String getActionName() {
	 	return actionName;
	 }
	 /**
	 * @���� ������
	 * @param actionName
	 */
	 public void setActionName(String actionName) {
	 	this.actionName = actionName;
	 }
	/**
	 * @return ��������
	 */
	 public String getActionPara() {
	 	return actionPara;
	 }
	 /**
	 * @���� ��������
	 * @param actionPara
	 */
	 public void setActionPara(String actionPara) {
	 	this.actionPara = actionPara;
	 }
	/**
	 * @return ������
	 */
	 public String getBelongDate() {
	 	return belongDate;
	 }
	 /**
	 * @���� ������
	 * @param belongDate
	 */
	 public void setBelongDate(String belongDate) {
	 	this.belongDate = belongDate;
	 }
}
