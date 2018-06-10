package app.creditapp.approve.entity;
import app.base.BaseDomain;
/**
* Title: ApproveNote.java
* Description:
* @version��1.0
**/
public class ApproveNote extends BaseDomain {
	private String note_id;//����֪ͨ����
	private String create_time;//ҵ���걨����
	private String br_no;//ҵ��������ҵ��
	private String br_name;//ҵ��������ҵ������
	private String group_no;//ҵ�������ͻ�������
	private String group_name;//ҵ�������ͻ�����������
	private Double app_amt;//��׼���Ŷ��
	private String chk_time;//�״������
	private String app_idea;//�������
	private String lim_type;//����������
	private String prod_no;//ҵ��Ʒ��
	private String use_method;//ʹ�÷���
	private String ln_amt;//���
	private String term_mon;//��������
	private String ln_use;//��;
	private String ln_rate;//����
	private String filler;//��ע
	private String op_no;//�Ǽ���
	private String tx_date;//�Ǽ�����
	private String up_time;//����ʱ��
	private String up_opno;//������Ա

	/**
	 * @return ����֪ͨ����
	 */
	public String getNote_id() {
	 	return note_id;
	}
	/**
	 * @���� ����֪ͨ����
	 * @param note_id
	 */
	public void setNote_id(String note_id) {
	 	this.note_id = note_id;
	}
	/**
	 * @return ҵ���걨����
	 */
	public String getCreate_time() {
	 	return create_time;
	}
	/**
	 * @���� ҵ���걨����
	 * @param create_time
	 */
	public void setCreate_time(String create_time) {
	 	this.create_time = create_time;
	}
	/**
	 * @return ҵ��������ҵ��
	 */
	public String getBr_no() {
	 	return br_no;
	}
	/**
	 * @���� ҵ��������ҵ��
	 * @param br_no
	 */
	public void setBr_no(String br_no) {
	 	this.br_no = br_no;
	}
	/**
	 * @return ҵ�������ͻ�������
	 */
	public String getGroup_no() {
	 	return group_no;
	}
	/**
	 * @���� ҵ�������ͻ�������
	 * @param group_no
	 */
	public void setGroup_no(String group_no) {
	 	this.group_no = group_no;
	}
	/**
	 * @return ��׼���Ŷ��
	 */
	public Double getApp_amt() {
	 	return app_amt;
	}
	/**
	 * @���� ��׼���Ŷ��
	 * @param app_amt
	 */
	public void setApp_amt(Double app_amt) {
	 	this.app_amt = app_amt;
	}
	/**
	 * @return �״������
	 */
	public String getChk_time() {
	 	return chk_time;
	}
	/**
	 * @���� �״������
	 * @param chk_time
	 */
	public void setChk_time(String chk_time) {
	 	this.chk_time = chk_time;
	}
	/**
	 * @return �������
	 */
	public String getApp_idea() {
	 	return app_idea;
	}
	/**
	 * @���� �������
	 * @param app_idea
	 */
	public void setApp_idea(String app_idea) {
	 	this.app_idea = app_idea;
	}
	/**
	 * @return ����������
	 */
	public String getLim_type() {
	 	return lim_type;
	}
	/**
	 * @���� ����������
	 * @param lim_type
	 */
	public void setLim_type(String lim_type) {
	 	this.lim_type = lim_type;
	}
	/**
	 * @return ҵ��Ʒ��
	 */
	public String getProd_no() {
	 	return prod_no;
	}
	/**
	 * @���� ҵ��Ʒ��
	 * @param prod_no
	 */
	public void setProd_no(String prod_no) {
	 	this.prod_no = prod_no;
	}
	/**
	 * @return ʹ�÷���
	 */
	public String getUse_method() {
	 	return use_method;
	}
	/**
	 * @���� ʹ�÷���
	 * @param use_method
	 */
	public void setUse_method(String use_method) {
	 	this.use_method = use_method;
	}
	/**
	 * @return ���
	 */
	public String getLn_amt() {
	 	return ln_amt;
	}
	/**
	 * @���� ���
	 * @param ln_amt
	 */
	public void setLn_amt(String ln_amt) {
	 	this.ln_amt = ln_amt;
	}
	/**
	 * @return ��������
	 */
	public String getTerm_mon() {
	 	return term_mon;
	}
	/**
	 * @���� ��������
	 * @param term_mon
	 */
	public void setTerm_mon(String term_mon) {
	 	this.term_mon = term_mon;
	}
	/**
	 * @return ��;
	 */
	public String getLn_use() {
	 	return ln_use;
	}
	/**
	 * @���� ��;
	 * @param ln_use
	 */
	public void setLn_use(String ln_use) {
	 	this.ln_use = ln_use;
	}
	/**
	 * @return ����
	 */
	public String getLn_rate() {
	 	return ln_rate;
	}
	/**
	 * @���� ����
	 * @param ln_rate
	 */
	public void setLn_rate(String ln_rate) {
	 	this.ln_rate = ln_rate;
	}
	/**
	 * @return ��ע
	 */
	public String getFiller() {
	 	return filler;
	}
	/**
	 * @���� ��ע
	 * @param filler
	 */
	public void setFiller(String filler) {
	 	this.filler = filler;
	}
	/**
	 * @return �Ǽ���
	 */
	public String getOp_no() {
	 	return op_no;
	}
	/**
	 * @���� �Ǽ���
	 * @param op_no
	 */
	public void setOp_no(String op_no) {
	 	this.op_no = op_no;
	}
	/**
	 * @return �Ǽ�����
	 */
	public String getTx_date() {
	 	return tx_date;
	}
	/**
	 * @���� �Ǽ�����
	 * @param tx_date
	 */
	public void setTx_date(String tx_date) {
	 	this.tx_date = tx_date;
	}
	/**
	 * @return ����ʱ��
	 */
	public String getUp_time() {
	 	return up_time;
	}
	/**
	 * @���� ����ʱ��
	 * @param up_time
	 */
	public void setUp_time(String up_time) {
	 	this.up_time = up_time;
	}
	/**
	 * @return ������Ա
	 */
	public String getUp_opno() {
	 	return up_opno;
	}
	/**
	 * @���� ������Ա
	 * @param up_opno
	 */
	public void setUp_opno(String up_opno) {
	 	this.up_opno = up_opno;
	}
	public String getBr_name() {
		return br_name;
	}
	public void setBr_name(String brName) {
		br_name = brName;
	}
	public String getGroup_name() {
		return group_name;
	}
	public void setGroup_name(String groupName) {
		group_name = groupName;
	}
}