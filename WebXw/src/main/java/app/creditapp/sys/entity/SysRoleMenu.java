package app.creditapp.sys.entity;
import app.base.BaseDomain;
/**
* Title: SysRoleMenu.java
* Description:
* @version��1.0
**/
public class SysRoleMenu extends BaseDomain {
	private String rec_id;//����
	private String role_no;//��ɫ��
	private String menu_no;//�˵���

	/**
	 * @return ����
	 */
	public String getRec_id() {
	 	return rec_id;
	}
	/**
	 * @���� ����
	 * @param id
	 */
	public void setRec_id(String rec_id) {
	 	this.rec_id = rec_id;
	}
	/**
	 * @return ��ɫ��
	 */
	public String getRole_no() {
	 	return role_no;
	}
	/**
	 * @���� ��ɫ��
	 * @param role_no
	 */
	public void setRole_no(String role_no) {
	 	this.role_no = role_no;
	}
	/**
	 * @return �˵���
	 */
	public String getMenu_no() {
	 	return menu_no;
	}
	/**
	 * @���� �˵���
	 * @param menu_no
	 */
	public void setMenu_no(String menu_no) {
	 	this.menu_no = menu_no;
	}
}