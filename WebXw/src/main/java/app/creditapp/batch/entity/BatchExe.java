package app.creditapp.batch.entity;
import app.base.BaseDomain;
/**
* Title: BatchExe.java
* Description:
* @version��1.0
**/
public class BatchExe extends BaseDomain {
	private String node_no;//�ڵ��
	private String node_name;//�ڵ�����
	private String node_status;//�ڵ�״̬
	private String batch_date;//ִ������
	private Integer arrive_step;//ִ�в���

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
	 * @return �ڵ�״̬
	 */
	public String getNode_status() {
	 	return node_status;
	}
	/**
	 * @���� �ڵ�״̬
	 * @param node_status
	 */
	public void setNode_status(String node_status) {
	 	this.node_status = node_status;
	}
	/**
	 * @return ִ������
	 */
	public String getBatch_date() {
	 	return batch_date;
	}
	/**
	 * @���� ִ������
	 * @param batch_date
	 */
	public void setBatch_date(String batch_date) {
	 	this.batch_date = batch_date;
	}
	/**
	 * @return ִ�в���
	 */
	public Integer getArrive_step() {
	 	return arrive_step;
	}
	/**
	 * @���� ִ�в���
	 * @param arrive_step
	 */
	public void setArrive_step(Integer arrive_step) {
	 	this.arrive_step = arrive_step;
	}
}