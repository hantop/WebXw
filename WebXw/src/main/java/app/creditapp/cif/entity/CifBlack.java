package app.creditapp.cif.entity;
import app.base.BaseDomain;
/**
* Title: CifBlack.java
* Description:
* @version��1.0
**/
public class CifBlack extends BaseDomain {
	private String opNo;//�޸���Ա
	private String upDate;//�޸�����
	private String txDate;//�Ǽ�����
	private String blkId;//������ID
	private String cifNo;//�ͻ���
	private String cifName;//�ͻ�����
	private String idType;//֤������
	private String idNo;//֤����
	private String blkSource;//������Դ[01�ֹ�����02��������03ODS����]
	private String blkLevel;//�������ȼ�[01�ܾ���02Ԥ����03��ʾ��]
	private String blkDate;//����׶�
	private String blkCause;//����ԭ��
	private String blkSts;//����״̬
	private String blkFlag;//״̬[01��Ч02ʧЧ]
	private String processId;//����ʵ����
	private String taskId;//��������ID
	private String url;//���̵�ַ
	
	
	private String opName;//�޸���Ա
	private String apprType;//��������
	
	//������������ѯʹ��
	private String userId;//�û�ID
	private String branchId;//������
	
	//��������������������ѯ����ID
	private String dbid;//������
	
	public String getOpName(){
		return opName;
	}
	
	public void setOpname(String opName){
		this.opName = opName;
	}
	/**
	 * @return �޸�����
	 */
	public String getUpDate() {
	 	return upDate;
	}
	/**
	 * @���� �޸�����
	 * @param upDate
	 */
	public void setUpDate(String upDate) {
	 	this.upDate = upDate;
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
	 * @return ������ID
	 */
	public String getBlkId() {
	 	return blkId;
	}
	/**
	 * @���� ������ID
	 * @param blkId
	 */
	public void setBlkId(String blkId) {
	 	this.blkId = blkId;
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
	 * @return ֤������
	 */
	public String getIdType() {
	 	return idType;
	}
	/**
	 * @���� ֤������
	 * @param idType
	 */
	public void setIdType(String idType) {
	 	this.idType = idType;
	}
	/**
	 * @return ֤����
	 */
	public String getIdNo() {
	 	return idNo;
	}
	/**
	 * @���� ֤����
	 * @param idNo
	 */
	public void setIdNo(String idNo) {
	 	this.idNo = idNo;
	}
	/**
	 * @return ������Դ[01�ֹ�����02��������03ODS����]
	 */
	public String getBlkSource() {
	 	return blkSource;
	}
	/**
	 * @���� ������Դ[01�ֹ�����02��������03ODS����]
	 * @param blkSource
	 */
	public void setBlkSource(String blkSource) {
	 	this.blkSource = blkSource;
	}
	/**
	 * @return �������ȼ�[01�ܾ���02Ԥ����03��ʾ��]
	 */
	public String getBlkLevel() {
	 	return blkLevel;
	}
	/**
	 * @���� �������ȼ�[01�ܾ���02Ԥ����03��ʾ��]
	 * @param blkLevel
	 */
	public void setBlkLevel(String blkLevel) {
	 	this.blkLevel = blkLevel;
	}
	/**
	 * @return ����ԭ��
	 */
	public String getBlkCause() {
	 	return blkCause;
	}
	/**
	 * @���� ����ԭ��
	 * @param blkCause
	 */
	public void setBlkCause(String blkCause) {
	 	this.blkCause = blkCause;
	}
	/**
	 * @return �ύ״̬[01δ�ύ02δ����03���04��Ч]
	 */
	public String getBlkDate() {
	 	return blkDate;
	}
	/**
	 * @���� �ύ״̬[01δ�ύ02δ����03���04��Ч]
	 * @param blkSts
	 */
	public void setBlkDate(String blkDate) {
	 	this.blkDate = blkDate;
	}
	/**
	 * @return �����ʶ[01����02�Ƴ�]
	 */
	public String getBlkFlag() {
	 	return blkFlag;
	}
	/**
	 * @���� �����ʶ[01����02�Ƴ�]
	 * @param blkFlag
	 */
	public void setBlkFlag(String blkFlag) {
	 	this.blkFlag = blkFlag;
	}
	/**
	 * @return ���йܻ������
	 */
	public String getOpNo() {
	 	return opNo;
	}
	/**
	 * @���� ���йܻ������
	 * @param opNo
	 */
	public void setOpNo(String opNo) {
	 	this.opNo = opNo;
	}
	public String getBlkSts() {
		return blkSts;
	}
	public void setBlkSts(String blkSts) {
		this.blkSts = blkSts;
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
	public String getProcessId() {
		return processId;
	}
	public void setProcessId(String processId) {
		this.processId = processId;
	}

	public String getApprType() {
		return apprType;
	}

	public void setApprType(String apprType) {
		this.apprType = apprType;
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