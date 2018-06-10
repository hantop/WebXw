package  app.creditapp.corp.action;
import java.util.List;
import app.util.User;
import org.apache.struts2.ServletActionContext;
import app.util.toolkit.Ipage;
import app.creditapp.corp.bo.CorpBaseBo;
import app.creditapp.corp.bo.CorpContBo;
import app.creditapp.corp.entity.CorpAcct;
import app.creditapp.corp.entity.CorpBase;
import app.creditapp.corp.entity.CorpCert;
import app.creditapp.corp.entity.CorpCont;
import com.core.domain.screen.FormData;
import com.core.service.screen.FormService;
import com.core.struts.ActionContext;
import com.core.struts.BaseFormBean;

/**
 * Title: CorpContAction.java
 * Description:
 **/
public class CorpContAction extends BaseFormBean {

	//ҳ�洫ֵ
	private CorpCont corpCont;
	private CorpBase corpBase;
	private List<CorpCont> corpContList;

	//ע��CorpContBo
	private CorpContBo corpContBo;
	private CorpBaseBo corpBaseBo;

	private String query;
	private String contNo;		
	private String brNo;
	
	private FormData formcoop0011;
	private FormData formcoop0012;
	private FormService formService = new FormService();
	
	public CorpContAction() {
		query = "";
	}
	/**
	 * ��ҳ��ѯ
	 * @return
	 * @throws Exception
	 */
	public String findByPage() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),ServletActionContext.getResponse());
		formcoop0011 = formService.getFormData("coop0011");
		corpCont = new CorpCont();
		getFormValue(formcoop0011);
		setObjValue(formcoop0011, corpCont);
		corpCont.setBrNo(User.getBrno(ServletActionContext.getRequest()));
		Ipage ipage = this.getIpage();
		corpContList = (List) corpContBo.findByPage(ipage, corpCont).getResult();
		return "list";
	}
	
	
	/**
	 * ��ȡ����ҳ��
	 * @return
	 * @throws Exception
	 */
	public String input() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formcoop0012 = formService.getFormData("coop0012");
		
		corpCont = new CorpCont();
		corpBase = new CorpBase();
		 
		corpBase.setBrNo(brNo);
		corpBase = corpBaseBo.getById(corpBase);
		corpCont.setBrNo(brNo);
		corpCont.setBrName(corpBase.getBrName());
		
		corpCont.setDeptNo(User.getBrno(ServletActionContext.getRequest()));//�Ǽǲ���
		corpCont.setOpNo(User.getLoginid(ServletActionContext.getRequest()));//����Ա
		corpCont.setTxDate(User.getSys_date(ServletActionContext.getRequest()));//�Ǽ�����
//		corpCont.setUpDate(User.getSys_date(ServletActionContext.getRequest()));//�޸�����
//		corpCont.setUpOpno(User.getLoginid(ServletActionContext.getRequest()));//�޸���Ա
		getObjValue(formcoop0012, corpCont);
		return "input";
	}
	
	/**
	 * �����������
	 * @return
	 * @throws Exception
	 */
	public String insert() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formcoop0012 = formService.getFormData("coop0012");
		getFormValue(formcoop0012);
		corpCont = new CorpCont();
		setObjValue(formcoop0012, corpCont);
		corpCont.setDeptNo(User.getBrno(ServletActionContext.getRequest()));//�Ǽǲ���
		corpCont.setOpNo(User.getLoginid(ServletActionContext.getRequest()));//����Ա
		corpCont.setTxDate(User.getSys_date(ServletActionContext.getRequest()));//�Ǽ�����
		corpCont.setUpDate(User.getSys_date(ServletActionContext.getRequest()));//�޸�����
		corpCont.setUpOpno(User.getLoginid(ServletActionContext.getRequest()));//�޸���Ա
		corpContBo.insert(corpCont);
		getObjValue(formcoop0012, corpCont);
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
		formcoop0012 = formService.getFormData("coop0012");
		getFormValue(formcoop0012);
		corpCont = new CorpCont();
		setObjValue(formcoop0012, corpCont);
		//corpCont.setDeptNo(User.getBrno(ServletActionContext.getRequest()));//�Ǽǲ���
		//corpCont.setOpNo(User.getLoginid(ServletActionContext.getRequest()));//����Ա
		//corpCont.setTxDate(User.getSys_date(ServletActionContext.getRequest()));//�Ǽ�����
		corpCont.setUpDate(User.getSys_date(ServletActionContext.getRequest()));//�޸�����
		corpCont.setUpOpno(User.getLoginid(ServletActionContext.getRequest()));//�޸���Ա
		corpContBo.update(corpCont);
		getObjValue(formcoop0012, corpCont);
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
		formcoop0011 = formService.getFormData("coop0011");
		corpCont = new CorpCont();
		corpCont.setContNo(contNo);
		//�ж� �ú��������� ����ϵ����Ϣ�Ƿ������һ���˻���Ϣ
		CorpCont corpContForDel = new CorpCont();
		corpContForDel.setBrNo(brNo);
		int count = corpContBo.getCount(corpContForDel);
		//�� �˻���Ϣ ���� 1����ʱ�򣬿��Խ���ɾ������
		if(count>1){
			 corpContBo.del(corpCont);
			 this.addActionMessage("ɾ���ɹ�");
		}else{
			//���˻���Ϣ Ϊ1����ʱ���ж����� ����������״̬��������������״̬Ϊ ͣ�õ�ʱ�� ���Խ���ɾ�����һ�����������õĻ������ܽ�����ϵ����Ϣɾ��
			CorpBase corpBase = new CorpBase();
			corpBase.setBrNo(brNo);
			corpBase = corpBaseBo.getById(corpBase);
			String brSts = corpBase.getBrSts();
			//�������� ״̬Ϊ ͣ��״̬
			if("00".equals(brSts)){
				corpContBo.del(corpCont);
				 this.addActionMessage("ɾ���ɹ�");
			}else{
				this.addActionMessage("��������Ϊ����״̬�����ܽ�����ϵ����Ϣɾ��");
			}
		}
		corpCont = new CorpCont();
		corpCont.setBrNo(brNo);
		Ipage ipage = this.getIpage();
		corpContList = (List) corpContBo.findByPage(ipage, corpCont).getResult();
		return "list";
	}

	
	/**
	 * ��ѯ����
	 * @return
	 * @throws Exception
	 */
	public String getById() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),ServletActionContext.getResponse());
		formcoop0012 = formService.getFormData("coop0012");
		corpCont = new CorpCont();
		corpCont.setContNo(contNo);
		corpCont = corpContBo.getById(corpCont);
		getObjValue(formcoop0012, corpCont);
		return "detail";
	}
	
	/**
	 * �����������У��
	 * @return
	 * @throws Exception
	 */
	public void validateInsert(){
		 ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		 formcoop0012 = formService.getFormData("coop0012");
		 getFormValue(formcoop0012);
		 validateFormData(formcoop0012);
   	}
   
	/**
	 * �޸ı������У��
	 * @return
	 * @throws Exception
	 */
	public void validateUpdate(){
		 ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		 formcoop0012 = formService.getFormData("coop0012");
		 getFormValue(formcoop0012);
		 validateFormData(formcoop0012);
  	}
	
	 /**
	    * ���ݺ�����������ʾ���еĵ���ϵ�� ��Ϣ
	    * @return
	    * @throws Exception
	    */
	   public String listQuotaForCorp() throws Exception {
	   	ActionContext.initialize(ServletActionContext.getRequest(),
	       		ServletActionContext.getResponse());
	   	corpCont = new CorpCont();
	   	corpCont.setBrNo(brNo);
	   	Ipage ipage = this.getIpage();
	   	corpContList = (List) corpContBo.findByPageQuotaForCorp(ipage, corpCont).getResult();
	   	return "list";
	   }
	   
	   
    public String getBrNo() {
		return brNo;
	}
	public void setBrNo(String brNo) {
		this.brNo = brNo;
	}	
	public CorpCont getCorpCont() {
		return corpCont;
	}
	public void setCorpCont(CorpCont  corpCont) {
		this.corpCont = corpCont;
	}
	public List<CorpCont> getCorpContList() {
		return corpContList;
	}
	public void setCorpContList(List<CorpCont> corpContList) {
		this.corpContList = corpContList;
	}
	public CorpContBo getCorpContBo() {
		return corpContBo;
	}
	public void setCorpContBo(CorpContBo corpContBo) {
		this.corpContBo = corpContBo;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public FormData getFormcoop0012() {
		return formcoop0012;
	}
	public void setFormcoop0012(FormData formcoop0012) {
		this.formcoop0012 = formcoop0012;
	}
	public FormData getFormcoop0011() {
		return formcoop0011;
	}
	public void setFormcoop0011(FormData formcoop0011) {
		this.formcoop0011 = formcoop0011;
	}
	public void setContNo(String contNo){
		this.contNo = contNo;
	}		
	public String getContNo(){
		return contNo;
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