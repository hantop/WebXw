package  app.creditapp.proj.action;
import java.util.List;
import app.util.User;
import org.apache.struts2.ServletActionContext;
import app.util.toolkit.Ipage;
import app.creditapp.proj.bo.ProjAcctLstBo;
import app.creditapp.proj.entity.ProjAcct;
import app.creditapp.proj.entity.ProjAcctLst;
import com.core.domain.screen.FormData;
import com.core.service.screen.FormService;
import com.core.struts.ActionContext;
import com.core.struts.BaseFormBean;

/**
 * Title: ProjAcctLstAction.java
 * Description:
 **/
public class ProjAcctLstAction extends BaseFormBean {

	//ҳ�洫ֵ
	private ProjAcctLst projAcctLst;
	private List<ProjAcctLst> projAcctLstList;
	private String backSts;
	//ע��ProjAcctLstBo
	private ProjAcctLstBo projAcctLstBo;

	private String query;
	private String lstId;	
	private String acctId;
	
	private FormData formproj0009;
	private FormData formproj0010;
	private FormService formService = new FormService();
	
	public ProjAcctLstAction() {
		query = "";
	}
	/**
	 * ��ҳ��ѯ
	 * @return
	 * @throws Exception
	 */
	public String findByPage() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),ServletActionContext.getResponse());
		formproj0009 = formService.getFormData("proj0009");
		projAcctLst = new ProjAcctLst();
		getFormValue(formproj0009);
		setObjValue(formproj0009, projAcctLst);
		Ipage ipage = this.getIpage();
		projAcctLstList = (List) projAcctLstBo.findByPage(ipage, projAcctLst).getResult();
		return "list";
	}
	
	
	/**
	 * ��ȡ����ҳ��
	 * @return
	 * @throws Exception
	 */
	public String input() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formproj0010 = formService.getFormData("proj0010");
		return "input";
	}
	
	/**
	 * �����������
	 * @return
	 * @throws Exception
	 */
	public String insert() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formproj0010 = formService.getFormData("proj0010");
		getFormValue(formproj0010);
		projAcctLst = new ProjAcctLst();
		setObjValue(formproj0010, projAcctLst);
		projAcctLst.setTxDate(User.getSys_date(this.getHttpRequest()));
		projAcctLstBo.insert(projAcctLst);
		getObjValue(formproj0010, projAcctLst);
		return "detail";
	}
	
	
	/**
	 * �޸ı������
	 * @return
	 * @throws Exception
	 */
	public String update() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formproj0010 = formService.getFormData("proj0010");
		getFormValue(formproj0010);
		projAcctLst = new ProjAcctLst();
		setObjValue(formproj0010, projAcctLst);
		projAcctLstBo.update(projAcctLst);
		getObjValue(formproj0010, projAcctLst);
		return "detail";
	}
	
	
	
	/**
	 * ɾ������
	 * @return
	 * @throws Exception
	 */
	public String del() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formproj0009 = formService.getFormData("proj0009");
		projAcctLst = new ProjAcctLst();
		projAcctLst.setLstId(lstId);
		projAcctLstBo.del(projAcctLst);
		this.addActionMessage("ɾ���ɹ�");
		projAcctLst = new ProjAcctLst();
		Ipage ipage = this.getIpage();
		projAcctLstList = (List) projAcctLstBo.findByPage(ipage, projAcctLst).getResult();
		return "list";
	}

	
	/**
	 * ��ѯ����
	 * @return
	 * @throws Exception
	 */
	public String getById() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),ServletActionContext.getResponse());
		formproj0010 = formService.getFormData("proj0010");
		projAcctLst = new ProjAcctLst();
		projAcctLst.setLstId(lstId);
		projAcctLst = projAcctLstBo.getById(projAcctLst);
		getObjValue(formproj0010, projAcctLst);
		return "detail";
	}
	/**
	 * ��ѯ����
	 * @return
	 * @throws Exception
	 */
	public String getById_Read() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),ServletActionContext.getResponse());
		formproj0010 = formService.getFormData("proj0010");
		projAcctLst = new ProjAcctLst();
		projAcctLst.setLstId(lstId);
		projAcctLst = projAcctLstBo.getById(projAcctLst);
		getObjValue(formproj0010, projAcctLst);
		return "detail_Read";
	}
	/**
	 * �����������У��
	 * @return
	 * @throws Exception
	 */
	public void validateInsert(){
		 ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		 formproj0010 = formService.getFormData("proj0010");
		 getFormValue(formproj0010);
		 validateFormData(formproj0010);
   	}
   
	/**
	 * �޸ı������У��
	 * @return
	 * @throws Exception
	 */
	public void validateUpdate(){
		 ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		 formproj0010 = formService.getFormData("proj0010");
		 getFormValue(formproj0010);
		 validateFormData(formproj0010);
  	}
	
	/**
	    * ������Ŀ��ʾ���еĵ��˻���ˮ ��Ϣ
	    * @return
	    * @throws Exception
	    */
	   public String listQuotaForCorp() throws Exception {
	   	ActionContext.initialize(ServletActionContext.getRequest(),
	       		ServletActionContext.getResponse());
	   	projAcctLst = new ProjAcctLst();
	   	projAcctLst.setAcctId(acctId);
	   	Ipage ipage = this.getIpage();
	   	projAcctLstList = (List) projAcctLstBo.findByPageQuotaForCorp(ipage, projAcctLst).getResult();
	   	return "list";
	   }
	   /**
	    * ������Ŀ��ʾ���еĵ��˻���ˮ ��Ϣ
	    * @return
	    * @throws Exception
	    */
	   public String listQuotaForCorp_Read() throws Exception {
	   	ActionContext.initialize(ServletActionContext.getRequest(),
	       		ServletActionContext.getResponse());
	   	projAcctLst = new ProjAcctLst();
	   	projAcctLst.setAcctId(acctId);
	   	Ipage ipage = this.getIpage();
	   	projAcctLstList = (List) projAcctLstBo.findByPageQuotaForCorp(ipage, projAcctLst).getResult();
	   	return "list_Read";
	   }
	public ProjAcctLst getProjAcctLst() {
		return projAcctLst;
	}
	public void setProjAcctLst(ProjAcctLst  projAcctLst) {
		this.projAcctLst = projAcctLst;
	}
	public List<ProjAcctLst> getProjAcctLstList() {
		return projAcctLstList;
	}
	public void setProjAcctLstList(List<ProjAcctLst> projAcctLstList) {
		this.projAcctLstList = projAcctLstList;
	}
	public ProjAcctLstBo getProjAcctLstBo() {
		return projAcctLstBo;
	}
	public void setProjAcctLstBo(ProjAcctLstBo projAcctLstBo) {
		this.projAcctLstBo = projAcctLstBo;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public FormData getFormproj0010() {
		return formproj0010;
	}
	public void setFormproj0010(FormData formproj0010) {
		this.formproj0010 = formproj0010;
	}
	public FormData getFormproj0009() {
		return formproj0009;
	}
	public void setFormproj0009(FormData formproj0009) {
		this.formproj0009 = formproj0009;
	}
	public void setLstId(String lstId){
		this.lstId = lstId;
	}		
	public String getLstId(){
		return lstId;
	}
	public String getAcctId() {
		return acctId;
	}
	public void setAcctId(String acctId) {
		this.acctId = acctId;
	}
	public String getBackSts() {
		return backSts;
	}
	public void setBackSts(String backSts) {
		this.backSts = backSts;
	}
}