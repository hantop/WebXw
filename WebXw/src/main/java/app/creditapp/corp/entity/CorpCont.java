package app.creditapp.corp.entity;
import app.base.BaseDomain;
/**
* Title: CorpCont.java
* Description:
* @version��1.0
**/
public class CorpCont extends BaseDomain {
	private String contIdno;//��ϵ��֤������
	private String contIdtyoe;//��ϵ��֤������
	private String contType;//��ϵ������[01-����������02-���³�03-�ܾ���04-��������05-����������06-���۸�����07-����]
	private String contName;//��ϵ������
	private String contNo;//��ϵ�˱��
	private String brName;//������������
	private String brNo;//�����������
	private String admTel;//��ϵ�绰
	private String edu;//ѧ��[10-��ʿ�о���15-˶ʿ�о���20-��ѧ����30-��ѧר�ƺ�ר��ѧУ40-�е�רҵѧУ���еȼ���ѧУ50-����ѧУ60-����70-����80-Сѧ90-��ä�����ä99-δ֪]
	private String admAddr;//������ַ
	private String country;//����
	private String birthday;//��������
	private String duty;//ְ��[1-�߼��쵼����������ּ����ּ������쵼���˾�߼�������Ա��2-�м��쵼����������ּ������쵼���˾�м�������Ա��3-һ��Ա��4-����9-δ֪]
	private String wkTitle;//ְ��[0-��1-�߼�2-�м�3-����9-δ֪]
	private String cifFax;//����
	private String comAddr;//��λ��ַ
	private String resume;//����
	private String filer;//��ע
	private String deptNo;//�Ǽǲ���
	private String opNo;//����Ա
	private String opName;//����Ա����
	private String txDate;//�Ǽ�����
	private String upDate;//�޸�����
	private String upOpno;//�޸���Ա
	private String upOpname;//�޸���Ա����
	private String commMail;//�޸���Ա����

	/**
	 * @return ��ϵ��֤������
	 */
	public String getContIdno() {
	 	return contIdno;
	}
	/**
	 * @���� ��ϵ��֤������
	 * @param contIdno
	 */
	public void setContIdno(String contIdno) {
	 	this.contIdno = contIdno;
	}
	/**
	 * @return ��ϵ��֤������
	 */
	public String getContIdtyoe() {
	 	return contIdtyoe;
	}
	/**
	 * @���� ��ϵ��֤������
	 * @param contIdtyoe
	 */
	public void setContIdtyoe(String contIdtyoe) {
	 	this.contIdtyoe = contIdtyoe;
	}
	/**
	 * @return ��ϵ������[01-����������02-���³�03-�ܾ���04-��������05-����������06-���۸�����07-����]
	 */
	public String getContType() {
	 	return contType;
	}
	/**
	 * @���� ��ϵ������[01-����������02-���³�03-�ܾ���04-��������05-����������06-���۸�����07-����]
	 * @param contType
	 */
	public void setContType(String contType) {
	 	this.contType = contType;
	}
	/**
	 * @return ��ϵ������
	 */
	public String getContName() {
	 	return contName;
	}
	/**
	 * @���� ��ϵ������
	 * @param contName
	 */
	public void setContName(String contName) {
	 	this.contName = contName;
	}
	/**
	 * @return ��ϵ�˱��
	 */
	public String getContNo() {
	 	return contNo;
	}
	/**
	 * @���� ��ϵ�˱��
	 * @param contNo
	 */
	public void setContNo(String contNo) {
	 	this.contNo = contNo;
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
	 * @return ��ϵ�绰
	 */
	public String getAdmTel() {
	 	return admTel;
	}
	/**
	 * @���� ��ϵ�绰
	 * @param admTel
	 */
	public void setAdmTel(String admTel) {
	 	this.admTel = admTel;
	}
	/**
	 * @return ѧ��[10-��ʿ�о���15-˶ʿ�о���20-��ѧ����30-��ѧר�ƺ�ר��ѧУ40-�е�רҵѧУ���еȼ���ѧУ50-����ѧУ60-����70-����80-Сѧ90-��ä�����ä99-δ֪]
	 */
	public String getEdu() {
	 	return edu;
	}
	/**
	 * @���� ѧ��[10-��ʿ�о���15-˶ʿ�о���20-��ѧ����30-��ѧר�ƺ�ר��ѧУ40-�е�רҵѧУ���еȼ���ѧУ50-����ѧУ60-����70-����80-Сѧ90-��ä�����ä99-δ֪]
	 * @param edu
	 */
	public void setEdu(String edu) {
	 	this.edu = edu;
	}
	/**
	 * @return ������ַ
	 */
	public String getAdmAddr() {
	 	return admAddr;
	}
	/**
	 * @���� ������ַ
	 * @param admAddr
	 */
	public void setAdmAddr(String admAddr) {
	 	this.admAddr = admAddr;
	}
	/**
	 * @return ����
	 */
	public String getCountry() {
	 	return country;
	}
	/**
	 * @���� ����
	 * @param country
	 */
	public void setCountry(String country) {
	 	this.country = country;
	}
	/**
	 * @return ��������
	 */
	public String getBirthday() {
	 	return birthday;
	}
	/**
	 * @���� ��������
	 * @param birthday
	 */
	public void setBirthday(String birthday) {
	 	this.birthday = birthday;
	}
	/**
	 * @return ְ��[1-�߼��쵼����������ּ����ּ������쵼���˾�߼�������Ա��2-�м��쵼����������ּ������쵼���˾�м�������Ա��3-һ��Ա��4-����9-δ֪]
	 */
	public String getDuty() {
	 	return duty;
	}
	/**
	 * @���� ְ��[1-�߼��쵼����������ּ����ּ������쵼���˾�߼�������Ա��2-�м��쵼����������ּ������쵼���˾�м�������Ա��3-һ��Ա��4-����9-δ֪]
	 * @param duty
	 */
	public void setDuty(String duty) {
	 	this.duty = duty;
	}
	/**
	 * @return ְ��[0-��1-�߼�2-�м�3-����9-δ֪]
	 */
	public String getWkTitle() {
	 	return wkTitle;
	}
	/**
	 * @���� ְ��[0-��1-�߼�2-�м�3-����9-δ֪]
	 * @param wkTitle
	 */
	public void setWkTitle(String wkTitle) {
	 	this.wkTitle = wkTitle;
	}
	/**
	 * @return ����
	 */
	public String getCifFax() {
	 	return cifFax;
	}
	/**
	 * @���� ����
	 * @param cifFax
	 */
	public void setCifFax(String cifFax) {
	 	this.cifFax = cifFax;
	}
	/**
	 * @return ��λ��ַ
	 */
	public String getComAddr() {
	 	return comAddr;
	}
	/**
	 * @���� ��λ��ַ
	 * @param comAddr
	 */
	public void setComAddr(String comAddr) {
	 	this.comAddr = comAddr;
	}
	/**
	 * @return ����
	 */
	public String getResume() {
	 	return resume;
	}
	/**
	 * @���� ����
	 * @param resume
	 */
	public void setResume(String resume) {
	 	this.resume = resume;
	}
	/**
	 * @return ��ע
	 */
	public String getFiler() {
	 	return filer;
	}
	/**
	 * @���� ��ע
	 * @param filer
	 */
	public void setFiler(String filer) {
	 	this.filer = filer;
	}
	/**
	 * @return �Ǽǲ���
	 */
	public String getDeptNo() {
	 	return deptNo;
	}
	/**
	 * @���� �Ǽǲ���
	 * @param deptNo
	 */
	public void setDeptNo(String deptNo) {
	 	this.deptNo = deptNo;
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
	 * @return �޸�����
	 */
	public String getUpDate() {
	 	return upDate;
	}
	/**
	 * @���� �޸�����
	 * @param upDate
	 */
	public void setUpDate(String upDate) {
	 	this.upDate = upDate;
	}
	/**
	 * @return �޸���Ա
	 */
	public String getUpOpno() {
	 	return upOpno;
	}
	/**
	 * @���� �޸���Ա
	 * @param upOpno
	 */
	public void setUpOpno(String upOpno) {
	 	this.upOpno = upOpno;
	}
	public String getOpName() {
		return opName;
	}
	public void setOpName(String opName) {
		this.opName = opName;
	}
	public String getUpOpname() {
		return upOpname;
	}
	public void setUpOpname(String upOpname) {
		this.upOpname = upOpname;
	}
	public String getCommMail() {
		return commMail;
	}
	public void setCommMail(String commMail) {
		this.commMail = commMail;
	}
}