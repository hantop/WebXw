package  app.creditapp.corp.action;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import app.creditapp.corp.bo.CorpBaseBo;
import app.creditapp.corp.bo.CorpCertBo;
import app.creditapp.corp.entity.CorpBase;
import app.creditapp.corp.entity.CorpCert;
import app.util.User;
import app.util.toolkit.Ipage;

import com.core.domain.screen.FormData;
import com.core.service.screen.FormService;
import com.core.struts.ActionContext;
import com.core.struts.BaseFormBean;

/**
 * Title: CorpCertAction.java
 * Description:
 **/
public class CorpCertAction extends BaseFormBean {

	//ҳ�洫ֵ
	private CorpCert corpCert;
	private CorpBase corpBase;
	
	private List<CorpCert> corpCertList;

	//ע��CorpCertBo
	private CorpCertBo corpCertBo;
	private CorpBaseBo corpBaseBo;

	
	
	private String query;
	private String certId;	
	private String brNo;
	
	private FormData formcoop0005;
	private FormData formcoop0006;
	private FormService formService = new FormService();
	
	public CorpCertAction() {
		query = "";
	}
	/**
	 * ��ҳ��ѯ
	 * @return
	 * @throws Exception
	 */
	public String findByPage() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),ServletActionContext.getResponse());
		formcoop0005 = formService.getFormData("coop0005");
		corpCert = new CorpCert();
		getFormValue(formcoop0005);
		setObjValue(formcoop0005, corpCert);
		corpCert.setBrNo(User.getBrno(ServletActionContext.getRequest()));
		Ipage ipage = this.getIpage();
		corpCertList = (List) corpCertBo.findByPage(ipage, corpCert).getResult();
		return "list";
	}
	
	
	/**
	 * ��ȡ����ҳ��
	 * @return
	 * @throws Exception
	 */
	public String input() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formcoop0006 = formService.getFormData("coop0006");
		corpCert = new CorpCert();
		corpBase = new CorpBase();
		 
		corpBase.setBrNo(brNo);
		corpBase = corpBaseBo.getById(corpBase);
		corpCert.setBrNo(brNo);
		corpCert.setBrName(corpBase.getBrName());
		
		corpCert.setDeptNo(User.getBrno(ServletActionContext.getRequest()));//�Ǽǲ���
		corpCert.setOpNo(User.getLoginid(ServletActionContext.getRequest()));//����Ա
		corpCert.setTxDate(User.getSys_date(ServletActionContext.getRequest()));//�Ǽ�����
//		corpCert.setUpDate(User.getSys_date(ServletActionContext.getRequest()));//�޸�����
//		corpCert.setUpOpNo(User.getLoginid(ServletActionContext.getRequest()));//�޸���Ա
		getObjValue(formcoop0006, corpCert);
		return "input";
	}
	
	/**
	 * �����������
	 * @return
	 * @throws Exception
	 */
	public String insert() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formcoop0006 = formService.getFormData("coop0006");
		getFormValue(formcoop0006);
		corpCert = new CorpCert();
		setObjValue(formcoop0006, corpCert);
		corpCert.setDeptNo(User.getBrno(ServletActionContext.getRequest()));//�Ǽǲ���
		corpCert.setOpNo(User.getLoginid(ServletActionContext.getRequest()));//����Ա
		corpCert.setTxDate(User.getSys_date(ServletActionContext.getRequest()));//�Ǽ�����
		//corpCert.setUpDate(User.getSys_date(ServletActionContext.getRequest()));//�޸�����
		//corpCert.setUpOpno(User.getLoginid(ServletActionContext.getRequest()));//�޸���Ա
		corpCertBo.insert(corpCert);
		getObjValue(formcoop0006, corpCert);
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
		formcoop0006 = formService.getFormData("coop0006");
		getFormValue(formcoop0006);
		corpCert = new CorpCert();
		setObjValue(formcoop0006, corpCert);
//		corpCert.setDeptNo(User.getBrno(ServletActionContext.getRequest()));//�Ǽǲ���
//		corpCert.setOpNo(User.getLoginid(ServletActionContext.getRequest()));//����Ա
//		corpCert.setTxDate(User.getSys_date(ServletActionContext.getRequest()));//�Ǽ�����
		corpCert.setUpDate(User.getSys_date(ServletActionContext.getRequest()));//�޸�����
		corpCert.setUpOpNo(User.getLoginid(ServletActionContext.getRequest()));//�޸���Ա
		corpCertBo.update(corpCert);
		getObjValue(formcoop0006, corpCert);
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
		formcoop0005 = formService.getFormData("coop0005");
		corpCert = new CorpCert();
		corpCert.setCertId(certId);
		corpCertBo.del(corpCert);
		this.addActionMessage("ɾ���ɹ�");
		corpCert = new CorpCert();
		corpCert.setBrNo(brNo);
		Ipage ipage = this.getIpage();
		corpCertList = (List) corpCertBo.findByPage(ipage, corpCert).getResult();
		return "list";
	}

	
	/**
	 * ��ѯ����
	 * @return
	 * @throws Exception
	 */
	public String getById() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),ServletActionContext.getResponse());
		formcoop0006 = formService.getFormData("coop0006");
		corpCert = new CorpCert();
		corpCert.setCertId(certId);
		corpCert = corpCertBo.getById(corpCert);
		getObjValue(formcoop0006, corpCert);
		return "detail";
	}
	
	/**
	 * �����������У��
	 * @return
	 * @throws Exception
	 */
	public void validateInsert(){
		 ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		 formcoop0006 = formService.getFormData("coop0006");
		 getFormValue(formcoop0006);
		 validateFormData(formcoop0006);
   	}
   
	/**
	 * �޸ı������У��
	 * @return
	 * @throws Exception
	 */
	public void validateUpdate(){
		 ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		 formcoop0006 = formService.getFormData("coop0006");
		 getFormValue(formcoop0006);
		 validateFormData(formcoop0006);
  	}
	
	/**
	    * ���ݺ�����������ʾ���еĵ�������Ϣ
	    * @return
	    * @throws Exception
	    */
	   public String listQuotaForCorp() throws Exception {
	   	ActionContext.initialize(ServletActionContext.getRequest(),
	       		ServletActionContext.getResponse());
	   	corpCert = new CorpCert();
	   	corpCert.setBrNo(brNo);
	   	Ipage ipage = this.getIpage();
	   	corpCertList = (List) corpCertBo.findByPageQuotaForCorp(ipage, corpCert).getResult();
	   	return "list";
	   }
	   public String listQuotaForCorp_Read() throws Exception {
		   	ActionContext.initialize(ServletActionContext.getRequest(),
		       		ServletActionContext.getResponse());
		   	corpCert = new CorpCert();
		   	corpCert.setBrNo(brNo);
		   	Ipage ipage = this.getIpage();
		   	corpCertList = (List) corpCertBo.findByPageQuotaForCorp(ipage, corpCert).getResult();
		   	return "list_Read";
		   }

   public CorpBaseBo getCorpBaseBo() {
		return corpBaseBo;
	}
	public void setCorpBaseBo(CorpBaseBo corpBaseBo) {
		this.corpBaseBo = corpBaseBo;
	}
    public CorpBase getCorpBase() {
	   return corpBase;
	}
	public void setCorpBase(CorpBase corpBase) {
		this.corpBase = corpBase;
	}   
   
	public String getBrNo() {
		return brNo;
	}
	public void setBrNo(String brNo) {
		this.brNo = brNo;
	}	
	public CorpCert getCorpCert() {
		return corpCert;
	}
	public void setCorpCert(CorpCert  corpCert) {
		this.corpCert = corpCert;
	}
	public List<CorpCert> getCorpCertList() {
		return corpCertList;
	}
	public void setCorpCertList(List<CorpCert> corpCertList) {
		this.corpCertList = corpCertList;
	}
	public CorpCertBo getCorpCertBo() {
		return corpCertBo;
	}
	public void setCorpCertBo(CorpCertBo corpCertBo) {
		this.corpCertBo = corpCertBo;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public FormData getFormcoop0006() {
		return formcoop0006;
	}
	public void setFormcoop0006(FormData formcoop0006) {
		this.formcoop0006 = formcoop0006;
	}
	public FormData getFormcoop0005() {
		return formcoop0005;
	}
	public void setFormcoop0005(FormData formcoop0005) {
		this.formcoop0005 = formcoop0005;
	}
	public void setCertId(String certId){
		this.certId = certId;
	}		
	public String getCertId(){
		return certId;
	}
}