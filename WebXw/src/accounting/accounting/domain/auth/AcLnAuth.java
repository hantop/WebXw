package accounting.domain.auth;
/**
* Title: AcLnAuth.java
* Description:
* @���� su
* @���� 2018-4-25
* @version��1.0
**/
public class AcLnAuth extends AcAuth implements java.io.Serializable {
	private double indpnAmt;                //�������
	private double trustAmt;                //���н��
	private String sbsyInd;                 //��Ϣ�����־
	private String authNo;                  //��Ȩ���
	private String prdtNoCrd;               //�Ŵ���Ʒ���
	private String loanTyp;                 //��������
	private String contNo;              	//��ͬ��
	private String loanNo;                  //��ݺ�
	private String cifNo;                   //�ͻ���
	private String cifName;                 //�ͻ�����
	private int    loanTerm;                //��������
	private int    loanTermDay;             //��������
	private String begDt;                   //��ʼ����
	private String endDt;                   //��������
	private String curNo;                   //����
	private double loanAmt;                 //������
	private String rateNo;                  //���ʱ��
	private double rateFlt;                 //���ʸ�������
	private double rate;                    //��ͬ����
	private double overRateFlt;             //�������ʸ�������
	private double overRate;                //��������
	private double fineRateFlt;             //��Ϣ���ʸ�������
	private double fineRate;                //��Ϣ����
	private double cmpdRate;                //��������
	private double actRate;                 //ʵ������
	private String assureMeans;             //��Ҫ������ʽ
	private String repayTermTyp;            //������������
	private int    repayTerm;               //��������
	private String rateMode;                //����ģʽ
	private String rateAdjTyp;              //���ʵ�����ʽ
	private String disbAcNo;                //����˺�
	
	private String repayTyp;                //���ʽ
	private String repayDayMode;            //�����շ�ʽ
	private String repayDay;                //ָ��������
	private String trustNo;                 //ί��Э����
	private String repayAdvOpt;             //��ǰ����ѡ��
	private double feeAmt;                  //������
	private String multRepayInd;            //��׶λ��ʽ��ʶ
	private int    pgsBegCnt;                  //�����ݼ���ʼ����
	private int    pgsPrcpFreq;             //�����ݼ��������
	private double pgsPrcpAmt;              //�����ݼ����
	private double pgsPrcpPct;              //�����ݼ�����
	private int    calTtlInstm;             //ʵ�ʼ�������
	private int    plnAdjPerd ;				//����ƻ������ʼ����
	private String setlMode;				//��ǰ���ʽ
	
	private String repayAcNoFst;               	//��һ�����˺�
	private String repayAcNoSnd;			  	//�ڶ������˺�
	private String bailAcNo;					//��֤���˺�
	private Double bailAmt;						//��֤����
	private Double bailBal;						//��֤�����
	private String depositAcNo;					//ָ������˺�(���ı�)
	private Double depositAmt;					//ָ������˺����
	private Double normRateFlt;					//ԭ�������ʸ�����
	private String oldLoanNo;					//ԭ��ݺţ����»��ɣ�
	
	//20151123�����ֶ�
	private String rateKind;					//��������
	private String preferRateInd;				//�Ż����ʱ�־�����ı���
	private String yLoanBail;					//�Ƿ��Զ���֤���˻��ۿ� 1-�� 0-��
	private String fltType;						//������ʽ  1-������ 0-������
	private double rateFltCount;				//��������
	private String intstTermType;				//��Ϣ����
	
	//������Դ����
	private String acSource;
	private String cifTyp;
	private String idTyp;
	private String idNo;
	
	private int graceDay;	//����������
	
	/**
	 * @return �������
	 */
	public double getIndpnAmt() {
		return indpnAmt;
	}
	/**
	 * @param �������
	 */
	public void setIndpnAmt(double indpnAmt) {
		this.indpnAmt = indpnAmt;
	}
	/**
	 * @return ���н��
	 */
	public double getTrustAmt() {
		return trustAmt;
	}
	/**
	 * @param ���н��
	 */
	public void setTrustAmt(double trustAmt) {
		this.trustAmt = trustAmt;
	}
	/**
	 * @return ��Ϣ��־
	 */
	public String getSbsyInd() {
		return sbsyInd;
	}
	/**
	 * @param ��Ϣ��־
	 */
	public void setSbsyInd(String sbsyInd) {
		this.sbsyInd = sbsyInd;
	}
	/**
	 * @return ��Ȩ���
	 */
	public String getAuthNo() {
		return authNo;
	}
	/**
	 * @param ��Ȩ���
	 */
	public void setAuthNo(String authNo) {
		this.authNo = authNo;
	}
	/**
	 * @return �Ŵ���Ʒ���
	 */
	public String getPrdtNoCrd() {
		return prdtNoCrd;
	}
	/**
	 * @param �Ŵ���Ʒ���
	 */
	public void setPrdtNoCrd(String prdtNoCrd) {
		this.prdtNoCrd = prdtNoCrd;
	}
	/**
	 * @return ��������
	 */
	public String getLoanTyp() {
		return loanTyp;
	}
	/**
	 * @param ��������
	 */
	public void setLoanTyp(String loanTyp) {
		this.loanTyp = loanTyp;
	}
	/**
	 * @return ��ͬ��
	 */
	public String getContNo() {
		return contNo;
	}
	/**
	 * @param ��ͬ��
	 */
	public void setContNo(String contNo) {
		this.contNo = contNo;
	}
	/**
	 * @return ��ݺ�
	 */
	public String getLoanNo() {
		return loanNo;
	}
	/**
	 * @param ��ݺ�
	 */
	public void setLoanNo(String loanNo) {
		this.loanNo = loanNo;
	}
	/**
	 * @return �ͻ���
	 */
	public String getCifNo() {
		return cifNo;
	}
	/**
	 * @param �ͻ���
	 */
	public void setCifNo(String cifNo) {
		this.cifNo = cifNo;
	}
	/**
	 * @return ��������
	 */
	public int getLoanTerm() {
		return loanTerm;
	}
	/**
	 * @param ��������
	 */
	public void setLoanTerm(int loanTerm) {
		this.loanTerm = loanTerm;
	}
	/**
	 * @return ��ʼ����
	 */
	public String getBegDt() {
		return begDt;
	}
	/**
	 * @param ��ʼ����
	 */
	public void setBegDt(String begDt) {
		this.begDt = begDt;
	}
	/**
	 * @return ��������
	 */
	public String getEndDt() {
		return endDt;
	}
	/**
	 * @param ��������
	 */
	public void setEndDt(String endDt) {
		this.endDt = endDt;
	}
	/**
	 * @return ����
	 */
	public String getCurNo() {
		return curNo;
	}
	/**
	 * @param ����
	 */
	public void setCurNo(String curNo) {
		this.curNo = curNo;
	}
	/**
	 * @return ������
	 */
	public double getLoanAmt() {
		return loanAmt;
	}
	/**
	 * @param ������
	 */
	public void setLoanAmt(double loanAmt) {
		this.loanAmt = loanAmt;
	}
	/**
	 * @return ���ʱ��
	 */
	public String getRateNo() {
		return rateNo;
	}
	/**
	 * @param ���ʱ��
	 */
	public void setRateNo(String rateNo) {
		this.rateNo = rateNo;
	}
	/**
	 * @return ���ʸ�������
	 */
	public double getRateFlt() {
		return rateFlt;
	}
	/**
	 * @param ���ʸ�������
	 */
	public void setRateFlt(double rateFlt) {
		this.rateFlt = rateFlt;
	}
	/**
	 * @return ��ͬ����
	 */
	public double getRate() {
		return rate;
	}
	/**
	 * @param ��ͬ����
	 */
	public void setRate(double rate) {
		this.rate = rate;
	}
	/**
	 * @return �������ʸ�������
	 */
	public double getOverRateFlt() {
		return overRateFlt;
	}
	/**
	 * @param �������ʸ�������
	 */
	public void setOverRateFlt(double overRateFlt) {
		this.overRateFlt = overRateFlt;
	}
	/**
	 * @return ��������
	 */
	public double getOverRate() {
		return overRate;
	}
	/**
	 * @param ��������
	 */
	public void setOverRate(double overRate) {
		this.overRate = overRate;
	}
	/**
	 * @return ��Ϣ���ʸ�������
	 */
	public double getFineRateFlt() {
		return fineRateFlt;
	}
	/**
	 * @param ��Ϣ���ʸ�������
	 */
	public void setFineRateFlt(double fineRateFlt) {
		this.fineRateFlt = fineRateFlt;
	}
	/**
	 * @return ��Ϣ����
	 */
	public double getFineRate() {
		return fineRate;
	}
	/**
	 * @param ��Ϣ����
	 */
	public void setFineRate(double fineRate) {
		this.fineRate = fineRate;
	}
	/**
	 * @return ��������
	 */
	public double getCmpdRate() {
		return cmpdRate;
	}
	/**
	 * @param ��������
	 */
	public void setCmpdRate(double cmpdRate) {
		this.cmpdRate = cmpdRate;
	}
	/**
	 * @return ʵ������
	 */
	public double getActRate() {
		return actRate;
	}
	/**
	 * @param ʵ������
	 */
	public void setActRate(double actRate) {
		this.actRate = actRate;
	}
	/**
	 * @return ��Ҫ������ʽ
	 */
	public String getAssureMeans() {
		return assureMeans;
	}
	/**
	 * @param ��Ҫ������ʽ
	 */
	public void setAssureMeans(String assureMeans) {
		this.assureMeans = assureMeans;
	}
	/**
	 * @return ������������
	 */
	public String getRepayTermTyp() {
		return repayTermTyp;
	}
	/**
	 * @param ������������
	 */
	public void setRepayTermTyp(String repayTermTyp) {
		this.repayTermTyp = repayTermTyp;
	}
	/**
	 * @return ��������
	 */
	public int getRepayTerm() {
		return repayTerm;
	}
	/**
	 * @param ��������
	 */
	public void setRepayTerm(int repayTerm) {
		this.repayTerm = repayTerm;
	}
	/**
	 * @return ����ģʽ
	 */
	public String getRateMode() {
		return rateMode;
	}
	/**
	 * @param ����ģʽ
	 */
	public void setRateMode(String rateMode) {
		this.rateMode = rateMode;
	}
	/**
	 * @return ���ʵ�����ʽ
	 */
	public String getRateAdjTyp() {
		return rateAdjTyp;
	}
	/**
	 * @param ���ʵ�����ʽ
	 */
	public void setRateAdjTyp(String rateAdjTyp) {
		this.rateAdjTyp = rateAdjTyp;
	}
	/**
	 * @return ����˺�
	 */
	public String getDisbAcNo() {
		return disbAcNo;
	}
	/**
	 * @param ����˺�
	 */
	public void setDisbAcNo(String disbAcNo) {
		this.disbAcNo = disbAcNo;
	}
	/**
	 * @return ���ʽ
	 */
	public String getRepayTyp() {
		return repayTyp;
	}
	/**
	 * @param ���ʽ
	 */
	public void setRepayTyp(String repayTyp) {
		this.repayTyp = repayTyp;
	}
	/**
	 * @return �����շ�ʽ
	 */
	public String getRepayDayMode() {
		return repayDayMode;
	}
	/**
	 * @param �����շ�ʽ
	 */
	public void setRepayDayMode(String repayDayMode) {
		this.repayDayMode = repayDayMode;
	}
	/**
	 * @return ָ��������
	 */
	public String getRepayDay() {
		return repayDay;
	}
	/**
	 * @param ָ��������
	 */
	public void setRepayDay(String repayDay) {
		this.repayDay = repayDay;
	}
	/**
	 * @return ί��Э����
	 */
	public String getTrustNo() {
		return trustNo;
	}
	/**
	 * @param ί��Э����
	 */
	public void setTrustNo(String trustNo) {
		this.trustNo = trustNo;
	}
	/**
	 * @return ��ǰ����ѡ��
	 */
	public String getRepayAdvOpt() {
		return repayAdvOpt;
	}
	/**
	 * @param ��ǰ����ѡ��
	 */
	public void setRepayAdvOpt(String repayAdvOpt) {
		this.repayAdvOpt = repayAdvOpt;
	}
	/**
	 * @return ������
	 */
	public double getFeeAmt() {
		return feeAmt;
	}
	/**
	 * @param ������
	 */
	public void setFeeAmt(double feeAmt) {
		this.feeAmt = feeAmt;
	}
	/**
	 * @return ��׶λ��ʽ��ʶ
	 */
	public String getMultRepayInd() {
		return multRepayInd;
	}
	/**
	 * @param ��׶λ��ʽ��ʶ
	 */
	public void setMultRepayInd(String multRepayInd) {
		this.multRepayInd = multRepayInd;
	}
	/**
	 * @return �����ݼ���ʼ����
	 */
	public int getPgsBegCnt() {
		return pgsBegCnt;
	}
	/**
	 * @param �����ݼ���ʼ����
	 */
	public void setPgsBegCnt(int pgsBegCnt) {
		this.pgsBegCnt = pgsBegCnt;
	}
	/**
	 * @return �����ݼ��������
	 */
	public int getPgsPrcpFreq() {
		return pgsPrcpFreq;
	}
	/**
	 * @param �����ݼ��������
	 */
	public void setPgsPrcpFreq(int pgsPrcpFreq) {
		this.pgsPrcpFreq = pgsPrcpFreq;
	}
	/**
	 * @return �����ݼ����
	 */
	public double getPgsPrcpAmt() {
		return pgsPrcpAmt;
	}
	/**
	 * @param �����ݼ����
	 */
	public void setPgsPrcpAmt(double pgsPrcpAmt) {
		this.pgsPrcpAmt = pgsPrcpAmt;
	}
	/**
	 * @return �����ݼ�����
	 */
	public double getPgsPrcpPct() {
		return pgsPrcpPct;
	}
	/**
	 * @param �����ݼ�����
	 */
	public void setPgsPrcpPct(double pgsPrcpPct) {
		this.pgsPrcpPct = pgsPrcpPct;
	}
	/**
	 * @return ʵ�ʼ�������
	 */
	public int getCalTtlInstm() {
		return calTtlInstm;
	}
	/**
	 * @param ʵ�ʼ�������
	 */
	public void setCalTtlInstm(int calTtlInstm) {
		this.calTtlInstm = calTtlInstm;
	}
	/**
	 * @return ��ʼ��������
	 */
	public int getPlnAdjPerd() {
		return plnAdjPerd;
	}
	/**
	 * @param ��ʼ��������
	 */
	public void setPlnAdjPerd(int plnAdjPerd) {
		this.plnAdjPerd = plnAdjPerd;
	}
	/**
	 * @return ��ǰ����ģʽ
	 */
	public String getSetlMode() {
		return setlMode;
	}
	/**
	 * @param ��ǰ����ģʽ
	 */
	public void setSetlMode(String setlMode) {
		this.setlMode = setlMode;
	}
	/**
	 * 
	 * @return ��һ�����˻�
	 */
	public String getRepayAcNoFst() {
		return repayAcNoFst;
	}
	/**
	 * @���� ��һ�����˻�
	 * @param repayAcNo1st
	 */
	public void setRepayAcNoFst(String repayAcNoFst) {
		this.repayAcNoFst = repayAcNoFst;
	}
	/**
	 * @return �ڶ������˻�
	 */
	public String getRepayAcNoSnd() {
		return repayAcNoSnd;
	}
	/**
	 * @���� �ڶ������˻�
	 * @param repayAcNo2nd
	 */
	public void setRepayAcNoSnd(String repayAcNoSnd) {
		this.repayAcNoSnd = repayAcNoSnd;
	}
	/**
	 * @return ��֤���˻�
	 */
	public String getBailAcNo() {
		return bailAcNo;
	}
	/**
	 * @���� ��֤���˻�
	 * @param bailAcNo
	 */
	public void setBailAcNo(String bailAcNo) {
		this.bailAcNo = bailAcNo;
	}
	public Double getBailAmt() {
		return bailAmt;
	}
	public void setBailAmt(Double bailAmt) {
		this.bailAmt = bailAmt;
	}
	/**
	 * ����˺ţ����ı���
	 * @return ����˺ţ����ı���
	 */
	public String getDepositAcNo() {
		return depositAcNo;
	}
	/**
	 * ����˺ţ����ı���
	 * @param depositAcNo
	 */
	public void setDepositAcNo(String depositAcNo) {
		this.depositAcNo = depositAcNo;
	}
	public Double getBailBal() {
		return bailBal;
	}
	public void setBailBal(Double bailBal) {
		this.bailBal = bailBal;
	}
	/**
	 * ָ������˺������ı���
	 * @return ָ������˺������ı���
	 */
	public Double getDepositAmt() {
		return depositAmt;
	}
	/**
	 * ָ������˺������ı���
	 * @param depositAmt
	 */
	public void setDepositAmt(Double depositAmt) {
		this.depositAmt = depositAmt;
	}
	public String getCifTyp() {
		return cifTyp;
	}
	public void setCifTyp(String cifTyp) {
		this.cifTyp = cifTyp;
	}
	public String getIdTyp() {
		return idTyp;
	}
	public void setIdTyp(String idTyp) {
		this.idTyp = idTyp;
	}
	public String getIdNo() {
		return idNo;
	}
	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}
	/**
	 * ԭ��ݺţ����»����ã�
	 * @return ԭ��ݺţ����»����ã�
	 */
	public String getOldLoanNo() {
		return oldLoanNo;
	}
	/**
	 * ԭ��ݺţ����»����ã�
	 * @param oldLoanNo
	 */
	public void setOldLoanNo(String oldLoanNo) {
		this.oldLoanNo = oldLoanNo;
	}
	public String getCifName() {
		return cifName;
	}
	public void setCifName(String cifName) {
		this.cifName = cifName;
	}
	/**
	 * ������Դ
	 * @return ������Դ
	 */
	public String getAcSource() {
		return acSource;
	}
	/**
	 * ������Դ
	 * @param acSource ������Դ
	 */
	public void setAcSource(String acSource) {
		this.acSource = acSource;
	}
	/**
	 * ��������
	 * @return ��������
	 */
	public String getRateKind() {
		return rateKind;
	}
	/**
	 * ��������
	 * @param rateKind
	 */
	public void setRateKind(String rateKind) {
		this.rateKind = rateKind;
	}
	/**
	 * ����������
	 * @return ����������
	 */
	public int getGraceDay() {
		return graceDay;
	}
	/**
	 * ����������
	 * @param graceDay 
	 */
	public void setGraceDay(int graceDay) {
		this.graceDay = graceDay;
	}
	/**
	 * ԭ�������ʸ�����
	 * @return ԭ�������ʸ�����
	 */
	public Double getNormRateFlt() {
		return normRateFlt;
	}
	/**
	 * ԭ�������ʸ�����
	 * @param normRateFlt
	 */
	public void setNormRateFlt(Double normRateFlt) {
		this.normRateFlt = normRateFlt;
	}
	public String getPreferRateInd() {
		return preferRateInd;
	}
	public void setPreferRateInd(String preferRateInd) {
		this.preferRateInd = preferRateInd;
	}
	public String getYLoanBail() {
		return yLoanBail;
	}
	public void setYLoanBail(String yLoanBail) {
		this.yLoanBail = yLoanBail;
	}
	public int getLoanTermDay() {
		return loanTermDay;
	}
	public void setLoanTermDay(int loanTermDay) {
		this.loanTermDay = loanTermDay;
	}
	public String getFltType() {
		return fltType;
	}
	public void setFltType(String fltType) {
		this.fltType = fltType;
	}
	public double getRateFltCount() {
		return rateFltCount;
	}
	public void setRateFltCount(double rateFltCount) {
		this.rateFltCount = rateFltCount;
	}
	public String getIntstTermType() {
		return intstTermType;
	}
	public void setIntstTermType(String intstTermType) {
		this.intstTermType = intstTermType;
	}
}