package app.creditapp.acc.log.entity;
import app.base.BaseDomain;
/**
* Title: AcLnIntstLog.java
* Description:
* @version��1.0
**/
public class AcLnIntstLog extends BaseDomain {
	private Integer perdNo;//�ڴκ�
	private String loanNo;//��ݺ�
	private String traceNo;//��������ˮ��
	private String pactNo;//��ͬ��
	private String brNo;//������
	private Double normInt;//������Ϣ
	private Double lstFineInt;//ԭ��Ϣ
	private Double fineInt;//��Ϣ
	private String lstIntDt;//�ϴνᷣϢ����
	private String txDt;//��������
	private String loginid;//��¼��Ա
	private String brName;//��������-����ҳ����ʾ
	
	
	
	
	
	public String getLoginid() {
		return loginid;
	}
	public void setLoginid(String loginid) {
		this.loginid = loginid;
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
	 * @return ��������ˮ��
	 */
	public String getTraceNo() {
	 	return traceNo;
	}
	/**
	 * @���� ��������ˮ��
	 * @param traceNo
	 */
	public void setTraceNo(String traceNo) {
	 	this.traceNo = traceNo;
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
	 * @return ԭ��Ϣ
	 */
	public Double getLstFineInt() {
	 	return lstFineInt;
	}
	/**
	 * @���� ԭ��Ϣ
	 * @param lstFineInt
	 */
	public void setLstFineInt(Double lstFineInt) {
	 	this.lstFineInt = lstFineInt;
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
	 * @return �ϴνᷣϢ����
	 */
	public String getLstIntDt() {
	 	return lstIntDt;
	}
	/**
	 * @���� �ϴνᷣϢ����
	 * @param lstIntDt
	 */
	public void setLstIntDt(String lstIntDt) {
	 	this.lstIntDt = lstIntDt;
	}
	/**
	 * @return ��������
	 */
	public String getTxDt() {
	 	return txDt;
	}
	/**
	 * @���� ��������
	 * @param txDt
	 */
	public void setTxDt(String txDt) {
	 	this.txDt = txDt;
	}
	public String getBrName() {
		return brName;
	}
	public void setBrName(String brName) {
		this.brName = brName;
	}
}