package app.creditapp.proj.dao.impl;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.SqlMapClientCallback;

import com.ibatis.sqlmap.client.SqlMapExecutor;

import app.base.BaseIbatisDao;
import app.base.DAOException;
import app.creditapp.proj.dao.RptProjDao;
import app.creditapp.proj.entity.RptProj;
public class RptProjDaoImpl extends BaseIbatisDao implements RptProjDao {
		public void delete(RptProj rptProj) throws DAOException {
			try {
				getSqlMapClientTemplate().delete("RptProj.del",rptProj);
			} catch (Exception e) {
				log.error(e);
				throw new DAOException("ɾ��ʧ��");
			}
		}

		@SuppressWarnings("unchecked")
		public List<RptProj> findByPage(Map map) throws DAOException {
			List<RptProj> rptProjlist = null;
			try {
				rptProjlist = getSqlMapClientTemplate().queryForList(
						"RptProj.findByPage", map);
			} catch (Exception e) {
				log.error(e);
				throw new DAOException("��ҳ��ѯʧ��");
			}
			return rptProjlist;
		}
		
		@SuppressWarnings("unchecked")
		public List<RptProj> findByAll(RptProj rptProj) throws DAOException {
			List<RptProj> rptProjlist = null;
			try {
				rptProjlist = getSqlMapClientTemplate().queryForList(
						"RptProj_Daily.findByAll", rptProj);
			} catch (Exception e) {
				log.error(e);
				throw new DAOException("��ѯȫ��ʧ��");
			}
			return rptProjlist;
		}
		
		@SuppressWarnings("unchecked")
		public List<RptProj> findByAllNum(RptProj rptProj) throws DAOException {
			List<RptProj> rptProjlist = null;
			try {
				rptProjlist = getSqlMapClientTemplate().queryForList(
						"RptProj_Daily.findByAllNum", rptProj);
			} catch (Exception e) {
				log.error(e);
				throw new DAOException("��ѯȫ��ʧ��");
			}
			return rptProjlist;
		}

		public RptProj getById(RptProj rptProj) throws DAOException {
			try {
				rptProj = (RptProj) getSqlMapClientTemplate().queryForObject(
						"RptProj.getById", rptProj);
			} catch (Exception e) {
				log.error(e);
				throw new DAOException("��ѯʧ��");
			}
			return rptProj;
		}

		public RptProj getDailyById(RptProj rptProj) throws DAOException {
			try {
				rptProj = (RptProj) getSqlMapClientTemplate().queryForObject(
						"RptProj_Daily.getById", rptProj);
			} catch (Exception e) {
				log.error(e);
				throw new DAOException("��ѯʧ��");
			}
			return rptProj;
		}		
		public int getCount(RptProj rptProj) throws DAOException {
			int count = 0;
			try {
				count = (Integer) getSqlMapClientTemplate().queryForObject(
						"RptProj.findPage.count", rptProj);
			} catch (Exception e) {
				log.error(e);
				throw new DAOException("��ѯͳ��ʧ��");
			}
			return count;
		}

		public String insert(RptProj rptProj) throws DAOException {
			String sid = "";
			try {
				sid = (String)getSqlMapClientTemplate().insert("RptProj.insert", rptProj);
			} catch (Exception e) {
				log.error(e);
				throw new DAOException("����ʧ��");
			}
			return sid;
		}
		
		@SuppressWarnings("unchecked")
		public void insertBatch(final List<RptProj> rptProjList) throws DAOException {
			getSqlMapClientTemplate().execute(new SqlMapClientCallback() {
				public Object doInSqlMapClient(SqlMapExecutor executor)
						throws SQLException {
					executor.startBatch();
					// ÿ���ύ�������
					final int batchSize = 200;
					int count = 0;
					for (RptProj rptProj : rptProjList) {
						executor.insert("RptProj.insert", rptProj);
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

		public void update(RptProj rptProj) throws DAOException {
			try {
				getSqlMapClientTemplate().insert("RptProj.update", rptProj);
			} catch (Exception e) {
				log.error(e);
				throw new DAOException("����ʧ��");
			}
		}
		@SuppressWarnings("unchecked")
		public List<RptProj> getAccountBal(RptProj rptProj) throws DAOException {
			List<RptProj> rptProjlist = null;
			try {
				rptProjlist = getSqlMapClientTemplate().queryForList(
						"RptProj_Daily.findByAll", rptProj);
			} catch (Exception e) {
				log.error(e);
				throw new DAOException("��ѯȫ��ʧ��");
			}
			return rptProjlist;
		}
}
