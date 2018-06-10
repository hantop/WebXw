package app.creditapp.acc.option.entity;
import app.base.BaseDomain;
/**
* Title: AcFineFormula.java
* Description:
* @version��1.0
**/
public class AcFineFormula extends BaseDomain {
	private String opNo;//�Ǽ���
	private String txDate;//�Ǽ�����
	private String upDate;//����ʱ��
	private String fineId;//��Ϣ��ʽ���
	private String fineName;//��Ϣ��ʽ����
	private String fineFormulaDes;//��Ϣ��ʽ����
	private String fineFormula;//fine_formula
	private String fineSts;//��Ϣ��ʽ״̬
	private double overRate;//��������

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
	/**
	 * @return ��Ϣ��ʽ���
	 */
	public String getFineId() {
	 	return fineId;
	}
	/**
	 * @���� ��Ϣ��ʽ���
	 * @param fineId
	 */
	public void setFineId(String fineId) {
	 	this.fineId = fineId;
	}
	/**
	 * @return ��Ϣ��ʽ����
	 */
	public String getFineName() {
	 	return fineName;
	}
	/**
	 * @���� ��Ϣ��ʽ����
	 * @param fineName
	 */
	public void setFineName(String fineName) {
	 	this.fineName = fineName;
	}
	/**
	 * @return ��Ϣ��ʽ����
	 */
	public String getFineFormulaDes() {
	 	return fineFormulaDes;
	}
	/**
	 * @���� ��Ϣ��ʽ����
	 * @param fineFormulaDes
	 */
	public void setFineFormulaDes(String fineFormulaDes) {
	 	this.fineFormulaDes = fineFormulaDes;
	}
	/**
	 * @return fine_formula
	 */
	public String getFineFormula() {
	 	return fineFormula;
	}
	/**
	 * @���� fine_formula
	 * @param fineFormula
	 */
	public void setFineFormula(String fineFormula) {
	 	this.fineFormula = fineFormula;
	}
	public double getOverRate() {
		return overRate;
	}
	public void setOverRate(double overRate) {
		this.overRate = overRate;
	}
	/**
	 * @return ��Ϣ��ʽ״̬
	 */
	public String getFineSts() {
	 	return fineSts;
	}
	/**
	 * @���� ��Ϣ��ʽ״̬
	 * @param fineSts
	 */
	public void setFineSts(String fineSts) {
	 	this.fineSts = fineSts;
	}
}