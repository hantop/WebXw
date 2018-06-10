package accounting.domain.loan;
/**
* Title: AcLnPayPln.java
* Description:
* @���� su
* @���� 2018-3-20
* @version��1.0
**/
public class AcLnPayPln extends accounting.domain.sys.CMISDomain {
	private String acId;                    //�˻�ID
	private String acSeq;                  //�˻����
	private String loanNo;                  //��ݺ�
	private int    perdNo;                  //�ں�
	private String payDt;					//Ӧ������
	private String endDt;                   //������
	private double instmAmt;                //�ڹ����
	private double prcpAmt;                 //����
	private double normInt;               //������Ϣ
	private double fineInt;               //��Ϣ
	private double overInt;              //������Ϣ
	private double inOverInt;			//����������Ϣ
	private double outOverInt;			//����������Ϣ
	private double cmpdInt;                 //����
	private double prcpAcm;                 //�������
	private double intstAcm;                //��Ϣ����
	private double cmpdAcm;                 //��������
	private double bal;                     //ʣ�౾��
	private double repayPrcpAmt;            //�ѻ�����
	private double repayNormInt;          //�ѻ���Ϣ
	private double repayFineInt;          //�ѹ黹��Ϣ���
	private double repayOverInt;          //�ѻ�������Ϣ
	private double repayInOverInt;		//�ѻ�����������Ϣ
	private double repayOutOverInt;      //�ѻ�����������Ϣ
	private double repayCmpdInt;         //�ѻ�����
	private double rate;                    //����ִ������
	private double overRate;                //��������
	private String overInd;                 //���ڱ�־
	private String lstPayDt;                //���������
	private double normIntTaken;             //�Ѽ���������Ϣ
	private double overIntTaken;            //�Ѽ���������Ϣ
	private double wvNormInt;             //����������Ϣ
	private double wvOverInt;             //����������Ϣ
	private double wvInOverInt;
	private double wvOutOverInt;
	private double wvCmpdInt;             //���⸴��
	private double wvFineInt;
	private double sbsyAmt;              //Ӧ��Ϣ���
	private String prcpSts;                 //����״̬
	private String intSts;                //��Ϣ״̬
	private String setlSts;                 //�Ƿ����־
	private String fineIntDt;          	//�ϴνᷣϢ����
	private String ppErInd;                 //���ڻ����¼�Ƿ�Ϊ��������
	private String acmDt;             		//����������
	private String acmBegDt;				//������ʼ����
	private double wvPrcpAmt;	//���Ȿ��
	private String ifAdj;		//�Ƿ��ֶ�����
	
	private double sbsyedAmt;		//����Ϣ���
	
	/**
	 * @return ���Ȿ��
	 */
	public double getWvPrcpAmt() {
		return wvPrcpAmt;
	}

	/**
	 * @param ���Ȿ��
	 */
	public void setWvPrcpAmt(double wvPrcpAmt) {
		this.wvPrcpAmt = wvPrcpAmt;
	}

	/**
	 * @return �Ѽ���������Ϣ
	 */
	public double getNormIntTaken() {
		return normIntTaken;
	}
	/**
	 * @param �Ѽ���������Ϣ
	 */
	public void setNormIntTaken(double normIntTaken) {
		this.normIntTaken = normIntTaken;
	}
	/**
	 * @return �Ѽ���������Ϣ
	 */
	public double getOverIntTaken() {
		return overIntTaken;
	}
	/**
	 * @param �Ѽ���������Ϣ
	 */
	public void setOverIntTaken(double overIntTaken) {
		this.overIntTaken = overIntTaken;
	}
	/**
	 * @return ����������Ϣ
	 */
	public double getWvNormInt() {
		return wvNormInt;
	}
	/**
	 * @param ����������Ϣ
	 */
	public void setWvNormInt(double wvNormInt) {
		this.wvNormInt = wvNormInt;
	}
	/**
	 * @return ����������Ϣ
	 */
	public double getWvOverInt() {
		return wvOverInt;
	}
	/**
	 * @param ����������Ϣ
	 */
	public void setWvOverInt(double wvOverInt) {
		this.wvOverInt = wvOverInt;
	}
	/**
	 * @return ���⸴��
	 */
	public double getWvCmpdInt() {
		return wvCmpdInt;
	}
	/**
	 * @param ���⸴��
	 */
	public void setWvCmpdInt(double wvCmpdInt) {
		this.wvCmpdInt = wvCmpdInt;
	}
	/**
	 * @return ������ʼ����
	 */
	public String getAcmBegDt() {
		return acmBegDt;
	}
	/**
	 * @param ������ʼ����
	 */
	public void setAcmBegDt(String acmBegDt) {
		this.acmBegDt = acmBegDt;
	}
	/**
	 * @return ���� �˻�ID
	 */
	public String getAcId() {
		return acId;
	}
	/**
	 * @���� �˻�ID
	 * @param acId
	 */
	public void setAcId(String acId) {
		this.acId=acId;
	}
	/**
	 * @return ���� �˻����
	 */
	public String getAcSeq() {
		return acSeq;
	}
	/**
	 * @���� �˻����
	 * @param acSeqn
	 */
	public void setAcSeq(String acSeq) {
		this.acSeq=acSeq;
	}
	/**
	 * @return ���� ��ݺ�
	 */
	public String getLoanNo() {
		return loanNo;
	}
	/**
	 * @���� ��ݺ�
	 * @param loanNo
	 */
	public void setLoanNo(String loanNo) {
		this.loanNo=loanNo;
	}
	/**
	 * @return ���� �ں�
	 */
	public int getPerdNo() {
		return perdNo;
	}
	/**
	 * @���� �ں�
	 * @param perdNo
	 */
	public void setPerdNo(int perdNo) {
		this.perdNo=perdNo;
	}
	
	/**
	 * Ӧ������
	 * @return Ӧ������
	 */
	public String getPayDt() {
		return payDt;
	}
	/**
	 * Ӧ������
	 * @param payDt
	 */
	public void setPayDt(String payDt) {
		this.payDt = payDt;
	}

	/**
	 * @return ���� ������
	 */
	public String getEndDt() {
		return endDt;
	}
	/**
	 * @���� ������
	 * @param endDt
	 */
	public void setEndDt(String endDt) {
		this.endDt=endDt;
	}
	/**
	 * @return ���� �ڹ����
	 */
	public double getInstmAmt() {
		return instmAmt;
	}
	/**
	 * @���� �ڹ����
	 * @param instmAmt
	 */
	public void setInstmAmt(double instmAmt) {
		this.instmAmt=instmAmt;
	}
	/**
	 * @return ���� ����
	 */
	public double getPrcpAmt() {
		return prcpAmt;
	}
	/**
	 * @���� ����
	 * @param prcpAmt
	 */
	public void setPrcpAmt(double prcpAmt) {
		this.prcpAmt=prcpAmt;
	}
	/**
	 * @return ���� ������Ϣ
	 */
	public double getNormInt() {
		return normInt;
	}
	/**
	 * @���� ������Ϣ
	 * @param nromIntst
	 */
	public void setNormInt(double normInt) {
		this.normInt=normInt;
	}
	/**
	 * @return ���� ��Ϣ
	 */
	public double getFineInt() {
		return fineInt;
	}
	/**
	 * @���� ��Ϣ
	 * @param fineIntst
	 */
	public void setFineInt(double fineInt) {
		this.fineInt=fineInt;
	}
	/**
	 * @return ���� ������Ϣ
	 */
	public double getOverInt() {
		return overInt;
	}
	/**
	 * @���� ������Ϣ
	 * @param overInstst
	 */
	public void setOverInt(double overInt) {
		this.overInt=overInt;
	}
	/**
	 * @return ���� ����
	 */
	public double getCmpdInt() {
		return cmpdInt;
	}
	/**
	 * @���� ����
	 * @param cmpdAmt
	 */
	public void setCmpdInt(double cmpdInt) {
		this.cmpdInt=cmpdInt;
	}
	/**
	 * @return ���� �������
	 */
	public double getPrcpAcm() {
		return prcpAcm;
	}
	/**
	 * @���� �������
	 * @param prcpAcm
	 */
	public void setPrcpAcm(double prcpAcm) {
		this.prcpAcm=prcpAcm;
	}
	/**
	 * @return ���� ��Ϣ����
	 */
	public double getIntstAcm() {
		return intstAcm;
	}
	/**
	 * @���� ��Ϣ����
	 * @param intstAcm
	 */
	public void setIntstAcm(double intstAcm) {
		this.intstAcm=intstAcm;
	}
	/**
	 * @return ���� ��������
	 */
	public double getCmpdAcm() {
		return cmpdAcm;
	}
	/**
	 * @���� ��������
	 * @param cmpdAcm
	 */
	public void setCmpdAcm(double cmpdAcm) {
		this.cmpdAcm=cmpdAcm;
	}
	/**
	 * @return ���� ʣ�౾��
	 */
	public double getBal() {
		return bal;
	}
	/**
	 * @���� ʣ�౾��
	 * @param bal
	 */
	public void setBal(double bal) {
		this.bal=bal;
	}
	/**
	 * @return ���� �ѻ�����
	 */
	public double getRepayPrcpAmt() {
		return repayPrcpAmt;
	}
	/**
	 * @���� �ѻ�����
	 * @param repayPrcpAmt
	 */
	public void setRepayPrcpAmt(double repayPrcpAmt) {
		this.repayPrcpAmt=repayPrcpAmt;
	}
	/**
	 * @return ���� �ѻ���Ϣ
	 */
	public double getRepayNormInt() {
		return repayNormInt;
	}
	/**
	 * @���� �ѻ���Ϣ
	 * @param repayNormIntst
	 */
	public void setRepayNormInt(double repayNormInt) {
		this.repayNormInt=repayNormInt;
	}
	/**
	 * @return ���� �ѹ黹��Ϣ���
	 */
	public double getRepayFineInt() {
		return repayFineInt;
	}
	/**
	 * @���� �ѹ黹��Ϣ���
	 * @param repayFineIntst
	 */
	public void setRepayFineInt(double repayFineInt) {
		this.repayFineInt=repayFineInt;
	}
	/**
	 * @return ���� �ѻ�������Ϣ
	 */
	public double getRepayOverInt() {
		return repayOverInt;
	}
	/**
	 * @���� �ѻ�������Ϣ
	 * @param repayOverIntst
	 */
	public void setRepayOverInt(double repayOverInt) {
		this.repayOverInt=repayOverInt;
	}
	/**
	 * @return ���� �ѻ�����
	 */
	public double getRepayCmpdInt() {
		return repayCmpdInt;
	}
	/**
	 * @���� �ѻ�����
	 * @param repayCmpdInstst
	 */
	public void setRepayCmpdInt(double repayCmpdInt) {
		this.repayCmpdInt=repayCmpdInt;
	}
	/**
	 * @return ���� ����ִ������
	 */
	public double getRate() {
		return rate;
	}
	/**
	 * @���� ����ִ������
	 * @param rate
	 */
	public void setRate(double rate) {
		this.rate=rate;
	}
	/**
	 * @return ���� ��������
	 */
	public double getOverRate() {
		return overRate;
	}
	/**
	 * @���� ��������
	 * @param overRate
	 */
	public void setOverRate(double overRate) {
		this.overRate=overRate;
	}
	/**
	 * @return ���� ���ڱ�־
	 */
	public String getOverInd() {
		return overInd;
	}
	/**
	 * @���� ���ڱ�־
	 * @param overInd
	 */
	public void setOverInd(String overInd) {
		this.overInd=overInd;
	}
	/**
	 * @return ���� ���������
	 */
	public String getLstPayDt() {
		return lstPayDt;
	}
	/**
	 * @���� ���������
	 * @param lstPayDt
	 */
	public void setLstPayDt(String lstPayDt) {
		this.lstPayDt=lstPayDt;
	}
	
	/**
	 * @return ���� ��Ϣ���
	 */
	public double getSbsyAmt() {
		return sbsyAmt;
	}
	/**
	 * @���� ��Ϣ���
	 * @param sbsyIntAmt
	 */
	public void setSbsyAmt(double sbsyAmt) {
		this.sbsyAmt=sbsyAmt;
	}
	/**
	 * @return ���� ����״̬
	 */
	public String getPrcpSts() {
		return prcpSts;
	}
	/**
	 * @���� ����״̬
	 * @param prcpSts
	 */
	public void setPrcpSts(String prcpSts) {
		this.prcpSts=prcpSts;
	}
	/**
	 * @return ���� ��Ϣ״̬
	 */
	public String getIntSts() {
		return intSts;
	}
	/**
	 * @���� ��Ϣ״̬
	 * @param intstSts
	 */
	public void setIntSts(String intSts) {
		this.intSts=intSts;
	}
	/**
	 * @return setlSts 
	 */	
	public String getSetlSts() {
		return setlSts;
	}
	/**
	 * @���� 
	 * @param setlSts 
	 */
	public void setSetlSts(String setlSts) {
		this.setlSts = setlSts;
	}
	/**
	 * @return ���� �ϴνᷣϢ����
	 */
	public String getFineIntDt() {
		return fineIntDt;
	}
	/**
	 * @���� �ϴνᷣϢ����
	 * @param fineIntstGenDt
	 */
	public void setFineIntDt(String fineIntDt) {
		this.fineIntDt=fineIntDt;
	}
	/**
	 * @return ���� ���ڻ����¼�Ƿ�Ϊ��������
	 */
	public String getPpErInd() {
		return ppErInd;
	}
	/**
	 * @���� ���ڻ����¼�Ƿ�Ϊ��������
	 * @param ppErInd
	 */
	public void setPpErInd(String ppErInd) {
		this.ppErInd=ppErInd;
	}
	/**
	 * @return ���� ����������
	 */
	public String getAcmDt() {
		return acmDt;
	}
	/**
	 * @���� ����������
	 * @param psGenProdDt
	 */
	public void setAcmDt(String acmDt) {
		this.acmDt=acmDt;
	}

	/**
	 * @return inOverInt
	 */
	public double getInOverInt() {
		return inOverInt;
	}

	/**
	 * @param inOverInt the inOverInt to set
	 */
	public void setInOverInt(double inOverInt) {
		this.inOverInt = inOverInt;
	}

	/**
	 * @return outOverInt
	 */
	public double getOutOverInt() {
		return outOverInt;
	}

	/**
	 * @param outOverInt the outOverInt to set
	 */
	public void setOutOverInt(double outOverInt) {
		this.outOverInt = outOverInt;
	}

	/**
	 * @return repayInOverInt
	 */
	public double getRepayInOverInt() {
		return repayInOverInt;
	}

	/**
	 * @param repayInOverInt the repayInOverInt to set
	 */
	public void setRepayInOverInt(double repayInOverInt) {
		this.repayInOverInt = repayInOverInt;
	}

	/**
	 * @return repayOutOverInt
	 */
	public double getRepayOutOverInt() {
		return repayOutOverInt;
	}

	/**
	 * @param repayOutOverInt the repayOutOverInt to set
	 */
	public void setRepayOutOverInt(double repayOutOverInt) {
		this.repayOutOverInt = repayOutOverInt;
	}

	/**
	 * @return wvInOverInt
	 */
	public double getWvInOverInt() {
		return wvInOverInt;
	}

	/**
	 * @param wvInOverInt the wvInOverInt to set
	 */
	public void setWvInOverInt(double wvInOverInt) {
		this.wvInOverInt = wvInOverInt;
	}

	/**
	 * @return wvOutOverInt
	 */
	public double getWvOutOverInt() {
		return wvOutOverInt;
	}

	/**
	 * @param wvOutOverInt the wvOutOverInt to set
	 */
	public void setWvOutOverInt(double wvOutOverInt) {
		this.wvOutOverInt = wvOutOverInt;
	}

	public String getIfAdj() {
		return ifAdj;
	}

	public void setIfAdj(String ifAdj) {
		this.ifAdj = ifAdj;
	}

	public double getSbsyedAmt() {
		return sbsyedAmt;
	}
	public void setSbsyedAmt(double sbsyedAmt) {
		this.sbsyedAmt = sbsyedAmt;
	}

	public double getWvFineInt() {
		return wvFineInt;
	}

	public void setWvFineInt(double wvFineInt) {
		this.wvFineInt = wvFineInt;
	}
	
}