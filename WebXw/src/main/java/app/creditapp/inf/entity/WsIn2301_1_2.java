package app.creditapp.inf.entity;

public class WsIn2301_1_2 {
	private String pactNo;//��ͬ��
    private int    cnt;// �ڴκ�
	private String feeType;//��������
	private double feeAmt;//���ý��
	private String brNo;//����������
	private String wsId;// ����ID
	private String feeKind;//�������ʹ�������
	
	public String getFeeType() {
		return feeType;
	}
	
	public void setFeeType(String feeType) {
		this.feeType = feeType;
	}
	
	public double getFeeAmt() {
		return feeAmt;
	}
	
	public void setFeeAmt(double feeAmt) {
		this.feeAmt = feeAmt;
	}

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

	public String getFeeKind() {
		return feeKind;
	}

	public void setFeeKind(String feeKind) {
		this.feeKind = feeKind;
	}
	
	
}
