package app.creditapp.acc.loan.bo.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;

import accounting.biz.loan.RepayBiz;
import accounting.biz.pub.ParmBiz;
import accounting.domain.fee.AcChrgLog;
import accounting.domain.loan.AcLoanBackLog;
import accounting.domain.sys.OperaInfo;
import accounting.interf.loan.AcLoanBack;
import accounting.interf.loan.CalFee;
import accounting.interf.loan.CalFeeResult;
import accounting.interf.loan.GrantLoan;
import accounting.interf.loan.GrantLoanBackResult;
import accounting.interf.loan.OpResult;
import accounting.plat.PUBConstant;
import accounting.plat.TransCode;
import accounting.plat.core.AccountingException;
import accounting.plat.core.Operation;
import accounting.plat.core.OperationFactory;
import accounting.plat.dao.JdbcDao;
import app.base.BaseService;
import app.base.ServiceException;
import app.creditapp.acc.loan.bo.LoanBo;
import app.creditapp.acc.loan.dao.AcLoanBackLogDao;
import app.creditapp.acc.log.dao.AcTraceLogDao;
import app.creditapp.inf.dao.WsBaseDao;
import app.creditapp.inf.entity.WsBase;
import app.creditapp.ln.dao.LnDueDao;
import app.creditapp.ln.entity.LnDue;
import app.util.DBUtils;
import app.util.DateUtil;

/**
 * 
 * 
 */
public class LoanBoImpl extends BaseService implements LoanBo {
	Logger logger = Logger.getLogger(LoanBoImpl.class);
	private DataSource dataSource;
	private AcTraceLogDao acTraceLogDao;
	private LnDueDao lnDueDao;
	private WsBaseDao wsBaseDao;
	private AcLoanBackLogDao acLoanBackLogDao;
	
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
	public String grantLoan(LnDue lnDue) throws ServiceException {
		Connection conn = this.getConnection();
		OpResult opResult = null;
		String grantSuccess = "02";//�ſ�ɹ���־ 01 �ɹ�;02ʧ��;Ĭ��ʧ��
		try {

			String traceNo = acTraceLogDao.getKey();
			int traceCnt = 1;
			// �������
			CalFee calFee = new CalFee();
			calFee.setTraceNo(traceNo);
			calFee.setTraceCnt(traceCnt);
			calFee.setLoanNo(lnDue.getDueNo());
			calFee.setPrdtNo(lnDue.getPrdtNo());
			calFee.setTxCode(TransCode.LNC3);
			calFee.setTxAmt(lnDue.getDueAmt());
			calFee.setCurNo(lnDue.getCurNo());
			calFee.setSaveInd(PUBConstant.N);
			calFee.setTxDt(DateUtil.getDate());
			calFee.setUsrId(lnDue.getOpNo());
			calFee.setBrNo(lnDue.getBrNo());
			calFee.setBizDt(ParmBiz.getBizDt(conn));
			Operation feeOp = (Operation) OperationFactory.getFactoryInstance()
					.getOperation(TransCode.LNFC, conn);
			CalFeeResult calFeeResult = (CalFeeResult) feeOp.execute(calFee);
			double feeAmt = calFeeResult.getFeeAmt();
			List<AcChrgLog> acChrgLogList = calFeeResult.getAcChrgLogList();
			GrantLoan grantLoan = new GrantLoan();
			grantLoan.setTraceNo(traceNo);
			grantLoan.setLoanNo(lnDue.getDueNo());
			grantLoan.setFeeAmt(feeAmt);
			grantLoan.setAcChrgLogList(acChrgLogList);
			grantLoan.setBrNo(lnDue.getBrNo());
			grantLoan.setUsrId(lnDue.getOpNo());
			grantLoan.setTxDt(DateUtil.getDate());
			grantLoan.setBizDt(ParmBiz.getBizDt(conn));
			Operation op = (Operation) OperationFactory.getFactoryInstance()
					.getOperation(TransCode.LNC3, conn);
			GrantLoanBackResult grantLoanBackResult = (GrantLoanBackResult)op.execute(grantLoan);
			
			List<AcLoanBackLog> acLoanBackLogList = grantLoanBackResult.getAcLoanBackLogList();
			String uUid = grantLoanBackResult.getUuid();
			opResult = new OpResult();
			opResult.setBl(true);
			opResult.setIdNo(traceNo);
			opResult.setType(TransCode.LN01);
			opResult.setMsg("����ſ��ɹ���");
			grantSuccess = "01";
			dealBack(uUid,acLoanBackLogList);
			
			//����״̬Ϊ�ſ�ɹ�
//			WorkUtils.getInstance().proc_up_stage(lnDue.getAppId(), "PAY_STS", "02", "�ſ�ɹ�");
		} catch (AccountingException e) {
			e.printStackTrace();
			opResult = new OpResult();
			opResult.setBl(false);
			opResult.setType(TransCode.LN01);
//			WorkUtils.getInstance().proc_up_stage(lnDue.getAppId(), "PAY_STS", "03", "�ſ�ʧ��");
//			String _del_result = WorkUtils.getInstance().proc_pact_del(lnDue.getPactId());
//			if("1".equals(_del_result)){
//				logger.info("����ſ��ʧ��!��ͬ����ݡ�������Ѿ�ɾ��[�����AppIdΪ" + lnDue.getAppId()+",��ͬ���PactNoΪ"+lnDue.getPactNo()+",�׾ݺ�dueNoΪ"+lnDue.getDueNo()+"]");
//			}else{
				logger.info("����ſ��ʧ��![�����AppIdΪ" + lnDue.getAppId()+",��ͬ���PactNoΪ"+lnDue.getPactNo()+",�׾ݺ�dueNoΪ"+lnDue.getDueNo()+"]");
//			}
			opResult.setMsg("���㴦�����ſ�ʧ�ܣ�");
			if (e.getLevel() == 1) {
				return e.getMessage();
			} else {
//				e.printStackTrace();
				throw new ServiceException(e);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException(e);
		} finally {
			try {
				conn.close();
//				cipEnter.HsBack(opResult);
			} catch (SQLException e) {
				e.printStackTrace();
				throw new ServiceException(e);
			} catch (Exception e) {
				e.printStackTrace();
				throw new ServiceException(e);
			}
		}
		return grantSuccess;
	}
	
	/**
	 * 
	 * @���� DHCC-LIUJ
	 * @���� 2016-8-26
	 * @���� �������������  
	 */
	public void dealBack(String uUID, List list) {
		// ActionContext.initialize(ServletActionContext.getRequest(),
		// ServletActionContext.getResponse());
		// ServletOutputStream out = null;
		Connection conn = null;
		try {
			String msg = "�ص��ſ�";
			List<AcLoanBackLog> acLoanBackLogListT = list;
			// List<AcLoanBackLog> acLoanBackLogListT = new
			// ArrayList<AcLoanBackLog>();
			// for(int i = 0;i< list.size();i++){
			// AcLoanBackLog acLoanBackLog = new AcLoanBackLog();
			// acLoanBackLog.setBackCnt((String)list.get(2));
			// acLoanBackLog.setUuid((String)list.get(11));
			// acLoanBackLogListT.add(acLoanBackLog);
			// }

			WsBase wsBase = new WsBase();
			conn = DBUtils.getConn();
			wsBase.setWsDate(ParmBiz.getBizDt(conn));
			wsBase.setWsTime(ParmBiz.getOracleUpDate(conn));
			wsBase.setTxCode("P100001");
			wsBase.setRespDesc("֧�����״���ص����ܳɹ�");
			wsBase.setWsSts("01");
			wsBase.setRespContent(msg);
			wsBaseDao.insertDelBack(wsBase);

			// TradeInfo tradeInfo = readStringXmlOut(msg);//��ȡ֧�����ص���Ϣ
			wsBase.setWsSerial(uUID);// ��ȡUUID
			wsBaseDao.updateDelBack(wsBase);

			for (AcLoanBackLog ac : acLoanBackLogListT) {

				String backCnt = ac.getBackCnt();// ��Ŀ��
				String uuid = ac.getUuid();
				app.creditapp.acc.loan.entity.AcLoanBackLog albkl = new app.creditapp.acc.loan.entity.AcLoanBackLog();
				app.creditapp.acc.loan.entity.AcLoanBackLog acLoanBackLog = new app.creditapp.acc.loan.entity.AcLoanBackLog();
				albkl.setBackCnt(backCnt);
				albkl.setUuid(uuid);
				acLoanBackLog = acLoanBackLogDao.getById(albkl);
				/****** ���ӻ��ƣ��ص��ȴ������ύÿ��2���ӣ����ȴ�60�Σ�����ص�������� start ******/
				int i = 0;
				while (i < 60 && acLoanBackLog == null) {
					Thread.sleep(2000);
					acLoanBackLog = acLoanBackLogDao.getById(albkl);
					i++;
				}
				/****** ���ӻ��ƣ��ص��ȴ������ύÿ��2���ӣ����ȴ�30�Σ�����ص�������� end ********/
				if (acLoanBackLog != null) {
					int result = 0;
					String PayStatus = "31000";
					String sql = "UPDATE AC_LOAN_BACK_LOG SET BACK_STS = '" + PUBConstant.BACK_STS_06 + "'";
					String backRes = "01";// �ɹ�
					result = JdbcDao.updateSql(sql + " WHERE back_log_no='" + acLoanBackLog.getBackLogNo()
							+ "' and back_cnt='" + backCnt + "' and back_sts <> '" + PUBConstant.BACK_STS_06 + "'",
							conn);
					if (result > 0) {
						conn.commit();
					} else {
						break;
					}
					String failCaus = "....";
					String cardChn = "CL0002";// ��ȡ֧������ �ȴ�֧�����ر��ļ���֧������
					acLoanBackLog.setBackRes(backRes);
					acLoanBackLog.setFailCaus(failCaus);
					acLoanBackLog.setBackDate(ParmBiz.getOracleTxTime(conn));
					acLoanBackLog.setStatus(PayStatus);
					if (PUBConstant.BACK_TYPE_01.equals(acLoanBackLog.getBackType())) {// �ſ�
						grantLoanBack(acLoanBackLog.getBackLogNo(), acLoanBackLog.getBackCnt(), backRes,
								failCaus, PayStatus, cardChn);
					} else if (PUBConstant.BACK_TYPE_02.equals(acLoanBackLog.getBackType())) {// �ۿ�
						OperaInfo operaInfo = new OperaInfo(conn);
						operaInfo.setTraceCnt(1);
						operaInfo.setBizDt(ParmBiz.getBizDt(conn));
						operaInfo.setTxDt(ParmBiz.getOracleTxDate(conn));
						RepayBiz.acDebitBack(acLoanBackLog.getBackLogNo(), acLoanBackLog.getBackCnt(), backRes,
								failCaus, operaInfo, PayStatus, cardChn);
					}
				}
			}

			// }
			try {
				conn.commit();
			} catch (SQLException e1) {
				conn.rollback();
				e1.printStackTrace();
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException(e.getMessage());
		} finally {
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
	
	public String grantLoan(String brNo) throws ServiceException {
		LnDue lnDue = new LnDue();
		lnDue.setDueNo(brNo);
		List<LnDue> dueList = lnDueDao.getLndueListByBrNo(brNo);
		for(LnDue due:dueList){
			this.grantLoan(due);
		}
		return grantLoan(lnDue);
	}
	
	/**
	 * �ſ��
	 */
	public String grantLoanBack(String backLogNo,String backCnt,String backRes,String failCaus,String PayStatus,String cardChn) throws ServiceException {
		Connection conn = this.getConnection();
		OpResult opResult = null;
		try {
			AcLoanBack acLoanBack = new AcLoanBack();
			acLoanBack.setBackLogNo(backLogNo);
			acLoanBack.setBackCnt(backCnt);
			acLoanBack.setBackRes(backRes);
			acLoanBack.setFailCaus(failCaus);
			acLoanBack.setBackDate(ParmBiz.getOracleUpDate(conn));
			acLoanBack.setTxDt(ParmBiz.getOracleTxDate(conn));
			acLoanBack.setStatus(PayStatus);
			acLoanBack.setCardChn(cardChn);
			Operation op = (Operation) OperationFactory
					.getFactoryInstance()
					.getOperation(TransCode.C3BK, conn);
			op.execute(acLoanBack);

		} catch (AccountingException e) {
			opResult = new OpResult();
			opResult.setBl(false);
			opResult.setType(TransCode.LN01);
			opResult.setMsg("���㴦�����ſ�ʧ�ܣ�");

			if (e.getLevel() == 1) {
				return e.getMessage();
			} else {
				e.printStackTrace();
				throw new ServiceException(e);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException(e);
		} finally {
			try {
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new ServiceException(e);
			} catch (Exception e) {
				e.printStackTrace();
				throw new ServiceException(e);
			}
		}
		return null;
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public AcTraceLogDao getAcTraceLogDao() {
		return acTraceLogDao;
	}

	public void setAcTraceLogDao(AcTraceLogDao acTraceLogDao) {
		this.acTraceLogDao = acTraceLogDao;
	}

	public LnDueDao getLnDueDao() {
		return lnDueDao;
	}

	public void setLnDueDao(LnDueDao lnDueDao) {
		this.lnDueDao = lnDueDao;
	}
	public WsBaseDao getWsBaseDao() {
		return wsBaseDao;
	}
	public void setWsBaseDao(WsBaseDao wsBaseDao) {
		this.wsBaseDao = wsBaseDao;
	}
	public AcLoanBackLogDao getAcLoanBackLogDao() {
		return acLoanBackLogDao;
	}
	public void setAcLoanBackLogDao(AcLoanBackLogDao acLoanBackLogDao) {
		this.acLoanBackLogDao = acLoanBackLogDao;
	}
	
}
