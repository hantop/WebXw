package app.creditapp.inf.entity;

/**
 * @���� DHCC-SONG
 * @���� Jun 23, 2016
 * @����   Ԥ�������β�ѯʵ����
 */
public class WsOut2005_1 {
	
	private String batNo; //���κ�
	private String batTime; //����ʱ��
	private int    batNum;  //��������
	private int    recvNum; //�������
	private int    chkNum;  //��������
	private int    chkNumOK;//����ͨ������
	public String getBatNo() {
		return batNo;
	}
	public void setBatNo(String batNo) {
		this.batNo = batNo;
	}
	public String getBatTime() {
		return batTime;
	}
	public void setBatTime(String batTime) {
		this.batTime = batTime;
	}
	public int getBatNum() {
		return batNum;
	}
	public void setBatNum(int batNum) {
		this.batNum = batNum;
	}
	public int getRecvNum() {
		return recvNum;
	}
	public void setRecvNum(int recvNum) {
		this.recvNum = recvNum;
	}
	public int getChkNum() {
		return chkNum;
	}
	public void setChkNum(int chkNum) {
		this.chkNum = chkNum;
	}
	public int getChkNumOK() {
		return chkNumOK;
	}
	public void setChkNumOK(int chkNumOK) {
		this.chkNumOK = chkNumOK;
	}
	
	
}
