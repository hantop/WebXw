package accounting.domain.loan;
/**
* Title: LnBatch.java
* Description:
* @���� su
* @���� 2018-3-20
* @version��1.0
**/
public class LnBatch extends accounting.domain.sys.CMISDomain {
	private String brNo;//������������
	private String batchNo;//���α��
	private String batchDate;//���ν�������
	private String batchTime;//���ν���ʱ��
	private String batchType;//��������[01�����ϴ�02�˹�����]
	private String batchFile;//�����ļ�����
	private String batchErrfile;//���������ļ�����
	private Integer batchNum;//��������
	private Integer dbNum;//������
	private Integer chkNum;//ɸ�����
	private Integer chkNumOk;//ɸ��ͨ������
	private Integer autoNum;//�Զ���������
	private Integer appNum;//�˹���������
	private Integer appNumOk;//�˹�����ͨ������
	private Integer lnNum;//�ſ��������
	private Integer lnNumFz;//�ſ�����˱���
	private Integer lnNumOk;//�ſ�ɹ�����
	private String batchSts;//���δ���״̬[01δ����02������03�������]
	private String upTime;//������ʱ��

	private Double appAmt;
	private Double dueAmt;
	
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
	 * @return �����ļ�����
	 */
	public String getBatchFile() {
	 	return batchFile;
	}
	/**
	 * @���� �����ļ�����
	 * @param batchFile
	 */
	public void setBatchFile(String batchFile) {
	 	this.batchFile = batchFile;
	}
	/**
	 * @return ���������ļ�����
	 */
	public String getBatchErrfile() {
	 	return batchErrfile;
	}
	/**
	 * @���� ���������ļ�����
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
	 * @return �Զ���������
	 */
	public Integer getAutoNum() {
	 	return autoNum;
	}
	/**
	 * @���� �Զ���������
	 * @param autoNum
	 */
	public void setAutoNum(Integer autoNum) {
	 	this.autoNum = autoNum;
	}
	/**
	 * @return �˹���������
	 */
	public Integer getAppNum() {
	 	return appNum;
	}
	/**
	 * @���� �˹���������
	 * @param appNum
	 */
	public void setAppNum(Integer appNum) {
	 	this.appNum = appNum;
	}
	/**
	 * @return �˹�����ͨ������
	 */
	public Integer getAppNumOk() {
	 	return appNumOk;
	}
	/**
	 * @���� �˹�����ͨ������
	 * @param appNumOk
	 */
	public void setAppNumOk(Integer appNumOk) {
	 	this.appNumOk = appNumOk;
	}
	/**
	 * @return �ſ��������
	 */
	public Integer getLnNum() {
	 	return lnNum;
	}
	/**
	 * @���� �ſ��������
	 * @param lnNum
	 */
	public void setLnNum(Integer lnNum) {
	 	this.lnNum = lnNum;
	}
	/**
	 * @return �ſ�����˱���
	 */
	public Integer getLnNumFz() {
	 	return lnNumFz;
	}
	/**
	 * @���� �ſ�����˱���
	 * @param lnNumFz
	 */
	public void setLnNumFz(Integer lnNumFz) {
	 	this.lnNumFz = lnNumFz;
	}
	/**
	 * @return �ſ�ɹ�����
	 */
	public Integer getLnNumOk() {
	 	return lnNumOk;
	}
	/**
	 * @���� �ſ�ɹ�����
	 * @param lnNumOk
	 */
	public void setLnNumOk(Integer lnNumOk) {
	 	this.lnNumOk = lnNumOk;
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
	 * @return the appAmt
	 */
	public Double getAppAmt() {
		return appAmt;
	}
	/**
	 * @param appAmt the appAmt to set
	 */
	public void setAppAmt(Double appAmt) {
		this.appAmt = appAmt;
	}
	/**
	 * @return the dueAmt
	 */
	public Double getDueAmt() {
		return dueAmt;
	}
	/**
	 * @param dueAmt the dueAmt to set
	 */
	public void setDueAmt(Double dueAmt) {
		this.dueAmt = dueAmt;
	}
}