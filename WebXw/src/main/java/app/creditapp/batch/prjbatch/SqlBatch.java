package app.creditapp.batch.prjbatch;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import app.base.PUBParm;
import app.creditapp.batch.entity.BatchNode;
import app.creditapp.batch.util.DBUtil;
import app.creditapp.batch.util.StrDealUtil;

/**
 * �ڵ�ִ��sql
 * 
 * 
 */
public class SqlBatch extends Batch {
	/**
	 * @param batchDate
	 */
	public SqlBatch(String batchDate) {
		super(batchDate);
	}

	public void doBatch(BatchNode batchNode) throws Exception {
		nodeNo = batchNode.getNode_no();
		nodeName = batchNode.getNode_name();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			logger.info("��ʼִ�нڵ��Ϊ:" + nodeNo + "������");
			String sql = "";
			sql = "SELECT SQL,SQL_DESC FROM BATCH_SQL WHERE NODE_NO=? ORDER BY SQL_LEV";
			ps = conn.prepareStatement(sql);
			ps.setString(1, nodeNo);
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("batchDate", batchDate);
			rs = ps.executeQuery();
			while (rs.next()) {
				sql = rs.getString(1);
				String sql_desc = rs.getString(2);
				//�滻�������ڱ���
				sql = StrDealUtil.getWantStr(sql, params);
				logger.info(sql);
				ps = conn.prepareStatement(sql);
				int count = ps.executeUpdate();
				logger.info(sql_desc+"ִ�гɹ������Ƹ���"+count+"����¼��");
			}
			logInfo = "����ִ�гɹ�";
			this.updateNoteSts(nodeNo,PUBParm.NODE_STATUS_4,batchDate);// �ڵ�ִ�гɹ�
			logger.info("�ڵ��Ϊ:" + nodeNo + "������ִ�гɹ�");
		} catch (Exception e) {
			logger.error("------�ڵ��Ϊ:" + nodeNo + "������ִ��ʧ��----------\n"
					+ e.getMessage());
			DBUtil.rollback(conn);
			logInfo = e.getMessage().length() > 3000 ? e.getMessage()
					.substring(0, 2999) : e.getMessage();
			this.updateNoteSts(nodeNo,PUBParm.NODE_STATUS_3,batchDate);// �ڵ�ִ��ʧ��
			e.printStackTrace();
			throw new Exception(e);
		} finally {
			DBUtil.close(ps);
			DBUtil.close(rs);
			this.insertBatchLog();// ������־��Ϣ
		}

	}
	
	public static void main(String args[]) throws Exception {
	    BatchNode batchNode = new  BatchNode();
	    batchNode.setNode_no("batch014");
	    batchNode.setNode_name("����");
	    SqlBatch sqlBatch= new SqlBatch("20150421");
	    sqlBatch.doBatch(batchNode);
	}
	
}
