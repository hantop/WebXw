package app.creditapp.cred.entity;
import app.base.BaseDomain;
/**
* Title: CifEval.java
* Description:
* @version��1.0
**/
public class CifEval extends BaseDomain {
	private String evalDesc;//����ԭ��
	private String evalDate;//����ʱ��
	private String evalSts;//����״̬[01��Ч02ʧЧ]
	private String grade;//�������[A B C]
	private String idNo;//֤������
	private String cifName;//�ͻ�����
	private String cifNo;//�ͻ����
	private String evalNo;//�������
	private String appId;//�����
	private Integer score;//���ַ���
	private String idType;//֤������
	private String brNo;//��������
	private String resultId;//�ͻ���������ID
	private String query;
	private String loginid;//��¼��Ա
	
	public String getLoginid() {
		return loginid;
	}
	public void setLoginid(String loginid) {
		this.loginid = loginid;
	}
	/**
	 * ��������
	 */
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
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
	 * @return ֤������
	 */
	public String getIdNo() {
	 	return idNo;
	}
	/**
	 * @���� ֤������
	 * @param idNo
	 */
	public void setIdNo(String idNo) {
	 	this.idNo = idNo;
	}
	/**
	 * @return �ͻ�����
	 */
	public String getCifName() {
	 	return cifName;
	}
	/**
	 * @���� �ͻ�����
	 * @param cifName
	 */
	public void setCifName(String cifName) {
	 	this.cifName = cifName;
	}
	/**
	 * @return �ͻ����
	 */
	public String getCifNo() {
	 	return cifNo;
	}
	/**
	 * @���� �ͻ����
	 * @param cifNo
	 */
	public void setCifNo(String cifNo) {
	 	this.cifNo = cifNo;
	}
	/**
	 * @return �������
	 */
	public String getEvalNo() {
	 	return evalNo;
	}
	/**
	 * @���� �������
	 * @param evalNo
	 */
	public void setEvalNo(String evalNo) {
	 	this.evalNo = evalNo;
	}
	
	public String getAppId() {
		return appId;
	}
	public void setAppId(String appId) {
		this.appId = appId;
	}
	public String getIdType() {
		return idType;
	}
	public void setIdType(String idType) {
		this.idType = idType;
	}
	public String getBrNo() {
		return brNo;
	}
	public void setBrNo(String brNo) {
		this.brNo = brNo;
	}
	/**
	 * @return the resultId
	 */
	public String getResultId() {
		return resultId;
	}
	/**
	 * @param resultId the resultId to set
	 */
	public void setResultId(String resultId) {
		this.resultId = resultId;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
}