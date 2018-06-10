package app.creditapp.sys.entity;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import app.base.BaseDomain;
/**
* Title: ScheduleTask.java
* Description:
* @version��1.0
**/
public class ScheduleTask extends BaseDomain {
	private Integer seId;//��ʱ����Ԥ��ID
	private String opNo;//����ԱID
	private String createTime;//����ʱ��
	private String updateTime;//�޸�ʱ��
	private String jobName;//��������
	private String jobGroup;//�������
	private String jobStatus;//��������״̬ 1-������0-δ����
	private String description;//��ע˵��
	private String isConcurrent;//�����Ƿ���״̬
	private String springId;//���õ�springID
	private String methodName;//���õķ�������
	private String beanClass;//�������ȫ·����ַ
	private String argumentsStr;//��������
	private String opName;//����ԱID
	private String tcId;//����ID
	/**
	 * methodName�п��ܻ�ʹ�õĲ����б�
	 */
	private Object[] arguments;
	
	private String templateName;//����ģ�����ֻ�ȡ��Ҫ�����ģ������
	
	public String getTemplateName() {
		return templateName;
	}
	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}
	/**
	 * @return ��ʱ����Ԥ��ID
	 */
	public Integer getSeId() {
	 	return seId;
	}
	/**
	 * @���� ��ʱ����Ԥ��ID
	 * @param seId
	 */
	public void setSeId(Integer seId) {
	 	this.seId = seId;
	}
	/**
	 * @return ����ԱID
	 */
	public String getOpNo() {
	 	return opNo;
	}
	/**
	 * @���� ����ԱID
	 * @param opNo
	 */
	public void setOpNo(String opNo) {
	 	this.opNo = opNo;
	}
	/**
	 * @return ����ʱ��
	 */
	public String getCreateTime() {
	 	return createTime;
	}
	/**
	 * @���� ����ʱ��
	 * @param createTime
	 */
	public void setCreateTime(String createTime) {
	 	this.createTime = createTime;
	}
	/**
	 * @return �޸�ʱ��
	 */
	public String getUpdateTime() {
	 	return updateTime;
	}
	/**
	 * @���� �޸�ʱ��
	 * @param updateTime
	 */
	public void setUpdateTime(String updateTime) {
	 	this.updateTime = updateTime;
	}
	/**
	 * @return ��������
	 */
	public String getJobName() {
	 	return jobName;
	}
	/**
	 * @���� ��������
	 * @param jobName
	 */
	public void setJobName(String jobName) {
	 	this.jobName = jobName;
	}
	/**
	 * @return �������
	 */
	public String getJobGroup() {
	 	return jobGroup;
	}
	/**
	 * @���� �������
	 * @param jobGroup
	 */
	public void setJobGroup(String jobGroup) {
	 	this.jobGroup = jobGroup;
	}
	/**
	 * @return ��������״̬ 1-������0-δ����
	 */
	public String getJobStatus() {
	 	return jobStatus;
	}
	/**
	 * @���� ��������״̬ 1-������0-δ����
	 * @param jobStatus
	 */
	public void setJobStatus(String jobStatus) {
	 	this.jobStatus = jobStatus;
	}
	/**
	 * @return ��ע˵��
	 */
	public String getDescription() {
	 	return description;
	}
	/**
	 * @���� ��ע˵��
	 * @param description
	 */
	public void setDescription(String description) {
	 	this.description = description;
	}
	/**
	 * @return �����Ƿ���״̬
	 */
	public String getIsConcurrent() {
	 	return isConcurrent;
	}
	/**
	 * @���� �����Ƿ���״̬
	 * @param isConcurrent
	 */
	public void setIsConcurrent(String isConcurrent) {
	 	this.isConcurrent = isConcurrent;
	}
	/**
	 * @return ���õ�springID
	 */
	public String getSpringId() {
	 	return springId;
	}
	/**
	 * @���� ���õ�springID
	 * @param springId
	 */
	public void setSpringId(String springId) {
	 	this.springId = springId;
	}
	/**
	 * @return ���õķ�������
	 */
	public String getMethodName() {
	 	return methodName;
	}
	/**
	 * @���� ���õķ�������
	 * @param methodName
	 */
	public void setMethodName(String methodName) {
	 	this.methodName = methodName;
	}
	/**
	 * @return �������ȫ·����ַ
	 */
	public String getBeanClass() {
	 	return beanClass;
	}
	/**
	 * @���� �������ȫ·����ַ
	 * @param beanClass
	 */
	public void setBeanClass(String beanClass) {
	 	this.beanClass = beanClass;
	}
	public String getOpName() {
		return opName;
	}
	public void setOpName(String opName) {
		this.opName = opName;
	}
	public String getTcId() {
		return tcId;
	}
	public void setTcId(String tcId) {
		this.tcId = tcId;
	}
	public String getArgumentsStr() {
		return argumentsStr;
	}
	public void setArgumentsStr(String argumentsStr) {
		this.argumentsStr = argumentsStr;
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
}