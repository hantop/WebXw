package  app.creditapp.acc.loan.bo.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import accounting.biz.pub.ParmBiz;
import accounting.plat.PUBConstant;
import accounting.plat.TransCode;
import accounting.plat.core.AccountingException;
import app.base.BaseService;
import app.base.ServiceException;
import app.creditapp.acc.loan.bo.AcLnLoBo;
import app.creditapp.acc.loan.dao.AcDebitDao;
import app.creditapp.acc.loan.dao.AcLnLoDao;
import app.creditapp.acc.loan.entity.AcDebit;
import app.creditapp.acc.loan.entity.AcDebitDtl;
import app.creditapp.acc.loan.entity.AcLnLo;
import app.creditapp.acc.loan.entity.AcLnMst;
import app.creditapp.acc.log.dao.AcChrgLogDao;
import app.creditapp.acc.log.dao.AcTraceLogDao;
import app.creditapp.acc.log.entity.AcChrgLog;
import app.creditapp.acc.log.entity.AcTraceLog;
import app.creditapp.inf.entity.ResponseParm;
import app.creditapp.inf.entity.WsIn3203;
import app.creditapp.inf.entity.WsOut3203_1;
import app.creditapp.ln.dao.LnAcctDao;
import app.creditapp.ln.dao.LnDueDao;
import app.creditapp.ln.entity.LnAcct;
import app.creditapp.ln.entity.LnDue;
import app.creditapp.proj.dao.ProjAcctDao;
import app.creditapp.proj.entity.ProjAcct;
import app.util.ruleFiter.entity.ValidateLog;
import app.util.ruleFiter.fiter.FiterEngineInterface;
import app.util.toolkit.Ipage;
/**
* Title: AcLnLoBoImplImpl.java
* Description:
**/
public class AcLnLoBoImpl extends BaseService implements AcLnLoBo {

	private AcLnLoDao acLnLoDao;
	private FiterEngineInterface filterEngineInterface;
	private AcChrgLogDao acChrgLogDao;
	private AcTraceLogDao acTraceLogDao;
	private DataSource dataSource;
	private LnDueDao lnDueDao;
	private LnAcctDao lnAcctDao;
	private ProjAcctDao projAcctDao;
	private AcDebitDao acDebitDao;
	 
	 
	public void del(AcLnLo acLnLo) throws ServiceException {
		try {
			acLnLoDao.del(acLnLo);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}

	public Ipage findByPage(Ipage ipg, AcLnLo acLnLo)
			throws ServiceException {
		try {
			ipg.initPageCounts(new Integer[] { (Integer) acLnLoDao
					.getCount(acLnLo) });// ��ʼ����ҳ��
			acLnLo.setStartNumAndEndNum (ipg);
			ipg.setResult(acLnLoDao.findByPage(acLnLo));
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return ipg;
	}

	public AcLnLo getById(AcLnLo acLnLo) throws ServiceException {
		try {
			acLnLo = acLnLoDao.getById(acLnLo);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return acLnLo;
	}
	
	public AcLnLo getLoAmt(AcLnLo acLnLo) throws ServiceException {
		try {
			acLnLo = acLnLoDao.getLoAmt(acLnLo);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return acLnLo;
	}

	public void insert(AcLnLo acLnLo) throws ServiceException {
		try {
			acLnLoDao.insert(acLnLo);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}

	public void update(AcLnLo acLnLo) throws ServiceException {
		try {
			acLnLoDao.update(acLnLo);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}
	
	/**
	 * 
	 * @���� DHCC-LIUJ
	 * @���� 2016-8-4
	 * @����	Ƿ�����
	 */
	public void lnLoCalcul(AcLnMst acLnMst) throws ServiceException{
		
		//��ȡ Ƿ���� ��Ƿ����ǷϢ����Ϣ��
		AcLnLo acLnLo = new AcLnLo();
		acLnLo.setLoanNo(acLnMst.getLoanNo());
		acLnLo = acLnLoDao.getLoAmt(acLnLo);
		
		double loPrcpAmt = acLnLo.getPrcpAmt();//Ƿ��
		double loNormInt = acLnLo.getNormInt();//ǷϢ
		double loFineInt = acLnLo.getFineInt();//��Ϣ
		
		AcChrgLog acChrgLog = new AcChrgLog();
		acChrgLog.setLoanNo(acLnMst.getLoanNo());
		acChrgLog.setChrgSts(PUBConstant.CHRG_STS_20);//��Ƿ
		double loFeeAmt = acChrgLogDao.getLoFeeAmt(acChrgLog);//Ƿ��
	}
	
	/**
	 * 
	 * @throws AccountingException 
	 * @���� DHCC-LIUJ
	 * @���� 2016-8-4
	 * @����	Ƿ��黹
	 */
	public void returnLnlo(AcLnMst acLnMst) throws ServiceException, AccountingException{
		Connection conn = this.getConnection();
		try{
			AcTraceLog acTraceLog = new AcTraceLog();
			String traceNo =  acTraceLogDao.getKey();
			
			//��ȡ Ƿ���� ��Ƿ����ǷϢ����Ϣ��
			AcLnLo acLnLo = new AcLnLo();
			acLnLo.setLoanNo(acLnMst.getLoanNo());
			acLnLo = acLnLoDao.getLoAmt(acLnLo);
			
			if(acLnLo != null){
				double loPrcpAmt = acLnLo.getPrcpAmt();//Ƿ��
				double loNormInt = acLnLo.getNormInt();//ǷϢ
				double loFineInt = acLnLo.getFineInt();//��Ϣ
				
				AcChrgLog acChrgLog = new AcChrgLog();
				acChrgLog.setLoanNo(acLnMst.getLoanNo());
				acChrgLog.setChrgSts(PUBConstant.CHRG_STS_20);//��Ƿ
				double loFeeAmt = acChrgLogDao.getLoFeeAmt(acChrgLog);//Ƿ��
				
				double loAmt = loPrcpAmt + loNormInt + loFineInt + loFeeAmt;//Ƿ���ܼ�
				
				LnDue lnDue = new LnDue();
				lnDue.setDueNo(acLnMst.getLoanNo());
				lnDue = lnDueDao.getById(lnDue);
				
				//�����˺���Ϣ
				LnAcct lnAcct = new LnAcct();
				lnAcct.setAppId(lnDue.getAppId());
				lnAcct.setAcUse("01");//�ۿ��˺�
				lnAcct = lnAcctDao.getById(lnAcct);
				
				//�����˺���Ϣ
				ProjAcct projAcct = new ProjAcct();
				projAcct.setProjNo(acLnMst.getProjNo());
				projAcct.setAcctType("01");//ר��
				projAcct = projAcctDao.getByProjNoAndAcctType(projAcct);
				
				AcDebitDtl acDebitDtl = new AcDebitDtl();
				acDebitDtl.setTraceNo(traceNo);
				acDebitDtl.setLoanNo(acLnMst.getLoanNo());
				acDebitDtl.setPactNo(acLnMst.getPactNo());
				acDebitDtl.setBrNo(acLnMst.getBrNo());
				acDebitDtl.setDdtlNo(ParmBiz.getAcDebitDtlNo(conn));
				acDebitDtl.setDdtlPrcpAmt(loPrcpAmt);
				acDebitDtl.setDdtlNormInt(loNormInt);
				acDebitDtl.setDdtlFineInt(loFineInt);
				acDebitDtl.setDdtlFeeAmt(loFeeAmt);
				acDebitDtl.setDdtlAmt(loAmt);
				acDebitDtl.setDdtlDate(ParmBiz.getOracleTxDate(conn));
				acDebitDtl.setXtAcNo(projAcct.getAcctNo());
				acDebitDtl.setDdtlAcNo(lnAcct.getAcNo());
				acDebitDtl.setDdtlAcName(lnAcct.getAcName());
				acDebitDtl.setDdtlBankCode(lnAcct.getBankCode());
				acDebitDtl.setDdtlBankCity(lnAcct.getBankCity());
				acDebitDtl.setDdtlBankProv(lnAcct.getBankProv());
				acDebitDtl.setDdtlBankSite(lnAcct.getBankSite());
				acDebitDtl.setDdtlSts("02");
				acDebitDtl.setTxDate(ParmBiz.getOracleTxDate(conn));
				acDebitDtl.setTxTime(ParmBiz.getOracleTxTime(conn));
				
				AcDebit acDebit = new AcDebit();
				acDebit.setTraceCnt(1);
				acDebit.setTraceNo(traceNo);
				acDebit.setDebitNo(ParmBiz.getDebitNo(conn));
				acDebit.setTxDt(ParmBiz.getOracleTxDate(conn));
				acDebit.setLoanNo(acLnMst.getLoanNo());
				acDebit.setPactNo(acLnMst.getPactNo());
				acDebit.setBrNo(acLnMst.getBrNo());
				acDebit.setAcctBankCde(acDebitDtl.getDdtlBankCode());
				acDebit.setAcNo(acDebitDtl.getDdtlAcNo());
				acDebit.setXtAcNo(acDebitDtl.getXtAcNo());
				acDebit.setCurNo(acLnMst.getCurNo());
				acDebit.setDebitType("01");
				acDebit.setAtpyAmt(loAmt);
				acDebit.setLoAmt(loAmt);
				acDebit.setCurAmt(0.00);
				acDebit.setMyFeeAmt(0.00);
				acDebit.setOtherFeeAmt(0.00);
				acDebit.setRepayAmt(0.00);
				acDebit.setSts("0");
				acDebit.setCreateDt(ParmBiz.getOracleTxDate(conn));
				acDebitDao.insert(acDebit);
				
				acTraceLog.setTraceNo(traceNo);
				acTraceLog.setTraceCnt(1);
				acTraceLog.setTxDt(ParmBiz.getOracleTxDate(conn));
				acTraceLog.setTxTime(ParmBiz.getOracleTxTime(conn));
				acTraceLog.setTxBrNo(acLnMst.getBrNo());
				acTraceLog.setTxCde(TransCode.LNLO);
				acTraceLog.setSubTxCde(TransCode.LNLO);
				acTraceLog.setSvcInd(TransCode.LNLO);
				acTraceLog.setBrNo(acLnMst.getBrNo());
				acTraceLog.setPactNo(acLnMst.getPactNo());
				acTraceLog.setLoanNo(acLnMst.getLoanNo());
				acTraceLog.setMemo("Ƿ��黹");
				
				acTraceLogDao.insert(acTraceLog);
			}else{
				throw new AccountingException("�ô�����Ƿ���¼");
			}
		} catch(Exception e){
			e.printStackTrace();
		} finally {
            try {
                if(conn!=null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
		
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
	//�ӿ�ws3203У��
	public ResponseParm getresponseParm(WsIn3203 wsIn3203)throws ServiceException{
		ResponseParm responseParm =  new ResponseParm();
		ValidateLog _vlws3203;
		responseParm.setRespCode("0000");
		responseParm.setRespDesc("��Ϣ��ѯ�ɹ���");
		try {
			_vlws3203 = filterEngineInterface.createValidateLog("wsIn3203Id", wsIn3203, true);
			if(!_vlws3203.isSuccess()){
				//У��δͨ�����÷�����Ϊ0001
				responseParm.setRespCode("9004");
				responseParm.setRespDesc("����У����ɣ����������ݸ�ʽ���ڴ���");
			}else{
				AcLnLo wsIn3203forsearch = new AcLnLo();
				String brNo = wsIn3203.getBrNo();
				String pactNo = wsIn3203.getPactNo();
				wsIn3203forsearch.setBrNo(brNo);
				int count = acLnLoDao.getCount(wsIn3203forsearch);
				//�ж��Ƿ���ڸ����κ�
				if(count == 0){
					responseParm.setRespCode("1004");
					responseParm.setRespDesc("��ѯ��¼�����ڣ�");
				}else{
					wsIn3203forsearch.setPactNo(pactNo);
					int countforPactNo = acLnLoDao.getCount(wsIn3203forsearch);
					if(countforPactNo == 0){
						responseParm.setRespCode("1001");
						responseParm.setRespDesc("��ͬ��Ϊ��  "+ pactNo +"  �ļ�¼�����ڣ�");
					}
				}
			}
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		return responseParm;
	}
	//�ӿ�ws3203���ϲ������� ���ط�ҳ��Ϣ
	public Ipage findByPageforws3203(Ipage ipg, AcLnLo acLnLo)throws ServiceException {
			try {
					ipg.initPageCounts(new Integer[] { (Integer) acLnLoDao.getCountfor3203(acLnLo) });// ��ʼ����ҳ��
						acLnLo.setStartNumAndEndNum (ipg);
						ipg.setResult(acLnLoDao.findByPageforws3203(acLnLo));
			} catch (Exception e) {
				throw new ServiceException(e.getMessage());
			}
			return ipg;
	}
	//�ӿ�ws3203���ϲ������� ������������
	public int  getCountforws3203(AcLnLo acLnLo) throws ServiceException {
		int count = 0;
		try {
			count = acLnLoDao.getCountfor3203(acLnLo);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return count;
	}


	public AcLnLoDao getAcLnLoDao() {
		return acLnLoDao;
	}

	public void setAcLnLoDao(AcLnLoDao acLnLoDao) {
		this.acLnLoDao = acLnLoDao;
	}

	public FiterEngineInterface getFilterEngineInterface() {
		return filterEngineInterface;
	}

	public void setFilterEngineInterface(FiterEngineInterface filterEngineInterface) {
		this.filterEngineInterface = filterEngineInterface;
	}

	@Override
	public AcLnLo getAcLnLoByCnt(AcLnLo acLnLo) {
		return acLnLoDao.getAcLnLoByCnt(acLnLo);
	}
	
}