package app.creditapp.ln.entity;
import app.base.BaseDomain;
/**
* Title: LnDue.java
* Description:
* @version��1.0
**/
public class LnDue extends BaseDomain {
	private String upTime;//����ʱ��
	private String txTime;//�Ǽ�ʱ��
	private String txDate;//�Ǽ�����
	private String opNo;//���йܻ�����Ա
	private String recSts;//��¼״̬[01����02ɾ��]
	private String dueSts;//���״̬[01δ����02����03����04����05����07����08�ع�]
	private String apprSts;//�������[00������01ͨ��02���03����]
	private String fiveSts;//�弶����״̬
	private String fiveDate;//�弶��������
	private Double feeAmt5;//������
	private Double feeAmt4;//������
	private Double feeAmt3;//������
	private Double feeAmt2;//���ö�
	private Double feeAmt1;//����һ
	private Double vouAmt;//������
	private Double vouRate;//��������
	private Double srvAmt;//�����
	private Double srvRate;//�������
	private Double feeAmt;//������
	private Double feeRate;//��������
	private String payMent;//֧����ʽ[01����02����]
	private String payChn;//֧������
	private String payDay;//�ۿ�����
	private String payKind;//�ۿ�����𡢻���Ƶ��
	private String payType;//�ۿ�������
	private String vouType;//������ʽ
	private Integer repayCycle;//��������
	private String repayType;//���ʽ
	private Integer termDay;//������
	private Integer termMon;//������
	private String termType;//��������
	private String endDate;//������գ���չ�ڣ�
	private String mtrDate;//ԭ��������
	private String begDate;//��ʼ����
	private Double damRate;//��ǰ����ΥԼ����
	private Double overRate;//��Ϣ����
	private Double lnRate;//������
	private Double lnRateYear;//������
	private Double bal;//�������
	private Double dueAmt;//��ݽ��
	private String curNo;//����[CNY-�����]
	private String lnType;//��������
	private String fundNo;//�ʽ���
	private String projNo;//��Ŀ���
	private String prdtNo;//�Ŵ��Ʒ��
	private String cifName;//�ͻ�����
	private String cifNo;//�ͻ�����
	private String brAccType;//������������[A/B]
	private String pactXt;//���к�ͬ���
	private String pactNo;//��ͬ���
	private String brNo;//����������
	private String batchNo;//���κ�
	private String appId;//����ID
	private String pactId;//��ͬID
	private String dueNo;//��ݺ�
	
	private String loginid;//����Ա��
	private String projName;//��Ŀ����
	private String brName;//������������
	private String prdtName;//��Ʒ����
	private Double normInt;//ǷϢ 
	private String tranSts;//ת��״̬
	private String tranDate;//ת������
	private String poolId;//�ʲ��ر��
	
	private String chkFlag;//�طñ�־��ʹ�ú���FUN_GETAFTSPOT��brno��pactno��ȡ��
	
	private Double pactAmt;//
	
	
	
	public Double getLnRateYear() {
		return lnRateYear;
	}
	public void setLnRateYear(Double lnRateYear) {
		this.lnRateYear = lnRateYear;
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
	 * @return ���״̬[01δ����02����03����04����05����07����08�ع�]
	 */
	public String getDueSts() {
	 	return dueSts;
	}
	/**
	 * @���� ���״̬[01δ����02����03����04����05����07����08�ع�]
	 * @param dueSts
	 */
	public void setDueSts(String dueSts) {
	 	this.dueSts = dueSts;
	}
	/**
	 * @return �������[00������01ͨ��02���03����]
	 */
	public String getApprSts() {
	 	return apprSts;
	}
	/**
	 * @���� �������[00������01ͨ��02���03����]
	 * @param apprSts
	 */
	public void setApprSts(String apprSts) {
	 	this.apprSts = apprSts;
	}
	/**
	 * @return �弶����״̬
	 */
	public String getFiveSts() {
	 	return fiveSts;
	}
	/**
	 * @���� �弶����״̬
	 * @param fiveSts
	 */
	public void setFiveSts(String fiveSts) {
	 	this.fiveSts = fiveSts;
	}
	/**
	 * @return �弶��������
	 */
	public String getFiveDate() {
	 	return fiveDate;
	}
	/**
	 * @���� �弶��������
	 * @param fiveDate
	 */
	public void setFiveDate(String fiveDate) {
	 	this.fiveDate = fiveDate;
	}
	/**
	 * @return ������
	 */
	public Double getFeeAmt5() {
	 	return feeAmt5;
	}
	/**
	 * @���� ������
	 * @param feeAmt5
	 */
	public void setFeeAmt5(Double feeAmt5) {
	 	this.feeAmt5 = feeAmt5;
	}
	/**
	 * @return ������
	 */
	public Double getFeeAmt4() {
	 	return feeAmt4;
	}
	/**
	 * @���� ������
	 * @param feeAmt4
	 */
	public void setFeeAmt4(Double feeAmt4) {
	 	this.feeAmt4 = feeAmt4;
	}
	/**
	 * @return ������
	 */
	public Double getFeeAmt3() {
	 	return feeAmt3;
	}
	/**
	 * @���� ������
	 * @param feeAmt3
	 */
	public void setFeeAmt3(Double feeAmt3) {
	 	this.feeAmt3 = feeAmt3;
	}
	/**
	 * @return ���ö�
	 */
	public Double getFeeAmt2() {
	 	return feeAmt2;
	}
	/**
	 * @���� ���ö�
	 * @param feeAmt2
	 */
	public void setFeeAmt2(Double feeAmt2) {
	 	this.feeAmt2 = feeAmt2;
	}
	/**
	 * @return ����һ
	 */
	public Double getFeeAmt1() {
	 	return feeAmt1;
	}
	/**
	 * @���� ����һ
	 * @param feeAmt1
	 */
	public void setFeeAmt1(Double feeAmt1) {
	 	this.feeAmt1 = feeAmt1;
	}
	/**
	 * @return ������
	 */
	public Double getVouAmt() {
	 	return vouAmt;
	}
	/**
	 * @���� ������
	 * @param vouAmt
	 */
	public void setVouAmt(Double vouAmt) {
	 	this.vouAmt = vouAmt;
	}
	/**
	 * @return ��������
	 */
	public Double getVouRate() {
	 	return vouRate;
	}
	/**
	 * @���� ��������
	 * @param vouRate
	 */
	public void setVouRate(Double vouRate) {
	 	this.vouRate = vouRate;
	}
	/**
	 * @return �����
	 */
	public Double getSrvAmt() {
	 	return srvAmt;
	}
	/**
	 * @���� �����
	 * @param srvAmt
	 */
	public void setSrvAmt(Double srvAmt) {
	 	this.srvAmt = srvAmt;
	}
	/**
	 * @return �������
	 */
	public Double getSrvRate() {
	 	return srvRate;
	}
	/**
	 * @���� �������
	 * @param srvRate
	 */
	public void setSrvRate(Double srvRate) {
	 	this.srvRate = srvRate;
	}
	/**
	 * @return ������
	 */
	public Double getFeeAmt() {
	 	return feeAmt;
	}
	/**
	 * @���� ������
	 * @param feeAmt
	 */
	public void setFeeAmt(Double feeAmt) {
	 	this.feeAmt = feeAmt;
	}
	/**
	 * @return ��������
	 */
	public Double getFeeRate() {
	 	return feeRate;
	}
	/**
	 * @���� ��������
	 * @param feeRate
	 */
	public void setFeeRate(Double feeRate) {
	 	this.feeRate = feeRate;
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
	 * @return �ۿ�����
	 */
	public String getPayDay() {
	 	return payDay;
	}
	/**
	 * @���� �ۿ�����
	 * @param payDay
	 */
	public void setPayDay(String payDay) {
	 	this.payDay = payDay;
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
	 * @return ��������
	 */
	public Integer getRepayCycle() {
	 	return repayCycle;
	}
	/**
	 * @���� ��������
	 * @param repayCycle
	 */
	public void setRepayCycle(Integer repayCycle) {
	 	this.repayCycle = repayCycle;
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
	 * @return ������գ���չ�ڣ�
	 */
	public String getEndDate() {
	 	return endDate;
	}
	/**
	 * @���� ������գ���չ�ڣ�
	 * @param endDate
	 */
	public void setEndDate(String endDate) {
	 	this.endDate = endDate;
	}
	/**
	 * @return ԭ��������
	 */
	public String getMtrDate() {
	 	return mtrDate;
	}
	/**
	 * @���� ԭ��������
	 * @param mtrDate
	 */
	public void setMtrDate(String mtrDate) {
	 	this.mtrDate = mtrDate;
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
	 * @return �������
	 */
	public Double getBal() {
	 	return bal;
	}
	/**
	 * @���� �������
	 * @param bal
	 */
	public void setBal(Double bal) {
	 	this.bal = bal;
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
	 * @return �ʽ���
	 */
	public String getFundNo() {
	 	return fundNo;
	}
	/**
	 * @���� �ʽ���
	 * @param fundNo
	 */
	public void setFundNo(String fundNo) {
	 	this.fundNo = fundNo;
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
	 * @return �Ŵ��Ʒ��
	 */
	public String getPrdtNo() {
	 	return prdtNo;
	}
	/**
	 * @���� �Ŵ��Ʒ��
	 * @param prdtNo
	 */
	public void setPrdtNo(String prdtNo) {
	 	this.prdtNo = prdtNo;
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
	 * @return ��ݺ�
	 */
	public String getDueNo() {
	 	return dueNo;
	}
	/**
	 * @���� ��ݺ�
	 * @param dueNo
	 */
	public void setDueNo(String dueNo) {
	 	this.dueNo = dueNo;
	}
	public String getLoginid() {
		return loginid;
	}
	public void setLoginid(String loginid) {
		this.loginid = loginid;
	}
	public void setNormInt(Double normInt) {
		this.normInt = normInt;
	}
	public Double getNormInt() {
		return normInt;
	}
	public String getProjName() {
		return projName;
	}
	public void setProjName(String projName) {
		this.projName = projName;
	}
	public String getBrName() {
		return brName;
	}
	public void setBrName(String brName) {
		this.brName = brName;
	}
	public String getPrdtName() {
		return prdtName;
	}
	public void setPrdtName(String prdtName) {
		this.prdtName = prdtName;
	}
	public Double getPactAmt() {
		return pactAmt;
	}
	public void setPactAmt(Double pactAmt) {
		this.pactAmt = pactAmt;
	}
	public String getTranSts() {
		return tranSts;
	}
	public void setTranSts(String tranSts) {
		this.tranSts = tranSts;
	}
	public String getTranDate() {
		return tranDate;
	}
	public void setTranDate(String tranDate) {
		this.tranDate = tranDate;
	}
	public String getPoolId() {
		return poolId;
	}
	public void setPoolId(String poolId) {
		this.poolId = poolId;
	}
	/**
	 * @return the chkFlag
	 */
	public String getChkFlag() {
		return chkFlag;
	}
	/**
	 * @param chkFlag the chkFlag to set
	 */
	public void setChkFlag(String chkFlag) {
		this.chkFlag = chkFlag;
	}
	
	
}