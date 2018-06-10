package accounting.interf.loan;

import java.util.List;

import accounting.domain.sys.AfferentDomain;
import accounting.domain.fee.AcChrgLog;

public class GrantLoan extends AfferentDomain{
	private String authNo;			//��Ȩ���
	private String loanNo;			//��ݺ�
	private String traceNo;
	private int traceCnt;
	private double feeAmt;
	private List<AcChrgLog> acChrgLogList;
	

	/**��Ȩ���
	 * @return  authNo ��Ȩ���
	 */
	public String getAuthNo() {
		return authNo;
	}

	/**��Ȩ���
	 * @param authNo  ��Ȩ���
	 */
	public void setAuthNo(String authNo) {
		this.authNo = authNo;
	}
	/**
	 * ������
	 * @return ������
	 */
	public double getFeeAmt() {
		return feeAmt;
	}
	/**
	 * ������
	 * @param feeAmt
	 */
	public void setFeeAmt(double feeAmt) {
		this.feeAmt = feeAmt;
	}
	/**
	 * ������List
	 * @return ������List
	 */
	public List<AcChrgLog> getAcChrgLogList() {
		return acChrgLogList;
	}
	/**
	 * ������List
	 * @param acChrgLogList
	 */
	public void setAcChrgLogList(List<AcChrgLog> acChrgLogList) {
		this.acChrgLogList = acChrgLogList;
	}

	/**
	 * ��ݺ�
	 * @return ��ݺ�
	 */
	public String getLoanNo() {
		return loanNo;
	}
	/**
	 * ��ݺ�
	 * @param loanNo
	 */
	public void setLoanNo(String loanNo) {
		this.loanNo = loanNo;
	}

	public String getTraceNo() {
		return traceNo;
	}

	public void setTraceNo(String traceNo) {
		this.traceNo = traceNo;
	}

	public int getTraceCnt() {
		return traceCnt;
	}

	public void setTraceCnt(int traceCnt) {
		this.traceCnt = traceCnt;
	}
	
	
}
