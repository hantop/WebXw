package app.creditapp.sys.action;

import java.util.ArrayList;
import java.util.List;
import app.util.User;
import org.apache.struts2.ServletActionContext;
import app.util.toolkit.Ipage;
import app.creditapp.corp.bo.CorpBaseBo;
import app.creditapp.corp.entity.CorpBase;
import app.creditapp.ln.worker.WorkUtils;
import app.creditapp.sys.bo.PrdtBaseBo;
import app.creditapp.sys.entity.PrdtBase;	
import com.core.domain.screen.FormData;
import com.core.service.screen.FormService;
import com.core.struts.ActionContext;
import com.core.struts.BaseFormBean;

/**
 * Title: PrdtBaseAction.java Description:
 * 
 **/
public class PrdtBaseAction extends BaseFormBean {

	// ҳ�洫ֵ
	private PrdtBase prdtBase;
	private List<PrdtBase> prdtBaseList;

	// ע��PrdtBaseBo
	private PrdtBaseBo prdtBaseBo;
	private CorpBaseBo corpBaseBo;
	private List<String[]> tabList;
	private String query;
	private String prdtId;
	private String brAccType;
	private String prdtNo;
	private String brNo;
	private String feeNo;
	private String prdtName;
	private FormData formsys0001;
	private FormData formsys0002;
	private FormData formsys0003;
	private FormData formsys0102;
	private FormService formService = new FormService();

	public PrdtBaseAction() {
		query = "";
	}

	/**
	 * ��ҳ��ѯ
	 * 
	 * @return
	 * @throws Exception
	 */
	public String findByPage() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),
				ServletActionContext.getResponse());
		formsys0001 = formService.getFormData("sys0001");
		prdtBase = new PrdtBase();
		getFormValue(formsys0001);
		String a =User.getBrno(ServletActionContext.getRequest());
		if(a != ""&&a !=null){
			prdtBase.setBrNo(User.getBrno(ServletActionContext.getRequest()));
		}
		setObjValue(formsys0001, prdtBase);
		Ipage ipage = this.getIpage();
		prdtBaseList = (List<PrdtBase>) prdtBaseBo.findByPage(ipage, prdtBase).getResult();
		return "list";
	}

	/**
	 * ��ȡ����ҳ��
	 * 
	 * @return
	 * @throws Exception
	 */
	public String input() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),
				ServletActionContext.getResponse());
		formsys0002 = formService.getFormData("sys0002");
		prdtBase = new PrdtBase();
		
		if(brNo==null || "".equals(brNo) || "brNo".equals(brNo)){
			prdtBase.setBrNo(null);
		}else{
			prdtBase.setBrNo(brNo);
			prdtBase.setPrdtSts("01");
			getObjValue(formsys0002, prdtBase);
		}
		return "input";
	}

	/**
	 * ��ȡ����ҳ��
	 * 
	 * @return
	 * @throws Exception
	 */
	public String inputForAc() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),
				ServletActionContext.getResponse());
		formsys0002 = formService.getFormData("sys0002");
		getFormValue(formsys0002);
		prdtBase = new PrdtBase();
		setObjValue(formsys0002, prdtBase);
		prdtBase.setPrdtId(prdtId);
		prdtBase.setPrdtNo(prdtNo);
		prdtBaseBo.update(prdtBase);
		this.addActionMessage("����ɹ�");

		formsys0003 = formService.getFormData("sys0003");
		getFormValue(formsys0002);
		prdtBase = new PrdtBase();
		prdtBase.setPrdtId(prdtId);
		prdtBase.setPrdtNo(prdtNo);
		prdtBase = prdtBaseBo.getById(prdtBase);
		getObjValue(formsys0003, prdtBase);
		return "input";
	}

	/**
	 * �����������
	 * 
	 * @return
	 * @throws Exception
	 */
	public String insert() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),
				ServletActionContext.getResponse());
		formsys0002 = formService.getFormData("sys0002");
		formsys0003 = formService.getFormData("sys0003");
		getFormValue(formsys0002);
		getFormValue(formsys0003);
		prdtBase = new PrdtBase();
		setObjValue(formsys0002, prdtBase);
		setObjValue(formsys0003, prdtBase);
		prdtBase.setTxDate(User.getSys_date(this.getHttpRequest()));
		
//		PrdtBase prdtBaseIns = new PrdtBase();
//		prdtBaseIns = prdtBaseBo.getMaxNoByBrNo(prdtBase);
//		if(prdtBaseIns==null){
//			prdtNo = prdtBase.getBrNo()+"001";
//		}else{
//			String maxPrdtNo = prdtBaseIns.getPrdtNo();
//			prdtNo = prdtBase.getBrNo() + String.format("%03d", Integer.parseInt(
//					maxPrdtNo.substring(maxPrdtNo.length()-3))+1);
//		}
//		//prdtNo = maxPrdtNo.substring(maxPrdtNo.length()-3);
//		prdtBase.setPrdtNo(prdtNo);
				
		prdtBaseBo.insert(prdtBase);
		this.addActionMessage("����ɹ�");

//		if (brAccType.equals("A")) {
//			prdtBase.setBrNo(brNo);
//			getObjValue(formsys0003, prdtBase);
//			prdtId = prdtBase.getPrdtId();
//			return "detailForAc";
//		} else {
			prdtBase.setBrNo(brNo);
			getObjValue(formsys0002, prdtBase);
			prdtId = prdtBase.getPrdtId();
			this.changeFormProperty(formsys0002, "prdtNo", "readonly", "1");
			return "detail";
//		}

	}
	//������������
	@SuppressWarnings("unchecked")
	public String findByPagePop() throws Exception {
		ActionContext.initialize(getHttpRequest(),getHttpResponse());
		//formsys0002 = formService.getFormData("sys0002");
		
		prdtBase = new PrdtBase();
		//getFormValue(formsys0002);
		//setObjValue(formsys0002, prdtBase);
		//Ipage ipage = this.getIpage();
//		prdtBase.setAllowAreaNo(User.getBrno(getHttpRequest()));
		prdtBaseList = (List<PrdtBase>) prdtBaseBo.findWkfApprovalRole(prdtBase);
		//prdtBaseList = (List<PrdtBase>) prdtBaseBo.findByPage(ipage, prdtBase).getResult();
		String roleno = getHttpRequest().getParameter("RoleNo");
		getHttpRequest().setAttribute("RoleNo", roleno);
		
		return "popList";
	}
	public String insertForCopy() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),
				ServletActionContext.getResponse());
		formsys0002 = formService.getFormData("sys0002");
		formsys0001 = formService.getFormData("sys0001");
		getFormValue(formsys0002);
		prdtBase = new PrdtBase();
		prdtBase.setPrdtId(prdtId);
		prdtBase.setPrdtNo(prdtNo);
		prdtBase = prdtBaseBo.getById(prdtBase);
		prdtBase.setPrdtNo("");
		prdtBase.setPrdtId(null);
		prdtBase.setPrdtSts("02");
		prdtBaseBo.insertForCopy(prdtBase);
		this.addActionMessage("���Ƴɹ�");
		prdtBase = new PrdtBase();
		getObjValue(formsys0001, prdtBase);
		Ipage ipage = this.getIpage();
		prdtBaseList = (List<PrdtBase>) prdtBaseBo.findByPage(ipage, prdtBase)
				.getResult();
		return "detail";
	}

	/**
	 * �޸ı������
	 * 
	 * @return
	 * @throws Exception
	 */
	public String update() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),
				ServletActionContext.getResponse());
		formsys0002 = formService.getFormData("sys0002");
		formsys0102 = formService.getFormData("sys0102");
		formsys0003 = formService.getFormData("sys0003");
		getFormValue(formsys0002);
		getFormValue(formsys0102);
		getFormValue(formsys0003);
		prdtBase = new PrdtBase();
		setObjValue(formsys0002, prdtBase);
		setObjValue(formsys0102, prdtBase);
		setObjValue(formsys0003, prdtBase);

		if (brAccType.equals("A")) {
			prdtBase.setFeeNo(feeNo);
			prdtBaseBo.update(prdtBase);
			this.addActionMessage("����ɹ�");
			getObjValue(formsys0003, prdtBase);
			prdtId = prdtBase.getPrdtId();
			WorkUtils.getRgAppRateMap().remove(prdtBase.getPrdtNo());
			//return "detailForAc";
			return "detail";
		} else {
			prdtBase.setFeeNo(null);
			prdtBase.setRepayNo(null);
			//prdtBase.setDefNo(null);
			prdtBase.setDamNo(null);
			//prdtBase.setOverRate(null);
			prdtBaseBo.update(prdtBase);
			this.addActionMessage("����ɹ�");
			getObjValue(formsys0102, prdtBase);
			prdtId = prdtBase.getPrdtId();
			WorkUtils.getRgAppRateMap().remove(prdtBase.getPrdtNo());
			return "detailB";
		}
	}

	/**
	 * ��Ч
	 * 
	 * @return
	 * @throws Exception
	 */
	public String active() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),
				ServletActionContext.getResponse());
		formsys0001 = formService.getFormData("sys0001");
		prdtBase = new PrdtBase();
		prdtBase.setPrdtId(prdtId);
		prdtBase.setPrdtNo(prdtNo);
		prdtBase = prdtBaseBo.getById(prdtBase);
		prdtBase.setPrdtSts("01");
		prdtBaseBo.update(prdtBase);
		this.addActionMessage("��Ч�ɹ�");
		prdtBase = new PrdtBase();
		Ipage ipage = this.getIpage();
		prdtBaseList = (List<PrdtBase>) prdtBaseBo.findByPage(ipage, prdtBase)
				.getResult();
		return "list";
	}

	/**
	 * ͣ��
	 * 
	 * @return
	 * @throws Exception
	 */
	public String inactive() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),
				ServletActionContext.getResponse());
		formsys0001 = formService.getFormData("sys0001");
		prdtBase = new PrdtBase();
		prdtBase.setPrdtId(prdtId);
		prdtBase.setPrdtNo(prdtNo);
		prdtBase = prdtBaseBo.getById(prdtBase);
		prdtBase.setPrdtSts("02");
		prdtBaseBo.update(prdtBase);
		this.addActionMessage("ͣ�óɹ�");
		prdtBase = new PrdtBase();
		Ipage ipage = this.getIpage();
		prdtBaseList = (List<PrdtBase>) prdtBaseBo.findByPage(ipage, prdtBase)
				.getResult();
		return "list";
	}

	/**
	 * �޸ı������
	 * 
	 * @return
	 * @throws Exception
	 */
	public String updateForAc() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),
				ServletActionContext.getResponse());
		formsys0003 = formService.getFormData("sys0003");
		getFormValue(formsys0003);
		prdtBase = new PrdtBase();
		prdtBase.setPrdtNo(prdtNo);
 		prdtBase.setPrdtId(prdtId);
		prdtBase = prdtBaseBo.getById(prdtBase);
		setObjValue(formsys0003, prdtBase);
		prdtBase.setPrdtId(prdtId);
		prdtBaseBo.update(prdtBase);
		this.addActionMessage("����ɹ�");
		getObjValue(formsys0003, prdtBase);
		return "detail";
	}
	public String updateForDou() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),
				ServletActionContext.getResponse());
		formsys0003 = formService.getFormData("sys0003");
		getFormValue(formsys0003);
		prdtBase = new PrdtBase();
		prdtBase.setPrdtNo(prdtNo);
 		prdtBase.setPrdtId(prdtId);
		prdtBase = prdtBaseBo.getById(prdtBase);
		setObjValue(formsys0003, prdtBase);
		prdtBase.setPrdtId(prdtId);
		prdtBaseBo.update(prdtBase);
		this.addActionMessage("����ɹ�");
		getObjValue(formsys0003, prdtBase);
		return "detail";
	}
	public String updateForNull() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),
				ServletActionContext.getResponse());
		formsys0002 = formService.getFormData("sys0002");
		getFormValue(formsys0002);
		prdtBase = new PrdtBase();
		setObjValue(formsys0002, prdtBase);
		prdtBase.setPrdtId(prdtId);
		prdtBaseBo.update(prdtBase);
		this.addActionMessage("����ɹ�");
		getObjValue(formsys0002, prdtBase);
		return "detail";
	}
	public String updateForNu() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),
				ServletActionContext.getResponse());
		formsys0002 = formService.getFormData("sys0002");
		getFormValue(formsys0002);
		prdtBase = new PrdtBase();
		setObjValue(formsys0002, prdtBase);
		prdtBase.setPrdtId(prdtId);
		prdtBaseBo.update(prdtBase);
		this.addActionMessage("����ɹ�");
		getObjValue(formsys0002, prdtBase);
		return "detail";
	}
	/**
	 * ɾ������
	 * 
	 * @return
	 * @throws Exception
	 */
	public String del() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),
				ServletActionContext.getResponse());
		formsys0001 = formService.getFormData("sys0001");
		prdtBase = new PrdtBase();
		prdtBase.setPrdtId(prdtId);
		prdtBaseBo.del(prdtBase);
		this.addActionMessage("ɾ���ɹ�");
		prdtBase = new PrdtBase();
		Ipage ipage = this.getIpage();
		prdtBaseList = (List<PrdtBase>) prdtBaseBo.findByPage(ipage, prdtBase)
				.getResult();
		return "list";
	}

	/**
	 * ��ѯ����
	 * 
	 * @return
	 * @throws Exception
	 */
	public String getById() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),
				ServletActionContext.getResponse());
		if ("A".equals(brAccType)) {
			formsys0002 = formService.getFormData("sys0002");
			prdtBase = new PrdtBase();
			prdtBase.setPrdtNo(prdtNo);
			prdtBase.setPrdtId(prdtId);
			prdtBase = prdtBaseBo.getById(prdtBase);
			getObjValue(formsys0002, prdtBase);
			return "detail";
		}else{
			formsys0102 = formService.getFormData("sys0102");
			prdtBase = new PrdtBase();
			prdtBase.setPrdtNo(prdtNo);
			prdtBase.setPrdtId(prdtId);
			prdtBase = prdtBaseBo.getById(prdtBase);
			getObjValue(formsys0102, prdtBase);
			return "detailB";
		}
		
	}
	public String getByIdB() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),
				ServletActionContext.getResponse());
		formsys0102 = formService.getFormData("sys0102");
		prdtBase = new PrdtBase();
		prdtBase.setPrdtNo(prdtNo);
		prdtBase.setPrdtId(prdtId);
		prdtBase = prdtBaseBo.getById(prdtBase);
		getObjValue(formsys0102, prdtBase);
		return "detail";
	}
	public String getByIdTabFir() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),
				ServletActionContext.getResponse());
		formsys0002 = formService.getFormData("sys0002");
		prdtBase = new PrdtBase();
		prdtBase.setPrdtNo(prdtNo);
		prdtBase.setPrdtId(prdtId);
		prdtBase = prdtBaseBo.getById(prdtBase);
		getObjValue(formsys0002, prdtBase);
		return "detail";
	}
	public String getByIdForTab() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),
				ServletActionContext.getResponse());
		formsys0003 = formService.getFormData("sys0003");
		prdtBase = new PrdtBase();
		prdtBase.setPrdtNo(prdtNo);
		prdtBase.setPrdtId(prdtId);
		prdtBase = prdtBaseBo.getById(prdtBase);
		getObjValue(formsys0003, prdtBase);
		return "detail";
	}
	public String getByIdForDou() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),
				ServletActionContext.getResponse());
		formsys0003 = formService.getFormData("sys0003");
		prdtBase = new PrdtBase();
		prdtBase.setPrdtNo(prdtNo);
		prdtBase.setPrdtId(prdtId);
		prdtBase.setPrdtName(prdtName);
		prdtBase = prdtBaseBo.getById(prdtBase);
		getObjValue(formsys0003, prdtBase);
		return "detail";
	}
	public String getTab() {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		tabList = new ArrayList<String[]>();
		String[] tab = null;
		
		if ("A".equals(brAccType)) {
			tab = new String[2];
			tab[0] = "������Ϣ";
			tab[1] = "PrdtBaseAction_getById.action?prdtId=" + prdtId+"&prdtNo="+prdtNo+"&query="+query;
			tabList.add(tab);
			
			tab = new String[2];
			tab[0] = "������Ϣ";
			tab[1] = "PrdtBaseAction_getByIdForDou.action?prdtId=" + prdtId
					+ "&prdtNo=" + prdtNo + "&query=" + query+"&brAccType="+brAccType;
			tabList.add(tab);
		}else{
			tab = new String[2];
			tab[0] = "������Ϣ";
			tab[1] = "PrdtBaseAction_getByIdB.action?prdtId=" + prdtId+"&prdtNo="+prdtNo+"&query="+query;
			tabList.add(tab);
		}
		
		return "tab";
	}
	/**
	 * �����������У��
	 * 
	 * @return
	 * @throws Exception
	 */
	public void validateInsert() {
		ActionContext.initialize(ServletActionContext.getRequest(),
				ServletActionContext.getResponse());
		formsys0002 = formService.getFormData("sys0002");
		getFormValue(formsys0002);
		validateFormData(formsys0002);
		prdtBase = new PrdtBase();
		setObjValue(formsys0002, prdtBase);
		prdtBase = prdtBaseBo.getById(prdtBase);
		if (prdtBase != null) {
			this.addActionError("�ò�Ʒ����Ѵ���!");
		}
	}

	/**
	 * �޸ı������У��
	 * 
	 * @return
	 * @throws Exception
	 */
	public void validateUpdate() {
		ActionContext.initialize(ServletActionContext.getRequest(),
				ServletActionContext.getResponse());
		formsys0002 = formService.getFormData("sys0002");
		getFormValue(formsys0002);
		validateFormData(formsys0002);
		prdtBase = new PrdtBase();
		setObjValue(formsys0002, prdtBase);
		int num = prdtBaseBo.getCountPrd(prdtBase);
		if (num >= 1) {
			this.addActionError("�ò�Ʒ����Ѵ���!");
		}
	}

	public PrdtBase getPrdtBase() {
		return prdtBase;
	}

	public void setPrdtBase(PrdtBase prdtBase) {
		this.prdtBase = prdtBase;
	}

	public List<PrdtBase> getPrdtBaseList() {
		return prdtBaseList;
	}

	public void setPrdtBaseList(List<PrdtBase> prdtBaseList) {
		this.prdtBaseList = prdtBaseList;
	}

	public PrdtBaseBo getPrdtBaseBo() {
		return prdtBaseBo;
	}

	public void setPrdtBaseBo(PrdtBaseBo prdtBaseBo) {
		this.prdtBaseBo = prdtBaseBo;
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}
	public FormData getFormsys0001() {
		return formsys0001;
	}

	public void setFormsys0001(FormData formsys0001) {
		this.formsys0001 = formsys0001;
	}

	public FormData getFormsys0002() {
		return formsys0002;
	}

	public void setFormsys0002(FormData formsys0002) {
		this.formsys0002 = formsys0002;
	}

	public FormData getFormsys0003() {
		return formsys0003;
	}

	public void setFormsys0003(FormData formsys0003) {
		this.formsys0003 = formsys0003;
	}

	public FormService getFormService() {
		return formService;
	}

	public void setFormService(FormService formService) {
		this.formService = formService;
	}

	public String getPrdtId() {
		return prdtId;
	}

	public void setPrdtId(String prdtId) {
		this.prdtId = prdtId;
	}

	public String getPrdtNo() {
		return prdtNo;
	}

	public void setPrdtNo(String prdtNo) {
		this.prdtNo = prdtNo;
	}

	public String getFeeNo() {
		return feeNo;
	}

	public void setFeeNo(String feeNo) {
		this.feeNo = feeNo;
	}

	public List<String[]> getTabList() {
		return tabList;
	}

	public void setTabList(List<String[]> tabList) {
		this.tabList = tabList;
	}

	public String getBrAccType() {
		return brAccType;
	}
	

	public String getBrNo() {
		return brNo;
	}

	public void setBrNo(String brNo) {
		this.brNo = brNo;
	}

	public void setBrAccType(String brAccType) {
		this.brAccType = brAccType;
	}

	public CorpBaseBo getCorpBaseBo() {
		return corpBaseBo;
	}

	public void setCorpBaseBo(CorpBaseBo corpBaseBo) {
		this.corpBaseBo = corpBaseBo;
	}

	public String getPrdtName() {
		return prdtName;
	}

	public void setPrdtName(String prdtName) {
		this.prdtName = prdtName;
	}

	/**
	 * @return the formsys0102
	 */
	public FormData getFormsys0102() {
		return formsys0102;
	}

	/**
	 * @param formsys0102 the formsys0102 to set
	 */
	public void setFormsys0102(FormData formsys0102) {
		this.formsys0102 = formsys0102;
	}
	
	
}