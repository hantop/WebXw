package  app.creditapp.fund.dao;

import java.util.HashMap;
import java.util.List;
import app.base.DAOException;
import app.creditapp.fund.entity.FundDetail;
/**
* Title: FundDetailDao.java
* Description:
**/
public interface FundDetailDao {

	public FundDetail getById(FundDetail fundDetail) throws DAOException;

	public void del(FundDetail fundDetail) throws DAOException;

	public void insert(FundDetail fundDetail) throws DAOException;
	//�����������������仯
	public void insert_after(FundDetail fundDetail) throws DAOException;

	public void update(FundDetail fundDetail) throws DAOException;
	
	public int getCount(FundDetail fundDetail) throws DAOException;

	public List<FundDetail > findByPage(FundDetail fundDetail) throws DAOException;
	//�鿴�ʽ��ֽ����Ƿ�������ʷ�Ҹ���ˮ
	public int findByhisfund(FundDetail fundDetail) throws DAOException;
	//�����Զ�����ӿ�
	public void reDeem(HashMap HashMap) throws DAOException;
	
	public double getBalBytradeType(FundDetail fundDetail) throws DAOException;
	
	//��ȡ��ϸ����������
	public String getMaxDate(FundDetail fundDetail) throws DAOException;
}