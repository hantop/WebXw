package app.creditapp.sys.action;

/**
 * ϵͳ����Ա��¼�ǳ���־��ѯ
 * @mailto: shaoxinlong@dhcc.com.cn
 */
import java.util.List;

import org.apache.struts2.ServletActionContext;

import app.creditapp.sys.bo.SysLoginLogBo;
import app.creditapp.sys.entity.SysLoginLog;
import app.util.toolkit.Ipage;

import com.core.domain.screen.FormData;
import com.core.service.screen.FormService;
import com.core.struts.ActionContext;
import com.core.struts.BaseFormBean;

public class SysLoginLogAction extends BaseFormBean {

	// ҳ�洫ֵ
	private SysLoginLog sysloginlog;
	private List<SysLoginLog> sysloginlogList;

	// ע��SysLoginLogBO
	private SysLoginLogBo sysLoginLogBo;

	private String query = "";
	private FormData formsys2007; // ��ѯ��
	private FormService formService = new FormService();

	public SysLoginLogAction() {
		formsys2007=formService.getFormData("sys2007");
		query="";
	}

	/**
	 * ��ҳ��ѯ
	 * 
	 * @return
	 * @throws Exception
	 */
	public String findByPage() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		sysloginlog=new SysLoginLog();
		getFormValue(formsys2007);
		setObjValue(formsys2007, sysloginlog);
		Ipage ipage = this.getIpage();
		sysloginlogList=(List)sysLoginLogBo.findByPage(ipage, sysloginlog).getResult();

		return "list";
	}

	/* ��־��¼����Ҫ����ɾ���ģ����¹��ܲ�ʹ�ã����� */
	// public String input() throws Exception{
	// if(sysloginlog!=null &&
	// StringUtils.isNotBlank(sysloginlog.getSession_id())){
	// sysloginlog = sysloginlogbo.getById(sysloginlog.getSession_id());
	// }
	// return "input";
	// }
	// public String insertOrUpdate() throws Exception{
	// sysloginlogbo.insertOrUpdate(sysloginlog);
	// this.setMessage("�����ɹ�");
	// return "input_result";
	// }
	// public String del() throws Exception{
	// sysloginlogbo.del(sysloginlog.getSession_id());
	// this.setMessage("�����ɹ�");
	// return "del_result";
	// }
	public String getById() throws Exception {
		sysloginlog = sysLoginLogBo.getById(sysloginlog.getSessionId());
		this.setMessage("�����ɹ�");
		return "input_result";
	}

	public SysLoginLog getSysloginlog() {
		return sysloginlog;
	}

	public void setSysloginlog(SysLoginLog sysloginlog) {
		this.sysloginlog = sysloginlog;
	}

	public List<SysLoginLog> getSysloginlogList() {
		return sysloginlogList;
	}

	public void setSysloginloglist(List<SysLoginLog> sysloginlogList) {
		this.sysloginlogList = sysloginlogList;
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	
	public void setSysloginlogList(List<SysLoginLog> sysloginlogList) {
		this.sysloginlogList = sysloginlogList;
	}

	public FormData getFormsys2007() {
		return formsys2007;
	}

	public void setFormsys2007(FormData formsys2007) {
		this.formsys2007 = formsys2007;
	}

	public SysLoginLogBo getSysLoginLogBo() {
		return sysLoginLogBo;
	}

	public void setSysLoginLogBo(SysLoginLogBo sysLoginLogBo) {
		this.sysLoginLogBo = sysLoginLogBo;
	}

	public FormService getFormService() {
		return formService;
	}

	public void setFormService(FormService formService) {
		this.formService = formService;
	}

}
