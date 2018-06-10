package app.creditapp.sys.entity;
import app.base.BaseDomain;
/**
* Title: ParmRewRule.java
* Description:
* @version��1.0
**/
public class ParmRewRule extends BaseDomain {
	private String ruleSts;//�Ƿ�����[0��1��]
	private String ruleId;//ɸ�������
	private String ruleDesc;//ɸ���������
	private String riskLev;//������ռ���[01��ʾ02����]
	private String opProc;//��Ӧ�洢����
	private String sceneNo;//�������[01Ԥ����02��ʽ����]

	/**
	 * @return �Ƿ�����[0��1��]
	 */
	public String getRuleSts() {
	 	return ruleSts;
	}
	/**
	 * @���� �Ƿ�����[0��1��]
	 * @param ruleSts
	 */
	public void setRuleSts(String ruleSts) {
	 	this.ruleSts = ruleSts;
	}
	/**
	 * @return ɸ�������
	 */
	public String getRuleId() {
	 	return ruleId;
	}
	/**
	 * @���� ɸ�������
	 * @param ruleId
	 */
	public void setRuleId(String ruleId) {
	 	this.ruleId = ruleId;
	}
	/**
	 * @return ɸ���������
	 */
	public String getRuleDesc() {
	 	return ruleDesc;
	}
	/**
	 * @���� ɸ���������
	 * @param ruleDesc
	 */
	public void setRuleDesc(String ruleDesc) {
	 	this.ruleDesc = ruleDesc;
	}
	/**
	 * @return ������ռ���[01��ʾ02����]
	 */
	public String getRiskLev() {
	 	return riskLev;
	}
	/**
	 * @���� ������ռ���[01��ʾ02����]
	 * @param riskLev
	 */
	public void setRiskLev(String riskLev) {
	 	this.riskLev = riskLev;
	}
	/**
	 * @return ��Ӧ�洢����
	 */
	public String getOpProc() {
	 	return opProc;
	}
	/**
	 * @���� ��Ӧ�洢����
	 * @param opProc
	 */
	public void setOpProc(String opProc) {
	 	this.opProc = opProc;
	}
	/**
	 * @return �������[01Ԥ����02��ʽ����]
	 */
	public String getSceneNo() {
	 	return sceneNo;
	}
	/**
	 * @���� �������[01Ԥ����02��ʽ����]
	 * @param sceneNo
	 */
	public void setSceneNo(String sceneNo) {
	 	this.sceneNo = sceneNo;
	}
}