package  app.creditapp.sys.action;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.core.domain.screen.FormData;
import com.core.service.screen.FormService;
import com.core.struts.ActionContext;
import com.core.struts.BaseFormBean;

import app.creditapp.sys.bo.SysPathBo;
import app.creditapp.sys.entity.SysPath;
import app.util.toolkit.Ipage;

/**
 * Title: SysPathAction.java
 * Description:
 **/
public class SysPathAction extends BaseFormBean {

	//ҳ�洫ֵ
	private SysPath sysPath;
	private List<SysPath> sysPathList;

	//ע��SysPathBo
	private SysPathBo sysPathBo;

	private String query;
	private String pathId;		
	private FormData formsys0028;
	private FormData formsys0029;
	private FormService formService = new FormService();
	
	public SysPathAction() {
		query = "";
	}
	/**
	 * ��ҳ��ѯ
	 * @return
	 * @throws Exception
	 */
	public String findByPage() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),ServletActionContext.getResponse());
		formsys0028 = formService.getFormData("sys0028");
		sysPath = new SysPath();
		getFormValue(formsys0028);
		setObjValue(formsys0028, sysPath);
//		sysPath.setBrNo(User.getBrno(this.getHttpRequest()));
		Ipage ipage = this.getIpage();
		sysPathList = (List) sysPathBo.findByPage(ipage, sysPath).getResult();
		return "list";
	}
	
	
	/**
	 * ��ȡ����ҳ��
	 * @return
	 * @throws Exception
	 */
	public String input() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formsys0029 = formService.getFormData("sys0029");
		return "input";
	}
	
	/**
	 * �����������
	 * @return
	 * @throws Exception
	 */
	public String insert() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formsys0029 = formService.getFormData("sys0029");
		getFormValue(formsys0029);
		sysPath = new SysPath();
		setObjValue(formsys0029, sysPath);
//		sysPath.setOpNo(User.getTlrno(this.getHttpRequest()));
//		sysPath.setTxDate(User.getSys_date(this.getHttpRequest()));
		sysPathBo.insert(sysPath);
		this.addActionMessage("����ɹ�");
		getObjValue(formsys0029, sysPath);
		return "detail";
	}
	
	
	/**
	 * �޸ı������
	 * @return
	 * @throws Exception
	 */
	public String update() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formsys0029 = formService.getFormData("sys0029");
		getFormValue(formsys0029);
		sysPath = new SysPath();
		setObjValue(formsys0029, sysPath);
//		sysPath.setUpTime(User.getSys_date(this.getHttpRequest()));
		sysPathBo.update(sysPath);
		this.addActionMessage("�޸ĳɹ�");
		getObjValue(formsys0029, sysPath);
		return "detail";
	}
	
	
	
	/**
	 * ɾ������
	 * @return
	 * @throws Exception
	 */
	public String del() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formsys0028 = formService.getFormData("sys0028");
		sysPath = new SysPath();
		sysPath.setPathId(pathId);
		sysPathBo.del(sysPath);
		this.addActionMessage("ɾ���ɹ�");
		sysPath = new SysPath();
//		sysPath.setBrNo(User.getBrno(this.getHttpRequest()));
		Ipage ipage = this.getIpage();
		sysPathList = (List) sysPathBo.findByPage(ipage, sysPath).getResult();
		return "list";
	}

	
	/**
	 * ��ѯ����
	 * @return
	 * @throws Exception
	 */
	public String getById() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),ServletActionContext.getResponse());
		formsys0029 = formService.getFormData("sys0029");
		sysPath = new SysPath();
		sysPath.setPathId(pathId);
		sysPath = sysPathBo.getById(sysPath);
		getObjValue(formsys0029, sysPath);
		return "detail";
	}
	
	/**
	 * �����������У��
	 * @return
	 * @throws Exception
	 */
	public void validateInsert(){
		 ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		 formsys0029 = formService.getFormData("sys0029");
		 getFormValue(formsys0029);
		 validateFormData(formsys0029);
   	}
   
	/**
	 * �޸ı������У��
	 * @return
	 * @throws Exception
	 */
	public void validateUpdate(){
		 ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		 formsys0029 = formService.getFormData("sys0029");
		 getFormValue(formsys0029);
		 validateFormData(formsys0029);
  	}
	public SysPath getSysPath() {
		return sysPath;
	}
	public void setSysPath(SysPath  sysPath) {
		this.sysPath = sysPath;
	}
	public List<SysPath> getSysPathList() {
		return sysPathList;
	}
	public void setSysPathList(List<SysPath> sysPathList) {
		this.sysPathList = sysPathList;
	}
	public SysPathBo getSysPathBo() {
		return sysPathBo;
	}
	public void setSysPathBo(SysPathBo sysPathBo) {
		this.sysPathBo = sysPathBo;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public FormData getFormsys0029() {
		return formsys0029;
	}
	public void setFormsys0029(FormData formsys0029) {
		this.formsys0029 = formsys0029;
	}
	public FormData getFormsys0028() {
		return formsys0028;
	}
	public void setFormsys0028(FormData formsys0028) {
		this.formsys0028 = formsys0028;
	}
	public void setPathId(String pathId){
		this.pathId = pathId;
	}		
	public String getPathId(){
		return pathId;
	}
}