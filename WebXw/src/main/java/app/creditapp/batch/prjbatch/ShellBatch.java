package app.creditapp.batch.prjbatch;

import java.io.InputStreamReader;
import java.io.LineNumberReader;

import app.base.PUBParm;
import app.creditapp.batch.entity.BatchNode;
import app.creditapp.batch.util.DBUtil;
import app.creditapp.batch.util.FilePathUtil;

/**
 * �ڵ�ִ��shell
 * 
 * 
 */
public class ShellBatch extends Batch {
	/**
	 * @param batchDate
	 */
	public ShellBatch(String batchDate) {
		super(batchDate);
	}

	public void doBatch(BatchNode batchNode, String shellName) throws Exception {
		nodeNo = batchNode.getNode_no();
		nodeName = batchNode.getNode_name();
		InputStreamReader ir = null;
		LineNumberReader input = null;
		String shellPath = "";
		try {
			shellPath = FilePathUtil.getShellPath()+"/"+shellName.trim();
			System.out.println("shellPath="+shellPath);
			Process process = null;
			process = Runtime.getRuntime().exec("/bin/sh "+shellPath +" "+batchDate);
			ir = new InputStreamReader(process.getInputStream(),"UTF-8");
			input = new LineNumberReader(ir);
			int result = process.waitFor(); // Shell�˳�״̬
			StringBuffer sbf = new StringBuffer();
			String line = "";
			while ((line = input.readLine()) != null) {
				sbf.append(line + "\r\n");
			}
			System.out.println(sbf.toString());
			if (result != 0) { // shell����������
				this.updateNoteSts(nodeNo,PUBParm.NODE_STATUS_3,batchDate);// �ڵ�ִ��ʧ��
				System.out.println("shell����������");
				if (result == 127) {
					logInfo = "δ�ҵ�Ҫ���е�����";
				} else if (result == 126) {
					logInfo = "�ҵ�������޷�ִ��";
				} else if (result > 128) {
					logInfo = "���ϵͳǿ�н���";
				} else {
					logInfo = sbf.toString();
				}
				throw new Exception(logInfo);
			} else {
				this.updateNoteSts(nodeNo,PUBParm.NODE_STATUS_4,batchDate);// �ڵ�ִ�гɹ�
				logInfo = "����ִ�гɹ�";
				logger.info("�ڵ��Ϊ:" + nodeNo + "������ִ�гɹ�");
			}
		} catch (Exception e) {
			DBUtil.rollback(conn);
			logger.error("�ڵ��Ϊ:" + nodeNo + "��SHELL:" + shellPath + "ִ��ʧ��:\n"
					+ e.getMessage());
			logInfo = e.getMessage().length() > 3000 ? e.getMessage()
					.substring(0, 2999) : e.getMessage();
			this.updateNoteSts(nodeNo,PUBParm.NODE_STATUS_3,batchDate);// �ڵ�ִ��ʧ��
			throw new Exception(e);
		} finally {
			try {
				this.insertBatchLog();// ������־��Ϣ
				if(ir != null){
					ir.close();
				}
				if(input != null){
					input.close();
				}
			} catch (Exception e) {
				throw new Exception(e);
			}
		}

	}
}
