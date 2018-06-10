package  app.creditapp.corp.action;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.core.domain.screen.FormData;
import com.core.service.screen.FormService;
import com.core.struts.ActionContext;
import com.core.struts.BaseFormBean;

import app.creditapp.bat.bo.RptPrdtDailyBo;
import app.creditapp.bat.entity.RptPrdtDaily;
import app.creditapp.corp.bo.CorpAcctBo;
import app.creditapp.corp.bo.CorpBaseBo;
import app.creditapp.corp.bo.CorpParmBo;
import app.creditapp.corp.bo.RptCorpAreaBo;
import app.creditapp.corp.bo.RptCorpDailyBo;
import app.creditapp.corp.bo.RptCorpPrdtBo;
import app.creditapp.corp.entity.CorpAcct;
import app.creditapp.corp.entity.CorpBase;
import app.creditapp.corp.entity.CorpParm;
import app.creditapp.corp.entity.RptCorpArea;
import app.creditapp.corp.entity.RptCorpDaily;
import app.creditapp.corp.entity.RptCorpPrdt;
import app.creditapp.corp.entity.RptParams;
import app.creditapp.pact.bo.LnPactBo;
import app.creditapp.pact.entity.LnPact;
import app.util.User;
import app.util.toolkit.Ipage;

/**
 * Title: CorpBaseAction.java
 * Description:
 **/
public class CorpBaseAction extends BaseFormBean {

	//ҳ�洫ֵ
	private CorpBase corpBase;
	private LnPact lnPact;
	private List<CorpBase> corpBaseList;

	//ע��CorpBaseBo
	private CorpBaseBo corpBaseBo;
	private CorpParmBo corpParmBo;
	private CorpAcctBo corpAcctBo;
	private LnPactBo lnPactBo;

	private String query;
	private String brNo;	
	private String appId;
	private String projNo;
	private String lnType;
	private String backSts;
	private String brName;
	private String brSts;
	
	
	private List tabList;
	
	private RptCorpDailyBo rptCorpDailyBo;
	private RptCorpAreaBo rptCorpAreaBo;
	private RptCorpPrdtBo rptCorpPrdtBo;
	private RptPrdtDailyBo rptPrdtDailyBo;
	private RptParams rptParams;
	
	private FormData formcoop0001;
	private FormData formcoop0002;
	private FormData formcoop0015;
	private FormData formcoop0055;
	
	
	
	private FormService formService = new FormService();
	
	public CorpBaseAction() {
		query = "";
	}
	/**
	 * ��ҳ��ѯ
	 * @return
	 * @throws Exception
	 */
	public String findByPage() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),ServletActionContext.getResponse());
		formcoop0001 = formService.getFormData("coop0001");
		corpBase = new CorpBase();
		corpBase.setBrNo(User.getBrno(ServletActionContext.getRequest()));
		getFormValue(formcoop0001);
		setObjValue(formcoop0001, corpBase);
		corpBase.setLoginid(User.getLoginIdByAuth(this.getHttpRequest()));
		Ipage ipage = this.getIpage();
		corpBaseList = (List) corpBaseBo.findByPage(ipage, corpBase).getResult();
		return "list";
	}
	
	//�ӿ�Ȩ������
	public String findByPageforSysWs() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),ServletActionContext.getResponse());
		formcoop0001 = formService.getFormData("coop0001");
		corpBase = new CorpBase();
		corpBase.setBrNo(User.getBrno(ServletActionContext.getRequest()));
		getFormValue(formcoop0001);
		setObjValue(formcoop0001, corpBase);
		Ipage ipage = this.getIpage();
		corpBaseList = (List) corpBaseBo.findByPage(ipage, corpBase).getResult();
		return "list";
	}
	
	/**
	 * ��ȡ����ҳ��
	 * @return
	 * @throws Exception
	 */
	public String input() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formcoop0002 = formService.getFormData("coop0002");
		getFormValue(formcoop0002);
		corpBase = new CorpBase();
		corpBase.setBrSts("00");
		getObjValue(formcoop0002, corpBase);
		return "input";
	}
	
	/**
	 * �����������
	 * @return
	 * @throws Exception
	 */
	public String insert() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formcoop0002 = formService.getFormData("coop0002");
		getFormValue(formcoop0002);
		corpBase = new CorpBase();
		setObjValue(formcoop0002, corpBase);
		corpBase.setDeptNo(User.getBrno(ServletActionContext.getRequest()));//�Ǽǲ���
		corpBase.setOpNo(User.getLoginid(ServletActionContext.getRequest()));//����Ա
		corpBase.setTxDate(User.getSys_date(ServletActionContext.getRequest()));//�Ǽ�����
		//corpAcct.setUpDate(User.getSys_date(ServletActionContext.getRequest()));//�޸�����
		//corpAcct.setUpOpno(User.getLoginid(ServletActionContext.getRequest()));//�޸���Ա
		corpBaseBo.insert(corpBase);
		corpBase.setSts("1");
		getObjValue(formcoop0002, corpBase);
		this.addActionMessage("�����ɹ�!<br>���������в�¼�ú���������������Ϣ����ϵ����Ϣ���˻���Ϣ");
		return "detail";
	}
	
	// ����/ֹͣ �ú�������
	public String valiBr() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formcoop0001 = formService.getFormData("coop0001");
		//ֹͣ״̬ ��Ϊ ����״̬
		if("00".equals(brSts)){
			//�ú��������ŵ�������Ϣ���и��µ�ʱ���жϸú��������߱�����Ϣ�Ƿ��������������жϴ˺����������ܷ��������
			int count = corpBaseBo.getAllInf(brNo);
			//����3 ������� ��ʾ���е���Ϣ�Ѿ���д����������������� �Ϳ��Խ�������
			if(count == 3){
				CorpBase corpBase = new CorpBase();
				corpBase.setBrNo(brNo);
				corpBase = corpBaseBo.getById(corpBase);
				//���ú���������״̬Ϊ ���� ״̬�����и������ ����������
				corpBase.setBrSts("01");
				corpBaseBo.update(corpBase);
			}else{
		        this.addActionError("���� ���� �м�� ������Ϣ����ϵ����Ϣ���˻���Ϣ�Ƿ���д������");
			}
		}else{
		//����״̬  ��Ϊ ͣ��״̬
			CorpBase corpBase = new CorpBase();
			corpBase.setBrNo(brNo);
			corpBase = corpBaseBo.getById(corpBase);
			//���ú���������״̬Ϊ ���� ״̬�����и������ ����������
			corpBase.setBrSts("00");
			corpBaseBo.update(corpBase);	
		}
		corpBase = new CorpBase();
		getFormValue(formcoop0001);
		setObjValue(formcoop0001, corpBase);
		if(corpBase!=null && !"".equals(corpBase)){
			corpBase = new CorpBase();
			getObjValue(formcoop0001, corpBase);
		}
		Ipage ipage = this.getIpage();
		corpBaseList = (List) corpBaseBo.findByPage(ipage, corpBase).getResult();
		return "list";
	}
	
	
	/**
	 * �޸ı������
	 * @return
	 * @throws Exception
	 */
	public String update() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formcoop0002 = formService.getFormData("coop0002");
		getFormValue(formcoop0002);
		corpBase = new CorpBase();
		setObjValue(formcoop0002, corpBase);
		//corpBase.setDeptNo(User.getBrno(ServletActionContext.getRequest()));//�Ǽǲ���
		//corpBase.setOpNo(User.getLoginid(ServletActionContext.getRequest()));//����Ա
		//corpBase.setTxDate(User.getSys_date(ServletActionContext.getRequest()));//�Ǽ�����
		corpBase.setUpDate(User.getSys_date(ServletActionContext.getRequest()));//�޸�����
		corpBase.setUpOpno(User.getLoginid(ServletActionContext.getRequest()));//�޸���Ա
		corpBaseBo.update(corpBase);
		getObjValue(formcoop0002, corpBase);
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
		formcoop0001 = formService.getFormData("coop0001");
		corpBase = new CorpBase();
		corpBase.setBrNo(brNo);
		CorpParm corpParm = new CorpParm();
		corpParm.setBrNo(brNo);
		corpParmBo.delForBase(corpParm);
		CorpAcct corpAcct = new CorpAcct();
		corpAcct.setBrNo(brNo);
		corpAcctBo.delForBase(corpAcct);
		corpBaseBo.del(corpBase);
		this.addActionMessage("ɾ���ɹ�");
		corpBase = new CorpBase();
		corpBase.setBrNo(User.getBrno(ServletActionContext.getRequest()));
		Ipage ipage = this.getIpage();
		corpBaseList = (List) corpBaseBo.findByPage(ipage, corpBase).getResult();
		return "list";
	}
	
	public String delForCorp() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formcoop0001 = formService.getFormData("coop0001");
		corpBase = new CorpBase();
		corpBase.setBrNo(brNo);
		corpBaseBo.del(corpBase);
		this.addActionMessage("ɾ���ɹ�");
		corpBase = new CorpBase();
		corpBase.setBrNo(brNo);
		Ipage ipage = this.getIpage();
		corpBaseList = (List) corpBaseBo.findByPage(ipage, corpBase).getResult();
		return "list";
	}
	/**
	 * ��ѯ����
	 * @return
	 * @throws Exception
	 */
	public String getById() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),ServletActionContext.getResponse());
		formcoop0002 = formService.getFormData("coop0002");
		corpBase = new CorpBase();
		corpBase.setBrNo(brNo);
		corpBase = corpBaseBo.getById(corpBase);
		getObjValue(formcoop0002, corpBase);
		this.changeFormProperty(formcoop0002, "brNo", "readonly", "1");
		return "detail";
	}
	public String getByIdForBrNo() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),ServletActionContext.getResponse());
		formcoop0002 = formService.getFormData("coop0002");
		corpBase = new CorpBase();
		lnPact = new LnPact();
		lnPact.setAppId(appId);
		lnPact = lnPactBo.getByIdForAppId(lnPact);
		corpBase.setBrNo(lnPact.getBrNo());
		corpBase = corpBaseBo.getById(corpBase);
		getObjValue(formcoop0002, corpBase);
		return "detail";
	}
	/**
	 * �����������У��
	 * @return
	 * @throws Exception
	 */
	public void validateInsert(){
		 ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		 formcoop0002 = formService.getFormData("coop0002");
		 getFormValue(formcoop0002);
		 corpBase = new CorpBase();
		 setObjValue(formcoop0002, corpBase);
		 validateFormData(formcoop0002);
   	}
   
	/**
	 * �޸ı������У��
	 * @return
	 * @throws Exception
	 */
	public void validateUpdate(){
		 ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		 formcoop0002 = formService.getFormData("coop0002");
		 getFormValue(formcoop0002);
		 validateFormData(formcoop0002);
  	}
	
	/**
	 * �鿴360�ӽ�
	 * @return
	 */
	public String getAllDetail() {
		ActionContext.initialize(ServletActionContext.getRequest(), 
				ServletActionContext.getResponse());
		corpBase = new CorpBase();
		corpBase.setBrNo(brNo);
		//cifPers.setEcif_no(ecif_no);
		corpBase = corpBaseBo.getById(corpBase);
		//cifType = cifPersInf.getCifType();
		//if_agri = cifPers.getIf_agri();
		return "all";
	}
	public String getAllDetailForRead() {
		ActionContext.initialize(ServletActionContext.getRequest(), 
				ServletActionContext.getResponse());
		corpBase = new CorpBase();
		corpBase.setBrNo(brNo);
		//cifPers.setEcif_no(ecif_no);
		corpBase = corpBaseBo.getById(corpBase);
		//cifType = cifPersInf.getCifType();
		//if_agri = cifPers.getIf_agri();
		return "all";
	}	
	/**
	 * 360��ͼ��tableͷ
	 * @return
	 */
	public String getDetailTop() {
		ActionContext.initialize(ServletActionContext.getRequest(), 
				ServletActionContext.getResponse());
		formcoop0015 = formService.getFormData("coop0015");
		corpBase = new CorpBase();
		corpBase.setBrNo(brNo);
		corpBase = corpBaseBo.getById(corpBase);
		getObjValue(formcoop0015, corpBase);
		query = "query";
		return "top";
	}
	
	/**
	 * ��ʾҵ��ſ�ͼ
	 * @return
	 * @throws Exception
	 */
	public String showView() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),ServletActionContext.getResponse());
		RptCorpArea rptCorpArea = new RptCorpArea();
		rptCorpArea.setBrNo(brNo);
		List<RptCorpArea> list = rptCorpAreaBo.findByAll(rptCorpArea);
		String areas = "";
		for(RptCorpArea rca : list){
			areas += ",{name:'"+rca.getAreaNo()+"',cnt:'"+rca.getLnCnt()+"'}";
			//System.out.println("name:"+rca.getAreaNo()+",����:"+rca.getLnCnt());
		}
		if(areas.length()>0){
			areas = areas.substring(1);
		}
		rptParams = new RptParams();
		rptParams.setData1(areas);
		
		return "detail";
	}
	
	public String getTab() throws Exception{
		ActionContext.initialize(ServletActionContext.getRequest(),
				ServletActionContext.getResponse());
		tabList = new ArrayList();
		String[] tab = null;
		
		tab = new String[2];
		tab[0] = "������Ϣ";
		tab[1] = "CorpBaseAction_getById.action?brNo=" + brNo+ "&query="+ query + "";
		tabList.add(tab);
		
			
		tab = new String[2];
		tab[0] = "������Ϣ";
		//tab[1] = "CorpParmAction_listQuotaForCorp.action?brNo=" + brNo + "&query="+ query + "";
		tab[1] = "CorpParmAction_getById.action?brNo=" + brNo+ "&query="+ query + "";
		tabList.add(tab);
			
		tab = new String[2];
		tab[0] = "������Ϣ";
		tab[1] = "CorpCertAction_listQuotaForCorp_Read.action?brNo="+brNo+ "&query="+ query + "";
		tabList.add(tab);
		
		tab = new String[2];
		tab[0] = "������Ϣ";
	    tab[1] = "CorpFinAction_listQuotaForCorp.action?brNo=" + brNo + "&query="+ query + "";
		
		tabList.add(tab);
		
		tab = new String[2];
		tab[0] = "�ɶ���Ϣ";
	    tab[1] = "CorpGdinfoAction_listQuotaForCorp.action?brNo=" + brNo + "&query="+ query + "";
		tabList.add(tab);
			
		tab = new String[2];
		tab[0] = "��ϵ����Ϣ";
		tab[1] = "CorpContAction_listQuotaForCorp.action?brNo=" + brNo + "&query="+ query + "";
		tabList.add(tab);
			
		tab = new String[2];
		tab[0] = "�˻���Ϣ";
		tab[1] = "CorpAcctAction_listQuotaForCorp.action?brNo=" + brNo + "&query="+ query + "";
		tabList.add(tab);
		
		/*tab = new String[2];
		tab[0] = "������Ϣ";
		tab[1] = "PubOpinAction_listQuotaForCorp.action?brNo=" + brNo + "&query="+ query + "&brName="+ brName +"";
		tabList.add(tab);*/
		
		tab = new String[2];
		tab[0] = "������Ϣ";
		tab[1] = "CorpEvalAction_findByPage360.action?brNo=" + brNo + "&query="+ query + "&formSts=1";
		tabList.add(tab);
		
/*		tab = new String[2];
		tab[0] = "�ͻ�����";
		if(is_flag!=null && is_flag.equals("1")){
			tab[1] = "CifEvalAction_findByPage360.action?cifNo=" + cifNo+"&brNo=" + brNo + "&query="+query;
		}else{
			tab[1] = "CifEvalAction_findByPage360.action?cifNo=" + cifNo+"&brNo=" + brNo + "&query="+query;
		}*/
		
		return "tab";
	}
	public String findByPageForPop() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),ServletActionContext.getResponse());
		corpBase = new CorpBase();
		formcoop0055 = formService.getFormData("coop0055");
		corpBase = new CorpBase();
		getFormValue(formcoop0055);
		setObjValue(formcoop0055, corpBase);
		Ipage ipage = this.getIpage();
		corpBaseList = (List) corpBaseBo.findByPage(ipage, corpBase).getResult();
		return "listforpop";
	}
	

	public String getViewTab() throws Exception{
		ActionContext.initialize(ServletActionContext.getRequest(), 
				ServletActionContext.getResponse());
		
		tabList = new ArrayList();
		String[] tab = null;
		
		tab = new String[2];
		tab[0] = "����ֲ�";
		tab[1] = "CorpBaseAction_showView.action?brNo=" + brNo+ "&query="+ query + "";
		tabList.add(tab);
		
		tab = new String[2];
		tab[0] = "��������";
		tab[1] = "CorpBaseAction_showActionNum.action?brNo=" + brNo+ "&query="+ query + "";
		tabList.add(tab);
		
	    tab = new String[2];
		tab[0] = "�ſ���ձ���";
		tab[1] = "CorpBaseAction_showReNumback.action?brNo=" + brNo+ "&query="+ query + "";
	    tabList.add(tab);
		
		tab = new String[2];
		tab[0] = "�������";
		tab[1] = "CorpBaseAction_showActionAmt.action?brNo=" + brNo+ "&query="+ query + "";
		tabList.add(tab);
			
		tab = new String[2];
		tab[0] = "ҵ�����";
		tab[1] = "CorpBaseAction_showIndictor.action?brNo=" + brNo+ "&query="+ query + "";
		tabList.add(tab);
			
		/*tab = new String[2];
		tab[0] = "�������";
		tab[1] = "CorpBaseAction_showProBal.action?brNo="+brNo+ "&query="+ query + "";
		tabList.add(tab);
		*/
		tab = new String[2];
		tab[0] = "ҵ�����";
	    tab[1] = "CorpBaseAction_showPrdtKind.action?brNo=" + brNo + "&query="+ query + "";
		
		tabList.add(tab);
		
		return "tab";
	}
	//ҵ�����
	public String showIndictor() throws Exception{
		ActionContext.initialize(ServletActionContext.getRequest(), 
				ServletActionContext.getResponse());
		String[] days = getMonthDays();
		String xStr = "";
		String data1 = "";
		String data2 = "";
		String data3 = "";
		String data4 = "";
		String data5 = "";
		int count = 0;
		for(int i=0; i<days.length; i++){
			RptCorpDaily rptCorpDaily = new RptCorpDaily();
			rptCorpDaily.setBrNo(brNo);
			rptCorpDaily.setRptDate(days[i].replace("-", ""));
			rptCorpDaily = rptCorpDailyBo.findRpt(rptCorpDaily);
			
			xStr += ",'"+days[i]+"'";
			if("".equals(rptCorpDaily)||null==rptCorpDaily){
				data1 += ","+0;
				data2 += ","+0;
				data3 += ","+0;
				data4 += ","+0;
				data5 += ","+0;
				count++;
			}else{
				data1 += ","+ new DecimalFormat("#.00").format(rptCorpDaily.getPassDayrate());
				if(rptCorpDaily.getLnBal()<=0){
					rptCorpDaily.setLnBal(1);
				}
				data2 += ","+new DecimalFormat("#.00").format(rptCorpDaily.getOverBal()/rptCorpDaily.getLnBal()*100);
				if(rptCorpDaily.getAmtTot()<=0){
					rptCorpDaily.setAmtTot(1);
				}
				data3 += ","+new DecimalFormat("#.00").format(rptCorpDaily.getCompAmt()/rptCorpDaily.getAmtTot()*100);
				data4 += ","+new DecimalFormat("#.00").format(rptCorpDaily.getRebuyAmt()/rptCorpDaily.getAmtTot()*100);
				data5 += ","+new DecimalFormat("#.00").format(rptCorpDaily.getFailDayrate()*100);
			}
		}
		if(count>=31){
			xStr = "";
			data1 = "";
			data2 = "";
			data3 = "";
			data4 = "";
			data5 = "";
		}
		if(xStr.length()>0){
			xStr = xStr.substring(1);
			data1 = data1.substring(1);
			data2 = data2.substring(1);
			data3 = data3.substring(1);
			data4 = data4.substring(1);
			data5 = data5.substring(1);
		}
		rptParams = new RptParams();
		rptParams.setData1(xStr);
		rptParams.setData2(data1);
		rptParams.setData3(data2);
		rptParams.setData4(data3);
		rptParams.setData5(data4);
		rptParams.setData6(data5);
		return "detail";
	}
	//ҵ��������
	public String showActionNum() throws Exception{
		ActionContext.initialize(ServletActionContext.getRequest(), 
				ServletActionContext.getResponse());
		String[] days = getMonthDays();
		String xStr = "";
		String data = "";
		int count = 0;
		for(int i=0; i<days.length; i++){
			RptCorpDaily rptCorpDaily = new RptCorpDaily();
			rptCorpDaily.setBrNo(brNo);
			rptCorpDaily.setRptDate(days[i].replace("-", ""));
			rptCorpDaily = rptCorpDailyBo.findRpt(rptCorpDaily);
			
			xStr += ",'"+days[i]+"'";
			if("".equals(rptCorpDaily)||null==rptCorpDaily){
				data += ","+0;
				count++;
			}else{
				data += ","+rptCorpDaily.getLnCnt();
			}
		}
		if(count>=31){
			xStr = "";
			data = "";
		}
		if(xStr.length()>0){
			xStr = xStr.substring(1);
			data = data.substring(1);
		}
		rptParams = new RptParams();
		rptParams.setData1(xStr);
		rptParams.setData2(data);
		return "detail";
	}
	public String showReNumback() throws Exception{
		ActionContext.initialize(ServletActionContext.getRequest(),ServletActionContext.getResponse());
		RptCorpDaily rptCorpDaily = new RptCorpDaily();
		rptCorpDaily.setBrNo(brNo);
		List<RptCorpDaily> list = rptCorpDailyBo.findByAllNum(rptCorpDaily);
		
		String xStr = "";
		String data = "";
		String data1 = "";
		for(RptCorpDaily rcd : list){
			xStr += ",'"+rcd.getRptDate()+"'";
			data += ","+rcd.getRepayDaycnt();
			data1 += ","+rcd.getCntDay();
		}
		if(xStr.length()>0){
			xStr = xStr.substring(1);
			data = data.substring(1);
			data1 = data1.substring(1);
		}
		rptParams = new RptParams();
		rptParams.setData1(xStr);
		rptParams.setData2(data);
		rptParams.setData3(data1);
		return "detail";
	}
	//ҵ�������
	public String showActionAmt() throws Exception{
		ActionContext.initialize(ServletActionContext.getRequest(), 
				ServletActionContext.getResponse());
		String[] days = getMonthDays();
		String xStr = "";
		String data1 = "";
		String data2 = "";
		int count = 0;
		for(int i=0; i<days.length; i++){
			RptCorpDaily rptCorpDaily = new RptCorpDaily();
			rptCorpDaily.setBrNo(brNo);
			rptCorpDaily.setRptDate(days[i].replace("-", ""));
			rptCorpDaily = rptCorpDailyBo.findRpt(rptCorpDaily);
			
			xStr += ",'"+days[i]+"'";
			if("".equals(rptCorpDaily)||null==rptCorpDaily){
				data1 += ","+0;
				data2 += ","+0;
				count++;
			}else{
				data1 += ","+new DecimalFormat("#.00").format(rptCorpDaily.getLnBal()/10000);
				data2 += ","+new DecimalFormat("#.00").format(rptCorpDaily.getOverBal()/10000);
			}
		}
		if(count>=31){
			xStr = "";
			data1 = "";
			data2 = "";
		}
		if(xStr.length()>0){
			xStr = xStr.substring(1);
			data1 = data1.substring(1);
		}
		rptParams = new RptParams();
		rptParams.setData1(xStr);
		rptParams.setData2(data1);
		rptParams.setData3(data2);
		return "detail";
	}
	
	public String showActionAmtForBal() throws Exception{
		ActionContext.initialize(ServletActionContext.getRequest(), 
				ServletActionContext.getResponse());
		RptPrdtDaily rptPrdtDaily = new RptPrdtDaily();
		rptPrdtDaily.setProjNo(projNo);
		rptPrdtDaily.setPrdtType(lnType);
		List<RptPrdtDaily> list = rptPrdtDailyBo.getList(rptPrdtDaily);
		
		String xStr = "";
		String data1 = "";
		String data2 = "";
		String data3 = "";
		String data4 = "";
		for(RptPrdtDaily rcd : list){
			xStr += ",'"+rcd.getRptDate()+"'";
			data1 += ","+new DecimalFormat("#.00").format(rcd.getLnBal()/10000);
			data2 += ","+new DecimalFormat("#.00").format(rcd.getOverBal()/10000);
		}
		if(xStr.length()>0){
			xStr = xStr.substring(1);
			data1 = data1.substring(1);
			data2 = data2.substring(1);
		}
		rptParams = new RptParams();
		rptParams.setData1(xStr);
		rptParams.setData2(data1);
		rptParams.setData3(data2);
		return "detail";
	}	
	public String showProBal() throws Exception{
		ActionContext.initialize(ServletActionContext.getRequest(), 
				ServletActionContext.getResponse());
		RptCorpDaily rptCorpDaily = new RptCorpDaily();
		rptCorpDaily.setBrNo(brNo);
		List<RptCorpDaily> list = rptCorpDailyBo.getList(rptCorpDaily);
		
		String xStr = "";
		String data1 = "";
		String data2 = "";
		String data3 = "";
		String data4 = "";
		for(RptCorpDaily rcd : list){
			xStr += ",'"+rcd.getRptDate()+"'";
			data1 += ","+rcd.getLnBal();
			data2 += ","+rcd.getAmtTot();
			data3 += ","+rcd.getIntstTot();
			data4 += ","+rcd.getOverBal();
		}
		if(xStr.length()>0){
			xStr = xStr.substring(1);
			data1 = data1.substring(1);
			data2 = data2.substring(1);
			data3 = data3.substring(1);
			data4 = data4.substring(1);
		}
		rptParams = new RptParams();
		rptParams.setData1(xStr);
		rptParams.setData2(data1);
		rptParams.setData3(data2);
		rptParams.setData4(data3);
		rptParams.setData5(data4);
		return "detail";
	}
	
	public String showPrdtKind() throws Exception{
		ActionContext.initialize(ServletActionContext.getRequest(), 
				ServletActionContext.getResponse());
		RptCorpPrdt rptCorpPrdt = new RptCorpPrdt();
		rptCorpPrdt.setBrNo(brNo);
		List<RptCorpPrdt> list = rptCorpPrdtBo.findByAll(rptCorpPrdt);
		String xStr = "";
		String data1 = "";
		String data2 = "";
		String data3 = "";
		String data4 = "";
		String prdtType = "";
		for(int i=0; i<list.size(); i++){
			RptCorpPrdt rcp = list.get(i);
			xStr += ",'"+rcp.getRptDate()+"'";
			for(int j=0; j<4; j++){
				RptCorpPrdt xrcp = null;
				if(i+j<list.size()){
					xrcp = list.get(i+j);
				}
				if(xrcp != null&&rcp.getRptDate().equals(xrcp.getRptDate())){
					if("01".equals(xrcp.getPrdtType())){
						data1 += ","+new DecimalFormat("#.00").format(xrcp.getLnBal()/10000);
					}else if("02".equals(xrcp.getPrdtType())){
						data2 += ","+new DecimalFormat("#.00").format(xrcp.getLnBal()/10000);
					}else if("03".equals(xrcp.getPrdtType())){
						data3 += ","+new DecimalFormat("#.00").format(xrcp.getLnBal()/10000);
					}else if("04".equals(xrcp.getPrdtType())){
						data4 += ","+new DecimalFormat("#.00").format(xrcp.getLnBal()/10000);
					}
					i = i+j;
					//20161116zlc
					prdtType += ","+xrcp.getPrdtType();
				}else{
//					if(j==0){
//						data1 += ",0";
//					}else if(j==1){
//						data2 += ",0";
//					}else if(j==2){
//						data3 += ",0";
//					}else if(j==3){
//						data4 += ",0";
//					}
				}
			}
			if("".equals(prdtType)){
				data1 += ",0";
				data2 += ",0";
				data3 += ",0";
				data4 += ",0";
			}
			if (!prdtType.contains("01")){
				data1 += ",0";					
			}
			if (!prdtType.contains("02")){
				data2 += ",0";					
			}
			if (!prdtType.contains("03")){
				data3 += ",0";					
			}
			if (!prdtType.contains("04")){
				data4 += ",0";					
			}
			prdtType = "";
		}
		if(xStr.length()>0){
			xStr = xStr.substring(1);
			data1 = data1.substring(1);
			data2 = data2.substring(1);
			data3 = data3.substring(1);
			data4 = data4.substring(1);
		}
		rptParams = new RptParams();
		rptParams.setData1(xStr);
		rptParams.setData2(data1);
		rptParams.setData3(data2);
		rptParams.setData4(data3);
		rptParams.setData5(data4);
		return "detail";
	}
	//��ȡ���һ��������
	public static String[] getMonthDays(){        
		String[] days = new String[31];
        Calendar cal = Calendar.getInstance();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        cal.set(Calendar.DATE, cal.get(Calendar.DATE)+1);
        for(int i=0; i<31; i++){
            cal.set(Calendar.DATE, cal.get(Calendar.DATE)-2); //�����ǰ��2��
        	Date dtFrom=cal.getTime();
        	days[30-i] = df.format(dtFrom);
        }       
        return days;
    } 
	
	public FormData getFormcoop0015() {
		return formcoop0015;
	}
	public void setFormcoop0015(FormData formcoop0015) {
		this.formcoop0015 = formcoop0015;
	}
	public List getTabList() {
		return tabList;
	}
	public void setTabList(List tabList) {
		this.tabList = tabList;
	}
	
	public CorpBase getCorpBase() {
		return corpBase;
	}
	public void setCorpBase(CorpBase  corpBase) {
		this.corpBase = corpBase;
	}
	public List<CorpBase> getCorpBaseList() {
		return corpBaseList;
	}
	public void setCorpBaseList(List<CorpBase> corpBaseList) {
		this.corpBaseList = corpBaseList;
	}
	public CorpBaseBo getCorpBaseBo() {
		return corpBaseBo;
	}
	public void setCorpBaseBo(CorpBaseBo corpBaseBo) {
		this.corpBaseBo = corpBaseBo;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public FormData getFormcoop0002() {
		return formcoop0002;
	}
	public void setFormcoop0002(FormData formcoop0002) {
		this.formcoop0002 = formcoop0002;
	}
	public FormData getFormcoop0001() {
		return formcoop0001;
	}
	public void setFormcoop0001(FormData formcoop0001) {
		this.formcoop0001 = formcoop0001;
	}
	public void setBrNo(String brNo){
		this.brNo = brNo;
	}		
	public String getBrNo(){
		return brNo;
	}
	public FormService getFormService() {
		return formService;
	}
	public void setFormService(FormService formService) {
		this.formService = formService;
	}
	public FormData getFormcoop0055() {
		return formcoop0055;
	}
	public void setFormcoop0055(FormData formcoop0055) {
		this.formcoop0055 = formcoop0055;
	}
	public RptCorpDailyBo getRptCorpDailyBo() {
		return rptCorpDailyBo;
	}
	public void setRptCorpDailyBo(RptCorpDailyBo rptCorpDailyBo) {
		this.rptCorpDailyBo = rptCorpDailyBo;
	}
	public RptParams getRptParams() {
		return rptParams;
	}
	public void setRptParams(RptParams rptParams) {
		this.rptParams = rptParams;
	}
	public RptCorpAreaBo getRptCorpAreaBo() {
		return rptCorpAreaBo;
	}
	public void setRptCorpAreaBo(RptCorpAreaBo rptCorpAreaBo) {
		this.rptCorpAreaBo = rptCorpAreaBo;
	}
	public RptCorpPrdtBo getRptCorpPrdtBo() {
		return rptCorpPrdtBo;
	}
	public void setRptCorpPrdtBo(RptCorpPrdtBo rptCorpPrdtBo) {
		this.rptCorpPrdtBo = rptCorpPrdtBo;
	}
	public LnPact getLnPact() {
		return lnPact;
	}
	public void setLnPact(LnPact lnPact) {
		this.lnPact = lnPact;
	}
	public LnPactBo getLnPactBo() {
		return lnPactBo;
	}
	public void setLnPactBo(LnPactBo lnPactBo) {
		this.lnPactBo = lnPactBo;
	}
	public String getAppId() {
		return appId;
	}
	public void setAppId(String appId) {
		this.appId = appId;
	}
	public String getProjNo() {
		return projNo;
	}
	public void setProjNo(String projNo) {
		this.projNo = projNo;
	}
	public String getLnType() {
		return lnType;
	}
	public void setLnType(String lnType) {
		this.lnType = lnType;
	}
	public RptPrdtDailyBo getRptPrdtDailyBo() {
		return rptPrdtDailyBo;
	}
	public void setRptPrdtDailyBo(RptPrdtDailyBo rptPrdtDailyBo) {
		this.rptPrdtDailyBo = rptPrdtDailyBo;
	}
	public String getBackSts() {
		return backSts;
	}
	public void setBackSts(String backSts) {
		this.backSts = backSts;
	}
	public String getBrName() {
		return brName;
	}
	public void setBrName(String brName) {
		this.brName = brName;
	}
	public CorpParmBo getCorpParmBo() {
		return corpParmBo;
	}
	public void setCorpParmBo(CorpParmBo corpParmBo) {
		this.corpParmBo = corpParmBo;
	}
	public CorpAcctBo getCorpAcctBo() {
		return corpAcctBo;
	}
	public void setCorpAcctBo(CorpAcctBo corpAcctBo) {
		this.corpAcctBo = corpAcctBo;
	}
	public String getBrSts() {
		return brSts;
	}
	public void setBrSts(String brSts) {
		this.brSts = brSts;
	}
	

	
	
}