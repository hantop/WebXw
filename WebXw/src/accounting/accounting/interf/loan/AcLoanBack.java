package accounting.interf.loan;

import accounting.domain.sys.AfferentDomain;

public class AcLoanBack extends AfferentDomain {

	private String backLogNo;//�ſ�/�ۿ����ˮ��
	private String backCnt;//˳���
	private String loanLogNo;//�ſ�/�ۿ���ˮ��
	private String backRes;//�ſ���
	private String failCaus;//ʧ��ԭ��
	private String backDate;//��������
	private String cardChn;//֧������
	private String status;//����״̬

	public String getBackLogNo() {
		return backLogNo;
	}
	public void setBackLogNo(String backLogNo) {
		this.backLogNo = backLogNo;
	}
	public String getLoanLogNo() {
		return loanLogNo;
	}
	public void setLoanLogNo(String loanLogNo) {
		this.loanLogNo = loanLogNo;
	}
	public String getBackRes() {
		return backRes;
	}
	public void setBackRes(String backRes) {
		this.backRes = backRes;
	}
	public String getFailCaus() {
		return failCaus;
	}
	public String getBackDate() {
		return backDate;
	}
	public void setFailCaus(String failCaus) {
		this.failCaus = failCaus;
	}
	public void setBackDate(String backDate) {
		this.backDate = backDate;
	}
	public String getBackCnt() {
		return backCnt;
	}
	public void setBackCnt(String backCnt) {
		this.backCnt = backCnt;
	}
	public String getCardChn() {
		return cardChn;
	}
	public void setCardChn(String cardChn) {
		this.cardChn = cardChn;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}


}
