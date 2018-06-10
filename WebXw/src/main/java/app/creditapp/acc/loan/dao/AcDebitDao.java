package  app.creditapp.acc.loan.dao;

import java.util.List;

import app.base.DAOException;
import app.creditapp.acc.loan.entity.AcDebit;
import app.creditapp.inf.entity.WsOut2305_1;
/**
* Title: AcDebitDao.java
* Description:
**/
public interface AcDebitDao {

	public AcDebit getById(AcDebit acDebit) throws DAOException;
	
	public AcDebit getByLoanNoIng(AcDebit acDebit) throws DAOException;

	public AcDebit getByDebitNo(AcDebit acDebit) throws DAOException;

	public void del(AcDebit acDebit) throws DAOException;
	
	public void delByLoanNoAndSts(AcDebit acDebit) throws DAOException;

	public void insert(AcDebit acDebit) throws DAOException;

	public void update(AcDebit acDebit) throws DAOException;
	
	public int getCount(AcDebit acDebit) throws DAOException;

	public List<AcDebit > findByPage(AcDebit acDebit) throws DAOException;
	
	public List<AcDebit > timDebit(AcDebit acDebit) throws DAOException;
	//��ȡ���������� 2305 ���
	public int getCountFor2305(AcDebit acDebit) throws DAOException;
	//�ӿ� 2305 ���ط���������list
	public List<WsOut2305_1> findByPageFor2305(AcDebit acDebit) throws DAOException;

}