package app.creditapp.sys.entity;

public class TransContr {

	private Integer seId;//Ԥ������ID
	private String tcName;//��������
	private Integer repeatTime;//���ʱ��
	private Integer repeatCount;//�ظ�����
	private String startTime;//��ʼʱ��
	private String endTime;//����ʱ��
	
	private String argumentsStr;//��������
	
	public String getArgumentsStr() {
		return argumentsStr;
	}
	public void setArgumentsStr(String argumentsStr) {
		this.argumentsStr = argumentsStr;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public Integer getSeId() {
		return seId;
	}
	public void setSeId(Integer seId) {
		this.seId = seId;
	}
	public String getTcName() {
		return tcName;
	}
	public void setTcName(String tcName) {
		this.tcName = tcName;
	}

	public Integer getRepeatCount() {
		return repeatCount;
	}
	public void setRepeatCount(Integer repeatCount) {
		this.repeatCount = repeatCount;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public Integer getRepeatTime() {
		return repeatTime;
	}
	public void setRepeatTime(Integer repeatTime) {
		this.repeatTime = repeatTime;
	}

}
