package app.creditapp.sys.entity;
import app.base.BaseDomain;
/**
* Title: SysRole.java
* Description:
* @version��1.0
**/
public class SysRole extends BaseDomain {
	private String role_no;//��ɫ���
	private String role_name;//��ɫ����
	private String role_type;//��ɫ����[0ҵ���ɫ1������ɫ2����Ա]
	private String role_sts;//��ɫ״̬[02��Ч01��Ч]
	private String role_pro;//��ɫ����

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
	/**
	 * @return ��ɫ����
	 */
	public String getRole_name() {
	 	return role_name;
	}
	/**
	 * @���� ��ɫ����
	 * @param role_name
	 */
	public void setRole_name(String role_name) {
	 	this.role_name = role_name;
	}
	/**
	 * @return ��ɫ����[0ҵ���ɫ1������ɫ2����Ա]
	 */
	public String getRole_type() {
	 	return role_type;
	}
	/**
	 * @���� ��ɫ����[0ҵ���ɫ1������ɫ2����Ա]
	 * @param role_type
	 */
	public void setRole_type(String role_type) {
	 	this.role_type = role_type;
	}
	/**
	 * @return ��ɫ״̬[0��Ч1��Ч]
	 */
	public String getRole_sts() {
	 	return role_sts;
	}
	/**
	 * @���� ��ɫ״̬[0��Ч1��Ч]
	 * @param role_sts
	 */
	public void setRole_sts(String role_sts) {
	 	this.role_sts = role_sts;
	}
	public String getRole_pro() {
		return role_pro;
	}
	public void setRole_pro(String rolePro) {
		role_pro = rolePro;
	}
	
}