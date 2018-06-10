package  app.creditapp.sysConfig.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import app.creditapp.sysConfig.bo.SysRequireTableBo;
import app.creditapp.sysConfig.entity.SysRequireTable;
import app.creditapp.sysConfig.entity.TableInfo;
import app.creditapp.sysConfig.util.GetTreeVal;
import app.oscache.MBaseCache;
import app.util.toolkit.Ipage;

import com.core.domain.screen.FormData;
import com.core.service.screen.FormService;
import com.core.struts.ActionContext;
import com.core.struts.BaseFormBean;


/**
* Title: RequireLogTableAction.java
* Description:
**/

public class SysRequireTableAction extends BaseFormBean {

	//ҳ�洫ֵ
	private SysRequireTable requireLogTable;
	private List<SysRequireTable> requireLogTableList;

	//ע��RequireLogTableBo
	private SysRequireTableBo sysRequireTableBo;

	private String query;
	private String view;
	private String tableCode;
	private String tableinfo;
	private String treeVal;
	private String parm_tbl;
	private String parm_str;
	private FormData formtbl0004;
	private FormData formtbl0003;
	private  FormService formService = new FormService();
	
	public SysRequireTableAction() {
		formtbl0004 = formService.getFormData("tbl0004");
		formtbl0003 = formService.getFormData("tbl0003");
		query = "";
		view = "";
	}
	/**
	 * ��ҳ��ѯ
	 * @return
	 * @throws Exception
	 */
	 public String findByPage() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),ServletActionContext.getResponse());
		requireLogTable = new SysRequireTable();
		getFormValue(formtbl0003);
		setObjValue(formtbl0003, requireLogTable);
		Ipage ipage = this.getIpage();
		requireLogTableList = (List) sysRequireTableBo.findByPage(ipage, requireLogTable).getResult();
		return "list";
	}
	
	/**
	 * ����ҳ��
	 * @return
	 * @throws Exception
	 */
	public String input() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		List<TableInfo> tablelist =sysRequireTableBo.getAllTable(new TableInfo());
		this.setTreeVal(GetTreeVal.toJsp(tablelist));
		return "allTab";
	}
	
	public String getDocTree() throws Exception {
		parm_str = sysRequireTableBo.getStringFromList();  //��ȡ���ݿ�����ṹ
		parm_tbl = sysRequireTableBo.getTblStringFromList();//�ĵ��ṹ��
		return "tbl_tree";
	}
	/**
	 * �����������
	 * @return
	 * @throws Exception
	 */
	public String insert() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		getFormValue(formtbl0004);
		requireLogTable = new SysRequireTable();
		setObjValue(formtbl0004, requireLogTable);
		sysRequireTableBo.insert(requireLogTable);
		getObjValue(formtbl0004, requireLogTable);
		query = "query";
		this.addActionMessage("�����ɹ�");
		return "detail";
	}
	
	public String insertNew() throws Exception{
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		Ipage ipage = this.getIpage();
		requireLogTable = new SysRequireTable();
		String str1 = this.tableinfo.split("-")[0];
		String str2 = this.tableinfo.split("-")[1];
		requireLogTable.setTableCode(this.tableinfo.split("-")[0]);
		requireLogTableList = (List) sysRequireTableBo.findByPage(ipage, requireLogTable).getResult();
		if(requireLogTableList.size()>0){
			this.addActionMessage("���д˱�");
		}else{
			requireLogTable.setTableName(str2);
			sysRequireTableBo.insert(requireLogTable);
			this.addActionMessage("�����ɹ�");
		}
		
		requireLogTable = new SysRequireTable();
		getFormValue(formtbl0003);
		setObjValue(formtbl0003, requireLogTable);
		
		requireLogTableList = (List) sysRequireTableBo.findByPage(ipage, requireLogTable).getResult();
		return "list";
	}
	public String getAllTable() throws Exception{
		List<TableInfo> tablelist =sysRequireTableBo.getAllTable(new TableInfo());
		this.setTreeVal(GetTreeVal.toJsp(tablelist));
		return "allTab";
	}
	/**
	 * �޸ı������
	 * @return
	 * @throws Exception
	 */
	public String update() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		getFormValue(formtbl0004);
		requireLogTable = new SysRequireTable();
		setObjValue(formtbl0004, requireLogTable);
		sysRequireTableBo.update(requireLogTable);
		getObjValue(formtbl0004, requireLogTable);
		query = "query";
		this.addActionMessage("�����ɹ�");
		return "detail";
	}
	
	/**
	 * ɾ������
	 * @return
	 * @throws Exception
	 */
	public String del() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		requireLogTable = new SysRequireTable();
		requireLogTable.setTableCode(this.tableCode);
		sysRequireTableBo.del(requireLogTable);
		MBaseCache.getCache().removeByKey(this.tableCode);
		requireLogTable = new SysRequireTable();
		Ipage ipage = this.getIpage();
		requireLogTableList = (List) sysRequireTableBo.findByPage(ipage, requireLogTable).getResult();
		this.addActionMessage("ɾ���ɹ�");
		return "list";
	}

	/**
	 * ��ѯ����
	 * @return
	 * @throws Exception
	 */
	public String getById() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),ServletActionContext.getResponse());
		requireLogTable = sysRequireTableBo.getById(requireLogTable);
		getObjValue(formtbl0004, requireLogTable);
		if(view.equals("view")){
			 query = "query";
		 }
		return "detail";
	}
	
	/**
	 * �����������У��
	 * @return
	 * @throws Exception
	 */
	public void validateInsert(){
		 ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		 getFormValue(formtbl0004);
		 validateFormData(formtbl0004);
   }
	/**
	 * �޸ı������У��
	 * @return
	 * @throws Exception
	 */
	public void validateUpdate(){
		 ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		 getFormValue(formtbl0004);
		 validateFormData(formtbl0004);
  }

	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public String getView() {
		return view;
	}
	public void setView(String view) {
		this.view = view;
	}
	public FormData getFormtbl0004() {
		return formtbl0004;
	}
	public void setFormtbl0004(FormData formtbl0004) {
		this.formtbl0004 = formtbl0004;
	}
	public FormData getFormtbl0003() {
		return formtbl0003;
	}
	public void setFormtbl0003(FormData formxxxx) {
		this.formtbl0003 = formxxxx;
	}
	public String getTableCode() {
		return tableCode;
	}
	public void setTableCode(String tableCode) {
		this.tableCode = tableCode;
	}
	public String getTreeVal() {
		return treeVal;
	}
	public void setTreeVal(String treeVal) {
		this.treeVal = treeVal;
	}
	public String getTableinfo() {
		return tableinfo;
	}
	public void setTableinfo(String tableinfo) {
		this.tableinfo = tableinfo;
	}
	public SysRequireTable getRequireLogTable() {
		return requireLogTable;
	}
	public void setRequireLogTable(SysRequireTable requireLogTable) {
		this.requireLogTable = requireLogTable;
	}
	public List<SysRequireTable> getRequireLogTableList() {
		return requireLogTableList;
	}
	public void setRequireLogTableList(List<SysRequireTable> requireLogTableList) {
		this.requireLogTableList = requireLogTableList;
	}
	public SysRequireTableBo getSysRequireTableBo() {
		return sysRequireTableBo;
	}
	public void setSysRequireTableBo(SysRequireTableBo sysRequireTableBo) {
		this.sysRequireTableBo = sysRequireTableBo;
	}
	public String getParm_tbl() {
		return parm_tbl;
	}
	public void setParm_tbl(String parm_tbl) {
		this.parm_tbl = parm_tbl;
	}
	public String getParm_str() {
		return parm_str;
	}
	public void setParm_str(String parm_str) {
		this.parm_str = parm_str;
	}
	public FormService getFormService() {
		return formService;
	}
	public void setFormService(FormService formService) {
		this.formService = formService;
	}
	
}