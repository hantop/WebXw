package  app.creditapp.cif.action;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import app.creditapp.cif.bo.CifPersInfBo;
import app.creditapp.cif.bo.CifPortraitBo;
import app.creditapp.cif.entity.CifPersInf;
import app.creditapp.cif.entity.CifPersRelCore;
import app.creditapp.cif.entity.CifPersRelLine;
import app.creditapp.cif.entity.CifPortrait;
import app.creditapp.cif.entity.ShowRel;
import app.creditapp.cred.bo.PcrpQueryInfoBo;
import app.creditapp.cred.entity.PcrpQueryInfo;
import app.util.IdCardUtil;
import app.util.User;
import app.util.toolkit.Ipage;

import com.alibaba.fastjson.JSON;
import com.core.domain.screen.FormData;
import com.core.service.screen.FormService;
import com.core.struts.ActionContext;
import com.core.struts.BaseFormBean;

/**
 * Title: CifPersAction.java
 * Description:
 **/
public class CifPersInfAction extends BaseFormBean {

	//ҳ�洫ֵ
	private CifPersInf cifPersInf;
	private List<CifPersInf> cifPersList;
	private CifPortrait cifPortrait;
	//ע��CifPersBo
	private CifPersInfBo cifPersInfBo;
	private CifPortraitBo cifPortraitBo;
	private PcrpQueryInfoBo pcrpQueryInfoBo;
	private String query;
	private String cifNo;	
	private String cifName;	
	private String brNo;
	private String querysts;
	//private String custType;
	private String cifType;//�ͻ�����
	private String idNo;
	private String is_flag;
	private ShowRel showRel;
	private FormData formcif0003;
	private FormData formcif0004;
	private String backSts;
	
	private List tabList;
	
	private String rtMessage;
	
	
	private FormData formcif0001;
	private FormData formcif0002;
	private FormData formcifpers0088;
	
	private FormService formService = new FormService();
	
	public CifPersInfAction() {
		query = "";
	}
	/**
	 * ��ҳ��ѯ
	 * @return
	 * @throws Exception
	 */
	public String findByPage() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),ServletActionContext.getResponse());
		formcif0001 = formService.getFormData("cif0001");
		cifPersInf = new CifPersInf();
		
		System.out.println(User.getBrno(ServletActionContext.getRequest())+"==========="+
				User.getSys_date(ServletActionContext.getRequest())+"==========="+
				User.getLoginid(ServletActionContext.getRequest())+"==========="
				+"===========");
		
		
		getFormValue(formcif0001);
		setObjValue(formcif0001, cifPersInf);
		cifPersInf.setBrNo(User.getBrno(ServletActionContext.getRequest()));
		
		cifPersInf.setLoginid(User.getLoginIdByAuth(this.getHttpRequest()));
		
		Ipage ipage = this.getIpage();
		cifPersList = (List) cifPersInfBo.findByPage(ipage, cifPersInf).getResult();
		return "list";
	}
	
	/**
	 * ��ȡ����ҳ��
	 * @return
	 * @throws Exception
	 */
	public String input() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formcif0002 = formService.getFormData("cif0002");
		
		System.out.println(User.getBrno(ServletActionContext.getRequest())+"yi==========="+
				User.getSys_date(ServletActionContext.getRequest())+"er==========="+
				User.getLoginid(ServletActionContext.getRequest())+"san==========="
				+"===========");
		
		return "input";
	}
	
	/**
	 * �����������
	 * @return
	 * @throws Exception
	 */
	public String insert() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formcif0002 = formService.getFormData("cif0002");
		getFormValue(formcif0002);
		cifPersInf = new CifPersInf();
		setObjValue(formcif0002, cifPersInf);
		cifPersInf.setBrNo(User.getBrno(ServletActionContext.getRequest()));
		cifPersInf.setTxDate(User.getSys_date(ServletActionContext.getRequest()));
		cifPersInf.setUpDate(User.getSys_date(ServletActionContext.getRequest()));
		cifPersInf.setOpNo(User.getLoginid(ServletActionContext.getRequest()));
		
		System.out.println(User.getBrno(ServletActionContext.getRequest())+"==========="+
				User.getSys_date(ServletActionContext.getRequest())+"==========="+
				User.getLoginid(ServletActionContext.getRequest())+"==========="
				+"===========");
		cifPersInfBo.insert(cifPersInf);
		/**
		 * �����ͻ���Ϣ��ͬʱ���Ѷ�Ӧ�Ŀͻ���Ϣ��ӵ���ʷ���У�������ʷ����,,waiting......
		 */
		 
		getObjValue(formcif0002, cifPersInf);
		this.addActionMessage("�����ɹ�");
		return "detail";
	}
	
	
	/**
	 * �޸ı������
	 * @return
	 * @throws Exception
	 */
	public String update() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formcif0002 = formService.getFormData("cif0002");
		getFormValue(formcif0002);
		cifPersInf = new CifPersInf();
		setObjValue(formcif0002, cifPersInf);
		cifPersInf.setUpDate(User.getSys_date(ServletActionContext.getRequest()));
		cifPersInfBo.update(cifPersInf);
		getObjValue(formcif0002, cifPersInf);
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
		formcif0001 = formService.getFormData("cif0001");
		cifPersInf = new CifPersInf();
		cifPersInf.setCifNo(cifNo);
		cifPersInfBo.del(cifPersInf);
		this.addActionMessage("ɾ���ɹ�");
		cifPersInf = new CifPersInf();
		cifPersInf.setBrNo(User.getBrno(ServletActionContext.getRequest()));
		Ipage ipage = this.getIpage();
		cifPersList = (List) cifPersInfBo.findByPage(ipage, cifPersInf).getResult();
		return "list";
	}

	
	/**
	 * ��������  ���ű����ѯ
	 * @return
	 * @throws Exception
	 */
	public String pcrpQueryInfo() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),ServletActionContext.getResponse());
		cifPersInf = new CifPersInf();
		
		System.out.println(User.getBrno(ServletActionContext.getRequest())+"==========="+
				User.getSys_date(ServletActionContext.getRequest())+"==========="+
				User.getLoginid(ServletActionContext.getRequest())+"==========="
				+"===========");
		
		cifPersInf.setCifNo(cifNo);
		cifPersInf = cifPersInfBo.getById(cifPersInf);
		
		PcrpQueryInfo pcrpQueryInfoRep = new PcrpQueryInfo();
		/**����ʹ�� ȡ��ǰ�û� ��ʼ**/
		pcrpQueryInfoRep.setCustName(cifPersInf.getCifName());
		pcrpQueryInfoRep.setCertType(cifPersInf.getIdType());
		pcrpQueryInfoRep.setCertNum(cifPersInf.getIdNo());
		/**����ʹ�� ȡ��ǰ�û� ����**/
		
		/**����ʹ�� �̶��û� ��ʼ**/
//		pcrpQueryInfoRep.setCustName("Ҷ����");
//		pcrpQueryInfoRep.setCertType("0");
//		pcrpQueryInfoRep.setCertNum("34012219791010003X");
		pcrpQueryInfoRep.setCrpReason("1");
		/**����ʹ�� �̶��û� ����**/
		
		String crpFilePath = "";
		
		/**����ʹ�� ��ʼ**/
		//���÷����������Ž����ѯ��
		PcrpQueryInfo pcrpQueryinfoCrpFilePath = pcrpQueryInfoBo.existValid(pcrpQueryInfoRep);
		if(null == pcrpQueryinfoCrpFilePath){
			crpFilePath="";
		}else{
			crpFilePath = pcrpQueryinfoCrpFilePath.getCrpFilePath();
		}
		ServletActionContext.getRequest().setAttribute("CRP_FILEPATH",crpFilePath);
		/**����ʹ�� ����**/
		
		return "pcrpQuery";
	}
	
	/**
	 * ��ѯ����
	 * @return
	 * @throws Exception
	 */
	public String getById() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),ServletActionContext.getResponse());
		formcif0002 = formService.getFormData("cif0002");
		cifPersInf = new CifPersInf();
		
		System.out.println(User.getBrno(ServletActionContext.getRequest())+"==========="+
				User.getSys_date(ServletActionContext.getRequest())+"==========="+
				User.getLoginid(ServletActionContext.getRequest())+"==========="
				+"===========");
		
		cifPersInf.setCifNo(cifNo);
		cifPersInf = cifPersInfBo.getById(cifPersInf);
		getObjValue(formcif0002, cifPersInf);
		return "detail";
	}
	
	/**
	 * �����������У��
	 * @return
	 * @throws Exception
	 */
	public void validateInsert(){
		 ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		 formcif0002 = formService.getFormData("cif0002");
		 getFormValue(formcif0002);
		 validateFormData(formcif0002);
   	}
   
	/**
	 * �޸ı������У��
	 * @return
	 * @throws Exception
	 */
	public void validateUpdate(){
		 ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		 formcif0002 = formService.getFormData("cif0002");
		 getFormValue(formcif0002);
		 validateFormData(formcif0002);
  	}
	
	/**
	 * ��ѯ���� ----������Ϣ
	 * 
	 * @return
	 * @throws Exception
	 */
	/*public String getById() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),
				ServletActionContext.getResponse());
		formcifpers0087 = formService.getFormData("cifpers0087");
		cifPersInf = new CifPersInf();
		cifPersInf.setCif_no(cifNo);
		cifPersInf = cifPersInfBo.getById(cifPersInf);
		if ("1".equals(cifPersInf.getId_type())) {//֤�����������֤
			this.changeFormProperty(formcifpers0087, "birth_day", "onclick", "");
			this.changeFormProperty(formcifpers0087, "birth_day", "readonly", "1");
			this.changeFormProperty(formcifpers0087, "sex", "readonly", "1");
			cifPersInf.setBirth_day(IdCardUtil.getBirthdayFromIdCard(cifPersInf.getId_no()));
			cifPersInf.setSex(IdCardUtil.getSexFromIdCard(cifPersInf.getId_no()));
			
		}	
//		this.changeFormProperty(formcifpers0087, "if_agri", "readonly", "1");
		//this.changeFormProperty(formcifpers0087, "cif_name", "readonly", "1");
		getObjValue(formcifpers0087, cifPersInf);
		return "detail";
	}*/
	
	/**
	 * �鿴360�ӽ�
	 * @return
	 */
	public String getAllDetail() {
		ActionContext.initialize(ServletActionContext.getRequest(), 
				ServletActionContext.getResponse());
		cifPersInf = new CifPersInf();
		cifPersInf.setCifNo(cifNo);
		//cifPers.setEcif_no(ecif_no);
		cifPersInf = cifPersInfBo.getById(cifPersInf);
		//cifType = cifPersInf.getCifType();
		//if_agri = cifPers.getIf_agri();
		return "all";
	}
	public String getAllDetailForRead() {
		ActionContext.initialize(ServletActionContext.getRequest(), 
				ServletActionContext.getResponse());
		cifPersInf = new CifPersInf();
		cifPersInf.setCifNo(cifNo);
		//cifPers.setEcif_no(ecif_no);
		cifPersInf = cifPersInfBo.getById(cifPersInf);
		ServletActionContext.getRequest().setAttribute("cifName", cifPersInf.getCifName());
		ServletActionContext.getRequest().setAttribute("idType", cifPersInf.getIdType());
		ServletActionContext.getRequest().setAttribute("idNo", cifPersInf.getIdNo());
		//cifType = cifPersInf.getCifType();
		//if_agri = cifPers.getIf_agri();
//		formcif0004 = formService.getFormData("cif0004");
//		cifPortrait = new CifPortrait();
//		cifPortrait.setCifNo(cifNo);
//		cifPortrait = cifPortraitBo.getById(cifPortrait);
//		getObjValue(formcif0004, cifPortrait);
//		return "detail";
		return "all";
	}	
	/**
	 * 360��ͼ��tableͷ
	 * @return
	 */
	public String getDetailTop() {
		ActionContext.initialize(ServletActionContext.getRequest(), 
				ServletActionContext.getResponse());
		formcifpers0088 = formService.getFormData("cifpers0088");
		cifPersInf = new CifPersInf();
		cifPersInf.setCifNo(cifNo);
		cifPersInf = cifPersInfBo.getById(cifPersInf);
		getObjValue(formcifpers0088, cifPersInf);
		query = "query";
		return "top";
	}
	
	public String getTab() throws Exception{
		ActionContext.initialize(ServletActionContext.getRequest(),
				ServletActionContext.getResponse());
		tabList = new ArrayList();
		String[] tab = null;
		
		tab = new String[2];
		tab[0] = "������Ϣ";
		tab[1] = "CifPersInfAction_getById.action?cifNo=" + cifNo+"&cust_type="+cifType + "&query="+ query + "";
		tabList.add(tab);
		
		if(is_flag!=null && is_flag.equals("1")){
			
			tab = new String[2];
			tab[0] = "�ͻ���ʷ��Ϣ";
			tab[1] = "CifPersHisAction_listQuotaForCif_Read.action?cifNo=" + cifNo + "&query=query";
			tabList.add(tab);
			
		}
		/*tab = new String[2];
		tab[0] = "Ӱ�����";
		tab[1] = "creditapp/cif/CifPersInf_ShowView.jsp?pacScene=10&cifNo="+cifNo+"&busiNo="+"" + "&query="+ query + "&scene_type=1";
		tabList.add(tab);*/
		
		tab = new String[2];
		tab[0] = "ְҵ��Ϣ";
		if(is_flag!=null && is_flag.equals("1")){
			tab[1] = "CifPersCareerAction_listQuotaForCif_Read.action?cifNo=" + cifNo +"&brNo=" + brNo + "&query=query";
		}else{
			tab[1] = "CifPersCareerAction_listQuotaForCif.action?cifNo=" + cifNo+"&brNo=" + brNo ;
		}
		
		tabList.add(tab);
		
		if(is_flag!=null && is_flag.equals("1")){
			tab = new String[2];
			tab[0] = "�˻���Ϣ";
			tab[1] = "CifAcctAction_listQuotaForCif_Read.action?cifNo=" + cifNo + "&query=query";
			tabList.add(tab);
			
			tab = new String[2];
			tab[0] = "��ѺƷ��Ϣ";
			tab[1] = "LnGageAction_listQuotaForCif_Read.action?cifNo=" + cifNo + "&query=query";
			tabList.add(tab);
			
			tab = new String[2];
			tab[0] = "��ͬ��Ϣ";
			tab[1] = "LnPactAction_listForCif.action?cifNo=" + cifNo + "&query=query";
			tabList.add(tab);
			
			tab = new String[2];
			tab[0] = "�ͻ�����";
			tab[1] = "creditapp/cif/CifPortrait_AllForRead.jsp?cifNo=" + cifNo + "&query=query";
			tabList.add(tab);
		}else{
			
		}
		tab = new String[2];
		tab[0] = "�ͻ�����";
		if(is_flag!=null && is_flag.equals("1")){
			tab[1] = "CifEvalAction_findByPage360_Read.action?cifNo=" + cifNo+"&brNo=" + brNo + "&query="+query;
		}else{
			tab[1] = "CifEvalAction_findByPage360_Read.action?cifNo=" + cifNo+"&brNo=" + brNo + "&query="+query;
		}
		
		tabList.add(tab);
		
		return "tab";
	}
	
	/**
	 * 
	 * @����˵��:��15λ֤����תΪ18λ
	 * @return
	 * @throws Exception
	 * @return  String
	 * @�޸�˵��:
	 */
	public String getIdNo15() throws Exception{
		this.getHttpResponse().setContentType("text/html;charset=utf-8");
		PrintWriter out = this.getHttpResponse().getWriter();
		try{
			IdCardUtil icu = new IdCardUtil();
			String id18 = icu.getNewIDCard(idNo);
			//rtMessage = "[{ridno:'" +id15 + "'}]";
			rtMessage=id18;
			out.println(rtMessage);
			return null;
		}catch(Exception e){
			//rtMessage = "[{ridno:'" +"8888" + "'}]";
			rtMessage="8888";
			out.println(rtMessage);
			return null;
		}
		
	}

	
	/**
	 * ��ʾ��ϵͼ
	 * @return
	 * @throws Exception
	 */
	public String showView() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),ServletActionContext.getResponse());
		cifPersInf = new CifPersInf();
		cifPersInf.setCifNo(cifNo);
		cifPersInf = cifPersInfBo.getById(cifPersInf);
		
		List<CifPersRelCore> clist = cifPersInfBo.getCifPersRelCores(cifPersInf);
		List<CifPersRelLine> llist = cifPersInfBo.getCifPersRelLines(cifPersInf);
		
		String nodes = "";
		for(CifPersRelCore cprc: clist){
			nodes += ",{name:'"+cprc.getCifName()+"'}";
		}
		if(nodes.length()>0){
			nodes = nodes.substring(1);
		}
		
		String links = "";
		for(CifPersRelLine cprl: llist){
			links += ",{source: '"+cprl.getCifName()+"', target: '"+cprl.getRelCifName()+"', weight: 1, name: '"+cprl.getRel()+"'}";
		}
		if(nodes.length()>0){
			links = links.substring(1);
		}
		
		showRel = new ShowRel();
		showRel.setTitle("");
		showRel.setName("");
		showRel.setData("");
		showRel.setNodes(nodes);
		showRel.setLinks(links);
		
		return "detail";
	}
	
	
	
	
	
	public ShowRel getShowRel() {
		return showRel;
	}
	public void setShowRel(ShowRel showRel) {
		this.showRel = showRel;
	}
	
	
	
	
	
	public String getIs_flag() {
		return is_flag;
	}
	public void setIs_flag(String isFlag) {
		is_flag = isFlag;
	}
	
	public String getIdNo() {
		return idNo;
	}
	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}
	
	public List getTabList() {
		return tabList;
	}
	public String getRtMessage() {
		return rtMessage;
	}
	public void setRtMessage(String rtMessage) {
		this.rtMessage = rtMessage;
	}
	public void setTabList(List tabList) {
		this.tabList = tabList;
	}
	public String getCifType() {
		return cifType;
	}
	public void setCifType(String cifType) {
		this.cifType = cifType;
	}
	
	public CifPersInf getCifPers() {
		return cifPersInf;
	}
	public void setCifPers(CifPersInf  cifPersInf) {
		this.cifPersInf = cifPersInf;
	}
	public List<CifPersInf> getCifPersList() {
		return cifPersList;
	}
	public void setCifPersList(List<CifPersInf> cifPersList) {
		this.cifPersList = cifPersList;
	}
	public CifPersInfBo getCifPersBoInf() {
		return cifPersInfBo;
	}
	public void setCifPersInfBo(CifPersInfBo cifPersInfBo) {
		this.cifPersInfBo = cifPersInfBo;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public FormData getFormcif0002() {
		return formcif0002;
	}
	public void setFormcif0002(FormData formcif0002) {
		this.formcif0002 = formcif0002;
	}
	public FormData getFormcif0001() {
		return formcif0001;
	}
	public void setFormcif0001(FormData formcif0001) {
		this.formcif0001 = formcif0001;
	}
	public FormData getFormcifpers0088() {
		return formcifpers0088;
	}
	public void setFormcifpers0088(FormData formcifpers0088) {
		this.formcifpers0088 = formcifpers0088;
	}
	public void setCifNo(String cifNo){
		this.cifNo = cifNo;
	}		
	public String getCifNo(){
		return cifNo;
	}
	public CifPortraitBo getCifPortraitBo() {
		return cifPortraitBo;
	}
	public void setCifPortraitBo(CifPortraitBo cifPortraitBo) {
		this.cifPortraitBo = cifPortraitBo;
	}
	public CifPortrait getCifPortrait() {
		return cifPortrait;
	}
	public void setCifPortrait(CifPortrait cifPortrait) {
		this.cifPortrait = cifPortrait;
	}
	public FormData getFormcif0003() {
		return formcif0003;
	}
	public void setFormcif0003(FormData formcif0003) {
		this.formcif0003 = formcif0003;
	}
	public FormData getFormcif0004() {
		return formcif0004;
	}
	public void setFormcif0004(FormData formcif0004) {
		this.formcif0004 = formcif0004;
	}
	public CifPersInf getCifPersInf() {
		return cifPersInf;
	}
	public void setCifPersInf(CifPersInf cifPersInf) {
		this.cifPersInf = cifPersInf;
	}
	public String getBrNo() {
		return brNo;
	}
	public void setBrNo(String brNo) {
		this.brNo = brNo;
	}
	public CifPersInfBo getCifPersInfBo() {
		return cifPersInfBo;
	}
	public String getBackSts() {
		return backSts;
	}
	public void setBackSts(String backSts) {
		this.backSts = backSts;
	}
	public String getQuerysts() {
		return querysts;
	}
	public void setQuerysts(String querysts) {
		this.querysts = querysts;
	}
	public String getCifName() {
		return cifName;
	}
	public void setCifName(String cifName) {
		this.cifName = cifName;
	}
	public PcrpQueryInfoBo getPcrpQueryInfoBo() {
		return pcrpQueryInfoBo;
	}
	public void setPcrpQueryInfoBo(PcrpQueryInfoBo pcrpQueryInfoBo) {
		this.pcrpQueryInfoBo = pcrpQueryInfoBo;
	}
	
}