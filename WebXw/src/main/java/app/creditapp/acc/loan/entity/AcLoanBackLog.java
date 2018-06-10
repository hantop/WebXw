package app.creditapp.acc.loan.entity;
import app.base.BaseDomain;
/**
* Title: AcLoanBackLog.java
* Description:
* @version��1.0
**/
public class AcLoanBackLog extends BaseDomain {
	
	private String backLogNo;//�ſ�/�ۿ����ˮ��
	private String backCnt;//���
	private String loanLogNo;//�ſ�/�ۿ���ˮ��
	private String backType;//��������[01-�ſ02-�ۿ�,03-δ��]
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
	/**
	 * @return �ſ����ˮ��
	 */
	public String getBackLogNo() {
	 	return backLogNo;
	}
	/**
	 * @���� �ſ����ˮ��
	 * @param backLogNo
	 */
	public void setBackLogNo(String backLogNo) {
	 	this.backLogNo = backLogNo;
	}
	/**
	 * @return �ſ���ˮ��
	 */
	public String getLoanLogNo() {
	 	return loanLogNo;
	}
	/**
	 * @���� �ſ���ˮ��
	 * @param loanLogNo
	 */
	public void setLoanLogNo(String loanLogNo) {
	 	this.loanLogNo = loanLogNo;
	}
	/**
	 * @return �ſ���[01-�ɹ�,02-ʧ��]
	 */
	public String getBackRes() {
	 	return backRes;
	}
	/**
	 * @���� �ſ���[01-�ɹ�,02-ʧ��,03-δ��]
	 * @param backRes
	 */
	public void setBackRes(String backRes) {
	 	this.backRes = backRes;
	}
	/**
	 * @return ����ʱ��
	 */
	public String getBackDate() {
	 	return backDate;
	}
	/**
	 * @���� ����ʱ��
	 * @param backDate
	 */
	public void setBackDate(String backDate) {
	 	this.backDate = backDate;
	}
	/**
	 * @return ����״̬[01-������,02-�Ѵ���]
	 */
	public String getBackSts() {
	 	return backSts;
	}
	/**
	 * @���� ����״̬[01-������,02-�Ѵ���]
	 * @param backSts
	 */
	public void setBackSts(String backSts) {
	 	this.backSts = backSts;
	}
	public String getFailCaus() {
		return failCaus;
	}
	public void setFailCaus(String failCaus) {
		this.failCaus = failCaus;
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