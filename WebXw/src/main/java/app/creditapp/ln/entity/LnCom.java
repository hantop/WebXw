package app.creditapp.ln.entity;
import app.base.BaseDomain;
/**
* Title: LnCom.java
* Description:
* @version��1.0
**/
public class LnCom extends BaseDomain {
	private String appId;//����ID
	private String comName;//����
	private String comIdtype;//֤������
	private String comIdno;//֤����
	private String comTel;//��ϵ�绰

	/**
	 * @return ����ID
	 */
	public String getAppId() {
	 	return appId;
	}
	/**
	 * @���� ����ID
	 * @param appId
	 */
	public void setAppId(String appId) {
	 	this.appId = appId;
	}
	/**
	 * @return ����
	 */
	public String getComName() {
	 	return comName;
	}
	/**
	 * @���� ����
	 * @param comName
	 */
	public void setComName(String comName) {
	 	this.comName = comName;
	}
	/**
	 * @return ֤������
	 */
	public String getComIdtype() {
	 	return comIdtype;
	}
	/**
	 * @���� ֤������
	 * @param comIdtype
	 */
	public void setComIdtype(String comIdtype) {
	 	this.comIdtype = comIdtype;
	}
	/**
	 * @return ֤����
	 */
	public String getComIdno() {
	 	return comIdno;
	}
	/**
	 * @���� ֤����
	 * @param comIdno
	 */
	public void setComIdno(String comIdno) {
	 	this.comIdno = comIdno;
	}
	/**
	 * @return ��ϵ�绰
	 */
	public String getComTel() {
	 	return comTel;
	}
	/**
	 * @���� ��ϵ�绰
	 * @param comTel
	 */
	public void setComTel(String comTel) {
	 	this.comTel = comTel;
	}
}