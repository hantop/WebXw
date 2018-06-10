package accounting.biz.loan;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import accounting.domain.biz.LoanRepay;
import accounting.domain.fee.AcChrgLog;
import accounting.domain.loan.AcDebit;
import accounting.domain.loan.AcLnLo;
import accounting.domain.loan.AcLnMst;
import accounting.domain.loan.AcLnPmLog;
import accounting.domain.loan.AcLnRepayPln;
import accounting.domain.sys.OperaInfo;
import accounting.plat.PUBConstant;
import accounting.plat.core.AccountingException;
import accounting.plat.dao.JdbcDao;
import accounting.plat.util.NumberUtil;
import accounting.plat.util.StringUtil;
import accounting.plat.util.TimeUtil;

/**
 * ����Ƿ����ҵ��
 * 
 * @project��nxnxnew
 * @className��RepayLoMortgageBiz
 */
public class RepayLoMortgageBiz {
	
	
	/**
	 * ��ý���µ��ܵļ�����Ϣ
	 * 
	 * @param loanNo
	 *            ��ݺ�
	 * @param conn
	 * @return
	 * @throws AccountingException
	 */
	public static AcLnRepayPln getWvAcLnRepayPln(String loanNo, Connection conn ,int perdNo)
			throws AccountingException {
		ResultSet rs = null;
		Statement st = null;
		AcLnRepayPln acLnRepayPln = new AcLnRepayPln();
		String sql = "SELECT SUM(wv_prcp_amt) wv_prcp_amt , SUM(wv_norm_int) wv_norm_int ,SUM(wv_fine_int) wv_fine_int FROM ac_ln_repay_pln WHERE loan_no ='"
				+ loanNo + "' AND PERD_NO >'"+perdNo+"'";

		try {
			rs = JdbcDao.executeQuery(st, rs, sql, conn);
			while (rs.next()) {
				acLnRepayPln.setWvPrcpAmt(rs.getDouble("wv_prcp_amt")); // ���ý��
				acLnRepayPln.setWvNormInt(rs.getDouble("wv_norm_int")); // �ۼ�ʵ�ս��
				acLnRepayPln.setWvFineInt(rs.getDouble("wv_fine_int")); // �������
			}
			st = rs.getStatement();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AccountingException(e);
		} finally {
			JdbcDao.close(st, rs);
		}

		return acLnRepayPln;
	}
	
	
	
	
	/**
	 * ��ÿһ�ڷ��ý��л���,�����ں�,����������,������ŵ�map��.
	 * 
	 * @param perdAmtMap
	 *            ���ÿһ��Ƿ��Ļ�����Ϣ,<�ں�,<�������,������>>
	 * @param amtType
	 *            �������
	 * @param remainAmt
	 *            �ɿ۽��
	 * @param acChrgLog
	 *            ���ñ�
	 * @param isAll
	 *            �Ƿ񹻻�ȫ��
	 * @return
	 */
	public static double dealRepayFeeAmt(Map<String, Map<String, Map<String, AcChrgLog>>> perdAmtMap, double remainAmt, AcChrgLog acChrgLog, boolean isAll) {
		double loAmt = 0;
		double txAmt = 0;// ʵ��
		double reAmt = acChrgLog.getRepayChrgAmt();// �ѻ�
		Map<String, Map<String, AcChrgLog>> tempMap = null;
		Map<String, AcChrgLog> tempMapFee = null;

		loAmt = NumberUtil.amtSubs(NumberUtil.amtSubs(acChrgLog.getChrgAmt(),acChrgLog.getRepayChrgAmt()), acChrgLog.getWvChrgAmt());
		// �����ȫ������
		if (isAll) {
			txAmt = loAmt;
			remainAmt = NumberUtil.amtSubs(remainAmt, txAmt);
		} else {
			// ������Ƿ��
			if (NumberUtil.isAmtGreat(loAmt, remainAmt)) {
				txAmt = remainAmt;
				remainAmt = 0;
			} else { // ����Ƿ��
				txAmt = loAmt;
				remainAmt = NumberUtil.amtSubs(remainAmt, loAmt);
			}
		}
		if (perdAmtMap.get(acChrgLog.getPerdNo()) == null) {
			tempMap = new HashMap<String, Map<String, AcChrgLog>>();

			if (tempMap.get(acChrgLog.getFeeKind()) == null) {
				tempMapFee = new HashMap<String, AcChrgLog>();
			} else {
				tempMapFee = tempMap.get(acChrgLog.getFeeKind());
			}
			
			acChrgLog.setRepayChrgAmt(NumberUtil.amtAdd(txAmt, reAmt));
			acChrgLog.setPayChrgAmt(txAmt);//����ʵ��
			tempMapFee.put(acChrgLog.getFeeType(), acChrgLog);

			tempMap.put(acChrgLog.getFeeKind(), tempMapFee);
			perdAmtMap.put(acChrgLog.getPerdNo(), tempMap);
		} else {
			tempMap = perdAmtMap.get(acChrgLog.getPerdNo());
			if (tempMap.get(acChrgLog.getFeeKind()) == null) {
				tempMapFee = new HashMap<String, AcChrgLog>();
			} else {
				tempMapFee = tempMap.get(acChrgLog.getFeeKind());
			}
			acChrgLog.setRepayChrgAmt(NumberUtil.amtAdd(txAmt, reAmt));
			acChrgLog.setPayChrgAmt(txAmt);//����ʵ��
			tempMapFee.put(acChrgLog.getFeeType(), acChrgLog);
			tempMap.put(acChrgLog.getFeeKind(), tempMapFee);

		}
		return remainAmt;
	}

	/**
	 * ����Ƿ����ҵ��:�����
	 * 
	 * @param acLnMst
	 *            �������ļ�
	 * @param traceCntHst
	 *            ������ϸ���еĽ��ױʴ�
	 * @param acLnSetlmtLog
	 *            �������־��
	 * @param txCode
	 *            ���״���
	 * @param operaInfo
	 *            ҵ���׶���
	 * 
	 * @return ���ױʴ�
	 * @throws AccountingException
	 */
	public static LoanRepay repayLoMortgageAmt(OperaInfo operaInfo,
			AcDebit acDebit, AcLnMst acLnMst, LoanRepay loanRepay, String txCode)
			throws AccountingException {

		Connection conn = operaInfo.getConn();

		// ��ô洢����Ƿ����list
		List<AcLnLo> acLnLoList = JdbcDao.queryList(new AcLnLo(), "loan_no='"
				+ acLnMst.getLoanNo() + "' and setl_sts='N'", "perd_no",
				"ac_ln_lo", conn);

		// ��û�����
		double repayAmt = acDebit.getRepayAmt();
		loanRepay.setRemainAmt(repayAmt);

		// ������ڴ���Ƿ����Ϣ,���Ȼ�����Ƿ��
		if (acLnLoList != null && acLnLoList.size() != 0) {
			// ��������ͻ���
			loanRepay = RepayLoMortgageBiz.repayLoMortgageByAmtType(operaInfo,
					acLnMst, acLnLoList, loanRepay, txCode);

		}

		return loanRepay;
	}

	/**
	 * ���ݽ�����Ϳ۳�Ƿ��
	 * 
	 * @param operaInfo
	 *            ҵ���������
	 * @param acLnMst
	 *            �������ļ�
	 * @param acLnSetlmtLog
	 *            �������־��
	 * @param loanRepay
	 *            ����������ڱ��淽���䴫�����ݵĶ���
	 * @param txCode
	 *            ���״���
	 * 
	 * @return ����������ڱ��淽���䴫�����ݵĶ���
	 * @throws AccountingException
	 */
	public static LoanRepay repayLoMortgageByAmtType(OperaInfo operaInfo,
			AcLnMst acLnMst, List<AcLnLo> acLnLoList, LoanRepay loanRepay,
			String txCode) throws AccountingException {
		Connection conn = operaInfo.getConn();

		double remainAmt = loanRepay.getRemainAmt();
		Map<String, Double> dcMap = new HashMap<String, Double>();
		String txDate = operaInfo.getTxDt();
		double ttlRepayAmt = 0;

		// ����пɿ۽��
		if (NumberUtil.isAmtGreatThanZero(remainAmt)) {

			String loanNo = acLnMst.getLoanNo();
			// ���ÿ�������ܵ�Ƿ����,�������aclnlo��
			AcLnLo sumAcLnLo = getSumAmt(loanNo, conn);
//			AcLnLo sumAcLnLo = (AcLnLo)JdbcDao.query(new AcLnLo(), "loan_no = '"+loanNo+"'", "ac_ln_lo", conn);
			// ��Ƿ������ں�Ϊ�������뵽map��
			Map<String, AcLnLo> acLnLoMap = StringUtil.changeListToMap("perdNo", acLnLoList);
			// ���ÿһ��,ÿ�ֽ�����͵Ļ�����
			Map<Integer, Map<String, Double>> perdAmtMap = new HashMap<Integer, Map<String, Double>>(); // <�ں�,<����,���>>
			// �ܵ�Ƿ�����
			double sumLoPrcpAmt = NumberUtil.amtSubs(NumberUtil.amtSubs(
					sumAcLnLo.getPrcpAmt(), sumAcLnLo.getRepayPrcpAmt()),
					sumAcLnLo.getWvPrcpAmt());
			// �ܵ�Ƿ������Ϣ���
			double sumLoNormInt = NumberUtil.amtSubs(NumberUtil.amtSubs(
					sumAcLnLo.getNormInt(), sumAcLnLo.getRepayNormInt()),
					sumAcLnLo.getWvNormInt());
			// �ܵ�Ƿ��Ϣ���
			double sumLoFineInt = NumberUtil.amtSubs(NumberUtil.amtSubs(
					sumAcLnLo.getFineInt(), sumAcLnLo.getRepayFineInt()),
					sumAcLnLo.getWvFineInt());

			// �ܵ�Ƿ����
			double sumLoAmt = NumberUtil.amtAdd(NumberUtil.amtAdd(sumLoPrcpAmt,
					sumLoNormInt), sumLoFineInt);

			// ���������<�ܵ�Ƿ����,����������Ƿ״̬ΪY
			if (NumberUtil.isAmtGreat(sumLoAmt, remainAmt)) {
				acLnMst.setDelqInd(PUBConstant.DELQ_IND_YES);
			} else {// ��Ƿ���,����������Ƿ״̬ΪN
				acLnMst.setDelqInd(PUBConstant.DELQ_IND_NO);
			}

			// ���������=��Ƿ���� && �������<��ǰӪҵ����,���´���״̬
			if (NumberUtil.isAmtGreatAndEqual(remainAmt, sumLoAmt)
					&& (TimeUtil.getBetweenDays(acLnMst.getMtrDt(), txDate) > acLnMst
							.getGraceDay())) {
				acLnMst.setLoanSts(PUBConstant.LOAN_STS_SETL);
			}
			// ��Ƿ��
			if (NumberUtil.isAmtGreatThanZero(sumLoAmt)) {
				// ��Ƿ�����
				if (NumberUtil.isAmtGreatThanZero(sumLoPrcpAmt)) {
					// ����ܵ�Ƿ�������ڿɿ۽��
					if (NumberUtil.isAmtGreat(sumLoPrcpAmt, remainAmt)) {
						// �������ļ����
						acLnMst.setLoanBal(NumberUtil.amtSubs(acLnMst
								.getLoanBal(), remainAmt));

						// ����Ƿ���
						for (int i = 0; i < acLnLoList.size(); i++) {
							AcLnLo acLnLo = acLnLoList.get(i);
							// ����ɿ۽�����0
							if (NumberUtil.isAmtGreatThanZero(remainAmt)) {
								// ��ÿһ�ڵ��ں�,�ۿ�������,�ۿ���ŵ�map��.
								remainAmt = dealRepayAmt(perdAmtMap,
										PUBConstant.LN_AMT_TYP_PRCP, remainAmt,
										acLnLo, false);

							} else {
								break;
							}
						}
					} else { // �ܵ�Ƿ�����С�ڵ��ڿɿ۽��
						// �������ļ����
						acLnMst.setLoanBal(NumberUtil.amtSubs(acLnMst
								.getLoanBal(), sumLoPrcpAmt));
						for (int i = 0; i < acLnLoList.size(); i++) {
							AcLnLo acLnLo = acLnLoList.get(i);
							// ��ÿһ�ڵ��ں�,�ۿ�������,�ۿ���ŵ�map��.
							remainAmt = dealRepayAmt(perdAmtMap,
									PUBConstant.LN_AMT_TYP_PRCP, remainAmt,
									acLnLo, true);
						}
					}

				} 
				if (NumberUtil.isAmtGreatThanZero(sumLoNormInt)) { // �������Ϊ������Ϣ,������Ƿ��������Ϣ
					// ����ܵ�Ƿ������Ϣ���ڿɿ۽��
					if (NumberUtil.isAmtGreat(sumLoNormInt, remainAmt)) {
						for (int i = 0; i < acLnLoList.size(); i++) {
							AcLnLo acLnLo = acLnLoList.get(i);
							if (NumberUtil.isAmtGreatThanZero(remainAmt)) {
								// ��ÿһ�ڵ��ں�,�ۿ�������,�ۿ���ŵ�map��.
								remainAmt = dealRepayAmt(perdAmtMap,
										PUBConstant.LN_AMT_TYP_CRI, remainAmt,
										acLnLo, false);
							} else {
								break;
							}
						}
					} else { // �ܵ�Ƿ������ϢС�ڵ��ڿɿ۽��
						for (int i = 0; i < acLnLoList.size(); i++) {
							AcLnLo acLnLo = acLnLoList.get(i);
							// ��ÿһ�ڵ��ں�,�ۿ�������,�ۿ���ŵ�map��.
							remainAmt = dealRepayAmt(perdAmtMap,
									PUBConstant.LN_AMT_TYP_CRI, remainAmt,
									acLnLo, true);
						}
					}
				} 
				if (NumberUtil.isAmtGreatThanZero(sumLoFineInt)) {// ��Ƿ��Ϣ
					// ����ܵ�Ƿ��Ϣ�����ڿɿ۽��
					if (NumberUtil.isAmtGreat(sumLoFineInt, remainAmt)) {
						for (int i = 0; i < acLnLoList.size(); i++) {
							AcLnLo acLnLo = acLnLoList.get(i);
							if (NumberUtil.isAmtGreatThanZero(remainAmt)) {
								// ��ÿһ�ڵ��ں�,�ۿ�������,�ۿ���ŵ�map��.
								remainAmt = dealRepayAmt(perdAmtMap,
										PUBConstant.LN_AMT_TYP_ODI, remainAmt,
										acLnLo, false);
							} else {
								break;
							}
						}
					} else { // �ܵ�Ƿ����������Ϣ���С�ڵ��ڿɿ۽��
						for (int i = 0; i < acLnLoList.size(); i++) {
							AcLnLo acLnLo = acLnLoList.get(i);
							// ��ÿһ�ڵ��ں�,�ۿ�������,�ۿ���ŵ�map��.
							remainAmt = dealRepayAmt(perdAmtMap,
									PUBConstant.LN_AMT_TYP_ODI, remainAmt,
									acLnLo, true);
						}
					}
				}

				// ����map,�鿴��ЩǷ�����еĻ������,������Ƿ���,���뻹����ϸ��,������ϸ��.
				for (Integer perdNo : perdAmtMap.keySet()) {

					double perdRepayPrcpAmt = 0; // ���ڱ��λ������
					double perdRepayNormInt = 0; // ���ڱ��λ�������Ϣ���
					double perdRepayFineInt = 0; // ���ڱ��η�Ϣ���

					if (perdAmtMap.get(perdNo).get(PUBConstant.LN_AMT_TYP_PRCP) != null) {
						perdRepayPrcpAmt = perdAmtMap.get(perdNo).get(
								PUBConstant.LN_AMT_TYP_PRCP);
					}
					if (perdAmtMap.get(perdNo).get(PUBConstant.LN_AMT_TYP_CRI) != null) {
						perdRepayNormInt = perdAmtMap.get(perdNo).get(
								PUBConstant.LN_AMT_TYP_CRI);
					}
					if (perdAmtMap.get(perdNo).get(PUBConstant.LN_AMT_TYP_ODI) != null) {
						perdRepayFineInt = perdAmtMap.get(perdNo).get(
								PUBConstant.LN_AMT_TYP_ODI);
					}
					// ��õ�ǰ�ںŵ�Ƿ���
					AcLnLo acLnLo = acLnLoMap.get(String.valueOf(perdNo));

					// ��Ƿ���ֵ
					acLnLo.setRepayPrcpAmt(NumberUtil.amtAdd(acLnLo
							.getRepayPrcpAmt(), perdRepayPrcpAmt));
					acLnLo.setRepayNormInt(NumberUtil.amtAdd(acLnLo
							.getRepayNormInt(), perdRepayNormInt));
					acLnLo.setRepayFineInt(NumberUtil.amtAdd(acLnLo
							.getRepayFineInt(), perdRepayFineInt));

					// ��鵱��Ƿ����Ƿ���
					if (chargePayOff(acLnLo)) {
						acLnLo.setPrcpSts(PUBConstant.AMT_STS_SETL);
						acLnLo.setIntSts(PUBConstant.AMT_STS_SETL);
						acLnLo.setSetlSts(PUBConstant.Y);
						acLnLo.setSetlDt(txDate);
					} else {
						acLnMst.setDelqInd(PUBConstant.DELQ_IND_YES);
					}

					// �ܵĻ�����
					ttlRepayAmt = NumberUtil.amtAdd(NumberUtil.amtAdd(NumberUtil.amtAdd(ttlRepayAmt,
									perdRepayPrcpAmt), perdRepayNormInt),perdRepayFineInt);

                   //	 ������ϸ��
					AcLnPmLog acLnPmLog = makeAcLnPmLog(operaInfo, acLnLo,
							perdRepayPrcpAmt, perdRepayNormInt,perdRepayFineInt);
					JdbcDao.insert(acLnPmLog, "ac_ln_pm_log", conn);

					try {
						RepayBiz.PROC_REACC_FUND(acLnMst.getLoanNo(), perdRepayPrcpAmt, perdRepayNormInt,"�ۿ�����","ADD", conn);
					} catch (Exception e) {
						e.printStackTrace();
					}
					
					String sql = "update ac_ln_repay_pln set repay_prcp_amt="
							+ acLnLo.getRepayPrcpAmt() + " ,repay_norm_int="
							+ acLnLo.getRepayNormInt() + " , repay_fine_int ="
							+ acLnLo.getRepayFineInt() + " ,INT_STS ='"
							+ acLnLo.getIntSts() + "' , SETL_STS='"
							+ acLnLo.getSetlSts() + "' ,lst_pay_dt='" + txDate
							+ "'";
					JdbcDao.excuteUpdateSql(sql + " where loan_no='"
							+ acLnLo.getLoanNo() + "' and perd_no=" + perdNo,
							conn);

					// ����Ƿ�����Ҫ�Ǳ���״̬����Ϣ״̬������״̬
					JdbcDao.update(acLnLo, "loan_no='" + acLnLo.getLoanNo()
							+ "' and perd_no=" + perdNo, "ac_ln_lo", conn);


				}
			}
		}

		acLnMst.setLstDt(txDate); // �ϱʽ�������
		acLnMst.setLastSetlDt(txDate); // �ϴοۿ���

		loanRepay.setRepayedAmt(ttlRepayAmt); // �����ܻ�����
		loanRepay.setRemainAmt(remainAmt); // �ɿ۽��
		loanRepay.setDcMap(dcMap); // ��¼<�������, ���>map

		return loanRepay;

	}

	/**
	 * ��ý���µ��ܵ�Ƿ����Ϣ
	 * 
	 * @param loanNo
	 *            ��ݺ�
	 * @param conn
	 * @return
	 * @throws AccountingException
	 */
	public static AcLnLo getSumAmt(String loanNo, Connection conn)
			throws AccountingException {
		ResultSet rs = null;
		Statement st = null;
		AcLnLo acLnLo = new AcLnLo();
		String sql = "SELECT SUM(PRCP_AMT) PRCP_AMT,SUM(NORM_INT) NORM_INT,SUM(FINE_INT) FINE_INT,SUM(REPAY_PRCP_AMT) REPAY_PRCP_AMT,SUM(REPAY_NORM_INT) REPAY_NORM_INT,SUM(REPAY_FINE_INT) REPAY_FINE_INT,SUM(WV_PRCP_AMT) WV_PRCP_AMT,SUM(WV_NORM_INT) WV_NORM_INT,SUM(WV_FINE_INT) WV_FINE_INT FROM AC_LN_LO WHERE LOAN_NO='"
				+ loanNo + "' and SETL_STS='" + PUBConstant.N + "'";
		
		try {
			rs = JdbcDao.executeQuery(st,rs,sql, conn);
			while (rs.next()) {
				acLnLo.setPrcpAmt(rs.getDouble("PRCP_AMT")); // ����
				acLnLo.setNormInt(rs.getDouble("NORM_INT")); // ������Ϣ
				acLnLo.setFineInt(rs.getDouble("FINE_INT")); // ������Ϣ
				acLnLo.setRepayPrcpAmt(rs.getDouble("REPAY_PRCP_AMT")); // �ѻ�����
				acLnLo.setRepayNormInt(rs.getDouble("REPAY_NORM_INT")); // �ѻ�������Ϣ
				acLnLo.setRepayFineInt(rs.getDouble("REPAY_FINE_INT")); // �ѻ���Ϣ��Ϣ
				acLnLo.setWvPrcpAmt(rs.getDouble("WV_PRCP_AMT")); // ���Ȿ��
				acLnLo.setWvNormInt(rs.getDouble("WV_NORM_INT")); // ����������Ϣ
				acLnLo.setWvFineInt(rs.getDouble("WV_FINE_INT")); // ���ⷣϢ��Ϣ
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AccountingException(e);
		}finally{
			JdbcDao.close(st, rs);
		}

		return acLnLo;
	}

	/**
	 * ��ÿһ��Ƿ����л���,�����ں�,����������,������ŵ�map��.
	 * 
	 * @param perdAmtMap
	 *            ���ÿһ��Ƿ��Ļ�����Ϣ,<�ں�,<�������,������>>
	 * @param amtType
	 *            �������
	 * @param remainAmt
	 *            �ɿ۽��
	 * @param acLnLo
	 *            Ƿ���
	 * @param isAll
	 *            �Ƿ񹻻�ȫ��
	 * @return
	 */
	public static double dealRepayAmt(
			Map<Integer, Map<String, Double>> perdAmtMap, String amtType,
			double remainAmt, AcLnLo acLnLo, boolean isAll) {
		double loAmt = 0;
		double txAmt = 0;
		Map<String, Double> tempMap = null;
		// ���ݻ���������ȡ������Ƿ������Ӧ��Ƿ����
		if (amtType.equals(PUBConstant.LN_AMT_TYP_PRCP)) {
			loAmt = NumberUtil.amtSubs(NumberUtil.amtSubs(acLnLo.getPrcpAmt(),
					acLnLo.getRepayPrcpAmt()), acLnLo.getWvPrcpAmt());
		} else if (amtType.equals(PUBConstant.LN_AMT_TYP_CRI)) {
			loAmt = NumberUtil.amtSubs(NumberUtil.amtSubs(acLnLo.getNormInt(),
					acLnLo.getRepayNormInt()), acLnLo.getWvNormInt());
		} else if (amtType.equals(PUBConstant.LN_AMT_TYP_ODI)) {
			loAmt = NumberUtil.amtSubs(NumberUtil.amtSubs(acLnLo.getFineInt(),
					acLnLo.getRepayFineInt()), acLnLo.getWvFineInt());
		}
		// �����ȫ������
		if (isAll) {
			txAmt = loAmt;
			remainAmt = NumberUtil.amtSubs(remainAmt, txAmt);
		} else {
			// ������Ƿ��
			if (NumberUtil.isAmtGreat(loAmt, remainAmt)) {
				txAmt = remainAmt;
				remainAmt = 0;
			} else { // ����Ƿ��
				txAmt = loAmt;
				remainAmt = NumberUtil.amtSubs(remainAmt, loAmt);
			}
		}
		if (perdAmtMap.get(acLnLo.getPerdNo()) == null) {
			tempMap = new HashMap<String, Double>();
			tempMap.put(amtType, txAmt);
			perdAmtMap.put(acLnLo.getPerdNo(), tempMap);
		} else {
			tempMap = perdAmtMap.get(acLnLo.getPerdNo());
			tempMap.put(amtType, txAmt);
		}

		return remainAmt;
	}
	
	/**
	 * �ж��Ƿ��ѻ���
	 * 
	 * @param acLnLo
	 *            ����Ƿ���
	 * @return true �ѻ���,false δ����
	 */
	public static boolean chargePayOff(AcLnLo acLnLo) {

		boolean flag = false;

		double txPrcp = NumberUtil.amtSubs(NumberUtil.amtSubs(acLnLo.getPrcpAmt(), acLnLo.getRepayPrcpAmt()), acLnLo.getWvPrcpAmt()); // ��Ƿ����
		double txNorm = NumberUtil.amtSubs(NumberUtil.amtSubs(acLnLo.getNormInt(), acLnLo.getRepayNormInt()),acLnLo.getWvNormInt()); // ��Ƿ������Ϣ
		double txFine = NumberUtil.amtSubs(NumberUtil.amtSubs(acLnLo.getFineInt(), acLnLo.getRepayFineInt()),acLnLo.getWvFineInt()); // ��Ƿ��Ϣ
		
		double ttlAmt = NumberUtil.amtAdd(NumberUtil.amtAdd(txFine, txNorm), txPrcp);
		
		// ���������
		if (NumberUtil.isAmtEqualZero(ttlAmt)) {
			flag = true;
		}
		return flag;
	}
	
	/**
	 * ��װ������ϸ��־��
	 * 
	 * @param operaInfo
	 * 			  ҵ���׶���
	 * @param acLnLo
	 *            ����Ƿ���
	 * @param prcpAmt
	 *            ����
	 * @param normInt
	 *            ��Ϣ
	 * @param fineInt
	 *            ��Ϣ
	 *            
	 * @return
	 * @throws AccountingException
	 */
	public static AcLnPmLog makeAcLnPmLog(OperaInfo operaInfo, AcLnLo acLnLo, double prcpAmt, double normInt, double fineInt) throws AccountingException {
		AcLnPmLog acLnPmLog = new AcLnPmLog();

		acLnPmLog.setTraceNo(operaInfo.getTraceNo()); // ������ˮ��
		acLnPmLog.setPactNo(acLnLo.getPactNo());
		acLnPmLog.setBrNo(acLnLo.getBrNo());
		acLnPmLog.setTxDt(operaInfo.getBizDt()); // ҵ��������
		acLnPmLog.setRepayNormInt(normInt); // ��Ϣ
		acLnPmLog.setRepayFineInt(fineInt); // ��Ϣ
		acLnPmLog.setRepayPrcpAmt(prcpAmt); // ������
		acLnPmLog.setLoanNo(acLnLo.getLoanNo());
		acLnPmLog.setPerdNo(String.valueOf(acLnLo.getPerdNo()));
		acLnPmLog.setIntSts(acLnLo.getIntSts());
		acLnPmLog.setPrcpSts(acLnLo.getPrcpSts());
		acLnPmLog.setCancelInd(PUBConstant.REV_ROL_NORM);

		return acLnPmLog;
	}
}
