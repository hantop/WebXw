package app.creditapp.inf.entity;


/**
 * @���� DHCC-WANG
 * @���� Jul 21, 2016
 * @���� ��ǰ��������ѯ--����ʵ���� ln_batch
 */
public class WsIn2805 {
	
	private String brNo; // �����������
	private String batNo;// ���κ�
	private String pactNo;// ��ͬ��
	private int pageNo; // ҳ��
	private int pageSize; // ÿҳ����
	/**
	 * @return �����������
	 */
	public String getBrNo() {
		return brNo;
	}
	/**
	 * @param �����������
	 */
	public void setBrNo(String brNo) {
		this.brNo = brNo;
	}
	/**
	 * @return ���κ�
	 */
	public String getBatNo() {
		return batNo;
	}
	/**
	 * @param ���κ�
	 */
	public void setBatNo(String batNo) {
		this.batNo = batNo;
	}
	/**
	 * @return ��ͬ��
	 */
	public String getPactNo() {
		return pactNo;
	}
	/**
	 * @param ��ͬ��
	 */
	public void setPactNo(String pactNo) {
		this.pactNo = pactNo;
	}
	/**
	 * @return ҳ��
	 */
	public int getPageNo() {
		return pageNo;
	}
	/**
	 * @param ҳ��
	 */
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	/**
	 * @return ÿҳ����
	 */
	public int getPageSize() {
		return pageSize;
	}
	/**
	 * @param ÿҳ����
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
}
