package  app.creditapp.proj.action;
import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.core.domain.screen.FormData;
import com.core.service.screen.FormService;
import com.core.struts.ActionContext;
import com.core.struts.BaseFormBean;

import app.creditapp.proj.bo.ProjBaseBo;
import app.creditapp.proj.bo.ProjParmBo;
import app.creditapp.proj.entity.ProjBase;
import app.creditapp.proj.entity.ProjParm;
import app.util.User;
import app.util.toolkit.Ipage;

/**
 * Title: ProjParmAction.java
 * Description:
 **/
public class ProjParmAction extends BaseFormBean {

	//ҳ�洫ֵ
	private ProjParm projParm;
	private ProjBase projBase;
	
	private List<ProjParm> projParmList;

	//ע��ProjParmBo
	private ProjParmBo projParmBo;
	private ProjBaseBo projBaseBo;

	private String query;
	private Float leverRate;		
	private String txDate;		
	private String upOpno;		
	private String deptNo;		
	private String truPayType;		
	private String upDate;		
	private Float rgAppRate;			
	private String projName;		
	private String opNo;		
	private String filler;			
	private String projNo;	
	private String projId;
	private Integer backDays;		
	private FormData formproj0005;
	private FormData formproj0006;
	private FormService formService = new FormService();
	
	public ProjParmAction() {
		query = "";
	}
	/**
	 * ��ҳ��ѯ
	 * @return
	 * @throws Exception
	 */
	public String findByPage() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),ServletActionContext.getResponse());
		formproj0005 = formService.getFormData("proj0005");
		projParm = new ProjParm();
		getFormValue(formproj0005);
		setObjValue(formproj0005, projParm);
		Ipage ipage = this.getIpage();
		projParmList = (List) projParmBo.findByPage(ipage, projParm).getResult();
		return "list";
	}
	
	
	/**
	 * ��ȡ����ҳ��
	 * @return
	 * @throws Exception
	 */
	public String input() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formproj0006 = formService.getFormData("proj0006");
		return "input";
	}
	
	/**
	 * �����������
	 * @return
	 * @throws Exception
	 */
	public String insert() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formproj0006 = formService.getFormData("proj0006");
		getFormValue(formproj0006);
		projParm = new ProjParm();
		setObjValue(formproj0006, projParm);
		
		projParm.setDeptNo(User.getBrno(ServletActionContext.getRequest()));//�Ǽǲ���
		projParm.setOpNo(User.getLoginid(ServletActionContext.getRequest()));//����Ա
		projParm.setTxDate(User.getSys_date(ServletActionContext.getRequest()));//�Ǽ�����
		//projParm.setUpDate(User.getSys_date(ServletActionContext.getRequest()));//�޸�����
		//projParm.setUpOpno(User.getLoginid(ServletActionContext.getRequest()));//�޸���Ա
		projParmBo.insert(projParm);
		getObjValue(formproj0006, projParm);
		return "detail";
	}
	
	
	/**
	 * �޸ı������
	 * @return
	 * @throws Exception
	 */
	public String update() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formproj0006 = formService.getFormData("proj0006");
		getFormValue(formproj0006);
		projParm = new ProjParm();
		setObjValue(formproj0006, projParm);
		
		projParm.setProjNo(projNo);
		projParm = projParmBo.getById(projParm);
		
		projBase = new ProjBase();
		projBase.setProjNo(projNo);
		projBase = projBaseBo.getById(projBase);
		
		if(projParm==null){
			projParm = new ProjParm();
			setObjValue(formproj0006, projParm);
			projParm.setProjNo(projNo);
//			projParm.setBackDays(66);
			
			
			projParm.setProjName(projBase.getProjName());
			projParm.setDeptNo(User.getBrno(ServletActionContext.getRequest()));//�Ǽǲ���
			projParm.setOpNo(User.getLoginid(ServletActionContext.getRequest()));//����Ա
			projParm.setTxDate(User.getSys_date(ServletActionContext.getRequest()));//�Ǽ�����
			HttpServletRequest request = ServletActionContext.getRequest();
			BigDecimal MangFeerate = new BigDecimal(request.getParameter("mangFeerate"));
			BigDecimal parm = new BigDecimal(Integer.toString(1000));
			projParm.setMangFeerate(MangFeerate.divide(parm).floatValue());
			projParmBo.insert(projParm);
		}else{
			setObjValue(formproj0006, projParm);
			projParm.setLeverRate(leverRate);
			//�޸����й������
			HttpServletRequest request = ServletActionContext.getRequest();
			BigDecimal MangFeerate = new BigDecimal(request.getParameter("mangFeerate"));
			BigDecimal parm = new BigDecimal(Integer.toString(1000));
			projParm.setMangFeerate(MangFeerate.divide(parm).floatValue());
			projParm.setUpDate(User.getSys_date(ServletActionContext.getRequest()));//�޸�����
			projParm.setUpOpno(User.getLoginid(ServletActionContext.getRequest()));//�޸���Ա
			projParmBo.update(projParm);
		}
		getObjValue(formproj0006, projParm);
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
		formproj0005 = formService.getFormData("proj0005");
		projParm = new ProjParm();
		projParm.setLeverRate(leverRate);
		projParm.setTxDate(txDate);
		projParm.setUpOpno(upOpno);
		projParm.setDeptNo(deptNo);
		projParm.setTruPayType(truPayType);
		projParm.setUpDate(upDate);
		projParm.setRgAppRate(rgAppRate);
		projParm.setProjName(projName);
		projParm.setOpNo(opNo);
		projParm.setFiller(filler);
		projParm.setProjNo(projNo);
		projParm.setBackDays(backDays);
		projParmBo.del(projParm);
		this.addActionMessage("ɾ���ɹ�");
		projParm = new ProjParm();
		Ipage ipage = this.getIpage();
		projParmList = (List) projParmBo.findByPage(ipage, projParm).getResult();
		return "list";
	}

	
	/**
	 * ��ѯ����
	 * @return
	 * @throws Exception
	 */
	public String getById() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),ServletActionContext.getResponse());
		if(projNo==null || "".equals(projNo)){
			this.addActionMessage("������  ��Ŀ��Ϣ �в�¼С΢��Ŀ��ţ�");
			return "   ";
		}else{
			formproj0006 = formService.getFormData("proj0006");
			projParm = new ProjParm();
			projParm.setLeverRate(leverRate);
			projParm.setTxDate(txDate);
			projParm.setUpOpno(upOpno);
			projParm.setDeptNo(deptNo);
			projParm.setTruPayType(truPayType);
			projParm.setUpDate(upDate);
			projParm.setRgAppRate(rgAppRate);
			projParm.setProjName(projName);
			projParm.setOpNo(opNo);
			projParm.setFiller(filler);
			projParm.setProjNo(projNo);
			projParm.setBackDays(backDays);
			
			
			projBase = new ProjBase();
			projBase.setProjId(projId);
			projBase.setProjNo(projNo);
			projBase = projBaseBo.getById(projBase);
			projParm = projParmBo.getById(projParm);
			
			if(projParm==null){
				projParm = new ProjParm();
				projParm.setBackDays(66);//�ع�������Ĭ��ֵ
				projParm.setFundEndDays(22);//�ʽ��ڶҸ�����
				projParm.setProjEndDays(11);//��Ŀ��������
				projParm.setIntDays(10);  // ��Ϣ��������
				projParm.setOverDays(10);//��������
				projParm.setMangFeerate(0.005f);//���й������[Ĭ��Ϊǧ��֮��]
				projParm.setLeverRate(0.01f);
			}
			projParm.setProjNo(projNo);
			projParm.setProjName(projBase.getProjName());
			projParm.setDeptNo(User.getBrno(ServletActionContext.getRequest()));//�Ǽǲ���
			projParm.setOpNo(User.getLoginid(ServletActionContext.getRequest()));//����Ա
			projParm.setTxDate(User.getSys_date(ServletActionContext.getRequest()));//�Ǽ�����
			projParm.setUpDate(User.getSys_date(ServletActionContext.getRequest()));//�޸�����
			projParm.setUpOpno(User.getLoginid(ServletActionContext.getRequest()));//�޸���Ա
			getObjValue(formproj0006, projParm);
			return "detail";
		}
			
		
	}
	
	/**
	 * �����������У��
	 * @return
	 * @throws Exception
	 */
	public void validateInsert(){
		 ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		 formproj0006 = formService.getFormData("proj0006");
		 getFormValue(formproj0006);
		 validateFormData(formproj0006);
   	}
   
	/**
	 * �޸ı������У��
	 * @return
	 * @throws Exception
	 */
	public void validateUpdate(){
		 ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		 formproj0006 = formService.getFormData("proj0006");
		 getFormValue(formproj0006);
		 validateFormData(formproj0006);
  	}
	
	
	/**
	    * ������Ŀ��ʾ���еĵ����� ��Ϣ
	    * @return
	    * @throws Exception
	    */
	   public String listQuotaForCorp() throws Exception {
	   	ActionContext.initialize(ServletActionContext.getRequest(),
	       		ServletActionContext.getResponse());
	   	projParm = new ProjParm();
	   	projParm.setProjNo(projNo);
	   	Ipage ipage = this.getIpage();
	   	projParmList = (List) projParmBo.findByPageQuotaForCorp(ipage, projParm).getResult();
	   	return "list";
	   }
	
	public ProjParm getProjParm() {
		return projParm;
	}
	public void setProjParm(ProjParm  projParm) {
		this.projParm = projParm;
	}
	public List<ProjParm> getProjParmList() {
		return projParmList;
	}
	public void setProjParmList(List<ProjParm> projParmList) {
		this.projParmList = projParmList;
	}
	public ProjParmBo getProjParmBo() {
		return projParmBo;
	}
	public void setProjParmBo(ProjParmBo projParmBo) {
		this.projParmBo = projParmBo;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public FormData getFormproj0006() {
		return formproj0006;
	}
	public void setFormproj0006(FormData formproj0006) {
		this.formproj0006 = formproj0006;
	}
	public FormData getFormproj0005() {
		return formproj0005;
	}
	public void setFormproj0005(FormData formproj0005) {
		this.formproj0005 = formproj0005;
	}
	public void setLeverRate(Float leverRate){
		this.leverRate = leverRate;
	}		
	public void setTxDate(String txDate){
		this.txDate = txDate;
	}		
	public void setUpOpno(String upOpno){
		this.upOpno = upOpno;
	}		
	public void setDeptNo(String deptNo){
		this.deptNo = deptNo;
	}		
	public void setTruPayType(String truPayType){
		this.truPayType = truPayType;
	}		
	public void setUpDate(String upDate){
		this.upDate = upDate;
	}		
	public void setRgAppRate(Float rgAppRate){
		this.rgAppRate = rgAppRate;
	}			
	public void setProjName(String projName){
		this.projName = projName;
	}		
	public void setOpNo(String opNo){
		this.opNo = opNo;
	}		
	public void setFiller(String filler){
		this.filler = filler;
	}			
	public void setProjNo(String projNo){
		this.projNo = projNo;
	}		
	public void setBackDays(Integer backDays){
		this.backDays = backDays;
	}		
	public Float getLeverRate(){
		return leverRate;
	}
	public String getTxDate(){
		return txDate;
	}
	public String getUpOpno(){
		return upOpno;
	}
	public String getDeptNo(){
		return deptNo;
	}
	public String getTruPayType(){
		return truPayType;
	}
	public String getUpDate(){
		return upDate;
	}
	public Float getRgAppRate(){
		return rgAppRate;
	}
	public String getProjName(){
		return projName;
	}
	public String getOpNo(){
		return opNo;
	}
	public String getFiller(){
		return filler;
	}
	public String getProjNo(){
		return projNo;
	}
	public Integer getBackDays(){
		return backDays;
	}
	public ProjBase getProjBase() {
		return projBase;
	}
	public void setProjBase(ProjBase projBase) {
		this.projBase = projBase;
	}
	public ProjBaseBo getProjBaseBo() {
		return projBaseBo;
	}
	public void setProjBaseBo(ProjBaseBo projBaseBo) {
		this.projBaseBo = projBaseBo;
	}
	public String getProjId() {
		return projId;
	}
	public void setProjId(String projId) {
		this.projId = projId;
	}
	
}