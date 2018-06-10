package  app.creditapp.ln.action;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
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
import app.creditapp.cif.entity.CifPersInf;
import app.creditapp.ln.bo.LnApplyMidBo;
import app.creditapp.ln.bo.LnApplyRegBo;
import app.creditapp.ln.bo.LnBatchBo;
import app.creditapp.ln.bo.LnStageBo;
import app.creditapp.ln.entity.LnApplyMid;
import app.creditapp.ln.entity.LnApplyReg;
import app.creditapp.ln.entity.LnBatch;
import app.creditapp.ln.entity.LnStage;
import app.creditapp.redis.util.RedisUtil;
import app.creditapp.sys.bo.SysPathBo;
import app.creditapp.sys.entity.SysPath;
import app.oscache.CachecodeUtil;
import app.oscache.MBaseCache;
import app.util.DateUtil;
import app.util.User;
import app.util.message.conversion.entity.TransferResult;
import app.util.message.conversion.transfer.TransferHandler;
import app.util.toolkit.Ipage;
import redis.clients.jedis.Jedis;

/**
 * Title: LnApplyRegAction.java
 * Description:
 **/
public class LnApplyRegAction extends BaseFormBean {

	//ҳ�洫ֵ
	private LnStage lnStage;
	private LnApplyReg lnApplyReg;
	private List<LnApplyReg> lnApplyRegList;
    private String pactNo;
    private CifPersInf cifPersInf;
    private SysPath  sysPath = new SysPath();
	public CifPersInf getCifPersInf() {
		return cifPersInf;
	}
	public void setCifPersInf(CifPersInf cifPersInf) {
		this.cifPersInf = cifPersInf;
	}
	public String getPactNo() {
		return pactNo;
	}
	public void setPactNo(String pactNo) {
		this.pactNo = pactNo;
	}
	//ע��LnApplyRegBo
	private LnStageBo lnStageBo;
	private LnApplyRegBo lnApplyRegBo;
	private TransferHandler transferHandler;
	private LnBatchBo     lnBatchBo;
	private LnApplyMidBo  lnApplyMidBo;
	private SysPathBo sysPathBo;

	private String query;
	private String appId;	
	private File upload;
	private String uploadFileName;	
	private String uploadContentType;	
	private String downloadFile;
	
	private List tabList;
	
	private FormData formlnapplyreg0001;
	private FormData formlnapplyreg0002;
	private FormData formappauto0001;
	public FormData getFormlnapplyreg0003() {
		return formlnapplyreg0003;
	}
	public void setFormlnapplyreg0003(FormData formlnapplyreg0003) {
		this.formlnapplyreg0003 = formlnapplyreg0003;
	}
	private FormData formlnapplyreg0003;
	private FormService formService = new FormService();

	public LnApplyRegAction() {
		query = "";
	}
	/**
	 * ��ҳ��ѯ
	 * @return
	 * @throws Exception
	 */
	public String findByPage() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),ServletActionContext.getResponse());
		formlnapplyreg0001 = formService.getFormData("lnapplyreg0001");
		lnApplyReg = new LnApplyReg();
		getFormValue(formlnapplyreg0001);
		setObjValue(formlnapplyreg0001, lnApplyReg);
		lnApplyReg.setBrNo(User.getBrno(this.getHttpRequest()));
		Ipage ipage = this.getIpage();
		lnApplyRegList = (List) lnApplyRegBo.findByPage(ipage, lnApplyReg).getResult();
		return "list";
	}
	
	//�޸��ֻ�����Ϣ
	public String findByPagechanyephone() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),ServletActionContext.getResponse());
		formlnapplyreg0001 = formService.getFormData("lnapplyreg0001");
		lnApplyReg = new LnApplyReg();
		getFormValue(formlnapplyreg0001);
		setObjValue(formlnapplyreg0001, lnApplyReg);
		lnApplyReg.setLoginid(User.getLoginIdByAuth(this.getHttpRequest()));
		lnApplyReg.setBrNo(User.getBrno(this.getHttpRequest()));
		Ipage ipage = this.getIpage();
		lnApplyRegList = (List) lnApplyRegBo.findByPage(ipage, lnApplyReg).getResult();
		return "list";
	}
	/**
	 * ��ѯ
	 * @return
	 * @throws Exception
	 
	public String findByReturnId() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),ServletActionContext.getResponse());
		formappauto0001 = formService.getFormData("appauto0001");
		lnApplyReg = new LnApplyReg();
		lnApplyReg.setAppId(appId);
		lnApplyReg = lnApplyRegBo.getById(lnApplyReg);
		String resultId = lnApplyReg.getIfFlag();
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
			RuleFact ruleFact = ro.getResponse().getRuleFact().get(0);
			getObjValue(formappauto0001, ruleFact);
		}
		return "find";
	}
	*/
	/**
	 * ��ȡ����ҳ��
	 * @return
	 * @throws Exception
	 */
	public String input() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formlnapplyreg0002 = formService.getFormData("lnapplyreg0002");
		return "input";
	}
	//�޸�ҳ��
	public String inputxiugai() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formlnapplyreg0003 = formService.getFormData("lnapplyreg0003");
		lnApplyReg = new LnApplyReg();
		lnApplyReg.setPactNo(pactNo);
		lnApplyReg = lnApplyRegBo.getBypactNo(lnApplyReg);
		
		//getFormValue(formlnapplyreg0003);
		getObjValue(formlnapplyreg0003, lnApplyReg);
		return "input";
	}
	/**
	 * �����������
	 * @return
	 * @throws Exception
	 */
	public String insert() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formlnapplyreg0002 = formService.getFormData("lnapplyreg0002");
		getFormValue(formlnapplyreg0002);
		lnApplyReg = new LnApplyReg();
		setObjValue(formlnapplyreg0002, lnApplyReg);
		lnApplyRegBo.insert(lnApplyReg);
		getObjValue(formlnapplyreg0002, lnApplyReg);
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
		formlnapplyreg0002 = formService.getFormData("lnapplyreg0002");
		getFormValue(formlnapplyreg0002);
		lnApplyReg = new LnApplyReg();
		setObjValue(formlnapplyreg0002, lnApplyReg);
		lnApplyRegBo.update(lnApplyReg);
		getObjValue(formlnapplyreg0002, lnApplyReg);
		this.addActionMessage("�����ɹ�");
		return "detail";
	}
	
	//�޸ı���ͻ������ֻ���
	public String updateinfor() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formlnapplyreg0003 = formService.getFormData("lnapplyreg0003");//lnapplyreg0003
		getFormValue(formlnapplyreg0003);
		lnApplyReg = new LnApplyReg();
		setObjValue(formlnapplyreg0003, lnApplyReg);
		lnApplyRegBo.updateBypactNo(lnApplyReg);
		getObjValue(formlnapplyreg0002, lnApplyReg);
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
		formlnapplyreg0001 = formService.getFormData("lnapplyreg0001");
		lnApplyReg = new LnApplyReg();
		lnApplyReg.setAppId(appId);
		lnApplyRegBo.del(lnApplyReg);
		this.addActionMessage("ɾ���ɹ�");
		lnApplyReg = new LnApplyReg();
		lnApplyReg.setBrNo(User.getBrno(this.getHttpRequest()));
		Ipage ipage = this.getIpage();
		lnApplyRegList = (List) lnApplyRegBo.findByPage(ipage, lnApplyReg).getResult();
		return "list";
	}

	
	/**
	 * ��ѯ����
	 * @return
	 * @throws Exception
	 */
	public String getById() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),ServletActionContext.getResponse());
		formlnapplyreg0002 = formService.getFormData("lnapplyreg0002");
		lnApplyReg = new LnApplyReg();
		lnApplyReg.setAppId(appId);
		lnApplyReg = lnApplyRegBo.getById(lnApplyReg);
		getObjValue(formlnapplyreg0002, lnApplyReg);
		return "detail";
	}
	
	/**
	 * �����������У��
	 * @return
	 * @throws Exception
	 */
	public void validateInsert(){
		 ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		 formlnapplyreg0002 = formService.getFormData("lnapplyreg0002");
		 getFormValue(formlnapplyreg0002);
		 validateFormData(formlnapplyreg0002);
   	}
   
	/**
	 * �޸ı������У��
	 * @return
	 * @throws Exception
	 */
	public void validateUpdate(){
		 ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		 formlnapplyreg0002 = formService.getFormData("lnapplyreg0002");
		 getFormValue(formlnapplyreg0002);
		 validateFormData(formlnapplyreg0002);
  	}
	
	/**
	 * �鿴360�ӽ�
	 * @return
	 */
	public String getAllDetail() {
		ActionContext.initialize(ServletActionContext.getRequest(), 
				ServletActionContext.getResponse());
		lnApplyReg = new LnApplyReg();
		lnApplyReg.setAppId(appId);
		lnApplyReg = lnApplyRegBo.getById(lnApplyReg);
		return "all";
	}
	
	/**
	 * 360��ͼ��tableͷ
	 * @return
	 */
	public String getDetailTop() {
		ActionContext.initialize(ServletActionContext.getRequest(), 
				ServletActionContext.getResponse());
		formlnapplyreg0002 = formService.getFormData("lnapplyreg0002");
		lnApplyReg = new LnApplyReg();
		lnApplyReg.setAppId(appId);
		lnApplyReg = lnApplyRegBo.getById(lnApplyReg);
		getObjValue(formlnapplyreg0002, lnApplyReg);
		query = "query";
		return "top";
	}
	
	public String getTab() throws Exception{
		ActionContext.initialize(ServletActionContext.getRequest(),
				ServletActionContext.getResponse());
		
		lnStage = new LnStage();
		lnStage.setAppId(appId);
		lnStage = lnStageBo.getById(lnStage);
		
		tabList = new ArrayList();
		String[] tab = null;
		
		tab = new String[2];
		tab[0] = "��ʽ��������";
		tab[1] = "LnApplyRegAction_getById.action?appId=" + appId+ "&query=query";
		tabList.add(tab);
		
			
		tab = new String[2];
		tab[0] = "��ʽ�����˻���Ϣ";
		tab[1] = "LnAcctMidAction_listQuotaForLn.action?appId=" + appId+ "&query="+ query + "";
		tabList.add(tab);
			
		tab = new String[2];
		tab[0] = "��ʽ����ѺƷ��Ϣ";
		tab[1] = "LnGageMidAction_listQuotaForLn.action?appId="+appId+ "&query="+ query + "";
		tabList.add(tab);
		
		tab = new String[2];
		tab[0]="��ͬ�������Ϣ";
		tab[1]="LnComMidAction_findByPage.action?appId="+appId+ "&query="+ query + "";
		tabList.add(tab);
		
		tab = new String[2];
		tab[0]="����������Ϣ";
		tab[1]="LnRelMidAction_findByPage.action?appId="+appId+ "&query="+ query + "";
		tabList.add(tab);
		
		tab = new String[2];
		tab[0]="�Զ����������Ϣ";
		tab[1]="LnApplyRegAction_findByReturnId.action?appId="+appId+ "&query=query";
		tabList.add(tab);
		
		/*tab = new String[2];
		tab[0]="������Ϣ";
		tab[1]="LnStageAction_getSts.action?appId="+appId+ "&query="+ query + "";
		tabList.add(tab);*/
		
		return "tab";
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
		String batchNo = CreateKey.getLnBatchNo();
		String appDate = DateUtil.getSysDate();
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
		Map<String,String> sysPathMap =(Map<String,String>)MBaseCache.getCache().
				getBeanCache(CachecodeUtil.SYS_PATH_STR, CachecodeUtil.SYS_PATH);
		String tmppath = "D:\\XINTUO\\upFile\\"+java.util.UUID.randomUUID()+ftype;
//		String tmppath = sysPathMap.get("105")+"/"+java.util.UUID.randomUUID()+ftype;

		/*String tmppath = UploadConfigurationRead.getInstance().getConfigItem("tmpuploadpath")+"/"
				+java.util.UUID.randomUUID()+ftype;*/
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
		String[] mappingId = {"0005","0006","0007","0008","0009"};
		String[] ruleId = {"lnApplyMid","lnAcctMid","lnGageMid","lnRelMid","lnComMid"};
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
		}  catch (Exception e) {
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
		LnApplyMid lnApplyMid = new LnApplyMid();
		lnApplyMid.setBrNo(tr.getGetRebackValue());
		lnApplyMid.setBatchNo(batchNo);
		lnApplyMidBo.updateToAppId(lnApplyMid);
		
		lnApplyMid = new LnApplyMid();
		lnApplyMid.setBatchNo(batchNo);
		List<LnApplyMid> lamlist = lnApplyMidBo.getListByLnApplyMid(lnApplyMid);
		
		LnBatch lnBatch = new LnBatch();
		lnBatch.setBatchNo(batchNo);  // ���α��
		lnBatch.setBatchFile(this.uploadFileName);
		lnBatch.setBatchDate(DateUtil.getSysDate());    // ��ǰϵͳ����
		lnBatch.setBatchTime(DateUtil.getTime());    // ��ǰϵͳʱ��
		lnBatch.setBatchType("02");  				// Ĭ��Ϊ�Զ�����
		lnBatch.setBrNo(tr.getGetRebackValue()); 	    // �����������
		lnBatch.setBatchSts("01");
		lnBatch.setBatchNum(lamlist.size());
		lnBatch.setDbNum(lamlist.size());
		lnBatch.setAppAmt(0.00);
		for(LnApplyMid lam : lamlist){
			lnBatch.setAppAmt(lnBatch.getAppAmt()+lam.getAppAmt());
		}
		lnBatchBo.insert(lnBatch);
		
		Jedis jedis = RedisUtil.getJedis();
		
		for(LnApplyMid bean:lamlist){
			jedis.lpush(RedisUtil.QUEUE1, JSON.toJSONString(bean));
		}
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
		ActionContext.initialize(ServletActionContext.getRequest(), 
				ServletActionContext.getResponse());
		String userAgent = ActionContext.getActionContext().getRequest().getHeader("user-agent").toLowerCase();

		String dfName = "��ʽ��������ģ��.xls";
		if (userAgent.contains("msie") || userAgent.contains("like gecko") ) {  
		        // win10 ie edge ����� ������ϵͳ��ie  
			dfName = URLEncoder.encode(dfName, "UTF-8");  
		} else {
			dfName = new String(dfName.getBytes(), "ISO8859-1");
		}

//		return new String("��ʽ��������ģ��.xls".getBytes(), "ISO8859-1");
		return dfName;
	}
	
	public InputStream getTargetFile() {
//		Map<String,String> sysPathMap =(Map<String,String>)MBaseCache.getCache().
//				getBeanCache(CachecodeUtil.SYS_PATH_STR, CachecodeUtil.SYS_PATH);
//		downloadFile = sysPathMap.get("005");
		sysPath.setPathId("005");
		sysPath = sysPathBo.getById(sysPath);
		downloadFile = sysPath.getPathDir();
		return this.getServletContest().getResourceAsStream(downloadFile);
	}
	
	public LnApplyReg getLnApplyReg() {
		return lnApplyReg;
	}
	public void setLnApplyReg(LnApplyReg  lnApplyReg) {
		this.lnApplyReg = lnApplyReg;
	}
	public List<LnApplyReg> getLnApplyRegList() {
		return lnApplyRegList;
	}
	public void setLnApplyRegList(List<LnApplyReg> lnApplyRegList) {
		this.lnApplyRegList = lnApplyRegList;
	}
	public LnApplyRegBo getLnApplyRegBo() {
		return lnApplyRegBo;
	}
	public void setLnApplyRegBo(LnApplyRegBo lnApplyRegBo) {
		this.lnApplyRegBo = lnApplyRegBo;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public FormData getFormlnapplyreg0002() {
		return formlnapplyreg0002;
	}
	public void setFormlnapplyreg0002(FormData formlnapplyreg0002) {
		this.formlnapplyreg0002 = formlnapplyreg0002;
	}
	public FormData getFormlnapplyreg0001() {
		return formlnapplyreg0001;
	}
	public void setFormlnapplyreg0001(FormData formlnapplyreg0001) {
		this.formlnapplyreg0001 = formlnapplyreg0001;
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
	public File getUpload() {
		return upload;
	}
	public void setUpload(File upload) {
		this.upload = upload;
	}
	public TransferHandler getTransferHandler() {
		return transferHandler;
	}
	public void setTransferHandler(TransferHandler transferHandler) {
		this.transferHandler = transferHandler;
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
	public LnBatchBo getLnBatchBo() {
		return lnBatchBo;
	}
	public void setLnBatchBo(LnBatchBo lnBatchBo) {
		this.lnBatchBo = lnBatchBo;
	}
	public LnApplyMidBo getLnApplyMidBo() {
		return lnApplyMidBo;
	}
	public void setLnApplyMidBo(LnApplyMidBo lnApplyMidBo) {
		this.lnApplyMidBo = lnApplyMidBo;
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
	public LnStage getLnStage() {
		return lnStage;
	}
	public void setLnStage(LnStage lnStage) {
		this.lnStage = lnStage;
	}
	public LnStageBo getLnStageBo() {
		return lnStageBo;
	}
	public void setLnStageBo(LnStageBo lnStageBo) {
		this.lnStageBo = lnStageBo;
	}
	/**
	 * @return the formappauto0001
	 */
	public FormData getFormappauto0001() {
		return formappauto0001;
	}
	/**
	 * @param formappauto0001 the formappauto0001 to set
	 */
	public void setFormappauto0001(FormData formappauto0001) {
		this.formappauto0001 = formappauto0001;
	}
	public SysPath getSysPath() {
		return sysPath;
	}
	public void setSysPath(SysPath sysPath) {
		this.sysPath = sysPath;
	}
	public SysPathBo getSysPathBo() {
		return sysPathBo;
	}
	public void setSysPathBo(SysPathBo sysPathBo) {
		this.sysPathBo = sysPathBo;
	}
	
}