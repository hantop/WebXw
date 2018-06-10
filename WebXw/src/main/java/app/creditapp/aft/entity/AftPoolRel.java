package app.creditapp.aft.entity;
import app.base.BaseDomain;
/**
* Title: AftPoolRel.java
* Description:
* @version��1.0
**/
public class AftPoolRel extends BaseDomain {
	private String poolId;//�ʲ��ر��
	private String pactId;//��ͬID
	private String pactNo;//��ͬ��
	private String brNo;//�����������
	private String cifNo;//�ͻ���
	private String cifName;//�ͻ�����
	private Double dueAmt;//��ݽ��
	private Double bal;//������
	private Double intst;//Ӧ��ǷϢ
	private String begDate;//��ʼ����
	private String endDate;//��������
	private String fiveSts;//�弶����
	private String poolDate;//�������
	private String poolSts;//���״̬
	private String opNo;//����Ա
	private String txDate;//�Ǽ�����
	private String upDate;//��������
	
	//����
	private String brName;//������������
	private String fundNo;//�ʽ���
	/**
	 * @return �ʲ��ر��
	 */
	public String getPoolId() {
	 	return poolId;
	}
	/**
	 * @���� �ʲ��ر��
	 * @param poolId
	 */
	public void setPoolId(String poolId) {
	 	this.poolId = poolId;
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
	 * @return ��ݽ��
	 */
	public Double getDueAmt() {
	 	return dueAmt;
	}
	/**
	 * @���� ��ݽ��
	 * @param dueAmt
	 */
	public void setDueAmt(Double dueAmt) {
	 	this.dueAmt = dueAmt;
	}
	/**
	 * @return ������
	 */
	public Double getBal() {
	 	return bal;
	}
	/**
	 * @���� ������
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
	 * @return ��ʼ����
	 */
	public String getBegDate() {
	 	return begDate;
	}
	/**
	 * @���� ��ʼ����
	 * @param begDate
	 */
	public void setBegDate(String begDate) {
	 	this.begDate = begDate;
	}
	/**
	 * @return ��������
	 */
	public String getEndDate() {
	 	return endDate;
	}
	/**
	 * @���� ��������
	 * @param endDate
	 */
	public void setEndDate(String endDate) {
	 	this.endDate = endDate;
	}
	/**
	 * @return �弶����
	 */
	public String getFiveSts() {
	 	return fiveSts;
	}
	/**
	 * @���� �弶����
	 * @param fiveSts
	 */
	public void setFiveSts(String fiveSts) {
	 	this.fiveSts = fiveSts;
	}
	/**
	 * @return �������
	 */
	public String getPoolDate() {
	 	return poolDate;
	}
	/**
	 * @���� �������
	 * @param poolDate
	 */
	public void setPoolDate(String poolDate) {
	 	this.poolDate = poolDate;
	}
	/**
	 * @return ���״̬
	 */
	public String getPoolSts() {
	 	return poolSts;
	}
	/**
	 * @���� ���״̬
	 * @param poolSts
	 */
	public void setPoolSts(String poolSts) {
	 	this.poolSts = poolSts;
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
	public String getPactId() {
		return pactId;
	}
	public void setPactId(String pactId) {
		this.pactId = pactId;
	}
	public void setBrName(String brName) {
		this.brName = brName;
	}
	public String getBrName() {
		return brName;
	}
	public void setFundNo(String fundNo) {
		this.fundNo = fundNo;
	}
	public String getFundNo() {
		return fundNo;
	}
}