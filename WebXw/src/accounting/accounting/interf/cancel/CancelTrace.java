package accounting.interf.cancel;

import accounting.domain.sys.AfferentDomain;

/**
 * ����/�����������ݴ������
 * 
 * 
 */
public class CancelTrace extends AfferentDomain {

	private String traceNo; // ������ˮ��
	private int traceCnt;// ��ˮ�ʴ�
	private String type; // ����ʽ��������ROL/������REV��

	/**
	 * @return ������ˮ��
	 */
	public String getTraceNo() {
		return traceNo;
	}

	/**
	 * @param traceNo
	 *            ������ˮ��
	 */
	public void setTraceNo(String traceNo) {
		this.traceNo = traceNo;
	}

	/**
	 * @return ����ʽ
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type
	 *            ����ʽ
	 */
	public void setType(String type) {
		this.type = type;
	}

	public int getTraceCnt() {
		return traceCnt;
	}

	public void setTraceCnt(int traceCnt) {
		this.traceCnt = traceCnt;
	}

}
