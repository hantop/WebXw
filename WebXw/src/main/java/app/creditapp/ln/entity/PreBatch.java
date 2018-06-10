package app.creditapp.ln.entity;
import app.base.BaseDomain;
/**
* Title: PreBatch.java
* Description:
* @version��1.0
**/
public class PreBatch extends BaseDomain {
	private String brNo;//������������
	private String brName;//������������
	private String batchNo;//���α��
	private String batchTime;//���ν���ʱ��
	private String batchType;//��������[01�����ϴ�02�˹�����]
	private String batchFile;//�����ļ�
	private String batchErrfile;//�����ļ�
	private Integer batchNum;//��������
	private Integer dbNum;//������
	private Integer chkNum;//ɸ�����
	private Integer chkNumOk;//ɸ��ͨ������
	private String batchSts;//���δ���״̬[01δ����02������03�������]
	private String upTime;//������ʱ��
	private String batchDate;//���ν�������
	private String loginid;//��¼����Ա
	
	public String getLoginid() {
		return loginid;
	}

	public void setLoginid(String loginid) {
		this.loginid = loginid;
	}

	public PreBatch(){
		batchNum=0;
		dbNum=0;
		chkNumOk=0;
		chkNum=0;
	}
	
	/**
	 * @return ������������
	 */
	public String getBrNo() {
	 	return brNo;
	}
	/**
	 * @���� ������������
	 * @param brNo
	 */
	public void setBrNo(String brNo) {
	 	this.brNo = brNo;
	}
	public String getBrName() {
		return brName;
	}
	public void setBrName(String brName) {
		this.brName = brName;
	}
	/**
	 * @return ���α��
	 */
	public String getBatchNo() {
	 	return batchNo;
	}
	/**
	 * @���� ���α��
	 * @param batchNo
	 */
	public void setBatchNo(String batchNo) {
	 	this.batchNo = batchNo;
	}
	/**
	 * @return ���ν���ʱ��
	 */
	public String getBatchTime() {
	 	return batchTime;
	}
	/**
	 * @���� ���ν���ʱ��
	 * @param batchTime
	 */
	public void setBatchTime(String batchTime) {
	 	this.batchTime = batchTime;
	}
	/**
	 * @return ��������[01�����ϴ�02�˹�����]
	 */
	public String getBatchType() {
	 	return batchType;
	}
	/**
	 * @���� ��������[01�����ϴ�02�˹�����]
	 * @param batchType
	 */
	public void setBatchType(String batchType) {
	 	this.batchType = batchType;
	}
	/**
	 * @return �����ļ�
	 */
	public String getBatchFile() {
	 	return batchFile;
	}
	/**
	 * @���� �����ļ�
	 * @param batchFile
	 */
	public void setBatchFile(String batchFile) {
	 	this.batchFile = batchFile;
	}
	/**
	 * @return �����ļ�
	 */
	public String getBatchErrfile() {
	 	return batchErrfile;
	}
	/**
	 * @���� �����ļ�
	 * @param batchErrfile
	 */
	public void setBatchErrfile(String batchErrfile) {
	 	this.batchErrfile = batchErrfile;
	}
	/**
	 * @return ��������
	 */
	public Integer getBatchNum() {
	 	return batchNum;
	}
	/**
	 * @���� ��������
	 * @param batchNum
	 */
	public void setBatchNum(Integer batchNum) {
	 	this.batchNum = batchNum;
	}
	/**
	 * @return ������
	 */
	public Integer getDbNum() {
	 	return dbNum;
	}
	/**
	 * @���� ������
	 * @param dbNum
	 */
	public void setDbNum(Integer dbNum) {
	 	this.dbNum = dbNum;
	}
	/**
	 * @return ɸ�����
	 */
	public Integer getChkNum() {
	 	return chkNum;
	}
	/**
	 * @���� ɸ�����
	 * @param chkNum
	 */
	public void setChkNum(Integer chkNum) {
	 	this.chkNum = chkNum;
	}
	/**
	 * @return ɸ��ͨ������
	 */
	public Integer getChkNumOk() {
	 	return chkNumOk;
	}
	/**
	 * @���� ɸ��ͨ������
	 * @param chkNumOk
	 */
	public void setChkNumOk(Integer chkNumOk) {
	 	this.chkNumOk = chkNumOk;
	}
	/**
	 * @return ���δ���״̬[01δ����02������03�������]
	 */
	public String getBatchSts() {
	 	return batchSts;
	}
	/**
	 * @���� ���δ���״̬[01δ����02������03�������]
	 * @param batchSts
	 */
	public void setBatchSts(String batchSts) {
	 	this.batchSts = batchSts;
	}
	/**
	 * @return ������ʱ��
	 */
	public String getUpTime() {
	 	return upTime;
	}
	/**
	 * @���� ������ʱ��
	 * @param upTime
	 */
	public void setUpTime(String upTime) {
	 	this.upTime = upTime;
	}
	/**
	 * @return ���ν�������
	 */
	public String getBatchDate() {
	 	return batchDate;
	}
	/**
	 * @���� ���ν�������
	 * @param batchDate
	 */
	public void setBatchDate(String batchDate) {
	 	this.batchDate = batchDate;
	}
}