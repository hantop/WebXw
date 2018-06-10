package app.creditapp.batch.entity;
import app.base.BaseDomain;
/**
* Title: BatchLog.java
* Description:
* @version��1.0
**/
public class BatchLog extends BaseDomain {
	private String batch_date;//ִ������
	private String node_no;//�ڵ��
	private String node_name;//�ڵ�����
	private String log_info;//��־��Ϣ
	private String beg_time;//��ʼʱ��
	private String end_time;//����ʱ��

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
	 * @return ��־��Ϣ
	 */
	public String getLog_info() {
	 	return log_info;
	}
	/**
	 * @���� ��־��Ϣ
	 * @param log_info
	 */
	public void setLog_info(String log_info) {
	 	this.log_info = log_info;
	}
	/**
	 * @return ��ʼʱ��
	 */
	public String getBeg_time() {
	 	return beg_time;
	}
	/**
	 * @���� ��ʼʱ��
	 * @param beg_time
	 */
	public void setBeg_time(String beg_time) {
	 	this.beg_time = beg_time;
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
}