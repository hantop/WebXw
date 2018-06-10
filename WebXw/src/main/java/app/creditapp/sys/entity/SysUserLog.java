package app.creditapp.sys.entity;
import app.base.BaseDomain;
/**
* Title: SysUserLog.java
* Description:
* @version��1.0
**/
public class SysUserLog extends BaseDomain {
	private String userId;//����Ա��
	private String loginTime;//��¼ʱ��
	private String logoutTime;//�˳�ʱ��
	private String lastTime;//�ϴε�¼ʱ��
	private Integer loginCnt;//��¼����
	private Integer passError;//����������
	private String loginIp;//��¼IP
	private String sessionId;//SESSIONID
	private String clientInfo;//�ն���Ϣ
	//�����ֶ�
	private String userName;//����Ա����
	/**
	 * @return ����Ա��
	 */
	public String getUserId() {
	 	return userId;
	}
	/**
	 * @���� ����Ա��
	 * @param userId
	 */
	public void setUserId(String userId) {
	 	this.userId = userId;
	}
	/**
	 * @return ��¼ʱ��
	 */
	public String getLoginTime() {
	 	return loginTime;
	}
	/**
	 * @���� ��¼ʱ��
	 * @param loginTime
	 */
	public void setLoginTime(String loginTime) {
	 	this.loginTime = loginTime;
	}
	/**
	 * @return �˳�ʱ��
	 */
	public String getLogoutTime() {
	 	return logoutTime;
	}
	/**
	 * @���� �˳�ʱ��
	 * @param logoutTime
	 */
	public void setLogoutTime(String logoutTime) {
	 	this.logoutTime = logoutTime;
	}
	/**
	 * @return �ϴε�¼ʱ��
	 */
	public String getLastTime() {
	 	return lastTime;
	}
	/**
	 * @���� �ϴε�¼ʱ��
	 * @param lastTime
	 */
	public void setLastTime(String lastTime) {
	 	this.lastTime = lastTime;
	}
	/**
	 * @return ��¼����
	 */
	public Integer getLoginCnt() {
	 	return loginCnt;
	}
	/**
	 * @���� ��¼����
	 * @param loginCnt
	 */
	public void setLoginCnt(Integer loginCnt) {
	 	this.loginCnt = loginCnt;
	}
	/**
	 * @return ����������
	 */
	public Integer getPassError() {
	 	return passError;
	}
	/**
	 * @���� ����������
	 * @param passError
	 */
	public void setPassError(Integer passError) {
	 	this.passError = passError;
	}
	/**
	 * @return ��¼IP
	 */
	public String getLoginIp() {
	 	return loginIp;
	}
	/**
	 * @���� ��¼IP
	 * @param loginIp
	 */
	public void setLoginIp(String loginIp) {
	 	this.loginIp = loginIp;
	}
	/**
	 * @return SESSIONID
	 */
	public String getSessionId() {
	 	return sessionId;
	}
	/**
	 * @���� SESSIONID
	 * @param sessionId
	 */
	public void setSessionId(String sessionId) {
	 	this.sessionId = sessionId;
	}
	/**
	 * @return �ն���Ϣ
	 */
	public String getClientInfo() {
	 	return clientInfo;
	}
	/**
	 * @���� �ն���Ϣ
	 * @param clientInfo
	 */
	public void setClientInfo(String clientInfo) {
	 	this.clientInfo = clientInfo;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserName() {
		return userName;
	}
}