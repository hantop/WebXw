package app.creditapp.acc.option.entity;
import accounting.plat.util.NumberUtil;
import app.base.BaseDomain;
/**
* Title: AcLnRepayPln.java
* @version��1.0
**/
public class AcLnRepayPln extends BaseDomain {
	private String pactNo;//��ͬ��
	private String brNo;//������
	private String brName;//������
	private String loanNo;//��ݺ�
	private Integer perdNo;//�ں�
	private String payDt;//Ӧ��������
	private Double instmAmt;//�ڹ����
	private Double prcpAmt;//����
	private Double normInt;//������Ϣ
	private Double fineInt;//��Ϣ
	private Double bal;//�������
	private Double repayPrcpAmt;//�ѻ�����
	private Double repayNormInt;//�ѻ�������Ϣ
	private Double repayFineInt;//�ѻ���Ϣ
	private Double lnRate;//ִ������
	private Double overRate;//��������
	private String overInd;//���ڱ�־
	private String lstPayDt;//���������
	private Double wvPrcpAmt;//���Ȿ��
	private Double wvNormInt;//����������Ϣ
	private Double wvFineInt;//���ⷣϢ
	private String prcpSts;//����״̬
	private String intSts;//��Ϣ״̬
	private String setlSts;//�����־
	private String fineIntDt;//�ϴνᷣϢ����
	private String ppErInd;//���ڻ����¼�Ƿ�Ϊ��������
	private String ifAdj;//�����Ƿ�Ϊ�ֶ�����

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
	 * @return �ں�
	 */
	public Integer getPerdNo() {
	 	return perdNo;
	}
	/**
	 * @���� �ں�
	 * @param perdNo
	 */
	public void setPerdNo(Integer perdNo) {
	 	this.perdNo = perdNo;
	}
	/**
	 * @return Ӧ��������
	 */
	public String getPayDt() {
	 	return payDt;
	}
	/**
	 * @���� Ӧ��������
	 * @param payDt
	 */
	public void setPayDt(String payDt) {
	 	this.payDt = payDt;
	}
	/**
	 * @return �ڹ����
	 */
	public Double getInstmAmt() {
	 	return instmAmt;
	}
	/**
	 * @���� �ڹ����
	 * @param instmAmt
	 */
	public void setInstmAmt(Double instmAmt) {
	 	this.instmAmt = instmAmt;
	}
	/**
	 * @return ����
	 */
	public Double getPrcpAmt() {
	 	return prcpAmt;
	}
	/**
	 * @���� ����
	 * @param prcpAmt
	 */
	public void setPrcpAmt(Double prcpAmt) {
	 	this.prcpAmt = prcpAmt;
	}
	/**
	 * @return ������Ϣ
	 */
	public Double getNormInt() {
	 	return normInt;
	}
	/**
	 * @���� ������Ϣ
	 * @param normInt
	 */
	public void setNormInt(Double normInt) {
	 	this.normInt = normInt;
	}
	/**
	 * @return ��Ϣ
	 */
	public Double getFineInt() {
	 	return fineInt;
	}
	/**
	 * @���� ��Ϣ
	 * @param fineInt
	 */
	public void setFineInt(Double fineInt) {
	 	this.fineInt = fineInt;
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
	 * @return �ѻ�����
	 */
	public Double getRepayPrcpAmt() {
	 	return repayPrcpAmt;
	}
	/**
	 * @���� �ѻ�����
	 * @param repayPrcpAmt
	 */
	public void setRepayPrcpAmt(Double repayPrcpAmt) {
	 	this.repayPrcpAmt = repayPrcpAmt;
	}
	/**
	 * @return �ѻ�������Ϣ
	 */
	public Double getRepayNormInt() {
	 	return repayNormInt;
	}
	/**
	 * @���� �ѻ�������Ϣ
	 * @param repayNormInt
	 */
	public void setRepayNormInt(Double repayNormInt) {
	 	this.repayNormInt = repayNormInt;
	}
	/**
	 * @return �ѻ���Ϣ
	 */
	public Double getRepayFineInt() {
	 	return repayFineInt;
	}
	/**
	 * @���� �ѻ���Ϣ
	 * @param repayFineInt
	 */
	public void setRepayFineInt(Double repayFineInt) {
	 	this.repayFineInt = repayFineInt;
	}
	/**
	 * @return ִ������
	 */
	public Double getLnRate() {
	 	return lnRate;
	}
	/**
	 * @���� ִ������
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
	 * @return ���ڱ�־
	 */
	public String getOverInd() {
	 	return overInd;
	}
	/**
	 * @���� ���ڱ�־
	 * @param overInd
	 */
	public void setOverInd(String overInd) {
	 	this.overInd = overInd;
	}
	/**
	 * @return ���������
	 */
	public String getLstPayDt() {
	 	return lstPayDt;
	}
	/**
	 * @���� ���������
	 * @param lstPayDt
	 */
	public void setLstPayDt(String lstPayDt) {
	 	this.lstPayDt = lstPayDt;
	}
	/**
	 * @return ���Ȿ��
	 */
	public Double getWvPrcpAmt() {
	 	return wvPrcpAmt;
	}
	/**
	 * @���� ���Ȿ��
	 * @param wvPrcpAmt
	 */
	public void setWvPrcpAmt(Double wvPrcpAmt) {
	 	this.wvPrcpAmt = wvPrcpAmt;
	}
	/**
	 * @return ����������Ϣ
	 */
	public Double getWvNormInt() {
	 	return wvNormInt;
	}
	/**
	 * @���� ����������Ϣ
	 * @param wvNormInt
	 */
	public void setWvNormInt(Double wvNormInt) {
	 	this.wvNormInt = wvNormInt;
	}
	/**
	 * @return ���ⷣϢ
	 */
	public Double getWvFineInt() {
	 	return wvFineInt;
	}
	/**
	 * @���� ���ⷣϢ
	 * @param wvFineInt
	 */
	public void setWvFineInt(Double wvFineInt) {
	 	this.wvFineInt = wvFineInt;
	}
	/**
	 * @return ����״̬
	 */
	public String getPrcpSts() {
	 	return prcpSts;
	}
	/**
	 * @���� ����״̬
	 * @param prcpSts
	 */
	public void setPrcpSts(String prcpSts) {
	 	this.prcpSts = prcpSts;
	}
	/**
	 * @return ��Ϣ״̬
	 */
	public String getIntSts() {
	 	return intSts;
	}
	/**
	 * @���� ��Ϣ״̬
	 * @param intSts
	 */
	public void setIntSts(String intSts) {
	 	this.intSts = intSts;
	}
	/**
	 * @return �����־
	 */
	public String getSetlSts() {
	 	return setlSts;
	}
	/**
	 * @���� �����־
	 * @param setlSts
	 */
	public void setSetlSts(String setlSts) {
	 	this.setlSts = setlSts;
	}
	/**
	 * @return �ϴνᷣϢ����
	 */
	public String getFineIntDt() {
	 	return fineIntDt;
	}
	/**
	 * @���� �ϴνᷣϢ����
	 * @param fineIntDt
	 */
	public void setFineIntDt(String fineIntDt) {
	 	this.fineIntDt = fineIntDt;
	}
	/**
	 * @return ���ڻ����¼�Ƿ�Ϊ��������
	 */
	public String getPpErInd() {
	 	return ppErInd;
	}
	/**
	 * @���� ���ڻ����¼�Ƿ�Ϊ��������
	 * @param ppErInd
	 */
	public void setPpErInd(String ppErInd) {
	 	this.ppErInd = ppErInd;
	}
	/**
	 * @return �����Ƿ�Ϊ�ֶ�����
	 */
	public String getIfAdj() {
	 	return ifAdj;
	}
	/**
	 * @���� �����Ƿ�Ϊ�ֶ�����
	 * @param ifAdj
	 */
	public void setIfAdj(String ifAdj) {
	 	this.ifAdj = ifAdj;
	}
	public String getPactNo() {
		return pactNo;
	}
	public void setPactNo(String pactNo) {
		this.pactNo = pactNo;
	}
	public String getBrNo() {
		return brNo;
	}
	public void setBrNo(String brNo) {
		this.brNo = brNo;
	}
	public String getBrName() {
		return brName;
	}
	public void setBrName(String brName) {
		this.brName = brName;
	}
	public Double getAmt(){
		return NumberUtil.amtAdd(NumberUtil.amtAdd(this.prcpAmt, this.normInt), this.fineInt);
	}
}