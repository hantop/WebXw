package  app.creditapp.acc.loan.dao;

import java.util.List;
import app.base.DAOException;
import app.creditapp.acc.loan.entity.AcLoanLog;
/**
* Title: AcLoanLogDao.java
* Description:
**/
public interface AcLoanLogDao {

	public AcLoanLog getById(AcLoanLog acLoanLog) throws DAOException;

	/**
	 * 
	 * @���� DHCC-LIUJ
	 * @���� 2016-9-5
	 * @����	���ݷſ��˺Ų�ѯ�ſ���־�гɹ���Ϣ
	 */
	public AcLoanLog getSuccessByAcno(AcLoanLog acLoanLog) throws DAOException;

	public void del(AcLoanLog acLoanLog) throws DAOException;

	public void insert(AcLoanLog acLoanLog) throws DAOException;

	public void update(AcLoanLog acLoanLog) throws DAOException;
	
	public int getCount(AcLoanLog acLoanLog) throws DAOException;

	public List<AcLoanLog > findByPage(AcLoanLog acLoanLog) throws DAOException;

	/**
	 * 
	 * @���� DHCC-LIUJ
	 * @���� 2016-8-22
	 * @����	���ݷſ��˺ż���ݺŲ�ѯ�����л�ſ�ɹ�����
	 */
	public List<AcLoanLog > getListByAcnoAndLoanno(AcLoanLog acLoanLog) throws DAOException;

	public List<AcLoanLog > getListByTraceNo(AcLoanLog acLoanLog) throws DAOException;

}