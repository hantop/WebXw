/**
 * 
 */
package accounting.batch;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

import accounting.domain.loan.AcLnLo;
import accounting.domain.loan.AcLnRepayPlnCur;
import accounting.domain.sys.OperaInfo;
import accounting.plat.PUBConstant;
import accounting.plat.core.init.BusinessInitializer;
/**
 * �������ۣ�Ƿ�
 *
 */
public class LoanRepayBatch extends Batch{
	private final Logger log = Logger.getLogger(LoanRepayBatch.class);
	
	public boolean doBatch(String startOrg, String endOrg) {
		
		String step="1";//������һ��
		boolean batchFlag = false;
		Connection conn = null; 		// ���ݿ�����
		
		//�����ڻ���ƻ��е�����δ���嵱�ڱ����Ļ���ƻ�����Ƿ���
		String insertLnLoSql = "insert into ac_ln_lo (select c.loan_no,c.pact_no,c.br_no,c.perd_no,c.pay_dt,c.prcp_amt,c.norm_int,'0.00',l.over_rate,nvl(c.repay_prcp_amt,0.00),"+
								" nvl(c.repay_norm_int,0.00),'0.00','0.00','0.00','0.00','30','30','N',?,'','��������Ƿ��','','' from ac_ln_repay_pln_cur c,ac_ln_mst l"+
								" where c.loan_no = l.loan_no  and (nvl(c.prcp_amt,0)+nvl(c.norm_int,0)-nvl(c.repay_prcp_amt,0)-nvl(c.repay_norm_int,0))>0 and c.end_dt=?)";
		PreparedStatement insertLnLoPst = null;
		
		//���µ��ڻ���ƻ�
//		String updateCurSql = "update ac_ln_repay_pln_cur a set (ttl_amt, perd_no, prcp_amt, norm_int, wrk_dt,"+
//							" pay_dt, end_dt, repay_prcp_amt, repay_norm_int) = (select m.instm_amt, m.perd_no, m.prcp_amt,"+
//							" m.norm_int, ?, m.pay_dt, to_char(to_date(m.pay_dt+n.grace_day,'YYYYMMDD'),'yyyymmdd'),"+
//               				" nvl(m.repay_prcp_amt,0), nvl(m.repay_norm_int,0) ��from ac_ln_repay_pln m,"+
//							" (select c.loan_no, c.perd_no + 1 as perd_no, l.grace_day from ac_ln_repay_pln_cur c, ac_ln_mst l"+
//							" where c.loan_no = l.loan_no and c.pay_dt <= ? and c.end_dt >= ?"+
//							" and ((nvl(c.prcp_amt, 0) + nvl(c.norm_int, 0) -"+
//                       		" nvl(c.repay_prcp_amt, 0) - nvl(c.repay_norm_int, 0)) <= 0 or"+
//                       		" ((nvl(c.prcp_amt, 0) + nvl(c.norm_int, 0) -"+
//                       		" nvl(c.repay_prcp_amt, 0) - nvl(c.repay_norm_int, 0)) > 0 and"+
//							" c.end_dt = ?) and c.end_dt >= ?)) n where m.loan_no = n.loan_no and m.perd_no = n.perd_no and a.loan_no=m.loan_no) " +
//							" where exists (select 1 from (select m.loan_no ��from ac_ln_repay_pln m,"+
//                       		" (select c.loan_no, c.perd_no + 1 as perd_no, l.grace_day"+
//                       		" from ac_ln_repay_pln_cur c, ac_ln_mst l where c.loan_no = l.loan_no"+
//                       		" and c.pay_dt <= ? and c.end_dt >= ? and ((nvl(c.prcp_amt, 0) + nvl(c.norm_int, 0) -"+
//                       		" nvl(c.repay_prcp_amt, 0) - nvl(c.repay_norm_int, 0)) <= 0 or"+
//                       		" ((nvl(c.prcp_amt, 0) + nvl(c.norm_int, 0) -"+
//                       		" nvl(c.repay_prcp_amt, 0) - nvl(c.repay_norm_int, 0)) > 0 and"+
//                       		" c.end_dt = ?) and c.end_dt >= ?)) n where m.loan_no = n.loan_no and m.perd_no = n.perd_no) y where a.loan_no=y.loan_no)";
		String updateCurSql = "UPDATE AC_LN_REPAY_PLN_CUR A SET (TTL_AMT, PERD_NO, PRCP_AMT, NORM_INT,"+
							  " WRK_DT, PAY_DT,  END_DT, REPAY_PRCP_AMT, REPAY_NORM_INT) ="+
							  " (SELECT B.INSTM_AMT, B.PERD_NO, B.PRCP_AMT, B.NORM_INT, ?, B.PAY_DT,"+
							  " TO_CHAR(TO_DATE(B.PAY_DT , 'YYYYMMDD')+ C.GRACE_DAY, 'yyyymmdd'),"+
							  " NVL(B.REPAY_PRCP_AMT, 0), NVL(B.REPAY_NORM_INT, 0)"+
							  "	FROM AC_LN_REPAY_PLN B, AC_LN_MST C WHERE B.LOAN_NO = C.LOAN_NO"+
							  "	AND A.LOAN_NO = B.LOAN_NO AND B.PERD_NO = A.PERD_NO + 1) WHERE END_DT = ?"+
							  "	AND EXISTS (SELECT 1 FROM AC_LN_REPAY_PLN D WHERE A.LOAN_NO = D.LOAN_NO"+
							  "	AND D.PERD_NO = A.PERD_NO + 1)";
		PreparedStatement updateCurPst = null;
		
		//���µ��ڽ��廹��ƻ���״̬
		String updateCurPlnSql = "update ac_ln_repay_pln a set a.prcp_sts = '40', a.int_sts = '40', a.setl_sts = 'Y'"+
								" where exists (select 1 from ac_ln_repay_pln_cur c where a.loan_no = c.loan_no"+
								" and a.perd_no = c.perd_no and a.setl_sts='N'"+
								" and nvl(c.prcp_amt, 0) - nvl(c.repay_prcp_amt, 0)=0 and nvl(c.norm_int, 0) - nvl(c.repay_norm_int, 0) = 0)";
		PreparedStatement updateCurPlnPst = null;

//		String insertCurSql = "insert into ac_ln_repay_pln_cur select m.loan_no,m.pact_no,m.br_no,m.instm_amt,m.perd_no,m.prcp_amt,"+
//							" m.norm_int,?,m.pay_dt,to_date(m.pay_dt)+n.grace_day,'0.00','0.00'��from ac_ln_repay_pln m,(  "+
//							" select c.loan_no,c.perd_no+1 as perd_no,l.grace_day from ac_ln_repay_pln_cur c, ac_ln_mst l"+
//							" where c.loan_no = l.loan_no and c.pay_dt <= ? and c.end_dt >= ?"+
//							" and ((nvl(c.prcp_amt, 0) + nvl(c.norm_int, 0) - nvl(c.repay_prcp_amt, 0) -"+
//							" nvl(c.repay_norm_int, 0)) <= 0 or ((nvl(c.prcp_amt, 0) + nvl(c.norm_int, 0) -"+
//							" nvl(c.repay_prcp_amt, 0) - nvl(c.repay_norm_int, 0)) > 0 and"+
//							" c.end_dt = '20160930') and c.end_dt >= ?)) n where m.loan_no=n.loan_no and m.perd_no=n.perd_no";
//		PreparedStatement insertCurPst= null;
		String updatePlnSql = "update ac_ln_repay_pln a set (a.prcp_sts, a.int_sts, a.setl_sts, a.fine_int_dt) ="+
							" (select prcp_sts, int_sts, setl_sts, fine_int_dt from ac_ln_lo l"+
							" where a.loan_no = l.loan_no and a.perd_no = l.perd_no ) where exists (select 1"+
							" from ac_ln_lo l  where a.loan_no = l.loan_no and a.perd_no = l.perd_no and a.setl_sts = 'N' ) ";
		PreparedStatement updatePlnPst = null;
		try {
			conn = this.getConnection();
			String txDt = PUBConstant.CUR_PRCS_DT ; // ��ȡ��ǰ����
			
			OperaInfo operaInfo = new OperaInfo(conn) ;
			operaInfo.setTraceCnt(1);
			
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
			if ("".equals(batchStp)) {
				int nums = 0;
				//���µ��ڽ��廹��ƻ���״̬
				log.info("���µ��ڽ��廹��ƻ���״̬,SQL=="+updateCurPlnSql);
				updateCurPlnPst = conn.prepareStatement(updateCurPlnSql);
				nums=updateCurPlnPst.executeUpdate();
				log.info("���µ��ڽ��廹��ƻ���״̬,RES=="+nums);
				
				//����Ƿ��
				log.info("����Ƿ��,SQL=="+insertLnLoSql);
				insertLnLoPst = conn.prepareStatement(insertLnLoSql);
				insertLnLoPst.setString(1, txDt);
				insertLnLoPst.setString(2, txDt);
				nums = insertLnLoPst.executeUpdate();
				log.info("����Ƿ��,RES=="+nums);
				
				//���µ��ڻ���ƻ���
				log.info("���µ��ڻ���ƻ���,SQL=="+updateCurSql);
				updateCurPst = conn.prepareStatement(updateCurSql);
				updateCurPst.setString(1, txDt);
				updateCurPst.setString(2, txDt);
				nums = updateCurPst.executeUpdate();
				log.info("���µ��ڻ���ƻ���,RES=="+nums);
				
				//���»���ƻ�
				log.info("���»���ƻ�,SQL=="+updatePlnSql);
				updatePlnPst = conn.prepareStatement(updatePlnSql);
				nums = updatePlnPst.executeUpdate();
				log.info("���»���ƻ�,RES=="+nums);
				
				Statement updateAcComSysParmSt = conn.createStatement();
				String updateAcComSysParmSql = "update AC_COM_SYS_PARM set batch_dt='"+batchDt+"',batch_stp='"+step+"'";
				updateAcComSysParmSt.executeUpdate(updateAcComSysParmSql);
				updateAcComSysParmSt.close();
			
				conn.commit();
				log.info(txDt+" �����ѳɹ�....SUCC");
			}else{
				log.info(txDt+" ������ִ��");
				System.out.println(batchDt+"��������1��ִ��");
			}
			
			selectSysGlobalPst.close();
			selectSysGlobalRs.close();
			selectAcComSysParmPst.close();
			selectAcComSysParmRs.close();
			
			batchFlag = true;
			
		} catch (Exception e) {
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
		} finally {
			try {
				if(insertLnLoPst!=null) insertLnLoPst.close();
				if(updateCurPst!=null) updateCurPst.close();
				if(updatePlnPst!=null) updatePlnPst.close();
				if(updateCurPlnPst!=null) updateCurPlnPst.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return batchFlag;
	}
	/**
	 * 
	 * @���� DHCC-LIUJ
	 * @���� 2016-9-23
	 * @����	���ݵ��ڻ���ƻ� ���Ƿ����Ϣ
	 */
	public static AcLnLo getAcLnLoByCur(AcLnLo acLnLo , AcLnRepayPlnCur acLnRepayPlnCur,String bizDt,double overRate){
		acLnLo.setLoanNo(acLnRepayPlnCur.getLoanNo());
		acLnLo.setPactNo(acLnRepayPlnCur.getPactNo());
		acLnLo.setBrNo(acLnRepayPlnCur.getBrNo());
		acLnLo.setPerdNo(acLnRepayPlnCur.getPerdNo());
		acLnLo.setPayDt(acLnRepayPlnCur.getPayDt());
		acLnLo.setPrcpAmt(acLnRepayPlnCur.getPrcpAmt());
		acLnLo.setNormInt(acLnRepayPlnCur.getNormInt());
		acLnLo.setFineInt(0.00);//Ƿ��Ϣ
		acLnLo.setOverRate(overRate);
		acLnLo.setRepayPrcpAmt(acLnRepayPlnCur.getRepayPrcpAmt());
		acLnLo.setRepayNormInt(acLnRepayPlnCur.getRepayNormInt());
		acLnLo.setRepayFineInt(0.00);
		acLnLo.setWvPrcpAmt(0.00);
		acLnLo.setWvNormInt(0.00);
		acLnLo.setWvFineInt(0.00);
		acLnLo.setPrcpSts("30");
		acLnLo.setIntSts("30");
		acLnLo.setSetlSts("N");
		acLnLo.setOverDt(bizDt);
		return acLnLo;
	}
	
	public static void main(String[] args) throws Exception {
		BusinessInitializer buz = new BusinessInitializer();
		buz.initialize();
		LoanRepayBatch loanRepayBatch=new LoanRepayBatch();
		boolean c = false;
		c = loanRepayBatch.doBatch(null, null);
		if (!c) {
			throw new Exception("LoanRepayBatch");
		}
		System.out.println("�������� ���is OK!");
	}
}
