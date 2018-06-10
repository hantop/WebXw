package app.creditapp.approve.entity;
import app.base.BaseDomain;
/**
* Title: ApproveTaskHis.java
* Description:
* @version��1.0
**/
public class ApproveTaskHis extends BaseDomain {
	private String flow_id;//���̱��
	private String task_id;//������
	private String app_type;//��������
	private String app_no;//�����
	private String role_no;//������λ
	private String approve_user;//������
	private String create_time;//����ʱ��
	private String end_time;//����ʱ��
	private String br_no;//����
	private String approve_idea;//�������
	private String idea_desc;//�����������
	private String task_type;//��������
	private String role_name;//��ɫ����
	private String cif_no;//�ͻ���
	private String cif_name;//�ͻ�����
	private String app_content;//��������
	private String signing_flag;//���������л�ǩ��λ���������ı�־
	private String flow_sts;//����״̬
	private String app_data;
	private String br_name;
	private String user_name;
	private String sxapp_no;
	private String cif_flag;
	private String table_name;
	private String col_name;
	private String last_approve_user;//�ϸ�������Ա

	/**
	 * @return ���̱��
	 */
	public String getFlow_id() {
	 	return flow_id;
	}
	/**
	 * @���� ���̱��
	 * @param flow_id
	 */
	public void setFlow_id(String flow_id) {
	 	this.flow_id = flow_id;
	}
	/**
	 * @return ������
	 */
	public String getTask_id() {
	 	return task_id;
	}
	/**
	 * @���� ������
	 * @param task_id
	 */
	public void setTask_id(String task_id) {
	 	this.task_id = task_id;
	}
	/**
	 * @return ��������
	 */
	public String getApp_type() {
	 	return app_type;
	}
	/**
	 * @���� ��������
	 * @param app_type
	 */
	public void setApp_type(String app_type) {
	 	this.app_type = app_type;
	}
	/**
	 * @return �����
	 */
	public String getApp_no() {
	 	return app_no;
	}
	/**
	 * @���� �����
	 * @param app_no
	 */
	public void setApp_no(String app_no) {
	 	this.app_no = app_no;
	}
	/**
	 * @return ������λ
	 */
	public String getRole_no() {
	 	return role_no;
	}
	/**
	 * @���� ������λ
	 * @param role_no
	 */
	public void setRole_no(String role_no) {
	 	this.role_no = role_no;
	}
	/**
	 * @return ������
	 */
	public String getApprove_user() {
	 	return approve_user;
	}
	/**
	 * @���� ������
	 * @param approve_user
	 */
	public void setApprove_user(String approve_user) {
	 	this.approve_user = approve_user;
	}
	/**
	 * @return ����ʱ��
	 */
	public String getCreate_time() {
	 	return create_time;
	}
	/**
	 * @���� ����ʱ��
	 * @param create_time
	 */
	public void setCreate_time(String create_time) {
	 	this.create_time = create_time;
	}
	/**
	 * @return ����ʱ��
	 */
	public String getEnd_time() {
	 	return end_time;
	}
	/**
	 * @���� ����ʱ��
	 * @param end_time
	 */
	public void setEnd_time(String end_time) {
	 	this.end_time = end_time;
	}
	/**
	 * @return ����
	 */
	public String getBr_no() {
	 	return br_no;
	}
	/**
	 * @���� ����
	 * @param br_no
	 */
	public void setBr_no(String br_no) {
	 	this.br_no = br_no;
	}
	/**
	 * @return �������
	 */
	public String getApprove_idea() {
	 	return approve_idea;
	}
	/**
	 * @���� �������
	 * @param approve_idea
	 */
	public void setApprove_idea(String approve_idea) {
	 	this.approve_idea = approve_idea;
	}
	/**
	 * @return �����������
	 */
	public String getIdea_desc() {
	 	return idea_desc;
	}
	/**
	 * @���� �����������
	 * @param idea_desc
	 */
	public void setIdea_desc(String idea_desc) {
	 	this.idea_desc = idea_desc;
	}
	public String getTask_type() {
		return task_type;
	}
	public void setTask_type(String task_type) {
		this.task_type = task_type;
	}
	public String getRole_name() {
		return role_name;
	}
	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}
	public String getCif_no() {
		return cif_no;
	}
	public void setCif_no(String cif_no) {
		this.cif_no = cif_no;
	}
	public String getApp_data() {
		return app_data;
	}
	public void setApp_data(String appData) {
		app_data = appData;
	}
	public String getCif_name() {
		return cif_name;
	}
	public void setCif_name(String cif_name) {
		this.cif_name = cif_name;
	}
	public String getApp_content() {
		return app_content;
	}
	public String getBr_name() {
		return br_name;
	}
	public void setBr_name(String brName) {
		br_name = brName;
	}
	public void setApp_content(String app_content) {
		this.app_content = app_content;
	}
	public String getSigning_flag() {
		return signing_flag;
	}
	public String getFlow_sts() {
		return flow_sts;
	}
	public void setFlow_sts(String flowSts) {
		flow_sts = flowSts;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String userName) {
		user_name = userName;
	}
	public void setSigning_flag(String signing_flag) {
		this.signing_flag = signing_flag;
	}
	public String getSxapp_no() {
		return sxapp_no;
	}
	public void setSxapp_no(String sxappNo) {
		sxapp_no = sxappNo;
	}
	public String getCif_flag() {
		return cif_flag;
	}
	public void setCif_flag(String cifFlag) {
		cif_flag = cifFlag;
	}
	public String getTable_name() {
		return table_name;
	}
	public String getCol_name() {
		return col_name;
	}
	public void setCol_name(String colName) {
		col_name = colName;
	}
	public void setTable_name(String tableName) {
		table_name = tableName;
	}
	public String getLast_approve_user() {
		return last_approve_user;
	}
	public void setLast_approve_user(String lastApproveUser) {
		last_approve_user = lastApproveUser;
	}
}