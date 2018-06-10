package accounting.batch.run;

import java.io.File;
import java.sql.Connection;

import org.apache.log4j.Logger;

import accounting.batch.ChangeSysDateBatch;
import accounting.batch.DealAftRepyClearBatch;
import accounting.batch.LoanAftCompstBatch;
import accounting.batch.LoanAftRebuyBatch;
import accounting.batch.LoanExpandBatch;
import accounting.batch.LoanIntstSettlementBatch;
import accounting.batch.LoanRepayBatch;
import accounting.batch.LoanRepayLoAcLmAtpyBatch;
import accounting.batch.LoanStsTransferBatch;
import accounting.plat.PUBConstant;
import accounting.plat.core.OperationFactory;
import accounting.plat.core.init.SetSysInfo;
import app.util.DBUtils;

public class Main {
	private final Logger logger = Logger.getLogger(Main.class);
	public void acBatch() throws Exception {
		//��ʼ����������
		initialize();
		String txDt = PUBConstant.CUR_PRCS_DT;
		
		logger.info("Ӫҵ����["+txDt+"] ����������ʼִ��");

		logger.info("+-------oOOo---(BITIC)---oOOo-------+   ");
		logger.info("	|������ ������������������������������|   ");
		logger.info("	|��    �� �� �� �� ���� �� �� �� �� �� ��      |   ");
		logger.info("	|�������������������������������� ����|   ");
		logger.info("+---------------------Oooo----------+   ");
		System.out.println("��ǰ����====" + txDt);
		
			boolean c = false;
			
			logger.info("Ӫҵ����["+txDt+"] ��������[��������]��ʼִ��");
			LoanRepayBatch lrlo = new LoanRepayBatch();
			c = lrlo.doBatch(null, null);
			if (!c) {
				logger.info("Ӫҵ����["+txDt+"] ��������[��������]ִ��ʧ��");
				throw new Exception("LoanRepayBatch");
			}
			System.out.println("�������� ���is OK!");
			logger.info("Ӫҵ����["+txDt+"] ��������[��������]ִ�гɹ�");
			
			/**
			 * ��̬ת��
			 */
			logger.info("Ӫҵ����["+txDt+"] ��������[��̬ת��]��ʼִ��");
			LoanStsTransferBatch lt = new LoanStsTransferBatch();
			c = lt.doBatch("1", "2");
			if (!c) {
				logger.info("Ӫҵ����["+txDt+"] ��������[��̬ת��]ִ��ʧ��");
				throw new Exception("LoanStsTransferBatch");
			}
			System.out.println("��̬ת�� is OK!");
			logger.info("Ӫҵ����["+txDt+"] ��������[��̬ת��]ִ�гɹ�");
			
			
			/**
			 * ����ϵͳ����
			 */
			logger.info("Ӫҵ����["+txDt+"] ��������[����ϵͳ����]��ʼִ��");
			ChangeSysDateBatch cs = new ChangeSysDateBatch();
			c = cs.doBatch("1", "2");
			if (!c) {
				logger.info("Ӫҵ����["+txDt+"] ��������[����ϵͳ����]ִ��ʧ��");
				throw new Exception("ChangeSysDateBatch");
			}
			System.out.println("����ϵͳ���� is OK!");
			logger.info("Ӫҵ����["+txDt+"] ��������[����ϵͳ����]ִ�гɹ�");
			
			/**
			 * չ��
			 */
			logger.info("Ӫҵ����["+txDt+"] ��������[չ�ڴ���]��ʼִ��");
			LoanExpandBatch leb = new LoanExpandBatch();
			c = leb.doBatch("1", "2");
			if (!c) {
				logger.info("Ӫҵ����["+txDt+"] ��������[չ�ڴ���]ִ��ʧ��");
				throw new Exception("LoanExpandBatch");
			}
			System.out.println("չ�� is OK!");
			logger.info("Ӫҵ����["+txDt+"] ��������[չ�ڴ���]ִ�гɹ�");
			//txDt = TimeUtil.ADD_DAY(txDt, 1);

			/**
			 * ��Ϣ
			 */
//			logger.info("Ӫҵ����["+txDt+"] ��������[��Ϣ]��ʼִ��");
//			LoanIntstSettlementBatch ls = new LoanIntstSettlementBatch();
//			c = ls.doBatch("1", "2");
//			if (!c) {
//				logger.info("Ӫҵ����["+txDt+"] ��������[��Ϣ]ִ��ʧ��");
//				throw new Exception("LoanIntstSettlementBatch");
//			}
//			System.out.println("��Ϣ is OK!");
//			logger.info("Ӫҵ����["+txDt+"] ��������[��Ϣ]ִ�гɹ�");
			
			/**
			 * ������������׼��
			 */
			logger.info("Ӫҵ����["+txDt+"] ��������[������������׼��]��ʼִ��");
			LoanRepayLoAcLmAtpyBatch lrbLo2 = new LoanRepayLoAcLmAtpyBatch();
			c = lrbLo2.doBatch(null, null);
			if (!c) {
				logger.info("Ӫҵ����["+txDt+"] ��������[������������׼��]ִ��ʧ��");
				throw new Exception("LoanRepayAcLmAtpyBatch");
			}
			System.out.println("�������� ����׼�� is OK!");
			logger.info("Ӫҵ����["+txDt+"] ��������[������������׼��]ִ�гɹ�");
			
			logger.info("+-------oOOo---(BITIC)---oOOo-------+   ");
			logger.info("	|������ ������������������������������|   ");
			logger.info("	|����  �� �� �� �� �� �� �� �� �� �� ��  �� ����  |   ");
			logger.info("	|�������������������������������� ����|   ");
			logger.info("+---------------------Oooo----------+   ");
			
		}
	//}

	public static void main(String[] args) throws Exception {

		/**
		 * ϵͳ��ʼ��
		 */
		// cleanFiles("E:\\batch");
		// CreateLoanDownFile.cleanFiles("E:\\batch");
		// BusinessInitializer buz = new BusinessInitializer();
		// Main.initialize();
		
		new Main().acBatch();
		System.out.println("�������������!");
	}

	/**
	 * ɾ���ļ����������ļ�
	 * 
	 * @param path
	 *            �ļ��о���·��
	 */
	public void cleanFiles(String path) {
		File dir = new File(path);
		if (dir.isDirectory()) {
			File[] files = dir.listFiles();
			for (File f : files) {
				f.delete();
			}
		}

	}

	public static void initialize() throws Exception {
		// ��ʼ��
		OperationFactory.init();
		Connection connection = null;
		try {
			connection = DBUtils.getConn();
		} catch (Exception e) {
			e.printStackTrace();
		}

		SetSysInfo.init(connection);
		connection.close();
	}

}
