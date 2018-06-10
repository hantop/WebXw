package app.creditapp.proj.entity;
import app.base.BaseDomain;
/**
* Title: ProjAcctLst.java
* Description:
* @version��1.0
**/
public class ProjAcctLst extends BaseDomain {
	private String txTime;//����ʱ��[hhmmss]
	private String txDate;//����ʱ��[YYYYMMDD]
	private String txDirect;//���׷���[01-��02-��]
	private Double txAmt;//���׽��
	private String txAcctName;//�����˻�����
	private String txOpnBkno;//���׿������к�
	private String txOpnBank;//�����˻���������
	private String txAcctNo;//�����˻��˺�
	private String lstId;//��ˮ��[����]
	private String acctId;//�˻�ID[���]

	/**
	 * @return ����ʱ��[hhmmss]
	 */
	public String getTxTime() {
	 	return txTime;
	}
	/**
	 * @���� ����ʱ��[hhmmss]
	 * @param txTime
	 */
	public void setTxTime(String txTime) {
	 	this.txTime = txTime;
	}
	/**
	 * @return ����ʱ��[YYYYMMDD]
	 */
	public String getTxDate() {
	 	return txDate;
	}
	/**
	 * @���� ����ʱ��[YYYYMMDD]
	 * @param txDate
	 */
	public void setTxDate(String txDate) {
	 	this.txDate = txDate;
	}
	/**
	 * @return ���׷���[01-��02-��]
	 */
	public String getTxDirect() {
	 	return txDirect;
	}
	/**
	 * @���� ���׷���[01-��02-��]
	 * @param txDirect
	 */
	public void setTxDirect(String txDirect) {
	 	this.txDirect = txDirect;
	}
	/**
	 * @return ���׽��
	 */
	public Double getTxAmt() {
	 	return txAmt;
	}
	/**
	 * @���� ���׽��
	 * @param txAmt
	 */
	public void setTxAmt(Double txAmt) {
	 	this.txAmt = txAmt;
	}
	/**
	 * @return �����˻�����
	 */
	public String getTxAcctName() {
	 	return txAcctName;
	}
	/**
	 * @���� �����˻�����
	 * @param txAcctName
	 */
	public void setTxAcctName(String txAcctName) {
	 	this.txAcctName = txAcctName;
	}
	/**
	 * @return ���׿������к�
	 */
	public String getTxOpnBkno() {
	 	return txOpnBkno;
	}
	/**
	 * @���� ���׿������к�
	 * @param txOpnBkno
	 */
	public void setTxOpnBkno(String txOpnBkno) {
	 	this.txOpnBkno = txOpnBkno;
	}
	/**
	 * @return �����˻���������
	 */
	public String getTxOpnBank() {
	 	return txOpnBank;
	}
	/**
	 * @���� �����˻���������
	 * @param txOpnBank
	 */
	public void setTxOpnBank(String txOpnBank) {
	 	this.txOpnBank = txOpnBank;
	}
	/**
	 * @return �����˻��˺�
	 */
	public String getTxAcctNo() {
	 	return txAcctNo;
	}
	/**
	 * @���� �����˻��˺�
	 * @param txAcctNo
	 */
	public void setTxAcctNo(String txAcctNo) {
	 	this.txAcctNo = txAcctNo;
	}
	/**
	 * @return ��ˮ��[����]
	 */
	public String getLstId() {
	 	return lstId;
	}
	/**
	 * @���� ��ˮ��[����]
	 * @param lstId
	 */
	public void setLstId(String lstId) {
	 	this.lstId = lstId;
	}
	/**
	 * @return �˻�ID[���]
	 */
	public String getAcctId() {
	 	return acctId;
	}
	/**
	 * @���� �˻�ID[���]
	 * @param acctId
	 */
	public void setAcctId(String acctId) {
	 	this.acctId = acctId;
	}
}