package app.creditapp.acc.loan.bo;

import app.base.ServiceException;
import app.creditapp.ln.entity.LnDue;

/**
 * 
 * 
 */
public interface LoanBo {

	// �ſ�
	public String grantLoan(LnDue lnDue)
			throws ServiceException;
	
	// �ſ�
		public String grantLoan(String brNo)throws ServiceException;
	
	// �ſ��
		public String grantLoanBack(String backLogNo,String backCnt,String backRes,String failCaus,String PayStatus,String cardChn)
				throws ServiceException;
	

}
