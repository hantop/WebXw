package  app.creditapp.sys.action;
import java.util.List;
import app.util.User;
import org.apache.struts2.ServletActionContext;
import app.util.toolkit.Ipage;
import app.creditapp.sys.bo.ParmRewBo;
import app.creditapp.sys.entity.ParmRew;
import com.core.domain.screen.FormData;
import com.core.service.screen.FormService;
import com.core.struts.ActionContext;
import com.core.struts.BaseFormBean;

/**
 * Title: ParmRewAction.java
 * Description:
 **/
public class ParmRewAction extends BaseFormBean {

	//ҳ�洫ֵ
	private ParmRew parmRew;
	private List<ParmRew> parmRewList;

	//ע��ParmRewBo
	private ParmRewBo parmRewBo;

	private String rewCyc;
	private String query;
	private String rewNo;		
	private FormData formsys0109;
	private FormData formsys0110;
	private FormService formService = new FormService();
	
	public ParmRewAction() {
		query = "";
	}
	/**
	 * ��ҳ��ѯ
	 * @return
	 * @throws Exception
	 */
	public String findByPage() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),ServletActionContext.getResponse());
		formsys0109 = formService.getFormData("sys0109");
		parmRew = new ParmRew();
		getFormValue(formsys0109);
		setObjValue(formsys0109, parmRew);
		Ipage ipage = this.getIpage();
		parmRewList = (List) parmRewBo.findByPage(ipage, parmRew).getResult();
		return "list";
	}
	
	
	/**
	 * ��ȡ����ҳ��
	 * @return
	 * @throws Exception
	 */
	public String input() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formsys0110 = formService.getFormData("sys0110");
		return "input";
	}
	
	/**
	 * �����������
	 * @return
	 * @throws Exception
	 */
	public String insert() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formsys0110 = formService.getFormData("sys0110");
		getFormValue(formsys0110);
		parmRew = new ParmRew();
		setObjValue(formsys0110, parmRew);
		parmRew.setRewCyc(rewCyc);
		parmRew.setTxDate(User.getSys_date(this.getHttpRequest()));
		parmRewBo.insert(parmRew);
		getObjValue(formsys0110, parmRew);
		return "detail";
	}
	
	
	/**
	 * �޸ı������
	 * @return
	 * @throws Exception
	 */
	public String update() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formsys0110 = formService.getFormData("sys0110");
		getFormValue(formsys0110);
		parmRew = new ParmRew();
		setObjValue(formsys0110, parmRew);
		parmRew.setRewCyc(rewCyc);
		parmRew.setUpDate(User.getSys_date(this.getHttpRequest()));
		parmRewBo.update(parmRew);
		getObjValue(formsys0110, parmRew);
		return "detail";
	}
	
	
	
	/**
	 * ɾ������
	 * @return
	 * @throws Exception
	 */
	public String del() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formsys0109 = formService.getFormData("sys0109");
		parmRew = new ParmRew();
		parmRew.setRewNo(rewNo);
		parmRewBo.del(parmRew);
		this.addActionMessage("ɾ���ɹ�");
		parmRew = new ParmRew();
		Ipage ipage = this.getIpage();
		parmRewList = (List) parmRewBo.findByPage(ipage, parmRew).getResult();
		return "list";
	}

	
	/**
	 * ��ѯ����
	 * @return
	 * @throws Exception
	 */
	public String getById() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),ServletActionContext.getResponse());
		formsys0110 = formService.getFormData("sys0110");
		parmRew = new ParmRew();
		parmRew.setRewNo(rewNo);
		parmRew = parmRewBo.getById(parmRew);
		getObjValue(formsys0110, parmRew);
		return "detail";
	}
	
	/**
	 * �����������У��
	 * @return
	 * @throws Exception
	 */
	public void validateInsert(){
		 ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		 formsys0110 = formService.getFormData("sys0110");
		 getFormValue(formsys0110);
		 validateFormData(formsys0110);
   	}
   
	/**
	 * �޸ı������У��
	 * @return
	 * @throws Exception
	 */
	public void validateUpdate(){
		 ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		 formsys0110 = formService.getFormData("sys0110");
		 getFormValue(formsys0110);
		 validateFormData(formsys0110);
  	}
	public ParmRew getParmRew() {
		return parmRew;
	}
	public void setParmRew(ParmRew  parmRew) {
		this.parmRew = parmRew;
	}
	public List<ParmRew> getParmRewList() {
		return parmRewList;
	}
	public void setParmRewList(List<ParmRew> parmRewList) {
		this.parmRewList = parmRewList;
	}
	public ParmRewBo getParmRewBo() {
		return parmRewBo;
	}
	public void setParmRewBo(ParmRewBo parmRewBo) {
		this.parmRewBo = parmRewBo;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public FormData getFormsys0110() {
		return formsys0110;
	}
	public void setFormsys0110(FormData formsys0110) {
		this.formsys0110 = formsys0110;
	}
	public FormData getFormsys0109() {
		return formsys0109;
	}
	public void setFormsys0109(FormData formsys0109) {
		this.formsys0109 = formsys0109;
	}
	public void setRewNo(String rewNo){
		this.rewNo = rewNo;
	}		
	public String getRewNo(){
		return rewNo;
	}
	public String getRewCyc() {
		return rewCyc;
	}
	public void setRewCyc(String rewCyc) {
		this.rewCyc = rewCyc;
	}
}