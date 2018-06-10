package accounting.domain.biz;
import app.base.BaseDomain;
/**
* Title: AccReplanParm.java
* Description:
* @���� su
* @���� 2018-4-25
* @version��1.0
**/
public class AcReplanParm extends accounting.domain.sys.CMISDomain {
	private String replanId;//�������
	private String replanName;//��������
	private String termType;//��������
	private Integer frequency;//����Ƶ��
	private String extendNext;//���ڲ�������
	private Integer secNo;//�ֶ���
	private String opNo;//����Ա
	private String brNo;//������
	private String upDate;//����ʱ��
	private String replanSts;//����״̬
	private String ifLoanInt;//�Ƿ�ſ��տ�Ϣ
	private String intType;//����������
	private Integer intUnit;//��������λ����
	private String holidIfExt;//�ڼ����Ƿ�˳��

	public String getReplanSts() {
		return replanSts;
	}
	public void setReplanSts(String replanSts) {
		this.replanSts = replanSts;
	}
	/**
	 * @return �������
	 */
	public String getReplanId() {
	 	return replanId;
	}
	/**
	 * @���� �������
	 * @param replanId
	 */
	public void setReplanId(String replanId) {
	 	this.replanId = replanId;
	}
	/**
	 * @return ��������
	 */
	public String getReplanName() {
	 	return replanName;
	}
	/**
	 * @���� ��������
	 * @param replanName
	 */
	public void setReplanName(String replanName) {
	 	this.replanName = replanName;
	}
	/**
	 * @return ��������
	 */
	public String getTermType() {
	 	return termType;
	}
	/**
	 * @���� ��������
	 * @param termType
	 */
	public void setTermType(String termType) {
	 	this.termType = termType;
	}
	/**
	 * @return ����Ƶ��
	 */
	public Integer getFrequency() {
	 	return frequency;
	}
	/**
	 * @���� ����Ƶ��
	 * @param frequency
	 */
	public void setFrequency(Integer frequency) {
	 	this.frequency = frequency;
	}
	/**
	 * @return ���ڲ�������
	 */
	public String getExtendNext() {
	 	return extendNext;
	}
	/**
	 * @���� ���ڲ�������
	 * @param extendNext
	 */
	public void setExtendNext(String extendNext) {
	 	this.extendNext = extendNext;
	}
	/**
	 * @return �ֶ���
	 */
	public Integer getSecNo() {
	 	return secNo;
	}
	/**
	 * @���� �ֶ���
	 * @param secNo
	 */
	public void setSecNo(Integer secNo) {
	 	this.secNo = secNo;
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
	 * @return ����ʱ��
	 */
	public String getUpDate() {
	 	return upDate;
	}
	/**
	 * @���� ����ʱ��
	 * @param upDate
	 */
	public void setUpDate(String upDate) {
	 	this.upDate = upDate;
	}
	public String getIfLoanInt() {
		return ifLoanInt;
	}
	public void setIfLoanInt(String ifLoanInt) {
		this.ifLoanInt = ifLoanInt;
	}
	public String getIntType() {
		return intType;
	}
	public void setIntType(String intType) {
		this.intType = intType;
	}
	public Integer getIntUnit() {
		return intUnit;
	}
	public void setIntUnit(Integer intUnit) {
		this.intUnit = intUnit;
	}
	public String getHolidIfExt() {
		return holidIfExt;
	}
	public void setHolidIfExt(String holidIfExt) {
		this.holidIfExt = holidIfExt;
	}
}