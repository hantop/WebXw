package  app.creditapp.acc.option.action;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import app.creditapp.acc.option.bo.AcReplanParmBo;
import app.creditapp.acc.option.bo.AcReplanSecBo;
import app.creditapp.acc.option.entity.AcReplanParm;
import app.creditapp.acc.option.entity.AcReplanSec;
import app.util.User;
import app.util.toolkit.Ipage;

import com.core.domain.screen.FormData;
import com.core.service.screen.FormService;
import com.core.struts.ActionContext;
import com.core.struts.BaseFormBean;

/**
 * Title: AcReplanParmAction.java
 * Description:
 **/
public class AcReplanParmAction extends BaseFormBean {

	//ҳ�洫ֵ
	private AcReplanParm acReplanParm;
	private List<AcReplanParm> acReplanParmList;

	//ע��AcReplanParmBo
	private AcReplanParmBo acReplanParmBo;
	private AcReplanSecBo acReplanSecBo;

	private String query;
	private String replanId;	
	private String replanSts;
    private List tabList;
	private FormData formreplan0001;
	private FormData formreplan0002;
	private FormService formService = new FormService();
	
	public AcReplanParmAction() {
		query = "";
	}
	/**
	 * ��ҳ��ѯ
	 * @return
	 * @throws Exception
	 */
	public String findByPage() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),ServletActionContext.getResponse());
		formreplan0001 = formService.getFormData("replan0001");
		acReplanParm = new AcReplanParm();
		getFormValue(formreplan0001);
		setObjValue(formreplan0001, acReplanParm);
		acReplanParm.setBrNo(User.getBrno(this.getHttpRequest()));
		Ipage ipage = this.getIpage();
		acReplanParmList = (List) acReplanParmBo.findByPage(ipage, acReplanParm).getResult();
		return "list";
	}
	//���á��رշ����б�
	public String findByPage_list() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),ServletActionContext.getResponse());
		//formreplan0001 = formService.getFormData("replan0001");
		acReplanParm = new AcReplanParm();
		//getFormValue(formreplan0001);
		//setObjValue(formreplan0001, acReplanParm);
		acReplanParm.setBrNo(User.getBrno(this.getHttpRequest()));
		Ipage ipage = this.getIpage();
		acReplanParmList = (List) acReplanParmBo.findByPage(ipage, acReplanParm).getResult();
		return "list";
	}
	
	
	/**
	 * ��ȡ����ҳ��
	 * @return
	 * @throws Exception
	 */
	public String input() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formreplan0002 = formService.getFormData("replan0002");
		return "input";
	}
	
	/**
	 * �����������
	 * @return
	 * @throws Exception
	 */
	public String insert() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formreplan0002 = formService.getFormData("replan0002");
		getFormValue(formreplan0002);
		acReplanParm = new AcReplanParm();
		setObjValue(formreplan0002, acReplanParm);
		acReplanParm.setOpNo(User.getLoginid(this.getHttpRequest()));
		acReplanParm.setBrNo(User.getBrno(this.getHttpRequest()));
		acReplanParm.setReplanSts("0");//����������Ĭ��ΪʧЧ
		acReplanParmBo.insert(acReplanParm);
		getObjValue(formreplan0002, acReplanParm);
		this.addActionMessage("�����ɹ���");
		return "detail";
	}
	
	
	/**
	 * �޸ı������
	 * @return
	 * @throws Exception
	 */
	public String update() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formreplan0002 = formService.getFormData("replan0002");
		getFormValue(formreplan0002);
		acReplanParm = new AcReplanParm();
		setObjValue(formreplan0002, acReplanParm);
		acReplanParm.setUpDate(User.getSys_date(this.getHttpRequest()));
		acReplanParmBo.update(acReplanParm);
		getObjValue(formreplan0002, acReplanParm);
		this.addActionMessage("�����ɹ���");
		return "detail";
	}
	
	/**
	 * ��������
	 * @return
	 * @throws Exception
	 */
	public String openReplan() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		acReplanParm = new AcReplanParm();
		acReplanParm.setReplanId(replanId);
		acReplanParm.setReplanSts("1");
		acReplanParmBo.updateReplanSts(acReplanParm);
		//getObjValue(formreplan0002, acReplanParm);
		this.addActionMessage("�����ɹ���");
		return findByPage_list();
	}
	
	/**
	 * ��������У��
	 * @return
	 * @throws Exception
	 */
	public void validateOpenReplan() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		AcReplanParm acReplanParm = new AcReplanParm();
		acReplanParm.setReplanId(replanId);
		acReplanParm = acReplanParmBo.getById(acReplanParm);
		
		AcReplanSec acReplanSec = new AcReplanSec();
		List<AcReplanSec> acReplanSecList = new ArrayList<AcReplanSec>();
		acReplanSec.setReplanId(replanId);
		acReplanSecList = acReplanSecBo.getListByReplanId(acReplanSec);
		double sumCapitalRate = 0.00;
		for(int i=1;i<=acReplanParm.getSecNo();i++){
			for(AcReplanSec ars : acReplanSecList){
				sumCapitalRate += ars.getCapitalRate();
			}
			AcReplanSec acReplanSec2 = new AcReplanSec();
			acReplanSec2.setReplanId(replanId);
			acReplanSec2.setSecOrderNo(String.valueOf(i));
			acReplanSec2 = acReplanSecBo.getByIdAndOrderNo(acReplanSec2);
			if(acReplanSec2 == null){
				this.addActionError("�û�����е�"+i+"�λ���ֶ���Ϣ�����ڣ�");
			}
		}
		if(sumCapitalRate<1){
			this.addActionError("����ֶεķֶα������֮�Ͳ�����100%���÷����޷����ã�");
		}
		
		formreplan0001 = formService.getFormData("replan0001");
		acReplanParm = new AcReplanParm();
		getFormValue(formreplan0001);
		setObjValue(formreplan0001, acReplanParm);
		acReplanParm.setBrNo(User.getBrno(this.getHttpRequest()));
		Ipage ipage = this.getIpage();
		acReplanParmList = (List) acReplanParmBo.findByPage(ipage, acReplanParm).getResult();
	}
	
	/**
	 * �رղ���
	 * @return
	 * @throws Exception
	 */
	public String closeReplan() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		acReplanParm = new AcReplanParm();
		acReplanParm.setReplanId(replanId);
		acReplanParm.setReplanSts("0");
		acReplanParmBo.updateReplanSts(acReplanParm);
		//getObjValue(formreplan0002, acReplanParm);
		this.addActionMessage("�����ɹ���");
		//return findByPage();
		return findByPage_list();
	}
	
	
	
	/**
	 * ɾ������
	 * @return
	 * @throws Exception
	 */
	public String del() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formreplan0001 = formService.getFormData("replan0001");
		acReplanParm = new AcReplanParm();
		acReplanParm.setReplanId(replanId);
		acReplanParmBo.del(acReplanParm);
		this.addActionMessage("ɾ���ɹ�");
		acReplanParm = new AcReplanParm();
		acReplanParm.setBrNo(User.getBrno(this.getHttpRequest()));
		Ipage ipage = this.getIpage();
		acReplanParmList = (List) acReplanParmBo.findByPage(ipage, acReplanParm).getResult();
		return "list";
	}

	public String getTab() throws Exception{
		tabList = new ArrayList();
		String[] tab = new String[2];
		tab[0] = "�������Ϣ";
		tab[1] = "AcReplanParmAction_getById.action?replanId="
				+ replanId ;
		tabList.add(tab);
		
		tab = new String[2];
		tab[0] = "����ֶ���Ϣ";
		tab[1] = "AcReplanSecAction_findByReplanId.action?replanId="
				+ replanId ;
		tabList.add(tab);
		return "tab";
	}
	
	public String getTabView() throws Exception{
		tabList = new ArrayList();
		String[] tab = new String[2];
		tab[0] = "�������Ϣ";
		tab[1] = "AcReplanParmAction_getById.action?replanId="
				+ replanId + "&query=query&view=view";
		tabList.add(tab);
		
		tab = new String[2];
		tab[0] = "����ֶ���Ϣ";
		tab[1] = "AcReplanSecAction_findByReplanId.action?replanId="
				+ replanId + "&query=query&view=view";
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
		formreplan0002 = formService.getFormData("replan0002");
		acReplanParm = new AcReplanParm();
		acReplanParm.setReplanId(replanId);
		acReplanParm = acReplanParmBo.getById(acReplanParm);
		getObjValue(formreplan0002, acReplanParm);
		return "detail";
	}
	
	/**
	 * �����������У��
	 * @return
	 * @throws Exception
	 */
	public void validateInsert(){
		 ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		 formreplan0002 = formService.getFormData("replan0002");
		 getFormValue(formreplan0002);
		 validateFormData(formreplan0002);
   	}
   
	/**
	 * �޸ı������У��
	 * @return
	 * @throws Exception
	 */
	public void validateUpdate(){
		 ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		 formreplan0002 = formService.getFormData("replan0002");
		 getFormValue(formreplan0002);
		 validateFormData(formreplan0002);
  	}
	public AcReplanParm getAcReplanParm() {
		return acReplanParm;
	}
	public void setAcReplanParm(AcReplanParm  acReplanParm) {
		this.acReplanParm = acReplanParm;
	}
	public List<AcReplanParm> getAcReplanParmList() {
		return acReplanParmList;
	}
	public void setAcReplanParmList(List<AcReplanParm> acReplanParmList) {
		this.acReplanParmList = acReplanParmList;
	}
	public AcReplanParmBo getAcReplanParmBo() {
		return acReplanParmBo;
	}
	public void setAcReplanParmBo(AcReplanParmBo acReplanParmBo) {
		this.acReplanParmBo = acReplanParmBo;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public FormData getFormreplan0002() {
		return formreplan0002;
	}
	public void setFormreplan0002(FormData formreplan0002) {
		this.formreplan0002 = formreplan0002;
	}
	public FormData getFormreplan0001() {
		return formreplan0001;
	}
	public void setFormreplan0001(FormData formreplan0001) {
		this.formreplan0001 = formreplan0001;
	}
	public void setReplanId(String replanId){
		this.replanId = replanId;
	}		
	public String getReplanId(){
		return replanId;
	}
	public List getTabList() {
		return tabList;
	}
	public void setTabList(List tabList) {
		this.tabList = tabList;
	}
	public AcReplanSecBo getAcReplanSecBo() {
		return acReplanSecBo;
	}
	public void setAcReplanSecBo(AcReplanSecBo acReplanSecBo) {
		this.acReplanSecBo = acReplanSecBo;
	}
	public String getReplanSts() {
		return replanSts;
	}
	public void setReplanSts(String replanSts) {
		this.replanSts = replanSts;
	}
}