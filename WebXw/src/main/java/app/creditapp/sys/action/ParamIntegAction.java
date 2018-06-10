package  app.creditapp.sys.action;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import app.creditapp.sys.bo.AccessCheckInfoBo;
import app.creditapp.sys.bo.PrdtBaseBo;
import app.creditapp.sys.entity.AccessCheckInfo;
import app.creditapp.sys.entity.PrdtBase;
import app.util.User;
import app.util.toolkit.Ipage;

import com.core.domain.screen.FormData;
import com.core.service.screen.FormService;
import com.core.struts.ActionContext;
import com.core.struts.BaseFormBean;

/**
 * Title: CorpBaseAction.java
 * Description:
 **/
public class ParamIntegAction extends BaseFormBean {

	//ҳ�洫ֵ
	private PrdtBase prdtBase;
	private List<PrdtBase> prdtBaseList;
	private AccessCheckInfo accessCheckInfo;
	private List<AccessCheckInfo> accessCheckInfoList;
	//ע��PrdtBaseBo
	private PrdtBaseBo prdtBaseBo;
	private String query;
	private String brNo;	
	
	//ע��AccessCheckInfoBo
	private AccessCheckInfoBo accessCheckInfoBo;

	private FormData formsys0041;
	
	private FormService formService = new FormService();
	
	public ParamIntegAction() {
		query = "";
	}
	//��תҳ
	public String skipPage() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),ServletActionContext.getResponse());
		return "sk";
	}
	//��������ҳ
	public String toParam() {
		ActionContext.initialize(ServletActionContext.getRequest(), 
				ServletActionContext.getResponse());
		return "param";
	}
	//topҳ
	public String headPage() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),ServletActionContext.getResponse());
		return "head";
	}
	//��������ҳ
	public String performance() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),ServletActionContext.getResponse());
		return "perf";
	}
	//��־����ҳ
	public String sysLog() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),ServletActionContext.getResponse());
		return "log";
	}
	//�������ҳ
	public String monitor() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),ServletActionContext.getResponse());
		return "moni";
	}
	//��������ҳ
	public String sysTools() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),ServletActionContext.getResponse());
		return "tools";
	}
	//ҵ������ҳ
	public String business() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),ServletActionContext.getResponse());
		return "busi";
	}
	
	/**
	 * ��ҳ��ѯ��Ʒ
	 * @return
	 * @throws Exception
	 */
	public String getPrdtList() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),
				ServletActionContext.getResponse());
		formsys0041 = formService.getFormData("sys0041");
		prdtBase = new PrdtBase();
		
		getFormValue(formsys0041);
		setObjValue(formsys0041, prdtBase);
        if(brNo==null || "".equals(brNo) || "brNo".equals(brNo)){
        	prdtBase.setBrNo(null);
		}
		Ipage ipage = this.getIpage();
		prdtBaseList = (List<PrdtBase>) prdtBaseBo.findByPage(ipage, prdtBase).getResult();
		return "prdt";
	}

	//׼����Ϣ����
	public String findDetail() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),ServletActionContext.getResponse());
		
		accessCheckInfoList = new ArrayList<AccessCheckInfo>();
		//1����ǰѡ��ĺ����������Ƿ������TA�Ŀͻ���Ϣ
		accessCheckInfo = new AccessCheckInfo();
		accessCheckInfo.setBrNo(brNo);		
		int msg = accessCheckInfoBo.countForMsg(accessCheckInfo);
		accessCheckInfo.setSerial("1");
		accessCheckInfo.setCheckItem("���������Ƿ������TA�Ŀͻ���Ϣ");
		if (msg > 0){
			accessCheckInfo.setFlag("01");
			accessCheckInfo.setCheckResult("ͨ��");
		}else{
			accessCheckInfo.setFlag("00");
			accessCheckInfo.setCheckResult("��ͨ��;����������δ����TA�Ŀͻ���Ϣ");
		}
		accessCheckInfoList.add(accessCheckInfo);
		//2����������ά�ȵ����ò����Ƿ��������
		accessCheckInfo = new AccessCheckInfo();
		accessCheckInfo.setBrNo(brNo);
		int conf = accessCheckInfoBo.countForConf(accessCheckInfo);
		accessCheckInfo.setSerial("2");
		accessCheckInfo.setCheckItem("��������ά�ȵ����ò����Ƿ��������");
		if(conf == 1){
			accessCheckInfo.setFlag("01");
			accessCheckInfo.setCheckResult("ͨ��");
		}else{
			accessCheckInfo.setFlag("00");
			accessCheckInfo.setCheckResult("��ͨ������������ά�ȵ����ò�����δ�������");
		}
		accessCheckInfoList.add(accessCheckInfo);
		//3�����������Ƿ��Ѿ�����������Ŀ
		accessCheckInfo = new AccessCheckInfo();
		accessCheckInfo.setBrNo(brNo);
		int rele = accessCheckInfoBo.countForRele(accessCheckInfo);
		accessCheckInfo.setSerial("3");
		accessCheckInfo.setCheckItem("���������Ƿ��Ѿ�����������Ŀ");
		if (rele > 0){
			accessCheckInfo.setFlag("01");
			accessCheckInfo.setCheckResult("ͨ��");
		}else{
			accessCheckInfo.setFlag("00");
			accessCheckInfo.setCheckResult("��ͨ��������������δ����������Ŀ");
		}
		accessCheckInfoList.add(accessCheckInfo);
		//4��������Ŀά���Ƿ�������������
		accessCheckInfo = new AccessCheckInfo();
		accessCheckInfo.setBrNo(brNo);
		int param = accessCheckInfoBo.countForParam(accessCheckInfo);
		accessCheckInfo.setSerial("4");
		accessCheckInfo.setCheckItem("������Ŀά���Ƿ�������������");
		if (param > 0){
			int paramConf = accessCheckInfoBo.countForParamConf(accessCheckInfo);
			if(paramConf == 0){
				accessCheckInfo.setFlag("01");
				accessCheckInfo.setCheckResult("ͨ��");				
			}else{
				accessCheckInfo.setFlag("00");
				accessCheckInfo.setCheckResult("��ͨ����������Ŀά�Ȳ�����δ�������");
			}
		}else{
			accessCheckInfo.setFlag("00");
			accessCheckInfo.setCheckResult("��ͨ����������Ŀά�Ȳ�����δ�������");
		}
		accessCheckInfoList.add(accessCheckInfo);
		//5����������������������Ŀ����Ӫ��Ա�Ƿ��Ѿ�ȫ��ָ��
		accessCheckInfo = new AccessCheckInfo();
		accessCheckInfo.setBrNo(brNo);
		int desig = accessCheckInfoBo.countForDesig(accessCheckInfo);
		accessCheckInfo.setSerial("5");
		accessCheckInfo.setCheckItem("��������������������Ŀ����Ӫ��Ա�Ƿ��Ѿ�ȫ��ָ��");
		if (desig == 0){
			accessCheckInfo.setFlag("01");
			accessCheckInfo.setCheckResult("ͨ��");
		}else{
			accessCheckInfo.setFlag("00");
			accessCheckInfo.setCheckResult("��ͨ��;��������������������Ŀ����Ӫ��Ա��δȫ��ָ��");
		}
		accessCheckInfoList.add(accessCheckInfo);
		
		return "det";
	}
	
	
	public void setBrNo(String brNo){
		this.brNo = brNo;
	}		
	public String getBrNo(){
		return brNo;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public PrdtBaseBo getPrdtBaseBo() {
		return prdtBaseBo;
	}
	public void setPrdtBaseBo(PrdtBaseBo prdtBaseBo) {
		this.prdtBaseBo = prdtBaseBo;
	}
	public FormData getFormsys0041() {
		return formsys0041;
	}
	public void setFormsys0041(FormData formsys0041) {
		this.formsys0041 = formsys0041;
	}
	public FormService getFormService() {
		return formService;
	}
	public void setFormService(FormService formService) {
		this.formService = formService;
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
	public AccessCheckInfo getAccessCheckInfo() {
		return accessCheckInfo;
	}
	public void setAccessCheckInfo(AccessCheckInfo accessCheckInfo) {
		this.accessCheckInfo = accessCheckInfo;
	}
	public AccessCheckInfoBo getAccessCheckInfoBo() {
		return accessCheckInfoBo;
	}
	public void setAccessCheckInfoBo(AccessCheckInfoBo accessCheckInfoBo) {
		this.accessCheckInfoBo = accessCheckInfoBo;
	}
	public List<AccessCheckInfo> getAccessCheckInfoList() {
		return accessCheckInfoList;
	}
	public void setAccessCheckInfoList(List<AccessCheckInfo> accessCheckInfoList) {
		this.accessCheckInfoList = accessCheckInfoList;
	}
}