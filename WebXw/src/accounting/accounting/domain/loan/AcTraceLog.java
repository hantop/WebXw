package accounting.domain.loan;
/**
* Title: AcTraceLog.java
* Description:
* @作者 su
* @日期 2018-3-20
* @version：1.0
**/
public class AcTraceLog extends accounting.domain.sys.CMISDomain {
	private Integer traceCnt;//流水笔次
	private String traceNo;//主机流水号
	private String txDt;//交易日期
	private String txTime;//交易时间
	private String txBrNo;//交易机构号
	private String txCde;//交易代码
	private String subTxCde;//子交易代码
	private String svcInd;//处理代码
	private String curNo;//币种
	private String prdtNo;//核算编号
	private String loanNo;//借据号
	private String pactNo;//合同号
	private String brNo;//机构号
	private String addInd;//增减标志
	private String ctInd;//转账标志
	private Double amt;//发生额
	private String hstInd;//是否已经入明细
	private String cancelInd;//冲账标志
	private Integer ejfno;//柜员流水号
	private Integer ptTraceNo;//平台流水号
	private String memo;//摘要
	private String cancelTraceNo;//冲账流水号
	
	/**
	 * @return 流水笔次
	 */
	public Integer getTraceCnt() {
	 	return traceCnt;
	}
	/**
	 * @设置 流水笔次
	 * @param traceCnt
	 */
	public void setTraceCnt(Integer traceCnt) {
	 	this.traceCnt = traceCnt;
	}
	/**
	 * @return 主机流水号
	 */
	public String getTraceNo() {
	 	return traceNo;
	}
	/**
	 * @设置 主机流水号
	 * @param traceNo
	 */
	public void setTraceNo(String traceNo) {
	 	this.traceNo = traceNo;
	}
	/**
	 * @return 交易日期
	 */
	public String getTxDt() {
	 	return txDt;
	}
	/**
	 * @设置 交易日期
	 * @param txDt
	 */
	public void setTxDt(String txDt) {
	 	this.txDt = txDt;
	}
	/**
	 * @return 交易时间
	 */
	public String getTxTime() {
	 	return txTime;
	}
	/**
	 * @设置 交易时间
	 * @param txTime
	 */
	public void setTxTime(String txTime) {
	 	this.txTime = txTime;
	}
	/**
	 * @return 交易机构号
	 */
	public String getTxBrNo() {
	 	return txBrNo;
	}
	/**
	 * @设置 交易机构号
	 * @param txBrNo
	 */
	public void setTxBrNo(String txBrNo) {
	 	this.txBrNo = txBrNo;
	}
	/**
	 * @return 交易代码
	 */
	public String getTxCde() {
	 	return txCde;
	}
	/**
	 * @设置 交易代码
	 * @param txCde
	 */
	public void setTxCde(String txCde) {
	 	this.txCde = txCde;
	}
	/**
	 * @return 子交易代码
	 */
	public String getSubTxCde() {
	 	return subTxCde;
	}
	/**
	 * @设置 子交易代码
	 * @param subTxCde
	 */
	public void setSubTxCde(String subTxCde) {
	 	this.subTxCde = subTxCde;
	}
	/**
	 * @return 处理代码
	 */
	public String getSvcInd() {
	 	return svcInd;
	}
	/**
	 * @设置 处理代码
	 * @param svcInd
	 */
	public void setSvcInd(String svcInd) {
	 	this.svcInd = svcInd;
	}
	/**
	 * @return 币种
	 */
	public String getCurNo() {
	 	return curNo;
	}
	/**
	 * @设置 币种
	 * @param curNo
	 */
	public void setCurNo(String curNo) {
	 	this.curNo = curNo;
	}
	/**
	 * @return 核算编号
	 */
	public String getPrdtNo() {
	 	return prdtNo;
	}
	/**
	 * @设置 核算编号
	 * @param prdtNo
	 */
	public void setPrdtNo(String prdtNo) {
	 	this.prdtNo = prdtNo;
	}
	/**
	 * @return 借据号
	 */
	public String getLoanNo() {
	 	return loanNo;
	}
	/**
	 * @设置 借据号
	 * @param loanNo
	 */
	public void setLoanNo(String loanNo) {
	 	this.loanNo = loanNo;
	}
	/**
	 * @return 增减标志
	 */
	public String getAddInd() {
	 	return addInd;
	}
	/**
	 * @设置 增减标志
	 * @param addInd
	 */
	public void setAddInd(String addInd) {
	 	this.addInd = addInd;
	}
	/**
	 * @return 发生额
	 */
	public Double getAmt() {
	 	return amt;
	}
	/**
	 * @设置 发生额
	 * @param amt
	 */
	public void setAmt(Double amt) {
	 	this.amt = amt;
	}
	/**
	 * @return 是否已经入明细
	 */
	public String getHstInd() {
	 	return hstInd;
	}
	/**
	 * @设置 是否已经入明细
	 * @param hstInd
	 */
	public void setHstInd(String hstInd) {
	 	this.hstInd = hstInd;
	}
	/**
	 * @return 冲账标志
	 */
	public String getCancelInd() {
	 	return cancelInd;
	}
	/**
	 * @设置 冲账标志
	 * @param cancelInd
	 */
	public void setCancelInd(String cancelInd) {
	 	this.cancelInd = cancelInd;
	}
	/**
	 * @return 柜员流水号
	 */
	public Integer getEjfno() {
	 	return ejfno;
	}
	/**
	 * @设置 柜员流水号
	 * @param ejfno
	 */
	public void setEjfno(Integer ejfno) {
	 	this.ejfno = ejfno;
	}
	/**
	 * @return 平台流水号
	 */
	public Integer getPtTraceNo() {
	 	return ptTraceNo;
	}
	/**
	 * @设置 平台流水号
	 * @param ptTraceNo
	 */
	public void setPtTraceNo(Integer ptTraceNo) {
	 	this.ptTraceNo = ptTraceNo;
	}
	/**
	 * @return 摘要
	 */
	public String getMemo() {
	 	return memo;
	}
	/**
	 * @设置 摘要
	 * @param memo
	 */
	public void setMemo(String memo) {
	 	this.memo = memo;
	}
	/**
	 * @return 冲账流水号
	 */
	public String getCancelTraceNo() {
	 	return cancelTraceNo;
	}
	/**
	 * @设置 冲账流水号
	 * @param cancelTraceNo
	 */
	public void setCancelTraceNo(String cancelTraceNo) {
	 	this.cancelTraceNo = cancelTraceNo;
	}
	public String getCtInd() {
		return ctInd;
	}
	public void setCtInd(String ctInd) {
		this.ctInd = ctInd;
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
	
}