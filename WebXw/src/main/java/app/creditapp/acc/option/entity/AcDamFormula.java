package app.creditapp.acc.option.entity;
import app.base.BaseDomain;
/**
* Title: AcDamFormula.java
* Description:
* @version��1.0
**/
public class AcDamFormula extends BaseDomain {
	private String damId;//��ǰ����ΥԼ��ʽ���
	private String damName;//��ǰ����ΥԼ��ʽ����
	private String damFormulaDes;//��ǰ����ΥԼ��ʽ����
	private String damFormula;//��ǰ����ΥԼ��ʽ
	private String frId;//���ʱ��
	private String damSts;//״̬[0-ʧЧ;1-��Ч]
	private String opNo;//�Ǽ���
	private String txDate;//�Ǽ�����
	private String upDate;//��������
	
	private String feeMethod;//��ǰ���������ȡ��ʽ 01 ȫ�� 02 �������� 03 �޷���


	/**
	 * @return ��ǰ����ΥԼ��ʽ���
	 */
	public String getDamId() {
	 	return damId;
	}
	/**
	 * @���� ��ǰ����ΥԼ��ʽ���
	 * @param damId
	 */
	public void setDamId(String damId) {
	 	this.damId = damId;
	}
	/**
	 * @return ��ǰ����ΥԼ��ʽ����
	 */
	public String getDamName() {
	 	return damName;
	}
	/**
	 * @���� ��ǰ����ΥԼ��ʽ����
	 * @param damName
	 */
	public void setDamName(String damName) {
	 	this.damName = damName;
	}
	/**
	 * @return ��ǰ����ΥԼ��ʽ����
	 */
	public String getDamFormulaDes() {
	 	return damFormulaDes;
	}
	/**
	 * @���� ��ǰ����ΥԼ��ʽ����
	 * @param damFormulaDes
	 */
	public void setDamFormulaDes(String damFormulaDes) {
	 	this.damFormulaDes = damFormulaDes;
	}
	/**
	 * @return ��ǰ����ΥԼ��ʽ
	 */
	public String getDamFormula() {
	 	return damFormula;
	}
	/**
	 * @���� ��ǰ����ΥԼ��ʽ
	 * @param damFormula
	 */
	public void setDamFormula(String damFormula) {
	 	this.damFormula = damFormula;
	}
	/**
	 * @return ���ʱ��
	 */
	public String getFrId() {
	 	return frId;
	}
	/**
	 * @���� ���ʱ��
	 * @param frId
	 */
	public void setFrId(String frId) {
	 	this.frId = frId;
	}
	/**
	 * @return ״̬[0-ʧЧ;1-��Ч]
	 */
	public String getDamSts() {
	 	return damSts;
	}
	/**
	 * @���� ״̬[0-ʧЧ;1-��Ч]
	 * @param damSts
	 */
	public void setDamSts(String damSts) {
	 	this.damSts = damSts;
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
	public String getFeeMethod() {
		return feeMethod;
	}
	public void setFeeMethod(String feeMethod) {
		this.feeMethod = feeMethod;
	}
}