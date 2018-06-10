package  app.creditapp.ln.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import app.base.BaseIbatisDao;
import app.base.DAOException;
import app.creditapp.inf.entity.WsOut2005_1;
import app.creditapp.ln.dao.PreBatchDao;
import app.creditapp.ln.entity.PreBatch;
/**
* Title: PreBatchDaoImpl.java
* Description:
**/
public class PreBatchDaoImpl extends BaseIbatisDao implements PreBatchDao {

	public void del(PreBatch preBatch) throws DAOException {
		try {
			getSqlMapClientTemplate().delete("PreBatch.del", preBatch);
		} catch (Exception e) {
			log.error(e);
			throw new DAOException(e.getMessage());
		}
	}

	public List<PreBatch> findByPage(PreBatch preBatch) throws DAOException {
		List preBatchList = null;
		try {
			preBatchList = getSqlMapClientTemplate().queryForList(
					"PreBatch.findByPage", preBatch);
		} catch (Exception e) {
			log.error(e);
			throw new DAOException(e.getMessage());
		}
		return preBatchList;
	}

	public PreBatch getById(PreBatch preBatch) throws DAOException {
		try {
			preBatch = (PreBatch) getSqlMapClientTemplate()
					.queryForObject("PreBatch.getById", preBatch);
		} catch (Exception e) {
			log.error(e);
			throw new DAOException(e.getMessage());
		}
		return preBatch;
	}

	public int getCount(PreBatch preBatch) throws DAOException {
		int count = 0;
		try {
			count = (Integer) getSqlMapClientTemplate().queryForObject(
					"PreBatch.findPage.count", preBatch);
		} catch (Exception e) {
			log.error(e);
			throw new DAOException(e.getMessage());
		}
		return count;
	}

	public void insert(PreBatch preBatch) throws DAOException {
		try {
			getSqlMapClientTemplate().insert("PreBatch.insert",
					preBatch);
		} catch (Exception e) {
			log.error(e);
			throw new DAOException(e.getMessage());
		}

	}

	public void update(PreBatch preBatch) throws DAOException {
		try {
			getSqlMapClientTemplate().update("PreBatch.update",
					preBatch);
		} catch (Exception e) {
			log.error(e);
			throw new DAOException(e.getMessage());
		}
	}

	public void updateNum(PreBatch preBatch) throws DAOException {
		try {
			getSqlMapClientTemplate().update("PreBatch.updateNum",
					preBatch);
		} catch (Exception e) {
			log.error(e);
			throw new DAOException(e.getMessage());
		}
	}
	
	@Override
	public PreBatch getByPreApply(PreBatch preBatch) throws DAOException {
		try {
			preBatch = (PreBatch) getSqlMapClientTemplate()
					.queryForObject("PreBatch.getByPreApply", preBatch);
		} catch (Exception e) {
			log.error(e);
			throw new DAOException(e.getMessage());
		}
		return preBatch;
	}
	
	//�������ط����������������ӿ�ws2005ר�ã�����Ϊ��������
	public int getCountforlistWs(PreBatch preBatch) throws DAOException {
		int count = 0;
		try {
			count = (Integer) getSqlMapClientTemplate().queryForObject(
					"WsPreBatch.findPageforlistWs.count", preBatch);
		} catch (Exception e) {
			log.error(e);
			throw new DAOException("��ѯͳ��ʧ��");
		}
		return count;
	}
	//�ӿ�ws2005��ҳ�����������з�ҳ���ܣ���ʼ
	public List<WsOut2005_1> findByPageforlistWs(Map map) throws DAOException {
		List<WsOut2005_1> wsOut2005_1 = new ArrayList<WsOut2005_1>();
		try {	wsOut2005_1 = getSqlMapClientTemplate().queryForList(
				"WsPreBatch.findByPageforlistWs", map);
		} catch (Exception e) {
			log.error(e);
			throw new DAOException("��ҳ��ѯʧ��");
		}
		return wsOut2005_1;
	}
	
	public List<PreBatch> findByPage(Map map) throws DAOException {
		List<PreBatch> preBatchlist = null;
		try {
			preBatchlist = getSqlMapClientTemplate().queryForList(
					"PreBatch.findByPage", map);
		} catch (Exception e) {
			log.error(e);
			throw new DAOException("��ҳ��ѯʧ��");
		}
		return preBatchlist;
	}
}