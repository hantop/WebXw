package app.creditapp.entity;

public class ParmDic implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// ��������
	private String key_name; // �ֶ���
	private String opt_code; // ѡ��ֵ
	private String opt_name; // ѡ����
	private Integer opt_seq; // ˳��
	private String opt_sts; // ״̬
	public String getKey_name() {
		return key_name;
	}

	public void setKey_name(String key_name) {
		this.key_name = key_name;
	}

	public String getOpt_code() {
		return opt_code;
	}

	public void setOpt_code(String opt_code) {
		this.opt_code = opt_code;
	}

	public String getOpt_name() {
		return opt_name;
	}

	public void setOpt_name(String opt_name) {
		this.opt_name = opt_name;
	}

	public Integer getOpt_seq() {
		return opt_seq;
	}

	public void setOpt_seq(Integer optSeq) {
		opt_seq = optSeq;
	}

	public String getOpt_sts() {
		return opt_sts;
	}

	public void setOpt_sts(String optSts) {
		opt_sts = optSts;
	}



}