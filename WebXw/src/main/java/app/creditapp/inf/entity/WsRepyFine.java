package app.creditapp.inf.entity;
import app.base.BaseDomain;
/**
* Title: WsRepyFine.java
* Description:
* @version��1.0
**/
public class WsRepyFine extends BaseDomain {
	private String wsId;//��������ID
	private String brNo;//������
	private String pactNo;//��ͬ��
	private Integer cnt;//�ڴ�
	private Double txPayOver;//Ӧ�շ�Ϣ

	/**
	 * @return ��������ID
	 */
	public String getWsId() {
	 	return wsId;
	}
	/**
	 * @���� ��������ID
	 * @param wsId
	 */
	public void setWsId(String wsId) {
	 	this.wsId = wsId;
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
	 * @return �ڴ�
	 */
	public Integer getCnt() {
	 	return cnt;
	}
	/**
	 * @���� �ڴ�
	 * @param cnt
	 */
	public void setCnt(Integer cnt) {
	 	this.cnt = cnt;
	}
	/**
	 * @return Ӧ�շ�Ϣ
	 */
	public Double getTxPayOver() {
	 	return txPayOver;
	}
	/**
	 * @���� Ӧ�շ�Ϣ
	 * @param txPayOver
	 */
	public void setTxPayOver(Double txPayOver) {
	 	this.txPayOver = txPayOver;
	}
}