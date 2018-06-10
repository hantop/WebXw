package accounting.batch;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import accounting.plat.PUBConstant;
import accounting.plat.util.TimeUtil;

/**
 * ����ϵͳ����
 *
 */
public class ChangeSysDateBatch extends Batch {
	
	public boolean doBatch(String startOrg, String endOrg){
		String step="6";//��6��

		boolean batchFlag=false;
		Connection conn = null;				// ���ݿ�����
		try {
			conn = this.getConnection();	// ��ȡ����
			
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
			
			//����������С��6��˵����ǰ�ò��軹δ����
			if (Integer.parseInt(batchStp) < Integer.parseInt(step)) {

				// ��ϵͳ���ڻ�����һ�죻�ϴ�ϵͳ���� =��ǰӪҵ����
				String txDt = this.getTxDt(conn);
				String lstDt = txDt;
				txDt = TimeUtil.ADD_DAY(txDt, 1);
				// ����AC_COM_SYS_PARM����ϵͳ���ں��ϴ�ϵͳ����
				Statement updateAcComSysParmSt = conn.createStatement();
				String updateAcComSysParmSql = "update AC_COM_SYS_PARM set lst_dt='" + lstDt + "',sys_dt='" + txDt + "'";
				updateAcComSysParmSt.executeUpdate(updateAcComSysParmSql);
				updateAcComSysParmSt.close();

				PUBConstant.CUR_PRCS_DT = txDt;
				PUBConstant.LAST_PRCS_DT = lstDt;

				log(txDt + "������ϵͳ���ս���  ���㻻�ճɹ�");

				Statement updateAcComSysParmSt2 = conn.createStatement();
				String updateAcComSysParmSql2 = "update AC_COM_SYS_PARM set batch_dt='" + batchDt + "',batch_stp='" + step + "'";
				updateAcComSysParmSt2.executeUpdate(updateAcComSysParmSql2);
				updateAcComSysParmSt2.close();

				conn.commit();

			}else{
				System.out.println(batchDt+"��������6��ִ��");
			}
			
			selectSysGlobalPst.close();
			selectSysGlobalRs.close();
			selectAcComSysParmPst.close();
			selectAcComSysParmRs.close();
			
			batchFlag=true;
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			error(e);
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return batchFlag;
	}
	
	
}
