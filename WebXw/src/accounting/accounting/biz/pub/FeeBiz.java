package accounting.biz.pub;

import java.sql.Connection;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import accounting.domain.fee.AcChrgLog;
import accounting.domain.loan.AcFeeFormula;
import accounting.domain.loan.AcFeeParm;
import accounting.domain.loan.AcFeeRate;
import accounting.domain.loan.AcLnDue;
import accounting.domain.loan.AcLnMst;
import accounting.domain.loan.AcLnRepayPlnCur;
import accounting.domain.loan.AcTraceLog;
import accounting.domain.loan.PrdtBase;
import accounting.domain.sys.OperaInfo;
import accounting.plat.PUBConstant;
import accounting.plat.core.AccountingException;
import accounting.plat.dao.JdbcDao;
import accounting.plat.util.NumberUtil;
import app.base.ServiceException;

public class FeeBiz {
	
		
	/**
	 * 
	 * @throws Exception 
	 * @���� DHCC-LIUJ
	 * @���� 2018-4-25
	 * @����	�ſ�ڻ�ȡ���������г���Ϊ�ſ�ķ����
	 */
	public static List<AcChrgLog> getAcChrgLogListFk(int traceCnt,String loanNo, String prdtNo, String txCode, double txAmt, String curNo, String saveInd, OperaInfo operaInfo)throws AccountingException{
		List<AcChrgLog> acChrgLogList = new ArrayList<AcChrgLog>();
		Connection conn = operaInfo.getConn();
		//�����Ϣ
		AcLnDue acLnDue = (AcLnDue)JdbcDao.query(new AcLnDue(), "due_no='"+loanNo+"'", "ln_due", operaInfo.getConn());

		// �����������Ϣ
		PrdtBase prdtBase = PUBConstant.PUB_ACCOUNT_PRAM.get(prdtNo);
		if (prdtBase == null) {
			throw new AccountingException("��ѯ������Ӧ��Ʒ��������Ϣ!");
		}		
		
		String traceNo = operaInfo.getTraceNo();

		//���ñ��
		String feeNo = prdtBase.getFeeNo();
		//���ý��
		double feeAmt = 0.0;
		//�ж���Ʒ��Ϣ���Ƿ����÷��ù�ʽ
		if(feeNo != null && feeNo.length()>0){
			String[] feeNos = feeNo.split("\\@");
			for(int i=0;i < feeNos.length;i++){
				//��������
				AcFeeParm acFeeParm = (AcFeeParm)JdbcDao.query(new AcFeeParm(), "fee_parm_id='"+feeNos[i]+"'", "ac_fee_parm", operaInfo.getConn());
				if(acFeeParm != null && acFeeParm.getFeeFormId()!=null&&acFeeParm.getFeeFormId().length()>=0){
					//�ж����ó���Ϊ�ſ�
					if(txCode.equals(acFeeParm.getFeeScenes())){
						AcFeeFormula acFeeFormula = (AcFeeFormula)JdbcDao.query(new AcFeeFormula(), "fee_form_id='"+acFeeParm.getFeeFormId()+"'", "ac_fee_formula", operaInfo.getConn());
						AcLnRepayPlnCur acLnRepayPlnCur = null;
						feeAmt = getFeeAmt(acLnRepayPlnCur,acFeeFormula, acLnDue.getDueAmt(),acLnDue.getTermMon(), operaInfo);
						if(feeAmt>0){//������ķ���Ѵ�����ʱ�����ӷ�����ϸ
							AcChrgLog acChrgLog = new AcChrgLog();
							acChrgLog.setChrgId(ParmBiz.getAcChrgLogId(conn));
							acChrgLog.setTraceNo(traceNo);
							acChrgLog.setLoanNo(acLnDue.getDueNo());
							acChrgLog.setPactNo(acLnDue.getPactNo());
							acChrgLog.setBrNo(acLnDue.getBrNo());
							acChrgLog.setPerdNo(txCode);
							if(acFeeParm.getFeeMax()!=null){
								//��������ķ��ô��ڷ������õ����ֵ����ȡ�����������ֵ
								if(feeAmt>acFeeParm.getFeeMax()){
									feeAmt = acFeeParm.getFeeMax();
								}
							}
							if(acFeeParm.getFeeMin()!=null){
								//��������ķ���С�ڷ������õ���Сֵ����ȡ����������Сֵ
								if(feeAmt<acFeeParm.getFeeMin()){
									feeAmt = acFeeParm.getFeeMin();
								}
							}
							acChrgLog.setChrgAmt(feeAmt);
							acChrgLog.setFeeParmId(acFeeParm.getFeeFormId());
							acChrgLog.setFeeKind(acFeeParm.getFeeKind());
							acChrgLog.setRepayChrgAmt(0.00);
							acChrgLog.setChrgSts("01");//������
							acChrgLog.setTxDate(operaInfo.getTxDt());
							acChrgLog.setTxTime(ParmBiz.getOracleTxTime(conn));
							acChrgLogList.add(acChrgLog);
						}
					}
				}
			}
		}
		return acChrgLogList;
	}
	
	/**
	 * 
	 * @throws Exception 
	 * @���� DHCC-LIUJ
	 * @���� 2016-6-27
	 * @����	���ݽ����Ϣ�뷣Ϣ��ʽ��Ϣ��ȡ���ý��
	 */
	public static double getFeeAmt(AcLnRepayPlnCur acLnRepayPlnCur,AcFeeFormula acFeeFormula,double amt, Integer termMon,OperaInfo operaInfo) throws AccountingException{
		double feeAmt = 0.0;//���ý��
		//���ù�ʽ
		String feeFormula = acFeeFormula.getFeeFormula();
		//����ָ���Ӧʵ��ֵ
		String parmA = String.valueOf(amt);//��ݽ��
		String parmB = "";//����Ӧ�ձ���
		String parmC = "";//����Ӧ����Ϣ
		if(acLnRepayPlnCur != null){
			parmB = String.valueOf(acLnRepayPlnCur.getPrcpAmt());
			parmC = String.valueOf(acLnRepayPlnCur.getNormInt());
		}
		String parmD = "";//����
		if(acFeeFormula.getFrId()!=null && acFeeFormula.getFrId().length()>0){
			String frId = acFeeFormula.getFrId() ;//���ʱ��
				List<AcFeeRate> acFeeRateList = (ArrayList)JdbcDao.queryList(new AcFeeRate(), "fr_id='"+frId+"' and '" + termMon +"' >= min_mon and max_mon > '" +termMon +"'", "ac_fee_rate", operaInfo.getConn());
				if(acFeeRateList.size()>0){
					parmD = String.valueOf(acFeeRateList.get(0).getFeeRate());
				}
		}
		//����ָ����ʵ��ֵӳ���ϵ
		Map<String,String> parmMp = new HashMap<String, String>();
		parmMp.put("A", parmA);
		parmMp.put("B", parmB);
		parmMp.put("C", parmC);
		parmMp.put("D", parmD);
		String formula = replaceParms(acFeeFormula.getFeeFormula(), parmMp);
		
		try{
			feeAmt = Calc.doCalc(formula).getValue();
		}catch(Exception e){
			throw new AccountingException("��ʽ��" + formula + "�������Ͻ�������");
		}
		
		return feeAmt; 
		
	}
	
	/**
	 * 
	 * @throws Exception 
	 * @���� DHCC-LIUJ
	 * @���� 2016-6-27
	 * @����	���ݽ����Ϣ�뷣Ϣ��ʽ��Ϣ��ȡ���ý��
	 */
	public static double getFeeAmt(String acquRate,AcLnRepayPlnCur acLnRepayPlnCur,AcFeeFormula acFeeFormula,double amt, Integer termMon,OperaInfo operaInfo,double premRate) throws AccountingException{
		double feeAmt = 0.0;//���ý��
		//���ù�ʽ
		String feeFormula = acFeeFormula.getFeeFormula();
		DecimalFormat df = new DecimalFormat("0.00000000");
		//����ָ���Ӧʵ��ֵ
		String parmA = String.valueOf(amt);//��ݽ��
		String parmB = "";//����Ӧ�ձ���
		String parmC = "";//����Ӧ����Ϣ
		if(acLnRepayPlnCur != null){
			parmB = String.valueOf(NumberUtil.amtSubs(NumberUtil.amtSubs(acLnRepayPlnCur.getPrcpAmt(), acLnRepayPlnCur.getRepayPrcpAmt()),acLnRepayPlnCur.getWvPrcpAmt()));
			parmC = String.valueOf(NumberUtil.amtSubs(NumberUtil.amtSubs(acLnRepayPlnCur.getNormInt(),acLnRepayPlnCur.getRepayNormInt()),acLnRepayPlnCur.getWvNormInt()));
		}
		String parmD = "";//����
		//����
		if("1".equals(acquRate)){
			parmD = String.valueOf(df.format(premRate/100));
		}else{
			if(acFeeFormula.getFrId()!=null && acFeeFormula.getFrId().length()>0){
				String frId = acFeeFormula.getFrId().replaceAll("@", "','") ;//���ʱ��
					List<AcFeeRate> acFeeRateList = (ArrayList)JdbcDao.queryList(new AcFeeRate(), "fee_id in ('"+frId+"') and '" + termMon +"' >= min_mon and max_mon > '" +termMon +"'", "ac_fee_rate", operaInfo.getConn());
					if(acFeeRateList.size()>0){
						parmD = String.valueOf(df.format(acFeeRateList.get(0).getFeeRate()));
					}
			}
		}
		
		
		//����ָ����ʵ��ֵӳ���ϵ
		Map<String,String> parmMp = new HashMap<String, String>();
		parmMp.put("A", parmA);
		parmMp.put("B", parmB);
		parmMp.put("C", parmC);
		parmMp.put("D", parmD);
		String formula = replaceParms(acFeeFormula.getFeeFormula(), parmMp);
		
		try{
			feeAmt = Calc.doCalc(formula).getValue();
		}catch(Exception e){
			throw new AccountingException("��ʽ��" + formula + "�������Ͻ�������");
		}
		
		return feeAmt; 
		
	}
	
	
	
	
	/**
	 * 
	 * @���� DHCC-LIUJ
	 * @���� 2016-6-27
	 * @���� ʹ�û���ָ���Ӧֵ�滻�ַ�����ʽ
	 */
	public static String replaceParms(String formula , Map<String,String> parmMp) throws ServiceException{
		for (Map.Entry<String, String> entry : parmMp.entrySet()) {
			formula = formula.replace(entry.getKey(), entry.getValue());
		}
		return formula;
	}
	
	/**
	 * ������Ϣ���ڣ��ۿ��ս�Ϣ����
	 * @throws AccountingException 
	 */
	public static void getAcChrgLogLNAA(AcLnRepayPlnCur acLnRepayPlnCur,AcLnMst acLnMst, OperaInfo operaInfo) throws AccountingException{
		List<AcChrgLog> acChrgLogList = new ArrayList<AcChrgLog>();
		
		Connection conn = operaInfo.getConn();
		//��Ʒ����
		PrdtBase prdtBase = PUBConstant.PUB_ACCOUNT_PRAM.get(acLnMst.getPrdtNo());
		//���ñ��
		String feeNo = prdtBase.getFeeNo();
		//���ý��
		double feeAmt = 0.0;
		//�ж���Ʒ��Ϣ���Ƿ����÷��ù�ʽ
		if(feeNo != null && feeNo.length()>0){
			String[] feeNos = feeNo.split("\\|");
			for(int i=0;i < feeNos.length;i++){
				//��������
				AcFeeParm acFeeParm = (AcFeeParm)JdbcDao.query(new AcFeeParm(), "fee_parm_id='"+feeNos[i]+"'", "ac_fee_parm", operaInfo.getConn());
				if(acFeeParm != null && acFeeParm.getFeeFormId()!=null&&acFeeParm.getFeeFormId().length()>=0){
					//�ж����ó���Ϊ����
					if("LNAA".equals(acFeeParm.getFeeScenes())){
						AcFeeFormula acFeeFormula = (AcFeeFormula)JdbcDao.query(new AcFeeFormula(), "fee_form_id='"+acFeeParm.getFeeFormId()+"'", "ac_fee_formula", operaInfo.getConn());
						feeAmt = getFeeAmt(acLnRepayPlnCur,acFeeFormula, acLnMst.getLoanAmt(),acLnMst.getTermMon(), operaInfo);
						if(feeAmt>0){//������ķ���Ѵ�����ʱ�����ӷ�����ϸ
							AcChrgLog acChrgLog = new AcChrgLog();
							acChrgLog = new AcChrgLog();
							acChrgLog.setChrgId(ParmBiz.getAcChrgLogId(conn));
							acChrgLog.setTraceNo(operaInfo.getTraceNo());
							acChrgLog.setLoanNo(acLnMst.getLoanNo());
							acChrgLog.setPactNo(acLnMst.getPactNo());
							acChrgLog.setBrNo(acLnMst.getBrNo());
							acChrgLog.setPerdNo(acFeeParm.getFeeScenes());
							acChrgLog.setFeeParmId(acFeeParm.getFeeParmId());
							acChrgLog.setFeeKind(acFeeParm.getFeeKind());
							acChrgLog.setChrgAmt(feeAmt);
							acChrgLog.setRepayChrgAmt(0.00);
							acChrgLog.setChrgSts("01");//������
							acChrgLog.setTxDate(operaInfo.getTxDt());
							acChrgLog.setTxTime(ParmBiz.getOracleTxTime(conn));
							acChrgLogList.add(acChrgLog);
						}
					}
				}
			}
		}
		if(acChrgLogList.size()>0){
			JdbcDao.insertList(acChrgLogList, "ac_chrg_log", conn);
			// ����������ˮ���¼
			AcTraceLog log = new AcTraceLog();
			log.setTxBrNo(operaInfo.getTxBrNo());
			LoanBiz.insertLog(log, acLnMst, operaInfo, "LNAA", "LNAA", PUBConstant.INC);
		}
	}
	
	/**
	 * ��ǰ�����������
	 * @throws AccountingException 
	 */
	public static double getDamAmt(AcLnRepayPlnCur acLnRepayPlnCur,AcLnMst acLnMst, OperaInfo operaInfo) throws AccountingException{
		
		//��Ʒ����
		//PrdtBase prdtBase = PUBConstant.PUB_ACCOUNT_PRAM.get(acLnMst.getPrdtNo());
		PrdtBase prdtBase = (PrdtBase)JdbcDao.query(new PrdtBase(), "prdt_no='"+acLnMst.getPrdtNo()+"'", "prdt_base", operaInfo.getConn());
		//���ñ��
		String feeNo = prdtBase.getFeeNo();
		//���ý��
		double feeAmt = 0.0;
		//�ж���Ʒ��Ϣ���Ƿ����÷��ù�ʽ
		if(feeNo != null && feeNo.length()>0){
			String[] feeNos = feeNo.split("\\@");
			for(int i=0;i < feeNos.length;i++){
				//��������
				AcFeeParm acFeeParm = (AcFeeParm)JdbcDao.query(new AcFeeParm(), "fee_parm_id='"+feeNos[i]+"'", "ac_fee_parm", operaInfo.getConn());
				if(acFeeParm != null && acFeeParm.getFeeFormId()!=null&&acFeeParm.getFeeFormId().length()>=0){
					//�ж����ó���Ϊ����
					if("LNAA".equals(acFeeParm.getFeeScenes())){
						AcFeeFormula acFeeFormula = (AcFeeFormula)JdbcDao.query(new AcFeeFormula(), "fee_form_id='"+acFeeParm.getFeeFormId()+"'", "ac_fee_formula", operaInfo.getConn());
						feeAmt = feeAmt+getFeeAmt(acLnRepayPlnCur,acFeeFormula, acLnMst.getLoanAmt(),acLnMst.getTermMon(), operaInfo);
					}
				}
			}
		}
		return feeAmt;
	}
	
	/**
	 * ��ǰ�������ɷ���
	 * @param acLnRepayPlnCur
	 * @param acLnMst
	 * @param conn
	 * @param method ��ǰ���������ȡ��ʽ 01 ȫ�� 02 �������� 03 �޷���
	 * @param days ����
	 * @return
	 * @throws AccountingException
	 */
	 
	public static List<AcChrgLog> getDamFeeAmt(AcLnRepayPlnCur acLnRepayPlnCur,app.creditapp.acc.loan.entity.AcLnMst acLnMst, Connection conn,String method,int days,String traceNo) throws AccountingException{
		List<AcChrgLog> acChrgLogList = new ArrayList<AcChrgLog>();
		OperaInfo operaInfo = new OperaInfo(conn);
		operaInfo.setTraceNo(traceNo);
		//��Ʒ����
		PrdtBase prdtBase = (PrdtBase)JdbcDao.query(new PrdtBase(), "prdt_no='"+acLnMst.getPrdtNo()+"'", "prdt_base", conn);
		//���ñ��
		String feeNo = prdtBase.getFeeNo();
		//���ý��
		double feeAmt = 0.0;
		double rate = 0;//������ȡ����
		if("01".equals(method)){
			rate = 1;
		}else if("02".equals(method)){
			rate = NumberUtil.div(days, 30, 2);
		}
		//�ж���Ʒ��Ϣ���Ƿ����÷��ù�ʽ
		if(feeNo != null && feeNo.length()>0){
			String[] feeNos = feeNo.split("\\@");
			for(int i=0;i < feeNos.length;i++){
				//��������
				AcFeeParm acFeeParm = (AcFeeParm)JdbcDao.query(new AcFeeParm(), "fee_parm_id='"+feeNos[i]+"'", "ac_fee_parm", conn);
				if(acFeeParm != null && acFeeParm.getFeeFormId()!=null&&acFeeParm.getFeeFormId().length()>=0){
					//�ж����ó���Ϊ����
					if("LNAA".equals(acFeeParm.getFeeScenes())){
						AcFeeFormula acFeeFormula = (AcFeeFormula)JdbcDao.query(new AcFeeFormula(), "fee_form_id='"+acFeeParm.getFeeFormId()+"'", "ac_fee_formula", operaInfo.getConn());
						feeAmt = getFeeAmt(acFeeParm.getAcquRate(),acLnRepayPlnCur,acFeeFormula, acLnMst.getLoanAmt(),acLnMst.getTermMon(), operaInfo,acLnMst.getPremRate());
					
						feeAmt = NumberUtil.amtMult(feeAmt, rate);
						if(NumberUtil.isAmtGreatThanZero(feeAmt)){//������ķ���Ѵ�����ʱ�����ӷ�����ϸ
							if(acFeeParm.getFeeMax()!=null){
								//��������ķ��ô��ڷ������õ����ֵ����ȡ�����������ֵ
								if(feeAmt>acFeeParm.getFeeMax()){
									feeAmt = acFeeParm.getFeeMax();
								}
							}
							if(acFeeParm.getFeeMin()!=null){
								//��������ķ���С�ڷ������õ���Сֵ����ȡ����������Сֵ
								if(feeAmt<acFeeParm.getFeeMin()){
									feeAmt = acFeeParm.getFeeMin();
								}
							}
							AcChrgLog acChrgLog = new AcChrgLog();
							acChrgLog = new AcChrgLog();
							acChrgLog.setChrgId(ParmBiz.getAcChrgLogId(conn));
							acChrgLog.setTraceNo(operaInfo.getTraceNo());
							acChrgLog.setLoanNo(acLnMst.getLoanNo());
							acChrgLog.setPactNo(acLnMst.getPactNo());
							acChrgLog.setBrNo(acLnMst.getBrNo());
							acChrgLog.setPerdNo(String.valueOf(acLnRepayPlnCur.getPerdNo()));
							acChrgLog.setFeeParmId(acFeeParm.getFeeParmId());
							acChrgLog.setFeeKind(acFeeParm.getFeeKind());
							acChrgLog.setChrgAmt(feeAmt);
							acChrgLog.setRepayChrgAmt(0.00);
							acChrgLog.setChrgSts("01");//������
							acChrgLog.setTxDate(ParmBiz.getBizDt(conn));
							acChrgLog.setTxTime(ParmBiz.getOracleTxTime(conn));
							acChrgLog.setFeeType(acFeeParm.getRateType());
							acChrgLogList.add(acChrgLog);
					
						}
					}
				}
			}
		
		}
			return acChrgLogList;
		}
	
}
	

