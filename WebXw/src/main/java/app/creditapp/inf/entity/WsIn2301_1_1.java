package app.creditapp.inf.entity;

/**
 * @���� DHCC-LIU
 * @���� Jun 23, 2016
 * @����   �ۿ���Ϣ�ϴ�[2301]listPayOver ������Ϣ
 */
public class WsIn2301_1_1 {
	
	private String pactNo;//��ͬ��
    private int    cnt;// �ڴκ�
	private double txPayOver;//Ӧ�շ�Ϣ
	private String brNo;//����������
	private String wsId;// ����ID
	
	
	public String getPactNo() {
		return pactNo;
	}
	public void setPactNo(String pactNo) {
		this.pactNo = pactNo;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public double getTxPayOver() {
		return txPayOver;
	}
	public void setTxPayOver(double txPayOver) {
		this.txPayOver = txPayOver;
	}
	public String getBrNo() {
		return brNo;
	}
	public void setBrNo(String brNo) {
		this.brNo = brNo;
	}
	public String getWsId() {
		return wsId;
	}
	public void setWsId(String wsId) {
		this.wsId = wsId;
	}

	
	
}
