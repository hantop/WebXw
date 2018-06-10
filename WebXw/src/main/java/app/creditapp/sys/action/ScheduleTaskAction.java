package  app.creditapp.sys.action;
import java.util.List;
import app.util.User;
import org.apache.struts2.ServletActionContext;
import app.util.toolkit.Ipage;
import app.base.quartz.entity.ScheduleJob;
import app.base.quartz.taskUtil.QuartzTaskWork;
import app.creditapp.sys.bo.ScheduleTaskBo;
import app.creditapp.sys.bo.TimeControllerBo;
import app.creditapp.sys.bo.impl.ScheduleTaskBoImpl;
import app.creditapp.sys.entity.ScheduleTask;
import app.creditapp.sys.entity.TimeController;
import app.creditapp.sys.entity.TransContr;

import com.core.domain.screen.FormData;
import com.core.service.screen.FormService;
import com.core.struts.ActionContext;
import com.core.struts.BaseFormBean;

/**
 * Title: ScheduleTaskAction.java
 * Description:
 **/
public class ScheduleTaskAction extends BaseFormBean {

	//ҳ�洫ֵ
	private ScheduleTask scheduleTask;
	private TimeController timeController;
	private ScheduleJob scheduleJob;
	private List<ScheduleTask> scheduleTaskList;
	private List<TimeController> timeControllerList;
	private QuartzTaskWork taskScheduleUtil;
	//ע��ScheduleTaskBo
	private ScheduleTaskBo scheduleTaskBo;
	private TimeControllerBo timeControllerBo;
	private String query;
	private Integer seId;	
	private Integer tcId;//����ID����
	private FormData formsys0115;
	private FormData formsys0116;
	private FormService formService = new FormService();
	private Object[] arguments;
	
	public ScheduleTaskAction() {
		query = "";
	}
	/**
	 * ��ҳ��ѯ
	 * @return
	 * @throws Exception
	 */
	public String findByPage() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),ServletActionContext.getResponse());
		formsys0115 = formService.getFormData("sys0115");
		scheduleTask = new ScheduleTask();
		getFormValue(formsys0115);
		setObjValue(formsys0115, scheduleTask);
		scheduleTask.setSeId(seId);
		Ipage ipage = this.getIpage();
		scheduleTaskList = (List) scheduleTaskBo.findByPage(ipage, scheduleTask).getResult();
		return "list";
	}
	
	
	/**
	 * ��ȡ����ҳ��
	 * @return
	 * @throws Exception
	 */
	public String input() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formsys0116 = formService.getFormData("sys0116");
		scheduleTask = new ScheduleTask();
		scheduleTask.setCreateTime(User.getSys_date(getHttpRequest()));
		scheduleTask.setUpdateTime(User.getSys_date(getHttpRequest()));
		getObjValue(formsys0116, scheduleTask);
		return "input";
	}
	
	/**
	 * �����������
	 * @return
	 * @throws Exception
	 */
	public String insert() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formsys0116 = formService.getFormData("sys0116");
		getFormValue(formsys0116);
		scheduleTask = new ScheduleTask();
		setObjValue(formsys0116, scheduleTask);
		try {
			scheduleTask.setArguments(arguments);
			scheduleTask.getArguments();
		} catch (Exception e) {
			this.addActionError("����ʧ�ܣ�������ʽ����");
			e.printStackTrace();
			return "detail";
		}
		scheduleTask.setOpNo(User.getTlrno(this.getHttpRequest()));
		scheduleTask.setCreateTime(User.getSys_date(getHttpRequest()));
		scheduleTask.setUpdateTime(User.getSys_date(getHttpRequest()));
		scheduleTask.setJobStatus("0");
		scheduleTaskBo.insert(scheduleTask);
		getObjValue(formsys0116, scheduleTask);
		this.addActionError("������ʱ����ɹ���");
		return "detail";
	}
	
	
	/**
	 * �޸ı������
	 * @return
	 * @throws Exception
	 */
	public String update() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formsys0116 = formService.getFormData("sys0116");
		getFormValue(formsys0116);
		scheduleTask = new ScheduleTask();
		setObjValue(formsys0116, scheduleTask);
		try {
			scheduleTask.setArguments(arguments);
			scheduleTask.getArguments();
		} catch (Exception e) {
			this.addActionError("�޸�ʧ�ܣ�������ʽ����");
			e.printStackTrace();
			return "detail";
		}
		scheduleTask.setUpdateTime(User.getSys_date(getHttpRequest()));
		scheduleTaskBo.update(scheduleTask);
		getObjValue(formsys0116, scheduleTask);
		return "detail";
	}
	/**
	 * ����Ԥ������
	 */
	public String start()throws Exception{
		ActionContext.initialize(ServletActionContext.getRequest(),ServletActionContext.getResponse());
		formsys0115 = formService.getFormData("sys0115");
		Ipage ipage = this.getIpage();
		scheduleTask = new ScheduleTask();
		scheduleTask.setJobStatus("1");
		scheduleTask.setSeId(seId);
		scheduleTaskBo.updateTaskSts(scheduleTask);
		scheduleTaskList = (List) scheduleTaskBo.findByPage(ipage, new ScheduleTask()).getResult();
		return "start";
	}
	/**
	 * ͣ��Ԥ������
	 */
	public String stop()throws Exception{
		ActionContext.initialize(ServletActionContext.getRequest(),ServletActionContext.getResponse());
		formsys0115 = formService.getFormData("sys0115");
		Ipage ipage = this.getIpage();
		scheduleTask = new ScheduleTask();
		scheduleTask.setJobStatus("0");
		scheduleTask.setSeId(seId);
		scheduleTaskBo.updateTaskSts(scheduleTask);
		
		timeController = new TimeController();
		timeController.setStId(seId);
		timeController.setTcState("0");
		timeControllerBo.updateTimeSts(timeController);
		timeController = new TimeController();
		scheduleTask = new ScheduleTask();
		scheduleTask.setSeId(seId);
		scheduleTask = scheduleTaskBo.getById(scheduleTask);
		timeController.setStId(seId);
		timeControllerList = timeControllerBo.getByStId(timeController);
		scheduleJob = new ScheduleJob();
		scheduleJob.setJobGroup(scheduleTask.getJobGroup());
		String tcName = "";
		for(int i=0;i<timeControllerList.size();i++){//ͣ��Ԥ����������ж�ʱ����
			tcName = timeControllerList.get(i).getTcName();
			scheduleJob.setJobName(tcName);
			taskScheduleUtil.deleteTaskJob(scheduleJob);
		}
		scheduleTaskList = (List) scheduleTaskBo.findByPage(ipage, new ScheduleTask()).getResult();
		return "stop";
		
	}
	
	/**
	 * ɾ������
	 * @return
	 * @throws Exception
	 */
	public String del() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formsys0115 = formService.getFormData("sys0115");
		scheduleTask = new ScheduleTask();
		scheduleTask.setSeId(seId);
		scheduleTask = scheduleTaskBo.getById(scheduleTask);
		if(scheduleTask.getTemplateName()==null){//�ж��Ƿ�Ϊϵͳ����
			scheduleTaskBo.del(scheduleTask);
			timeController = new TimeController();
			timeController.setStId(seId);
			timeControllerList = timeControllerBo.getByStId(timeController);
			for(int i=0;i<timeControllerList.size();i++){//ɾ��Ԥ������ʱ���¹����Ĳ���
				timeController = new TimeController();
				timeController = timeControllerList.get(i);
				timeController.setStId(null);
				timeControllerBo.update(timeController);
			}
			this.addActionMessage("ɾ���ɹ�");
		}else{
			this.addActionMessage("�˲���Ϊϵͳ�����޷�ɾ��");
		}
		scheduleTask = new ScheduleTask();
		Ipage ipage = this.getIpage();
		scheduleTaskList = (List) scheduleTaskBo.findByPage(ipage, scheduleTask).getResult();
		return "list";
	}

	
	/**
	 * ��ѯ����
	 * @return
	 * @throws Exception
	 */
	public String getById() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),ServletActionContext.getResponse());
		formsys0116 = formService.getFormData("sys0116");
		scheduleTask = new ScheduleTask();
		scheduleTask.setSeId(seId);
		scheduleTask = scheduleTaskBo.getById(scheduleTask);
		getObjValue(formsys0116, scheduleTask);
		return "detail";
	}
	
	/**
	 * �����������У��
	 * @return
	 * @throws Exception
	 */
	public void validateInsert(){
		 ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		 formsys0116 = formService.getFormData("sys0116");
		 getFormValue(formsys0116);
		 validateFormData(formsys0116);
   	}
   
	/**
	 * �޸ı������У��
	 * @return
	 * @throws Exception
	 */
	public void validateUpdate(){
		 ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		 formsys0116 = formService.getFormData("sys0116");
		 getFormValue(formsys0116);
		 validateFormData(formsys0116);
  	}
	public ScheduleTask getScheduleTask() {
		return scheduleTask;
	}
	public void setScheduleTask(ScheduleTask  scheduleTask) {
		this.scheduleTask = scheduleTask;
	}
	public List<ScheduleTask> getScheduleTaskList() {
		return scheduleTaskList;
	}
	public void setScheduleTaskList(List<ScheduleTask> scheduleTaskList) {
		this.scheduleTaskList = scheduleTaskList;
	}
	public ScheduleTaskBo getScheduleTaskBo() {
		return scheduleTaskBo;
	}
	public void setScheduleTaskBo(ScheduleTaskBo scheduleTaskBo) {
		this.scheduleTaskBo = scheduleTaskBo;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public FormData getFormsys0116() {
		return formsys0116;
	}
	public void setFormsys0116(FormData formsys0116) {
		this.formsys0116 = formsys0116;
	}
	public FormData getFormsys0115() {
		return formsys0115;
	}
	public void setFormsys0115(FormData formsys0115) {
		this.formsys0115 = formsys0115;
	}
	public void setSeId(Integer seId){
		this.seId = seId;
	}		
	public Integer getSeId(){
		return seId;
	}
	public Integer getTcId() {
		return tcId;
	}
	public void setTcId(Integer tcId) {
		this.tcId = tcId;
	}
	public TimeControllerBo getTimeControllerBo() {
		return timeControllerBo;
	}
	public void setTimeControllerBo(TimeControllerBo timeControllerBo) {
		this.timeControllerBo = timeControllerBo;
	}
	public TimeController getTimeController() {
		return timeController;
	}
	public void setTimeController(TimeController timeController) {
		this.timeController = timeController;
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
	public List<TimeController> getTimeControllerList() {
		return timeControllerList;
	}
	public void setTimeControllerList(List<TimeController> timeControllerList) {
		this.timeControllerList = timeControllerList;
	}
	public Object[] getArguments() {
		return arguments;
	}
	public void setArguments(Object[] arguments) {
		this.arguments = arguments;
	}
}