package app.creditapp.batch.mfs.batch;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import app.base.PUBParm;
import app.creditapp.batch.entity.BatchNode;
import app.creditapp.batch.mfs.util.MessageUtil;
import app.creditapp.batch.prjbatch.JavaBatch;
import app.creditapp.batch.util.DBUtil;

/**
 * ��������
 * 
 */
public class EndBatch extends JavaBatch {

	public EndBatch(String batchDate) {
		super(batchDate);
	}

	@Override
	public void doBatch(BatchNode batchNode) throws Exception {
		nodeNo = batchNode.getNode_no();
		nodeName = batchNode.getNode_name();
		try {
			// ����ϵͳ״̬Ϊ������
			String sql = "UPDATE SYS_GLOBAL SET SYS_STS = '01',BAT_DATE=SYS_DATE WHERE GLO_NO = '0000000000'";
			this.updateWithLog("��������", sql, null);

			logInfo = "����ִ�гɹ�";
			this.updateNoteSts(nodeNo, PUBParm.NODE_STATUS_4, batchDate);// �ڵ�ִ�гɹ�
			logger.info("�ڵ��Ϊ:" + nodeNo + "������ִ�гɹ�");
			String[] mail = getMail();
			// ���ʼ�
			// zlc 20170913 ע�͵���ʱ���õĲ���
//			String msg = batchDate + "����������ɹ�,ʱ�䣺" + new Date().toString() + "\n";
//			msg += getBatchInfo(batchDate);
//			new MessageUtil().sendMail(mail[1], batchDate + "����������ɹ�", msg);
		} catch (Exception e) {
			logger.error("---------�ڵ��Ϊ:" + nodeNo + "������ִ��ʧ��--------\n" + e.getMessage());
			DBUtil.rollback(conn);
			logInfo = e.getMessage().length() > 3000 ? e.getMessage().substring(0, 2999) : e.getMessage();
			this.updateNoteSts(nodeNo, PUBParm.NODE_STATUS_3, batchDate);// �ڵ�ִ��ʧ��
			e.printStackTrace();
			throw new Exception(e);
		} finally {
			this.insertBatchLog();// ������־��Ϣ
		}
	}

	private String[] getMail() throws Exception {
		String[] mail = new String[2];
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			stmt = conn.createStatement();
			rs = stmt
					.executeQuery("SELECT ADD_NAME, NVL(PHONE_NO1, PHONE_NO2), EMAIL FROM PUB_ADDR WHERE ADD_NO = '0000000000'");
			if (rs.next()) {
				String name = rs.getString(1);
				mail[0] = name + "#" + rs.getString(2);// �ֻ���
				mail[1] = name + "#" + rs.getString(3);// ����
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs);
			DBUtil.close(stmt);
			DBUtil.close(conn);
		}
		return mail;
	}

	private String getBatchInfo(String batchDate) throws Exception {
		StringBuffer sb = new StringBuffer();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			stmt = conn.createStatement();
			rs = stmt
					.executeQuery("SELECT NODE_NO, NODE_NAME, NODE_STATUS FROM BATCH_EXE WHERE NODE_STATUS != '4' AND BATCH_DATE = '"
							+ batchDate + "'");
			while (rs.next()) {
				sb.append("�ڵ�[" + rs.getString(1) + "--" + rs.getString(2) + "]");
				if ("1".equals(rs.getString(3))) {
					sb.append("δִ��\n");
				} else if ("2".equals(rs.getString(3))) {
					sb.append("ִ����\n");
				} else if ("3".equals(rs.getString(3))) {
					sb.append("ִ��ʧ��\n");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs);
			DBUtil.close(stmt);
			DBUtil.close(conn);
		}
		return sb.toString();
	}

}
