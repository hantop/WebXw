package accounting.domain.loan;

import java.util.Map;

import accounting.domain.sys.AfferentDomain;

public class AcLoanBackLog extends accounting.domain.sys.CMISDomain {

	private String backLogNo;//�ſ�/�ۿ����ˮ��
	private String backCnt;//���
	private String loanLogNo;//�ſ�/�ۿ���ˮ��
	private String backType;//��������[01-�ſ02-�ۿ�]
	private String backRes;//�ſ���
	private String failCaus;//ʧ��ԭ��
	private String backDate;//��������
	private String backSts;//����״̬
	private String busOrderType;//ҵ�񶩵���������
	private String busEntryType;//��Ŀ��������
	private String descCode;//��������
	
	private String traceNo;//������ˮ
	private String uuid;//�ӿ���ˮ��
	private String status;//֧�����ر��Ľ��״̬
	private String txTime;//��������ʱ��
	private String upTime;//����ʱ��
	private String cardChn;//֧������

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
	public String getBackSts() {
		return backSts;
	}
	public void setBackSts(String backSts) {
		this.backSts = backSts;
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
	public String getBackType() {
		return backType;
	}
	public void setBackType(String backType) {
		this.backType = backType;
	}
	public String getBackCnt() {
		return backCnt;
	}
	public void setBackCnt(String backCnt) {
		this.backCnt = backCnt;
	}
	public String getBusOrderType() {
		return busOrderType;
	}
	public void setBusOrderType(String busOrderType) {
		this.busOrderType = busOrderType;
	}
	public String getBusEntryType() {
		return busEntryType;
	}
	public void setBusEntryType(String busEntryType) {
		this.busEntryType = busEntryType;
	}
	public String getDescCode() {
		return descCode;
	}
	public void setDescCode(String descCode) {
		this.descCode = descCode;
	}
	public String getTraceNo() {
		return traceNo;
	}
	public void setTraceNo(String traceNo) {
		this.traceNo = traceNo;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getTxTime() {
		return txTime;
	}
	public void setTxTime(String txTime) {
		this.txTime = txTime;
	}
	public String getUpTime() {
		return upTime;
	}
	public void setUpTime(String upTime) {
		this.upTime = upTime;
	}
	public String getCardChn() {
		return cardChn;
	}
	public void setCardChn(String cardChn) {
		this.cardChn = cardChn;
	}

}
