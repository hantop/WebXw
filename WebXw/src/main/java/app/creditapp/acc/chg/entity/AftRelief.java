package app.creditapp.acc.chg.entity;
import app.base.BaseDomain;
/**
* Title: AftRelief.java
* Description:
* @version��1.0
**/
public class AftRelief extends BaseDomain {
	private String refId;//����ID
	private Double loFee;//Ƿ����
	private Double refAmt;//���Ȿ��
	private Double refIntst;//������Ϣ
	private Double refFine;//���ⷣϢ
	private Double refFee;//�������
	private String refSts;//״̬
	private String opNo;//����Ա
	private String txDate;//�Ǽ�����
	private String upDate;//��������
	private String traceNo;//��������ˮ��
	private String pactId;//��ͬID
	private String pactNo;//��ͬ��
	private String brNo;//������
	private String cifNo;//�ͻ���
	private String cifName;//�ͻ�����
	private Double dueAmt;//��ݽ��
	private Double loIntst;//ǷϢ
	private Double loAmt;//Ƿ��
	private Double loFine;//Ƿ��Ϣ
	private String appSts;//����״̬
	private String processId;//������ID
	private String brName;//��������
	private String opName;//��������
	private String taskId;//��������ID
	private String url;//���̵�ַ
	
	//������������ѯʹ��
	private String userId;//�û�ID
	private String branchId;//������
	
	//��������������������ѯ����ID
	private String dbid;//������
	/**
	 * @return ����ID
	 */
	public String getRefId() {
	 	return refId;
	}
	/**
	 * @���� ����ID
	 * @param refId
	 */
	public void setRefId(String refId) {
	 	this.refId = refId;
	}
	/**
	 * @return Ƿ����
	 */
	public Double getLoFee() {
	 	return loFee;
	}
	/**
	 * @���� Ƿ����
	 * @param loFee
	 */
	public void setLoFee(Double loFee) {
	 	this.loFee = loFee;
	}
	/**
	 * @return ���Ȿ��
	 */
	public Double getRefAmt() {
	 	return refAmt;
	}
	/**
	 * @���� ���Ȿ��
	 * @param refAmt
	 */
	public void setRefAmt(Double refAmt) {
	 	this.refAmt = refAmt;
	}
	/**
	 * @return ������Ϣ
	 */
	public Double getRefIntst() {
	 	return refIntst;
	}
	/**
	 * @���� ������Ϣ
	 * @param refIntst
	 */
	public void setRefIntst(Double refIntst) {
	 	this.refIntst = refIntst;
	}
	/**
	 * @return ���ⷣϢ
	 */
	public Double getRefFine() {
	 	return refFine;
	}
	/**
	 * @���� ���ⷣϢ
	 * @param refFine
	 */
	public void setRefFine(Double refFine) {
	 	this.refFine = refFine;
	}
	/**
	 * @return �������
	 */
	public Double getRefFee() {
	 	return refFee;
	}
	/**
	 * @���� �������
	 * @param refFee
	 */
	public void setRefFee(Double refFee) {
	 	this.refFee = refFee;
	}
	/**
	 * @return ״̬
	 */
	public String getRefSts() {
	 	return refSts;
	}
	/**
	 * @���� ״̬
	 * @param refSts
	 */
	public void setRefSts(String refSts) {
	 	this.refSts = refSts;
	}
	/**
	 * @return ����Ա
	 */
	public String getOpNo() {
	 	return opNo;
	}
	/**
	 * @���� ����Ա
	 * @param opNo
	 */
	public void setOpNo(String opNo) {
	 	this.opNo = opNo;
	}
	/**
	 * @return �Ǽ�����
	 */
	public String getTxDate() {
	 	return txDate;
	}
	/**
	 * @���� �Ǽ�����
	 * @param txDate
	 */
	public void setTxDate(String txDate) {
	 	this.txDate = txDate;
	}
	/**
	 * @return ��������
	 */
	public String getUpDate() {
	 	return upDate;
	}
	/**
	 * @���� ��������
	 * @param upDate
	 */
	public void setUpDate(String upDate) {
	 	this.upDate = upDate;
	}
	/**
	 * @return ��������ˮ��
	 */
	public String getTraceNo() {
	 	return traceNo;
	}
	/**
	 * @���� ��������ˮ��
	 * @param traceNo
	 */
	public void setTraceNo(String traceNo) {
	 	this.traceNo = traceNo;
	}
	/**
	 * @return ��ͬID
	 */
	public String getPactId() {
	 	return pactId;
	}
	/**
	 * @���� ��ͬID
	 * @param pactId
	 */
	public void setPactId(String pactId) {
	 	this.pactId = pactId;
	}
	/**
	 * @return ��ͬ��
	 */
	public String getPactNo() {
	 	return pactNo;
	}
	/**
	 * @���� ��ͬ��
	 * @param pactNo
	 */
	public void setPactNo(String pactNo) {
	 	this.pactNo = pactNo;
	}
	/**
	 * @return ������
	 */
	public String getBrNo() {
	 	return brNo;
	}
	/**
	 * @���� ������
	 * @param brNo
	 */
	public void setBrNo(String brNo) {
	 	this.brNo = brNo;
	}
	/**
	 * @return �ͻ���
	 */
	public String getCifNo() {
	 	return cifNo;
	}
	/**
	 * @���� �ͻ���
	 * @param cifNo
	 */
	public void setCifNo(String cifNo) {
	 	this.cifNo = cifNo;
	}
	/**
	 * @return �ͻ�����
	 */
	public String getCifName() {
	 	return cifName;
	}
	/**
	 * @���� �ͻ�����
	 * @param cifName
	 */
	public void setCifName(String cifName) {
	 	this.cifName = cifName;
	}
	/**
	 * @return ��ݽ��
	 */
	public Double getDueAmt() {
	 	return dueAmt;
	}
	/**
	 * @���� ��ݽ��
	 * @param dueAmt
	 */
	public void setDueAmt(Double dueAmt) {
	 	this.dueAmt = dueAmt;
	}
	/**
	 * @return ǷϢ
	 */
	public Double getLoIntst() {
	 	return loIntst;
	}
	/**
	 * @���� ǷϢ
	 * @param loIntst
	 */
	public void setLoIntst(Double loIntst) {
	 	this.loIntst = loIntst;
	}
	/**
	 * @return Ƿ��
	 */
	public Double getLoAmt() {
	 	return loAmt;
	}
	/**
	 * @���� Ƿ��
	 * @param loAmt
	 */
	public void setLoAmt(Double loAmt) {
	 	this.loAmt = loAmt;
	}
	/**
	 * @return Ƿ��Ϣ
	 */
	public Double getLoFine() {
	 	return loFine;
	}
	/**
	 * @���� Ƿ��Ϣ
	 * @param loFine
	 */
	public void setLoFine(Double loFine) {
	 	this.loFine = loFine;
	}
	public String getAppSts() {
		return appSts;
	}
	public void setAppSts(String appSts) {
		this.appSts = appSts;
	}
	public String getProcessId() {
		return processId;
	}
	public void setProcessId(String processId) {
		this.processId = processId;
	}
	public String getTaskId() {
		return taskId;
	}
	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getBrName() {
		return brName;
	}
	public void setBrName(String brName) {
		this.brName = brName;
	}
	public String getOpName() {
		return opName;
	}
	public void setOpName(String opName) {
		this.opName = opName;
	}
	public String getUserId() {
		return userId;
	}
	public String getBranchId() {
		return branchId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}
	public String getDbid() {
		return dbid;
	}
	public void setDbid(String dbid) {
		this.dbid = dbid;
	}
}