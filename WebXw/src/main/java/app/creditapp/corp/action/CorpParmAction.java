package  app.creditapp.corp.action;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import app.creditapp.corp.bo.CorpBaseBo;
import app.creditapp.corp.bo.CorpParmBo;
import app.creditapp.corp.entity.CorpBase;
import app.creditapp.corp.entity.CorpParm;
import app.oscache.CachecodeUtil;
import app.oscache.MBaseCache;
import app.util.User;
import app.util.toolkit.Ipage;

import com.core.domain.screen.FormData;
import com.core.service.screen.FormService;
import com.core.struts.ActionContext;
import com.core.struts.BaseFormBean;

/**
 * Title: CorpParmAction.java
 * Description:
 **/
public class CorpParmAction extends BaseFormBean {

	//ҳ�洫ֵ
	private CorpParm corpParm;
	private CorpBase corpBase;
	
	private List<CorpParm> corpParmList;

	//ע��CorpParmBo
	private CorpParmBo corpParmBo;
	private CorpBaseBo corpBaseBo;

	private String query;
	private String parmId;		
	private String brNo;
	
	private FormData formcoop0003;
	private FormData formcoop0004;
	private FormService formService = new FormService();
	
	public CorpParmAction() {
		query = "";
	}
	/**
	 * ��ҳ��ѯ
	 * @return
	 * @throws Exception
	 */
	public String findByPage() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),ServletActionContext.getResponse());
		formcoop0003 = formService.getFormData("coop0003");
		corpParm = new CorpParm();
		getFormValue(formcoop0003);
		setObjValue(formcoop0003, corpParm);
		corpParm.setBrNo(User.getBrno(ServletActionContext.getRequest()));
		Ipage ipage = this.getIpage();
		corpParmList = (List) corpParmBo.findByPage(ipage, corpParm).getResult();
		return "list";
	}
	
	
	/**
	 * ��ȡ����ҳ��
	 * @return
	 * @throws Exception
	 */
	public String input() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formcoop0004 = formService.getFormData("coop0004");
		
		corpParm = new CorpParm();
		corpBase = new CorpBase();
		 
		corpBase.setBrNo(brNo);
		corpBase = corpBaseBo.getById(corpBase);
		corpParm.setDeptNo(User.getBrno(ServletActionContext.getRequest()));//�Ǽǲ���
		corpParm.setOpNo(User.getLoginid(ServletActionContext.getRequest()));//����Ա
		corpParm.setTxDate(User.getSys_date(ServletActionContext.getRequest()));//�Ǽ�����
		corpParm.setUpDate(User.getSys_date(ServletActionContext.getRequest()));//�޸�����
		corpParm.setUpOpno(User.getLoginid(ServletActionContext.getRequest()));//�޸���Ա
		getObjValue(formcoop0004, corpParm);
		
		return "input";
	}
	
	/**
	 * �����������
	 * @return
	 * @throws Exception
	 */
	public String insert() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formcoop0004 = formService.getFormData("coop0004");
		getFormValue(formcoop0004);
		corpParm = new CorpParm();
		setObjValue(formcoop0004, corpParm);
		corpParm.setDeptNo(User.getBrno(ServletActionContext.getRequest()));//�Ǽǲ���
		corpParm.setOpNo(User.getLoginid(ServletActionContext.getRequest()));//����Ա
		corpParm.setTxDate(User.getSys_date(ServletActionContext.getRequest()));//�Ǽ�����
		//corpParm.setUpDate(User.getSys_date(ServletActionContext.getRequest()));//�޸�����
		//corpParm.setUpOpno(User.getLoginid(ServletActionContext.getRequest()));//�޸���Ա
		corpParmBo.insert(corpParm);
		getObjValue(formcoop0004, corpParm);
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
		formcoop0004 = formService.getFormData("coop0004");
		getFormValue(formcoop0004);
		corpParm = new CorpParm();
		setObjValue(formcoop0004, corpParm);
		
		
		corpParm.setBrNo(brNo);
		corpParm = corpParmBo.getById(corpParm);
		
		corpBase = new CorpBase();
		 
		corpBase.setBrNo(brNo);
		corpBase = corpBaseBo.getById(corpBase);
		
		
		if(corpParm==null){
			corpParm = new CorpParm();
			setObjValue(formcoop0004, corpParm);
			corpParm.setBrNo(brNo);
			corpParm.setBrName(corpBase.getBrName());
			corpParm.setDeptNo(User.getBrno(ServletActionContext.getRequest()));//�Ǽǲ���
			corpParm.setOpNo(User.getLoginid(ServletActionContext.getRequest()));//����Ա
			corpParm.setTxDate(User.getSys_date(ServletActionContext.getRequest()));//�Ǽ�����
			corpParmBo.insert(corpParm);
		}else{
			//corpParm = new CorpParm();
			setObjValue(formcoop0004, corpParm);
			corpParm.setUpDate(User.getSys_date(ServletActionContext.getRequest()));//�޸�����
			corpParm.setUpOpno(User.getLoginid(ServletActionContext.getRequest()));//�޸���Ա
			corpParmBo.update(corpParm);
			//�ú��������ŵ�������Ϣ���и��µ�ʱ���жϸú��������߱�����Ϣ�Ƿ��������������жϴ˺����������ܷ��������
			int count = corpBaseBo.getAllInf(brNo);
			//����4 ������� ��ʾ���е���Ϣ�Ѿ���д����������������� �Ϳ��Խ�������
			if(count == 4){
				CorpBase corpBase = new CorpBase();
				corpBase.setBrNo(brNo);
				corpBase = corpBaseBo.getById(corpBase);
				//���ú���������״̬Ϊ ���� ״̬�����и������ ����������
				corpBase.setBrSts("01");
				corpBaseBo.update(corpBase);
			}
		}
		//�������
		try {
			MBaseCache.getCache().removeByKey(CachecodeUtil.CORP_PARM_STR);
		} catch (Exception e) {
			e.printStackTrace();
		}
		getObjValue(formcoop0004, corpParm);
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
		formcoop0003 = formService.getFormData("coop0003");
		corpParm = new CorpParm();
		corpParm.setParmId(parmId);
		corpParmBo.del(corpParm);
		this.addActionMessage("ɾ���ɹ�");
		corpParm = new CorpParm();
		corpParm.setBrNo(User.getBrno(ServletActionContext.getRequest()));
		Ipage ipage = this.getIpage();
		corpParmList = (List) corpParmBo.findByPage(ipage, corpParm).getResult();
		return "list";
	}

	
	/**
	 * ��ѯ����
	 * @return
	 * @throws Exception
	 */
	public String getById() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),ServletActionContext.getResponse());
		formcoop0004 = formService.getFormData("coop0004");
		corpParm = new CorpParm();
		corpBase = new CorpBase();
		
		//corpParm.setParmId(parmId);
		corpParm.setBrNo(brNo);
		corpBase.setBrNo(brNo);
		corpBase = corpBaseBo.getById(corpBase);
		corpParm = corpParmBo.getById(corpParm);
		if(corpParm==null){
			corpParm = new CorpParm();
			corpParm.setPutType("01");//�ſ�ģʽ
			corpParm.setMonthDays("01");//����������
			corpParm.setGraceDay(0);//���ڿ�����
			corpParm.setTolAmt(0.00);//�����ݴ���
			corpParm.setRpyDay("01");//�ۿ�������
			corpParm.setPayOrder("01");//�ۿ�˳��
			corpParm.setAccType("01");//���㷽ʽ
			corpParm.setIfRelchk("0");//�����Ƿ����Ԥ����У��
			
		}
		corpParm.setBrNo(brNo);
		corpParm.setBrName(corpBase.getBrName());
		
		corpParm.setDeptNo(User.getBrno(ServletActionContext.getRequest()));//�Ǽǲ���
		corpParm.setOpNo(User.getLoginid(ServletActionContext.getRequest()));//����Ա
		corpParm.setTxDate(User.getSys_date(ServletActionContext.getRequest()));//�Ǽ�����
		corpParm.setUpDate(User.getSys_date(ServletActionContext.getRequest()));//�޸�����
		corpParm.setUpOpno(User.getLoginid(ServletActionContext.getRequest()));//�޸���Ա
		
		
		
		getObjValue(formcoop0004, corpParm);
		return "detail";
		
	}
	
	/**
	 * �����������У��
	 * @return
	 * @throws Exception
	 */
	public void validateInsert(){
		 ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		 formcoop0004 = formService.getFormData("coop0004");
		 getFormValue(formcoop0004);
		 validateFormData(formcoop0004);
   	}
   
	/**
	 * �޸ı������У��
	 * @return
	 * @throws Exception
	 */
	public void validateUpdate(){
		 ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		 formcoop0004 = formService.getFormData("coop0004");
		 getFormValue(formcoop0004);
		 validateFormData(formcoop0004);
  	}
	
	/**
	    * ���ݺ�����������ʾ���еĵ����� ��Ϣ
	    * @return
	    * @throws Exception
	    */
	   public String listQuotaForCorp() throws Exception {
	   	ActionContext.initialize(ServletActionContext.getRequest(),
	       		ServletActionContext.getResponse());
	   	corpParm = new CorpParm();
	   	corpParm.setBrNo(brNo);
	   	Ipage ipage = this.getIpage();
	   	corpParmList = (List) corpParmBo.findByPageQuotaForCorp(ipage, corpParm).getResult();
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
	public CorpParm getCorpParm() {
		return corpParm;
	}
	public void setCorpParm(CorpParm  corpParm) {
		this.corpParm = corpParm;
	}
	public List<CorpParm> getCorpParmList() {
		return corpParmList;
	}
	public void setCorpParmList(List<CorpParm> corpParmList) {
		this.corpParmList = corpParmList;
	}
	public CorpParmBo getCorpParmBo() {
		return corpParmBo;
	}
	public void setCorpParmBo(CorpParmBo corpParmBo) {
		this.corpParmBo = corpParmBo;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public FormData getFormcoop0004() {
		return formcoop0004;
	}
	public void setFormcoop0004(FormData formcoop0004) {
		this.formcoop0004 = formcoop0004;
	}
	public FormData getFormcoop0003() {
		return formcoop0003;
	}
	public void setFormcoop0003(FormData formcoop0003) {
		this.formcoop0003 = formcoop0003;
	}
	public void setParmId(String parmId){
		this.parmId = parmId;
	}		
	public String getParmId(){
		return parmId;
	}
}