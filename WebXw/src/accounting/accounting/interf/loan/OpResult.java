package accounting.interf.loan;


public class OpResult {

	private String authNo;//��Ȩ���
	private Boolean bl;//�ɹ���־
	private String idNo;//��ˮ��
	private String msg;//������ʾ��Ϣ
	private String type;//�ӿڴ���
	
	
	public Boolean getBl() {
		return bl;
	}
	public void setBl(Boolean bl) {
		this.bl = bl;
	}
	public String getIdNo() {
		return idNo;
	}
	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getAuthNo() {
		return authNo;
	}
	public void setAuthNo(String authNo) {
		this.authNo = authNo;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
}
