package accounting.biz.loan;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import accounting.biz.pub.AcLnRepayPlnBiz;
import accounting.domain.biz.LoanRepay;
import accounting.domain.fee.AcChrgLog;
import accounting.domain.loan.AcDebit;
import accounting.domain.loan.AcLnLo;
import accounting.domain.loan.AcLnMst;
import accounting.domain.loan.AcLnPmLog;
import accounting.domain.loan.AcLnRepayDtlSeq;
import accounting.domain.loan.AcLnRepayPln;
import accounting.domain.loan.AcLnRepayPlnCur;
import accounting.domain.loan.AcLoanBackLog;
import accounting.domain.loan.PrdtBase;
import accounting.domain.sys.OperaInfo;
import accounting.plat.PUBConstant;
import accounting.plat.TransCode;
import accounting.plat.core.AccountingException;
import accounting.plat.dao.JdbcDao;
import accounting.plat.util.NumberUtil;
import accounting.plat.util.TimeUtil;
import accounting.plat.util.TransUtil;
import app.creditapp.aft.entity.AftCompst;

/**
 * �ۿ������
 * 
 * @project��nxnxnew
 * @className��RepayBiz
 * @author��su
 */
public class RepayBiz {
	
	
	
	/**
	 * ��������˳������
	 * @param acdebit
	 * @param op
	 * @param conn
	 */
	public static void repayAmtOrder(AcLnRepayPlnCur acLCur,AcDebit acDebit ,OperaInfo operaInfo ,Connection conn){
		double ttlAmt = acDebit.getRepayAmt();
		LoanRepay loanRepay = new LoanRepay() ;
			double prcpAmtCur = 0;
			double prcpIntCur = 0;
//			double amt  = NumberUtil.amtAdd(NumberUtil.amtAdd(acDebit.getLoAmt(), acDebit.getOtherFeeAmt()),acDebit.getMyFeeAmt());

//			if (NumberUtil.isAmtGreatThanZero(amt)) {// Ƿ�����0����Ƿ��
				try {
					loanRepay = RepayBiz.repayLoForBatch(acDebit, operaInfo, conn);
				} catch (AccountingException e) {
					e.printStackTrace();
				}
				ttlAmt = loanRepay.getRemainAmt();//�۳�Ƿ���Ŀɿڽ��
//			}
			if(acLCur!=null){
				double prcpCur = NumberUtil.amtSubs(NumberUtil.amtSubs(acLCur.getPrcpAmt(),acLCur.getRepayPrcpAmt()),acLCur.getWvPrcpAmt());
				double normIntCur = NumberUtil.amtSubs(NumberUtil.amtSubs(acLCur.getNormInt(),acLCur.getRepayNormInt()),acLCur.getWvNormInt());
				double ttlAmtCur =NumberUtil.amtAdd(prcpCur, normIntCur);
				if (NumberUtil.isAmtGreatThanZero(ttlAmtCur)&&NumberUtil.isAmtGreatThanZero(ttlAmt)) {// ���ڿۿ����0���嵱��
					acDebit.setRepayAmt(ttlAmt);//�۳�Ƿ���Ŀɿڽ��
					
					acDebit.setCurAmt(ttlAmtCur);//���ڽ��
					try {
						loanRepay = RepayBiz.repayCurForBatch(acDebit, operaInfo);
					} catch (AccountingException e1) {
						e1.printStackTrace();
					}
					prcpAmtCur = loanRepay.getDcMap().get(PUBConstant.LN_AMT_TYP_PRCP);//�����ڱ���
					prcpIntCur = loanRepay.getDcMap().get(PUBConstant.LN_AMT_TYP_CRI);//��������Ϣ
					
					try {
						PROC_REACC_FUND(acDebit.getLoanNo(),prcpAmtCur,prcpIntCur,"�ۿ�����","ADD",operaInfo.getConn());
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
	}

	
	/**
	 * �ۿ��������۵��ڣ�
	 * @param acLmAtpy
	 * @param traceCnt
	 * @param conn
	 * @throws AccountingException
	 */
	public static LoanRepay repayCurForBatch(AcDebit acDebit, OperaInfo operaInfo)throws AccountingException{

		String loanNo = acDebit.getLoanNo();
		double repayAmt = acDebit.getRepayAmt();
		double curAmt = acDebit.getCurAmt();
		String txDate = operaInfo.getBizDt();
		// ��ô������ļ�
		AcLnMst acLnMst = (AcLnMst)JdbcDao.query(new AcLnMst(), "loan_no='"+loanNo+"'", "ac_ln_mst", operaInfo.getConn());
		String curDueDt = acLnMst.getCurDueDt();
		String nextDueDt = acLnMst.getNextDueDt();
//		String curDueDt = "20171106";
//		String nextDueDt ="20171228";
		
		//��ȡ����������Ϣ
//		CorpBase corpBase = (CorpBase) JdbcDao.query(new CorpBase(), "br_no='"+acLnMst.getBrNo()+"'", "CORP_BASE", operaInfo.getConn());
		// ��ú��������
		PrdtBase prdtBase = (PrdtBase) JdbcDao.query(new PrdtBase(), "prdt_no='"+acLnMst.getPrdtNo()+"'", "PRDT_BASE", operaInfo.getConn());

		if (prdtBase == null) {
			throw new AccountingException("��ѯ������Ӧ��Ʒ����Ϣ!");
		}
		
		List<AcLnRepayDtlSeq>  acLnRepayDtlSeqList = (ArrayList)JdbcDao.queryList(new AcLnRepayDtlSeq(), "REPAY_SEQ_CDE='"+prdtBase.getRepaySeqCde()+"'","REPAY_SEQ","asc", "AC_LN_REPAY_DTL_SEQ", operaInfo.getConn());
		
		//�ۿ��ն�Ӧ�Ļ���ƻ����ڱ�����
		AcLnRepayPlnCur oldAcLnRepayPlnCur = (AcLnRepayPlnCur) JdbcDao.query(new AcLnRepayPlnCur(), "loan_no='"+loanNo+"'" , "ac_ln_repay_pln_cur", operaInfo.getConn());
		int perdNo = oldAcLnRepayPlnCur.getPerdNo();
		int nextPerdNo = perdNo + 1;
		
		AcLnRepayPln oldAcLnRepayPln = (AcLnRepayPln) JdbcDao.query(new AcLnRepayPln(), "loan_no='"+loanNo+"' and perd_no=" + perdNo, "ac_ln_repay_pln", operaInfo.getConn());
		
		List<AcChrgLog> acChrgLogList = (ArrayList)JdbcDao.queryList(new AcChrgLog(), "loan_no='"+loanNo+"' and perd_no='" + perdNo+"' and chrg_sts in ('01','02')","ac_chrg_log", operaInfo.getConn());
		
		// ����Ӧ��������Ϣ
		double prcpAmt = NumberUtil.amtSubs(NumberUtil.amtSubs(oldAcLnRepayPlnCur.getPrcpAmt(), oldAcLnRepayPlnCur.getRepayPrcpAmt()),oldAcLnRepayPlnCur.getWvPrcpAmt());
		double normInt = NumberUtil.amtSubs(NumberUtil.amtSubs(oldAcLnRepayPlnCur.getNormInt(), oldAcLnRepayPlnCur.getRepayNormInt()),oldAcLnRepayPlnCur.getWvNormInt());
		
		// ���ÿһ��,ÿ�ֽ�����͵Ļ�����
		Map<String, Map<String, Map<String, AcChrgLog>>> perdFeeAmtMap = new HashMap<String, Map<String, Map<String, AcChrgLog>>>(); // <�ں�,<����,���>>
		
		// ��õ����ڽɷ�
		double lnaaAmtF = 0;//���ڷ�����ܶ�
		double lnaaAmtB = 0;//���ڱ����ܶ�
		double lnaaAmtW = 0;//����ΥԼ���ܶ�
		for(AcChrgLog acChrgLog : acChrgLogList){
			if(PUBConstant.FEE_TYPE_01.equals(acChrgLog.getFeeType())){
				lnaaAmtF = NumberUtil.amtAdd(NumberUtil.amtSubs(NumberUtil.amtSubs(acChrgLog.getChrgAmt(), acChrgLog.getRepayChrgAmt()),acChrgLog.getWvChrgAmt()), lnaaAmtF);
			}else if(PUBConstant.FEE_TYPE_02.equals(acChrgLog.getFeeType())){
				lnaaAmtB = NumberUtil.amtAdd(NumberUtil.amtSubs(NumberUtil.amtSubs(acChrgLog.getChrgAmt(), acChrgLog.getRepayChrgAmt()),acChrgLog.getWvChrgAmt()), lnaaAmtB);
			}else if(PUBConstant.FEE_TYPE_06.equals(acChrgLog.getFeeType())){
				lnaaAmtW = NumberUtil.amtAdd(NumberUtil.amtSubs(NumberUtil.amtSubs(acChrgLog.getChrgAmt(), acChrgLog.getRepayChrgAmt()),acChrgLog.getWvChrgAmt()), lnaaAmtW);
			}
		}
		//���λ�������Ϣ
		double repayPrcpAmt = 0;
		double repayNormInt = 0; 
		String prcpSts = "";
		String intSts = "";
		// �۳���Ƿ���Ļ�����
		double remAmt = repayAmt;
//		double feeAmtTotal = NumberUtil.amtAdd(NumberUtil.amtAdd(lnaaAmtF, lnaaAmtB),lnaaAmtW);
		//��ΥԼ��
		if(NumberUtil.isAmtGreatThanZero(remAmt)&&NumberUtil.isAmtGreatThanZero(lnaaAmtW)){
			if (NumberUtil.isAmtGreat(lnaaAmtW, remAmt)) {
				for(AcChrgLog acChrgLog : acChrgLogList){
					if(PUBConstant.FEE_TYPE_06.equals(acChrgLog.getFeeType())){
						remAmt = RepayLoMortgageBiz.dealRepayFeeAmt(perdFeeAmtMap,remAmt,acChrgLog, false);
					}
				}
			} else {
				for(AcChrgLog acChrgLog : acChrgLogList){
					if(PUBConstant.FEE_TYPE_06.equals(acChrgLog.getFeeType())){
						remAmt = RepayLoMortgageBiz.dealRepayFeeAmt(perdFeeAmtMap,remAmt,acChrgLog, true);
					}
				}
			}
		}
		
		Map<String, Double> dcMap = new HashMap<String, Double>();
		LoanRepay loanRepay = new LoanRepay();
		// ������ڵ���Ӧ�۽����ɻ�������0
		if (NumberUtil.isAmtGreatThanZero(curAmt) && NumberUtil.isAmtGreatThanZero(remAmt)) {
			
			double curPrcpAmt = NumberUtil.amtSubs(NumberUtil.amtSubs(oldAcLnRepayPlnCur.getPrcpAmt(), oldAcLnRepayPlnCur.getRepayPrcpAmt()),oldAcLnRepayPlnCur.getWvPrcpAmt());
			double curNormInt = NumberUtil.amtSubs(NumberUtil.amtSubs(oldAcLnRepayPlnCur.getNormInt(), oldAcLnRepayPlnCur.getRepayNormInt()),oldAcLnRepayPlnCur.getWvNormInt());
			double curTtlAmt = NumberUtil.amtAdd(NumberUtil.amtAdd(NumberUtil.amtAdd(curPrcpAmt, curNormInt),lnaaAmtB),lnaaAmtF);//������

			// ���������ڵ�
			if (NumberUtil.isAmtGreat(remAmt,curTtlAmt)) {
				out:
				if (NumberUtil.isAmtGreatThanZero(remAmt)) {
					for(AcLnRepayDtlSeq acLnRepayDtlSeq : acLnRepayDtlSeqList){
						if("01".equals(acLnRepayDtlSeq.getRepayAmtTyp())){//����
							if (NumberUtil.isAmtGreatAndEqual(remAmt, prcpAmt)) {
								repayPrcpAmt = prcpAmt;
								remAmt = NumberUtil.amtSubs(remAmt, repayPrcpAmt);
							} else {
								repayPrcpAmt = remAmt;
								remAmt = NumberUtil.amtSubs(remAmt, repayPrcpAmt);
							}
						}else if("02".equals(acLnRepayDtlSeq.getRepayAmtTyp())){//��Ϣ
							if (NumberUtil.isAmtGreatAndEqual(remAmt, normInt)) {
								repayNormInt = normInt;
								remAmt = NumberUtil.amtSubs(remAmt, repayNormInt);
							} else {
								repayNormInt = remAmt;
								remAmt = NumberUtil.amtSubs(remAmt, repayNormInt);
							}
						}else if("04".equals(acLnRepayDtlSeq.getRepayAmtTyp())){//�����
							if (NumberUtil.isAmtGreat(lnaaAmtF, remAmt)) {
								for(AcChrgLog acChrgLog : acChrgLogList){
									if(NumberUtil.isAmtGreatThanZero(remAmt)){
										if(PUBConstant.FEE_TYPE_01.equals(acChrgLog.getFeeType())){
											remAmt = RepayLoMortgageBiz.dealRepayFeeAmt(perdFeeAmtMap,remAmt,acChrgLog, false);
										}
									}else{
										break out;
									}
								}
							} else {
								for(AcChrgLog acChrgLog : acChrgLogList){
									if(NumberUtil.isAmtGreatThanZero(remAmt)){
										if(PUBConstant.FEE_TYPE_01.equals(acChrgLog.getFeeType())){
											remAmt = RepayLoMortgageBiz.dealRepayFeeAmt(perdFeeAmtMap,remAmt,acChrgLog, true);
										}
									}else{
										break out;
									}
								}
							}
						}else if("05".equals(acLnRepayDtlSeq.getRepayAmtTyp())){//����
							if (NumberUtil.isAmtGreat(lnaaAmtB, remAmt)) {
								for(AcChrgLog acChrgLog : acChrgLogList){
									if(NumberUtil.isAmtGreatThanZero(remAmt)){
										if(PUBConstant.FEE_TYPE_02.equals(acChrgLog.getFeeType())){
											remAmt = RepayLoMortgageBiz.dealRepayFeeAmt(perdFeeAmtMap,remAmt,acChrgLog, false);
										}
									}else{
										break out;
									}
								}
							} else {
								for(AcChrgLog acChrgLog : acChrgLogList){
									if(NumberUtil.isAmtGreatThanZero(remAmt)){
										if(PUBConstant.FEE_TYPE_02.equals(acChrgLog.getFeeType())){
											remAmt = RepayLoMortgageBiz.dealRepayFeeAmt(perdFeeAmtMap,remAmt,acChrgLog, true);
										}
									}else{
										break out;
									}
								}
							}
						}
					}
				
				}

				if(NumberUtil.isAmtGreatAndEqual(repayPrcpAmt, prcpAmt)||NumberUtil.isAmtLessThanOrEqualZero(prcpAmt)){
					prcpSts = PUBConstant.AMT_STS_NORMAL;
				}else{
					prcpSts = PUBConstant.AMT_STS_DELQ;
				}
				
				if(NumberUtil.isAmtGreatAndEqual(repayNormInt, normInt)||NumberUtil.isAmtLessThanOrEqualZero(normInt)){
					intSts = PUBConstant.AMT_STS_NORMAL;
				}else{
					intSts = PUBConstant.AMT_STS_DELQ;
				}
				
				oldAcLnRepayPln.setRepayPrcpAmt(NumberUtil.amtAdd(oldAcLnRepayPln.getRepayPrcpAmt(), repayPrcpAmt));
				oldAcLnRepayPln.setRepayNormInt(NumberUtil.amtAdd(oldAcLnRepayPln.getRepayNormInt(), repayNormInt));
				oldAcLnRepayPln.setPrcpSts(prcpSts);
				oldAcLnRepayPln.setIntSts(intSts);
				oldAcLnRepayPln.setLstPayDt(txDate);
				JdbcDao.update(oldAcLnRepayPln, "loan_no='"+loanNo+"' and perd_no="+perdNo, "ac_ln_repay_pln", operaInfo.getConn());
				System.out.println("���»���ƻ���1");
				
				//���뻹����ϸ��
				AcLnPmLog acLnPmLog = new AcLnPmLog();
				AftCompst act = null;
				acLnPmLog.setTraceNo(operaInfo.getTraceNo()); 
				acLnPmLog.setTxDt(txDate); 
				acLnPmLog.setRepayNormInt(repayNormInt); 
				acLnPmLog.setRepayPrcpAmt(repayPrcpAmt);
				acLnPmLog.setRepayFeeAmt(0);
				acLnPmLog.setLoanNo(oldAcLnRepayPln.getLoanNo());
				acLnPmLog.setPactNo(oldAcLnRepayPln.getPactNo());
				acLnPmLog.setBrNo(oldAcLnRepayPln.getBrNo());
				acLnPmLog.setPerdNo(String.valueOf(oldAcLnRepayPln.getPerdNo()));
				acLnPmLog.setIntSts(oldAcLnRepayPln.getIntSts());
				acLnPmLog.setPrcpSts(oldAcLnRepayPln.getPrcpSts());
				acLnPmLog.setCancelInd(PUBConstant.REV_ROL_NORM);
				act=(AftCompst) JdbcDao.query(new AftCompst(),"pact_no='"+acLnMst.getPactNo()+"' and perd_no='"+oldAcLnRepayPln.getPerdNo()+"'and br_no='"+acLnMst.getBrNo()+"'","aft_compst", operaInfo.getConn());
				if(null==act || "".equals(act)){
					acLnPmLog.setComPst("01");//01����	
				}else{
					acLnPmLog.setComPst("02");//02����
				}
				JdbcDao.insert(acLnPmLog, "ac_ln_pm_log", operaInfo.getConn());
				// �ѹ�������
				if(TimeUtil.checkDate2AfterDate1(oldAcLnRepayPlnCur.getEndDt(),txDate )){
					JdbcDao.delete("loan_no='"+loanNo+"'", "ac_ln_repay_pln_cur", operaInfo.getConn());
					AcLnRepayPln acLnRepayPln = (AcLnRepayPln) JdbcDao.query(new AcLnRepayPln(), "loan_no='"+loanNo+"' and perd_no=" + nextPerdNo, "ac_ln_repay_pln", operaInfo.getConn());
					if (acLnRepayPln != null) {
						AcLnRepayPlnCur newAcLnRepayPlnCur = AcLnRepayPlnBiz.getAcLnRepayPlnCur(acLnRepayPln, acLnMst, txDate);
						 curDueDt = newAcLnRepayPlnCur.getPayDt();
						nextDueDt = newAcLnRepayPlnCur.getPayDt();
						JdbcDao.insert(newAcLnRepayPlnCur, "ac_ln_repay_pln_cur", operaInfo.getConn());
					}
					AcLnLo acLnLo = new AcLnLo();
					TransUtil.copyProperties(oldAcLnRepayPlnCur, acLnLo);
					acLnLo.setSetlSts(PUBConstant.N);
					acLnLo.setOverDt(txDate);
						
					acLnLo.setFineIntDt(txDate);
					acLnLo.setRepayPrcpAmt(oldAcLnRepayPln.getRepayPrcpAmt());
					acLnLo.setRepayNormInt(oldAcLnRepayPln.getRepayNormInt());
					acLnLo.setPrcpSts(PUBConstant.AMT_STS_OVER);
					acLnLo.setIntSts(PUBConstant.AMT_STS_OVER);
					JdbcDao.insert(acLnLo, "ac_ln_lo", operaInfo.getConn());
					
					//����ԭ����ƻ����ڱ�־
					oldAcLnRepayPln.setOverInd(PUBConstant.Y);
					JdbcDao.update(oldAcLnRepayPln, "loan_no='"+loanNo+"' and perd_no="+perdNo, "ac_ln_repay_pln", operaInfo.getConn());

				}else{
					oldAcLnRepayPlnCur.setRepayPrcpAmt(NumberUtil.amtAdd(oldAcLnRepayPlnCur.getRepayPrcpAmt(), repayPrcpAmt));
					oldAcLnRepayPlnCur.setRepayNormInt(NumberUtil.amtAdd(oldAcLnRepayPlnCur.getRepayNormInt(), repayNormInt));
					JdbcDao.update(oldAcLnRepayPlnCur, "loan_no='"+loanNo+"'", "ac_ln_repay_pln_cur", operaInfo.getConn());
				}
				acLnMst.setDelqInd(PUBConstant.DELQ_IND_YES);
				
			} else { // �������ڵ�
				repayPrcpAmt = prcpAmt;//��
				repayNormInt = normInt;
				prcpSts = PUBConstant.INT_STS_40;
				intSts = PUBConstant.INT_STS_40;
				
				oldAcLnRepayPln.setSetlSts(PUBConstant.Y);
				oldAcLnRepayPln.setIntSts(intSts);	
				oldAcLnRepayPln.setPrcpSts(prcpSts);
				oldAcLnRepayPln.setRepayPrcpAmt(NumberUtil.amtAdd(oldAcLnRepayPln.getRepayPrcpAmt(), repayPrcpAmt));
				oldAcLnRepayPln.setRepayNormInt(NumberUtil.amtAdd(oldAcLnRepayPln.getRepayNormInt(), repayNormInt));
				oldAcLnRepayPln.setLstPayDt(txDate);
				JdbcDao.update(oldAcLnRepayPln, "loan_no='"+loanNo+"' and perd_no="+perdNo, "ac_ln_repay_pln", operaInfo.getConn());
				System.out.println("���»���ƻ���2");
				
				
				//�������ڸ��·���״̬Ϊ�ѽ���
				double repayChrgAmt = 0;//�����ѻ�����
				for(AcChrgLog acChrgLog : acChrgLogList){
					repayChrgAmt = NumberUtil.amtSubs(NumberUtil.amtSubs(acChrgLog.getChrgAmt(), acChrgLog.getRepayChrgAmt()),acChrgLog.getWvChrgAmt());
					acChrgLog.setRepayChrgAmt(NumberUtil.amtAdd(acChrgLog.getRepayChrgAmt(), repayChrgAmt));
					acChrgLog.setUpDate(operaInfo.getBizDt());
					JdbcDao.update(acChrgLog, "chrg_id='"+acChrgLog.getChrgId()+"'", "ac_chrg_log", operaInfo.getConn());
				}
				
				AcLnPmLog acLnPmLog = new AcLnPmLog();
				AftCompst act = null;
				acLnPmLog.setTraceNo(operaInfo.getTraceNo()); 
				acLnPmLog.setTxDt(txDate); 
				acLnPmLog.setRepayNormInt(oldAcLnRepayPln.getNormInt()); 
				acLnPmLog.setRepayPrcpAmt(oldAcLnRepayPln.getRepayPrcpAmt()); 
				acLnPmLog.setRepayFeeAmt(repayChrgAmt);
				acLnPmLog.setLoanNo(oldAcLnRepayPln.getLoanNo());
				acLnPmLog.setPactNo(oldAcLnRepayPln.getPactNo());
				acLnPmLog.setPerdNo(String.valueOf(oldAcLnRepayPln.getPerdNo()));
				acLnPmLog.setIntSts(oldAcLnRepayPln.getIntSts());
				acLnPmLog.setBrNo(oldAcLnRepayPln.getBrNo());
				acLnPmLog.setPrcpSts(oldAcLnRepayPln.getPrcpSts());
				acLnPmLog.setCancelInd(PUBConstant.REV_ROL_NORM);
				act=(AftCompst) JdbcDao.query(new AftCompst(),"pact_no='"+acLnMst.getPactNo()+"' and perd_no='"+oldAcLnRepayPln.getPerdNo()+"'and br_no='"+acLnMst.getBrNo()+"'","aft_compst", operaInfo.getConn());
				if(null==act || "".equals(act)){
					acLnPmLog.setComPst("01");//01����	
				}else{
					acLnPmLog.setComPst("02");//02����
				}
				JdbcDao.insert(acLnPmLog, "ac_ln_pm_log", operaInfo.getConn());
				
				
				JdbcDao.delete("loan_no='"+loanNo+"'", "ac_ln_repay_pln_cur", operaInfo.getConn());
				AcLnRepayPln acLnRepayPln = (AcLnRepayPln) JdbcDao.query(new AcLnRepayPln(), "loan_no='"+loanNo+"' and perd_no=" + nextPerdNo, "ac_ln_repay_pln", operaInfo.getConn());
				if (acLnRepayPln != null) {
					AcLnRepayPlnCur newAcLnRepayPlnCur = AcLnRepayPlnBiz.getAcLnRepayPlnCur(acLnRepayPln, acLnMst, txDate);
					 curDueDt = newAcLnRepayPlnCur.getPayDt();
					 nextDueDt = newAcLnRepayPlnCur.getPayDt();
					JdbcDao.insert(newAcLnRepayPlnCur, "ac_ln_repay_pln_cur", operaInfo.getConn());
				}
			}
			acLnMst.setLoanBal(NumberUtil.amtSubs(acLnMst.getLoanBal(),repayPrcpAmt));
			acLnMst.setLastSetlDt(txDate);
			acLnMst.setLstDt(txDate);
			acLnMst.setNextDueDt(nextDueDt);
			acLnMst.setCurDueDt(curDueDt);
			acLnMst.setUpDt(txDate);
//			acLnMst.setLoanBal(0.0);  //����������
//			acLnMst.setLoanSts(PUBConstant.LOAN_STS_04);  //����״̬Ϊ����
			
			ResultSet rs = null;
			Statement stmt = null;
			try{
				rs =  JdbcDao.executeQuery(stmt,rs,"select count(*) as counts from ac_ln_repay_pln where setl_sts='N' and loan_no='"+loanNo+"'", operaInfo.getConn());
				if(rs.next()){
					if(rs.getInt("counts")==0){
						acLnMst.setLoanSts(PUBConstant.LOAN_STS_04);
					}
				}
				stmt = rs.getStatement();
			}catch (Exception e) {
				throw new AccountingException(e.getMessage());
			}finally{
				JdbcDao.close(stmt, rs);
			}
			JdbcDao.update(acLnMst, "loan_no='" + loanNo+ "'", "ac_ln_mst", operaInfo.getConn());  //���´������ļ�

		}else if(NumberUtil.isAmtGreatThanZero(curAmt) && NumberUtil.isAmtLessThanOrEqualZero(remAmt)){	//����е���Ӧ��,�ɿ۽��Ϊ0
	
			String nextIntDt = null;
			//����״̬
			prcpSts = NumberUtil.isAmtLessThanOrEqualZero(prcpAmt)?PUBConstant.AMT_STS_NORMAL:PUBConstant.AMT_STS_DELQ;
			//��Ϣ״̬
			intSts = NumberUtil.isAmtLessThanOrEqualZero(normInt)?PUBConstant.AMT_STS_NORMAL:PUBConstant.AMT_STS_DELQ;
			//�ѹ�������������һ�ڵ���
			if(TimeUtil.checkDate2AfterDate1(oldAcLnRepayPlnCur.getEndDt(),txDate )){
				JdbcDao.delete("loan_no='"+loanNo+"'", "ac_ln_repay_pln_cur", operaInfo.getConn());
				AcLnRepayPln acLnRepayPln = (AcLnRepayPln) JdbcDao.query(new AcLnRepayPln(), "loan_no='"+loanNo+"' and perd_no=" + nextPerdNo, "ac_ln_repay_pln", operaInfo.getConn());
				
				if (acLnRepayPln != null) {
					AcLnRepayPlnCur newAcLnRepayPlnCur = AcLnRepayPlnBiz.getAcLnRepayPlnCur(acLnRepayPln, acLnMst, txDate);
					curDueDt = newAcLnRepayPlnCur.getPayDt();
					nextDueDt = newAcLnRepayPlnCur.getPayDt();
					JdbcDao.insert(newAcLnRepayPlnCur, "ac_ln_repay_pln_cur", operaInfo.getConn());
				}
				// Ƿ���
				AcLnLo acLnLo = new AcLnLo();
				TransUtil.copyProperties(oldAcLnRepayPlnCur, acLnLo);
				acLnLo.setSetlSts(PUBConstant.N);
				acLnLo.setOverRate(acLnMst.getOverRate()); // ��������
				acLnLo.setFineIntDt(txDate);
				acLnLo.setPrcpSts(PUBConstant.AMT_STS_OVER);
				acLnLo.setIntSts(PUBConstant.AMT_STS_OVER);
				acLnLo.setNextIntDt(nextIntDt);
				JdbcDao.insert(acLnLo, "ac_ln_lo", operaInfo.getConn());
				
				oldAcLnRepayPln.setLstPayDt(txDate);
				
			}
		}
		// ����map,�鿴��ЩǷ�����еĻ������,������Ƿ���,���뻹����ϸ��
		for (String cnt : perdFeeAmtMap.keySet()) {
			
			AcChrgLog acChrgLogFSelf = null;// ͬһ�ڴ����շ����ʵ��
			AcChrgLog acChrgLogBSelf = null;// ͬһ�ڴ����ձ���ʵ��
			AcChrgLog acChrgLogFColl = null;// ͬһ�ڴδ��շ����ʵ��
			AcChrgLog acChrgLogBColl = null;// ͬһ�ڴδ��ձ���ʵ��
			AcChrgLog acChrgLogWColl = null;// ͬһ�ڴδ���ΥԼ��ʵ��
			
			if (perdFeeAmtMap.get(cnt) != null) {
				
				acChrgLogFSelf = perdFeeAmtMap.get(cnt).get(PUBConstant.FEE_KIND_01)==null?acChrgLogFSelf:perdFeeAmtMap.get(cnt).get(PUBConstant.FEE_KIND_01).get(PUBConstant.FEE_TYPE_01);
				acChrgLogBSelf = perdFeeAmtMap.get(cnt).get(PUBConstant.FEE_KIND_01)==null?acChrgLogBSelf:perdFeeAmtMap.get(cnt).get(PUBConstant.FEE_KIND_01).get(PUBConstant.FEE_TYPE_02);
				acChrgLogFColl = perdFeeAmtMap.get(cnt).get(PUBConstant.FEE_KIND_02)==null?acChrgLogFColl:perdFeeAmtMap.get(cnt).get(PUBConstant.FEE_KIND_02).get(PUBConstant.FEE_TYPE_01);
				acChrgLogBColl = perdFeeAmtMap.get(cnt).get(PUBConstant.FEE_KIND_02)==null?acChrgLogBColl:perdFeeAmtMap.get(cnt).get(PUBConstant.FEE_KIND_02).get(PUBConstant.FEE_TYPE_02);
				acChrgLogWColl = perdFeeAmtMap.get(cnt).get(PUBConstant.FEE_KIND_02)==null?acChrgLogWColl:perdFeeAmtMap.get(cnt).get(PUBConstant.FEE_KIND_02).get(PUBConstant.FEE_TYPE_06);

				
				insertAcLnPmLog(acChrgLogFSelf, operaInfo);
				insertAcLnPmLog(acChrgLogBSelf, operaInfo);
				insertAcLnPmLog(acChrgLogFColl, operaInfo);
				insertAcLnPmLog(acChrgLogBColl, operaInfo);
				insertAcLnPmLog(acChrgLogWColl, operaInfo);
			}
		}
		
		dcMap.put(PUBConstant.LN_AMT_TYP_PRCP, repayPrcpAmt);//���λ�����
		dcMap.put(PUBConstant.LN_AMT_TYP_CRI, repayNormInt);//���λ���Ϣ
		
		loanRepay.setDcMap(dcMap);
		return loanRepay;
	}
	
	public static void insertAcLnPmLog (AcChrgLog acChrgLog,OperaInfo operaInfo){
		double chrgAmt = 0;
		if(acChrgLog!=null){
			chrgAmt = acChrgLog.getPayChrgAmt();
			if(NumberUtil.isAmtGreatThanZero(chrgAmt)){
				if (RepayBiz.chargePayOff(acChrgLog)) {
					acChrgLog.setChrgSts(PUBConstant.CHRG_STS_03);
				} else {
					acChrgLog.setChrgSts(PUBConstant.CHRG_STS_02);
				}
				acChrgLog.setUpDate(operaInfo.getBizDt());
				try {
					JdbcDao.update(acChrgLog, "chrg_id='"+acChrgLog.getChrgId()+"'", "ac_chrg_log", operaInfo.getConn());
				
				} catch (AccountingException e) {
					e.printStackTrace();
				}
				//���뻹����ϸ��
				AcLnPmLog acLnPmLog = new AcLnPmLog();
				AftCompst act = null;
				acLnPmLog.setTraceNo(operaInfo.getTraceNo()); 
				acLnPmLog.setTxDt(operaInfo.getTxDt()); //
				acLnPmLog.setRepayNormInt(0); 
				acLnPmLog.setRepayPrcpAmt(0);
				acLnPmLog.setRepayFeeAmt(chrgAmt);//
				acLnPmLog.setLoanNo(acChrgLog.getLoanNo());//
				acLnPmLog.setPactNo(acChrgLog.getPactNo());//
				acLnPmLog.setBrNo(acChrgLog.getBrNo());//
				acLnPmLog.setPerdNo(String.valueOf(acChrgLog.getPerdNo()));//
				acLnPmLog.setChrgSts(acChrgLog.getChrgSts());//
				acLnPmLog.setCancelInd(PUBConstant.REV_ROL_NORM);//
				acLnPmLog.setChrgId(acChrgLog.getChrgId());//
				try {
					act=(AftCompst) JdbcDao.query(new AftCompst(),"pact_no='"+acChrgLog.getPactNo()+"' and perd_no='"+acChrgLog.getPerdNo()+"'and br_no='"+acChrgLog.getBrNo()+"'","aft_compst", operaInfo.getConn());
				} catch (AccountingException e1) {
					
					e1.printStackTrace();
				}
				if(null==act || "".equals(act)){
					acLnPmLog.setComPst("01");//01����	//
				}else{
					acLnPmLog.setComPst("02");//02����
				}
				try {
					JdbcDao.insert(acLnPmLog, "ac_ln_pm_log", operaInfo.getConn());
				} catch (AccountingException e) {
					e.printStackTrace();
				}
			}
			
		}
	}
	
	/**
	 * �ж��Ƿ��ѻ���
	 * 
	 * @param AcChrgLog
	 *            ������ϸ��
	 * @return true �ѻ���,false δ����
	 */
	public static boolean chargePayOff(AcChrgLog acChrgLog) {

		boolean flag = false;

		double txPrcp = NumberUtil.amtSubs(acChrgLog.getChrgAmt(), acChrgLog.getRepayChrgAmt()); // ��Ƿ����
		
		// ���������
		if (NumberUtil.isAmtEqualZero(txPrcp)) {
			flag = true;
		}
		return flag;
	}
	
	/**
	 * ������ۿ���տ�Ƿ�
	 * @param acLmAtpy
	 * @param traceCnt
	 * @param conn
	 * @throws AccountingException
	 */
	public static LoanRepay repayLoForBatch(AcDebit acDebit, OperaInfo operaInfo, Connection conn)throws AccountingException{
		String loanNo = acDebit.getLoanNo();
		double repayAmt = acDebit.getRepayAmt();
		// ��ô������ļ�
		AcLnMst acLnMst = (AcLnMst)JdbcDao.query(new AcLnMst(), "loan_no='"+loanNo+"'", "ac_ln_mst", conn);
	
		String txCode = TransCode.LNCQ;
		if(acLnMst.getDevaInd().equals(PUBConstant.Y)){
			txCode = TransCode.LNEQ;
		}
		LoanRepay loanRepay = new LoanRepay() ;
		
		// �����ʵ�ս��
		if (NumberUtil.isAmtGreatThanZero(repayAmt)) {

			
			loanRepay.setBatchInd(true)  ;
			// ���û�Ƿ��
			loanRepay = RepayLoMortgageBiz.repayLoMortgageAmt(operaInfo,acDebit, acLnMst, loanRepay, txCode);

			
		} 
		return loanRepay;
		
	}
	
	/**
	 * 
	 * @���� DHCC-LIUJ
	 * @���� 2018-4-25
	 * @����	�ſ���̴���
	 */
	public static void acDebitBack(String backLogNo,String backCnt ,String backRes,String failCaus, OperaInfo operaInfo,String status,String cardChn)throws AccountingException{
		
	
	}
	
	/**
	 * 
	 * @���� DHCC-LIUJ
	 * @���� 2018-4-25
	 * @����	�ۿ���̴����ʽ����
	 */
	public static void PROC_REACC_FUND(String P_DUENO, double P_REAMT,
			double P_REINT,String P_FILLER, String fundFlag,Connection conn) throws Exception {
		// ���ô洢���̸���ln_stageҵ��׶α�
		CallableStatement proc = null;
		String result_val = "01";
		try {

			// ���ô洢���̸���ln_stageҵ��׶α�
			String fundSql = "";
			if("ADD".equals(fundFlag)){
				fundSql = "{call PKG_LN_DUE.PROC_REACC_FUND(?,?,?,?,?)}";
			}else {
				fundSql = "{call PKG_LN_DUE.PROC_REACC_FUND_BACK(?,?,?,?,?)}";
			}
			proc = conn.prepareCall(fundSql); // ���ô洢����
			proc.setString(1, P_DUENO); // ���õ�1�������������
			proc.setDouble(2, P_REAMT);
			proc.setDouble(3, P_REINT);
			proc.setString(4, P_FILLER);
			proc.registerOutParameter(5, Types.VARCHAR);// ��4�������������,��VARCHAR���͵�
			proc.execute(); // ִ��
			result_val = proc.getString(5);// ����������
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(proc != null) proc.close();
		}
	}
	
	/**
	 * @param acLoanBackLog
	 * @param operaInfo
	 * @���� ����AC_LOAN_BACK_LOG��
	 */
	public static void updateAcLoanBackLog(AcLoanBackLog acLoanBackLog,OperaInfo operaInfo){
		String sql = "";	
		try {
			if(PUBConstant.BACK_STS_05.equals(acLoanBackLog.getBackSts())){
				sql = "UPDATE AC_LOAN_BACK_LOG SET BACK_STS = '"+acLoanBackLog.getBackSts()+"'";
			}else{
				sql = "UPDATE AC_LOAN_BACK_LOG SET BACK_RES = '"+acLoanBackLog.getBackRes()+"',FAIL_CAUS = '"+acLoanBackLog.getFailCaus()+"',BACK_DATE = '"+acLoanBackLog.getBackDate()+"',BACK_STS = '"+acLoanBackLog.getBackSts()+"',STATUS = '"+acLoanBackLog.getStatus()+"',CARD_CHN = '"+acLoanBackLog.getCardChn()+"',UP_TIME = '"+acLoanBackLog.getUpTime()+"'";
			}
			JdbcDao.updateSql(sql + " WHERE BACK_LOG_NO = '"+acLoanBackLog.getBackLogNo()+"' AND BACK_CNT = '"+acLoanBackLog.getBackCnt()+"'",
				operaInfo.getConn());	
		} catch (AccountingException e) {
			e.printStackTrace();
		}	
	}
	
	
	
	
	
}
