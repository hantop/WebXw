package app.creditapp.inf.dao.impl;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.SqlMapClientCallback;

import app.base.BaseIbatisDao;
import app.base.DAOException;
import app.base.ServiceException;
import app.creditapp.inf.dao.WsRepyMesDao;
import app.creditapp.inf.entity.WsOut2302_1;
import app.creditapp.inf.entity.WsRepyMes;
import app.creditapp.inf.entity.WsRepyMes_Count;

import com.ibatis.sqlmap.client.SqlMapExecutor;
public class WsRepyMesDaoImpl extends BaseIbatisDao implements WsRepyMesDao {
		public void delete(WsRepyMes wsRepyMes) throws DAOException {
			try {
				getSqlMapClientTemplate().delete("WsRepyMes.del",wsRepyMes);
			} catch (Exception e) {
				log.error(e);
				throw new DAOException("ɾ��ʧ��");
			}
		}

		@SuppressWarnings("unchecked")
		public List<WsRepyMes> findByPage(Map map) throws DAOException {
			List<WsRepyMes> wsRepyMeslist = null;
			try {
				wsRepyMeslist = getSqlMapClientTemplate().queryForList(
						"WsRepyMes.findByPage", map);
			} catch (Exception e) {
				log.error(e);
				throw new DAOException("��ҳ��ѯʧ��");
			}
			return wsRepyMeslist;
		}
		/*//�ӿ�ws2302��ҳ����
		public List<WsRepyMes> findByPage(Map map) throws DAOException {
			List<WsRepyMes> wsRepyMeslist = null;
			try {
				wsRepyMeslist = getSqlMapClientTemplate().queryForList(
						"WsRepyMes.findByPage", map);
			} catch (Exception e) {
				log.error(e);
				throw new DAOException("��ҳ��ѯʧ��");
			}
			return wsRepyMeslist;
		}*/
		
		@SuppressWarnings("unchecked")
		public List<WsRepyMes> findByAll(Map map) throws DAOException {
			List<WsRepyMes> wsRepyMeslist = null;
			try {
				wsRepyMeslist = getSqlMapClientTemplate().queryForList(
						"WsRepyMes.findByAll", map);
			} catch (Exception e) {
				log.error(e);
				throw new DAOException("��ѯȫ��ʧ��");
			}
			return wsRepyMeslist;
		}

		public WsRepyMes getById(WsRepyMes wsRepyMes) throws DAOException {
			try {
				wsRepyMes = (WsRepyMes) getSqlMapClientTemplate().queryForObject(
						"WsRepyMes.getById", wsRepyMes);
			} catch (Exception e) {
				log.error(e);
				throw new DAOException("��ѯʧ��");
			}
			return wsRepyMes;
		}
		
		public WsOut2302_1 getByIdForNew(WsRepyMes wsRepyMes) throws DAOException {
			WsOut2302_1 wsOut2302_1 = new WsOut2302_1();
			try {
				wsOut2302_1 = (WsOut2302_1) getSqlMapClientTemplate().queryForObject(
						"WsRepyMes.getIdForNew", wsRepyMes);
			} catch (Exception e) {
				log.error(e);
				throw new DAOException("��ѯʧ��");
			}
			return wsOut2302_1;
		}
		
		public int getCount(WsRepyMes wsRepyMes) throws DAOException {
			int count = 0;
			try {
				count = (Integer) getSqlMapClientTemplate().queryForObject(
						"WsRepyMes.findPage.count", wsRepyMes);
			} catch (Exception e) {
				log.error(e);
				throw new DAOException("��ѯͳ��ʧ��");
			}
			return count;
		}

		public String insert(WsRepyMes wsRepyMes) throws DAOException {
			String sid = "";
			try {
				sid = (String)getSqlMapClientTemplate().insert("WsRepyMes.insert", wsRepyMes);
			} catch (Exception e) {
				log.error(e);
				throw new DAOException("����ʧ��");
			}
			return sid;
		}
		
		@SuppressWarnings("unchecked")
		public void insertBatch(final List<WsRepyMes> wsRepyMesList) throws DAOException {
			getSqlMapClientTemplate().execute(new SqlMapClientCallback() {
				public Object doInSqlMapClient(SqlMapExecutor executor)
						throws SQLException {
					executor.startBatch();
					// ÿ���ύ�������
					final int batchSize = 200;
					int count = 0;
					for (WsRepyMes wsRepyMes : wsRepyMesList) {
						executor.insert("WsRepyMes.insert", wsRepyMes);
						// ÿ10000�������ύһ��
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

		public void update(WsRepyMes wsRepyMes) throws DAOException {
			try {
				getSqlMapClientTemplate().insert("WsRepyMes.update", wsRepyMes);
			} catch (Exception e) {
				log.error(e);
				throw new DAOException("����ʧ��");
			}
		}
		public void updateSts(WsRepyMes wsRepyMes) throws DAOException{
			try {
				getSqlMapClientTemplate().insert("WsRepyMes.updateSts", wsRepyMes);
			} catch (Exception e) {
				log.error(e);
				throw new DAOException("����ʧ��");
			}
		}
		//�ӿ�ws2302��ҳ����
		public List<WsOut2302_1> findByPageforws2302(WsRepyMes wsRepyMes) throws DAOException {
			List<WsOut2302_1> wsOut2302_1list = new ArrayList<WsOut2302_1>();
			try {
				wsOut2302_1list = getSqlMapClientTemplate().queryForList(
						"WsRepyMes.findByPageforws2302", wsRepyMes);
			} catch (Exception e) {
				log.error(e);
				throw new DAOException(e.getMessage());
			}
			return wsOut2302_1list;
		}
		//�ӿ�ws2302�õ���������������
		public int getCountforws2302(WsRepyMes wsRepyMes) throws DAOException {
			int count = 0;
			try {
				count = (Integer) getSqlMapClientTemplate().queryForObject(
						"WsRepyMes.findPage.countforws2302", wsRepyMes);
			} catch (Exception e) {
				log.error(e);
				throw new DAOException("��ѯͳ��ʧ��");
			}
			return count;
		}
		//����
		//�ӿ�ws2301��ϸ��ɾ����ͬ��ͬ�ŵ�����
		public void deleteForPactNo() throws DAOException {
			try {
				getSqlMapClientTemplate().delete("WsRepyMesforPactNo.del");
			} catch (Exception e) {
				log.error(e);
				throw new DAOException("ɾ��ʧ��");
			}
		}
		
		//�������η����б�
		public List<WsRepyMes> getByBatch(String wsRepyMesBatch) throws DAOException {
			List<WsRepyMes> wsRepyMeslist = new ArrayList<WsRepyMes>();
			try {
				wsRepyMeslist = getSqlMapClientTemplate().queryForList(
						"WsRepyMes.getByBatch", wsRepyMesBatch);
			} catch (Exception e) {
				log.error(e);
				throw new DAOException(e.getMessage());
			}
			return wsRepyMeslist;
		}
		
		public WsRepyMes getByBatchAndPactNo(WsRepyMes wsRepyMes) throws DAOException {
			try {
				wsRepyMes = (WsRepyMes) getSqlMapClientTemplate().queryForObject(
						"WsRepyMes.getByBatchAndPactNo", wsRepyMes);
			} catch (Exception e) {
				log.error(e);
				throw new DAOException("��ѯʧ��");
			}
			return wsRepyMes;
		}
		//�ۿ���Ϣͳ��
		public int getMesCount(WsRepyMes_Count wc) throws DAOException {
			int count = 0;
			try {
				count = (Integer) getSqlMapClientTemplate().queryForObject(
						"WsRepyMes.getCountMes.count", wc);
			} catch (Exception e) {
				log.error(e);
				throw new DAOException("��ѯͳ��ʧ��");
			}
			return count;
		}
		public List<WsRepyMes_Count> getCountMes(Map map) throws DAOException{
			List<WsRepyMes_Count> wcList = null;
			try {
				wcList = getSqlMapClientTemplate().queryForList(
						"WsRepyMes.getCountMes", map);
			} catch (Exception e) {
				log.error(e);
				throw new DAOException("��ѯͳ��ʧ��");
			}
			return wcList;
		}
}