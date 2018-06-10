package  app.creditapp.sys.action;
import java.util.Arrays;
import java.util.List;

import app.util.User;

import org.apache.struts2.ServletActionContext;

import app.util.toolkit.Ipage;
import app.base.quartz.entity.ConExpTransType;
import app.base.quartz.entity.ScheduleJob;
import app.base.quartz.taskUtil.QuartzTaskWork;
import app.base.quartz.taskUtil.TimeToCronUtil;
import app.creditapp.sys.bo.ScheduleTaskBo;
import app.creditapp.sys.bo.TimeControllerBo;
import app.creditapp.sys.entity.ScheduleTask;
import app.creditapp.sys.entity.TimeController;

import com.core.domain.screen.FormData;
import com.core.service.screen.FormService;
import com.core.struts.ActionContext;
import com.core.struts.BaseFormBean;

/**
 * Title: TimeControllerAction.java
 * Description:
 **/
public class TimeControllerAction extends BaseFormBean {

	//ҳ�洫ֵ
	private TimeController timeController;
	private ScheduleTask scheduleTask;
	private ScheduleJob scheduleJob;
	private List<TimeController> timeControllerList;

	//ע��TimeControllerBo
	private ScheduleTaskBo scheduleTaskBo;
	private TimeControllerBo timeControllerBo;

	private String query;
	private String tcName;//��������
	private Integer tcId;	
	private Integer stId;
	private FormData formsys0113;
	private FormData formsys0114;
	private QuartzTaskWork taskScheduleUtil;
	private FormService formService = new FormService();
	
	private String tcState;//��ʱ����״̬
	private String trigerType;//��ʱģʽ
	private String[] intervalTime;//���ʱ��
	private Integer repeatCount;//�ظ�����
	private String intervalStartTime;//���ģʽ��ʼʱ��
	private String intervalEndTime;//���ģʽ����ʱ��
	private String timingStartTime;//��ʱģʽ��ʼʱ��
	private String timingEndTime;//��ʱģʽ����ʱ��
	private String timingMode;//��ʱģʽ���� ʱ �� �� �� �꣩
	private String timMin;//��
	private String timHour;//ʱ
	private String hourTime;//ʱ
	private String dayHourTime;//���춨ʱСʱ
	private String dayMinTime;//���춨ʱ����
	private String timDay;//��
	private String[] week;//�� 
	private String timMonth;//�� 
	private String[] timYear;//��
	
	public TimeControllerAction() {
		query = "";
	}
	/**
	 * ��ҳ��ѯ
	 * @return
	 * @throws Exception
	 */
	public String findByPage() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),ServletActionContext.getResponse());
		formsys0113 = formService.getFormData("sys0113");
		timeController = new TimeController();
		getFormValue(formsys0113);
		setObjValue(formsys0113, timeController);
		timeController.setTcId(tcId);
		timeController.setStId(stId);
		Ipage ipage = this.getIpage();
		timeControllerList = (List) timeControllerBo.findByPage(ipage, timeController).getResult();
		return "list";
	}
	
	
	/**
	 * ��ȡ����ҳ��
	 * @return
	 * @throws Exception
	 */
	public String input() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formsys0114 = formService.getFormData("sys0114");
		return "input";
	}
	/**
	 * �����������
	 * @return
	 * @throws Exception
	 */
	public String insert() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		timeController = new TimeController();
		timeController = timing();
		timeControllerBo.insert(timeController);
		this.addActionMessage("��ʱ���������ɹ���");
		return "detail";
	}
	/**
	 * @param timeController
	 * @return
	 */
	public TimeController timing(){
		if("1".equals(trigerType)){//���ģʽ
			timeController.setRepeatIntTime(Arrays.toString(intervalTime).replaceAll("\\[", "").replaceAll("\\]", "").replaceAll(" ", ""));//���ʱ��
			timeController.setStartTime(intervalStartTime);
			timeController.setRepeatCount(repeatCount);
			int intervalArgs[] = new int[intervalTime.length];
			//��������ʱ����====>��ʱ����������
			for(int i=3;i<intervalTime.length;i++){
				intervalArgs[i-3] = Integer.parseInt(intervalTime[i]);
			}
			intervalArgs[4] = Integer.parseInt(intervalTime[2]);
			intervalArgs[5] = Integer.parseInt(intervalTime[1]);
			intervalArgs[6] = Integer.parseInt(intervalTime[0]);
			timeController.setRepeatInterval(TimeToCronUtil.intervalToCron(intervalArgs));
		}else if("2".equals(trigerType)){//��ʱģʽ
			dayHourTime = timingStartTime.substring(11, 13);
			dayMinTime = timingStartTime.substring(14, 16);
			String[][] dateArrays = new String[7][];
//			dateArrays[1] = new String[]{dayHourTime};//ÿ��N��Сʱ
//			dateArrays[2] = new String[]{dayMinTime};//ÿ��N�����
			String timeConExpression = "";
			if("0".equals(timingMode)){//��ÿ����ִ��
				dateArrays[2] = new String[]{timMin};
				timeConExpression = TimeToCronUtil.transConExpression(dateArrays, ConExpTransType.BY_TIMES);
			}else if("1".equals(timingMode)){//��Сʱִ��
				dateArrays[1] = new String[]{timHour};//ÿ��N��Сʱ
				dateArrays[2] = new String[]{hourTime};//ÿ��N��Сʱ
				timeConExpression = TimeToCronUtil.transConExpression(dateArrays, ConExpTransType.BY_HOUR);
			}else if("2".equals(timingMode)){//������ִ��
				dateArrays[0] = new String[]{timDay};//ÿ��N��
				dateArrays[1] = new String[]{dayHourTime};//ÿ��N��Сʱ
				dateArrays[2] = new String[]{dayMinTime};//ÿ��N�����
				timeConExpression = TimeToCronUtil.transConExpression(dateArrays, ConExpTransType.BY_DAY);
			}else if("3".equals(timingMode)){//����ִ��
				dateArrays[1] = new String[]{dayHourTime};//ÿ��N��Сʱ
				dateArrays[2] = new String[]{dayMinTime};//ÿ��N�����
				dateArrays[4] = week;//ÿ�ܵ��ļ���
				timeConExpression = TimeToCronUtil.transConExpression(dateArrays, ConExpTransType.BY_WEEK);
			}else if("4".equals(timingMode)){//����ִ��
				dateArrays[1] = new String[]{dayHourTime};//ÿ��N��Сʱ
				dateArrays[2] = new String[]{dayMinTime};//ÿ��N�����
				dateArrays[0] = new String[]{timMonth};//ÿ�µĵ�N��
				timeConExpression = TimeToCronUtil.transConExpression(dateArrays, ConExpTransType.BY_MONTH);
			}else if("5".equals(timingMode)){//����ִ��
				dateArrays[0] = new String[]{timYear[1]};//ÿ�µĵ�N��
				dateArrays[5] = new String[]{timYear[0]};//ÿ��ĵ�N����
				timeConExpression = TimeToCronUtil.transConExpression(dateArrays, ConExpTransType.BY_YEAR);
			}
//			dateArrays[3] = null;//��
			timeController.setJobMode(timingMode);
			timeController.setCronExpression(timeConExpression);
			timeController.setRepeatCount(0);
			timeController.setRepeatInterval(null);
			StringBuilder timingTiming = new StringBuilder();
			//�꣨�£��գ�+��+��+ʱ+��+ÿСʱ���֣����ڷ���
			timeController.setRepeatIntTime(timingTiming.append(arrayToStr(timYear)).append(",").append(timMonth).append(",").append(timDay).append(",").append(timHour).append(",").append(timMin).append(",").append(hourTime).toString());
			timeController.setWeek(arrayToStr(week));
			
			timeController.setStartTime(timingStartTime);
		}
		timeController.setTcState(tcState);//����״̬
		timeController.setStId(stId);
		timeController.setTcName(tcName);
		timeController.setTriggerType(trigerType);//��ʱģʽ
//		this.addActionMessage("������ʱ���Գɹ���");
		return timeController;
	}
	/**
	 * ����ת��Ϊ�ַ���
	 * @param arr
	 * @return
	 */
	public String arrayToStr(String[] arr){
		return Arrays.toString(arr).replaceAll("\\[", "").replaceAll("\\]", "").replaceAll(" ", "");
	}
	/**
	 * �޸ı������
	 * @return
	 * @throws Exception
	 */
	public String update() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		timeController = new TimeController();
		timeController = timing();
		timeController.setTcId(tcId);
		timeControllerBo.update(timeController);
		timeController = timeControllerBo.getById(timeController);
		this.addActionMessage("��ʱ�����޸ĳɹ���");
		return "detail";
	}
	
	
	
	/**
	 * ɾ������
	 * @return
	 * @throws Exception
	 */
	public String del() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formsys0113 = formService.getFormData("sys0113");
		timeController = new TimeController();
		timeController.setTcId(tcId);
		timeControllerBo.del(timeController);
		this.addActionMessage("��ʱ����ɾ���ɹ�");
		timeController = new TimeController();
		Ipage ipage = this.getIpage();
		timeControllerList = (List) timeControllerBo.findByPage(ipage, timeController).getResult();
		return "list";
	}

	
	/**
	 * ��ѯ����
	 * @return
	 * @throws Exception
	 */
	public String getById() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),ServletActionContext.getResponse());
		timeController = new TimeController();
		timeController.setTcId(tcId);
		timeController = timeControllerBo.getById(timeController);
		return "detail";
	}
	/**
	 * ������ʱ����
	 * @return
	 * @throws Exception
	 */
	public String start()throws Exception {
		timeController = new TimeController();
		timeController.setTcId(tcId);
		timeController = timeControllerBo.getById(timeController);
		if(timeController.getStId()==null){//��ʱ�����Ƿ����Ԥ������
			this.addActionMessage("�����Ԥ������֮����������ʱ����");
		}else{
			scheduleTask = new ScheduleTask();
			scheduleTask.setSeId(timeController.getStId());
			scheduleTask = scheduleTaskBo.getById(scheduleTask);
			if("0".equals(scheduleTask.getJobStatus())){//Ԥ�������Ƿ�����
				this.addActionMessage("��������Ԥ������֮����������ʱ����");
			}else{
				scheduleJob = new ScheduleJob();
				scheduleJob.setJobName(String.valueOf(timeController.getTcId()));
				scheduleJob.setJobTaskName(scheduleTask.getJobName());
				scheduleJob.setJobGroup(scheduleTask.getJobGroup());
				scheduleJob.setBeanClass(scheduleTask.getBeanClass());
				scheduleJob.setSpringId(scheduleTask.getSpringId());
				scheduleJob.setArgumentsStr(scheduleTask.getArgumentsStr());
				scheduleJob.setMethodName(scheduleTask.getMethodName());
				scheduleJob.setTriggerType(timeController.getTriggerType());
				scheduleJob.setCronExpression(timeController.getCronExpression());
				scheduleJob.setRepeatCount(timeController.getRepeatCount());
				scheduleJob.setRepeatInterval(timeController.getRepeatInterval());
				scheduleJob.setJobStatus("1");
				scheduleJob.setStartTime(timeController.getStartTime());
				scheduleJob.setEndTime(timeController.getEndTime());
				scheduleJob.setDescription(scheduleTask.getDescription());
				taskScheduleUtil.addOrUpdateJob(scheduleJob);//��������¶�ʱ����
				timeController.setTcState("1");//�Ѳ���״̬��Ϊ����
				timeControllerBo.startTimeSts(timeController);
			}
		}
//		findByPage();
		formsys0113 = formService.getFormData("sys0113");
		TimeController timeController1 = new TimeController();
		getFormValue(formsys0113);
		setObjValue(formsys0113, timeController1);
		Ipage ipage = this.getIpage();
		timeControllerList = (List) timeControllerBo.findByPage(ipage, timeController1).getResult();
		return "start";
	}
	/**
	 * ֹͣ��ʱ����
	 * @return
	 * @throws Exception
	 */
	public String stop()throws Exception {
		timeController = new TimeController();
		timeController.setTcId(tcId);
		timeController = timeControllerBo.getById(timeController);
		scheduleTask = new ScheduleTask();
		scheduleTask.setSeId(timeController.getStId());
		scheduleTask = scheduleTaskBo.getById(scheduleTask);
		scheduleJob = new ScheduleJob();
		scheduleJob.setJobName(String.valueOf(timeController.getTcId()));//����ID�������ƣ���ֹ�����ظ�
		scheduleJob.setJobGroup(scheduleTask.getJobGroup());//Ԥ������group
		taskScheduleUtil.deleteTaskJob(scheduleJob);//ɾ����ʱ����
		timeController.setTcState("0");//�Ѳ���״̬��Ϊֹͣ
		timeControllerBo.startTimeSts(timeController);
		timeController = new TimeController();
		timeController.setTcId(tcId);
//		findByPage();
		formsys0113 = formService.getFormData("sys0113");
		TimeController timeController1 = new TimeController();
		getFormValue(formsys0113);
		setObjValue(formsys0113, timeController1);
		Ipage ipage = this.getIpage();
		timeControllerList = (List) timeControllerBo.findByPage(ipage, timeController1).getResult();
		return "stop";
	}
	/**
	 * �����������У��
	 * @return
	 * @throws Exception
	 */
	public void validateInsert(){
		 ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		 formsys0114 = formService.getFormData("sys0114");
		 getFormValue(formsys0114);
		 System.out.println(timingStartTime.length());
		 if(!"".equals(timingStartTime) ||timingStartTime != null){
			 String[] arr1 = timingStartTime.split(" ");
			 String[] arr = arr1[1].split(":");
			 if(Integer.parseInt(arr[0]) >=24){
				 this.addActionError("��ʼʱ�䣺СʱӦС��24");
			 }
			 if(Integer.parseInt(arr[1]) >=60){
				 this.addActionError("��ʼʱ�䣺����ӦС��60");
			 }
		 }
		 if(timingStartTime.length()== 16 || intervalStartTime.length() == 16){
			 
		 }else {
			 this.addActionError("��������ȷ�Ŀ�ʼʱ��");
		 }
		 validateFormData(formsys0114);
   	}
   
	/**
	 * �޸ı������У��
	 * @return
	 * @throws Exception
	 */
	public void validateUpdate(){
		 ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		 formsys0114 = formService.getFormData("sys0114");
		 getFormValue(formsys0114);
		 if(!"".equals(timingStartTime) ||timingStartTime != null){
			 String[] arr1 = timingStartTime.split(" ");
			 String[] arr = arr1[1].split(":");
			 if(Integer.parseInt(arr[0]) >=24){
				 this.addActionError("��ʼʱ�䣺СʱӦС��24");
			 }
			 if(Integer.parseInt(arr[1]) >=60){
				 this.addActionError("��ʼʱ�䣺����ӦС��60");
			 }
		 }
		 if(timingStartTime.length()== 16 || intervalStartTime.length() == 16){
			 
		 }else {
			 this.addActionError("��������ȷ�Ŀ�ʼʱ��");
		 }
		 validateFormData(formsys0114);
  	}
	public TimeController getTimeController() {
		return timeController;
	}
	public void setTimeController(TimeController  timeController) {
		this.timeController = timeController;
	}
	public List<TimeController> getTimeControllerList() {
		return timeControllerList;
	}
	public void setTimeControllerList(List<TimeController> timeControllerList) {
		this.timeControllerList = timeControllerList;
	}
	public TimeControllerBo getTimeControllerBo() {
		return timeControllerBo;
	}
	public void setTimeControllerBo(TimeControllerBo timeControllerBo) {
		this.timeControllerBo = timeControllerBo;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public FormData getFormsys0114() {
		return formsys0114;
	}
	public void setFormsys0114(FormData formsys0114) {
		this.formsys0114 = formsys0114;
	}
	public FormData getFormsys0113() {
		return formsys0113;
	}
	public void setFormsys0113(FormData formsys0113) {
		this.formsys0113 = formsys0113;
	}
	public void setTcId(Integer tcId){
		this.tcId = tcId;
	}		
	public Integer getTcId(){
		return tcId;
	}
	public FormService getFormService() {
		return formService;
	}
	public void setFormService(FormService formService) {
		this.formService = formService;
	}
	public String getTcState() {
		return tcState;
	}
	public void setTcState(String tcState) {
		this.tcState = tcState;
	}
	public String getTrigerType() {
		return trigerType;
	}
	public void setTrigerType(String trigerType) {
		this.trigerType = trigerType;
	}
	public String[] getIntervalTime() {
		return intervalTime;
	}
	public void setIntervalTime(String[] intervalTime) {
		this.intervalTime = intervalTime;
	}
	public Integer getRepeatCount() {
		return repeatCount;
	}
	public void setRepeatCount(Integer repeatCount) {
		this.repeatCount = repeatCount;
	}
	public String getIntervalStartTime() {
		return intervalStartTime;
	}
	public void setIntervalStartTime(String intervalStartTime) {
		this.intervalStartTime = intervalStartTime;
	}
	public String getIntervalEndTime() {
		return intervalEndTime;
	}
	public void setIntervalEndTime(String intervalEndTime) {
		this.intervalEndTime = intervalEndTime;
	}
	public String getTimingStartTime() {
		return timingStartTime;
	}
	public void setTimingStartTime(String timingStartTime) {
		this.timingStartTime = timingStartTime;
	}
	public String getTimingEndTime() {
		return timingEndTime;
	}
	public void setTimingEndTime(String timingEndTime) {
		this.timingEndTime = timingEndTime;
	}
	public String getTimingMode() {
		return timingMode;
	}
	public void setTimingMode(String timingMode) {
		this.timingMode = timingMode;
	}
	public String getTimMin() {
		return timMin;
	}
	public void setTimMin(String timMin) {
		this.timMin = timMin;
	}
	public String getTimHour() {
		return timHour;
	}
	public void setTimHour(String timHour) {
		this.timHour = timHour;
	}
	public String getHourTime() {
		return hourTime;
	}
	public void setHourTime(String hourTime) {
		this.hourTime = hourTime;
	}
	public String getTimDay() {
		return timDay;
	}
	public void setTimDay(String timDay) {
		this.timDay = timDay;
	}
	public String[] getWeek() {
		return week;
	}
	public void setWeek(String[] week) {
		this.week = week;
	}
	public String getTimMonth() {
		return timMonth;
	}
	public void setTimMonth(String timMonth) {
		this.timMonth = timMonth;
	}
	public String[] getTimYear() {
		return timYear;
	}
	public void setTimYear(String[] timYear) {
		this.timYear = timYear;
	}
	public ScheduleTask getScheduleTask() {
		return scheduleTask;
	}
	public void setScheduleTask(ScheduleTask scheduleTask) {
		this.scheduleTask = scheduleTask;
	}
	public ScheduleTaskBo getScheduleTaskBo() {
		return scheduleTaskBo;
	}
	public void setScheduleTaskBo(ScheduleTaskBo scheduleTaskBo) {
		this.scheduleTaskBo = scheduleTaskBo;
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
	public String getTcName() {
		return tcName;
	}
	public Integer getStId() {
		return stId;
	}
	public void setStId(Integer stId) {
		this.stId = stId;
	}
	public void setTcName(String tcName) {
		this.tcName = tcName;
	}
	public String getDayHourTime() {
		return dayHourTime;
	}
	public void setDayHourTime(String dayHourTime) {
		this.dayHourTime = dayHourTime;
	}
	public String getDayMinTime() {
		return dayMinTime;
	}
	public void setDayMinTime(String dayMinTime) {
		this.dayMinTime = dayMinTime;
	}
}