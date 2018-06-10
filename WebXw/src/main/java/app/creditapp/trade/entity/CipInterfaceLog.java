package app.creditapp.trade.entity;
import app.base.BaseDomain;
/**
* Title: CipInterfaceLog.java
* Description:
* @version��1.0
**/
public class CipInterfaceLog extends BaseDomain {
	private String serial_no;
	private String trade_id; 
	private String send_xml; 
	private String receive_xml; 
	private String br_no; 
	private String op_no; 
	private String log_date; 
	private String error_msg;
	private String request_no;//��������ʶ���
	private String relative_no;// ҵ�������(������ˮ)
	private String trade_no;//������ 
	/*
	 * ���Ŵ���ֲ�����ֶ�
	 */
	private String key ; // ��
	private String value ; // ֵ
	private String tlrName ; // ����Ա��
	private String brNo ; // ������
	private String idnum ; // ���֤�ŶԹ��ͻ�ȡ�ͻ��ţ�xd2001��
	private String cifNo ; // �ͻ���
	private String cifName ; // ��֤�� �ͻ�����
	private String balance ; // ��֤�����
	private String lnAcNo ;
	private String lnAcName ;
	private String ratNo ;
	private String rtFlag ;
	private String obrNo ;
	private double rate ;
	private String actNo ;//������ڴ���˺�
	private String actName ;//���п�����
	private String actStatus ;//�˻�״̬
	private String cardStatus ;//���п�״̬
	private String cardType ;//���п�����
	public String getSerial_no() {
		return serial_no;
	}
	public void setSerial_no(String serial_no) {
		this.serial_no = serial_no;
	}
	public String getTrade_id() {
		return trade_id;
	}
	public void setTrade_id(String trade_id) {
		this.trade_id = trade_id;
	}
	public String getSend_xml() {
		return send_xml;
	}
	public void setSend_xml(String send_xml) {
		this.send_xml = send_xml;
	}
	public String getReceive_xml() {
		return receive_xml;
	}
	public void setReceive_xml(String receive_xml) {
		this.receive_xml = receive_xml;
	}
	public String getBr_no() {
		return br_no;
	}
	public void setBr_no(String br_no) {
		this.br_no = br_no;
	}
	public String getOp_no() {
		return op_no;
	}
	public void setOp_no(String op_no) {
		this.op_no = op_no;
	}
	public String getLog_date() {
		return log_date;
	}
	public void setLog_date(String log_date) {
		this.log_date = log_date;
	}
	public String getError_msg() {
		return error_msg;
	}
	public void setError_msg(String error_msg) {
		this.error_msg = error_msg;
	}
	public String getRequest_no() {
		return request_no;
	}
	public void setRequest_no(String requestNo) {
		request_no = requestNo;
	}
	public String getRelative_no() {
		return relative_no;
	}
	public void setRelative_no(String relativeNo) {
		relative_no = relativeNo;
	}
	public String getTrade_no() {
		return trade_no;
	}
	public void setTrade_no(String tradeNo) {
		trade_no = tradeNo;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getTlrName() {
		return tlrName;
	}
	public void setTlrName(String tlrName) {
		this.tlrName = tlrName;
	}
	public String getBrNo() {
		return brNo;
	}
	public void setBrNo(String brNo) {
		this.brNo = brNo;
	}
	public String getIdnum() {
		return idnum;
	}
	public void setIdnum(String idnum) {
		this.idnum = idnum;
	}
	public String getCifNo() {
		return cifNo;
	}
	public void setCifNo(String cifNo) {
		this.cifNo = cifNo;
	}
	public String getCifName() {
		return cifName;
	}
	public void setCifName(String cifName) {
		this.cifName = cifName;
	}
	public String getBalance() {
		return balance;
	}
	public void setBalance(String balance) {
		this.balance = balance;
	}
	public String getLnAcNo() {
		return lnAcNo;
	}
	public void setLnAcNo(String lnAcNo) {
		this.lnAcNo = lnAcNo;
	}
	public String getLnAcName() {
		return lnAcName;
	}
	public void setLnAcName(String lnAcName) {
		this.lnAcName = lnAcName;
	}
	public String getRatNo() {
		return ratNo;
	}
	public void setRatNo(String ratNo) {
		this.ratNo = ratNo;
	}
	public String getRtFlag() {
		return rtFlag;
	}
	public void setRtFlag(String rtFlag) {
		this.rtFlag = rtFlag;
	}
	public String getObrNo() {
		return obrNo;
	}
	public void setObrNo(String obrNo) {
		this.obrNo = obrNo;
	}
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	public String getActNo() {
		return actNo;
	}
	public void setActNo(String actNo) {
		this.actNo = actNo;
	}
	public String getActName() {
		return actName;
	}
	public void setActName(String actName) {
		this.actName = actName;
	}
	public String getActStatus() {
		return actStatus;
	}
	public void setActStatus(String actStatus) {
		this.actStatus = actStatus;
	}
	public String getCardStatus() {
		return cardStatus;
	}
	public void setCardStatus(String cardStatus) {
		this.cardStatus = cardStatus;
	}
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	} 
	
}