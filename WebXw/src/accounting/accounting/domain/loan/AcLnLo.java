package accounting.domain.loan;
import app.base.BaseDomain;
/**
* Title: AcLnLo.java
* Description:
* @���� su
* @���� 2018-3-20
* @version��1.0
**/
public class AcLnLo extends accounting.domain.sys.CMISDomain {
	private String loanNo;//��ݺ�
	private String pactNo;//��ͬ��
	private String brNo;//������
	private Integer perdNo;//Ƿ���ڴ�
	private String payDt;//Ӧ������
	private Double prcpAmt;//Ƿ���
	private Double normInt;//Ƿ��Ϣ
	private Double fineInt;//Ƿ��Ϣ
	private Double overRate;//��������
	private Double repayPrcpAmt;//�ѹ黹������
	private Double repayNormInt;//�ѹ黹������Ϣ
	private Double repayFineInt;//�ѹ黹��Ϣ���
	private Double wvPrcpAmt;//���Ȿ��
	private Double wvNormInt;//����������Ϣ
	private Double wvFineInt;//���ⷣϢ
	private String prcpSts;//����״̬
	private String intSts;//��Ϣ״̬
	private String setlSts;//�Ƿ����־
	private String overDt;//ת������
	private String fineIntDt;//�ϴνᷣϢ����
	private String mac;//mac
	private String nextIntDt;//��һ�ν�Ϣ����
	private String setlDt;//��������

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
	 * @return Ƿ���ڴ�
	 */
	public Integer getPerdNo() {
	 	return perdNo;
	}
	/**
	 * @���� Ƿ���ڴ�
	 * @param perdNo
	 */
	public void setPerdNo(Integer perdNo) {
	 	this.perdNo = perdNo;
	}
	/**
	 * @return Ӧ������
	 */
	public String getPayDt() {
	 	return payDt;
	}
	/**
	 * @���� Ӧ������
	 * @param payDt
	 */
	public void setPayDt(String payDt) {
	 	this.payDt = payDt;
	}
	/**
	 * @return Ƿ���
	 */
	public Double getPrcpAmt() {
	 	return prcpAmt;
	}
	/**
	 * @���� Ƿ���
	 * @param prcpAmt
	 */
	public void setPrcpAmt(Double prcpAmt) {
	 	this.prcpAmt = prcpAmt;
	}
	/**
	 * @return Ƿ��Ϣ
	 */
	public Double getNormInt() {
	 	return normInt;
	}
	/**
	 * @���� Ƿ��Ϣ
	 * @param normInt
	 */
	public void setNormInt(Double normInt) {
	 	this.normInt = normInt;
	}
	/**
	 * @return Ƿ��Ϣ
	 */
	public Double getFineInt() {
	 	return fineInt;
	}
	/**
	 * @���� Ƿ��Ϣ
	 * @param fineInt
	 */
	public void setFineInt(Double fineInt) {
	 	this.fineInt = fineInt;
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
	 * @return �ѹ黹������
	 */
	public Double getRepayPrcpAmt() {
	 	return repayPrcpAmt;
	}
	/**
	 * @���� �ѹ黹������
	 * @param repayPrcpAmt
	 */
	public void setRepayPrcpAmt(Double repayPrcpAmt) {
	 	this.repayPrcpAmt = repayPrcpAmt;
	}
	/**
	 * @return �ѹ黹������Ϣ
	 */
	public Double getRepayNormInt() {
	 	return repayNormInt;
	}
	/**
	 * @���� �ѹ黹������Ϣ
	 * @param repayNormInt
	 */
	public void setRepayNormInt(Double repayNormInt) {
	 	this.repayNormInt = repayNormInt;
	}
	/**
	 * @return �ѹ黹��Ϣ���
	 */
	public Double getRepayFineInt() {
	 	return repayFineInt;
	}
	/**
	 * @���� �ѹ黹��Ϣ���
	 * @param repayFineInt
	 */
	public void setRepayFineInt(Double repayFineInt) {
	 	this.repayFineInt = repayFineInt;
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
	 * @return �Ƿ����־
	 */
	public String getSetlSts() {
	 	return setlSts;
	}
	/**
	 * @���� �Ƿ����־
	 * @param setlSts
	 */
	public void setSetlSts(String setlSts) {
	 	this.setlSts = setlSts;
	}
	/**
	 * @return ת������
	 */
	public String getOverDt() {
	 	return overDt;
	}
	/**
	 * @���� ת������
	 * @param overDt
	 */
	public void setOverDt(String overDt) {
	 	this.overDt = overDt;
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
	 * @return mac
	 */
	public String getMac() {
	 	return mac;
	}
	/**
	 * @���� mac
	 * @param mac
	 */
	public void setMac(String mac) {
	 	this.mac = mac;
	}
	/**
	 * @return ��һ�ν�Ϣ����
	 */
	public String getNextIntDt() {
	 	return nextIntDt;
	}
	/**
	 * @���� ��һ�ν�Ϣ����
	 * @param nextIntDt
	 */
	public void setNextIntDt(String nextIntDt) {
	 	this.nextIntDt = nextIntDt;
	}
	/**
	 * @return ��������
	 */
	public String getSetlDt() {
	 	return setlDt;
	}
	/**
	 * @���� ��������
	 * @param setlDt
	 */
	public void setSetlDt(String setlDt) {
	 	this.setlDt = setlDt;
	}
}