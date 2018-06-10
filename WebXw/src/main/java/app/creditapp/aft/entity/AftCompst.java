package app.creditapp.aft.entity;
import app.base.BaseDomain;
/**
* Title: AftCompst.java
* Description:
* @version��1.0
**/
public class AftCompst extends accounting.domain.sys.CMISDomain {
	private String compstId;//�������
	private String loanNo;//��ݺ�
	private String pactNo;//��ͬ��
	private String brNo;//������
	private String projNo;//��Ŀ���
	private String cifNo;//�ͻ���
	private String cifName;//�ͻ���
	private Integer perdNo;//�ڴκ�
	private Double prcpAmt;//Ӧ�ձ���
	private Double normInt;//Ӧ����Ϣ
	private Double fineInt;//Ӧ�շ�Ϣ
	private Double repayPrcpAmt;//ʵ�ձ���
	private Double repayNormInt;//ʵ����Ϣ
	private Double repayFineInt;//ʵ�շ�Ϣ
	private String txDate;//�Ǽ�����
	private String txTime;//�Ǽ�ʱ��
	private String compstSts;//����״̬[01-������,02-�Ѵ���]
	private String lstcpstDt;//�ϴδ�����
	private String compstDt;//��������
	
	private String prdtNo;//��Ʒ��
	private String prdtName;//��Ʒ����
	private String projName; //��Ŀ����
	private String loginid;//��¼��Ա
	
	public String getLoginid() {
		return loginid;
	}
	public void setLoginid(String loginid) {
		this.loginid = loginid;
	}
	/**
	 * @return �������
	 */
	public String getCompstId() {
	 	return compstId;
	}
	/**
	 * @���� �������
	 * @param compstId
	 */
	public void setCompstId(String compstId) {
	 	this.compstId = compstId;
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
	 * @return �ͻ���
	 */
	public String getCifName() {
	 	return cifName;
	}
	/**
	 * @���� �ͻ���
	 * @param cifName
	 */
	public void setCifName(String cifName) {
	 	this.cifName = cifName;
	}
	/**
	 * @return �ڴκ�
	 */
	public Integer getPerdNo() {
	 	return perdNo;
	}
	/**
	 * @���� �ڴκ�
	 * @param perdNo
	 */
	public void setPerdNo(Integer perdNo) {
	 	this.perdNo = perdNo;
	}
	/**
	 * @return Ӧ�ձ���
	 */
	public Double getPrcpAmt() {
	 	return prcpAmt;
	}
	/**
	 * @���� Ӧ�ձ���
	 * @param prcpAmt
	 */
	public void setPrcpAmt(Double prcpAmt) {
	 	this.prcpAmt = prcpAmt;
	}
	/**
	 * @return Ӧ����Ϣ
	 */
	public Double getNormInt() {
	 	return normInt;
	}
	/**
	 * @���� Ӧ����Ϣ
	 * @param normInt
	 */
	public void setNormInt(Double normInt) {
	 	this.normInt = normInt;
	}
	/**
	 * @return Ӧ�շ�Ϣ
	 */
	public Double getFineInt() {
	 	return fineInt;
	}
	/**
	 * @���� Ӧ�շ�Ϣ
	 * @param fineInt
	 */
	public void setFineInt(Double fineInt) {
	 	this.fineInt = fineInt;
	}
	/**
	 * @return ʵ�ձ���
	 */
	public Double getRepayPrcpAmt() {
	 	return repayPrcpAmt;
	}
	/**
	 * @���� ʵ�ձ���
	 * @param repayPrcpAmt
	 */
	public void setRepayPrcpAmt(Double repayPrcpAmt) {
	 	this.repayPrcpAmt = repayPrcpAmt;
	}
	/**
	 * @return ʵ����Ϣ
	 */
	public Double getRepayNormInt() {
	 	return repayNormInt;
	}
	/**
	 * @���� ʵ����Ϣ
	 * @param repayNormInt
	 */
	public void setRepayNormInt(Double repayNormInt) {
	 	this.repayNormInt = repayNormInt;
	}
	/**
	 * @return ʵ�շ�Ϣ
	 */
	public Double getRepayFineInt() {
	 	return repayFineInt;
	}
	/**
	 * @���� ʵ�շ�Ϣ
	 * @param repayFineInt
	 */
	public void setRepayFineInt(Double repayFineInt) {
	 	this.repayFineInt = repayFineInt;
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
	 * @return ����״̬[01-������,02-�Ѵ���]
	 */
	public String getCompstSts() {
	 	return compstSts;
	}
	/**
	 * @���� ����״̬[01-������,02-�Ѵ���]
	 * @param compstSts
	 */
	public void setCompstSts(String compstSts) {
	 	this.compstSts = compstSts;
	}
	/**
	 * @return ��������
	 */
	public String getCompstDt() {
	 	return compstDt;
	}
	/**
	 * @���� ��������
	 * @param compstDt
	 */
	public void setCompstDt(String compstDt) {
	 	this.compstDt = compstDt;
	}
	public String getProjNo() {
		return projNo;
	}
	public void setProjNo(String projNo) {
		this.projNo = projNo;
	}
	public String getPrdtNo() {
		return prdtNo;
	}
	public void setPrdtNo(String prdtNo) {
		this.prdtNo = prdtNo;
	}
	public String getPrdtName() {
		return prdtName;
	}
	public void setPrdtName(String prdtName) {
		this.prdtName = prdtName;
	}
	public String getProjName() {
		return projName;
	}
	public void setProjName(String projName) {
		this.projName = projName;
	}
	public String getLstcpstDt() {
		return lstcpstDt;
	}
	public void setLstcpstDt(String lstcpstDt) {
		this.lstcpstDt = lstcpstDt;
	}
}