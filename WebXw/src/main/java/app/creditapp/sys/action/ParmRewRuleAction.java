package  app.creditapp.sys.action;
import java.util.List;
import app.util.User;
import org.apache.struts2.ServletActionContext;
import app.util.toolkit.Ipage;
import app.creditapp.sec.entity.SecurityAudit;
import app.creditapp.sys.bo.ParmRewRuleBo;
import app.creditapp.sys.entity.ParmRewRule;
import com.core.domain.screen.FormData;
import com.core.service.screen.FormService;
import com.core.struts.ActionContext;
import com.core.struts.BaseFormBean;

/**
 * Title: ParmRewRuleAction.java
 * Description:
 **/
public class ParmRewRuleAction extends BaseFormBean {

	//ҳ�洫ֵ
	private ParmRewRule parmRewRule;
	private List<ParmRewRule> parmRewRuleList;

	//ע��ParmRewRuleBo
	private ParmRewRuleBo parmRewRuleBo;

	private String query;
	private String ruleId;
	private String ruleSts;
	private FormData formsys0016;
	private FormData formsys0017;
	private FormService formService = new FormService();
	
	public ParmRewRuleAction() {
		query = "";
	}
	/**
	 * ��ҳ��ѯ
	 * @return
	 * @throws Exception
	 */
	public String findByPage() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),ServletActionContext.getResponse());
		formsys0016 = formService.getFormData("sys0016");
		parmRewRule = new ParmRewRule();
		getFormValue(formsys0016);
		String s = ruleId;
		setObjValue(formsys0016, parmRewRule);
		parmRewRuleList = parmRewRuleBo.findAll(parmRewRule);
		ServletActionContext.getRequest().setAttribute("auditlist", parmRewRuleList);
		return "list";
	}
	/**
	 * ��ҳ��ѯ
	 * @return
	 * @throws Exception
	 */
	public String findByPageSts() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),ServletActionContext.getResponse());
		formsys0016 = formService.getFormData("sys0016");
		parmRewRule = new ParmRewRule();
		setObjValue(formsys0016, parmRewRule);
		parmRewRuleList = parmRewRuleBo.findAll(parmRewRule);
		ServletActionContext.getRequest().setAttribute("auditlist", parmRewRuleList);
		return "list";
	}
	/**
	 * �޸ı������
	 * @return
	 * @throws Exception
	 */
	public String updateRuleSts() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		parmRewRule = new ParmRewRule();
		parmRewRule.setRuleId(ruleId);
		ruleSts = "1".equals(ruleSts)?"0":"1";
		parmRewRule.setRuleSts(ruleSts);
		parmRewRuleBo.updateRuleSts(parmRewRule);
		return findByPageSts();
	}
	
	/**
	 * ��ȡ����ҳ��
	 * @return
	 * @throws Exception
	 */
	public String input() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formsys0017 = formService.getFormData("sys0017");
		return "input";
	}
	
	/**
	 * �����������
	 * @return
	 * @throws Exception
	 */
	public String insert() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formsys0017 = formService.getFormData("sys0017");
		getFormValue(formsys0017);
		parmRewRule = new ParmRewRule();
		setObjValue(formsys0017, parmRewRule);
		parmRewRuleBo.insert(parmRewRule);
		getObjValue(formsys0017, parmRewRule);
		return "detail";
	}
	
	
	/**
	 * �޸ı������
	 * @return
	 * @throws Exception
	 */
	public String update() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formsys0017 = formService.getFormData("sys0017");
		getFormValue(formsys0017);
		parmRewRule = new ParmRewRule();
		setObjValue(formsys0017, parmRewRule);
		parmRewRuleBo.update(parmRewRule);
		getObjValue(formsys0017, parmRewRule);
		return "detail";
	}
	
	
	
	/**
	 * ɾ������
	 * @return
	 * @throws Exception
	 */
	public String del() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formsys0016 = formService.getFormData("sys0016");
		parmRewRule = new ParmRewRule();
		parmRewRule.setRuleId(ruleId);
		parmRewRuleBo.del(parmRewRule);
		this.addActionMessage("ɾ���ɹ�");
		parmRewRule = new ParmRewRule();
		Ipage ipage = this.getIpage();
		parmRewRuleList = (List) parmRewRuleBo.findByPage(ipage, parmRewRule).getResult();
		return "list";
	}

	
	/**
	 * ��ѯ����
	 * @return
	 * @throws Exception
	 */
	public String getById() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),ServletActionContext.getResponse());
		formsys0017 = formService.getFormData("sys0017");
		parmRewRule = new ParmRewRule();
		parmRewRule.setRuleId(ruleId);
		parmRewRule = parmRewRuleBo.getById(parmRewRule);
		getObjValue(formsys0017, parmRewRule);
		return "detail";
	}
	
	/**
	 * �����������У��
	 * @return
	 * @throws Exception
	 */
	public void validateInsert(){
		 ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		 formsys0017 = formService.getFormData("sys0017");
		 getFormValue(formsys0017);
		 validateFormData(formsys0017);
   	}
   
	/**
	 * �޸ı������У��
	 * @return
	 * @throws Exception
	 */
	public void validateUpdate(){
		 ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		 formsys0017 = formService.getFormData("sys0017");
		 getFormValue(formsys0017);
		 validateFormData(formsys0017);
  	}
	public ParmRewRule getParmRewRule() {
		return parmRewRule;
	}
	public void setParmRewRule(ParmRewRule  parmRewRule) {
		this.parmRewRule = parmRewRule;
	}
	public List<ParmRewRule> getParmRewRuleList() {
		return parmRewRuleList;
	}
	public void setParmRewRuleList(List<ParmRewRule> parmRewRuleList) {
		this.parmRewRuleList = parmRewRuleList;
	}
	public ParmRewRuleBo getParmRewRuleBo() {
		return parmRewRuleBo;
	}
	public void setParmRewRuleBo(ParmRewRuleBo parmRewRuleBo) {
		this.parmRewRuleBo = parmRewRuleBo;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public FormData getFormsys0017() {
		return formsys0017;
	}
	public void setFormsys0017(FormData formsys0017) {
		this.formsys0017 = formsys0017;
	}
	public FormData getFormsys0016() {
		return formsys0016;
	}
	public void setFormsys0016(FormData formsys0016) {
		this.formsys0016 = formsys0016;
	}
	public void setRuleId(String ruleId){
		this.ruleId = ruleId;
	}		
	public String getRuleId(){
		return ruleId;
	}
	public String getRuleSts() {
		return ruleSts;
	}
	public void setRuleSts(String ruleSts) {
		this.ruleSts = ruleSts;
	}
}