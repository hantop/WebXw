package  app.creditapp.corp.action;
import java.util.List;
import app.util.User;
import org.apache.struts2.ServletActionContext;
import app.util.toolkit.Ipage;
import app.creditapp.corp.bo.CorpBaseBo;
import app.creditapp.corp.bo.CorpGdinfoBo;
import app.creditapp.corp.entity.CorpBase;
import app.creditapp.corp.entity.CorpCert;
import app.creditapp.corp.entity.CorpCont;
import app.creditapp.corp.entity.CorpGdinfo;
import com.core.domain.screen.FormData;
import com.core.service.screen.FormService;
import com.core.struts.ActionContext;
import com.core.struts.BaseFormBean;

/**
 * Title: CorpGdinfoAction.java
 * Description:
 **/
public class CorpGdinfoAction extends BaseFormBean {

	//ҳ�洫ֵ
	private CorpGdinfo corpGdinfo;
	private CorpBase corpBase;
	private List<CorpGdinfo> corpGdinfoList;

	//ע��CorpGdinfoBo
	private CorpGdinfoBo corpGdinfoBo;
	private CorpBaseBo corpBaseBo;

	
	private String query;
	private String gdId;
	private String brNo;
	
	private FormData formcoop0009;
	private FormData formcoop0010;
	private FormService formService = new FormService();
	
	public CorpGdinfoAction() {
		query = "";
	}
	/**
	 * ��ҳ��ѯ
	 * @return
	 * @throws Exception
	 */
	public String findByPage() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),ServletActionContext.getResponse());
		formcoop0009 = formService.getFormData("coop0009");
		corpGdinfo = new CorpGdinfo();
		getFormValue(formcoop0009);
		setObjValue(formcoop0009, corpGdinfo);
		corpGdinfo.setBrNo(User.getBrno(ServletActionContext.getRequest()));
		Ipage ipage = this.getIpage();
		corpGdinfoList = (List) corpGdinfoBo.findByPage(ipage, corpGdinfo).getResult();
		return "list";
	}
	
	
	/**
	 * ��ȡ����ҳ��
	 * @return
	 * @throws Exception
	 */
	public String input() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formcoop0010 = formService.getFormData("coop0010");
		corpGdinfo = new CorpGdinfo();
		corpBase = new CorpBase();
		 
		corpBase.setBrNo(brNo);
		corpBase = corpBaseBo.getById(corpBase);
		corpGdinfo.setBrNo(brNo);
		corpGdinfo.setBrName(corpBase.getBrName());
		corpGdinfo.setCurNo("CNY");
		corpGdinfo.setDeptNo(User.getBrno(ServletActionContext.getRequest()));//�Ǽǲ���
		corpGdinfo.setOpNo(User.getLoginid(ServletActionContext.getRequest()));//����Ա
		corpGdinfo.setTxDate(User.getSys_date(ServletActionContext.getRequest()));//�Ǽ�����
//		corpGdinfo.setUpDate(User.getSys_date(ServletActionContext.getRequest()));//�޸�����
//		corpGdinfo.setUpOpno(User.getLoginid(ServletActionContext.getRequest()));//�޸���Ա
		getObjValue(formcoop0010, corpGdinfo);
		return "input";
	}
	
	/**
	 * �����������
	 * @return
	 * @throws Exception
	 */
	public String insert() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formcoop0010 = formService.getFormData("coop0010");
		getFormValue(formcoop0010);
		corpGdinfo = new CorpGdinfo();
		setObjValue(formcoop0010, corpGdinfo);
		corpGdinfo.setDeptNo(User.getBrno(ServletActionContext.getRequest()));//�Ǽǲ���
		corpGdinfo.setOpNo(User.getLoginid(ServletActionContext.getRequest()));//����Ա
		corpGdinfo.setTxDate(User.getSys_date(ServletActionContext.getRequest()));//�Ǽ�����
		//corpGdinfo.setUpDate(User.getSys_date(ServletActionContext.getRequest()));//�޸�����
		//corpGdinfo.setUpOpno(User.getLoginid(ServletActionContext.getRequest()));//�޸���Ա
		corpGdinfoBo.insert(corpGdinfo);
		getObjValue(formcoop0010, corpGdinfo);
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
		formcoop0010 = formService.getFormData("coop0010");
		getFormValue(formcoop0010);
		corpGdinfo = new CorpGdinfo();
		setObjValue(formcoop0010, corpGdinfo);
		//corpGdinfo.setDeptNo(User.getBrno(ServletActionContext.getRequest()));//�Ǽǲ���
		//corpGdinfo.setOpNo(User.getLoginid(ServletActionContext.getRequest()));//����Ա
		//corpGdinfo.setTxDate(User.getSys_date(ServletActionContext.getRequest()));//�Ǽ�����
		corpGdinfo.setUpDate(User.getSys_date(ServletActionContext.getRequest()));//�޸�����
		corpGdinfo.setUpOpno(User.getLoginid(ServletActionContext.getRequest()));//�޸���Ա
		corpGdinfoBo.update(corpGdinfo);
		getObjValue(formcoop0010, corpGdinfo);
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
		formcoop0009 = formService.getFormData("coop0009");
		corpGdinfo = new CorpGdinfo();
		corpGdinfo.setGdId(gdId);
		corpGdinfoBo.del(corpGdinfo);
		this.addActionMessage("ɾ���ɹ�");
		corpGdinfo = new CorpGdinfo();
		corpGdinfo.setBrNo(brNo);
		Ipage ipage = this.getIpage();
		corpGdinfoList = (List) corpGdinfoBo.findByPage(ipage, corpGdinfo).getResult();
		return "list";
	}

	
	/**
	 * ��ѯ����
	 * @return
	 * @throws Exception
	 */
	public String getById() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),ServletActionContext.getResponse());
		formcoop0010 = formService.getFormData("coop0010");
		corpGdinfo = new CorpGdinfo();
		corpGdinfo.setGdId(gdId);
		corpGdinfo = corpGdinfoBo.getById(corpGdinfo);
		getObjValue(formcoop0010, corpGdinfo);
		return "detail";
	}
	
	/**
	 * �����������У��
	 * @return
	 * @throws Exception
	 */
	public void validateInsert(){
		 ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		 formcoop0010 = formService.getFormData("coop0010");
		 getFormValue(formcoop0010);
		 validateFormData(formcoop0010);
   	}
   
	/**
	 * �޸ı������У��
	 * @return
	 * @throws Exception
	 */
	public void validateUpdate(){
		 ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		 formcoop0010 = formService.getFormData("coop0010");
		 getFormValue(formcoop0010);
		 validateFormData(formcoop0010);
  	}
	
	/**
	    * ���ݺ�����������ʾ���еĵĹɶ� ��Ϣ
	    * @return
	    * @throws Exception
	    */
	   public String listQuotaForCorp() throws Exception {
	   	ActionContext.initialize(ServletActionContext.getRequest(),
	       		ServletActionContext.getResponse());
	   	corpGdinfo = new CorpGdinfo();
	   	corpGdinfo.setBrNo(brNo);
	   	Ipage ipage = this.getIpage();
	   	corpGdinfoList = (List) corpGdinfoBo.findByPageQuotaForCorp(ipage, corpGdinfo).getResult();
	   	return "list";
	   }
    public String getBrNo() {
		return brNo;
	}
	public void setBrNo(String brNo) {
		this.brNo = brNo;
	}
	public CorpGdinfo getCorpGdinfo() {
		return corpGdinfo;
	}
	public void setCorpGdinfo(CorpGdinfo  corpGdinfo) {
		this.corpGdinfo = corpGdinfo;
	}
	public List<CorpGdinfo> getCorpGdinfoList() {
		return corpGdinfoList;
	}
	public void setCorpGdinfoList(List<CorpGdinfo> corpGdinfoList) {
		this.corpGdinfoList = corpGdinfoList;
	}
	public CorpGdinfoBo getCorpGdinfoBo() {
		return corpGdinfoBo;
	}
	public void setCorpGdinfoBo(CorpGdinfoBo corpGdinfoBo) {
		this.corpGdinfoBo = corpGdinfoBo;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public FormData getFormcoop0010() {
		return formcoop0010;
	}
	public void setFormcoop0010(FormData formcoop0010) {
		this.formcoop0010 = formcoop0010;
	}
	public FormData getFormcoop0009() {
		return formcoop0009;
	}
	public void setFormcoop0009(FormData formcoop0009) {
		this.formcoop0009 = formcoop0009;
	}
	public void setGdId(String gdId){
		this.gdId = gdId;
	}		
	public String getGdId(){
		return gdId;
	}
	public CorpBase getCorpBase() {
		return corpBase;
	}
	public void setCorpBase(CorpBase corpBase) {
		this.corpBase = corpBase;
	}
	public CorpBaseBo getCorpBaseBo() {
		return corpBaseBo;
	}
	public void setCorpBaseBo(CorpBaseBo corpBaseBo) {
		this.corpBaseBo = corpBaseBo;
	}
}