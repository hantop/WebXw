package accounting.domain.loan;

/**
 * Title: AcLnRepayDtlSeq.java Description:
 * 
 * @version��1.0
 **/

public class AcLnRepayDtlSeq extends accounting.domain.sys.CMISDomain{
	private String repaySeqCde;// ����˳�����
	private int repaySeq;// �������
	private String repayAmtTyp;// ����������
	public String getRepaySeqCde() {
		return repaySeqCde;
	}
	public void setRepaySeqCde(String repaySeqCde) {
		this.repaySeqCde = repaySeqCde;
	}
	public int getRepaySeq() {
		return repaySeq;
	}
	public void setRepaySeq(int repaySeq) {
		this.repaySeq = repaySeq;
	}
	public String getRepayAmtTyp() {
		return repayAmtTyp;
	}
	public void setRepayAmtTyp(String repayAmtTyp) {
		this.repayAmtTyp = repayAmtTyp;
	}
}
