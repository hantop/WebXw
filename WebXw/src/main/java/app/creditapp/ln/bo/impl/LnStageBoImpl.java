package  app.creditapp.ln.bo.impl;

import java.sql.CallableStatement;
import java.sql.Connection;

import app.base.BaseService;
import app.base.ServiceException;
import app.creditapp.ln.bo.LnStageBo;
import app.creditapp.ln.dao.LnStageDao;
import app.creditapp.ln.entity.LnStage;
import app.util.DBUtils;
import app.util.toolkit.Ipage;
/**
* Title: LnStageBoImplImpl.java
* Description:
**/
public class LnStageBoImpl extends BaseService implements LnStageBo {

	private LnStageDao lnStageDao;

	public void del(LnStage lnStage) throws ServiceException {
		try {
			lnStageDao.del(lnStage);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}

	public Ipage findByPage(Ipage ipg, LnStage lnStage)
			throws ServiceException {
		try {
			ipg.initPageCounts(new Integer[] { (Integer) lnStageDao
					.getCount(lnStage) });// ��ʼ����ҳ��
			lnStage.setStartNumAndEndNum (ipg);
			ipg.setResult(lnStageDao.findByPage(lnStage));
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return ipg;
	}

	public LnStage getById(LnStage lnStage) throws ServiceException {
		try {
			lnStage = lnStageDao.getById(lnStage);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return lnStage;
	}

	public void insert(LnStage lnStage) throws ServiceException {
		try {
			lnStageDao.insert(lnStage);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}

	public void update(LnStage lnStage) throws ServiceException {
		try {
			lnStageDao.update(lnStage);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}
	
	public void updatests(String appId,String columns,String value) throws ServiceException {
		Connection conn = null;
		CallableStatement proc = null;
		try {
			  conn = DBUtils.getConn();
			  //conn = DBUtil.getConnection(); // �������ý��в�����
			  // ���ô洢���̸���ln_stageҵ��׶α�
		      proc = conn.prepareCall("{ call PKG_LN_APPLY.PROC_UP_STAGE(?,?,?) }"); //���ô洢����
		      proc.setString(1, appId); //���õ�1�������������
		      proc.setString(2, columns); //���õ�2�������������
		      proc.setString(3, value); //���õ�3�������������
		      proc.execute(); // ִ��
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		} finally {
			DBUtils.closeConnection(conn);
			DBUtils.closeStatement(proc);
		}
	}

	public LnStageDao getLnStageDao() {
		return lnStageDao;
	}

	public void setLnStageDao(LnStageDao lnStageDao) {
		this.lnStageDao = lnStageDao;
	}
}