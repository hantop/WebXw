package app.creditapp.inf.entity;

/**
 * @���� DHCC-SONG
 * @���� Jun 28, 2016
 * @���� ����ʵ����
 */
public class WsIn4101 {
	private String batchNo;//���κ���
	private String czPactNo;//��֤��ˮ��
	private String brNo;//������������
	private String appDate;//��������
	private String cifName;//�ͻ�����
	private String idType;//֤������
	private String idNo;//֤������
	private String czAuth;//�Ƿ��в�����Ȩ
	private String czId;//�Ƿ����֤��Ϣ
	private String url; // ���ű��������ļ�·��
	private String chkDesc; // У����
	
	//����
	private String crpReason;//��ѯԭ��
	
	public String getBatchNo() {
		return batchNo;
	}
	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}
	public String getBrNo() {
		return brNo;
	}
	public void setBrNo(String brNo) {
		this.brNo = brNo;
	}
	public String getAppDate() {
		return appDate;
	}
	public void setAppDate(String appDate) {
		this.appDate = appDate;
	}
	public String getCifName() {
		return cifName;
	}
	public void setCifName(String cifName) {
		this.cifName = cifName;
	}
	public String getIdType() {
		return idType;
	}
	public void setIdType(String idType) {
		this.idType = idType;
	}
	public String getIdNo() {
		return idNo;
	}
	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getChkDesc() {
		return chkDesc;
	}
	public void setChkDesc(String chkDesc) {
		this.chkDesc = chkDesc;
	}
	public String getCzAuth() {
		return czAuth;
	}
	public void setCzAuth(String czAuth) {
		this.czAuth = czAuth;
	}
	public String getCzId() {
		return czId;
	}
	public void setCzId(String czId) {
		this.czId = czId;
	}
	public String getCzPactNo() {
		return czPactNo;
	}
	public void setCzPactNo(String czPactNo) {
		this.czPactNo = czPactNo;
	}
	public String getCrpReason() {
		return crpReason;
	}
	public void setCrpReason(String crpReason) {
		this.crpReason = crpReason;
	}

}
