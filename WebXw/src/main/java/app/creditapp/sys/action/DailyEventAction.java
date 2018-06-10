package  app.creditapp.sys.action;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import accounting.domain.sys.AcComHoliday;
import app.creditapp.acc.option.bo.AcComHolidayBo;
import app.creditapp.sys.bo.DailyEventBo;
import app.creditapp.sys.bo.ScheduleTaskBo;
import app.creditapp.sys.entity.DailyEvent;
import app.creditapp.sys.entity.ScheduleTask;
import app.creditapp.sys.entity.TransContr;
import app.oscache.CachecodeUtil;
import app.oscache.MBaseCache;
import app.util.User;

import com.core.service.screen.FormService;
import com.core.struts.BaseFormBean;

/**
 * Title: DailyEventAction.java
 * Description:
 **/
public class DailyEventAction extends BaseFormBean {

	//ҳ�洫ֵ
	private DailyEvent dailyEvent;
	private List<DailyEvent> dailyEventList;

	//ע��DailyEventBo
	private DailyEventBo dailyEventBo;
	
	public AcComHolidayBo getAcComHolidayBo() {
		return acComHolidayBo;
	}


	public void setAcComHolidayBo(AcComHolidayBo acComHolidayBo) {
		this.acComHolidayBo = acComHolidayBo;
	}

	public void setScheduleTaskBo(ScheduleTaskBo scheduleTaskBo) {
		this.scheduleTaskBo = scheduleTaskBo;
	}

	// ע��AcComHolidayBO
	private AcComHolidayBo acComHolidayBo ;
	private ScheduleTaskBo scheduleTaskBo ; 
	
	private String query;
	private FormService formService = new FormService();
	
	//��ȡҳ��������Ϣ
	private String eventId;
	private String title;
	private String start;
	private String end;
	private String allDay;
	private String repeatEndDate;
	private Integer repeat;
	private String impLevel;
	private String url;
	private String seId;
	private String templateName;
	private String argsObjs;
	
	private String eventJson;
	
	private List<AcComHoliday> acComHolidayList ;
	private List<ScheduleTask> scheduleTaskList;
	
	public DailyEventAction() {
		query = "";
	}
	
	
	public String initDailyView() throws Exception{
		dailyEvent = new DailyEvent();
		dailyEvent.setUserId(User.getLoginid(getHttpRequest()));
		List<DailyEvent> dailyEventList = dailyEventBo.findAllEvent(dailyEvent);
		StringBuilder eventBuilder = new StringBuilder();
		for(DailyEvent event:dailyEventList){
			eventBuilder.append("{");
			
			eventBuilder.append("eventId:").append("'").append(event.getEventId()).append("'");
			eventBuilder.append(",").append("title:").append("'").append(event.getTitle()).append("'");
			eventBuilder.append(",").append("start:").append("'").append(formatDate(event.getStartTime(), false)).append("'");
			eventBuilder.append(",").append("allDay:").append(event.getAllDay().equals("1"));
			eventBuilder.append(",").append("id:").append("'").append(event.getEventId()).append("'");
			
			//����IDû�Ž�ȥ
			//if(isNull(event))eventBuilder.append(",").append("end:").append("'").append(event.getEndTime()).append("'");
			if(isNull(event.getEndTime()))eventBuilder.append(",").append("end:").append("'").append(formatDate(event.getEndTime(),false)).append("'");
			if(isNull(event.getRepeat()))eventBuilder.append(",").append("repeat:").append(event.getRepeat());
			if(isNull(event.getRepeatEndDate()))eventBuilder.append(",").append("repeat_endDate:").append("'").append(formatDate(event.getRepeatEndDate(),false).substring(0, 10)).append("'");
			if(isNull(event.getImpLevel())){
				eventBuilder.append(",").append("impLevel:").append("'").append(event.getImpLevel()).append("'");
				eventBuilder.append(",").append("color:").append("'").append("#fff").append("'");
				eventBuilder.append(",").append("backImg:").append("'").append(getBackImgByImp(event.getImpLevel())).append("'");
			}
			if(isNull(event.getUrl()))eventBuilder.append(",").append("url:").append("'").append(event.getUrl()).append("'");
			if(isNull(event.getSeId()))eventBuilder.append(",").append("seId:").append("'").append(event.getSeId()).append("'");
			if(isNull(event.getTaskId()))eventBuilder.append(",").append("taskId:").append("'").append(event.getTaskId()).append("'");
			if(isNull(event.getArgumentsStr()))eventBuilder.append(",").append("argsObjs:").append("'").append(event.getArgumentsStr()).append("'");
			
			eventBuilder.append("},"); 
		}
		if(eventBuilder.length()>0)eventBuilder.deleteCharAt(eventBuilder.lastIndexOf(","));
		eventJson = "["+eventBuilder.toString()+"]";
		System.out.println(eventJson);
		getHttpRequest().setAttribute("eventJson", eventJson);
		//�ڼ���json
		String holidayJson = (String) MBaseCache.getCache().getBeanCache("holidayJson", CachecodeUtil.HOLIDAY_JSON);
		getHttpRequest().setAttribute("holidayJson", holidayJson);
		
		
		return "showDailyView";
	}
	
	public String initPendingPage(){
		scheduleTaskList = scheduleTaskBo.findStartTask();
		return "showPanding";
	}
	
	public String showInfoPage(){
		dailyEvent = new DailyEvent();
		dailyEvent.setEventId(eventId);
		dailyEvent = dailyEventBo.getById(dailyEvent);
		String showTime = dailyEvent.getStartTime().substring(0, 4) + "�� " + dailyEvent.getStartTime().substring(4, 6) +"�� " + dailyEvent.getStartTime().substring(6,8)+"��";
		dailyEvent.setStartTime(showTime);
		return "showInfoPage";
	}
	
	private boolean isNull(Object value){
		if(value!=null && String.valueOf(value).length()>0)return true;
		return false;
	}
	
	private String getBackImgByImp(String imp){
		if("1".equals(imp)){
			return "greenPoint.png";
		}else if("2".equals(imp)){
			return "yellowPoint.png";
		}else if("3".equals(imp)){
			return "redPoint.png";
		}
		return "greenPoint.png";
	}

	/*
	 *  <p id="repeat_p" style="display: none">
	    	<span class="spanTitle">����ʱ�䣺</span>
	    	<input type="text" readonly="readonly" class="input datepicker" name="repeatEndDate" id="repeatEndDate" value='' onclick="fPopUpCalendarDlg()">
		</p>
	 */
	public String createArgumentsTemplate() throws Exception{
		HttpServletResponse response = getHttpResponse();
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw = response.getWriter();
		StringBuilder templateStr = new StringBuilder();
		if(getTemplateName() == null){
			pw.write("");
			return null;
			
		}else if(getTemplateName().equals("loan")){//�ſ�  LoanBoImpl/grantLoan
			templateStr.append("<p >");
			templateStr.append("<span class='spanTitle'>��ݺ�:</span>");
			templateStr.append(" <input type='text' data-type='String' class='inputArg' required='required' />");
			templateStr.append("</p>");
		}else if(getTemplateName().equals("appro")){//Ԥ����    ProjAcctBoImpl/ virtual_AllocateReg
			
		}
		pw.write(templateStr.toString());
		return null;
	}
	
	
	/**
	 * ��ҳ��ѯ
	 * @return
	 * @throws Exception
	 */
	public String findByPage() throws Exception {
//		ActionContext.initialize(ServletActionContext.getRequest(),ServletActionContext.getResponse());
//		formdlevent0001 = formService.getFormData("dlevent0001");
//		dailyEvent = new DailyEvent();
//		getFormValue(formdlevent0001);
//		setObjValue(formdlevent0001, dailyEvent);
//		Ipage ipage = this.getIpage();
//		dailyEventList = (List) dailyEventBo.findByPage(ipage, dailyEvent).getResult();
		return "list";
	}
	
	
	/**
	 * ��ȡ����ҳ��
	 * @return
	 * @throws Exception
	 */
	public String input() throws Exception {
//		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
//		formdlevent0002 = formService.getFormData("dlevent0002");
		return "input";
	}
	
	/**
	 * �����������
	 * @return
	 * @throws Exception
	 */
	public String insert() throws Exception {
		HttpServletResponse response = getHttpResponse();
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw = response.getWriter();
		try {
			String expInfo = "";
			title =URLDecoder.decode(title, "UTF-8");
			dailyEvent = new DailyEvent();
			dailyEvent.setUserId(User.getLoginid(getHttpRequest()));
			dailyEvent.setTitle(title);
			dailyEvent.setStartTime(formatDate(start,true));
			dailyEvent.setEndTime(formatDate(end,true));
			dailyEvent.setAllDay("true".equals(allDay)?"1":"0");
			dailyEvent.setRepeat(repeat);
			dailyEvent.setRepeatEndDate(formatDate(repeatEndDate,true));
			dailyEvent.setImpLevel(impLevel);
			dailyEvent.setUrl(url);
			if(dailyEvent.getImpLevel().equals("2")){
				dailyEvent.setSeId(seId);
				String argumentsStr = inputArgsIntoEvent(getArgsObjs());
				Integer tcId = insertNewTaskAndGetTcId(dailyEvent,argumentsStr);
				dailyEvent.setTaskId(String.valueOf(tcId));
				dailyEvent.setArgumentsStr(getArgsObjs());
				expInfo = "|"+tcId+"|";
			}
			String eventId = dailyEventBo.insert(dailyEvent);
			
			pw.write("success|"+eventId+expInfo);//[0]-�ɹ���־[1]�¼�ID[2]����ID
		} catch (Exception e) {
			e.printStackTrace();
			pw.write("false");
		}
		
		return null;
	}
	
	private String inputArgsIntoEvent(String argsObjs){
		if(argsObjs!=null && !argsObjs.isEmpty()){
			String[] args = argsObjs.split("\\|");
			if(args.length > 0 && args[0].split("-").length>1 ){
				StringBuilder argsumentsStr = new StringBuilder();
				String templateName = args[0].split("-")[1];
				for(int index = 1;index < args.length; index++){
					argsumentsStr.append(args[index].split("-")[0]).append(":").append(args[index].split("-")[1]).append(",");
				}
				if(templateName.equals("loan")){//�ſ�
					
				}else if(templateName.equals("appro")){//Ԥ������Ҫ����Ӳ�������Ա��
					argsumentsStr.append("String:"+User.getLoginid(getHttpRequest())).append(",");
					argsumentsStr.append("String:100");
				}
				return argsumentsStr.toString();
			}
		}
		return "";
	}
	
	private Integer insertNewTaskAndGetTcId(DailyEvent event,String argumentsStr){
		TransContr tc = new TransContr();
		tc.setArgumentsStr(argumentsStr);//����Ĳ�����������ʹ��
		tc.setSeId(Integer.valueOf(event.getSeId()));
		tc.setTcName(event.getTitle());
		tc.setRepeatTime(event.getRepeat());
		tc.setStartTime(event.getStartTime()+"00");//������ĳ���
		tc.setEndTime(event.getEndTime()+"00");
		return scheduleTaskBo.getTaskAndCon(tc);
	}
	
	private String formatDate(String date, boolean toData) throws ParseException{
		if(date==null || "null".equals(date) || date.isEmpty())return null;
		SimpleDateFormat sdfToData = new SimpleDateFormat("yyyyMMddHHmm"); 
		SimpleDateFormat sdfToPage = new SimpleDateFormat("yyyy-MM-dd HH:mm"); 
		try {
			if(toData){//ת�������ݿ�
				if(date.length() == 10)date += " 00:00";
				return sdfToData.format(sdfToPage.parse(date));
			}else{
				return sdfToPage.format(sdfToData.parse(date));
			}
		} catch (ParseException e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	/**
	 * �޸ı������
	 * @return
	 * @throws Exception
	 */
	public String update() throws Exception {
		HttpServletResponse response = getHttpResponse();
		response.setContentType("text/html;charset=GBK");
		PrintWriter pw = response.getWriter();
		
		try {
			String expInfo = "";
			if(title!=null && !title.isEmpty()) title =URLDecoder.decode(title, "UTF-8");
			dailyEvent = new DailyEvent();
			dailyEvent.setUserId(User.getLoginid(getHttpRequest()));
			dailyEvent.setEventId(eventId);
			dailyEvent.setTitle(title);
			dailyEvent.setStartTime(formatDate(start,true));
			dailyEvent.setEndTime(formatDate(end,true));
			dailyEvent.setAllDay("true".equals(allDay)?"1":"0");
			dailyEvent.setRepeat(repeat);
			dailyEvent.setRepeatEndDate(formatDate(repeatEndDate,true));
			dailyEvent.setImpLevel(impLevel);
			dailyEvent.setUrl(url);
			if(dailyEvent.getImpLevel().equals("2")){//�޸�ʱ����ɾ������ȥ����Ϣ�����²���
				DailyEvent event = dailyEventBo.getById(dailyEvent);
				if(!(event.getTaskId()==null||"".equals(event.getTaskId()))){
					scheduleTaskBo.delController(Integer.valueOf(event.getTaskId()));
				}
				dailyEvent.setSeId(seId);
				String argumentsStr = inputArgsIntoEvent(getArgsObjs());
				Integer tcId = insertNewTaskAndGetTcId(dailyEvent,argumentsStr);
				dailyEvent.setTaskId(String.valueOf(tcId));
				dailyEvent.setArgumentsStr(getArgsObjs());
				expInfo = "|"+tcId+"|";
			}
			dailyEventBo.update(dailyEvent);
			
			pw.write("success|"+eventId+expInfo);
		} catch (Exception e) {
			e.printStackTrace();
			pw.write("false");
		}
		
		return null;
	}
	
	
	
	/**
	 * ɾ������
	 * @return
	 * @throws Exception
	 */
	public String del() throws Exception {
		HttpServletResponse response = getHttpResponse();
		response.setContentType("text/html;charset=GBK");
		PrintWriter pw = response.getWriter();
		dailyEvent = new DailyEvent();
		try {
			dailyEvent.setEventId(eventId);
			DailyEvent event = dailyEventBo.getById(dailyEvent);
			if(event.getImpLevel().equals("2")){
				scheduleTaskBo.delController(Integer.valueOf(event.getTaskId()));
			}
			dailyEventBo.del(dailyEvent);
			pw.write("success");
		} catch (Exception e) {
			pw.write("false");
			e.printStackTrace();
		}
		return null;
	}

	
	/**
	 * ��ѯ����
	 * @return
	 * @throws Exception
	 */
	public String getById() throws Exception {
//		ActionContext.initialize(ServletActionContext.getRequest(),ServletActionContext.getResponse());
//		formdlevent0002 = formService.getFormData("dlevent0002");
//		dailyEvent = new DailyEvent();
//		dailyEvent.setEventId(eventId);
//		dailyEvent = dailyEventBo.getById(dailyEvent);
//		getObjValue(formdlevent0002, dailyEvent);
		return "detail";
	}
	
	public String showDailyFrame() throws Exception {
//		ActionContext.initialize(ServletActionContext.getRequest(),ServletActionContext.getResponse());
		return "showDailyFrame";
	}
   
	public DailyEvent getDailyEvent() {
		return dailyEvent;
	}
	public void setDailyEvent(DailyEvent  dailyEvent) {
		this.dailyEvent = dailyEvent;
	}
	public List<DailyEvent> getDailyEventList() {
		return dailyEventList;
	}
	public void setDailyEventList(List<DailyEvent> dailyEventList) {
		this.dailyEventList = dailyEventList;
	}
	public DailyEventBo getDailyEventBo() {
		return dailyEventBo;
	}
	public void setDailyEventBo(DailyEventBo dailyEventBo) {
		this.dailyEventBo = dailyEventBo;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public void setEventId(String eventId){
		this.eventId = eventId;
	}		
	public String getEventId(){
		return eventId;
	}

	public FormService getFormService() {
		return formService;
	}


	public void setFormService(FormService formService) {
		this.formService = formService;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public String getAllDay() {
		return allDay;
	}

	public void setAllDay(String allDay) {
		this.allDay = allDay;
	}

	public String getRepeatEndDate() {
		return repeatEndDate;
	}

	public void setRepeatEndDate(String repeatEndDate) {
		this.repeatEndDate = repeatEndDate;
	}

	public Integer getRepeat() {
		return repeat;
	}

	public void setRepeat(Integer repeat) {
		this.repeat = repeat;
	}


	public String getImpLevel() {
		return impLevel;
	}

	public void setImpLevel(String impLevel) {
		this.impLevel = impLevel;
	}

	public String getEventJson() {
		return eventJson;
	}

	public void setEventJson(String eventJson) {
		this.eventJson = eventJson;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	public List<AcComHoliday> getAcComHolidayList() {
		return acComHolidayList;
	}

	public void setAcComHolidayList(List<AcComHoliday> acComHolidayList) {
		this.acComHolidayList = acComHolidayList;
	}
	
	public List<ScheduleTask> getScheduleTaskList() {
		return scheduleTaskList;
	}

	public void setScheduleTaskList(List<ScheduleTask> scheduleTaskList) {
		this.scheduleTaskList = scheduleTaskList;
	}

	public String getSeId() {
		return seId;
	}

	public void setSeId(String seId) {
		this.seId = seId;
	}

	public String getTemplateName() {
		return templateName;
	}

	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}
	public String getArgsObjs() {
		return argsObjs;
	}
	public void setArgsObjs(String argsObjs) {
		this.argsObjs = argsObjs;
	}


	public static void main(String[] args) throws ParseException {
		DailyEventAction dea = new DailyEventAction();
		System.out.println(dea.formatDate("201203121219", false));
	}

}