package app.creditapp.sys.entity;
import app.base.BaseDomain;
/**
* Title: SysUserRel.java
* Description:
* @version��1.0
**/
public class SysUserRole extends BaseDomain {
	private String rec_id;//��ϵID[ϵͳ�Զ�����]
	private String user_no;//�û����
	private String role_no;//��ɫ���

	/**
	 * @return ��ϵID[ϵͳ�Զ�����]
	 */
	public String getRec_id() {
	 	return rec_id;
	}
	/**
	 * @���� ��ϵID[ϵͳ�Զ�����]
	 * @param rel_id
	 */
	public void setRec_id(String rec_id) {
	 	this.rec_id = rec_id;
	}
	/**
	 * @return ��¼�˺�
	 */
	public String getUser_no() {
	 	return user_no;
	}
	/**
	 * @���� ��¼�˺�
	 * @param login_id
	 */
	public void setUser_no(String user_no) {
	 	this.user_no = user_no;
	}
	/**
	 * @return ��ɫ���
	 */
	public String getRole_no() {
	 	return role_no;
	}
	/**
	 * @���� ��ɫ���
	 * @param role_no
	 */
	public void setRole_no(String role_no) {
	 	this.role_no = role_no;
	}
	
	
}