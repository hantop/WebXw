package app.creditapp.sys.entity;
import app.base.BaseDomain;
/**
* Title: DailyEvent.java
* Description:
* @version��1.0
**/
public class DailyEvent extends BaseDomain {
	private String eventId;//�¼�ID��Ψһ
	private String title;//�¼�����
	private String startTime;//��ʼʱ�䣨��ȷ���֣�
	private String endTime;//����ʱ�䣨��ȷ���֣�
	private String allDay;//�Ƿ�Ϊȫ���¼���0-��1-��)
	private Integer repeat;//�������
	private String repeatEndDate;//�ظ��¼���ֹʱ��
	private String impLevel;//��������
	private String url;//���URL
	private String seId;//������Ԥ������ID
	private String taskId;//�����Ĳ���ID
	private String eventdesc;//�����Ĳ���ID
	private String argumentsStr;//��������
	
	private String userId;//�����Ĳ�����
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getArgumentsStr() {
		return argumentsStr;
	}
	public void setArgumentsStr(String argumentsStr) {
		this.argumentsStr = argumentsStr;
	}
	public String getTaskId() {
		return taskId;
	}
	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}
	public String getSeId() {
		return seId;
	}
	public void setSeId(String seId) {
		this.seId = seId;
	}
	/**
	 * @return �¼�ID��Ψһ
	 */
	public String getEventId() {
	 	return eventId;
	}
	/**
	 * @���� �¼�ID��Ψһ
	 * @param eventId
	 */
	public void setEventId(String eventId) {
	 	this.eventId = eventId;
	}
	/**
	 * @return �¼�����
	 */
	public String getTitle() {
	 	return title;
	}
	/**
	 * @���� �¼�����
	 * @param title
	 */
	public void setTitle(String title) {
	 	this.title = title;
	}
	/**
	 * @return ��ʼʱ�䣨��ȷ���֣�
	 */
	public String getStartTime() {
	 	return startTime;
	}
	/**
	 * @���� ��ʼʱ�䣨��ȷ���֣�
	 * @param startTime
	 */
	public void setStartTime(String startTime) {
	 	this.startTime = startTime;
	}
	/**
	 * @return ����ʱ�䣨��ȷ���֣�
	 */
	public String getEndTime() {
	 	return endTime;
	}
	/**
	 * @���� ����ʱ�䣨��ȷ���֣�
	 * @param endTime
	 */
	public void setEndTime(String endTime) {
	 	this.endTime = endTime;
	}
	/**
	 * @return �Ƿ�Ϊȫ���¼���0-��1-��)
	 */
	public String getAllDay() {
	 	return allDay;
	}
	/**
	 * @���� �Ƿ�Ϊȫ���¼���0-��1-��)
	 * @param allDay
	 */
	public void setAllDay(String allDay) {
	 	this.allDay = allDay;
	}
	/**
	 * @return �������
	 */
	public Integer getRepeat() {
	 	return repeat;
	}
	/**
	 * @���� �������
	 * @param repeat
	 */
	public void setRepeat(Integer repeat) {
	 	this.repeat = repeat;
	}
	/**
	 * @return �ظ��¼���ֹʱ��
	 */
	public String getRepeatEndDate() {
	 	return repeatEndDate;
	}
	/**
	 * @���� �ظ��¼���ֹʱ��
	 * @param repeatEndDate
	 */
	public void setRepeatEndDate(String repeatEndDate) {
	 	this.repeatEndDate = repeatEndDate;
	}
	/**
	 * @return ��������
	 */
	public String getImpLevel() {
	 	return impLevel;
	}
	/**
	 * @���� ��������
	 * @param impLevel
	 */
	public void setImpLevel(String impLevel) {
	 	this.impLevel = impLevel;
	}
	/**
	 * @return ���URL
	 */
	public String getUrl() {
	 	return url;
	}
	/**
	 * @���� ���URL
	 * @param url
	 */
	public void setUrl(String url) {
	 	this.url = url;
	}
	public String getEventdesc() {
		return eventdesc;
	}
	public void setEventdesc(String eventdesc) {
		this.eventdesc = eventdesc;
	}
	
}