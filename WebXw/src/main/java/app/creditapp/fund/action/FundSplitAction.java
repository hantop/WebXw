package  app.creditapp.fund.action;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.core.domain.screen.FormData;
import com.core.service.screen.FormService;
import com.core.struts.ActionContext;
import com.core.struts.BaseFormBean;

import app.creditapp.fund.bo.FundPayPlanBo;
import app.creditapp.fund.bo.FundSplitBo;
import app.creditapp.fund.entity.FundRel;
import app.creditapp.fund.entity.FundSplit;
import app.util.User;
import app.util.toolkit.Ipage;
/**
 * Title: FundSplitAction.java
 * Description:
 **/
public class FundSplitAction extends BaseFormBean {

	//ҳ�洫ֵ
	private FundSplit fundSplit;
	private List<FundSplit> fundSplitList;

	//ע��FundSplitBo
	private FundSplitBo fundSplitBo;

	private String query;	
	private String partNo;		
	private String fundNo;
	private FundRel fundRel;
	private FormData formfdsplit0001;
	private FormData formfdsplit0002;
	private FormService formService = new FormService();
	
	//�Ҹ��ƻ�����������
	private FundPayPlanBo fundPayPlanBo;

	private List tabList;
	
	public FundSplitAction() {
		query = "";
	}
	/**
	 * ��ҳ��ѯ
	 * @return
	 * @throws Exception
	 */
	public String findByPage() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),ServletActionContext.getResponse());
		formfdsplit0001 = formService.getFormData("fdsplit0001");
		fundSplit = new FundSplit();
		getFormValue(formfdsplit0001);
		setObjValue(formfdsplit0001, fundSplit);
		Ipage ipage = this.getIpage();
		fundSplitList = (List) fundSplitBo.findByPage(ipage, fundSplit).getResult();
		for(int i = 0; i<fundSplitList.size();i++){
			fundSplitList.get(i).setQuery(query);
		}
		return "list";
	}
	public String echarts() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),ServletActionContext.getResponse());
		fundSplit = new FundSplit();
		fundSplit.setFundNo(fundNo);
		fundSplitList = (List) fundSplitBo.echarts(fundSplit);
		
		String nodes = "";
		for(FundSplit fund: fundSplitList){
			nodes += ",{name:'"+fund.getPartName()+"',value:"+fund.getPartAmt()+"}";
		}
		if(nodes.length()>0){
			nodes = nodes.substring(1);
		}
		fundRel = new FundRel();
		fundRel.setTitle("");
		fundRel.setName("");
		fundRel.setData("");
		fundRel.setNodes(nodes);
		return "list";
	}
	
	/**
	 * ��ȡ����ҳ��
	 * @return
	 * @throws Exception
	 */
	public String input() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formfdsplit0002 = formService.getFormData("fdsplit0002");
		fundSplit = new FundSplit();
		fundSplit.setOpNo(User.getLoginid(this.getHttpRequest()));
		fundSplit.setFundNo(fundNo);
		getObjValue(formfdsplit0002, fundSplit);
		this.changeFormProperty(formfdsplit0002, "opNo", "readonly", "1");//1��ֻ����0�ǿɱ༭
		return "input";
	}
	
	/**
	 * �����������
	 * @return
	 * @throws Exception
	 */
	public String insert() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formfdsplit0002 = formService.getFormData("fdsplit0002");
		getFormValue(formfdsplit0002);
		fundSplit = new FundSplit();
		setObjValue(formfdsplit0002, fundSplit);
		fundSplitBo.insert(fundSplit);
		//�����Ҹ��ƻ�
		fdpayplan_insert(fundSplit);
		this.addActionMessage("�����ɹ�");
		query="query";
		getObjValue(formfdsplit0002, fundSplit);
		return "detail";
	}
	
	/**
	 * �޸ı������
	 * @return
	 * @throws Exception
	 */
	public String update() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formfdsplit0002 = formService.getFormData("fdsplit0002");
		getFormValue(formfdsplit0002);
		fundSplit = new FundSplit();
		setObjValue(formfdsplit0002, fundSplit);
		HttpServletRequest request = ServletActionContext.getRequest();
		fundSplit.setInvRate(Float.parseFloat(request.getParameter("invRate"))/100F);
		fundSplit.setOpNo(User.getLoginid(this.getHttpRequest()));
		fundSplitBo.update(fundSplit);
		//�޸ĶҸ��ƻ�
		fdpayplan_insert(fundSplit);
		this.addActionMessage("�޸ĳɹ�");
		query="query";
		getObjValue(formfdsplit0002, fundSplit);
		return "detail";
	}
	
	/**
	 * ���䷽��������ӶҸ��ƻ�����,���䷽��������Ҫ��ʼʱ�䣬����ʱ�䣬�Ҹ���ʽ��������������
	 * @return
	 * @throws Exception
	 */
	public String fdpayplan_insert(FundSplit fundSplit) throws Exception {
		
		// �ж��Ƿ���ڷ�����ţ��Ҹ���ʽ 
		if(fundSplit.getPayType()!=null && fundSplit.getInvRate() !=null){
			fundPayPlanBo.auto_insert(fundSplit);
		}
		
		return "detail";
	}
		
	/**
	 * ɾ������
	 * @return
	 * @throws Exception
	 */
	public String del() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formfdsplit0001 = formService.getFormData("fdsplit0001");
		fundSplit = new FundSplit();
		fundSplit.setPartNo(partNo);
		fundSplitBo.del(fundSplit);
		this.addActionMessage("ɾ���ɹ�");
		fundSplit = new FundSplit();
		Ipage ipage = this.getIpage();
		fundSplitList = (List) fundSplitBo.findByPage(ipage, fundSplit).getResult();
		return "list";
	}

	
	/**
	 * ��ѯ����
	 * @return
	 * @throws Exception
	 */
	public String getById() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),ServletActionContext.getResponse());
		formfdsplit0002 = formService.getFormData("fdsplit0002");
		if(("query1").equals(query)){
			query="query";
		}
		fundSplit = new FundSplit();
		fundSplit.setPartNo(partNo);
		fundSplit = fundSplitBo.getById(fundSplit);
		getObjValue(formfdsplit0002, fundSplit);
		this.changeFormProperty(formfdsplit0002, "opNo", "readonly", "1");//1��ֻ����0�ǿɱ༭
		return "detail";
	}
	/**
	 * �����������У��
	 * @return
	 * @throws Exception
	 */
	public void validateInsert(){
		 ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		 formfdsplit0002 = formService.getFormData("fdsplit0002");
		 getFormValue(formfdsplit0002);
		 validateFormData(formfdsplit0002);
   	}
   
	/**
	 * �޸ı������У��
	 * @return
	 * @throws Exception
	 */
	public void validateUpdate(){
		 ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		 formfdsplit0002 = formService.getFormData("fdsplit0002");
		 getFormValue(formfdsplit0002);
		 validateFormData(formfdsplit0002);
  	}
	public FundSplit getFundSplit() {
		return fundSplit;
	}
	public void setFundSplit(FundSplit  fundSplit) {
		this.fundSplit = fundSplit;
	}
	public List<FundSplit> getFundSplitList() {
		return fundSplitList;
	}
	public void setFundSplitList(List<FundSplit> fundSplitList) {
		this.fundSplitList = fundSplitList;
	}
	public FundSplitBo getFundSplitBo() {
		return fundSplitBo;
	}
	public void setFundSplitBo(FundSplitBo fundSplitBo) {
		this.fundSplitBo = fundSplitBo;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public FormData getFormfdsplit0002() {
		return formfdsplit0002;
	}
	public void setFormfdsplit0002(FormData formfdsplit0002) {
		this.formfdsplit0002 = formfdsplit0002;
	}
	public FormData getFormfdsplit0001() {
		return formfdsplit0001;
	}
	public void setFormfdsplit0001(FormData formfdsplit0001) {
		this.formfdsplit0001 = formfdsplit0001;
	}	
	public void setPartNo(String partNo){
		this.partNo = partNo;
	}		
	public String getPartNo(){
		return partNo;
	}
	//�Ҹ��ƻ���������
	
	public FundPayPlanBo getFundPayPlanBo() {
		return fundPayPlanBo;
	}
	public void setFundPayPlanBo(FundPayPlanBo fundPayPlanBo) {
		this.fundPayPlanBo = fundPayPlanBo;
	}
	public String getFundNo() {
		return fundNo;
	}
	public void setFundNo(String fundNo) {
		this.fundNo = fundNo;
	}
	public List getTabList() {
		return tabList;
	}
	public void setTabList(List tabList) {
		this.tabList = tabList;
	}
	public FundRel getFundRel() {
		return fundRel;
	}
	public void setFundRel(FundRel fundRel) {
		this.fundRel = fundRel;
	}
}