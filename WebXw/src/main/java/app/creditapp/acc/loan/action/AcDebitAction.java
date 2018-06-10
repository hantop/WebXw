package  app.creditapp.acc.loan.action;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.struts2.ServletActionContext;

import accounting.biz.pub.ParmBiz;
import app.base.ServiceException;
import app.creditapp.acc.loan.bo.AcDebitBo;
import app.creditapp.acc.loan.entity.AcDebit;
import app.util.User;
import app.util.toolkit.Ipage;

import com.core.domain.screen.FormData;
import com.core.service.screen.FormService;
import com.core.struts.ActionContext;
import com.core.struts.BaseFormBean;

/**
 * Title: AcDebitAction.java
 * Description:
 **/
public class AcDebitAction extends BaseFormBean {

	//ҳ�洫ֵ
	private AcDebit acDebit;
	private List<AcDebit> acDebitList;

	//ע��AcDebitBo
	private AcDebitBo acDebitBo;

	private DataSource dataSource;
	private String query;
	private String traceNo;		
	private FormData formdebit0001;
	private FormData formdebit0002;
	private FormService formService = new FormService();
	
	public AcDebitAction() {
		query = "";
	}
	/**
	 * ��ҳ��ѯ
	 * @return
	 * @throws Exception
	 */
	public String findByPage() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),ServletActionContext.getResponse());
		formdebit0001 = formService.getFormData("debit0001");
		Connection conn = this.getConnection();
		acDebit = new AcDebit();
		getFormValue(formdebit0001);
		setObjValue(formdebit0001, acDebit);
//		acDebit.setBrNo(User.getBrno(this.getHttpRequest()));
		acDebit.setLoginid(User.getLoginIdByAuth(this.getHttpRequest())); // ��session�л�ȡȨ��
		acDebit.setTxDt(ParmBiz.getBizDt(conn));
		Ipage ipage = this.getIpage();
		acDebitList = (List) acDebitBo.findByPage(ipage, acDebit).getResult();
		return "list";
	}
	
	
	/**
	 * ��ȡ����ҳ��
	 * @return
	 * @throws Exception
	 */
	public String input() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formdebit0002 = formService.getFormData("debit0002");
		return "input";
	}
	
	/**
	 * �����������
	 * @return
	 * @throws Exception
	 */
	public String insert() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formdebit0002 = formService.getFormData("debit0002");
		getFormValue(formdebit0002);
		acDebit = new AcDebit();
		setObjValue(formdebit0002, acDebit);
		acDebit.setBrNo(User.getBrno(this.getHttpRequest()));
		acDebitBo.insert(acDebit);
		getObjValue(formdebit0002, acDebit);
		return "detail";
	}
	
	
	/**
	 * �޸ı������
	 * @return
	 * @throws Exception
	 */
	public String update() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formdebit0002 = formService.getFormData("debit0002");
		getFormValue(formdebit0002);
		acDebit = new AcDebit();
		setObjValue(formdebit0002, acDebit);
		acDebitBo.update(acDebit);
		getObjValue(formdebit0002, acDebit);
		return "detail";
	}
	
	
	
	/**
	 * ɾ������
	 * @return
	 * @throws Exception
	 */
	public String del() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formdebit0001 = formService.getFormData("debit0001");
		acDebit = new AcDebit();
		acDebit.setTraceNo(traceNo);
		acDebitBo.del(acDebit);
		this.addActionMessage("ɾ���ɹ�");
		acDebit = new AcDebit();
		acDebit.setBrNo(User.getBrno(this.getHttpRequest()));
		Ipage ipage = this.getIpage();
		acDebitList = (List) acDebitBo.findByPage(ipage, acDebit).getResult();
		return "list";
	}

	
	/**
	 * ��ѯ����
	 * @return
	 * @throws Exception
	 */
	public String getById() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),ServletActionContext.getResponse());
		formdebit0002 = formService.getFormData("debit0002");
		acDebit = new AcDebit();
		acDebit.setTraceNo(traceNo);
		acDebit = acDebitBo.getById(acDebit);
		getObjValue(formdebit0002, acDebit);
		return "detail";
	}
	
	/**
	 * �����������У��
	 * @return
	 * @throws Exception
	 */
	public void validateInsert(){
		 ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		 formdebit0002 = formService.getFormData("debit0002");
		 getFormValue(formdebit0002);
		 validateFormData(formdebit0002);
   	}
   
	/**
	 * �޸ı������У��
	 * @return
	 * @throws Exception
	 */
	public void validateUpdate(){
		 ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		 formdebit0002 = formService.getFormData("debit0002");
		 getFormValue(formdebit0002);
		 validateFormData(formdebit0002);
  	}
	
	private Connection getConnection() {

		Connection conn = null;
		try {
			conn = dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ServiceException(e);
		}
		return conn;
	}
	public AcDebit getAcDebit() {
		return acDebit;
	}
	public void setAcDebit(AcDebit  acDebit) {
		this.acDebit = acDebit;
	}
	public List<AcDebit> getAcDebitList() {
		return acDebitList;
	}
	public void setAcDebitList(List<AcDebit> acDebitList) {
		this.acDebitList = acDebitList;
	}
	public AcDebitBo getAcDebitBo() {
		return acDebitBo;
	}
	public void setAcDebitBo(AcDebitBo acDebitBo) {
		this.acDebitBo = acDebitBo;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public FormData getFormdebit0002() {
		return formdebit0002;
	}
	public void setFormdebit0002(FormData formdebit0002) {
		this.formdebit0002 = formdebit0002;
	}
	public FormData getFormdebit0001() {
		return formdebit0001;
	}
	public void setFormdebit0001(FormData formdebit0001) {
		this.formdebit0001 = formdebit0001;
	}
	public void setTraceNo(String traceNo){
		this.traceNo = traceNo;
	}		
	public String getTraceNo(){
		return traceNo;
	}
	public DataSource getDataSource() {
		return dataSource;
	}
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
}