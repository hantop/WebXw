package app.creditapp.cred.entity;

import app.base.BaseDomain;
/**
 * 
  * �����ƣ�PcrpQueryInfo
  * �������� 
  * �����ˣ�lidong dhcc
  * ����ʱ�䣺2015-7-15 ����01:06:30
  * �޸��ˣ�Administrator  
 * @version
 */
public class PcrpQueryInfo extends BaseDomain implements java.io.Serializable{
	private String crpId;      //���ñ����ѯ��ϢID    
	private String custNo;     //�ͻ���       
	private String batchNo;     //���κ�     
	private String custName;   //�ͻ�����              
	private String reportType; //��������(��ѯ��ʽ)    //
	private String certType;   //֤������              
	private String certNum;    //֤������              
	private String crpTime;    //��ѯʱ��              
	private String crpReason;  //��ѯԭ��              //
	private String crpSts;     //��ѯ״̬              
	private String crpType;    //ϵͳ����              
	private String grandId;    //��ȨID                //
	private String crpMtrDate; //���ñ���ʧЧ����      
	private String intOprrno;  //���ñ������в�ѯ����Ա
	private String reportId;   //���ñ�����
	private String crpContent; //���ñ�������          
	private String crpFileName; //���ñ����ļ�·��      
	private String txDate;     //��������              
	private String ipAddr;     //IP_ADDR               
	private String macAddr;    // MAC_ADDR             
	private String remarks;    //��ע                  
	private String crpExpDate; //ϵͳ������ȡ����      //
	private String crpFilePath;//���ñ���·��          
	private String opprNo;     //���ñ��汾����ѯԱ    
	private String brNo;       //���ñ����ѯ������   
	private String querytype;       //���ñ����ѯ������   
	private String aft_id;  //�������ñ���ID
	private String existFlag;  //���ڱ�־
	private String validFlag;  //��Ч��־
	private String czPactNo;  //ҵ����
	
	public String getExistFlag() {
		return existFlag;
	}

	public void setExistFlag(String existFlag) {
		this.existFlag = existFlag;
	}

	public String getValidFlag() {
		return validFlag;
	}

	public void setValidFlag(String validFlag) {
		this.validFlag = validFlag;
	}

	public PcrpQueryInfo(){
		this.crpId="";      
		this.custNo="";   
		this.batchNo="";  
		this.custName="";   
		this.reportType=""; 
		this.certType="";   
		this.certNum="";    
		this.crpTime="";    
		this.crpReason="";  
		this.crpSts="";     
		this.crpType="";    
		this.grandId="";    
		this.crpMtrDate=""; 
		this.intOprrno="";  
		this.reportId="";   
		this.crpContent=""; 
		this.crpFileName="";
		this.txDate="";     
		this.ipAddr="";     
		this.macAddr="";    
		this.remarks="";    
		this.crpExpDate=""; 
		this.crpFilePath="";
		this.opprNo="";     
		this.brNo="";       
		this.querytype="";  
		this.aft_id="";  
	}
	
	public String getAft_id() {
		return aft_id;
	}
	public void setAft_id(String aftId) {
		aft_id = aftId;
	}
	public String getCrpId() {
		return crpId;
	}
	public void setCrpId(String crpId) {
		this.crpId = crpId;
	}
	public String getCustNo() {
		return custNo;
	}
	public void setCustNo(String custNo) {
		this.custNo = custNo;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getReportType() {
		return reportType;
	}
	public void setReportType(String reportType) {
		this.reportType = reportType;
	}
	public String getCertType() {
		return certType;
	}
	public void setCertType(String certType) {
		this.certType = certType;
	}
	public String getCertNum() {
		return certNum;
	}
	public void setCertNum(String certNum) {
		this.certNum = certNum;
	}
	public String getCrpTime() {
		return crpTime;
	}
	public void setCrpTime(String crpTime) {
		this.crpTime = crpTime;
	}
	public String getCrpReason() {
		return crpReason;
	}
	public void setCrpReason(String crpReason) {
		this.crpReason = crpReason;
	}
	public String getCrpSts() {
		return crpSts;
	}
	public void setCrpSts(String crpSts) {
		this.crpSts = crpSts;
	}
	public String getCrpType() {
		return crpType;
	}
	public void setCrpType(String crpType) {
		this.crpType = crpType;
	}
	public String getGrandId() {
		return grandId;
	}
	public void setGrandId(String grandId) {
		this.grandId = grandId;
	}
	public String getCrpMtrDate() {
		return crpMtrDate;
	}
	public void setCrpMtrDate(String crpMtrDate) {
		this.crpMtrDate = crpMtrDate;
	}
	public String getIntOprrno() {
		return intOprrno;
	}
	public void setIntOprrno(String intOprrno) {
		this.intOprrno = intOprrno;
	}
	public String getCrpContent() {
		return crpContent;
	}
	public void setCrpContent(String crpContent) {
		this.crpContent = crpContent;
	}
	
	public String getCrpFileName() {
		return crpFileName;
	}
	public void setCrpFileName(String crpFileName) {
		this.crpFileName = crpFileName;
	}
	public String getTxDate() {
		return txDate;
	}
	public void setTxDate(String txDate) {
		this.txDate = txDate;
	}
	public String getIpAddr() {
		return ipAddr;
	}
	public void setIpAddr(String ipAddr) {
		this.ipAddr = ipAddr;
	}
	public String getMacAddr() {
		return macAddr;
	}
	public void setMacAddr(String macAddr) {
		this.macAddr = macAddr;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getCrpExpDate() {
		return crpExpDate;
	}
	public void setCrpExpDate(String crpExpDate) {
		this.crpExpDate = crpExpDate;
	}
	public String getCrpFilePath() {
		return crpFilePath;
	}
	public void setCrpFilePath(String crpFilePath) {
		this.crpFilePath = crpFilePath;
	}
	public String getOpprNo() {
		return opprNo;
	}
	public void setOpprNo(String opprNo) {
		this.opprNo = opprNo;
	}
	public String getBrNo() {
		return brNo;
	}
	public void setBrNo(String brNo) {
		this.brNo = brNo;
	}
	public String getQuerytype() {
		return querytype;
	}
	public void setQuerytype(String querytype) {
		this.querytype = querytype;
	}
	public String getReportId() {
		return reportId;
	}
	public void setReportId(String reportId) {
		this.reportId = reportId;
	}

	public String getBatchNo() {
		return batchNo;
	}

	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}

	public String getCzPactNo() {
		return czPactNo;
	}

	public void setCzPactNo(String czPactNo) {
		this.czPactNo = czPactNo;
	}

	   
}
