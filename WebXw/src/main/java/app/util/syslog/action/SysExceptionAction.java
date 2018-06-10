package  app.util.syslog.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import app.util.syslog.bo.SysExceptionBo;
import app.util.syslog.entity.SysException;
import app.util.toolkit.Ipage;

import com.core.domain.screen.FormData;
import com.core.service.screen.FormService;
import com.core.struts.ActionContext;
import com.core.struts.BaseFormBean;

/**
 * Title: SysExceptionAction.java
 * Description:
 **/
public class SysExceptionAction extends BaseFormBean {

	//ҳ�洫ֵ
	private SysException sysException;
	private List<SysException> sysExceptionList;

	//ע��SysExceptionBo
	private SysExceptionBo sysExceptionBo;

	private String query;
	private String expId;		
	private FormData formsys0020;
	private FormData formsys0021;
	private FormService formService = new FormService();
	
	public SysExceptionAction() {
		query = "";
	}
	/**
	 * ��ҳ��ѯ
	 * @return
	 * @throws Exception
	 */
	public String findByPage() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),ServletActionContext.getResponse());
		formsys0020 = formService.getFormData("sys0020");
		sysException = new SysException();
		getFormValue(formsys0020);
		setObjValue(formsys0020, sysException);
		Ipage ipage = this.getIpage();
		sysExceptionList = (List) sysExceptionBo.findByPage(ipage, sysException).getResult();
		System.out.println("��ѯ������");
		return "list";
	}
	
	
	/**
	 * ��ȡ����ҳ��
	 * @return
	 * @throws Exception
	 */
	public String input() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formsys0021 = formService.getFormData("sys0021");
		return "input";
	}
	
	/**
	 * �����������
	 * @return
	 * @throws Exception
	 */
	public String insert() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formsys0021 = formService.getFormData("sys0021");
		getFormValue(formsys0021);
		sysException = new SysException();
		setObjValue(formsys0021, sysException);
		sysExceptionBo.insert(sysException);
		getObjValue(formsys0021, sysException);
		return "detail";
	}
	
	
	/**
	 * �޸ı������
	 * @return
	 * @throws Exception
	 */
	public String update() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formsys0021 = formService.getFormData("sys0021");
		getFormValue(formsys0021);
		sysException = new SysException();
		setObjValue(formsys0021, sysException);
		sysExceptionBo.update(sysException);
		getObjValue(formsys0021, sysException);
		return "detail";
	}
	
	
	
	/**
	 * ɾ������
	 * @return
	 * @throws Exception
	 */
	public String del() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formsys0020 = formService.getFormData("sys0020");
		sysException = new SysException();
		sysException.setExpId(expId);
		sysExceptionBo.del(sysException);
		this.addActionMessage("ɾ���ɹ�");
		sysException = new SysException();
		Ipage ipage = this.getIpage();
		sysExceptionList = (List) sysExceptionBo.findByPage(ipage, sysException).getResult();
		return "list";
	}

	
	/**
	 * ��ѯ����
	 * @return
	 * @throws Exception
	 */
	public String getById() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),ServletActionContext.getResponse());
		formsys0021 = formService.getFormData("sys0021");
		sysException = new SysException();
		sysException.setExpId(expId);
		System.out.println(expId);
		sysException = sysExceptionBo.getById(sysException);
		getObjValue(formsys0021, sysException);
		return "detail";
	}
	
	/**
	 * �����������У��
	 * @return
	 * @throws Exception
	 */
	public void validateInsert(){
		 ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		 formsys0020 = formService.getFormData("sys0020");
		 getFormValue(formsys0020);
		 validateFormData(formsys0020);
   	}
   	
	/**
	 * �޸ı������У��
	 * @return
	 * @throws Exception
	 */
	public void validateUpdate(){
		 ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		 formsys0021 = formService.getFormData("sys0021");
		 getFormValue(formsys0021);
		 validateFormData(formsys0021);
  	}
	public SysException getSysException() {
		return sysException;
	}
	public void setSysException(SysException  sysException) {
		this.sysException = sysException;
	}
	public List<SysException> getSysExceptionList() {
		return sysExceptionList;
	}
	public void setSysExceptionList(List<SysException> sysExceptionList) {
		this.sysExceptionList = sysExceptionList;
	}
	public SysExceptionBo getSysExceptionBo() {
		return sysExceptionBo;
	}
	public void setSysExceptionBo(SysExceptionBo sysExceptionBo) {
		this.sysExceptionBo = sysExceptionBo;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public FormData getFormsys0021() {
		return formsys0021;
	}
	public void setFormsys0021(FormData formsys0021) {
		this.formsys0021 = formsys0021;
	}
	public FormData getFormsys0020() {
		return formsys0020;
	}
	public void setFormsys0020(FormData formsys0020) {
		this.formsys0020 = formsys0020;
	}
	public void setExpId(String expId){
		this.expId = expId;
	}		
	public String getExpId(){
		return expId;
	}
}