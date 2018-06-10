package  app.creditapp.proj.action;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSON;
import com.core.domain.screen.FormData;
import com.core.service.screen.FormService;
import com.core.struts.ActionContext;
import com.core.struts.BaseFormBean;

import app.creditapp.proj.bo.ProjBaseBo;
import app.creditapp.proj.bo.ProjMangBo;
import app.creditapp.proj.entity.ProjBase;
import app.creditapp.proj.entity.ProjMang;
import app.util.User;
import app.util.toolkit.Ipage;

/**
 * Title: ProjMangAction.java
 * Description:
 **/
public class ProjMangAction extends BaseFormBean {

	//ҳ�洫ֵ
	private ProjMang projMang;
	private ProjBase projBase;
	
	private List<ProjBase> managerList;
	private List<ProjMang> projMangList;

	//ע��ProjMangBo
	private ProjMangBo projMangBo;
	private ProjBaseBo projBaseBo;

	private String query;
	private String relId;	
	private String projNo;
	private String loginId;
	private FormData formproj0003;
	private FormData formproj0004;
	private FormService formService = new FormService();
	
	public ProjMangAction() {
		query = "";
	}
	/**
	 * ��ҳ��ѯ
	 * @return
	 * @throws Exception
	 */
	public String findByPage() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),ServletActionContext.getResponse());
		formproj0003 = formService.getFormData("proj0003");
		projMang = new ProjMang();
		getFormValue(formproj0003);
		setObjValue(formproj0003, projMang);
		Ipage ipage = this.getIpage();
		projMangList = (List) projMangBo.findByPage(ipage, projMang).getResult();
		String s = JSON.toJSONString(projMangList);
		return "list";
	}
	//ͬ��
	public String findByPageForManager() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),ServletActionContext.getResponse());
		projMangList = (List)projMangBo.findByPageForManager(projMang);
		return "list";
	}
	
	/**
	 * ��ȡ����ҳ��
	 * @return
	 * @throws Exception
	 */
	public String input() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		projMang = new ProjMang();
		projMang.setTiMe(User.getSys_date(this.getHttpRequest()));
		formproj0004 = formService.getFormData("proj0004");
		getObjValue(formproj0004, projMang);
		return "input"; 
	}
	
	/**
	 * ����������� 
	 * @return
	 * @throws Exception
	 */
	public String insert() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formproj0004 = formService.getFormData("proj0004");
		getFormValue(formproj0004);
		projMang = new ProjMang();
		projMang.setProjNo(projNo);
		projMang.setLoginId(loginId);
		projMang = projMangBo.getById(projMang);
		if(projMang==null){
			projMang = new ProjMang();
			setObjValue(formproj0004, projMang);
			projMang.setPerSOn(User.getLoginid(getHttpRequest()));
			projMangBo.insert(projMang);
			this.addActionMessage("�����ɹ�");
			getObjValue(formproj0004, projMang);
			
		}else{
			this.addActionMessage("���û��Ѿ���������Ŀ�����д���Ŀ�Ĺ���Ȩ��");
		}
		return "detail";
	}
	
	
	/**
	 * �޸ı������
	 * @return
	 * @throws Exception
	 */
	public String update() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formproj0004 = formService.getFormData("proj0004");
		getFormValue(formproj0004);
		projMang = new ProjMang();
		setObjValue(formproj0004, projMang);
		projMang.setProjNo(projNo);
		projMang.setLoginId(loginId);
		projMang = projMangBo.getById(projMang);
		
		if(projMang!=null){
			projMang = new ProjMang();
			setObjValue(formproj0004, projMang);
//			projMangBo.update(projMang);
//			getObjValue(formproj0004, projMang);
			this.addActionMessage("���û��Ѿ���������Ŀ�����д���Ŀ�Ĺ���Ȩ��");
		}
		else{
			projMang = new ProjMang();
			setObjValue(formproj0004, projMang);
			projMang.setPerSOn(User.getLoginid(getHttpRequest()));
			projMangBo.insert(projMang);
			this.addActionMessage("�����ɹ�");
		}
		getObjValue(formproj0004, projMang);
		
		return "detail";
	}
	
	
	/**
	 * ɾ������
	 * @return
	 * @throws Exception
	 */
	public String del() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formproj0003 = formService.getFormData("proj0003");
		projMang = new ProjMang();
		projMang.setRelId(relId);
		projMangBo.del(projMang);
		this.addActionMessage("ɾ���ɹ�");
		projMang = new ProjMang();
		Ipage ipage = this.getIpage();
		projMangList = (List) projMangBo.findByPage(ipage, projMang).getResult();
		return "list";
	}

	
	/**
	 * ��ѯ����
	 * @return
	 * @throws Exception
	 */
	public String getById() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),ServletActionContext.getResponse());
		formproj0004 = formService.getFormData("proj0004");
		projMang = new ProjMang();
//		projBase = new ProjBase();
//		projBase.setProjNo(projNo);
//		System.out.println(projNo);
		projMang.setProjNo(projNo);
		projMang.setLoginId(loginId);
//		projMang.setRelId(relId);
		projMang = projMangBo.getById(projMang);
		
//		if(projMang==null){
//			projMang = new ProjMang();
//		}
//		projMang.setProjNo(projNo);
		
		getObjValue(formproj0004, projMang);
		return "detail";
		
	}
	
	/**
	 * �����������У��
	 * @return
	 * @throws Exception
	 */
	public void validateInsert(){
		 ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		 formproj0004 = formService.getFormData("proj0004");
		 getFormValue(formproj0004);
		 validateFormData(formproj0004);
   	}
   
	/**
	 * �޸ı������У��
	 * @return
	 * @throws Exception
	 */
	public void validateUpdate(){
		 ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		 formproj0004 = formService.getFormData("proj0004");
		 getFormValue(formproj0004);
		 validateFormData(formproj0004);
  	}
	public ProjMang getProjMang() {
		return projMang;
	}
	public void setProjMang(ProjMang  projMang) {
		this.projMang = projMang;
	}
	public List<ProjMang> getProjMangList() {
		return projMangList;
	}
	public void setProjMangList(List<ProjMang> projMangList) {
		this.projMangList = projMangList;
	}
	public ProjMangBo getProjMangBo() {
		return projMangBo;
	}
	public void setProjMangBo(ProjMangBo projMangBo) {
		this.projMangBo = projMangBo;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public FormData getFormproj0004() {
		return formproj0004;
	}
	public void setFormproj0004(FormData formproj0004) {
		this.formproj0004 = formproj0004;
	}
	public FormData getFormproj0003() {
		return formproj0003;
	}
	public void setFormproj0003(FormData formproj0003) {
		this.formproj0003 = formproj0003;
	}
	public void setRelId(String relId){
		this.relId = relId;
	}		
	public String getRelId(){
		return relId;
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
	public String getProjNo() {
		return projNo;
	}
	public void setProjNo(String projNo) {
		this.projNo = projNo;
	}
	public List<ProjBase> getManagerList() {
		return managerList;
	}
	public void setManagerList(List<ProjBase> managerList) {
		this.managerList = managerList;
	}
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
}