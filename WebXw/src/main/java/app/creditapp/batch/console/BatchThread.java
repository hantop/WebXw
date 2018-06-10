package app.creditapp.batch.console;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Map;

import org.apache.log4j.Logger;

import app.base.PUBParm;
import app.base.ServiceException;
import app.creditapp.batch.entity.BatchNode;
import app.creditapp.batch.mfs.util.MessageUtil;
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
public class BatchThread implements Runnable {
	private final Logger logger = Logger.getLogger(BatchThread.class);
	private BatchNode batchNode;
	private Map<String,String> map;
	private String batchDate;
	private String errorMsg="";
	
	public BatchThread(String batchDate, BatchNode batchNode, Map<String,String> map) {
		this.batchNode = batchNode;
		this.map = map;
		this.batchDate = batchDate;
	}

	public void run() {
		runPreTask();
	}

	private void runPreTask() {
		BatchRunner runner = new BatchRunner();
		String message = runRule();
		if ("no".equals(message)) {
			BatchMessage.getInstance().append("�ڵ��Ϊ:" + batchNode.getNode_no() + "�������������û�гɹ����У��������д˽ڵ�����").append("<br/>");
			logger.info("�ڵ��Ϊ:" + batchNode.getNode_no() + "�������������û�гɹ����У��������д˽ڵ�����");
		} else if("pass".equals(message)){
			BatchMessage.getInstance().append("�ڵ��Ϊ:" + batchNode.getNode_no() + "��������ִ�У�"+ message).append("<br/>");
			logger.info("�ڵ��Ϊ:" + batchNode.getNode_no() + "��������ִ�У�"+ message);
		} else if("running".equals(message)){
			BatchMessage.getInstance().append("�ڵ��Ϊ:" + batchNode.getNode_no() + "����������ִ���У�"+ message).append("<br/>");
			logger.info("�ڵ��Ϊ:" + batchNode.getNode_no() + "����������ִ���У�"+ message);
		} else if("success".equals(message)){
			logger.info("�ڵ��Ϊ:" + batchNode.getNode_no() + "������ִ�гɹ���"+ message);
			runner.callNextRulesStart(batchNode.getNode_no(),map);
		} else if("error".equals(message)){
			BatchMessage.getInstance().append("�ڵ��Ϊ:" + batchNode.getNode_no() + "����������ʧ�ܣ�������ϢΪ��"+ message).append("<br/>");
			logger.info("�ڵ��Ϊ:" + batchNode.getNode_no() + "����������ʧ�ܣ�������ϢΪ��"+ errorMsg);
			if("1".equals(batchNode.getErr_flag())){//���ִ��ʧ�ܣ���ֹͣ����������ʧ���ʼ�
				//ִ��ʧ�ܷ��ʼ�
				String[] mail = getMail();
				new MessageUtil().sendMail(mail[1], batchDate+"������ִ��ʧ��",
					"ʱ��:"+new Date().toString() + "--" +batchNode.getNode_no()+"--"+batchNode.getNode_name()+" ����ִ��ʧ�ܣ�"+errorMsg);
			}else if("2".equals(batchNode.getErr_flag())){//���������ԣ������ִ��
				runner.callNextRulesStart(batchNode.getNode_no(),map);
			}
		}
	}

	private String runRule() {
		BatchRunner runner = new BatchRunner();
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
				return "running";
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
			errorMsg = e.getMessage();
			return "error";
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
			rs.close();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException(e.getMessage());
		} finally {
			DBUtil.close(conn);
		}
		return sts;
	}

	private String[] getMail()  {
		String[] mail = new String[2];
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT ADD_NAME, NVL(PHONE_NO1, PHONE_NO2), EMAIL FROM PUB_ADDR WHERE ADD_NO = '0000000000'");
			if (rs.next()) {
				String name = rs.getString(1);
				mail[0] = name+"#"+rs.getString(2);//�ֻ���
				mail[1] = name+"#"+rs.getString(3);//����
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
}
