package app.creditapp.batch.entity;
import app.base.BaseDomain;
/**
* Title: BatchSql.java
* Description:
* @version��1.0
**/
public class BatchSql extends BaseDomain {
	private String node_no;//�ڵ��
	private String sql;//sql���
	private String sql_desc;//sql����
	private Integer sql_lev;//���ȼ�
	private String id;//���ȼ�

	/**
	 * @return �ڵ��
	 */
	public String getNode_no() {
	 	return node_no;
	}
	/**
	 * @���� �ڵ��
	 * @param node_no
	 */
	public void setNode_no(String node_no) {
	 	this.node_no = node_no;
	}
	/**
	 * @return sql���
	 */
	public String getSql() {
	 	return sql;
	}
	/**
	 * @���� sql���
	 * @param sql
	 */
	public void setSql(String sql) {
	 	this.sql = sql;
	}
	/**
	 * @return sql����
	 */
	public String getSql_desc() {
	 	return sql_desc;
	}
	/**
	 * @���� sql����
	 * @param sql_desc
	 */
	public void setSql_desc(String sql_desc) {
	 	this.sql_desc = sql_desc;
	}
	/**
	 * @return ���ȼ�
	 */
	public Integer getSql_lev() {
	 	return sql_lev;
	}
	/**
	 * @���� ���ȼ�
	 * @param sql_lev
	 */
	public void setSql_lev(Integer sql_lev) {
	 	this.sql_lev = sql_lev;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
}