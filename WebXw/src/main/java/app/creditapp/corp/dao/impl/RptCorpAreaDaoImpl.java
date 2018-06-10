package app.creditapp.corp.dao.impl;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.SqlMapClientCallback;

import com.ibatis.sqlmap.client.SqlMapExecutor;

import app.base.BaseIbatisDao;
import app.base.DAOException;
import app.creditapp.corp.dao.RptCorpAreaDao;
import app.creditapp.corp.entity.RptCorpArea;
public class RptCorpAreaDaoImpl extends BaseIbatisDao implements RptCorpAreaDao {
		public void delete(RptCorpArea rptCorpArea) throws DAOException {
			try {
				getSqlMapClientTemplate().delete("RptCorpArea.del",rptCorpArea);
			} catch (Exception e) {
				log.error(e);
				throw new DAOException("ɾ��ʧ��");
			}
		}

		@SuppressWarnings("unchecked")
		public List<RptCorpArea> findByPage(Map map) throws DAOException {
			List<RptCorpArea> rptCorpArealist = null;
			try {
				rptCorpArealist = getSqlMapClientTemplate().queryForList(
						"RptCorpArea.findByPage", map);
			} catch (Exception e) {
				log.error(e);
				throw new DAOException("��ҳ��ѯʧ��");
			}
			return rptCorpArealist;
		}
		
		@SuppressWarnings("unchecked")
		public List<RptCorpArea> findByAll(RptCorpArea rptCorpArea) throws DAOException {
			List<RptCorpArea> rptCorpArealist = null;
			try {
				rptCorpArealist = getSqlMapClientTemplate().queryForList(
						"RptCorpArea.findByAll", rptCorpArea);
			} catch (Exception e) {
				log.error(e);
				e.printStackTrace();
				throw new DAOException("��ѯȫ��ʧ��");
			}
			return rptCorpArealist;
		}

		public RptCorpArea getById(RptCorpArea rptCorpArea) throws DAOException {
			try {
				rptCorpArea = (RptCorpArea) getSqlMapClientTemplate().queryForObject(
						"RptCorpArea.getById", rptCorpArea);
			} catch (Exception e) {
				log.error(e);
				throw new DAOException("��ѯʧ��");
			}
			return rptCorpArea;
		}
		
		public int getCount(RptCorpArea rptCorpArea) throws DAOException {
			int count = 0;
			try {
				count = (Integer) getSqlMapClientTemplate().queryForObject(
						"RptCorpArea.findPage.count", rptCorpArea);
			} catch (Exception e) {
				log.error(e);
				throw new DAOException("��ѯͳ��ʧ��");
			}
			return count;
		}

		public String insert(RptCorpArea rptCorpArea) throws DAOException {
			String sid = "";
			try {
				sid = (String)getSqlMapClientTemplate().insert("RptCorpArea.insert", rptCorpArea);
			} catch (Exception e) {
				log.error(e);
				throw new DAOException("����ʧ��");
			}
			return sid;
		}
		
		@SuppressWarnings("unchecked")
		public void insertBatch(final List<RptCorpArea> rptCorpAreaList) throws DAOException {
			getSqlMapClientTemplate().execute(new SqlMapClientCallback() {
				public Object doInSqlMapClient(SqlMapExecutor executor)
						throws SQLException {
					executor.startBatch();
					// ÿ���ύ�������
					final int batchSize = 200;
					int count = 0;
					for (RptCorpArea rptCorpArea : rptCorpAreaList) {
						executor.insert("RptCorpArea.insert", rptCorpArea);
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

		public void update(RptCorpArea rptCorpArea) throws DAOException {
			try {
				getSqlMapClientTemplate().insert("RptCorpArea.update", rptCorpArea);
			} catch (Exception e) {
				log.error(e);
				throw new DAOException("����ʧ��");
			}
		}
		
}
