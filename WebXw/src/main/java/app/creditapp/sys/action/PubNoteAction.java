package  app.creditapp.sys.action;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.core.domain.screen.FormData;
import com.core.service.screen.FormService;
import com.core.struts.ActionContext;
import com.core.struts.BaseFormBean;

import app.creditapp.sys.bo.PubNoteBo;
import app.creditapp.sys.entity.PubNote;
import app.util.FileTool;
import app.util.Ftp;
import app.util.FtpUtil;
import app.util.UploadConfigurationRead;
import app.util.UploadUtil;
import app.util.User;
import app.util.toolkit.Ipage;

/**
 * Title: PubNoteAction.java
 * Description:
 **/
public class PubNoteAction extends BaseFormBean {

	//ҳ�洫ֵ
	private int kb_index;//����Ŀǰ����ʾ����
	private int next_index;//������һ��
	private String chooseflag;//ѡ���ĸ�֧·��־
	private String flag;//�ж��Ƿ�����һ��
	private PubNote pubNote;
	private PubNote pub;//���ڴ�����һ��������Ϣ
	private List<PubNote> pubNoteList;
	private int pageNo;

	//ע��PubNoteBo
	private PubNoteBo pubNoteBo;
	
	private String query;
	private String noteNo;		
	private String noteType;
	private String contType;
	private String noteFile;
	private String txDate;
	private File upload;//ʵ���ϴ��ļ�
	private String uploadFileName;//�ϴ��ļ���
	private FormData formsys0090;
	private FormData formsys0091;
	private FormData formsys0098;
	private FormData formsys0099;
	private String docName;
	private String add;
	private FormService formService = new FormService();
//	private String pubNote.docName;
	
	public PubNoteAction() {
		query = "";
	}
	public static String getExt(String fileName) {
		return fileName.substring(fileName.lastIndexOf("."));
	}
	/**
	 * ��ҳ��ѯ
	 * @return
	 * @throws Exception
	 */
	public String findByPage() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),ServletActionContext.getResponse());
		formsys0090 = formService.getFormData("sys0090");
		pubNote = new PubNote();
		getFormValue(formsys0090);
		setObjValue(formsys0090, pubNote);
		pubNote.setNoteType(noteType);
		Ipage ipage = this.getIpage();
		pubNoteList = (List) pubNoteBo.findByPage(ipage, pubNote).getResult();
		return "list";
	}
	
	/**
	 * ��̨֪ʶ������ò�ѯ 
	 * @return
	 * @throws Exception
	 */
	public String findByAll() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),ServletActionContext.getResponse());
		formsys0098 = formService.getFormData("sys0098");
		pubNote = new PubNote();
		getFormValue(formsys0098);
		setObjValue(formsys0098, pubNote);
		Ipage ipage = this.getIpage();		
		pubNoteList = (List) pubNoteBo.findByPage(ipage, pubNote).getResult();
		return "listAll";
	}
	
	/**
	 * ��ȡ����ҳ��
	 * @return
	 * @throws Exception
	 */
	public String input() throws Exception {
		pubNote = new PubNote();
		pubNote.setTxDate(User.getSys_date(ServletActionContext.getRequest()));
		pubNote.setUpDate(User.getSys_date(ServletActionContext.getRequest()));
		pubNote.setOpNo(User.getLoginid(ServletActionContext.getRequest()));
		return "input";
	}
//	class CharacterEncodingRequest extends HttpServletRequestWrapper{
//		
//		
//		private HttpServletRequest request;
//
//		public CharacterEncodingRequest(HttpServletRequest request) {
//			super(request);
//			this.request = request;
//		}
	/**
	 * �����������
	 * @return
	 * @throws Exception
	 */
	public String insert() throws Exception {
		if (("1").equals(pubNote.getContType())) {// ���߱༭
			
		} else if (("2").equals(pubNote.getContType())) {// �ĵ��ϴ�
//			String encod = getEncoding(uploadFileName);
//			String fileName = null;
//			if ("GBK".equals(encod) || "GB2312".equals(encod) || "GB18030".equals(encod)) {
//				fileName = uploadFileName;
//			} else {
//				fileName = new String(uploadFileName.getBytes(), "GBK");// �ϴ����ļ���
//			}
//			// System.out.println("fileName=="+fileName+" uploadFileName="+uploadFileName);
//			String paString = "";
//			if (fileName != null) {
//				 /*String serverPath =
//				 UploadConfigurationRead.getInstance().getConfigItem("uploadFilePath").trim();*/
//				Map<String,String> sysPathMap =(Map<String,String>)MBaseCache.getCache().
//							getBeanCache(CachecodeUtil.SYS_PATH_STR, CachecodeUtil.SYS_PATH);
//				String serverPath = sysPathMap.get("107");
//				 // ��ȡ�������ϴ��ļ���Ŀ¼
////				String serverPath = UploadUtil.getParm("uploadFilePath");
//				File target = new File(serverPath, fileName);
//				FileUtils.copyFile(upload, target);// �ϴ�����������Ŀ¼
//				paString = serverPath + "/" + fileName;
//			}
//			if (pubNote.getNoteFile() != null && fileName != null) {
//				String targetDirectory = ServletActionContext.getServletContext().getRealPath("");// ���·��
//				String s = UploadUtil.getPath(targetDirectory) + pubNote.getNoteFile();
//				UploadUtil.delete(s);
//			}
//			pubNote.setDocName(fileName);
//			pubNote.setNoteFile(paString);
//		}
////		pubNote.setUpDate(User.getSys_date(this.getHttpRequest()));
		
//		this.addActionMessage("�����ɹ�");
//		ServletActionContext.getRequest().setAttribute("noteContent", pubNote.getNoteContent());
//		
		
//		if(this.uploadFileName==null || "".equals(this.uploadFileName) ){
//			this.addActionError("�ļ�δ�ϴ������ļ����ڴ���");
//			return "input";
//		}
//		String ftype = this.uploadFileName.substring(this.uploadFileName.indexOf("."));
//		if(!(".xls".equals(ftype)||".xlsx".equals(ftype))){
//			this.addActionError("�ϴ��ļ���ʽ����ϵͳ֧���ϴ�.xls��.xlsx�ļ���");
//			return "input";
			ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
			HttpServletRequest request = ServletActionContext.getRequest();
			String sfile ="";
			String adds = request.getParameter("docName");
			long e = System.currentTimeMillis();
			String [] strs = adds.split("\\.");
			if(strs.length>2){
				sfile = e+"."+strs[strs.length-1];
			}else{
				sfile = e+"."+strs[1];
			}
			String cont = request.getParameter("contType");
			String note = request.getParameter("noteType");
			String noteTitle = pubNote.getNoteTitle();
			PubNote pubNote =new PubNote();
			pubNote.setDocName(adds);
			pubNote.setNoteTitle(noteTitle);
			pubNote.setNoteType(note);
			pubNote.setContType(cont);
			pubNote.setOpNo(User.getLoginid(ServletActionContext.getRequest()));
			pubNote.setTxDate(User.getSys_date(this.getHttpRequest()));
//			pubNote.setNoteFile("http://10.7.53.30/itp/knowledge/"+adds);
			pubNote.setNoteFile("/PUB/knowledge/"+sfile);
			pubNoteBo.insert(pubNote);
			
			FileInputStream fis = null;
			FileTool fileTool =new FileTool();  
//		Map<String,String> sysPathMap =(Map<String,String>)MBaseCache.getCache().getBeanCache(CachecodeUtil.SYS_PATH_STR, CachecodeUtil.SYS_PATH);
//		String tmppath = sysPathMap.get("101")+"/"+add;
			fis = new FileInputStream(this.getUpload());
			boolean bool = fileTool.upLoadFromProduction("10.7.53.30", 21, "MFS", "RsKBnHlj",  "/PUB/knowledge", sfile, fis);
			if(!bool){
				this.addActionMessage("����ʧ��");
			}else{
				this.addActionMessage("�����ɹ�");
			}
			
		}
		
		return "input";
	}
	
	public static String getEncoding(String str) {
		String encode = "GB2312";
		try {
			if (str.equals(new String(str.getBytes(encode), encode))) {
				String s = encode;
				return s;
			}
		} catch (Exception exception) {
		}
		encode = "GBK";
		try {
			if (str.equals(new String(str.getBytes(encode), encode))) {
				String s3 = encode;
				return s3;
			}
		} catch (Exception exception3) {
		}
		encode = "GB18030";
		try {
			if (str.equals(new String(str.getBytes(encode), encode))) {
				String s31 = encode;
				return s31;
			}
		} catch (Exception exception3) {
		}
		encode = "UTF-8";
		try {
			if (str.equals(new String(str.getBytes(encode), encode))) {
				String s2 = encode;
				return s2;
			}
		} catch (Exception exception2) {
		}
		encode = "ISO-8859-1";
		try {
			if (str.equals(new String(str.getBytes(encode), encode))) {
				String s1 = encode;
				return s1;
			}
		} catch (Exception exception1) {
		}
		return "";
	}

	/**
	 * �޸ı������
	 * @return
	 * @throws Exception
	 */
	public String update() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());		
		if (("1").equals(pubNote.getContType())) {//���߱༭
		} else if(("2").equals(pubNote.getContType())) {//�ĵ��ϴ�
			//���ϴ��ļ����޸ĵ�ʱ��
			if(uploadFileName==null){
			}else{//���ļ�����Ϊ�յ�ʱ��
				//���ϴ�
				//String fileName = new String(uploadFileName.getBytes(),"GBK");//�ϴ����ļ���
				String encod = getEncoding(uploadFileName);
				String fileName = null;
				if ("GBK".equals(encod) || "GB2312".equals(encod) || "GB18030".equals(encod)) {
					fileName = uploadFileName;
				} else {
					fileName = new String(uploadFileName.getBytes(), "GBK");// �ϴ����ļ���
				}
				String paString = "";
				String serverPath = UploadConfigurationRead.getInstance().getConfigItem("uploadFilePath").trim();// ��ȡ�������ϴ��ļ���Ŀ¼		           
//				String serverPath = UploadUtil.getParm("uploadFilePath");
				File target = new File(serverPath, fileName);
				FileUtils.copyFile(upload, target);//�ϴ�����������Ŀ¼
				paString = serverPath +"/"+ fileName;  				
				//�ֽ���ǰ���ļ�ɾ��
				File file=new File(pubNote.getNoteFile());
				if(file.exists()){
					UploadUtil.delete(pubNote.getNoteFile());
				}				
				pubNote.setDocName(fileName);
				pubNote.setNoteFile(paString);
				
			}			
		}
//		pubNote.setUpDate(User.getSys_date(this.getHttpRequest()));
		pubNoteBo.update(pubNote);
		this.addActionMessage("�����ɹ�");
		ServletActionContext.getRequest().setAttribute("noteContent", pubNote.getNoteContent());		
		return "input";
	}	
	
	
	/**
	 * ɾ������
	 * @return
	 * @throws Exception
	 */
	public String del() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formsys0098 = formService.getFormData("sys0098");
		pubNote = new PubNote();
		pubNote.setNoteNo(noteNo);
		pubNoteBo.del(pubNote);
		this.addActionMessage("ɾ���ɹ�");
		pubNote = new PubNote();
		Ipage ipage = this.getIpage();
		pubNoteList = (List) pubNoteBo.findByPage(ipage, pubNote).getResult();
		return "listAll";
	}

	
	/**
	 * ��ѯ����
	 * @return
	 * @throws Exception
	 */
	public String getById() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),ServletActionContext.getResponse());
		formsys0091 = formService.getFormData("sys0091");
		pubNote = new PubNote();
		pubNote.setNoteNo(noteNo);
		pubNote = pubNoteBo.getById(pubNote);
		pubNote.getNoteType();
		getObjValue(formsys0091, pubNote);
		return "detail";
	}
	
	/**
	 * �����鿴
	 * @return
	 * @throws Exception
	 */
	public String popView() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),ServletActionContext.getResponse());
		flag = "0";//����һ��
		pubNote = new PubNote();
		pubNote.setNoteNo(noteNo);
		pubNote = pubNoteBo.getById(pubNote);
		String txDate = pubNote.getTxDate();
		if(txDate!=null)
			txDate =  txDate.substring(0, 4)+"��"+txDate.substring(4, 6)+"��"+txDate.substring(6)+"��";
		pubNote.setTxDate(txDate);
		pubNote.getNoteType();
		pub = new PubNote();
		if(!"1".equals(chooseflag)){
			chooseflag = "0";
			pub.setContType("1");//���߱༭
			pubNoteList = pubNoteBo.getTop10(pub);
		}else{
			pub.setNoteType("1");
			pubNoteList = (List) pubNoteBo.findAllByNote_type(pub);
		}		
		for(int i=0;i<pubNoteList.size();i++){
			if(noteNo.equals(pubNoteList.get(i).getNoteNo())){
				next_index = i+1;
				break;
			}
		}
		kb_index = pubNoteList.size();
		if(next_index<pubNoteList.size()){
			pub = pubNoteList.get(next_index);
		}else{
			flag = "1";//û����һ��
		}
		return "popView";
	}
	
	/**
	 * �����鿴
	 * @return
	 * @throws Exception
	 */
	public String popList() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),ServletActionContext.getResponse());
		pubNote = new PubNote();
		pubNote.setNoteType(noteType);
		Ipage ipage = this.getIpage();
		pageNo = ipage.getPageNo();
		pubNoteList = (List) pubNoteBo.findByPage(ipage, pubNote).getResult();
		return "popList";
	}
	
	public String getByIdZsk() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),ServletActionContext.getResponse());
		pubNote = new PubNote();
		pubNote.setNoteNo(noteNo);
		pubNote = pubNoteBo.getById(pubNote);
		pubNote.getNoteType();
		return "detailZsk";
	}
	/**
	 * �����������У��
	 * @return
	 * @throws Exception
	 */
	public void validateInsert(){
		 ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		 formsys0091 = formService.getFormData("sys0091");
		 getFormValue(formsys0091);
		 validateFormData(formsys0091);
   	}
   
	/**
	 * �޸ı������У��
	 * @return
	 * @throws Exception
	 */
	public void validateUpdate(){
		 ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		 formsys0091 = formService.getFormData("sys0091");
		 getFormValue(formsys0091);
		 validateFormData(formsys0091);
  	}
	private String file_name;
	private InputStream downloadFile;
	
	public String downLoad() throws Exception{
		
		Ftp f=new Ftp();
		f.setIpAddr("10.7.53.30");
		f.setUserName("MFS");
		f.setPwd("RsKBnHlj");
		try {
			if(FtpUtil.connectFtp(f)){
				PubNote pubnote = new PubNote();
				pubnote.setNoteNo(noteNo);
				pubnote = pubNoteBo.getById(pubnote);
				this.file_name = new String(getFile_name().getBytes("ISO-8859-1"));
				String ftpFileName = this.file_name;
				String ftpFile = pubnote.getNoteFile();
//				String ftpFilePath = "/PUB/knowledge";
//				String ftpFileNames = ftpFile.substring(15);
				downloadFile = FtpUtil.retrieveFileStream(ftpFile);
				
				if(downloadFile == null){
//					downloadFile.close();
					return "fileNotFound";
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
//			downloadFile.close();
//			FtpUtil.closeFtp();
		}
		return "success";
	}

	public InputStream getDownloadFile() throws IOException {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext
				.getResponse());
		//
		return downloadFile;
//		Ftp f=new Ftp();
//		f.setIpAddr("10.7.53.30");
//		f.setUserName("MFS");
//		f.setPwd("RsKBnHlj");
//		try {
//			if(FtpUtil.connectFtp(f)){
//				String ftpFile = "/PUB/knowledge/���ֽ���ҵ����԰���˵�� .docx";
//				downloadFile = FtpUtil.retrieveFileStream(ftpFile);
//				this.file_name = getFile_name();
//				if(downloadFile == null)
//				return downloadFile;
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}finally{
//			FtpUtil.closeFtp();
//		}
//		
//		return null;
	}
	
	public void setDownloadFile(InputStream downloadFile) {
		this.downloadFile = downloadFile;
	}
	
	public String getFile_name() {
		 try {
			String fileName = new String(this.file_name.getBytes("GBK"), "ISO8859-1");
			return fileName;
			} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}  
		return null;
	}
	
	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}
	private String down_path;
	public String getDown_path() {
		return down_path;
	}
	public void setDown_path(String down_path) {
		this.down_path = down_path;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public FormData getFormsys0091() {
		return formsys0091;
	}
	public void setFormsys0091(FormData formsys0091) {
		this.formsys0091 = formsys0091;
	}
	public FormData getFormsys0090() {
		return formsys0090;
	}
	public void setFormsys0090(FormData formsys0090) {
		this.formsys0090 = formsys0090;
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
	public FormData getFormsys0098() {
		return formsys0098;
	}
	public void setFormsys0098(FormData formsys0098) {
		this.formsys0098 = formsys0098;
	}
	public FormData getFormsys0099() {
		return formsys0099;
	}
	public void setFormsys0099(FormData formsys0099) {
		this.formsys0099 = formsys0099;
	}
	public int getKb_index() {
		return kb_index;
	}
	public void setKb_index(int kbIndex) {
		kb_index = kbIndex;
	}
	public int getNext_index() {
		return next_index;
	}
	public void setNext_index(int nextIndex) {
		next_index = nextIndex;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public String getChooseflag() {
		return chooseflag;
	}
	public void setChooseflag(String chooseflag) {
		this.chooseflag = chooseflag;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public PubNote getPubNote() {
		return pubNote;
	}
	public void setPubNote(PubNote pubNote) {
		this.pubNote = pubNote;
	}
	public PubNote getPub() {
		return pub;
	}
	public void setPub(PubNote pub) {
		this.pub = pub;
	}
	public List<PubNote> getPubNoteList() {
		return pubNoteList;
	}
	public void setPubNoteList(List<PubNote> pubNoteList) {
		this.pubNoteList = pubNoteList;
	}
	public PubNoteBo getPubNoteBo() {
		return pubNoteBo;
	}
	public void setPubNoteBo(PubNoteBo pubNoteBo) {
		this.pubNoteBo = pubNoteBo;
	}
	public String getNoteNo() {
		return noteNo;
	}
	public void setNoteNo(String noteNo) {
		this.noteNo = noteNo;
	}
	public String getNoteType() {
		return noteType;
	}
	public void setNoteType(String noteType) {
		this.noteType = noteType;
	}
	public String getNoteFile() {
		return noteFile;
	}
	public void setNoteFile(String noteFile) {
		this.noteFile = noteFile;
	}
	public String getTxDate() {
		return txDate;
	}
	public void setTxDate(String txDate) {
		this.txDate = txDate;
	}
	public String getDocName() {
		return docName;
	}
	public void setDocName(String docName) {
		this.docName = docName;
	}
	public String getAdd() {
		return add;
	}
	public void setAdd(String add) {
		this.add = add;
	}
	public String getContType() {
		return contType;
	}
	public void setContType(String contType) {
		this.contType = contType;
	}
}