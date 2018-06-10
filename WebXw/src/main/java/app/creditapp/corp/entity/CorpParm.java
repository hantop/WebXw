package app.creditapp.corp.entity;
import app.base.BaseDomain;
/**
* Title: CorpParm.java
* Description:
* @version��1.0
**/
public class CorpParm extends BaseDomain {
	private String accType;//���㷽ʽ[A���к���B��������]
	private String parmId;//���ò���ID
	private String brName;//������������
	private String brNo;//�����������
	private String putType;//�ſ�ģʽ[01�Զ� 02��ʱ]
	private String rpyDay;//�ۿ�������[01�̶��ۿ�02�ſ��տۿ�]
	private String rpyScheme;//�ڼ��տۿ��[01�� 02Ĭ�� 03�Զ���]
	private Integer graceDay;//���ڿ����ڣ��죩
	private Double tolAmt;//�����ݴ���
	private String ftpPath;//�ǻ������洢FTP·��
	private String upOpno;//�޸���Ա
	private String upOpname;//�޸���Ա����
	private String upDate;//�޸�����
	private String txDate;//�Ǽ�����
	private String opNo;//����Ա
	private String opName;//����Ա����
	private String deptNo;//�Ǽǲ���
	private String filler;//��ע
	private String putTime;//��ʱ�ſ�ʱ��
	private String monthDays;//����������
	private String payOrder;//�ۿ�˳��
	//����ֶ�
	private String ifRelchk;//�����Ƿ����Ԥ����У��
	private String commMail;//��ϵ������[�����ʼ�֪ͨ]
	private String taName;//��ͨ�ͻ�����
	private String corpSign;//������־
	private String rebuySign;//�ع���־

	public String getCommMail() {
		return commMail;
	}
	public void setCommMail(String commMail) {
		this.commMail = commMail;
	}
	public String getPutTime() {
		return putTime;
	}
	public void setPutTime(String putTime) {
		this.putTime = putTime;
	}
	public String getMonthDays() {
		return monthDays;
	}
	public void setMonthDays(String monthDays) {
		this.monthDays = monthDays;
	}
	public String getPayOrder() {
		return payOrder;
	}
	public void setPayOrder(String payOrder) {
		this.payOrder = payOrder;
	}
	public String getUpOpno() {
		return upOpno;
	}
	public void setUpOpno(String upOpno) {
		this.upOpno = upOpno;
	}
	public String getUpDate() {
		return upDate;
	}
	public void setUpDate(String upDate) {
		this.upDate = upDate;
	}
	public String getTxDate() {
		return txDate;
	}
	public void setTxDate(String txDate) {
		this.txDate = txDate;
	}
	public String getOpNo() {
		return opNo;
	}
	public void setOpNo(String opNo) {
		this.opNo = opNo;
	}
	public String getDeptNo() {
		return deptNo;
	}
	public void setDeptNo(String deptNo) {
		this.deptNo = deptNo;
	}
	public String getFiller() {
		return filler;
	}
	public void setFiller(String filler) {
		this.filler = filler;
	}
	/**
	 * @return ���㷽ʽ[A���к���B��������]
	 */
	public String getAccType() {
	 	return accType;
	}
	/**
	 * @���� ���㷽ʽ[A���к���B��������]
	 * @param accType
	 */
	public void setAccType(String accType) {
	 	this.accType = accType;
	}
	/**
	 * @return ���ò���ID
	 */
	public String getParmId() {
	 	return parmId;
	}
	/**
	 * @���� ���ò���ID
	 * @param parmId
	 */
	public void setParmId(String parmId) {
	 	this.parmId = parmId;
	}
	/**
	 * @return ������������
	 */
	public String getBrName() {
	 	return brName;
	}
	/**
	 * @���� ������������
	 * @param brName
	 */
	public void setBrName(String brName) {
	 	this.brName = brName;
	}
	/**
	 * @return �����������
	 */
	public String getBrNo() {
	 	return brNo;
	}
	/**
	 * @���� �����������
	 * @param brNo
	 */
	public void setBrNo(String brNo) {
	 	this.brNo = brNo;
	}
	/**
	 * @return �ſ�ģʽ[01�Զ� 02��ʱ]
	 */
	public String getPutType() {
	 	return putType;
	}
	/**
	 * @���� �ſ�ģʽ[01�Զ� 02��ʱ]
	 * @param putType
	 */
	public void setPutType(String putType) {
	 	this.putType = putType;
	}
	/**
	 * @return �ۿ�������[01�̶��ۿ�02�ſ��տۿ�]
	 */
	public String getRpyDay() {
	 	return rpyDay;
	}
	/**
	 * @���� �ۿ�������[01�̶��ۿ�02�ſ��տۿ�]
	 * @param rpyDay
	 */
	public void setRpyDay(String rpyDay) {
	 	this.rpyDay = rpyDay;
	}
	/**
	 * @return �ڼ��տۿ��[01�� 02Ĭ�� 03�Զ���]
	 */
	public String getRpyScheme() {
	 	return rpyScheme;
	}
	/**
	 * @���� �ڼ��տۿ��[01�� 02Ĭ�� 03�Զ���]
	 * @param rpyScheme
	 */
	public void setRpyScheme(String rpyScheme) {
	 	this.rpyScheme = rpyScheme;
	}
	/**
	 * @return ���ڿ����ڣ��죩
	 */
	public Integer getGraceDay() {
	 	return graceDay;
	}
	/**
	 * @���� ���ڿ����ڣ��죩
	 * @param graceDay
	 */
	public void setGraceDay(Integer graceDay) {
	 	this.graceDay = graceDay;
	}
	/**
	 * @return �����ݴ���
	 */
	public Double getTolAmt() {
	 	return tolAmt;
	}
	/**
	 * @���� �����ݴ���
	 * @param tolAmt
	 */
	public void setTolAmt(Double tolAmt) {
	 	this.tolAmt = tolAmt;
	}
	/**
	 * @return �ǻ������洢FTP·��
	 */
	public String getFtpPath() {
	 	return ftpPath;
	}
	/**
	 * @���� �ǻ������洢FTP·��
	 * @param ftpPath
	 */
	public void setFtpPath(String ftpPath) {
	 	this.ftpPath = ftpPath;
	}
	public String getIfRelchk() {
		return ifRelchk;
	}
	public void setIfRelchk(String ifRelchk) {
		this.ifRelchk = ifRelchk;
	}
	public String getUpOpname() {
		return upOpname;
	}
	public void setUpOpname(String upOpname) {
		this.upOpname = upOpname;
	}
	public String getOpName() {
		return opName;
	}
	public void setOpName(String opName) {
		this.opName = opName;
	}
	public String getTaName() {
		return taName;
	}
	public void setTaName(String taName) {
		this.taName = taName;
	}
	public String getCorpSign() {
		return corpSign;
	}
	public void setCorpSign(String corpSign) {
		this.corpSign = corpSign;
	}
	public String getRebuySign() {
		return rebuySign;
	}
	public void setRebuySign(String rebuySign) {
		this.rebuySign = rebuySign;
	}
	
	
}