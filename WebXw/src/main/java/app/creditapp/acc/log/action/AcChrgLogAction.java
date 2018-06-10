package  app.creditapp.acc.log.action;
import java.util.List;
import app.util.User;
import org.apache.struts2.ServletActionContext;
import app.util.toolkit.Ipage;
import app.creditapp.acc.log.bo.AcChrgLogBo;
import app.creditapp.acc.log.entity.AcChrgLog;
import com.core.domain.screen.FormData;
import com.core.service.screen.FormService;
import com.core.struts.ActionContext;
import com.core.struts.BaseFormBean;

/**
 * Title: AcChrgLogAction.java
 * Description:
 **/
public class AcChrgLogAction extends BaseFormBean {

	//ҳ�洫ֵ
	private AcChrgLog acChrgLog;
	private List<AcChrgLog> acChrgLogList;

	//ע��AcChrgLogBo
	private AcChrgLogBo acChrgLogBo;
	private String chrgId;
	private String query;
	private String pactNo;
	private String traceNo;		
	private String formSts;
	private FormData formchrglog001;
	private FormData formchrglog002;
	private FormService formService = new FormService();
	
	public AcChrgLogAction() {
		query = "";
	}
	/**
	 * ��ҳ��ѯ
	 * @return
	 * @throws Exception
	 */
	public String findByPage() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),ServletActionContext.getResponse());
		formchrglog001 = formService.getFormData("chrglog001");
		acChrgLog = new AcChrgLog();
		getFormValue(formchrglog001);
		setObjValue(formchrglog001, acChrgLog);
		acChrgLog.setPactNo(pactNo);
		acChrgLog.setLoginid(User.getLoginIdByAuth(this.getHttpRequest())); // ��session�л�ȡȨ��
		Ipage ipage = this.getIpage();
		acChrgLogList = (List) acChrgLogBo.findByPage(ipage, acChrgLog).getResult();
		return "list";
	}
	public String findByPageForRead() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),ServletActionContext.getResponse());
		formchrglog001 = formService.getFormData("chrglog001");
		acChrgLog = new AcChrgLog();
		getFormValue(formchrglog001);
		setObjValue(formchrglog001, acChrgLog);
		acChrgLog.setPactNo(pactNo);
		Ipage ipage = this.getIpage();
		acChrgLogList = (List) acChrgLogBo.findByPage(ipage, acChrgLog).getResult();
		return "lists";
	}	
	
	/**
	 * ��ȡ����ҳ��
	 * @return
	 * @throws Exception
	 */
	public String input() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formchrglog002 = formService.getFormData("chrglog002");
		return "input";
	}
	
	/**
	 * �����������
	 * @return
	 * @throws Exception
	 */
	public String insert() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formchrglog002 = formService.getFormData("chrglog002");
		getFormValue(formchrglog002);
		acChrgLog = new AcChrgLog();
		setObjValue(formchrglog002, acChrgLog);
		acChrgLog.setBrNo(User.getBrno(this.getHttpRequest()));
		acChrgLogBo.insert(acChrgLog);
		getObjValue(formchrglog002, acChrgLog);
		return "detail";
	}
	
	
	/**
	 * �޸ı������
	 * @return
	 * @throws Exception
	 */
	public String update() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formchrglog002 = formService.getFormData("chrglog002");
		getFormValue(formchrglog002);
		acChrgLog = new AcChrgLog();
		setObjValue(formchrglog002, acChrgLog);
		acChrgLogBo.update(acChrgLog);
		getObjValue(formchrglog002, acChrgLog);
		return "detail";
	}
	
	
	
	/**
	 * ɾ������
	 * @return
	 * @throws Exception
	 */
	public String del() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formchrglog001 = formService.getFormData("chrglog001");
		acChrgLog = new AcChrgLog();
//		acChrgLog.setTraceNo(traceNo);
		acChrgLog.setChrgId(chrgId);
		acChrgLogBo.del(acChrgLog);
		this.addActionMessage("ɾ���ɹ�");
		acChrgLog = new AcChrgLog();
		acChrgLog.setBrNo(User.getBrno(this.getHttpRequest()));
		Ipage ipage = this.getIpage();
		acChrgLogList = (List) acChrgLogBo.findByPage(ipage, acChrgLog).getResult();
		return "list";
	}

	
	/**
	 * ��ѯ����
	 * @return
	 * @throws Exception
	 */
	public String getById() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),ServletActionContext.getResponse());
		formchrglog002 = formService.getFormData("chrglog002");
		acChrgLog = new AcChrgLog();
//		acChrgLog.setTraceNo(traceNo);
		acChrgLog.setChrgId(chrgId);
		acChrgLog = acChrgLogBo.getById(acChrgLog);
		getObjValue(formchrglog002, acChrgLog);
		return "detail";
	}
	
	/**
	 * �����������У��
	 * @return
	 * @throws Exception
	 */
	public void validateInsert(){
		 ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		 formchrglog002 = formService.getFormData("chrglog002");
		 getFormValue(formchrglog002);
		 validateFormData(formchrglog002);
   	}
   
	/**
	 * �޸ı������У��
	 * @return
	 * @throws Exception
	 */
	public void validateUpdate(){
		 ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		 formchrglog002 = formService.getFormData("chrglog002");
		 getFormValue(formchrglog002);
		 validateFormData(formchrglog002);
  	}
	public AcChrgLog getAcChrgLog() {
		return acChrgLog;
	}
	public void setAcChrgLog(AcChrgLog  acChrgLog) {
		this.acChrgLog = acChrgLog;
	}
	public List<AcChrgLog> getAcChrgLogList() {
		return acChrgLogList;
	}
	public void setAcChrgLogList(List<AcChrgLog> acChrgLogList) {
		this.acChrgLogList = acChrgLogList;
	}
	public AcChrgLogBo getAcChrgLogBo() {
		return acChrgLogBo;
	}
	public void setAcChrgLogBo(AcChrgLogBo acChrgLogBo) {
		this.acChrgLogBo = acChrgLogBo;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public FormData getFormchrglog002() {
		return formchrglog002;
	}
	public void setFormchrglog002(FormData formchrglog002) {
		this.formchrglog002 = formchrglog002;
	}
	public FormData getFormchrglog001() {
		return formchrglog001;
	}
	public void setFormchrglog001(FormData formchrglog001) {
		this.formchrglog001 = formchrglog001;
	}
	public String getChrgId() {
		return chrgId;
	}
	public void setChrgId(String chrgId) {
		this.chrgId = chrgId;
	}
	public String getPactNo() {
		return pactNo;
	}
	public void setPactNo(String pactNo) {
		this.pactNo = pactNo;
	}
	public String getTraceNo() {
		return traceNo;
	}
	public void setTraceNo(String traceNo) {
		this.traceNo = traceNo;
	}
	public String getFormSts() {
		return formSts;
	}
	public void setFormSts(String formSts) {
		this.formSts = formSts;
	}
}