package accounting.domain.loan;
import app.base.BaseDomain;
/**
* Title: LnPact.java
* Description:
* @���� su
* @���� 2018-3-20
* @version��1.0
**/
public class LnPact extends accounting.domain.sys.CMISDomain {
	private String pactNo;//��ͬ���
	private String brNo;//����������
	private String batchNo;//���κ�
	private String appId;//����ID
	private String pactId;//��ͬID
	private String pactXt;//���к�ͬ���
	private String brAccType;//������������[A/B]
	private String cifNo;//�ͻ�����
	private String cifName;//�ͻ�����
	private String prdtNo;//��Ʒ���
	private String projNo;//��Ŀ���
	private String lnType;//��������
	private String curNo;//����[CNY-�����]
	private Double pactAmt;//��ͬ���
	private Double putAmt;//���Ž��
	private Double lnRate;//������
	private Double overRate;//��Ϣ����
	private Double damRate;//��ǰ����ΥԼ����
	private String begDate;//��ʼ����
	private String endDate;//��������
	private String termType;//��������
	private Integer termMon;//������
	private Integer termDay;//������
	private String repayType;//���ʽ
	private String vouType;//������ʽ
	private String appArea;//����ص�
	private String lnUse;//������;
	private String payType;//�ۿ�������
	private String payKind;//�ۿ�����𡢻���Ƶ��
	private Integer payDay;//�ۿ�����
	private String payChn;//֧������
	private String payMent;//֧����ʽ[01����02����]
	private String ifCron;//�Ƿ�ʱ
	private String cronTime;//��ʱʱ��
	private String apprType;//��������[01�Զ�02�˹�]
	private String processId;//������ID
	private String apprSts;//����״̬[00��ʼ��01������02ͬ��03���04����05�˻�]
	private String pactSts;//��ͬ״̬[01����02���ſ�03�ѳ���04�ѷſ�]
	private String recSts;//��¼״̬[01����02ɾ��]
	private String opNo;//���йܻ�����Ա
	private String txDate;//�Ǽ�����
	private String txTime;//�Ǽ�ʱ��
	private String upTime;//����ʱ��

	/**
	 * @return ��ͬ���
	 */
	public String getPactNo() {
	 	return pactNo;
	}
	/**
	 * @���� ��ͬ���
	 * @param pactNo
	 */
	public void setPactNo(String pactNo) {
	 	this.pactNo = pactNo;
	}
	/**
	 * @return ����������
	 */
	public String getBrNo() {
	 	return brNo;
	}
	/**
	 * @���� ����������
	 * @param brNo
	 */
	public void setBrNo(String brNo) {
	 	this.brNo = brNo;
	}
	/**
	 * @return ���κ�
	 */
	public String getBatchNo() {
	 	return batchNo;
	}
	/**
	 * @���� ���κ�
	 * @param batchNo
	 */
	public void setBatchNo(String batchNo) {
	 	this.batchNo = batchNo;
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
	 * @return ���к�ͬ���
	 */
	public String getPactXt() {
	 	return pactXt;
	}
	/**
	 * @���� ���к�ͬ���
	 * @param pactXt
	 */
	public void setPactXt(String pactXt) {
	 	this.pactXt = pactXt;
	}
	/**
	 * @return ������������[A/B]
	 */
	public String getBrAccType() {
	 	return brAccType;
	}
	/**
	 * @���� ������������[A/B]
	 * @param brAccType
	 */
	public void setBrAccType(String brAccType) {
	 	this.brAccType = brAccType;
	}
	/**
	 * @return �ͻ�����
	 */
	public String getCifNo() {
	 	return cifNo;
	}
	/**
	 * @���� �ͻ�����
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
	 * @return ��Ʒ���
	 */
	public String getPrdtNo() {
	 	return prdtNo;
	}
	/**
	 * @���� ��Ʒ���
	 * @param prdtNo
	 */
	public void setPrdtNo(String prdtNo) {
	 	this.prdtNo = prdtNo;
	}
	/**
	 * @return ��Ŀ���
	 */
	public String getProjNo() {
	 	return projNo;
	}
	/**
	 * @���� ��Ŀ���
	 * @param projNo
	 */
	public void setProjNo(String projNo) {
	 	this.projNo = projNo;
	}
	/**
	 * @return ��������
	 */
	public String getLnType() {
	 	return lnType;
	}
	/**
	 * @���� ��������
	 * @param lnType
	 */
	public void setLnType(String lnType) {
	 	this.lnType = lnType;
	}
	/**
	 * @return ����[CNY-�����]
	 */
	public String getCurNo() {
	 	return curNo;
	}
	/**
	 * @���� ����[CNY-�����]
	 * @param curNo
	 */
	public void setCurNo(String curNo) {
	 	this.curNo = curNo;
	}
	/**
	 * @return ��ͬ���
	 */
	public Double getPactAmt() {
	 	return pactAmt;
	}
	/**
	 * @���� ��ͬ���
	 * @param pactAmt
	 */
	public void setPactAmt(Double pactAmt) {
	 	this.pactAmt = pactAmt;
	}
	/**
	 * @return ���Ž��
	 */
	public Double getPutAmt() {
	 	return putAmt;
	}
	/**
	 * @���� ���Ž��
	 * @param putAmt
	 */
	public void setPutAmt(Double putAmt) {
	 	this.putAmt = putAmt;
	}
	/**
	 * @return ������
	 */
	public Double getLnRate() {
	 	return lnRate;
	}
	/**
	 * @���� ������
	 * @param lnRate
	 */
	public void setLnRate(Double lnRate) {
	 	this.lnRate = lnRate;
	}
	/**
	 * @return ��Ϣ����
	 */
	public Double getOverRate() {
	 	return overRate;
	}
	/**
	 * @���� ��Ϣ����
	 * @param overRate
	 */
	public void setOverRate(Double overRate) {
	 	this.overRate = overRate;
	}
	/**
	 * @return ��ǰ����ΥԼ����
	 */
	public Double getDamRate() {
	 	return damRate;
	}
	/**
	 * @���� ��ǰ����ΥԼ����
	 * @param damRate
	 */
	public void setDamRate(Double damRate) {
	 	this.damRate = damRate;
	}
	/**
	 * @return ��ʼ����
	 */
	public String getBegDate() {
	 	return begDate;
	}
	/**
	 * @���� ��ʼ����
	 * @param begDate
	 */
	public void setBegDate(String begDate) {
	 	this.begDate = begDate;
	}
	/**
	 * @return ��������
	 */
	public String getEndDate() {
	 	return endDate;
	}
	/**
	 * @���� ��������
	 * @param endDate
	 */
	public void setEndDate(String endDate) {
	 	this.endDate = endDate;
	}
	/**
	 * @return ��������
	 */
	public String getTermType() {
	 	return termType;
	}
	/**
	 * @���� ��������
	 * @param termType
	 */
	public void setTermType(String termType) {
	 	this.termType = termType;
	}
	/**
	 * @return ������
	 */
	public Integer getTermMon() {
	 	return termMon;
	}
	/**
	 * @���� ������
	 * @param termMon
	 */
	public void setTermMon(Integer termMon) {
	 	this.termMon = termMon;
	}
	/**
	 * @return ������
	 */
	public Integer getTermDay() {
	 	return termDay;
	}
	/**
	 * @���� ������
	 * @param termDay
	 */
	public void setTermDay(Integer termDay) {
	 	this.termDay = termDay;
	}
	/**
	 * @return ���ʽ
	 */
	public String getRepayType() {
	 	return repayType;
	}
	/**
	 * @���� ���ʽ
	 * @param repayType
	 */
	public void setRepayType(String repayType) {
	 	this.repayType = repayType;
	}
	/**
	 * @return ������ʽ
	 */
	public String getVouType() {
	 	return vouType;
	}
	/**
	 * @���� ������ʽ
	 * @param vouType
	 */
	public void setVouType(String vouType) {
	 	this.vouType = vouType;
	}
	/**
	 * @return ����ص�
	 */
	public String getAppArea() {
	 	return appArea;
	}
	/**
	 * @���� ����ص�
	 * @param appArea
	 */
	public void setAppArea(String appArea) {
	 	this.appArea = appArea;
	}
	/**
	 * @return ������;
	 */
	public String getLnUse() {
	 	return lnUse;
	}
	/**
	 * @���� ������;
	 * @param lnUse
	 */
	public void setLnUse(String lnUse) {
	 	this.lnUse = lnUse;
	}
	/**
	 * @return �ۿ�������
	 */
	public String getPayType() {
	 	return payType;
	}
	/**
	 * @���� �ۿ�������
	 * @param payType
	 */
	public void setPayType(String payType) {
	 	this.payType = payType;
	}
	/**
	 * @return �ۿ�����𡢻���Ƶ��
	 */
	public String getPayKind() {
	 	return payKind;
	}
	/**
	 * @���� �ۿ�����𡢻���Ƶ��
	 * @param payKind
	 */
	public void setPayKind(String payKind) {
	 	this.payKind = payKind;
	}
	/**
	 * @return �ۿ�����
	 */
	public Integer getPayDay() {
	 	return payDay;
	}
	/**
	 * @���� �ۿ�����
	 * @param payDay
	 */
	public void setPayDay(Integer payDay) {
	 	this.payDay = payDay;
	}
	/**
	 * @return ֧������
	 */
	public String getPayChn() {
	 	return payChn;
	}
	/**
	 * @���� ֧������
	 * @param payChn
	 */
	public void setPayChn(String payChn) {
	 	this.payChn = payChn;
	}
	/**
	 * @return ֧����ʽ[01����02����]
	 */
	public String getPayMent() {
	 	return payMent;
	}
	/**
	 * @���� ֧����ʽ[01����02����]
	 * @param payMent
	 */
	public void setPayMent(String payMent) {
	 	this.payMent = payMent;
	}
	/**
	 * @return �Ƿ�ʱ
	 */
	public String getIfCron() {
	 	return ifCron;
	}
	/**
	 * @���� �Ƿ�ʱ
	 * @param ifCron
	 */
	public void setIfCron(String ifCron) {
	 	this.ifCron = ifCron;
	}
	/**
	 * @return ��ʱʱ��
	 */
	public String getCronTime() {
	 	return cronTime;
	}
	/**
	 * @���� ��ʱʱ��
	 * @param cronTime
	 */
	public void setCronTime(String cronTime) {
	 	this.cronTime = cronTime;
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
	 * @return ������ID
	 */
	public String getProcessId() {
	 	return processId;
	}
	/**
	 * @���� ������ID
	 * @param processId
	 */
	public void setProcessId(String processId) {
	 	this.processId = processId;
	}
	/**
	 * @return ����״̬[00��ʼ��01������02ͬ��03���04����05�˻�]
	 */
	public String getApprSts() {
	 	return apprSts;
	}
	/**
	 * @���� ����״̬[00��ʼ��01������02ͬ��03���04����05�˻�]
	 * @param apprSts
	 */
	public void setApprSts(String apprSts) {
	 	this.apprSts = apprSts;
	}
	/**
	 * @return ��ͬ״̬[01����02���ſ�03�ѳ���04�ѷſ�]
	 */
	public String getPactSts() {
	 	return pactSts;
	}
	/**
	 * @���� ��ͬ״̬[01����02���ſ�03�ѳ���04�ѷſ�]
	 * @param pactSts
	 */
	public void setPactSts(String pactSts) {
	 	this.pactSts = pactSts;
	}
	/**
	 * @return ��¼״̬[01����02ɾ��]
	 */
	public String getRecSts() {
	 	return recSts;
	}
	/**
	 * @���� ��¼״̬[01����02ɾ��]
	 * @param recSts
	 */
	public void setRecSts(String recSts) {
	 	this.recSts = recSts;
	}
	/**
	 * @return ���йܻ�����Ա
	 */
	public String getOpNo() {
	 	return opNo;
	}
	/**
	 * @���� ���йܻ�����Ա
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
	 * @return �Ǽ�ʱ��
	 */
	public String getTxTime() {
	 	return txTime;
	}
	/**
	 * @���� �Ǽ�ʱ��
	 * @param txTime
	 */
	public void setTxTime(String txTime) {
	 	this.txTime = txTime;
	}
	/**
	 * @return ����ʱ��
	 */
	public String getUpTime() {
	 	return upTime;
	}
	/**
	 * @���� ����ʱ��
	 * @param upTime
	 */
	public void setUpTime(String upTime) {
	 	this.upTime = upTime;
	}

}