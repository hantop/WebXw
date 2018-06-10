package app.creditapp.aft.entity;
import app.base.BaseDomain;
/**
* Title: AftAssetPool.java
* Description:
* @version��1.0
**/
public class AftAssetPool extends BaseDomain {
	private String poolId;//�ʲ��ر��
	private String poolName;//�ʲ�������
	private String poolDesc;//�ʲ��ظſ�
	private Integer poolCnt;//����������
	private Double poolAmt;//�ʲ����ܶ�
	private Double totalAmt;//�����ܶ�
	private String begDate;//��Ч����
	private String endDate;//��������
	private String poolSts;//�ʲ���״̬[01-δ���02-�����]
	private String opNo;//�Ǽ���
	private String txDate;//�Ǽ�����
	private String upDate;//��������
	private String loginid;//��¼��Ա
	
	public String getLoginid() {
		return loginid;
	}
	public void setLoginid(String loginid) {
		this.loginid = loginid;
	}
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
	 * @return �ʲ�������
	 */
	public String getPoolName() {
	 	return poolName;
	}
	/**
	 * @���� �ʲ�������
	 * @param poolName
	 */
	public void setPoolName(String poolName) {
	 	this.poolName = poolName;
	}
	/**
	 * @return �ʲ��ظſ�
	 */
	public String getPoolDesc() {
	 	return poolDesc;
	}
	/**
	 * @���� �ʲ��ظſ�
	 * @param poolDesc
	 */
	public void setPoolDesc(String poolDesc) {
	 	this.poolDesc = poolDesc;
	}
	/**
	 * @return ����������
	 */
	public Integer getPoolCnt() {
	 	return poolCnt;
	}
	/**
	 * @���� ����������
	 * @param poolCnt
	 */
	public void setPoolCnt(Integer poolCnt) {
	 	this.poolCnt = poolCnt;
	}
	/**
	 * @return �ʲ����ܶ�
	 */
	public Double getPoolAmt() {
	 	return poolAmt;
	}
	/**
	 * @���� �ʲ����ܶ�
	 * @param poolAmt
	 */
	public void setPoolAmt(Double poolAmt) {
	 	this.poolAmt = poolAmt;
	}
	/**
	 * @return �����ܶ�
	 */
	public Double getTotalAmt() {
	 	return totalAmt;
	}
	/**
	 * @���� �����ܶ�
	 * @param totalAmt
	 */
	public void setTotalAmt(Double totalAmt) {
	 	this.totalAmt = totalAmt;
	}
	/**
	 * @return ��Ч����
	 */
	public String getBegDate() {
	 	return begDate;
	}
	/**
	 * @���� ��Ч����
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
	 * @return �ʲ���״̬[01-δ���02-�����]
	 */
	public String getPoolSts() {
	 	return poolSts;
	}
	/**
	 * @���� �ʲ���״̬[01-δ���02-�����]
	 * @param poolSts
	 */
	public void setPoolSts(String poolSts) {
	 	this.poolSts = poolSts;
	}
	/**
	 * @return �Ǽ���
	 */
	public String getOpNo() {
	 	return opNo;
	}
	/**
	 * @���� �Ǽ���
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
}