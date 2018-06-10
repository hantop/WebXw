package  app.creditapp.acc.log.action;
import java.util.List;
import app.util.User;
import org.apache.struts2.ServletActionContext;
import app.util.toolkit.Ipage;
import app.creditapp.acc.log.bo.AcLnIntstLogBo;
import app.creditapp.acc.log.entity.AcLnIntstLog;
import com.core.domain.screen.FormData;
import com.core.service.screen.FormService;
import com.core.struts.ActionContext;
import com.core.struts.BaseFormBean;

/**
 * Title: AcLnIntstLogAction.java
 **/
public class AcLnIntstLogAction extends BaseFormBean {

	//ҳ�洫ֵ
	private AcLnIntstLog acLnIntstLog;
	private List<AcLnIntstLog> acLnIntstLogList;

	//ע��AcLnIntstLogBo
	private AcLnIntstLogBo acLnIntstLogBo;

	private String query;
	private Integer perdNo;		
	private String loanNo;		
	private String traceNo;		
	private FormData formintlog0001;
	private FormData formintlog0002;
	private FormService formService = new FormService();
	
	public AcLnIntstLogAction() {
		query = "";
	}
	/**
	 * ��ҳ��ѯ
	 * @return
	 * @throws Exception
	 */
	public String findByPage() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),ServletActionContext.getResponse());
		formintlog0001 = formService.getFormData("intlog0001");
		acLnIntstLog = new AcLnIntstLog();
		getFormValue(formintlog0001);
		setObjValue(formintlog0001, acLnIntstLog);
		acLnIntstLog.setLoginid(User.getLoginIdByAuth(this.getHttpRequest())); // ��session�л�ȡȨ��
		Ipage ipage = this.getIpage();
		acLnIntstLogList = (List) acLnIntstLogBo.findByPage(ipage, acLnIntstLog).getResult();
		return "list";
	}
	
	
	/**
	 * ��ȡ����ҳ��
	 * @return
	 * @throws Exception
	 */
	public String input() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formintlog0002 = formService.getFormData("intlog0002");
		return "input";
	}
	
	/**
	 * �����������
	 * @return
	 * @throws Exception
	 */
	public String insert() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formintlog0002 = formService.getFormData("intlog0002");
		getFormValue(formintlog0002);
		acLnIntstLog = new AcLnIntstLog();
		setObjValue(formintlog0002, acLnIntstLog);
		acLnIntstLog.setBrNo(User.getBrno(this.getHttpRequest()));
		acLnIntstLogBo.insert(acLnIntstLog);
		getObjValue(formintlog0002, acLnIntstLog);
		return "detail";
	}
	
	
	/**
	 * �޸ı������
	 * @return
	 * @throws Exception
	 */
	public String update() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formintlog0002 = formService.getFormData("intlog0002");
		getFormValue(formintlog0002);
		acLnIntstLog = new AcLnIntstLog();
		setObjValue(formintlog0002, acLnIntstLog);
		acLnIntstLogBo.update(acLnIntstLog);
		getObjValue(formintlog0002, acLnIntstLog);
		return "detail";
	}
	
	
	
	/**
	 * ɾ������
	 * @return
	 * @throws Exception
	 */
	public String del() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formintlog0001 = formService.getFormData("intlog0001");
		acLnIntstLog = new AcLnIntstLog();
		acLnIntstLog.setPerdNo(perdNo);
		acLnIntstLog.setLoanNo(loanNo);
		acLnIntstLog.setTraceNo(traceNo);
		acLnIntstLogBo.del(acLnIntstLog);
		this.addActionMessage("ɾ���ɹ�");
		acLnIntstLog = new AcLnIntstLog();
		acLnIntstLog.setBrNo(User.getBrno(this.getHttpRequest()));
		Ipage ipage = this.getIpage();
		acLnIntstLogList = (List) acLnIntstLogBo.findByPage(ipage, acLnIntstLog).getResult();
		return "list";
	}

	
	/**
	 * ��ѯ����
	 * @return
	 * @throws Exception
	 */
	public String getById() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),ServletActionContext.getResponse());
		formintlog0002 = formService.getFormData("intlog0002");
		acLnIntstLog = new AcLnIntstLog();
		acLnIntstLog.setPerdNo(perdNo);
		acLnIntstLog.setLoanNo(loanNo);
		acLnIntstLog.setTraceNo(traceNo);
		acLnIntstLog = acLnIntstLogBo.getById(acLnIntstLog);
		getObjValue(formintlog0002, acLnIntstLog);
		return "detail";
	}
	
	/**
	 * �����������У��
	 * @return
	 * @throws Exception
	 */
	public void validateInsert(){
		 ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		 formintlog0002 = formService.getFormData("intlog0002");
		 getFormValue(formintlog0002);
		 validateFormData(formintlog0002);
   	}
   
	/**
	 * �޸ı������У��
	 * @return
	 * @throws Exception
	 */
	public void validateUpdate(){
		 ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		 formintlog0002 = formService.getFormData("intlog0002");
		 getFormValue(formintlog0002);
		 validateFormData(formintlog0002);
  	}
	public AcLnIntstLog getAcLnIntstLog() {
		return acLnIntstLog;
	}
	public void setAcLnIntstLog(AcLnIntstLog  acLnIntstLog) {
		this.acLnIntstLog = acLnIntstLog;
	}
	public List<AcLnIntstLog> getAcLnIntstLogList() {
		return acLnIntstLogList;
	}
	public void setAcLnIntstLogList(List<AcLnIntstLog> acLnIntstLogList) {
		this.acLnIntstLogList = acLnIntstLogList;
	}
	public AcLnIntstLogBo getAcLnIntstLogBo() {
		return acLnIntstLogBo;
	}
	public void setAcLnIntstLogBo(AcLnIntstLogBo acLnIntstLogBo) {
		this.acLnIntstLogBo = acLnIntstLogBo;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public FormData getFormintlog0002() {
		return formintlog0002;
	}
	public void setFormintlog0002(FormData formintlog0002) {
		this.formintlog0002 = formintlog0002;
	}
	public FormData getFormintlog0001() {
		return formintlog0001;
	}
	public void setFormintlog0001(FormData formintlog0001) {
		this.formintlog0001 = formintlog0001;
	}
	public void setPerdNo(Integer perdNo){
		this.perdNo = perdNo;
	}		
	public void setLoanNo(String loanNo){
		this.loanNo = loanNo;
	}		
	public void setTraceNo(String traceNo){
		this.traceNo = traceNo;
	}		
	public Integer getPerdNo(){
		return perdNo;
	}
	public String getLoanNo(){
		return loanNo;
	}
	public String getTraceNo(){
		return traceNo;
	}
}