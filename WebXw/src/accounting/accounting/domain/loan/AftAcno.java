package accounting.domain.loan;
import app.base.BaseDomain;
/**
* Title: AftAcno.java
* Description:
* @���� su
* @���� 2018-3-20
* @version��1.0
**/
public class AftAcno extends accounting.domain.sys.CMISDomain {
	private String chgId;//���ID
	private String opNo;//����Ա
	private String txDate;//�Ǽ�����
	private String upDate;//��������
	private String pactId;//��ͬID
	private String pactNo;//��ͬ��
	private String brNo;//��������
	private String oldAcType;//ԭ�����˻�����
	private String oldAcNo;//ԭ�����˺�
	private String oldAcName;//ԭ�����˺Ż���
	private String oldOpnCode;//ԭ�����˺ſ�����
	private String newAcType;//�»����˻�����
	private String newAcNo;//�»����˺�
	private String newAcName;//�»����˺Ż���
	private String newOpnCode;//�»����˺ſ�����
	private String chgSts;//״̬[01������02�Ѵ���]
	private String traceNo;//����ˮ���
	private String acUse;//�˻���;[1�ۿ��˻�2�ſ��˻�]

	/**
	 * @return ���ID
	 */
	public String getChgId() {
	 	return chgId;
	}
	/**
	 * @���� ���ID
	 * @param chgId
	 */
	public void setChgId(String chgId) {
	 	this.chgId = chgId;
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
	 * @return ��ͬ��
	 */
	public String getPactNo() {
	 	return pactNo;
	}
	/**
	 * @���� ��ͬ��
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
	 * @return ԭ�����˻�����
	 */
	public String getOldAcType() {
	 	return oldAcType;
	}
	/**
	 * @���� ԭ�����˻�����
	 * @param oldAcType
	 */
	public void setOldAcType(String oldAcType) {
	 	this.oldAcType = oldAcType;
	}
	/**
	 * @return ԭ�����˺�
	 */
	public String getOldAcNo() {
	 	return oldAcNo;
	}
	/**
	 * @���� ԭ�����˺�
	 * @param oldAcNo
	 */
	public void setOldAcNo(String oldAcNo) {
	 	this.oldAcNo = oldAcNo;
	}
	/**
	 * @return ԭ�����˺Ż���
	 */
	public String getOldAcName() {
	 	return oldAcName;
	}
	/**
	 * @���� ԭ�����˺Ż���
	 * @param oldAcName
	 */
	public void setOldAcName(String oldAcName) {
	 	this.oldAcName = oldAcName;
	}
	/**
	 * @return ԭ�����˺ſ�����
	 */
	public String getOldOpnCode() {
	 	return oldOpnCode;
	}
	/**
	 * @���� ԭ�����˺ſ�����
	 * @param oldOpnCode
	 */
	public void setOldOpnCode(String oldOpnCode) {
	 	this.oldOpnCode = oldOpnCode;
	}
	/**
	 * @return �»����˻�����
	 */
	public String getNewAcType() {
	 	return newAcType;
	}
	/**
	 * @���� �»����˻�����
	 * @param newAcType
	 */
	public void setNewAcType(String newAcType) {
	 	this.newAcType = newAcType;
	}
	/**
	 * @return �»����˺�
	 */
	public String getNewAcNo() {
	 	return newAcNo;
	}
	/**
	 * @���� �»����˺�
	 * @param newAcNo
	 */
	public void setNewAcNo(String newAcNo) {
	 	this.newAcNo = newAcNo;
	}
	/**
	 * @return �»����˺Ż���
	 */
	public String getNewAcName() {
	 	return newAcName;
	}
	/**
	 * @���� �»����˺Ż���
	 * @param newAcName
	 */
	public void setNewAcName(String newAcName) {
	 	this.newAcName = newAcName;
	}
	/**
	 * @return �»����˺ſ�����
	 */
	public String getNewOpnCode() {
	 	return newOpnCode;
	}
	/**
	 * @���� �»����˺ſ�����
	 * @param newOpnCode
	 */
	public void setNewOpnCode(String newOpnCode) {
	 	this.newOpnCode = newOpnCode;
	}
	/**
	 * @return ״̬[01������02�Ѵ���]
	 */
	public String getChgSts() {
	 	return chgSts;
	}
	/**
	 * @���� ״̬[01������02�Ѵ���]
	 * @param chgSts
	 */
	public void setChgSts(String chgSts) {
	 	this.chgSts = chgSts;
	}
	public String getTraceNo() {
		return traceNo;
	}
	public void setTraceNo(String traceNo) {
		this.traceNo = traceNo;
	}
	public String getAcUse() {
		return acUse;
	}
	public void setAcUse(String acUse) {
		this.acUse = acUse;
	}
}