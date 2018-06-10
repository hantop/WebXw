package  app.creditapp.ln.action;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSON;
import com.core.domain.screen.FormData;
import com.core.service.screen.FormService;
import com.core.struts.ActionContext;
import com.core.struts.BaseFormBean;

import app.base.CreateKey;
import app.base.SourceTemplate;
import app.creditapp.inf.client.RuleTrans;
import app.creditapp.inf.client.RulesService;
import app.creditapp.inf.client.entity.Request;
import app.creditapp.inf.client.entity.RequestObj;
import app.creditapp.inf.client.entity.ReturnObj;
import app.creditapp.inf.client.entity.RuleFact;
import app.creditapp.inf.client.entity.RuleReturn;
import app.creditapp.ln.bo.PreApplyBo;
import app.creditapp.ln.bo.PreBatchBo;
import app.creditapp.ln.entity.PreApply;
import app.creditapp.ln.entity.PreBatch;
import app.creditapp.redis.util.RedisUtil;
import app.oscache.CachecodeUtil;
import app.oscache.MBaseCache;
import app.util.DateUtil;
import app.util.User;
import app.util.message.conversion.entity.TransferResult;
import app.util.message.conversion.transfer.TransferHandler;
import app.util.toolkit.Ipage;
import redis.clients.jedis.Jedis;

/**
 * Title: PreApplyAction.java
 * Description:
 **/
public class PreApplyAction extends BaseFormBean {

	//ҳ�洫ֵ
	private PreApply preApply;
	private List<PreApply> preApplyList;
	private List<RuleReturn> ruleReturnList;
	//ע��PreApplyBo
	private PreApplyBo preApplyBo;
	private TransferHandler transferHandler; 
	private PreBatchBo preBatchBo;

	private String res;
	private String query;
	private String appId;	
	private File upload;
	private String uploadFileName;	
	private String uploadContentType;	
	private String downloadFile;
	
	private List tabList;
	
	private FormData formlnpreapply0001;
	private FormData formlnpreapply0002;
	private FormService formService = new FormService();
	
	public PreApplyAction() {
		query = "";
	}
	/**
	 * ��ҳ��ѯ
	 * @return
	 * @throws Exception
	 */
	public String findByPage() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),ServletActionContext.getResponse());
		formlnpreapply0001 = formService.getFormData("lnpreapply0001");
		preApply = new PreApply();
		getFormValue(formlnpreapply0001);
		setObjValue(formlnpreapply0001, preApply);
//		preApply.setBrNo(User.getBrno(this.getHttpRequest()));
		Ipage ipage = this.getIpage();
		preApplyList = (List) preApplyBo.findByPage(ipage, preApply).getResult();
		return "list";
	}
	/**
	 * ɸ������ѯ
	 * @return
	 * @throws Exception
	 */
	public String findByChk() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),ServletActionContext.getResponse());
		preApply = new PreApply();
		preApply.setAppId(appId);
		preApply = preApplyBo.getById(preApply);
		//���������淵��JSONת��ΪList
		if(preApply.getChkRes()!=null){
			RuleTrans rt = new RuleTrans();
			ruleReturnList = rt.translationPreChk(preApply);
		}
		res = "2";
		for(int i=0;i<ruleReturnList.size();i++){
			if("02".equals(ruleReturnList.get(i).getCodeRes())){
				res = "3";
				break;
			}
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
		formlnpreapply0002 = formService.getFormData("lnpreapply0002");
		return "input";
	}
	
	/**
	 * �����������
	 * @return
	 * @throws Exception
	 */
	public String insert() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formlnpreapply0002 = formService.getFormData("lnpreapply0002");
		getFormValue(formlnpreapply0002);
		preApply = new PreApply();
		setObjValue(formlnpreapply0002, preApply);
		preApplyBo.insert(preApply);
		getObjValue(formlnpreapply0002, preApply);
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
		formlnpreapply0002 = formService.getFormData("lnpreapply0002");
		getFormValue(formlnpreapply0002);
		preApply = new PreApply();
		setObjValue(formlnpreapply0002, preApply);
		preApplyBo.update(preApply);
		getObjValue(formlnpreapply0002, preApply);
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
		formlnpreapply0001 = formService.getFormData("lnpreapply0001");
		preApply = new PreApply();
		preApply.setAppId(appId);
		preApplyBo.del(preApply);
		this.addActionMessage("ɾ���ɹ�");
		preApply = new PreApply();
		preApply.setBrNo(User.getBrno(this.getHttpRequest()));
		Ipage ipage = this.getIpage();
		preApplyList = (List) preApplyBo.findByPage(ipage, preApply).getResult();
		return "list";
	}

	
	/**
	 * ��ѯ����
	 * @return
	 * @throws Exception
	 */
	public String getById() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),ServletActionContext.getResponse());
		formlnpreapply0002 = formService.getFormData("lnpreapply0002");
		preApply = new PreApply();
		preApply.setAppId(appId);
		preApply = preApplyBo.getById(preApply);
		getObjValue(formlnpreapply0002, preApply);
		return "detail";
	}
	
	/**
	 * �����������У��
	 * @return
	 * @throws Exception
	 */
	public void validateInsert(){
		 ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		 formlnpreapply0002 = formService.getFormData("lnpreapply0002");
		 getFormValue(formlnpreapply0002);
		 validateFormData(formlnpreapply0002);
   	}
   
	/**
	 * �޸ı������У��
	 * @return
	 * @throws Exception
	 */
	public void validateUpdate(){
		 ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		 formlnpreapply0002 = formService.getFormData("lnpreapply0002");
		 getFormValue(formlnpreapply0002);
		 validateFormData(formlnpreapply0002);
  	}
	
	/**
	 * �鿴360�ӽ�
	 * @return
	 */
	public String getAllDetail() {
		ActionContext.initialize(ServletActionContext.getRequest(), 
				ServletActionContext.getResponse());
		preApply = new PreApply();
		preApply.setAppId(appId);
		preApply = preApplyBo.getById(preApply);
		return "all";
	}
	
	/**
	 * 360��ͼ��tableͷ
	 * @return
	 */
	public String getDetailTop() {
		ActionContext.initialize(ServletActionContext.getRequest(), 
				ServletActionContext.getResponse());
		formlnpreapply0002 = formService.getFormData("lnpreapply0002");
		preApply = new PreApply();
		preApply.setAppId(appId);
		preApply = preApplyBo.getById(preApply);
		getObjValue(formlnpreapply0002, preApply);
		query = "query";
		return "top";
	}
	
	public String getTab() throws Exception{
		ActionContext.initialize(ServletActionContext.getRequest(),
				ServletActionContext.getResponse());
		tabList = new ArrayList();
		String[] tab = null;
		
		preApply = new PreApply();
		preApply.setAppId(appId);
		preApply = preApplyBo.getById(preApply);
		
		tab = new String[2];
		tab[0] = "Ԥ��������";
		tab[1] = "PreApplyAction_getById.action?appId=" + appId+ "&query=query";
		tabList.add(tab);
		
/*			
		tab = new String[2];
		tab[0] = "Ԥ�����˻���Ϣ";
		tab[1] = "PreAcctAction_listQuotaForLn.action?appId=" + appId+ "&query="+ query + "";
		tabList.add(tab);
*/			
		tab = new String[2];
		tab[0] = "Ԥ����ѺƷ��Ϣ";
		tab[1] = "PreGageAction_listQuotaForLn.action?appId="+appId+ "&query="+ query + "";
		tabList.add(tab);
		
		if(!(preApply.getChkRes()==null||"".equals(preApply.getChkRes())||"00".equals(preApply.getChkRes()))){
			tab = new String[2];
			tab[0] = "Ԥ����ɸ����Ϣ";
			tab[1] = "PreApplyAction_findByChk.action?appId="+appId+ "&query="+ query + "";
			tabList.add(tab);
		}
		
		if(!(preApply.getIfFlag()==null||"".equals(preApply.getIfFlag()))){
			tab = new String[2];
			tab[0]="�Զ����������Ϣ";
			tab[1]="PreApplyAction_findByReturnId.action?appId="+appId+ "&query=query";
			tabList.add(tab);
		}
		
		return "tab";
	}
	/**
	 * ����returnID��ѯ��������
	 * @return
	 * @throws Exception
	 */
	public String findByReturnId() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),ServletActionContext.getResponse());
		preApply = new PreApply();
		preApply.setAppId(appId);
		preApply = preApplyBo.getById(preApply);
		String resultId = preApply.getIfFlag();
		if(resultId!=null){
			RulesService rs = (RulesService) SourceTemplate.getSpringContextInstance().getBean("RulesService");
			RequestObj requestObj = new RequestObj();
			Request request = new Request();
			request.setResultId(resultId);
			requestObj.setPassword("1");
			requestObj.setUser("1001");
			requestObj.setRequest(request);
			//���ù�������õ����ص��ַ���
			String str= rs.queryResult(JSON.toJSONString(requestObj));
			ReturnObj ro = (ReturnObj) JSON.parseObject(str, ReturnObj.class);
			if("0000".equals(ro.getResponse().getRuleCode())){
				RuleFact ruleFact = ro.getResponse().getRuleFact().get(0);
//				getObjValue(formappauto0001, ruleFact);
				//���������淵��JSONת��ΪList
				RuleTrans rt = new RuleTrans();
				ruleReturnList = rt.translationAppAuto(ruleFact,preApply.getPrdtNo());
				res = "2";
				for(int i=0;i<ruleReturnList.size();i++){
					if("03".equals(ruleReturnList.get(i).getCodeRes())){
						res = "3";
						break;
					}
				}
			}else{
				this.addActionMessage("��ѯ��������ʧ�ܣ�"+ro.getResponse().getRuleMsg()+"!");
			}
		}else{
			this.addActionMessage("���Զ�����ID!");
		}
		return "find";
	}
	/**
	 * �ļ��ϴ�ҳ��
	 * @return
	 */
	public String uploadInput() {
		ActionContext.initialize(ServletActionContext.getRequest(), 
				ServletActionContext.getResponse());
		
		return "uploadInput";
	}
	
	/**
	 * ����
	 * @return
	 */
	public String upload() {
		ActionContext.initialize(ServletActionContext.getRequest(), 
				ServletActionContext.getResponse());
		FileOutputStream fos = null;
		FileInputStream fis = null;
		String batchNo = CreateKey.getPreBatchNo();
		String appDate = DateUtil.getDate();
		if(this.uploadFileName == null || "".equals(this.uploadFileName)){
			this.addActionError("δ�ϴ��ļ��������ļ�����");
			return "input";
		}
		String ftype = this.uploadFileName.substring(this.uploadFileName.indexOf("."));
		
		if(!(".xls".equals(ftype)||".xlsx".equals(ftype))){
			this.addActionError("�ϴ��ļ���ʽ����ϵͳ֧���ϴ�.xls��.xlsx�ļ���");
			return "input";
		}
		//��ȡ�ϴ�Ŀ��·��
		Map<String,String> sysPathMap =(Map<String,String>)MBaseCache.getCache().getBeanCache(CachecodeUtil.SYS_PATH_STR, CachecodeUtil.SYS_PATH);
		String tmppath = sysPathMap.get("103")+"/"+java.util.UUID.randomUUID()+ftype;
		/*String tmppath = UploadConfigurationRead.getInstance().getConfigItem("tmpuploadpath")+"/"+
			java.util.UUID.randomUUID()+ftype;*/
		try {
			fos = new FileOutputStream(tmppath);
			fis = new FileInputStream(this.getUpload());
			byte[] buffer = new byte[1024];
			int len = 0;
			while((len=fis.read(buffer))>0){
				fos.write(buffer, 0, len);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			this.addActionError("�ϴ��ļ������ڣ�");
			return "input";
		} catch (IOException e) {
			e.printStackTrace();
			this.addActionError("�ϴ��ļ���ȡ�����г��ִ���");
			return "input";
		}finally{
			try {
				fos.close();
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		boolean rslt = true;
		TransferResult tr = null;
		String[] mappingId = {"0010","0011"};
		String[] ruleId = {"preApply","preGage"};
		try {
			transferHandler.refreshMappingConfig();
			Map<String,String> replaceDefaultMap = new HashMap<String, String>();
			replaceDefaultMap.put("BATCH_NO", batchNo);
			replaceDefaultMap.put("APP_DATE", appDate);
			List<TransferResult> trlist = transferHandler.messageToDataForComplex(mappingId, ruleId, tmppath, replaceDefaultMap);
			tr = trlist.get(0);
		} catch (IndexOutOfBoundsException e) {
			e.printStackTrace();
			this.addActionError(e.getMessage()+"��");
			return "input";
		} catch (Exception e) {
			e.printStackTrace();
			this.addActionError("���ݲ�������г������������Ƿ���ȷ��");
			return "input";
		}
		if(!rslt){
			this.addActionError("�������ݿ�ʧ�ܣ����Ժ����Ի������Ա��ϵ��");
			return "input";
		}
		if(tr.getErrorDataNumber()==-99){
			this.addActionError("��ͬ�Ų����ظ����������ݺ����µ��룡");
			return "input";
		}
		if(tr.getErrorDataNumber()==-88){
			this.addActionError("����У��δͨ��:"+tr.getTransferId()+"");
			return "input";
		}
		rslt = tr.isWorkSuccess();
		PreApply preApply = new PreApply();
		preApply.setBrNo(tr.getGetRebackValue());
		preApply.setBatchNo(batchNo);
		preApplyBo.updateToAppId(preApply);
		List<PreApply> lamlist = preApplyBo.findListByBatNo(preApply);
		PreBatch preBatch = new PreBatch();
		preBatch.setBatchNo(batchNo);
		preBatch.setBatchFile(this.uploadFileName);
		preBatch.setBatchDate(DateUtil.getSysDate());
		preBatch.setBatchTime(DateUtil.getTime());
		preBatch.setBatchType("02");
		preBatch.setBrNo(tr.getGetRebackValue());
		preBatch.setBatchSts("01");
		preBatch.setBatchNum(lamlist.size());
		preBatch.setDbNum(lamlist.size());
		preBatch.setBatchFile(this.uploadFileName);
		preBatch.setUpTime(DateUtil.getTime());
		preBatchBo.insert(preBatch);
		//push����workP�ڵ�
		Jedis jedis = RedisUtil.getJedis();
		jedis.lpush(RedisUtil.QUEUE0, batchNo);
		jedis.close();
		this.addActionError("���ݵ���ɹ������κ�="+batchNo+"");
		return "input";
	}
	
	/**
	 * ����
	 * @return
	 */
	public String download() {
		
		return "download";
	}
	
	public String getDownfName() throws UnsupportedEncodingException {
		return new String("Ԥ��������ģ��.xls".getBytes(), "ISO8859-1");
	}
	
	public InputStream getTargetFile() {
		Map<String,String> sysPathMap =(Map<String,String>)MBaseCache.getCache().
					getBeanCache(CachecodeUtil.SYS_PATH_STR, CachecodeUtil.SYS_PATH);
		downloadFile = sysPathMap.get("003");
		return this.getServletContest().getResourceAsStream(downloadFile);
	}
	
	public PreApply getPreApply() {
		return preApply;
	}
	public void setPreApply(PreApply  preApply) {
		this.preApply = preApply;
	}
	public List<PreApply> getPreApplyList() {
		return preApplyList;
	}
	public void setPreApplyList(List<PreApply> preApplyList) {
		this.preApplyList = preApplyList;
	}
	public PreApplyBo getPreApplyBo() {
		return preApplyBo;
	}
	public void setPreApplyBo(PreApplyBo preApplyBo) {
		this.preApplyBo = preApplyBo;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public FormData getFormlnpreapply0002() {
		return formlnpreapply0002;
	}
	public void setFormlnpreapply0002(FormData formlnpreapply0002) {
		this.formlnpreapply0002 = formlnpreapply0002;
	}
	public FormData getFormlnpreapply0001() {
		return formlnpreapply0001;
	}
	public void setFormlnpreapply0001(FormData formlnpreapply0001) {
		this.formlnpreapply0001 = formlnpreapply0001;
	}
	public void setAppId(String appId){
		this.appId = appId;
	}		
	public String getAppId(){
		return appId;
	}
	public List getTabList() {
		return tabList;
	}
	public void setTabList(List tabList) {
		this.tabList = tabList;
	}
	public TransferHandler getTransferHandler() {
		return transferHandler;
	}
	public void setTransferHandler(TransferHandler transferHandler) {
		this.transferHandler = transferHandler;
	}
	public File getUpload() {
		return upload;
	}
	public void setUpload(File upload) {
		this.upload = upload;
	}
	public String getUploadFileName() {
		return uploadFileName;
	}
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	public String getUploadContentType() {
		return uploadContentType;
	}
	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}
	public PreBatchBo getPreBatchBo() {
		return preBatchBo;
	}
	public void setPreBatchBo(PreBatchBo preBatchBo) {
		this.preBatchBo = preBatchBo;
	}
	public FormService getFormService() {
		return formService;
	}
	public void setFormService(FormService formService) {
		this.formService = formService;
	}
	public String getDownloadFile() {
		return downloadFile;
	}
	public void setDownloadFile(String downloadFile) {
		this.downloadFile = downloadFile;
	}
	public List<RuleReturn> getRuleReturnList() {
		return ruleReturnList;
	}
	public void setRuleReturnList(List<RuleReturn> ruleReturnList) {
		this.ruleReturnList = ruleReturnList;
	}
	public String getRes() {
		return res;
	}
	public void setRes(String res) {
		this.res = res;
	}
	
}