package app.creditapp.sys.entity;
import app.base.BaseDomain;
/**
* Title: SysOrg.java
* Description:
* @version��1.0
**/
public class SysOrg extends BaseDomain {
	private String orgDisname;//�������
	private String orgName;//��������
	private String orgNo;//����/���ű��
	private String supNo;//�ϼ�������
	private String orgType;//��������[01����02��˾]
	private Integer orgLev;//�����ȼ�
	private String orgChannel;//ͨѶ������(����ΧϵͳͨѶ��������)
	private String orgFinno;//���ڻ�������
	private String orgSts;//ϵͳ״̬[01����02ͣ��]

	/**
	 * @return �������
	 */
	public String getOrgDisname() {
	 	return orgDisname;
	}
	/**
	 * @���� �������
	 * @param orgDisname
	 */
	public void setOrgDisname(String orgDisname) {
	 	this.orgDisname = orgDisname;
	}
	/**
	 * @return ��������
	 */
	public String getOrgName() {
	 	return orgName;
	}
	/**
	 * @���� ��������
	 * @param orgName
	 */
	public void setOrgName(String orgName) {
	 	this.orgName = orgName;
	}
	/**
	 * @return ����/���ű��
	 */
	public String getOrgNo() {
	 	return orgNo;
	}
	/**
	 * @���� ����/���ű��
	 * @param orgNo
	 */
	public void setOrgNo(String orgNo) {
	 	this.orgNo = orgNo;
	}
	/**
	 * @return �ϼ�������
	 */
	public String getSupNo() {
	 	return supNo;
	}
	/**
	 * @���� �ϼ�������
	 * @param supNo
	 */
	public void setSupNo(String supNo) {
	 	this.supNo = supNo;
	}
	/**
	 * @return ��������[01����02��˾]
	 */
	public String getOrgType() {
	 	return orgType;
	}
	/**
	 * @���� ��������[01����02��˾]
	 * @param orgType
	 */
	public void setOrgType(String orgType) {
	 	this.orgType = orgType;
	}
	/**
	 * @return �����ȼ�
	 */
	public Integer getOrgLev() {
	 	return orgLev;
	}
	/**
	 * @���� �����ȼ�
	 * @param orgLev
	 */
	public void setOrgLev(Integer orgLev) {
	 	this.orgLev = orgLev;
	}
	/**
	 * @return ͨѶ������(����ΧϵͳͨѶ��������)
	 */
	public String getOrgChannel() {
	 	return orgChannel;
	}
	/**
	 * @���� ͨѶ������(����ΧϵͳͨѶ��������)
	 * @param orgChannel
	 */
	public void setOrgChannel(String orgChannel) {
	 	this.orgChannel = orgChannel;
	}
	/**
	 * @return ���ڻ�������
	 */
	public String getOrgFinno() {
	 	return orgFinno;
	}
	/**
	 * @���� ���ڻ�������
	 * @param orgFinno
	 */
	public void setOrgFinno(String orgFinno) {
	 	this.orgFinno = orgFinno;
	}
	/**
	 * @return ϵͳ״̬[01����02ͣ��]
	 */
	public String getOrgSts() {
	 	return orgSts;
	}
	/**
	 * @���� ϵͳ״̬[01����02ͣ��]
	 * @param orgSts
	 */
	public void setOrgSts(String orgSts) {
	 	this.orgSts = orgSts;
	}
}