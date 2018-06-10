
package accounting.interf.cancel;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import accounting.biz.pub.AcLnRepayPlnBiz;
import accounting.biz.pub.ParmBiz;
import accounting.domain.fee.AcChrgLog;
import accounting.domain.loan.AcDebit;
import accounting.domain.loan.AcDebitDtl;
import accounting.domain.loan.AcLnDue;
import accounting.domain.loan.AcLnLo;
import accounting.domain.loan.AcLnMst;
import accounting.domain.loan.AcLnPmLog;
import accounting.domain.loan.AcLnRepayPln;
import accounting.domain.loan.AcLnRepayPlnCur;
import accounting.domain.loan.AcLnRepayPlnHst;
import accounting.domain.loan.AcLnSetlmtLog;
import accounting.domain.loan.AcLoanLog;
import accounting.domain.loan.AcTraceLog;
import accounting.domain.loan.AftAcno;
import accounting.domain.loan.AftPayday;
import accounting.domain.loan.AftReliefDtl;
import accounting.domain.loan.LnAcct;
import accounting.domain.loan.ProjAcct;
import accounting.domain.sys.AfferentDomain;
import accounting.domain.sys.OperaInfo;
import accounting.plat.PUBConstant;
import accounting.plat.TransCode;
import accounting.plat.core.AccountingException;
import accounting.plat.core.Operation;
import accounting.plat.dao.JdbcDao;
import accounting.plat.util.NumberUtil;
import accounting.plat.util.TransUtil;

/**
 * ���˽��ײ�����
 * 
 * 
 */
public class ReverseTraceOp extends Operation {

	@Override
	public Object doExecute(AfferentDomain afferentDomain) throws AccountingException {
		// ���˽������ݴ������
		ReverseTrace reverseTrace = null;
		// �ж����ݴ����������
		if (afferentDomain instanceof ReverseTrace) {
			reverseTrace = (ReverseTrace) afferentDomain;
		} else {
			throw new AccountingException("���˽������ݴ���������Ͳ�����");
		}

		// ���ݿ����Ӷ���
		Connection conn = this.getConnection();

		// ��ȡ��ǰ��ˮ��
		String traceNo = this.getTraceNo();

		// ���˽�����ˮ��
		long reverseTraceNo = reverseTrace.getReverseTraceNo();

		// �����˽�����ˮ
		AcTraceLog reverseTraceLog = (AcTraceLog) this.getReverseTraceLogList(reverseTraceNo, conn).get(0);

		// ����ҵ���������
		OperaInfo operaInfo = new OperaInfo(afferentDomain, traceNo, conn) ;
		operaInfo.setBizDt(reverseTraceLog.getTxDt()) ;	// ҵ��������
		
		// ������
		String txCode = reverseTraceLog.getTxCde();

		if (txCode == null || txCode.equals("")) {
			throw new AccountingException("�����벻ӦΪ�գ�");
		} else if (txCode.equals(TransCode.LNC3)) {
			// ����ų���
//			this.reverseGrant(operaInfo, reverseTraceLog);
		} else if (txCode.equals(TransCode.LNC4)) {
			// ��������
			this.reverseRepay(operaInfo, reverseTraceLog) ;
		}else if(txCode.equals(TransCode.LNAD)) {
			//��ǰ�������
			this.reverseAdvpay(operaInfo, reverseTraceLog);
		}else if(txCode.equals(TransCode.CGPD)){
			//�����ձ������
			this.reverseRepayDt(operaInfo, reverseTraceLog);
		}else if(txCode.equals(TransCode.LNUP)){
			//�����ʺű������
			this.reverseAcno(operaInfo, reverseTraceLog);
		}else if(txCode.equals(TransCode.LNWV)){
			//Ϣ�Ѽ������
			this.reverseRelief(operaInfo, reverseTraceLog);
		}else {
			throw new AccountingException("�����롾" + txCode + "�����ܽ��г��˲�����");
		}
		
//		// ����ҵ����ˮ��
//		this.dealTraceLog(operaInfo, reverseTraceLog) ;

		return traceNo;
	}
	
	/**
	 * �������˽�����ˮ��¼
	 * 
	 * @parm operaInfo 	���ײ�������
	 * @parm acTraceLog	ԭ������ˮ��¼
	 * 
	 */
	public void dealTraceLog(OperaInfo operaInfo, AcTraceLog acTraceLog)throws AccountingException{

		String traceNo = operaInfo.getTraceNo() ;
		Connection conn = operaInfo.getConn() ;
		
		// �����ݿ����ҵ����ˮ��Ϣ
		AcTraceLog newTraceLog = new AcTraceLog();
		TransUtil.copyProperties(acTraceLog, newTraceLog) ;

		newTraceLog.setTraceNo(traceNo); 				// ������ˮ��
		newTraceLog.setTraceCnt(1); 					// ������ˮ�ʴ�
		newTraceLog.setTxDt(operaInfo.getTxDt());	 	// ���ý�������
		newTraceLog.setTxTime(ParmBiz.getOracleTxTime(conn));	// ���ý���ʱ��
		newTraceLog.setTxBrNo(operaInfo.getTxBrNo()) ;	// ���ý��׻���
		newTraceLog.setTxCde(TransCode.LNRV); 			// ���ý��״���
		newTraceLog.setSubTxCde(acTraceLog.getTxCde());	// �����ӽ��״���Ϊ��ԭ���״��롱
		newTraceLog.setCancelInd(PUBConstant.REV_ROL_NORM);	// ���ó�����־
		newTraceLog.setAmt(NumberUtil.amtSubs(0, acTraceLog.getAmt())); // ���÷�����

		JdbcDao.insert(newTraceLog, "ac_trace_log", conn);
	}

	/**
	 * ���˽�����ˮ�б�
	 * 
	 * @param reverseTraceNo
	 *            ���˽�����ˮ��
	 * @param conn
	 *            ���ݿ����Ӷ���
	 * @return ���˽�����ˮ�б�
	 * @throws AccountingException
	 */
	private List getReverseTraceLogList(long reverseTraceNo, Connection conn) throws AccountingException {
		List reverseTraceLogList = null;
		String condition = "TRACE_NO='" + reverseTraceNo + "' ";
		reverseTraceLogList = JdbcDao.queryList(new AcTraceLog(), condition, "ac_trace_log", conn);
		return reverseTraceLogList;
	}
	
	/**
	 * �������
	 * 
	 * @param operaInfo
	 *            ҵ���׶���
	 * @param reverseTraceLog
	 *            �������ˮ����
	 *            
	 * @return
	 * @throws AccountingException
	 */
	private void reverseRepay(OperaInfo operaInfo, AcTraceLog reverseTraceLog) throws AccountingException {
		String reverseTraceNo = reverseTraceLog.getTraceNo() ;
		String loanNo = reverseTraceLog.getLoanNo() ;
		
		Connection conn = operaInfo.getConn() ;
		String txDate = operaInfo.getTxDt() ;

		// ��ò����´���������Ϣ
		AcLnMst acLnMst = (AcLnMst) JdbcDao.query(new AcLnMst(), "loan_no='"+loanNo+"'", "ac_ln_mst", conn);
		// �жϴ��������¼�Ƿ����
		if (acLnMst == null) {
			throw new AccountingException("��ѯ������ݡ�"+loanNo+"����Ӧ �Ĵ��������¼��");
		}
		
		//�����Ϣ
		AcLnDue acLnDue = (AcLnDue) JdbcDao.query(new AcLnDue(), "due_no='"+acLnMst.getLoanNo()+"'", "ln_due", conn);
	
		//������־--Ƿ�����Ϣ
		List<AcLnPmLog> loAcLnPmLogList = (ArrayList) JdbcDao.queryList(new AcLnPmLog(), "trace_no='"+reverseTraceNo+"' and repay_fee_amt=0.00", "ac_ln_pm_log", conn);

		//������־--Ƿ�ѻ�����Ϣ
		List<AcLnPmLog> feeAcLnPmLogList = (ArrayList) JdbcDao.queryList(new AcLnPmLog(), "trace_no='"+reverseTraceNo+"' and repay_fee_amt>0.00", "ac_ln_pm_log", conn);
		
		//��ѯ�ۿ�ɹ��������ļ�
		AcDebit acDebit = (AcDebit) JdbcDao.query(new AcDebit(), "trace_no='"+reverseTraceNo+"'","ac_debit", conn);
		
		//���˽��
		double loanAmt= acDebit.getRepayAmt();
		if (loanAmt > 0) {
			// ���ɷſ���ϸ
			AcLoanLog acLoanLog = new AcLoanLog();
			acLoanLog.setTraceNo(operaInfo.getTraceNo());
			acLoanLog.setLoanLogNo(ParmBiz.getAcLoanLogNo(conn));
			acLoanLog.setLoanNo(acLnMst.getLoanNo());
			acLoanLog.setPactNo(acLnMst.getPactNo());
			acLoanLog.setBrNo(acLnMst.getBrNo());
			acLoanLog.setLoanAmt(loanAmt);
			acLoanLog.setXtAcNo("");
			acLoanLog.setCardChn("");
			acLoanLog.setLoanAcNo(acDebit.getAcNo());
			acLoanLog.setLoanAcType(acDebit.getAcType());
			acLoanLog.setLoanAcName(acDebit.getAcName());
			acLoanLog.setLoanBankCode(acDebit.getBankCode());
			acLoanLog.setLoanBankProv(acDebit.getBankProv());
			acLoanLog.setLoanBankCity(acDebit.getBankCity());
			acLoanLog.setLoanBankSite(acDebit.getBankSite());
			acLoanLog.setBusEntryType("");
			acLoanLog.setLoanSts("01");// ������
			acLoanLog.setTxDate(operaInfo.getTxDt());
			acLoanLog.setTxTime(ParmBiz.getOracleTxTime(conn));
			
			//�ظ�����������
//			for(AcLnPmLog acLnPmLog : loAcLnPmLogList){
//				String perdNo = acLnPmLog.getPerdNo();
//				//��ȡ����ƻ�
//				AcLnRepayPln acLnRepayPln = (AcLnRepayPln)JdbcDao.query(new AcLnRepayPln(), "loan_no='"+acLnMst.getLoanNo()+"' and perd_no='"+perdNo+"'", "ac_ln_repay_pln", conn);
//				acLnRepayPln.setRepayPrcpAmt(acLnRepayPln.getRepayPrcpAmt()-acLnPmLog.getRepayPrcpAmt());
//				acLnRepayPln.setRepayNormInt(acLnRepayPln.getRepayNormInt()-acLnPmLog.getRepayNormInt());
//				acLnRepayPln.setRepayFineInt(acLnRepayPln.getRepayFineInt()-acLnPmLog.getRepayFineInt());
//				JdbcDao.update(acLnRepayPln, "loan_no='"+acLnMst.getLoanNo()+"' and perd_no='"+perdNo+"'", "ac_ln_repay_pln", conn);
//				
//				//���ڻ���ƻ�
//				AcLnRepayPlnCur acLnRepayPlnCur = (AcLnRepayPlnCur)JdbcDao.query(new AcLnRepayPlnCur(), "loan_no='"+acLnMst.getLoanNo()+"' and perd_no='"+perdNo+"'", "ac_ln_repay_pln_cur", conn);
//				if(acLnRepayPlnCur != null){
//					acLnRepayPlnCur.setRepayPrcpAmt(acLnRepayPlnCur.getRepayPrcpAmt()-acLnPmLog.getRepayPrcpAmt());
//					acLnRepayPlnCur.setRepayNormInt(acLnRepayPlnCur.getRepayNormInt()-acLnPmLog.getRepayNormInt());
//					JdbcDao.update(acLnRepayPlnCur, "loan_no='"+acLnMst.getLoanNo()+"' and perd_no='"+perdNo+"'", "ac_ln_repay_pln_cur", conn);
//				}
//				//Ƿ������
//				AcLnLo acLnLo = (AcLnLo)JdbcDao.query(new AcLnLo(), "loan_no='"+acLnMst.getLoanNo()+"' and perd_no='"+perdNo+"'", "ac_ln_lo", conn);
//				if(acLnLo != null){
//					acLnLo.setRepayPrcpAmt(acLnLo.getRepayPrcpAmt()-acLnPmLog.getRepayPrcpAmt());
//					acLnLo.setRepayNormInt(acLnLo.getRepayNormInt()-acLnPmLog.getRepayNormInt());
//					acLnLo.setRepayFineInt(acLnLo.getRepayFineInt()-acLnPmLog.getRepayFineInt());
//					JdbcDao.update(acLnLo, "loan_no='"+acLnMst.getLoanNo()+"' and perd_no='"+perdNo+"'", "ac_ln_lo", conn);
//				}
//				
//				acLnPmLog.setCancelDt(txDate);
//				acLnPmLog.setCancelTraceNo(Long.parseLong(operaInfo.getTraceNo()));
//				acLnPmLog.setCancelInd(PUBConstant.REV_ROL_REV);
//				JdbcDao.update(acLnPmLog, "trace_no='"+reverseTraceNo+"' and perd_no='"+perdNo+"' and repay_fee_amt=0.00", "ac_ln_pm_log", conn);
//			}
			//�ظ�����
//			for(AcLnPmLog acLnPmLog : feeAcLnPmLogList){
//				String perdNo = acLnPmLog.getPerdNo();
//				String chrgId = acLnPmLog.getChrgId();
//				AcChrgLog acChrgLog = (AcChrgLog)JdbcDao.query(new AcChrgLog(), "chrg_id='"+chrgId+"'", "ac_chrg_log", conn);
//				acChrgLog.setRepayChrgAmt(acChrgLog.getRepayChrgAmt()-acLnPmLog.getRepayFeeAmt());
//				JdbcDao.update(acChrgLog, "chrg_id='"+chrgId+"'", "ac_chrg_log", conn);
//				
//				acLnPmLog.setCancelDt(txDate);
//				acLnPmLog.setCancelTraceNo(Long.parseLong(operaInfo.getTraceNo()));
//				acLnPmLog.setCancelInd(PUBConstant.REV_ROL_REV);
//				JdbcDao.update(acLnPmLog, "trace_no='"+reverseTraceNo+"' and chrg_id='"+chrgId+"'", "ac_ln_pm_log", conn);
//			}
			
		}else{
			throw new AccountingException("�޳ɹ��ۿ��¼���޷����л�����˽��ף�");
		}
		
		//����������ˮ
		this.dealTraceLog(operaInfo,reverseTraceLog);
		
	}


	/**
	 * ���˴���ſ��
	 * 
	 * @param operaInfo
	 *            ҵ���׶���
	 * @param reverseTraceLog
	 *            �ſ����ˮ����
	 *            
	 * @return
	 * @throws AccountingException
	 */
	private void reverseGrant(OperaInfo operaInfo, AcTraceLog reverseTraceLog) throws AccountingException {
		String reverseTraceNo = reverseTraceLog.getTraceNo() ;
		String loanNo = reverseTraceLog.getLoanNo() ;
		
		Connection conn = operaInfo.getConn() ;
		String txDate = operaInfo.getTxDt() ;

		// ��ò����´���������Ϣ
		AcLnMst acLnMst = (AcLnMst) JdbcDao.query(new AcLnMst(), "loan_no='"+loanNo+"'", "ac_ln_mst", conn);
		// �жϴ��������¼�Ƿ����
		if (acLnMst == null) {
			throw new AccountingException("��ѯ������ݡ�"+loanNo+"����Ӧ �Ĵ��������¼��");
		}
		
		//��ȡ�ſ���ϸ
		List<AcLoanLog> acLoanLogList = (ArrayList) JdbcDao.queryList(new AcLoanLog(), "trace_no='"+reverseTraceNo+"'", "AC_LOAN_LOG", conn);

		//���ɿۿ���ϸ
		for(AcLoanLog acLoanLog : acLoanLogList){
			AcDebitDtl acDebitDtl = getAcDebitDtlByLoanLog(acLoanLog,operaInfo);
			AcDebit acDebit = getAcDebitByDtl(acDebitDtl,acLnMst,operaInfo);
		}
		boolean debitFlag = false;
		
		if(debitFlag){
			
		}
		
		// ���´������ļ�
		JdbcDao.executeUpdate("ac_ln_mst", "lst_dt='"+txDate+"', ac_sts='"+PUBConstant.AC_STS_CANCEL+"' where loan_no='"+loanNo+"'", conn) ;
	
		//��ȡ����ƻ�
		List<AcLnRepayPln> alrpList = (ArrayList) JdbcDao.queryList(new AcLnRepayPln(), "loan_no='"+loanNo+"'", "AC_LN_REPAY_PLN", conn);
		//����ƻ���ʷ��¼
		List<AcLnRepayPlnHst> alrphList = new ArrayList<AcLnRepayPlnHst>();
		//�ǻ���ƻ���ʷ
		for(AcLnRepayPln alrp : alrpList){
			AcLnRepayPlnHst alrph = new AcLnRepayPlnHst();
			alrph = AcLnRepayPlnBiz.getRpHsByRp(alrp, operaInfo.getTraceNo());
			alrphList.add(alrph);
		}
		
		// ��������ƻ���ʷ
		JdbcDao.insertList(alrphList, "ac_ln_repay_pln_hst", operaInfo.getConn());

		// ɾ������ƻ���
		JdbcDao.delete("loan_no = '"+loanNo+"'", "ac_ln_pay_pln", conn);

		// ɾ�����ڻ���ƻ���
		JdbcDao.delete("loan_no = '"+loanNo+"'", "ac_ln_pay_pln_cur", conn);
		
	}
	
	/**
	 * 
	 * @���� DHCC-LIUJ
	 * @���� 2016-8-16
	 * @����	���ݻ�����ϸ���ɿۿ���ϸ
	 */
	public void getLoAcDebitDtlByPmLog(List<AcDebitDtl> acDebitDtlList,List<AcLnPmLog> loAcLnPmLogList,AcLnMst acLnMst,double loAmt,OperaInfo operaInfo) throws AccountingException{
		for(AcLnPmLog loAcLnPmLog : loAcLnPmLogList){
			AcDebitDtl acDebitDtl = new AcDebitDtl();
			acDebitDtl.setTraceNo(operaInfo.getTraceNo());
			acDebitDtl.setLoanNo(acLnMst.getLoanNo());
			acDebitDtl.setPactNo(acLnMst.getPactNo());
			acDebitDtl.setBrNo(acLnMst.getBrNo());
			acDebitDtl.setPerdNo(loAcLnPmLog.getPerdNo());
			acDebitDtl.setDdtlFeeAmt(0.00);
			acDebitDtl.setDdtlDate(ParmBiz.getOracleTxDate(operaInfo.getConn()));
			acDebitDtl.setDdtlSts(PUBConstant.DDTL_STS_PEND);// ������
			acDebitDtl.setTxDate(ParmBiz.getOracleTxDate(operaInfo.getConn()));
			acDebitDtl.setTxTime(ParmBiz.getOracleTxTime(operaInfo.getConn()));	
			acDebitDtl.setDdtlPrcpAmt(loAcLnPmLog.getRepayPrcpAmt());
			acDebitDtl.setDdtlNormInt(loAcLnPmLog.getRepayNormInt());
			acDebitDtl.setDdtlFineInt(loAcLnPmLog.getRepayFineInt());
			acDebitDtl.setDdtlAmt(loAcLnPmLog.getRepayPrcpAmt() + loAcLnPmLog.getRepayNormInt() + loAcLnPmLog.getRepayFineInt());
			loAmt = loAmt + loAcLnPmLog.getRepayPrcpAmt() + loAcLnPmLog.getRepayNormInt() + loAcLnPmLog.getRepayFineInt();
			acDebitDtlList.add(acDebitDtl);
		}		
	}
	
	/**
	 * 
	 * @���� DHCC-LIUJ
	 * @���� 2016-8-16
	 * @����	���ɿ۷�����ϸ
	 */
	public void getFeeAcDebitDtlByPmLog(List<AcDebitDtl> acDebitDtlList,List<AcLnPmLog> feeAcLnPmLogList,AcLnMst acLnMst,double myFeeAmt,double otherFeeAmt,OperaInfo operaInfo) throws AccountingException{
		for(AcLnPmLog loAcLnPmLog : feeAcLnPmLogList){
			//��ȡ���ñ���Ϣ
			AcChrgLog acChrgLog = (AcChrgLog)JdbcDao.query(new AcChrgLog(), "chrg_id='"+loAcLnPmLog.getChrgId()+"'", "ac_chrg_log", operaInfo.getConn());
			//���ɿۿ���ϸ
			AcDebitDtl acDebitDtl = new AcDebitDtl();
			acDebitDtl.setTraceNo(operaInfo.getTraceNo());
			acDebitDtl.setLoanNo(acLnMst.getLoanNo());
			acDebitDtl.setPactNo(acLnMst.getPactNo());
			acDebitDtl.setBrNo(acLnMst.getBrNo());
			acDebitDtl.setPerdNo(loAcLnPmLog.getPerdNo());
			acDebitDtl.setDdtlFeeAmt(loAcLnPmLog.getRepayFeeAmt());
			acDebitDtl.setDdtlDate(ParmBiz.getOracleTxDate(operaInfo.getConn()));
			acDebitDtl.setDdtlSts(PUBConstant.DDTL_STS_PEND);// ������
			acDebitDtl.setTxDate(ParmBiz.getOracleTxDate(operaInfo.getConn()));
			acDebitDtl.setTxTime(ParmBiz.getOracleTxTime(operaInfo.getConn()));	
			acDebitDtl.setDdtlPrcpAmt(0.00);
			acDebitDtl.setDdtlNormInt(0.00);
			acDebitDtl.setDdtlFineInt(0.00);
			acDebitDtl.setDdtlAmt(loAcLnPmLog.getRepayFeeAmt());
			//���շ�
			if(PUBConstant.FEE_KIND_01.equals(acChrgLog.getFeeKind())){
				myFeeAmt = myFeeAmt + loAcLnPmLog.getRepayFeeAmt();
			}else if(PUBConstant.FEE_KIND_02.equals(acChrgLog.getFeeKind())){
				otherFeeAmt = otherFeeAmt + loAcLnPmLog.getRepayFeeAmt();
			}
			acDebitDtlList.add(acDebitDtl);
		}		
	}
	
	/**
	 * 
	 * @���� DHCC-LIUJ
	 * @���� 2016-8-1
	 * @����	���ݷſ���־���ɿۿ���ϸ
	 */
	public AcDebitDtl getAcDebitDtlByLoanLog(AcLoanLog acLoanLog,OperaInfo operaInfo) throws AccountingException{
		AcDebitDtl acDebitDtl = new AcDebitDtl();
		acDebitDtl.setTraceNo(operaInfo.getTraceNo());
		acDebitDtl.setDdtlNo(ParmBiz.getAcDebitDtlNo(operaInfo.getConn()));
		acDebitDtl.setLoanNo(acLoanLog.getLoanNo());
		acDebitDtl.setPactNo(acLoanLog.getPactNo());
		acDebitDtl.setBrNo(acLoanLog.getBrNo());
		acDebitDtl.setDdtlPrcpAmt(acLoanLog.getLoanAmt());
		acDebitDtl.setDdtlNormInt(0.00);
		acDebitDtl.setDdtlFineInt(0.00);
		acDebitDtl.setDdtlFeeAmt(0.00);
		acDebitDtl.setDdtlAmt(acLoanLog.getLoanAmt());
		acDebitDtl.setDdtlDate(operaInfo.getBizDt());
		acDebitDtl.setXtAcNo(acLoanLog.getXtAcNo());
		acDebitDtl.setDdtlAcNo(acLoanLog.getLoanAcNo());
		acDebitDtl.setDdtlAcName(acLoanLog.getLoanAcName());
		acDebitDtl.setDdtlBankCode(acLoanLog.getLoanBankCode());
		acDebitDtl.setDdtlBankCity(acLoanLog.getLoanBankCity());
		acDebitDtl.setDdtlBankProv(acLoanLog.getLoanBankProv());
		acDebitDtl.setDdtlBankSite(acLoanLog.getLoanBankSite());
		acDebitDtl.setDdtlSts(PUBConstant.DDTL_STS_PEND);
		acDebitDtl.setTxDate(operaInfo.getBizDt());
		acDebitDtl.setTxTime(ParmBiz.getOracleTxTime(operaInfo.getConn()));
		
		return acDebitDtl;
	}
	
	/**
	 * 
	 * @���� DHCC-LIUJ
	 * @���� 2016-8-1
	 * @����	���ݿۿ���ϸ���ɿۿ��ļ�
	 */
	public AcDebit getAcDebitByDtl(AcDebitDtl acDebitDtl,AcLnMst acLnMst , OperaInfo operaInfo) throws AccountingException{
		
		AcDebit acDebit = new AcDebit();
		acDebit.setTraceNo(acDebitDtl.getTraceNo());
		acDebit.setTraceCnt(1);
		acDebit.setDebitNo(ParmBiz.getDebitNo(operaInfo.getConn()));
		acDebit.setTxDt(operaInfo.getBizDt());
		acDebit.setLoanNo(acDebitDtl.getLoanNo());
		acDebit.setPactNo(acDebitDtl.getPactNo());
		acDebit.setBrNo(acDebitDtl.getBrNo());
		acDebit.setAcctBankCde(acDebitDtl.getDdtlBankCode());
		acDebit.setAcNo(acDebitDtl.getDdtlAcNo());
		acDebit.setXtAcNo(acDebitDtl.getXtAcNo());
		acDebit.setCurNo(acLnMst.getCurNo());
		acDebit.setDebitType(PUBConstant.DEBIT_TYPE_01);
		acDebit.setAtpyAmt(acDebitDtl.getDdtlAmt());
		acDebit.setLoAmt(0.00);
		acDebit.setCurAmt(acDebitDtl.getDdtlAmt());
		acDebit.setMyFeeAmt(0.00);
		acDebit.setOtherFeeAmt(0.00);
		acDebit.setRepayAmt(0.00);
		acDebit.setSts(PUBConstant.DDTL_STS_PEND);
		acDebit.setCreateDt(operaInfo.getBizDt());
		return acDebit ;
	}
	
	/**
	 * 
	 * @���� DHCC-LIUJ
	 * @���� 2016-8-1
	 * @����	�����ձ������
	 */
	public void reverseRepayDt(OperaInfo operaInfo , AcTraceLog reverseTraceLog) throws AccountingException{
		String loanNo = reverseTraceLog.getLoanNo();
		Connection conn = operaInfo.getConn();
		
		// ��ô���������Ϣ
		AcLnMst acLnMst = (AcLnMst) JdbcDao.query(new AcLnMst(), "loan_no='"+loanNo+"'", "ac_ln_mst", conn);
		// �жϴ��������¼�Ƿ����
		if (acLnMst == null) {
			throw new AccountingException("��ѯ������ݡ�"+loanNo+"����Ӧ �Ĵ��������¼��");
		}
		
		// ��ý�ݱ���Ϣ
		AcLnDue acLnDue = (AcLnDue) JdbcDao.query(new AcLnDue(), "due_no='"+loanNo+"'", "ln_due", conn);
		// �жϴ��������¼�Ƿ����
		if (acLnDue == null) {
			throw new AccountingException("��ѯ������ݡ�"+loanNo+"����Ϣ");
		}
		
		//��ȡ �����ձ����¼
		AftPayday aftPayday = (AftPayday) JdbcDao.query(new AftPayday(), "trace_no='"+reverseTraceLog.getTraceNo()+"'", "aft_payday", conn);
		
		//��ȡ����ƻ���ʷ
		List<AcLnRepayPlnHst> oldPlnHst = (ArrayList)JdbcDao.queryList(new AcLnRepayPlnHst(), "trace_no='"+reverseTraceLog.getTraceNo()+"' order by perd_no asc", "ac_ln_repay_pln_hst", conn);
		
		//�»���ƻ�
		List<AcLnRepayPln> newPln = new ArrayList<AcLnRepayPln>();
		for(AcLnRepayPlnHst plnHst : oldPlnHst){
			AcLnRepayPln pln = getRpByRpHs(plnHst);
			newPln.add(pln);
		}
		if(oldPlnHst.size()>0){
		//�����ʼ�ڴ�
		int firstPerdNo = oldPlnHst.get(0).getPerdNo();
		
		//�ֻ���ƻ�
		List<AcLnRepayPln> nowPln = (ArrayList)JdbcDao.queryList(new AcLnRepayPln(), "loan_no='"+loanNo+"' and perd_no >='"+firstPerdNo+"'", "ac_ln_repay_pln", conn);

		for(AcLnRepayPln acLnRepayPln : nowPln){
			//��������ƻ���ʷ
			AcLnRepayPlnHst acLnRepayPlnHst = new AcLnRepayPlnHst();
			acLnRepayPlnHst = getRpHsByRp(acLnRepayPln , operaInfo.getTraceNo());
			JdbcDao.insert(acLnRepayPlnHst, "AC_LN_REPAY_PLN_HST", conn);
			JdbcDao.delete("loan_no='"+loanNo+"' and perd_no='"+acLnRepayPln.getPerdNo()+"'", "ac_ln_repay_pln", conn);
		}
		
		//��������ƻ�
		JdbcDao.insertList(newPln, "ac_ln_repay_pln", conn);
		}
		
		//���ɻ����ձ�Ϊ�»�����
		acLnMst.setRepayDay(aftPayday.getOldPayday());
		acLnMst.setUpDt(operaInfo.getBizDt());
		//���½�ݱ�����
		acLnDue.setPayDay(aftPayday.getOldPayday());
		acLnDue.setUpTime(ParmBiz.getOracleTxTime(conn));
		
		//���´�������
		JdbcDao.update(acLnMst, "loan_no='"+loanNo+"'", "ac_ln_mst", conn);
		
		//���½�ݱ�
		JdbcDao.update(acLnDue, "due_no='"+loanNo+"'", "ln_due", conn);
		
		//���¾�ҵ����ˮ��
		reverseTraceLog.setCancelInd(PUBConstant.REV_ROL_REV);
		reverseTraceLog.setCancelTraceNo(operaInfo.getTraceNo());
		JdbcDao.update(reverseTraceLog, "trace_no='"+reverseTraceLog.getTraceNo()+"'", "ac_trace_log", conn);

		//����������ˮ
		this.dealTraceLog(operaInfo,reverseTraceLog);
		
	}
	
	/*
	 * ���ݻ���ƻ���ȡ����ƻ���ʷ��Ϣ
	 */
	private AcLnRepayPlnHst getRpHsByRp(AcLnRepayPln acLnRepayPln,String traceNo){
		AcLnRepayPlnHst acLnRepayPlnHst = new AcLnRepayPlnHst();
		
		acLnRepayPlnHst.setTraceNo(traceNo);
		acLnRepayPlnHst.setLoanNo(acLnRepayPln.getLoanNo());
		acLnRepayPlnHst.setPactNo(acLnRepayPln.getPactNo());
		acLnRepayPlnHst.setBrNo(acLnRepayPln.getBrNo());
		acLnRepayPlnHst.setPerdNo(acLnRepayPln.getPerdNo());
		acLnRepayPlnHst.setPayDt(acLnRepayPln.getPayDt());
		acLnRepayPlnHst.setInstmAmt(acLnRepayPln.getInstmAmt());
		acLnRepayPlnHst.setPrcpAmt(acLnRepayPln.getPrcpAmt());
		acLnRepayPlnHst.setNormInt(acLnRepayPln.getNormInt());
		acLnRepayPlnHst.setFineInt(acLnRepayPln.getFineInt());
		acLnRepayPlnHst.setBal(acLnRepayPln.getBal());
		return acLnRepayPlnHst ;
	}
	
	/*
	 * ���ݻ���ƻ���ʷ��ȡ����ƻ���Ϣ
	 */
	private AcLnRepayPln getRpByRpHs(AcLnRepayPlnHst acLnRepayPlnHst){
		AcLnRepayPln acLnRepayPln = new AcLnRepayPln();
		
		acLnRepayPln.setLoanNo(acLnRepayPlnHst.getLoanNo());
		acLnRepayPln.setPactNo(acLnRepayPlnHst.getPactNo());
		acLnRepayPln.setBrNo(acLnRepayPlnHst.getBrNo());
		acLnRepayPln.setPerdNo(acLnRepayPlnHst.getPerdNo());
		acLnRepayPln.setPayDt(acLnRepayPlnHst.getPayDt());
		acLnRepayPln.setInstmAmt(acLnRepayPlnHst.getInstmAmt());
		acLnRepayPln.setPrcpAmt(acLnRepayPlnHst.getPrcpAmt());
		acLnRepayPln.setNormInt(acLnRepayPlnHst.getNormInt());
		acLnRepayPln.setFineInt(acLnRepayPlnHst.getFineInt());
		acLnRepayPln.setBal(acLnRepayPlnHst.getBal());
		return acLnRepayPln ;
	}
	
	/**
	 * 
	 * @���� DHCC-LIUJ
	 * @���� 2016-8-1
	 * @����	�����ʺű������
	 */
	public void reverseAcno(OperaInfo operaInfo , AcTraceLog reverseTraceLog) throws AccountingException{
		String loanNo = reverseTraceLog.getLoanNo();
		Connection conn = operaInfo.getConn();
		
		// ��ô���������Ϣ
		AcLnMst acLnMst = (AcLnMst) JdbcDao.query(new AcLnMst(), "loan_no='"+loanNo+"'", "ac_ln_mst", conn);
		// �жϴ��������¼�Ƿ����
		if (acLnMst == null) {
			throw new AccountingException("��ѯ������ݡ�"+loanNo+"����Ӧ �Ĵ��������¼��");
		}
		// ��ý�ݱ���Ϣ
		AcLnDue acLnDue = (AcLnDue) JdbcDao.query(new AcLnDue(), "due_no='"+loanNo+"'", "ln_due", conn);
		if (acLnDue == null) {
			throw new AccountingException("��ѯ������ݡ�"+loanNo+"����Ӧ �Ľ����Ϣ��");
		}
		//��ô��󻹿��˺ű����¼
		AftAcno aftAcno = (AftAcno) JdbcDao.query(new AftAcno(), "trace_no='"+reverseTraceLog.getTraceNo()+"'", "aft_acno", conn);
		if (aftAcno == null) {
			throw new AccountingException("��ѯ������ݡ�"+loanNo+"����Ӧ �Ļ����˺ű����¼��");
		}
		//��ۿ��˻�
		LnAcct lnAcct = (LnAcct) JdbcDao.query(new LnAcct(), "app_id='"+acLnDue.getAppId()+"' and ac_use='01'", "ln_acct", conn);
		if (lnAcct == null) {
			throw new AccountingException("��ѯ������ݡ�"+loanNo+"����Ӧ �Ļ����˺���Ϣ��");
		}
		//���þɿۿ��˻���Ϣ
		lnAcct.setAcNo(aftAcno.getOldAcNo());
		lnAcct.setAcName(aftAcno.getOldAcName());
		lnAcct.setAcType(aftAcno.getOldAcType());
		lnAcct.setBankCode(aftAcno.getOldOpnCode());
		
		//���´����˻���
		JdbcDao.update(lnAcct, "app_id='"+acLnDue.getAppId()+"' and ac_use='01'", "ln_acct", conn);

		//���¾�ҵ����ˮ��
//		reverseTraceLog.setCancelInd(PUBConstant.REV_ROL_REV);
//		reverseTraceLog.setCancelTraceNo(operaInfo.getTraceNo());
//		JdbcDao.update(reverseTraceLog, "trace_no='"+reverseTraceLog.getTraceNo()+"'", "ac_trace_log", conn);

		//����������ˮ
		this.dealTraceLog(operaInfo,reverseTraceLog);
		
	}
	
	/**
	 * 
	 * @���� DHCC-LIUJ
	 * @���� 2016-8-1
	 * @����	Ϣ�Ѽ������
	 */
	public void reverseRelief(OperaInfo operaInfo , AcTraceLog reverseTraceLog) throws AccountingException{
		String loanNo = reverseTraceLog.getLoanNo();
		Connection conn = operaInfo.getConn();
		
		// ��ô���������Ϣ
		AcLnMst acLnMst = (AcLnMst) JdbcDao.query(new AcLnMst(), "loan_no='"+loanNo+"'", "ac_ln_mst", conn);
		// �жϴ��������¼�Ƿ����
		if (acLnMst == null) {
			throw new AccountingException("��ѯ������ݡ�"+loanNo+"����Ӧ �Ĵ��������¼��");
		}
		
		// ��ô���Ϣ�Ѽ�����ϸ
		List<AftReliefDtl> ardList = (ArrayList)JdbcDao.queryList(new AftReliefDtl(), "trace_no='"+reverseTraceLog.getTraceNo()+"'","aft_relief_dtl", conn);
		
		//ԭ������=���м����� - �����ļ�����
		for(AftReliefDtl aftReliefDtl : ardList){
			if("01".equals(aftReliefDtl.getReliefType())){//������������ϸ
				//Ƿ�����Ϣ
				AcLnLo acLnLo = (AcLnLo)JdbcDao.query(new AcLnLo(), "loan_no='"+aftReliefDtl.getLoanNo()+"' and perd_no='"+aftReliefDtl.getPerdNo()+"'", "ac_ln_lo", conn);
				//����ƻ�
				AcLnRepayPln acLnRepayPln = (AcLnRepayPln)JdbcDao.query(new AcLnRepayPln(), "loan_no='"+aftReliefDtl.getLoanNo()+"' and perd_no='"+aftReliefDtl.getPerdNo()+"'", "ac_ln_repay_pln", conn);
				
				//����Ƿ����������
				acLnLo.setWvPrcpAmt(acLnLo.getWvPrcpAmt()-aftReliefDtl.getRefAmt());
				acLnLo.setWvNormInt(acLnLo.getWvNormInt()-aftReliefDtl.getRefIntst());
				acLnLo.setWvFineInt(acLnLo.getWvFineInt()-aftReliefDtl.getRefFine());
				JdbcDao.update(acLnLo, "loan_no='"+aftReliefDtl.getLoanNo()+"' and perd_no='"+aftReliefDtl.getPerdNo()+"'", "ac_ln_lo", conn);
				
				//���»���ƻ����������
				acLnRepayPln.setWvPrcpAmt(acLnRepayPln.getWvPrcpAmt()-aftReliefDtl.getRefAmt());
				acLnRepayPln.setWvNormInt(acLnRepayPln.getWvNormInt()-aftReliefDtl.getRefIntst());
				acLnRepayPln.setWvFineInt(acLnRepayPln.getWvFineInt()-aftReliefDtl.getRefFine());
				JdbcDao.update(acLnRepayPln, "loan_no='"+aftReliefDtl.getLoanNo()+"' and perd_no='"+aftReliefDtl.getPerdNo()+"'", "ac_ln_repay_pln", conn);
			}else{
				//�ع��������
				List<AcChrgLog> acChrgLogList = (ArrayList)JdbcDao.queryList(new AcChrgLog(), "loan_no='"+aftReliefDtl.getLoanNo()+"' and perd_no='"+aftReliefDtl.getPerdNo()+"'","ac_chrg_log", conn);
				double refFee = aftReliefDtl.getRefFee();
				for(AcChrgLog acChrgLog : acChrgLogList){
					if(refFee>0.00){
						if( NumberUtil.isAmtGreat(refFee, acChrgLog.getWvChrgAmt())){//��������ô��ڱ��ڼ�����
							acChrgLog.setWvChrgAmt(0.00);
							refFee = refFee - acChrgLog.getWvChrgAmt();
						}else{
							acChrgLog.setWvChrgAmt( acChrgLog.getWvChrgAmt() - refFee);
							refFee = 0.00;
						}
						JdbcDao.update(acChrgLog, "chrg_id='"+acChrgLog.getChrgId()+"'", "ac_chrg_log", conn);
					}
				}
			
			}
		}
		
		
		//���¾�ҵ����ˮ��
		reverseTraceLog.setCancelInd(PUBConstant.REV_ROL_REV);
		reverseTraceLog.setCancelTraceNo(operaInfo.getTraceNo());
//		JdbcDao.update(reverseTraceLog, "trace_no='"+reverseTraceLog.getTraceNo()+"'", "ac_trace_log", conn);

		//����������ˮ
		this.dealTraceLog(operaInfo,reverseTraceLog);
		
	}
	
	/**
	 * ��ǰ�������
	 * 
	 * @param operaInfo			ҵ���������
	 * @param reverseTraceLog	�����˽�����ˮ����
	 * 
	 * @throws AccountingException
	 */
	public void reverseAdvpay(OperaInfo operaInfo, AcTraceLog reverseTraceLog) throws AccountingException {
		String sql = "" ;
		
		String reverseTraceNo = reverseTraceLog.getTraceNo();	// ԭ������ˮ��
		String loanNo = reverseTraceLog.getLoanNo() ;		// ��ݺ�
		
		Connection conn = operaInfo.getConn() ;

		// �������ļ�
		AcLnMst acLnMst = (AcLnMst)JdbcDao.query(new AcLnMst(), "loan_no='"+loanNo+"'", "ac_ln_mst", conn);

		// ��ô�����ǰ������־��
		AcLnSetlmtLog acLnSetlmtLog = (AcLnSetlmtLog) JdbcDao.query(new AcLnSetlmtLog(), "loan_no='"+loanNo+"' and trace_no=" + reverseTraceNo, "ac_ln_setlmt_log", conn);
		
		//��ȡ����ƻ���ʷ
		List<AcLnRepayPlnHst> oldPlnHst = (ArrayList)JdbcDao.queryList(new AcLnRepayPlnHst(), "trace_no='"+reverseTraceLog.getTraceNo()+"' and loan_no='"+loanNo+"' order by perd_no asc", "ac_ln_repay_pln_hst", conn);
		
		//�»���ƻ�
		List<AcLnRepayPln> newPln = new ArrayList<AcLnRepayPln>();
		for(AcLnRepayPlnHst plnHst : oldPlnHst){
			AcLnRepayPln pln = getRpByRpHs(plnHst);
			newPln.add(pln);
		}
		//�����ʼ�ڴ�
		int firstPerdNo = oldPlnHst.get(0).getPerdNo();
		
		//�ֻ���ƻ�
		List<AcLnRepayPln> nowPln = (ArrayList)JdbcDao.queryList(new AcLnRepayPln(), "loan_no='"+loanNo+"' and perd_no >='"+firstPerdNo+"'", "ac_ln_repay_pln", conn);

		for(AcLnRepayPln acLnRepayPln : nowPln){
			//��������ƻ���ʷ
			AcLnRepayPlnHst acLnRepayPlnHst = new AcLnRepayPlnHst();
			acLnRepayPlnHst = getRpHsByRp(acLnRepayPln , operaInfo.getTraceNo());
			JdbcDao.insert(acLnRepayPlnHst, "AC_LN_REPAY_PLN_HST", conn);
			JdbcDao.delete("loan_no='"+loanNo+"' and perd_no='"+acLnRepayPln.getPerdNo()+"'", "ac_ln_repay_pln", conn);
		}
		
		//��������ƻ�
		JdbcDao.insertList(newPln, "ac_ln_repay_pln", conn);
		
		//ɾ�����ڻ���ƻ�
		JdbcDao.delete("loan_no='"+loanNo+"' and perd_no='"+newPln.get(0).getPerdNo()+"'", "ac_ln_repay_pln_cur", conn);
		
		//�������ڻ���ƻ�
		AcLnRepayPlnCur acPlnCur = getPlnCurByPln(newPln.get(0),operaInfo);
		JdbcDao.insert(acPlnCur, "ac_ln_repay_pln_cur", conn);
		
		//���¾�ҵ����ˮ��
		reverseTraceLog.setCancelInd(PUBConstant.REV_ROL_REV);
		reverseTraceLog.setCancelTraceNo(operaInfo.getTraceNo());
		JdbcDao.update(reverseTraceLog, "trace_no='"+reverseTraceLog.getTraceNo()+"'", "ac_trace_log", conn);

		//����������ˮ
		this.dealTraceLog(operaInfo,reverseTraceLog);
	}
	
	/*
	 * ��ȡ���ڻ���ƻ�
	 */
	public AcLnRepayPlnCur getPlnCurByPln(AcLnRepayPln acLnRepayPln , OperaInfo operaInfo) throws AccountingException{
		AcLnRepayPlnCur acPlnCur = new AcLnRepayPlnCur();
		acPlnCur.setLoanNo(acLnRepayPln.getLoanNo());
		acPlnCur.setPactNo(acLnRepayPln.getPactNo());
		acPlnCur.setBrNo(acLnRepayPln.getBrNo());
		acPlnCur.setTtlAmt(acLnRepayPln.getInstmAmt());
		acPlnCur.setPerdNo(acLnRepayPln.getPerdNo());
		acPlnCur.setPrcpAmt(acLnRepayPln.getPrcpAmt());
		acPlnCur.setNormInt(acLnRepayPln.getNormInt());
		acPlnCur.setWrkDt(operaInfo.getBizDt());
		acPlnCur.setPayDt(acLnRepayPln.getPayDt());
		acPlnCur.setEndDt(acLnRepayPln.getPayDt());
		acPlnCur.setRepayPrcpAmt(acLnRepayPln.getRepayPrcpAmt());
		acPlnCur.setRepayNormInt(acLnRepayPln.getRepayNormInt());
		return acPlnCur;
	}
}