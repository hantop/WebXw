package app.creditapp.ln.entity;
import app.base.BaseDomain;
/**
* Title: LnApply.java
* Description:
* @version��1.0
**/
public class LnApply extends BaseDomain {
	private String batchNo;//���κ���
	private String appId;//����ID
	private String brNo;//������������
	private String pactNo;//��ͬ���
	private String appDate;//��������
	private String pactXt;//���к�ͬ���
	private String brAccType;//������������[A/B]
	private String cifNo;//�ͻ�����
	private String cifName;//�ͻ�����
	private String projNo;//������Ŀ���
	private String prdtNo;//��Ʒ��
	private String lnType;//��������
	private String curNo;//�������
	private Double appAmt;//������
	private Double pactAmt;//��ͬ���
	private Double lnRate;//���ʣ��£�
	private Double lnRateYear;//���ʣ��꣩
	private Double overRate;//��Ϣ���ʣ��£�
	private Double damRate;//��ǰ����ΥԼ�����
	private String appArea;//����ص�
	private String lnUse;//������;
	private String repayType;//���ʽ
	private Integer termMon;//�������ޣ��£�
	private Integer termDay;//�������ޣ��գ�
	private String vouType;//������ʽ
	private String begDate;//�ſ�����
	private String endDate;//��������
	private String payType;//�ۿ�������
	private String payKind;//�ۿ�����𡢻���Ƶ��
	private Integer payDay;//�ۿ���
	private String feeType;//�ɷѷ�ʽ
	private String payMent;//֧����ʽ[01����02����]
	private Integer vouDays;//���е�������
	private Double feeTotal;//�������ܶ�
	private Double feeRate;//��������
	private Double feeAmt;//������
	private Double srvRate;//�������
	private Double srvAmt;//�����
	private Double vouRate;//��������
	private Double vouAmt;//������
	private Double feeAmt1;//����һ
	private Double feeAmt2;//���ö�
	private Double feeAmt3;//������
	private Double feeAmt4;//������
	private Double feeAmt5;//������
	private String apprType;//��������[01�Զ�]
	private String appSts;//����״̬[01δ����02ͨ��03���04������ͬ]
	private String recSts;//��¼״̬[01����02ɾ��]
	private String opNo;//���йܻ�����Ա
	private String txDate;//��������
	private String upDate;//��������

	private String czPactNo;//������ˮ��
	private String resultId;//�Զ���������Id
	
	public Double getLnRateYear() {
		return lnRateYear;
	}
	public void setLnRateYear(Double lnRateYear) {
		this.lnRateYear = lnRateYear;
	}
	/**
	 * @return ���κ���
	 */
	public String getBatchNo() {
	 	return batchNo;
	}
	/**
	 * @���� ���κ���
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
	 * @return ��������
	 */
	public String getAppDate() {
	 	return appDate;
	}
	/**
	 * @���� ��������
	 * @param appDate
	 */
	public void setAppDate(String appDate) {
	 	this.appDate = appDate;
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
	 * @return ������Ŀ���
	 */
	public String getProjNo() {
	 	return projNo;
	}
	/**
	 * @���� ������Ŀ���
	 * @param projNo
	 */
	public void setProjNo(String projNo) {
	 	this.projNo = projNo;
	}
	/**
	 * @return ��Ʒ��
	 */
	public String getPrdtNo() {
	 	return prdtNo;
	}
	/**
	 * @���� ��Ʒ��
	 * @param prdtNo
	 */
	public void setPrdtNo(String prdtNo) {
	 	this.prdtNo = prdtNo;
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
	 * @return �������
	 */
	public String getCurNo() {
	 	return curNo;
	}
	/**
	 * @���� �������
	 * @param curNo
	 */
	public void setCurNo(String curNo) {
	 	this.curNo = curNo;
	}
	/**
	 * @return ������
	 */
	public Double getAppAmt() {
	 	return appAmt;
	}
	/**
	 * @���� ������
	 * @param appAmt
	 */
	public void setAppAmt(Double appAmt) {
	 	this.appAmt = appAmt;
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
	 * @return ���ʣ��£�
	 */
	public Double getLnRate() {
	 	return lnRate;
	}
	/**
	 * @���� ���ʣ��£�
	 * @param lnRate
	 */
	public void setLnRate(Double lnRate) {
	 	this.lnRate = lnRate;
	}
	/**
	 * @return ��Ϣ���ʣ��£�
	 */
	public Double getOverRate() {
	 	return overRate;
	}
	/**
	 * @���� ��Ϣ���ʣ��£�
	 * @param overRate
	 */
	public void setOverRate(Double overRate) {
	 	this.overRate = overRate;
	}
	/**
	 * @return ��ǰ����ΥԼ�����
	 */
	public Double getDamRate() {
	 	return damRate;
	}
	/**
	 * @���� ��ǰ����ΥԼ�����
	 * @param damRate
	 */
	public void setDamRate(Double damRate) {
	 	this.damRate = damRate;
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
	 * @return �������ޣ��£�
	 */
	public Integer getTermMon() {
	 	return termMon;
	}
	/**
	 * @���� �������ޣ��£�
	 * @param termMon
	 */
	public void setTermMon(Integer termMon) {
	 	this.termMon = termMon;
	}
	/**
	 * @return �������ޣ��գ�
	 */
	public Integer getTermDay() {
	 	return termDay;
	}
	/**
	 * @���� �������ޣ��գ�
	 * @param termDay
	 */
	public void setTermDay(Integer termDay) {
	 	this.termDay = termDay;
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
	 * @return �ſ�����
	 */
	public String getBegDate() {
	 	return begDate;
	}
	/**
	 * @���� �ſ�����
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
	 * @return �ۿ���
	 */
	public Integer getPayDay() {
	 	return payDay;
	}
	/**
	 * @���� �ۿ���
	 * @param payDay
	 */
	public void setPayDay(Integer payDay) {
	 	this.payDay = payDay;
	}
	/**
	 * @return �ɷѷ�ʽ
	 */
	public String getFeeType() {
	 	return feeType;
	}
	/**
	 * @���� �ɷѷ�ʽ
	 * @param feeType
	 */
	public void setFeeType(String feeType) {
	 	this.feeType = feeType;
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
	 * @return ���е�������
	 */
	public Integer getVouDays() {
	 	return vouDays;
	}
	/**
	 * @���� ���е�������
	 * @param vouDays
	 */
	public void setVouDays(Integer vouDays) {
	 	this.vouDays = vouDays;
	}
	/**
	 * @return �������ܶ�
	 */
	public Double getFeeTotal() {
	 	return feeTotal;
	}
	/**
	 * @���� �������ܶ�
	 * @param feeTotal
	 */
	public void setFeeTotal(Double feeTotal) {
	 	this.feeTotal = feeTotal;
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
	 * @return ��������[01�Զ�]
	 */
	public String getApprType() {
	 	return apprType;
	}
	/**
	 * @���� ��������[01�Զ�]
	 * @param apprType
	 */
	public void setApprType(String apprType) {
	 	this.apprType = apprType;
	}
	/**
	 * @return ����״̬[01δ����02ͨ��03���04������ͬ]
	 */
	public String getAppSts() {
	 	return appSts;
	}
	/**
	 * @���� ����״̬[01δ����02ͨ��03���04������ͬ]
	 * @param appSts
	 */
	public void setAppSts(String appSts) {
	 	this.appSts = appSts;
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
	 * @return ��������
	 */
	public String getTxDate() {
	 	return txDate;
	}
	/**
	 * @���� ��������
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
	public String getCzPactNo() {
		return czPactNo;
	}
	public void setCzPactNo(String czPactNo) {
		this.czPactNo = czPactNo;
	}
	public String getResultId() {
		return resultId;
	}
	public void setResultId(String resultId) {
		this.resultId = resultId;
	}
}