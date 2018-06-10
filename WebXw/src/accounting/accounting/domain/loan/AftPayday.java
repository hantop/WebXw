package accounting.domain.loan;
import app.base.BaseDomain;
/**
* Title: AftPayday.java
* Description:
* @���� su
* @���� 2018-3-20
* @version��1.0
**/
public class AftPayday extends accounting.domain.sys.CMISDomain {
	private String chgId;//���ID
	private String pactId;//��ͬID
	private String pactNo;//��ͬ��
	private String brNo;//��������
	private String oldPayday;//ԭ�ۿ���
	private String newPayday;//�¿ۿ���
	private String chgSts;//״̬[01������02�Ѵ���]
	private String opNo;//����Ա
	private String txDate;//�Ǽ�����
	private String upDate;//��������
	private String traceNo;//��������ˮ

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
	 * @return ԭ�ۿ���
	 */
	public String getOldPayday() {
	 	return oldPayday;
	}
	/**
	 * @���� ԭ�ۿ���
	 * @param oldPayday
	 */
	public void setOldPayday(String oldPayday) {
	 	this.oldPayday = oldPayday;
	}
	/**
	 * @return �¿ۿ���
	 */
	public String getNewPayday() {
	 	return newPayday;
	}
	/**
	 * @���� �¿ۿ���
	 * @param newPayday
	 */
	public void setNewPayday(String newPayday) {
	 	this.newPayday = newPayday;
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
	public String getTraceNo() {
		return traceNo;
	}
	public void setTraceNo(String traceNo) {
		this.traceNo = traceNo;
	}
}