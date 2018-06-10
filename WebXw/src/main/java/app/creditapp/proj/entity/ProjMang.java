package app.creditapp.proj.entity;
import app.base.BaseDomain;
/**
* Title: ProjMang.java
* Description:
* @version��1.0
**/
public class ProjMang extends BaseDomain {
	private String loginId;//��Ӫ��ID[��¼��(LOGIN_ID)]
	private String projNo;//��Ŀ���
	private String relId;//��ϵID[����]
	private String userName;//��Ŀ��������
	private String prdtName;//��Ŀ����
	private String perSOn;  //ָ�˱��
	private String tiMe;    //ָ��ʱ��
	private String id;//���
	private String managers;//��Ŀ������    
	private String loginName;//��Ӫ������
	private String vipFlag;//���0δ���1VIP���
	private String perSOnName;  //ָ��������
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * @return ��Ŀ����[��¼��(LOGIN_ID)]
	 */
	public String getLoginId() {
	 	return loginId;
	}
	/**
	 * @���� ��Ŀ����[��¼��(LOGIN_ID)]
	 * @param loginId
	 */
	public void setLoginId(String loginId) {
	 	this.loginId = loginId;
	}
	/**
	 * @return ��Ŀ���
	 */
	public String getProjNo() {
	 	return projNo;
	}
	/**
	 * @���� ��Ŀ���
	 * @param projNo
	 */
	public void setProjNo(String projNo) {
	 	this.projNo = projNo;
	}
	/**
	 * @return ��ϵID[����]
	 */
	public String getRelId() {
	 	return relId;
	}
	/**
	 * @���� ��ϵID[����]
	 * @param relId
	 */
	public void setRelId(String relId) {
	 	this.relId = relId;
	}
	public String getPrdtName() {
		return prdtName;
	}
	public void setPrdtName(String prdtName) {
		this.prdtName = prdtName;
	}
	public String getPerSOn() {
		return perSOn;
	}
	public void setPerSOn(String perSOn) {
		this.perSOn = perSOn;
	}
	public String getTiMe() {
		return tiMe;
	}
	public void setTiMe(String tiMe) {
		this.tiMe = tiMe;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getManagers() {
		return managers;
	}
	public void setManagers(String managers) {
		this.managers = managers;
	}
	public String getVipFlag() {
		return vipFlag;
	}
	public void setVipFlag(String vipFlag) {
		this.vipFlag = vipFlag;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getPerSOnName() {
		return perSOnName;
	}
	public void setPerSOnName(String perSOnName) {
		this.perSOnName = perSOnName;
	}
}