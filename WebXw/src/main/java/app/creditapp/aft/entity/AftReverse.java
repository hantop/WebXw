package app.creditapp.aft.entity;
import app.base.BaseDomain;
/**
* Title: AftReverse.java
* Description:
* @version��1.0
**/
public class AftReverse extends BaseDomain {
	private String reveId;//����ID[AFT_CHG_SEQ]
	private String traceNo;//ҵ����ˮ��
	private String txCde;//������
	private String cifNo;//�ͻ���
	private String cifName;//�ͻ�����
	private String dueNo;//��ݺ�
	private String brNo;//����������
	private String pactNo;//��ͬ���
	private Double reveAmt;//���˽��
	private String reveReason;//����ԭ��
	private String reveDate;//��������
	private String reveSts;//����״̬ 01δ�ύ 02������ 03ͨ�� 04���
	private String opNo;//����Ա���
	private String txDate;//�Ǽ�����
	private String upDate;//��������
	private String opName;//����Ա����
	private String brName;//������������

	/**
	 * @return ����ID[AFT_CHG_SEQ]
	 */
	public String getReveId() {
	 	return reveId;
	}
	/**
	 * @���� ����ID[AFT_CHG_SEQ]
	 * @param reveId
	 */
	public void setReveId(String reveId) {
	 	this.reveId = reveId;
	}
	/**
	 * @return ҵ����ˮ��
	 */
	public String getTraceNo() {
	 	return traceNo;
	}
	/**
	 * @���� ҵ����ˮ��
	 * @param traceNo
	 */
	public void setTraceNo(String traceNo) {
	 	this.traceNo = traceNo;
	}
	/**
	 * @return ������
	 */
	public String getTxCde() {
	 	return txCde;
	}
	/**
	 * @���� ������
	 * @param txCde
	 */
	public void setTxCde(String txCde) {
	 	this.txCde = txCde;
	}
	/**
	 * @return �ͻ���
	 */
	public String getCifNo() {
	 	return cifNo;
	}
	/**
	 * @���� �ͻ���
	 * @param cifNo
	 */
	public void setCifNo(String cifNo) {
	 	this.cifNo = cifNo;
	}
	/**
	 * @return �ͻ�����
	 */
	public String getCifName() {
	 	return cifName;
	}
	/**
	 * @���� �ͻ�����
	 * @param cifName
	 */
	public void setCifName(String cifName) {
	 	this.cifName = cifName;
	}
	/**
	 * @return ��ݺ�
	 */
	public String getDueNo() {
	 	return dueNo;
	}
	/**
	 * @���� ��ݺ�
	 * @param dueNo
	 */
	public void setDueNo(String dueNo) {
	 	this.dueNo = dueNo;
	}
	/**
	 * @return ����������
	 */
	public String getBrNo() {
	 	return brNo;
	}
	/**
	 * @���� ����������
	 * @param brNo
	 */
	public void setBrNo(String brNo) {
	 	this.brNo = brNo;
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
	 * @return ���˽��
	 */
	public Double getReveAmt() {
	 	return reveAmt;
	}
	/**
	 * @���� ���˽��
	 * @param reveAmt
	 */
	public void setReveAmt(Double reveAmt) {
	 	this.reveAmt = reveAmt;
	}
	/**
	 * @return ����ԭ��
	 */
	public String getReveReason() {
	 	return reveReason;
	}
	/**
	 * @���� ����ԭ��
	 * @param reveReason
	 */
	public void setReveReason(String reveReason) {
	 	this.reveReason = reveReason;
	}
	/**
	 * @return ��������
	 */
	public String getReveDate() {
	 	return reveDate;
	}
	/**
	 * @���� ��������
	 * @param reveDate
	 */
	public void setReveDate(String reveDate) {
	 	this.reveDate = reveDate;
	}
	/**
	 * @return ����״̬ 01δ�ύ 02������ 03ͨ�� 04���
	 */
	public String getReveSts() {
	 	return reveSts;
	}
	/**
	 * @���� ����״̬ 01δ�ύ 02������ 03ͨ�� 04���
	 * @param reveSts
	 */
	public void setReveSts(String reveSts) {
	 	this.reveSts = reveSts;
	}
	/**
	 * @return op_no
	 */
	public String getOpNo() {
	 	return opNo;
	}
	/**
	 * @���� op_no
	 * @param opNo
	 */
	public void setOpNo(String opNo) {
	 	this.opNo = opNo;
	}
	/**
	 * @return tx_date
	 */
	public String getTxDate() {
	 	return txDate;
	}
	/**
	 * @���� tx_date
	 * @param txDate
	 */
	public void setTxDate(String txDate) {
	 	this.txDate = txDate;
	}
	/**
	 * @return up_date
	 */
	public String getUpDate() {
	 	return upDate;
	}
	/**
	 * @���� up_date
	 * @param upDate
	 */
	public void setUpDate(String upDate) {
	 	this.upDate = upDate;
	}
	public String getOpName() {
		return opName;
	}
	public void setOpName(String opName) {
		this.opName = opName;
	}
	public String getBrName() {
		return brName;
	}
	public void setBrName(String brName) {
		this.brName = brName;
	}
}