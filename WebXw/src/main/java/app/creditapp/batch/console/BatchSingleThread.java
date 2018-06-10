package app.creditapp.batch.console;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;

import org.apache.log4j.Logger;

import app.base.PUBParm;
import app.base.ServiceException;
import app.creditapp.batch.entity.BatchNode;
import app.creditapp.batch.prjbatch.Batch;
import app.creditapp.batch.prjbatch.ProcedureBatch;
import app.creditapp.batch.prjbatch.ShellBatch;
import app.creditapp.batch.prjbatch.SqlBatch;
import app.creditapp.batch.util.CheckDateKind;
import app.creditapp.batch.util.DBUtil;
import app.creditapp.batch.veiw.BatchMessage;

/**
 * ִ�нڵ���̵߳���
 * 
 * 
 */
public class BatchSingleThread implements Runnable {
	private final Logger logger = Logger.getLogger(BatchSingleThread.class);
	private BatchNode batchNode;
	private Map map;
	private String batchDate;

	public BatchSingleThread(String batchDate, BatchNode batchNode, Map map) {
		this.batchNode = batchNode;
		this.map = map;
		this.batchDate = batchDate;
	}

	public void run() {
		runPreTask();
	}

	private void runPreTask() {
		String message = runRule();
		if ("no".equals(message)) {
			BatchMessage.getInstance().append("�ڵ��Ϊ:" + batchNode.getNode_no() + "�������������û�гɹ����У��������д˽ڵ�����").append("<br/>");
			logger.info("�ڵ��Ϊ:" + batchNode.getNode_no() + "�������������û�гɹ����У��������д˽ڵ�����");
		}else if (!"success".equals(message)&&!"pass".equals(message)) {
			BatchMessage.getInstance().append("�ڵ��Ϊ:" + batchNode.getNode_no() + "����������ʧ�ܣ�������ϢΪ��"+ message).append("<br/>");
			logger.info("�ڵ��Ϊ:" + batchNode.getNode_no() + "����������ʧ�ܣ�������ϢΪ��"+ message);
		} else if("success".equals(message)){
			logger.info("�ڵ��Ϊ:" + batchNode.getNode_no() + "���������г� "+ message);
		}

	}

	private String runRule() {
		BatchRunner runner = new BatchRunner(this.batchDate);
		Batch batch = new Batch("");
		String nodeNo = batchNode.getNode_no();
		try {
			if(PUBParm.YES_NO_N.equals(batchNode.getUse_sts())){//�жϽڵ��Ƿ����ã������ã�ֱ�Ӱѽڵ�״̬����Ϊ�ɹ��������˽ڵ�
				batch.updateNoteSts(nodeNo, PUBParm.NODE_STATUS_4,batchDate);
				BatchMessage.getInstance().append(nodeNo + "�ڵ�δ���ã������˽ڵ�!").append("<br/>");
				logger.info(nodeNo + "�ڵ�δ���ã������˽ڵ�!");
				return "success";
			}
			
			boolean flag = CheckDateKind.checkKind(batchNode.getScheme_time_type(),batchNode.getScheme_time_detail(),batchDate);
			if(!flag){//������ִ��Ƶ������
				batch.updateNoteSts(nodeNo, PUBParm.NODE_STATUS_4,batchDate);
				BatchMessage.getInstance().append(nodeNo + "�ڵ㲻����ִ��Ƶ�������������˽ڵ�!");
				logger.info(nodeNo + "�ڵ㲻����ִ��Ƶ�������������˽ڵ�!");
				return "success";
			}
	
			// ��һ��ִ������map��¼�ڵ��Ƿ�ִ�й�����ֹͬһ���ڵ��α�ִ�У�
			String nodePerSts = (String) map.get(nodeNo);
			if ("1".equals(nodePerSts)) {// 1��ʾִ�й�һ��
				return "pass";//ִ�й�һ��
			}
			
			boolean preTaskState = runner.getFatherState(nodeNo);// �����Ƿ�ִ�гɹ�
			if (!preTaskState) {
				return "no";//��������û�гɹ�����
			}
			
			String nodeSts = runner.getTaskState(nodeNo);// �ڵ�ִ��״̬
			if (nodeSts.equals(PUBParm.NODE_STATUS_2)) {//ִ����
				return "����������������";
			}
	
			if (nodeSts.equals(PUBParm.NODE_STATUS_4)) {//ִ�гɹ�
				return "success";
			}
			
			// ���½ڵ�״̬Ϊִ����
			batch.updateNoteSts(nodeNo, PUBParm.NODE_STATUS_2,batchDate);
			
			// ��һ��ִ������map��¼�ڵ��Ƿ�ִ�й�����ֹͬһ���ڵ��α�ִ�У�
			map.put(batchNode.getNode_no(), "1");// 1��ʾִ�й�һ��
			
			// �жϽڵ�����
			switch (Integer.parseInt(batchNode.getScheme_no())) {
			// java
			case 1:
				Class clazz = Class.forName(batchNode.getScheme_info());
				Constructor constructor = clazz.getConstructor(String.class);// ����.����
				Method method = clazz.getMethod("doBatch",BatchNode.class);// ���������Ͳ����������
				method.invoke(constructor.newInstance(batchDate), batchNode);// ���ʵ�����Ͳ���
				break;
			// Shell
			case 2:
				ShellBatch shellBatch = new ShellBatch(batchDate);
				shellBatch.doBatch(batchNode, batchNode.getScheme_info());
				break;

			// SQL
			case 3:
				SqlBatch sqlBatch = new SqlBatch(batchDate);
				sqlBatch.doBatch(batchNode);
				break;

			// �洢����
			case 4:
				ProcedureBatch procedureBatch = new ProcedureBatch(batchDate);
				procedureBatch.doBatch(batchNode, batchNode.getScheme_info());
				break;
			}
			return "success";
		} catch (Exception e) {
			// ���½ڵ�״̬Ϊִ��ʧ��
			batch.updateNoteSts(nodeNo, PUBParm.NODE_STATUS_3,batchDate);
			e.printStackTrace();
			return e.getMessage();
		}
	}
	
	/**
	 * ��ȡ�ڵ����ñ�־
	 */
	public String getUseSts(String node_no) throws ServiceException {
		String sts = "";
		Connection conn = DBUtil.getConnection();
		try {
			String sql = "SELECT USE_STS FROM BATCH_NODE WHERE NODE_NO = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, node_no);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				sts = rs.getString(1);
			}
			ps.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException(e.getMessage());
		} finally {
			DBUtil.close(conn);
		}
		return sts;
	}

}
