package app.creditapp.inf.entity;

/**
 * @���� DHCC-SONG
 * @���� Jun 28, 2016
 * @���� ����ʵ����
 */
public class WsIn4103 {
	private String batchNo;//���κ���
//	private String pactNo;//��ͬ����
	private String brNo;//������������
//	private String appDate;//��������
//	private String cifName;//�ͻ�����
//	private String idType;//֤������
	private String idNo;//֤������
//	private String url; // ���ű��������ļ�·��
//	private String chkDesc; // У����
	private int pageNo;
	private int pageSize;
	
	public String getBatchNo() {
		return batchNo;
	}
	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}
	public String getBrNo() {
		return brNo;
	}
	public void setBrNo(String brNo) {
		this.brNo = brNo;
	}
	public String getIdNo() {
		return idNo;
	}
	public void setIdNo(String idNo) {
		this.idNo = idNo;
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
