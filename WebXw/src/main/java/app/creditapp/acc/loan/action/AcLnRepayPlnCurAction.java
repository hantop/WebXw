package  app.creditapp.acc.loan.action;
import java.util.List;
import app.util.User;
import org.apache.struts2.ServletActionContext;
import app.util.toolkit.Ipage;
import app.creditapp.acc.loan.bo.AcLnRepayPlnCurBo;
import app.creditapp.acc.loan.entity.AcLnRepayPlnCur;
import com.core.domain.screen.FormData;
import com.core.service.screen.FormService;
import com.core.struts.ActionContext;
import com.core.struts.BaseFormBean;

/**
 * Title: AcLnRepayPlnCurAction.java
 * Description:
 **/
public class AcLnRepayPlnCurAction extends BaseFormBean {

	//ҳ�洫ֵ
	private AcLnRepayPlnCur acLnRepayPlnCur;
	private List<AcLnRepayPlnCur> acLnRepayPlnCurList;

	//ע��AcLnRepayPlnCurBo
	private AcLnRepayPlnCurBo acLnRepayPlnCurBo;

	private String query;
	private String loanNo;		
	private FormData formcur001;
	private FormData formcur002;
	private FormService formService = new FormService();
	
	public AcLnRepayPlnCurAction() {
		query = "";
	}
	/**
	 * ��ҳ��ѯ
	 * @return
	 * @throws Exception
	 */
	public String findByPage() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),ServletActionContext.getResponse());
		formcur001 = formService.getFormData("cur001");
		acLnRepayPlnCur = new AcLnRepayPlnCur();
		getFormValue(formcur001);
		setObjValue(formcur001, acLnRepayPlnCur);
		acLnRepayPlnCur.setBrNo(User.getBrno(this.getHttpRequest()));
		Ipage ipage = this.getIpage();
		acLnRepayPlnCurList = (List) acLnRepayPlnCurBo.findByPage(ipage, acLnRepayPlnCur).getResult();
		return "list";
	}
	
	
	/**
	 * ��ȡ����ҳ��
	 * @return
	 * @throws Exception
	 */
	public String input() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formcur002 = formService.getFormData("cur002");
		return "input";
	}
	
	/**
	 * �����������
	 * @return
	 * @throws Exception
	 */
	public String insert() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formcur002 = formService.getFormData("cur002");
		getFormValue(formcur002);
		acLnRepayPlnCur = new AcLnRepayPlnCur();
		setObjValue(formcur002, acLnRepayPlnCur);
		acLnRepayPlnCur.setBrNo(User.getBrno(this.getHttpRequest()));
		acLnRepayPlnCurBo.insert(acLnRepayPlnCur);
		getObjValue(formcur002, acLnRepayPlnCur);
		return "detail";
	}
	
	
	/**
	 * �޸ı������
	 * @return
	 * @throws Exception
	 */
	public String update() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formcur002 = formService.getFormData("cur002");
		getFormValue(formcur002);
		acLnRepayPlnCur = new AcLnRepayPlnCur();
		setObjValue(formcur002, acLnRepayPlnCur);
		acLnRepayPlnCurBo.update(acLnRepayPlnCur);
		getObjValue(formcur002, acLnRepayPlnCur);
		return "detail";
	}
	
	
	
	/**
	 * ɾ������
	 * @return
	 * @throws Exception
	 */
	public String del() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formcur001 = formService.getFormData("cur001");
		acLnRepayPlnCur = new AcLnRepayPlnCur();
		acLnRepayPlnCur.setLoanNo(loanNo);
		acLnRepayPlnCurBo.del(acLnRepayPlnCur);
		this.addActionMessage("ɾ���ɹ�");
		acLnRepayPlnCur = new AcLnRepayPlnCur();
		acLnRepayPlnCur.setBrNo(User.getBrno(this.getHttpRequest()));
		Ipage ipage = this.getIpage();
		acLnRepayPlnCurList = (List) acLnRepayPlnCurBo.findByPage(ipage, acLnRepayPlnCur).getResult();
		return "list";
	}

	
	/**
	 * ��ѯ����
	 * @return
	 * @throws Exception
	 */
	public String getById() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),ServletActionContext.getResponse());
		formcur002 = formService.getFormData("cur002");
		acLnRepayPlnCur = new AcLnRepayPlnCur();
		acLnRepayPlnCur.setLoanNo(loanNo);
		acLnRepayPlnCur = acLnRepayPlnCurBo.getById(acLnRepayPlnCur);
		getObjValue(formcur002, acLnRepayPlnCur);
		return "detail";
	}
	
	/**
	 * �����������У��
	 * @return
	 * @throws Exception
	 */
	public void validateInsert(){
		 ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		 formcur002 = formService.getFormData("cur002");
		 getFormValue(formcur002);
		 validateFormData(formcur002);
   	}
   
	/**
	 * �޸ı������У��
	 * @return
	 * @throws Exception
	 */
	public void validateUpdate(){
		 ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		 formcur002 = formService.getFormData("cur002");
		 getFormValue(formcur002);
		 validateFormData(formcur002);
  	}
	public AcLnRepayPlnCur getAcLnRepayPlnCur() {
		return acLnRepayPlnCur;
	}
	public void setAcLnRepayPlnCur(AcLnRepayPlnCur  acLnRepayPlnCur) {
		this.acLnRepayPlnCur = acLnRepayPlnCur;
	}
	public List<AcLnRepayPlnCur> getAcLnRepayPlnCurList() {
		return acLnRepayPlnCurList;
	}
	public void setAcLnRepayPlnCurList(List<AcLnRepayPlnCur> acLnRepayPlnCurList) {
		this.acLnRepayPlnCurList = acLnRepayPlnCurList;
	}
	public AcLnRepayPlnCurBo getAcLnRepayPlnCurBo() {
		return acLnRepayPlnCurBo;
	}
	public void setAcLnRepayPlnCurBo(AcLnRepayPlnCurBo acLnRepayPlnCurBo) {
		this.acLnRepayPlnCurBo = acLnRepayPlnCurBo;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public FormData getFormcur002() {
		return formcur002;
	}
	public void setFormcur002(FormData formcur002) {
		this.formcur002 = formcur002;
	}
	public FormData getFormcur001() {
		return formcur001;
	}
	public void setFormcur001(FormData formcur001) {
		this.formcur001 = formcur001;
	}
	public void setLoanNo(String loanNo){
		this.loanNo = loanNo;
	}		
	public String getLoanNo(){
		return loanNo;
	}
}