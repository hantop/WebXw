package app.creditapp.inf.client.entity;

public class RuleReturn {
	
	private String codeName;//Ҫ��
	private String codeDes;//ָ��
	private String codeValue;//��������
	private String codeRes;//���
	private String codeResDes;//�������
	private Double score;//�������
	
	public String getCodeResDes() {
		return codeResDes;
	}
	public void setCodeResDes(String codeResDes) {
		this.codeResDes = codeResDes;
	}
	public String getCodeName() {
		return codeName;
	}
	public void setCodeName(String codeName) {
		this.codeName = codeName;
	}
	public String getCodeDes() {
		return codeDes;
	}
	public void setCodeDes(String codeDes) {
		this.codeDes = codeDes;
	}
	public String getCodeValue() {
		return codeValue;
	}
	public void setCodeValue(String codeValue) {
		this.codeValue = codeValue;
	}
	public String getCodeRes() {
		return codeRes;
	}
	public void setCodeRes(String codeRes) {
		this.codeRes = codeRes;
	}
	public Double getScore() {
		return score;
	}
	public void setScore(Double score) {
		this.score = score;
	}


}
