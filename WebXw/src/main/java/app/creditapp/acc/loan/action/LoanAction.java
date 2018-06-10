package app.creditapp.acc.loan.action;

import org.apache.struts2.ServletActionContext;

import accounting.domain.auth.AcLnAuth;
import accounting.plat.PUBConstant;
import app.creditapp.acc.loan.bo.AcLoanBackLogBo;
import app.creditapp.acc.loan.bo.LoanBo;
import app.creditapp.ln.bo.LnDueBo;
import app.creditapp.ln.entity.LnDue;

import com.core.service.screen.FormService;
import com.core.struts.ActionContext;
import com.core.struts.BaseFormBean;

/**
 * ����ſ�Action
 * 
 */
public class LoanAction extends BaseFormBean {

	private AcLnAuth acLnAuth;

	// ��������
	private LoanBo loanBo;
	private LnDueBo lnDueBo;
	private AcLoanBackLogBo acLoanBackLogBo;

	private String authNo;
	private String loanNo;
	private String typ;
	private String query;
	private String view;
	private FormService formService = new FormService();

	/**
	 * �����Ĺ��췽��
	 */
	public LoanAction() {
		query = "";
		view = "";
	}

	/**
	 * �ſ�
	 * 
	 * @return
	 */
	public String grantLoan() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),	ServletActionContext.getResponse());
		LnDue lnDue = new LnDue();
		lnDue.setDueNo("10000000046339");
		lnDue = lnDueBo.getById(lnDue);
		String msg = loanBo.grantLoan(lnDue);
		if (msg != null) {
			this.addActionError(msg);
			return INPUT;
		}
		this.addActionMessage("�ſ�ɹ���");
		query = "query";
		return SUCCESS;
	}
//	/**
//	 * �ſ��
//	 * 
//	 * @return
//	 */
//	public String grantLoanBack() throws Exception {
//		ActionContext.initialize(ServletActionContext.getRequest(),	ServletActionContext.getResponse());
//		AcLoanBackLog acLoanBackLog = new AcLoanBackLog();
//		acLoanBackLog.setBackLogNo("10000000007");
//		acLoanBackLog.setLoanLogNo("1000000297");
//		acLoanBackLog.setBackType(PUBConstant.BACK_STS_01);
//		acLoanBackLog.setBackRes("01");
//		acLoanBackLog.setBackSts("01");
//		String msg = loanBo.grantLoanBack(acLoanBackLog);
//		if (msg != null) {
//			this.addActionError(msg);
//			return INPUT;
//		}
//		this.addActionMessage("������֧����Ϣ���ճɹ���");
//		query = "query";
//		return SUCCESS;
//	}
	public void validateGrantLoan() {
		ActionContext.initialize(ServletActionContext.getRequest(),
				ServletActionContext.getResponse());
	}

	

	public AcLnAuth getAcLnAuth() {
		return acLnAuth;
	}
	public void setAcLnAuth(AcLnAuth acLnAuth) {
		this.acLnAuth = acLnAuth;
	}
	public LoanBo getLoanBo() {
		return loanBo;
	}
	public void setLoanBo(LoanBo loanBo) {
		this.loanBo = loanBo;
	}
	public String getAuthNo() {
		return authNo;
	}
	public void setAuthNo(String authNo) {
		this.authNo = authNo;
	}
	public String getLoanNo() {
		return loanNo;
	}
	public void setLoanNo(String loanNo) {
		this.loanNo = loanNo;
	}
	public String getTyp() {
		return typ;
	}
	public void setTyp(String typ) {
		this.typ = typ;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public String getView() {
		return view;
	}
	public void setView(String view) {
		this.view = view;
	}

	public LnDueBo getLnDueBo() {
		return lnDueBo;
	}

	public void setLnDueBo(LnDueBo lnDueBo) {
		this.lnDueBo = lnDueBo;
	}

	public AcLoanBackLogBo getAcLoanBackLogBo() {
		return acLoanBackLogBo;
	}

	public void setAcLoanBackLogBo(AcLoanBackLogBo acLoanBackLogBo) {
		this.acLoanBackLogBo = acLoanBackLogBo;
	}
}
