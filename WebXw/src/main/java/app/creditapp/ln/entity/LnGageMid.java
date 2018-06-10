package app.creditapp.ln.entity;
import app.base.BaseDomain;
/**
* Title: LnGageMid.java
* Description:
* @version��1.0
**/
public class LnGageMid extends BaseDomain {
	private String appId;//����ID
	private String gageCifname;//����Ȩ������
	private String gageIdtype;//����Ȩ��֤������
	private String gageIdno;//����Ȩ��֤������
	private String gageType;//ѺƷ����
	private String gageName;//ѺƷ����
	private String gageDesc;//ѺƷ����
	private Double gageValue;//ѺƷ������ֵ
	private String gageLic;//Ȩ֤����
	private String gageLictype;//Ȩ֤����[01����֤02�������Ǽ�֤��]
	private String gageLicbr;//Ȩ֤���Ż���
	private String gageBegdate;//ѺƷ��ʼ��
	private String gageEnddate;//ѺƷ������
	private Double gageAmt;//��Ѻ���
	private String pactNo;//��ͬ��

	public String getPactNo() {
		return pactNo;
	}
	public void setPactNo(String pactNo) {
		this.pactNo = pactNo;
	}
	/**
	 * @return ����ID
	 */
	public String getAppId() {
	 	return appId;
	}
	/**
	 * @���� ����ID
	 * @param appId
	 */
	public void setAppId(String appId) {
	 	this.appId = appId;
	}
	/**
	 * @return ����Ȩ������
	 */
	public String getGageCifname() {
	 	return gageCifname;
	}
	/**
	 * @���� ����Ȩ������
	 * @param gageCifname
	 */
	public void setGageCifname(String gageCifname) {
	 	this.gageCifname = gageCifname;
	}
	/**
	 * @return ����Ȩ��֤������
	 */
	public String getGageIdtype() {
	 	return gageIdtype;
	}
	/**
	 * @���� ����Ȩ��֤������
	 * @param gageIdtype
	 */
	public void setGageIdtype(String gageIdtype) {
	 	this.gageIdtype = gageIdtype;
	}
	/**
	 * @return ����Ȩ��֤������
	 */
	public String getGageIdno() {
	 	return gageIdno;
	}
	/**
	 * @���� ����Ȩ��֤������
	 * @param gageIdno
	 */
	public void setGageIdno(String gageIdno) {
	 	this.gageIdno = gageIdno;
	}
	/**
	 * @return ѺƷ����
	 */
	public String getGageType() {
	 	return gageType;
	}
	/**
	 * @���� ѺƷ����
	 * @param gageType
	 */
	public void setGageType(String gageType) {
	 	this.gageType = gageType;
	}
	/**
	 * @return ѺƷ����
	 */
	public String getGageName() {
	 	return gageName;
	}
	/**
	 * @���� ѺƷ����
	 * @param gageName
	 */
	public void setGageName(String gageName) {
	 	this.gageName = gageName;
	}
	/**
	 * @return ѺƷ����
	 */
	public String getGageDesc() {
	 	return gageDesc;
	}
	/**
	 * @���� ѺƷ����
	 * @param gageDesc
	 */
	public void setGageDesc(String gageDesc) {
	 	this.gageDesc = gageDesc;
	}
	/**
	 * @return ѺƷ������ֵ
	 */
	public Double getGageValue() {
	 	return gageValue;
	}
	/**
	 * @���� ѺƷ������ֵ
	 * @param gageValue
	 */
	public void setGageValue(Double gageValue) {
	 	this.gageValue = gageValue;
	}
	/**
	 * @return Ȩ֤����
	 */
	public String getGageLic() {
	 	return gageLic;
	}
	/**
	 * @���� Ȩ֤����
	 * @param gageLic
	 */
	public void setGageLic(String gageLic) {
	 	this.gageLic = gageLic;
	}
	/**
	 * @return Ȩ֤����[01����֤02�������Ǽ�֤��]
	 */
	public String getGageLictype() {
	 	return gageLictype;
	}
	/**
	 * @���� Ȩ֤����[01����֤02�������Ǽ�֤��]
	 * @param gageLictype
	 */
	public void setGageLictype(String gageLictype) {
	 	this.gageLictype = gageLictype;
	}
	/**
	 * @return Ȩ֤���Ż���
	 */
	public String getGageLicbr() {
	 	return gageLicbr;
	}
	/**
	 * @���� Ȩ֤���Ż���
	 * @param gageLicbr
	 */
	public void setGageLicbr(String gageLicbr) {
	 	this.gageLicbr = gageLicbr;
	}
	/**
	 * @return ѺƷ��ʼ��
	 */
	public String getGageBegdate() {
	 	return gageBegdate;
	}
	/**
	 * @���� ѺƷ��ʼ��
	 * @param gageBegdate
	 */
	public void setGageBegdate(String gageBegdate) {
	 	this.gageBegdate = gageBegdate;
	}
	/**
	 * @return ѺƷ������
	 */
	public String getGageEnddate() {
	 	return gageEnddate;
	}
	/**
	 * @���� ѺƷ������
	 * @param gageEnddate
	 */
	public void setGageEnddate(String gageEnddate) {
	 	this.gageEnddate = gageEnddate;
	}
	/**
	 * @return ��Ѻ���
	 */
	public Double getGageAmt() {
	 	return gageAmt;
	}
	/**
	 * @���� ��Ѻ���
	 * @param gageAmt
	 */
	public void setGageAmt(Double gageAmt) {
	 	this.gageAmt = gageAmt;
	}
}