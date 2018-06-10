package accounting.batch;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import accounting.biz.pub.AcLnRepayPlnBiz;
import accounting.biz.pub.FeeBiz;
import accounting.biz.pub.ParmBiz;
import accounting.domain.fee.AcChrgLog;
import accounting.domain.loan.AcLnMst;
import accounting.domain.loan.AcLnRepayPln;
import accounting.domain.loan.AcLnRepayPlnCur;
import accounting.domain.loan.AcTraceLog;
import accounting.domain.loan.PrdtBase;
import accounting.domain.sys.OperaInfo;
import accounting.plat.PUBConstant;
import accounting.plat.core.init.BusinessInitializer;
import accounting.plat.dao.JdbcDao;
import app.creditapp.aft.entity.AftExp;
import app.util.DateUtil;

/**
 * ���ս���չ�ڽ���
 * 
 * 
 */
public class LoanExpandBatch extends Batch {
	private final Logger log = Logger.getLogger(LoanExpandBatch.class);
	
	public boolean doBatch(String startOrg, String endOrg) {
		String step = "7";// ��7��

		boolean batchFlag = false;
		Connection conn = null; // ���ݿ�����
		try {
			conn = this.getConnection(); // ��ȡ����

			String batchDt = "";// ��ǰ��������
			PreparedStatement selectSysGlobalPst = conn.prepareStatement("select sys_date from sys_global ");

			ResultSet selectSysGlobalRs = selectSysGlobalPst.executeQuery();
			if (selectSysGlobalRs.next()) {
				batchDt = selectSysGlobalRs.getString("sys_date");
			}
			String batchStp = "";// ��ǰ�����ɹ����в���
			PreparedStatement selectAcComSysParmPst = conn
					.prepareStatement("select batch_stp from ac_com_sys_parm where batch_dt='" + batchDt + "'");

			ResultSet selectAcComSysParmRs = selectAcComSysParmPst.executeQuery();
			if (selectAcComSysParmRs.next()) {
				batchStp = selectAcComSysParmRs.getString("batch_stp");
			}

			// ����������С��7��˵����ǰ�ò��軹δ����
			if (Integer.parseInt(batchStp) < Integer.parseInt(step)) {

				String traceNo = ParmBiz.getTraceNo(conn); // ��ȡ������ˮ��

				String txDt = this.getTxDt(conn); // �õ���ǰӪҵ����

				String aftExpSql = "SELECT * FROM aft_exp WHERE beg_date='" + txDt + "' AND exp_sts ='02' ";
				log.info("����[չ��]SQL=="+aftExpSql);
				PreparedStatement aftExpPs = conn.prepareStatement(aftExpSql);

				ResultSet aftExpRs = aftExpPs.executeQuery();

				while (aftExpRs.next()) {
					String pactNo = aftExpRs.getString("PACT_NO"); // ��ͬ��
					String brNo = aftExpRs.getString("BR_NO");// ������
					// ��ѯ����������Ϣ
					AcLnMst acLnMst = (AcLnMst) JdbcDao.query(new AcLnMst(), "pact_no='" + pactNo + "' and br_no='" + brNo + "'", "ac_ln_mst", conn);

					AftExp aftExp = this.parseAftExp(aftExpRs);
					// ��ú��������
					PrdtBase prdtBase = PUBConstant.PUB_ACCOUNT_PRAM.get(acLnMst.getPrdtNo());

					OperaInfo operaInfo = new OperaInfo(conn);
					operaInfo.setTxBrNo(aftExp.getBrNo()); // ���㽻�׻�����
					operaInfo.setTxDt(aftExp.getBegDate()); // ϵͳ��������
					operaInfo.setTraceNo(traceNo); // ������ˮ��

					acLnMst.setMtrDt(aftExp.getEndDate()); // ��������
					acLnMst.setLnRate(aftExp.getExpRate()); // չ������

					if ("A".equals(acLnMst.getBrAccType())) {
						// �´������ļ������������»���ƻ�
						AcLnMst newAcLnMst = new AcLnMst();
						newAcLnMst = acLnMst;
						newAcLnMst.setOpnDt(aftExp.getBegDate());
						// ���¼������ڴ������ޣ����������»���ƻ�
						long[] terms = DateUtil.getMonthsAndDays(aftExp.getBegDate(), acLnMst.getMtrDt());
						int month = (int) terms[0];
						if (terms[1] > 0) {
							month += 1;
						}
						acLnMst.setLoanTerm(month);

						List<AcLnRepayPln> acLnRepayPlnList = AcLnRepayPlnBiz.getAcLnRepayPln(acLnMst, prdtBase, operaInfo);

						AcLnRepayPlnCur alrpc = (AcLnRepayPlnCur) JdbcDao.query(new AcLnRepayPlnCur(), "loan_no='" + acLnMst.getLoanNo() + "'", "ac_ln_repay_pln_cur", conn);

						// �����ɵĻ���ƻ��ڴδ�1��ʼ�����Ϊ��ԭ����ƻ����һ�ڿ�ʼ
						for (int i = 0; i < acLnRepayPlnList.size(); i++) {
							acLnRepayPlnList.get(i).setPerdNo(acLnRepayPlnList.get(i).getPerdNo() + alrpc.getPerdNo());
						}

						AcLnRepayPlnCur newAcLnRepayPlnCur = AcLnRepayPlnBiz.getAcLnRepayPlnCur(acLnRepayPlnList.get(0), acLnMst, operaInfo.getTxDt());

						// ���ɷ�����Ϣ--չ�ڷ����
						List<AcChrgLog> acChrgLogList = new ArrayList<AcChrgLog>();
						acChrgLogList = FeeBiz.getAcChrgLogListFk(operaInfo.getTraceCnt(), acLnMst.getLoanNo(),
								acLnMst.getPrdtNo(), "LN06", aftExp.getExpAmt(), acLnMst.getCurNo(), "", operaInfo);

						// �������ڻ���ƻ�
						JdbcDao.delete("loan_no='" + acLnMst.getLoanNo() + "'", "ac_ln_repay_pln_cur", operaInfo.getConn());
						JdbcDao.insert(newAcLnRepayPlnCur, "ac_ln_repay_pln_cur", operaInfo.getConn());

						// ����չ�ں󻹿�ƻ�
						JdbcDao.insertList(acLnRepayPlnList, "ac_ln_repay_pln", operaInfo.getConn());

						// ����չ��������
						if (acChrgLogList.size() > 0) {
							JdbcDao.insertList(acChrgLogList, "ac_chrg_log", operaInfo.getConn());
						}
					}
					// ���´������ļ�
					JdbcDao.update(acLnMst, "loan_no='" + acLnMst.getLoanNo() + "'", "AC_LN_MST", conn);

					// ���´���չ�������
					aftExp.setExpSts("03");// ����״̬Ϊ��չ��
					JdbcDao.update(aftExp, "exp_id='" + aftExp.getExpId() + "'", "AFT_EXP", conn);

					// ��ȡ������ˮ
					AcTraceLog acTraceLog = new AcTraceLog();
					acTraceLog.setTraceNo(traceNo);
					acTraceLog.setTraceCnt(1);
					acTraceLog.setTxDt(txDt);
					acTraceLog.setTxTime(ParmBiz.getOracleTxTime(conn));
					acTraceLog.setTxCde("LN06");
					acTraceLog.setSubTxCde("LN06");
					acTraceLog.setSvcInd("LN06");
					acTraceLog.setCurNo(acLnMst.getCurNo());
					acTraceLog.setPrdtNo(acLnMst.getPrdtNo());
					acTraceLog.setBrNo(acLnMst.getBrNo());
					acTraceLog.setPactNo(acLnMst.getPactNo());
					acTraceLog.setLoanNo(acLnMst.getLoanNo());
					acTraceLog.setAmt(aftExp.getExpAmt());
					acTraceLog.setMemo("����չ��");
					JdbcDao.insert(acTraceLog, "ac_trace_log", conn);
				}
				aftExpPs.close();
				aftExpRs.close();

				Statement updateAcComSysParmSt2 = conn.createStatement();
				String updateAcComSysParmSql2 = "update AC_COM_SYS_PARM set batch_dt='" + batchDt + "',batch_stp='"
						+ step + "'";
				updateAcComSysParmSt2.executeUpdate(updateAcComSysParmSql2);
				updateAcComSysParmSt2.close();

				conn.commit();

			} else {
				System.out.println(batchDt + "��������7��ִ��");
				log.info("����[չ��]��ִ��");
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
			e.printStackTrace();
			error(e);
			log.error("չ�ڴ���ʧ�ܣ�"+e.getMessage(),e);
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return batchFlag;
	}

	public AftExp parseAftExp(ResultSet aftExpRs) throws SQLException {
		AftExp aftExp = new AftExp();
		aftExp.setExpId(aftExpRs.getString("EXP_ID"));
		aftExp.setPactId(aftExpRs.getString("PACT_ID"));
		aftExp.setPactNo(aftExpRs.getString("PACT_NO"));
		aftExp.setBrNo(aftExpRs.getString("BR_NO"));
		aftExp.setBegDate(aftExpRs.getString("BEG_DATE"));
		aftExp.setEndDate(aftExpRs.getString("END_DATE"));
		aftExp.setExpRate(aftExpRs.getDouble("EXP_RATE"));
		aftExp.setExpAmt(aftExpRs.getDouble("EXP_AMT"));
		aftExp.setExpReason(aftExpRs.getString("EXP_REASON"));
		aftExp.setExpSts(aftExpRs.getString("EXP_STS"));
		aftExp.setOpNo(aftExpRs.getString("OP_NO"));
		aftExp.setTxDate(aftExpRs.getString("TX_DATE"));
		aftExp.setUpDate(aftExpRs.getString("UP_DATE"));
		return aftExp;
	}

	public static void main(String[] args) throws Exception {
		BusinessInitializer buz = new BusinessInitializer();
		buz.initialize();
		LoanExpandBatch loanExpandBatch = new LoanExpandBatch();
		boolean c = false;
		c = loanExpandBatch.doBatch("1", "2");
		if (!c) {
			throw new Exception("LoanExpandBatch");
		}
		System.out.println("����չ�� is OK!");
	}
}
