package app.base.quartz.entity;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import app.base.BaseDomain;


public class ScheduleJob extends BaseDomain implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6420298152382952718L;
	private Long jobId;//��ʱ��������
	private String opNo;//��ز���Ա���
	private String createTime;//����ʱ��
	private String updateTime;//�޸�ʱ��
	private String jobName;//��������
	private String jobGroup;//�������
	private String jobStatus;//����״̬��1-������0-ֹͣ
	private String cronExpression;//ʱ����ʽ
	private String description;//����˵��
	private String beanClass;//����ִ��ʱ�����ĸ���ķ��� ����+����
	private String isConcurrent;//�����Ƿ���״̬
	private String springId;//spring��ID��ʶ
	private String methodName;//���õķ�����
	private String startTime;//��ʼʱ��
	private String endTime;//����ʱ��
	private Integer repeatCount;//�ظ�\����
	private Long repeatInterval;//���ʱ��
	private String argumentsStr;//��������
	private String userName; //����Ա����
	private String allTime;//���ʱ�䣨δ����
	private String mode;//��ʱģʽ���죬�ܣ��£���
	private String timingTime;//��ʱģʽ���죬�ܣ��£��������ʱ�䣨δ����
	private String week;//���ܶ�ʱ
	private String jobTaskName;//Ԥ����������
	//�������� by 7.04
	private String triggerType;//1-simpleTrigger��2-CronTrigger
	
	
	
	public String getTriggerType() {
		return triggerType;
	}

	public void setTriggerType(String triggerType) {
		this.triggerType = triggerType;
	}

	public String getArgumentsStr() {
		return argumentsStr;
	}

	public void setArgumentsStr(String argumentsStr) {
		this.argumentsStr = argumentsStr;
	}

	public void setRepeatCount(Integer repeatCount) {
		this.repeatCount = repeatCount;
	}

	public void setRepeatInterval(Long repeatInterval) {
		this.repeatInterval = repeatInterval;
	}

	/**
	 * methodName�п��ܻ�ʹ�õĲ����б�
	 */
	private Object[] arguments;
	
	public String getOpNo() {
		return opNo;
	}

	public void setOpNo(String opNo) {
		this.opNo = opNo;
	}

	public Object[] getArguments() {
		if(this.arguments!=null && this.arguments.length != 0)
			return this.arguments;
		else if(this.argumentsStr!=null && !this.argumentsStr.isEmpty()){
			String[] initArgsArray = argumentsStr.split(",");
			arguments = new Object[initArgsArray.length];
			for(int index = 0; index<initArgsArray.length; index++){
				if(initArgsArray[index].indexOf(":") != -1){//����ð�ţ����ɷ���ö�������
					String[] secArgsArray = initArgsArray[index].split(":");
						try {
							if(secArgsArray[0].equalsIgnoreCase("String")){
								arguments[index] =secArgsArray[1];
							}else if( secArgsArray[0].equalsIgnoreCase("Integer")
								|| secArgsArray[0].equalsIgnoreCase("Double")
								||secArgsArray[0].equalsIgnoreCase("Float")
								||secArgsArray[0].equalsIgnoreCase("Long")
								||secArgsArray[0].equalsIgnoreCase("Short")
								||secArgsArray[0].equalsIgnoreCase("Boolean")){
								secArgsArray[0] = secArgsArray[0].substring(0, 1).toUpperCase() + secArgsArray[0].substring(1).toLowerCase();
								Class<?> clazz = Class.forName("java.lang."+secArgsArray[0]);
								Method valueOfMethod = clazz.getDeclaredMethod("valueOf", String.class);
								arguments[index] = valueOfMethod.invoke(clazz,secArgsArray[1] );
							}else{
								arguments[index] = Class.forName(secArgsArray[0]).newInstance();
							}
						} catch (ClassNotFoundException e) {
							e.printStackTrace();
						} catch (NoSuchMethodException e) {
							e.printStackTrace();
						} catch (SecurityException e) {
							e.printStackTrace();
						} catch (IllegalAccessException e) {
							e.printStackTrace();
						} catch (IllegalArgumentException e) {
							e.printStackTrace();
						} catch (InvocationTargetException e) {
							e.printStackTrace();
						} catch (InstantiationException e) {
							e.printStackTrace();
						}
				}else{//��������ð�ţ������ֵ�ĸ�ʽ�жϳ���Ӧ������
					if(initArgsArray[index].startsWith("\"")){
						arguments[index] = initArgsArray[index].replaceAll("\"", "");
					}else if(initArgsArray[index].indexOf(".") != -1){
						arguments[index] = Double.valueOf(initArgsArray[index]);
					}else if(initArgsArray[index].equalsIgnoreCase("true") || initArgsArray[index].equalsIgnoreCase("false")){
						arguments[index] = Boolean.valueOf(initArgsArray[index]);
					}else {
						arguments[index] = Integer.valueOf(initArgsArray[index]);
					}
				}
			}
			return arguments;
		}else{
			return null;
		}
	}
	
	public void setArguments(Object[] arguments) {
		this.arguments = arguments;
	}

	public long getRepeatInterval() {
		if(this.repeatInterval == null)this.repeatInterval = 0L;
		return repeatInterval;
	}

	public void setRepeatInterval(long repeatInterval) {
		this.repeatInterval = repeatInterval;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public Integer getRepeatCount() {
		if(this.repeatCount == null)this.repeatCount = 0;
		return repeatCount;
	}

	public void setRepeatCount(int repeatCount) {
		this.repeatCount = repeatCount;
	}

	public Long getJobId() {
		return jobId;
	}

	public void setJobId(Long jobId) {
		this.jobId = jobId;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
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

	public String getJobStatus() {
		return jobStatus;
	}

	public void setJobStatus(String jobStatus) {
		this.jobStatus = jobStatus;
	}

	public String getCronExpression() {
		return cronExpression;
	}

	public void setCronExpression(String cronExpression) {
		this.cronExpression = cronExpression;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getBeanClass() {
		return beanClass;
	}

	public void setBeanClass(String beanClass) {
		this.beanClass = beanClass;
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
	
	public static void main(String[] args) {
		ScheduleJob job = new ScheduleJob();
		job.setArgumentsStr("\"haha\",98,Double:34.12,long:44,\"21\"");
		for(Object ob:job.getArguments()){
			System.out.println(ob.toString());
		}
//		System.out.println(Boolean.valueOf("tRuE"));
	}
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAllTime() {
		return allTime;
	}

	public void setAllTime(String allTime) {
		this.allTime = allTime;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public String getTimingTime() {
		return timingTime;
	}

	public void setTimingTime(String timingTime) {
		this.timingTime = timingTime;
	}

	public String getWeek() {
		return week;
	}

	public void setWeek(String week) {
		this.week = week;
	}

	public String getJobTaskName() {
		return jobTaskName;
	}

	public void setJobTaskName(String jobTaskName) {
		this.jobTaskName = jobTaskName;
	}
	
}
