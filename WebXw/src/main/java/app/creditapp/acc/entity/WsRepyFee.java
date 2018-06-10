package app.creditapp.acc.entity;
import app.base.BaseDomain;
/**
* Title: WsRepyFee.java
* Description:
* @version��1.0
**/
public class WsRepyFee extends BaseDomain {
	private String wsId;//��������ID
	private String brNo;//������
	private String pactNo;//��ͬ��
	private Integer cnt;//�ڴ�
	private String feeType;//��������[01����� 02����]
	private String feeKind;//��������[01 ����  02����]
	private Double feeAmt;//���ý��

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
	 * @return ��������[1���� 2�����]
	 */
	public String getFeeType() {
	 	return feeType;
	}
	/**
	 * @���� ��������[1���� 2�����]
	 * @param feeType
	 */
	public void setFeeType(String feeType) {
	 	this.feeType = feeType;
	}
	/**
	 * @return ���ý��
	 */
	public Double getFeeAmt() {
	 	return feeAmt;
	}
	/**
	 * @���� ���ý��
	 * @param feeAmt
	 */
	public void setFeeAmt(Double feeAmt) {
	 	this.feeAmt = feeAmt;
	}
	public String getFeeKind() {
		return feeKind;
	}
	public void setFeeKind(String feeKind) {
		this.feeKind = feeKind;
	}
}