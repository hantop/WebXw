package  app.creditapp.ln.action;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import oracle.jdbc.OracleTypes;

import org.apache.struts2.ServletActionContext;

import app.creditapp.ln.bo.LnBatchBo;
import app.creditapp.ln.entity.LnBatch;
import app.util.DBUtils;
import app.util.User;
import app.util.toolkit.Ipage;

import com.core.domain.screen.FormData;
import com.core.service.screen.FormService;
import com.core.struts.ActionContext;
import com.core.struts.BaseFormBean;

/**
 * Title: LnBatchAction.java
 * Description:
 **/
public class LnBatchAction extends BaseFormBean {

	//ҳ�洫ֵ
	private LnBatch lnBatch;
	private List<LnBatch> lnBatchList;

	//ע��LnBatchBo
	private LnBatchBo lnBatchBo;

	private String query;
	private String valChk;
	private String valApp;
	private String valLn;
	private String valSum;
	private String batchNo;		
	private FormData formlnbatch0001;
	private FormData formlnbatch0002;
	private FormService formService = new FormService();
	private List tabList;
	
	public LnBatchAction() {
		query = "";
	}
	/**
	 * ��ҳ��ѯ
	 * @return
	 * @throws Exception
	 */
	public String findByPage() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),ServletActionContext.getResponse());
		formlnbatch0001 = formService.getFormData("lnbatch0001");
		lnBatch = new LnBatch();
		getFormValue(formlnbatch0001);
		setObjValue(formlnbatch0001, lnBatch);
//		lnBatch.setBrNo(User.getBrno(this.getHttpRequest()));
		lnBatch.setLoginid(User.getLoginIdByAuth(this.getHttpRequest()));
		Ipage ipage = this.getIpage();
		lnBatchList = (List) lnBatchBo.findByPage(ipage, lnBatch).getResult();
		return "list";
	}
	
	
	/**
	 * ��ȡ����ҳ��
	 * @return
	 * @throws Exception
	 */
	public String input() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formlnbatch0002 = formService.getFormData("lnbatch0002");
		return "input";
	}
	
	/**
	 * �����������
	 * @return
	 * @throws Exception
	 */
	public String insert() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formlnbatch0002 = formService.getFormData("lnbatch0002");
		getFormValue(formlnbatch0002);
		lnBatch = new LnBatch();
		setObjValue(formlnbatch0002, lnBatch);
		lnBatch.setBrNo(User.getBrno(this.getHttpRequest()));
		lnBatchBo.insert(lnBatch);
		getObjValue(formlnbatch0002, lnBatch);
		return "detail";
	}
	
	
	/**
	 * �޸ı������
	 * @return
	 * @throws Exception
	 */
	public String update() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formlnbatch0002 = formService.getFormData("lnbatch0002");
		getFormValue(formlnbatch0002);
		lnBatch = new LnBatch();
		setObjValue(formlnbatch0002, lnBatch);
		lnBatchBo.update(lnBatch);
		getObjValue(formlnbatch0002, lnBatch);
		return "detail";
	}
	
	/**
	 * ɾ������
	 * @return
	 * @throws Exception
	 */
	public String del() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formlnbatch0001 = formService.getFormData("lnbatch0001");
		lnBatch = new LnBatch();
		lnBatch.setBatchNo(batchNo);
		lnBatchBo.del(lnBatch);
		this.addActionMessage("ɾ���ɹ�");
		lnBatch = new LnBatch();
		lnBatch.setBrNo(User.getBrno(this.getHttpRequest()));
		lnBatch.setLoginid(User.getLoginIdByAuth(this.getHttpRequest()));
		Ipage ipage = this.getIpage();
		lnBatchList = (List) lnBatchBo.findByPage(ipage, lnBatch).getResult();
		return "list";
	}

	
	/**
	 * ��ѯ����
	 * @return
	 * @throws Exception
	 */
	public String getById() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),ServletActionContext.getResponse());
		formlnbatch0002 = formService.getFormData("lnbatch0002");
		lnBatch = new LnBatch();
		lnBatch.setBatchNo(batchNo);
		lnBatch = lnBatchBo.getById(lnBatch);
		getObjValue(formlnbatch0002, lnBatch);
		return "detail";
	}
	
	/**
	 * �����������У��
	 * @return
	 * @throws Exception
	 */
	public void validateInsert(){
		 ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		 formlnbatch0002 = formService.getFormData("lnbatch0002");
		 getFormValue(formlnbatch0002);
		 validateFormData(formlnbatch0002);
   	}
   
	/**
	 * �޸ı������У��
	 * @return
	 * @throws Exception
	 */
	public void validateUpdate(){
		 ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		 formlnbatch0002 = formService.getFormData("lnbatch0002");
		 getFormValue(formlnbatch0002);
		 validateFormData(formlnbatch0002);
  	}
	
	/**
	 * ��ѯ����
	 * @return
	 * @throws Exception
	 */
	public String getShowSchedule() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),ServletActionContext.getResponse());
		query = "";
		Connection conn = DBUtils.getConn();
		CallableStatement proc = null;
		ResultSet rs = null;
		try{
		  proc = (CallableStatement)conn.prepareCall("{ call PKG_COMM.PROC_GETBATCHSTS(?,?) }"); //���ô洢����
	      proc.setString(1, batchNo);//���õ�һ�������������
//	      proc.registerOutParameter(2, Types.VARCHAR);//�ڶ��������������,��VARCHAR���͵�
	      proc.registerOutParameter(2, OracleTypes.CURSOR);//�ڶ��������������,���α����͵�
	      proc.execute();// ִ��
	      rs = (ResultSet)proc.getObject(2);//����������
	      DecimalFormat df = new DecimalFormat("###.00");
	     while(rs.next()){
	    	 valChk = rs.getDouble(2)+"";
	    	 valApp = rs.getDouble(3)+"";
	    	 valLn = rs.getDouble(4)+"";
	    	 valSum = rs.getDouble(5)+"";
	    	 query = "'"+df.format(rs.getDouble(2)/rs.getDouble(5)*100)+"','"+df.format(rs.getDouble(3)/rs.getDouble(5)*100)+"','"+df.format(rs.getDouble(4)/rs.getDouble(5)*100)+"'";
	     }
		}catch(Exception e){
			
		}finally{
			DBUtils.closeResultset(rs);
			DBUtils.closeStatement(proc);
			DBUtils.closeConnection(conn);
		}
		return "detail";
	}
	
	public String getTab() throws Exception{
		ActionContext.initialize(ServletActionContext.getRequest(),
				ServletActionContext.getResponse());
		
		LnBatch lnBatch = new LnBatch();
		lnBatch.setBatchNo(batchNo);
		lnBatchBo.updateNum(lnBatch);
		
		
		tabList = new ArrayList();
		String[] tab = null;
		
		tab = new String[2];
		tab[0] = "ҵ�����";
		tab[1] = "LnBatchAction_getShowSchedule.action?batchNo=" + batchNo+ "&query="+ query + "";
		tabList.add(tab);

		tab = new String[2];
		tab[0] = "������Ϣ";
		tab[1] = "LnBatchAction_getById.action?batchNo=" + batchNo+ "&query=query";
		tabList.add(tab);
		
		tab = new String[2];
		tab[0] = "������ϸ";
		tab[1] = "LnApplyMidAction_findByPage.action?batchNo=" + batchNo;
		//LnApplyRegAction_findByPage.action
		tabList.add(tab);
		
		return "tab";
	}
	
	
	public List getTabList() {
		return tabList;
	}
	public void setTabList(List tabList) {
		this.tabList = tabList;
	}
	public LnBatch getLnBatch() {
		return lnBatch;
	}
	public void setLnBatch(LnBatch  lnBatch) {
		this.lnBatch = lnBatch;
	}
	public List<LnBatch> getLnBatchList() {
		return lnBatchList;
	}
	public void setLnBatchList(List<LnBatch> lnBatchList) {
		this.lnBatchList = lnBatchList;
	}
	public LnBatchBo getLnBatchBo() {
		return lnBatchBo;
	}
	public void setLnBatchBo(LnBatchBo lnBatchBo) {
		this.lnBatchBo = lnBatchBo;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public FormData getFormlnbatch0002() {
		return formlnbatch0002;
	}
	public void setFormlnbatch0002(FormData formlnbatch0002) {
		this.formlnbatch0002 = formlnbatch0002;
	}
	public FormData getFormlnbatch0001() {
		return formlnbatch0001;
	}
	public void setFormlnbatch0001(FormData formlnbatch0001) {
		this.formlnbatch0001 = formlnbatch0001;
	}
	public void setBatchNo(String batchNo){
		this.batchNo = batchNo;
	}		
	public String getBatchNo(){
		return batchNo;
	}
	public String getValChk() {
		return valChk;
	}
	public void setValChk(String valChk) {
		this.valChk = valChk;
	}
	public String getValApp() {
		return valApp;
	}
	public void setValApp(String valApp) {
		this.valApp = valApp;
	}
	public String getValLn() {
		return valLn;
	}
	public void setValLn(String valLn) {
		this.valLn = valLn;
	}
	public String getValSum() {
		return valSum;
	}
	public void setValSum(String valSum) {
		this.valSum = valSum;
	}
	
}