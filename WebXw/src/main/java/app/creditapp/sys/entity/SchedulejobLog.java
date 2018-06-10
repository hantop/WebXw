package app.creditapp.sys.entity;
import app.base.BaseDomain;
/**
* Title: SchedulejobLog.java
* Description:
* @version��1.0
**/
public class SchedulejobLog extends BaseDomain {
	private String logId;//log_id
	private String createTime;//ִ��ʱ�䣬��ȷ����:YYYYMMDD HH24:MI:SS
	private String jobName;//ִ����������
	private String jobDescription;//ִ�������Ҫ����
	private String beanClass;//ִ�еķ�����ϸ·��
	private String methodName;//ִ�з�������
	private String springId;//ִ�е�spring����
	private String argumentsstr;//ִ�еĲ�������

	/**
	 * @return log_id
	 */
	public String getLogId() {
	 	return logId;
	}
	/**
	 * @���� log_id
	 * @param logId
	 */
	public void setLogId(String logId) {
	 	this.logId = logId;
	}
	/**
	 * @return ִ��ʱ�䣬��ȷ����:YYYYMMDD HH24:MI:SS
	 */
	public String getCreateTime() {
	 	return createTime;
	}
	/**
	 * @���� ִ��ʱ�䣬��ȷ����:YYYYMMDD HH24:MI:SS
	 * @param createTime
	 */
	public void setCreateTime(String createTime) {
	 	this.createTime = createTime;
	}
	/**
	 * @return ִ����������
	 */
	public String getJobName() {
	 	return jobName;
	}
	/**
	 * @���� ִ����������
	 * @param jobName
	 */
	public void setJobName(String jobName) {
	 	this.jobName = jobName;
	}
	/**
	 * @return ִ�������Ҫ����
	 */
	public String getJobDescription() {
	 	return jobDescription;
	}
	/**
	 * @���� ִ�������Ҫ����
	 * @param jobDescription
	 */
	public void setJobDescription(String jobDescription) {
	 	this.jobDescription = jobDescription;
	}
	/**
	 * @return ִ�еķ�����ϸ·��
	 */
	public String getBeanClass() {
	 	return beanClass;
	}
	/**
	 * @���� ִ�еķ�����ϸ·��
	 * @param beanClass
	 */
	public void setBeanClass(String beanClass) {
	 	this.beanClass = beanClass;
	}
	/**
	 * @return ִ�з�������
	 */
	public String getMethodName() {
	 	return methodName;
	}
	/**
	 * @���� ִ�з�������
	 * @param methodName
	 */
	public void setMethodName(String methodName) {
	 	this.methodName = methodName;
	}
	/**
	 * @return ִ�е�spring����
	 */
	public String getSpringId() {
	 	return springId;
	}
	/**
	 * @���� ִ�е�spring����
	 * @param springId
	 */
	public void setSpringId(String springId) {
	 	this.springId = springId;
	}
	/**
	 * @return ִ�еĲ�������
	 */
	public String getArgumentsstr() {
	 	return argumentsstr;
	}
	/**
	 * @���� ִ�еĲ�������
	 * @param argumentsstr
	 */
	public void setArgumentsstr(String argumentsstr) {
	 	this.argumentsstr = argumentsstr;
	}
}