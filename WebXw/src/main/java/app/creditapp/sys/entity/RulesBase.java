package app.creditapp.sys.entity;
import app.base.BaseDomain;
/**
* Title: RulesBase.java
* Description:
* @version��1.0
**/
public class RulesBase extends BaseDomain {
	private String prdtNo;//��Ʒ��
	private String codeValue;//�ֶ�����
	private String codeName;//�ֶ���
	private String codeDesc;//�ֶ�����
	private String codeSts;//�ֶ�ֵ[01-׼��|02-�ܾ�|03-ʵʱ]

	/**
	 * @return ��Ʒ��
	 */
	public String getPrdtNo() {
	 	return prdtNo;
	}
	/**
	 * @���� ��Ʒ��
	 * @param prdtNo
	 */
	public void setPrdtNo(String prdtNo) {
	 	this.prdtNo = prdtNo;
	}
	/**
	 * @return �ֶ�����
	 */
	public String getCodeValue() {
	 	return codeValue;
	}
	/**
	 * @���� �ֶ�����
	 * @param codeValue
	 */
	public void setCodeValue(String codeValue) {
	 	this.codeValue = codeValue;
	}
	/**
	 * @return �ֶ���
	 */
	public String getCodeName() {
	 	return codeName;
	}
	/**
	 * @���� �ֶ���
	 * @param codeName
	 */
	public void setCodeName(String codeName) {
	 	this.codeName = codeName;
	}
	/**
	 * @return �ֶ�����
	 */
	public String getCodeDesc() {
	 	return codeDesc;
	}
	/**
	 * @���� �ֶ�����
	 * @param codeDesc
	 */
	public void setCodeDesc(String codeDesc) {
	 	this.codeDesc = codeDesc;
	}
	/**
	 * @return �ֶ�ֵ[01-׼��|02-�ܾ�|03-ʵʱ]
	 */
	public String getCodeSts() {
	 	return codeSts;
	}
	/**
	 * @���� �ֶ�ֵ[01-׼��|02-�ܾ�|03-ʵʱ]
	 * @param codeSts
	 */
	public void setCodeSts(String codeSts) {
	 	this.codeSts = codeSts;
	}
}