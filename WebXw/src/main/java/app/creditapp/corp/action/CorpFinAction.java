package  app.creditapp.corp.action;
import java.util.List;
import app.util.User;
import org.apache.struts2.ServletActionContext;
import app.util.toolkit.Ipage;
import app.creditapp.corp.bo.CorpBaseBo;
import app.creditapp.corp.bo.CorpFinBo;
import app.creditapp.corp.entity.CorpBase;
import app.creditapp.corp.entity.CorpCert;
import app.creditapp.corp.entity.CorpCont;
import app.creditapp.corp.entity.CorpFin;
import com.core.domain.screen.FormData;
import com.core.service.screen.FormService;
import com.core.struts.ActionContext;
import com.core.struts.BaseFormBean;

/**
 * Title: CorpFinAction.java
 * Description:
 **/
public class CorpFinAction extends BaseFormBean {

	//ҳ�洫ֵ
	private CorpFin corpFin;
	private CorpBase corpBase;
	private List<CorpFin> corpFinList;

	//ע��CorpFinBo
	private CorpFinBo corpFinBo;
	private CorpBaseBo corpBaseBo;

	
	private String query;
	private String finId;	
	private String brNo;
	
	private FormData formcoop0007;
	private FormData formcoop0008;
	private FormService formService = new FormService();
	
	public CorpFinAction() {
		query = "";
	}
	/**
	 * ��ҳ��ѯ
	 * @return
	 * @throws Exception
	 */
	public String findByPage() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),ServletActionContext.getResponse());
		formcoop0007 = formService.getFormData("coop0007");
		corpFin = new CorpFin();
		getFormValue(formcoop0007);
		setObjValue(formcoop0007, corpFin);
		corpFin.setBrNo(User.getBrno(ServletActionContext.getRequest()));
		Ipage ipage = this.getIpage();
		corpFinList = (List) corpFinBo.findByPage(ipage, corpFin).getResult();
		return "list";
	}
	
	
	/**
	 * ��ȡ����ҳ��
	 * @return
	 * @throws Exception
	 */
	public String input() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formcoop0008 = formService.getFormData("coop0008");
		corpFin = new CorpFin();
		corpBase = new CorpBase();
		 
		corpBase.setBrNo(brNo);
		corpBase = corpBaseBo.getById(corpBase);
		corpFin.setBrNo(brNo);
		corpFin.setBrName(corpBase.getBrName());
		
		corpFin.setDeptNo(User.getBrno(ServletActionContext.getRequest()));//�Ǽǲ���
		corpFin.setOpNo(User.getLoginid(ServletActionContext.getRequest()));//����Ա
		corpFin.setTxDate(User.getSys_date(ServletActionContext.getRequest()));//�Ǽ�����
//		corpFin.setUpDate(User.getSys_date(ServletActionContext.getRequest()));//�޸�����
//		corpFin.setUpOpno(User.getLoginid(ServletActionContext.getRequest()));//�޸���Ա
		getObjValue(formcoop0008, corpFin);
		
		return "input";
	}
	
	/**
	 * �����������
	 * @return
	 * @throws Exception
	 */
	public String insert() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formcoop0008 = formService.getFormData("coop0008");
		getFormValue(formcoop0008);
		corpFin = new CorpFin();
		setObjValue(formcoop0008, corpFin);
		corpFin.setDeptNo(User.getBrno(ServletActionContext.getRequest()));//�Ǽǲ���
		corpFin.setOpNo(User.getLoginid(ServletActionContext.getRequest()));//����Ա
		corpFin.setTxDate(User.getSys_date(ServletActionContext.getRequest()));//�Ǽ�����
//		corpFin.setUpDate(User.getSys_date(ServletActionContext.getRequest()));//�޸�����
//		corpFin.setUpOpno(User.getLoginid(ServletActionContext.getRequest()));//�޸���Ա
		corpFinBo.insert(corpFin);
		getObjValue(formcoop0008, corpFin);
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
		formcoop0008 = formService.getFormData("coop0008");
		getFormValue(formcoop0008);
		corpFin = new CorpFin();
		setObjValue(formcoop0008, corpFin);
		//corpFin.setDeptNo(User.getBrno(ServletActionContext.getRequest()));//�Ǽǲ���
		//corpFin.setOpNo(User.getLoginid(ServletActionContext.getRequest()));//����Ա
		//corpFin.setTxDate(User.getSys_date(ServletActionContext.getRequest()));//�Ǽ�����
		corpFin.setUpDate(User.getSys_date(ServletActionContext.getRequest()));//�޸�����
		corpFin.setUpOpno(User.getLoginid(ServletActionContext.getRequest()));//�޸���Ա
		corpFinBo.update(corpFin);
		getObjValue(formcoop0008, corpFin);
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
		formcoop0007 = formService.getFormData("coop0007");
		corpFin = new CorpFin();
		corpFin.setFinId(finId);
		corpFinBo.del(corpFin);
		this.addActionMessage("ɾ���ɹ�");
		corpFin = new CorpFin();
		corpFin.setBrNo(brNo);
		Ipage ipage = this.getIpage();
		corpFinList = (List) corpFinBo.findByPage(ipage, corpFin).getResult();
		return "list";
	}

	
	/**
	 * ��ѯ����
	 * @return
	 * @throws Exception
	 */
	public String getById() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),ServletActionContext.getResponse());
		formcoop0008 = formService.getFormData("coop0008");
		corpFin = new CorpFin();
		corpFin.setFinId(finId);
		corpFin = corpFinBo.getById(corpFin);
		getObjValue(formcoop0008, corpFin);
		return "detail";
	}
	
	/**
	 * �����������У��
	 * @return
	 * @throws Exception
	 */
	public void validateInsert(){
		 ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		 formcoop0008 = formService.getFormData("coop0008");
		 getFormValue(formcoop0008);
		 validateFormData(formcoop0008);
   	}
   
	/**
	 * �޸ı������У��
	 * @return
	 * @throws Exception
	 */
	public void validateUpdate(){
		 ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		 formcoop0008 = formService.getFormData("coop0008");
		 getFormValue(formcoop0008);
		 validateFormData(formcoop0008);
  	}
	
	/**
	    * ���ݺ�����������ʾ���еĵĲ�����Ϣ
	    * @return
	    * @throws Exception
	    */
	   public String listQuotaForCorp() throws Exception {
	   	ActionContext.initialize(ServletActionContext.getRequest(),
	       		ServletActionContext.getResponse());
	   	corpFin = new CorpFin();
	   	corpFin.setBrNo(brNo);
	   	Ipage ipage = this.getIpage();
	   	corpFinList = (List) corpFinBo.findByPageQuotaForCorp(ipage, corpFin).getResult();
	   	return "list";
	   }
    public String getBrNo() {
		return brNo;
	}
	public void setBrNo(String brNo) {
		this.brNo = brNo;
	}
	public CorpFin getCorpFin() {
		return corpFin;
	}
	public void setCorpFin(CorpFin  corpFin) {
		this.corpFin = corpFin;
	}
	public List<CorpFin> getCorpFinList() {
		return corpFinList;
	}
	public void setCorpFinList(List<CorpFin> corpFinList) {
		this.corpFinList = corpFinList;
	}
	public CorpFinBo getCorpFinBo() {
		return corpFinBo;
	}
	public void setCorpFinBo(CorpFinBo corpFinBo) {
		this.corpFinBo = corpFinBo;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public FormData getFormcoop0008() {
		return formcoop0008;
	}
	public void setFormcoop0008(FormData formcoop0008) {
		this.formcoop0008 = formcoop0008;
	}
	public FormData getFormcoop0007() {
		return formcoop0007;
	}
	public void setFormcoop0007(FormData formcoop0007) {
		this.formcoop0007 = formcoop0007;
	}
	public void setFinId(String finId){
		this.finId = finId;
	}		
	public String getFinId(){
		return finId;
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