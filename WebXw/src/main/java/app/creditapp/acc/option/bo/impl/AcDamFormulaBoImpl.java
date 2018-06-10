package  app.creditapp.acc.option.bo.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import accounting.biz.pub.FeeBiz;
import accounting.biz.pub.ParmBiz;
import accounting.domain.fee.AcChrgLog;
import accounting.domain.loan.AcFeeRate;
import accounting.domain.loan.AcLnRepayPln;
import accounting.domain.loan.AcLnRepayPlnCur;
import accounting.domain.loan.PrdtBase;
import accounting.plat.PUBConstant;
import accounting.plat.core.AccountingException;
import accounting.plat.dao.JdbcDao;
import accounting.plat.util.NumberUtil;
import accounting.plat.util.TimeUtil;
import app.base.BaseService;
import app.base.ServiceException;
import app.creditapp.acc.loan.entity.AcLnMst;
import app.creditapp.acc.option.bo.AcDamFormulaBo;
import app.creditapp.acc.option.dao.AcDamFormulaDao;
import app.creditapp.acc.option.entity.AcDamFormula;
import app.creditapp.aft.entity.AftAdvpay;
import app.util.DateUtil;
import app.util.toolkit.Ipage;
/**
* Title: AcDamFormulaBoImplImpl.java
* Description:
**/
public class AcDamFormulaBoImpl extends BaseService implements AcDamFormulaBo {

	private AcDamFormulaDao acDamFormulaDao;
	private DataSource dataSource;

	public void del(AcDamFormula acDamFormula) throws ServiceException {
		try {
			acDamFormulaDao.del(acDamFormula);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}

	/*
	 * ��ǰ�������ΥԼ��
	 * (non-Javadoc)
	 * @see app.creditapp.acc.option.bo.AcDamFormulaBo#getDamAmtInAftAdvpay(app.creditapp.aft.entity.AftAdvpay, app.creditapp.acc.loan.entity.AcLnMst)
	 */
	@Override
	public List<AcChrgLog> getDamAmtInAftAdvpay(AftAdvpay aftAdvpay,
			AcLnMst acLnMst, String traceNo) throws ServiceException {
		Connection conn = this.getConnection();
		//DecimalFormat nf = new DecimalFormat();  
		DecimalFormat df =new java.text.DecimalFormat("###.00"); 
		
		DecimalFormat df6 =new java.text.DecimalFormat("0.00000000");
		List<AcChrgLog> acChrgLogList = new ArrayList<AcChrgLog>();
		
	//	nf.setMaximumFractionDigits(10); // �������С��λ
		double damAmt = 0.00;
		try {
			String txDt = ParmBiz.getBizDt(conn);
			if(traceNo==null){
				txDt= aftAdvpay.getPayDate();
			}
			//��ȡ��Ʒ����
			PrdtBase prdtBase = (PrdtBase)JdbcDao.query(new PrdtBase(), "prdt_no='"+acLnMst.getPrdtNo()+"'", "prdt_base", conn);
			System.out.println("pppppp");
			//��ȡ ��ǰ����ΥԼ��ʽ���
			if(prdtBase.getDamNo()!=null || prdtBase.getDamNo().length()>0){
				String damId = prdtBase.getDamNo();
				//��ȡ��ǰ����ΥԼ��ʽ
				AcDamFormula acDamFormula = new AcDamFormula();
				acDamFormula.setDamId(damId);
				acDamFormula = acDamFormulaDao.getById(acDamFormula);
				//���ù�ʽ
				String damFormula = "";
				if (acDamFormula != null) {
					AcLnRepayPlnCur acLnRepayPlnCur = (AcLnRepayPlnCur) JdbcDao.query(new AcLnRepayPlnCur(), "loan_no='"+acLnMst.getLoanNo()+"'", "ac_ln_repay_pln_cur", conn);
					int perdNo = acLnRepayPlnCur.getPerdNo()-1;
					String intDt = "";
					if(NumberUtil.isAmtEqualZero(perdNo)){//�����Ƿ�Ϊ��һ��
						intDt = acLnMst.getOpnDt();
					}else{
						AcLnRepayPln AcLnRepayPln = (AcLnRepayPln) JdbcDao.query(new AcLnRepayPln(), "loan_no='"+acLnMst.getLoanNo()+"' and perd_no = '"+perdNo+"'", "ac_ln_repay_pln", conn);
						intDt = AcLnRepayPln.getPayDt();
					}
					
					
					int days = TimeUtil.getBetweenDays(intDt, txDt);
					damFormula = acDamFormula.getDamFormula();
					String method = acDamFormula.getFeeMethod();
					// �����
					String parmA = "";
					// ��ǰ������
					String parmB = "";
					// ����
					String parmC = "";
	
					String betwMon = String.valueOf(TimeUtil.getBetweenDays(acLnMst
							.getOpnDt(), aftAdvpay.getPayDate()) / 30);
					parmA = String.valueOf(acLnMst.getLoanAmt());
					parmB = String.valueOf(aftAdvpay.getPayAmt());
	
					List<AcFeeRate> acFeeRateList = (ArrayList) JdbcDao.queryList(new AcFeeRate(), "fee_id in ('" + acDamFormula.getFrId().replaceAll("@", "','")
									+ "') and '" + betwMon+ "' >= min_mon and max_mon > '" + betwMon+ "'", "ac_fee_rate", conn);
					if (acFeeRateList.size() > 0) {
						parmC = String.valueOf(df6.format(acFeeRateList.get(0).getFeeRate()));
					}
					
					String parmD= "0";//������Ϣ
					
					if(acLnRepayPlnCur != null){
						parmD = df.format(NumberUtil.amtSubs(NumberUtil.amtSubs(acLnRepayPlnCur.getNormInt(), acLnRepayPlnCur.getRepayNormInt()),acLnRepayPlnCur.getWvNormInt()));
					}
					
					// ����ָ����ʵ��ֵӳ���ϵ
					Map<String, String> parmMp = new HashMap<String, String>();
					parmMp.put("A", parmA);
					parmMp.put("B", parmB);
					parmMp.put("C", parmC);
					parmMp.put("D", parmD);
					String formula = replaceParms(damFormula, parmMp);
					try {
						damAmt = Calc.doCalc(formula).getValue();
						damAmt = NumberUtil.mult(damAmt, 1, 2);
					} catch (Exception e) {
						throw new ServiceException("��ʽ��" + formula + "�������Ͻ�������");
					}
					AcChrgLog acChrgLog = new AcChrgLog();
					acChrgLog = new AcChrgLog();
					acChrgLog.setChrgId(ParmBiz.getAcChrgLogId(conn));
					acChrgLog.setTraceNo(traceNo);
					acChrgLog.setLoanNo(acLnMst.getLoanNo());
					acChrgLog.setPactNo(acLnMst.getPactNo());
					acChrgLog.setBrNo(acLnMst.getBrNo());
					acChrgLog.setPerdNo(String.valueOf(acLnRepayPlnCur.getPerdNo()));
					acChrgLog.setFeeParmId("");
					acChrgLog.setFeeKind("02");
					acChrgLog.setChrgAmt(damAmt);
					acChrgLog.setRepayChrgAmt(0.00);
					acChrgLog.setChrgSts("01");//������
					acChrgLog.setTxDate(ParmBiz.getBizDt(conn));
					acChrgLog.setTxTime(ParmBiz.getOracleTxTime(conn));
					acChrgLog.setFeeType(PUBConstant.FEE_TYPE_06);//ΥԼ��
					if("03".equals(method)){}else{//�����޷���ʱ
						acChrgLogList = FeeBiz.getDamFeeAmt(acLnRepayPlnCur, acLnMst, conn, method, days,traceNo);
					}
					acChrgLogList.add(acChrgLog);
				}
			}
			if(traceNo!=null){
				JdbcDao.insertList(acChrgLogList, "ac_chrg_log", conn);
			}
		} catch (Exception e) {
			
			throw new ServiceException(e.getMessage());
		} finally{
			try {
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				throw new ServiceException(e.getMessage());
			}
		}
		return acChrgLogList;
	}

	public Ipage findByPage(Ipage ipg, AcDamFormula acDamFormula)
			throws ServiceException {
		try {
			ipg.initPageCounts(new Integer[] { (Integer) acDamFormulaDao
					.getCount(acDamFormula) });// ��ʼ����ҳ��
			acDamFormula.setStartNumAndEndNum (ipg);
			ipg.setResult(acDamFormulaDao.findByPage(acDamFormula));
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return ipg;
	}

	public AcDamFormula getById(AcDamFormula acDamFormula) throws ServiceException {
		try {
			acDamFormula = acDamFormulaDao.getById(acDamFormula);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return acDamFormula;
	}

	public void insert(AcDamFormula acDamFormula) throws ServiceException {
		try {
			acDamFormulaDao.insert(acDamFormula);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}

	public void update(AcDamFormula acDamFormula) throws ServiceException {
		try {
			acDamFormulaDao.update(acDamFormula);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}
	
	public void updateSts(AcDamFormula acDamFormula) throws ServiceException {
		try {
			acDamFormulaDao.updateSts(acDamFormula);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}

	/*
	 * ��ǰ�������ΥԼ��
	 * (non-Javadoc)
	 * @see app.creditapp.acc.option.bo.AcDamFormulaBo#getDamAmtInAftAdvpay(app.creditapp.aft.entity.AftAdvpay, app.creditapp.acc.loan.entity.AcLnMst)
	 */
	public double getDamAmtInAftAdvpay(AftAdvpay aftAdvpay,AcLnMst acLnMst) throws ServiceException {
		Connection conn = this.getConnection();

		double damAmt = 0.00;
		try {
			//��ȡ��Ʒ����
			PrdtBase prdtBase = PUBConstant.PUB_ACCOUNT_PRAM.get(acLnMst.getPrdtNo());
			//��ȡ ��ǰ����ΥԼ��ʽ���
			String damId = prdtBase.getDamNo();
			//��ȡ��ǰ����ΥԼ��ʽ
			AcDamFormula acDamFormula = new AcDamFormula();
			acDamFormula.setDamId(damId);
			acDamFormula = acDamFormulaDao.getById(acDamFormula);
			//���ù�ʽ
			String damFormula = "";
			if (acDamFormula != null) {
				damFormula = acDamFormula.getDamFormula();

				// �����
				String parmA = "";
				// ��ǰ������
				String parmB = "";
				// ����
				String parmC = "";

				String betwMon = String.valueOf(DateUtil.getDaysBetween(acLnMst
						.getOpnDt(), aftAdvpay.getPayDate()) / 30);
				parmA = String.valueOf(acLnMst.getLoanAmt());
				parmB = String.valueOf(aftAdvpay.getPayAmt());

				List<AcFeeRate> acFeeRateList = (ArrayList) JdbcDao.queryList(new AcFeeRate(), "fr_id='" + acDamFormula.getFrId()
								+ "' and '" + betwMon+ "' >= min_mon and max_mon > '" + betwMon+ "'", "ac_fee_rate", conn);
				if (acFeeRateList.size() > 0) {
					parmC = String.valueOf(acFeeRateList.get(0).getFeeRate());
				}

				// ����ָ����ʵ��ֵӳ���ϵ
				Map<String, String> parmMp = new HashMap<String, String>();
				parmMp.put("A", parmA);
				parmMp.put("B", parmB);
				parmMp.put("C", parmC);
				String formula = replaceParms(damFormula, parmMp);
				try {
					damAmt = Calc.doCalc(formula).getValue();
				} catch (Exception e) {
					throw new AccountingException("��ʽ��" + formula + "�������Ͻ�������");
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException(e.getMessage());
		} finally{
			try {
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return damAmt;
	}
	/**
	 * 
	 * @���� DHCC-LIUJ
	 * @���� 2016-6-27
	 * @���� ʹ�û���ָ���Ӧֵ�滻�ַ�����ʽ
	 */
	public static String replaceParms(String formula , Map<String,String> parmMp) throws ServiceException{
		for (Map.Entry<String, String> entry : parmMp.entrySet()) {
			System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
			formula = formula.replace(entry.getKey(), entry.getValue());
		}
		return formula;
	}
	
	private Connection getConnection() {

		Connection conn = null;
		try {
			conn = dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ServiceException(e);
		}
		return conn;
	}
	public AcDamFormulaDao getAcDamFormulaDao() {
		return acDamFormulaDao;
	}

	public void setAcDamFormulaDao(AcDamFormulaDao acDamFormulaDao) {
		this.acDamFormulaDao = acDamFormulaDao;
	}
	public DataSource getDataSource() {
		return dataSource;
	}
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
}