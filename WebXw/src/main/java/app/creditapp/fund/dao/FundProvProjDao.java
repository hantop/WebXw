package  app.creditapp.fund.dao;

import java.util.List;
import app.base.DAOException;
import app.creditapp.fund.entity.FundProvProj;
import app.creditapp.bat.entity.RptPrdtDaily;
/**
* Title: FundProvProjDao.java
* Description:
**/
public interface FundProvProjDao {

	public FundProvProj getById(FundProvProj fundProvProj) throws DAOException;

	public void del(FundProvProj fundProvProj) throws DAOException;

	public void insert(FundProvProj fundProvProj) throws DAOException;

	public void update(FundProvProj fundProvProj) throws DAOException;
	
	public int getCount(FundProvProj fundProvProj) throws DAOException;

	public List<FundProvProj > findByPage(FundProvProj fundProvProj) throws DAOException;
	//��ȡ��Ŀ��Ӧ�ۼƷŴ���
	public List<RptPrdtDaily > RptRrdtDailygetByPrdtNoamt(RptPrdtDaily rptPrdtDaily) throws DAOException;
	//ʱ����ڲ�ͬ��Ʒ���ۼƷŴ����
	public List<RptPrdtDaily > RptRrdtDailygetByprdtno(RptPrdtDaily rptPrdtDaily) throws DAOException;

	public double RptRrdtDailygetByProjNoamt(RptPrdtDaily rptPrdtDaily) throws DAOException;
	
	public RptPrdtDaily RptRrdtDailygetBymaxDate(RptPrdtDaily rptPrdtDaily) throws DAOException;
	//��ȡprovProjNo
	public String getProvProjNo() throws DAOException;
	
	public String getProjNameByProjNo(String projNo) throws DAOException;

	public List<FundProvProj> findAll(FundProvProj fundProvProj) throws DAOException;
}