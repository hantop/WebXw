package app.creditapp.acc.log.entity;
import app.base.BaseDomain;
/**
* Title: AcTraceLog.java
* Description:
* @version��1.0
**/
public class AcTraceLog extends BaseDomain {
	private Integer traceCnt;//��ˮ�ʴ�
	private String traceNo;//������ˮ��
	private String txDt;//��������
	private String txTime;//����ʱ��
	private String txBrNo;//���׻�����
	private String txCde;//���״���
	private String subTxCde;//�ӽ��״���
	private String svcInd;//�������
	private String curNo;//����
	private String prdtNo;//������
	private String loanNo;//��ݺ�
	private String pactNo;//��ͬ��
	private String brNo;//������
	private String addInd;//������־
	private String ctInd;//ת�˱�־
	private Double amt;//������
	private String hstInd;//�Ƿ��Ѿ�����ϸ
	private String cancelInd;//���˱�־
	private Integer ejfno;//��Ա��ˮ��
	private Integer ptTraceNo;//ƽ̨��ˮ��
	private String memo;//ժҪ
	private String cancelTraceNo;//������ˮ��
	private String appSts;//����״̬
	private String processId;//������ID
	private String prdtName;//��Ʒ����
	private String brName;//������������
	private String taskId;//��������ID
	private String url;//���̵�ַ
	
	//�׾ݱ� ������������
	private String cifName;//�ͻ�����
	
	//������������ѯʹ��
	private String userId;//�û�ID
	private String branchId;//������
	private String cifNo;//�ͻ���
	private String loginid;//��¼��Ա
	
	public String getLoginid() {
		return loginid;
	}
	public void setLoginid(String loginid) {
		this.loginid = loginid;
	}
	public String getCifNo() {
		return cifNo;
	}
	public void setCifNo(String cifNo) {
		this.cifNo = cifNo;
	}
	/**
	 * @return ��ˮ�ʴ�
	 */
	public Integer getTraceCnt() {
	 	return traceCnt;
	}
	/**
	 * @���� ��ˮ�ʴ�
	 * @param traceCnt
	 */
	public void setTraceCnt(Integer traceCnt) {
	 	this.traceCnt = traceCnt;
	}
	/**
	 * @return ������ˮ��
	 */
	public String getTraceNo() {
	 	return traceNo;
	}
	/**
	 * @���� ������ˮ��
	 * @param traceNo
	 */
	public void setTraceNo(String traceNo) {
	 	this.traceNo = traceNo;
	}
	/**
	 * @return ��������
	 */
	public String getTxDt() {
	 	return txDt;
	}
	/**
	 * @���� ��������
	 * @param txDt
	 */
	public void setTxDt(String txDt) {
	 	this.txDt = txDt;
	}
	/**
	 * @return ����ʱ��
	 */
	public String getTxTime() {
	 	return txTime;
	}
	/**
	 * @���� ����ʱ��
	 * @param txTime
	 */
	public void setTxTime(String txTime) {
	 	this.txTime = txTime;
	}
	/**
	 * @return ���׻�����
	 */
	public String getTxBrNo() {
	 	return txBrNo;
	}
	/**
	 * @���� ���׻�����
	 * @param txBrNo
	 */
	public void setTxBrNo(String txBrNo) {
	 	this.txBrNo = txBrNo;
	}
	/**
	 * @return ���״���
	 */
	public String getTxCde() {
	 	return txCde;
	}
	/**
	 * @���� ���״���
	 * @param txCde
	 */
	public void setTxCde(String txCde) {
	 	this.txCde = txCde;
	}
	/**
	 * @return �ӽ��״���
	 */
	public String getSubTxCde() {
	 	return subTxCde;
	}
	/**
	 * @���� �ӽ��״���
	 * @param subTxCde
	 */
	public void setSubTxCde(String subTxCde) {
	 	this.subTxCde = subTxCde;
	}
	/**
	 * @return �������
	 */
	public String getSvcInd() {
	 	return svcInd;
	}
	/**
	 * @���� �������
	 * @param svcInd
	 */
	public void setSvcInd(String svcInd) {
	 	this.svcInd = svcInd;
	}
	/**
	 * @return ����
	 */
	public String getCurNo() {
	 	return curNo;
	}
	/**
	 * @���� ����
	 * @param curNo
	 */
	public void setCurNo(String curNo) {
	 	this.curNo = curNo;
	}
	/**
	 * @return ������
	 */
	public String getPrdtNo() {
	 	return prdtNo;
	}
	/**
	 * @���� ������
	 * @param prdtNo
	 */
	public void setPrdtNo(String prdtNo) {
	 	this.prdtNo = prdtNo;
	}
	/**
	 * @return ��ݺ�
	 */
	public String getLoanNo() {
	 	return loanNo;
	}
	/**
	 * @���� ��ݺ�
	 * @param loanNo
	 */
	public void setLoanNo(String loanNo) {
	 	this.loanNo = loanNo;
	}
	/**
	 * @return ������־
	 */
	public String getAddInd() {
	 	return addInd;
	}
	/**
	 * @���� ������־
	 * @param addInd
	 */
	public void setAddInd(String addInd) {
	 	this.addInd = addInd;
	}
	/**
	 * @return ������
	 */
	public Double getAmt() {
	 	return amt;
	}
	/**
	 * @���� ������
	 * @param amt
	 */
	public void setAmt(Double amt) {
	 	this.amt = amt;
	}
	/**
	 * @return �Ƿ��Ѿ�����ϸ
	 */
	public String getHstInd() {
	 	return hstInd;
	}
	/**
	 * @���� �Ƿ��Ѿ�����ϸ
	 * @param hstInd
	 */
	public void setHstInd(String hstInd) {
	 	this.hstInd = hstInd;
	}
	/**
	 * @return ���˱�־
	 */
	public String getCancelInd() {
	 	return cancelInd;
	}
	/**
	 * @���� ���˱�־
	 * @param cancelInd
	 */
	public void setCancelInd(String cancelInd) {
	 	this.cancelInd = cancelInd;
	}
	/**
	 * @return ��Ա��ˮ��
	 */
	public Integer getEjfno() {
	 	return ejfno;
	}
	/**
	 * @���� ��Ա��ˮ��
	 * @param ejfno
	 */
	public void setEjfno(Integer ejfno) {
	 	this.ejfno = ejfno;
	}
	/**
	 * @return ƽ̨��ˮ��
	 */
	public Integer getPtTraceNo() {
	 	return ptTraceNo;
	}
	/**
	 * @���� ƽ̨��ˮ��
	 * @param ptTraceNo
	 */
	public void setPtTraceNo(Integer ptTraceNo) {
	 	this.ptTraceNo = ptTraceNo;
	}
	/**
	 * @return ժҪ
	 */
	public String getMemo() {
	 	return memo;
	}
	/**
	 * @���� ժҪ
	 * @param memo
	 */
	public void setMemo(String memo) {
	 	this.memo = memo;
	}
	/**
	 * @return ������ˮ��
	 */
	public String getCancelTraceNo() {
	 	return cancelTraceNo;
	}
	/**
	 * @���� ������ˮ��
	 * @param cancelTraceNo
	 */
	public void setCancelTraceNo(String cancelTraceNo) {
	 	this.cancelTraceNo = cancelTraceNo;
	}
	public String getCtInd() {
		return ctInd;
	}
	public void setCtInd(String ctInd) {
		this.ctInd = ctInd;
	}
	public String getPactNo() {
		return pactNo;
	}
	public String getBrNo() {
		return brNo;
	}
	public void setPactNo(String pactNo) {
		this.pactNo = pactNo;
	}
	public void setBrNo(String brNo) {
		this.brNo = brNo;
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
	public String getBrName() {
		return brName;
	}
	public void setBrName(String brName) {
		this.brName = brName;
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
	public String getPrdtName() {
		return prdtName;
	}
	public void setPrdtName(String prdtName) {
		this.prdtName = prdtName;
	}
	public String getCifName() {
		return cifName;
	}
	public void setCifName(String cifName) {
		this.cifName = cifName;
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
}