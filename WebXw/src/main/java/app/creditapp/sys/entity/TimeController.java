package app.creditapp.sys.entity;
import app.base.BaseDomain;
/**
* Title: TimeController.java
* Description:
* @version��1.0
**/
public class TimeController extends BaseDomain {
	private Integer tcId;//ID����
	private String tcName;//��������
	private String tcState;//��ʱ�����Ƿ��Ѿ����� 1-���� 0-δ����
	private String cronExpression;//ʱ����ʽ
	private String startTime;//��ʼʱ��
	private String endTime;//����ʱ��
	private Integer repeatCount;//�ظ�����(���999)
	private Long repeatInterval;//���ʱ��
	private String timingtime;//������ʾ�Ķ�ʱģʽ
	private String triggerType;//1-simpleTrigger;2-CronTrigger
	private String repeatIntTime;//δ����ļ��ʱ��
	private String jobMode;//job_mode
	private String week;//���ܶ�ʱ
	private Integer stId;//��Ӧ��Ԥ������ID
	private String jobName;//��Ӧ��Ԥ����������
	
	
	private String jobGroup;//�������
	private String isConcurrent;//�����Ƿ���״̬
	private String springId;//���õ�springID
	private String methodName;//���õķ�������
	private String beanClass;//�������ȫ·����ַ
	private String argumentsStr;//��������

	/**
	 * @return ID����
	 */
	public Integer getTcId() {
	 	return tcId;
	}
	/**
	 * @���� ID����
	 * @param tcId
	 */
	public void setTcId(Integer tcId) {
	 	this.tcId = tcId;
	}
	public String getTcName() {
		return tcName;
	}
	public void setTcName(String tcName) {
		this.tcName = tcName;
	}
	/**
	 * @return ��ʱ�����Ƿ��Ѿ����� 1-���� 0-δ����
	 */
	public String getTcState() {
	 	return tcState;
	}
	/**
	 * @���� ��ʱ�����Ƿ��Ѿ����� 1-���� 0-δ����
	 * @param tcState
	 */
	public void setTcState(String tcState) {
	 	this.tcState = tcState;
	}
	/**
	 * @return ʱ����ʽ
	 */
	public String getCronExpression() {
	 	return cronExpression;
	}
	/**
	 * @���� ʱ����ʽ
	 * @param cronExpression
	 */
	public void setCronExpression(String cronExpression) {
	 	this.cronExpression = cronExpression;
	}
	/**
	 * @return ��ʼʱ��
	 */
	public String getStartTime() {
	 	return startTime;
	}
	/**
	 * @���� ��ʼʱ��
	 * @param startTime
	 */
	public void setStartTime(String startTime) {
	 	this.startTime = startTime;
	}
	/**
	 * @return ����ʱ��
	 */
	public String getEndTime() {
	 	return endTime;
	}
	/**
	 * @���� ����ʱ��
	 * @param endTime
	 */
	public void setEndTime(String endTime) {
	 	this.endTime = endTime;
	}
	/**
	 * @return �ظ�����(���999)
	 */
	public Integer getRepeatCount() {
	 	return repeatCount;
	}
	/**
	 * @���� �ظ�����(���999)
	 * @param repeatCount
	 */
	public void setRepeatCount(Integer repeatCount) {
	 	this.repeatCount = repeatCount;
	}
	/**
	 * @return ���ʱ��
	 */
	
	public void setRepeatInterval(Long repeatInterval) {
		this.repeatInterval = repeatInterval;
	}
	/**
	 * @���� ���ʱ��
	 * @param repeatInterval
	 */
	public Long getRepeatInterval() {
		return repeatInterval;
	}
	/**
	 * @return ������ʾ�Ķ�ʱģʽ
	 */
	public String getTimingtime() {
	 	return timingtime;
	}
	/**
	 * @���� ������ʾ�Ķ�ʱģʽ
	 * @param timingtime
	 */
	public void setTimingtime(String timingtime) {
	 	this.timingtime = timingtime;
	}
	/**
	 * @return 1-simpleTrigger;2-CronTrigger
	 */
	public String getTriggerType() {
	 	return triggerType;
	}
	/**
	 * @���� 1-simpleTrigger;2-CronTrigger
	 * @param triggerType
	 */
	public void setTriggerType(String triggerType) {
	 	this.triggerType = triggerType;
	}
	/**
	 * @return δ����ļ��ʱ��
	 */
	public String getRepeatIntTime() {
		return repeatIntTime;
	}
	
	public void setRepeatIntTime(String repeatIntTime) {
		this.repeatIntTime = repeatIntTime;
	}
	/**
	 * @return job_mode
	 */
	public String getJobMode() {
	 	return jobMode;
	}
	
	/**
	 * @���� job_mode
	 * @param jobMode
	 */
	public void setJobMode(String jobMode) {
	 	this.jobMode = jobMode;
	}
	/**
	 * @return ���ܶ�ʱ
	 */
	public String getWeek() {
	 	return week;
	}
	/**
	 * @���� ���ܶ�ʱ
	 * @param week
	 */
	public void setWeek(String week) {
	 	this.week = week;
	}
	
	/**
	 * @return ��Ӧ��Ԥ������ID
	 */
	public Integer getStId() {
	 	return stId;
	}
	/**
	 * @���� ��Ӧ��Ԥ������ID
	 * @param stId
	 */
	public void setStId(Integer stId) {
	 	this.stId = stId;
	}
	public String getJobName() {
		return jobName;
	}
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	public String getJobGroup() {
		return jobGroup;
	}
	public void setJobGroup(String jobGroup) {
		this.jobGroup = jobGroup;
	}
	public String getIsConcurrent() {
		return isConcurrent;
	}
	public void setIsConcurrent(String isConcurrent) {
		this.isConcurrent = isConcurrent;
	}
	public String getSpringId() {
		return springId;
	}
	public void setSpringId(String springId) {
		this.springId = springId;
	}
	public String getMethodName() {
		return methodName;
	}
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
	public String getBeanClass() {
		return beanClass;
	}
	public void setBeanClass(String beanClass) {
		this.beanClass = beanClass;
	}
	public String getArgumentsStr() {
		return argumentsStr;
	}
	public void setArgumentsStr(String argumentsStr) {
		this.argumentsStr = argumentsStr;
	}
}