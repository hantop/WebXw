package  app.creditapp.fund.bo.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.util.HashMap;
import java.util.List;

import app.base.BaseService;
import app.base.ServiceException;
import app.creditapp.fund.bo.FundBaseBo;
import app.creditapp.fund.dao.FundBaseDao;
import app.creditapp.fund.dao.FundDetailDao;
import app.creditapp.fund.entity.FundBase;
import app.creditapp.fund.entity.FundDetail;
import app.util.DBUtils;
import app.util.toolkit.Ipage;

/**
* Title: FundBaseBoImplImpl.java
* Description:
**/
public class FundBaseBoImpl extends BaseService implements FundBaseBo {

	private FundBaseDao fundBaseDao;
	private FundDetailDao fundDetailDao;

	public void del(FundBase fundBase) throws ServiceException {
		try {
			fundBaseDao.del(fundBase);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}

	
	public Ipage findByPage(Ipage ipg, FundBase fundBase)
			throws ServiceException {
		try {
			ipg.initPageCounts(new Integer[] { (Integer) fundBaseDao
					.getCount(fundBase) });// ��ʼ����ҳ��
			fundBase.setStartNumAndEndNum (ipg);
			ipg.setResult(fundBaseDao.findByPage(fundBase));
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return ipg;
	}

	public FundBase getById(FundBase fundBase) throws ServiceException {
		try {
			fundBase = fundBaseDao.getById(fundBase);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return fundBase;
	}

	public void insert(FundBase fundBase) throws ServiceException {
		try {
			fundBaseDao.insert(fundBase);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}

	public void update(FundBase fundBase) throws ServiceException {
		try {
			fundBaseDao.update(fundBase);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}
	//ת�ø���
	public void updateBytransts(FundBase fundBase) throws ServiceException {
		try {
			fundBaseDao.updateBytransts(fundBase);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}
	public int getCountunmatched(FundBase fundBase) throws ServiceException {
		 int count;
		try {
			count = fundBaseDao.getCountunmatched(fundBase);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return count;
	}
	
	public int getCountunmatcheds(FundBase fundBase) throws ServiceException {
		 int count;
		try {
			count = fundBaseDao.getCountunmatcheds(fundBase);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return count;
	}
	//�ʽ���������
	public int getFundRepayRemind(FundBase fundBase)throws ServiceException{
		int count;
		try {
			count = fundBaseDao.getFundRepayRemind(fundBase);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return count;
	}
//	public void insertadd() throws ServiceException {
//		try {
//			fundBaseDao.insertadd();
//		} catch (Exception e) {
//			throw new ServiceException(e.getMessage());
//		}
//	}
	
	public void proc_sync_fund_single(String txDate,String projNo,String mtxDate,String opNo,String flag){
		Connection conn = null;
		CallableStatement proc = null;
		try {
			  conn = DBUtils.getConn();
			  //conn = DBUtil.getConnection(); // �������ý��в�����
			  // ���ô洢���̸���ln_stageҵ��׶α�
		      proc = conn.prepareCall("{ call PKG_FUND.PROC_SYNC_FUND(?,?,?,?,?) }"); //���ô洢����
		      proc.setString(1, txDate); //���õ�1�������������
		      proc.setString(2, projNo);
		      proc.setString(3, mtxDate);
		      proc.setString(4, opNo);
		      proc.setString(5, flag);
		      proc.execute(); // ִ��
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeStatement(proc);
			DBUtils.closeConnection(conn);
		}
	}

	/**
	 * @���� DHCC-ZLC
	 * @���� 2016-6-29
	 * @����˵����
	 * @���ز���:
	 */
	public Ipage sync(Ipage ipg, FundBase fundBase)
	        throws ServiceException {
		Connection conn = null;
		CallableStatement proc = null;
        try {
        	  String mtxDate = fundBaseDao.getmaxtxDate(fundBase);
        	  conn = DBUtils.getConn();
  			  //conn = DBUtil.getConnection(); // �������ý��в�����
  			  // ���ô洢���̸���ln_stageҵ��׶α�
  		      proc = conn.prepareCall("{ call PKG_FUND.PROC_SYNC_FUND(?,?,?,?,?) }"); //���ô洢����
  		      proc.setString(1, fundBase.getTxDate()); //���õ�1�������������
  		      proc.setString(2, fundBase.getProjNo());
  		      proc.setString(3, mtxDate);
  		      proc.setString(4, fundBase.getOpNo());
  		      proc.setString(5, "1");
  		      proc.execute(); // ִ��
//        	    fundBaseDao.sync(paramMap);
    	    ipg.initPageCounts(new Integer[] { (Integer) fundBaseDao
					.getCount(fundBase) });// ��ʼ����ҳ��
			fundBase.setStartNumAndEndNum (ipg);
			ipg.setResult(fundBaseDao.findByPage(fundBase));
        }catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeStatement(proc);
			DBUtils.closeConnection(conn);
		}
             return ipg;
    }
	//�����ʽ�ͬ��
	public void syncSingle(FundBase fundBase) throws ServiceException {
		Connection conn = null;
		CallableStatement proc = null;
		try {

			conn = DBUtils.getConn();
			// conn = DBUtil.getConnection(); // �������ý��в�����
			// ���ô洢���̸���ln_stageҵ��׶α�
			proc = conn.prepareCall("{call PKG_FUND.PROC_SYNC_FUND_SINGLE(?,?,?,?,?,?)}"); // ���ô洢����
			proc.setString(1, fundBase.getTxDate()); // ���õ�1�������������
			proc.setString(2, fundBase.getProjNo());
			proc.setString(3, "10000101");
			proc.setString(4, fundBase.getOpNo());
			proc.setString(5, "1");
			proc.setString(6, fundBase.getFundNo());
			proc.execute(); // ִ��
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeStatement(proc);
			DBUtils.closeConnection(conn);
		}
	}

	// �����Զ�������
	public void reDeem(FundBase fundBase) throws ServiceException {
		try {
			 HashMap<String, String> paramMap = new HashMap<String, String>();
			 FundDetail fundDetail = new FundDetail();
			 fundDetail.setFundNo(fundBase.getFundNo());
			 fundDetail.setTxDate(fundBase.getTxDate());
			 //�鿴�ʽ��ֽ����Ƿ�������ʷ�Ҹ���ˮ
			 int count = fundDetailDao.findByhisfund(fundDetail);
     	    if(count > 0){
     	       paramMap.put("FUNDNO", fundBase.getFundNo());
         	   paramMap.put("PROJNO", fundBase.getProjNo());
         	   fundDetailDao.reDeem(paramMap);
     	    }

		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}	
	
	/**
	 * @���� DHCC-ZLC
	 * @���� 2016-8-25
	 * @����˵������ѯʧЧ���ʽ�
	 * @���ز��� List<FundBase>
	 */
	public  List<FundBase> findByFdflag(String op_no) throws ServiceException {
		List fundBaseList = null;
		try {
			FundBase fundbase = new FundBase();
			fundbase.setOpNo(op_no);
			fundBaseList = fundBaseDao.findByFdflag(fundbase);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return fundBaseList;
	}
	public FundBaseDao getFundBaseDao() {
		return fundBaseDao;
	}

	public void setFundBaseDao(FundBaseDao fundBaseDao) {
		this.fundBaseDao = fundBaseDao;
	}
	public FundDetailDao getFundDetailDao() {
		return fundDetailDao;
	}

	public void setFundDetailDao(FundDetailDao fundDetailDao) {
		this.fundDetailDao = fundDetailDao;
	}
}