package app.creditapp.proj.action;

import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSON;
import com.core.domain.screen.FormData;
import com.core.service.screen.FormService;
import com.core.struts.ActionContext;
import com.core.struts.BaseFormBean;

import app.creditapp.corp.bo.CorpAcctBo;
import app.creditapp.corp.entity.CorpAcct;
import app.creditapp.fund.bo.FundDetailBo;
import app.creditapp.fund.bo.FundPayPlanBo;
import app.creditapp.fund.bo.FundRepayPlanBo;
import app.creditapp.fund.entity.FundDetail;
import app.creditapp.fund.entity.FundPayPlan;
import app.creditapp.fund.entity.FundRepayPlan;
import app.creditapp.inf.bo.WsBaseBo;
import app.creditapp.inf.entity.AllocateRegWsIn;
import app.creditapp.proj.bo.ProjAcctBo;
import app.creditapp.proj.bo.ProjBaseBo;
import app.creditapp.proj.bo.RptProjBo;
import app.creditapp.proj.entity.FutureCashFlow;
import app.creditapp.proj.entity.ProjAcct;
import app.creditapp.proj.entity.ProjBase;
import app.creditapp.proj.entity.RptProj;
import app.util.DateUtil;
import app.util.User;
import app.util.toolkit.Ipage;

/**
 * Title: ProjAcctAction.java Description:
 * 
 **/
public class ProjAcctAction extends BaseFormBean {

	// ҳ�洫ֵ
	private ProjAcct projAcct;
	private ProjBase projBase;
	private FutureCashFlow futureCashFlow;

	private List tabList;
	
	private List<CorpAcct> corpAcctList;
	private List<ProjAcct> projAcctList;

	// ע��ProjAcctBo
	private ProjAcctBo projAcctBo;
	private ProjBaseBo projBaseBo;
	private CorpAcctBo corpAcctBo;
	private FundDetailBo fundDetailBo;
	private WsBaseBo wsBaseBo;
	private FundPayPlanBo fundPayPlanBo;
	private FundRepayPlanBo fundRepayPlanBo;

	private RptProjBo rptProjBo;
	private String cardSts;
	private HttpServletRequest request;

	private String query;
	private String txDate;
	private String upOpno;
	private String deptNo;
	private String acctDesc;
	private String acctId;
	private String acctName;
	private String upDate;
	private String cardNo;
	private Double acctBal;
	private String acctUse;
	private String acctType;
	private String projName;
	private String opNo;
	private String filler;
	private String projNo;//��Ŀ���
	private String opnBank;
	private String acctNo;//�˻���
	private String projId;
	private FormData formproj0007;
	private FormData formproj0015;
	private FormData formproj0008;
	private FormData formproj0011;
	private FormData formproj0016;
	private FormData formproj0017;
	private FormData formproj0020;
	private FormData formproj0030;
	private FormData formproj0028;
	private double txAmt;
	private String isFlag;
	private String endDate;
	private String CalCulType;
	// ҳ�淵�ذ�ť�жϲ���
	private String backSts;
	// �ղ���ӿ�
	// ����Ϣ����
	private String id;// Ψһ��ʶ������¼(Ψһ��ʶ����Χϵͳͨ����ID�ɻ�����ɵĲ���̨������Ϣ)
	private String businessflag;// ҵ���ʾ1:�˻����2:���и���Ӫ��3:�˻��տ4:��Ӫ���棬5:���и����ϻ���6:���˻�����
	private String autoSyncFlag;// �Զ�ͬ�����������ʾ
	private String projectid;// ��ĿID
	private String ddtype;// ��������(������������������Ϊ��Ӫ��������� 1:��Ӫҵ˰������2:���)
	private String transdate;// ҵ������(��������) yyyy-MM-dd
	private String transreason;// ��������
	private String purpose;// ��;
	private String memo;// ժҪ
	private String userCode;// ������CODE
	private String staffapp;// ������� (��Ӫ������0���ⲿ�˻� 1������Ա����2�����л�)
	// ��ϸ��Ϣ����
	private String amount;// ���׽��(2λС��)
	private String bktranstypecode;// ����Ľ������ͱ���(����ʱ����)
	private String sktranstypecode;// �տ�Ľ������ͱ��� (����������и���Ӫ�����տ��ʱ����)
	private String feetypecode;// �������ͱ���(��������,�����ཻ������ʱ�����)
	private String taxtypecode;// ˰Ŀ���ͱ���(��������,˰Ŀ�ཻ��ʱ������ )
	private String customid;// �տ���ID
	private String accountid;// �ʽ����÷��˺�ID/���ID(�����������ϸ�������ʹ����˻��ཻ������ʱ�����)
	// private String opbankacntid ;//�Է�����ID
	private String opbankacntno;// �Է������˺�(�������������ʻ�������и���Ӫ����Ӫ����(�������Ϊ�ⲿ�˻�������ר��)������100���ַ�)
	private String opbankname;// �Է������˺ſ�����(��������,������ʻ�������и���Ӫ����Ӫ����(�������Ϊ�ⲿ�˻�������ר��)������100���ַ�)
	private String opbankacntname;// �Է������˺Ż���(��������,������ʻ�������и���Ӫ����Ӫ����(�������Ϊ�ⲿ�˻�������ר��)������100���ַ�)
	private String opbankprovince;// ����������ʡ(��������,������ʻ�������и���Ӫ������100���ַ�)
	private String opbankcity;// ������������(��������,������ʻ�������и���Ӫ������100���ַ�)
	private String repaytypeid;// ���ʽ
								// ����������ڲ��˻��е�ҵ�����Ϊ����ģ�����ϸ����������Ϊ����ģ�01�����ջأ�02�ʲ����飬03�ʲ����룬04���ʵ�ծ��05����������06���������07�����Ի��08ծת�ɡ�09ת����
	private String appusercode;// �ڲ���Ա(��������:��Ӫ���沦�����Ϊ����ʱ�����)
	private String tradeCode;
	private String project;
	private String customer;
	private String industry;

	private FormService formService = new FormService();

	public ProjAcctAction() {
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
		formproj0007 = formService.getFormData("proj0007");
		projAcct = new ProjAcct();
		getFormValue(formproj0007);
		setObjValue(formproj0007, projAcct);
		projAcct.setAcctType(acctType);
		projAcct.setProjNo(projNo);
		Ipage ipage = this.getIpage();
		projAcctList = (List) projAcctBo.findByPage(ipage, projAcct)
				.getResult();
		return "list";
	}

	public String findByPageForPop() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),
				ServletActionContext.getResponse());
		formproj0015 = formService.getFormData("proj0015");
		projAcct = new ProjAcct();
		getFormValue(formproj0015);
		setObjValue(formproj0015, projAcct);
		projAcct.setProjNo(projNo);
		Ipage ipage = this.getIpage();
		projAcctList = (List) projAcctBo.findByPageForPop(ipage, projAcct)
				.getResult();
		return "list";
	}

	/**
	 * ��ҳ��ѯ
	 * 
	 * @return
	 * @throws Exception
	 */
	public String findByPageToProj() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),
				ServletActionContext.getResponse());

		if (projNo == null || "".equals(projNo)) {
			this.addActionMessage("������  ��Ŀ��Ϣ �в�¼С΢��Ŀ��ţ�");
			return "   ";
		} else {
			formproj0007 = formService.getFormData("proj0007");
			projAcct = new ProjAcct();
			projAcct.setProjNo(projNo);
			getFormValue(formproj0007);
			setObjValue(formproj0007, projAcct);
			projAcct.setAcctType(acctType);
			projAcct.setProjNo(projNo);
			projAcct.setQuery(query);
			Ipage ipage = this.getIpage();
			projAcctList = (List) projAcctBo.findByPage(ipage, projAcct)
					.getResult();
			return "list";
		}

	}

	/**
	 * ��ҳ��ѯ
	 * 
	 * @return
	 * @throws Exception
	 */
	public String findByPageToProj_Read() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),
				ServletActionContext.getResponse());

		if (projNo == null || "".equals(projNo)) {
			this.addActionMessage("������  ��Ŀ��Ϣ �в�¼С΢��Ŀ��ţ�");
			return "   ";
		} else {
			// formproj0007 = formService.getFormData("proj0007");
			projAcct = new ProjAcct();
			// projAcct.setProjNo(projNo);
			// getFormValue(formproj0007);
			// setObjValue(formproj0007, projAcct);
			// projAcct.setAcctType(acctType);
			projAcct.setProjNo(projNo);
			// projAcct.setQuery(query);
			Ipage ipage = this.getIpage();
			projAcctList = (List) projAcctBo.findByPage(ipage, projAcct)
					.getResult();
			return "list_Read";
		}
	}

	/**
	 * ��ҳ��ѯ�����˻���Ϣ
	 * 
	 * @return
	 * @throws Exception
	 */
	public String findByPageForVa() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),
				ServletActionContext.getResponse());
		formproj0011 = formService.getFormData("proj0011");
		projAcct = new ProjAcct();
		getFormValue(formproj0011);
		setObjValue(formproj0011, projAcct);
		// projAcct.setAcctType(acctType);
		// projAcct.setProjNo(projNo);
		projAcct.setLoginid(User.getLoginIdByAuth(this.getHttpRequest())); // ��session�л�ȡȨ��
		Ipage ipage = this.getIpage();
		projAcctList = (List) projAcctBo.findByPage(ipage, projAcct)
				.getResult();
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

		formproj0008 = formService.getFormData("proj0008");

		projAcct = new ProjAcct();
		projBase = new ProjBase();

		if (projNo != null && !projNo.equals("")) {
			projBase.setProjNo(projNo);
			projBase = projBaseBo.getById(projBase);
			projAcct.setProjNo(projNo);
			projAcct.setProjName(projBase.getProjName());
		}

		projAcct.setDeptNo(User.getBrno(ServletActionContext.getRequest()));// �Ǽǲ���
		projAcct.setOpNo(User.getLoginid(ServletActionContext.getRequest()));// ����Ա
		projAcct.setTxDate(User.getSys_date(ServletActionContext.getRequest()));// �Ǽ�����
		// projAcct.setUpDate(User.getSys_date(ServletActionContext.getRequest()));//�޸�����
		// projAcct.setUpOpno(User.getLoginid(ServletActionContext.getRequest()));//�޸���Ա
		getObjValue(formproj0008, projAcct);
		return "input";
	}
	/**
	 * ��ȡ����ҳ��
	 * 
	 * @return
	 * @throws Exception
	 */
	public String inputAcct() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),
				ServletActionContext.getResponse());

		formproj0028 = formService.getFormData("proj0028");

		projAcct = new ProjAcct();
		projBase = new ProjBase();

		if (projNo != null && !projNo.equals("")) {
			projBase.setProjNo(projNo);
			projBase = projBaseBo.getById(projBase);
			projAcct.setProjNo(projNo);
			projAcct.setProjName(projBase.getProjName());
		}

		projAcct.setDeptNo(User.getBrno(ServletActionContext.getRequest()));// �Ǽǲ���
		projAcct.setOpNo(User.getLoginid(ServletActionContext.getRequest()));// ����Ա
		projAcct.setTxDate(User.getSys_date(ServletActionContext.getRequest()));// �Ǽ�����
		// projAcct.setUpDate(User.getSys_date(ServletActionContext.getRequest()));//�޸�����
		// projAcct.setUpOpno(User.getLoginid(ServletActionContext.getRequest()));//�޸���Ա
		getObjValue(formproj0028, projAcct);
		return "input";
	}
	/**
	 * �����������
	 *�ĳ�����ר���ķ���
	 * @return
	 * @throws Exception
	 */
	public String insert() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),
				ServletActionContext.getResponse());
		//formproj0008 = formService.getFormData("proj0008");    �˷�����ԭ����0008
		
		formproj0028 = formService.getFormData("proj0028");

		
		getFormValue(formproj0028);
		projAcct = new ProjAcct();
		setObjValue(formproj0028, projAcct);
		projAcct.setDeptNo(User.getBrno(ServletActionContext.getRequest()));// �Ǽǲ���
		projAcct.setOpNo(User.getLoginid(ServletActionContext.getRequest()));// ����Ա
		projAcct.setTxDate(User.getSys_date(ServletActionContext.getRequest()));// �Ǽ�����
		// projAcct.setUpDate(User.getSys_date(ServletActionContext.getRequest()));//�޸�����
		// projAcct.setUpOpno(User.getLoginid(ServletActionContext.getRequest()));//�޸���Ա
	//	int count = projAcctBo.getCountForX(projAcct);
		
		
		int count = projAcctBo.getCountForProj(projAcct);

		//���� ���� �� ��Ŀ��Ž����ж� �Ƿ��Ѿ����� �˴��������ڵĻ��Ͳ��ܽ�����������
		if(count!=0){
			this.addActionError("��������ר���Ѿ����ڣ�");
			getObjValue(formproj0028, projAcct);
			return inputAcct();
		}else{
			String s = projAcctBo.getProjId(projAcct);
			projAcct.setProjId(s);
			projAcct.setCardSts("01");
//			String res = acctSynMes(projAcct,"1");
//			if("1".equals(res)){
				projAcctBo.insert(projAcct);
				getObjValue(formproj0028, projAcct);
				this.addActionMessage("�����ɹ�,ר����ӳɹ�!");
//			}else{
//				this.addActionMessage("����ʧ�ܣ�"+res);
//			}
		}
		return findByPageToProj_Read();
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
		formproj0007 = formService.getFormData("proj0007");
		projAcct = new ProjAcct();
		projAcct.setAcctId(acctId);
		projAcct = projAcctBo.getById(projAcct);
		if ("01".equals(cardSts)) {
			String res = acctSynMes(projAcct,"0");
			if("1".equals(res)){
				projAcct.setCardSts("02");
				projAcct.setSendSts("0");
				projAcctBo.updateSts(projAcct);
				this.addActionMessage("��ʧЧ");
			}else{
				this.addActionMessage("����ʧ�ܣ��˻�δʧЧ��"+res);
			}
		} else {
			int count = projAcctBo.getCountForX(projAcct);
			//���� ���� �� ��Ŀ��Ž����ж� �Ƿ��Ѿ����� �����⻧�����ڵĻ��Ͳ��ܽ�����������
			if(count!=0){
				this.addActionError("����Ŀ����һ����Ч�������ʻ���");
				return findByPageToProj_Read();
			}else{
				String res = acctSynMes(projAcct,"3");
				if("1".equals(res)){
					projAcct.setCardSts("01");
					projAcct.setSendSts("1");
					projAcctBo.updateSts(projAcct);
					this.addActionMessage("��Ч�ɹ�");
				}else{
					this.addActionMessage("����ʧ�ܣ��˻�δ��Ч��"+res);
				}
			}
		}
		// projAcctBo.update(projAcct);
		// this.addActionMessage("��Ч�ɹ�");
		projAcct = new ProjAcct();
		projAcct.setAcctType(acctType);
		projAcct.setProjNo(projNo);
		Ipage ipage = this.getIpage();
		projAcctList = (List) projAcctBo.findByPage(ipage, projAcct)
				.getResult();
		return "list";
	}

	/**
	 * ʧЧ
	 * 
	 * @return
	 * @throws Exception
	 */
	public String inactive() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),
				ServletActionContext.getResponse());
		formproj0007 = formService.getFormData("proj0007");
		projAcct = new ProjAcct();
		projAcct.setAcctId(acctId);
		projAcct = projAcctBo.getById(projAcct);
		projAcct.setSendSts("0");
		projAcct.setCardSts("02");
		projAcctBo.update(projAcct);
		this.addActionMessage("��ʧЧ");
		projAcct = new ProjAcct();
		Ipage ipage = this.getIpage();
		projAcctList = (List) projAcctBo.findByPage(ipage, projAcct)
				.getResult();
		return "list";
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
		formproj0008 = formService.getFormData("proj0008");
		getFormValue(formproj0008);
		projAcct = new ProjAcct();
			setObjValue(formproj0008, projAcct);
			projAcct.setUpDate(User.getSys_date(ServletActionContext.getRequest()));// �޸�����
			projAcct.setUpOpno(User.getLoginid(ServletActionContext.getRequest()));// �޸���Ա
			String s = projAcctBo.getProjId(projAcct);
			projAcct.setProjId(s);
//			String res = acctSynMes(projAcct,"2");
//			if("1".equals(res)){
				projAcctBo.update(projAcct);
				getObjValue(formproj0008, projAcct);
				this.addActionMessage("�˻��޸ĳɹ�");
//			}else{
//				this.addActionMessage("�˻��޸�ʧ�ܣ�"+res);
//			}
			return "detail";
	}
	
	public String updateForZ() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),
				ServletActionContext.getResponse());
		formproj0020 = formService.getFormData("proj0020");
		getFormValue(formproj0020);
		projAcct = new ProjAcct();
			setObjValue(formproj0020, projAcct);
			projAcct.setUpDate(User.getSys_date(ServletActionContext.getRequest()));// �޸�����
			projAcct.setUpOpno(User.getLoginid(ServletActionContext.getRequest()));// �޸���Ա
			projAcctBo.update(projAcct);
			getObjValue(formproj0020, projAcct);
			this.addActionMessage("�����ɹ�");
			return "detailForZ";
	}
	
	public String updateForFK() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),
				ServletActionContext.getResponse());
		formproj0030 = formService.getFormData("proj0030");
		getFormValue(formproj0030);
		projAcct = new ProjAcct();
			setObjValue(formproj0030, projAcct);
			projAcct.setUpDate(User.getSys_date(ServletActionContext.getRequest()));// �޸�����
			projAcct.setUpOpno(User.getLoginid(ServletActionContext.getRequest()));// �޸���Ա
			projAcctBo.update(projAcct);
			getObjValue(formproj0030, projAcct);
			this.addActionMessage("�����ɹ�");
			return "detailForFK";
	}

	public String acctSynMes() throws Exception {
		
		ProjAcct projAcct = new ProjAcct();
		projAcct.setAcctId(acctId);
		projAcct = projAcctBo.getById(projAcct);
		
		projBase = new ProjBase();
		projBase.setProjNo(projNo);
		projBase = projBaseBo.getByIdForProjNo(projBase);
		/*
		AcctSendDetail acctSendDetail = new AcctSendDetail();
		
		acctSendDetail.setAccountName(projAcct.getAcctName());
		acctSendDetail.setAccountNo(projAcct.getAcctNo());
		acctSendDetail.setCustName(projBase.getProjName());
		acctSendDetail.setCustNo(projBase.getProjNo());
		acctSendDetail.setTenantNo(projBase.getTenantNo());
		
		ResultMes resultMes = SendZFService.createAcctXMLAndSend(acctSendDetail, projBase.getBrNo());
		
		if("1".equals(resultMes.getResultCode())){
			this.addActionMessage("�˻����ͳɹ���");
			projAcct.setCardSts("01");
			projAcct.setSendSts("02");
			projAcctBo.update(projAcct);
		}else{
			this.addActionMessage("�˻�����ʧ�ܣ�"+resultMes.getResultMsg());
		}
		*/
		return findByPageToProj_Read();
	}
	
	public String acctSynMes(ProjAcct projAcct,String sendSts) throws Exception {
		
		return findByPageToProj_Read();
	}
	
//	// ͬ������
//	public String acctSynMes() throws Exception {
//		ProjAcct projAcct = new ProjAcct();
//		projAcct.setAcctId(acctId);
//		projAcct = projAcctBo.getById(projAcct);
//		String projNo = projAcct.getProjNo();//��ȡ��Ŀ���
//		if (projAcct == null || "".equals(projAcct)) {
//			this.addActionError("��Ŀ��š�" + projNo + "����Ӧ���˺Ų����ڣ�");
//			return findByPageToProj_Read();
//		}
//		String sendSts = projAcct.getSendSts();
//		if ("02".equals(projAcct.getCardSts())) {
//			if ("1".equals(sendSts) || "2".equals(sendSts)) {
//				this.addActionError("��Ŀ�˺š�" + projAcct.getAcctNo()
//						+ "����ʧЧ�������������޸�");
//				return findByPageToProj_Read();
//			}
//		}
//		// ����ͷ
//		SimpleDateFormat timeFormater = new SimpleDateFormat(
//				"yyyy-MM-dd HH:mm:ss");
//		AcctSynHead acctSynHead = new AcctSynHead();
//		acctSynHead.setRequestType("A100002");
//		acctSynHead.setUUID("00014");// ������ˮ��
//		acctSynHead.setComId("0001");
//		acctSynHead.setComIP("211.168.22.111");
//		acctSynHead.setFrom("1881632261");
//		acctSynHead.setSystemName("16133001");
//		acctSynHead.setSystemPassword("111111");
//		acctSynHead.setSendTime(timeFormater.format(new Date()));
//		acctSynHead.setAsyn("0");
//		acctSynHead.setReturnUrl("http://ufc.esb.cost.com/cooperation/");
//		acctSynHead.setSigned("");
//		acctSynHead.setItSystem("0");
//		String headXml = XMLUtil.createHead(acctSynHead); // ͷ�ļ�
//		// ����ʵ��
//		AcctSynDetail acctSynDetail = new AcctSynDetail();
//		acctSynDetail.setAccountNo(projAcct.getAcctNo());// �˻���
//		acctSynDetail.setOperaType(sendSts);
//		if(projAcct.getAcctName()==null||"".equals(projAcct.getAcctName())){
//			this.addActionError("�˻����Ʋ���Ϊ�գ�");
//			return findByPageToProj_Read();
//		}
//		acctSynDetail.setAccountName(projAcct.getAcctName()); // �˻�����
//		if(projAcct.getProjId()==null||"".equals(projAcct.getProjId())){
//			this.addActionError("���˻�����Ϊ�գ�");
//			return findByPageToProj_Read();
//		}
//		acctSynDetail.setBelongTo(projAcct.getProjId());// ���˻�
//		if(projAcct.getOrgNo()==null||"".equals(projAcct.getOrgNo())){
//			this.addActionError("�����Ų���Ϊ�գ�");
//			return findByPageToProj_Read();
//		}
//		acctSynDetail.setOrgNo(projAcct.getOrgNo());// ������
//		//�˻�����
//		if("02".equals(projAcct.getAcctType())){
//			acctSynDetail.setAccountType("01");
//		}else{
//			this.addActionError("ֻ�������⻧ͬ�������˻����ݣ�");
//			return findByPageToProj_Read();
//		}
//		acctSynDetail.setMaxAmount(""); // �����޶�
//		if(projAcct.getCardChn()==null||"".equals(projAcct.getCardChn())){
//			this.addActionError("�����˻���������Ϊ�գ�");
//			return findByPageToProj_Read();
//		}
//		acctSynDetail.setPayChannel(projAcct.getCardChn()); // ������������
//		acctSynDetail.setProvince(projAcct.getBankProv());// ����������ʡ
//		acctSynDetail.setCity(projAcct.getBankCity());// ������������
//		acctSynDetail.setBankName(projAcct.getOpnBank());// ����������
//		acctSynDetail.setSettlementFlag(projAcct.getSellFlag());// ���к���ϸ
//		String bodyXml = XMLUtil.createBody(acctSynDetail);// ת��ΪXML
//		String xml = headXml + bodyXml + "</Package>";
//		System.out.println(xml);
//		// ���ýӿ�
//		Date d1 = new Date();
//		ZfTradeService ZfTradeService = (ZfTradeService) SourceTemplate
//				.getSpringContextInstance().getBean("zfTradeService");
//		String result = ZfTradeService.doAction("A100002", xml);
//		Date d2 = new Date();
//		System.out.println(result);
//
//		Document document = null;
//		try {
//			document = DocumentHelper.parseText(result);
//		} catch (DocumentException e) {
//			e.printStackTrace();
//		}
//		Element root = document.getRootElement();
//		Element eHeader = root.element("Header");
//
//		Element eResultCode = eHeader.element("ResultCode");
//		String resultCode = eResultCode.getText();
//
//		Element eResultMsg = eHeader.element("ResultMsg");
//		String resultMsg = eResultMsg.getText();
//
//		String wsSts = "01";
//		if ("1".equals(resultCode)) {
//			wsSts = "02";
//			if ("1".equals(sendSts)) {
//				projAcct.setSendSts("2");
//				projAcctBo.updateSts(projAcct);
//				this.addActionError("��Ŀ�˻������ɹ���");
//			} else if ("2".equals(sendSts)) {
//				this.addActionError("��Ŀ�˻��޸ĳɹ���");
//			} else if ("0".equals(sendSts)) {
//				projAcct.setSendSts("1");
//				projAcctBo.updateSts(projAcct);
//				this.addActionError("��Ŀ�˻�ע���ɹ���");
//			}
//		} else {
//			this.addActionError("����ͬ��ʧ�ܣ�֧��ƽ̨���أ�" + resultMsg + "!");
//		}
//		//��ѯ�����������
//		projBase = new ProjBase();
//		projBase.setProjNo(projNo);
//		projBase = projBaseBo.getById(projBase);
//		
//		WsBase wsBase = new WsBase();
//		SimpleDateFormat wsTimeFormater = new SimpleDateFormat(
//				"yyyyMMdd HH:mm:ss");
//		wsBase.setWsTime(wsTimeFormater.format(d1));
//		wsBase.setRespTime(wsTimeFormater.format(d2));
//		wsBase.setTxCode("A100002");
//		wsBase.setWsSerial("00014");
//		wsBase.setRespCode(resultCode);
//		wsBase.setRespDesc("֧��ƽ̨���أ�" + resultMsg + "");
//		wsBase.setWsSts(wsSts);
//		wsBase.setReqContent(xml);
//		wsBase.setRespContent(result);
//		wsBase.setBrNo(projBase.getBrNo());
//		wsBaseBo.insert(wsBase);
//		return findByPageToProj_Read();
//	}
//	// ͬ������
//	public String acctSynMes(ProjAcct projAcct,String sendSts) throws Exception {
//		String projNo = projAcct.getProjNo();//��ȡ��Ŀ���
//		// ����ͷ
//		SimpleDateFormat timeFormater = new SimpleDateFormat(
//				"yyyy-MM-dd HH:mm:ss");
//		AcctSynHead acctSynHead = new AcctSynHead();
//		acctSynHead.setRequestType("A100002");
//		acctSynHead.setUUID("00014");// ������ˮ��
//		acctSynHead.setComId("0001");
//		acctSynHead.setComIP("211.168.22.111");
//		acctSynHead.setFrom("1881632261");
//		acctSynHead.setSystemName("16133001");
//		acctSynHead.setSystemPassword("111111");
//		acctSynHead.setSendTime(timeFormater.format(new Date()));
//		acctSynHead.setAsyn("0");
//		acctSynHead.setReturnUrl("http://ufc.esb.cost.com/cooperation/");
//		acctSynHead.setSigned("");
//		acctSynHead.setItSystem("0");
//		String headXml = XMLUtil.createHead(acctSynHead); // ͷ�ļ�
//		// ����ʵ��
//		AcctSynDetail acctSynDetail = new AcctSynDetail();
//		acctSynDetail.setAccountNo(projAcct.getAcctNo());// �˻���
//		acctSynDetail.setOperaType(sendSts);
//		if(projAcct.getAcctName()==null||"".equals(projAcct.getAcctName())){
//			return "�˻����Ʋ���Ϊ�գ�";
//		}
//		acctSynDetail.setAccountName(projAcct.getAcctName()); // �˻�����
//		if(projAcct.getProjId()==null||"".equals(projAcct.getProjId())){
//			return "���˻�����Ϊ�գ�";
//		}
//		acctSynDetail.setBelongTo(projAcct.getProjId());// ���˻�
//		if(projAcct.getOrgNo()==null||"".equals(projAcct.getOrgNo())){
//			return "�����Ų���Ϊ�գ�";
//		}
//		acctSynDetail.setOrgNo(projAcct.getOrgNo());// ������
//		//�˻�����
//		if("02".equals(projAcct.getAcctType())){
//			acctSynDetail.setAccountType("01");
//		}else{
//			return "ֻ�������⻧ͬ�������˻����ݣ�";
//		}
//		acctSynDetail.setMaxAmount(""); // �����޶�
//		if(projAcct.getCardChn()==null||"".equals(projAcct.getCardChn())){
//			return "�����˻���������Ϊ�գ�";
//		}
//		acctSynDetail.setPayChannel(projAcct.getCardChn()); // ������������
//		acctSynDetail.setProvince(projAcct.getBankProv());// ����������ʡ
//		acctSynDetail.setCity(projAcct.getBankCity());// ������������
//		acctSynDetail.setBankName(projAcct.getOpnBank());// ����������
//		acctSynDetail.setSettlementFlag(projAcct.getSellFlag());// ���к���ϸ
//		String bodyXml = XMLUtil.createBody(acctSynDetail);// ת��ΪXML
//		String xml = headXml + bodyXml + "</Package>";
//		System.out.println(xml);
//		// ���ýӿ�
//		Date d1 = new Date();
//		ZfTradeService ZfTradeService = (ZfTradeService) SourceTemplate
//				.getSpringContextInstance().getBean("zfTradeService");
//		String result = ZfTradeService.doAction("A100002", xml);
//		Date d2 = new Date();
//		System.out.println(result);
//
//		Document document = null;
//		try {
//			document = DocumentHelper.parseText(result);
//		} catch (DocumentException e) {
//			e.printStackTrace();
//		}
//		Element root = document.getRootElement();
//		Element eHeader = root.element("Header");
//
//		Element eResultCode = eHeader.element("ResultCode");
//		String resultCode = eResultCode.getText();
//
//		Element eResultMsg = eHeader.element("ResultMsg");
//		String resultMsg = eResultMsg.getText();
//
//		String wsSts = "01";
//		if ("1".equals(resultCode)) {
//			wsSts = "02";
//		}
//		//��ѯ�����������
//		projBase = new ProjBase();
//		projBase.setProjNo(projNo);
//		projBase = projBaseBo.getById(projBase);
//		
//		WsBase wsBase = new WsBase();
//		SimpleDateFormat wsTimeFormater = new SimpleDateFormat(
//				"yyyyMMdd HH:mm:ss");
//		wsBase.setWsTime(wsTimeFormater.format(d1));
//		wsBase.setRespTime(wsTimeFormater.format(d2));
//		wsBase.setTxCode("A100002");
//		wsBase.setWsSerial("00014");
//		wsBase.setRespCode(resultCode);
//		wsBase.setRespDesc("֧��ƽ̨���أ�" + resultMsg + "");
//		wsBase.setWsSts(wsSts);
//		wsBase.setReqContent(xml);
//		wsBase.setRespContent(result);
//		wsBase.setBrNo(projBase.getBrNo());
//		wsBaseBo.insert(wsBase);
//		if("1".equals(resultCode)||"0045".equals(resultCode)){
//			return "1";
//		}else{
//			return "֧��ƽ̨���أ�" + resultMsg + "!";
//		}
//	}
	
	
	
//   ����ѯ
//	public String acctBalMes() throws Exception {
//
//		ProjAcct projAcct = new ProjAcct();
//		projAcct.setAcctId(acctId);
//		projAcct = projAcctBo.getById(projAcct);
//		String projNo = projAcct.getProjNo();
//		if (projAcct == null || "".equals(projAcct)) {
//			this.addActionError("��Ŀ��š�" + projNo + "����Ӧ���˺Ų����ڣ�");
//			return findByPageToProj_Read();
//		}
//		SimpleDateFormat timeFormater = new SimpleDateFormat(
//				"yyyy-MM-dd HH:mm:ss");
//		// ����ͷ
//		AcctSynHead acctSynHead = new AcctSynHead();
//		acctSynHead.setRequestType("B100002");
//		acctSynHead.setUUID("00014");// ������ˮ��
//		acctSynHead.setComId("0001");
//		acctSynHead.setComIP("211.168.22.111");
//		acctSynHead.setFrom("1881632261");
//		acctSynHead.setSystemName("16133001");
//		acctSynHead.setSystemPassword("111111");
//
//		acctSynHead.setSendTime(timeFormater.format(new Date()));
//		acctSynHead.setAsyn("0");
//		acctSynHead.setReturnUrl("http://ufc.esb.cost.com/cooperation/");
//		acctSynHead.setSigned("");
//		acctSynHead.setItSystem("0");
//		String headXml = XMLUtil.createHead(acctSynHead); // ͷ�ļ�
//		// ����ʵ��
//		AcctBalDetail acctBalDetail = new AcctBalDetail();
//		acctBalDetail.setAccountNo(projAcct.getAcctNo());// �˻���
//		if("01".equals(acctType)){
//			acctBalDetail.setPayType("02");// ��������ר��
//			acctBalDetail.setPayChannel(""); // ������������
//		}else{
//			if(projAcct.getCardChn()==null||"".equals(projAcct.getCardChn())){
//				this.addActionError("�����˻���������Ϊ�գ�");
//				return findByPageToProj_Read();
//			}
//			acctBalDetail.setPayChannel(projAcct.getCardChn()); // ������������
//			acctBalDetail.setPayType("01");// �������͵�����
//		}
//		String bodyXml = XMLUtil.createBody(acctBalDetail);// ת��ΪXML
//		String xml = headXml + bodyXml + "</Package>";
//		System.out.println(xml);
//		// ���ýӿ�
//		Date d1 = new Date();
//		QueryService QueryService = (QueryService) SourceTemplate
//				.getSpringContextInstance().getBean("queryService");
//		String result = QueryService.doAction("B100002", xml);
//		Date d2 = new Date();
//		System.out.println(result);
//		Document document = null;
//		try {
//			document = DocumentHelper.parseText(result);
//		} catch (DocumentException e) {
//			e.printStackTrace();
//		}
//		Element root = document.getRootElement();
//		Element eHeader = root.element("Header");
//		Element eResultCode = eHeader.element("ResultCode");
//		String resultCode = eResultCode.getText();
//
//		Element eResultMsg = eHeader.element("ResultMsg");
//		String resultMsg = eResultMsg.getText();
//
//		String wsSts = "01";
//		if ("1".equals(resultCode)) {
//			wsSts = "02";
//			Element eBody = root.element("Body");
//			Element eBalanceInfoList = eBody.element("BalanceInfoList");
//			Element eBalanceInfo = eBalanceInfoList.element("BalanceInfo");
//			Element eBalance = eBalanceInfo.element("Balance");
//			Double money = Double.valueOf(eBalance.getText()) / 100;
//			// resultMsg = resultMsg+"�˻����= "+s+"";
//			projAcct.setAcctBal(money);
//			projAcctBo.update(projAcct);
//			this.addActionError("����ͬ���ɹ����˻����=" + new DecimalFormat("######################.00").format(money) + "Ԫ");
//		} else {
//			this.addActionError("����ͬ��ʧ�ܣ�֧��ƽ̨���أ�" + resultMsg + "!");
//		}
//		//��ѯ�����������
//		projBase = new ProjBase();
//		projBase.setProjNo(projNo);
//		projBase = projBaseBo.getById(projBase);
//		
//		WsBase wsBase = new WsBase();
//		SimpleDateFormat wsTimeFormater = new SimpleDateFormat(
//				"yyyyMMdd HH:mm:ss");
//		wsBase.setWsTime(wsTimeFormater.format(d1));
//		wsBase.setRespTime(wsTimeFormater.format(d2));
//		wsBase.setTxCode("B100002");
//		wsBase.setWsSerial("00014");
//		wsBase.setRespCode(resultCode);
//		wsBase.setRespDesc("֧��ƽ̨���أ�" + resultMsg + "");
//		wsBase.setWsSts(wsSts);
//		wsBase.setReqContent(xml);
//		wsBase.setRespContent(result);
//		wsBase.setBrNo(projBase.getBrNo());
//		wsBaseBo.insert(wsBase);
//
//		return findByPageToProj_Read();
//	}
		//��ѯ���
	public String serchAcctBal() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),ServletActionContext.getResponse());
		
		ProjAcct projAcct = new ProjAcct();
		projAcct.setAcctId(acctId);
		projAcct = projAcctBo.getById(projAcct);
		
		String acctNo = projAcct.getAcctNo();
////		projAcct.setAcctId(acctId);
//		projAcct = projAcctBo.getById(projAcct);    		

		/*
		AcctSerchDetail acctSerchDetail = new AcctSerchDetail();
//		acctSerchDetail.setNo(projNo);//���ƴ�����룬NoΪ�˻��ţ��˴�set����Ŀ���
		
		acctSerchDetail.setNo(acctNo);
//		acctSerchDetail.setQueryType("03");//����0907�·��ĵ����޴�����
		acctSerchDetail.setChannelNo("");
		ResultMes resultMes = SendZFService.serchAcctXML(acctSerchDetail, "");
		if ("1".equals(resultMes.getResultCode())){
			List<BalanceInfo> balanceInfoList = resultMes.getBalanceInfoList();
			for (int i=0;i<balanceInfoList.size();i++){
				BalanceInfo balanceInfo = balanceInfoList.get(i);
//				ProjAcct projAcct= new ProjAcct();
				projAcct.setAcctNo(balanceInfo.getAccountNo());
				projAcct.setAcctBal(Double.valueOf(balanceInfo.getBalance())/100);
				projAcctBo.updateAcctBal(projAcct);
			}
			this.addActionMessage("ͬ�����ɹ���");
		}else{
			this.addActionMessage("��ѯ���ʧ�ܣ�"+resultMes.getResultMsg());
		}
		*/
		return findByPageToProj_Read();
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
		formproj0007 = formService.getFormData("proj0007");
		projAcct = new ProjAcct();
		projAcct.setTxDate(txDate);
		projAcct.setUpOpno(upOpno);
		projAcct.setDeptNo(deptNo);
		projAcct.setAcctDesc(acctDesc);
		projAcct.setAcctId(acctId);
		projAcct.setAcctName(acctName);
		projAcct.setUpDate(upDate);
		projAcct.setCardNo(cardNo);
		projAcct.setAcctBal(acctBal);
		projAcct.setAcctUse(acctUse);
		projAcct.setAcctType(acctType);
		projAcct.setProjName(projName);
		projAcct.setOpNo(opNo);
		projAcct.setFiller(filler);
		projAcct.setProjNo(projNo);
		projAcct.setOpnBank(opnBank);
		projAcct.setAcctNo(acctNo);
		projAcctBo.del(projAcct);
		this.addActionMessage("ɾ���ɹ�");
		projAcct = new ProjAcct();
		Ipage ipage = this.getIpage();
		projAcct.setAcctType(acctType);
		projAcctList = (List) projAcctBo.findByPage(ipage, projAcct)
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
		formproj0008 = formService.getFormData("proj0008");
		formproj0016 = formService.getFormData("proj0016");
		formproj0017 = formService.getFormData("proj0017");
		formproj0020 = formService.getFormData("proj0020");
		projAcct = new ProjAcct();

		projAcct.setAcctId(acctId);
		projAcct.setProjNo(projNo);
		projAcct.setAcctType(acctType);
		projAcct.setProjName(projName);
		projAcct.setUpDate(User.getSys_date(ServletActionContext.getRequest()));// �޸�����
		projAcct.setUpOpno(User.getLoginid(ServletActionContext.getRequest()));// �޸���Ա
		projAcct.setAcctNo(acctNo);
		projAcct = projAcctBo.getById(projAcct);
		if ("query".equals(query)) {// ������������ʾ����������ʡ��
			if("01".equals(projAcct.getAcctType())){
				getObjValue(formproj0017, projAcct);
			}else{
				getObjValue(formproj0016, projAcct);
			}
			
		} else {
			if("01".equals(projAcct.getAcctType())){
				getObjValue(formproj0020, projAcct);
			}else{
				getObjValue(formproj0008, projAcct);
			}
			
		}
		//�ж�Ϊר����ʱ�򣬲���ʾ  �����˻�����
		if("01".equals(projAcct.getAcctType())){
			return "detailForZ";
		}else{
			return "detail";
		}
		
	}
	/**
	 * ��ѯ����
	 * 
	 * @return
	 * @throws Exception
	 */
	public String getByIdXQ() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),
				ServletActionContext.getResponse());
		if("01".equals(acctType)){//ר��
			formproj0020 = formService.getFormData("proj0020");
			projAcct = new ProjAcct();
			projAcct.setAcctId(acctId);
			projAcct = projAcctBo.getById(projAcct);
			getObjValue(formproj0020, projAcct);
			return "detailForZ";
		}else if("02".equals(acctType)){//����������
			formproj0008 = formService.getFormData("proj0008");
			projAcct = new ProjAcct();
			projAcct.setAcctId(acctId);
			projAcct = projAcctBo.getById(projAcct);
			getObjValue(formproj0008, projAcct);
			return "detail";
		}else{//�ſ�ۿ��˻�
			formproj0030 = formService.getFormData("proj0030");
			projAcct = new ProjAcct();
			projAcct.setAcctId(acctId);
			projAcct = projAcctBo.getById(projAcct);
			getObjValue(formproj0030, projAcct);
			return "detailForFK";
		}
		
	}
	/**
	 * ��ѯ����
	 * 
	 * @return
	 * @throws Exception
	 */
	public String getById_Read() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),
				ServletActionContext.getResponse());
		formproj0008 = formService.getFormData("proj0008");
		formproj0016 = formService.getFormData("proj0016");
		projAcct = new ProjAcct();

		projAcct.setAcctId(acctId);
		projAcct.setProjNo(projNo);
		projAcct.setAcctType(acctType);
		projAcct.setProjName(projName);
		projAcct.setUpDate(User.getSys_date(ServletActionContext.getRequest()));// �޸�����
		projAcct.setUpOpno(User.getLoginid(ServletActionContext.getRequest()));// �޸���Ա
		projAcct.setAcctNo(acctNo);
		projAcct = projAcctBo.getById(projAcct);
		if ("query".equals(query)) {
			getObjValue(formproj0016, projAcct);
		} else {
			getObjValue(formproj0008, projAcct);
		}
		return "detail_Read";
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
		formproj0008 = formService.getFormData("proj0008");
		getFormValue(formproj0008);
		validateFormData(formproj0008);
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
		formproj0008 = formService.getFormData("proj0008");
			getFormValue(formproj0008);
			validateFormData(formproj0008);
	}

	/**
	 * ������Ŀ��ʾ���еĵ��˻� ��Ϣ
	 * 
	 * @return
	 * @throws Exception
	 */
	public String listQuotaForCorp() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),
				ServletActionContext.getResponse());
		if (projNo == null || "".equals(projNo)) {
			this.addActionMessage("������  ��Ŀ��Ϣ �в�¼С΢��Ŀ��ţ�");
			return "   ";
		} else {
			projAcct = new ProjAcct();
			projAcct.setProjNo(projNo);
			Ipage ipage = this.getIpage();
			projAcctList = (List) projAcctBo.findByPageQuotaForCorp(ipage,
					projAcct).getResult();
			return "list";
		}

	}

	/**
	 * @���� DHCC-ZLC
	 * @���� 2016-8-13
	 * @����˵����
	 * @���ز��� String
	 */
	public String findByProjNoAndAcctType() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),
				ServletActionContext.getResponse());
		projAcct = new ProjAcct();
		projAcct.setProjNo(projNo);
		projAcct.setAcctType(acctType);
		Ipage ipage = this.getIpage();
		projAcctList = (List) projAcctBo.findByProjNoAndAcctType(ipage,
				projAcct).getResult();
		if ("01".equals(acctType)) {
			return "list1";
		} else {
			return "list2";
		}
	}
	public String findByProjNoToFK() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),
				ServletActionContext.getResponse());
		projAcct = new ProjAcct();
		projAcct.setProjNo(projNo);
		Ipage ipage = this.getIpage();
		projAcctList = projAcctBo.findListByProjNo(projAcct);
		return "list";
	}
	/**
	 * @���� DHCC-ZLC
	 * @���� 2016-8-22
	 * @����˵����δ���ֽ���Ԥ��
	 * @���ز��� String
	 */
	public String future_cash_flow() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),
				ServletActionContext.getResponse());

		String nowDate = DateUtil.addByDay((User.getTime().replace("-", ""))
				.substring(0, 8), -1);
		String beginDate = DateUtil.addByDay(nowDate, -30);
		endDate = endDate.replace("-", "");
		// Ԥ������
		int between_Date = DateUtil.getBetweenDays(DateUtil
				.changeToShow(nowDate), DateUtil.changeToShow(endDate)) + 1;
		// 1.���ʽ���Ϣ��ȡ30��׷���ʽ�ƽ��ֵ
		FundDetail fundDetail = new FundDetail();
		fundDetail.setTxDate(nowDate);
		fundDetail.setTradeType("01");
		fundDetail.setFundNo(projNo);
		Double add_bal_avg = fundDetailBo.getBalBytradeType(fundDetail);

		// 2.���������
		FundRepayPlan fundRepayPlan = new FundRepayPlan();
		fundRepayPlan.setRepayDate(nowDate);
		fundRepayPlan.setFiller(endDate);
		fundRepayPlan.setFundNo(projNo);
		double repay_bal_back = fundRepayPlanBo.getBalByDate(fundRepayPlan);

		// 3.����������ع�����ר�����
		RptProj rptProj = new RptProj();
		rptProj.setProjNo(projNo);
		rptProj.setRptDate(beginDate);
		// ��ʼ���ڻ�ȡ
		RptProj rptProj1 = rptProjBo.getDailyById(rptProj);
		// �������ڻ�ȡ
		rptProj.setRptDate(nowDate);
		RptProj rptProj2 = rptProjBo.getDailyById(rptProj);
		if (rptProj1 == null) {
			rptProj1 = new RptProj();
			rptProj1.setRepayTot(0.0);
			rptProj1.setIntstTot(0.0);
			rptProj1.setFineTot(0.0);
			rptProj1.setCompAmt(0.0);
			rptProj1.setRebuyAmt(0.0);
		}
		if (rptProj2 == null) {
			rptProj2 = new RptProj();
			rptProj2.setRepayTot(0.0);
			rptProj2.setIntstTot(0.0);
			rptProj2.setFineTot(0.0);
			rptProj2.setCompAmt(0.0);
			rptProj2.setRebuyAmt(0.0);
		}
		// 3.1��ȡƽ�������
		double repay_avg = DateUtil
				.DoDcm(
						rptProj2.getRepayTot()
								+ rptProj2.getIntstTot()
								+ rptProj2.getFineTot()
								- (rptProj1.getRepayTot()
										+ rptProj1.getIntstTot() + rptProj1
										.getFineTot())).divide(
						DateUtil.IoDcm(30), 3, BigDecimal.ROUND_HALF_UP)
				.doubleValue();
		// 3.2��ȡƽ���������
		double comp_amt_avg = DateUtil.DoDcm(
				rptProj2.getCompAmt() - rptProj1.getCompAmt()).divide(
				DateUtil.IoDcm(30), 3, BigDecimal.ROUND_HALF_UP).doubleValue();
		// 3.3��ȡƽ��ع����
		double rebuy_amt_avg = DateUtil.DoDcm(
				rptProj2.getRebuyAmt() - rptProj1.getRebuyAmt()).divide(
				DateUtil.IoDcm(30), 3, BigDecimal.ROUND_HALF_UP).doubleValue();

		// 4.��ȡƽ���Ҹ����ֵ
		FundPayPlan fundPayPlan = new FundPayPlan();
		fundPayPlan.setPayDate(nowDate);
		fundPayPlan.setWarnDate(endDate);
		fundPayPlan.setFundNo(projNo);
		double pay_bal_out = fundPayPlanBo.getBalByDate(fundPayPlan);

		// 5.��ȡƽ���ſ�� AMT_AVG
		double amt_avg = rptProj2.getAmtAvg();
		// ���
		double inAmt = add_bal_avg * between_Date + repay_bal_back
				+ (repay_avg + comp_amt_avg + rebuy_amt_avg) * between_Date;
		// ����
		double outAmt = pay_bal_out + amt_avg * between_Date;
		// ʣ��
		double restAmt = inAmt - outAmt + rptProj2.getAccBal();
		futureCashFlow = new FutureCashFlow();
		futureCashFlow.setInAmt(inAmt);
		futureCashFlow.setOutAmt(outAmt);
		futureCashFlow.setRestAmt(restAmt);
		PrintWriter out = this.getHttpResponse().getWriter();
		JSON json = (JSON) JSON.toJSON(futureCashFlow);
		out.print(json);

		return null;

	}

	/**
	 * @���� DHCC-ZLC
	 * @���� 2016-8-22
	 * @����˵���������˻�����
	 * @���ز��� String
	 */
	public String virtual_account_calculaor() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),
				ServletActionContext.getResponse());

		String nowDate = DateUtil.addByDay((User.getTime().replace("-", ""))
				.substring(0, 8), -1);
		endDate = endDate.replace("-", "");
		int days = 0;
		double bal = 0.00;
		// Ԥ������
		// �����˻����
		projAcct = new ProjAcct();
		projAcct.setAcctId(acctId);
		projAcct = projAcctBo.getById(projAcct);

		RptProj rptProj = new RptProj();
		rptProj.setProjNo(projNo);
		rptProj.setRptDate(nowDate);
		rptProj = rptProjBo.getDailyById(rptProj);
		if(rptProj!=null){
			if ("01".equals(CalCulType)) {
				// ʱ�����
				// 1.��������
				days = (int) Math
						.floor(projAcct.getAcctBal() / rptProj.getAmtTot());
				// 2.ʣ����
				bal = projAcct.getAcctBal() % rptProj.getAmtTot();
				futureCashFlow = new FutureCashFlow();
				futureCashFlow.setUserDays(days);
				futureCashFlow.setBal(bal);
				futureCashFlow.setCalCulType(CalCulType);
			} else {
				// ������
				// 1.��������
				days = DateUtil.getBetweenDays(DateUtil.changeToShow(nowDate),
						DateUtil.changeToShow(endDate)) + 1;
				;
				// 2.���ý��
				double userAmt = rptProj.getAmtTot() * days;
				// 3.ʣ����
				bal = projAcct.getAcctBal() - userAmt;
				futureCashFlow = new FutureCashFlow();
				futureCashFlow.setUserAmt(userAmt);
				futureCashFlow.setBal(bal);
				futureCashFlow.setCalCulType(CalCulType);
				PrintWriter out = this.getHttpResponse().getWriter();
				JSON json = (JSON) JSON.toJSON(futureCashFlow);
				out.print(json);
			}
		}
		return null;
	}

	/**
	 * @���� DHCC-ZLC
	 * @���� 2016-8-22
	 * @����˵���������˻�Ԥ����
	 * @���ز��� String
	 */
	public String virtual_AllocateReg() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),
				ServletActionContext.getResponse());
		ServletActionContext.getResponse().setCharacterEncoding("utf-8");
		memo = java.net.URLDecoder.decode(memo, "UTF-8");
		transreason = java.net.URLDecoder.decode(transreason, "UTF-8");
		purpose = java.net.URLDecoder.decode(purpose, "UTF-8");
		opbankprovince = java.net.URLDecoder.decode(opbankprovince, "UTF-8");
		opbankcity = java.net.URLDecoder.decode(opbankcity, "UTF-8");
		project = java.net.URLDecoder.decode(project, "UTF-8");
		customer = java.net.URLDecoder.decode(customer, "UTF-8");
		industry = java.net.URLDecoder.decode(industry, "UTF-8");
		opbankacntname = java.net.URLDecoder.decode(opbankacntname, "UTF-8");
		opbankname = java.net.URLDecoder.decode(opbankname, "UTF-8");
		projAcct = new ProjAcct();
		AllocateRegWsIn allocateRegWsIn = new AllocateRegWsIn();
		// ������Ϣ
		allocateRegWsIn.setId(id);
		allocateRegWsIn.setBusinessflag(businessflag);
		allocateRegWsIn.setAutoSyncFlag("2");
		allocateRegWsIn.setProjectid(projNo);
		allocateRegWsIn.setDdtype(ddtype);
		allocateRegWsIn.setTransdate(transdate);
		allocateRegWsIn.setTransreason(transreason);
		allocateRegWsIn.setPurpose(purpose);
		allocateRegWsIn.setMemo(memo);
		allocateRegWsIn.setUserCode(userCode);
		allocateRegWsIn.setStaffapp(staffapp);
		// ��ϸlist
		allocateRegWsIn.setAmount(amount);
		allocateRegWsIn.setBktranstypecode(bktranstypecode);
		allocateRegWsIn.setSktranstypecode(sktranstypecode);
		allocateRegWsIn.setFeetypecode(feetypecode);
		allocateRegWsIn.setTaxtypecode(taxtypecode);
		allocateRegWsIn.setCustomid(customid);
		allocateRegWsIn.setAccountid(accountid);//
		// allocateRegWsIn.setOpbankacntid(opbankacntid);
		allocateRegWsIn.setOpbankacntno(opbankacntno);
		allocateRegWsIn.setOpbankname(opbankname);
		allocateRegWsIn.setOpbankacntname(opbankacntname);
		allocateRegWsIn.setOpbankprovince(opbankprovince);
		allocateRegWsIn.setOpbankcity(opbankcity);
		allocateRegWsIn.setRepaytypeid(repaytypeid);
		allocateRegWsIn.setAppusercode(appusercode);
		// ��������Ϊ������������
		allocateRegWsIn.setPersonnel("");
		allocateRegWsIn.setProject(project);
		allocateRegWsIn.setCustomer(customer);
		allocateRegWsIn.setCashflow("");
		allocateRegWsIn.setVirtualaccount("");
		allocateRegWsIn.setContractnumber("");
		allocateRegWsIn.setStockcode("");
		allocateRegWsIn.setFundaccount("");
		allocateRegWsIn.setSalesdepartment("");
		allocateRegWsIn.setChecknumber("");
		allocateRegWsIn.setBusinesstype("");
		allocateRegWsIn.setCashflowstatement("");
		allocateRegWsIn.setTaxcategory("");
		allocateRegWsIn.setInterestrate("");
		allocateRegWsIn.setIndustry(industry);
		allocateRegWsIn.setStock("");
		allocateRegWsIn.setAssetname("");
		allocateRegWsIn.setProductname("");
		allocateRegWsIn.setClientorbeneficiary("");
		allocateRegWsIn.setShareholder("");
		allocateRegWsIn.setEntrustcontractnumber("");
		allocateRegWsIn.setTradingpurpose("");
		allocateRegWsIn.setContractvariety("");
		allocateRegWsIn.setDateofreceipt("");
		allocateRegWsIn.setInterestdate("");
		allocateRegWsIn.setDuedate("");
		allocateRegWsIn.setInorout("");
		allocateRegWsIn.setBillnumber("");
		allocateRegWsIn.setAcctId(acctId);
		projAcct = projAcctBo.virtual_AllocateReg(allocateRegWsIn);
		PrintWriter out = this.getHttpResponse().getWriter();
		JSON json = (JSON) JSON.toJSON(projAcct);
		out.print(json);
		return null;

	}

	/**
	 * @���� DHCC-ZLC
	 * @���� 2016-8-22
	 * @����˵�������ݲ����ղ���������ݽ��з���
	 * @���ز��� String
	 */
	public String insert_allocateRegWsIn() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),
				ServletActionContext.getResponse());
		AllocateRegWsIn allocateRegWsIn = new AllocateRegWsIn();
		opNo = User.getLoginid(this.getHttpRequest());
		allocateRegWsIn = projAcctBo.insert_allocateRegWsIn(projNo, txAmt,
				acctId, opNo, tradeCode);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		JSON json = (JSON) JSON.toJSON(allocateRegWsIn);
		if(allocateRegWsIn.getAccountid()==null){
			json = null;
		}
		out.print(json);
		return null;

	}

	public String getTab() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),
				ServletActionContext.getResponse());
		tabList = new ArrayList();
		String[] tab = null;

//		System.out.println("=========isFlag=======" + isFlag
//				+ "======acctType========" + acctType + "====projNo======="
//				+ projNo);

		if (acctType != null && acctType.equals("01")) {
			tab = new String[2];
			tab[0] = "ר����Ϣ";
			tab[1] = "ProjAcctAction_getById_Read.action?acctId=" + acctId
					+ "&acctType=" + acctType + "&query=query&projNo=" + projNo;
			tabList.add(tab);

			tab = new String[2];
			tab[0] = "ר����ˮ";
			tab[1] = "ProjAcctLstAction_listQuotaForCorp_Read.action?acctId="
					+ acctId + "&acctType=" + acctType + "&query=query&projNo="
					+ projNo;
			tabList.add(tab);

		} else {

			tab = new String[2];
			tab[0] = "�����˻���Ϣ";
			tab[1] = "ProjAcctAction_getById.action?acctId=" + acctId
					+ "&acctType=" + acctType + "&query=query&projNo=" + projNo;
			tabList.add(tab);

			tab = new String[2];
			tab[0] = "�����˻���Ϣ��ˮ";
			tab[1] = "ProjAcctLstAction_listQuotaForCorp.action?acctId="
					+ acctId + "&acctType=" + acctType + "&query=query&projNo="
					+ projNo;
			tabList.add(tab);
		}

		return "tab";
	}

	// �ʽ�ͬ��
	public String fundsync() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),
				ServletActionContext.getResponse());
		
		projAcct = new ProjAcct();
		projAcct.setAcctId(acctId);
		projAcct = projAcctBo.getById(projAcct);
		String projNo = projAcct.getProjNo();//��ȡ��Ŀ���
		if (projAcct == null || "".equals(projAcct)) {
			this.addActionError("��Ŀ��š�" + projNo + "����Ӧ���˺Ų����ڣ�");
			if ("01".equals(acctType)) {
				return "list1";
			} else {
				return "list2";
			}
		}
		SimpleDateFormat timeFormater = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		/*
		// ����ͷ
		AcctSynHead acctSynHead = new AcctSynHead();
		acctSynHead.setRequestType("B100002");
		acctSynHead.setUUID("00014");// ������ˮ��
		acctSynHead.setComId("0001");
		acctSynHead.setComIP("211.168.22.111");
		acctSynHead.setFrom("1881632261");
		acctSynHead.setSystemName("16133001");
		acctSynHead.setSystemPassword("111111");

		acctSynHead.setSendTime(timeFormater.format(new Date()));
		acctSynHead.setAsyn("0");
		acctSynHead.setReturnUrl("http://ufc.esb.cost.com/cooperation/");
		acctSynHead.setSigned("");
		acctSynHead.setItSystem("0");
		String headXml = XMLUtil.createHead(acctSynHead); // ͷ�ļ�
		// ����ʵ��
		AcctBalDetail acctBalDetail = new AcctBalDetail();
		acctBalDetail.setAccountNo(projAcct.getAcctNo());// �˻���
		acctBalDetail.setPayChannel(projAcct.getCardChn()); // ������������
		acctBalDetail.setPayType("01");// ��������

		String bodyXml = XMLUtil.createBody(acctBalDetail);// ת��ΪXML
		String xml = headXml + bodyXml + "</Package>";
		System.out.println(xml);
		// ���ýӿ�
		 
		 
		Date d1 = new Date();
		QueryService QueryService = (QueryService) SourceTemplate
				.getSpringContextInstance().getBean("queryService");
		String result = QueryService.doAction("B100002", xml);
		Date d2 = new Date();
		System.out.println(result);
		Document document = null;
		try {
			document = DocumentHelper.parseText(result);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		Element root = document.getRootElement();
		Element eHeader = root.element("Header");
		Element eResultCode = eHeader.element("ResultCode");
		String resultCode = eResultCode.getText();

		Element eResultMsg = eHeader.element("ResultMsg");
		String resultMsg = eResultMsg.getText();

		String wsSts = "01";
		if ("1".equals(resultCode)) {
			wsSts = "02";
			Element eBody = root.element("Body");
			Element eBalanceInfoList = eBody.element("BalanceInfoList");
			Element eBalanceInfo = eBalanceInfoList.element("BalanceInfo");
			Element eBalance = eBalanceInfo.element("Balance");
			Double money = Double.valueOf(eBalance.getText()) / 100;
			// resultMsg = resultMsg+"�˻����= "+s+"";
			projAcct.setAcctBal(money);
			projAcctBo.update(projAcct);
			this.addActionError("����ͬ���ɹ����˻����=" + money + "Ԫ");
		} else {
			this.addActionError("����ͬ��ʧ�ܣ�֧��ƽ̨���أ�" + resultMsg + "!");
		}
		*/

		//��ѯ�����������
		projBase = new ProjBase();
		projBase.setProjNo(projNo);
		projBase = projBaseBo.getById(projBase);
		
		/*
		WsBase wsBase = new WsBase();
		SimpleDateFormat wsTimeFormater = new SimpleDateFormat(
				"yyyyMMdd HH:mm:ss");
		wsBase.setWsTime(wsTimeFormater.format(d1));
		wsBase.setRespTime(wsTimeFormater.format(d2));
		wsBase.setTxCode("A100002");
		wsBase.setWsSerial("00014");
		wsBase.setRespCode(resultCode);
		wsBase.setRespDesc("֧��ƽ̨���أ�" + resultMsg + "");
		wsBase.setWsSts(wsSts);
		wsBase.setReqContent(xml);
		wsBase.setRespContent(result);
		wsBase.setBrNo(projBase.getBrNo());
		wsBaseBo.insert(wsBase);
		*/
	
		
		
		projAcct = new ProjAcct();
		projAcct.setProjNo(projNo);
		projAcct.setAcctId(acctId);
		projAcct.setAcctType(acctType);
		Ipage ipage = this.getIpage();
		projAcctList = (List) projAcctBo.findByProjNoAndAcctType(ipage,
				projAcct).getResult();
		if ("01".equals(acctType)) {
			return "list1";
		} else {
			return "list2";
		}

	}

	public ProjAcct getProjAcct() {
		return projAcct;
	}

	public void setProjAcct(ProjAcct projAcct) {
		this.projAcct = projAcct;
	}

	public List<ProjAcct> getProjAcctList() {
		return projAcctList;
	}

	public void setProjAcctList(List<ProjAcct> projAcctList) {
		this.projAcctList = projAcctList;
	}

	public ProjAcctBo getProjAcctBo() {
		return projAcctBo;
	}

	public void setProjAcctBo(ProjAcctBo projAcctBo) {
		this.projAcctBo = projAcctBo;
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public FormData getFormproj0008() {
		return formproj0008;
	}

	public void setFormproj0008(FormData formproj0008) {
		this.formproj0008 = formproj0008;
	}

	public FormData getFormproj0007() {
		return formproj0007;
	}

	public void setFormproj0007(FormData formproj0007) {
		this.formproj0007 = formproj0007;
	}

	public void setTxDate(String txDate) {
		this.txDate = txDate;
	}

	public void setUpOpno(String upOpno) {
		this.upOpno = upOpno;
	}

	public void setDeptNo(String deptNo) {
		this.deptNo = deptNo;
	}

	public void setAcctDesc(String acctDesc) {
		this.acctDesc = acctDesc;
	}

	public void setAcctId(String acctId) {
		this.acctId = acctId;
	}

	public void setAcctName(String acctName) {
		this.acctName = acctName;
	}

	public void setUpDate(String upDate) {
		this.upDate = upDate;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public void setAcctBal(Double acctBal) {
		this.acctBal = acctBal;
	}

	public void setAcctUse(String acctUse) {
		this.acctUse = acctUse;
	}

	public void setAcctType(String acctType) {
		this.acctType = acctType;
	}

	public void setProjName(String projName) {
		this.projName = projName;
	}

	public void setOpNo(String opNo) {
		this.opNo = opNo;
	}

	public void setFiller(String filler) {
		this.filler = filler;
	}

	public void setProjNo(String projNo) {
		this.projNo = projNo;
	}

	public void setOpnBank(String opnBank) {
		this.opnBank = opnBank;
	}

	public void setAcctNo(String acctNo) {
		this.acctNo = acctNo;
	}

	public String getTxDate() {
		return txDate;
	}

	public String getUpOpno() {
		return upOpno;
	}

	public String getDeptNo() {
		return deptNo;
	}

	public String getAcctDesc() {
		return acctDesc;
	}

	public String getAcctId() {
		return acctId;
	}

	public String getAcctName() {
		return acctName;
	}

	public String getUpDate() {
		return upDate;
	}

	public String getCardNo() {
		return cardNo;
	}

	public Double getAcctBal() {
		return acctBal;
	}

	public String getAcctUse() {
		return acctUse;
	}

	public String getAcctType() {
		return acctType;
	}

	public String getProjName() {
		return projName;
	}

	public String getOpNo() {
		return opNo;
	}

	public String getFiller() {
		return filler;
	}

	public String getProjNo() {
		return projNo;
	}

	public String getOpnBank() {
		return opnBank;
	}

	public String getAcctNo() {
		return acctNo;
	}

	public ProjBase getProjBase() {
		return projBase;
	}

	public void setProjBase(ProjBase projBase) {
		this.projBase = projBase;
	}

	public ProjBaseBo getProjBaseBo() {
		return projBaseBo;
	}

	public void setProjBaseBo(ProjBaseBo projBaseBo) {
		this.projBaseBo = projBaseBo;
	}

	public List getTabList() {
		return tabList;
	}

	public void setTabList(List tabList) {
		this.tabList = tabList;
	}

	public String getIsFlag() {
		return isFlag;
	}

	public void setIsFlag(String isFlag) {
		this.isFlag = isFlag;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public String getProjId() {
		return projId;
	}

	public void setProjId(String projId) {
		this.projId = projId;
	}

	public FundDetailBo getFundDetailBo() {
		return fundDetailBo;
	}

	public void setFundDetailBo(FundDetailBo fundDetailBo) {
		this.fundDetailBo = fundDetailBo;
	}

	public FundPayPlanBo getFundPayPlanBo() {
		return fundPayPlanBo;
	}

	public void setFundPayPlanBo(FundPayPlanBo fundPayPlanBo) {
		this.fundPayPlanBo = fundPayPlanBo;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	/**
	 * @return the rptProjBo
	 */
	public RptProjBo getRptProjBo() {
		return rptProjBo;
	}

	/**
	 * @param rptProjBo
	 *            the rptProjBo to set
	 */
	public void setRptProjBo(RptProjBo rptProjBo) {
		this.rptProjBo = rptProjBo;
	}

	public FundRepayPlanBo getFundRepayPlanBo() {
		return fundRepayPlanBo;
	}

	public void setFundRepayPlanBo(FundRepayPlanBo fundRepayPlanBo) {
		this.fundRepayPlanBo = fundRepayPlanBo;
	}

	public FutureCashFlow getFutureCashFlow() {
		return futureCashFlow;
	}

	public void setFutureCashFlow(FutureCashFlow futureCashFlow) {
		this.futureCashFlow = futureCashFlow;
	}

	public String getCalCulType() {
		return CalCulType;
	}

	public void setCalCulType(String calCulType) {
		CalCulType = calCulType;
	}

	/**
	 * @return the txAmt
	 */
	public double getTxAmt() {
		return txAmt;
	}

	/**
	 * @param txAmt
	 *            the txAmt to set
	 */
	public void setTxAmt(double txAmt) {
		this.txAmt = txAmt;
	}

	public FormData getFormproj0011() {
		return formproj0011;
	}

	public void setFormproj0011(FormData formproj0011) {
		this.formproj0011 = formproj0011;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the businessflag
	 */
	public String getBusinessflag() {
		return businessflag;
	}

	/**
	 * @param businessflag
	 *            the businessflag to set
	 */
	public void setBusinessflag(String businessflag) {
		this.businessflag = businessflag;
	}

	/**
	 * @return the projectid
	 */
	public String getProjectid() {
		return projectid;
	}

	/**
	 * @param projectid
	 *            the projectid to set
	 */
	public void setProjectid(String projectid) {
		this.projectid = projectid;
	}

	/**
	 * @return the ddtype
	 */
	public String getDdtype() {
		return ddtype;
	}

	/**
	 * @param ddtype
	 *            the ddtype to set
	 */
	public void setDdtype(String ddtype) {
		this.ddtype = ddtype;
	}

	/**
	 * @return the transdate
	 */
	public String getTransdate() {
		return transdate;
	}

	/**
	 * @param transdate
	 *            the transdate to set
	 */
	public void setTransdate(String transdate) {
		this.transdate = transdate;
	}

	/**
	 * @return the transreason
	 */
	public String getTransreason() {
		return transreason;
	}

	/**
	 * @param transreason
	 *            the transreason to set
	 */
	public void setTransreason(String transreason) {
		this.transreason = transreason;
	}

	/**
	 * @return the purpose
	 */
	public String getPurpose() {
		return purpose;
	}

	/**
	 * @param purpose
	 *            the purpose to set
	 */
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	/**
	 * @return the memo
	 */
	public String getMemo() {
		return memo;
	}

	/**
	 * @param memo
	 *            the memo to set
	 */
	public void setMemo(String memo) {
		this.memo = memo;
	}

	/**
	 * @return the amount
	 */
	public String getAmount() {
		return amount;
	}

	/**
	 * @param amount
	 *            the amount to set
	 */
	public void setAmount(String amount) {
		this.amount = amount;
	}

	/**
	 * @return the bktranstypecode
	 */
	public String getBktranstypecode() {
		return bktranstypecode;
	}

	/**
	 * @param bktranstypecode
	 *            the bktranstypecode to set
	 */
	public void setBktranstypecode(String bktranstypecode) {
		this.bktranstypecode = bktranstypecode;
	}

	/**
	 * @return the sktranstypecode
	 */
	public String getSktranstypecode() {
		return sktranstypecode;
	}

	/**
	 * @param sktranstypecode
	 *            the sktranstypecode to set
	 */
	public void setSktranstypecode(String sktranstypecode) {
		this.sktranstypecode = sktranstypecode;
	}

	/**
	 * @return the feetypecode
	 */
	public String getFeetypecode() {
		return feetypecode;
	}

	/**
	 * @param feetypecode
	 *            the feetypecode to set
	 */
	public void setFeetypecode(String feetypecode) {
		this.feetypecode = feetypecode;
	}

	/**
	 * @return the taxtypecode
	 */
	public String getTaxtypecode() {
		return taxtypecode;
	}

	/**
	 * @param taxtypecode
	 *            the taxtypecode to set
	 */
	public void setTaxtypecode(String taxtypecode) {
		this.taxtypecode = taxtypecode;
	}

	/**
	 * @return the customid
	 */
	public String getCustomid() {
		return customid;
	}

	/**
	 * @param customid
	 *            the customid to set
	 */
	public void setCustomid(String customid) {
		this.customid = customid;
	}

	/**
	 * @return the accountid
	 */
	public String getAccountid() {
		return accountid;
	}

	/**
	 * @param accountid
	 *            the accountid to set
	 */
	public void setAccountid(String accountid) {
		this.accountid = accountid;
	}

	/**
	 * @return the opbankacntno
	 */
	public String getOpbankacntno() {
		return opbankacntno;
	}

	/**
	 * @param opbankacntno
	 *            the opbankacntno to set
	 */
	public void setOpbankacntno(String opbankacntno) {
		this.opbankacntno = opbankacntno;
	}

	/**
	 * @return the opbankname
	 */
	public String getOpbankname() {
		return opbankname;
	}

	/**
	 * @param opbankname
	 *            the opbankname to set
	 */
	public void setOpbankname(String opbankname) {
		this.opbankname = opbankname;
	}

	/**
	 * @return the opbankacntname
	 */
	public String getOpbankacntname() {
		return opbankacntname;
	}

	/**
	 * @param opbankacntname
	 *            the opbankacntname to set
	 */
	public void setOpbankacntname(String opbankacntname) {
		this.opbankacntname = opbankacntname;
	}

	/**
	 * @return the opbankprovince
	 */
	public String getOpbankprovince() {
		return opbankprovince;
	}

	/**
	 * @param opbankprovince
	 *            the opbankprovince to set
	 */
	public void setOpbankprovince(String opbankprovince) {
		this.opbankprovince = opbankprovince;
	}

	/**
	 * @return the opbankcity
	 */
	public String getOpbankcity() {
		return opbankcity;
	}

	/**
	 * @param opbankcity
	 *            the opbankcity to set
	 */
	public void setOpbankcity(String opbankcity) {
		this.opbankcity = opbankcity;
	}

	/**
	 * @return the tradeCode
	 */
	public String getTradeCode() {
		return tradeCode;
	}

	/**
	 * @param tradeCode
	 *            the tradeCode to set
	 */
	public void setTradeCode(String tradeCode) {
		this.tradeCode = tradeCode;
	}

	/**
	 * @return the project
	 */
	public String getProject() {
		return project;
	}

	/**
	 * @param project
	 *            the project to set
	 */
	public void setProject(String project) {
		this.project = project;
	}

	/**
	 * @return the customer
	 */
	public String getCustomer() {
		return customer;
	}

	/**
	 * @param customer
	 *            the customer to set
	 */
	public void setCustomer(String customer) {
		this.customer = customer;
	}

	/**
	 * @return the industry
	 */
	public String getIndustry() {
		return industry;
	}

	/**
	 * @param industry
	 *            the industry to set
	 */
	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public FormData getFormproj0015() {
		return formproj0015;
	}

	public void setFormproj0015(FormData formproj0015) {
		this.formproj0015 = formproj0015;
	}

	/**
	 * @return the staffapp
	 */
	public String getStaffapp() {
		return staffapp;
	}

	/**
	 * @param staffapp
	 *            the staffapp to set
	 */
	public void setStaffapp(String staffapp) {
		this.staffapp = staffapp;
	}

	/**
	 * @return the repaytypeid
	 */
	public String getRepaytypeid() {
		return repaytypeid;
	}

	/**
	 * @param repaytypeid
	 *            the repaytypeid to set
	 */
	public void setRepaytypeid(String repaytypeid) {
		this.repaytypeid = repaytypeid;
	}

	/**
	 * @return the appUserCode
	 */
	public String getAppusercode() {
		return appusercode;
	}

	/**
	 * @param appUserCode
	 *            the appUserCode to set
	 */
	public void setAppusercode(String appusercode) {
		this.appusercode = appusercode;
	}

	public String getCardSts() {
		return cardSts;
	}

	public void setCardSts(String cardSts) {
		this.cardSts = cardSts;
	}

	/**
	 * @return the dataSts
	 */
	public String getBackSts() {
		return backSts;
	}

	/**
	 * @param dataSts
	 *            the dataSts to set
	 */
	public void setBackSts(String backSts) {
		this.backSts = backSts;
	}

	public WsBaseBo getWsBaseBo() {
		return wsBaseBo;
	}

	public void setWsBaseBo(WsBaseBo wsBaseBo) {
		this.wsBaseBo = wsBaseBo;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getAutoSyncFlag() {
		return autoSyncFlag;
	}

	public void setAutoSyncFlag(String autoSyncFlag) {
		this.autoSyncFlag = autoSyncFlag;
	}

	public FormData getFormproj0016() {
		return formproj0016;
	}

	public void setFormproj0016(FormData formproj0016) {
		this.formproj0016 = formproj0016;
	}

	public FormData getFormproj0017() {
		return formproj0017;
	}

	public void setFormproj0017(FormData formproj0017) {
		this.formproj0017 = formproj0017;
	}

	public FormData getFormproj0020() {
		return formproj0020;
	}

	public void setFormproj0020(FormData formproj0020) {
		this.formproj0020 = formproj0020;
	}

	/**
	 * @return the formproj0028
	 */
	public FormData getFormproj0028() {
		return formproj0028;
	}

	/**
	 * @param formproj0028 the formproj0028 to set
	 */
	public void setFormproj0028(FormData formproj0028) {
		this.formproj0028 = formproj0028;
	}

	/**
	 * @return the formproj0030
	 */
	public FormData getFormproj0030() {
		return formproj0030;
	}

	/**
	 * @param formproj0030 the formproj0030 to set
	 */
	public void setFormproj0030(FormData formproj0030) {
		this.formproj0030 = formproj0030;
	}

	/**
	 * @return the corpAcctBo
	 */
	public CorpAcctBo getCorpAcctBo() {
		return corpAcctBo;
	}

	/**
	 * @param corpAcctBo the corpAcctBo to set
	 */
	public void setCorpAcctBo(CorpAcctBo corpAcctBo) {
		this.corpAcctBo = corpAcctBo;
	}

	/**
	 * @return the corpAcctList
	 */
	public List<CorpAcct> getCorpAcctList() {
		return corpAcctList;
	}

	/**
	 * @param corpAcctList the corpAcctList to set
	 */
	public void setCorpAcctList(List<CorpAcct> corpAcctList) {
		this.corpAcctList = corpAcctList;
	}
	

}