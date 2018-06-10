package  app.creditapp.acc.option.dao;

import java.util.List;

import app.base.DAOException;
import app.creditapp.acc.option.entity.AcLnRepayPln;
/**
* Title: AcLnRepayPlnDao.java
**/
public interface AcLnRepayPlnDao {

	public AcLnRepayPln getById(AcLnRepayPln acLnRepayPln) throws DAOException;
	
	//ȡ����ƻ�������perd_no
	public int getByIdMaxPerdNo(AcLnRepayPln acLnRepayPln) throws DAOException;

	public void del(AcLnRepayPln acLnRepayPln) throws DAOException;

	public void insert(AcLnRepayPln acLnRepayPln) throws DAOException;

	public void update(AcLnRepayPln acLnRepayPln) throws DAOException;
	
	public int getCount(AcLnRepayPln acLnRepayPln) throws DAOException;

	public List<AcLnRepayPln > findByPage(AcLnRepayPln acLnRepayPln) throws DAOException;
	//���ݺ�ͬ�ŷ��ض�Ӧ������
	public AcLnRepayPln getByIdforpact(AcLnRepayPln acLnRepayPln) throws DAOException;
	
	//��ȡ�����Ӧ�ձ�����Ϣ���ѻ������ѻ�������Ϣ
	public AcLnRepayPln getAllAmt(AcLnRepayPln acLnRepayPln) throws DAOException;
	public List<AcLnRepayPln> getListByLoanNo(AcLnRepayPln acLnRepayPln) throws DAOException;

	public AcLnRepayPln getByBrNoPactNoPerdNo(AcLnRepayPln acLnRepayPln) throws DAOException;

   

}