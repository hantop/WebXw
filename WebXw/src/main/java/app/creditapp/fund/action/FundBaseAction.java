package  app.creditapp.fund.action;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import app.base.CreateKey;
import app.creditapp.fund.bo.FundPayPlanBo;
import app.creditapp.fund.entity.FundPayPlan;
import app.creditapp.aft.bo.AftAssetPoolBo;
import app.creditapp.aft.bo.AftPoolRelBo;
import app.creditapp.aft.entity.AftAssetPool;
import app.creditapp.aft.entity.AftPoolRel;
import app.creditapp.fund.bo.FundBaseBo;
import app.creditapp.fund.bo.FundDetailBo;
import app.creditapp.fund.bo.FundRepayPlanBo;
import app.creditapp.fund.entity.FundBase;
import app.creditapp.sys.bo.DailyEventBo;
import app.util.User;
import app.util.toolkit.Ipage;



import com.core.domain.screen.FormData;
import com.core.service.screen.FormService;
import com.core.struts.ActionContext;
import com.core.struts.BaseFormBean;

/**
 * Title: FundBaseAction.java
 * Description:
 **/
public class FundBaseAction extends BaseFormBean {

	//ҳ�洫ֵ
	private FundBase fundBase;
	private List<FundBase> fundBaseList;	
	private FundPayPlan fundPayPlan;
	
	//ע��FundBaseBo
	private FundBaseBo fundBaseBo;
	//ע��AftAssetPoolBo
	private AftAssetPoolBo aftAssetPoolBo;
	//ע��AftPoolRelBo
	private AftPoolRelBo aftPoolRelBo;	
	private FundPayPlanBo fundPayPlanBo;
	private DailyEventBo dailyEventBo;
	

	private String query;
	private String fundNo; 
	private String projNo;
	private String fdType;
	private String reDeem1;
	private String packetSts;
	private String fdState;
	private String formSts;
	private String projName;
	private String fundName;
	private FormData formfund0001;
	private FormData formfund0002;
	private FormData formfund0005;
	private FormService formService = new FormService();
	private String syncfundNo;
	private String syncprojNo;
	//����
	private FundRepayPlanBo fundRepayPlanBo;
	private FundDetailBo fundDetailBo;
	private List tabList;
	public FundBaseAction() {
		query = "";
	}
	/**
	 * ��ҳ��ѯ
	 * @return
	 * @throws Exception
	 */
	public String findByPage() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),ServletActionContext.getResponse());
		formfund0001 = formService.getFormData("fund0001");
		formfund0005 = formService.getFormData("fund0005");
		fundBase = new FundBase();
		if("1".equals(formSts)){
			getFormValue(formfund0005);
			setObjValue(formfund0005, fundBase);
		}else{
			getFormValue(formfund0001);
			setObjValue(formfund0001, fundBase);
		}
//		fundBase.setLoginid(User.getLoginIdByAuth(this.getHttpRequest())); // ��session�л�ȡȨ��
		fundBase.setOpNo(User.getLoginIdByAuth(this.getHttpRequest()));
		Ipage ipage = this.getIpage();
		fundBaseList = (List) fundBaseBo.findByPage(ipage, fundBase).getResult();
		return "list";
	}
	/**
	 * ��ȡ����ҳ��
	 * @return
	 * @throws Exception
	 */
	public String input() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formfund0002 = formService.getFormData("fund0002");
		fundBase = new FundBase();
		fundBase.setOpNo(User.getLoginid(this.getHttpRequest()));
		fundBase.setTxDate(User.getSys_date(this.getHttpRequest()));
		getObjValue(formfund0002, fundBase);
		this.changeFormProperty(formfund0002, "opNo", "readonly", "1");//1��ֻ����0�ǿɱ༭
		this.changeFormProperty(formfund0002, "txDate", "readonly", "1");//1��ֻ����0�ǿɱ༭
		this.changeFormProperty(formfund0002, "upOpno", "fieldType", 99);//99����ʾ�ֶ�
		this.changeFormProperty(formfund0002, "upDate", "fieldType", 99);//99����ʾ�ֶ�
		return "input";
	}
	
	/**
	 * �����������
	 * @return
	 * @throws Exception
	 */
	public String insert() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formfund0002 = formService.getFormData("fund0002");
		getFormValue(formfund0002);
		fundBase = new FundBase();
		setObjValue(formfund0002, fundBase);
		fundBase.setFdAmt(fundBase.getFdInitialAmt());
		fundBase.setCashBal(fundBase.getFdInitialAmt());
		fundBase.setTranSts("0");
		fundBase.setPacketSts("0");
		fundBaseBo.insert(fundBase);	
		//��������ƻ�
		repayplan_insert(fundBase);
		this.addActionMessage("�����ɹ�");
		query="query";
		getObjValue(formfund0002, fundBase);
		return "detail";
	}
	
	
	/**
	 * �޸ı������
	 * @return
	 * @throws Exception
	 */
	public String update() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formfund0002 = formService.getFormData("fund0002");
		getFormValue(formfund0002);
		fundBase = new FundBase();
		setObjValue(formfund0002, fundBase);
		HttpServletRequest request = ServletActionContext.getRequest();
		BigDecimal FinanceRate = new BigDecimal(request.getParameter("financeRate"));
		BigDecimal parm = new BigDecimal(Integer.toString(100));
		fundBase.setFinanceRate(FinanceRate.divide(parm).floatValue());
		String reDeem1 = request.getParameter("reDeem1");
		fundBase.setUpOpno(User.getLoginid(this.getHttpRequest()));
		fundBase.setUpDate(User.getSys_date(this.getHttpRequest()));
		//�ж��ʽ���Ч/ʧЧ״̬
		 //�鿴�Ҹ��ƻ��Ƿ�����
		fundPayPlan = new FundPayPlan();
		fundPayPlan.setFundNo(fundNo);
		int count = fundPayPlanBo.findBycount(fundPayPlan);
		if(count>0){
			fundBase.setFdFlag("01");
			this.addActionMessage("�޸ĳɹ�");
		}else{
			if("01".equals(fundBase.getFdType()) ){
			}else{
			    this.changeFormProperty(formfund0002, "financeRate", "readonly", "1");//99����ʾ�ֶ�
			    this.changeFormProperty(formfund0002, "repayType", "readonly", "1");//99����ʾ�ֶ�
			   //this.changeFormProperty(formfund0002, "repayDay", "fieldType", 99);//99����ʾ�ֶ�
			    this.changeFormProperty(formfund0002, "repayDay", "readonly", "1");//99����ʾ�ֶ�
			}
			if(fundBase.getUpOpno() == null ){
				this.changeFormProperty(formfund0002, "upOpno", "fieldType", 99);//99����ʾ�ֶ�	
				this.changeFormProperty(formfund0002, "upDate", "fieldType", 99);//99����ʾ�ֶ�	
			}
			this.changeFormProperty(formfund0002, "opNo", "readonly", "1");//1��ֻ����0�ǿɱ༭
			this.changeFormProperty(formfund0002, "txDate", "readonly", "1");//1��ֻ����0�ǿɱ༭
			this.changeFormProperty(formfund0002, "upOpno", "readonly", "1");//1��ֻ����0�ǿɱ༭
			this.changeFormProperty(formfund0002, "upDate", "readonly", "1");//1��ֻ����0�ǿɱ༭
//  2017/08/28  ʷ־ΰ���ʽ�̨����������޸ı���ʱ��������ʾ������Ϣ��Ŀǰδ�����к�Ӱ�죬��ע��			
//			this.addActionMessage("���䷽���еġ��Ҹ����ڡ��ֶβ����ڣ��ʽ�δ��Ч��");
		}
		fundBaseBo.update(fundBase);
		//��������ƻ�
		repayplan_insert(fundBase);
		//�ж��Ƿ��޸��������־
		if(reDeem1!="01" && "01".equals(fundBase.getReDeem())){
		   	//��������
			fundBaseBo.reDeem(fundBase);
		}else{
		}
		//��ȡ��������
		fundBase = fundBaseBo.getById(fundBase);
		//this.addActionMessage("�޸ĳɹ�");
		getObjValue(formfund0002, fundBase);
		return "detail";
	}
	/**
	 * �޸�ĳ���ֶα������
	 * @return
	 * @throws Exception
	 */
	public String updateByfield() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formfund0001 = formService.getFormData("fund0001");
		
		fundBase = new FundBase();
		fundBase.setFundNo(fundNo);
		fundBase = fundBaseBo.getById(fundBase);
		if(!"".equals(packetSts) && fdState==null){
			fundBase.setPacketSts("1");	
		}
		else if(packetSts==null && !"".equals(fdState)){
			// ת�ã�ע���ʲ���
			turnAsset(fundNo);
			
			fundBase.setFdState("03");	
			fundBaseBo.updateBytransts(fundBase);	
		}
		fundBaseBo.update(fundBase);

		//��ȡ��������		
		FundBase fundBase1 = new FundBase();
		Ipage ipage = this.getIpage();
		getFormValue(formfund0001);
		setObjValue(formfund0001, fundBase1);
		fundBase1.setFundNo("");
		getObjValue(formfund0001, fundBase1);
		fundBaseList = (List) fundBaseBo.findByPage(ipage, fundBase1).getResult();
		return "list";
	}
	
	/**
	 * ת�ã�ע���ʲ���
	 * @return
	 * @throws Exception
	 */
	public void turnAsset(String fundNo) throws Exception {
		fundBase = new FundBase();
		fundBase.setFundNo(fundNo);
		fundBase = fundBaseBo.getById(fundBase);
		//ת�� �½��ʲ�������
		AftAssetPool aftAssetPool = new AftAssetPool();
		String poolId = CreateKey.getPoolId();
		String date = User.getSys_date(this.getHttpRequest());
		String name = fundBase.getFundName()+"_"+date+"�ʲ���";
		aftAssetPool.setPoolName(name);
		aftAssetPool.setPoolDesc(name);
		aftAssetPool.setBegDate(date);
		aftAssetPool.setTxDate(date);
		aftAssetPool.setOpNo(User.getLoginid(this.getHttpRequest()));
		aftAssetPool.setPoolSts("02");
		aftAssetPool.setPoolId(poolId);
		aftAssetPoolBo.insert(aftAssetPool);
		//ͨ��fundNo��ln_due�е�������������aft_pool_rel���� 
		AftPoolRel aftPoolRel = new AftPoolRel();
		aftPoolRel.setPoolId(poolId);
		aftPoolRel.setOpNo(User.getLoginid(this.getHttpRequest()));
		aftPoolRel.setPoolSts("02");
		aftPoolRel.setFundNo(fundNo);
		aftPoolRelBo.insertList(aftPoolRel);
		//������ �ؽ�ݹ��������ʽ�ؽ������ܶ�
		aftAssetPool = new AftAssetPool();
		aftAssetPool.setPoolId(poolId);
		aftAssetPoolBo.updateTotal(aftAssetPool);			
				
	}		
	
	/**
	 * ɾ������
	 * @return
	 * @throws Exception
	 */
	public String del() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formfund0001 = formService.getFormData("fund0001");
		fundBase = new FundBase();
		fundBase.setFundNo(fundNo);
		fundBaseBo.del(fundBase);
		this.addActionMessage("ɾ���ɹ�");
		fundBase = new FundBase();
		Ipage ipage = this.getIpage();
		fundBaseList = (List) fundBaseBo.findByPage(ipage, fundBase).getResult();
		return "list";
	}

	/**
	 * �ʽ���Ϣtableͷ
	 * @return
	 */
	public String getDetailTop() {
		ActionContext.initialize(ServletActionContext.getRequest(), 
				ServletActionContext.getResponse());
		formfund0001 = formService.getFormData("fund0001");
		fundBase = new FundBase();
		fundBase.setFundNo(fundNo);
		fundBase = fundBaseBo.getById(fundBase);
		getObjValue(formfund0001, fundBase);
		query = "query";
		return "top";
	}
	/**
	 * �鿴�ʽ���Ϣ
	 * @return
	 */
	public String getAllDetail() {
		ActionContext.initialize(ServletActionContext.getRequest(), 
				ServletActionContext.getResponse());
		fundBase = new FundBase();
		fundBase.setFundNo(fundNo);
		fundBase.setFdType(fdType);		//cifPers.setEcif_no(ecif_no);
		fundBase = fundBaseBo.getById(fundBase);
		//cifType = cifPersInf.getCifType();
		//if_agri = cifPers.getIf_agri();
		return "all";
	}
	/**
	 * �鿴�ʽ���Ϣ
	 * @return
	 */
	public String getAllDetailForRead() {
		ActionContext.initialize(ServletActionContext.getRequest(), 
				ServletActionContext.getResponse());
		fundBase = new FundBase();
		fundBase.setFundNo(fundNo);
		//cifPers.setEcif_no(ecif_no);
		fundBase = fundBaseBo.getById(fundBase);
		//cifType = cifPersInf.getCifType();
		//if_agri = cifPers.getIf_agri();
		return "all";
	}			
	/**
	 * ��ѯ����
	 * @return
	 * @throws Exception
	 */
	public String getById() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),ServletActionContext.getResponse());
		formfund0002 = formService.getFormData("fund0002");
	    //����������޸�ʱ�����水ť����ʾ
		if(("query1").equals(query)){
			query="query";
		}
		fundBase = new FundBase();
		fundBase.setFundNo(fundNo);
		fundBase = fundBaseBo.getById(fundBase);
		getObjValue(formfund0002, fundBase);
		reDeem1 = fundBase.getReDeem();

		if("01".equals(fundBase.getFdType()) ){
		}else{
		    this.changeFormProperty(formfund0002, "financeRate", "readonly", "1");//99����ʾ�ֶ�
		    this.changeFormProperty(formfund0002, "repayType", "readonly", "1");//99����ʾ�ֶ�
		   //this.changeFormProperty(formfund0002, "repayDay", "fieldType", 99);//99����ʾ�ֶ�
		    this.changeFormProperty(formfund0002, "repayDay", "readonly", "1");//99����ʾ�ֶ�
		}
		if(fundBase.getUpOpno() == null ){
			this.changeFormProperty(formfund0002, "upOpno", "fieldType", 99);//99����ʾ�ֶ�	
			this.changeFormProperty(formfund0002, "upDate", "fieldType", 99);//99����ʾ�ֶ�	
		}
		this.changeFormProperty(formfund0002, "opNo", "readonly", "1");//1��ֻ����0�ǿɱ༭
		this.changeFormProperty(formfund0002, "txDate", "readonly", "1");//1��ֻ����0�ǿɱ༭
		this.changeFormProperty(formfund0002, "upOpno", "readonly", "1");//1��ֻ����0�ǿɱ༭
		this.changeFormProperty(formfund0002, "upDate", "readonly", "1");//1��ֻ����0�ǿɱ༭

		return "detail";
	}

	/**
	 * @���� DHCC-ZLC
	 * @���� 2016-6-29
	 * @����˵�����ʽ�����䶯�������Ҹ��ƻ����ݲ���
	 * @���ز��� String
	 */
	public String repayplan_insert(FundBase fundBase) throws Exception {

		// �ж��Ƿ���������ƻ������������㷽ʽ��Ϊ�գ��������ʲ�Ϊ�գ���������Ϊ�գ�ͬʱֻ�����ȼ��ʽ��������ƻ�
		if("01".equals(fundBase.getFdType()) && 
				!(fundBase.getRepayType() == null || "".equals(fundBase.getRepayType())) && 
				!(fundBase.getFinanceRate()==0) && 
				!(fundBase.getYearDays() == 0) ){
			fundRepayPlanBo.auto_insert(fundBase);
		}
		return "detail";
	}
	
	/**
	 * @���� DHCC-ZBW
	 * @���� 2016-7-8
	 * @����˵����tabҳ��ʾ
	 * @���ز��� String
	 */
	public String getTab() {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		tabList = new ArrayList();
		String[] tab = null;
		
		tab = new String[2];
		tab[0] = "�����ſ�";
		tab[1] = "creditapp/fund/FundBase_Echarts.jsp?fundNo="+fundNo+"&query="+query;
//		tab[1] = "FundBaseAction_echarts.action?fundNo="+fundNo+"&query="+query;
		tabList.add(tab);
		
		tab = new String[2];
		tab[0] = "������Ϣ";
		tab[1] = "FundBaseAction_getById.action?fundNo="+fundNo+"&query="+query;
		tabList.add(tab);
		
		tab = new String[2];
		tab[0] = "�ʽ���ϸ";
		tab[1] = "FundDetailAction_findByPage.action?fundNo="+fundNo+"&projNo="+projNo+"&fdType="+fdType+"&query="+query;
		tabList.add(tab);
		
		tab = new String[2];
		tab[0] = "���䷽��";
		tab[1] = "FundSplitAction_findByPage.action?fundNo="+fundNo+"&query="+query;
		tabList.add(tab);
		
		tab = new String[2];
		tab[0] = "�Ҹ��ƻ�";
		tab[1] = "FundPayPlanAction_findByPageForAmt.action?fundNo="+fundNo+"&query="+query;
		tabList.add(tab);
		
		tab = new String[2];
		tab[0] = "����ƻ�";
		tab[1] = "FundRepayPlanAction_findByPage.action?fundNo="+fundNo+"&query="+query;
		tabList.add(tab);
		
		tab = new String[2];
		tab[0] = "�ֽ����";
		tab[1] = "FundCashRegAction_findByPage.action?fundNo="+fundNo+"&query="+query;
		tabList.add(tab);
		
		tab = new String[2];
		tab[0] = "ծȨ����";
		tab[1] = "FundRightDetailAction_findByPage.action?fundNo="+fundNo+"&query="+query+"&projNo="+projNo;
		tabList.add(tab);
		
		return "tab";
	}
	public String getTabForEcharts() throws Exception{
		ActionContext.initialize(ServletActionContext.getRequest(),
				ServletActionContext.getResponse());
		tabList = new ArrayList();
		String[] tab = null;
		
		tab = new String[2];
		tab[0] = "�ʽ��ģ";
		tab[1] = "RptFundDailyAction_echarts.action?fundNo=" + fundNo+ "&query="+ query;
		tabList.add(tab);
		
		/*tab = new String[2];
		tab[0] = "���䷽����ģ";
		tab[1] = "FundSplitAction_echarts.action?fundNo=" + fundNo+ "&query="+ query;
		tabList.add(tab);*/
		
		return "tab";
	}
	/**
	 * @���� DHCC-ZLC
	 * @���� 2016-8-1
	 * @����˵����
	 * @���ز��� String
	 */
	public String getTab_Update() {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		tabList = new ArrayList();
		String[] tab = null;
		tab = new String[2];
		tab[0] = "������Ϣ";
		tab[1] = "FundBaseAction_getById.action?fundNo="+fundNo+"&query="+query;
		tabList.add(tab);
		
		tab = new String[2];
		tab[0] = "�ʽ���ϸ";
		tab[1] = "FundDetailAction_findByPage.action?fundNo="+fundNo+"&projNo="+projNo+"&fdType="+fdType+"&query="+query;
		tabList.add(tab);
		

		return "tab";
	}	
	
	/**
	 * @���� DHCC-ZLC
	 * @���� 2016-6-29
	 * @����˵����ͬ������Ϣ
	 * @���ز��� String
	 */
	public String sync() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),ServletActionContext.getResponse());
		formfund0001 = formService.getFormData("fund0001");
		formfund0005 = formService.getFormData("fund0005");
		fundBase = new FundBase();
		if("1".equals(formSts)){
			getFormValue(formfund0005);
			setObjValue(formfund0005, fundBase);
		}else{
			getFormValue(formfund0001);
			setObjValue(formfund0001, fundBase);
		}
				
		fundBase.setOpNo(User.getLoginid(this.getHttpRequest()));
		fundBase.setTxDate(User.getSys_date(this.getHttpRequest()));
		Ipage ipage = this.getIpage();
		fundBaseList = (List) fundBaseBo.sync(ipage,fundBase).getResult();	
		this.addActionMessage("��Ŀ�ʽ�ͬ���ɹ�");
		
		//�ʽ𼴽�����,��daily_event���������,����-wmj
//		int s=fundBaseBo.getCountunmatcheds(fundBase);
//		DailyEvent dailyEvent=new DailyEvent();
//		if(s>0){		
//			dailyEventBo.insertadd(dailyEvent);			
//			try {
//		SendMessageMain.sendMessage("������ʾ", "�ʽ𼴽�����",PasSubTypeEntity.RewFundMessage);
//			} catch (Exception e) {
//				throw new ServiceException(e.getMessage());
//			}
//		}
		
		//�ʽ����㵽������
//		int m=fundBaseBo.getFundRepayRemind(fundBase);
//		DailyEvent dailyEventRepay=new DailyEvent();
//		if(m>0){		
//			dailyEventBo.fundpayRemind(dailyEventRepay);			
//			try {
//		SendMessageMain.sendMessage("������ʾ", "�ʽ����㼴������",PasSubTypeEntity.RewFundMessage);
//			} catch (Exception e) {
//				throw new ServiceException(e.getMessage());
//			}
//		}
		
		return "list";
	}
	/**
	 * �����ʽ�ͬ��
	 * @return
	 * @throws Exception
	 */
	public String syncSingle() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),ServletActionContext.getResponse());
		formfund0001 = formService.getFormData("fund0001");
		fundBase = new FundBase();
		fundBase.setFundNo(syncfundNo);
		fundBase.setProjNo(syncprojNo);
		fundBase.setOpNo(User.getLoginid(this.getHttpRequest()));
		fundBase.setTxDate(User.getSys_date(this.getHttpRequest()));
		fundBaseBo.syncSingle(fundBase);
		this.addActionMessage("�ʽ�ͬ���ɹ�");
		fundBase = new FundBase();
		getFormValue(formfund0001);
		setObjValue(formfund0001, fundBase);
		Ipage ipage = this.getIpage();
		fundBaseList = (List)fundBaseBo.findByPage(ipage, fundBase).getResult();
		return "syncSingle";
	}

	public DailyEventBo getDailyEventBo() {
		return dailyEventBo;
	}
	public void setDailyEventBo(DailyEventBo dailyEventBo) {
		this.dailyEventBo = dailyEventBo;
	}
	/**
	 * �����������У��
	 * @return
	 * @throws Exception
	 */
	public void validateInsert(){
		 ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		 formfund0002 = formService.getFormData("fund0002");
		 getFormValue(formfund0002);
		 validateFormData(formfund0002);
   	}
   
	/**
	 * �޸ı������У��
	 * @return
	 * @throws Exception
	 */
	public void validateUpdate(){
		 ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		 formfund0002 = formService.getFormData("fund0002");
		 getFormValue(formfund0002);
		 validateFormData(formfund0002);
  	}
	public FundBase getFundBase() {
		return fundBase;
	}
	public void setFundBase(FundBase  fundBase) {
		this.fundBase = fundBase;
	}
	public List<FundBase> getFundBaseList() {
		return fundBaseList;
	}
	public void setFundBaseList(List<FundBase> fundBaseList) {
		this.fundBaseList = fundBaseList;
	}
	public FundBaseBo getFundBaseBo() {
		return fundBaseBo;
	}
	public void setFundBaseBo(FundBaseBo fundBaseBo) {
		this.fundBaseBo = fundBaseBo;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public FormData getFormfund0002() {
		return formfund0002;
	}
	public void setFormfund0002(FormData formfund0002) {
		this.formfund0002 = formfund0002;
	}
	public FormData getFormfund0001() {
		return formfund0001;
	}
	public void setFormfund0001(FormData formfund0001) {
		this.formfund0001 = formfund0001;
	}
	public void setFundNo(String fundNo){
		this.fundNo = fundNo;
	}		
	public String getFundNo(){
		return fundNo;
	}
	//����
	public FundRepayPlanBo getFundRepayPlanBo() {
		return fundRepayPlanBo;
	}
	public void setFundRepayPlanBo(FundRepayPlanBo fundRepayPlanBo) {
		this.fundRepayPlanBo = fundRepayPlanBo;
	}
	public List getTabList() {
		return tabList;
	}
	public void setTabList(List tabList) {
		this.tabList = tabList;
	}
	public String getProjNo() {
		return projNo;
	}
	public void setProjNo(String projNo) {
		this.projNo = projNo;
	}
	public String getReDeem1() {
		return reDeem1;
	}
	public void setReDeem1(String reDeem1) {
		this.reDeem1 = reDeem1;
	}
	
	public FundDetailBo getFundDetailBo() {
		return fundDetailBo;
	}
	public void setFundBaseBo(FundDetailBo fundDetailBo) {
		this.fundDetailBo = fundDetailBo;
	}
	public String getPacketSts() {
		return packetSts;
	}
	public void setPacketSts(String packetSts) {
		this.packetSts = packetSts;
	}
	public String getFdState() {
		return fdState;
	}
	public void setFdState(String fdState) {
		this.fdState = fdState;
	}
	public String getFdType() {
		return fdType;
	}
	public void setFdType(String fdType) {
		this.fdType = fdType;
	}
	public void setFundDetailBo(FundDetailBo fundDetailBo) {
		this.fundDetailBo = fundDetailBo;
	}
	public AftAssetPoolBo getAftAssetPoolBo() {
		return aftAssetPoolBo;
	}
	public void setAftAssetPoolBo(AftAssetPoolBo aftAssetPoolBo) {
		this.aftAssetPoolBo = aftAssetPoolBo;
	}
	public AftPoolRelBo getAftPoolRelBo() {
		return aftPoolRelBo;
	}
	public void setAftPoolRelBo(AftPoolRelBo aftPoolRelBo) {
		this.aftPoolRelBo = aftPoolRelBo;
	}
	/**
	 * @return the fundPayPlan
	 */
	public FundPayPlan getFundPayPlan() {
		return fundPayPlan;
	}
	/**
	 * @param fundPayPlan the fundPayPlan to set
	 */
	public void setFundPayPlan(FundPayPlan fundPayPlan) {
		this.fundPayPlan = fundPayPlan;
	}
	/**
	 * @return the fundPayPlanBo
	 */
	public FundPayPlanBo getFundPayPlanBo() {
		return fundPayPlanBo;
	}
	/**
	 * @param fundPayPlanBo the fundPayPlanBo to set
	 */
	public void setFundPayPlanBo(FundPayPlanBo fundPayPlanBo) {
		this.fundPayPlanBo = fundPayPlanBo;
	}
	public String getFormSts() {
		return formSts;
	}
	public void setFormSts(String formSts) {
		this.formSts = formSts;
	}
	public FormData getFormfund0005() {
		return formfund0005;
	}
	public void setFormfund0005(FormData formfund0005) {
		this.formfund0005 = formfund0005;
	}
	public String getProjName() {
		return projName;
	}
	public void setProjName(String projName) {
		this.projName = projName;
	}
	public String getFundName() {
		return fundName;
	}
	public void setFundName(String fundName) {
		this.fundName = fundName;
	}
	/**
	 * @return the syncfundNo
	 */
	public String getSyncfundNo() {
		return syncfundNo;
	}
	/**
	 * @param syncfundNo the syncfundNo to set
	 */
	public void setSyncfundNo(String syncfundNo) {
		this.syncfundNo = syncfundNo;
	}
	/**
	 * @return the syncprojNo
	 */
	public String getSyncprojNo() {
		return syncprojNo;
	}
	/**
	 * @param syncprojNo the syncprojNo to set
	 */
	public void setSyncprojNo(String syncprojNo) {
		this.syncprojNo = syncprojNo;
	}
	
}