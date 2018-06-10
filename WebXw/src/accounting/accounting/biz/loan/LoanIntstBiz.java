package accounting.biz.loan;

import java.sql.Connection;
import java.util.List;

import accounting.biz.pub.IntstBiz;
import accounting.biz.pub.LoanBiz;
import accounting.domain.loan.AcLnIntstLog;
import accounting.domain.loan.AcLnLo;
import accounting.domain.loan.AcLnMst;
import accounting.domain.loan.AcLnRepayPln;
import accounting.domain.loan.AcLnRepayPlnCur;
import accounting.domain.loan.AcTraceLog;
import accounting.domain.sys.OperaInfo;
import accounting.interf.loan.IntstDetailDatas;
import accounting.plat.PUBConstant;
import accounting.plat.TransCode;
import accounting.plat.core.AccountingException;
import accounting.plat.dao.JdbcDao;
import accounting.plat.util.NumberUtil;
import app.util.DateUtil;

/**
 * ���ʽ�Ϣ
 * 
 * @project��nxnxnew
 * @className��LoanIntstBiz
 */
public class LoanIntstBiz {

	/**
	 * ���ʽ�Ϣ
	 * 
	 * @param operaInfo
	 * 			      ҵ�����
	 * @param acLnMst
	 *            �������ļ�
	 * @param acLnLoList
	 *            ����Ƿ���List
	 * @param txCode
	 *            ���״���
	 * @param subTxCode
	 *            �����Ӵ���
	 * @param isBatch
	 *            �Ƿ���������,�ǵĻ� Ϊtrue,�����ж��Ƿ���»���ƻ�
	 * @throws Exception 
	 * @ҵ��˵��:
	 */

	@SuppressWarnings("unchecked")
	public static IntstDetailDatas loanIntstSettlement(OperaInfo operaInfo, AcLnMst acLnMst, List<AcLnLo> acLnLoList, 
			String txCode, String subTxCode, boolean isBatch)
	throws Exception {

		IntstDetailDatas intstDatas = new IntstDetailDatas();
		

		String loanNo = acLnMst.getLoanNo();
		Connection conn = operaInfo.getConn() ;
		String txDate = operaInfo.getTxDt() ;
		
		double fineInt = 0.0;
		
		//��ȡ���ڻ���ƻ�
		AcLnRepayPlnCur acLnRepayPlnCur = (AcLnRepayPlnCur) JdbcDao.query(new AcLnRepayPlnCur(), "loan_no='"+acLnMst.getLoanNo()+"'", "ac_ln_repay_pln_cur", conn);
		//����Ƿ������ݣ���ÿ��Ƿ�����ݽ��н�Ϣ
		for (AcLnLo acLnLo : acLnLoList) {
			fineInt = 0.0;
			int perdNo = acLnLo.getPerdNo();
			
			// ����ÿ�ڵ�ǷϢ
			IntstDetailDatas datas = IntstBiz.calculatePerLoInt(acLnMst, acLnLo, operaInfo);
			
			if (datas != null ) {
				fineInt = datas.getFineInt(); 	// Ƿ��Ϣ
				double prcpAmt = datas.getPrcpAmt();	// Ƿ����
				double normInt = datas.getNormInt();	// Ƿ������Ϣ
					
				intstDatas.setFineInt(NumberUtil.amtAdd(intstDatas.getFineInt(), fineInt));		//�ۼ�Ƿ��Ϣ
				intstDatas.setPrcpAmt(NumberUtil.amtAdd(intstDatas.getPrcpAmt(), prcpAmt));		//�ۼ�Ƿ����
				intstDatas.setNormInt(NumberUtil.amtAdd(intstDatas.getNormInt(), normInt));		//�ۼ�Ƿ������Ϣ
				
				//��Ϣ��־
				AcLnIntstLog acLnIntstLog = new AcLnIntstLog();
				acLnIntstLog.setTraceNo(operaInfo.getTraceNo());
				acLnIntstLog.setLoanNo(acLnLo.getLoanNo());
				acLnIntstLog.setPerdNo(acLnLo.getPerdNo());
				acLnIntstLog.setPactNo(acLnLo.getPactNo());
				acLnIntstLog.setBrNo(acLnLo.getBrNo());
				acLnIntstLog.setNormInt(0.00);
				acLnIntstLog.setLstIntDt(acLnLo.getFineIntDt());
				acLnIntstLog.setFineInt(datas.getFineInt()-acLnLo.getFineInt());
				acLnIntstLog.setLstIntDt(acLnLo.getFineIntDt());
				acLnIntstLog.setTxDt(operaInfo.getBizDt());
				JdbcDao.insert(acLnIntstLog, "ac_ln_intst_log", conn);
				
//				acLnLo.setFineInt(datas.getFineInt()); // ��Ϣ
				acLnLo.setFineIntDt(txDate);
				acLnLo.setFineInt(datas.getFineInt());

//				if (!isBatch) {// �ռ��Ϣ��������Ӧ�Ļ���ƻ���
//					AcLnPayPln acLnPayPln = (AcLnPayPln)JdbcDao.query(new AcLnPayPln(), "loan_no='"+loanNo+"' and perd_no="+perdNo, "ac_ln_pay_pln", conn);
//					acLnPayPln.setOverInt(acLnLo.getOverInt()); 	
//					acLnPayPln.setCmpdInt(acLnLo.getCmpdInt()); 	
//					acLnPayPln.setFineIntDt(txDate);	
//					acLnPayPln.setPrcpAcm(0);			
//					acLnPayPln.setIntstAcm(0);			
//					acLnPayPln.setCmpdAcm(0);			
//					acLnPayPln.setAcmDt(acLnLo.getAcmDt());
//					acLnPayPln.setAcmBegDt(acLnLo.getAcmBegDt());		
//					JdbcDao.update(acLnPayPln, "loan_no='"+loanNo+"' and perd_no=" + perdNo, "ac_ln_pay_pln", conn);
//				}
				
				//���ս�Ϣ��ÿ�춼Ҫ���н�Ϣ
				acLnLo.setNextIntDt(DateUtil.addByDay(txDate,1));
				
				// ����Ƿ���
				JdbcDao.update(acLnLo, "loan_no='"+loanNo+"' and perd_no=" + perdNo, "ac_ln_lo", conn);
				
				//���»���ƻ���Ϣ
				AcLnRepayPln acLnRepayPln = (AcLnRepayPln)JdbcDao.query(new AcLnRepayPln(), "loan_no='"+acLnMst.getLoanNo()+"' and perd_no='"+perdNo+"'", "ac_ln_repay_pln", conn);
				acLnRepayPln.setFineInt(acLnLo.getFineInt());
				JdbcDao.update(acLnRepayPln, "loan_no='"+acLnRepayPln.getLoanNo()+"' and perd_no='"+acLnRepayPln.getPerdNo()+"'", "ac_ln_repay_pln", conn);
					
			}
		}
		

	
		
		if(!isBatch){
			acLnMst.setLstIntDt(txDate);	
			acLnMst.setIcDt(txDate); 		
			acLnMst.setLstDt(txDate); 	
			JdbcDao.update(acLnMst, "loan_no='"+loanNo+"'", "ac_ln_mst", conn);
		}
		
		// ����������ˮ���¼
		AcTraceLog log = new AcTraceLog();
		log.setAmt(fineInt);
		log.setTxBrNo(operaInfo.getTxBrNo());
		LoanBiz.insertLog(log, acLnMst, operaInfo, txCode, subTxCode, PUBConstant.INC);
		
		return intstDatas;
	}

	
	/**
	 * �ۿ��սᵱ����Ϣ
	 * @param acLnMst ���ļ�
	 * @param operaInfo ҵ�����
	 * @param txCde ������
	 * @throws AccountingException
	 */
	public static void loanCurIntstSettlement(AcLnMst acLnMst,AcLnRepayPlnCur repayPlnCur, OperaInfo operaInfo, String txCde) throws AccountingException{
		Connection conn = operaInfo.getConn();
		String txDate = operaInfo.getTxDt();
		String loanNo = acLnMst.getLoanNo();

		acLnMst.setLstIntDt(repayPlnCur.getEndDt()); 	
		acLnMst.setIcDt(repayPlnCur.getEndDt()); 			
		acLnMst.setLstDt(txDate); 			
		JdbcDao.update(acLnMst, "loan_no='"+loanNo+"'", "ac_ln_mst", conn);
		
		AcLnIntstLog acLnIntstLog = new AcLnIntstLog();
		acLnIntstLog.setTraceNo(operaInfo.getTraceNo());
		acLnIntstLog.setLoanNo(acLnMst.getLoanNo());
		acLnIntstLog.setPerdNo(repayPlnCur.getPerdNo());
		acLnIntstLog.setPactNo(repayPlnCur.getPactNo());
		acLnIntstLog.setBrNo(repayPlnCur.getBrNo());
		acLnIntstLog.setNormInt(repayPlnCur.getNormInt()-repayPlnCur.getRepayNormInt());
		acLnIntstLog.setLstFineInt(0.00);
		acLnIntstLog.setFineInt(0.00);
		acLnIntstLog.setLstIntDt("");
		acLnIntstLog.setTxDt(operaInfo.getBizDt());
		JdbcDao.insert(acLnIntstLog, "ac_ln_intst_log", conn);
		
		AcTraceLog log = new AcTraceLog();
		log.setTxBrNo(operaInfo.getTxBrNo());
		log.setAmt(repayPlnCur.getNormInt());
		LoanBiz.insertLog(log, acLnMst, operaInfo, txCde, TransCode.LNSA, PUBConstant.INC);
		
	}
}	
