package  app.creditapp.acc.option.bo.impl;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import accounting.biz.pub.ParmBiz;
import accounting.domain.sys.AcComHoliday;
import accounting.plat.util.TimeUtil;
import app.base.BaseService;
import app.base.ServiceException;
import app.creditapp.acc.loan.dao.AcLnMstDao;
import app.creditapp.acc.loan.entity.AcLnMst;
import app.creditapp.acc.option.bo.AcLnRepayPlnBo;
import app.creditapp.acc.option.dao.AcComHolidayDao;
import app.creditapp.acc.option.dao.AcLnRepayPlnDao;
import app.creditapp.acc.option.dao.AcLnRepayPlnSuspDao;
import app.creditapp.acc.option.dao.AcReplanFormulaDao;
import app.creditapp.acc.option.dao.AcReplanParmDao;
import app.creditapp.acc.option.dao.AcReplanSecDao;
import app.creditapp.acc.option.entity.AcLnRepayPln;
import app.creditapp.acc.option.entity.AcReplanFormula;
import app.creditapp.acc.option.entity.AcReplanParm;
import app.creditapp.acc.option.entity.AcReplanSec;
import app.creditapp.pact.dao.LnPactDao;
import app.creditapp.sys.dao.PrdtBaseDao;
import app.creditapp.sys.entity.PrdtBase;
import app.util.DateUtil;
import app.util.toolkit.Ipage;
/**
* Title: AcLnRepayPlnBoImplImpl.java
* Description:
**/
public class AcLnRepayPlnBoImpl extends BaseService implements AcLnRepayPlnBo {

	private AcLnRepayPlnDao acLnRepayPlnDao;
	private AcReplanSecDao acReplanSecDao;
	private AcReplanParmDao acReplanParmDao;
	private AcReplanFormulaDao acReplanFormulaDao;
	private AcComHolidayDao acComHolidayDao;
	private PrdtBaseDao prdtBaseDao;
	private LnPactDao lnPactDao;
	private AcLnMstDao acLnMstDao;
	private AcLnRepayPlnSuspDao acLnRepayPlnSuspDao;

	public LnPactDao getLnPactDao() {
		return lnPactDao;
	}

	public void setLnPactDao(LnPactDao lnPactDao) {
		this.lnPactDao = lnPactDao;
	}

	public void del(AcLnRepayPln acLnRepayPln) throws ServiceException {
		try {
			acLnRepayPlnDao.del(acLnRepayPln);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}

	public Ipage findByPage(Ipage ipg, AcLnRepayPln acLnRepayPln)
			throws ServiceException {
		try {
			ipg.initPageCounts(new Integer[] { (Integer) acLnRepayPlnDao
					.getCount(acLnRepayPln) });// ��ʼ����ҳ��
			acLnRepayPln.setStartNumAndEndNum (ipg);
			ipg.setResult(acLnRepayPlnDao.findByPage(acLnRepayPln));
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return ipg;
	}

	/**
	 * ����ƻ�����
	 */
	public List calPlnsByParms(AcLnMst acLnMst)
			throws ServiceException {
		List<AcLnRepayPln> acLnRepayPlnList = new ArrayList<AcLnRepayPln>();
		List<AcReplanSec> acReplanSecList = new ArrayList<AcReplanSec>();
		
		DecimalFormat df =new java.text.DecimalFormat("###.00"); 
		
		DecimalFormat df6 =new java.text.DecimalFormat("###.000000"); 

		String opnDt = acLnMst.getOpnDt();//�ſ���
		String mtrDt = acLnMst.getMtrDt();//������
		String lstIntDt = acLnMst.getRepayDay();//������
		if(lstIntDt.length()==1){
			lstIntDt = 0+lstIntDt;
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
			String prdtNo = acLnMst.getPrdtNo();
			PrdtBase prdtBase = new PrdtBase();
			prdtBase.setPrdtNo(prdtNo);
			prdtBase = prdtBaseDao.getByPrdtNo(prdtBase);
			String replanId = prdtBase.getRepayNo();// �������
			
			AcReplanParm acReplanParm = new AcReplanParm();
			acReplanParm.setReplanId(replanId);
			acReplanParm = acReplanParmDao.getById(acReplanParm);
			AcReplanSec acReplanSec = new AcReplanSec();
			acReplanSec.setReplanId(replanId);
			acReplanSecList = (List) acReplanSecDao.getListByReplanId(acReplanSec);
			int i = 0;// �ڴ�--�ڼ���
			if (acReplanSecList.size() > 0) {// ����ÿһ�λ���ƻ�
				for (AcReplanSec ars : acReplanSecList) {

					String extendNext = acReplanParm.getExtendNext();// ������е����ڲ������� �ڳ�/��ĩ
					String extendDate = "";
					if("3".equals(extendNext)){
						extendDate = opnDt;
					}else{
						extendDate = getExtendDate(opnDt,lstIntDt);
					}
					
					
					String parmB = String.valueOf(acLnMst.getLoanTerm());// ������
					parmC = acReplanParm.getTermType();
					String parmD = String.valueOf(acLnMst.getLnRate());// ����������
//					String parmL = String.valueOf(acLnMst.getLnRateYear());// ����������
					String parmL = String.valueOf(0.1056);// ����������
					parmE = String.valueOf(acReplanParm.getFrequency());
					parmH = String.valueOf(ars.getCapitalRate());

					String begRepayNo = ars.getBegRepayNo();// ������ʼ�ڴ�
					String endRepayNo = ars.getEndRepayNo();// ���ε������

					AcReplanFormula acReplanFormula = new AcReplanFormula();
					acReplanFormula.setFormulaId(ars.getFormulaId());
					acReplanFormula = acReplanFormulaDao
							.getById(acReplanFormula);
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
							if(TimeUtil.checkDate1BeforeDate2(acLnMst.getMtrDt(),DateUtil.getDateStr(extendDate,sumPerdNo))){
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
						for (; i <= Integer.parseInt(endRepayNo); i++) {// ����ÿ�ڻ���ƻ�
							AcLnRepayPln acLnRepayPln = new AcLnRepayPln();
							if(0==i){
								parmG = String.valueOf(i - Integer.parseInt(begRepayNo) + 1);// ���㱾���ڴ�
								acLnRepayPln.setBal(acLnMst.getLoanAmt());
								acLnRepayPln.setInstmAmt(0.00);
								acLnRepayPln.setLoanNo(acLnMst.getLoanNo());
								acLnRepayPln.setNormInt(0.00);
								acLnRepayPln.setPayDt(DateUtil.getDateStr(opnDt, i));
								acLnRepayPln.setPerdNo(i);
								acLnRepayPln.setPrcpAmt(0.00);
								acLnRepayPln.setLnRate(acLnMst.getLnRate());
								acLnRepayPlnList.add(acLnRepayPln);
							} else {
								parmG = String.valueOf(i - Integer.parseInt(begRepayNo) + 1);// ���㱾���ڴ�
								double normInt = 0.00;// ����Ӧ����Ϣ
								double prcpAmt = 0.00;// ����Ӧ�ձ���
								String upPayDt = "";// ���ڻ�����
								String payDt = "";// ���ڻ�����
								AcLnRepayPln lstAcLnRepayPln = new AcLnRepayPln();
								for (AcLnRepayPln alrp : acLnRepayPlnList) {
									if ((i - 1) == alrp.getPerdNo()) {
										lstAcLnRepayPln = alrp;
										parmF = df.format(alrp.getBal());
										upPayDt = alrp.getPayDt();
									}
								}
								double normIntExtend = acLnMst.getLoanAmt() * acLnMst.getLnRate()
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
									}
								}else{
									if ("1".equals(acReplanParm.getTermType())) {// ��������Ϊ���գ����ڻ�����Ϊ���ڻ�����+����Ƶ��
										payDt = DateUtil.addByDay(opnDt, i * Integer.parseInt(parmE));
									}else{
										//ʹ��������䣬���ɵĻ���ƻ������ڵ���
//										payDt = DateUtil.getDateStr(extendDate, (i -1)*Integer.parseInt(parmE)*Integer.parseInt(parmC)).substring(0, 6)+lstIntDt;  
										//ʹ��������䣬���ɵĻ���ƻ������ڴ���
										payDt = DateUtil.getDateStr(upPayDt, Integer.parseInt(parmE)*Integer.parseInt(parmC)).substring(0, 6)+lstIntDt;
										while(!DateUtil.isDateStr(payDt)){
											payDt = DateUtil.addByDay(payDt, -1);
										}
										if(!DateUtil.isBefore(opnDt, payDt)){
											payDt = DateUtil.getDateStr(extendDate, (i) * Integer.parseInt(parmE)*Integer.parseInt(parmC)).substring(0, 6)+lstIntDt;
										}
									}
								}
								//�ж��˵����Ƿ���Ч������Ч�����һ�����ж�
								while(!DateUtil.isDateStr(payDt)){
									payDt = DateUtil.addByDay(payDt, -1);
								}
								//�жϽڼ����Ƿ�˳��
								if("1".equals(acReplanParm.getHolidIfExt())){
									payDt = closeHoliday(payDt);//�ж������Ƿ�Ϊ�ڼ��գ��������ȡ�ڼ��պ�ĵ�һ��������
								}
								//��ȡ�����뱾�ڼ��������
								String parmI = String.valueOf(DateUtil.getDaysBetween(upPayDt, payDt));
								//�ò���ֵ�滻��ʽָ��
								String payCap1 = this.replaceParms(payCap, parmA, parmB, parmC, parmD, parmE,
										parmF, parmG, parmH, parmI, String.valueOf(parmJ),parmK,parmL);
								String payInte1 = this.replaceParms(payInte, parmA, parmB, parmC, parmD, parmE,
										parmF, parmG, parmH, parmI, String.valueOf(parmJ),parmK,parmL);
								normInt = Calc.doCalc(payInte1).getValue();// ͨ����ʽ�ó��ı���Ӧ����Ϣ
								prcpAmt = Calc.doCalc(payCap1).getValue();// ͨ����ʽ�ó��ı���Ӧ�ձ���
								if(1==i&&"1".equals(acReplanParm.getIfLoanInt())){//��Ϊ��һ�ڣ��ҷ���ѡ��ſ��տۿ�
									payDt = opnDt;
								}
								if (i == 1 && "1".equals(extendNext)) {// ��һ����Ϣ����ݷ����趨���ڳ�/��ĩ���������Ϣͳ�����ڳ�������ĩ
									normInt += normIntExtend;
								}
								if (i == sumPerdNo) {// ���һ����ϢӦ�����¼���
									if("1".equals(extendNext) && !mtrDt.equals(payDt)){//�����һ�ڼ�����Ļ������뵽���ղ�һ�£���˵�����һ�ڲ������£��谴�ռ�����Ϣ
										normInt = (Double.parseDouble(parmF)
												* acLnMst.getLnRate() / 30 * DateUtil.getDaysBetween(upPayDt, mtrDt));
									}else if ("2".equals(extendNext)) {// ���ڲ���������ĩ
										normInt += normIntExtend;
									}
									payDt = mtrDt;
								}
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
								acLnRepayPln.setLnRate(acLnMst.getLnRate());
								acLnRepayPln.setFineInt(0.0);
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
				if(Math.abs(arp.getBal())<=1){
					arp.setBal(0.00);
				}else{
					arp.setBal(Double.parseDouble(df.format(arp.getBal())));
				}
			}
		}
		return acLnRepayPlnList;
	}
	/*
	 * �ų��ڼ��պ�ĵ�һ��������
	 */
	public String  closeHoliday(String day){
		while(true){
			AcComHoliday acComHoliday = new AcComHoliday();
			acComHoliday = acComHolidayDao.getByDay(day);
			if(acComHoliday==null){
				break;
			}
			day = DateUtil.addByDay(day, 1);
		}
		
		return day;
	}
	//���ݺ�ͬ�Ž��в�ѯ
	public AcLnRepayPln getByIdforpact(AcLnRepayPln acLnRepayPln) throws ServiceException{
		
			try {
				acLnRepayPln = acLnRepayPlnDao.getByIdforpact(acLnRepayPln);
			} catch (Exception e) {
				throw new ServiceException(e.getMessage());
			}
			return acLnRepayPln;
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
	public static void main(String[] args) {
		String s = getExtendDate("20150510","20");
		System.out.println(s);
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
	public String replaceParms(String formula , String parmA,String parmB,String parmC,
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
	
	public AcLnRepayPln getById(AcLnRepayPln acLnRepayPln) throws ServiceException {
		try {
			acLnRepayPln = acLnRepayPlnDao.getById(acLnRepayPln);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return acLnRepayPln;
	}
	@Override
	public AcLnRepayPln getAllAmt(AcLnRepayPln acLnRepayPln)
			throws ServiceException {
		try {
			acLnRepayPln = acLnRepayPlnDao.getAllAmt(acLnRepayPln);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return acLnRepayPln;
	}
	public void insert(AcLnRepayPln acLnRepayPln) throws ServiceException {
		try {
			acLnRepayPlnDao.insert(acLnRepayPln);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}

	public void update(AcLnRepayPln acLnRepayPln) throws ServiceException {
		try {
			acLnRepayPlnDao.update(acLnRepayPln);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}

	public AcLnRepayPlnDao getAcLnRepayPlnDao() {
		return acLnRepayPlnDao;
	}

	public void setAcLnRepayPlnDao(AcLnRepayPlnDao acLnRepayPlnDao) {
		this.acLnRepayPlnDao = acLnRepayPlnDao;
	}

	public AcReplanSecDao getAcReplanSecDao() {
		return acReplanSecDao;
	}

	public void setAcReplanSecDao(AcReplanSecDao acReplanSecDao) {
		this.acReplanSecDao = acReplanSecDao;
	}

	public AcReplanParmDao getAcReplanParmDao() {
		return acReplanParmDao;
	}

	public void setAcReplanParmDao(AcReplanParmDao acReplanParmDao) {
		this.acReplanParmDao = acReplanParmDao;
	}

	public AcReplanFormulaDao getAcReplanFormulaDao() {
		return acReplanFormulaDao;
	}

	public void setAcReplanFormulaDao(AcReplanFormulaDao acReplanFormulaDao) {
		this.acReplanFormulaDao = acReplanFormulaDao;
	}

	public AcComHolidayDao getAcComHolidayDao() {
		return acComHolidayDao;
	}

	public void setAcComHolidayDao(AcComHolidayDao acComHolidayDao) {
		this.acComHolidayDao = acComHolidayDao;
	}

	public PrdtBaseDao getPrdtBaseDao() {
		return prdtBaseDao;
	}

	public void setPrdtBaseDao(PrdtBaseDao prdtBaseDao) {
		this.prdtBaseDao = prdtBaseDao;
	}

	public AcLnMstDao getAcLnMstDao() {
		return acLnMstDao;
	}

	public void setAcLnMstDao(AcLnMstDao acLnMstDao) {
		this.acLnMstDao = acLnMstDao;
	}

	public AcLnRepayPlnSuspDao getAcLnRepayPlnSuspDao() {
		return acLnRepayPlnSuspDao;
	}

	public void setAcLnRepayPlnSuspDao(AcLnRepayPlnSuspDao acLnRepayPlnSuspDao) {
		this.acLnRepayPlnSuspDao = acLnRepayPlnSuspDao;
	}

	@Override
	public AcLnRepayPln getByBrNoPactNoPerdNo(AcLnRepayPln acLnRepayPln)
			throws ServiceException {
		return acLnRepayPlnDao.getByBrNoPactNoPerdNo(acLnRepayPln);
		
	}


}