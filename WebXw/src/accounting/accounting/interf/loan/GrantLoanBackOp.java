package accounting.interf.loan;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import accounting.biz.loan.RepayBiz;
import accounting.biz.pub.AcLnRepayPlnBiz;
import accounting.biz.pub.ParmBiz;
import accounting.domain.fee.AcChrgLog;
import accounting.domain.loan.AcLnDue;
import accounting.domain.loan.AcLnMst;
import accounting.domain.loan.AcLnRepayPln;
import accounting.domain.loan.AcLnRepayPlnCur;
import accounting.domain.loan.AcLoanBackLog;
import accounting.domain.loan.AcLoanLog;
import accounting.domain.loan.AcTraceLog;
import accounting.domain.loan.AftAcno;
import accounting.domain.loan.LnAcct;
import accounting.domain.loan.LnApplyMid;
import accounting.domain.loan.LnBatch;
import accounting.domain.loan.LnPact;
import accounting.domain.loan.LnStage;
import accounting.domain.loan.PrdtBase;
import accounting.domain.loan.ProjAcct;
import accounting.domain.sys.AfferentDomain;
import accounting.domain.sys.OperaInfo;
import accounting.domain.ws.WsAcnoChg;
import accounting.plat.PUBConstant;
import accounting.plat.TransCode;
import accounting.plat.core.AccountingException;
import accounting.plat.core.Operation;
import accounting.plat.dao.JdbcDao;
import accounting.plat.util.NumberUtil;
import app.util.DateUtil;


public class GrantLoanBackOp extends Operation {
	/**
	 * �ſ�������� 
	 * @param afferentDomain     ����ſ����ݶ���
	 * @return  
	 */
	public Object doExecute(AfferentDomain afferentDomain)throws AccountingException{
		AcLoanBack lb;
		
		if (afferentDomain instanceof AcLoanBack) {
			lb = (AcLoanBack) afferentDomain;
		} else {
			throw new AccountingException("�������Ͳ�ƥ�䣡");
		}
		
		Connection conn = this.getConnection();

		//�õ�ҵ�����
		String traceNo = ParmBiz.getTraceNo(conn);
		String backRes = lb.getBackRes();//�ſ���
		String status = lb.getStatus();//����״̬
		String failCaus = lb.getFailCaus();//ʧ��ԭ��
		String cardChn = lb.getCardChn();//֧������
		
		// ����ҵ���������
		OperaInfo operaInfo = new OperaInfo(afferentDomain, traceNo, conn);
		operaInfo.setBizDt(ParmBiz.getBizDt(conn));//���㽻������
		operaInfo.setTxDt(ParmBiz.getBizDt(conn));//���㽻������

		
		//����֧����������Ϣ
		AcLoanBackLog acLoanBackLog = (AcLoanBackLog)JdbcDao.query(new AcLoanBackLog(), "back_log_no='"+lb.getBackLogNo()+"' and back_cnt='"+lb.getBackCnt()+"'", "ac_loan_back_log", conn);
		
		//���ݷſ���ˮ�Ų�ѯ�ſ���Ϣ��
		AcLoanLog acLoanLog = (AcLoanLog)JdbcDao.query(new AcLoanLog(), "loan_log_no='"+acLoanBackLog.getLoanLogNo()+"'", "ac_loan_log", operaInfo.getConn());
		
		//����ˮ��Ϣ
		AcTraceLog acTraceLog = (AcTraceLog)JdbcDao.query(new AcTraceLog(), "trace_no='"+acLoanLog.getTraceNo()+"'", "ac_trace_log", conn);
		
		//�����Ϣ
		AcLnDue acLnDue = null;

		//ҵ��׶���Ϣ
		LnStage lnStage = null;
		
		//��ʽ����������ϸ
		LnApplyMid lnApplyMid = null;
		
		//��ʽ������ͬ��
		LnPact lnPact = null;
		
		//�ſ��˺���Ϣ
		List<LnAcct> lnAcctList = null;
		
		//�ſ���Ϣ
		LnAcct lnAcct = null;
		
		// ����������Ϣ
		AcLnMst acLnMst = null;
		
		//����������Ϣ
		LnBatch lnBatch = null;
		
		//�ſ�ɹ���ȡ��������״̬
		PreparedStatement queryResultStsPst = null;
		ResultSet queryResultStsRs = null;
		
		String txCde = acTraceLog.getTxCde();//���״���
		if("01".equals(backRes)||"02".equals(backRes)){//�ſ���Ϊ�ɹ�/ʧ�ܣ�����
		
		try{
					
			//�����Ϣ
			acLnDue = (AcLnDue)JdbcDao.query(new AcLnDue(), "due_no='"+acLoanLog.getLoanNo()+"'", "ln_due", conn);

			//ҵ��׶���Ϣ
			lnStage = (LnStage)JdbcDao.query(new LnStage(), "app_id='"+acLnDue.getAppId()+"'", "ln_stage", conn);
			
			//��ʽ����������ϸ
			lnApplyMid = (LnApplyMid)JdbcDao.query(new LnApplyMid(), "app_id='"+acLnDue.getAppId()+"'", "ln_apply_mid", conn);
			
			//��ʽ������ͬ��
			lnPact = (LnPact)JdbcDao.query(new LnPact(), "app_id='"+acLnDue.getAppId()+"'", "ln_pact", conn);
			
			//�ſ��˺���Ϣ
			lnAcctList = (ArrayList)JdbcDao.queryList(new LnAcct(), "app_id='"+acLnDue.getAppId()+"' and ac_use='2' and ac_sts='01' ","ln_acct", conn);
			
			//�ſ���Ϣ
			lnAcct = (LnAcct)JdbcDao.query(new LnAcct(), "app_id='"+acLnDue.getAppId()+"' and ac_use='2' and ac_no='"+acLoanLog.getLoanAcNo()+"'", "ln_acct", conn);
			
			// ����������Ϣ
			acLnMst = (AcLnMst)JdbcDao.query(new AcLnMst(), "loan_no='"+acLoanLog.getLoanNo()+"'", "ac_ln_mst", operaInfo.getConn());
			
			//����������Ϣ
			lnBatch = (LnBatch)JdbcDao.query(new LnBatch(), "batch_no='"+acLnDue.getBatchNo()+"'", "ln_batch", conn);
			
			PrdtBase prdtBase = (PrdtBase) JdbcDao.query(new PrdtBase(), "prdt_no='"+acLnMst.getPrdtNo()+"'", "PRDT_BASE", conn);
			if (prdtBase == null) {
				throw new AccountingException("��ѯ������Ӧ��Ʒ����Ϣ!");
			}
			
			
			
			// ��������������ȡ
			
			
			
			if("01".equals(backRes)){//�ſ���Ϊ�ɹ�
				if(lnAcct==null){//����
					//��ȡ��Ӧ���ü�¼
					List<AcChrgLog> acChrgLogList = (ArrayList)JdbcDao.queryList(new AcChrgLog(), "trace_no='"+acLoanLog.getTraceNo()+"' and loan_no='"+acLnMst.getLoanNo()+"'", "ac_chrg_log", conn);
					double payChrgAmt = acLoanLog.getLoanAmt();
					for(AcChrgLog acChrgLog : acChrgLogList){
						if(payChrgAmt>0){
							if(NumberUtil.isAmtGreat(payChrgAmt,acChrgLog.getRepayChrgAmt())){
								acChrgLog.setPayChrgAmt(acChrgLog.getPayChrgAmt()+acChrgLog.getRepayChrgAmt());
								payChrgAmt = payChrgAmt - acChrgLog.getRepayChrgAmt();
							}else{
								acChrgLog.setPayChrgAmt(acChrgLog.getPayChrgAmt()+payChrgAmt);
								payChrgAmt = 0.00;
							}
						}
					}
				
			}else if(lnAcctList.size()==1){//һ����������ſ�
				//���´������ļ�
				//��ȡ���̺�ǰ������Ϊ������ʼ��
				String begDate = operaInfo.getBizDt();
				//�����»�ȡ�Ĵ�����ʼ�� �����������¡�����������  -- ����������
				String endDate = DateUtil.addByDay(DateUtil.getDateStr(begDate, acLnMst.getTermMon()), acLnMst.getTermDay());
				acLnMst.setOpnDt(begDate);
				acLnMst.setIcDt(begDate);
				acLnMst.setMtrDt(endDate);
				acLnMst.setLoanBal(acLnMst.getLoanBal()+acLoanLog.getLoanAmt());//���´������
				acLnMst.setLoanSts("01");//����״̬Ϊ����
				acLnMst.setDealSts("03");//���´���״̬Ϊ�ſ�ɹ�
				
				List<AcLnRepayPln> acLnRepayPlnList = new ArrayList<AcLnRepayPln>();
				AcLnRepayPlnBiz acLnRepayPlnBiz = new AcLnRepayPlnBiz();
				if (PUBConstant.BR_ACC_TYPE_A.equals(acLnMst
						.getBrAccType())) {// A������ſ�ɹ������ɻ���ƻ�
					acLnRepayPlnList = acLnRepayPlnBiz
							.getAcLnRepayPln(acLnMst, prdtBase,
									operaInfo);
					JdbcDao.insertList(acLnRepayPlnList,
							"AC_LN_REPAY_PLN", conn);

					// ���ɻ���ƻ���������
					AcLnRepayPlnCur acLnRepayPlnCur = acLnRepayPlnBiz
							.getAcLnRepayPlnCur(
									acLnRepayPlnList.get(0),
									acLnMst, operaInfo.getBizDt());
					JdbcDao.insert(acLnRepayPlnCur,
							"AC_LN_REPAY_PLN_CUR", conn);
					acLnMst.setCurDueDt(acLnRepayPlnCur.getPayDt()); // ��ǰ�黹����
					acLnMst.setNextDueDt(acLnRepayPlnCur.getPayDt()); // ��һ�λ�����
					acLnMst.setIntToStpInd(PUBConstant.N);
				}
				
				acLoanLog.setLoanSts(PUBConstant.LOAN_STS_SUCC);//�ſ���Ϣ��״̬����Ϊ�ſ�ɹ�
				
				//���½�ݱ�
				acLnDue.setBegDate(begDate);
				acLnDue.setEndDate(endDate);
				acLnDue.setDueSts("02");//����
				//����ҵ��׶α�
				lnStage.setPaySts("02");//�ſ�ɹ�
				lnStage.setRsDesc("�ſ�ɹ�");
				lnBatch.setBatchSts("03");//�������
				lnBatch.setDueAmt(lnBatch.getDueAmt()+lnApplyMid.getAppAmt());
				lnApplyMid.setBegDate(begDate);
				lnApplyMid.setEndDate(endDate);
				lnPact.setBegDate(begDate);
				lnPact.setEndDate(endDate);
				
			}else if(lnAcctList.size()>=2){//ά�ſ����� ���ڶ���ſ��
				//�������˺�
				String otherAccNo ="";
				for(LnAcct otherLnAcct : lnAcctList){
					if(!otherLnAcct.getAcNo().equals(acLoanLog.getLoanAcNo())){//�Ǳ���
						if(otherAccNo.equals("")){
							otherAccNo += otherLnAcct.getAcNo();
						}else{
							otherAccNo += "','"+otherLnAcct.getAcNo();
						}
					}
				}
				queryResultStsPst = conn.prepareStatement("select case when (select count(*) from (select * "+
             			" from (select loan_ac_no,loan_sts,"+
                        " dense_rank() over(partition by loan_ac_no order by up_date desc) AS xc "+
                        " from ac_loan_log where loan_ac_no in(?)  and app_id = ? ) "+
                        " where xc = 1 and loan_sts in ('02', '06')) ) > 0 then '01' "+
                        " when (select count(*) from(select * from (select loan_ac_no,loan_sts, "+
                        " dense_rank() over(partition by loan_ac_no order by up_date desc) AS xc "+
                        " from ac_loan_log where loan_ac_no in(?) and app_id = ? "+
                        " ) where xc = 1 and loan_sts in('04','05')) ) > 0 then "+
                        " '02' else '03' end as result_sts from dual");
				queryResultStsPst.setString(1, otherAccNo);
				queryResultStsPst.setString(2, acLnDue.getAppId());
				queryResultStsPst.setString(3, otherAccNo);
				queryResultStsPst.setString(4, acLnDue.getAppId());
				queryResultStsRs = queryResultStsPst.executeQuery();
				String resultSts ="";
				if(queryResultStsRs.next()){
					resultSts= queryResultStsRs.getString("result_sts");
				}
				
				if(resultSts.equals("03")){//�ɹ�
					//���´������ļ�
					//��ȡ���̺�ǰ������Ϊ������ʼ��
					String begDate = operaInfo.getBizDt();
					//�����»�ȡ�Ĵ�����ʼ�� �����������¡�����������  -- ����������
					String endDate = DateUtil.addByDay(DateUtil.getDateStr(begDate, acLnMst.getTermMon()), acLnMst.getTermDay());
					acLnMst.setOpnDt(begDate);
					acLnMst.setIcDt(begDate);
					acLnMst.setMtrDt(endDate);
					acLnMst.setLoanBal(acLnMst.getLoanBal()+acLoanLog.getLoanAmt());//���´������
					acLnMst.setLoanSts("01");//����״̬Ϊ����
					acLnMst.setDealSts("03");//���´���״̬Ϊ�ſ�ɹ�
					
					List<AcLnRepayPln> acLnRepayPlnList = new ArrayList<AcLnRepayPln>();
					AcLnRepayPlnBiz acLnRepayPlnBiz = new AcLnRepayPlnBiz();
					
					acLoanLog.setLoanSts(PUBConstant.LOAN_STS_SUCC);//�ſ���Ϣ��״̬����Ϊ�ſ�ɹ�
					
					//���½�ݱ�
					acLnDue.setBegDate(begDate);
					acLnDue.setEndDate(endDate);
					acLnDue.setDueSts("02");//����
					//����ҵ��׶α�
					lnStage.setPaySts("02");//�ſ�ɹ�
					lnStage.setRsDesc("�ſ�ɹ�");
					lnBatch.setBatchSts("03");//�������
					lnBatch.setDueAmt(lnBatch.getDueAmt()+lnApplyMid.getAppAmt());
					lnApplyMid.setBegDate(begDate);
					lnApplyMid.setEndDate(endDate);
					lnPact.setBegDate(begDate);
					lnPact.setEndDate(endDate);
					}else if(resultSts.equals("02")){//����ʧ��
						acLnDue.setBal(acLnDue.getBal()+acLoanLog.getLoanAmt());
						acLnMst.setLoanBal(acLnMst.getLoanBal()+acLoanLog.getLoanAmt());
						acLnMst.setDealSts("05");//���´���״̬Ϊ���ַſ�ɹ�
						
						lnStage.setPaySts("04");//���ַſ�ɹ�
						lnStage.setRsDesc("���ַſ�ɹ�");
						lnBatch.setBatchSts("02");//������
					}else if(resultSts.equals("01")){//����δ��ֻ�������
						acLnDue.setBal(acLnDue.getBal()+acLoanLog.getLoanAmt());
						acLnMst.setLoanBal(acLnMst.getLoanBal()+acLoanLog.getLoanAmt());
					}
				}
				acLoanLog.setLoanSts("03");//�ſ�ɹ�

			}else if("02".equals(backRes)){//02Ϊʧ��
				if(lnAcct==null){//����
					
				}else if(lnAcctList.size()==1) {//һ����������ſ�
					acLnMst.setDealSts("04");//���´���״̬Ϊ�ſ�ʧ��
					acLnMst.setFailCaus(failCaus);//ʧ��ԭ��
					acLnDue.setDueSts("09");//�ſ�ʧ��
					//����ҵ��׶α�
					lnStage.setPaySts("03");//�ſ�ʧ��
					lnStage.setRsDesc(failCaus);
					lnBatch.setBatchSts("03");//�������
//					_del_result = WorkUtils.getInstance().proc_pact_del(acLnDue.getPactId());
					//�ſ�ʧ�ܣ��ʽ�س�
					try {
						RepayBiz.PROC_REACC_FUND(acLnMst.getLoanNo(), acLoanLog.getLoanAmt(), 0.00,"�ſ�ʧ��", "ADD", conn);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}else if(lnAcctList.size()>=2) {//������
					
					//�������˺�
					String otherAccNo ="";
					for(LnAcct otherLnAcct : lnAcctList){
						if(!otherLnAcct.getAcNo().equals(acLoanLog.getLoanAcNo())){//�Ǳ���
							if(otherAccNo.equals("")){
								otherAccNo += otherLnAcct.getAcNo();
							}else{
								otherAccNo += "','"+otherLnAcct.getAcNo();
							}
						}
					}
					
					queryResultStsPst = conn.prepareStatement("select case when (select count(*) from (select * "+
                 			" from (select loan_ac_no,loan_sts,"+
                            " dense_rank() over(partition by loan_ac_no order by up_date desc) AS xc "+
                            " from ac_loan_log where loan_ac_no in(?)  and app_id = ? ) "+
                            " where xc = 1 and loan_sts in ('02', '06')) ) > 0 then '01' "+
                            " when (select count(*) from(select * from (select loan_ac_no,loan_sts, "+
                            " dense_rank() over(partition by loan_ac_no order by up_date desc) AS xc "+
                            " from ac_loan_log where loan_ac_no in(?) and app_id = ? "+
                            " ) where xc = 1 and loan_sts=?) ) > 0 then "+
                            " '02' else '03' end as result_sts from dual");
					queryResultStsPst.setString(1, otherAccNo);
					queryResultStsPst.setString(2, acLnDue.getAppId());
					queryResultStsPst.setString(3, otherAccNo);
					queryResultStsPst.setString(4, acLnDue.getAppId());
					queryResultStsPst.setString(5, "03");//�ɹ�
					queryResultStsRs = queryResultStsPst.executeQuery();
					String resultSts ="";
					if(queryResultStsRs.next()){
						resultSts= queryResultStsRs.getString("result_sts");
					}
					if(resultSts.equals("01")){//����δ������������
						
					}else if(resultSts.equals("02")){//���ڳɹ�
						acLnMst.setDealSts("05");// ���´���״̬Ϊ���ֳɹ�
						acLnMst.setFailCaus(failCaus);// ʧ��ԭ��
						acLnDue.setDueSts("09");// �ſ�ʧ��
						// ����ҵ��׶α�
						lnStage.setPaySts("04");// �ſ�ֳɹ�
						lnStage.setRsDesc("���ַſ�ɹ�");
						lnBatch.setBatchSts("02");//������
					}else if(resultSts.equals("03")){//�����ȶ�Ϊʧ��
						acLnMst.setDealSts("04");// ���´���״̬Ϊ�ſ�ʧ��
						acLnMst.setFailCaus(failCaus);// ʧ��ԭ��
						acLnDue.setDueSts("09");// �ſ�ʧ��
						// ����ҵ��׶α�
						lnStage.setPaySts("03");// �ſ�ʧ��
						lnStage.setRsDesc(failCaus);
						lnBatch.setBatchSts("03");//�������
						
						//�ſ�ʧ�ܣ��ʽ�س�
						try {
							RepayBiz.PROC_REACC_FUND(acLnMst.getLoanNo(), acLoanLog.getLoanAmt(), 0.00,"�ſ�ʧ��", "ADD", conn);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
				acLoanLog.setLoanSts("04");//�ſ���Ϣ��״̬����Ϊ�ſ�ʧ��
				acLoanLog.setUpDate(ParmBiz.getOracleUpDate(conn));
				
			}else{
				if(lnAcct==null){//����
					
				}else {//һ����������ſ�
					acLnMst.setDealSts("07");//���´���״̬Ϊ�ſ�δ��
					lnStage.setRsDesc(failCaus);//���½����׶α�����,��ѯʹ��
				}
				acLoanLog.setLoanSts("06");//�ſ���Ϣ��״̬����Ϊ�ſ�δ��
				acLoanLog.setUpDate(ParmBiz.getOracleUpDate(conn));
			}
			
			acLnMst.setLstDt(operaInfo.getTxDt());						//�����ϱʷ������ڡ���ǰӪҵ���ڡ�
			acLnMst.setUpDt(operaInfo.getTxDt());
			
			
			
			JdbcDao.update(acLnMst, "loan_no='"+acLnMst.getLoanNo()+"'", "ac_ln_mst", conn);
			
			//����ln_pact���ͬ��ʼʱ��
			JdbcDao.update(lnPact, "app_id='"+acLnDue.getAppId()+"'", "ln_Pact", conn);
			//���½�ݱ�״̬
			JdbcDao.update(acLnDue, "due_no='"+acLnDue.getDueNo()+"'", "ln_due", conn);
			
			//����ҵ��׶α�
			JdbcDao.update(lnStage, "app_id='"+acLnDue.getAppId()+"'", "ln_stage", conn);
			
			//���½�������
			JdbcDao.update(lnBatch, "batch_no='"+acLnDue.getBatchNo()+"'", "ln_batch", conn);
			
			//����ln_apply_mid��ſ�ʱ��
			if(lnApplyMid != null){
				JdbcDao.update(lnApplyMid, "app_id='"+acLnDue.getAppId()+"'", "ln_apply_mid", conn);
			}

			//ԭ�ſ���ˮΪ�˻����������Ҫ����WS��AFT��
			if(TransCode.LNUP.equals(acTraceLog.getTxCde())){
				AftAcno aftAcno = (AftAcno)JdbcDao.query(new AftAcno(), "trace_no='"+acTraceLog.getTraceNo()+"'", "aft_acno", conn);
				if(aftAcno.getChgId().length()==20){
					WsAcnoChg wsAcnoChg = (WsAcnoChg)JdbcDao.query(new WsAcnoChg(), "ws_id='"+aftAcno.getChgId()+"'", "ws_acno_chg", conn);
					if("01".equals(backRes)){
						wsAcnoChg.setDealSts("03");
						wsAcnoChg.setDealDesc("����ɹ�");
						aftAcno.setChgSts("03");
					}else{
						wsAcnoChg.setDealSts("04");
						wsAcnoChg.setDealDesc(failCaus);
						aftAcno.setChgSts("04");
					}
					JdbcDao.update(wsAcnoChg, "ws_id='"+wsAcnoChg.getWsId()+"'", "ws_acno_chg", conn);
					JdbcDao.update(aftAcno, "chg_id='"+wsAcnoChg.getWsId()+"'", "aft_acno", conn);
				}
				//JdbcDao.query(aftAcno, "chg_id='"+aftAcno.getChgId()+"'", "aft_acno", conn);
				//�����˺ű����ˮΪ����
				acTraceLog.setCancelInd("NORM");
				//JdbcDao.query(acTraceLog, "trace_no='"+acTraceLog.getTraceNo()+"'", "ac_trace_log", conn);
			}
			
//			//��õǼǽ�����ˮ
//			AcTraceLog traceLog = this.getTraceLog(operaInfo, acLnMst,acLoanLog);
//			JdbcDao.insert(traceLog, "AC_TRACE_LOG", conn);
		
//		}
		
		//���·ſ����״̬
		acLoanBackLog.setBackRes(lb.getBackRes());
		acLoanBackLog.setFailCaus(failCaus);
		acLoanBackLog.setBackDate(ParmBiz.getBizDt(conn));
		acLoanBackLog.setBackSts(PUBConstant.BACK_STS_06);//�Ѵ���
		acLoanBackLog.setStatus(status);
		acLoanBackLog.setCardChn(cardChn);
		acLoanBackLog.setUpTime(ParmBiz.getOracleUpDate(conn));
		RepayBiz.updateAcLoanBackLog(acLoanBackLog, operaInfo);
//		JdbcDao.update(acLoanBackLog, "back_log_no='"+acLoanBackLog.getBackLogNo()+"' and back_cnt='"+acLoanBackLog.getBackCnt()+"'", "ac_loan_back_log", conn);

		//���·ſ���Ϣ��״̬
		acLoanLog.setUpDate(ParmBiz.getOracleUpDate(conn));
		acLoanLog.setCardChn(cardChn);
		JdbcDao.update(acLoanLog, "loan_log_no='"+acLoanBackLog.getLoanLogNo()+"'", "ac_loan_log", conn);
		
		}catch(SQLException e){
			e.printStackTrace();
		}
		}else if("04".equals(backRes)){//�쳣δ��
			acLoanBackLog.setBackSts(PUBConstant.BACK_STS_05);
			RepayBiz.updateAcLoanBackLog(acLoanBackLog, operaInfo);
//			JdbcDao.update(acLoanBackLog, "back_log_no='"+acLoanBackLog.getBackLogNo()+"' and back_cnt='"+acLoanBackLog.getBackCnt()+"'", "ac_loan_back_log", conn);
		}
		return null;

	}
	
	
	/**
	 *  
	 * @���� DHCC-LIUJ
	 * @���� 2016-6-28
	 * @����	��ȡ�ſ���Ϣ�����ݽ�ݺŲ�ѯ�˻����˻���;Ϊ�ſ��˻��ļ�¼�����ݸü�¼���ɷſ���Ϣ
	 */
	private List<AcLoanLog> getAcLoanLogList(AcLnDue acLnDue , OperaInfo operaInfo) throws AccountingException{
		Connection conn = operaInfo.getConn() ;
		
		//�˻���Ϣ��
		List<LnAcct> lnAcctList = (List<LnAcct>) JdbcDao.query(new LnAcct(), "app_id='"+acLnDue.getAppId()+"'", "ln_acct", operaInfo.getConn());
		
		//��Ŀ�˺ű�
		ProjAcct projAcct = (ProjAcct) JdbcDao.query(new ProjAcct(), "proj_no='"+acLnDue.getProjNo()+"'", "proj_acct", operaInfo.getConn());

		List<AcLoanLog> acLoanLogList = new ArrayList<AcLoanLog>();
		for(int i=0;i<lnAcctList.size();i++){
			AcLoanLog acLoanLog = new AcLoanLog();
			acLoanLog.setTraceNo(operaInfo.getTraceNo());
			acLoanLog.setLoanLogNo(ParmBiz.getAcLoanLogNo(conn));
			acLoanLog.setLoanNo(acLnDue.getDueNo());
			acLoanLog.setPactNo(acLnDue.getPactNo());
			acLoanLog.setBrNo(acLnDue.getBrNo());
			acLoanLog.setLoanAmt(lnAcctList.get(i).getAcAmt());
			acLoanLog.setXtAcNo(projAcct.getAcctNo());//�����˻�
			acLoanLog.setLoanAcNo(lnAcctList.get(i).getAcNo());//�ſ��˺�
			acLoanLog.setLoanAcType(lnAcctList.get(i).getAcType());
			acLoanLog.setLoanAcName(lnAcctList.get(i).getAcName());
			acLoanLog.setLoanBankCode(lnAcctList.get(i).getBankCode());
			acLoanLog.setLoanBankProv(lnAcctList.get(i).getBankProv());
			acLoanLog.setLoanBankCity(lnAcctList.get(i).getBankCity());
			acLoanLog.setLoanBankSite(lnAcctList.get(i).getBankSite());
			acLoanLog.setLoanSts("01");//������
			acLoanLog.setTxDate(operaInfo.getTxDt());
			acLoanLog.setTxTime(ParmBiz.getOracleTxTime(conn));
			acLoanLogList.add(acLoanLog);
		}
		return acLoanLogList;
	}
//	/**
//	 * �õ��Ǽǽ�����ˮ����Ϣ
//	 * @param operaInfo ҵ���������
//	 * @param lnMst �����������
//	 * 
//	 * @return traceLog    �Ǽǽ�����ˮ�����
//	 * @throws AccountingException
//	 */
//	private AcTraceLog getTraceLog(OperaInfo operaInfo,AcLnMst lnMst , AcLoanLog acLoanLog)throws AccountingException {
//		AcTraceLog traceLog = new AcTraceLog();
//		
//		Connection conn = operaInfo.getConn() ;
//
//		traceLog.setTraceNo(operaInfo.getTraceNo());//������ˮ��
//		traceLog.setTraceCnt(1);					//������ˮ�ʴ�
//		traceLog.setTxDt(operaInfo.getTxDt());		//���ý�������
//    	traceLog.setTxTime(ParmBiz.getOracleTxTime(conn)) ;	//���ý���ʱ��
//		traceLog.setTxBrNo(operaInfo.getTxBrNo());	//���ý��׻�����
//		traceLog.setTxCde(TransCode.LNC3);			//���ý��״���
//		traceLog.setSubTxCde(TransCode.LNC3);		//�����ӽ��״���
//		traceLog.setCurNo(lnMst.getCurNo());		//���ñ���
//		traceLog.setPrdtNo(lnMst.getPrdtNo());		//���ò�Ʒ���
//		traceLog.setPactNo(lnMst.getPactNo());
//		traceLog.setBrNo(lnMst.getBrNo());
//		traceLog.setLoanNo(lnMst.getLoanNo());		//���ý�ݺ�
//		traceLog.setAddInd(PUBConstant.INC);		//����������־Ϊ�����ӡ�
//		traceLog.setCtInd(PUBConstant.TRANS);		//������ת��־Ϊ��ת�ˡ�
//		traceLog.setAmt(acLoanLog.getLoanAmt());		//���÷�����
//		traceLog.setCancelInd(PUBConstant.REV_ROL_NORM);// ���ó�����־		
//		traceLog.setMemo("");
//		return traceLog;
//	}
	
	public void getAcTxDetail(){
		
	}

}