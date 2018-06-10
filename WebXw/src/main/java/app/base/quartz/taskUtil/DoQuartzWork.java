package app.base.quartz.taskUtil;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import app.base.SourceTemplate;
import app.base.quartz.entity.ScheduleJob;
import app.creditapp.sys.bo.SchedulejobLogBo;
import app.creditapp.sys.bo.impl.SchedulejobLogBoImpl;
import app.creditapp.sys.entity.SchedulejobLog;
import app.util.User;

public class DoQuartzWork implements Job{

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		ScheduleJob scheduleJob = (ScheduleJob) context.getMergedJobDataMap().get("scheduleJob");
		SchedulejobLogBo schedulejobLogBo = new SchedulejobLogBoImpl();
		SchedulejobLog schedulejobLog = new SchedulejobLog();
		schedulejobLog.setArgumentsstr(scheduleJob.getArgumentsStr());
		schedulejobLog.setBeanClass(scheduleJob.getBeanClass());
		schedulejobLog.setCreateTime(User.getTime());
		schedulejobLog.setJobDescription(scheduleJob.getDescription());
		schedulejobLog.setJobName(scheduleJob.getJobName());
		schedulejobLog.setMethodName(scheduleJob.getMethodName());
		schedulejobLog.setSpringId(scheduleJob.getSpringId());
		schedulejobLogBo.insert(schedulejobLog);
		System.out.println("ִ�ж�ʱ����  = [ �������ƣ�" + scheduleJob.getJobName() + "]");
		System.out.println("ִ�ж�ʱ����  = [ ����������" + scheduleJob.getDescription() + "]");
		System.out.println("ִ�ж�ʱ����  = [ ִ��ʱ�䣺" + new Date().toString() + "]");
		System.out.println("ִ�ж�ʱ����  = [ ִ�ж���" + scheduleJob.getBeanClass() + "]");
		System.out.println("ִ�ж�ʱ����  = [ ִ�з�����" + scheduleJob.getMethodName() + "]");
		System.out.println("=================����ִ�п�ʼ==========================");
		try {
			doJobWork(scheduleJob);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private void doJobWork(ScheduleJob scheduleJob) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, ClassNotFoundException{
		Object obj =  SourceTemplate.getSpringContextInstance().getBean(scheduleJob.getSpringId());
		if(scheduleJob.getArguments()==null || scheduleJob.getArguments().length==0){//�޲���ʱֱ�ӵ��ø÷���
			Method workMethod = obj.getClass().getDeclaredMethod(scheduleJob.getMethodName());
			workMethod.invoke(obj);
		}else{
			//�в���ʱ���������������жϲ����б���������������Ƿ����
			//PS��������˳��ǳ���Ҫ��
			Method[] workMethods = obj.getClass().getMethods();
			for(Method method:workMethods){
				if(scheduleJob.getMethodName().equals(method.getName()) && (scheduleJob.getArguments().length == method.getParameterTypes().length )){
					method.invoke(obj, scheduleJob.getArguments());
					break;
				}
			}
		}
		System.out.println("=================����ִ�н���==========================");
	}
	
	public void test(String sdaa,int dda,double dasdas){
		
	}
	
}
