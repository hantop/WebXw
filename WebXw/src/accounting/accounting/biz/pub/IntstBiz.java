package accounting.biz.pub;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import accounting.domain.loan.AcFineFormula;
import accounting.domain.loan.AcLnLo;
import accounting.domain.loan.AcLnMst;
import accounting.domain.loan.AcLnPayPln;
import accounting.domain.loan.AcLnRepayPln;
import accounting.domain.loan.AcLnRepayPlnCur;
import accounting.domain.loan.PrdtBase;
import accounting.domain.sys.OperaInfo;
import accounting.interf.loan.IntstDetailDatas;
import accounting.plat.PUBConstant;
import accounting.plat.core.AccountingException;
import accounting.plat.dao.JdbcDao;
import accounting.plat.util.NumberUtil;
import accounting.plat.util.TimeUtil;
import accounting.plat.util.TransUtil;
import app.util.DateUtil;

/**
 * ��Ϣ�����
 * 
 * @project��nxnxnew
 * @className��IntstBiz
 * @author��su
 */
public class IntstBiz {
	

	/**
	 * ����ÿһ�ڵ�Ƿ���ķ�Ϣ
	 * 
	 * @param acLnMst
	 *            �������ļ�
	 * @param acLnLo
	 *            ����Ƿ���
	 * @param txDate
	 *            ��������
	 * @param acLnParm
	 *            ��Ʒ������
	 * @param conn
	 *            ���ݿ�����
	 * @return ���ÿһ��Ƿ�����Ϣ����Ϣ��
	 * @throws Exception 
	 */
	public static IntstDetailDatas calculatePerLoInt(AcLnMst acLnMst, AcLnLo acLnLo, OperaInfo operaInfo) throws Exception {
		IntstDetailDatas datas = new IntstDetailDatas();
//		PrdtBase prdtBase = PUBConstant.PUB_ACCOUNT_PRAM.get(acLnMst.getPrdtNo());
		PrdtBase prdtBase = (PrdtBase) JdbcDao.query(new PrdtBase(), "prdt_no='"+acLnMst.getPrdtNo()+"'", "PRDT_BASE", operaInfo.getConn());

		double normInt = 0; 					// Ƿ������Ϣ
		double prcpAmt = 0; 					// Ƿ���
		double fineInt = 0; 					// ��Ϣ
		
		//�ϴνᷣϢ����
		String begDate = acLnLo.getFineIntDt();
		if(begDate==null || begDate.equals("")){
			begDate = acLnLo.getPayDt() ;
		}

		// ��������
		int days = TimeUtil.getBetweenDays(begDate, operaInfo.getBizDt());
		
		// ����Ƿ��� Ƿ���=ԭ����-�ѻ�����-���Ȿ��
		prcpAmt = NumberUtil.amtSubs(NumberUtil.amtSubs(acLnLo.getPrcpAmt(), acLnLo.getRepayPrcpAmt()), acLnLo.getWvPrcpAmt()) ;
		
		//����������Ϣ��Ƿ������Ϣ=ԭ������Ϣ-�ѻ�������Ϣ-����������Ϣ
		normInt = NumberUtil.amtSubs(NumberUtil.amtSubs(acLnLo.getNormInt(), acLnLo.getRepayNormInt()), acLnLo.getWvNormInt());

		//���㱾�ν�Ϣ�����ķ�Ϣ
		fineInt = calFineInt(acLnLo ,acLnMst.getLoanAmt(),prcpAmt,normInt , days, prdtBase , operaInfo);
		
		//ԭǷ���Ϣ+���ν�Ϣ������ķ�Ϣ = ʵ��Ƿ��Ϣ
		fineInt = NumberUtil.amtAdd(acLnLo.getFineInt(), fineInt);

		datas.setPrcpAmt(prcpAmt); // Ƿ����
		datas.setNormInt(normInt); // Ƿ��Ϣ
		datas.setFineInt(fineInt); // Ƿ��Ϣ
		return datas;
	}

	/**
	 * 
	 * @throws Exception 
	 * @���� DHCC-LIUJ
	 * @���� 2018-4-25
	 * @���� ���㷣Ϣ
	 */
	public static double calFineInt(AcLnLo acLnLo,double loanAmt,double prcpAmt,double normInt, Integer day , PrdtBase prdtBase , OperaInfo operaInfo )throws Exception{
		double fineInt = 0.00;
		String defNo = prdtBase.getDefNo();//��Ϣ���
		
		AcLnMst acLnMst = (AcLnMst) JdbcDao.query(new AcLnMst(), "loan_no='"+acLnLo.getLoanNo()+"'", "AC_LN_MST", operaInfo.getConn());
		
		double lnRate = acLnMst.getLnRate();
		if(defNo != null && defNo.length()>0){
			AcFineFormula acFineFormula = (AcFineFormula)JdbcDao.query(new AcFineFormula(), "fine_id = '"+defNo+"'","ac_fine_formula", operaInfo.getConn());
			
			//��Ƿ���¼
			List<AcLnLo> acLnLoList = (ArrayList)JdbcDao.queryList(new AcLnLo(), "loan_no = '"+acLnLo.getLoanNo()+"' and setl_sts='N'","ac_ln_lo", operaInfo.getConn());
			
			String fineFormula = acFineFormula.getFineFormula();//��ȡ��Ϣ���ù�ʽ
			double overRate = prdtBase.getOverRate();//��ȡ��������
			//����ָ����ʵ��ֵӳ���ϵ
			Map<String,String> parmMp = new HashMap<String, String>();
			parmMp.put("A", String.valueOf(prcpAmt));
			parmMp.put("B", String.valueOf(normInt));
			parmMp.put("C", String.valueOf(day));
//			DecimalFormat nf = new DecimalFormat();  
//			nf.setMaximumFractionDigits(10); // �������С��λ
			DecimalFormat df6 =new java.text.DecimalFormat("0.000000");
			DecimalFormat df =new java.text.DecimalFormat("###.00"); 
			parmMp.put("D", df6.format(overRate));
			parmMp.put("E", df.format(loanAmt));
			parmMp.put("F", String.valueOf(acLnLoList.size()));
			parmMp.put("G", df6.format(lnRate/100/30));//������
			FeeBiz feeBiz = new FeeBiz();
			fineFormula = feeBiz.replaceParms(fineFormula, parmMp);
			
			fineInt = Calc.doCalc(fineFormula).getValue();
		}
		
		return fineInt;
		
	}
	
	/**
	 * ��ǰ���������Ϣ
	 * 
	 * @param acLnMst
	 *            �������ļ�
	 * @param acLnLoList
	 *            ���Ƿ�����Ϣ��list
	 * @param remAmt
	 *            ��ǰ�������
	 * @param conn
	 *            ���ݿ�����
	 * @return datas ��Ϣ��
	 * @throws Exception 
	 */
	public static IntstDetailDatas calculateTtlIntIsMortgage(AcLnMst acLnMst,  double remAmt, PrdtBase prdtBase, OperaInfo operaInfo) throws Exception {
		
		IntstDetailDatas datas = new IntstDetailDatas() ;
		
		double normInt = 0.00; 			// Ƿ������Ϣ
		double prcpAmt = 0.00; 			// Ƿ���
		double fineInt = 0.00; 			// ��Ϣ
		double curInt = 0.00; 			// ������Ϣ
		
		String intDt = operaInfo.getBizDt();	// Ԥ�ƽ�Ϣ�գ���������
		String txDt = operaInfo.getTxDt();		// ��ǰ���ڣ�ϵͳ����
		
		String loanNo = acLnMst.getLoanNo();
		
		//����Ӫҵ��֮��Ļ���ƻ�
		List<AcLnRepayPln> acLnRepayPlnList = JdbcDao.queryList(new AcLnRepayPln(), "loan_no='"+loanNo+"' and pay_dt>='"+txDt+"' and setl_sts='"+PUBConstant.N+"'", "perd_no", "ac_ln_repay_pln", operaInfo.getConn());
		
		
		 
		//����Ƿ����е����ݣ���Ԥ��Ϣ��ʱ��������Ϣ
		//ac_ln_loǷ�������ȡ�����ڵĻ�����Ϣ��Ƿ����ǷϢ����Ϣ
		List<AcLnLo> acLnLoList = JdbcDao.queryList(new AcLnLo(), "loan_no='" + acLnMst.getLoanNo() +"' and setl_sts='N'", "perd_no", "ac_ln_lo", operaInfo.getConn());
		for (int i=0;i<acLnLoList.size();i++){
			AcLnLo acLnLo = (AcLnLo)acLnLoList.get(i) ;

//			IntstDetailDatas detailDatas = calculatePerLoInt(acLnMst, acLnLo, operaInfo);					

			prcpAmt = NumberUtil.amtAdd(prcpAmt, acLnLo.getPrcpAmt()); 
			normInt = NumberUtil.amtAdd(normInt, acLnLo.getNormInt());
			fineInt = NumberUtil.amtAdd(fineInt, acLnLo.getFineInt());
		}

		//���һ�ڻ���ƻ�
		AcLnRepayPln lastPayPln = (AcLnRepayPln)acLnRepayPlnList.get(acLnRepayPlnList.size()-1) ;
		String lastRepayDt = lastPayPln.getPayDt();		//���һ�ڻ���ƻ�������

		//�����ǰӪҵ����>������գ���ֻ�����Ƿ��������ݲ�������Ϣ
		//����������²������㵱����Ϣ
		if(TimeUtil.compareDate(txDt, lastRepayDt)<=0){
			// Ԥ�ƽ�Ϣ�������ڵĻ���ƻ�
			
			AcLnRepayPln acLnRepayPlnPur = getAcLnRepayPln(intDt, acLnRepayPlnList);
			// Ԥ�ƽ�Ϣ�ն�Ӧ�Ļ���ƻ�����
			int perdNoPur = acLnRepayPlnPur.getPerdNo() ;

			// ��ǰ�������ڵĻ���ƻ�
			AcLnRepayPln acLnRepayPlnCur = acLnRepayPlnList.get(0) ;
			int  perdNocur = acLnRepayPlnCur.getPerdNo();

			//����ǰӪҵ����Ԥ��Ϣ�ռ�Ļ����ڵ�����Ƿ����11111111perdNoPur-perdNocur
			for(int i=0;i<perdNoPur-perdNocur;i++){
				
				AcLnLo acLnLoT = new AcLnLo() ;
				TransUtil.copyProperties((AcLnRepayPln)acLnRepayPlnList.get(i), acLnLoT);

//				IntstDetailDatas detailDatas = calculatePerLoInt(acLnMst, acLnLoT, operaInfo);	

				prcpAmt = NumberUtil.amtAdd(prcpAmt, acLnLoT.getPrcpAmt());
				normInt = NumberUtil.amtAdd(normInt, acLnLoT.getNormInt());
				fineInt = NumberUtil.amtAdd(fineInt, acLnLoT.getFineInt());
			}

			curInt = calCurInt(acLnMst, acLnRepayPlnPur, remAmt, operaInfo);
		}
		
		AcLnRepayPlnCur acLnRepayPlnCur = (AcLnRepayPlnCur)JdbcDao.query(new AcLnRepayPlnCur(), "LOAN_NO = '"+acLnMst.getLoanNo()+"'","AC_LN_REPAY_PLN_CUR", operaInfo.getConn());

		double feeAmt = FeeBiz.getDamAmt(acLnRepayPlnCur, acLnMst, operaInfo);
		
		datas.setFeeAmt(feeAmt);		//�ڽɷ�
		datas.setCurInt(curInt); 		// ������Ϣ
		datas.setRemPrcpAmt(remAmt) ;	// ��ǰ�������
		
		datas.setPrcpAmt(prcpAmt);     //Ƿ���
		datas.setNormInt(normInt);    //ǷϢ
		datas.setFineInt(fineInt);    //��Ϣ
		/**Ƿ���úϼ�
		double loFeeAmt = 0.00;//Ƿ��
		String loFeeAmtSql = "select nvl(sum(chrg_amt)-sum(repay_chrg_amt)-sum(wv_chrg_amt),0) as lo_fee_amt from ac_chrg_log where chrg_sts!='3' and loan_no='"+acLnMst.getLoanNo()+"'";
		PreparedStatement loFeeAmtPs = operaInfo.getConn().prepareStatement(loFeeAmtSql);
		ResultSet loFeeAmtRs = loFeeAmtPs.executeQuery();
		while (loFeeAmtRs.next()) {
			loFeeAmt = loFeeAmtRs.getDouble("lo_fee_amt");
		}
		loFeeAmtPs.close();
		loFeeAmtRs.close();
		*/
		datas.setLoFeeAmt(0.0);
		
		
		return datas;
	}


	/**
	 * ���㵱ǰ����Ϣ����ǰ�����Ϣ�ã�
	 * @param acLnMst
	 * @param acLnRepayPlnCur
	 * @param remAmt
	 * @param operaInfo
	 * @return
	 * @throws AccountingException
	 */
	public static double calCurInt(AcLnMst acLnMst,AcLnRepayPln acLnRepayPlnCur,double remAmt, OperaInfo operaInfo)throws AccountingException{

		double curInt = 0.00;
		
		int perdNoCur = acLnRepayPlnCur.getPerdNo();
		String intDt = operaInfo.getBizDt();
		
		// ��Ϣ�������ڵ���һ�ڼ�¼
		AcLnRepayPln perAcLnRepayPln = null;
		if(perdNoCur>1){
			perAcLnRepayPln = (AcLnRepayPln)JdbcDao.query(new AcLnRepayPln(), "loan_no = '"+acLnMst.getLoanNo()+"' and perd_no = "+(perdNoCur-1), "AC_LN_REPAY_PLN", operaInfo.getConn());
		}
		
			
		if (perdNoCur > 1) {
			remAmt = perAcLnRepayPln.getBal();
		} else {
			remAmt = acLnMst.getLoanAmt();
		}
		String begDt = null;
		double bal = 0.00;
		if(perdNoCur>1){
			begDt = perAcLnRepayPln.getPayDt() ;
			bal = perAcLnRepayPln.getBal();
		}else{
			begDt = acLnMst.getOpnDt() ;
			bal = acLnMst.getLoanAmt();
		}

		if (operaInfo.getBizDt().equals(acLnRepayPlnCur.getPayDt())) {
			curInt = acLnRepayPlnCur.getNormInt();
		} else {
//			rateDaly = getDaylyRateByYearly(acLnMst.getCurNo(), acLnMst.getLnRate()*12) ;
			curInt = getInterestByAmtAndDaysAndRate(bal, begDt, intDt, acLnMst.getLnRate()/(30*100));
		}

		return curInt;
			
	}
	
	/**
	 * ͨ�����,����,���ʻ����Ϣ
	 * 
	 * @param amt
	 *            ���
	 * @param date1
	 *            ��ʼ����
	 * @param date2
	 *            ��������
	 * @param rateDaly
	 *            ������
	 * @return interest ��Ϣ
	 * @throws AccountingException
	 */
	public static double getInterestByAmtAndDaysAndRate(double amt, String date1, String date2, double rateDaly)
	throws AccountingException {
		double interest = 0;
		int betwDay = (int)DateUtil.getDaysBetween(date1, date2);
		
		// �����Ϣ
		interest = NumberUtil.amtMult(NumberUtil.amtMult(amt, rateDaly),betwDay);

		return interest;
	}
	/**
	 * ����ָ�����ڵó������ڵĻ���ƻ��еĶ���
	 * @param txDate				ָ��ʱ��    	  
	 * @param acLnTtlPayPlnList		����ƻ���
	 * 
	 * @return  acLnPayPln    		����ƻ�����
	 * @throws AccountingException
	 */
	public static AcLnRepayPln getAcLnRepayPln(String txDate, List acLnRepayPlnList)throws AccountingException{
		int ttlCnt = acLnRepayPlnList.size() ;

		AcLnRepayPln acLnRepayPln = null ;
		for(int i = 0;i<ttlCnt;i++){
			acLnRepayPln = (AcLnRepayPln)acLnRepayPlnList.get(i) ;

			if(TimeUtil.compareDate(acLnRepayPln.getPayDt(), txDate) > 0)
				return acLnRepayPln ;
		}

		return acLnRepayPln;
	}
	
}
