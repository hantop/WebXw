package accounting.domain.loan;
import app.base.BaseDomain;
/**
* Title: AcFeeRate.java
* Description:
* @���� su
* @���� 2018-3-20
* @version��1.0
**/
public class AcFeeRate extends accounting.domain.sys.CMISDomain {
	private String feeId;//���ʱ��
	private String feeName;//��������
	private Integer minMon;//��������
	private Integer maxMon;//��������
	private Double feeRate;//����
	private String frId;//���ʶ�����


	/**
	 * @return ���ʱ��
	 */
	public String getFeeId() {
	 	return feeId;
	}
	/**
	 * @���� ���ʱ��
	 * @param feeId
	 */
	public void setFeeId(String feeId) {
	 	this.feeId = feeId;
	}
	/**
	 * @return ��������
	 */
	public String getFeeName() {
	 	return feeName;
	}
	/**
	 * @���� ��������
	 * @param feeName
	 */
	public void setFeeName(String feeName) {
	 	this.feeName = feeName;
	}
	/**
	 * @return ��������
	 */
	public Integer getMinMon() {
	 	return minMon;
	}
	/**
	 * @���� ��������
	 * @param minMon
	 */
	public void setMinMon(Integer minMon) {
	 	this.minMon = minMon;
	}
	/**
	 * @return ��������
	 */
	public Integer getMaxMon() {
	 	return maxMon;
	}
	/**
	 * @���� ��������
	 * @param maxMon
	 */
	public void setMaxMon(Integer maxMon) {
	 	this.maxMon = maxMon;
	}
	/**
	 * @return ����
	 */
	public Double getFeeRate() {
	 	return feeRate;
	}
	/**
	 * @���� ����
	 * @param feeRate
	 */
	public void setFeeRate(Double feeRate) {
	 	this.feeRate = feeRate;
	}
	public String getFrId() {
		return frId;
	}
	public void setFrId(String frId) {
		this.frId = frId;
	}
}