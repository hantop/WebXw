package app.creditapp.acc.option.action;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import accounting.domain.sys.AcComHoliday;
import app.creditapp.acc.option.bo.AcComHolidayBo;
import app.creditapp.entity.WorkCalendar;
import app.util.User;
import app.util.toolkit.Ipage;

import com.core.domain.screen.FormData;
import com.core.service.screen.FormService;
import com.core.struts.ActionContext;
import com.core.struts.BaseFormBean;

public class AcComHolidayAction extends BaseFormBean {

	// ҳ�洫ֵ
	private AcComHoliday acComHoliday ;
	private List<AcComHoliday> acComHolidayList ;

	// ע��AcComHolidayBO
	private AcComHolidayBo acComHolidayBo ;

	private String endDt ;
	private String typ ;
	private String begDt ;
	
	private String parNames ;
	private String popNames ;
	private String query ;
	private String view ;
	private String[] strs;
	private String month;
	private String year;
	private FormData formacc8017;  
	private FormData formacc8018;  
	private FormService formService = new FormService() ;
	
	/**
     * �����Ĺ��췽��
     */
    public AcComHolidayAction() {
    	query = "";
    	view = "";
    }
    
	/**
	 * ��ҳ��ѯ
	 * @return
	 * @throws Exception
	 */
	public String findByPage() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formacc8017 = formService.getFormData("acc8017");
		acComHoliday = new AcComHoliday();
		getFormValue(formacc8017);
	    setObjValue(formacc8017,acComHoliday);
	    Ipage ipage = this.getIpage();
	    acComHolidayList =(List) acComHolidayBo.findByPage(ipage, acComHoliday).getResult();
	    return "list";
	}
	/**
	 * ����ʱ����ת
	 */
	public String input() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),
				ServletActionContext.getResponse());
		formacc8018= formService.getFormData("acc8018");
		return "input";
	}

	/**
	 *  pop�����÷�ҳ��ѯ ������ҳ��ѯ
	 * @return
	 * @throws Exception
	 */
	public String findByPageForPop() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		acComHoliday = new AcComHoliday();
	    Ipage ipage = this.getIpage();
	    acComHolidayList =(List) acComHolidayBo.findByPage(ipage, acComHoliday).getResult();
	    
		return "pop";
	}

	/**
	 * ���²���
	 * @return
	 * @throws Exception
	 */
	public String update() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
    	formacc8018 = formService.getFormData("acc8018");
		getFormValue(formacc8018);
		acComHoliday = new AcComHoliday();
		setObjValue(formacc8018, acComHoliday);
		acComHolidayBo.update(acComHoliday);
		// ���²�����Ϊ����ת������鿴ҳ��
		endDt = acComHoliday.getEndDt() ;	// �����������֮����Ҫ����������endDt����ҳ��
		typ = acComHoliday.getTyp() ;	// �����������֮����Ҫ����������typ����ҳ��
		begDt = acComHoliday.getBegDt() ;	// �����������֮����Ҫ����������begDt����ҳ��
		
		query = "query";

		return "detail";
	}
	
	/**
	 * �������
	 * @return
	 * @throws Exception
	 */
	public String insert() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
    	formacc8018 = formService.getFormData("acc8018");
		getFormValue(formacc8018);
		acComHoliday = new AcComHoliday();
		setObjValue(formacc8018, acComHoliday);
		acComHolidayBo.insert(acComHoliday);
		// ���²�����Ϊ����ת������鿴ҳ��
		getObjValue(formacc8018, acComHoliday);
		endDt = acComHoliday.getEndDt() ;	// �����������֮����Ҫ����������endDt����ҳ��
		typ = acComHoliday.getTyp() ;	// �����������֮����Ҫ����������typ����ҳ��
		begDt = acComHoliday.getBegDt() ;	// �����������֮����Ҫ����������begDt����ҳ��
		
		query = "query";

		return "detail";
	}

	/**
	 * ɾ������
	 * @return
	 * @throws Exception
	 */
	public String del() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		acComHoliday = new AcComHoliday();
		acComHoliday.setEndDt(endDt) ;
		acComHoliday.setTyp(typ) ;
		acComHoliday.setBegDt(begDt) ;
		
		acComHolidayBo.del(acComHoliday);
		this.addActionMessage("ɾ���ɹ�!");
		Ipage ipage = this.getIpage();
		acComHolidayList = (List) acComHolidayBo.findByPage(ipage, new AcComHoliday()).getResult();
		
		return "list";
	}

	/**
	 * �鿴,�༭����
	 * @return
	 * @throws Exception
	 */
	public String getById() throws Exception {
		 ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
	    formacc8018 = formService.getFormData("acc8018");
		acComHoliday = new AcComHoliday();
		acComHoliday.setEndDt(endDt) ;
		acComHoliday.setTyp(typ) ;
		acComHoliday.setBegDt(begDt) ;
		
		 acComHoliday = acComHolidayBo.getById(acComHoliday) ;
		 getObjValue(formacc8018,acComHoliday);
	
		 if(view.equals("view")){
			 query = "query";
		 }
//		 changeFormProperty(formacc8018, "endDt", "readonly", "1") ;
//		changeFormProperty(formacc8018, "typ", "readonly", "1") ;
//		changeFormProperty(formacc8018, "begDt", "readonly", "1") ;
		
		 
		 return "detail";
	}
	
	/**
	 * ���������������֤
	 */
	public void validateInsert(){
		 ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		 formacc8018 = formService.getFormData("acc8018");
		 getFormValue(formacc8018);
		 validateFormData(formacc8018) ;
		 /*
		  * ҵ���߼�
		  */
	}
	
	/**
	 * ���²�����������֤
	 */
	public void validateUpdate(){
		 ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		 formacc8018 = formService.getFormData("acc8018");
		 getFormValue(formacc8018);
		 validateFormData(formacc8018) ;
		 /*
		  * ҵ���߼�
		  */
	 }
	
	/**
	 * �ڼ���ά���µ�չʾ��ʽ
	 * @return
	 */
	 public String monthlist() {
			List<WorkCalendar> list = new ArrayList<WorkCalendar>();
			Map<String, String> map = new HashMap<String, String>();
			String year = "";
			String month = "";
			if (ServletActionContext.getRequest().getParameter("month") != null) {
				month = ServletActionContext.getRequest().getParameter("month");
				month = String.valueOf(Integer.parseInt(month) + 1);
			} else {
				month = (User.getTime().substring(4, 6));
			}
			if (month.length() == 1) {
				month = "0" + month;
			}
			
			if (ServletActionContext.getRequest().getParameter("year") != null) {
				year = ServletActionContext.getRequest().getParameter("year");
			} else {
				year = (User.getTime().substring(0, 4));
			}
			
			String begDt = year + month;
			strs = new String[31];
			acComHolidayList = acComHolidayBo.getListByBegDt(begDt);
			ServletActionContext.getRequest().setAttribute("acComHolidayList", acComHolidayList);
			if(acComHolidayList.size() != 0 && acComHolidayList != null){
					ServletActionContext.getRequest().setAttribute("flg", "have");
			}else{
				ServletActionContext.getRequest().setAttribute("flg", "no");
			}
			
			return "monthlist";
		}
	 
	 public String save() throws Exception {
			ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
//			ServletActionContext.getRequest().setCharacterEncoding("UTF-8");
			month = ServletActionContext.getRequest().getParameter("month");
			year = ServletActionContext.getRequest().getParameter("year");
			if (month.length() == 1) {
				month = "0" + month;
			}
			String[] days = this.getHttpRequest().getParameterValues("checkBox");
			String calendar = null;
			String str = year + month;
			acComHoliday = new AcComHoliday();
			acComHolidayBo.delByBegDt(str);
			for (int i = 0; i < days.length; i++) {
//				String desc = new String(this.getHttpRequest().getParameter("desc"+days[i]).getBytes("GBK"),"UTF-8");
				String desc = this.getHttpRequest().getParameter("desc"+days[i]);
				if(days[i].length() == 1){
					days[i] = "0" + days[i];
				}
				calendar = str + days[i];
				acComHoliday.setBegDt(calendar);
				acComHoliday.setEndDt(calendar);
				acComHoliday.setTyp("1");
				acComHoliday.setDays("1");
				acComHoliday.setTyp(desc);
				acComHolidayBo.insert(acComHoliday);
			}
			
			String begDt = year + month;
			strs = new String[31];
			acComHolidayList = acComHolidayBo.getListByBegDt(begDt);
			ServletActionContext.getRequest().setAttribute("acComHolidayList", acComHolidayList);
			
			if(acComHolidayList.size() != 0 && acComHolidayList != null){
				ServletActionContext.getRequest().setAttribute("flg", "have");
			}else{
				ServletActionContext.getRequest().setAttribute("flg", "no");
			}
			ServletActionContext.getRequest().setAttribute("flag", "save");
			return "monthlist";
		}

	public AcComHoliday getAcComHoliday() {
		return acComHoliday;
	}

	public void setAcComHoliday(AcComHoliday acComHoliday) {
		this.acComHoliday = acComHoliday;
	}

	public List<AcComHoliday> getAcComHolidayList() {
		return acComHolidayList;
	}

	public void setAcComHolidayList(List<AcComHoliday> acComHolidayList) {
		this.acComHolidayList = acComHolidayList;
	}

	public AcComHolidayBo getAcComHolidayBo() {
		return acComHolidayBo;
	}

	public void setAcComHolidayBo(AcComHolidayBo acComHolidayBo) {
		this.acComHolidayBo = acComHolidayBo;
	}

	public String getEndDt() {
		return endDt;
	}

	public void setEndDt(String endDt) {
		this.endDt = endDt;
	}

	public String getTyp() {
		return typ;
	}

	public void setTyp(String typ) {
		this.typ = typ;
	}

	public String getBegDt() {
		return begDt;
	}

	public void setBegDt(String begDt) {
		this.begDt = begDt;
	}

	public String getParNames() {
		return parNames;
	}

	public void setParNames(String parNames) {
		this.parNames = parNames;
	}

	public String getPopNames() {
		return popNames;
	}

	public void setPopNames(String popNames) {
		this.popNames = popNames;
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public String getView() {
		return view;
	}

	public void setView(String view) {
		this.view = view;
	}

	public FormData getFormacc8017() {
		return formacc8017;
	}

	public void setFormacc8017(FormData formacc8017) {
		this.formacc8017 = formacc8017;
	}

	public FormData getFormacc8018() {
		return formacc8018;
	}

	public void setFormacc8018(FormData formacc8018) {
		this.formacc8018 = formacc8018;
	}

	public String[] getStrs() {
		return strs;
	}

	public void setStrs(String[] strs) {
		this.strs = strs;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}
}
