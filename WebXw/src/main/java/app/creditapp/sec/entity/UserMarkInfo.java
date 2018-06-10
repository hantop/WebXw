package app.creditapp.sec.entity;

/**
* Title: UserMarkInfo.java
* Description:
* @version��1.0
**/

public class UserMarkInfo implements java.io.Serializable{
	private String  userId;//�û�����
	private String  passwordUpdateTime;//�����޸�ʱ��
	private int  visitTimes;//��½����
	private int  loginErrorTimes;//��½�������
	private String  lastSignInTime;//�ϴε�½ʱ��
	private String  lastSignOutTime;//�ϴ��˳�ʱ��
	private String  currentSignInTime;//���ε�½ʱ��
	private String  passwordState;//����״̬����
	private String  passwordMessege;//����״̬����

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
	 * @return �����޸�ʱ��
	 */
	 public String getPasswordUpdateTime() {
	 	return passwordUpdateTime;
	 }
	 /**
	 * @���� �����޸�ʱ��
	 * @param passwordUpdateTime
	 */
	 public void setPasswordUpdateTime(String passwordUpdateTime) {
	 	this.passwordUpdateTime = passwordUpdateTime;
	 }
	/**
	 * @return ��½����
	 */
	 public int getVisitTimes() {
	 	return visitTimes;
	 }
	 /**
	 * @���� ��½����
	 * @param visitTimes
	 */
	 public void setVisitTimes(int visitTimes) {
	 	this.visitTimes = visitTimes;
	 }
	/**
	 * @return ��½�������
	 */
	 public int getLoginErrorTimes() {
	 	return loginErrorTimes;
	 }
	 /**
	 * @���� ��½�������
	 * @param loginErrorTimes
	 */
	 public void setLoginErrorTimes(int loginErrorTimes) {
	 	this.loginErrorTimes = loginErrorTimes;
	 }
	/**
	 * @return �ϴε�½ʱ��
	 */
	 public String getLastSignInTime() {
	 	return lastSignInTime;
	 }
	 /**
	 * @���� �ϴε�½ʱ��
	 * @param lastSignInTime
	 */
	 public void setLastSignInTime(String lastSignInTime) {
	 	this.lastSignInTime = lastSignInTime;
	 }
	/**
	 * @return �ϴ��˳�ʱ��
	 */
	 public String getLastSignOutTime() {
	 	return lastSignOutTime;
	 }
	 /**
	 * @���� �ϴ��˳�ʱ��
	 * @param lastSignOutTime
	 */
	 public void setLastSignOutTime(String lastSignOutTime) {
	 	this.lastSignOutTime = lastSignOutTime;
	 }
	/**
	 * @return ���ε�½ʱ��
	 */
	 public String getCurrentSignInTime() {
	 	return currentSignInTime;
	 }
	 /**
	 * @���� ���ε�½ʱ��
	 * @param currentSignInTime
	 */
	 public void setCurrentSignInTime(String currentSignInTime) {
	 	this.currentSignInTime = currentSignInTime;
	 }
	/**
	 * @return ����״̬����
	 */
	 public String getPasswordState() {
	 	return passwordState;
	 }
	 /**
	 * @���� ����״̬����
	 * @param passwordState
	 */
	 public void setPasswordState(String passwordState) {
	 	this.passwordState = passwordState;
	 }
	/**
	 * @return ����״̬����
	 */
	 public String getPasswordMessege() {
	 	return passwordMessege;
	 }
	 /**
	 * @���� ����״̬����
	 * @param passwordMessege
	 */
	 public void setPasswordMessege(String passwordMessege) {
	 	this.passwordMessege = passwordMessege;
	 }
}
