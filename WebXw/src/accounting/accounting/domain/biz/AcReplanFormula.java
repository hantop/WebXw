package accounting.domain.biz;
import app.base.BaseDomain;
/**
* Title: AccReplanFormula.java
* Description:
* @���� su
* @���� 2018-4-25
* @version��1.0
**/
public class AcReplanFormula extends accounting.domain.sys.CMISDomain {
	private String formulaId;//����ƻ����
	private String formulaName;//����ƻ�����
	private String customEle;//�Զ���Ҫ��
	private String payCapDes;//Ӧ�ձ���ʽ����
	private String payCap;//Ӧ�ձ���ʽ
	private String payInteDes;//Ӧ����Ϣ��ʽ����
	private String payInte;//Ӧ����Ϣ��ʽ
	private String opNo;//����Ա
	private String brNo;//������
	private String upDate;//����ʱ��

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
	 * @return ����ƻ�����
	 */
	public String getFormulaName() {
	 	return formulaName;
	}
	/**
	 * @���� ����ƻ�����
	 * @param formulaName
	 */
	public void setFormulaName(String formulaName) {
	 	this.formulaName = formulaName;
	}
	/**
	 * @return �Զ���Ҫ��
	 */
	public String getCustomEle() {
	 	return customEle;
	}
	/**
	 * @���� �Զ���Ҫ��
	 * @param customEle
	 */
	public void setCustomEle(String customEle) {
	 	this.customEle = customEle;
	}
	/**
	 * @return Ӧ�ձ���ʽ����
	 */
	public String getPayCapDes() {
	 	return payCapDes;
	}
	/**
	 * @���� Ӧ�ձ���ʽ����
	 * @param payCapDes
	 */
	public void setPayCapDes(String payCapDes) {
	 	this.payCapDes = payCapDes;
	}
	/**
	 * @return Ӧ�ձ���ʽ
	 */
	public String getPayCap() {
	 	return payCap;
	}
	/**
	 * @���� Ӧ�ձ���ʽ
	 * @param payCap
	 */
	public void setPayCap(String payCap) {
	 	this.payCap = payCap;
	}
	/**
	 * @return Ӧ����Ϣ��ʽ����
	 */
	public String getPayInteDes() {
	 	return payInteDes;
	}
	/**
	 * @���� Ӧ����Ϣ��ʽ����
	 * @param payInteDes
	 */
	public void setPayInteDes(String payInteDes) {
	 	this.payInteDes = payInteDes;
	}
	/**
	 * @return Ӧ����Ϣ��ʽ
	 */
	public String getPayInte() {
	 	return payInte;
	}
	/**
	 * @���� Ӧ����Ϣ��ʽ
	 * @param payInte
	 */
	public void setPayInte(String payInte) {
	 	this.payInte = payInte;
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
}