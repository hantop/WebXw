package app.creditapp.inf.entity;

/**
 * @���� DHCC-LIU
 * @���� Jun 23, 2016
 * @����   �������β�ѯ--����ʵ����
 */
public class WsIn2103 {
	
	private String brNo; // �����������
	private String appDate; // ��������
	private String batNo; //���κ�
	private int    pageNo; //ҳ��
	private int    pageSize;//ÿҳ����
	
	public String getBrNo() {
		return brNo;
	}
	public void setBrNo(String brNo) {
		this.brNo = brNo;
	}
	public String getAppDate() {
		return appDate;
	}
	public void setAppDate(String appDate) {
		this.appDate = appDate;
	}
	public String getBatNo() {
		return batNo;
	}
	public void setBatNo(String batNo) {
		this.batNo = batNo;
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

}
