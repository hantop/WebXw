package  app.creditapp.inf.action;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import app.util.User;
import org.apache.struts2.ServletActionContext;
import app.util.toolkit.Ipage;
import app.creditapp.inf.bo.WsRepyMesBo;
import app.creditapp.inf.entity.WsRepyMes;
import app.creditapp.inf.entity.WsRepyMes_Count;

import com.core.domain.screen.FormData;
import com.core.service.screen.FormService;
import com.core.struts.ActionContext;
import com.core.struts.BaseFormBean;

/**
 * Title: WsRepyMesAction.java
 * Description:
 **/
public class WsRepyMesAction extends BaseFormBean {

	//ҳ�洫ֵ
	private WsRepyMes wsRepyMes;
	private List<WsRepyMes> wsRepyMesList;
	//�ۿ�ͳ�� ����
	private WsRepyMes_Count wc;
	private List<WsRepyMes_Count> wcList;
	private FormData forminf0009;
	
	//ע��WsRepyMesBo
	private WsRepyMesBo wsRepyMesBo;

	private String query;
	private String wsId;
	private String batchNo;
	private FormData forminf0001;
	private FormData forminf0002;
	private FormService formService = new FormService();
	
	public WsRepyMesAction() {
		query = "";
	}
	/**
	 * ��ҳ��ѯ
	 * @return
	 * @throws Exception
	 */
	public String findByPage() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),ServletActionContext.getResponse());
		forminf0001 = formService.getFormData("inf0001");
		wsRepyMes = new WsRepyMes();
		getFormValue(forminf0001);
		setObjValue(forminf0001, wsRepyMes);
//		wsRepyMes.setBrNo(User.getBrno(this.getHttpRequest()));
		wsRepyMes.setBatchNo(batchNo);
		Ipage ipage = this.getIpage();
		wsRepyMesList = (List) wsRepyMesBo.findByPage(ipage, wsRepyMes).getResult();
		return "list";
	}
	
	
	/**
	 * ��ȡ����ҳ��
	 * @return
	 * @throws Exception
	 */
	public String input() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		forminf0002 = formService.getFormData("inf0002");
		return "input";
	}
	
	/**
	 * �����������
	 * @return
	 * @throws Exception
	 */
	public String insert() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		forminf0002 = formService.getFormData("inf0002");
		getFormValue(forminf0002);
		wsRepyMes = new WsRepyMes();
		setObjValue(forminf0002, wsRepyMes);
		wsRepyMes.setBrNo(User.getBrno(this.getHttpRequest()));
		wsRepyMesBo.insert(wsRepyMes);
		getObjValue(forminf0002, wsRepyMes);
		return "detail";
	}
	
	
	/**
	 * �޸ı������
	 * @return
	 * @throws Exception
	 */
	public String update() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		forminf0002 = formService.getFormData("inf0002");
		getFormValue(forminf0002);
		wsRepyMes = new WsRepyMes();
		setObjValue(forminf0002, wsRepyMes);
		wsRepyMesBo.update(wsRepyMes);
		getObjValue(forminf0002, wsRepyMes);
		return "detail";
	}
	
	
	
	/**
	 * ɾ������
	 * @return
	 * @throws Exception
	 */
	public String del() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		forminf0001 = formService.getFormData("inf0001");
		wsRepyMes = new WsRepyMes();
		wsRepyMes.setWsId(wsId);
		wsRepyMesBo.del(wsRepyMes);
		this.addActionMessage("ɾ���ɹ�");
		wsRepyMes = new WsRepyMes();
		wsRepyMes.setBrNo(User.getBrno(this.getHttpRequest()));
		Ipage ipage = this.getIpage();
		wsRepyMesList = (List) wsRepyMesBo.findByPage(ipage, wsRepyMes).getResult();
		return "list";
	}

	
	/**
	 * ��ѯ����
	 * @return
	 * @throws Exception
	 */
	public String getById() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),ServletActionContext.getResponse());
		forminf0002 = formService.getFormData("inf0002");
		wsRepyMes = new WsRepyMes();
		wsRepyMes.setWsId(wsId);
		wsRepyMes = wsRepyMesBo.getById(wsRepyMes);
		getObjValue(forminf0002, wsRepyMes);
		return "detail";
	}
	
	/**
	 * �����������У��
	 * @return
	 * @throws Exception
	 */
	public void validateInsert(){
		 ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		 forminf0002 = formService.getFormData("inf0002");
		 getFormValue(forminf0002);
		 validateFormData(forminf0002);
   	}
   
	/**
	 * �޸ı������У��
	 * @return
	 * @throws Exception
	 */
	public void validateUpdate(){
		 ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		 forminf0002 = formService.getFormData("inf0002");
		 getFormValue(forminf0002);
		 validateFormData(forminf0002);
  	}
	
	/**
	 * ͳ�ƿۿ���Ϣ
	 * @return
	 * @throws Exception
	 */
	public String getCountMes() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),ServletActionContext.getResponse());
		forminf0009 = formService.getFormData("inf0009");
		getFormValue(forminf0009);
		wc = new WsRepyMes_Count();
		setObjValue(forminf0009, wc);
		String txTime = wc.getTxTime();
		String endTime = wc.getEndTime();
		if("".equals(txTime)||txTime == null){
			txTime = new SimpleDateFormat("yyyy-MM-dd 00:00:00").format(new Date());
			endTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
			this.changeFormProperty(forminf0009, "txTime", "initValue", txTime);
			this.changeFormProperty(forminf0009, "endTime", "initValue", endTime);
			return "list";
		}
		txTime = txTime.replace("-", "");
		endTime = endTime.replace("-", "");
		wc.setTxTime(txTime);
		Ipage ipage = this.getIpage();
		wcList = (List) wsRepyMesBo.getCountMes(ipage, wc).getResult();
		return "list";
	}
	
	public WsRepyMes getWsRepyMes() {
		return wsRepyMes;
	}
	public void setWsRepyMes(WsRepyMes  wsRepyMes) {
		this.wsRepyMes = wsRepyMes;
	}
	public List<WsRepyMes> getWsRepyMesList() {
		return wsRepyMesList;
	}
	public void setWsRepyMesList(List<WsRepyMes> wsRepyMesList) {
		this.wsRepyMesList = wsRepyMesList;
	}
	public WsRepyMesBo getWsRepyMesBo() {
		return wsRepyMesBo;
	}
	public void setWsRepyMesBo(WsRepyMesBo wsRepyMesBo) {
		this.wsRepyMesBo = wsRepyMesBo;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public FormData getForminf0002() {
		return forminf0002;
	}
	public void setForminf0002(FormData forminf0002) {
		this.forminf0002 = forminf0002;
	}
	public FormData getForminf0001() {
		return forminf0001;
	}
	public void setForminf0001(FormData forminf0001) {
		this.forminf0001 = forminf0001;
	}
	public void setWsId(String wsId){
		this.wsId = wsId;
	}		
	public String getWsId(){
		return wsId;
	}
	public String getBatchNo() {
		return batchNo;
	}
	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}
	public WsRepyMes_Count getWc() {
		return wc;
	}
	public void setWc(WsRepyMes_Count wc) {
		this.wc = wc;
	}
	public List<WsRepyMes_Count> getWcList() {
		return wcList;
	}
	public void setWcList(List<WsRepyMes_Count> wcList) {
		this.wcList = wcList;
	}
	public FormData getForminf0009() {
		return forminf0009;
	}
	public void setForminf0009(FormData forminf0009) {
		this.forminf0009 = forminf0009;
	}
}