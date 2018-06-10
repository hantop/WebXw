package app.creditapp.inf.entity;

import java.util.List;

/**
 * @���� DHCC-LIU
 * @���� Jun 23, 2016
 * @����  ��ǰ�������[2303]  ������Ϣ
 */
public class WsIn2303 {
	

	private String brNo;//����������
	private String pactNo;//��ͬ��
	private String acName;//�˻�����
	private String acNo;//�����˺�
	private String opnCode;//���д���
	private String opnName;//������
	private String serialNo;//�ۿ���ˮ��
	private double payOver;//Ӧ�շ�Ϣ
	private double feeRec;//Ӧ�մ��۷��ܶ�
	private double repayTotal;//�ۿ���
	private double repayAmt;//�ۿ��
	private double repayInte;//�ۿ���Ϣ
	private double repayOver;//�ۿϢ
	private double feeTotal;//���۷��ܶ�
	
	
	private String cardChn;//�����˻�����
	
	private String dealSts;//����״̬
	private String dealDesc;//��������
	//��ǰ�������id--����
	private String wsId;//����ID  ����
	//20161101���wt
	private List<WsIn2303_1> listPayOver;
	
	public WsIn2303() {
		dealSts = "01";
		dealDesc = "";
	}
	
	public String getBrNo() {
		return brNo;
	}
	public void setBrNo(String brNo) {
		this.brNo = brNo;
	}
	public String getPactNo() {
		return pactNo;
	}
	public void setPactNo(String pactNo) {
		this.pactNo = pactNo;
	}
	public String getAcName() {
		return acName;
	}
	public void setAcName(String acName) {
		this.acName = acName;
	}
	public String getAcNo() {
		return acNo;
	}
	public void setAcNo(String acNo) {
		this.acNo = acNo;
	}
	public String getOpnCode() {
		return opnCode;
	}
	public void setOpnCode(String opnCode) {
		this.opnCode = opnCode;
	}
	public String getOpnName() {
		return opnName;
	}
	public void setOpnName(String opnName) {
		this.opnName = opnName;
	}
	public String getSerialNo() {
		return serialNo;
	}
	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}
	public double getPayOver() {
		return payOver;
	}
	public void setPayOver(double payOver) {
		this.payOver = payOver;
	}
	public double getFeeRec() {
		return feeRec;
	}
	public void setFeeRec(double feeRec) {
		this.feeRec = feeRec;
	}
	public double getRepayTotal() {
		return repayTotal;
	}
	public void setRepayTotal(double repayTotal) {
		this.repayTotal = repayTotal;
	}
	public double getRepayAmt() {
		return repayAmt;
	}
	public void setRepayAmt(double repayAmt) {
		this.repayAmt = repayAmt;
	}
	public double getRepayInte() {
		return repayInte;
	}
	public void setRepayInte(double repayInte) {
		this.repayInte = repayInte;
	}
	public double getRepayOver() {
		return repayOver;
	}
	public void setRepayOver(double repayOver) {
		this.repayOver = repayOver;
	}
	public double getFeeTotal() {
		return feeTotal;
	}
	public void setFeeTotal(double feeTotal) {
		this.feeTotal = feeTotal;
	}
	public String getWsId() {
		return wsId;
	}
	public void setWsId(String wsId) {
		this.wsId = wsId;
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

	public String getCardChn() {
		return cardChn;
	}

	public void setCardChn(String cardChn) {
		this.cardChn = cardChn;
	}

	/**
	 * @return the listPayOver
	 */
	public List<WsIn2303_1> getListPayOver() {
		return listPayOver;
	}

	/**
	 * @param listPayOver the listPayOver to set
	 */
	public void setListPayOver(List<WsIn2303_1> listPayOver) {
		this.listPayOver = listPayOver;
	}
	
	
}
