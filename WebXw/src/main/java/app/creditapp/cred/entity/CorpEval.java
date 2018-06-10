package app.creditapp.cred.entity;
import app.base.BaseDomain;
/**
* Title: CorpEval.java
* Description:
* @version��1.0
**/
public class CorpEval extends BaseDomain {
	private String evalNo;//�������[����]
	private String brNo;//�����������
	private String brName;//������������
	private String screditNo;//���ͳһ���ô���֤
	private String grade;//�������[A B C]
	private String evalSts;//����״̬[01��Ч02ʧЧ]
	private String evalDate;//����ʱ��
	private String evalDesc;//����ԭ��
	private String resultId;//����ԭ��
	private String loginid;//��¼��Ա
	
	public String getLoginid() {
		return loginid;
	}
	public void setLoginid(String loginid) {
		this.loginid = loginid;
	}
	/**
	 * @return �������[����]
	 */
	public String getEvalNo() {
	 	return evalNo;
	}
	/**
	 * @���� �������[����]
	 * @param evalNo
	 */
	public void setEvalNo(String evalNo) {
	 	this.evalNo = evalNo;
	}
	/**
	 * @return �����������
	 */
	public String getBrNo() {
	 	return brNo;
	}
	/**
	 * @���� �����������
	 * @param brNo
	 */
	public void setBrNo(String brNo) {
	 	this.brNo = brNo;
	}
	/**
	 * @return ������������
	 */
	public String getBrName() {
	 	return brName;
	}
	/**
	 * @���� ������������
	 * @param brName
	 */
	public void setBrName(String brName) {
	 	this.brName = brName;
	}
	/**
	 * @return ���ͳһ���ô���֤
	 */
	public String getScreditNo() {
	 	return screditNo;
	}
	/**
	 * @���� ���ͳһ���ô���֤
	 * @param screditNo
	 */
	public void setScreditNo(String screditNo) {
	 	this.screditNo = screditNo;
	}
	/**
	 * @return �������[A B C]
	 */
	public String getGrade() {
	 	return grade;
	}
	/**
	 * @���� �������[A B C]
	 * @param grade
	 */
	public void setGrade(String grade) {
	 	this.grade = grade;
	}
	/**
	 * @return ����״̬[01��Ч02ʧЧ]
	 */
	public String getEvalSts() {
	 	return evalSts;
	}
	/**
	 * @���� ����״̬[01��Ч02ʧЧ]
	 * @param evalSts
	 */
	public void setEvalSts(String evalSts) {
	 	this.evalSts = evalSts;
	}
	/**
	 * @return ����ʱ��
	 */
	public String getEvalDate() {
	 	return evalDate;
	}
	/**
	 * @���� ����ʱ��
	 * @param evalDate
	 */
	public void setEvalDate(String evalDate) {
	 	this.evalDate = evalDate;
	}
	/**
	 * @return ����ԭ��
	 */
	public String getEvalDesc() {
	 	return evalDesc;
	}
	/**
	 * @���� ����ԭ��
	 * @param evalDesc
	 */
	public void setEvalDesc(String evalDesc) {
	 	this.evalDesc = evalDesc;
	}
	public String getResultId() {
		return resultId;
	}
	public void setResultId(String resultId) {
		this.resultId = resultId;
	}
}