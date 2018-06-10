package  app.creditapp.inf.action;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import app.creditapp.inf.bo.WsElyRepyBo;
import app.creditapp.inf.entity.WsElyRepy;
import app.creditapp.inf.entity.WsIn2806;
import app.creditapp.inf.entity.WsOut2806;
import app.util.User;
import app.util.toolkit.Ipage;

import com.core.domain.screen.FormData;
import com.core.service.screen.FormService;
import com.core.struts.ActionContext;
import com.core.struts.BaseFormBean;

/**
 * Title: WsElyRepyAction.java
 * Description:
 * @author:su1573
 * 
 **/
public class WsElyRepyAction extends BaseFormBean {

	//ҳ�洫ֵ
	private WsElyRepy wsElyRepy;
	private List<WsElyRepy> wsElyRepyList;

	//ע��WsElyRepyBo
	private WsElyRepyBo wsElyRepyBo;
	private Date payDate;
	private Double payAmt;
	private String payType;
	private Double totalAmt;
	private Double curInte;

	private String query;
	private String wsId;
	private String batchNo;
	private FormData forminf0060;
	private FormData forminf0058;
	private FormData forminf0059;
	private FormService formService = new FormService();
	
	public WsElyRepyAction() {
		query = "";
	}
	/**
	 * ��ҳ��ѯ
	 * @return
	 * @throws Exception
	 */
	public String findByPage() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),ServletActionContext.getResponse());
		forminf0058 = formService.getFormData("inf0058");
		wsElyRepy = new WsElyRepy();
		
		getFormValue(forminf0058);
		setObjValue(forminf0058, wsElyRepy);
		//wsElyRepy.setBrNo(User.getBrno(this.getHttpRequest()));
		wsElyRepy.setBatchNo(batchNo);
		wsElyRepy.setLoginid(User.getLoginIdByAuth(this.getHttpRequest())); // ��session�л�ȡȨ��
		Ipage ipage = this.getIpage();
		wsElyRepyList = (List) wsElyRepyBo.findByPage(ipage, wsElyRepy).getResult();
		
		return "list";
	}
	
	
	/**
	 * ��ȡ����ҳ��
	 * @return
	 * @throws Exception
	 */
	public String input() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		forminf0059 = formService.getFormData("inf0059");
		return "input";
	}
	
	/**
	 * �����������
	 * @return
	 * @throws Exception
	 */
	public String insert() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		forminf0059 = formService.getFormData("inf0059");
		getFormValue(forminf0059);
		wsElyRepy = new WsElyRepy();
		setObjValue(forminf0059, wsElyRepy);
//		wsElyRepy.setBrNo(User.getBrno(this.getHttpRequest()));
//		wsElyRepy.setTxDate(User.getSys_date(this.getHttpRequest()));
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		String date = formatter.format(payDate);
		try{
			System.out.println("�ϴ����ڣ�"+date);
			wsElyRepy.setTxDate(date);     //��������
			wsElyRepy.setDebitType(payType);  //��������
			wsElyRepy.setPayTotal(totalAmt); //�����ܶ�
			wsElyRepy.setPayInte(curInte);  //������Ϣ
			wsElyRepyBo.insert(wsElyRepy);
			this.addActionMessage("�����ɹ�");
		}catch(Exception e){
			this.addActionMessage(e.getMessage());
			
			return "input";
		}
		getObjValue(forminf0059, wsElyRepy);
		
		return "success";
	}
	
	/**
	 * �������У��
	 * @return
	 * @throws Exception
	 */
	public String calcu() throws Exception{
		 ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		 forminf0059 = formService.getFormData("inf0059");
		 getFormValue(forminf0059);
		 WsIn2806 wsIn2806 = new WsIn2806();
		 WsOut2806 wsOut2806;
		 setObjValue(forminf0059, wsIn2806);
		 try{
			 wsOut2806 = wsElyRepyBo.calcu(wsIn2806);
				this.addActionMessage("����ɹ�");
			}catch(Exception e){
				
				this.addActionMessage(e.getMessage());
				return "input";
			}
			getObjValue(forminf0059, wsOut2806);
			
			return "success";
		 
  	}
	
	
	public void validateAndInsert() throws Exception{
		 ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		 forminf0059 = formService.getFormData("inf0059");
		 getFormValue(forminf0059);
		
		 
//		 validateFormData(forminf0059);
   	}
	
	/**
	 * �޸ı������
	 * @return
	 * @throws Exception
	 */
	public String update() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		forminf0059 = formService.getFormData("inf0059");
		getFormValue(forminf0059);
		wsElyRepy = new WsElyRepy();
		setObjValue(forminf0059, wsElyRepy);
		wsElyRepyBo.update(wsElyRepy);
		getObjValue(forminf0059, wsElyRepy);
		this.addActionMessage("�޸ĳɹ�");
		return "detail";
	}
	
	
	
	/**
	 * ɾ������
	 * @return
	 * @throws Exception
	 */
	public String del() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		forminf0058 = formService.getFormData("inf0058");
		wsElyRepy = new WsElyRepy();
		wsElyRepy.setWsId(wsId);
		wsElyRepyBo.del(wsElyRepy);
		this.addActionMessage("ɾ���ɹ�");
		wsElyRepy = new WsElyRepy();
		wsElyRepy.setBrNo(User.getBrno(this.getHttpRequest()));
		Ipage ipage = this.getIpage();
		wsElyRepyList = (List) wsElyRepyBo.findByPage(ipage, wsElyRepy).getResult();
		return "list";
	}

	
	/**
	 * ��ѯ����
	 * @return
	 * @throws Exception
	 */
	public String getById() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),ServletActionContext.getResponse());
		forminf0059 = formService.getFormData("inf0059");
		wsElyRepy = new WsElyRepy();
		wsElyRepy.setWsId(wsId);
		wsElyRepy = wsElyRepyBo.getById(wsElyRepy);
		getObjValue(forminf0059, wsElyRepy);
		return "detail";
	}
	
	
   
	/**
	 * �޸ı������У��
	 * @return
	 * @throws Exception
	 */
	public void validateUpdate(){
		 ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		 forminf0059 = formService.getFormData("inf0059");
		 getFormValue(forminf0059);
		 validateFormData(forminf0059);
  	}
	public WsElyRepy getWsElyRepy() {
		return wsElyRepy;
	}
	public void setWsElyRepy(WsElyRepy  wsElyRepy) {
		this.wsElyRepy = wsElyRepy;
	}
	public List<WsElyRepy> getWsElyRepyList() {
		return wsElyRepyList;
	}
	public void setWsElyRepyList(List<WsElyRepy> wsElyRepyList) {
		this.wsElyRepyList = wsElyRepyList;
	}
	public WsElyRepyBo getWsElyRepyBo() {
		return wsElyRepyBo;
	}
	public void setWsElyRepyBo(WsElyRepyBo wsElyRepyBo) {
		this.wsElyRepyBo = wsElyRepyBo;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public FormData getForminf0059() {
		return forminf0059;
	}
	public void setForminf0059(FormData forminf0059) {
		this.forminf0059 = forminf0059;
	}
	public FormData getForminf0058() {
		return forminf0058;
	}
	public void setForminf0058(FormData forminf0058) {
		this.forminf0058 = forminf0058;
	}
	public FormData getForminf0060() {
		return forminf0060;
	}
	public void setForminf0060(FormData forminf0060) {
		this.forminf0060 = forminf0060;
	}
	public void setWsId(String wsId){
		this.wsId = wsId;
	}		
	public String getWsId(){
		return wsId;
	}
	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}
	public String getBatchNo() {
		return batchNo;
	}
	public Date getPayDate() {
		return payDate;
	}
	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}
	public Double getPayAmt() {
		return payAmt;
	}
	public void setPayAmt(Double payAmt) {
		this.payAmt = payAmt;
	}
	public String getPayType() {
		return payType;
	}
	public void setPayType(String payType) {
		this.payType = payType;
	}
	public Double getTotalAmt() {
		return totalAmt;
	}
	public void setTotalAmt(Double totalAmt) {
		this.totalAmt = totalAmt;
	}
	public Double getCurInte() {
		return curInte;
	}
	public void setCurInte(Double curInte) {
		this.curInte = curInte;
	}
}