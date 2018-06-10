package  app.creditapp.fund.action;
import java.util.List;


import org.apache.struts2.ServletActionContext;

import app.util.User;
import app.util.toolkit.Ipage;
import app.creditapp.fund.bo.FundSplitTermBo;
import app.creditapp.fund.entity.FundSplit;
import app.creditapp.fund.entity.FundSplitTerm;
import com.core.domain.screen.FormData;
import com.core.service.screen.FormService;
import com.core.struts.ActionContext;
import com.core.struts.BaseFormBean;

/**
 * Title: FundSplitTermAction.java
 * Description:
 **/
public class FundSplitTermAction extends BaseFormBean {

	//ҳ�洫ֵ
	private FundSplitTerm fundSplitTerm;
	private List<FundSplitTerm> fundSplitTermList;

	//ע��FundSplitTermBo
	private FundSplitTermBo fundSplitTermBo;

	private String query;
	private String termNo;		
	private String fundNo;	
	private String partNo;
	private FormData formfdsptm0001;
	private FormData formfdsptm0002;
	private FormService formService = new FormService();
	
	//��������
	
	public FundSplitTermAction() {
		query = "";
	}
	/**
	 * ��ҳ��ѯ
	 * @return
	 * @throws Exception
	 */
	public String findByPage() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),ServletActionContext.getResponse());
		formfdsptm0001 = formService.getFormData("fdsptm0001");
		fundSplitTerm = new FundSplitTerm();
		getFormValue(formfdsptm0001);
		setObjValue(formfdsptm0001, fundSplitTerm);
		Ipage ipage = this.getIpage();
		fundSplitTermList = (List) fundSplitTermBo.findByPage(ipage, fundSplitTerm).getResult();
		return "list";
	}
	
	
	/**
	 * ��ȡ����ҳ��
	 * @return
	 * @throws Exception
	 */
	public String input() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formfdsptm0002 = formService.getFormData("fdsptm0002");
		fundSplitTerm = new FundSplitTerm();
		fundSplitTerm.setPartNo(partNo);
		fundSplitTerm.setFundNo(fundNo);
		getObjValue(formfdsptm0002, fundSplitTerm);
		return "input";
	}
	
	/**
	 * �����������
	 * @return
	 * @throws Exception
	 */
	public String insert() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formfdsptm0002 = formService.getFormData("fdsptm0002");
		getFormValue(formfdsptm0002);
		fundSplitTerm = new FundSplitTerm();
		setObjValue(formfdsptm0002, fundSplitTerm);
		fundSplitTermBo.insert(fundSplitTerm);
		this.addActionMessage("�����ɹ�");
		query="query";
		getObjValue(formfdsptm0002, fundSplitTerm);
		return "detail";
	}
	
	
	/**
	 * �޸ı������
	 * @return
	 * @throws Exception
	 */
	public String update() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formfdsptm0002 = formService.getFormData("fdsptm0002");
		getFormValue(formfdsptm0002);
		fundSplitTerm = new FundSplitTerm();
		setObjValue(formfdsptm0002, fundSplitTerm);
		fundSplitTermBo.update(fundSplitTerm);
		this.addActionMessage("�޸ĳɹ�");
		getObjValue(formfdsptm0002, fundSplitTerm);
		return "detail";
	}
	
	
	
	/**
	 * ɾ������
	 * @return
	 * @throws Exception
	 */
	public String del() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formfdsptm0001 = formService.getFormData("fdsptm0001");
		fundSplitTerm = new FundSplitTerm();
		fundSplitTerm.setTermNo(termNo);
		fundSplitTermBo.del(fundSplitTerm);
		this.addActionMessage("ɾ���ɹ�");
		fundSplitTerm = new FundSplitTerm();
		fundSplitTerm.setPartNo(partNo);
		fundSplitTerm.setFundNo(fundNo);
		Ipage ipage = this.getIpage();
		fundSplitTermList = (List) fundSplitTermBo.findByPage(ipage, fundSplitTerm).getResult();
		return "list";
	}

	
	/**
	 * ��ѯ����
	 * @return
	 * @throws Exception
	 */
	public String getById() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),ServletActionContext.getResponse());
		formfdsptm0002 = formService.getFormData("fdsptm0002");
		fundSplitTerm = new FundSplitTerm();
		fundSplitTerm.setTermNo(termNo);
		fundSplitTerm = fundSplitTermBo.getById(fundSplitTerm);
		getObjValue(formfdsptm0002, fundSplitTerm);
		return "detail";
	}
	
	/**
	 * �����������У��
	 * @return
	 * @throws Exception
	 */
	public void validateInsert(){
		 ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		 formfdsptm0002 = formService.getFormData("fdsptm0002");
		 getFormValue(formfdsptm0002);
		 validateFormData(formfdsptm0002);
   	}
   
	/**
	 * �޸ı������У��
	 * @return
	 * @throws Exception
	 */
	public void validateUpdate(){
		 ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		 formfdsptm0002 = formService.getFormData("fdsptm0002");
		 getFormValue(formfdsptm0002);
		 validateFormData(formfdsptm0002);
  	}
	public FundSplitTerm getFundSplitTerm() {
		return fundSplitTerm;
	}
	public void setFundSplitTerm(FundSplitTerm  fundSplitTerm) {
		this.fundSplitTerm = fundSplitTerm;
	}
	public List<FundSplitTerm> getFundSplitTermList() {
		return fundSplitTermList;
	}
	public void setFundSplitTermList(List<FundSplitTerm> fundSplitTermList) {
		this.fundSplitTermList = fundSplitTermList;
	}
	public FundSplitTermBo getFundSplitTermBo() {
		return fundSplitTermBo;
	}
	public void setFundSplitTermBo(FundSplitTermBo fundSplitTermBo) {
		this.fundSplitTermBo = fundSplitTermBo;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public FormData getFormfdsptm0002() {
		return formfdsptm0002;
	}
	public void setFormfdsptm0002(FormData formfdsptm0002) {
		this.formfdsptm0002 = formfdsptm0002;
	}
	public FormData getFormfdsptm0001() {
		return formfdsptm0001;
	}
	public void setFormfdsptm0001(FormData formfdsptm0001) {
		this.formfdsptm0001 = formfdsptm0001;
	}
	public void setTermNo(String termNo){
		this.termNo = termNo;
	}		
	public String getTermNo(){
		return termNo;
	}
	public String getFundNo() {
		return fundNo;
	}
	public void setFundNo(String fundNo) {
		this.fundNo = fundNo;
	}
	public String getPartNo() {
		return partNo;
	}
	public void setPartNo(String partNo) {
		this.partNo = partNo;
	}
	
}