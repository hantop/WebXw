package  app.creditapp.corp.action;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.core.domain.screen.FormData;
import com.core.service.screen.FormService;
import com.core.struts.ActionContext;
import com.core.struts.BaseFormBean;

import app.creditapp.corp.bo.CorpAcctBo;
import app.creditapp.corp.bo.CorpBaseBo;
import app.creditapp.corp.entity.CorpAcct;
import app.creditapp.corp.entity.CorpBase;
import app.util.User;
import app.util.toolkit.Ipage;

/**
 * Title: CorpAcctAction.java
 * Description:
 **/
public class CorpAcctAction extends BaseFormBean {

	//ҳ�洫ֵ
	private CorpAcct corpAcct;
	private CorpBase corpBase;
	private List<CorpAcct> corpAcctList;

	//ע��CorpAcctBo
	private CorpAcctBo corpAcctBo;
	private CorpBaseBo corpBaseBo;

	
	private String query;
	private String acctId;
	private String brNo;
	
	private FormData formcoop0013;
	private FormData formcoop0014;
	private FormService formService = new FormService();
	
	public CorpAcctAction() {
		query = "";
	}
	/**
	 * ��ҳ��ѯ
	 * @return
	 * @throws Exception
	 */
	public String findByPage() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),ServletActionContext.getResponse());
		formcoop0013 = formService.getFormData("coop0013");
		corpAcct = new CorpAcct();
		getFormValue(formcoop0013);
		setObjValue(formcoop0013, corpAcct);
		corpAcct.setBrNo(User.getBrno(ServletActionContext.getRequest()));
		Ipage ipage = this.getIpage();
		corpAcctList = (List) corpAcctBo.findByPage(ipage, corpAcct).getResult();
		return "list";
	}
	
	
	/**
	 * ��ȡ����ҳ��
	 * @return
	 * @throws Exception
	 */
	public String input() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formcoop0014 = formService.getFormData("coop0014");
		String returnSts = "";
		corpAcct = new CorpAcct();
		corpBase = new CorpBase();
		corpBase.setBrNo(brNo);
		corpBase = corpBaseBo.getById(corpBase);
		corpAcct.setBrNo(brNo);
		corpAcct.setBrName(corpBase.getBrName());
		if(corpAcctBo.getById(corpAcct)==null){//�жϺ��������Ƿ�������˻���Ϣ
			corpAcct.setDeptNo(User.getBrno(ServletActionContext.getRequest()));//�Ǽǲ���
			corpAcct.setOpNo(User.getLoginid(ServletActionContext.getRequest()));//����Ա
			corpAcct.setTxDate(User.getSys_date(ServletActionContext.getRequest()));//�Ǽ�����
//			corpAcct.setUpDate(User.getSys_date(ServletActionContext.getRequest()));//�޸�����
//			corpAcct.setUpOpno(User.getLoginid(ServletActionContext.getRequest()));//�޸���Ա
			getObjValue(formcoop0014, corpAcct);
			returnSts = "input";
		}else{
			Ipage ipage = this.getIpage();
		   	corpAcctList = (List) corpAcctBo.findByPageQuotaForCorp(ipage, corpAcct).getResult();
		   	this.addActionMessage(corpBase.getBrName()+"������˻���Ϣ");
		   	returnSts =  "list";
		}
		return returnSts;
	}
	
	/**
	 * �����������
	 * @return
	 * @throws Exception
	 */
	public String insert() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formcoop0014 = formService.getFormData("coop0014");
		getFormValue(formcoop0014);
		corpAcct = new CorpAcct();
		setObjValue(formcoop0014, corpAcct);
		
		corpAcct.setDeptNo(User.getBrno(ServletActionContext.getRequest()));//�Ǽǲ���
		corpAcct.setOpNo(User.getLoginid(ServletActionContext.getRequest()));//����Ա
		corpAcct.setTxDate(User.getSys_date(ServletActionContext.getRequest()));//�Ǽ�����
		//corpAcct.setUpDate(User.getSys_date(ServletActionContext.getRequest()));//�޸�����
		//corpAcct.setUpOpno(User.getLoginid(ServletActionContext.getRequest()));//�޸���Ա
		corpAcctBo.insert(corpAcct);
		getObjValue(formcoop0014, corpAcct);
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
		formcoop0014 = formService.getFormData("coop0014");
		getFormValue(formcoop0014);
		corpAcct = new CorpAcct();
		setObjValue(formcoop0014, corpAcct);
		//corpAcct.setDeptNo(User.getBrno(ServletActionContext.getRequest()));//�Ǽǲ���
		//corpAcct.setOpNo(User.getLoginid(ServletActionContext.getRequest()));//����Ա
		//corpAcct.setTxDate(User.getSys_date(ServletActionContext.getRequest()));//�Ǽ�����
		corpAcct.setUpDate(User.getSys_date(ServletActionContext.getRequest()));//�޸�����
		corpAcct.setUpOpno(User.getLoginid(ServletActionContext.getRequest()));//�޸���Ա
		corpAcctBo.update(corpAcct);
		getObjValue(formcoop0014, corpAcct);
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
		formcoop0013 = formService.getFormData("coop0013");
		corpAcct = new CorpAcct();
		corpAcct.setAcctId(acctId);
		//�ж� �ú��������� ���˻���Ϣ�Ƿ������һ���˻���Ϣ
		CorpAcct corpAcctForDel = new CorpAcct();
		corpAcctForDel.setBrNo(brNo);
		int count = corpAcctBo.getCount(corpAcctForDel);
		//�� �˻���Ϣ ���� 1����ʱ�򣬿��Խ���ɾ������
		if(count>1){
			 corpAcctBo.del(corpAcct);	
			 this.addActionMessage("ɾ���ɹ�");
		}else{
			//���˻���Ϣ Ϊ1����ʱ���ж����� ����������״̬��������������״̬Ϊ ͣ�õ�ʱ�� ���Խ���ɾ�����һ�����������õĻ������ܽ����˻���Ϣɾ��
			CorpBase corpBase = new CorpBase();
			corpBase.setBrNo(brNo);
			corpBase = corpBaseBo.getById(corpBase);
			String brSts = corpBase.getBrSts();
			//�������� ״̬Ϊ ͣ��״̬
			if("00".equals(brSts)){
				 corpAcctBo.del(corpAcct);
				 this.addActionMessage("ɾ���ɹ�");
			}else{
				this.addActionMessage("��������Ϊ����״̬�����ܽ����˻���Ϣɾ��");
			}
		}
		corpAcct = new CorpAcct();
		corpAcct.setBrNo(brNo);
		Ipage ipage = this.getIpage();
		corpAcctList = (List) corpAcctBo.findByPage(ipage, corpAcct).getResult();
		return "list";
	}

	
	/**
	 * ��ѯ����
	 * @return
	 * @throws Exception
	 */
	public String getById() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),ServletActionContext.getResponse());
		formcoop0014 = formService.getFormData("coop0014");
		corpAcct = new CorpAcct();
		corpAcct.setAcctId(acctId);
		corpAcct = corpAcctBo.getById(corpAcct);
		getObjValue(formcoop0014, corpAcct);
		return "detail";
	}
	
	/**
	 * �����������У��
	 * @return
	 * @throws Exception
	 */
	public void validateInsert(){
		 ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		 formcoop0014 = formService.getFormData("coop0014");
		 getFormValue(formcoop0014);
		 validateFormData(formcoop0014);
   	}
   
	/**
	 * �޸ı������У��
	 * @return
	 * @throws Exception
	 */
	public void validateUpdate(){
		 ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		 formcoop0014 = formService.getFormData("coop0014");
		 getFormValue(formcoop0014);
		 validateFormData(formcoop0014);
  	}
	
	
	
	 /**
    * ���ݺ�����������ʾ���еĵ��˻���Ϣ
    * @return
    * @throws Exception
    */
   public String listQuotaForCorp() throws Exception {
   	ActionContext.initialize(ServletActionContext.getRequest(),
       		ServletActionContext.getResponse());
   	corpAcct = new CorpAcct();
   	corpAcct.setBrNo(brNo);
   	Ipage ipage = this.getIpage();
   	corpAcctList = (List) corpAcctBo.findByPageQuotaForCorp(ipage, corpAcct).getResult();
   	return "list";
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
    public String getBrNo() {
		return brNo;
	}
	public void setBrNo(String brNo) {
		this.brNo = brNo;
	}
	public CorpAcct getCorpAcct() {
		return corpAcct;
	}
	public void setCorpAcct(CorpAcct  corpAcct) {
		this.corpAcct = corpAcct;
	}
	public List<CorpAcct> getCorpAcctList() {
		return corpAcctList;
	}
	public void setCorpAcctList(List<CorpAcct> corpAcctList) {
		this.corpAcctList = corpAcctList;
	}
	public CorpAcctBo getCorpAcctBo() {
		return corpAcctBo;
	}
	public void setCorpAcctBo(CorpAcctBo corpAcctBo) {
		this.corpAcctBo = corpAcctBo;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public FormData getFormcoop0014() {
		return formcoop0014;
	}
	public void setFormcoop0014(FormData formcoop0014) {
		this.formcoop0014 = formcoop0014;
	}
	public FormData getFormcoop0013() {
		return formcoop0013;
	}
	public void setFormcoop0013(FormData formcoop0013) {
		this.formcoop0013 = formcoop0013;
	}
	public void setAcctId(String acctId){
		this.acctId = acctId;
	}		
	public String getAcctId(){
		return acctId;
	}
}