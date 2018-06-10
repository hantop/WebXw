package  app.creditapp.ln.action;
import java.util.ArrayList;
import java.util.List;
import app.util.User;
import org.apache.struts2.ServletActionContext;
import app.util.toolkit.Ipage;
import app.base.SourceTemplate;
import app.creditapp.inf.client.RuleTrans;
import app.creditapp.inf.client.RulesService;
import app.creditapp.inf.client.entity.Request;
import app.creditapp.inf.client.entity.RequestObj;
import app.creditapp.inf.client.entity.ReturnObj;
import app.creditapp.inf.client.entity.RuleFact;
import app.creditapp.inf.client.entity.RuleReturn;
import app.creditapp.ln.bo.LnApplyBo;
import app.creditapp.ln.entity.LnApply;
import app.creditapp.ln.entity.LnApplyMid;
import app.creditapp.ln.entity.LnApplyReg;
import app.creditapp.ln.entity.PreApply;

import com.alibaba.fastjson.JSON;
import com.core.domain.screen.FormData;
import com.core.service.screen.FormService;
import com.core.struts.ActionContext;
import com.core.struts.BaseFormBean;

/**
 * Title: LnApplyAction.java
 * Description:
 **/
public class LnApplyAction extends BaseFormBean {

	//ҳ�洫ֵ
	private LnApply lnApply;
	private List<LnApply> lnApplyList;
	private List<RuleReturn> ruleReturnList;
	//ע��LnApplyBo
	private LnApplyBo lnApplyBo;

	private String query;
	private String appId;		
	
	private List tabList;
	
	private FormData formlnapply0001;
	private FormData formlnapply0002;
	private FormService formService = new FormService();
	
	public LnApplyAction() {
		query = "";
	}
	/**
	 * ��ҳ��ѯ
	 * @return
	 * @throws Exception
	 */
	public String findByPage() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),ServletActionContext.getResponse());
		formlnapply0001 = formService.getFormData("lnapply0001");
		lnApply = new LnApply();
		getFormValue(formlnapply0001);
		setObjValue(formlnapply0001, lnApply);
		lnApply.setBrNo(User.getBrno(this.getHttpRequest()));
		Ipage ipage = this.getIpage();
		lnApplyList = (List) lnApplyBo.findByPage(ipage, lnApply).getResult();
		return "list";
	}
	/**
	 * ����returnID��ѯ��������
	 * @return
	 * @throws Exception
	 */
	public String findByReturnId() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),ServletActionContext.getResponse());
		String resultId = null;
		lnApply = new LnApply();
		lnApply.setAppId(appId);
		lnApply = lnApplyBo.getById(lnApply);
		if(lnApply!=null){
			resultId = lnApply.getResultId();
		}
		if(resultId!=null){
			RulesService rs = (RulesService) SourceTemplate.getSpringContextInstance().getBean("RulesService");
			RequestObj requestObj = new RequestObj();
			Request request = new Request();
			request.setResultId(resultId);
			requestObj.setPassword("1");
			requestObj.setUser("1001");
			requestObj.setRequest(request);
			//���ù�������õ����ص��ַ���
			String str= rs.queryResult(JSON.toJSONString(requestObj));
			ReturnObj ro = (ReturnObj) JSON.parseObject(str, ReturnObj.class);
			if("0000".equals(ro.getResponse().getRuleCode())){
				RuleFact ruleFact = ro.getResponse().getRuleFact().get(0);
//				getObjValue(formappauto0001, ruleFact);
				//���������淵��JSONת��ΪList
				RuleTrans rt = new RuleTrans();
				ruleReturnList = rt.translationAppAuto(ruleFact,lnApply.getPrdtNo());
			}else{
				this.addActionMessage("��ѯ��������ʧ�ܣ�"+ro.getResponse().getRuleMsg()+"!");
			}
		}else{
			this.addActionMessage("���Զ�����ID!");
		}
		return "find";
	}
	
	/**
	 * ��ȡ����ҳ��
	 * @return
	 * @throws Exception
	 */
	public String input() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formlnapply0002 = formService.getFormData("lnapply0002");
		return "input";
	}
	
	/**
	 * �����������
	 * @return
	 * @throws Exception
	 */
	public String insert() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formlnapply0002 = formService.getFormData("lnapply0002");
		getFormValue(formlnapply0002);
		lnApply = new LnApply();
		setObjValue(formlnapply0002, lnApply);
		lnApply.setBrNo(User.getBrno(this.getHttpRequest()));
		//lnApply.setOpNo(User.getTlrno(this.getHttpRequest()));
		lnApply.setTxDate(User.getSys_date(this.getHttpRequest()));
		lnApplyBo.insert(lnApply);
		getObjValue(formlnapply0002, lnApply);
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
		formlnapply0002 = formService.getFormData("lnapply0002");
		getFormValue(formlnapply0002);
		lnApply = new LnApply();
		setObjValue(formlnapply0002, lnApply);
		lnApply.setUpDate(User.getSys_date(this.getHttpRequest()));
		lnApplyBo.update(lnApply);
		getObjValue(formlnapply0002, lnApply);
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
		formlnapply0001 = formService.getFormData("lnapply0001");
		lnApply = new LnApply();
		lnApply.setAppId(appId);
		lnApplyBo.del(lnApply);
		this.addActionMessage("ɾ���ɹ�");
		lnApply = new LnApply();
		lnApply.setBrNo(User.getBrno(this.getHttpRequest()));
		Ipage ipage = this.getIpage();
		lnApplyList = (List) lnApplyBo.findByPage(ipage, lnApply).getResult();
		return "list";
	}

	
	/**
	 * ��ѯ����
	 * @return
	 * @throws Exception
	 */
	public String getById() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),ServletActionContext.getResponse());
		formlnapply0002 = formService.getFormData("lnapply0002");
		lnApply = new LnApply();
		lnApply.setAppId(appId);
		lnApply = lnApplyBo.getById(lnApply);
		getObjValue(formlnapply0002, lnApply);
		return "detail";
	}
	
	/**
	 * �����������У��
	 * @return
	 * @throws Exception
	 */
	public void validateInsert(){
		 ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		 formlnapply0002 = formService.getFormData("lnapply0002");
		 getFormValue(formlnapply0002);
		 validateFormData(formlnapply0002);
   	}
   
	/**
	 * �޸ı������У��
	 * @return
	 * @throws Exception
	 */
	public void validateUpdate(){
		 ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		 formlnapply0002 = formService.getFormData("lnapply0002");
		 getFormValue(formlnapply0002);
		 validateFormData(formlnapply0002);
  	}
	
	/**
	 * �鿴360�ӽ�
	 * @return
	 */
	public String getAllDetail() {
		ActionContext.initialize(ServletActionContext.getRequest(), 
				ServletActionContext.getResponse());
		lnApply = new LnApply();
		lnApply.setAppId(appId);
		lnApply = lnApplyBo.getById(lnApply);
		return "all";
	}
	
	/**
	 * 360��ͼ��tableͷ
	 * @return
	 */
	public String getDetailTop() {
		ActionContext.initialize(ServletActionContext.getRequest(), 
				ServletActionContext.getResponse());
		formlnapply0002 = formService.getFormData("lnapply0002");
		lnApply = new LnApply();
		lnApply.setAppId(appId);
		lnApply = lnApplyBo.getById(lnApply);
		getObjValue(formlnapply0002, lnApply);
		query = "query";
		return "top";
	}
	
	public String getTab() throws Exception{
		ActionContext.initialize(ServletActionContext.getRequest(),
				ServletActionContext.getResponse());
		tabList = new ArrayList();
		String[] tab = null;
		
		tab = new String[2];
		tab[0] = "������Ϣ";
		tab[1] = "LnApplyAction_getById.action?appId=" + appId+ "&query="+ query + "";
		tabList.add(tab);
		
			
		tab = new String[2];
		tab[0] = "�˻���Ϣ";
		tab[1] = "LnAcctAction_listQuotaForLn.action?appId=" + appId+ "&query="+ query + "";
		tabList.add(tab);
			
		tab = new String[2];
		tab[0] = "ѺƷ��Ϣ";
		tab[1] = "LnGageAction_listQuotaForLn.action?appId="+appId+ "&query="+ query + "";
		tabList.add(tab);
		
		
		tab = new String[2];
		tab[0] = "����������Ϣ";
		tab[1] = "LnRelAction_findByPage.action?appId="+appId+ "&query="+ query + "";
		tabList.add(tab);
		
		
		tab = new String[2];
		tab[0] = "��ͬ�������Ϣ";
		tab[1] = "LnComAction_findByPage.action?appId="+appId+ "&query="+ query + "";
		tabList.add(tab);
		
		return "tab";
	}
	
	public LnApply getLnApply() {
		return lnApply;
	}
	public void setLnApply(LnApply  lnApply) {
		this.lnApply = lnApply;
	}
	public List<LnApply> getLnApplyList() {
		return lnApplyList;
	}
	public void setLnApplyList(List<LnApply> lnApplyList) {
		this.lnApplyList = lnApplyList;
	}
	public LnApplyBo getLnApplyBo() {
		return lnApplyBo;
	}
	public void setLnApplyBo(LnApplyBo lnApplyBo) {
		this.lnApplyBo = lnApplyBo;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public FormData getFormlnapply0002() {
		return formlnapply0002;
	}
	public void setFormlnapply0002(FormData formlnapply0002) {
		this.formlnapply0002 = formlnapply0002;
	}
	public FormData getFormlnapply0001() {
		return formlnapply0001;
	}
	public void setFormlnapply0001(FormData formlnapply0001) {
		this.formlnapply0001 = formlnapply0001;
	}
	public void setAppId(String appId){
		this.appId = appId;
	}		
	public String getAppId(){
		return appId;
	}
	public List getTabList() {
		return tabList;
	}
	public void setTabList(List tabList) {
		this.tabList = tabList;
	}
	public List<RuleReturn> getRuleReturnList() {
		return ruleReturnList;
	}
	public void setRuleReturnList(List<RuleReturn> ruleReturnList) {
		this.ruleReturnList = ruleReturnList;
	}
}