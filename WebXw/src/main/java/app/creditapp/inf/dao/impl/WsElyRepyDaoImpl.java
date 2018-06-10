package  app.creditapp.inf.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.orm.ibatis.SqlMapClientCallback;

import com.ibatis.sqlmap.client.SqlMapExecutor;

import app.base.BaseIbatisDao;
import app.base.DAOException;
import app.creditapp.inf.dao.WsElyRepyDao;
import app.creditapp.inf.entity.WsElyRepy;

/**
* Title: WsElyRepyDaoImpl.java
* Description:
* @author:su
* 
**/
public class WsElyRepyDaoImpl extends BaseIbatisDao implements WsElyRepyDao {

	
	@Override
	public WsElyRepy getByBatchNo(WsElyRepy wsElyRepy) throws DAOException {
		try {
			wsElyRepy = (WsElyRepy) getSqlMapClientTemplate()
					.queryForObject("WsElyRepy.getByBatchNo", wsElyRepy);
		} catch (Exception e) {
			log.error(e);
			throw new DAOException(e.getMessage());
		}
		return wsElyRepy;
	}
	//���ݺ�ͬ��ɾ������ͬ��ͬ����
	public void delByPactNo(WsElyRepy wsElyRepy) throws DAOException {
		try {
			getSqlMapClientTemplate().delete("WsElyRepy.delByPactNo",wsElyRepy);
		} catch (Exception e) {
			log.error(e);
			throw new DAOException("ɾ��ʧ��");
		}
	}
	//����������ǰ����������ϸws2803
	@SuppressWarnings("unchecked")
	public void insertForList(final List<WsElyRepy> wsElyRepylist) throws DAOException {
		getSqlMapClientTemplate().execute(new SqlMapClientCallback() {
			public Object doInSqlMapClient(SqlMapExecutor executor) throws SQLException {
				executor.startBatch();
				// ÿ���ύ�������
				final int batchSize = 100;
				int count = 0;
				for (WsElyRepy wsElyRepy : wsElyRepylist) {
					// ���뻹��ƻ���Ϣ
					executor.insert("WsElyRepy.insert", wsElyRepy);
					// ÿbatchSize�������ύһ��
					if (++count % batchSize == 0) {
						executor.executeBatch();
					}
				}
				// �ύʣ�������
				executor.executeBatch();
				return null;
			}
		});
	}
	public List<WsElyRepy> findByPageForList(WsElyRepy wsElyRepy) throws DAOException {
		List wsElyRepyList = null;
		try {
			wsElyRepyList = getSqlMapClientTemplate().queryForList(
					"WsElyRepy.findByPageForList", wsElyRepy);
		} catch (Exception e) {
			log.error(e);
			throw new DAOException(e.getMessage());
		}
		return wsElyRepyList;
	}
	public int getCountforlist(WsElyRepy wsElyRepy) throws DAOException {
		int count = 0;
		try {
			count = (Integer) getSqlMapClientTemplate().queryForObject(
					"WsElyRepy.count", wsElyRepy);
		} catch (Exception e) {
			log.error(e);
			throw new DAOException(e.getMessage());
		}
		return count;
	}
	public void del(WsElyRepy wsElyRepy) throws DAOException {
		try {
			getSqlMapClientTemplate().delete("WsElyRepy.del", wsElyRepy);
		} catch (Exception e) {
			log.error(e);
			throw new DAOException(e.getMessage());
		}
	}

	public List<WsElyRepy> findByPage(WsElyRepy wsElyRepy) throws DAOException {
		List wsElyRepyList = null;
		try {
			wsElyRepyList = getSqlMapClientTemplate().queryForList(
					"WsElyRepy.findByPage", wsElyRepy);
		} catch (Exception e) {
			log.error(e);
			throw new DAOException(e.getMessage());
		}
		return wsElyRepyList;
	}

	public WsElyRepy getById(WsElyRepy wsElyRepy) throws DAOException {
		try {
			wsElyRepy = (WsElyRepy) getSqlMapClientTemplate()
					.queryForObject("WsElyRepy.getById", wsElyRepy);
		} catch (Exception e) {
			log.error(e);
			throw new DAOException(e.getMessage());
		}
		return wsElyRepy;
	}

	public int getCount(WsElyRepy wsElyRepy) throws DAOException {
		int count = 0;
		try {
			count = (Integer) getSqlMapClientTemplate().queryForObject(
					"WsElyRepy.findPage.count", wsElyRepy);
		} catch (Exception e) {
			log.error(e);
			throw new DAOException(e.getMessage());
		}
		return count;
	}

	public void insert(WsElyRepy wsElyRepy) throws DAOException {
		try {
			System.out.println("*************��ҳ���ȡ��ֵ��"+wsElyRepy.getBrNo());
			System.out.println("*************��ҳ���ȡ��ֵ��"+wsElyRepy.getPayTotal());
			getSqlMapClientTemplate().insert("WsElyRepy.insert",
					wsElyRepy);
		} catch (Exception e) {
			log.error(e);
			throw new DAOException(e.getMessage());
		}

	}

	public void update(WsElyRepy wsElyRepy) throws DAOException {
		try {
			getSqlMapClientTemplate().update("WsElyRepy.update",
					wsElyRepy);
		} catch (Exception e) {
			log.error(e);
			throw new DAOException(e.getMessage());
		}
	}
	
	@Override
	public void updateStsAndDesc(WsElyRepy wsElyRepy) throws DAOException {
		try {
			getSqlMapClientTemplate().update("WsElyRepy.updateStsAndDesc",
					wsElyRepy);
		} catch (Exception e) {
			log.error(e);
			throw new DAOException(e.getMessage());
		}
		
	}
}