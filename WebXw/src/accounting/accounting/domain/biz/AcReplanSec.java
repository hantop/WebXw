package accounting.domain.biz;
import app.base.BaseDomain;
/**
* Title: AcReplanSec.java
* Description:
* @���� su
* @���� 2018-4-25
* @version��1.0
**/
public class AcReplanSec extends accounting.domain.sys.CMISDomain {
	private String secId;//�ֶα��
	private String replanId;//��������
	private String formulaId;//����ƻ����
	private String repayType;//��Ϣ��ʽ
	private Double capitalRate;//�������
	private String begRepayNo;//��ʼ�ڴ�
	private String endRepayNo;//�����ڴ�
	private String upDate;//����ʱ��
	private String secOrderNo;//�ֶδ���

	/**
	 * @return �ֶα��
	 */
	public String getSecId() {
	 	return secId;
	}
	/**
	 * @���� �ֶα��
	 * @param secId
	 */
	public void setSecId(String secId) {
	 	this.secId = secId;
	}
	/**
	 * @return ��������
	 */
	public String getReplanId() {
	 	return replanId;
	}
	/**
	 * @���� ��������
	 * @param replanId
	 */
	public void setReplanId(String replanId) {
	 	this.replanId = replanId;
	}
	/**
	 * @return ����ƻ����
	 */
	public String getFormulaId() {
	 	return formulaId;
	}
	/**
	 * @���� ����ƻ����
	 * @param formulaId
	 */
	public void setFormulaId(String formulaId) {
	 	this.formulaId = formulaId;
	}
	/**
	 * @return ��Ϣ��ʽ
	 */
	public String getRepayType() {
	 	return repayType;
	}
	/**
	 * @���� ��Ϣ��ʽ
	 * @param repayType
	 */
	public void setRepayType(String repayType) {
	 	this.repayType = repayType;
	}
	/**
	 * @return �������
	 */
	public Double getCapitalRate() {
	 	return capitalRate;
	}
	/**
	 * @���� �������
	 * @param capitalRate
	 */
	public void setCapitalRate(Double capitalRate) {
	 	this.capitalRate = capitalRate;
	}
	/**
	 * @return ��ʼ�ڴ�
	 */
	public String getBegRepayNo() {
	 	return begRepayNo;
	}
	/**
	 * @���� ��ʼ�ڴ�
	 * @param begRepayNo
	 */
	public void setBegRepayNo(String begRepayNo) {
	 	this.begRepayNo = begRepayNo;
	}
	/**
	 * @return �����ڴ�
	 */
	public String getEndRepayNo() {
	 	return endRepayNo;
	}
	/**
	 * @���� �����ڴ�
	 * @param endRepayNo
	 */
	public void setEndRepayNo(String endRepayNo) {
	 	this.endRepayNo = endRepayNo;
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
	public String getSecOrderNo() {
		return secOrderNo;
	}
	public void setSecOrderNo(String secOrderNo) {
		this.secOrderNo = secOrderNo;
	}
}