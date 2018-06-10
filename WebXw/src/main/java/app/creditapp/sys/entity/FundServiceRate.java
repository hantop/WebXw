package app.creditapp.sys.entity;
import app.base.BaseDomain;
/**
* Title: FundServiceRate.java
* Description:
* @version��1.0
**/
public class FundServiceRate extends BaseDomain {
	private String serviceRateId;//id
	private String projNo;//��Ŀ���
	private String projName;//��Ŀ����
	private String stepNo;//���ݱ��
	private Double minAmt;//���ݷŴ���ģ����
	private Double maxAmt;//���ݷŴ���ģ����
	private Float svRate;//�������
	private String opNo;//�Ǽ���Ա
	private String opName;//�Ǽ���Ա����
	private String txDate;//�Ǽ�����
	private String filler;//��ע

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
	 * @return ��Ŀ����
	 */
	public String getProjName() {
	 	return projName;
	}
	/**
	 * @���� ��Ŀ����
	 * @param projName
	 */
	public void setProjName(String projName) {
	 	this.projName = projName;
	}
	/**
	 * @return ���ݱ��
	 */
	public String getStepNo() {
	 	return stepNo;
	}
	/**
	 * @���� ���ݱ��
	 * @param stepNo
	 */
	public void setStepNo(String stepNo) {
	 	this.stepNo = stepNo;
	}
	/**
	 * @return ���ݷŴ���ģ����
	 */
	public Double getMinAmt() {
	 	return minAmt;
	}
	/**
	 * @���� ���ݷŴ���ģ����
	 * @param minAmt
	 */
	public void setMinAmt(Double minAmt) {
	 	this.minAmt = minAmt;
	}
	/**
	 * @return ���ݷŴ���ģ����
	 */
	public Double getMaxAmt() {
	 	return maxAmt;
	}
	/**
	 * @���� ���ݷŴ���ģ����
	 * @param maxAmt
	 */
	public void setMaxAmt(Double maxAmt) {
	 	this.maxAmt = maxAmt;
	}
	/**
	 * @return �������
	 */
	public Float getSvRate() {
	 	return svRate;
	}
	/**
	 * @���� �������
	 * @param svRate
	 */
	public void setSvRate(Float svRate) {
	 	this.svRate = svRate;
	}
	/**
	 * @return �Ǽ���Ա
	 */
	public String getOpNo() {
	 	return opNo;
	}
	/**
	 * @���� �Ǽ���Ա
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
	public String getOpName() {
		return opName;
	}
	public void setOpName(String opName) {
		this.opName = opName;
	}
	public String getServiceRateId() {
		return serviceRateId;
	}
	public void setServiceRateId(String serviceRateId) {
		this.serviceRateId = serviceRateId;
	}
}