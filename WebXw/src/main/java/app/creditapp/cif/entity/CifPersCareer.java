package app.creditapp.cif.entity;
import app.base.BaseDomain;
/**
* Title: CifPersCareer.java
* Description:
* @version��1.0
**/
public class CifPersCareer extends BaseDomain {
	private String recId;//��¼ID
	private String cifName;//�ͻ�����
	private String cifNo;//�ͻ�����
	private String workType;//ְҵ
	private String corpName;//������λ����
	private String corpWay;//������λ������ҵ
	private String corpCode;//������λ�ʱ�
	private String corpAddr;//������λ��ַ
	private String duty;//ְ��
	private String title;//ְ��
	private String workYear;//������ʼ���
	private String brNo;//������������
	private String brName;//������������
	private String recSts;//��¼״̬[01���� 02ɾ��]
	private String txDate;//�Ǽ�����
	private String upDate;//��������
	private String opNo;//����Ա
	private String opName;//����Ա����
	private String workSts; //����״̬
	
	
	public String getWorkSts() {
		return workSts;
	}
	public void setWorkSts(String workSts) {
		this.workSts = workSts;
	}
	/**
	 * @return ��¼ID
	 */
	public String getRecId() {
	 	return recId;
	}
	/**
	 * @���� ��¼ID
	 * @param recId
	 */
	public void setRecId(String recId) {
	 	this.recId = recId;
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
	 * @return �ͻ�����
	 */
	public String getCifNo() {
	 	return cifNo;
	}
	/**
	 * @���� �ͻ�����
	 * @param cifNo
	 */
	public void setCifNo(String cifNo) {
	 	this.cifNo = cifNo;
	}
	/**
	 * @return ְҵ
	 */
	public String getWorkType() {
	 	return workType;
	}
	/**
	 * @���� ְҵ
	 * @param workType
	 */
	public void setWorkType(String workType) {
	 	this.workType = workType;
	}
	/**
	 * @return ������λ����
	 */
	public String getCorpName() {
	 	return corpName;
	}
	/**
	 * @���� ������λ����
	 * @param corpName
	 */
	public void setCorpName(String corpName) {
	 	this.corpName = corpName;
	}
	/**
	 * @return ������λ������ҵ
	 */
	public String getCorpWay() {
	 	return corpWay;
	}
	/**
	 * @���� ������λ������ҵ
	 * @param corpWay
	 */
	public void setCorpWay(String corpWay) {
	 	this.corpWay = corpWay;
	}
	/**
	 * @return ������λ�ʱ�
	 */
	public String getCorpCode() {
	 	return corpCode;
	}
	/**
	 * @���� ������λ�ʱ�
	 * @param corpCode
	 */
	public void setCorpCode(String corpCode) {
	 	this.corpCode = corpCode;
	}
	/**
	 * @return ������λ��ַ
	 */
	public String getCorpAddr() {
	 	return corpAddr;
	}
	/**
	 * @���� ������λ��ַ
	 * @param corpAddr
	 */
	public void setCorpAddr(String corpAddr) {
	 	this.corpAddr = corpAddr;
	}
	/**
	 * @return ְ��
	 */
	public String getDuty() {
	 	return duty;
	}
	/**
	 * @���� ְ��
	 * @param duty
	 */
	public void setDuty(String duty) {
	 	this.duty = duty;
	}
	/**
	 * @return ְ��
	 */
	public String getTitle() {
	 	return title;
	}
	/**
	 * @���� ְ��
	 * @param title
	 */
	public void setTitle(String title) {
	 	this.title = title;
	}
	/**
	 * @return ������ʼ���
	 */
	public String getWorkYear() {
	 	return workYear;
	}
	/**
	 * @���� ������ʼ���
	 * @param workYear
	 */
	public void setWorkYear(String workYear) {
	 	this.workYear = workYear;
	}
	/**
	 * @return ������������
	 */
	public String getBrNo() {
	 	return brNo;
	}
	/**
	 * @���� ������������
	 * @param brNo
	 */
	public void setBrNo(String brNo) {
	 	this.brNo = brNo;
	}
	/**
	 * @return ��¼״̬[01���� 02ɾ��]
	 */
	public String getRecSts() {
	 	return recSts;
	}
	/**
	 * @���� ��¼״̬[01���� 02ɾ��]
	 * @param recSts
	 */
	public void setRecSts(String recSts) {
	 	this.recSts = recSts;
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
	public String getBrName() {
		return brName;
	}
	public void setBrName(String brName) {
		this.brName = brName;
	}
	public String getOpName() {
		return opName;
	}
	public void setOpName(String opName) {
		this.opName = opName;
	}
}