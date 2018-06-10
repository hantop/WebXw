package app.creditapp.sys.entity;
import app.base.BaseDomain;
/**
* Title: PubNote.java
* Description:
* @version��1.0
**/
public class PubNote extends BaseDomain {
	private String noteNo;//������
	private String noteTitle;//�������
	private String noteContent;//��������
	private String noteType;//��������
	private String noteFile;//������ַ
	private String noteVip;//�Ƿ��ö�
	private String endDate;//����ʱ��
	private String noteSts;//����״̬
	private String opNo;//������
	private String txDate;//����ʱ��
	private String upDate;//��������
	private String contType;//�༭����
	private String docName;//�ĵ�����
	
	
	public String getNoteNo() {
		return noteNo;
	}
	public void setNoteNo(String noteNo) {
		this.noteNo = noteNo;
	}
	public String getNoteTitle() {
		return noteTitle;
	}
	public void setNoteTitle(String noteTitle) {
		this.noteTitle = noteTitle;
	}
	public String getNoteContent() {
		return noteContent;
	}
	public void setNoteContent(String noteContent) {
		this.noteContent = noteContent;
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
	public String getNoteVip() {
		return noteVip;
	}
	public void setNoteVip(String noteVip) {
		this.noteVip = noteVip;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getNoteSts() {
		return noteSts;
	}
	public void setNoteSts(String noteSts) {
		this.noteSts = noteSts;
	}
	public String getOpNo() {
		return opNo;
	}
	public void setOpNo(String opNo) {
		this.opNo = opNo;
	}
	public String getTxDate() {
		return txDate;
	}
	public void setTxDate(String txDate) {
		this.txDate = txDate;
	}
	public String getUpDate() {
		return upDate;
	}
	public void setUpDate(String upDate) {
		this.upDate = upDate;
	}
	public String getContType() {
		return contType;
	}
	public void setContType(String contType) {
		this.contType = contType;
	}
	public String getDocName() {
		return docName;
	}
	public void setDocName(String docName) {
		this.docName = docName;
	}

}