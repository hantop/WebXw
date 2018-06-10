package app.creditapp.aft.entity;
import app.base.BaseDomain;
/**
* Title: AftRepyClear.java
* Description:
* @version��1.0
**/
public class AftRepyClear extends BaseDomain {
	private String pactNo;//��ͬ��
	private String brNo;//������
	private String clearId;//��ǰ�������id
	private String wsId;//����ID
	private int perdNo;//�ڴκ�
	private String payDt;//Ӧ��������
	private String clearSts;//����״̬[01-������,02-����ɹ�,03-����ʧ��]
	private String dealDesc;//�������
	private String txDate;//�Ǽ�����
	private String upDate;//��������

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
	 * @return ������
	 */
	public String getBrNo() {
	 	return brNo;
	}
	/**
	 * @���� ������
	 * @param brNo
	 */
	public void setBrNo(String brNo) {
	 	this.brNo = brNo;
	}
	/**
	 * @return ��ǰ�������id
	 */
	public String getClearId() {
	 	return clearId;
	}
	/**
	 * @���� ��ǰ�������id
	 * @param clearId
	 */
	public void setClearId(String clearId) {
	 	this.clearId = clearId;
	}
	/**
	 * @return ����ID
	 */
	public String getWsId() {
	 	return wsId;
	}
	/**
	 * @���� ����ID
	 * @param wsId
	 */
	public void setWsId(String wsId) {
	 	this.wsId = wsId;
	}
	/**
	 * @return �ڴκ�
	 */
	public int getPerdNo() {
	 	return perdNo;
	}
	/**
	 * @���� �ڴκ�
	 * @param perdNo
	 */
	public void setPerdNo(int perdNo) {
	 	this.perdNo = perdNo;
	}
	/**
	 * @return ����״̬[01-������,02-����ɹ�,03-����ʧ��]
	 */
	public String getClearSts() {
	 	return clearSts;
	}
	/**
	 * @���� ����״̬[01-������,02-����ɹ�,03-����ʧ��]
	 * @param clearSts
	 */
	public void setClearSts(String clearSts) {
	 	this.clearSts = clearSts;
	}
	/**
	 * @return �������
	 */
	public String getDealDesc() {
	 	return dealDesc;
	}
	/**
	 * @���� �������
	 * @param dealDesc
	 */
	public void setDealDesc(String dealDesc) {
	 	this.dealDesc = dealDesc;
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
	public String getPayDt() {
		return payDt;
	}
	public void setPayDt(String payDt) {
		this.payDt = payDt;
	}
}