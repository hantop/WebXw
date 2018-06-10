package  app.creditapp.cif.bo.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import com.alibaba.fastjson.JSON;

import app.base.BaseService;
import app.base.ServiceException;
import app.creditapp.cif.bo.CifPersInfBo;
import app.creditapp.cif.dao.CifPersHisDao;
import app.creditapp.cif.dao.CifPersInfDao;
import app.creditapp.cif.entity.CifPersHis;
import app.creditapp.cif.entity.CifPersInf;
import app.creditapp.cif.entity.CifPersRelCore;
import app.creditapp.cif.entity.CifPersRelLine;
import app.creditapp.cred.entity.PcrpQueryInfo;
import app.util.DBUtils;
import app.util.toolkit.Ipage;
import oracle.jdbc.OracleTypes;
/**
* Title: CifPersBoImplImpl.java
* Description:
**/
public class CifPersInfBoImpl extends BaseService implements CifPersInfBo {

	private CifPersInfDao cifPersInfDao;
	private CifPersHisDao cifPersHisDao;
//	private CreditSelService creditSelResultInfoDao; //���ʲ�������ӿ�dao

	public void del(CifPersInf cifPersInf) throws ServiceException {
		try {
			cifPersInfDao.del(cifPersInf);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}

	public Ipage findByPage(Ipage ipg, CifPersInf cifPersInf)
			throws ServiceException {
		try {
			ipg.initPageCounts(new Integer[] { (Integer) cifPersInfDao
					.getCount(cifPersInf) });// ��ʼ����ҳ��
			cifPersInf.setStartNumAndEndNum (ipg);
			ipg.setResult(cifPersInfDao.findByPage(cifPersInf));
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return ipg;
	}

	public CifPersInf getById(CifPersInf cifPersInf) throws ServiceException {
		try {
			cifPersInf = cifPersInfDao.getById(cifPersInf);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return cifPersInf;
	}

	public void insert(CifPersInf cifPersInf) throws ServiceException {
		try {
			/**
			 * �����ͻ���Ϣ�Ŀͻ���������
			 */
			cifPersInf.setCifNo(cifPersInfDao.getKey());
			
			cifPersInfDao.insert(cifPersInf);
			
			/**
			 * �����ͻ���Ϣ��ͬʱ���Ѷ�Ӧ�Ŀͻ���Ϣ��ӵ���ʷ���У�������ʷ����
			 */
			//cifPersHisBo.insert(cifPersInf);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}

	public void update(CifPersInf cifPersInf) throws ServiceException {
		
		CifPersHis cifPersHis = new CifPersHis();
		String cifSeq = "";
		
		try {
			
			cifPersInfDao.update(cifPersInf);
			
			/**
			 * xiugai�ͻ���Ϣ��ͬʱ���Ѷ�Ӧ�Ŀͻ���Ϣ��ӵ���ʷ���У�������ʷ����
			 */
			BeanUtils.copyProperties(cifPersHis, cifPersInf);
			cifSeq = cifPersHisDao.getSeqKey();
			cifPersHis.setRecId(cifSeq);
			cifPersHisDao.insert(cifPersHis);
			
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}
	
	/**
	 * ���ʲ�ѯ���Ž������ ������
	 */
	public String getByCrp(PcrpQueryInfo pcrpQueryInfo) throws ServiceException {
		try {
			//������תjson
			String selBatchJson = JSON.toJSONString(pcrpQueryInfo);
			//���÷���˽ӿ�
			String selBatch = null;
//			String selBatch = creditSelResultInfoDao.analyticForOneOnLocal(selBatchJson);
		return selBatch;
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException(e.getMessage());
		}
	}
	

	@Override
	public List<CifPersRelCore> getCifPersRelCores(CifPersInf cifPers)
			throws ServiceException {
		List<CifPersRelCore> list = new ArrayList<CifPersRelCore>();
		Connection conn = null;
		CallableStatement proc = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConn();
			// conn = DBUtil.getConnection();
			proc = conn.prepareCall("{ call proc_getrel_core(?,?) }"); // ���ô洢����
			proc.setString(1, cifPers.getIdNo());// ���õ�һ�������������
			proc.registerOutParameter(2, OracleTypes.CURSOR);// �ڶ��������������,��VARCHAR���͵�
			// proc.registerOutParameter(2,
			// OracleTypes.CURSOR);//�ڶ��������������,���α����͵�
			proc.execute();// ִ��
			rs = (ResultSet)proc.getObject(2);
			while (rs != null && rs.next()) {
				CifPersRelCore crl = new CifPersRelCore();
				crl.setIdNo(rs.getString(1));
				crl.setCifName(rs.getString(2));
				crl.setRel(rs.getString(3));
				list.add(crl);
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		} finally {
			DBUtils.closeConnection(conn);
			DBUtils.closeStatement(proc);
			DBUtils.closeResultset(rs);
		}
		return list;
	}

	@Override
	public List<CifPersRelLine> getCifPersRelLines(CifPersInf cifPers)
			throws ServiceException {
		List<CifPersRelLine> list = new ArrayList<CifPersRelLine>();
		Connection conn = null;
		CallableStatement proc = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConn();
			// conn = DBUtil.getConnection();
			proc = conn.prepareCall("{ call proc_getrel_lines(?,?) }"); // ���ô洢����
			proc.setString(1, cifPers.getIdNo());// ���õ�һ�������������
			proc.registerOutParameter(2, OracleTypes.CURSOR);// �ڶ��������������,��VARCHAR���͵�
			// proc.registerOutParameter(2,
			// OracleTypes.CURSOR);//�ڶ��������������,���α����͵�
			proc.execute();// ִ��
			rs = (ResultSet)proc.getObject(2);
			while (rs != null && rs.next()) {
				CifPersRelLine crl = new CifPersRelLine();
				crl.setIdNo(rs.getString(1));
				crl.setCifName(rs.getString(2));
				crl.setRel(rs.getString(3));
				crl.setRelIdNo(rs.getString(4));
				crl.setRelCifName(rs.getString(5));
				list.add(crl);
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		} finally {
			DBUtils.closeConnection(conn);
			DBUtils.closeStatement(proc);
			DBUtils.closeResultset(rs);
		}
		return list;
	}

	public CifPersInfDao getCifPersInfDao() {
		return cifPersInfDao;
	}

	public void setCifPersInfDao(CifPersInfDao cifPersInfDao) {
		this.cifPersInfDao = cifPersInfDao;
	}
	
	public CifPersHisDao getCifPersHisDao() {
		return cifPersHisDao;
	}

	public void setCifPersHisDao(CifPersHisDao cifPersHisDao) {
		this.cifPersHisDao = cifPersHisDao;
	}

	

}