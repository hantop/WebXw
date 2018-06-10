package  app.creditapp.sys.action;
import java.util.List;
import app.util.User;
import org.apache.struts2.ServletActionContext;
import app.util.toolkit.Ipage;
import app.creditapp.sys.bo.SysUserRoleBo;
import app.creditapp.sys.entity.SysUserRole;
import com.core.domain.screen.FormData;
import com.core.service.screen.FormService;
import com.core.struts.ActionContext;
import com.core.struts.BaseFormBean;

/**
 * Title: SysUserRelAction.java
 * Description:
 **/
public class SysUserRoleAction extends BaseFormBean {

	//ҳ�洫ֵ
	private SysUserRole sysUserRole;
	private List<SysUserRole> sysUserRoleList;

	//ע��SysUserRoleBo
	private SysUserRoleBo sysUserRoleBo;

	private String query;
	private String rec_id;	
	private String user_no;
	private String role_no;
	private FormData formsys0072;
	private FormData formsys0073;
	private FormData formsys0100;
	private FormData formsys0106;
	private FormService formService = new FormService();
	
	public SysUserRoleAction() {
		query = "";
	}
	/**
	 * ��ҳ��ѯ
	 * @return
	 * @throws Exception
	 */
	public String findByPage() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),ServletActionContext.getResponse());
		formsys0072 = formService.getFormData("sys0072");
		sysUserRole = new SysUserRole();
		getFormValue(formsys0072);
		setObjValue(formsys0072, sysUserRole);
		sysUserRole.setUser_no(user_no);
		Ipage ipage = this.getIpage();
		sysUserRoleList = (List) sysUserRoleBo.findByPage(ipage, sysUserRole).getResult();
		return "list";
	}
	
	
	/**
	 * ��ȡ����ҳ��
	 * @return
	 * @throws Exception
	 */
	public String input() throws Exception {
		System.out.println(User.getBrno(this.getHttpRequest()));
		System.out.println(User.getBsno(this.getHttpRequest()));
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formsys0073 = formService.getFormData("sys0073");
		formsys0106 = formService.getFormData("sys0106");
		sysUserRole = new SysUserRole();
		if(!"".equals(user_no)&&null != user_no){
			sysUserRole.setUser_no(user_no);
			getObjValue(formsys0073, sysUserRole);
			return "input";
		}
		getObjValue(formsys0106, sysUserRole);
		return "inputWh";
	}
	
	/**
	 * �����������
	 * @return
	 * @throws Exception
	 */
	public String insert() throws Exception {
		System.out.println(user_no);
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formsys0072 = formService.getFormData("sys0072");
		formsys0073 = formService.getFormData("sys0073");
		//formsys0100 = formService.getFormData("sys0100");
		getFormValue(formsys0073);
		sysUserRole = new SysUserRole();
		setObjValue(formsys0073, sysUserRole);
		String s =role_no;
		String[] array = s.split("@");
		for(int i=1;i<array.length;i++){
			SysUserRole sur = new SysUserRole();
			sur.setRole_no(array[i]);
			sur.setUser_no(user_no);
			sysUserRoleBo.insert(sur);
		}
		this.addActionMessage("�����ɹ�");
		SysUserRole sysUserRoleTemp = new SysUserRole();
		sysUserRoleTemp.setUser_no(sysUserRole.getUser_no());
		Ipage ipage = this.getIpage();
		sysUserRoleList = (List) sysUserRoleBo.findByPage(ipage, sysUserRoleTemp).getResult();
		getObjValue(formsys0072, sysUserRoleTemp);
		return "list";
//		getObjValue(formsys0100, sysUserRel);
//		return "detail";
	}
	/**
	 * �����������
	 * @return
	 * @throws Exception
	 */
	public String insertWh() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formsys0072 = formService.getFormData("sys0072");
		formsys0106 = formService.getFormData("sys0106");
		getFormValue(formsys0106);
		sysUserRole = new SysUserRole();
		setObjValue(formsys0106, sysUserRole);
		sysUserRoleBo.insert(sysUserRole);
		this.addActionMessage("�����ɹ�");
		Ipage ipage = this.getIpage();
		sysUserRoleList = (List) sysUserRoleBo.findByPage(ipage, sysUserRole).getResult();
		getObjValue(formsys0072, sysUserRole);
		return "list";
	}
	
	
	/**
	 * �޸ı������
	 * @return
	 * @throws Exception
	 */
	public String update() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formsys0100 = formService.getFormData("sys0100");
		getFormValue(formsys0100);
		sysUserRole = new SysUserRole();
		setObjValue(formsys0100, sysUserRole);
		sysUserRoleBo.update(sysUserRole);
		this.addActionMessage("�����ɹ�");
		sysUserRole = sysUserRoleBo.getById(sysUserRole);
		getObjValue(formsys0100, sysUserRole);
		return "detail";
	}
	
	
	
	/**
	 * ɾ������
	 * @return
	 * @throws Exception
	 */
	public String del() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formsys0072 = formService.getFormData("sys0072");
		sysUserRole = new SysUserRole();
		sysUserRole.setRec_id(rec_id);
		sysUserRoleBo.del(sysUserRole);
		this.addActionMessage("ɾ���ɹ�");
		Ipage ipage = this.getIpage();
		sysUserRole = new SysUserRole();
	    sysUserRole.setUser_no(user_no);
		sysUserRoleList = (List) sysUserRoleBo.findByPage(ipage, sysUserRole).getResult();
		return "list";
	}

	
	/**
	 * ��ѯ����
	 * @return
	 * @throws Exception
	 */
	public String getById() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),ServletActionContext.getResponse());
		formsys0100 = formService.getFormData("sys0100");
		sysUserRole = new SysUserRole();
		sysUserRole.setRec_id(rec_id);
		sysUserRole.setUser_no(user_no);
		sysUserRole = sysUserRoleBo.getById(sysUserRole);
		getObjValue(formsys0100, sysUserRole);
		return "detail";
	}
	
	/**
	 * �����������У��
	 * @return
	 * @throws Exception
	 */
	public void validateInsertWh(){
		 ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		 formsys0106 = formService.getFormData("sys0106");
		 getFormValue(formsys0106);
		 sysUserRole = new SysUserRole();
		 setObjValue(formsys0106, sysUserRole);
		 sysUserRole = sysUserRoleBo.getByRoleAndBrno(sysUserRole);
		 if(sysUserRole!=null){
				this.addActionError("�û��û�����ɫ�Ѿ�����!");
		 }
		 validateFormData(formsys0106);
   	}
	/**
	 * �����������У��
	 * @return
	 * @throws Exception
	 */
	public void validateInsert(){
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formsys0073 = formService.getFormData("sys0073");
		getFormValue(formsys0073);
		validateFormData(formsys0073);
	}
   
	/**
	 * �޸ı������У��
	 * @return
	 * @throws Exception
	 */
	public void validateUpdate(){
		 ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		 formsys0073 = formService.getFormData("sys0073");
		 getFormValue(formsys0073);
		 validateFormData(formsys0073);
		 formsys0100 = formService.getFormData("sys0100");
		 getFormValue(formsys0100);
		 validateFormData(formsys0100);
  	}
	public SysUserRole getSysUserRel() {
		return sysUserRole;
	}
	public void setSysUserRel(SysUserRole  sysUserRel) {
		this.sysUserRole = sysUserRel;
	}
	public List<SysUserRole> getSysUserRelList() {
		return sysUserRoleList;
	}
	public void setSysUserRelList(List<SysUserRole> sysUserRelList) {
		this.sysUserRoleList = sysUserRelList;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public FormData getFormsys0073() {
		return formsys0073;
	}
	public void setFormsys0073(FormData formsys0073) {
		this.formsys0073 = formsys0073;
	}
	public FormData getFormsys0072() {
		return formsys0072;
	}
	public void setFormsys0072(FormData formsys0072) {
		this.formsys0072 = formsys0072;
	}
	public FormData getFormsys0100() {
		return formsys0100;
	}
	public void setFormsys0100(FormData formsys0100) {
		this.formsys0100 = formsys0100;
	}
	public FormData getFormsys0106() {
		return formsys0106;
	}
	public void setFormsys0106(FormData formsys0106) {
		this.formsys0106 = formsys0106;
	}
	public SysUserRole getSysUserRole() {
		return sysUserRole;
	}
	public void setSysUserRole(SysUserRole sysUserRole) {
		this.sysUserRole = sysUserRole;
	}
	public List<SysUserRole> getSysUserRoleList() {
		return sysUserRoleList;
	}
	public void setSysUserRoleList(List<SysUserRole> sysUserRoleList) {
		this.sysUserRoleList = sysUserRoleList;
	}
	public SysUserRoleBo getSysUserRoleBo() {
		return sysUserRoleBo;
	}
	public void setSysUserRoleBo(SysUserRoleBo sysUserRoleBo) {
		this.sysUserRoleBo = sysUserRoleBo;
	}
	public String getUser_no() {
		return user_no;
	}
	public void setUser_no(String userNo) {
		user_no = userNo;
	}
	public String getRec_id() {
		return rec_id;
	}
	public void setRec_id(String recId) {
		rec_id = recId;
	}
	public String getRole_no() {
		return role_no;
	}
	public void setRole_no(String roleNo) {
		role_no = roleNo;
	}
	
}