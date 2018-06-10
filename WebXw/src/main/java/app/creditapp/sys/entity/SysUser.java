package app.creditapp.sys.entity;
import app.base.BaseDomain;
/**
* Title: SysUser.java
* Description:
* @version��1.0
**/
public class SysUser extends BaseDomain {
	private String user_no;//����Ա����
	private String user_name;//����Ա����
	private String disp_name;//���Ƽ��
	private String pass_word;//�û�����
	private String pass_date;//�����޸�����
	private String id_no;//���֤��
	private String user_type;//����Ա����
	private String org_no;//��������
	private String skin;//ϵͳƤ��
	private String user_sts;//״̬(01����02ͣ��)
	private String tx_date;//�Ǽ�����
	private String up_date;//����ʱ��
	private String user_id;//����ԱID
	private String roleNos; // ����Ա��ɫ�� ","�ָ�
	
	private String lastUi;
	
	public String getLastUi() {
		return lastUi;
	}
	public void setLastUi(String lastUi) {
		this.lastUi = lastUi;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_no() {
		return user_no;
	}
	public void setUser_no(String userNo) {
		user_no = userNo;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String userName) {
		user_name = userName;
	}
	public String getDisp_name() {
		return disp_name;
	}
	public void setDisp_name(String dispName) {
		disp_name = dispName;
	}
	public String getPass_word() {
		return pass_word;
	}
	public void setPass_word(String passWord) {
		pass_word = passWord;
	}
	public String getId_no() {
		return id_no;
	}
	public void setId_no(String idNo) {
		id_no = idNo;
	}
	public String getUser_type() {
		return user_type;
	}
	public void setUser_type(String userType) {
		user_type = userType;
	}
	public String getOrg_no() {
		return org_no;
	}
	public void setOrg_no(String orgNo) {
		org_no = orgNo;
	}
	public String getUser_sts() {
		return user_sts;
	}
	public void setUser_sts(String userSts) {
		user_sts = userSts;
	}
	public String getTx_date() {
		return tx_date;
	}
	public void setTx_date(String txDate) {
		tx_date = txDate;
	}
	public String getUp_date() {
		return up_date;
	}
	public void setUp_date(String upDate) {
		up_date = upDate;
	}
	public String getPass_date() {
		return pass_date;
	}
	public void setPass_date(String passDate) {
		pass_date = passDate;
	}
	public String getSkin() {
		return skin;
	}
	public void setSkin(String skin) {
		this.skin = skin;
	}
	public String getRoleNos() {
		return roleNos;
	}
	public void setRoleNos(String roleNos) {
		this.roleNos = roleNos;
	}
	
}