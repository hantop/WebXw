package app.creditapp.gage.entity;
import app.base.BaseDomain;
/**
* Title: LnGage.java
* Description:
* @version��1.0
**/
public class LnGage extends BaseDomain {
	private String upDate;//��������
	private String txDate;//��������
	private String opNo;//�ܻ�����Ա��
	private String brNo;//������������
	private String gageSts;//ѺƷ״̬[01����02���03��Ѻ04ת��ծ]
	private String gateDete;//�´μ������
	private Double evalValue;//������ֵ
	private String evalOrg;//��������
	private String evalDate;//��������
	private String evalType;//��������
	private Double gageAmt;//��Ѻ���
	private String gageOutdate;//��Ѻ����
	private String gageEnddate;//ѺƷ������
	private String gageBegdate;//ѺƷ��ʼ��
	private String gageLicbr;//Ȩ֤���Ż���
	private String gageLic;//����Ȩ֤����
	private Double gageValue;//�϶���ֵ
	private String gageDesc;//ѺƷ����
	private String gageName;//ѺƷ����
	private String gageType;//ѺƷ����
	private String gageIdno;//����Ȩ��֤������
	private String gageIdtype;//����Ȩ��֤������
	private String gageCifname;//����Ȩ������
	private String gageId;//ѺƷID
	private String appId;//����ID
	private String cifNo;//�ͻ���
	private String gageLictype;//Ȩ֤����
	private String cifName;//�ͻ�����
	private String brName;//������������
	private String opName;//����Ա����
	
	public String getCifNo() {
		return cifNo;
	}
	public void setCifNo(String cifNo) {
		this.cifNo = cifNo;
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
	 * @return ��������
	 */
	public String getTxDate() {
	 	return txDate;
	}
	/**
	 * @���� ��������
	 * @param txDate
	 */
	public void setTxDate(String txDate) {
	 	this.txDate = txDate;
	}
	/**
	 * @return �ܻ�����Ա��
	 */
	public String getOpNo() {
	 	return opNo;
	}
	/**
	 * @���� �ܻ�����Ա��
	 * @param opNo
	 */
	public void setOpNo(String opNo) {
	 	this.opNo = opNo;
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
	 * @return ѺƷ״̬[01����02���03��Ѻ04ת��ծ]
	 */
	public String getGageSts() {
	 	return gageSts;
	}
	/**
	 * @���� ѺƷ״̬[01����02���03��Ѻ04ת��ծ]
	 * @param gageSts
	 */
	public void setGageSts(String gageSts) {
	 	this.gageSts = gageSts;
	}
	/**
	 * @return �´μ������
	 */
	public String getGateDete() {
	 	return gateDete;
	}
	/**
	 * @���� �´μ������
	 * @param gateDete
	 */
	public void setGateDete(String gateDete) {
	 	this.gateDete = gateDete;
	}
	/**
	 * @return ������ֵ
	 */
	public Double getEvalValue() {
	 	return evalValue;
	}
	/**
	 * @���� ������ֵ
	 * @param evalValue
	 */
	public void setEvalValue(Double evalValue) {
	 	this.evalValue = evalValue;
	}
	/**
	 * @return ��������
	 */
	public String getEvalOrg() {
	 	return evalOrg;
	}
	/**
	 * @���� ��������
	 * @param evalOrg
	 */
	public void setEvalOrg(String evalOrg) {
	 	this.evalOrg = evalOrg;
	}
	/**
	 * @return ��������
	 */
	public String getEvalDate() {
	 	return evalDate;
	}
	/**
	 * @���� ��������
	 * @param evalDate
	 */
	public void setEvalDate(String evalDate) {
	 	this.evalDate = evalDate;
	}
	/**
	 * @return ��������
	 */
	public String getEvalType() {
	 	return evalType;
	}
	/**
	 * @���� ��������
	 * @param evalType
	 */
	public void setEvalType(String evalType) {
	 	this.evalType = evalType;
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
	/**
	 * @return ��Ѻ����
	 */
	public String getGageOutdate() {
	 	return gageOutdate;
	}
	/**
	 * @���� ��Ѻ����
	 * @param gageOutdate
	 */
	public void setGageOutdate(String gageOutdate) {
	 	this.gageOutdate = gageOutdate;
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
	 * @return ����Ȩ֤����
	 */
	public String getGageLic() {
	 	return gageLic;
	}
	/**
	 * @���� ����Ȩ֤����
	 * @param gageLic
	 */
	public void setGageLic(String gageLic) {
	 	this.gageLic = gageLic;
	}
	/**
	 * @return �϶���ֵ
	 */
	public Double getGageValue() {
	 	return gageValue;
	}
	/**
	 * @���� �϶���ֵ
	 * @param gageValue
	 */
	public void setGageValue(Double gageValue) {
	 	this.gageValue = gageValue;
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
	 * @return ѺƷID
	 */
	public String getGageId() {
	 	return gageId;
	}
	/**
	 * @���� ѺƷID
	 * @param gageId
	 */
	public void setGageId(String gageId) {
	 	this.gageId = gageId;
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
	public String getGageLictype() {
		return gageLictype;
	}
	public void setGageLictype(String gageLictype) {
		this.gageLictype = gageLictype;
	}
	public String getCifName() {
		return cifName;
	}
	public void setCifName(String cifName) {
		this.cifName = cifName;
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