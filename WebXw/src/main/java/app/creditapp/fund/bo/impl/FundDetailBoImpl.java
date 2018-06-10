package  app.creditapp.fund.bo.impl;

import app.creditapp.fund.dao.FundBaseDao;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import app.base.BaseService;
import app.base.ServiceException;
import app.util.DBUtils;
import app.util.ruleFiter.entity.ValidateLog;
import app.util.ruleFiter.fiter.FiterEngineInterface;
import app.util.toolkit.Ipage;
import app.creditapp.fund.action.FundBaseAction;
import app.creditapp.fund.bo.FundDetailBo;
import app.creditapp.fund.dao.FundDetailDao;

import app.creditapp.fund.entity.FundBase;
import app.creditapp.fund.entity.FundDetail;
/**
* Title: FundDetailBoImplImpl.java
* Description:
**/
public class FundDetailBoImpl extends BaseService implements FundDetailBo {

	private FundDetailDao fundDetailDao;
	private FiterEngineInterface fiterEngineInterface;
    private FundBaseDao fundBaseDao;
	public void del(FundDetail fundDetail) throws ServiceException {
		try {
			fundDetailDao.del(fundDetail);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}

	public Ipage findByPage(Ipage ipg, FundDetail fundDetail)
			throws ServiceException {
		try {
			ipg.initPageCounts(new Integer[] { (Integer) fundDetailDao
					.getCount(fundDetail) });// ��ʼ����ҳ��
			fundDetail.setStartNumAndEndNum (ipg);
			ipg.setResult(fundDetailDao.findByPage(fundDetail));
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return ipg;
	}
	
	public FundDetail getById(FundDetail fundDetail) throws ServiceException {
		try {
			fundDetail = fundDetailDao.getById(fundDetail);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return fundDetail;
	}

	public void insert(FundDetail fundDetail) throws ServiceException {
		try {
			//1.�����ʽ���ϸ���μ���Ϣ��
			fundDetailDao.insert(fundDetail);
			//2.�޸��ʽ���Ϣ�дμ��ʽ�
			//3.�޸ķ��䷽��
			//4.�޸ķ��䷽������
			//5.�޸ķ��䷽����ϸ
			//6.�޸ĶҸ��ƻ�
			//�ڴ��������д���
			//xbb�޸�
			//1.�����ʽ���ϸ��ͬʱ��������Ϣ���ʽ��ܶ��Լ��ʽ����ֽ�������
			//insert_up(fundDetail);
			FundBase fundBase=new FundBase();
			//��fdAmt��ֵ
			fundBase.setFdAmt(fundDetail.getTxAmt());
			//��fundNo��ֵ
			fundBase.setFundNo(fundDetail.getFundNo());
			fundBaseDao.updateCash(fundBase); 
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}
	public double getBalBytradeType(FundDetail fundDetail) throws ServiceException {
		Double bal = 0.00;
		try {
			bal = fundDetailDao.getBalBytradeType(fundDetail);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return bal;
	}
	public void update(FundDetail fundDetail) throws ServiceException {
		try {
			fundDetailDao.update(fundDetail);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}
	public void insert_only(FundDetail fundDetail) throws ServiceException {
		try {
			fundDetailDao.insert(fundDetail);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}
	// ���ô洢���̸���������������ʽ���ϸ��Ӱ��
	public void insert_up(FundDetail fundDetail) throws ServiceException {
		Connection conn = null;
		CallableStatement proc = null;
		try {
			conn = DBUtils.getConn();
			// ���ô洢���̸��²�����ϸ��Ӱ��
			proc = conn.prepareCall("{call PKG_FUND.PROC_FUND_DETAIL_UPDATE(?,?,?,?,?)}"); // ���ô洢����
			proc.setString(1, fundDetail.getFundNo()); // ���õ�1�������������
			proc.setString(2, fundDetail.getTradeType());
			proc.setDouble(3, fundDetail.getTxAmt());
			proc.setString(4, fundDetail.getTxDate());
			proc.setString(5, fundDetail.getOpNo());
			proc.execute(); // ִ��
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeStatement(proc);
			DBUtils.closeConnection(conn);
		}
	}
	//�жϸ��ʽ��Ƿ���ڸô������
	public boolean isExatis(String termNo, String fundNo) throws ServiceException {
		Connection conn = null;
	//	CallableStatement proc = null;
		PreparedStatement psta = null;
		boolean val = false;
		try {
			conn = DBUtils.getConn();
			String sql = "SELECT TERM_NO FROM fund_split_term a," +
					"fund_split b where a.part_no = b.part_no and a.term_amt>0 " +
					"and a.end_date = b.end_date and a.fund_no = ?"; // sql��ѯ���
			psta = conn.prepareStatement(sql);
			psta.setString(1, fundNo); // �����������
			ResultSet rs = psta.executeQuery(); // ִ��
			while(rs.next()){
				if(termNo.equals(rs.getString(1))){
					val = true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeStatement(psta);
			DBUtils.closeConnection(conn);
		}
		return val;
	}
	//��ȡ��ϸ����������
	public String getMaxDate(FundDetail fundDetail) throws ServiceException{
		String date = "";
		try {
			date = fundDetailDao.getMaxDate(fundDetail);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return date;
	}	
	//����У�����У���ʽ���ϸ��Ϣ
	public String validate(FundDetail fundDetail) throws ServiceException{
		String val = null;
		ValidateLog _vl = null;
		try{
			_vl = fiterEngineInterface.createValidateLog("fundDetail",fundDetail, true);
		}catch(Exception e){
			e.printStackTrace();
		}
		val = _vl.getErrorMessage();
		return val;
	}
	public FundDetailDao getFundDetailDao() {
		return fundDetailDao;
	}

	public void setFundDetailDao(FundDetailDao fundDetailDao) {
		this.fundDetailDao = fundDetailDao;
	}

	public FiterEngineInterface getFiterEngineInterface() {
		return fiterEngineInterface;
	}

	public void setFiterEngineInterface(FiterEngineInterface fiterEngineInterface) {
		this.fiterEngineInterface = fiterEngineInterface;
	}

	public FundBaseDao getFundBaseDao() {
		return fundBaseDao;
	}

	public void setFundBaseDao(FundBaseDao fundBaseDao) {
		this.fundBaseDao = fundBaseDao;
	}
	
}