package app.creditapp.ln.entity;
import app.base.BaseDomain;
/**
* Title: LnApprIdea.java
* Description:
* @version��1.0
**/
public class LnApprIdea extends BaseDomain {
	private String ideaId;//���ID
	private String appId;//����ID
	private String apprId;//��������ID
	private String apprType;//��������[01�Զ�02�˹�]
	private String apprTime;//����ʱ��
	private String apprOpt;//������
	private String apprIdea;//�������[01ͬ��02���03����04�˻�]
	private String apprDesc;//��������
	private String apprOp;//������
	private String apprRole;//������ɫ
	private String apprKind;//��������[01��������02��������03����������04��������]
	
	private String batchNo;//���κ�
	private String brNo;//������
	private String brName;//��������
	private String projName;//��Ŀ����
	
	private String processId;
	private String taskId;
	private String apprRoleName;//������ɫ����
	private String userName;//�����û�
	private String url;
	
	//Ϣ�Ѽ���
	private Double loAmt;//Ƿ��
	private Double loIntst;//ǷϢ
	private Double refIntst;//������Ϣ
	private Double refAmt;//���Ȿ��
	private String pactNo;//��ͬ��
	private String cifNo;//�ͻ���
	private String cifName;//�ͻ�����
	
	//���� 
	private String txDt;//��������
	private String txTime;//��������
	private String txCde;//���״���
	
	
	
	private String idType;//
	private String idNo;//
	private String blkFlag;//
	/**
	 * @return ���ID
	 */
	public String getIdeaId() {
	 	return ideaId;
	}
	/**
	 * @���� ���ID
	 * @param ideaId
	 */
	public void setIdeaId(String ideaId) {
	 	this.ideaId = ideaId;
	}
	/**
	 * @return ����ID
	 */
	public String getAppId() {
	 	return appId;
	}
	/**
	 * @���� ����ID
	 * @param appId
	 */
	public void setAppId(String appId) {
	 	this.appId = appId;
	}
	/**
	 * @return ��������ID
	 */
	public String getApprId() {
		return apprId;
	}
	/**
	 * @���� ��������ID
	 * @param batchId
	 */
	public void setApprId(String apprId) {
		this.apprId = apprId;
	}
	/**
	 * @return ��������[01�Զ�02�˹�]
	 */
	public String getApprType() {
	 	return apprType;
	}
	/**
	 * @���� ��������[01�Զ�02�˹�]
	 * @param apprType
	 */
	public void setApprType(String apprType) {
	 	this.apprType = apprType;
	}
	/**
	 * @return ����ʱ��
	 */
	public String getApprTime() {
	 	return apprTime;
	}
	/**
	 * @���� ����ʱ��
	 * @param apprTime
	 */
	public void setApprTime(String apprTime) {
	 	this.apprTime = apprTime;
	}
	/**
	 * @return ������
	 */
	public String getApprOpt() {
	 	return apprOpt;
	}
	/**
	 * @���� ������
	 * @param apprOpt
	 */
	public void setApprOpt(String apprOpt) {
	 	this.apprOpt = apprOpt;
	}
	/**
	 * @return �������[01ͬ��02���03����04�˻�]
	 */
	public String getApprIdea() {
	 	return apprIdea;
	}
	/**
	 * @���� �������[01ͬ��02���03����04�˻�]
	 * @param apprIdea
	 */
	public void setApprIdea(String apprIdea) {
	 	this.apprIdea = apprIdea;
	}
	/**
	 * @return ��������
	 */
	public String getApprDesc() {
	 	return apprDesc;
	}
	/**
	 * @���� ��������
	 * @param apprDesc
	 */
	public void setApprDesc(String apprDesc) {
	 	this.apprDesc = apprDesc;
	}
	/**
	 * @return ������
	 */
	public String getApprOp() {
	 	return apprOp;
	}
	/**
	 * @���� ������
	 * @param apprOp
	 */
	public void setApprOp(String apprOp) {
	 	this.apprOp = apprOp;
	}

	public String getTaskId() {
		return taskId;
	}
	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}
	public String getBatchNo() {
		return batchNo;
	}
	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}
	public String getBrNo() {
		return brNo;
	}
	public void setBrNo(String brNo) {
		this.brNo = brNo;
	}

	/**
	 * @return ������ɫ
	 */
	public String getApprRole() {
		return apprRole;
	}
	/**
	 * @���� ������ɫ
	 * @param apprRole
	 */
	public void setApprRole(String apprRole) {
		this.apprRole = apprRole;
	}
	public String getApprKind() {
		return apprKind;
	}
	public void setApprKind(String apprKind) {
		this.apprKind = apprKind;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getApprRoleName() {
		return apprRoleName;
	}
	public void setApprRoleName(String apprRoleName) {
		this.apprRoleName = apprRoleName;
	}
	public String getBrName() {
		return brName;
	}
	public void setBrName(String brName) {
		this.brName = brName;
	}
	public Double getLoAmt() {
		return loAmt;
	}
	public void setLoAmt(Double loAmt) {
		this.loAmt = loAmt;
	}
	public Double getLoIntst() {
		return loIntst;
	}
	public void setLoIntst(Double loIntst) {
		this.loIntst = loIntst;
	}
	public Double getRefIntst() {
		return refIntst;
	}
	public void setRefIntst(Double refIntst) {
		this.refIntst = refIntst;
	}
	public Double getRefAmt() {
		return refAmt;
	}
	public void setRefAmt(Double refAmt) {
		this.refAmt = refAmt;
	}
	public String getPactNo() {
		return pactNo;
	}
	public void setPactNo(String pactNo) {
		this.pactNo = pactNo;
	}
	public String getCifNo() {
		return cifNo;
	}
	public void setCifNo(String cifNo) {
		this.cifNo = cifNo;
	}
	public String getCifName() {
		return cifName;
	}
	public void setCifName(String cifName) {
		this.cifName = cifName;
	}
	public String getTxDt() {
		return txDt;
	}
	public void setTxDt(String txDt) {
		this.txDt = txDt;
	}
	public String getTxTime() {
		return txTime;
	}
	public void setTxTime(String txTime) {
		this.txTime = txTime;
	}
	public String getTxCde() {
		return txCde;
	}
	public void setTxCde(String txCde) {
		this.txCde = txCde;
	}
	public String getProcessId() {
		return processId;
	}
	public void setProcessId(String processId) {
		this.processId = processId;
	}
	public String getProjName() {
		return projName;
	}
	public void setProjName(String projName) {
		this.projName = projName;
	}
	public String getIdType() {
		return idType;
	}
	public void setIdType(String idType) {
		this.idType = idType;
	}
	public String getIdNo() {
		return idNo;
	}
	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}
	public String getBlkFlag() {
		return blkFlag;
	}
	public void setBlkFlag(String blkFlag) {
		this.blkFlag = blkFlag;
	}
	
}