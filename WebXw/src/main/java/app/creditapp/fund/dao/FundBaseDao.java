package  app.creditapp.fund.dao;

import java.util.HashMap;
import java.util.List;
import app.base.DAOException;
import app.creditapp.fund.entity.FundBase;
/**
* Title: FundBaseDao.java
* Description:
**/
public interface FundBaseDao {

	public FundBase getById(FundBase fundBase) throws DAOException;

	public void del(FundBase fundBase) throws DAOException;

	public void insert(FundBase fundBase) throws DAOException;

	public void update(FundBase fundBase) throws DAOException;
	//ת�ø���
	public void updateBytransts(FundBase fundBase) throws DAOException;
	
	public int getCount(FundBase fundBase) throws DAOException;
	//��ȡ�����Ϲ涨������
	public int getCountunmatched(FundBase fundBase) throws DAOException;
	
//	public void insertadd() throws DAOException;
	
	//��ȡ�����Ϲ涨������
	public int getCountunmatcheds(FundBase fundBase) throws DAOException;
	//�ʽ���������
	public int getFundRepayRemind(FundBase fundBase) throws DAOException;
	
	public String getmaxtxDate(FundBase fundBase) throws DAOException;
	
	public String getmaxtxDateSingle(FundBase fundBase) throws DAOException ;

	public List<FundBase > findByPage(FundBase fundBase) throws DAOException;
	
	public List<FundBase > echarts(FundBase fundBase) throws DAOException;
    //��ȡ���ʽ����ʻ��֣���ȡ�ʽ��ģ
	public Double getByfdTypeCount(FundBase fundBase) throws DAOException;
    //��ȡ���ʽ����ʻ��֣���ȡ�ֽ��ģ
	public Double getByfdTypeCashbal(FundBase fundBase) throws DAOException;
	//ͬ������
	public void sync(HashMap HashMap) throws DAOException;
	//ͬ�������ʽ�
	public void syncSingle(HashMap HashMap) throws DAOException;
	//��ѯʧЧ���ʽ�
	public List<FundBase> findByFdflag(FundBase fundBase) throws DAOException;

	public void updateCash(FundBase fundBase) throws DAOException;
}