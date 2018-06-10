package app.creditapp.sys.entity;
import app.base.BaseDomain;
/**
* Title: SysLoginLog.java
* Description:
* @version��1.0
**/

public class SysLoginLog extends BaseDomain {
	private String  sessionId;//sessionid
	private String  brNo;//������
	private String  opNo;//����Ա��
	private String  opName;//����Ա����
	private String  loginDate;//��¼����
	private String  loginTime;//��¼ʱ��
	private String  loginIp;//�ͻ���ip��ַ
	private String  logoutTime;//�˳�ʱ��
	private String  osName;//�ͻ��˲���ϵͳ����
	private String  osVersion;//�ͻ��˲���ϵͳ�汾
	private String  ieName;//�ͻ������������
	private String  ieVersion;//�ͻ���������汾

	public SysLoginLog(){
	}
	
	public SysLoginLog(String userinfo){
		String[] a = userinfo.split("\\|");
		sessionId = a[0];
		brNo = a[1];
		opNo = a[2];
		opName = a[3];
		loginDate = a[4];
		loginTime = a[5];
		loginIp = a[6];
		logoutTime = "";
		osName = a[7];
		osVersion = a[8];
		ieName = a[9].substring(0,a[9].indexOf("("));
		ieVersion = a[10].substring(0,a[10].indexOf("("));
	}
	/**
	 * @return sessionid
	 */
	 public String getSessionId() {
	 	return sessionId;
	 }
	 /**
	 * @���� sessionid
	 * @param sessionId
	 */
	 public void setSessionId(String sessionId) {
	 	this.sessionId = sessionId;
	 }
	/**
	 * @return ������
	 */
	 public String getBrNo() {
	 	return brNo;
	 }
	 /**
	 * @���� ������
	 * @param brNo
	 */
	 public void setBrNo(String brNo) {
	 	this.brNo = brNo;
	 }
	/**
	 * @return ����Ա��
	 */
	 public String getOpNo() {
	 	return opNo;
	 }
	 /**
	 * @���� ����Ա��
	 * @param opNo
	 */
	 public void setOpNo(String opNo) {
	 	this.opNo = opNo;
	 }
	/**
	 * @return ����Ա����
	 */
	 public String getOpName() {
	 	return opName;
	 }
	 /**
	 * @���� ����Ա����
	 * @param opName
	 */
	 public void setOpName(String opName) {
	 	this.opName = opName;
	 }
	/**
	 * @return ��¼����
	 */
	 public String getLoginDate() {
	 	return loginDate;
	 }
	 /**
	 * @���� ��¼����
	 * @param loginDate
	 */
	 public void setLoginDate(String loginDate) {
	 	this.loginDate = loginDate;
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
	 * @return �ͻ���ip��ַ
	 */
	 public String getLoginIp() {
	 	return loginIp;
	 }
	 /**
	 * @���� �ͻ���ip��ַ
	 * @param loginIp
	 */
	 public void setLoginIp(String loginIp) {
	 	this.loginIp = loginIp;
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
	 * @return �ͻ��˲���ϵͳ����
	 */
	 public String getOsName() {
	 	return osName;
	 }
	 /**
	 * @���� �ͻ��˲���ϵͳ����
	 * @param osName
	 */
	 public void setOsName(String osName) {
	 	this.osName = osName;
	 }
	/**
	 * @return �ͻ��˲���ϵͳ�汾
	 */
	 public String getOsVersion() {
	 	return osVersion;
	 }
	 /**
	 * @���� �ͻ��˲���ϵͳ�汾
	 * @param osVersion
	 */
	 public void setOsVersion(String osVersion) {
	 	this.osVersion = osVersion;
	 }
	/**
	 * @return �ͻ������������
	 */
	 public String getIeName() {
	 	return ieName;
	 }
	 /**
	 * @���� �ͻ������������
	 * @param ieName
	 */
	 public void setIeName(String ieName) {
	 	this.ieName = ieName;
	 }
	/**
	 * @return �ͻ���������汾
	 */
	 public String getIeVersion() {
	 	return ieVersion;
	 }
	 /**
	 * @���� �ͻ���������汾
	 * @param ieVersion
	 */
	 public void setIeVersion(String ieVersion) {
	 	this.ieVersion = ieVersion;
	 }
}
