package  app.creditapp.cred.action;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.core.domain.screen.FormData;
import com.core.service.screen.FormService;
import com.core.struts.ActionContext;
import com.core.struts.BaseFormBean;

import app.creditapp.cred.bo.CifEvalBo;
import app.creditapp.cred.entity.CifEval;
import app.creditapp.inf.client.entity.RuleReturn;
import app.util.User;
import app.util.toolkit.Ipage;

/**
 * Title: CifEvalAction.java
 * Description:
 **/
public class CifEvalAction extends BaseFormBean {

	//ҳ�洫ֵ
	private CifEval cifEval;
	private List<CifEval> cifEvalList;
	private List<RuleReturn> ruleReturnList;
	private String backSts;
	
	//ע��CifEvalBo
	private CifEvalBo cifEvalBo;
	
	private String cifNo;
	private List tabList;
	private String query;
	private String evalNo;		
	private FormData formcred0003;
	private FormData formcred0004;
	private FormData formcifeval0001;
	private FormService formService = new FormService();
	
	public CifEvalAction() {
		query = "";
	}
	/**
	 * ��ҳ��ѯ
	 * @return
	 * @throws Exception
	 */
	public String findByPage() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),ServletActionContext.getResponse());
		formcred0003 = formService.getFormData("cred0003");
		cifEval = new CifEval();
		getFormValue(formcred0003);
		setObjValue(formcred0003, cifEval);
		cifEval.setLoginid(User.getLoginIdByAuth(this.getHttpRequest()));
		Ipage ipage = this.getIpage();
		cifEvalList = (List) cifEvalBo.findByPage(ipage, cifEval).getResult();

		return "list";
	}
	/**
	 * �ͻ�����360��ͼ
	 * @return
	 * @throws Exception
	 */
	public String findByPage360_Read() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),ServletActionContext.getResponse());
		formcred0003 = formService.getFormData("cred0003");
		cifEval = new CifEval();
		cifEval.setCifNo(cifNo);
		Ipage ipage = this.getIpage();
		cifEvalList = (List) cifEvalBo.findByPage(ipage, cifEval).getResult();
		for(int i = 0; i<cifEvalList.size();i++){
			cifEvalList.get(i).setQuery(query);
		}
		return "list360_Read";
	}
	/**
	 * �ͻ�����360��ͼ
	 * @return
	 * @throws Exception
	 */
	public String findByPage360() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),ServletActionContext.getResponse());
		formcred0003 = formService.getFormData("cred0003");
		cifEval = new CifEval();
		cifEval.setCifNo("100000023022");
		Ipage ipage = this.getIpage();
		cifEvalList = (List) cifEvalBo.findByPage(ipage, cifEval).getResult();
		for(int i = 0; i<cifEvalList.size();i++){
			cifEvalList.get(i).setQuery(query);
		}
		return "list360";
	}
	/**
	 * �ͻ�����Tab
	 * @return
	 * @throws Exception
	 */
	public String getRateTab() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),
				ServletActionContext.getResponse());
		tabList = new ArrayList();
		String[] tab = null;		
		tab = new String[2];
		tab[0] = "��������";
		tab[1] = "CifEvalAction_findRuleByNo.action?cifNo=" + cifNo + "&evalNo=" + evalNo + "&query=query&onlyShow=show";
		tabList.add(tab);
		tab = new String[2];
		tab[0] = "������ʷ";
		tab[1] = "CifEvalAction_findByPage360.action?cifNo=" + cifNo + "&query=query&onlyShow=show";
		tabList.add(tab);		
		return "tab";
	}
	/**
	 * �鿴360�ӽ�
	 * @return
	 */
	public String getAllDetail() {
		ActionContext.initialize(ServletActionContext.getRequest(), 
				ServletActionContext.getResponse());
		cifEval = new CifEval();
		cifEval.setCifNo(cifNo);
		cifEval = cifEvalBo.getById(cifEval);
		return "all";
	}
	/**
	 * �����ͼ�в鿴�ӽ�
	 * @return
	 */
	public String getAllDetail_360() {
		ActionContext.initialize(ServletActionContext.getRequest(), 
				ServletActionContext.getResponse());
		cifEval = new CifEval();
		cifEval.setCifNo(cifNo);
		cifEval = cifEvalBo.getById(cifEval);
		return "all";
	}
	public String getTab() throws Exception{
		ActionContext.initialize(ServletActionContext.getRequest(),
				ServletActionContext.getResponse());
		tabList = new ArrayList();
		String[] tab = null;
		tab = new String[2];
		tab[0] = "�ͻ�����";
		tab[1] = "CifEvalAction_getById.action?evalNo=" + evalNo + "&query=query&onlyShow=show";
		tabList.add(tab);		
		tab = new String[2];
		tab[0] = "�ͻ���������";
		tab[1] = "CifEvalAction_findByReturnId.action?evalNo=" + evalNo + "&query=query&onlyShow=show";
		tabList.add(tab);
		
		return "tab";
	}
	public String getTab_360() throws Exception{
		ActionContext.initialize(ServletActionContext.getRequest(),
				ServletActionContext.getResponse());
		tabList = new ArrayList();
		String[] tab = null;
		tab = new String[2];
		tab[0] = "�ͻ�����";
		tab[1] = "CifEvalAction_getById.action?evalNo=" + evalNo + "&query=query&onlyShow=show";
		tabList.add(tab);		
		tab = new String[2];
		tab[0] = "�ͻ���������";
		tab[1] = "CifEvalAction_findByReturnId.action?evalNo=" + evalNo + "&query=query&onlyShow=show";
		tabList.add(tab);
		
		return "tab";
	}
	/**
	 * ��Ч
	 * @return
	 * @throws Exception
	 */
	public String active() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formcred0003 = formService.getFormData("cred0003");
		cifEval = new CifEval();
		cifEval.setEvalNo(evalNo);
		cifEval.setCifNo(cifNo);
		cifEval.setEvalSts("01");
		cifEvalBo.update(cifEval);
		this.addActionMessage("��Ч�ɹ�");
		Ipage ipage = this.getIpage();
		cifEvalList = (List) cifEvalBo.findByPage(ipage, cifEval).getResult();
		
		for(int i = 0; i<cifEvalList.size();i++){
			cifEvalList.get(i).setQuery(query);
		}
		return "list360";
	}	
	/**
	 * ͣ��
	 * @return
	 * @throws Exception
	 */
	public String inactive() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formcred0003 = formService.getFormData("cred0003");
		cifEval = new CifEval();
		cifEval.setEvalNo(evalNo);
		cifEval.setCifNo(cifNo);
		cifEval.setEvalSts("02");
		cifEvalBo.update(cifEval);
		this.addActionMessage("��ʧЧ");
		Ipage ipage = this.getIpage();
		cifEvalList = (List) cifEvalBo.findByPage(ipage, cifEval).getResult();
		
		for(int i = 0; i<cifEvalList.size();i++){
			cifEvalList.get(i).setQuery(query);
		}
		return "list360";
	}	
	/**
	 * ��ȡ����ҳ��
	 * @return
	 * @throws Exception
	 */
	public String input() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formcred0004 = formService.getFormData("cred0004");
		return "input";
	}
	
	/**
	 * �����������
	 * @return
	 * @throws Exception
	 */
	public String insert() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formcred0004 = formService.getFormData("cred0004");
		getFormValue(formcred0004);
		cifEval = new CifEval();
		setObjValue(formcred0004, cifEval);
		cifEval.setEvalDate(User.getSys_date(ServletActionContext.getRequest()));
		cifEvalBo.insert(cifEval);
		getObjValue(formcred0004, cifEval);
		this.addActionMessage("�����ɹ�");
		return "detail";
	}
	
	
	/**
	 * �޸ı������
	 * @return
	 * @throws Exception
	 */
	public String update() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formcred0004 = formService.getFormData("cred0004");
		getFormValue(formcred0004);
		cifEval = new CifEval();
		setObjValue(formcred0004, cifEval);
		cifEvalBo.update(cifEval);
		getObjValue(formcred0004, cifEval);
		this.addActionMessage("�����ɹ�");
		return "detail";
	}
	
	
	
	/**
	 * ɾ������
	 * @return
	 * @throws Exception
	 */
	public String del() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formcred0003 = formService.getFormData("cred0003");
		cifEval = new CifEval();
		cifEval.setEvalNo(evalNo);
		cifEvalBo.del(cifEval);
		this.addActionMessage("ɾ���ɹ�");
		cifEval = new CifEval();
		Ipage ipage = this.getIpage();
		cifEvalList = (List) cifEvalBo.findByPage(ipage, cifEval).getResult();
		return "list";
	}

	
	/**
	 * ��ѯ����
	 * @return
	 * @throws Exception
	 */
	public String getById() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),ServletActionContext.getResponse());
		formcred0004 = formService.getFormData("cred0004");
		cifEval = new CifEval();
		cifEval.setEvalNo(evalNo);
		cifEval = cifEvalBo.getById(cifEval);
		getObjValue(formcred0004, cifEval);
		return "detail";
	}
	
	/**
	 * �����������У��
	 * @return
	 * @throws Exception
	 */
	public void validateInsert(){
		 ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		 formcred0004 = formService.getFormData("cred0004");
		 getFormValue(formcred0004);
		 validateFormData(formcred0004);
   	}
   
	/**
	 * �޸ı������У��
	 * @return
	 * @throws Exception
	 */
	public void validateUpdate(){
		 ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		 formcred0004 = formService.getFormData("cred0004");
		 getFormValue(formcred0004);
		 validateFormData(formcred0004);
  	}
	public CifEval getCifEval() {
		return cifEval;
	}
	public void setCifEval(CifEval  cifEval) {
		this.cifEval = cifEval;
	}
	public List<CifEval> getCifEvalList() {
		return cifEvalList;
	}
	public void setCifEvalList(List<CifEval> cifEvalList) {
		this.cifEvalList = cifEvalList;
	}
	public CifEvalBo getCifEvalBo() {
		return cifEvalBo;
	}
	public void setCifEvalBo(CifEvalBo cifEvalBo) {
		this.cifEvalBo = cifEvalBo;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public FormData getFormcred0004() {
		return formcred0004;
	}
	public void setFormcred0004(FormData formcred0004) {
		this.formcred0004 = formcred0004;
	}
	public FormData getFormcred0003() {
		return formcred0003;
	}
	public void setFormcred0003(FormData formcred0003) {
		this.formcred0003 = formcred0003;
	}
	public void setEvalNo(String evalNo){
		this.evalNo = evalNo;
	}		
	public String getEvalNo(){
		return evalNo;
	}
	/**
	 * @return the tabList
	 */
	public List getTabList() {
		return tabList;
	}
	/**
	 * @param tabList the tabList to set
	 */
	public void setTabList(List tabList) {
		this.tabList = tabList;
	}
	/**
	 * @return the formcifeval0001
	 */
	public FormData getFormcifeval0001() {
		return formcifeval0001;
	}
	/**
	 * @param formcifeval0001 the formcifeval0001 to set
	 */
	public void setFormcifeval0001(FormData formcifeval0001) {
		this.formcifeval0001 = formcifeval0001;
	}
	/**
	 * @return the cifNo
	 */
	public String getCifNo() {
		return cifNo;
	}
	/**
	 * @param cifNo the cifNo to set
	 */
	public void setCifNo(String cifNo) {
		this.cifNo = cifNo;
	}
	public List<RuleReturn> getRuleReturnList() {
		return ruleReturnList;
	}
	public void setRuleReturnList(List<RuleReturn> ruleReturnList) {
		this.ruleReturnList = ruleReturnList;
	}
	public String getBackSts() {
		return backSts;
	}
	public void setBackSts(String backSts) {
		this.backSts = backSts;
	}
}