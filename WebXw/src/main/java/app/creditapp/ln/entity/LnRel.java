package app.creditapp.ln.entity;
import app.base.BaseDomain;
/**
* Title: LnRel.java
* Description:
* @version��1.0
**/
public class LnRel extends BaseDomain {
	private String appId;//����ID
	private String relName;//����������
	private String relIdtype;//������֤��
	private String relIdno;//������֤����
	private String relTel;//��������ϵ�绰

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
	 * @return ����������
	 */
	public String getRelName() {
	 	return relName;
	}
	/**
	 * @���� ����������
	 * @param relName
	 */
	public void setRelName(String relName) {
	 	this.relName = relName;
	}
	/**
	 * @return ������֤��
	 */
	public String getRelIdtype() {
	 	return relIdtype;
	}
	/**
	 * @���� ������֤��
	 * @param relIdtype
	 */
	public void setRelIdtype(String relIdtype) {
	 	this.relIdtype = relIdtype;
	}
	/**
	 * @return ������֤����
	 */
	public String getRelIdno() {
	 	return relIdno;
	}
	/**
	 * @���� ������֤����
	 * @param relIdno
	 */
	public void setRelIdno(String relIdno) {
	 	this.relIdno = relIdno;
	}
	/**
	 * @return ��������ϵ�绰
	 */
	public String getRelTel() {
	 	return relTel;
	}
	/**
	 * @���� ��������ϵ�绰
	 * @param relTel
	 */
	public void setRelTel(String relTel) {
	 	this.relTel = relTel;
	}
}