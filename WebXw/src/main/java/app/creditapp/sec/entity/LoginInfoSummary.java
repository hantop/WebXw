package app.creditapp.sec.entity;

import java.util.Date;

public class LoginInfoSummary implements java.io.Serializable{
	private String loginId;
	private Date loginTime;
	private String loginStatus;
	
	private int loginTimeCount;//�ܵ�¼����
	private int loginUserCount;//�ܵ�¼�û�
	private int logoutTimeCount;//��ע������
	private int logoutUserCount;//��ע������
	private int loginFailCount;//��¼ʧ������
	private int onlineUserCount;//��ǰ��������
	private int userAppCount;//���ղ����ܴ���
	
	
	public LoginInfoSummary() {
		super();
	}
	public LoginInfoSummary(String loginId, Date loginTime, String loginStatus) {
		super();
		this.loginId = loginId;
		this.loginTime = loginTime;
		this.loginStatus = loginStatus;
	}
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public Date getLoginTime() {
		return loginTime;
	}
	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}
	public String getLoginStatus() {
		return loginStatus;
	}
	public void setLoginStatus(String loginStatus) {
		this.loginStatus = loginStatus;
	}
	public int getLoginTimeCount() {
		return loginTimeCount;
	}
	public void setLoginTimeCount(int loginTimeCount) {
		this.loginTimeCount = loginTimeCount;
	}
	public int getLoginUserCount() {
		return loginUserCount;
	}
	public void setLoginUserCount(int loginUserCount) {
		this.loginUserCount = loginUserCount;
	}
	public int getLogoutTimeCount() {
		return logoutTimeCount;
	}
	public void setLogoutTimeCount(int logoutTimeCount) {
		this.logoutTimeCount = logoutTimeCount;
	}
	public int getLogoutUserCount() {
		return logoutUserCount;
	}
	public void setLogoutUserCount(int logoutUserCount) {
		this.logoutUserCount = logoutUserCount;
	}
	public int getLoginFailCount() {
		return loginFailCount;
	}
	public void setLoginFailCount(int loginFailCount) {
		this.loginFailCount = loginFailCount;
	}
	public int getOnlineUserCount() {
		return onlineUserCount;
	}
	public void setOnlineUserCount(int onlineUserCount) {
		this.onlineUserCount = onlineUserCount;
	}
	public int getUserAppCount() {
		return userAppCount;
	}
	public void setUserAppCount(int userAppCount) {
		this.userAppCount = userAppCount;
	}
	
}
