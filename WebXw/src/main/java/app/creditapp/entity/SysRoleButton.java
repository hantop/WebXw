package app.creditapp.entity;
/**
 * ����������Ȩ�޶�Ӧ��ť ʵ����
 *
 */
public class SysRoleButton implements java.io.Serializable {
	
	public SysRoleButton() {
	}

	// ��������
	private String id; //
	private String role_no; //
	private String menu_no; //
	private String button_no; //
	// set����

	public void setId(String id) {
		this.id = id;
	}

	public void setRole_no(String role_no) {
		this.role_no = role_no;
	}

	public void setMenu_no(String menu_no) {
		this.menu_no = menu_no;
	}

	public void setButton_no(String button_no) {
		this.button_no = button_no;
	}

	// get����
	public String getId() {
		return id;
	}

	public String getRole_no() {
		return role_no;
	}

	public String getMenu_no() {
		return menu_no;
	}

	public String getButton_no() {
		return button_no;
	}
}
