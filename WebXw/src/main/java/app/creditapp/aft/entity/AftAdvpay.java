package app.creditapp.aft.entity;
import app.base.BaseDomain;
/**
* Title: AftAdvpay.java
* Description:
* @version��1.0
**/
public class AftAdvpay extends BaseDomain {
	private String repId;//����ID
	private String pactId;//��ͬID
	private String pactNo;//��ͬ���
	private String brNo;//��������
	private Double pactAmt;//��ͬ���
	private Double bal;//��ͬ���
	private Double intst;//Ӧ��ǷϢ
	private Double payAmt;//������
	private String acType;//�����˻�����
	private String acNo;//�����˻���
	private String acName;//�����˻�����
	private String acBankname;//�����˻�������
	private String repReason;//��ǰ����ԭ��
	private String repType;//��������[01ȫ������02���ֻ���]
	private String repSts;//����״̬
	private String opNo;//����Ա
	private String txDate;//�Ǽ�����
	private String upDate;//��������
	private String payDate;//��������
	private String repayType;//��������[01-�������䣬�����ڹ� 02-�ڹ����䣬��������]
	private String endDate;//��������
	private String brName;//������������
	private String opName;//����Ա����
	private String traceNo;//����ˮ���
	private String onlinOff;//���� 01 ���� 02
	private String loginid;//��¼��Ա
	
	public String getLoginid() {
		return loginid;
	}
	public void setLoginid(String loginid) {
		this.loginid = loginid;
	}
	/**
	 * @return ����ID
	 */
	public String getRepId() {
	 	return repId;
	}
	/**
	 * @���� ����ID
	 * @param repId
	 */
	public void setRepId(String repId) {
	 	this.repId = repId;
	}
	/**
	 * @return ��ͬID
	 */
	public String getPactId() {
	 	return pactId;
	}
	/**
	 * @���� ��ͬID
	 * @param pactId
	 */
	public void setPactId(String pactId) {
	 	this.pactId = pactId;
	}
	/**
	 * @return ��ͬ���
	 */
	public String getPactNo() {
	 	return pactNo;
	}
	/**
	 * @���� ��ͬ���
	 * @param pactNo
	 */
	public void setPactNo(String pactNo) {
	 	this.pactNo = pactNo;
	}
	/**
	 * @return ��������
	 */
	public String getBrNo() {
	 	return brNo;
	}
	/**
	 * @���� ��������
	 * @param brNo
	 */
	public void setBrNo(String brNo) {
	 	this.brNo = brNo;
	}
	/**
	 * @return ��ͬ���
	 */
	public Double getPactAmt() {
	 	return pactAmt;
	}
	/**
	 * @���� ��ͬ���
	 * @param pactAmt
	 */
	public void setPactAmt(Double pactAmt) {
	 	this.pactAmt = pactAmt;
	}
	/**
	 * @return ��ͬ���
	 */
	public Double getBal() {
	 	return bal;
	}
	/**
	 * @���� ��ͬ���
	 * @param bal
	 */
	public void setBal(Double bal) {
	 	this.bal = bal;
	}
	/**
	 * @return Ӧ��ǷϢ
	 */
	public Double getIntst() {
	 	return intst;
	}
	/**
	 * @���� Ӧ��ǷϢ
	 * @param intst
	 */
	public void setIntst(Double intst) {
	 	this.intst = intst;
	}
	/**
	 * @return ������
	 */
	public Double getPayAmt() {
	 	return payAmt;
	}
	/**
	 * @���� ������
	 * @param payAmt
	 */
	public void setPayAmt(Double payAmt) {
	 	this.payAmt = payAmt;
	}
	/**
	 * @return �����˻�����
	 */
	public String getAcType() {
	 	return acType;
	}
	/**
	 * @���� �����˻�����
	 * @param acType
	 */
	public void setAcType(String acType) {
	 	this.acType = acType;
	}
	/**
	 * @return �����˻���
	 */
	public String getAcNo() {
	 	return acNo;
	}
	/**
	 * @���� �����˻���
	 * @param acNo
	 */
	public void setAcNo(String acNo) {
	 	this.acNo = acNo;
	}
	/**
	 * @return �����˻�����
	 */
	public String getAcName() {
	 	return acName;
	}
	/**
	 * @���� �����˻�����
	 * @param acName
	 */
	public void setAcName(String acName) {
	 	this.acName = acName;
	}
	/**
	 * @return �����˻�������
	 */
	public String getAcBankname() {
	 	return acBankname;
	}
	/**
	 * @���� �����˻�������
	 * @param acBankname
	 */
	public void setAcBankname(String acBankname) {
	 	this.acBankname = acBankname;
	}
	/**
	 * @return ��ǰ����ԭ��
	 */
	public String getRepReason() {
	 	return repReason;
	}
	/**
	 * @���� ��ǰ����ԭ��
	 * @param repReason
	 */
	public void setRepReason(String repReason) {
	 	this.repReason = repReason;
	}
	/**
	 * @return ��������[01ȫ������02���ֻ���]
	 */
	public String getRepType() {
	 	return repType;
	}
	/**
	 * @���� ��������[01ȫ������02���ֻ���]
	 * @param repType
	 */
	public void setRepType(String repType) {
	 	this.repType = repType;
	}
	/**
	 * @return ����״̬
	 */
	public String getRepSts() {
	 	return repSts;
	}
	/**
	 * @���� ����״̬
	 * @param repSts
	 */
	public void setRepSts(String repSts) {
	 	this.repSts = repSts;
	}
	/**
	 * @return ����Ա
	 */
	public String getOpNo() {
	 	return opNo;
	}
	/**
	 * @���� ����Ա
	 * @param opNo
	 */
	public void setOpNo(String opNo) {
	 	this.opNo = opNo;
	}
	/**
	 * @return �Ǽ�����
	 */
	public String getTxDate() {
	 	return txDate;
	}
	/**
	 * @���� �Ǽ�����
	 * @param txDate
	 */
	public void setTxDate(String txDate) {
	 	this.txDate = txDate;
	}
	/**
	 * @return ��������
	 */
	public String getUpDate() {
	 	return upDate;
	}
	/**
	 * @���� ��������
	 * @param upDate
	 */
	public void setUpDate(String upDate) {
	 	this.upDate = upDate;
	}
	public String getPayDate() {
		return payDate;
	}
	public void setPayDate(String payDate) {
		this.payDate = payDate;
	}
	public String getRepayType() {
		return repayType;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setRepayType(String repayType) {
		this.repayType = repayType;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getBrName() {
		return brName;
	}
	public void setBrName(String brName) {
		this.brName = brName;
	}
	public String getOpName() {
		return opName;
	}
	public void setOpName(String opName) {
		this.opName = opName;
	}
	public String getTraceNo() {
		return traceNo;
	}
	public void setTraceNo(String traceNo) {
		this.traceNo = traceNo;
	}
	public String getOnlinOff() {
		return onlinOff;
	}
	public void setOnlinOff(String onlinOff) {
		this.onlinOff = onlinOff;
	}
}