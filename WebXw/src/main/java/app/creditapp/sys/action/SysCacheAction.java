package  app.creditapp.sys.action;
import java.util.List;
import app.util.User;
import org.apache.struts2.ServletActionContext;
import app.util.toolkit.Ipage;
import app.creditapp.sys.bo.SysCacheBo;
import app.creditapp.sys.entity.SysCache;
import com.core.domain.screen.FormData;
import com.core.service.screen.FormService;
import com.core.struts.ActionContext;
import com.core.struts.BaseFormBean;

/**
 * Title: SysCacheAction.java
 * Description:
 **/
public class SysCacheAction extends BaseFormBean {

	//ҳ�洫ֵ
	private SysCache sysCache;
	private List<SysCache> sysCacheList;

	//ע��SysCacheBo
	private SysCacheBo sysCacheBo;

	private String query;
	private String cache_no;		
	private FormData formsys0096;
	private FormData formsys0097;
	private FormService formService = new FormService();
	
	public SysCacheAction() {
		query = "";
	}
	/**
	 * ��ҳ��ѯ
	 * @return
	 * @throws Exception
	 */
	public String findByPage() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),ServletActionContext.getResponse());
		formsys0096 = formService.getFormData("sys0096");
		sysCache = new SysCache();
		getFormValue(formsys0096);
		setObjValue(formsys0096, sysCache);
		Ipage ipage = this.getIpage();
		sysCacheList = (List) sysCacheBo.findByPage(ipage, sysCache).getResult();
		return "list";
	}
	
	
	/**
	 * ��ȡ����ҳ��
	 * @return
	 * @throws Exception
	 */
	public String input() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formsys0097 = formService.getFormData("sys0097");
		return "input";
	}
	
	/**
	 * �����������
	 * @return
	 * @throws Exception
	 */
	public String insert() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formsys0097 = formService.getFormData("sys0097");
		getFormValue(formsys0097);
		sysCache = new SysCache();
		setObjValue(formsys0097, sysCache);
		sysCacheBo.insert(sysCache);
		getObjValue(formsys0097, sysCache);
		return "detail";
	}
	
	
	/**
	 * �޸ı������
	 * @return
	 * @throws Exception
	 */
	public String update() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formsys0097 = formService.getFormData("sys0097");
		getFormValue(formsys0097);
		sysCache = new SysCache();
		setObjValue(formsys0097, sysCache);
		sysCacheBo.update(sysCache);
		getObjValue(formsys0097, sysCache);
		return "detail";
	}
	
	
	
	/**
	 * ɾ������
	 * @return
	 * @throws Exception
	 */
	public String del() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formsys0096 = formService.getFormData("sys0096");
		sysCache = new SysCache();
		sysCache.setCache_no(cache_no);
		sysCacheBo.del(sysCache);
		this.addActionMessage("ɾ���ɹ�");
		sysCache = new SysCache();
		Ipage ipage = this.getIpage();
		sysCacheList = (List) sysCacheBo.findByPage(ipage, sysCache).getResult();
		return "list";
	}

	
	/**
	 * ��ѯ����
	 * @return
	 * @throws Exception
	 */
	public String getById() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),ServletActionContext.getResponse());
		formsys0097 = formService.getFormData("sys0097");
		sysCache = new SysCache();
		sysCache.setCache_no(cache_no);
		sysCache = sysCacheBo.getById(sysCache);
		getObjValue(formsys0097, sysCache);
		return "detail";
	}
	
	/**
	 * �����������У��
	 * @return
	 * @throws Exception
	 */
	public void validateInsert(){
		 ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		 formsys0097 = formService.getFormData("sys0097");
		 getFormValue(formsys0097);
		 validateFormData(formsys0097);
   	}
   
	/**
	 * �޸ı������У��
	 * @return
	 * @throws Exception
	 */
	public void validateUpdate(){
		 ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		 formsys0097 = formService.getFormData("sys0097");
		 getFormValue(formsys0097);
		 validateFormData(formsys0097);
  	}
	public SysCache getSysCache() {
		return sysCache;
	}
	public void setSysCache(SysCache  sysCache) {
		this.sysCache = sysCache;
	}
	public List<SysCache> getSysCacheList() {
		return sysCacheList;
	}
	public void setSysCacheList(List<SysCache> sysCacheList) {
		this.sysCacheList = sysCacheList;
	}
	public SysCacheBo getSysCacheBo() {
		return sysCacheBo;
	}
	public void setSysCacheBo(SysCacheBo sysCacheBo) {
		this.sysCacheBo = sysCacheBo;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public FormData getFormsys0097() {
		return formsys0097;
	}
	public void setFormsys0097(FormData formsys0097) {
		this.formsys0097 = formsys0097;
	}
	public FormData getFormsys0096() {
		return formsys0096;
	}
	public void setFormsys0096(FormData formsys0096) {
		this.formsys0096 = formsys0096;
	}
	public void setCache_no(String cache_no){
		this.cache_no = cache_no;
	}		
	public String getCache_no(){
		return cache_no;
	}
}