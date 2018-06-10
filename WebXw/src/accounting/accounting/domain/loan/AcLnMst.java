package accounting.domain.loan;
import app.base.BaseDomain;
/**
* Title: AcLnMst.java
* Description:
* @���� su
* @���� 2018-3-20
* @version��1.0
**/
public class AcLnMst extends accounting.domain.sys.CMISDomain {
	private String loanNo;//��ݺ�
	private String deductDay;//�Զ����ձ�������
	private Double deductMinAmt;//�Զ�������СǷϢ���
	private Double ttlPrvdAmt;//�ۼƷ��Ž��
	private Integer calTtlInstm;//ʵ�ʼ�������
	private String overIntstTyp;//���ڽ�Ϣ��ʽ
	private Double indpnAmt;//�������
	private Double trustAmt;//���н��
	private Double trustAmtTrans;//���н��֧�������ۼ�
	private String oldLoanNo;//ԭ��ݺţ����»��ɣ�
	private Double delqPrcpAmt;//��Ƿ����
	private String pactNo;//��ͬ��
	private String brNo;//������
	private String batchNo;//���κ�
	private String prdtNo;//�����Ʒ���
	private String projNo;//��Ŀ���
	private String brAccType;//������������[A/B]
	private String cifNo;//�ͻ���
	private String cifName;//�ͻ�����
	private String loanTyp;//��������
	private String assureMeans;//������ʽ
	private Integer loanTerm;//��������
	private String opnDt;//��������
	private String mtrDt;//��������
	private String termTyp;//��������
	private Integer termMon;//term_mon
	private Integer termDay;//term_day
	private String curNo;//����
	private Double loanAmt;//�����޶�
	private Double loanBal;//���
	private Double lnRate;//������
	private Double lnRateYear;//������
	private Double overRate;//��������
	private String icDt;//��Ϣ����
	private String repayDay;//������
	private String expInd;//չ�ڿ��Ʊ�־
	private Double expRate;//չ������
	private String expMtrDt;//չ�ڵ�����
	private String graceTyp;//����������
	private Integer graceDay;//��������(��)
	private String delqInd;//��Ƿ��ʶ
	private String devaInd;//��ֵ��ʶ
	private String dealSts;//�����־
	private String failCaus;//ʧ��ԭ��
	private String loanSts;//����״̬
	private String intToStpInd;//ͣ��Ϣ��־
	private String fiveSts;//�弶����״̬
	private String lastSetlDt;//��һ�οۿ���
	private String curDueDt;//��ǰ�黹����
	private String nextDueDt;//��һ�λ�����
	private String lstIntDt;//������Ϣ����
	private Integer hstCnt;//��ϸ����
	private String lstDt;//�ϱʷ�������
	private Double ysBal;//�������
	private Double hstBal;//��ϸ���
	private String mac;//��Ѻ
	private String sailFlag;//sail_flag
	private String sailDt;//�����־
	private Double zfBal;//zf_bal
	private Double deductBegAmt;//�Զ����ձ��������
	private String upDt;//��������
	private String premRate;//���ѷ���
	
	public Double getLnRateYear() {
		return lnRateYear;
	}
	public void setLnRateYear(Double lnRateYear) {
		this.lnRateYear = lnRateYear;
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
	 * @return �Զ����ձ�������
	 */
	public String getDeductDay() {
	 	return deductDay;
	}
	/**
	 * @���� �Զ����ձ�������
	 * @param deductDay
	 */
	public void setDeductDay(String deductDay) {
	 	this.deductDay = deductDay;
	}
	/**
	 * @return �Զ�������СǷϢ���
	 */
	public Double getDeductMinAmt() {
	 	return deductMinAmt;
	}
	/**
	 * @���� �Զ�������СǷϢ���
	 * @param deductMinAmt
	 */
	public void setDeductMinAmt(Double deductMinAmt) {
	 	this.deductMinAmt = deductMinAmt;
	}
	/**
	 * @return �ۼƷ��Ž��
	 */
	public Double getTtlPrvdAmt() {
	 	return ttlPrvdAmt;
	}
	/**
	 * @���� �ۼƷ��Ž��
	 * @param ttlPrvdAmt
	 */
	public void setTtlPrvdAmt(Double ttlPrvdAmt) {
	 	this.ttlPrvdAmt = ttlPrvdAmt;
	}
	/**
	 * @return ʵ�ʼ�������
	 */
	public Integer getCalTtlInstm() {
	 	return calTtlInstm;
	}
	/**
	 * @���� ʵ�ʼ�������
	 * @param calTtlInstm
	 */
	public void setCalTtlInstm(Integer calTtlInstm) {
	 	this.calTtlInstm = calTtlInstm;
	}
	/**
	 * @return ���ڽ�Ϣ��ʽ
	 */
	public String getOverIntstTyp() {
	 	return overIntstTyp;
	}
	/**
	 * @���� ���ڽ�Ϣ��ʽ
	 * @param overIntstTyp
	 */
	public void setOverIntstTyp(String overIntstTyp) {
	 	this.overIntstTyp = overIntstTyp;
	}
	/**
	 * @return �������
	 */
	public Double getIndpnAmt() {
	 	return indpnAmt;
	}
	/**
	 * @���� �������
	 * @param indpnAmt
	 */
	public void setIndpnAmt(Double indpnAmt) {
	 	this.indpnAmt = indpnAmt;
	}
	/**
	 * @return ���н��
	 */
	public Double getTrustAmt() {
	 	return trustAmt;
	}
	/**
	 * @���� ���н��
	 * @param trustAmt
	 */
	public void setTrustAmt(Double trustAmt) {
	 	this.trustAmt = trustAmt;
	}
	/**
	 * @return ���н��֧�������ۼ�
	 */
	public Double getTrustAmtTrans() {
	 	return trustAmtTrans;
	}
	/**
	 * @���� ���н��֧�������ۼ�
	 * @param trustAmtTrans
	 */
	public void setTrustAmtTrans(Double trustAmtTrans) {
	 	this.trustAmtTrans = trustAmtTrans;
	}
	/**
	 * @return ԭ��ݺţ����»��ɣ�
	 */
	public String getOldLoanNo() {
	 	return oldLoanNo;
	}
	/**
	 * @���� ԭ��ݺţ����»��ɣ�
	 * @param oldLoanNo
	 */
	public void setOldLoanNo(String oldLoanNo) {
	 	this.oldLoanNo = oldLoanNo;
	}
	/**
	 * @return ��Ƿ����
	 */
	public Double getDelqPrcpAmt() {
	 	return delqPrcpAmt;
	}
	/**
	 * @���� ��Ƿ����
	 * @param delqPrcpAmt
	 */
	public void setDelqPrcpAmt(Double delqPrcpAmt) {
	 	this.delqPrcpAmt = delqPrcpAmt;
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
	 * @return �����Ʒ���
	 */
	public String getPrdtNo() {
	 	return prdtNo;
	}
	/**
	 * @���� �����Ʒ���
	 * @param prdtNo
	 */
	public void setPrdtNo(String prdtNo) {
	 	this.prdtNo = prdtNo;
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
	 * @return ��������
	 */
	public String getLoanTyp() {
	 	return loanTyp;
	}
	/**
	 * @���� ��������
	 * @param loanTyp
	 */
	public void setLoanTyp(String loanTyp) {
	 	this.loanTyp = loanTyp;
	}
	/**
	 * @return ������ʽ
	 */
	public String getAssureMeans() {
	 	return assureMeans;
	}
	/**
	 * @���� ������ʽ
	 * @param assureMeans
	 */
	public void setAssureMeans(String assureMeans) {
	 	this.assureMeans = assureMeans;
	}
	/**
	 * @return ��������
	 */
	public Integer getLoanTerm() {
	 	return loanTerm;
	}
	/**
	 * @���� ��������
	 * @param loanTerm
	 */
	public void setLoanTerm(Integer loanTerm) {
	 	this.loanTerm = loanTerm;
	}
	/**
	 * @return ��������
	 */
	public String getOpnDt() {
	 	return opnDt;
	}
	/**
	 * @���� ��������
	 * @param opnDt
	 */
	public void setOpnDt(String opnDt) {
	 	this.opnDt = opnDt;
	}
	/**
	 * @return ��������
	 */
	public String getMtrDt() {
	 	return mtrDt;
	}
	/**
	 * @���� ��������
	 * @param mtrDt
	 */
	public void setMtrDt(String mtrDt) {
	 	this.mtrDt = mtrDt;
	}
	/**
	 * @return ��������
	 */
	public String getTermTyp() {
	 	return termTyp;
	}
	/**
	 * @���� ��������
	 * @param termTyp
	 */
	public void setTermTyp(String termTyp) {
	 	this.termTyp = termTyp;
	}
	/**
	 * @return term_mon
	 */
	public Integer getTermMon() {
	 	return termMon;
	}
	/**
	 * @���� term_mon
	 * @param termMon
	 */
	public void setTermMon(Integer termMon) {
	 	this.termMon = termMon;
	}
	/**
	 * @return term_day
	 */
	public Integer getTermDay() {
	 	return termDay;
	}
	/**
	 * @���� term_day
	 * @param termDay
	 */
	public void setTermDay(Integer termDay) {
	 	this.termDay = termDay;
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
	 * @return �����޶�
	 */
	public Double getLoanAmt() {
	 	return loanAmt;
	}
	/**
	 * @���� �����޶�
	 * @param loanAmt
	 */
	public void setLoanAmt(Double loanAmt) {
	 	this.loanAmt = loanAmt;
	}
	/**
	 * @return ���
	 */
	public Double getLoanBal() {
	 	return loanBal;
	}
	/**
	 * @���� ���
	 * @param loanBal
	 */
	public void setLoanBal(Double loanBal) {
	 	this.loanBal = loanBal;
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
	 * @return ��������
	 */
	public Double getOverRate() {
	 	return overRate;
	}
	/**
	 * @���� ��������
	 * @param overRate
	 */
	public void setOverRate(Double overRate) {
	 	this.overRate = overRate;
	}
	/**
	 * @return ��Ϣ����
	 */
	public String getIcDt() {
	 	return icDt;
	}
	/**
	 * @���� ��Ϣ����
	 * @param icDt
	 */
	public void setIcDt(String icDt) {
	 	this.icDt = icDt;
	}
	/**
	 * @return ������
	 */
	public String getRepayDay() {
	 	return repayDay;
	}
	/**
	 * @���� ������
	 * @param repayDay
	 */
	public void setRepayDay(String repayDay) {
	 	this.repayDay = repayDay;
	}
	/**
	 * @return չ�ڿ��Ʊ�־
	 */
	public String getExpInd() {
	 	return expInd;
	}
	/**
	 * @���� չ�ڿ��Ʊ�־
	 * @param expInd
	 */
	public void setExpInd(String expInd) {
	 	this.expInd = expInd;
	}
	/**
	 * @return չ������
	 */
	public Double getExpRate() {
	 	return expRate;
	}
	/**
	 * @���� չ������
	 * @param expRate
	 */
	public void setExpRate(Double expRate) {
	 	this.expRate = expRate;
	}
	/**
	 * @return չ�ڵ�����
	 */
	public String getExpMtrDt() {
	 	return expMtrDt;
	}
	/**
	 * @���� չ�ڵ�����
	 * @param expMtrDt
	 */
	public void setExpMtrDt(String expMtrDt) {
	 	this.expMtrDt = expMtrDt;
	}
	/**
	 * @return ����������
	 */
	public String getGraceTyp() {
	 	return graceTyp;
	}
	/**
	 * @���� ����������
	 * @param graceTyp
	 */
	public void setGraceTyp(String graceTyp) {
	 	this.graceTyp = graceTyp;
	}
	/**
	 * @return ��������(��)
	 */
	public Integer getGraceDay() {
	 	return graceDay;
	}
	/**
	 * @���� ��������(��)
	 * @param graceDay
	 */
	public void setGraceDay(Integer graceDay) {
	 	this.graceDay = graceDay;
	}
	/**
	 * @return ��Ƿ��ʶ
	 */
	public String getDelqInd() {
	 	return delqInd;
	}
	/**
	 * @���� ��Ƿ��ʶ
	 * @param delqInd
	 */
	public void setDelqInd(String delqInd) {
	 	this.delqInd = delqInd;
	}
	/**
	 * @return ��ֵ��ʶ
	 */
	public String getDevaInd() {
	 	return devaInd;
	}
	/**
	 * @���� ��ֵ��ʶ
	 * @param devaInd
	 */
	public void setDevaInd(String devaInd) {
	 	this.devaInd = devaInd;
	}
	/**
	 * @return ����״̬
	 */
	public String getLoanSts() {
	 	return loanSts;
	}
	/**
	 * @���� ����״̬
	 * @param loanSts
	 */
	public void setLoanSts(String loanSts) {
	 	this.loanSts = loanSts;
	}
	/**
	 * @return ͣ��Ϣ��־
	 */
	public String getIntToStpInd() {
	 	return intToStpInd;
	}
	/**
	 * @���� ͣ��Ϣ��־
	 * @param intToStpInd
	 */
	public void setIntToStpInd(String intToStpInd) {
	 	this.intToStpInd = intToStpInd;
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
	 * @return ��һ�οۿ���
	 */
	public String getLastSetlDt() {
	 	return lastSetlDt;
	}
	/**
	 * @���� ��һ�οۿ���
	 * @param lastSetlDt
	 */
	public void setLastSetlDt(String lastSetlDt) {
	 	this.lastSetlDt = lastSetlDt;
	}
	/**
	 * @return ��ǰ�黹����
	 */
	public String getCurDueDt() {
	 	return curDueDt;
	}
	/**
	 * @���� ��ǰ�黹����
	 * @param curDueDt
	 */
	public void setCurDueDt(String curDueDt) {
	 	this.curDueDt = curDueDt;
	}
	/**
	 * @return ��һ�λ�����
	 */
	public String getNextDueDt() {
	 	return nextDueDt;
	}
	/**
	 * @���� ��һ�λ�����
	 * @param nextDueDt
	 */
	public void setNextDueDt(String nextDueDt) {
	 	this.nextDueDt = nextDueDt;
	}
	/**
	 * @return ������Ϣ����
	 */
	public String getLstIntDt() {
	 	return lstIntDt;
	}
	/**
	 * @���� ������Ϣ����
	 * @param lstIntDt
	 */
	public void setLstIntDt(String lstIntDt) {
	 	this.lstIntDt = lstIntDt;
	}
	/**
	 * @return ��ϸ����
	 */
	public Integer getHstCnt() {
	 	return hstCnt;
	}
	/**
	 * @���� ��ϸ����
	 * @param hstCnt
	 */
	public void setHstCnt(Integer hstCnt) {
	 	this.hstCnt = hstCnt;
	}
	/**
	 * @return �ϱʷ�������
	 */
	public String getLstDt() {
	 	return lstDt;
	}
	/**
	 * @���� �ϱʷ�������
	 * @param lstDt
	 */
	public void setLstDt(String lstDt) {
	 	this.lstDt = lstDt;
	}
	/**
	 * @return �������
	 */
	public Double getYsBal() {
	 	return ysBal;
	}
	/**
	 * @���� �������
	 * @param ysBal
	 */
	public void setYsBal(Double ysBal) {
	 	this.ysBal = ysBal;
	}
	/**
	 * @return ��ϸ���
	 */
	public Double getHstBal() {
	 	return hstBal;
	}
	/**
	 * @���� ��ϸ���
	 * @param hstBal
	 */
	public void setHstBal(Double hstBal) {
	 	this.hstBal = hstBal;
	}
	/**
	 * @return ��Ѻ
	 */
	public String getMac() {
	 	return mac;
	}
	/**
	 * @���� ��Ѻ
	 * @param mac
	 */
	public void setMac(String mac) {
	 	this.mac = mac;
	}
	/**
	 * @return sail_flag
	 */
	public String getSailFlag() {
	 	return sailFlag;
	}
	/**
	 * @���� sail_flag
	 * @param sailFlag
	 */
	public void setSailFlag(String sailFlag) {
	 	this.sailFlag = sailFlag;
	}
	/**
	 * @return sail_dt
	 */
	public String getSailDt() {
	 	return sailDt;
	}
	/**
	 * @���� sail_dt
	 * @param sailDt
	 */
	public void setSailDt(String sailDt) {
	 	this.sailDt = sailDt;
	}
	/**
	 * @return zf_bal
	 */
	public Double getZfBal() {
	 	return zfBal;
	}
	/**
	 * @���� zf_bal
	 * @param zfBal
	 */
	public void setZfBal(Double zfBal) {
	 	this.zfBal = zfBal;
	}
	/**
	 * @return �Զ����ձ��������
	 */
	public Double getDeductBegAmt() {
	 	return deductBegAmt;
	}
	/**
	 * @���� �Զ����ձ��������
	 * @param deductBegAmt
	 */
	public void setDeductBegAmt(Double deductBegAmt) {
	 	this.deductBegAmt = deductBegAmt;
	}
	public String getDealSts() {
		return dealSts;
	}
	public void setDealSts(String dealSts) {
		this.dealSts = dealSts;
	}
	public String getUpDt() {
		return upDt;
	}
	public void setUpDt(String upDt) {
		this.upDt = upDt;
	}
	public String getProjNo() {
		return projNo;
	}
	public void setProjNo(String projNo) {
		this.projNo = projNo;
	}
	public String getFailCaus() {
		return failCaus;
	}
	public void setFailCaus(String failCaus) {
		this.failCaus = failCaus;
	}
	public String getPremRate() {
		return premRate;
	}
	public void setPremRate(String premRate) {
		this.premRate = premRate;
	}
	
}