package app.creditapp.inf.entity;

/**
 * @���� DHCC-LIU
 * @���� Jun 23, 2016
 * @����  Ƿ����Ϣ��ѯ[3203] ������Ϣ
 */
public class WsIn3203 {
	
	private String brNo;//����������
	private String pactNo;//��ͬ��
	private String cnt;//�ڴκ�
	private int    pageNo;//ҳ��
	private int    pageSize;//ÿҳ����


	public String getBrNo() {
		return brNo;
	}
	public void setBrNo(String brNo) {
		this.brNo = brNo;
	}
	public String getPactNo() {
		return pactNo;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public void setPactNo(String pactNo) {
		this.pactNo = pactNo;
	}
	public String getCnt() {
		return cnt;
	}
	public void setCnt(String cnt) {
		this.cnt = cnt;
	}
	

}
