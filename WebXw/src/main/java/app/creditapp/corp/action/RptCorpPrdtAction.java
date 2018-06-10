package app.creditapp.corp.action;
import java.util.List;
import org.apache.struts2.ServletActionContext;
import app.creditapp.corp.bo.RptCorpPrdtBo;
import app.creditapp.corp.entity.RptCorpPrdt;
import app.util.toolkit.Ipage;
import com.core.domain.screen.FormData;
import com.core.struts.ActionContext;
import com.core.struts.BaseFormBean;
public class RptCorpPrdtAction extends BaseFormBean {
	
	private String query;
	private String view;
	
	private RptCorpPrdt rptCorpPrdt;
	
	private FormData formfin;
	
	private List<RptCorpPrdt> list;
	
	private RptCorpPrdtBo rptCorpPrdtBo;
	
	public RptCorpPrdtAction(){
		query = "";
		view = "";
	}
	
	public String input() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		return "input";
	}
	
	public String findByPage() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		Ipage ipage = this.getIpage();
		rptCorpPrdt=new RptCorpPrdt();
		getFormValue(formfin);
		setObjValue(formfin, rptCorpPrdt);
		list=(List)rptCorpPrdtBo.findByPage(ipage, rptCorpPrdt).getResult();
		return "list";
	}
	
	public String insert() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		getFormValue(formfin);
		rptCorpPrdt=new RptCorpPrdt();
	    setObjValue(formfin,rptCorpPrdt);
	    rptCorpPrdtBo.insert(rptCorpPrdt);
	    
		//���²�����Ϊ����ת������鿴ҳ��
		getObjValue(formfin,rptCorpPrdt);
		query = "query";
		return "detail";
	}
	
	/**
	 * ������֤
	 * @throws Exception
	 */
	public void validateInsert() throws Exception{
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		getFormValue(formfin);
		validateFormData(formfin) ;
		//��ֵ���������������н�һ������֤
		rptCorpPrdt=new RptCorpPrdt();
	    setObjValue(formfin,rptCorpPrdt);
	}
	
	public String update() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		getFormValue(formfin);
		rptCorpPrdt=new RptCorpPrdt();
	    setObjValue(formfin,rptCorpPrdt);
	    rptCorpPrdtBo.update(rptCorpPrdt);
		//���²�����Ϊ����ת������鿴ҳ��
		getObjValue(formfin,rptCorpPrdt);
		query = "query";
		return "detail";
	}

	/**
	 * �޸���֤
	 * @throws Exception
	 */
	public void validateUpdate() throws Exception{
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		getFormValue(formfin);
		validateFormData(formfin) ;
		//��ֵ���������������н�һ������֤
		rptCorpPrdt=new RptCorpPrdt();
	    setObjValue(formfin,rptCorpPrdt);
	}
	
	public String del() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		rptCorpPrdt=new RptCorpPrdt();

		rptCorpPrdtBo.del(rptCorpPrdt);
		this.setMessage("�����ɹ�");
		return "return_list";
	}

	public String getById() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		rptCorpPrdt=new RptCorpPrdt();
		
		rptCorpPrdt = rptCorpPrdtBo.getById(rptCorpPrdt);
		getObjValue(formfin,rptCorpPrdt);
		 if(view.equals("view")){
			 query = "query";
		 }
		return "detail";
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

	public RptCorpPrdt getRptCorpPrdt() {
		return rptCorpPrdt;
	}

	public void setRptCorpPrdt(RptCorpPrdt rptCorpPrdt) {
		this.rptCorpPrdt = rptCorpPrdt;
	}

	public List<RptCorpPrdt> getList() {
		return list;
	}

	public void setList(List<RptCorpPrdt> list) {
		this.list = list;
	}

	public RptCorpPrdtBo getRptCorpPrdtBo() {
		return rptCorpPrdtBo;
	}

	public void setRptCorpPrdtBo(RptCorpPrdtBo rptCorpPrdtBo) {
		this.rptCorpPrdtBo = rptCorpPrdtBo;
	}
}
