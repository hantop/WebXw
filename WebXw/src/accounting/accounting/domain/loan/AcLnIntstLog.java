package accounting.domain.loan;
/**
* Title: AcLnIntstLog.java
* Description:
* @version��1.0
**/
public class AcLnIntstLog extends accounting.domain.sys.CMISDomain {
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
	
	
	
	public Integer getPerdNo() {
		return perdNo;
	}
	public String getLoanNo() {
		return loanNo;
	}
	public String getTraceNo() {
		return traceNo;
	}
	public String getPactNo() {
		return pactNo;
	}
	public String getBrNo() {
		return brNo;
	}
	public Double getNormInt() {
		return normInt;
	}
	public Double getLstFineInt() {
		return lstFineInt;
	}
	public Double getFineInt() {
		return fineInt;
	}
	public String getLstIntDt() {
		return lstIntDt;
	}
	public String getTxDt() {
		return txDt;
	}
	public void setPerdNo(Integer perdNo) {
		this.perdNo = perdNo;
	}
	public void setLoanNo(String loanNo) {
		this.loanNo = loanNo;
	}
	public void setTraceNo(String traceNo) {
		this.traceNo = traceNo;
	}
	public void setPactNo(String pactNo) {
		this.pactNo = pactNo;
	}
	public void setBrNo(String brNo) {
		this.brNo = brNo;
	}
	public void setNormInt(Double normInt) {
		this.normInt = normInt;
	}
	public void setLstFineInt(Double lstFineInt) {
		this.lstFineInt = lstFineInt;
	}
	public void setFineInt(Double fineInt) {
		this.fineInt = fineInt;
	}
	public void setLstIntDt(String lstIntDt) {
		this.lstIntDt = lstIntDt;
	}
	public void setTxDt(String txDt) {
		this.txDt = txDt;
	}
	
}