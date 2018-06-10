package app.creditapp.batch.prjbatch;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import app.creditapp.batch.entity.BatchLog;
import app.creditapp.batch.util.DBUtil;

/**
 * ������׼��
 * 
 */
public class Batch {
	public Logger logger = Logger.getLogger(this.getClass());
	protected BatchLog batchLog = new BatchLog();

	/** ϵͳ���� **/
	protected String sysDate;
	/** ���ݿ����� **/
	protected Connection conn;
	/** �������� **/
	protected String batchDate;

	/** �ڵ��� **/
	protected String nodeNo;
	/** �ڵ����� **/
	protected String nodeName;
	/** �ڵ����п�ʼʱ�� **/
	protected String begTime;
	/** �ڵ����н���ʱ�� **/
	protected String endTime;
	/** �ڵ�״̬ **/
	protected String nodeSts;

	protected String msg = "";
	protected String logInfo;// ��־��Ϣ

	public Batch(String batchDate) {
		this.conn = DBUtil.getConnection();
		this.batchDate = batchDate;
		begTime = this.getSysTime();
	}

	/**
	 * ����ָ�������������нڵ��״̬
	 * 
	 * @param nodeNo
	 *            �ڵ���
	 * @param node_sts
	 *            1-δִ�� 2-ִ���� 3-ִ��ʧ�� 4-ִ�гɹ�
	 * @param batchDate
	 *            ������������
	 */
	public void updateNoteSts(String nodeNo, String node_sts, String batchDate) {
		String sql = "UPDATE BATCH_EXE SET NODE_STATUS=? WHERE NODE_NO=? and BATCH_DATE=?";
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, node_sts);
			ps.setString(2, nodeNo);
			ps.setString(3, batchDate);
			ps.executeUpdate();
			ps.close();
			DBUtil.commit(conn);
		} catch (SQLException e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} finally {
			DBUtil.close(ps);
		}
	}

	/**
	 * ���ݽڵ����������־
	 * 
	 * @throws Exception
	 */
	public void insertBatchLog() {
		String sql = "INSERT INTO BATCH_LOG (BATCH_DATE, NODE_NO, NODE_NAME, LOG_INFO, BEG_TIME, END_TIME) VALUES (?, ?, ?, ?, ?, ?)";
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, batchDate);
			ps.setString(2, nodeNo);
			ps.setString(3, nodeName);
			ps.setString(4, logInfo);
			ps.setString(5, begTime);
			ps.setString(6, this.getSysTime());
			ps.executeUpdate();
			DBUtil.commit(conn);
			logger.info(nodeNo + "�ڵ����������־�ɹ�");
		} catch (SQLException e) {
			logger.error(nodeNo + "�ڵ����������־ʧ��");
			e.printStackTrace();
		} finally {
			DBUtil.close(ps);
			DBUtil.close(conn);
		}
	}

	/**
	 * ��ȡ���ݿ�ʱ��
	 * 
	 * @return
	 * @throws Exception
	 * @throws Exception
	 */
	public String getSysTime() {
		String tamp = "";
		String sql = "SELECT SYSDATE FROM DUAL";
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				tamp = rs.getString(1);
			}
			rs.close();
		} catch (SQLException e) {
			logger.error(e);
			e.printStackTrace();
		} finally {
			DBUtil.close(ps);
		}
		return tamp;
	}

	/**
	 * ִ�зǲ�ѯSQL(����¼��־),�������paramsΪnull���޲�������
	 * 
	 * @param sql
	 *            ִ��SQl
	 * @param params
	 *            SQl�еĲ���,�����е����+1 �����λ��ƥ��
	 * @return
	 * @throws Exception
	 */
	protected int execUpdate(String sql, Object[] params) throws Exception {
		PreparedStatement ps = null;
		int result = 0;
		try {
			ps = conn.prepareStatement(sql);
			if (params != null && params.length >= 1) {
				for (int i = 0; i < params.length; i++) {
					if (params[i] instanceof Double) {
						ps.setDouble(i + 1, (Double) params[i]);
					} else if (params[i] instanceof Integer) {
						ps.setInt(i + 1, (Integer) params[i]);
					} else {
						ps.setString(i + 1, (String) params[i]);
					}
				}
			}
			result = ps.executeUpdate();
			DBUtil.commit(conn);
		} catch (Exception e) {
			DBUtil.rollback(conn);
			logger.error(e.getMessage(),e);
			throw new Exception(e);
		} finally {
			DBUtil.close(ps);
		}
		return result;
	}

	/**
	 * ִ�зǲ�ѯSQL,�������paramsΪnull���޲�������
	 * 
	 * @param msg
	 *            ��¼��־
	 * @param sql
	 *            ִ��SQl
	 * @param params
	 *            SQl�еĲ���,�����е����+1 �����λ��ƥ��
	 * @return
	 * @throws Exception
	 */
	protected int updateWithLog(String msg, String sql, Object[] params) throws Exception {
		long startTime = System.currentTimeMillis();
		long endTime = 0;
		PreparedStatement ps = null;
		int result = 0;
		try {
			ps = conn.prepareStatement(sql);
			if (params != null && params.length >= 1) {
				for (int i = 0; i < params.length; i++) {
					if (params[i] instanceof Double) {
						ps.setDouble(i + 1, (Double) params[i]);
					} else if (params[i] instanceof Integer) {
						ps.setInt(i + 1, (Integer) params[i]);
					} else {
						ps.setString(i + 1, (String) params[i]);
					}
				}
			}
			logger.info(sql);
			if (params != null && params.length != 0) {
				logger.info("����: " + transParams(params));
			}
			result = ps.executeUpdate();
			endTime = System.currentTimeMillis();
			logger.info(msg + "ִ�н��������¼�¼��:" + result);
			logger.info("ִ��ʱ�䣺" + (endTime - startTime) + "ms");
			DBUtil.commit(conn);
		} catch (Exception e) {
			DBUtil.rollback(conn);
			throw new Exception(e);
		} finally {
			DBUtil.close(ps);
		}
		return result;
	}

	/**
	 * ��ʽ����� �������� a b c ����� [a][b][c]
	 * 
	 * @param ao
	 *            �������
	 * @return
	 */
	private String transParams(Object[] ao) {
		if (ao == null || ao.length == 0) {
			return "[]";
		}
		StringBuffer buf = new StringBuffer();
		for (int i = 0; i < ao.length; i++) {
			buf.append("[").append(ao[i]).append("] ");
		}
		return buf.toString();
	}

}
