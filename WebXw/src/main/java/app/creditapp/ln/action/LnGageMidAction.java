package  app.creditapp.ln.action;
import java.util.List;
import app.util.User;
import org.apache.struts2.ServletActionContext;
import app.util.toolkit.Ipage;
import app.creditapp.gage.entity.LnGage;
import app.creditapp.ln.bo.LnGageMidBo;
import app.creditapp.ln.entity.LnGageMid;
import com.core.domain.screen.FormData;
import com.core.service.screen.FormService;
import com.core.struts.ActionContext;
import com.core.struts.BaseFormBean;

/**
 * Title: LnGageMidAction.java
 **/
public class LnGageMidAction extends BaseFormBean {

	//ҳ�洫ֵ
	private LnGageMid lnGageMid;
	private List<LnGageMid> lnGageMidList;

	//ע��LnGageMidBo
	private LnGageMidBo lnGageMidBo;
	private String backSts;
	private String query;

	private String appId;		
	private FormData formlngagemid0001;
	private FormData formlngagemid0002;
	private FormService formService = new FormService();
	
	public LnGageMidAction() {
		query = "";
	}
	/**
	 * ��ҳ��ѯ
	 * @return
	 * @throws Exception
	 */
	public String findByPage() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),ServletActionContext.getResponse());
		formlngagemid0001 = formService.getFormData("lngagemid0001");
		lnGageMid = new LnGageMid();
		getFormValue(formlngagemid0001);
		setObjValue(formlngagemid0001, lnGageMid);
		Ipage ipage = this.getIpage();
		lnGageMidList = (List) lnGageMidBo.findByPage(ipage, lnGageMid).getResult();
		return "list";
	}
	
	/**
	 * ��ȡ����ҳ��
	 * @return
	 * @throws Exception
	 */
	public String input() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formlngagemid0002 = formService.getFormData("lngagemid0002");
		return "input";
	}
	
	/**
	 * �����������
	 * @return
	 * @throws Exception
	 */
	public String insert() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formlngagemid0002 = formService.getFormData("lngagemid0002");
		getFormValue(formlngagemid0002);
		lnGageMid = new LnGageMid();
		setObjValue(formlngagemid0002, lnGageMid);
		lnGageMidBo.insert(lnGageMid);
		getObjValue(formlngagemid0002, lnGageMid);
		return "detail";
	}
	
	
	/**
	 * �޸ı������
	 * @return
	 * @throws Exception
	 */
	public String update() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formlngagemid0002 = formService.getFormData("lngagemid0002");
		getFormValue(formlngagemid0002);
		lnGageMid = new LnGageMid();
		setObjValue(formlngagemid0002, lnGageMid);
		lnGageMidBo.update(lnGageMid);
		getObjValue(formlngagemid0002, lnGageMid);
		return "detail";
	}
	
	
	
	/**
	 * ɾ������
	 * @return
	 * @throws Exception
	 */
	public String del() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formlngagemid0001 = formService.getFormData("lngagemid0001");
		lnGageMid = new LnGageMid();
		lnGageMid.setAppId(appId);
		lnGageMidBo.del(lnGageMid);
		this.addActionMessage("ɾ���ɹ�");
		lnGageMid = new LnGageMid();
		Ipage ipage = this.getIpage();
		lnGageMidList = (List) lnGageMidBo.findByPage(ipage, lnGageMid).getResult();
		return "list";
	}

	
	/**
	 * ��ѯ����
	 * @return
	 * @throws Exception
	 */
	public String getById() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),ServletActionContext.getResponse());
		formlngagemid0002 = formService.getFormData("lngagemid0002");
		lnGageMid = new LnGageMid();
		lnGageMid.setAppId(appId);
		
		lnGageMid = lnGageMidBo.getById(lnGageMid);
		getObjValue(formlngagemid0002, lnGageMid);
		return "detail";
	}

	/**
	 * �����������У��
	 * @return
	 * @throws Exception
	 */
	public void validateInsert(){
		 ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		 formlngagemid0002 = formService.getFormData("lngagemid0002");
		 getFormValue(formlngagemid0002);
		 validateFormData(formlngagemid0002);
   	}
   
	/**
	 * �޸ı������У��
	 * @return
	 * @throws Exception
	 */
	public void validateUpdate(){
		 ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		 formlngagemid0002 = formService.getFormData("lngagemid0002");
		 getFormValue(formlngagemid0002);
		 validateFormData(formlngagemid0002);
  	}
	
	 /**
	    * ��������ID��ʾ���еĵ�ѺƷ��Ϣ
	    * @return
	    * @throws Exception
	    */
	   public String listQuotaForLn() throws Exception {
	   	ActionContext.initialize(ServletActionContext.getRequest(),
	       		ServletActionContext.getResponse());
	   	lnGageMid = new LnGageMid();
	   	lnGageMid.setAppId(appId);
	   	Ipage ipage = this.getIpage();
	   	lnGageMidList = (List) lnGageMidBo.findByPageQuotaForLn(ipage, lnGageMid).getResult();
	   	return "list";
	   }
	   public String listQuotaForLn_Read() throws Exception {
		   	ActionContext.initialize(ServletActionContext.getRequest(),
		       		ServletActionContext.getResponse());
		   	lnGageMid = new LnGageMid();
		   	lnGageMid.setAppId(appId);
		   	Ipage ipage = this.getIpage();
		   	lnGageMidList = (List) lnGageMidBo.findByPageQuotaForLn(ipage, lnGageMid).getResult();
		   	return "list_Read";
		   }
	
	public LnGageMid getLnGageMid() {
		return lnGageMid;
	}
	public void setLnGageMid(LnGageMid  lnGageMid) {
		this.lnGageMid = lnGageMid;
	}
	public List<LnGageMid> getLnGageMidList() {
		return lnGageMidList;
	}
	public void setLnGageMidList(List<LnGageMid> lnGageMidList) {
		this.lnGageMidList = lnGageMidList;
	}
	public LnGageMidBo getLnGageMidBo() {
		return lnGageMidBo;
	}
	public void setLnGageMidBo(LnGageMidBo lnGageMidBo) {
		this.lnGageMidBo = lnGageMidBo;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public FormData getFormlngagemid0002() {
		return formlngagemid0002;
	}
	public void setFormlngagemid0002(FormData formlngagemid0002) {
		this.formlngagemid0002 = formlngagemid0002;
	}
	public FormData getFormlngagemid0001() {
		return formlngagemid0001;
	}
	public void setFormlngagemid0001(FormData formlngagemid0001) {
		this.formlngagemid0001 = formlngagemid0001;
	}
	public void setAppId(String appId){
		this.appId = appId;
	}		
	public String getAppId(){
		return appId;
	}
	public String getBackSts() {
		return backSts;
	}
	public void setBackSts(String backSts) {
		this.backSts = backSts;
	}
}