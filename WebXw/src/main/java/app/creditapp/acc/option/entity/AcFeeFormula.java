package app.creditapp.acc.option.entity;
import app.base.BaseDomain;
/**
* Title: AcFeeFormula.java
* Description:
* @version��1.0
**/
public class AcFeeFormula extends BaseDomain {
	private String feeFormId;//���ù�ʽ���
	private String feeFormName;//���ù�ʽ����
	private String frId;//���ʶ�����
	private String feeFormulaDes;//���ù�ʽ����
	private String feeFormula;//���ù�ʽ

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
	 * @return ���ù�ʽ����
	 */
	public String getFeeFormName() {
	 	return feeFormName;
	}
	/**
	 * @���� ���ù�ʽ����
	 * @param feeFormName
	 */
	public void setFeeFormName(String feeFormName) {
	 	this.feeFormName = feeFormName;
	}
	/**
	 * @return ���ù�ʽ����
	 */
	public String getFeeFormulaDes() {
	 	return feeFormulaDes;
	}
	/**
	 * @���� ���ù�ʽ����
	 * @param feeFormulaDes
	 */
	public void setFeeFormulaDes(String feeFormulaDes) {
	 	this.feeFormulaDes = feeFormulaDes;
	}
	/**
	 * @return ���ù�ʽ
	 */
	public String getFeeFormula() {
	 	return feeFormula;
	}
	/**
	 * @���� ���ù�ʽ
	 * @param feeFormula
	 */
	public void setFeeFormula(String feeFormula) {
	 	this.feeFormula = feeFormula;
	}
	public String getFrId() {
		return frId;
	}
	public void setFrId(String frId) {
		this.frId = frId;
	}
}