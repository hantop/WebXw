package app.creditapp.inf.entity;

/**
 * @���� DHCC-ZKX
 * @���� July 18, 2016 list
 * @���� ����ƻ����ʲ�ѯ--���ʵ����
 */
public class WsOut2202 {
	private String pactNo;// ��ͬ�ţ���ͬ��+�ڴ�Ϊ����
	private int cnt;// �ڴ�
	private int endDate;// �˵���
	private double totalAmt;// �ڹ����
	private double prcpAmt;// ���ڱ���
	private double normInt;// ������Ϣ
	private String sts;// ����״̬��01δ���� 02�ѽ���
	private double fineInt;// ��Ϣ
	private double repayPrcpAmt;// �ѻ�����
	private double repayNormInt;// �ѻ���Ϣ
	private double repayFineInt;// �ѻ���Ϣ
	private double wvPrcpAmt;// ���Ȿ��
	private double wvNormInt;// ������Ϣ
	private double wvFineInt;// ���ⷣϢ
	private String prcpSts;// �������״̬
	private String brName; //������������
	
	
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
	public int getEndDate() {
		return endDate;
	}
	public void setEndDate(int endDate) {
		this.endDate = endDate;
	}
	public double getTotalAmt() {
		return totalAmt;
	}
	public void setTotalAmt(double totalAmt) {
		this.totalAmt = totalAmt;
	}
	public double getPrcpAmt() {
		return prcpAmt;
	}
	public void setPrcpAmt(double prcpAmt) {
		this.prcpAmt = prcpAmt;
	}
	public double getNormInt() {
		return normInt;
	}
	public void setNormInt(double normInt) {
		this.normInt = normInt;
	}
	public String getSts() {
		return sts;
	}
	public void setSts(String sts) {
		this.sts = sts;
	}
	public double getFineInt() {
		return fineInt;
	}
	public void setFineInt(double fineInt) {
		this.fineInt = fineInt;
	}
	public double getRepayPrcpAmt() {
		return repayPrcpAmt;
	}
	public void setRepayPrcpAmt(double repayPrcpAmt) {
		this.repayPrcpAmt = repayPrcpAmt;
	}
	public double getRepayNormInt() {
		return repayNormInt;
	}
	public void setRepayNormInt(double repayNormInt) {
		this.repayNormInt = repayNormInt;
	}
	public double getRepayFineInt() {
		return repayFineInt;
	}
	public void setRepayFineInt(double repayFineInt) {
		this.repayFineInt = repayFineInt;
	}
	public double getWvPrcpAmt() {
		return wvPrcpAmt;
	}
	public void setWvPrcpAmt(double wvPrcpAmt) {
		this.wvPrcpAmt = wvPrcpAmt;
	}
	public double getWvNormInt() {
		return wvNormInt;
	}
	public void setWvNormInt(double wvNormInt) {
		this.wvNormInt = wvNormInt;
	}
	public double getWvFineInt() {
		return wvFineInt;
	}
	public void setWvFineInt(double wvFineInt) {
		this.wvFineInt = wvFineInt;
	}
	public String getBrName() {
		return brName;
	}
	public void setBrName(String brName) {
		this.brName = brName;
	}
	public String getPrcpSts() {
		return prcpSts;
	}
	public void setPrcpSts(String prcpSts) {
		this.prcpSts = prcpSts;
	}

	
	
}
