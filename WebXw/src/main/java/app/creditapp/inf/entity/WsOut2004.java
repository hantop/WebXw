package app.creditapp.inf.entity;
/**
 * @���� DHCC-SONG
 * @���� Jun 28, 2016
 * @����   Ԥ������������[2004] �������
 */
public class WsOut2004 {
	
	private String prePactNo ;// Ԥ����ID
	private String dealSts;// ɸ����[01�ɹ�02�������ͻ�03�����ܾ�04�����ԭ��05����ԭ��]
	private String dealDesc;// ɸ��������

	public String getPrePactNo() {
		return prePactNo;
	}
	public void setPrePactNo(String prePactNo) {
		this.prePactNo = prePactNo;
	}
	public String getDealSts() {
		return dealSts;
	}
	public void setDealSts(String dealSts) {
		this.dealSts = dealSts;
	}
	public String getDealDesc() {
		return dealDesc;
	}
	public void setDealDesc(String dealDesc) {
		this.dealDesc = dealDesc;
	}
	
	
}
