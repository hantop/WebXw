package  app.creditapp.cred.action;
import java.util.List;
import app.util.User;
import org.apache.struts2.ServletActionContext;
import app.util.toolkit.Ipage;
import app.creditapp.cif.bo.CifBlackBo;
import app.creditapp.cif.entity.CifBlack;
import app.creditapp.cred.bo.CifBlackAppBo;
import app.creditapp.cred.entity.CifBlackApp;
import app.creditapp.wkf.entity.WkfParm;

import com.core.domain.screen.FormData;
import com.core.service.screen.FormService;
import com.core.struts.ActionContext;
import com.core.struts.BaseFormBean;

/**
 * Title: CifBlackAppAction.java
 * Description:
 **/
public class CifBlackAppAction extends BaseFormBean {

	//ҳ�洫ֵ
	private CifBlackApp cifBlackApp;
	private CifBlack cifBlack;
	private List<CifBlackApp> cifBlackAppList;
	private List<CifBlack> cifBlackList;

	//ע��CifBlackAppBo
	private CifBlackAppBo cifBlackAppBo;
	private CifBlackBo cifBlackBo;

	private String query;
	private String appId;		
	private String blkId;		
	private String formSts;	
	private FormData formcred0005;
	private FormData formcred0006;
	private FormData formcifblack0001;
	private FormService formService = new FormService();
	
	public CifBlackAppAction() {
		query = "";
	}
	/**
	 * ��ҳ��ѯ
	 * @return
	 * @throws Exception
	 */
	public String findByPage() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),ServletActionContext.getResponse());
		formcred0005 = formService.getFormData("cred0005");
		cifBlackApp = new CifBlackApp();
		getFormValue(formcred0005);
		setObjValue(formcred0005, cifBlackApp);
		Ipage ipage = this.getIpage();
		cifBlackAppList = (List) cifBlackAppBo.findByPage(ipage, cifBlackApp).getResult();
		return "list";
	}
	public String findByPageblack() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),ServletActionContext.getResponse());
		cifBlackApp = new CifBlackApp();
		cifBlackApp.setBlkId(blkId);
		Ipage ipage = this.getIpage();
		cifBlackAppList = (List) cifBlackAppBo.findByPage(ipage, cifBlackApp).getResult();
		return "list";
	}
	
	/**
	 * ��ȡ����ҳ��
	 * @return
	 * @throws Exception
	 */
	public String input() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formcred0006 = formService.getFormData("cred0006");
		cifBlack = new CifBlack();
		cifBlack.setBlkId(blkId);
		cifBlack = cifBlackBo.getById(cifBlack);
		cifBlackApp = new CifBlackApp();
		getFormValue(formcred0006);
		setObjValue(formcred0006, cifBlackApp);
		cifBlackApp.setBlkLevel(cifBlack.getBlkLevel());
		cifBlackApp.setCifNo(cifBlack.getCifNo());
		cifBlackApp.setCifName(cifBlack.getCifName());
		cifBlackApp.setIdType(cifBlack.getIdType());
		cifBlackApp.setIdNo(cifBlack.getIdNo());
		if(cifBlack.getBlkFlag().equals("01")){//�ж��Ƿ���Ч  01Ϊ��Ч 02ΪʧЧ
			cifBlackApp.setAppType("02");      //��������Ϊ�Ƴ�
		}else{
			cifBlackApp.setAppType("01");      //��������Ϊ����
		}
		getObjValue(formcred0006, cifBlackApp);
		return "input";
	}
	
	/**
	 * �����������
	 * @return
	 * @throws Exception
	 */
	public String insert() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formcred0006 = formService.getFormData("cred0006");
		getFormValue(formcred0006);
		cifBlackApp = new CifBlackApp();
		setObjValue(formcred0006, cifBlackApp);
		cifBlackApp.setTxDate(User.getSys_date(ServletActionContext.getRequest()));
		cifBlackApp.setOpNo(User.getLoginid(ServletActionContext.getRequest()));
		cifBlackAppBo.insert(cifBlackApp);
		//������̱�����Ȼ����������
		WkfParm parm = new WkfParm();
		parm.setApp_no(blkId);//ID��
		parm.setApp_type("03");//������
		
		StringBuilder wfAppValue = new StringBuilder();
		wfAppValue.append("�ͻ���:"+cifBlackApp.getCifNo());
		wfAppValue.append(",�ͻ�����:"+cifBlackApp.getCifName());
		wfAppValue.append(",֤����:"+cifBlackApp.getIdNo());
		
		parm.setWf_app_value(wfAppValue.toString());//ҵ��
		
		String nextDesc =cifBlackAppBo.doSubmit(parm,cifBlackApp,User.getLoginid(getHttpRequest()), User.getBrno(getHttpRequest()));
		this.addActionMessage("�����ɹ�,��һ�ڵ����Ա"+nextDesc);
		
		formcifblack0001 = formService.getFormData("cifblack0001");
		cifBlack = new CifBlack();
		cifBlackApp = new CifBlackApp();
		setObjValue(formcifblack0001, cifBlack);
		Ipage ipage = this.getIpage();
		cifBlackList = (List) cifBlackBo.findByPage(ipage, cifBlack).getResult();
		
		return "detail";
	}
	
	/**
	 * �޸ı������
	 * @return
	 * @throws Exception
	 */
	public String update() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formcred0006 = formService.getFormData("cred0006");
		getFormValue(formcred0006);
		cifBlackApp = new CifBlackApp();
		setObjValue(formcred0006, cifBlackApp);
		cifBlackAppBo.update(cifBlackApp);
		getObjValue(formcred0006, cifBlackApp);
		this.addActionMessage("�����ɹ�");
		return "detail";
	}
	
	
	
	/**
	 * ɾ������
	 * @return
	 * @throws Exception
	 */
	public String del() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formcred0005 = formService.getFormData("cred0005");
		cifBlackApp = new CifBlackApp();
		cifBlackApp.setAppId(appId);
		cifBlackAppBo.del(cifBlackApp);
		this.addActionMessage("ɾ���ɹ�");
		cifBlackApp = new CifBlackApp();
		Ipage ipage = this.getIpage();
		cifBlackAppList = (List) cifBlackAppBo.findByPage(ipage, cifBlackApp).getResult();
		return "list";
	}

	
	/**
	 * ��ѯ����
	 * @return
	 * @throws Exception
	 */
	public String getById() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),ServletActionContext.getResponse());
		formcred0006 = formService.getFormData("cred0006");
		cifBlackApp = new CifBlackApp();
		cifBlackApp.setAppId(appId);
		cifBlackApp = cifBlackAppBo.getById(cifBlackApp);
		getObjValue(formcred0006, cifBlackApp);
		return "detail";
	}
	
	/**
	 * �����������У��
	 * @return
	 * @throws Exception
	 */
	public void validateInsert(){
		 ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		 formcred0006 = formService.getFormData("cred0006");
		 getFormValue(formcred0006);
		 validateFormData(formcred0006);
   	}
   
	/**
	 * �޸ı������У��
	 * @return
	 * @throws Exception
	 */
	public void validateUpdate(){
		 ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		 formcred0006 = formService.getFormData("cred0006");
		 getFormValue(formcred0006);
		 validateFormData(formcred0006);
  	}
	public CifBlackApp getCifBlackApp() {
		return cifBlackApp;
	}
	public void setCifBlackApp(CifBlackApp  cifBlackApp) {
		this.cifBlackApp = cifBlackApp;
	}
	public List<CifBlackApp> getCifBlackAppList() {
		return cifBlackAppList;
	}
	public void setCifBlackAppList(List<CifBlackApp> cifBlackAppList) {
		this.cifBlackAppList = cifBlackAppList;
	}
	public CifBlackAppBo getCifBlackAppBo() {
		return cifBlackAppBo;
	}
	public void setCifBlackAppBo(CifBlackAppBo cifBlackAppBo) {
		this.cifBlackAppBo = cifBlackAppBo;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public FormData getFormcred0006() {
		return formcred0006;
	}
	public void setFormcred0006(FormData formcred0006) {
		this.formcred0006 = formcred0006;
	}
	public FormData getFormcred0005() {
		return formcred0005;
	}
	public void setFormcred0005(FormData formcred0005) {
		this.formcred0005 = formcred0005;
	}
	public void setAppId(String appId){
		this.appId = appId;
	}		
	public String getAppId(){
		return appId;
	}
	public CifBlack getCifBlack() {
		return cifBlack;
	}
	public void setCifBlack(CifBlack cifBlack) {
		this.cifBlack = cifBlack;
	}
	public String getBlkId() {
		return blkId;
	}
	public void setBlkId(String blkId) {
		this.blkId = blkId;
	}
	public CifBlackBo getCifBlackBo() {
		return cifBlackBo;
	}
	public void setCifBlackBo(CifBlackBo cifBlackBo) {
		this.cifBlackBo = cifBlackBo;
	}
	public FormData getFormcifblack0001() {
		return formcifblack0001;
	}
	public void setFormcifblack0001(FormData formcifblack0001) {
		this.formcifblack0001 = formcifblack0001;
	}
	public List<CifBlack> getCifBlackList() {
		return cifBlackList;
	}
	public void setCifBlackList(List<CifBlack> cifBlackList) {
		this.cifBlackList = cifBlackList;
	}
	public String getFormSts() {
		return formSts;
	}
	public void setFormSts(String formSts) {
		this.formSts = formSts;
	}
}