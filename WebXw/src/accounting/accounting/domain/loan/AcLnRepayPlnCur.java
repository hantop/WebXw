package accounting.domain.loan;
/**
* Title: AcLnPayPlnCur.java
* Description:
* @���� su
* @���� 2018-3-20
* @version��1.0
**/
public class AcLnRepayPlnCur extends accounting.domain.sys.CMISDomain {
	private String loanNo;                  //��ݺ�
	private String pactNo;					//��ͬ��
	private String brNo;					//������
	private double ttlAmt;                  //�ܽ��
	private int    perdNo;                  //��ǰ����
	private double prcpAmt;                 //���ڽ��
	private double normInt;               //��ǰ�ڴ�Ӧ����Ϣ
	private String wrkDt;                   //�Ǽ�����
	private String payDt;                   //Ӧ������
	private String endDt;                   //��������
	private double repayPrcpAmt;			//�ѻ�����
	private double repayNormInt;			//�ѻ���Ϣ
	private Double wvPrcpAmt;//���Ȿ��
	private Double wvNormInt;//������Ϣ


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
	 * @return ���� �ܽ��
	 */
	public double getTtlAmt() {
		return ttlAmt;
	}
	/**
	 * @���� �ܽ��
	 * @param ttlAmt
	 */
	public void setTtlAmt(double ttlAmt) {
		this.ttlAmt=ttlAmt;
	}
	/**
	 * @return ���� ��ǰ����
	 */
	public int getPerdNo() {
		return perdNo;
	}
	/**
	 * @���� ��ǰ����
	 * @param perdNo
	 */
	public void setPerdNo(int perdNo) {
		this.perdNo=perdNo;
	}
	/**
	 * @return ���� ���ڽ��
	 */
	public double getPrcpAmt() {
		return prcpAmt;
	}
	/**
	 * @���� ���ڽ��
	 * @param prcpAmt
	 */
	public void setPrcpAmt(double prcpAmt) {
		this.prcpAmt=prcpAmt;
	}
	/**
	 * @return ���� ��ǰ�ڴ�Ӧ����Ϣ
	 */
	public double getNormInt() {
		return normInt;
	}
	/**
	 * @���� ��ǰ�ڴ�Ӧ����Ϣ
	 * @param normIntst
	 */
	public void setNormInt(double normInt) {
		this.normInt=normInt;
	}
	
	
	/**
	 * @return ���� �Ǽ�����
	 */
	public String getWrkDt() {
		return wrkDt;
	}
	/**
	 * @���� �Ǽ�����
	 * @param wrkDt
	 */
	public void setWrkDt(String wrkDt) {
		this.wrkDt=wrkDt;
	}
	/**
	 * @return ���� ��ʼ�黹����
	 */
	public String getPayDt() {
		return payDt;
	}
	/**
	 * @���� ��ʼ�黹����
	 * @param begDt
	 */
	public void setPayDt(String payDt) {
		this.payDt=payDt;
	}
	/**
	 * @return ���� ��������
	 */
	public String getEndDt() {
		return endDt;
	}
	/**
	 * @���� ��������
	 * @param endDt
	 */
	public void setEndDt(String endDt) {
		this.endDt=endDt;
	}
	/**
	 * �ѻ�����
	 * @return	�ѻ�����
	 */
	public double getRepayPrcpAmt() {
		return repayPrcpAmt;
	}
	/**
	 * �ѻ�����
	 * @param repayPrcpAmt
	 */
	public void setRepayPrcpAmt(double repayPrcpAmt) {
		this.repayPrcpAmt = repayPrcpAmt;
	}
	/**
	 * �ѻ���Ϣ
	 * @return �ѻ���Ϣ
	 */
	public double getRepayNormInt() {
		return repayNormInt;
	}
	/**
	 * �ѻ���Ϣ
	 * @param repayNormInt
	 */
	public void setRepayNormInt(double repayNormInt) {
		this.repayNormInt = repayNormInt;
	}
	public String getBrNo() {
		return brNo;
	}
	public void setBrNo(String brNo) {
		this.brNo = brNo;
	}
	public String getPactNo() {
		return pactNo;
	}
	public void setPactNo(String pactNo) {
		this.pactNo = pactNo;
	}
	public Double getWvPrcpAmt() {
		return wvPrcpAmt;
	}
	public void setWvPrcpAmt(Double wvPrcpAmt) {
		this.wvPrcpAmt = wvPrcpAmt;
	}
	public Double getWvNormInt() {
		return wvNormInt;
	}
	public void setWvNormInt(Double wvNormInt) {
		this.wvNormInt = wvNormInt;
	}
	
}