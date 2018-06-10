package  app.creditapp.fund.action;
import java.util.List;
import app.util.User;
import org.apache.struts2.ServletActionContext;
import app.util.toolkit.Ipage;
import app.creditapp.fund.bo.FundRepayPlanBo;
import app.creditapp.fund.entity.FundRepayPlan;
import com.core.domain.screen.FormData;
import com.core.service.screen.FormService;
import com.core.struts.ActionContext;
import com.core.struts.BaseFormBean;

/**
 * Title: FundRepayPlanAction.java
 * Description:
 **/
public class FundRepayPlanAction extends BaseFormBean {

	//ҳ�洫ֵ
	private FundRepayPlan fundRepayPlan;
	private List<FundRepayPlan> fundRepayPlanList;

	//ע��FundRepayPlanBo
	private FundRepayPlanBo fundRepayPlanBo;

	private String query;
	private String repayPlanNo;	
	private String fundNo;
	private FormData formfdreplan0001;
	private FormData formfdreplan0002;
	private FormService formService = new FormService();
	
	public FundRepayPlanAction() {
		query = "";
	}
	/**
	 * ��ҳ��ѯ
	 * @return
	 * @throws Exception
	 */
	public String findByPage() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),ServletActionContext.getResponse());
		formfdreplan0001 = formService.getFormData("fdreplan0001");
		fundRepayPlan = new FundRepayPlan();
		fundRepayPlan.setFundNo(fundNo);
		getFormValue(formfdreplan0001);
		setObjValue(formfdreplan0001, fundRepayPlan);
		Ipage ipage = this.getIpage();
		fundRepayPlanList = (List) fundRepayPlanBo.findByPage(ipage, fundRepayPlan).getResult();
		for(int i = 0; i<fundRepayPlanList.size();i++){
			fundRepayPlanList.get(i).setQuery(query);
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
		formfdreplan0002 = formService.getFormData("fdreplan0002");
		return "input";
	}
	
	/**
	 * �����������
	 * @return
	 * @throws Exception
	 */
	public String insert() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formfdreplan0002 = formService.getFormData("fdreplan0002");
		getFormValue(formfdreplan0002);
		fundRepayPlan = new FundRepayPlan();
		setObjValue(formfdreplan0002, fundRepayPlan);
		fundRepayPlanBo.insert(fundRepayPlan);
		this.addActionMessage("�����ɹ�");
		query="query";
		getObjValue(formfdreplan0002, fundRepayPlan);
		return "detail";
	}
	
	
	/**
	 * �޸ı������
	 * @return
	 * @throws Exception
	 */
	public String update() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formfdreplan0002 = formService.getFormData("fdreplan0002");
		getFormValue(formfdreplan0002);
		fundRepayPlan = new FundRepayPlan();
		setObjValue(formfdreplan0002, fundRepayPlan);
		fundRepayPlanBo.update(fundRepayPlan);
		this.addActionMessage("�޸ĳɹ�");
		query="query";
		getObjValue(formfdreplan0002, fundRepayPlan);
		return "detail";
	}
	
	
	
	/**
	 * ɾ������
	 * @return
	 * @throws Exception
	 */
	public String del() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formfdreplan0001 = formService.getFormData("fdreplan0001");
		fundRepayPlan = new FundRepayPlan();
		fundRepayPlan.setRepayPlanNo(repayPlanNo);
		fundRepayPlanBo.del(fundRepayPlan);
		this.addActionMessage("ɾ���ɹ�");
		fundRepayPlan = new FundRepayPlan();
		Ipage ipage = this.getIpage();
		fundRepayPlanList = (List) fundRepayPlanBo.findByPage(ipage, fundRepayPlan).getResult();
		return "list";
	}

	
	/**
	 * ��ѯ����
	 * @return
	 * @throws Exception
	 */
	public String getById() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),ServletActionContext.getResponse());
		formfdreplan0002 = formService.getFormData("fdreplan0002");
		fundRepayPlan = new FundRepayPlan();
		fundRepayPlan.setRepayPlanNo(repayPlanNo);
		fundRepayPlan = fundRepayPlanBo.getById(fundRepayPlan);
		getObjValue(formfdreplan0002, fundRepayPlan);
		return "detail";
	}
	
	/**
	 * �����������У��
	 * @return
	 * @throws Exception
	 */
	public void validateInsert(){
		 ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		 formfdreplan0002 = formService.getFormData("fdreplan0002");
		 getFormValue(formfdreplan0002);
		 validateFormData(formfdreplan0002);
   	}
   
	/**
	 * �޸ı������У��
	 * @return
	 * @throws Exception
	 */
	public void validateUpdate(){
		 ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		 formfdreplan0002 = formService.getFormData("fdreplan0002");
		 getFormValue(formfdreplan0002);
		 validateFormData(formfdreplan0002);
  	}
	public FundRepayPlan getFundRepayPlan() {
		return fundRepayPlan;
	}
	public void setFundRepayPlan(FundRepayPlan  fundRepayPlan) {
		this.fundRepayPlan = fundRepayPlan;
	}
	public List<FundRepayPlan> getFundRepayPlanList() {
		return fundRepayPlanList;
	}
	public void setFundRepayPlanList(List<FundRepayPlan> fundRepayPlanList) {
		this.fundRepayPlanList = fundRepayPlanList;
	}
	public FundRepayPlanBo getFundRepayPlanBo() {
		return fundRepayPlanBo;
	}
	public void setFundRepayPlanBo(FundRepayPlanBo fundRepayPlanBo) {
		this.fundRepayPlanBo = fundRepayPlanBo;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public FormData getFormfdreplan0002() {
		return formfdreplan0002;
	}
	public void setFormfdreplan0002(FormData formfdreplan0002) {
		this.formfdreplan0002 = formfdreplan0002;
	}
	public FormData getFormfdreplan0001() {
		return formfdreplan0001;
	}
	public void setFormfdreplan0001(FormData formfdreplan0001) {
		this.formfdreplan0001 = formfdreplan0001;
	}
	public void setRepayPlanNo(String repayPlanNo){
		this.repayPlanNo = repayPlanNo;
	}		
	public String getRepayPlanNo(){
		return repayPlanNo;
	}
	public String getFundNo() {
		return fundNo;
	}
	public void setFundNo(String fundNo) {
		this.fundNo = fundNo;
	}
}