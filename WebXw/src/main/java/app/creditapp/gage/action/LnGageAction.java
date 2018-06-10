package  app.creditapp.gage.action;
import java.io.PrintWriter;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.core.domain.screen.FormData;
import com.core.service.screen.FormService;
import com.core.struts.ActionContext;
import com.core.struts.BaseFormBean;

import app.creditapp.gage.bo.LnGageBo;
import app.creditapp.gage.entity.LnGage;
import app.creditapp.ln.bo.LnDueBo;
import app.creditapp.ln.entity.LnDue;
import app.util.IdCardUtil;
import app.util.User;
import app.util.toolkit.Ipage;

/**
 * Title: LnGageAction.java
 * Description:
 **/
public class LnGageAction extends BaseFormBean {

	//ҳ�洫ֵ
	private LnGage lnGage;
	private List<LnGage> lnGageList;
	private List<LnDue> lnDueList;
	private String backSts;
	
	//ע��LnGageBo
	private LnGageBo lnGageBo;
	private LnDueBo lnDueBo;
	private String query;
	private String appId;	
	private String cifNo;
	private String cifName;
	private String gageId;
	
	private String gageIdno;
	private String rtMessage;
	
	private FormData formlngage0001;
	private FormData formlngage0002;
	private FormData formlngage0003;
	private FormService formService = new FormService();
	private String flag;
	
	public LnGageAction() {
		query = "";
	}
	/**
	 * ��ҳ��ѯ
	 * @return
	 * @throws Exception
	 */
	public String findByPage() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),ServletActionContext.getResponse());
		formlngage0001 = formService.getFormData("lngage0001");
		lnGage = new LnGage();
		getFormValue(formlngage0001);
		setObjValue(formlngage0001, lnGage);
		Ipage ipage = this.getIpage();
		lnGageList = (List) lnGageBo.findByPage(ipage, lnGage).getResult();
		return "list";
	}
	/**
	 * ��ҳ��ѯ����ѺѺƷ
	 * @return
	 * @throws Exception
	 */
	public String findlistBygageSts() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),ServletActionContext.getResponse());
		formlngage0003 = formService.getFormData("lngage0003");
		lnGage = new LnGage();
		getFormValue(formlngage0003);
		setObjValue(formlngage0003, lnGage);
		Ipage ipage = this.getIpage();
		lnGageList = (List) lnGageBo.findlistBygegeSts(ipage, lnGage).getResult();
		return "list";
	}
	/**
	 * pop��ѯ
	 * @return
	 * @throws Exception
	 */
	
	public String findByPageForPop() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formlngage0001 = formService.getFormData("lngage0001");
		lnGage = new LnGage();
		getFormValue(formlngage0001);
		setObjValue(formlngage0001, lnGage);
		lnGage.setBrNo(User.getBrno(this.getHttpRequest()));
		Ipage ipage = this.getIpage();
		lnGageList = (List) lnGageBo.findByPage(ipage, lnGage).getResult();		//��ȡ�ܵ�ͳ�ƶ��
		
		return "list";
	}
	/**
	 * ��ȡ����ҳ��
	 * @return
	 * @throws Exception
	 */
	public String input() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formlngage0002 = formService.getFormData("lngage0002");
		getObjValue(formlngage0002, lnGage);
		return "input";
	}
	
	/**
	 * �����������
	 * @return
	 * @throws Exception
	 */
	public String insert() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formlngage0002 = formService.getFormData("lngage0002");
		getFormValue(formlngage0002);
		lnGage = new LnGage();
		setObjValue(formlngage0002, lnGage);
		boolean val = lnGage.getGageBegdate()!=null&&!"".equals(lnGage.getGageBegdate())
				&&lnGage.getGageEnddate()!=null&&!"".equals(lnGage.getGageEnddate())
				&&Integer.parseInt(lnGage.getGageBegdate())>=Integer.parseInt(lnGage.getGageEnddate());
		if(val){
			this.addActionMessage("ѺƷ������δ����ѺƷ��ʼ�գ�<br>������¼�룡");
			return input();
		}
		lnGage.setTxDate(User.getSys_date(this.getHttpRequest()));
		lnGage.setOpNo(User.getLoginid(this.getHttpRequest()));
//		lnGage.setBrNo(User.getBrno(this.getHttpRequest()));
		lnGageBo.insert(lnGage);
		this.addActionMessage("����ɹ�");
		getObjValue(formlngage0002, lnGage);
		return "detail";
	}
	
	/**
	 * �������
	 * @return
	 * @throws Exception
	 */
	public String getDetail() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),ServletActionContext.getResponse());
		formlngage0002 = formService.getFormData("lngage0002");
		lnGage = new LnGage();
		lnGage.setAppId(appId);
		lnGage.setGageId(gageId);
		lnGage = lnGageBo.getById(lnGage);
		getObjValue(formlngage0002, lnGage);
		return "detail";
	}
	/**
	 * �޸ı������
	 * @return
	 * @throws Exception
	 */
	public String update() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formlngage0002 = formService.getFormData("lngage0002");
		getFormValue(formlngage0002);
		lnGage = new LnGage();
		setObjValue(formlngage0002, lnGage);
		boolean val = lnGage.getGageBegdate()!=null&&!"".equals(lnGage.getGageBegdate())
				&&lnGage.getGageEnddate()!=null&&!"".equals(lnGage.getGageEnddate())
				&&Integer.parseInt(lnGage.getGageBegdate())>=Integer.parseInt(lnGage.getGageEnddate());
		if(val){
			this.addActionMessage("ѺƷ������δ����ѺƷ��ʼ�գ�<br>������¼�룡");
		}else{
			lnGage.setUpDate(User.getSys_date(this.getHttpRequest()));
			lnGageBo.update(lnGage);
			this.addActionMessage("����ɹ�");
		}
		getObjValue(formlngage0002, lnGage);
		return "detail";
	}
	/**
	 * ����ѺƷ״̬Ϊ�ѽ�Ѻ
	 * @return
	 * @throws Exception
	 */
	public String updateSts() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		lnGage = new LnGage();
		lnGage.setGageId(gageId);
		lnGage.setGageOutdate(User.getSys_date(getHttpRequest()));
		lnGageBo.updateSts(lnGage);
		formlngage0003 = formService.getFormData("lngage0003");
		lnGage = new LnGage();
		Ipage ipage = this.getIpage();
		lnGageList = (List) lnGageBo.findlistBygegeSts(ipage, lnGage).getResult();
		return "list";
	}
	/**
	 * ҵ����ϸ��ѯѺƷ��������б�
	 * @return
	 * @throws Exception
	 */
	public String findLnDue() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		lnGage = new LnGage();
		LnDue lnDue = new LnDue();
		lnGage.setGageId(gageId);
		String a = lnGageBo.findAppIdByGageId(lnGage);
		lnDue.setAppId(a);
		Ipage ipage = this.getIpage();
		lnDueList = (List) lnDueBo.findByPage(ipage, lnDue).getResult();
		return "list";
	}
	/**
	 * ɾ������
	 * @return
	 * @throws Exception
	 */
	public String del() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formlngage0001 = formService.getFormData("lngage0001");
		lnGage = new LnGage();
		lnGage.setAppId(appId);
		lnGageBo.del(lnGage);
		this.addActionMessage("ɾ���ɹ�");
		lnGage = new LnGage();
		lnGage.setBrNo(User.getBrno(this.getHttpRequest()));
		Ipage ipage = this.getIpage();
		lnGageList = (List) lnGageBo.findByPage(ipage, lnGage).getResult();
		return "list";
	}

	
	/**
	 * ��ѯ����
	 * @return
	 * @throws Exception
	 */
	public String getById() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),ServletActionContext.getResponse());
		formlngage0002 = formService.getFormData("lngage0002");
		lnGage = new LnGage();
		lnGage.setAppId(appId);
		lnGage.setGageId(gageId);
		lnGage = lnGageBo.getById(lnGage);
		getObjValue(formlngage0002, lnGage);
		//���ַ���ҳ�棨ѺƷ��Ѻ��ѺƷ�Ǽǣ�
		if("3".equals(flag)){
			return "detail";
		}else{
			return "detailRead";
		}
		
	}
	/**
	 * ��ѯ����
	 * @return
	 * @throws Exception
	 */
	public String getById_Read() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),ServletActionContext.getResponse());
		formlngage0002 = formService.getFormData("lngage0002");
		lnGage = new LnGage();
		lnGage.setAppId(appId);
		lnGage.setGageId(gageId);
		lnGage = lnGageBo.getById(lnGage);
		getObjValue(formlngage0002, lnGage);
		return "detail_Read";
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
			String id18 = icu.getNewIDCard(gageIdno);
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
	 * �����������У��
	 * @return
	 * @throws Exception
	 */
	public void validateInsert(){
		 ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		 formlngage0002 = formService.getFormData("lngage0002");
		 getFormValue(formlngage0002);
		 validateFormData(formlngage0002);
		 lnGage = new LnGage();
		 setObjValue(formlngage0002, lnGage);
		 lnGage = lnGageBo.getById(lnGage);
		 if(lnGage!=null){   
				this.addActionError("��ѺƷID�Ѵ���!");
		 }
   	}
   
	/**
	 * �޸ı������У��
	 * @return
	 * @throws Exception
	 */
	public void validateUpdate(){
		 ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		 formlngage0002 = formService.getFormData("lngage0002");
		 getFormValue(formlngage0002);
		 validateFormData(formlngage0002);
  	}
	
	/**
     * ���ݿͻ�����ʾ���е�ѺƷ��Ϣ
     * @return
     * @throws Exception
     */
    public String listQuotaForCif() throws Exception {
    	ActionContext.initialize(ServletActionContext.getRequest(),
        		ServletActionContext.getResponse());
    	lnGage = new LnGage();
    	lnGage.setCifNo(cifNo);
    	Ipage ipage = this.getIpage();
    	lnGageList = (List) lnGageBo.findByPageQuotaForCif(ipage, lnGage).getResult();
    	return "list";
    }
    public String listQuotaForCif_Read() throws Exception {
    	ActionContext.initialize(ServletActionContext.getRequest(),
        		ServletActionContext.getResponse());
    	lnGage = new LnGage();
    	lnGage.setCifNo(cifNo);
    	Ipage ipage = this.getIpage();
    	lnGageList = (List) lnGageBo.findByPageQuotaForCif(ipage, lnGage).getResult();
    	return "list_Read";
    }
    
    /**
	    * ��������ID��ʾ���еĵ�ѺƷ��Ϣ
	    * @return
	    * @throws Exception
	    */
	   public String listQuotaForLn() throws Exception {
	   	ActionContext.initialize(ServletActionContext.getRequest(),
	       		ServletActionContext.getResponse());
	   	lnGage = new LnGage();
	   	lnGage.setAppId(appId);
	   	Ipage ipage = this.getIpage();
	   	lnGageList = (List) lnGageBo.findByPageQuotaForLn(ipage, lnGage).getResult();
	   	return "list";
	   }
	
	public LnGage getLnGage() {
		return lnGage;
	}
	public void setLnGage(LnGage  lnGage) {
		this.lnGage = lnGage;
	}
	public List<LnGage> getLnGageList() {
		return lnGageList;
	}
	public void setLnGageList(List<LnGage> lnGageList) {
		this.lnGageList = lnGageList;
	}
	public LnGageBo getLnGageBo() {
		return lnGageBo;
	}
	public void setLnGageBo(LnGageBo lnGageBo) {
		this.lnGageBo = lnGageBo;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public FormData getFormlngage0002() {
		return formlngage0002;
	}
	public void setFormlngage0002(FormData formlngage0002) {
		this.formlngage0002 = formlngage0002;
	}
	public FormData getFormlngage0001() {
		return formlngage0001;
	}
	public void setFormlngage0001(FormData formlngage0001) {
		this.formlngage0001 = formlngage0001;
	}
	public FormData getFormlngage0003() {
		return formlngage0003;
	}
	public void setFormlngage0003(FormData formlngage0003) {
		this.formlngage0003 = formlngage0003;
	}
	public void setAppId(String appId){
		this.appId = appId;
	}		
	public String getAppId(){
		return appId;
	}
	public String getCifNo() {
		return cifNo;
	}
	public void setCifNo(String cifNo) {
		this.cifNo = cifNo;
	}
	public String getGageIdno() {
		return gageIdno;
	}
	public void setGageIdno(String gageIdno) {
		this.gageIdno = gageIdno;
	}
	public String getRtMessage() {
		return rtMessage;
	}
	public void setRtMessage(String rtMessage) {
		this.rtMessage = rtMessage;
	}
	public String getGageId() {
		return gageId;
	}
	public void setGageId(String gageId) {
		this.gageId = gageId;
	}
	public LnDueBo getLnDueBo() {
		return lnDueBo;
	}
	public void setLnDueBo(LnDueBo lnDueBo) {
		this.lnDueBo = lnDueBo;
	}
	public List<LnDue> getLnDueList() {
		return lnDueList;
	}
	public void setLnDueList(List<LnDue> lnDueList) {
		this.lnDueList = lnDueList;
	}
	public String getBackSts() {
		return backSts;
	}
	public void setBackSts(String backSts) {
		this.backSts = backSts;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public String getCifName() {
		return cifName;
	}
	public void setCifName(String cifName) {
		this.cifName = cifName;
	}
	
}