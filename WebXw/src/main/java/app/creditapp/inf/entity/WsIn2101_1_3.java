package app.creditapp.inf.entity;

/**
 * @���� DHCC-LIU
 * @���� Jun 23, 2016
 * listCom
 * @����   ������������--����ʵ���� LN_COM_MID
 */
public class WsIn2101_1_3 {
	
	private String appId;
	private String comName;  //���������
	private String comIdtype;//֤������
	private String comIdno;  //֤������
	private String comTel;   //��ϵ�绰
	private String pactNo; //��ͬ��
	
	public String getPactNo() {
		return pactNo;
	}
	public void setPactNo(String pactNo) {
		this.pactNo = pactNo;
	}
	public String getComName() {
		return comName;
	}
	public void setComName(String comName) {
		this.comName = comName;
	}
	public String getComIdtype() {
		return comIdtype;
	}
	public void setComIdtype(String comIdtype) {
		this.comIdtype = comIdtype;
	}
	public String getComIdno() {
		return comIdno;
	}
	public void setComIdno(String comIdno) {
		this.comIdno = comIdno;
	}
	public String getComTel() {
		return comTel;
	}
	public void setComTel(String comTel) {
		this.comTel = comTel;
	}
	public String getAppId() {
		return appId;
	}
	public void setAppId(String appId) {
		this.appId = appId;
	}
	
	
}
