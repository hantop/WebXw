package  app.creditapp.sys.action;
import java.util.List;
import app.util.User;
import org.apache.struts2.ServletActionContext;
import app.util.toolkit.Ipage;
import app.creditapp.sys.bo.ParmKeyBo;
import app.creditapp.sys.entity.ParmKey;
import com.core.domain.screen.FormData;
import com.core.service.screen.FormService;
import com.core.struts.ActionContext;
import com.core.struts.BaseFormBean;

/**
 * Title: ParmKeyAction.java
 * Description:
 **/
public class ParmKeyAction extends BaseFormBean {

	//ҳ�洫ֵ
	private ParmKey ParmKey;
	private List<ParmKey> ParmKeyList;

	//ע��ParmKeyBo
	private ParmKeyBo ParmKeyBo;

	private String query;
	private String key_name;		
	private FormData formsys0050;
	private FormData formsys0051;
	private FormService formService = new FormService();
	
	public ParmKeyAction() {
		query = "";
	}
	/**
	 * ��ҳ��ѯ
	 * @return
	 * @throws Exception
	 */
	public String findByPage() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),ServletActionContext.getResponse());
		formsys0050 = formService.getFormData("sys0050");
		ParmKey = new ParmKey();
		getFormValue(formsys0050);
		setObjValue(formsys0050, ParmKey);
		Ipage ipage = this.getIpage();
		ParmKeyList = (List) ParmKeyBo.findByPage(ipage, ParmKey).getResult();
		return "list";
	}
	
	
	/**
	 * ��ȡ����ҳ��
	 * @return
	 * @throws Exception
	 */
	public String input() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formsys0051 = formService.getFormData("sys0051");
		return "input";
	}
	
	/**
	 * �����������
	 * @return
	 * @throws Exception
	 */
	public String insert() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formsys0051 = formService.getFormData("sys0051");
		getFormValue(formsys0051);
		ParmKey = new ParmKey();
		setObjValue(formsys0051, ParmKey);
		ParmKey.setKey_sts("01");
		ParmKeyBo.insert(ParmKey);
		this.addActionMessage("����ɹ�");
		getObjValue(formsys0051, ParmKey);
		this.changeFormProperty(formsys0051, "key_name", "readonly", "1");
		return "detail";
	}
	
	
	/**
	 * �޸ı������
	 * @return
	 * @throws Exception
	 */
	public String update() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formsys0051 = formService.getFormData("sys0051");
		getFormValue(formsys0051);
		ParmKey = new ParmKey();
		setObjValue(formsys0051, ParmKey);
		ParmKeyBo.update(ParmKey);
		this.addActionMessage("����ɹ�");
		getObjValue(formsys0051, ParmKey);
		this.changeFormProperty(formsys0051, "key_name", "readonly", "1");
		return "detail";
	}
	
	
	
	/**
	 * ɾ������
	 * @return
	 * @throws Exception
	 */
	public String del() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formsys0050 = formService.getFormData("sys0050");
		ParmKey = new ParmKey();
		ParmKey.setKey_name(key_name);
		ParmKeyBo.del(ParmKey);
		this.addActionMessage("ɾ���ɹ�");
		ParmKey = new ParmKey();
		Ipage ipage = this.getIpage();
		ParmKeyList = (List) ParmKeyBo.findByPage(ipage, ParmKey).getResult();
		return "list";
	}

	
	/**
	 * ��ѯ����
	 * @return
	 * @throws Exception
	 */
	public String getById() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),ServletActionContext.getResponse());
		formsys0051 = formService.getFormData("sys0051");
		ParmKey = new ParmKey();
		ParmKey.setKey_name(key_name);
		ParmKey = ParmKeyBo.getById(ParmKey);
		getObjValue(formsys0051, ParmKey);
		this.changeFormProperty(formsys0051, "key_name", "readonly", "1");
		return "detail";
	}
	
	/**
	 * �����������У��
	 * @return
	 * @throws Exception
	 */
	public void validateInsert(){
		 ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		 formsys0051 = formService.getFormData("sys0051");
		 getFormValue(formsys0051);
		 validateFormData(formsys0051);
		 ParmKey = new ParmKey();
		 setObjValue(formsys0051, ParmKey);
		 ParmKey = ParmKeyBo.getById(ParmKey);
		 if(ParmKey != null){
			 this.addActionError("�ֵ����Ѵ��ڣ�");
		 }
		 
   	}
   
	/**
	 * �޸ı������У��
	 * @return
	 * @throws Exception
	 */
	public void validateUpdate(){
		 ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		 formsys0051 = formService.getFormData("sys0051");
		 getFormValue(formsys0051);
		 validateFormData(formsys0051);
  	}
	public ParmKey getParmKey() {
		return ParmKey;
	}
	public void setParmKey(ParmKey  ParmKey) {
		this.ParmKey = ParmKey;
	}
	public List<ParmKey> getParmKeyList() {
		return ParmKeyList;
	}
	public void setParmKeyList(List<ParmKey> ParmKeyList) {
		this.ParmKeyList = ParmKeyList;
	}
	public ParmKeyBo getParmKeyBo() {
		return ParmKeyBo;
	}
	public void setParmKeyBo(ParmKeyBo ParmKeyBo) {
		this.ParmKeyBo = ParmKeyBo;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public FormData getFormsys0051() {
		return formsys0051;
	}
	public void setFormsys0051(FormData formsys0051) {
		this.formsys0051 = formsys0051;
	}
	public FormData getFormsys0050() {
		return formsys0050;
	}
	public void setFormsys0050(FormData formsys0050) {
		this.formsys0050 = formsys0050;
	}
	public String getKey_name() {
		return key_name;
	}
	public void setKey_name(String keyName) {
		key_name = keyName;
	}
}