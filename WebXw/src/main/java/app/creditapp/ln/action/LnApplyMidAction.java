package  app.creditapp.ln.action;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import app.base.SourceTemplate;
import app.creditapp.inf.client.RuleTrans;
import app.creditapp.inf.client.RulesService;
import app.creditapp.inf.client.entity.Request;
import app.creditapp.inf.client.entity.RequestObj;
import app.creditapp.inf.client.entity.ReturnObj;
import app.creditapp.inf.client.entity.RuleFact;
import app.creditapp.inf.client.entity.RuleReturn;
import app.creditapp.ln.bo.LnApplyMidBo;
import app.creditapp.ln.bo.LnStageBo;
import app.creditapp.ln.entity.LnApplyMid;
import app.creditapp.ln.entity.LnApprIdea;
import app.creditapp.ln.entity.LnFail;
import app.creditapp.ln.entity.LnStage;
import app.util.User;
import app.util.toolkit.Ipage;

import com.alibaba.fastjson.JSON;
import com.core.domain.screen.FormData;
import com.core.service.screen.FormService;
import com.core.struts.ActionContext;
import com.core.struts.BaseFormBean;
      
/**
 * Title: LnApplyMidAction.java
 * Description:
 **/
public class LnApplyMidAction extends BaseFormBean {

	//ҳ�洫ֵ
	private LnApplyMid lnApplyMid;
	private List<LnApplyMid> lnApplyMidList;
	private List<LnFail> lnFailList;
	private String backSts;
	private String res;
	public String getBackSts() {
		return backSts;
	}
	public void setBackSts(String backSts) {
		this.backSts = backSts;
	}

	private List<RuleReturn> ruleReturnList;
	public List<LnFail> getLnFailList() {
		return lnFailList;
	}
	public void setLnFailList(List<LnFail> lnFailList) {
		this.lnFailList = lnFailList;
	}
	
	private LnStage lnStage;
	private LnStageBo lnStageBo;
	//ע��LnApplyMidBo
	private LnApplyMidBo lnApplyMidBo;

	private String query;
	private String appId;
	private String chkSts;
	private String zdappSts;
	private String rgappSts;
	
	private List tabList;
	
	private FormData formlnapplymid0001;
	private FormData formlnapplymid0002;
	private FormData formlnapplymid0003;
	private FormData formlnapplymid0004;
	private FormData formlnapplymid0013;
	private FormData formappauto0001;
	private FormData formlnfail0001;
	private FormService formService = new FormService();
	
	public LnApplyMidAction() {
		query = "";
	}
	/**
	 * ��ʽ������ϸ��ѯ
	 * @return
	 * @throws Exception
	 */
	public String findByPage() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),ServletActionContext.getResponse());
		formlnapplymid0003 = formService.getFormData("lnapplymid0003");
		lnApplyMid = new LnApplyMid();
		getFormValue(formlnapplymid0003);
		setObjValue(formlnapplymid0003, lnApplyMid);
		lnApplyMid.setBrNo(User.getBrno(this.getHttpRequest()));
		Ipage ipage = this.getIpage();
		lnApplyMidList = (List) lnApplyMidBo.findByPage(ipage, lnApplyMid).getResult();
		return "list";
	}
	/**
	 * ��ʽ������ϸ/ͳ�Ʋ�ѯ
	 * @return
	 * @throws Exception
	 */
	public String findByPageForSta() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),ServletActionContext.getResponse());
		formlnapplymid0013 = formService.getFormData("lnapplymid0013");
		lnApplyMid = new LnApplyMid();
		getFormValue(formlnapplymid0013);
		setObjValue(formlnapplymid0013, lnApplyMid);
		lnApplyMid.setLoginid(User.getLoginIdByAuth(this.getHttpRequest())); // ��session�л�ȡȨ��
		Ipage ipage = this.getIpage();
		lnApplyMidList = (List) lnApplyMidBo.findByPage(ipage, lnApplyMid).getResult();
		return "list";
	}
	/**
	 * �鿴360�ӽ�
	 * @return
	 */
	public String getAllDetail() {
		ActionContext.initialize(ServletActionContext.getRequest(), 
				ServletActionContext.getResponse());
		lnApplyMid = new LnApplyMid();
		lnApplyMid.setAppId(appId);
		lnApplyMid = lnApplyMidBo.getById(lnApplyMid);
		return "all";
	}
	/**
	 * ����ʧ�ܺͷſ�ʧ��
	 * @return
	 */
	public String getAllDetailFail() {
		ActionContext.initialize(ServletActionContext.getRequest(), 
				ServletActionContext.getResponse());
		lnApplyMid = new LnApplyMid();
		lnApplyMid.setAppId(appId);
		lnApplyMid = lnApplyMidBo.getById(lnApplyMid);
		return "all";
	}
	public String getTabFail() throws Exception{
		ActionContext.initialize(ServletActionContext.getRequest(),
				ServletActionContext.getResponse());
		
		lnStage = new LnStage();
		lnStage.setAppId(appId);
		lnStage = lnStageBo.getById(lnStage);
		
		tabList = new ArrayList();
		String[] tab = null;
		
		tab = new String[2];
		tab[0] = "��ʽ��������";
		tab[1] = "LnApplyMidAction_getByIdToLn.action?appId=" + appId+ "&query=query";
		tabList.add(tab);
		
			
		tab = new String[2];
		tab[0] = "�˻���Ϣ";
		tab[1] = "LnAcctMidAction_listQuotaForLn_Read.action?appId=" + appId+ "&query="+ query + "";
		tabList.add(tab);
			
		tab = new String[2];
		tab[0] = "ѺƷ��Ϣ";
		tab[1] = "LnGageMidAction_listQuotaForLn_Read.action?appId="+appId+ "&query="+ query + "";
		tabList.add(tab);
		
		
		if("03".equals(lnStage.getChkSts())){
			tab = new String[2];
			tab[0]="ɸ������Ϣ";
			tab[1]="LnApplyMidAction_findByChk.action?appId="+appId+ "&query=query";
			tabList.add(tab);
		}


		if("03".equals(lnStage.getRgappSts())){
			tab = new String[2];
			tab[0]="�˹����������Ϣ";
			tab[1]="LnApprIdeaAction_findByAppId.action?appId="+appId+ "&query=query";
			tabList.add(tab);
		}
		
		return "tab";
	}
	/**
	 * ����returnID��ѯ��������
	 * @return
	 * @throws Exception
	 */
	public String findByReturnId() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),ServletActionContext.getResponse());
		lnApplyMid = new LnApplyMid();
		lnApplyMid.setAppId(appId);
		lnApplyMid = lnApplyMidBo.getById(lnApplyMid);
		String resultId = lnApplyMid.getIfFlag();
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
				ruleReturnList = rt.translationAppAuto(ruleFact,lnApplyMid.getPrdtNo());
				res = "2";
//				for(int i=0;i<ruleReturnList.size();i++){
//					if("03".equals(ruleReturnList.get(i).getCodeRes())){
//						res = "3";
//						break;
//					}
//				}
			}else{
				this.addActionMessage("��ѯ��������ʧ�ܣ�"+ro.getResponse().getRuleMsg()+"!");
			}
		}else{
			this.addActionMessage("���Զ�����ID!");
		}
		return "find";
	}
	
	/**
	 * ɸ������ѯ
	 * @return
	 * @throws Exception
	 */
	public String findByChk() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),ServletActionContext.getResponse());
		lnApplyMid = new LnApplyMid();
		lnApplyMid.setAppId(appId);
		lnApplyMid = lnApplyMidBo.getById(lnApplyMid);
		if(lnApplyMid.getChkRes()!=null){
			RuleTrans rt = new RuleTrans();
			ruleReturnList = rt.translationLnChk(lnApplyMid);
		}
		res = "2";
		for(int i=0;i<ruleReturnList.size();i++){
			if("02".equals(ruleReturnList.get(i).getCodeRes())){
				res = "3";
				break;
			}
		}
		return "list";
	}
	/**
	 * ��ȡ����ҳ��
	 * @return
	 * @throws Exception
	 */
	public String input() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formlnapplymid0002 = formService.getFormData("lnapplymid0002");
		return "input";
	}
	
	/**
	 * �����������
	 * @return
	 * @throws Exception
	 */
	public String insert() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formlnapplymid0002 = formService.getFormData("lnapplymid0002");
		getFormValue(formlnapplymid0002);
		lnApplyMid = new LnApplyMid();
		setObjValue(formlnapplymid0002, lnApplyMid);
		lnApplyMid.setBrNo(User.getBrno(this.getHttpRequest()));
		lnApplyMidBo.insert(lnApplyMid);
		getObjValue(formlnapplymid0002, lnApplyMid);
		return "detail";
	}
	
	
	/**
	 * �޸ı������
	 * @return
	 * @throws Exception
	 */
	public String update() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formlnapplymid0002 = formService.getFormData("lnapplymid0002");
		getFormValue(formlnapplymid0002);
		lnApplyMid = new LnApplyMid();
		setObjValue(formlnapplymid0002, lnApplyMid);
		lnApplyMidBo.update(lnApplyMid);
		getObjValue(formlnapplymid0002, lnApplyMid);
		return "detail";
	}
	
	
	
	/**
	 * ɾ������
	 * @return
	 * @throws Exception
	 */
	public String del() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formlnapplymid0001 = formService.getFormData("lnapplymid0001");
		lnApplyMid = new LnApplyMid();
		lnApplyMid.setAppId(appId);
		lnApplyMidBo.del(lnApplyMid);
		this.addActionMessage("ɾ���ɹ�");
		lnApplyMid = new LnApplyMid();
		lnApplyMid.setBrNo(User.getBrno(this.getHttpRequest()));
		Ipage ipage = this.getIpage();
		lnApplyMidList = (List) lnApplyMidBo.findByPage(ipage, lnApplyMid).getResult();
		return "list";
	}

	public String getTab() throws Exception{
		ActionContext.initialize(ServletActionContext.getRequest(),
				ServletActionContext.getResponse());
		
		lnStage = new LnStage();
		lnStage.setAppId(appId);
		lnStage = lnStageBo.getById(lnStage);
		lnApplyMid = new LnApplyMid();
		lnApplyMid.setAppId(appId);
		lnApplyMid = lnApplyMidBo.getById(lnApplyMid);
		tabList = new ArrayList();
		String[] tab = null;
		
		tab = new String[2];
		tab[0] = "��ʽ��������";
		tab[1] = "LnApplyMidAction_getByIdToLn.action?appId=" + appId+ "&query=query";
		tabList.add(tab);
		
			
		tab = new String[2];
		tab[0] = "�˻���Ϣ";
		tab[1] = "LnAcctMidAction_listQuotaForLn.action?appId=" + appId+ "&query="+ query + "";
		tabList.add(tab);
			
		tab = new String[2];
		tab[0] = "ѺƷ��Ϣ";
		tab[1] = "LnGageMidAction_listQuotaForLn.action?appId="+appId+ "&query="+ query + "";
		tabList.add(tab);
		
		if("02".equals(lnStage.getChkSts())||"03".equals(lnStage.getChkSts())){
			tab = new String[2];
			tab[0]="ɸ������Ϣ";
			tab[1]="LnApplyMidAction_findByChk.action?appId="+appId+ "&query=query";
			tabList.add(tab);
		}
		

		if("02".equals(lnStage.getRgappSts())||"03".equals(lnStage.getRgappSts())){
			tab = new String[2];
			tab[0]="�˹����������Ϣ";
			tab[1]="LnApprIdeaAction_findByAppId.action?appId="+appId+ "&query=query";
			tabList.add(tab);
		}
		
		
		return "tab";
	}
	
	/**
	 * ��ѯ����
	 * @return
	 * @throws Exception
	 */
	public String getById() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),ServletActionContext.getResponse());
		formlnapplymid0002 = formService.getFormData("lnapplymid0002");
		lnApplyMid = new LnApplyMid();
		lnApplyMid.setAppId(appId);
		lnApplyMid = lnApplyMidBo.getById(lnApplyMid);
		getObjValue(formlnapplymid0002, lnApplyMid);
		return "detail";
	}
	/**
	 * ��ѯ����
	 * @return
	 * @throws Exception
	 */
	public String getByIdToLn() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),ServletActionContext.getResponse());
		formlnapplymid0004 = formService.getFormData("lnapplymid0004");
		lnApplyMid = new LnApplyMid();
		lnApplyMid.setAppId(appId);
		lnApplyMid = lnApplyMidBo.getById(lnApplyMid);
		getObjValue(formlnapplymid0004, lnApplyMid);
		return "detail";
	}
	/**
	 * �����������У��
	 * @return
	 * @throws Exception
	 */
	public void validateInsert(){
		 ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		 formlnapplymid0002 = formService.getFormData("lnapplymid0002");
		 getFormValue(formlnapplymid0002);
		 validateFormData(formlnapplymid0002);
   	}
   
	/**
	 * �޸ı������У��
	 * @return
	 * @throws Exception
	 */
	public void validateUpdate(){
		 ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		 formlnapplymid0002 = formService.getFormData("lnapplymid0002");
		 getFormValue(formlnapplymid0002);
		 validateFormData(formlnapplymid0002);
  	}
	
	/**
	 * ����ʧ�ܷ�ҳ��ѯ
	 * @return
	 * @throws Exception
	 */
	public String findByPageToLnFail() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),ServletActionContext.getResponse());
		formlnfail0001 = formService.getFormData("lnfail0001");
		lnApplyMid = new LnApplyMid();
		getFormValue(formlnfail0001);
		setObjValue(formlnfail0001, lnApplyMid);
		if(lnApplyMid.getBrNo()==null||"".equals(lnApplyMid.getBrNo())){
			//this.addActionMessage("��������������Ž��в�ѯ!");
			return "list";
		}
		lnApplyMid.setLoginid(User.getLoginIdByAuth(this.getHttpRequest())); // ��session�л�ȡȨ��
		Ipage ipage = this.getIpage();
		lnFailList = (List) lnApplyMidBo.findByPageToLnFail(ipage, lnApplyMid).getResult();
		return "list";
	}
	
	public FormData getFormlnfail0001() {
		return formlnfail0001;
	}
	public void setFormlnfail0001(FormData formlnfail0001) {
		this.formlnfail0001 = formlnfail0001;
	}
	public LnApplyMid getLnApplyMid() {
		return lnApplyMid;
	}
	public void setLnApplyMid(LnApplyMid  lnApplyMid) {
		this.lnApplyMid = lnApplyMid;
	}
	public List<LnApplyMid> getLnApplyMidList() {
		return lnApplyMidList;
	}
	public void setLnApplyMidList(List<LnApplyMid> lnApplyMidList) {
		this.lnApplyMidList = lnApplyMidList;
	}
	public LnApplyMidBo getLnApplyMidBo() {
		return lnApplyMidBo;
	}
	public void setLnApplyMidBo(LnApplyMidBo lnApplyMidBo) {
		this.lnApplyMidBo = lnApplyMidBo;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public FormData getFormlnapplymid0002() {
		return formlnapplymid0002;
	}
	public void setFormlnapplymid0002(FormData formlnapplymid0002) {
		this.formlnapplymid0002 = formlnapplymid0002;
	}
	public FormData getFormlnapplymid0001() {
		return formlnapplymid0001;
	}
	public void setFormlnapplymid0001(FormData formlnapplymid0001) {
		this.formlnapplymid0001 = formlnapplymid0001;
	}
	public FormData getFormlnapplymid0003() {
		return formlnapplymid0003;
	}
	public void setFormlnapplymid0003(FormData formlnapplymid0003) {
		this.formlnapplymid0003 = formlnapplymid0003;
	}
	public FormData getFormappauto0001() {
		return formappauto0001;
	}
	public void setFormappauto0001(FormData formappauto0001) {
		this.formappauto0001 = formappauto0001;
	}
	public FormData getFormlnapplymid0004() {
		return formlnapplymid0004;
	}
	public void setFormlnapplymid0004(FormData formlnapplymid0004) {
		this.formlnapplymid0004 = formlnapplymid0004;
	}
	public LnStage getLnStage() {
		return lnStage;
	}
	public void setLnStage(LnStage lnStage) {
		this.lnStage = lnStage;
	}
	public LnStageBo getLnStageBo() {
		return lnStageBo;
	}
	public void setLnStageBo(LnStageBo lnStageBo) {
		this.lnStageBo = lnStageBo;
	}
	public List getTabList() {
		return tabList;
	}
	public void setTabList(List tabList) {
		this.tabList = tabList;
	}
	public void setAppId(String appId){
		this.appId = appId;
	}		
	public String getAppId(){
		return appId;
	}
	public List<RuleReturn> getRuleReturnList() {
		return ruleReturnList;
	}
	public void setRuleReturnList(List<RuleReturn> ruleReturnList) {
		this.ruleReturnList = ruleReturnList;
	}
	public FormData getFormlnapplymid0013() {
		return formlnapplymid0013;
	}
	public void setFormlnapplymid0013(FormData formlnapplymid0013) {
		this.formlnapplymid0013 = formlnapplymid0013;
	}
	public String getChkSts() {
		return chkSts;
	}
	public void setChkSts(String chkSts) {
		this.chkSts = chkSts;
	}
	public String getZdappSts() {
		return zdappSts;
	}
	public void setZdappSts(String zdappSts) {
		this.zdappSts = zdappSts;
	}
	public String getRgappSts() {
		return rgappSts;
	}
	public void setRgappSts(String rgappSts) {
		this.rgappSts = rgappSts;
	}
	public String getRes() {
		return res;
	}
	public void setRes(String res) {
		this.res = res;
	}
	
}