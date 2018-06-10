package app.creditapp.batch.entity;
import app.base.BaseDomain;

/**
 * Title: BatchNode.java Description:
 * 
 * @version��1.0
 **/
public class BatchNode extends BaseDomain {

	private String node_no;// �ڵ��
	private String node_name;// �ڵ�����
	private String scheme_no;// ִ������
	private String scheme_info;// ִ�з���
	private String filler;// ��ע
	private String scheme_time_type;//ִ��ʱ������
	private String scheme_time_detail;//ִ��ʱ����ϸ
	private String use_sts;//���ñ�־
	private String err_flag;//ִ�г���ʱ�������
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
	 * @return ִ������
	 */
	public String getScheme_no() {
		return scheme_no;
	}

	/**
	 * @���� ִ������
	 * @param scheme_no
	 */
	public void setScheme_no(String scheme_no) {
		this.scheme_no = scheme_no;
	}

	/**
	 * @return ִ�з���
	 */
	public String getScheme_info() {
		return scheme_info;
	}

	/**
	 * @���� ִ�з���
	 * @param scheme_info
	 */
	public void setScheme_info(String scheme_info) {
		this.scheme_info = scheme_info;
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

	public String getScheme_time_type() {
		return scheme_time_type;
	}

	public void setScheme_time_type(String schemeTimeType) {
		scheme_time_type = schemeTimeType;
	}

	public String getScheme_time_detail() {
		return scheme_time_detail;
	}

	public void setScheme_time_detail(String schemeTimeDetail) {
		scheme_time_detail = schemeTimeDetail;
	}

	public String getUse_sts() {
		return use_sts;
	}

	public void setUse_sts(String useSts) {
		use_sts = useSts;
	}

	public String getErr_flag() {
		return err_flag;
	}

	public void setErr_flag(String errFlag) {
		err_flag = errFlag;
	}
	

}