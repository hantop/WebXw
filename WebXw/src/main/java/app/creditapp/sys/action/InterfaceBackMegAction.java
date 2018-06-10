package  app.creditapp.sys.action;
import java.util.List;
import java.util.ArrayList;
import org.apache.struts2.ServletActionContext;
import app.util.toolkit.Ipage;
import app.creditapp.sys.bo.InterfaceBackMegBo;
import app.creditapp.sys.entity.InterfaceBackMeg;
import com.core.domain.screen.FormData;
import com.core.service.screen.FormService;
import com.core.struts.ActionContext;
import com.core.struts.BaseFormBean;

/**
 * Title: InterfaceBackMegAction.java
 * Description:
 **/
public class InterfaceBackMegAction extends BaseFormBean {

	//ҳ�洫ֵ
	private InterfaceBackMeg interfaceBackMeg;
	private List<InterfaceBackMeg> interfaceBackMegList;

	//ע��InterfaceBackMegBo
	private InterfaceBackMegBo interfaceBackMegBo;

	private String query;
	private String interfaceName;		
	private String backMegKey;		
	private FormData forminfbkmeg0001;
	private FormData forminfbkmeg0002;
	private FormService formService = new FormService();
	
	public InterfaceBackMegAction() {
		query = "";
	}
	/**
	 * ��ҳ��ѯ
	 * @return
	 * @throws Exception
	 */
	public String findByPage() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),ServletActionContext.getResponse());
		forminfbkmeg0001 = formService.getFormData("infbkmeg0001");
		interfaceBackMeg = new InterfaceBackMeg();
		getFormValue(forminfbkmeg0001);
		setObjValue(forminfbkmeg0001, interfaceBackMeg);
		Ipage ipage = this.getIpage();
		interfaceBackMegList = (List) interfaceBackMegBo.findByPage(ipage, interfaceBackMeg).getResult();
		return "list";
	}
	
	
	/**
	 * ��ȡ����ҳ��
	 * @return
	 * @throws Exception
	 */
	public String input() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		forminfbkmeg0002 = formService.getFormData("infbkmeg0002");
		return "input";
	}
	
	/**
	 * �����������
	 * @return
	 * @throws Exception
	 */
	public String insert() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		forminfbkmeg0002 = formService.getFormData("infbkmeg0002");
		getFormValue(forminfbkmeg0002);
		interfaceBackMeg = new InterfaceBackMeg();
		setObjValue(forminfbkmeg0002, interfaceBackMeg);
		interfaceBackMegBo.insert(interfaceBackMeg);
		getObjValue(forminfbkmeg0002, interfaceBackMeg);
		return "detail";
	}
	
	
	/**
	 * �޸ı������
	 * @return
	 * @throws Exception
	 */
	public String update() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		forminfbkmeg0002 = formService.getFormData("infbkmeg0002");
		getFormValue(forminfbkmeg0002);
		interfaceBackMeg = new InterfaceBackMeg();
		setObjValue(forminfbkmeg0002, interfaceBackMeg);
		interfaceBackMegBo.update(interfaceBackMeg);
		getObjValue(forminfbkmeg0002, interfaceBackMeg);
		return "detail";
	}
	
	
	
	/**
	 * ɾ������
	 * @return
	 * @throws Exception
	 */
	public String del() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		forminfbkmeg0001 = formService.getFormData("infbkmeg0001");
		interfaceBackMeg = new InterfaceBackMeg();
		interfaceBackMeg.setInterfaceName(interfaceName);
		interfaceBackMeg.setBackMegKey(backMegKey);
		interfaceBackMegBo.del(interfaceBackMeg);
		this.addActionMessage("ɾ���ɹ�");
		interfaceBackMeg = new InterfaceBackMeg();
		Ipage ipage = this.getIpage();
		interfaceBackMegList = (List) interfaceBackMegBo.findByPage(ipage, interfaceBackMeg).getResult();
		return "list";
	}

	
	/**
	 * ��ѯ����
	 * @return
	 * @throws Exception
	 */
	public String getById() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),ServletActionContext.getResponse());
		forminfbkmeg0002 = formService.getFormData("infbkmeg0002");
		interfaceBackMeg = new InterfaceBackMeg();
		interfaceBackMeg.setInterfaceName(interfaceName);
		interfaceBackMeg.setBackMegKey(backMegKey);
		interfaceBackMeg = interfaceBackMegBo.getById(interfaceBackMeg);
		getObjValue(forminfbkmeg0002, interfaceBackMeg);
		return "detail";
	}
	
	/**
	 * �����������У��
	 * @return
	 * @throws Exception
	 */
	public void validateInsert(){
		 ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		 forminfbkmeg0002 = formService.getFormData("infbkmeg0002");
		 getFormValue(forminfbkmeg0002);
		 validateFormData(forminfbkmeg0002);
   }
   
	/**
	 * �޸ı������У��
	 * @return
	 * @throws Exception
	 */
	public void validateUpdate(){
		 ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		 forminfbkmeg0002 = formService.getFormData("infbkmeg0002");
		 getFormValue(forminfbkmeg0002);
		 validateFormData(forminfbkmeg0002);
  	}
	public InterfaceBackMeg getInterfaceBackMeg() {
		return interfaceBackMeg;
	}
	public void setInterfaceBackMeg(InterfaceBackMeg  interfaceBackMeg) {
		this.interfaceBackMeg = interfaceBackMeg;
	}
	public List<InterfaceBackMeg> getInterfaceBackMegList() {
		return interfaceBackMegList;
	}
	public void setInterfaceBackMegList(List<InterfaceBackMeg> interfaceBackMegList) {
		this.interfaceBackMegList = interfaceBackMegList;
	}
	public InterfaceBackMegBo getInterfaceBackMegBo() {
		return interfaceBackMegBo;
	}
	public void setInterfaceBackMegBo(InterfaceBackMegBo interfaceBackMegBo) {
		this.interfaceBackMegBo = interfaceBackMegBo;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public FormData getForminfbkmeg0002() {
		return forminfbkmeg0002;
	}
	public void setForminfbkmeg0002(FormData forminfbkmeg0002) {
		this.forminfbkmeg0002 = forminfbkmeg0002;
	}
	public FormData getForminfbkmeg0001() {
		return forminfbkmeg0001;
	}
	public void setForminfbkmeg0001(FormData forminfbkmeg0001) {
		this.forminfbkmeg0001 = forminfbkmeg0001;
	}
	public void setInterfaceName(String interfaceName){
		this.interfaceName = interfaceName;
	}		
	public void setBackMegKey(String backMegKey){
		this.backMegKey = backMegKey;
	}		
	public String getInterfaceName(){
		return interfaceName;
	}
	public String getBackMegKey(){
		return backMegKey;
	}
}