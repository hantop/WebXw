package accounting.biz.pub;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import accounting.biz.loan.RepayLoMortgageBiz;
import accounting.domain.biz.AcComHoliday;
import accounting.domain.biz.AcReplanFormula;
import accounting.domain.biz.AcReplanParm;
import accounting.domain.biz.AcReplanSec;
import accounting.domain.loan.AcLnLo;
import accounting.domain.loan.AcLnMst;
import accounting.domain.loan.AcLnRepayPln;
import accounting.domain.loan.AcLnRepayPlnCur;
import accounting.domain.loan.AcLnRepayPlnHst;
import accounting.domain.loan.PrdtBase;
import accounting.domain.sys.OperaInfo;
import accounting.plat.PUBConstant;
import accounting.plat.core.AccountingException;
import accounting.plat.dao.JdbcDao;
import accounting.plat.util.NumberUtil;
import accounting.plat.util.TimeUtil;
import app.base.ServiceException;
import app.creditapp.acc.option.entity.AcLnSetlmtLog;
import app.util.DateUtil;

public class AcLnRepayPlnBiz {
	
	/**
	 * 
	 * @throws Exception 
	 * @���� su
	 * @���� 2018-4-25
	 * @����	�ſ������A������������ɻ���ƻ�
	 */
public static List<AcLnRepayPln> getAcLnRepayPln(AcLnMst acLnMst,PrdtBase prdtBase,OperaInfo operaInfo)throws AccountingException{
	List<AcLnRepayPln> acLnRepayPlnList = new ArrayList<AcLnRepayPln>();
	List<AcReplanSec> acReplanSecList = new ArrayList<AcReplanSec>();
	
	DecimalFormat df =new java.text.DecimalFormat("###.00"); 
	
	DecimalFormat df6 =new java.text.DecimalFormat("###.000000"); 

	DecimalFormat nf6 =new java.text.DecimalFormat("0.00000000");

	String opnDt = acLnMst.getOpnDt();//�ſ���
	String mtrDt = acLnMst.getMtrDt();//������
	String lstIntDt = acLnMst.getRepayDay();//������
	if(lstIntDt==null || lstIntDt.length()==0){
		lstIntDt = opnDt.substring(6,8);
	}
	if(lstIntDt.length()==1){
		lstIntDt = 0+lstIntDt;
	}
	String upPayDt = acLnMst.getLstDt();// ���ڻ�����
	if(upPayDt == "" || "".equals(upPayDt)){
		upPayDt = opnDt;
	}
	//��ʽ��������
	String parmA = df.format(acLnMst.getLoanAmt());//�����
	String parmC = "";//��������
	String parmE ;//����Ƶ��
	String parmF = "";//����ʣ�౾��
	String parmG = "";//�����ڴ�
	String parmH = "";//���α������
	int parmJ = 0;//����������
	int sumPerdNo = 0;//������
	String parmK = "";//����������

	try {
		String replanId = prdtBase.getRepayNo();// ������ţ������в�Ʒ���Ӳ�Ʒ��ȡ
		AcReplanParm acReplanParm = (AcReplanParm)JdbcDao.query(new AcReplanParm(), "replan_id='"+replanId+"'", "ac_replan_parm", operaInfo.getConn());

		AcReplanSec acReplanSec = new AcReplanSec();
		acReplanSec.setReplanId(replanId);
		acReplanSecList = (ArrayList)JdbcDao.queryList(new AcReplanSec(), "replan_id='"+replanId+"'", "ac_replan_sec", operaInfo.getConn());

		if("3".equals(acReplanParm.getExtendNext())&&Integer.valueOf(acLnMst.getOpnDt().substring(6, 8))>Integer.valueOf(acLnMst.getRepayDay())){
			acLnMst.setLoanTerm(acLnMst.getLoanTerm()+1);
		}
		if ("4".equals(acReplanParm.getExtendNext())&&Integer.valueOf(acLnMst.getOpnDt().substring(6, 8))!=Integer.valueOf(acLnMst.getRepayDay())){
			acLnMst.setLoanTerm(acLnMst.getLoanTerm()+1);
		}
		int i = 0;// �ڴ�--�ڼ���
		if (acReplanSecList.size() > 0) {// ����ÿһ�λ���ƻ�
			for (AcReplanSec ars : acReplanSecList) {
				String extendNext = acReplanParm.getExtendNext();// ������е����ڲ������� �ڳ�/��ĩ
				String extendDate = "";
				if("3".equals(extendNext)||"4".equals(extendNext)){
					extendDate = opnDt;
				}else{
					extendDate = getExtendDate(opnDt,lstIntDt);
				}
				
		
				String parmB = String.valueOf(acLnMst.getLoanTerm());// ������
				parmC = acReplanParm.getTermType();
//				DecimalFormat nf = new DecimalFormat();  
//				nf.setMaximumFractionDigits(10); // �������С��λ
				
				String parmD = String.valueOf(nf6.format(acLnMst.getLnRate()));// ����������  
				String parmL = String.valueOf(nf6.format(acLnMst.getLnRateYear()));// ����������
				
				parmE = String.valueOf(acReplanParm.getFrequency());
				parmH = String.valueOf(ars.getCapitalRate());

				String begRepayNo = ars.getBegRepayNo();// ������ʼ�ڴ�
				String endRepayNo = ars.getEndRepayNo();// ���ε������

				AcReplanFormula acReplanFormula = (AcReplanFormula)JdbcDao.query(new AcReplanFormula(), "Formula_id='"+ars.getFormulaId()+"'", "ac_replan_formula", operaInfo.getConn());

				if (acReplanFormula != null) {
					String payCap = acReplanFormula.getPayCap();// Ӧ�ձ���ʽ
					String payInte = acReplanFormula.getPayInte();// Ӧ����Ϣ
					if ("1".equals(parmC)) {// ��������Ϊ��
						sumPerdNo = (int) Math.ceil((DateUtil.getDaysBetween(
								acLnMst.getOpnDt(), mtrDt)) / 1.00 / acReplanParm.getFrequency());// ���ռ�Ϣ��������������ʼ����-����������Ϊ�����ޣ�������/����Ƶ�ʼ�Ϊ������
						parmC = "1";
						parmD = parmD + "/30";// ��������Ϊ���գ��������ʸ�Ϊ������
						parmL = parmL + "/365";// ��������Ϊ���գ��������ʸ�Ϊ������
						parmB = String.valueOf(DateUtil.getDaysBetween(
								acLnMst.getOpnDt(), mtrDt));
					} else if ("2".equals(parmC)) {// ��������Ϊ��
						sumPerdNo = acLnMst.getLoanTerm() / acReplanParm.getFrequency();
						//�ж������ڶ��ڻ������Ƿ���ڴ������,�����ڵ����գ���������-1
						if(TimeUtil.checkDate1BeforeDate2(acLnMst.getMtrDt(),DateUtil.getDateStr(extendDate,sumPerdNo-1))){
							sumPerdNo = sumPerdNo-1;
						}
						parmC = "1";
					} else if ("3".equals(parmC)) {// ��������Ϊ��
						sumPerdNo = acLnMst.getLoanTerm() / 3 / acReplanParm.getFrequency();
						//�ж������ڶ��ڻ������Ƿ���ڴ������,�����ڵ����գ���������-1
						if(TimeUtil.checkDate1BeforeDate2(acLnMst.getMtrDt(),DateUtil.getDateStr(extendDate,3*sumPerdNo-1))){
							sumPerdNo = sumPerdNo-1;
						}
						parmC = "3";
					} else if ("4".equals(parmC)) {// ��������Ϊ����
						sumPerdNo = acLnMst.getLoanTerm() / 6 / acReplanParm.getFrequency();
						//�ж������ڶ��ڻ������Ƿ���ڴ������,�����ڵ����գ���������-1
						if(TimeUtil.checkDate1BeforeDate2(acLnMst.getMtrDt(),DateUtil.getDateStr(extendDate,6*sumPerdNo-1))){
							sumPerdNo = sumPerdNo-1;
						}
						parmC = "6";
					} else if ("5".equals(parmC)) {// ��������Ϊ��
						sumPerdNo = acLnMst.getLoanTerm() / 12 / acReplanParm.getFrequency();
						//�ж������ڶ��ڻ������Ƿ���ڴ������,�����ڵ����գ���������-1
						if(TimeUtil.checkDate1BeforeDate2(acLnMst.getMtrDt(),DateUtil.getDateStr(extendDate,12*sumPerdNo-1))){
							sumPerdNo = sumPerdNo-1;
						}
						parmC = "12";
					}else if ("6".equals(parmC)) {// ��������Ϊһ����
						sumPerdNo = 1;
						parmC = "1";
					}
					
					if("1".equals(acReplanParm.getIfLoanInt())){//�Ƿ�ſ��տ�Ϣ����ѡ�ǣ�����ƻ�������+1
						sumPerdNo += 1;
					}
					parmK = String.valueOf(sumPerdNo);
					begRepayNo = String.valueOf((int)Math.ceil(Calc.doCalc(begRepayNo.replaceAll("n", String
							.valueOf(sumPerdNo))).getValue()));
					endRepayNo = String.valueOf((int)Math.ceil(Calc.doCalc(endRepayNo.replaceAll("n", String
							.valueOf(sumPerdNo))).getValue()));
					i = Integer.parseInt(begRepayNo);
					parmJ = Integer.parseInt(endRepayNo) - Integer.parseInt(begRepayNo) + 1;
					if(0==(acLnRepayPlnList.size())){//�ж���������ʼΪ��һ�ڣ���ӵ�0�ڿ�ʼ
						i=0;
					}
					//���β��ǵ�һ�ڣ��ұ�����ʼ�ڴ�С�ڵ���ǰ������ڴΣ����������ų��ظ��ڴ� ��������������Ϊ1�ڣ�����ƻ������Σ������ظ��ڴΣ�
					if(i!=0 && i <= acLnRepayPlnList.size()-1) continue;
					for (; i <= Integer.parseInt(endRepayNo); i++) {// ����ÿ�ڻ���ƻ�
						AcLnRepayPln acLnRepayPln = new AcLnRepayPln();
						if(0==i){
							parmG = String.valueOf(i - Integer.parseInt(begRepayNo) + 1);// ���㱾���ڴ�
							acLnRepayPln.setBal(acLnMst.getLoanAmt());
							acLnRepayPln.setInstmAmt(0.00);
							acLnRepayPln.setLoanNo(acLnMst.getLoanNo());
							acLnRepayPln.setNormInt(0.00);
							acLnRepayPln.setPayDt(DateUtil.getDateStr(upPayDt, i));
							acLnRepayPln.setPerdNo(i);
							acLnRepayPln.setPrcpAmt(0.00);
							acLnRepayPln.setLnRate(acLnMst.getLnRate());
							acLnRepayPlnList.add(acLnRepayPln);
						} else {
							parmG = String.valueOf(i - Integer.parseInt(begRepayNo) + 1);// ���㱾���ڴ�
							double normInt = 0.00;// ����Ӧ����Ϣ
							double prcpAmt = 0.00;// ����Ӧ�ձ���
							String payDt = "";// ���ڻ�����
							AcLnRepayPln lstAcLnRepayPln = new AcLnRepayPln();
							for (AcLnRepayPln alrp : acLnRepayPlnList) {
								if ((i - 1) == alrp.getPerdNo()) {
									lstAcLnRepayPln = alrp;
									parmF = df.format(alrp.getBal());
									upPayDt = alrp.getPayDt();
								}
							}
							double normIntExtend = acLnMst.getLoanAmt() * acLnMst.getLnRate()/100
									/ 30 * DateUtil.getDaysBetween(opnDt,extendDate);

							if("1".equals(acReplanParm.getIfLoanInt())){//�ſ��տ�Ϣ����һ�ڷſ���
								if(1!=i){
									if ("1".equals(acReplanParm.getTermType())) {// ��������Ϊ���գ����ڻ�����Ϊ���ڻ�����+����Ƶ��
										payDt = DateUtil.addByDay(
												opnDt, (i-1) * Integer.parseInt(parmE));
									}else{
										payDt = DateUtil.getDateStr(
												extendDate, (i-1) * Integer.parseInt(parmE)*Integer.parseInt(parmC));
									}
								}else{
									payDt=extendDate;
								}
							}else{
								if ("1".equals(acReplanParm.getTermType())) {// ��������Ϊ���գ����ڻ�����Ϊ���ڻ�����+����Ƶ��
									payDt = DateUtil.addByDay(upPayDt, Integer.parseInt(parmE));
								}else{
									payDt = DateUtil.getDateStr(upPayDt, Integer.parseInt(parmE)*Integer.parseInt(parmC)).substring(0, 6)+lstIntDt;
									if (i == 1 && "4".equals(extendNext)&&Integer.valueOf(acLnMst.getOpnDt().substring(6, 8))<Integer.valueOf(acLnMst.getRepayDay())) {
										payDt = DateUtil.addBMonth(payDt);
									}
									while(!DateUtil.isDateStr(payDt)){
										payDt = String.valueOf(Integer.parseInt(payDt)- 1);
									}
									if(!DateUtil.isBefore(opnDt, payDt)){
										payDt = DateUtil.getDateStr(upPayDt, Integer.parseInt(parmE)*Integer.parseInt(parmC)).substring(0, 6)+lstIntDt;
									}
								}
							}
							//�ж��˵����Ƿ���Ч������Ч�����һ�����ж�
							while(!DateUtil.isDateStr(payDt)){
								payDt = String.valueOf(Integer.parseInt(payDt)- 1);
							}
							//�жϽڼ����Ƿ�˳��
							if("1".equals(acReplanParm.getHolidIfExt())){
								payDt = closeHoliday(payDt,operaInfo);//�ж������Ƿ�Ϊ�ڼ��գ��������ȡ�ڼ��պ�ĵ�һ��������
							}
							//��ȡ�����뱾�ڼ��������
							if (i == sumPerdNo) {// ���һ����ϢӦ�����¼���
								payDt = mtrDt;
							}
							String parmI = String.valueOf(DateUtil.getDaysBetween(upPayDt, payDt));
							//�ò���ֵ�滻��ʽָ��
							String payCap1 = replaceParms(payCap, parmA, parmB, parmC, parmD, parmE,
									parmF, parmG, parmH, parmI, String.valueOf(parmJ),parmK,parmL);
							String payInte1 = replaceParms(payInte, parmA, parmB, parmC, parmD, parmE,
									parmF, parmG, parmH, parmI, String.valueOf(parmJ),parmK,parmL);
							normInt = Calc.doCalc(payInte1).getValue();// ͨ����ʽ�ó��ı���Ӧ����Ϣ
							normInt = NumberUtil.getDouble(normInt, 2);
							prcpAmt = Calc.doCalc(payCap1).getValue();// ͨ����ʽ�ó��ı���Ӧ�ձ���
							prcpAmt = NumberUtil.getDouble(prcpAmt, 2);
							if(1==i&&"1".equals(acReplanParm.getIfLoanInt())){//��Ϊ��һ�ڣ��ҷ���ѡ��ſ��տۿ�
								payDt = opnDt;
							}
//							if (i == 1 && "1".equals(extendNext)) {// ��һ����Ϣ����ݷ����趨���ڳ�/��ĩ���������Ϣͳ�����ڳ�������ĩ
//								normInt += normIntExtend;
//							}
							
							for (AcLnRepayPln alrp : acLnRepayPlnList) {
								if ((i - 1) == alrp.getPerdNo()) {
									Double bal = Double.parseDouble(df6.format(alrp.getBal() - prcpAmt));// ʣ�౾��
									acLnRepayPln.setBal(ParmBiz.parseAmt(bal,acReplanParm.getIntUnit(),acReplanParm.getIntType()));
								}
							}
							
							acLnRepayPln.setPayDt(payDt);
							acLnRepayPln.setLoanNo(acLnMst.getLoanNo());
							acLnRepayPln.setPactNo(acLnMst.getPactNo());
							acLnRepayPln.setBrNo(acLnMst.getBrNo());
							acLnRepayPln.setNormInt(ParmBiz.parseAmt(normInt,acReplanParm.getIntUnit(),acReplanParm.getIntType()));
							acLnRepayPln.setPerdNo(i);
							acLnRepayPln.setPrcpAmt(ParmBiz.parseAmt(prcpAmt,acReplanParm.getIntUnit(),acReplanParm.getIntType()));
							acLnRepayPln.setInstmAmt(ParmBiz.parseAmt(normInt + prcpAmt,acReplanParm.getIntUnit(),acReplanParm.getIntType()));
							acLnRepayPln.setFineInt(0.00);
							acLnRepayPln.setRepayPrcpAmt(0.00);
							acLnRepayPln.setRepayNormInt(0.00);
							acLnRepayPln.setRepayFineInt(0.00);
							acLnRepayPln.setOverRate(0.00);
							acLnRepayPln.setWvPrcpAmt(0.00);
							acLnRepayPln.setWvNormInt(0.00);
							acLnRepayPln.setWvFineInt(0.00);
							acLnRepayPln.setLnRate(acLnMst.getLnRate());
							acLnRepayPln.setIntSts(PUBConstant.INT_STS_10);//��Ϣ״̬������
							acLnRepayPln.setPrcpSts(PUBConstant.INT_STS_10);//����״̬������
							acLnRepayPln.setSetlSts(PUBConstant.SETL_STS_N);//����״̬��δ����
							acLnRepayPlnList.add(acLnRepayPln);
						}
					}
				}else{
					throw new ServiceException("�û�����д���δ���û���ƻ���ʽ�ķֶ���Ϣ��");
				}
			}
		}else{
			throw new ServiceException("�û���������޷ֶ���Ϣ��");
		}
	} catch (Exception e) {
		throw new ServiceException(e.getMessage());
	}
	
	//��ʣ�౾���������������λС��
	if(acLnRepayPlnList.size()>0){
		acLnRepayPlnList.remove(0);
		for(AcLnRepayPln arp : acLnRepayPlnList){
			if(Double.parseDouble(df.format(arp.getBal()))==0){
				arp.setBal(0.00);
			}else{
				arp.setBal(Double.parseDouble(df.format(arp.getBal())));

			}
		}
	}
	return acLnRepayPlnList;
	}


//������ʼ�������Ϣ�գ���ȡ���ڲ���Ľ�Ϣ�գ���20150405�ſ� ��Ϣ��Ϊ10�ţ���õ�����Ϊ20150410�� ����Ϣ��Ϊ01�ţ���õ�����Ϊ20150501
	public static String getExtendDate(String date ,String lstIntDt )throws ServiceException{
		String lstDate = date.substring(6,8);
		String nextDate = DateUtil.getDateStr(date,1);
		if(Integer.parseInt(lstDate)>Integer.parseInt(lstIntDt)){
			date = nextDate.substring(0,6)+lstIntDt;
		}else{
			date = date.substring(0,6)+lstIntDt;
		}
		while(!DateUtil.isDateStr(date)){
			date = DateUtil.addByDay(date, -1);
		}
		return date ;
	}
	
	
	/**
	 * 
	 * @throws AccountingException 
	 * @���� DHCC-LIUJ
	 * @���� 2016-7-20
	 * @����	��ǰ����ȷ�ϣ���Ҫ���л���ƻ����
	 */
	public static void aftAdvpayChangeRepln(AcLnSetlmtLog acLnSetlmtLog,OperaInfo operaInfo) throws AccountingException{
		//�������ļ�
		AcLnMst acLnMst = (AcLnMst)JdbcDao.query(new AcLnMst(), "loan_no='"+acLnSetlmtLog.getLoanNo()+"'", "ac_ln_mst", operaInfo.getConn());
		//���ڻ���ƻ�
		AcLnRepayPlnCur acLnRepayPlnCur = (AcLnRepayPlnCur)JdbcDao.query(new AcLnRepayPlnCur(), "loan_no='"+acLnSetlmtLog.getLoanNo()+"'", "ac_ln_repay_pln_cur", operaInfo.getConn());
		String endDt = acLnRepayPlnCur.getEndDt();
		AcLnRepayPln acLnRepayPlnur = (AcLnRepayPln)JdbcDao.query(new AcLnRepayPln(), "loan_no='"+acLnSetlmtLog.getLoanNo()+"' and perd_no='"+acLnRepayPlnCur.getPerdNo()+"'", "ac_ln_repay_pln", operaInfo.getConn());
		//���ڻ���ƻ�--���ڻ�ȡ���ڻ���ƻ�ʣ�౾��
		AcLnRepayPln lstAcLnRepayPln = (AcLnRepayPln)JdbcDao.query(new AcLnRepayPln(), "loan_no='"+acLnSetlmtLog.getLoanNo()+"' and perd_no='"+String.valueOf(acLnRepayPlnCur.getPerdNo()-1)+"'", "ac_ln_repay_pln", operaInfo.getConn());
		//��ȡ��Ʒ��Ϣ
//		PrdtBase prdtBase = PUBConstant.PUB_ACCOUNT_PRAM.get(acLnMst.getPrdtNo());
		PrdtBase prdtBase = (PrdtBase) JdbcDao.query(new PrdtBase(), "prdt_no='"+acLnMst.getPrdtNo()+"'", "PRDT_BASE", operaInfo.getConn());
		
		List<AcLnRepayPln> newAcPlnList = new ArrayList<AcLnRepayPln>();
		
		AcLnRepayPln wvAcLnRepayPln = RepayLoMortgageBiz.getWvAcLnRepayPln(acLnSetlmtLog.getLoanNo(), operaInfo.getConn(), acLnRepayPlnCur.getPerdNo());
		
		AcLnLo sumAcLnLo = RepayLoMortgageBiz.getSumAmt(acLnMst.getLoanNo(), operaInfo.getConn());//�����ݱ���ͬһ��ͬ���µ�Ƿ������Ϣ
		
		// �ܵ�Ƿ�����
		double sumLoPrcpAmt = NumberUtil.amtSubs(NumberUtil.amtSubs(
				sumAcLnLo.getPrcpAmt(), sumAcLnLo.getRepayPrcpAmt()),
				sumAcLnLo.getWvPrcpAmt());

		//���ڻ���ƻ�ʣ�౾��
		double lstBal = acLnMst.getLoanAmt();
		if(lstAcLnRepayPln !=null){
			lstBal = lstAcLnRepayPln.getBal();
		}
		
		//�޸ĵ��ڻ���ƻ�
		double normInt = NumberUtil.isAmtGreatAndEqual(acLnSetlmtLog.getCurInt(), acLnRepayPlnur.getNormInt())?acLnSetlmtLog.getCurInt():acLnRepayPlnur.getNormInt();
		acLnRepayPlnur.setNormInt(NumberUtil.amtSubs(normInt,acLnRepayPlnur.getRepayNormInt()));//���������Ϣ
		acLnRepayPlnur.setPayDt(acLnSetlmtLog.getRecvDt());//���������
		acLnRepayPlnur.setPrcpAmt(lstBal);//��ǰ�������
				
		acLnRepayPlnur.setInstmAmt(NumberUtil.amtAdd(acLnRepayPlnur.getNormInt(), acLnRepayPlnur.getPrcpAmt()));
		acLnRepayPlnur.setBal(NumberUtil.amtAdd(NumberUtil.amtSubs(NumberUtil.amtSubs(NumberUtil.amtSubs(lstBal-acLnSetlmtLog.getRemPrcpAmt(), acLnRepayPlnur.getRepayPrcpAmt()),acLnRepayPlnur.getWvPrcpAmt()),wvAcLnRepayPln.getWvPrcpAmt()), sumLoPrcpAmt));//ʣ�౾��lstBal-acLnSetlmtLog.getRemPrcpAmt()
				
		acLnRepayPlnCur.setNormInt(acLnRepayPlnur.getNormInt());
		acLnRepayPlnCur.setPrcpAmt(acLnRepayPlnur.getPrcpAmt());
		acLnRepayPlnCur.setTtlAmt(acLnRepayPlnur.getInstmAmt());
		acLnRepayPlnCur.setPayDt(acLnSetlmtLog.getRecvDt());
		acLnRepayPlnCur.setEndDt(DateUtil.addByDay(acLnSetlmtLog.getRecvDt(), acLnMst.getGraceDay()));
		
		//��ʣ�౾��Ϊ0����˵������Ҫ�����µĺ�������ƻ�
		if(NumberUtil.isAmtGreatThanZero(acLnRepayPlnur.getBal())){
			acLnMst.setLoanAmt(NumberUtil.amtAdd(acLnRepayPlnur.getBal(), wvAcLnRepayPln.getWvPrcpAmt()));
			if("02".equals(acLnSetlmtLog.getRepayType())){//������--����ĵ�����
				acLnMst.setMtrDt(acLnSetlmtLog.getEndDate());
			}
			if(DateUtil.compareDate(DateUtil.changeToShow(endDt), DateUtil.changeToShow(acLnSetlmtLog.getRecvDt()))==0){
				acLnSetlmtLog.setRecvDt(DateUtil.addByDay(acLnSetlmtLog.getRecvDt(), 1));
			}
			
			//���¼������ڴ������ޣ����������»���ƻ�
			long[] terms = DateUtil.getMonthsAndDays(acLnSetlmtLog.getRecvDt(), acLnMst.getMtrDt());
			//���¼������ڴ������ޣ����������»���ƻ�acLnSetlmtLog.getRecvDt()
//			long[] terms = DateUtil.getMonthsAndDays(acLnSetlmtLog.getRecvDt().substring(0,6)+acLnMst.getOpnDt().substring(6,8), acLnMst.getMtrDt());
	
			int month = (int) terms[0];
			if(terms[1]>0){
				month += 1;
			}
			acLnMst.setLoanTerm(month);
//			acLnMst.setOpnDt(acLnSetlmtLog.getRecvDt());
			List<AcLnRepayPln> acLnRepayPlnList = getAcLnRepayPln(acLnMst, prdtBase, operaInfo);
			
			acLnRepayPlnur.setPrcpAmt(acLnSetlmtLog.getRemPrcpAmt());//��ǰ�������
			acLnRepayPlnur.setInstmAmt(NumberUtil.amtAdd(acLnRepayPlnur.getNormInt(), acLnRepayPlnur.getPrcpAmt()));
			
			acLnRepayPlnCur.setPrcpAmt(acLnRepayPlnur.getPrcpAmt());
			acLnRepayPlnCur.setTtlAmt(acLnRepayPlnur.getInstmAmt());
			
			newAcPlnList.add(acLnRepayPlnur);
			//�»���ƻ�Ӧ�ӵ��ڿ�ʼ�����仯
			for(AcLnRepayPln alrp : acLnRepayPlnList){
				//�����ɵĻ���ƻ��ڴδ�1��ʼ��ʵ��Ӧ����ԭ����ƻ����һ������
				alrp.setPerdNo(alrp.getPerdNo()+acLnRepayPlnur.getPerdNo());
				if(alrp.getPerdNo()==(acLnRepayPlnur.getPerdNo()+1)){
					alrp.setWvPrcpAmt(wvAcLnRepayPln.getWvPrcpAmt());
				}
				newAcPlnList.add(alrp);
			}
			
			
		}else{
			//ȫ����ǰ��������¼������
			acLnRepayPlnur.setWvPrcpAmt(NumberUtil.amtAdd(wvAcLnRepayPln.getWvPrcpAmt(), acLnRepayPlnur.getWvPrcpAmt()));
//			acLnRepayPlnur.setWvNormInt(NumberUtil.amtAdd(wvAcLnRepayPln.getWvNormInt(), acLnRepayPlnur.getWvNormInt()));
			
			//�»���ƻ�Ӧ�ӵ��ڿ�ʼ�����仯
			newAcPlnList.add(acLnRepayPlnur);
			
		}
		acLnRepayPlnCur.setWvPrcpAmt(acLnRepayPlnur.getWvPrcpAmt());
		acLnRepayPlnCur.setWvNormInt(acLnRepayPlnur.getWvNormInt());
		JdbcDao.update(acLnRepayPlnCur,"loan_no='"+acLnMst.getLoanNo()+"'", "ac_ln_repay_pln_cur", operaInfo.getConn());
		
		//��ѯԭ����ƻ� ��Ҫ����Ļ���ƻ�
		List<AcLnRepayPln> oldAcLnRepayPln = (ArrayList)JdbcDao.queryList(new AcLnRepayPln(), "loan_no='"+acLnSetlmtLog.getLoanNo()+"' and perd_no>='"+String.valueOf(acLnRepayPlnCur.getPerdNo())+"'", "ac_ln_repay_pln", operaInfo.getConn());
		
		for(AcLnRepayPln alrp : oldAcLnRepayPln){
			//��������ƻ���ʷ
			AcLnRepayPlnHst acLnRepayPlnHst =  getRpHsByRp(alrp,operaInfo.getTraceNo());
			JdbcDao.insert(acLnRepayPlnHst, "ac_ln_repay_pln_hst", operaInfo.getConn());
			
			//ɾ��ԭ��Ҫ����Ļ���ƻ�
			JdbcDao.delete("loan_no='"+alrp.getLoanNo()+"' and perd_no='"+alrp.getPerdNo()+"'", "ac_ln_repay_pln", operaInfo.getConn());
		}
		//�����µĻ���ƻ�
		JdbcDao.insertList(newAcPlnList, "ac_ln_repay_pln", operaInfo.getConn());
		

	}
	
	
	/*
	 * �ų��ڼ��պ�ĵ�һ��������
	 */
	public static String  closeHoliday(String day,OperaInfo operaInfo) throws AccountingException{
		while(true){
			AcComHoliday acComHoliday = (AcComHoliday)JdbcDao.query(new AcComHoliday(), "days='"+day+"'", "ac_com_holiday", operaInfo.getConn());
			if(acComHoliday==null){
				break;
			}
			day = DateUtil.addByDay(day, 1);
		}
		return day;
	}
	
	/**
	 * ��ʽ�û��������滻
	 * @param formula��ʽ
	 * @param parmA
	 * @param parmB
	 * @param parmC
	 * @param parmD
	 * @param parmE
	 * @param parmF
	 * @param parmG
	 * @param parmH
	 * @return
	 * @throws ServiceException
	 */
	public static String replaceParms(String formula , String parmA,String parmB,String parmC,
			String parmD,String parmE,String parmF,String parmG,String parmH,String parmI,String parmJ,String parmK,String parmL) throws ServiceException{
		formula = formula.replace("A", parmA);
		formula = formula.replaceAll("B", parmB);
		formula = formula.replaceAll("C", parmC);
		formula = formula.replaceAll("D", parmD);
		formula = formula.replaceAll("E", parmE);
		formula = formula.replaceAll("F", parmF);
		formula = formula.replaceAll("G", parmG);
		formula = formula.replaceAll("H", parmH);
		formula = formula.replaceAll("I", parmI);
		formula = formula.replaceAll("J", parmJ);
		formula = formula.replaceAll("K", parmK);
		formula = formula.replaceAll("L", parmL);

		return formula;
	}
	
	
	/**
	 * ��װ���ڻ���ƻ���
	 * @param acLnPayPln		����ƻ�
	 * @param acLnMst			�������ļ�
	 * @param curDate			Ӫҵ����
	 * @return acLnRepayPlnCur	���ڻ���ƻ�
	 */
	public static AcLnRepayPlnCur getAcLnRepayPlnCur(AcLnRepayPln acLnRepayPln,AcLnMst acLnMst, String curDate){
		AcLnRepayPlnCur acLnRepayPlnCur = new AcLnRepayPlnCur() ;
		acLnRepayPlnCur.setPayDt(acLnRepayPln.getPayDt()) ;			
		acLnRepayPlnCur.setEndDt(TimeUtil.ADD_DAY(acLnRepayPln.getPayDt(), acLnMst.getGraceDay())) ;
		acLnRepayPlnCur.setLoanNo(acLnRepayPln.getLoanNo()) ;	
		acLnRepayPlnCur.setPactNo(acLnMst.getPactNo());
		acLnRepayPlnCur.setBrNo(acLnMst.getBrNo());
		acLnRepayPlnCur.setNormInt(acLnRepayPln.getNormInt()) ;		
		acLnRepayPlnCur.setPerdNo(acLnRepayPln.getPerdNo()) ;		
		acLnRepayPlnCur.setPrcpAmt(acLnRepayPln.getPrcpAmt()) ;		
		acLnRepayPlnCur.setTtlAmt(acLnRepayPln.getInstmAmt()) ;			
		acLnRepayPlnCur.setWrkDt(curDate) ;						

		return acLnRepayPlnCur ;
	}
	
	/*
	 * ���ݻ���ƻ���ȡ����ƻ���ʷ��Ϣ
	 */
	public static AcLnRepayPlnHst getRpHsByRp(AcLnRepayPln acLnRepayPln,String traceNo){
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
		acLnRepayPlnHst.setRepayPrcpAmt(acLnRepayPln.getRepayPrcpAmt());
		acLnRepayPlnHst.setRepayNormInt(acLnRepayPln.getRepayNormInt());
		acLnRepayPlnHst.setRepayFineInt(acLnRepayPln.getRepayFineInt());
		acLnRepayPlnHst.setOverInd(acLnRepayPln.getOverInd());
		acLnRepayPlnHst.setLstPayDt(acLnRepayPln.getLstPayDt());
		acLnRepayPlnHst.setWvPrcpAmt(acLnRepayPln.getWvPrcpAmt());
		acLnRepayPlnHst.setWvNormInt(acLnRepayPln.getWvNormInt());
		acLnRepayPlnHst.setWvFineInt(acLnRepayPln.getWvFineInt());
		acLnRepayPlnHst.setPrcpSts(acLnRepayPln.getPrcpSts());
		acLnRepayPlnHst.setIntSts(acLnRepayPln.getIntSts());
		acLnRepayPlnHst.setSetlSts(acLnRepayPln.getSetlSts());
		acLnRepayPlnHst.setFineIntDt(acLnRepayPln.getFineIntDt());
		
		return acLnRepayPlnHst ;
	}
	
	
	

}
