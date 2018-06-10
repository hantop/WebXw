package  app.creditapp.sys.bo;

import java.util.List;

import app.base.DAOException;
import app.base.ServiceException;
import app.util.toolkit.Ipage;

import app.creditapp.sys.entity.ScheduleTask;
import app.creditapp.sys.entity.TransContr;

/**
* Title: ScheduleTaskBo.java
* Description:
**/
public interface ScheduleTaskBo {

	public ScheduleTask getById(ScheduleTask scheduleTask) throws ServiceException;

	public void del(ScheduleTask scheduleTask) throws ServiceException;

	public void insert(ScheduleTask scheduleTask) throws ServiceException;

	public void update(ScheduleTask scheduleTask) throws ServiceException;
	
	public void updateTaskSts(ScheduleTask scheduleTask) throws ServiceException;
	
	public Ipage findByPage(Ipage ipg, ScheduleTask scheduleTask) throws ServiceException;
	/**
	 * ��ѯ���õ�Ԥ������
	 */
	public List<ScheduleTask> findStartTask() throws ServiceException;
	/**
	 * ����Ԥ�������붨ʱ����
	 * @param seId
	 * @param tcId
	 * @throws ServiceException
	 */
	public void updateTimeController(String seId, String tcId) throws ServiceException;
	/**
	 * @param timeController
	 * ��Ҫ����Ĳ���:Ԥ������ID,
	 * 					 ��������,���ʱ��,�ظ�����,��ʼʱ��
	 * ���ز���ID
	 */
	public Integer getTaskAndCon(TransContr transContr)throws ServiceException;
	/**
	 * �������������ID
	 * @param tcId
	 */
	public void delController(Integer tcId)throws ServiceException;
	

}