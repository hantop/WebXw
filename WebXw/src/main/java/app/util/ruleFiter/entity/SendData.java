package app.util.ruleFiter.entity;

import java.io.File;

import app.util.ruleFiter.type.FileType;

public class SendData {
	/**
	 * ׼�����õ�У������ID
	 */
	private String sendRuleId; 
	/**
	 * ����У�����ݵĸ�ʽ
	 */
	private FileType fileType; 
	/**
	 * �����ļ�
	 */
	private File sendFileData;
	/**
	 * �����ַ���
	 */
	private String sendStringData;
	/**
	 * ����������Ϣ
	 */
	private String remarks;
	
	
	public String getSendRuleId() {
		return sendRuleId;
	}
	public void setSendRuleId(String sendRuleId) {
		this.sendRuleId = sendRuleId;
	}
	public FileType getFileType() {
		return fileType;
	}
	public void setFileType(FileType fileType) {
		this.fileType = fileType;
	}
	public File getSendFileData() {
		return sendFileData;
	}
	public void setSendFileData(File sendFileData) {
		this.sendFileData = sendFileData;
	}
	public String getSendStringData() {
		return sendStringData;
	}
	public void setSendStringData(String sendStringData) {
		this.sendStringData = sendStringData;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
}
