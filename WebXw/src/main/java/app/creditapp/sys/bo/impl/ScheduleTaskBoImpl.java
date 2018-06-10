package  app.creditapp.sys.bo.impl;

import java.text.ParseException;
import java.util.List;

import org.quartz.SchedulerException;

import app.base.BaseService;
import app.base.ServiceException;
import app.base.quartz.entity.ConExpTransType;
import app.base.quartz.entity.ScheduleJob;
import app.base.quartz.taskUtil.QuartzTaskWork;
import app.base.quartz.taskUtil.TimeToCronUtil;
import app.util.toolkit.Ipage;
import app.creditapp.sys.bo.ScheduleTaskBo;
import app.creditapp.sys.dao.ScheduleTaskDao;
import app.creditapp.sys.dao.TimeControllerDao;
import app.creditapp.sys.entity.ScheduleTask;
import app.creditapp.sys.entity.TimeController;
import app.creditapp.sys.entity.TransContr;
/**
* Title: ScheduleTaskBoImplImpl.java
* Description:
**/
public class ScheduleTaskBoImpl extends BaseService implements ScheduleTaskBo {

	private ScheduleTaskDao scheduleTaskDao;
	private ScheduleTask scheduleTask;
	private TimeController timeController;
	private TimeControllerDao timeControllerDao;
	private ScheduleJob scheduleJob;
	private QuartzTaskWork taskScheduleUtil;
	public void del(ScheduleTask scheduleTask) throws ServiceException {
		try {
			scheduleTaskDao.del(scheduleTask);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}

	public Ipage findByPage(Ipage ipg, ScheduleTask scheduleTask)
			throws ServiceException {
		try {
			ipg.initPageCounts(new Integer[] { (Integer) scheduleTaskDao
					.getCount(scheduleTask) });// ��ʼ����ҳ��
			scheduleTask.setStartNumAndEndNum (ipg);
			ipg.setResult(scheduleTaskDao.findByPage(scheduleTask));
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return ipg;
	}

	public ScheduleTask getById(ScheduleTask scheduleTask) throws ServiceException {
		try {
			scheduleTask = scheduleTaskDao.getById(scheduleTask);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return scheduleTask;
	}

	public void insert(ScheduleTask scheduleTask) throws ServiceException {
		try {
			scheduleTaskDao.insert(scheduleTask);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}

	public void update(ScheduleTask scheduleTask) throws ServiceException {
		try {
			scheduleTaskDao.update(scheduleTask);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}
	/**
	 * ����Ԥ�������붨ʱ����
	 */
	@Override
	public void updateTimeController(String seId, String tcId)
			throws ServiceException {
		try {
			scheduleTaskDao.updateTimeController(seId, tcId);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		
	}
	/**
	 * ����Ԥ������״̬
	 */
	@Override
	public void updateTaskSts(ScheduleTask scheduleTask)
			throws ServiceException {
		try {
			scheduleTaskDao.updateTaskSts(scheduleTask);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		
	}
	/**
	 * ��ѯ���õ�Ԥ������
	 */
	@Override
	public List<ScheduleTask> findStartTask() throws ServiceException {
		List<ScheduleTask> scheduleTaskList = null;
		scheduleTask = new ScheduleTask();
		try {
			scheduleTask.setJobStatus("1");
			scheduleTaskList = scheduleTaskDao.findStartTask(scheduleTask);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return scheduleTaskList;
	}
	/**
	 * @param timeController
	 * ��Ҫ����Ĳ���:Ԥ������ID,
	 * 					 ��������,���ʱ��,�ظ�����,��ʼʱ��
	 * ���ز���ID
	 */
	public Integer getTaskAndCon(TransContr transContr){
		
		timeController = new TimeController();
		timeController.setStId(transContr.getSeId());
		timeController.setTcName(transContr.getTcName());
		timeController.setRepeatCount(transContr.getRepeatCount());
		timeController.setRepeatInterval(toRepeatInterval(transContr.getRepeatTime()));
		timeController.setStartTime(transContr.getStartTime());
		timeController.setEndTime(transContr.getEndTime());
		timeController.setTriggerType("1");
		timeController.setTcState("1");
		int tcId = timeControllerDao.insert(timeController);//�����Դ������ݿ�
		//if(tcId == -1)
		
		scheduleTask = new ScheduleTask();
		scheduleTask.setSeId(transContr.getSeId());
		scheduleTask = scheduleTaskDao.getById(scheduleTask);//��ѯԤ��������Ϣ
		
		scheduleJob = new ScheduleJob();
		scheduleJob.setJobGroup(scheduleTask.getJobGroup());
		scheduleJob.setBeanClass(scheduleTask.getBeanClass());
		scheduleJob.setSpringId(scheduleTask.getSpringId());
		scheduleJob.setMethodName(scheduleTask.getMethodName());
//		scheduleJob.setJobName(String.valueOf(tcId));
		scheduleJob.setJobName(scheduleTask.getJobName());
		scheduleJob.setTriggerType("1");//���ģʽ
		scheduleJob.setJobStatus("1");//����״̬
		scheduleJob.setRepeatCount(timeController.getRepeatCount());
		scheduleJob.setRepeatInterval(timeController.getRepeatInterval());
		scheduleJob.setStartTime(timeController.getStartTime());
		scheduleJob.setEndTime(timeController.getEndTime());
		scheduleJob.setArgumentsStr(transContr.getArgumentsStr());
		try {
			taskScheduleUtil.addOrUpdateJob(scheduleJob);
		} catch (SchedulerException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return timeController.getTcId();
	}
	/**
	 * ɾ������
	 * �������������ID
	 * @param tcId
	 */
	public void delController(Integer tcId){
		timeController = new TimeController();
		timeController.setTcId(tcId);
		timeController = timeControllerDao.findGroupAndName(timeController);//��ѯ�������ƺ��������
		
		scheduleJob = new ScheduleJob();
		scheduleJob.setJobGroup(timeController.getJobGroup());
		scheduleJob.setJobName(String.valueOf(tcId));
		try {
			timeController.setTcId(tcId);
			taskScheduleUtil.deleteTaskJob(scheduleJob);//ֹͣ����
			timeControllerDao.del(timeController);//ɾ������
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}
	/**
	 * ת��Ϊ���ʱ��
	 * @param long1
	 * @return
	 */
	public Long toRepeatInterval(Integer value){
		int intervalArgs[] = new int[7];
		intervalArgs[0] = value;
		return TimeToCronUtil.intervalToCron(intervalArgs);
	}
	public ScheduleTaskDao getScheduleTaskDao() {
		return scheduleTaskDao;
	}

	public void setScheduleTaskDao(ScheduleTaskDao scheduleTaskDao) {
		this.scheduleTaskDao = scheduleTaskDao;
	}

	public ScheduleTask getScheduleTask() {
		return scheduleTask;
	}

	public void setScheduleTask(ScheduleTask scheduleTask) {
		this.scheduleTask = scheduleTask;
	}

	public TimeController getTimeController() {
		return timeController;
	}

	public void setTimeController(TimeController timeController) {
		this.timeController = timeController;
	}
	public TimeControllerDao getTimeControllerDao() {
		return timeControllerDao;
	}

	public void setTimeControllerDao(TimeControllerDao timeControllerDao) {
		this.timeControllerDao = timeControllerDao;
	}

	public ScheduleJob getScheduleJob() {
		return scheduleJob;
	}

	public void setScheduleJob(ScheduleJob scheduleJob) {
		this.scheduleJob = scheduleJob;
	}

	public QuartzTaskWork getTaskScheduleUtil() {
		return taskScheduleUtil;
	}

	public void setTaskScheduleUtil(QuartzTaskWork taskScheduleUtil) {
		this.taskScheduleUtil = taskScheduleUtil;
	}
	 public static void main(String[] args) {
//			System.out.println(TimeToCronUtil.intervalToCron(2,3,12,4,56,3));
//	    	String[] arrays = {"1",null,null,null,null,null,null};//ÿ����3��5��12��
//	    	System.out.println(toRepeatInterval(1));
//	    	String[] arrays = {"3","5","12"};//ÿ����3��5��12��
//	    	String rs = TimeToCronUtil.transArrayToStr(arrays);
//	    	System.out.println(rs);
		}
	
}