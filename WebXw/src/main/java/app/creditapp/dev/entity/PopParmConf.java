package app.creditapp.dev.entity;
import app.base.BaseDomain;
/**
* Title: PopParmConf.java
* Description:
* @version��1.0
**/
public class PopParmConf extends BaseDomain {
	
	private String scene_id;//�������
	private String col_name;//�б���ʾ����
	private String sql;//��ѯ�б����
	private String db_bean_rel;//���ݿ��Ӧ���Թ�ϵ
	private String scene_desc;//��������
	private String query_name;//��ѯnameֵ
	private String query_disName;//��ѯ��ʾ����
	private String page_no;//ҳ��
	private String dyn_or;//��̬or
	private String dyn_and;//��̬and
	private String orderby;//����
	private String if_checkbox;//�Ƿ��ѡ
	private String hidden_col;//��������
	private String if_query;//�Ƿ�ֱ�Ӳ�ѯ

	public String getPage_no() {
		return page_no;
	}
	public void setPage_no(String pageNo) {
		page_no = pageNo;
	}
	public String getQuery_name() {
		return query_name;
	}
	public void setQuery_name(String queryName) {
		query_name = queryName;
	}
	public String getQuery_disName() {
		return query_disName;
	}
	public void setQuery_disName(String queryDisName) {
		query_disName = queryDisName;
	}
	/**
	 * @return �������
	 */
	public String getScene_id() {
	 	return scene_id;
	}
	/**
	 * @���� �������
	 * @param scene_id
	 */
	public void setScene_id(String scene_id) {
	 	this.scene_id = scene_id;
	}
	/**
	 * @return �б���ʾ����
	 */
	public String getCol_name() {
	 	return col_name;
	}
	/**
	 * @���� �б���ʾ����
	 * @param col_name
	 */
	public void setCol_name(String col_name) {
	 	this.col_name = col_name;
	}
	/**
	 * @return ��ѯ�б����
	 */
	public String getSql() {
	 	return sql;
	}
	/**
	 * @���� ��ѯ�б����
	 * @param sql
	 */
	public void setSql(String sql) {
	 	this.sql = sql;
	}
	/**
	 * @return ���ݿ��Ӧ���Թ�ϵ
	 */
	public String getDb_bean_rel() {
	 	return db_bean_rel;
	}
	/**
	 * @���� ���ݿ��Ӧ���Թ�ϵ
	 * @param db_bean_rel
	 */
	public void setDb_bean_rel(String db_bean_rel) {
	 	this.db_bean_rel = db_bean_rel;
	}
	public String getScene_desc() {
		return scene_desc;
	}
	public void setScene_desc(String scene_desc) {
		this.scene_desc = scene_desc;
	}
	
	public String getDyn_and() {
		return dyn_and;
	}
	public void setDyn_and(String dynAnd) {
		dyn_and = dynAnd;
	}
	public String getOrderby() {
		return orderby;
	}
	public void setOrderby(String orderby) {
		this.orderby = orderby;
	}
	public String getDyn_or() {
		return dyn_or;
	}
	public String getIf_checkbox() {
		return if_checkbox;
	}
	public void setIf_checkbox(String ifCheckbox) {
		if_checkbox = ifCheckbox;
	}
	public String getIf_query() {
		return if_query;
	}
	public void setIf_query(String ifQuery) {
		if_query = ifQuery;
	}
	public void setDyn_or(String dynOr) {
		dyn_or = dynOr;
	}
	public String getHidden_col() {
		return hidden_col;
	}
	public void setHidden_col(String hiddenCol) {
		hidden_col = hiddenCol;
	}
}