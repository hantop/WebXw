package app.creditapp.inf.entity;

/**
 * @���� DHCC-LIU
 * @���� Jun 23, 2016
 * listRel
 * @����   ������������--����ʵ���� LN_REL_MID
 */
public class WsIn2101_1_4 {
	
	private String appId;
	private String relName; //���������
	private String relIdtype; //֤������
	private String relIdno;  //֤������
    private String relTel; //��ϵ�绰
    private String pactNo; //��ͬ��
    
	public String getPactNo() {
		return pactNo;
	}
	public void setPactNo(String pactNo) {
		this.pactNo = pactNo;
	}
	public String getRelName() {
		return relName;
	}
	public void setRelName(String relName) {
		this.relName = relName;
	}
	public String getRelIdtype() {
		return relIdtype;
	}
	public void setRelIdtype(String relIdtype) {
		this.relIdtype = relIdtype;
	}
	public String getRelIdno() {
		return relIdno;
	}
	public void setRelIdno(String relIdno) {
		this.relIdno = relIdno;
	}
	public String getRelTel() {
		return relTel;
	}
	public void setRelTel(String relTel) {
		this.relTel = relTel;
	}
	public String getAppId() {
		return appId;
	}
	public void setAppId(String appId) {
		this.appId = appId;
	}
    
    
		
}
