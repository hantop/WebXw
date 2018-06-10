package  app.creditapp.sec.action;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.struts2.ServletActionContext;

import app.creditapp.sec.bo.SecurityAuditBo;
import app.creditapp.sec.entity.PasswordRegexp;
import app.creditapp.sec.entity.SecurityAudit;
import app.oscache.MBaseCache;
import app.util.User;
import app.util.toolkit.Ipage;

import com.core.domain.screen.FormData;
import com.core.service.screen.FormService;
import com.core.struts.ActionContext;
import com.core.struts.BaseFormBean;


/**
* Title: SecurityAuditAction.java
* Description:
**/

public class SecurityAuditAction extends BaseFormBean {

	//ҳ�洫ֵ
	private SecurityAudit secAudit;
	private List<SecurityAudit> secAuditList;

	//ע��SecurityAuditBo
	private SecurityAuditBo secAuditBo;

	private String itemNo;
	private String itemNoStr;
	private String query;
	private String view;
	private String audit;
	private String isUse;
	private String itemValues;
	private String itemValueStr;
	private String codeType;
	private FormData formsec0021;
	private FormData formsec0020;
	//�����޸�������Ϣ ԭʼ����@�¸�����
	private String changePWInfo; 
	private String checkRegIndex;
	private String pwd2 ;
	
	public String getPwd2() {
		return pwd2;
	}

	public void setPwd2(String pwd2) {
		this.pwd2 = pwd2;
	}
	public String getChangePWInfo() {
		return changePWInfo;
	}

	public void setChangePWInfo(String changePWInfo) {
		this.changePWInfo = changePWInfo;
	}
	private  FormService formService = new FormService();
	
	public SecurityAuditAction() {
		formsec0021 = formService.getFormData("sec0021");
//		formsec0020 = formService.getFormData("sec0020");
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
		secAudit = new SecurityAudit();
//		getFormValue(formsec0020);
//		setObjValue(formsec0020, secAudit);
		Ipage ipage = this.getIpage();
		if(audit!=null){
			if(audit.equals("SL")){//�����ʹ������
				secAudit.setCodeType(audit);
			}else if(audit.equals("SF")){//����������������̴���
				secAudit.setCodeType(audit);
			}else if(audit.equals("SR")){//�Ƿ��¼�û�����ɫ�����־
				secAudit.setCodeType(audit);
			}else{//����У��
				secAudit.setCodeType(audit);
			}
			secAuditList = (List) secAuditBo.findByPage(ipage, secAudit).getResult();
		}else{
			System.out.println("@@@@#"+itemNo);
			secAudit = secAuditBo.getById(itemNo);
			SecurityAudit sa = new SecurityAudit();
			sa.setCodeType(secAudit.getCodeType());
			secAuditList = (List) secAuditBo.findByPage(ipage, sa).getResult();
		}
		return "list";
	}
	
	/**
	 * ����ҳ��
	 * @return
	 * @throws Exception
	 */
	public String input() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		return "input";
	}
	
	/**
	 * �����������
	 * @return
	 * @throws Exception
	 */
	public String insert() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		getFormValue(formsec0021);
		secAudit = new SecurityAudit();
		setObjValue(formsec0021, secAudit);
		secAuditBo.insert(secAudit);
		getObjValue(formsec0021, secAudit);
		itemNo= secAudit.getItemNo();
		query = "query";
		return "detail";
	}
	
	/**
	 * �޸ı������
	 * @return
	 * @throws Exception
	 */
	public String update() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		secAudit = new SecurityAudit();
		getFormValue(formsec0021);
		setObjValue(formsec0021, secAudit);
		secAuditBo.update(secAudit);
		getObjValue(formsec0021, secAudit);
		itemNo= secAudit.getItemNo();
		secAudit = secAuditBo.getById(itemNo);
		if (secAudit.getIsEdit()==0) {
			this.changeFormProperty(formsec0021, "itemValues", "readonly", "1");
		}
		getObjValue(formsec0021, secAudit);
		itemNo= secAudit.getItemNo();
		return "detail";
	}
	
	/**
	 * ɾ������
	 * @return
	 * @throws Exception
	 */
	public String del() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		secAuditBo.del(itemNo);
		this.addActionMessage("ɾ���ɹ�");
		secAudit = new SecurityAudit();
		Ipage ipage = this.getIpage();
		secAuditList = (List) secAuditBo.findByPage(ipage, secAudit).getResult();
		return "list";
	}

	/**
	 * ��ѯ����
	 * @return
	 * @throws Exception
	 */
	public String getById() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),ServletActionContext.getResponse());
		secAudit = secAuditBo.getById(itemNo);
		if (secAudit.getIsEdit()==0) {
			this.changeFormProperty(formsec0021, "itemValues", "readonly", "1");
		}
		getObjValue(formsec0021, secAudit);
		itemNo= secAudit.getItemNo();
		return "detail";
	}
	/**
	 * �޸��Ƿ�����
	 * @return
	 * @throws Exception
	 */
	public String updateIsUse() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		secAudit = new SecurityAudit();
		secAudit = secAuditBo.getById(itemNo);
		isUse = "1".equals(isUse)?"0":"1";
		secAudit.setIsUse(isUse);
		secAuditBo.updateIsUse(secAudit);
		SecurityAudit sa = new SecurityAudit();
		sa.setCodeType(secAudit.getCodeType());
		Ipage ipage = this.getIpage();
		if(itemNo.equals("10")){
			MBaseCache.getCache().reloadSecurity();
		}
		secAuditList = (List) secAuditBo.findByPage(ipage, sa).getResult();
		return "list";
	}
	public String getTableList() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),ServletActionContext.getResponse());
		String[] itemValuesArray = itemValueStr.split("@");
		String[] itemNoArray = itemNoStr.split("@");
		secAudit = new SecurityAudit();
		for(int i =0;i<itemNoArray.length;i++){
			secAudit = secAuditBo.getById(itemNoArray[i].trim());
			if(secAudit.getIsEdit()==0){
				secAudit.setItemValues("");
			}else{
				secAudit.setItemValues(itemValuesArray[i].trim());
			}
			secAuditBo.update(secAudit);
		}
		SecurityAudit sa = new SecurityAudit();
		sa.setCodeType(secAudit.getCodeType());
		Ipage ipage = this.getIpage();
		secAuditList = (List) secAuditBo.findByPage(ipage, sa).getResult();
		addActionMessage("�ѱ���ɹ�");
		return "list";
	}
	/**
	 * ��ת�������޸�ҳ��
	 * @return
	 * @throws Exception
	 */
	public String tomodifyPwd() throws Exception {
		return "success";
	}
	public String modifyPwd() throws Exception{
		this.getHttpResponse().setContentType("text/html;charset=utf-8");
		PrintWriter out = this.getHttpResponse().getWriter();
		try{
			changePWInfo = "[{pwdmes:'" +"seak" + "'}]";
			String userId = User.getUserid(this.getHttpRequest());
			List<SecurityAudit> list= new ArrayList<SecurityAudit>();
			SecurityAudit secAudit =new SecurityAudit();
			secAudit.setIsUse("1");
			list =  secAuditBo.getListForSec(secAudit);
			for(int i=0;i<list.size();i++){
				String itemNo = list.get(i).getItemNo();
			//���볤����Сֵ��ֵѡ��0-20λ
				if(itemNo.equals("1")){
					if(pwd2.length()<Integer.valueOf((list.get(i).getItemValues()))){
						changePWInfo = "[{pwdmes:'" + "���볤�ȱ�����ڵ���" +list.get(i).getItemValues()+"λ��" + "'}]";
						out.println(changePWInfo);
						return null;	
					}
				}
			//	�������Ӣ�Ĵ�д��ĸ(A �� Z)
				if(itemNo.equals("2")){
					Pattern pattern = Pattern.compile(".*[A-Z]{1,}.*");
					Matcher m = pattern.matcher(pwd2);
					if(!m.matches()){
						changePWInfo = "[{pwdmes:'" + "����������Ӣ�ġ���д��ĸ����" + "'}]";
						out.println(changePWInfo);
						return null;
					}
				}
			//	�������Ӣ��Сд��ĸ(a �� z)
				if(itemNo.equals("3")){
					Pattern pattern = Pattern.compile(".*[a-z]{1,}.*");
					Matcher m = pattern.matcher(pwd2);
					if(!m.matches()){
						changePWInfo = "[{pwdmes:'" + "����������Ӣ�ġ�Сд��ĸ����" + "'}]";
						out.println(changePWInfo);
						return null;
					}
				}
			//	�������10 ����������(0 �� 9)
				if(itemNo.equals("4")){
					Pattern pattern = Pattern.compile(".*[0-9]{1,}.*");
					Matcher m = pattern.matcher(pwd2);
					if(!m.matches()){
						changePWInfo = "[{pwdmes:'" +"���������������֡���" + "'}]";
						out.println(changePWInfo);
						return null;
					}
				}
			//	������������ַ�(!��@��$��*��.)
				if(itemNo.equals("5")){
					Pattern pattern = Pattern.compile(".*[!@$*.]{1,}.*");
					Matcher m = pattern.matcher(pwd2);
					if(!m.matches()){
						changePWInfo = "[{pwdmes:'" + "�����������������ַ�����" + "'}]";
						out.println(changePWInfo);
						return null;
					}
				}
			//	���ܰ����û����ʻ���
				if(itemNo.equals("6")){
					if(!(pwd2.indexOf(userId) == -1)){
						changePWInfo = "[{pwdmes:'" +"���벻�ܰ����û����ʻ�����" + "'}]";
						out.println(changePWInfo);
						return null;
					}
				}
			}
			out.println(changePWInfo);
			return null;
		}catch(Exception e){
			changePWInfo = "[{pwdmes:'" +"�������Ա��ϵ��" + "'}]";
			out.println(changePWInfo);
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
		 getFormValue(formsec0021);
		 validateFormData(formsec0021);
   }
	/**
	 * �޸ı������У��
	 * @return
	 * @throws Exception
	 */
	public void validateUpdate(){
		 ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		 getFormValue(formsec0021);
		 validateFormData(formsec0021);
  }
	
	/********************************************�ϳ�������д��ȫ���ģ��******************************/
	
	public String findSecurityConfig(){
		secAuditList = secAuditBo.findAuditListByCode(codeType);
//		Map<Integer,String> passrdRegxpMap = new LinkedHashMap<Integer, String>();
//		for(PasswordRegexp reg:PasswordRegexp.values()){
//		}
		for(SecurityAudit audit:secAuditList){
			if(audit.getItemNo().equals("1")){
				checkRegIndex = audit.getItemValues();
				break;
			}
		}
		ServletActionContext.getRequest().setAttribute("auditlist", secAuditList);
		return "newList";
	}
	
	public String updateAuditInfo()throws Exception{
		this.getHttpResponse().setContentType("text/html;charset=utf-8");
		PrintWriter out = this.getHttpResponse().getWriter();
		secAudit = new SecurityAudit();
		secAudit.setItemNo(itemNo);
		//TODO ����޸ĵ�ֵ
		secAudit.setItemValues(itemValueStr);
		try {
			secAuditBo.update(secAudit);
			MBaseCache.getCache().reloadSecurity();
			out.println("SUCC");
		} catch (Exception e) {
			e.printStackTrace();
			out.println("�޸Ĺ����г��ִ����������Ա��ϵ");
		}
		return null;
	}
	
	public String updateIsUseNew() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		secAudit = new SecurityAudit();
		secAudit.setItemNo(itemNo);
		isUse = "1".equals(isUse)?"0":"1";
		secAudit.setIsUse(isUse);
		secAuditBo.updateIsUse(secAudit);
		MBaseCache.getCache().reloadSecurity();
		return findSecurityConfig();
//		return "list";
	}
	
	public String updateAllAuditInfo()throws Exception{
		//TODO �����޸ķ���
		return findSecurityConfig();
	}
	
	public SecurityAudit getSecurityAudit() {
		return secAudit;
	}
	public void setSecurityAudit(SecurityAudit  secAudit) {
		this.secAudit = secAudit;
	}
	public List<SecurityAudit> getSecurityAuditList() {
		return secAuditList;
	}
	public void setSecurityAuditList(List<SecurityAudit> secAuditList) {
		this.secAuditList = secAuditList;
	}
	public SecurityAuditBo getSecurityAuditBo() {
		return secAuditBo;
	}
	public void setSecurityAuditBo(SecurityAuditBo secAuditBo) {
		this.secAuditBo = secAuditBo;
	}
	public String getItemNo() {
		return itemNo;
	}
	public void setItemNo(String itemNo) {
		this.itemNo = itemNo;
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
	public FormData getFormsec0021() {
		return formsec0021;
	}
	public void setFormsec0021(FormData formsec0021) {
		this.formsec0021 = formsec0021;
	}
	public FormData getFormsec0020() {
		return formsec0020;
	}
	public void setFormsec0020(FormData formsec0020) {
		this.formsec0020 = formsec0020;
	}
	public String getIsUse() {
		return isUse;
	}
	public void setIsUse(String isUse) {
		this.isUse = isUse;
	}
	public String getAudit() {
		return audit;
	}
	public void setAudit(String audit) {
		this.audit = audit;
	}
	public String getItemValues() {
		return itemValues;
	}
	public void setItemValues(String itemValues) {
		this.itemValues = itemValues;
	}
	public String getCodeType() {
		return codeType;
	}
	public void setCodeType(String codeType) {
		this.codeType = codeType;
	}

	public String getItemValueStr() {
		return itemValueStr;
	}

	public void setItemValueStr(String itemValueStr) {
		this.itemValueStr = itemValueStr;
	}

	public String getItemNoStr() {
		return itemNoStr;
	}

	public void setItemNoStr(String itemNoStr) {
		this.itemNoStr = itemNoStr;
	}

	public SecurityAudit getSecAudit() {
		return secAudit;
	}

	public void setSecAudit(SecurityAudit secAudit) {
		this.secAudit = secAudit;
	}

	public List<SecurityAudit> getSecAuditList() {
		return secAuditList;
	}

	public void setSecAuditList(List<SecurityAudit> secAuditList) {
		this.secAuditList = secAuditList;
	}

	public SecurityAuditBo getSecAuditBo() {
		return secAuditBo;
	}

	public void setSecAuditBo(SecurityAuditBo secAuditBo) {
		this.secAuditBo = secAuditBo;
	}

	public String getCheckRegIndex() {
		return checkRegIndex;
	}

	public void setCheckRegIndex(String checkRegIndex) {
		this.checkRegIndex = checkRegIndex;
	}
}
