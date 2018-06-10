package accounting.batch;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

import accounting.biz.pub.ParmBiz;
import accounting.biz.sts.StsTransferBiz;
import accounting.domain.sys.OperaInfo;
import accounting.plat.TransCode;
import accounting.plat.core.init.BusinessInitializer;

/**
 * ������̬������������
 *
 */
public class LoanStsTransferBatch extends Batch {
	private final Logger log = Logger.getLogger(LoanStsTransferBatch.class);
	
	@Override
	public boolean doBatch(String startOrg, String endOrg) throws Exception {
		String step = "2";//����2
		boolean batchFlag = false;
		Connection conn = null;		// ���ݿ����� 
		String traceNo = null;
		try {
			conn = this.getConnection();
			String txDt = this.getTxDt(conn);	
			
			String batchDt = "";//��ǰ��������
			PreparedStatement selectSysGlobalPst = conn.prepareStatement("select sys_date from sys_global ");
			
			ResultSet selectSysGlobalRs = selectSysGlobalPst.executeQuery();
			if(selectSysGlobalRs.next()){
				batchDt = selectSysGlobalRs.getString("sys_date");
			}
			
			String batchStp = "";//��ǰ�����ɹ����в���
			PreparedStatement selectAcComSysParmPst = conn.prepareStatement("select batch_stp from ac_com_sys_parm where batch_dt='"+batchDt+"'");
			
			ResultSet selectAcComSysParmRs = selectAcComSysParmPst.executeQuery();
			if(selectAcComSysParmRs.next()){
				batchStp = selectAcComSysParmRs.getString("batch_stp");
			}
			
			//����������С��2��˵����ǰ�ò��軹δ����
			if (Integer.parseInt(batchStp) < Integer.parseInt(step)) {

				traceNo = ParmBiz.getTraceNo(conn); // �õ�������ˮ��

				OperaInfo operaInfo = new OperaInfo(conn);
				operaInfo.setBizDt(txDt);
				operaInfo.setTraceNo(traceNo);
				operaInfo.setTraceCnt(1);

				StsTransferBiz a = new StsTransferBiz();
				a.dealStsTransfer(operaInfo, TransCode.LNAN);
				
				Statement updateAcComSysParmSt = conn.createStatement();
				String updateAcComSysParmSql = "update AC_COM_SYS_PARM set batch_stp='"+step+"'";
				updateAcComSysParmSt.executeUpdate(updateAcComSysParmSql);
				updateAcComSysParmSt.close();
				
				conn.commit();
				log.info(txDt+" �����ѳɹ�....SUCC");
			}else{
				log.info(txDt+" ������ִ��");
				System.out.println(batchDt+"��������2��ִ��");
			}
			selectSysGlobalPst.close();
			selectSysGlobalRs.close();
			selectAcComSysParmPst.close();
			selectAcComSysParmRs.close();
			batchFlag = true;
			
	}catch (Exception e) {
		try {
			conn.rollback();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		log.error("����ʧ��....FAIL");
		log.error(e.getMessage(), e);
		e.printStackTrace();
		error(e);
		batchFlag = false;
	}finally {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	  }
		return batchFlag;
	}
	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		BusinessInitializer buz = new BusinessInitializer();
		buz.initialize();
		
		LoanStsTransferBatch lb = new LoanStsTransferBatch();
		lb.doBatch("100000", "100001");

	}
}
