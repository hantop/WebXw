package  app.creditapp.inf.action;
import java.util.List;
import app.util.User;
import org.apache.struts2.ServletActionContext;
import app.util.toolkit.Ipage;
import app.creditapp.inf.bo.WsRepyClearBo;
import app.creditapp.inf.entity.WsRepyClear;
import com.core.domain.screen.FormData;
import com.core.service.screen.FormService;
import com.core.struts.ActionContext;
import com.core.struts.BaseFormBean;

/**
 * Title: WsRepyClearAction.java
 * Description:
 **/
public class WsRepyClearAction extends BaseFormBean {

	//ҳ�洫ֵ
	private WsRepyClear wsRepyClear;
	private List<WsRepyClear> wsRepyClearList;

	//ע��WsRepyClearBo
	private WsRepyClearBo wsRepyClearBo;

	private String query;
	private String wsId;		
	private FormData forminf;
	private FormData forminf0621;
	private FormData forminf0625;
	private FormService formService = new FormService();
	
	public WsRepyClearAction() {
		query = "";
	}
	/**
	 * ��ҳ��ѯ
	 * @return
	 * @throws Exception
	 */
	public String findByPage() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),ServletActionContext.getResponse());
		forminf = formService.getFormData("inf0625");
		wsRepyClear = new WsRepyClear();
		getFormValue(forminf);
		setObjValue(forminf, wsRepyClear);
		wsRepyClear.setBrNo(User.getBrno(this.getHttpRequest()));
		Ipage ipage = this.getIpage();
		wsRepyClearList = (List) wsRepyClearBo.findByPage(ipage, wsRepyClear).getResult();
		return "list";
	}
	
	
	/**
	 * ��ȡ����ҳ��
	 * @return
	 * @throws Exception
	 */
	public String input() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		forminf0621 = formService.getFormData("inf0621");
		return "input";
	}
	
	/**
	 * �����������
	 * @return
	 * @throws Exception
	 */
	public String insert() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		forminf0621 = formService.getFormData("inf0621");
		getFormValue(forminf0621);
		wsRepyClear = new WsRepyClear();
		setObjValue(forminf0621, wsRepyClear);
		wsRepyClear.setBrNo(User.getBrno(this.getHttpRequest()));
		wsRepyClear.setTxDate(User.getSys_date(this.getHttpRequest()));
		wsRepyClearBo.insert(wsRepyClear);
		getObjValue(forminf0621, wsRepyClear);
		return "detail";
	}
	
	
	/**
	 * �޸ı������
	 * @return
	 * @throws Exception
	 */
	public String update() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		forminf0621 = formService.getFormData("inf0621");
		getFormValue(forminf0621);
		wsRepyClear = new WsRepyClear();
		setObjValue(forminf0621, wsRepyClear);
		wsRepyClearBo.update(wsRepyClear);
		getObjValue(forminf0621, wsRepyClear);
		return "detail";
	}
	
	
	
	/**
	 * ɾ������
	 * @return
	 * @throws Exception
	 */
	public String del() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		forminf = formService.getFormData("inf0623");
		wsRepyClear = new WsRepyClear();
		wsRepyClear.setWsId(wsId);
		wsRepyClearBo.del(wsRepyClear);
		this.addActionMessage("ɾ���ɹ�");
		wsRepyClear = new WsRepyClear();
		wsRepyClear.setBrNo(User.getBrno(this.getHttpRequest()));
		Ipage ipage = this.getIpage();
		wsRepyClearList = (List) wsRepyClearBo.findByPage(ipage, wsRepyClear).getResult();
		return "list";
	}

	
	/**
	 * ��ѯ����
	 * @return
	 * @throws Exception
	 */
	public String getById() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),ServletActionContext.getResponse());
		forminf0621 = formService.getFormData("inf0621");
		wsRepyClear = new WsRepyClear();
		wsRepyClear.setWsId(wsId);
		wsRepyClear = wsRepyClearBo.getById(wsRepyClear);
		getObjValue(forminf0621, wsRepyClear);
		return "detail";
	}
	
	/**
	 * �����������У��
	 * @return
	 * @throws Exception
	 */
	public void validateInsert(){
		 ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		 forminf0621 = formService.getFormData("inf0621");
		 getFormValue(forminf0621);
		 validateFormData(forminf0621);
   	}
   
	/**
	 * �޸ı������У��
	 * @return
	 * @throws Exception
	 */
	public void validateUpdate(){
		 ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		 forminf0621 = formService.getFormData("inf0621");
		 getFormValue(forminf0621);
		 validateFormData(forminf0621);
  	}
	public WsRepyClear getWsRepyClear() {
		return wsRepyClear;
	}
	public void setWsRepyClear(WsRepyClear  wsRepyClear) {
		this.wsRepyClear = wsRepyClear;
	}
	public List<WsRepyClear> getWsRepyClearList() {
		return wsRepyClearList;
	}
	public void setWsRepyClearList(List<WsRepyClear> wsRepyClearList) {
		this.wsRepyClearList = wsRepyClearList;
	}
	public WsRepyClearBo getWsRepyClearBo() {
		return wsRepyClearBo;
	}
	public void setWsRepyClearBo(WsRepyClearBo wsRepyClearBo) {
		this.wsRepyClearBo = wsRepyClearBo;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public FormData getForminf0621() {
		return forminf0621;
	}
	public void setForminf0621(FormData forminf0621) {
		this.forminf0621 = forminf0621;
	}
	public FormData getForminf() {
		return forminf;
	}
	public void setForminf(FormData forminf) {
		this.forminf = forminf;
	}
	public void setWsId(String wsId){
		this.wsId = wsId;
	}		
	public String getWsId(){
		return wsId;
	}
	public FormData getForminf0625() {
		return forminf0625;
	}
	public void setForminf0625(FormData forminf0625) {
		this.forminf0625 = forminf0625;
	}
}