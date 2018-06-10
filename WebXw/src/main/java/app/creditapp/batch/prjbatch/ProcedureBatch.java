package app.creditapp.batch.prjbatch;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import app.base.PUBParm;
import app.creditapp.batch.entity.BatchLog;
import app.creditapp.batch.entity.BatchNode;
import app.creditapp.batch.util.DBUtil;
import app.creditapp.batch.util.DateUtil;
import app.util.DBUtils;

/**
 * �ڵ�ִ�д洢����
 * 
 * 
 */
public class ProcedureBatch extends Batch {
	/**
	 * @param batchDate
	 */
	public ProcedureBatch(String batchDate) {
		super(batchDate);
	}

	public void doBatch(BatchNode batchNode, String procedure_name) throws Exception {
		nodeNo = batchNode.getNode_no();
		nodeName = batchNode.getNode_name();
		try {
			CallableStatement cs = conn.prepareCall("{call " + procedure_name
					+ "()}");
			cs.execute();
			cs.close();
			logInfo = "����ִ�гɹ�";
			this.updateNoteSts(nodeNo,PUBParm.NODE_STATUS_4,batchDate);// �ڵ�ִ�гɹ�
			logger.info("�ڵ��Ϊ:" + nodeNo + "������ִ�гɹ�");
		} catch (Exception e) {
			logger.error("---------�ڵ��Ϊ:" + nodeNo + "������ִ��ʧ��--------\n"
					+ e.getMessage());
			DBUtil.rollback(conn);
			logInfo = e.getMessage().length() > 3000 ? e.getMessage()
					.substring(0, 2999) : e.getMessage();
			this.updateNoteSts(nodeNo,PUBParm.NODE_STATUS_3,batchDate);// �ڵ�ִ��ʧ��
			e.printStackTrace();
			throw new Exception(e);
		} finally {
			this.insertBatchLog();// ������־��Ϣ
		}

	}
}
