package  app.creditapp.cif.action;
import java.util.ArrayList;
import java.util.List;
import app.util.User;
import org.apache.struts2.ServletActionContext;
import app.util.toolkit.Ipage;
import app.creditapp.cif.bo.CifBlackBo;
import app.creditapp.cif.entity.CifBlack;
import com.core.domain.screen.FormData;
import com.core.service.screen.FormService;
import com.core.struts.ActionContext;
import com.core.struts.BaseFormBean;

/**
 * Title: CifBlackAction.java
 * Description:
 **/
public class CifBlackAction extends BaseFormBean {

	//ҳ�洫ֵ
	private CifBlack cifBlack;
	private List<CifBlack> cifBlackList;

	//ע��CifBlackBo
	private CifBlackBo cifBlackBo;

	private String query;
	private String blkId;	
	private String formSts;
	private FormData formcifblack0001;
	private FormData formcifblack0002;
	private FormService formService = new FormService();
	
	private List tabList;
	
	public CifBlackAction() {
		query = "";
	}
	/**
	 * ��ҳ��ѯ
	 * @return
	 * @throws Exception
	 */
	public String findByPage() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),ServletActionContext.getResponse());
		formcifblack0001 = formService.getFormData("cifblack0001");
		cifBlack = new CifBlack();
		getFormValue(formcifblack0001);
		setObjValue(formcifblack0001, cifBlack);
		Ipage ipage = this.getIpage();
		cifBlackList = (List) cifBlackBo.findByPage(ipage, cifBlack).getResult();
		return "list";
	}
	
	
	/**
	 * ��ȡ����ҳ��
	 * @return
	 * @throws Exception
	 */
	public String input() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formcifblack0002 = formService.getFormData("cifblack0002");
		return "input";
	}
	
	/**
	 * �����������
	 * @return
	 * @throws Exception
	 */
	public String insert() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formcifblack0002 = formService.getFormData("cifblack0002");
		getFormValue(formcifblack0002);
		cifBlack = new CifBlack();
		setObjValue(formcifblack0002, cifBlack);
		cifBlack.setBlkFlag("02");
		cifBlack.setBlkSts("01");
		cifBlack.setOpNo(User.getLoginid(ServletActionContext.getRequest()));//����Ա
		cifBlack.setTxDate(User.getSys_date(ServletActionContext.getRequest()));//�Ǽ�����
		cifBlackBo.insert(cifBlack);
		getObjValue(formcifblack0002, cifBlack);
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
		formcifblack0002 = formService.getFormData("cifblack0002");
		getFormValue(formcifblack0002);
		cifBlack = new CifBlack();
		setObjValue(formcifblack0002, cifBlack);
		cifBlack.setUpDate(User.getSys_date(ServletActionContext.getRequest()));//�޸�����
		cifBlackBo.update(cifBlack);
		getObjValue(formcifblack0002, cifBlack);
		this.addActionMessage("�����ɹ�");
		return "detail";
	}
	
	/**
	 * @���� DHCC-ZBW
	 * @���� 2016-7-15
	 * @����˵����tabҳ��ʾ
	 * @���ز��� String
	 */
	public String getTab() {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		tabList = new ArrayList();
		String[] tab = null;
		tab = new String[2];
		tab[0] = "������Ϣ";
		tab[1] = "CifBlackAction_getById.action?blkId="+blkId+"&query="+query+"&formSts=1";
		tabList.add(tab);
		
		tab = new String[2];
		tab[0] = "�����ϸ";
		tab[1] = "LnApprIdeaAction_findByPageForRead.action?appId="+blkId+"&formSts=1";
		tabList.add(tab);
		
		return "tab";
	}
	
	/**
	 * ɾ������
	 * @return
	 * @throws Exception
	 */
	public String del() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formcifblack0001 = formService.getFormData("cifblack0001");
		cifBlack = new CifBlack();
		cifBlack.setBlkId(blkId);
		cifBlackBo.del(cifBlack);
		this.addActionMessage("ɾ���ɹ�");
		cifBlack = new CifBlack();
		Ipage ipage = this.getIpage();
		cifBlackList = (List) cifBlackBo.findByPage(ipage, cifBlack).getResult();
		return "list";
	}

	
	/**
	 * ��ѯ����
	 * @return
	 * @throws Exception
	 */
	public String getById() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),ServletActionContext.getResponse());
		formcifblack0002 = formService.getFormData("cifblack0002");
		cifBlack = new CifBlack();
		cifBlack.setBlkId(blkId);
		cifBlack = cifBlackBo.getById(cifBlack);
		getObjValue(formcifblack0002, cifBlack);
		this.changeFormProperty(formcifblack0002, "cifNo", "readonly", "1");
		this.changeFormProperty(formcifblack0002, "idType", "readonly", "1");
		return "detail";
	}
	
	/**
	 * �����������У��
	 * @return
	 * @throws Exception
	 */
	public void validateInsert(){
		 ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		 formcifblack0002 = formService.getFormData("cifblack0002");
		 getFormValue(formcifblack0002);
		 validateFormData(formcifblack0002);
   	}
   
	/**
	 * �޸ı������У��
	 * @return
	 * @throws Exception
	 */
	public void validateUpdate(){
		 ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		 formcifblack0002 = formService.getFormData("cifblack0002");
		 getFormValue(formcifblack0002);
		 validateFormData(formcifblack0002);
  	}
	
	
	/**
	 * ��������--->��������ЧʧЧ
	 * @return
	 * @throws Exception
	 */
	public String updateForAppSts() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formcifblack0002 = formService.getFormData("formcifblack0002");
		getFormValue(formcifblack0002);
		cifBlack = new CifBlack();
		setObjValue(formcifblack0002, cifBlack);
		String APP_STS = "";
		if(APP_STS.equals("01")){
			//cifBlack.setBlkSts("01");
		}else{
			
		}
		cifBlackBo.update(cifBlack);
		this.addActionMessage("�޸ĳɹ�");
		getObjValue(formcifblack0002, cifBlack);
		return "list";
	}
	
	public CifBlack getCifBlack() {
		return cifBlack;
	}
	public void setCifBlack(CifBlack  cifBlack) {
		this.cifBlack = cifBlack;
	}
	public List<CifBlack> getCifBlackList() {
		return cifBlackList;
	}
	public void setCifBlackList(List<CifBlack> cifBlackList) {
		this.cifBlackList = cifBlackList;
	}
	public CifBlackBo getCifBlackBo() {
		return cifBlackBo;
	}
	public void setCifBlackBo(CifBlackBo cifBlackBo) {
		this.cifBlackBo = cifBlackBo;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public FormData getFormcifblack0002() {
		return formcifblack0002;
	}
	public void setFormcifblack0002(FormData formcifblack0002) {
		this.formcifblack0002 = formcifblack0002;
	}
	public FormData getFormcifblack0001() {
		return formcifblack0001;
	}
	public void setFormcifblack0001(FormData formcifblack0001) {
		this.formcifblack0001 = formcifblack0001;
	}
	public void setBlkId(String blkId){
		this.blkId = blkId;
	}		
	public String getBlkId(){
		return blkId;
	}
	public List getTabList() {
		return tabList;
	}
	public void setTabList(List tabList) {
		this.tabList = tabList;
	}
	public String getFormSts() {
		return formSts;
	}
	public void setFormSts(String formSts) {
		this.formSts = formSts;
	}
}