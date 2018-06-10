package  app.creditapp.fund.action;
import java.util.List;
import app.util.User;
import org.apache.struts2.ServletActionContext;
import app.util.toolkit.Ipage;
import app.creditapp.fund.bo.FundRightDetailBo;
import app.creditapp.fund.entity.FundRightDetail;
import com.core.domain.screen.FormData;
import com.core.service.screen.FormService;
import com.core.struts.ActionContext;
import com.core.struts.BaseFormBean;

/**
 * Title: FundRightDetailAction.java
 * Description:
 **/
public class FundRightDetailAction extends BaseFormBean {

	//ҳ�洫ֵ
	private FundRightDetail fundRightDetail;
	private List<FundRightDetail> fundRightDetailList;

	//ע��FundRightDetailBo
	private FundRightDetailBo fundRightDetailBo;

	private String query;
	private String detailId;	
	private String fundNo;
	private String projNo;
	private FormData formfdrtdtl0001;
	private FormData formfdrtdtl0002;
	private FormService formService = new FormService();
	private String backSts;
	
	public FundRightDetailAction() {
		query = "";
	}
	/**
	 * ��ҳ��ѯ
	 * @return
	 * @throws Exception
	 */
	public String findByPage() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),ServletActionContext.getResponse());
			formfdrtdtl0001 = formService.getFormData("fdrtdtl0001");
			fundRightDetail = new FundRightDetail();
			getFormValue(formfdrtdtl0001);
			setObjValue(formfdrtdtl0001, fundRightDetail);
			fundRightDetail.setSaleFno(fundNo);
			fundRightDetail.setBuyFno(fundNo);
			fundRightDetail.setProjNo(projNo);
			Ipage ipage = this.getIpage();
			fundRightDetailList = (List) fundRightDetailBo.findByPage(ipage, fundRightDetail).getResult();
			for(int i = 0; i<fundRightDetailList.size();i++){
				fundRightDetailList.get(i).setQuery(query);
			}
			return "list";
		}
		
	
	
	/**
	 * ��ȡ����ҳ��
	 * @return
	 * @throws Exception
	 */
	public String input() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formfdrtdtl0002 = formService.getFormData("fdrtdtl0002");
		return "input";
	}
	
	/**
	 * �����������
	 * @return
	 * @throws Exception
	 */
	public String insert() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formfdrtdtl0002 = formService.getFormData("fdrtdtl0002");
		getFormValue(formfdrtdtl0002);
		fundRightDetail = new FundRightDetail();
		setObjValue(formfdrtdtl0002, fundRightDetail);
		fundRightDetailBo.insert(fundRightDetail);
		this.addActionMessage("�����ɹ�");
		query="query";
		getObjValue(formfdrtdtl0002, fundRightDetail);
		return "detail";
	}
	
	
	/**
	 * �޸ı������
	 * @return
	 * @throws Exception
	 */
	public String update() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formfdrtdtl0002 = formService.getFormData("fdrtdtl0002");
		getFormValue(formfdrtdtl0002);
		fundRightDetail = new FundRightDetail();
		setObjValue(formfdrtdtl0002, fundRightDetail);
		fundRightDetailBo.update(fundRightDetail);
		this.addActionMessage("�޸ĳɹ�");
		query="query";
		getObjValue(formfdrtdtl0002, fundRightDetail);
		return "detail";
	}
	
	
	
	/**
	 * ɾ������
	 * @return
	 * @throws Exception
	 */
	public String del() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formfdrtdtl0001 = formService.getFormData("fdrtdtl0001");
		fundRightDetail = new FundRightDetail();
		fundRightDetail.setDetailId(detailId);
		fundRightDetailBo.del(fundRightDetail);
		this.addActionMessage("ɾ���ɹ�");
		fundRightDetail = new FundRightDetail();
		Ipage ipage = this.getIpage();
		fundRightDetailList = (List) fundRightDetailBo.findByPage(ipage, fundRightDetail).getResult();
		return "list";
	}

	
	/**
	 * ��ѯ����
	 * @return
	 * @throws Exception
	 */
	public String getById() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),ServletActionContext.getResponse());
		formfdrtdtl0002 = formService.getFormData("fdrtdtl0002");
		fundRightDetail = new FundRightDetail();
		fundRightDetail.setDetailId(detailId);
		fundRightDetail = fundRightDetailBo.getById(fundRightDetail);
		getObjValue(formfdrtdtl0002, fundRightDetail);
		return "detail";
	}
	
	/**
	 * �����������У��
	 * @return
	 * @throws Exception
	 */
	public void validateInsert(){
		 ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		 formfdrtdtl0002 = formService.getFormData("fdrtdtl0002");
		 getFormValue(formfdrtdtl0002);
		 validateFormData(formfdrtdtl0002);
   	}
   
	/**
	 * �޸ı������У��
	 * @return
	 * @throws Exception
	 */
	public void validateUpdate(){
		 ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		 formfdrtdtl0002 = formService.getFormData("fdrtdtl0002");
		 getFormValue(formfdrtdtl0002);
		 validateFormData(formfdrtdtl0002);
  	}
	public FundRightDetail getFundRightDetail() {
		return fundRightDetail;
	}
	public void setFundRightDetail(FundRightDetail  fundRightDetail) {
		this.fundRightDetail = fundRightDetail;
	}
	public List<FundRightDetail> getFundRightDetailList() {
		return fundRightDetailList;
	}
	public void setFundRightDetailList(List<FundRightDetail> fundRightDetailList) {
		this.fundRightDetailList = fundRightDetailList;
	}
	public FundRightDetailBo getFundRightDetailBo() {
		return fundRightDetailBo;
	}
	public void setFundRightDetailBo(FundRightDetailBo fundRightDetailBo) {
		this.fundRightDetailBo = fundRightDetailBo;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public FormData getFormfdrtdtl0002() {
		return formfdrtdtl0002;
	}
	public void setFormfdrtdtl0002(FormData formfdrtdtl0002) {
		this.formfdrtdtl0002 = formfdrtdtl0002;
	}
	public FormData getFormfdrtdtl0001() {
		return formfdrtdtl0001;
	}
	public void setFormfdrtdtl0001(FormData formfdrtdtl0001) {
		this.formfdrtdtl0001 = formfdrtdtl0001;
	}
	public void setDetailId(String detailId){
		this.detailId = detailId;
	}		
	public String getDetailId(){
		return detailId;
	}
	public String getFundNo() {
		return fundNo;
	}
	public void setFundNo(String fundNo) {
		this.fundNo = fundNo;
	}
	public String getProjNo() {
		return projNo;
	}
	public void setProjNo(String projNo) {
		this.projNo = projNo;
	}
	public String getBackSts() {
		return backSts;
	}
	public void setBackSts(String backSts) {
		this.backSts = backSts;
	}
	
}