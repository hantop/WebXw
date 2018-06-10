package  app.creditapp.fund.dao.impl;

import java.util.HashMap;
import java.util.List;
import app.base.BaseIbatisDao;
import app.base.DAOException;
import app.creditapp.fund.dao.FundDetailDao;
import app.creditapp.fund.entity.FundDetail;
/**
* Title: FundDetailDaoImpl.java
* Description:
**/
public class FundDetailDaoImpl extends BaseIbatisDao implements FundDetailDao {

	public void del(FundDetail fundDetail) throws DAOException {
		try {
			getSqlMapClientTemplate().delete("FundDetail.del", fundDetail);
		} catch (Exception e) {
			log.error(e);
			throw new DAOException(e.getMessage());
		}
	}

	public List<FundDetail> findByPage(FundDetail fundDetail) throws DAOException {
		List fundDetailList = null;
		try {
			fundDetailList = getSqlMapClientTemplate().queryForList(
					"FundDetail.findByPage", fundDetail);
		} catch (Exception e) {
			log.error(e);
			throw new DAOException(e.getMessage());
		}
		return fundDetailList;
	}

	public FundDetail getById(FundDetail fundDetail) throws DAOException {
		try {
			fundDetail = (FundDetail) getSqlMapClientTemplate()
					.queryForObject("FundDetail.getById", fundDetail);
		} catch (Exception e) {
			log.error(e);
			throw new DAOException(e.getMessage());
		}
		return fundDetail;
	}

	public int getCount(FundDetail fundDetail) throws DAOException {
		int count = 0;
		try {
			count = (Integer) getSqlMapClientTemplate().queryForObject(
					"FundDetail.findPage.count", fundDetail);
		} catch (Exception e) {
			log.error(e);
			throw new DAOException(e.getMessage());
		}
		return count;
	}

	public void insert(FundDetail fundDetail) throws DAOException {
		try {
			getSqlMapClientTemplate().insert("FundDetail.insert",
					fundDetail);
		} catch (Exception e) {
			log.error(e);
			throw new DAOException(e.getMessage());
		}

	}

	public void update(FundDetail fundDetail) throws DAOException {
		try {
			getSqlMapClientTemplate().update("FundDetail.update",
					fundDetail);
		} catch (Exception e) {
			log.error(e);
			throw new DAOException(e.getMessage());
		}
	}
	//�鿴�ʽ��ֽ����Ƿ�������ʷ�Ҹ���ˮ
	public int findByhisfund(FundDetail fundDetail) throws DAOException {
		int count = 0;
		try {
			count = (Integer) getSqlMapClientTemplate().queryForObject(
					"FundDetail.findByhisfundNo.count", fundDetail);
		} catch (Exception e) {
			log.error(e);
			throw new DAOException(e.getMessage());
		}
		return count;
	}
	//ͬ������
	public void reDeem(HashMap paramMap) throws DAOException {
		try {
			getSqlMapClientTemplate().queryForObject("FundDetail.redeem", paramMap);
		} catch (Exception e) {
			log.error(e);
			throw new DAOException(e.getMessage());
		}
	}
	//�����ʽ�μ���Ϣ���������䶯
	public void insert_after(FundDetail fundDetail) throws DAOException {
		try {
			getSqlMapClientTemplate().queryForObject("FundDetail.insert_after", fundDetail);
		} catch (Exception e) {
			log.error(e);
			throw new DAOException(e.getMessage());
		}
	}
	//��ѯһ���ڵĶҸ����
	public double getBalBytradeType(FundDetail fundDetail) throws DAOException {
		double bal = 0.00;
		try {
			bal = Double.parseDouble(getSqlMapClientTemplate().queryForObject("FundDetail.getBalBytradeType", fundDetail).toString());

		} catch (Exception e) {
			log.error(e);
			throw new DAOException(e.getMessage());
		}
		return bal;
	}
	//��ȡ��ϸ����������
	public String getMaxDate(FundDetail fundDetail) throws DAOException{
		String date = "";
		try {
			date = (String)getSqlMapClientTemplate().queryForObject(
					"FundDetail.getMaxDate" ,fundDetail);
		} catch (Exception e) {
			log.error(e);
			throw new DAOException(e.getMessage());
		}
		if("".equals(date)||date==null){
			date = "0";
		}
		return date;
	}
}