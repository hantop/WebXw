package  app.creditapp.ln.action;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import app.creditapp.ln.bo.PreBatchBo;
import app.creditapp.ln.entity.PreBatch;
import app.util.User;
import app.util.toolkit.Ipage;

import com.alibaba.fastjson.JSON;
import com.core.domain.screen.FormData;
import com.core.service.screen.FormService;
import com.core.struts.ActionContext;
import com.core.struts.BaseFormBean;

/**
 * Title: PreBatchAction.java
 * Description:
 **/
public class PreBatchAction extends BaseFormBean {

	//ҳ�洫ֵ
	private PreBatch preBatch;
	private List<PreBatch> preBatchList;

	//ע��PreBatchBo
	private PreBatchBo preBatchBo;

	private String query;
	private String batchNo;		
	private FormData formlnprebatch0001;
	private FormData formlnprebatch0002;
	private FormService formService = new FormService();
	
	private List tabList;
	

	public PreBatchAction() {
		query = "";
	}
	/**
	 * ��ҳ��ѯ
	 * @return
	 * @throws Exception
	 */
	public String findByPage() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),ServletActionContext.getResponse());
		formlnprebatch0001 = formService.getFormData("lnprebatch0001");
		preBatch = new PreBatch();
		getFormValue(formlnprebatch0001);
		setObjValue(formlnprebatch0001, preBatch);
//		preBatch.setBrNo(User.getBrno(this.getHttpRequest()));
		preBatch.setLoginid(User.getLoginIdByAuth(this.getHttpRequest()));
		Ipage ipage = this.getIpage();
		preBatchList = (List) preBatchBo.findByPage(ipage, preBatch).getResult();
		return "list";
	}
	
	
	/**
	 * ��ȡ����ҳ��
	 * @return
	 * @throws Exception
	 */
	public String input() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formlnprebatch0002 = formService.getFormData("lnprebatch0002");
		return "input";
	}
	
	/**
	 * �����������
	 * @return
	 * @throws Exception
	 */
	public String insert() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formlnprebatch0002 = formService.getFormData("lnprebatch0002");
		getFormValue(formlnprebatch0002);
		preBatch = new PreBatch();
		setObjValue(formlnprebatch0002, preBatch);
		preBatch.setBrNo(User.getBrno(this.getHttpRequest()));
		preBatchBo.insert(preBatch);
		getObjValue(formlnprebatch0002, preBatch);
		return "detail";
	}
	
	
	/**
	 * �޸ı������
	 * @return
	 * @throws Exception
	 */
	public String update() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formlnprebatch0002 = formService.getFormData("lnprebatch0002");
		getFormValue(formlnprebatch0002);
		preBatch = new PreBatch();
		setObjValue(formlnprebatch0002, preBatch);
		preBatchBo.update(preBatch);
		getObjValue(formlnprebatch0002, preBatch);
		return "detail";
	}
	
	
	
	/**
	 * ɾ������
	 * @return
	 * @throws Exception
	 */
	public String del() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formlnprebatch0001 = formService.getFormData("lnprebatch0001");
		preBatch = new PreBatch();
		preBatch.setBatchNo(batchNo);
		preBatchBo.del(preBatch);
		this.addActionMessage("ɾ���ɹ�");
		preBatch = new PreBatch();
		preBatch.setBrNo(User.getBrno(this.getHttpRequest()));
		preBatch.setLoginid(User.getLoginIdByAuth(this.getHttpRequest()));
		Ipage ipage = this.getIpage();
		preBatchList = (List) preBatchBo.findByPage(ipage, preBatch).getResult();
		return "list";
	}

	/**
	 * Ԥ��������tabҳ
	 * @return
	 * @throws Exception
	 */
	public String getTab() throws Exception{
		ActionContext.initialize(ServletActionContext.getRequest(),
				ServletActionContext.getResponse());
		
		preBatch = new PreBatch();
		preBatch.setBatchNo(batchNo);
		preBatchBo.updateNum(preBatch);
		
		tabList = new ArrayList();
		String[] tab = null;
		
		tab = new String[2];
		tab[0] = "������Ϣ";
		tab[1] = "PreBatchAction_getById.action?batchNo=" + batchNo+ "&query=query";
		tabList.add(tab);
		
		tab = new String[2];
		tab[0] = "Ԥ����������ϸ";
		tab[1] = "PreApplyAction_findByPage.action?batchNo=" + batchNo;
		//PreApplyAction_findByPage.action
		tabList.add(tab);
		
		return "tab";
	}
	/**
	 * ��ѯ����
	 * @return
	 * @throws Exception
	 */
	public String getById() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),ServletActionContext.getResponse());
		formlnprebatch0002 = formService.getFormData("lnprebatch0002");
		preBatch = new PreBatch();
		preBatch.setBatchNo(batchNo);
		preBatch = preBatchBo.getById(preBatch);
		getObjValue(formlnprebatch0002, preBatch);
		return "detail";
	}
	
	/**
	 * �����������У��
	 * @return
	 * @throws Exception
	 */
	public void validateInsert(){
		 ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		 formlnprebatch0002 = formService.getFormData("lnprebatch0002");
		 getFormValue(formlnprebatch0002);
		 validateFormData(formlnprebatch0002);
   	}
   
	/**
	 * �޸ı������У��
	 * @return
	 * @throws Exception
	 */
	public void validateUpdate(){
		 ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		 formlnprebatch0002 = formService.getFormData("lnprebatch0002");
		 getFormValue(formlnprebatch0002);
		 validateFormData(formlnprebatch0002);
  	}
	public PreBatch getPreBatch() {
		return preBatch;
	}
	public void setPreBatch(PreBatch  preBatch) {
		this.preBatch = preBatch;
	}
	public List<PreBatch> getPreBatchList() {
		return preBatchList;
	}
	public void setPreBatchList(List<PreBatch> preBatchList) {
		this.preBatchList = preBatchList;
	}
	public PreBatchBo getPreBatchBo() {
		return preBatchBo;
	}
	public void setPreBatchBo(PreBatchBo preBatchBo) {
		this.preBatchBo = preBatchBo;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public FormData getFormlnprebatch0002() {
		return formlnprebatch0002;
	}
	public void setFormlnprebatch0002(FormData formlnprebatch0002) {
		this.formlnprebatch0002 = formlnprebatch0002;
	}
	public FormData getFormlnprebatch0001() {
		return formlnprebatch0001;
	}
	public void setFormlnprebatch0001(FormData formlnprebatch0001) {
		this.formlnprebatch0001 = formlnprebatch0001;
	}
	public void setBatchNo(String batchNo){
		this.batchNo = batchNo;
	}		
	public String getBatchNo(){
		return batchNo;
	}
	public List getTabList() {
		return tabList;
	}
	public void setTabList(List tabList) {
		this.tabList = tabList;
	}
}