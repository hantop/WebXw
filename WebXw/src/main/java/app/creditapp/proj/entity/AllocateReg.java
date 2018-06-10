package app.creditapp.proj.entity;
import app.base.BaseDomain;
/**
* Title: AllocateReg.java
* Description:
* @version��1.0
**/
public class AllocateReg extends BaseDomain {
	private String allocateRegId;//Ԥ����Ǽ�ID
	private String projNo;//��Ŀ���
	private String acctId;//�˺�ID
	private String acctNo;//�˺�
	private String fAcctNo;//ת���˺�
	private Double txAmt;//������
	private String txDate;//��������ʱ��
	private String opNo;//������Ա
	private String filler;//��ע

	/**
	 * @return Ԥ����Ǽ�ID
	 */
	public String getAllocateRegId() {
	 	return allocateRegId;
	}
	/**
	 * @���� Ԥ����Ǽ�ID
	 * @param allocateRegId
	 */
	public void setAllocateRegId(String allocateRegId) {
	 	this.allocateRegId = allocateRegId;
	}
	/**
	 * @return ��Ŀ���
	 */
	public String getProjNo() {
	 	return projNo;
	}
	/**
	 * @���� ��Ŀ���
	 * @param projNo
	 */
	public void setProjNo(String projNo) {
	 	this.projNo = projNo;
	}
	/**
	 * @return �˺�ID
	 */
	public String getAcctId() {
	 	return acctId;
	}
	/**
	 * @���� �˺�ID
	 * @param acctId
	 */
	public void setAcctId(String acctId) {
	 	this.acctId = acctId;
	}
	/**
	 * @return �˺�
	 */
	public String getAcctNo() {
	 	return acctNo;
	}
	/**
	 * @���� �˺�
	 * @param acctNo
	 */
	public void setAcctNo(String acctNo) {
	 	this.acctNo = acctNo;
	}
	/**
	 * @return ת���˺�
	 */
	public String getFAcctNo() {
	 	return fAcctNo;
	}
	/**
	 * @���� ת���˺�
	 * @param fAcctNo
	 */
	public void setFAcctNo(String fAcctNo) {
	 	this.fAcctNo = fAcctNo;
	}
	/**
	 * @return ������
	 */
	public Double getTxAmt() {
	 	return txAmt;
	}
	/**
	 * @���� ������
	 * @param txAmt
	 */
	public void setTxAmt(Double txAmt) {
	 	this.txAmt = txAmt;
	}
	/**
	 * @return ��������ʱ��
	 */
	public String getTxDate() {
	 	return txDate;
	}
	/**
	 * @���� ��������ʱ��
	 * @param txDate
	 */
	public void setTxDate(String txDate) {
	 	this.txDate = txDate;
	}
	/**
	 * @return ������Ա
	 */
	public String getOpNo() {
	 	return opNo;
	}
	/**
	 * @���� ������Ա
	 * @param opNo
	 */
	public void setOpNo(String opNo) {
	 	this.opNo = opNo;
	}
	/**
	 * @return ��ע
	 */
	public String getFiller() {
	 	return filler;
	}
	/**
	 * @���� ��ע
	 * @param filler
	 */
	public void setFiller(String filler) {
	 	this.filler = filler;
	}
}