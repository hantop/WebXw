package  app.creditapp.aft.bo.impl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import accounting.biz.loan.RepayBiz;
import accounting.biz.pub.ParmBiz;
import accounting.domain.sys.OperaInfo;
import accounting.interf.loan.AcLoanBack;
import accounting.plat.PUBConstant;
import accounting.plat.TransCode;
import accounting.plat.core.AccountingException;
import accounting.plat.core.Operation;
import accounting.plat.core.OperationFactory;
import accounting.plat.util.NumberUtil;
import app.base.BaseService;
import app.base.ServiceException;
import app.creditapp.acc.loan.dao.AcDebitDao;
import app.creditapp.acc.loan.dao.AcDebitSuspDao;
import app.creditapp.acc.loan.dao.AcLnLoDao;
import app.creditapp.acc.loan.dao.AcLnMstDao;
import app.creditapp.acc.loan.dao.AcLnRepayPlnCurDao;
import app.creditapp.acc.loan.dao.AcLoanBackLogDao;
import app.creditapp.acc.loan.dao.AcLoanLogDao;
import app.creditapp.acc.loan.entity.AcDebit;
import app.creditapp.acc.loan.entity.AcDebitSusp;
import app.creditapp.acc.loan.entity.AcLnLo;
import app.creditapp.acc.loan.entity.AcLnMst;
import app.creditapp.acc.loan.entity.AcLnRepayPlnCur;
import app.creditapp.acc.loan.entity.AcLoanBackLog;
import app.creditapp.acc.loan.entity.AcLoanLog;
import app.creditapp.acc.log.dao.AcTraceLogDao;
import app.creditapp.acc.log.entity.AcTraceLog;
import app.creditapp.acc.option.dao.AcLnRepayPlnDao;
import app.creditapp.acc.option.entity.AcLnRepayPln;
import app.creditapp.aft.bo.AftRepyClearBo;
import app.creditapp.aft.dao.AftRepyClearDao;
import app.creditapp.aft.entity.AftRepyClear;
import app.creditapp.corp.dao.CorpAcctDao;
import app.creditapp.corp.dao.CorpBaseDao;
import app.creditapp.corp.entity.CorpAcct;
import app.creditapp.corp.entity.CorpBase;
import app.creditapp.inf.client.zf.Exception_Exception;
import app.creditapp.inf.dao.WsBaseDao;
import app.creditapp.inf.dao.WsRepyClearDao;
import app.creditapp.inf.dao.WsRepyFineDao;
import app.creditapp.inf.entity.WsRepyClear;
import app.creditapp.inf.entity.WsRepyFine;
import app.creditapp.ln.dao.LnAcctDao;
import app.creditapp.ln.dao.LnDueDao;
import app.creditapp.ln.entity.LnAcct;
import app.creditapp.ln.entity.LnDue;
import app.creditapp.proj.dao.ProjAcctDao;
import app.creditapp.proj.dao.ProjBaseDao;
import app.creditapp.proj.entity.ProjAcct;
import app.creditapp.proj.entity.ProjBase;
import app.util.DBUtils;
import app.util.toolkit.Ipage;
/**
* Title: AftRepyClearBoImplImpl.java
**/
public class AftRepyClearBoImpl extends BaseService implements AftRepyClearBo {

	private AftRepyClearDao aftRepyClearDao;
	private AcLnMstDao acLnMstDao;
	private AcLnRepayPlnCurDao acLnRepayPlnCurDao;
	private WsRepyClearDao wsRepyClearDao;
	private LnDueDao lnDueDao;
	private LnAcctDao lnAcctDao;
	private	AcDebitSuspDao acDebitSuspDao;
	private AcTraceLogDao acTraceLogDao;
	private ProjAcctDao projAcctDao;
	private AcDebitDao acDebitDao;
	private AcLoanBackLogDao acLoanBackLogDao;
	private CorpAcctDao corpAcctDao;
	private AcLoanLogDao acLoanLogDao;
	private WsBaseDao wsBaseDao;
	private ProjBase projBase;
	private ProjBaseDao projBaseDao;
	private WsRepyFineDao wsRepyFineDao;
	private AcLnLoDao acLnLoDao;
	private AcLnRepayPlnDao acLnRepayPlnDao;
	private CorpBaseDao corpBaseDao;
	
	public void del(AftRepyClear aftRepyClear) throws ServiceException {
		try {
			aftRepyClearDao.del(aftRepyClear);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}

	public Ipage findByPage(Ipage ipg, AftRepyClear aftRepyClear)
			throws ServiceException {
		try {
			ipg.initPageCounts(new Integer[] { (Integer) aftRepyClearDao
					.getCount(aftRepyClear) });// ��ʼ����ҳ��
			aftRepyClear.setStartNumAndEndNum (ipg);
			ipg.setResult(aftRepyClearDao.findByPage(aftRepyClear));
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return ipg;
	}

	public AftRepyClear getById(AftRepyClear aftRepyClear) throws ServiceException {
		try {
			aftRepyClear = aftRepyClearDao.getById(aftRepyClear);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return aftRepyClear;
	}

	public void insert(AftRepyClear aftRepyClear) throws ServiceException {
		try {
			aftRepyClearDao.insert(aftRepyClear);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}
	
	/**
	 * 
	 * @���� DHCC-LIUJ
	 * @���� 2016-10-14
	 * @����	��ǰ���ʵʱ��ѯ����
	 */
	public WsRepyClear selectClearResult(WsRepyClear wsRepyClear) throws ServiceException{
		AftRepyClear aftRepyClear = new AftRepyClear();
		aftRepyClear.setWsId(wsRepyClear.getWsId());
		aftRepyClear = aftRepyClearDao.getByWsId(aftRepyClear);
		
		AcLnMst acLnMst = new AcLnMst();
		acLnMst.setPactNo(aftRepyClear.getPactNo());
		acLnMst.setBrNo(aftRepyClear.getBrNo());
		acLnMst = acLnMstDao.getByPactNo(acLnMst);
		
		double exact = 0.0001;//��ȷС��
		if(acLnMst.getLoanBal()<exact && acLnMst.getLoanBal()>-exact ){//����ɹ�
			aftRepyClear.setClearSts("02");
			aftRepyClear.setDealDesc("����ɹ�");
			aftRepyClearDao.update(aftRepyClear);
			
			wsRepyClear.setDealSts("03");
			wsRepyClear.setDealDesc("����ɹ�");
			wsRepyClearDao.update(wsRepyClear);
		}
		return wsRepyClear;
				
	}
	/**
	 * 
	 * @���� DHCC-LIUJ
	 * @���� 2016-8-23
	 * @����	��ǰ��������WS����SUSP�����
	 */
	public WsRepyClear WsInsert(WsRepyClear wsRepyClear) throws ServiceException{
		boolean result = false;
		Connection conn = DBUtils.getConn();
		try {
			AcLnRepayPlnCur acLnRepayPlnCur = new AcLnRepayPlnCur();
			AcLnMst acLnMst = new AcLnMst();
			String pactNo = wsRepyClear.getPactNo();// ��ͬ��
			String brNo = wsRepyClear.getBrNo();// ������

			double repayAmt = wsRepyClear.getRepayAmt();// �ۿ��
			double repayInte = wsRepyClear.getRepayInte();// �ۿ���Ϣ

			// �ֱ�ŵ��������ļ���ʵ�� ��ѯ��
			acLnMst.setPactNo(pactNo);
			acLnMst.setBrNo(brNo);
			acLnMst = acLnMstDao.getByPactNo(acLnMst);
			if (acLnMst == null) {
				// ����WS������ʧ��
				wsRepyClear.setDealDesc("�������ļ�������");
				wsRepyClear.setDealSts("05");
				wsRepyClearDao.update(wsRepyClear);
				return wsRepyClear;
			} else if("01".equals(acLnMst.getLoanSts()) ||"02".equals(acLnMst.getLoanSts()) 
						||"03".equals(acLnMst.getLoanSts()) ||"04".equals(acLnMst.getLoanSts())){//���ļ�״̬Ϊ01/02/03/04���ܿۿ�
			}else{
				//����WS������ʧ��
				wsRepyClear.setDealDesc("�������ļ�������������");
				wsRepyClear.setDealSts("05");
				wsRepyClearDao.update(wsRepyClear);
				return wsRepyClear;
			}
			// �ֱ�ŵ����ڻ���ƻ����ʵ�� ��ѯ��
			acLnRepayPlnCur.setPactNo(pactNo);
			acLnRepayPlnCur.setBrNo(brNo);
			acLnRepayPlnCur = acLnRepayPlnCurDao.getByPactNo(acLnRepayPlnCur);
			if(acLnRepayPlnCur == null){
				// ����WS������ʧ��
				wsRepyClear.setDealDesc("����ƻ������ڣ����ܷ�����ǰ������룡");
				wsRepyClear.setDealSts("05");
				wsRepyClearDao.update(wsRepyClear);
				return wsRepyClear;
			}
			
			//��ѯ�����е���ǰ���
			WsRepyClear wsRepyClearIng = new WsRepyClear();
			wsRepyClearIng = wsRepyClearDao.getDealIngByPactno(wsRepyClear);
			if(wsRepyClearIng!=null){
				wsRepyClear.setDealDesc("���ڴ����е���ǰ������룬�����ظ�����");
				wsRepyClear.setDealSts("05");
				wsRepyClearDao.update(wsRepyClear);
				return wsRepyClear;
			}
			
			// ��ѯ�����Ϣ
			LnDue lnDue = new LnDue();
			lnDue.setDueNo(acLnMst.getLoanNo());
			lnDue = lnDueDao.getById(lnDue);

			// ���ݿۿ��˺Ų�ѯ �ۿ���Ϣ
			LnAcct lnAcct = new LnAcct();
			lnAcct.setAppId(lnDue.getAppId());
			lnAcct.setAcNo(wsRepyClear.getAcNo());
			lnAcct.setAcUse("1");// �ۿ�
			lnAcct = lnAcctDao.getById(lnAcct);

			if (lnAcct == null) {// �ۿ��˺� ����������ոÿۿ�����
				// ����WS������ʧ��
				wsRepyClear.setDealDesc("�ۿ��˺Ų�����");
				wsRepyClear.setDealSts("05");
				wsRepyClearDao.update(wsRepyClear);
				return wsRepyClear;
			} else if (!"01".equals(lnAcct.getAcSts())) {// �ۿ��˺�δ��Ч������տۿ�����
				wsRepyClear.setDealDesc("�ۿ��˺�δ��Ч");
				wsRepyClear.setDealSts("05");
				wsRepyClearDao.update(wsRepyClear);
				return wsRepyClear;
			}

			//����Ӧ�շ�Ϣ
			WsRepyFine wsRepyFine = new WsRepyFine();
			wsRepyFine.setWsId(wsRepyClear.getWsId());
			List<WsRepyFine> wsRepyFineList = wsRepyFineDao.getListByWsId(wsRepyFine);
			AcLnRepayPln acLnRepayPln = null;
			AcLnLo alo = null;
			for(WsRepyFine wrf : wsRepyFineList){
				//���»���ƻ���Ӧ�շ�Ϣ
				acLnRepayPln = new AcLnRepayPln();
				acLnRepayPln.setLoanNo(acLnMst.getLoanNo());
				acLnRepayPln.setPerdNo(wrf.getCnt());
				acLnRepayPln = acLnRepayPlnDao.getById(acLnRepayPln);
				if(acLnRepayPln != null){
					acLnRepayPln.setFineInt(wrf.getTxPayOver());
					acLnRepayPlnDao.update(acLnRepayPln);
				}
				//����Ƿ���Ӧ�շ�Ϣ
				alo = new AcLnLo();
				alo.setLoanNo(acLnMst.getLoanNo());
				alo.setPerdNo(wrf.getCnt());
				alo = acLnLoDao.getById(alo);
				if(alo != null){
					alo.setFineInt(wrf.getTxPayOver());
					acLnLoDao.update(alo);
				}
			}
			
			// ��ǰ��� ������������۱����һֱ
			double exact = 0.0001;
			double bal = NumberUtil.amtSubs(acLnMst.getLoanBal(), wsRepyClear.getRepayAmt());
			if (bal < exact && bal > -exact ) {
				result = true;
			} else {
				result = false;

				// ����WS������ʧ��
				wsRepyClear.setDealDesc("������ǰ������룬�۱�����������"+acLnMst.getLoanBal()+"����");
				wsRepyClear.setDealSts("05");
				wsRepyClearDao.update(wsRepyClear);
				return wsRepyClear;
			}
			
				wsRepyClear.setDealDesc("������");
				wsRepyClear.setDealSts("02");
				wsRepyClearDao.update(wsRepyClear);

				AcDebitSusp acDebitSusp = new AcDebitSusp();
				acDebitSusp.setWsId(wsRepyClear.getWsId());
				acDebitSusp.setBatchNo("");
				acDebitSusp.setBrNo(wsRepyClear.getBrNo());
				acDebitSusp.setPactNo(wsRepyClear.getPactNo());
				acDebitSusp.setAcName(wsRepyClear.getAcName());
				acDebitSusp.setAcNo(wsRepyClear.getAcNo());
				acDebitSusp.setOpnCode(wsRepyClear.getOpnCode());
				acDebitSusp.setOpnName(wsRepyClear.getOpnName());
				acDebitSusp.setPayOver(wsRepyClear.getPayOver());
				acDebitSusp.setFeeRec(wsRepyClear.getFeeRec());
				acDebitSusp.setRepayTotal(wsRepyClear.getRepayTotal());
				acDebitSusp.setRepayAmt(wsRepyClear.getRepayAmt());
				acDebitSusp.setRepayInte(wsRepyClear.getRepayInte());
				acDebitSusp.setRepayOver(wsRepyClear.getRepayOver());
				acDebitSusp.setFeeTotal(wsRepyClear.getFeeTotal());
				acDebitSusp.setSerialNo(wsRepyClear.getSerialNo());
				acDebitSusp.setDealSts(wsRepyClear.getDealSts());
				acDebitSusp.setDealDesc(wsRepyClear.getDealDesc());
				acDebitSusp.setTxCde(TransCode.LNCL);// ��ǰ���
				
				// acDebitSusp.setTxDate(wsRepyClear.getTxDate());
				acDebitSuspDao.insert(acDebitSusp);

				// ����ҵ����
				acDebitSuspExec(acDebitSusp);

		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}finally{
			if(conn!=null)
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return wsRepyClear;
	}
	
	/**
	 * 
	 * @���� DHCC-LIUJ
	 * @���� 2016-8-25
	 * @����	�ۿ��ļ��ϴ��߼�����
	 */
	public void acDebitSuspExec(AcDebitSusp acDebitSusp)throws ServiceException{
		Connection conn = DBUtils.getConn();
		AcTraceLog acTraceLog = new AcTraceLog();
		String traceNo =  acTraceLogDao.getKey();
		
		//�����Ϣ
		LnDue lnDue = new LnDue();
		lnDue.setPactNo(acDebitSusp.getPactNo());
		lnDue.setBrNo(acDebitSusp.getBrNo());
		lnDue = lnDueDao.getByPactNoAndBrNo(lnDue);
		
		//���������˻�
		ProjAcct projAcct = null;
		if(acDebitSusp.getCardChn()!=null && acDebitSusp.getCardChn().length()>0){
			projAcct = new ProjAcct();
			projAcct.setProjNo(lnDue.getProjNo());
			projAcct.setAcctType("02");//�����˻�
			projAcct.setCardSts("01");//��Ч
			projAcct.setCardChn(acDebitSusp.getCardChn());
			projAcct = projAcctDao.getByProjNoAndAcctTypeAndChn(projAcct);
		}
		
		LnAcct lnAcct = new LnAcct();
		lnAcct.setAppId(lnDue.getAppId());
		lnAcct.setAcUse("1");//�ۿ��˺�
		lnAcct.setAcNo(acDebitSusp.getAcNo());
		lnAcct.setAcSts("01");//״̬����
		lnAcct = lnAcctDao.getById(lnAcct);
		
		AcDebit acDebit = new AcDebit();
		acDebit.setTraceCnt(1);
		acDebit.setTraceNo(traceNo);
		try {
			List<AcLoanBackLog> acLoanBackLogList = new ArrayList<AcLoanBackLog>();

			acDebit.setDebitNo(ParmBiz.getDebitNo(conn));
			acDebit.setTxDt(ParmBiz.getBizDt(conn));
			acDebit.setLoanNo(lnDue.getDueNo());
			acDebit.setPactNo(lnDue.getPactNo());
			acDebit.setBrNo(lnDue.getBrNo());
			acDebit.setCurNo(lnDue.getCurNo());
			acDebit.setAcctBankCde(lnAcct.getBankCode());
			acDebit.setAcNo(lnAcct.getAcNo());
			acDebit.setAcType(lnAcct.getAcType());
			acDebit.setAcName(lnAcct.getAcName());
			acDebit.setBankCode(lnAcct.getBankCode());
			acDebit.setBankProv(lnAcct.getBankProv());
			acDebit.setBankCity(lnAcct.getBankCity());
			acDebit.setBankSite(lnAcct.getBankSite());
			acDebit.setAtpyAmt(acDebitSusp.getRepayAmt()+acDebitSusp.getRepayInte()+acDebitSusp.getRepayOver()+acDebitSusp.getFeeTotal());
			acDebit.setLoAmt(0.00);
			acDebit.setCurAmt(0.00);
			acDebit.setMyFeeAmt(0.00);
			acDebit.setOtherFeeAmt(acDebitSusp.getFeeTotal());
			acDebit.setRepayAmt(0.00);
			acDebit.setSts("01");
			String busOrderType="";//ҵ�񶩵���������
			if(acDebitSusp.getFeeTotal()>0){//�����ô���0
				busOrderType="004";//������
			}else{
				busOrderType="003";//��������
			}
			acDebit.setBusEntryType(busOrderType+"01");
			acDebit.setIdType(lnAcct.getIdType());
	 		acDebit.setIdNo(lnAcct.getIdNo());
	 		acDebit.setPhoneNo(lnAcct.getPhoneNo());
	 		acDebit.setValidDate(lnAcct.getValidDate());
	 		acDebit.setCvvNo(lnAcct.getCvvNo());
			
			if(acDebitSusp.getCardChn()!=null && acDebitSusp.getCardChn().length()>0){//�ϴ��ۿ��ļ���ָ��֧������
				acDebit.setCardChn(acDebitSusp.getCardChn());
				acDebit.setXtAcNo(projAcct.getAcctNo());
			}else{
				acDebit.setCardChn("");
				acDebit.setXtAcNo("");
			}
			acDebit.setCreateDt(ParmBiz.getOracleTxDate(conn));
			
			acDebitDao.insert(acDebit);
			
			AcLoanBackLog acLoanBackLog = new AcLoanBackLog();
			String backLogNo = ParmBiz.getAcLoanLogNo(conn) ;
			acLoanBackLog.setBackLogNo(backLogNo);
			acLoanBackLog.setBackCnt("1");
			acLoanBackLog.setLoanLogNo(acDebit.getDebitNo());
			acLoanBackLog.setBackType(PUBConstant.BACK_TYPE_02);
			acLoanBackLog.setBackRes("");
			acLoanBackLog.setFailCaus("");
			acLoanBackLog.setBackSts(PUBConstant.BACK_STS_01);
			acLoanBackLog.setBusOrderType(busOrderType);
			acLoanBackLog.setBusEntryType(acDebit.getBusEntryType());
			acLoanBackLogDao.insert(acLoanBackLog);
			acLoanBackLogList.add(acLoanBackLog);
			
			
			// ���շѴ���0 �� �轫���շѴ������˻��л�������������
			if (acDebitSusp.getFeeTotal() > 0) {
				//��ȡ���������˻���Ϣ
				CorpAcct corpAcct = new CorpAcct();
				corpAcct.setBrNo(lnDue.getBrNo());
				corpAcct = corpAcctDao.getByBrNo(corpAcct);
				
				AcLoanLog acLoanLog = new AcLoanLog();
				acLoanLog.setLoanLogNo(ParmBiz.getAcLoanLogNo(conn));
				acLoanLog.setTraceNo(traceNo);
				acLoanLog.setLoanNo(lnDue.getDueNo());
				acLoanLog.setPactNo(lnDue.getPactNo());
				acLoanLog.setBrNo(lnDue.getBrNo());
				acLoanLog.setLoanAmt(acDebitSusp.getFeeTotal());
				acLoanLog.setLoanAcNo(corpAcct.getOpnAcno());
				acLoanLog.setLoanAcType("12");
				acLoanLog.setLoanAcName(corpAcct.getAcName());
				acLoanLog.setLoanBankCode(corpAcct.getExchange());
				acLoanLog.setLoanBankProv(corpAcct.getProvince());
				acLoanLog.setLoanBankCity(corpAcct.getCity());
				acLoanLog.setLoanBankSite(corpAcct.getOpnBank());
				acLoanLog.setLoanSts("01");
				acLoanLog.setTxDate(ParmBiz.getBizDt(conn));
				acLoanLog.setTxTime(ParmBiz.getOracleTxTime(conn));
				if(acDebitSusp.getCardChn()!=null && acDebitSusp.getCardChn().length()>0){//�ϴ��ۿ��ļ���ָ��֧������
					acLoanLog.setCardChn(acDebitSusp.getCardChn());
					acLoanLog.setXtAcNo(projAcct.getAcctNo());
				}else{
					acLoanLog.setCardChn("");
					acLoanLog.setXtAcNo("");
				}
				acLoanLog.setBusEntryType(busOrderType+"02");
				
				acLoanLogDao.insert(acLoanLog);

				acLoanBackLog = new AcLoanBackLog();
				acLoanBackLog.setBackLogNo(backLogNo);
				acLoanBackLog.setBackCnt("2");
				acLoanBackLog.setLoanLogNo(acLoanLog.getLoanLogNo());
				acLoanBackLog.setBackType(PUBConstant.BACK_TYPE_01);
				acLoanBackLog.setBackRes("");
				acLoanBackLog.setFailCaus("");
				acLoanBackLog.setBackSts(PUBConstant.BACK_STS_01);
				acLoanBackLog.setBusOrderType(busOrderType);
				acLoanBackLog.setBusEntryType(acLoanLog.getBusEntryType());
				acLoanBackLogDao.insert(acLoanBackLog);
				acLoanBackLogList.add(acLoanBackLog);
			}
			
			
			acDebitSusp.setDealSts("02");
			acDebitSusp.setSerialNo(acDebit.getDebitNo());
			acDebitSuspDao.update(acDebitSusp);
			
			//���¿ۿ������
			WsRepyClear wsRepyClear = new WsRepyClear();
			wsRepyClear.setWsId(acDebitSusp.getWsId());
			wsRepyClear = wsRepyClearDao.getById(wsRepyClear);
			wsRepyClear.setDealSts("02");
			wsRepyClearDao.update(wsRepyClear);
			
			acTraceLog.setTraceNo(traceNo);
			acTraceLog.setTraceCnt(1);
			acTraceLog.setTxDt(ParmBiz.getOracleTxDate(conn));
			acTraceLog.setTxTime(ParmBiz.getOracleTxTime(conn));
			acTraceLog.setTxBrNo(acDebitSusp.getBrNo());
			acTraceLog.setTxCde(TransCode.LNC4);
			acTraceLog.setSubTxCde(TransCode.LNCL);
			acTraceLog.setSvcInd(TransCode.LNCL);
			acTraceLog.setCurNo(lnDue.getCurNo());
			acTraceLog.setPrdtNo(lnDue.getPrdtNo());
			acTraceLog.setAmt(acDebitSusp.getRepayTotal());
			acTraceLog.setCancelInd(PUBConstant.REV_ROL_NORM);//����
			acTraceLog.setAppSts("01");//����
			acTraceLog.setBrNo(lnDue.getBrNo());
			acTraceLog.setPactNo(lnDue.getPactNo());
			acTraceLog.setLoanNo(lnDue.getDueNo());
			acTraceLog.setMemo("�ۿ���Ϣ�ϴ�");
			
			acTraceLogDao.insert(acTraceLog);
			
			//��������������Ϣ
			CorpBase corpBase = new CorpBase();
			corpBase.setBrNo(wsRepyClear.getBrNo());
			corpBase = corpBaseDao.getById(corpBase);
			//�Թ����㴦��
			if ("01".equals(corpBase.getStateSts())) {
				//���͵�����֧��
				sendZfMes(acLoanBackLogList,lnDue.getProjNo(), traceNo, conn); 
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		finally {
			try {
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void dealClear(WsRepyClear wsRepyClear){
		Connection conn = DBUtils.getConn();
		try{
		//��������������Ϣ
		CorpBase corpBase = new CorpBase();
		corpBase.setBrNo(wsRepyClear.getBrNo());
		corpBase = corpBaseDao.getById(corpBase);
		//�Թ����㴦��
		if ("01".equals(corpBase.getStateSts())) {
		}else{
			AcDebitSusp acDebitSusp = new AcDebitSusp();
			acDebitSusp.setWsId(wsRepyClear.getWsId());
			acDebitSusp = acDebitSuspDao.getById(acDebitSusp);
			
			AcLoanBackLog acLoanBackLog = new AcLoanBackLog();
			acLoanBackLog.setLoanLogNo(acDebitSusp.getSerialNo());
			acLoanBackLog.setBackType("02");
			List<AcLoanBackLog> albList = acLoanBackLogDao.getListByLogNoAndType(acLoanBackLog);
			List<AcLoanBackLog> acLoanBackLogList = acLoanBackLogDao.getListByBackLogNo(albList.get(0));
			//����ʵ�գ���ֱ�ӽ������˶���
			OperaInfo operaInfo = new OperaInfo(conn);
			operaInfo.setTraceCnt(1);
			operaInfo.setBizDt(ParmBiz.getBizDt(conn));
			operaInfo.setTxDt(ParmBiz.getOracleTxDate(conn));
			for(AcLoanBackLog  all:acLoanBackLogList){
				if (PUBConstant.BACK_TYPE_01.equals(all.getBackType())) {// �ſ�
					AcLoanBack acLoanBack = new AcLoanBack();
					acLoanBack.setBackLogNo(all.getBackLogNo());
					acLoanBack.setBackCnt(all.getBackCnt());
					acLoanBack.setBackRes("01");
					acLoanBack.setFailCaus("��ǰ������´���");
					try {
						acLoanBack.setBackDate(ParmBiz.getOracleUpDate(conn));
					} catch (AccountingException e) {
						e.printStackTrace();
					}
					acLoanBack.setTxDt(ParmBiz.getOracleTxDate(conn));
					Operation op = (Operation) OperationFactory
							.getFactoryInstance()
							.getOperation(TransCode.C3BK, conn);
					op.execute(acLoanBack);
				} else if (PUBConstant.BACK_TYPE_02.equals(all.getBackType())) {// �ۿ�
					RepayBiz.acDebitBack(all.getBackLogNo(),all.getBackCnt(), "01","����ʵ�մ���ɹ�", operaInfo,"15000","");
				} 
			}
		}
		}catch(Exception e){
			throw new ServiceException(e.getMessage());
		}finally{
			if(conn!=null)
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}
	/**
	 * 
	 * @throws AccountingException 
	 * @throws Exception_Exception 
	 * @throws IOException 
	 * @throws SQLException 
	 * @���� DHCC-LIUJ
	 * @���� 2016-9-14
	 * @����	���͵�����֧���ſ�
	 */
	public  Map sendZfMes(List<AcLoanBackLog> acLoanBackLogList,String projNo,String traceNo,Connection conn) throws AccountingException, Exception_Exception, IOException, SQLException {

		return null ;
	}
	public void updateBack(int status,String dealDesc,List<AcLoanLog> acLoanLogList,List<AcDebit> acDebitList,List<AcLoanBackLog> acLoanBackLogList,Connection conn){
		if(status>=10000&&status<20000){//���ͳɹ�
			for(AcLoanLog acLoanLog1 : acLoanLogList){
				acLoanLog1.setLoanSts("02");
				try {
					acLoanLog1.setUpDate(ParmBiz.getOracleUpDate(conn));
				} catch (AccountingException e) {
					e.printStackTrace();
				}
				acLoanLogDao.update(acLoanLog1);
			}
			for(AcDebit acDebit1 : acDebitList){
				acDebit1.setSts("02");//�ѷ���
				acDebitDao.update(acDebit1);
			}
		}else{
			for(AcLoanLog acLoanLog1 : acLoanLogList){
				acLoanLog1.setLoanSts("05");
				try {
					acLoanLog1.setUpDate(ParmBiz.getOracleUpDate(conn));
				} catch (AccountingException e) {
					e.printStackTrace();
				}
				acLoanLogDao.update(acLoanLog1);
			}
			for(AcDebit acDebit1 : acDebitList){
				acDebit1.setSts("05");//����ʧ��
				acDebitDao.update(acDebit1);
				AcDebitSusp acDebitSusp = new AcDebitSusp();
				acDebitSusp.setSerialNo(acDebit1.getDebitNo());
				acDebitSusp = acDebitSuspDao.getBySerialNo(acDebitSusp);
				WsRepyClear wsRepyClear = new WsRepyClear();
				wsRepyClear.setWsId(acDebitSusp.getWsId());
				wsRepyClear.setDealSts("05");
				wsRepyClear.setDealDesc(dealDesc.length()>60?dealDesc.substring(0,30):dealDesc);
				wsRepyClearDao.updateSts(wsRepyClear);
			}
			for(AcLoanBackLog acLoanBackLog : acLoanBackLogList){
				acLoanBackLog.setBackSts("02");//����ʧ��
				acLoanBackLog.setBackRes("02");
				acLoanBackLog.setFailCaus("����ʧ��");
				acLoanBackLogDao.updateSts(acLoanBackLog);
			}
		}
	}
	public void update(AftRepyClear aftRepyClear) throws ServiceException {
		try {
			aftRepyClearDao.update(aftRepyClear);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}


	 /**

  * @description ��xml�ַ���ת����map

  * @param xml

  * @return Map

  */

	public static Map readStringXmlOut(String xml) {

		Map map = new HashMap();

		Document doc = null;

		try {
			doc = DocumentHelper.parseText(xml); // ���ַ���תΪXML

			Element rootElt = doc.getRootElement(); // ��ȡ���ڵ�

			Iterator iter = rootElt.elementIterator("Header"); // ��ȡ���ڵ��µ��ӽڵ�header

			Element recordEle = (Element) iter.next();

			String RequestType = recordEle.elementTextTrim("RequestType");
			map.put("RequestType", RequestType);

			String UUID = recordEle.elementTextTrim("UUID");
			map.put("UUID", UUID);

			String ComId = recordEle.elementTextTrim("ComId");
			map.put("ComId", ComId);

			String SendTime = recordEle.elementTextTrim("SendTime");
			map.put("SendTime", SendTime);

			String Signed = recordEle.elementTextTrim("Signed");
			map.put("Signed", Signed);

			String ResultCode = recordEle.elementTextTrim("ResultCode");
			map.put("ResultCode", ResultCode);

			String ResultMsg = recordEle.elementTextTrim("ResultMsg");
			map.put("ResultMsg", ResultMsg);

		} catch (DocumentException e) {

			e.printStackTrace();

		} catch (Exception e) {

			e.printStackTrace();

		}

		return map;

	}
	
	
	public AftRepyClearDao getAftRepyClearDao() {
		return aftRepyClearDao;
	}

	public void setAftRepyClearDao(AftRepyClearDao aftRepyClearDao) {
		this.aftRepyClearDao = aftRepyClearDao;
	}

	public AcLnMstDao getAcLnMstDao() {
		return acLnMstDao;
	}

	public AcLnRepayPlnCurDao getAcLnRepayPlnCurDao() {
		return acLnRepayPlnCurDao;
	}

	public WsRepyClearDao getWsRepyClearDao() {
		return wsRepyClearDao;
	}

	public void setAcLnMstDao(AcLnMstDao acLnMstDao) {
		this.acLnMstDao = acLnMstDao;
	}

	public void setAcLnRepayPlnCurDao(AcLnRepayPlnCurDao acLnRepayPlnCurDao) {
		this.acLnRepayPlnCurDao = acLnRepayPlnCurDao;
	}

	public void setWsRepyClearDao(WsRepyClearDao wsRepyClearDao) {
		this.wsRepyClearDao = wsRepyClearDao;
	}

	public LnDueDao getLnDueDao() {
		return lnDueDao;
	}

	public LnAcctDao getLnAcctDao() {
		return lnAcctDao;
	}

	public AcDebitSuspDao getAcDebitSuspDao() {
		return acDebitSuspDao;
	}

	public AcTraceLogDao getAcTraceLogDao() {
		return acTraceLogDao;
	}

	public ProjAcctDao getProjAcctDao() {
		return projAcctDao;
	}

	public AcDebitDao getAcDebitDao() {
		return acDebitDao;
	}

	public AcLoanBackLogDao getAcLoanBackLogDao() {
		return acLoanBackLogDao;
	}

	public CorpAcctDao getCorpAcctDao() {
		return corpAcctDao;
	}

	public AcLoanLogDao getAcLoanLogDao() {
		return acLoanLogDao;
	}

	public void setLnDueDao(LnDueDao lnDueDao) {
		this.lnDueDao = lnDueDao;
	}

	public void setLnAcctDao(LnAcctDao lnAcctDao) {
		this.lnAcctDao = lnAcctDao;
	}

	public void setAcDebitSuspDao(AcDebitSuspDao acDebitSuspDao) {
		this.acDebitSuspDao = acDebitSuspDao;
	}

	public void setAcTraceLogDao(AcTraceLogDao acTraceLogDao) {
		this.acTraceLogDao = acTraceLogDao;
	}

	public void setProjAcctDao(ProjAcctDao projAcctDao) {
		this.projAcctDao = projAcctDao;
	}

	public void setAcDebitDao(AcDebitDao acDebitDao) {
		this.acDebitDao = acDebitDao;
	}

	public void setAcLoanBackLogDao(AcLoanBackLogDao acLoanBackLogDao) {
		this.acLoanBackLogDao = acLoanBackLogDao;
	}

	public void setCorpAcctDao(CorpAcctDao corpAcctDao) {
		this.corpAcctDao = corpAcctDao;
	}

	public void setAcLoanLogDao(AcLoanLogDao acLoanLogDao) {
		this.acLoanLogDao = acLoanLogDao;
	}

	public WsBaseDao getWsBaseDao() {
		return wsBaseDao;
	}

	public void setWsBaseDao(WsBaseDao wsBaseDao) {
		this.wsBaseDao = wsBaseDao;
	}

	public ProjBase getProjBase() {
		return projBase;
	}

	public void setProjBase(ProjBase projBase) {
		this.projBase = projBase;
	}

	public ProjBaseDao getProjBaseDao() {
		return projBaseDao;
	}

	public void setProjBaseDao(ProjBaseDao projBaseDao) {
		this.projBaseDao = projBaseDao;
	}

	public WsRepyFineDao getWsRepyFineDao() {
		return wsRepyFineDao;
	}

	public AcLnLoDao getAcLnLoDao() {
		return acLnLoDao;
	}

	public AcLnRepayPlnDao getAcLnRepayPlnDao() {
		return acLnRepayPlnDao;
	}

	public void setWsRepyFineDao(WsRepyFineDao wsRepyFineDao) {
		this.wsRepyFineDao = wsRepyFineDao;
	}

	public void setAcLnLoDao(AcLnLoDao acLnLoDao) {
		this.acLnLoDao = acLnLoDao;
	}

	public void setAcLnRepayPlnDao(AcLnRepayPlnDao acLnRepayPlnDao) {
		this.acLnRepayPlnDao = acLnRepayPlnDao;
	}

	public CorpBaseDao getCorpBaseDao() {
		return corpBaseDao;
	}

	public void setCorpBaseDao(CorpBaseDao corpBaseDao) {
		this.corpBaseDao = corpBaseDao;
	}
}