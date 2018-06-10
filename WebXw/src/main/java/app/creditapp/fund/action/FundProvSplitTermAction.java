package  app.creditapp.fund.action;
import java.util.List;
import app.util.User;
import org.apache.struts2.ServletActionContext;
import app.util.toolkit.Ipage;
import app.creditapp.fund.bo.FundProvSplitTermBo;
import app.creditapp.fund.entity.FundProvSplitTerm;
import com.core.domain.screen.FormData;
import com.core.service.screen.FormService;
import com.core.struts.ActionContext;
import com.core.struts.BaseFormBean;

/**
 * Title: FundProvSplitTermAction.java
 * Description:
 **/
public class FundProvSplitTermAction extends BaseFormBean {

	//ҳ�洫ֵ
	private FundProvSplitTerm fundProvSplitTerm;
	private List<FundProvSplitTerm> fundProvSplitTermList;

	//ע��FundProvSplitTermBo
	private FundProvSplitTermBo fundProvSplitTermBo;

	private String query;
	private String provTermNo;		
	private FormData formfdpst0001;
	private FormData formfdpst0002;
	private FormData formfdpst0003;
	private FormService formService = new FormService();
	
	public FundProvSplitTermAction() {
		query = "";
	}
	/**
	 * ��ҳ��ѯ
	 * @return
	 * @throws Exception
	 */
	public String findByPage() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),ServletActionContext.getResponse());
		formfdpst0001 = formService.getFormData("fdpst0001");
		fundProvSplitTerm = new FundProvSplitTerm();
		getFormValue(formfdpst0001);
		setObjValue(formfdpst0001, fundProvSplitTerm);
		Ipage ipage = this.getIpage();
		fundProvSplitTermList = (List) fundProvSplitTermBo.findByPage(ipage, fundProvSplitTerm).getResult();
		return "list";
	}
	/**
	 * ����ѷ�ҳ��ѯ
	 * @return
	 * @throws Exception
	 */
	public String Manager_findByPage() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),ServletActionContext.getResponse());
		formfdpst0001 = formService.getFormData("fdpst0001");
		fundProvSplitTerm = new FundProvSplitTerm();
		getFormValue(formfdpst0001);
		setObjValue(formfdpst0001, fundProvSplitTerm);
		Ipage ipage = this.getIpage();
		fundProvSplitTermList = (List) fundProvSplitTermBo.Manager_findByPage(ipage, fundProvSplitTerm).getResult();
		return "list";
	}	
	
	/**
	 * ��ȡ����ҳ��
	 * @return
	 * @throws Exception
	 */
	public String input() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formfdpst0002 = formService.getFormData("fdpst0002");
		return "input";
	}
	
	/**
	 * �����������
	 * @return
	 * @throws Exception
	 */
	public String insert() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formfdpst0002 = formService.getFormData("fdpst0002");
		getFormValue(formfdpst0002);
		fundProvSplitTerm = new FundProvSplitTerm();
		setObjValue(formfdpst0002, fundProvSplitTerm);
		fundProvSplitTerm.setOpNo(User.getTlrno(this.getHttpRequest()));
		fundProvSplitTerm.setTxDate(User.getSys_date(this.getHttpRequest()));
		fundProvSplitTermBo.insert(fundProvSplitTerm);
		getObjValue(formfdpst0002, fundProvSplitTerm);
		return "detail";
	}
	
	
	/**
	 * �޸ı������
	 * @return
	 * @throws Exception
	 */
	public String update() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formfdpst0002 = formService.getFormData("fdpst0002");
		getFormValue(formfdpst0002);
		fundProvSplitTerm = new FundProvSplitTerm();
		setObjValue(formfdpst0002, fundProvSplitTerm);
		fundProvSplitTermBo.update(fundProvSplitTerm);
		getObjValue(formfdpst0002, fundProvSplitTerm);
		return "detail";
	}
	
	
	
	/**
	 * ɾ������
	 * @return
	 * @throws Exception
	 */
	public String del() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formfdpst0001 = formService.getFormData("fdpst0001");
		fundProvSplitTerm = new FundProvSplitTerm();
		fundProvSplitTerm.setProvTermNo(provTermNo);
		fundProvSplitTermBo.del(fundProvSplitTerm);
		this.addActionMessage("ɾ���ɹ�");
		fundProvSplitTerm = new FundProvSplitTerm();
		Ipage ipage = this.getIpage();
		fundProvSplitTermList = (List) fundProvSplitTermBo.findByPage(ipage, fundProvSplitTerm).getResult();
		return "list";
	}

	/**
	 * ��ѯ����
	 * @return
	 * @throws Exception
	 */
	public String getById() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),ServletActionContext.getResponse());
		formfdpst0002 = formService.getFormData("fdpst0002");
		fundProvSplitTerm = new FundProvSplitTerm();
		fundProvSplitTerm.setProvTermNo(provTermNo);
		fundProvSplitTerm = fundProvSplitTermBo.getById(fundProvSplitTerm);
		getObjValue(formfdpst0002, fundProvSplitTerm);
		return "detail";
	}

	/**
	 * ����Ѳ�ѯ����
	 * @return
	 * @throws Exception
	 */
	public String Manager_getById() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),ServletActionContext.getResponse());
		formfdpst0003 = formService.getFormData("fdpst0003");
		fundProvSplitTerm = new FundProvSplitTerm();
		fundProvSplitTerm.setProvTermNo(provTermNo);
		fundProvSplitTerm = fundProvSplitTermBo.Manager_getById(fundProvSplitTerm);
		getObjValue(formfdpst0003, fundProvSplitTerm);
		return "detail";
	}	
	
	/**
	 * �����������У��
	 * @return
	 * @throws Exception
	 */
	public void validateInsert(){
		 ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		 formfdpst0002 = formService.getFormData("fdpst0002");
		 getFormValue(formfdpst0002);
		 validateFormData(formfdpst0002);
   	}
   
	/**
	 * �޸ı������У��
	 * @return
	 * @throws Exception
	 */
	public void validateUpdate(){
		 ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		 formfdpst0002 = formService.getFormData("fdpst0002");
		 getFormValue(formfdpst0002);
		 validateFormData(formfdpst0002);
  	}
	public FundProvSplitTerm getFundProvSplitTerm() {
		return fundProvSplitTerm;
	}
	public void setFundProvSplitTerm(FundProvSplitTerm  fundProvSplitTerm) {
		this.fundProvSplitTerm = fundProvSplitTerm;
	}
	public List<FundProvSplitTerm> getFundProvSplitTermList() {
		return fundProvSplitTermList;
	}
	public void setFundProvSplitTermList(List<FundProvSplitTerm> fundProvSplitTermList) {
		this.fundProvSplitTermList = fundProvSplitTermList;
	}
	public FundProvSplitTermBo getFundProvSplitTermBo() {
		return fundProvSplitTermBo;
	}
	public void setFundProvSplitTermBo(FundProvSplitTermBo fundProvSplitTermBo) {
		this.fundProvSplitTermBo = fundProvSplitTermBo;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public FormData getFormfdpst0002() {
		return formfdpst0002;
	}
	public void setFormfdpst0002(FormData formfdpst0002) {
		this.formfdpst0002 = formfdpst0002;
	}
	public FormData getFormfdpst0003() {
		return formfdpst0003;
	}
	public void setFormfdpst0003(FormData formfdpst0003) {
		this.formfdpst0003 = formfdpst0003;
	}
	public FormData getFormfdpst0001() {
		return formfdpst0001;
	}
	public void setFormfdpst0001(FormData formfdpst0001) {
		this.formfdpst0001 = formfdpst0001;
	}
	public void setProvTermNo(String provTermNo){
		this.provTermNo = provTermNo;
	}		
	public String getProvTermNo(){
		return provTermNo;
	}
}