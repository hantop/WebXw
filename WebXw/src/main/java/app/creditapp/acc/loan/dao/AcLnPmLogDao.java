package  app.creditapp.acc.loan.dao;

import java.util.HashMap;
import java.util.List;
import app.base.DAOException;
import app.creditapp.acc.loan.entity.AcLnPmLog;
/**
* Title: AcLnPmLogDao.java
* Description:
**/
public interface AcLnPmLogDao {

	public AcLnPmLog getById(AcLnPmLog acLnPmLog) throws DAOException;

	public void del(AcLnPmLog acLnPmLog) throws DAOException;

	public void insert(AcLnPmLog acLnPmLog) throws DAOException;

	public void update(AcLnPmLog acLnPmLog) throws DAOException;
	
	public int getCount(AcLnPmLog acLnPmLog) throws DAOException;

	public List<AcLnPmLog > findByPage(AcLnPmLog acLnPmLog) throws DAOException;
	
	public List<AcLnPmLog > getPmLogByCompst(HashMap<String, String> map) throws DAOException;
	
	public AcLnPmLog getSumRepayByLoanNo(AcLnPmLog acLnPmLog) throws DAOException;
	
	public List<AcLnPmLog > getListByTraceNoAndLoanNo(AcLnPmLog acLnPmLog) throws DAOException;
	
	//�����ڴ�����ϸ�����ʽ�س����Ϣ
	public List<AcLnPmLog> procReaccFund(AcLnPmLog acLnPmLog) throws DAOException;

}