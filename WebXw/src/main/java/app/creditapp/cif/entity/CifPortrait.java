package app.creditapp.cif.entity;
import app.base.BaseDomain;
/**
* Title: CifPortrait.java
* Description:
* @version��1.0
**/
public class CifPortrait extends BaseDomain {
	private String cifNo;//�ͻ�����
	private String cifName;//�ͻ�����
	private String idNo;//֤������
	private String idType;//֤������
	private String sex;//�Ա�
	private String birthDay;//��������
	private String marriage;//����״��
	private String edu;//���ѧ��
	private Double income;//�����루Ԫ��
	private String grade;//���õȼ����÷�
	private String creditDesc;//����״��
	private String workType;//ְҵ
	private String ifCar;//�Ƿ��г�
	private String ifRoom;//�Ƿ��з�
	private String ifDc;//�Ƿ����
	private String ifHg;//�Ƿ�ع�
	private String prtDesc;//��������-����
	private String txDate;//�Ǽ�����
	private String upDate;//��������
	private String cifGroup;//�ͻ�Ⱥ��
	
	private Integer repdNum;//���ڴ���
	private Double gradePersent;//�ͻ����ְٷֱ�
	private Integer cifBlacknum;//������
	private String cifType;//�ͻ�����
	private String lnDue;//��ݺ�
	private String resTel;//סլ�绰
	private String resAddr;//סլ��ַ
	private int version;//��ͼ�汾
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
	 * @return �Ա�
	 */
	public String getSex() {
	 	return sex;
	}
	/**
	 * @���� �Ա�
	 * @param sex
	 */
	public void setSex(String sex) {
	 	this.sex = sex;
	}
	/**
	 * @return ��������
	 */
	public String getBirthDay() {
	 	return birthDay;
	}
	/**
	 * @���� ��������
	 * @param birthDay
	 */
	public void setBirthDay(String birthDay) {
	 	this.birthDay = birthDay;
	}
	/**
	 * @return ����״��
	 */
	public String getMarriage() {
	 	return marriage;
	}
	/**
	 * @���� ����״��
	 * @param marriage
	 */
	public void setMarriage(String marriage) {
	 	this.marriage = marriage;
	}
	/**
	 * @return ���ѧ��
	 */
	public String getEdu() {
	 	return edu;
	}
	/**
	 * @���� ���ѧ��
	 * @param edu
	 */
	public void setEdu(String edu) {
	 	this.edu = edu;
	}
	/**
	 * @return �����루Ԫ��
	 */
	public Double getIncome() {
	 	return income;
	}
	/**
	 * @���� �����루Ԫ��
	 * @param income
	 */
	public void setIncome(Double income) {
	 	this.income = income;
	}
	/**
	 * @return ���õȼ����÷�
	 */
	public String getGrade() {
	 	return grade;
	}
	/**
	 * @���� ���õȼ����÷�
	 * @param grade
	 */
	public void setGrade(String grade) {
	 	this.grade = grade;
	}
	/**
	 * @return ����״��
	 */
	public String getCreditDesc() {
	 	return creditDesc;
	}
	/**
	 * @���� ����״��
	 * @param creditDesc
	 */
	public void setCreditDesc(String creditDesc) {
	 	this.creditDesc = creditDesc;
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
	 * @return �Ƿ��г�
	 */
	public String getIfCar() {
	 	return ifCar;
	}
	/**
	 * @���� �Ƿ��г�
	 * @param ifCar
	 */
	public void setIfCar(String ifCar) {
	 	this.ifCar = ifCar;
	}
	/**
	 * @return �Ƿ��з�
	 */
	public String getIfRoom() {
	 	return ifRoom;
	}
	/**
	 * @���� �Ƿ��з�
	 * @param ifRoom
	 */
	public void setIfRoom(String ifRoom) {
	 	this.ifRoom = ifRoom;
	}
	/**
	 * @return �Ƿ����
	 */
	public String getIfDc() {
	 	return ifDc;
	}
	/**
	 * @���� �Ƿ����
	 * @param ifDc
	 */
	public void setIfDc(String ifDc) {
	 	this.ifDc = ifDc;
	}
	/**
	 * @return �Ƿ�ع�
	 */
	public String getIfHg() {
	 	return ifHg;
	}
	/**
	 * @���� �Ƿ�ع�
	 * @param ifHg
	 */
	public void setIfHg(String ifHg) {
	 	this.ifHg = ifHg;
	}
	/**
	 * @return ��������-����
	 */
	public String getPrtDesc() {
	 	return prtDesc;
	}
	/**
	 * @���� ��������-����
	 * @param prtDesc
	 */
	public void setPrtDesc(String prtDesc) {
	 	this.prtDesc = prtDesc;
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
	public String getCifGroup() {
		return cifGroup;
	}
	public void setCifGroup(String cifGroup) {
		this.cifGroup = cifGroup;
	}
	public Integer getRepdNum() {
		return repdNum;
	}
	public void setRepdNum(Integer repdNum) {
		this.repdNum = repdNum;
	}
	public Double getGradePersent() {
		return gradePersent;
	}
	public void setGradePersent(Double gradePersent) {
		this.gradePersent = gradePersent;
	}
	public Integer getCifBlacknum() {
		return cifBlacknum;
	}
	public void setCifBlacknum(Integer cifBlacknum) {
		this.cifBlacknum = cifBlacknum;
	}
	public String getCifType() {
		return cifType;
	}
	public void setCifType(String cifType) {
		this.cifType = cifType;
	}
	public String getLnDue() {
		return lnDue;
	}
	public void setLnDue(String lnDue) {
		this.lnDue = lnDue;
	}
	public String getResTel() {
		return resTel;
	}
	public void setResTel(String resTel) {
		this.resTel = resTel;
	}
	public String getResAddr() {
		return resAddr;
	}
	public void setResAddr(String resAddr) {
		this.resAddr = resAddr;
	}
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	public String getIdNo() {
		return idNo;
	}
	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}
	public String getIdType() {
		return idType;
	}
	public void setIdType(String idType) {
		this.idType = idType;
	}

}