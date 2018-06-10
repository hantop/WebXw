package  app.creditapp.acc.loan.bo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import accounting.plat.core.AccountingException;
import app.base.ServiceException;
import app.creditapp.acc.loan.entity.AcDebitSusp;
import app.creditapp.acc.loan.entity.AcLoanBackLog;
import app.creditapp.inf.client.zf.Exception_Exception;
import app.creditapp.inf.entity.WsIn2102;
import app.creditapp.inf.entity.WsRepyClear;
import app.creditapp.inf.entity.WsRepyMes;
import app.util.toolkit.Ipage;

/**
* Title: AcDebitSuspBo.java
* Description:
**/
public interface AcDebitSuspBo {

	public AcDebitSusp getById(AcDebitSusp acDebitSusp) throws ServiceException;
	
	public List<WsRepyMes> getByBatch(String batchNo) throws ServiceException;
	
	public void del(AcDebitSusp acDebitSusp) throws ServiceException;

	public void insert(AcDebitSusp acDebitSusp) throws ServiceException;

	public void update(AcDebitSusp acDebitSusp) throws ServiceException;

	public Ipage findByPage(Ipage ipg, AcDebitSusp acDebitSusp) throws ServiceException;

	//�ۿ���ϸҵ���߼�
	public Map<String,String> validateAcDebitSusp(String acDebitSuspBatch) throws ServiceException;
	
	public  Map sendZfMes(List<AcLoanBackLog> acLoanBackLogList,String projNo,String txCde,Connection conn) throws AccountingException, Exception_Exception, IOException, SQLException, Exception ;
	
	//���ʿۿ��ѯ
	public  void querySingleMes(WsRepyMes wsRepyMes) throws AccountingException, Exception_Exception, IOException, SQLException ;

	public  void querySingleClear(WsRepyClear wsRepyClear) throws AccountingException, Exception_Exception, IOException, SQLException ;

	public  void querySingleLoan(WsIn2102 wsIn2102) throws AccountingException, Exception_Exception, IOException, SQLException ;
	
	public void queryReconciliation() throws ServiceException;

}