package  app.creditapp.inf.dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.SqlMapClientCallback;

import app.base.BaseIbatisDao;
import app.base.DAOException;
import app.creditapp.inf.dao.WsRepyClearDao;
import app.creditapp.inf.entity.WsIn2303;
import app.creditapp.inf.entity.WsIn2303_1;
import app.creditapp.inf.entity.WsIn2304;
import app.creditapp.inf.entity.WsOut2304;
import app.creditapp.inf.entity.WsRepyClear;

import com.ibatis.sqlmap.client.SqlMapExecutor;
/**
* Title: WsRepyClearDaoImpl.java
* Description:
**/
public class WsRepyClearDaoImpl extends BaseIbatisDao implements WsRepyClearDao {

	public void del(WsRepyClear wsRepyClear) throws DAOException {
		try {
			getSqlMapClientTemplate().delete("WsRepyClear.del", wsRepyClear);
		} catch (Exception e) {
			log.error(e);
			throw new DAOException(e.getMessage());
		}
	}

	public List<WsRepyClear> findByPage(Map map) throws DAOException {
		List wsRepyClearList = null;
		try {
			wsRepyClearList = getSqlMapClientTemplate().queryForList(
					"WsRepyClear.findByPage", map);
		} catch (Exception e) {
			log.error(e);
			throw new DAOException(e.getMessage());
		}
		return wsRepyClearList;
	}

	public WsRepyClear getById(WsRepyClear wsRepyClear) throws DAOException {
		try {
			wsRepyClear = (WsRepyClear) getSqlMapClientTemplate()
					.queryForObject("WsRepyClear.getById", wsRepyClear);
		} catch (Exception e) {
			log.error(e);
			throw new DAOException(e.getMessage());
		}
		return wsRepyClear;
	}
	
	public WsRepyClear getDealIngByPactno(WsRepyClear wsRepyClear) throws DAOException {
		try {
			wsRepyClear = (WsRepyClear) getSqlMapClientTemplate()
					.queryForObject("WsRepyClear.getDealIngByPactno", wsRepyClear);
		} catch (Exception e) {
			log.error(e);
			throw new DAOException(e.getMessage());
		}
		return wsRepyClear;
	}

	public int getCount(WsRepyClear wsRepyClear) throws DAOException {
		int count = 0;
		try {
			count = (Integer) getSqlMapClientTemplate().queryForObject(
					"WsRepyClear.findPage.count", wsRepyClear);
		} catch (Exception e) {
			log.error(e);
			throw new DAOException(e.getMessage());
		}
		return count;
	}
	
	
	//�ӿ�ws2304��ѯ���������ļ�¼��
	public int getCountforws3204(WsRepyClear wsRepyClear) throws DAOException {
		int count = 0;
		try {
			count = (Integer) getSqlMapClientTemplate().queryForObject(
					"WsRepyClear.countforws3204", wsRepyClear);
		} catch (Exception e) {
			log.error(e);
			throw new DAOException(e.getMessage());
		}
		return count;
	}

	public void insert(WsRepyClear wsRepyClear) throws DAOException {
		try {
			getSqlMapClientTemplate().insert("WsRepyClear.insert",
					wsRepyClear);
		} catch (Exception e) {
			log.error(e);
			throw new DAOException(e.getMessage());
		}

	}

	public void update(WsRepyClear wsRepyClear) throws DAOException {
		try {
			getSqlMapClientTemplate().update("WsRepyClear.update",
					wsRepyClear);
		} catch (Exception e) {
			log.error(e);
			throw new DAOException(e.getMessage());
		}
	}
	public void updateSts(WsRepyClear wsRepyClear) throws DAOException{
		try {
			getSqlMapClientTemplate().update("WsRepyClear.updateSts",
					wsRepyClear);
		} catch (Exception e) {
			log.error(e);
			throw new DAOException(e.getMessage());
		}
	}
//	//�ӿ�ws2303���ݿ���뷽��
//	public void insertforws2303(WsIn2303 wsIn2303) throws DAOException{
//		try {
//			getSqlMapClientTemplate().insert("WsRepyClearforws2303.insert",
//					wsIn2303);
//		} catch (Exception e) {
//			log.error(e);
//			throw new DAOException(e.getMessage());
//		}
//	}
	//�ӿ�ws2303���ݿ���뷽��(��20161101wt)
	@SuppressWarnings("unchecked")
	public void insertforws2303(final WsIn2303 wsIn2303) throws DAOException {
		getSqlMapClientTemplate().execute(new SqlMapClientCallback() {
			public Object doInSqlMapClient(SqlMapExecutor executor)
					throws SQLException {
				executor.startBatch();
				// ÿ���ύ�������
				final int batchSize = 50;
				int count = 0;
					// ������ʽ������Ϣ�м��
					executor.insert("WsRepyClearforws2303.insert", wsIn2303);
					// ������ʽ�����˻��м��
					if(wsIn2303.getListPayOver()== null || "".equals(wsIn2303.getListPayOver())){
					//  ��ǰ��������з�Ϣ��Ϣ
					}else{
					// ��ǰ������� ��Ϣ��Ϣ
						for (WsIn2303_1 wsIn2303_1 : wsIn2303.getListPayOver()) {
							wsIn2303_1.setBrNo(wsIn2303.getBrNo());
							wsIn2303_1.setPactNo(wsIn2303.getPactNo());
							wsIn2303_1.setWsId(wsIn2303.getWsId());
							executor.insert("WsIn2303_1.insert", wsIn2303_1);
						}
					}
					// ÿbatchSize�������ύһ��
					if (++count % batchSize == 0) {
						executor.executeBatch();
					}
				// �ύʣ�������
				executor.executeBatch();
				return null;
			}
		});

	}
	//�ӿ�ws2303�����ͬ���ظ�ɾ������
	public void delforws2303(WsRepyClear wsRepyClear) throws DAOException{
		
		try {
			getSqlMapClientTemplate().insert("WsRepyClearforws2303.del",
					wsRepyClear);
		} catch (Exception e) {
			log.error(e);
			throw new DAOException(e.getMessage());
		}
	}
	//�ӿ�ws2304 ���ݺ����ṹ�ţ���ͬ�ŷ��ؽ��ֵ
	public WsOut2304 getInfo(WsIn2304 wsIn2304) throws DAOException{
		WsOut2304 wsOut2304 = null;
		try {
			wsOut2304 = (WsOut2304) getSqlMapClientTemplate()
					.queryForObject("WsRepyClearforws2304.getById", wsIn2304);
		} catch (Exception e) {
			log.error(e);
			throw new DAOException(e.getMessage());
		}
		return wsOut2304;
	}
	//�ӿ�ws2304 ���ݺ����ṹ�ţ���ͬ�ŷ��ؽ��ֵ
	public WsOut2304 getInfoForNew(WsIn2304 wsIn2304) throws DAOException{
		WsOut2304 wsOut2304 = null;
		try {
			wsOut2304 = (WsOut2304) getSqlMapClientTemplate()
					.queryForObject("WsRepyClearforws2304.getByIdforNew", wsIn2304);
		} catch (Exception e) {
			log.error(e);
			throw new DAOException(e.getMessage());
		}
		return wsOut2304;
	}
}