package accounting.domain.loan;
import app.base.BaseDomain;
/**
* Title: AcFeeParm.java
* Description:
* @���� su
* @���� 2018-3-20
* @version��1.0
**/
public class AcFeeParm extends accounting.domain.sys.CMISDomain {
	private String feeParmId;//���ñ��
	private String feeParmName;//��������
	private String feeKind;//��������
	private String feeScenes;//���ó���
	private Double feeMax;//�������ֵ
	private Double feeMin;//������Сֵ
	private String feeFormId;//���ù�ʽ���
	private String feeSts;//����״̬
	private String opNo;//�Ǽ���
	private String txDate;//�Ǽ�����
	private String upDate;//��������
	
	private String rateType;//������; 01 ����� 02 ���� 
	private String acquRate;//���ʻ�ȡ��ʽ:1���� 2���ʹ�ʽ����

	/**
	 * @return ���ñ��
	 */
	public String getFeeParmId() {
	 	return feeParmId;
	}
	/**
	 * @���� ���ñ��
	 * @param feeParmId
	 */
	public void setFeeParmId(String feeParmId) {
	 	this.feeParmId = feeParmId;
	}
	/**
	 * @return ��������
	 */
	public String getFeeParmName() {
	 	return feeParmName;
	}
	/**
	 * @���� ��������
	 * @param feeParmName
	 */
	public void setFeeParmName(String feeParmName) {
	 	this.feeParmName = feeParmName;
	}
	/**
	 * @return ���ó���
	 */
	public String getFeeScenes() {
	 	return feeScenes;
	}
	/**
	 * @���� ���ó���
	 * @param feeScenes
	 */
	public void setFeeScenes(String feeScenes) {
	 	this.feeScenes = feeScenes;
	}
	/**
	 * @return �������ֵ
	 */
	public Double getFeeMax() {
	 	return feeMax;
	}
	/**
	 * @���� �������ֵ
	 * @param feeMax
	 */
	public void setFeeMax(Double feeMax) {
	 	this.feeMax = feeMax;
	}
	/**
	 * @return ������Сֵ
	 */
	public Double getFeeMin() {
	 	return feeMin;
	}
	/**
	 * @���� ������Сֵ
	 * @param feeMin
	 */
	public void setFeeMin(Double feeMin) {
	 	this.feeMin = feeMin;
	}
	/**
	 * @return ���ù�ʽ���
	 */
	public String getFeeFormId() {
	 	return feeFormId;
	}
	/**
	 * @���� ���ù�ʽ���
	 * @param feeFormId
	 */
	public void setFeeFormId(String feeFormId) {
	 	this.feeFormId = feeFormId;
	}
	/**
	 * @return ����״̬
	 */
	public String getFeeSts() {
	 	return feeSts;
	}
	/**
	 * @���� ����״̬
	 * @param feeSts
	 */
	public void setFeeSts(String feeSts) {
	 	this.feeSts = feeSts;
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
	public String getFeeKind() {
		return feeKind;
	}
	public void setFeeKind(String feeKind) {
		this.feeKind = feeKind;
	}
	public String getRateType() {
		return rateType;
	}
	public void setRateType(String rateType) {
		this.rateType = rateType;
	}
	public String getAcquRate() {
		return acquRate;
	}
	public void setAcquRate(String acquRate) {
		this.acquRate = acquRate;
	}
}