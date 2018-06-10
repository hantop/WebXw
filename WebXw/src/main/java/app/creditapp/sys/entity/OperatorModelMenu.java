package app.creditapp.sys.entity;
import app.base.BaseDomain;
/**
* Title: OperatorModelMenu.java
* Description:
* @version��1.0
**/
public class OperatorModelMenu extends BaseDomain {
	private String menu_no;//�˵����
	private String menu_name;//�˵�����
	private String menu_url;//�˵�url
	private String menu_parent;//���˵����
	private String menu_lvl;//�˵�����
	private String menu_stats;//�˵�״̬ ����1��ͣ��0
	private Integer group_seq;//�������
	private String cif_type;//�����ͻ�����
	private String last_url;//��һ����URL��ַ

	/**
	 * @return �˵����
	 */
	public String getMenu_no() {
	 	return menu_no;
	}
	/**
	 * @���� �˵����
	 * @param menu_no
	 */
	public void setMenu_no(String menu_no) {
	 	this.menu_no = menu_no;
	}
	/**
	 * @return �˵�����
	 */
	public String getMenu_name() {
	 	return menu_name;
	}
	/**
	 * @���� �˵�����
	 * @param menu_name
	 */
	public void setMenu_name(String menu_name) {
	 	this.menu_name = menu_name;
	}
	/**
	 * @return �˵�url
	 */
	public String getMenu_url() {
	 	return menu_url;
	}
	/**
	 * @���� �˵�url
	 * @param menu_url
	 */
	public void setMenu_url(String menu_url) {
	 	this.menu_url = menu_url;
	}
	/**
	 * @return ���˵����
	 */
	public String getMenu_parent() {
	 	return menu_parent;
	}
	/**
	 * @���� ���˵����
	 * @param menu_parent
	 */
	public void setMenu_parent(String menu_parent) {
	 	this.menu_parent = menu_parent;
	}
	/**
	 * @return �˵�����
	 */
	public String getMenu_lvl() {
	 	return menu_lvl;
	}
	/**
	 * @���� �˵�����
	 * @param menu_lvl
	 */
	public void setMenu_lvl(String menu_lvl) {
	 	this.menu_lvl = menu_lvl;
	}
	/**
	 * @return �˵�״̬ ����1��ͣ��0
	 */
	public String getMenu_stats() {
	 	return menu_stats;
	}
	/**
	 * @���� �˵�״̬ ����1��ͣ��0
	 * @param menu_stats
	 */
	public void setMenu_stats(String menu_stats) {
	 	this.menu_stats = menu_stats;
	}
	/**
	 * @return �������
	 */
	public Integer getGroup_seq() {
	 	return group_seq;
	}
	/**
	 * @���� �������
	 * @param group_seq
	 */
	public void setGroup_seq(Integer group_seq) {
	 	this.group_seq = group_seq;
	}
	/**
	 * @return �����ͻ�����
	 */
	public String getCif_type() {
	 	return cif_type;
	}
	/**
	 * @���� �����ͻ�����
	 * @param cif_type
	 */
	public void setCif_type(String cif_type) {
	 	this.cif_type = cif_type;
	}
	/**
	 * @return ��һ����URL��ַ
	 */
	public String getLast_url() {
	 	return last_url;
	}
	/**
	 * @���� ��һ����URL��ַ
	 * @param last_url
	 */
	public void setLast_url(String last_url) {
	 	this.last_url = last_url;
	}
}