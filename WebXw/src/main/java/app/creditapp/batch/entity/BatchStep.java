package app.creditapp.batch.entity;
import app.base.BaseDomain;
/**
* Title: BatchStep.java
* Description:
* @version��1.0
**/
public class BatchStep extends BaseDomain {
	private String node_no;//�ڵ��
	private String node_name;//�ڵ�����
	private String up_node_no;//�ϼ�����
	private String up_node_name;//�ϼ��������

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
	 * @return �ڵ�����
	 */
	public String getNode_name() {
	 	return node_name;
	}
	/**
	 * @���� �ڵ�����
	 * @param node_name
	 */
	public void setNode_name(String node_name) {
	 	this.node_name = node_name;
	}
	/**
	 * @return �ϼ�����
	 */
	public String getUp_node_no() {
	 	return up_node_no;
	}
	/**
	 * @���� �ϼ�����
	 * @param up_node_no
	 */
	public void setUp_node_no(String up_node_no) {
	 	this.up_node_no = up_node_no;
	}
	/**
	 * @return �ϼ��������
	 */
	public String getUp_node_name() {
	 	return up_node_name;
	}
	/**
	 * @���� �ϼ��������
	 * @param up_node_name
	 */
	public void setUp_node_name(String up_node_name) {
	 	this.up_node_name = up_node_name;
	}
}