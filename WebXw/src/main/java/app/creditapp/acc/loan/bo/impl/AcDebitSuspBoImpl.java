package app.creditapp.acc.loan.bo.impl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import redis.clients.jedis.Jedis;
import accounting.biz.loan.RepayBiz;
import accounting.biz.pub.ParmBiz;
import accounting.domain.sys.OperaInfo;
import accounting.interf.loan.AcLoanBack;
import accounting.plat.PUBConstant;
import accounting.plat.TransCode;
import accounting.plat.core.AccountingException;
import accounting.plat.core.Operation;
import accounting.plat.core.OperationFactory;
import accounting.plat.dao.JdbcDao;
import accounting.plat.util.NumberUtil;
import app.base.BaseService;
import app.base.CreateKey;
import app.base.ServiceException;
import app.base.SourceTemplate;
import app.creditapp.acc.dao.WsRepyFeeDao;
import app.creditapp.acc.entity.WsRepyFee;
import app.creditapp.acc.loan.bo.AcDebitSuspBo;
import app.creditapp.acc.loan.dao.AcDebitDao;
import app.creditapp.acc.loan.dao.AcDebitSuspDao;
import app.creditapp.acc.loan.dao.AcLnLoDao;
import app.creditapp.acc.loan.dao.AcLnMstDao;
import app.creditapp.acc.loan.dao.AcLnPmLogDao;
import app.creditapp.acc.loan.dao.AcLnRepayPlnCurDao;
import app.creditapp.acc.loan.dao.AcLoanBackLogDao;
import app.creditapp.acc.loan.dao.AcLoanLogDao;
import app.creditapp.acc.loan.entity.AcDebit;
import app.creditapp.acc.loan.entity.AcDebitSusp;
import app.creditapp.acc.loan.entity.AcLnLo;
import app.creditapp.acc.loan.entity.AcLnMst;
import app.creditapp.acc.loan.entity.AcLnPmLog;
import app.creditapp.acc.loan.entity.AcLnRepayPlnCur;
import app.creditapp.acc.loan.entity.AcLoanBackLog;
import app.creditapp.acc.loan.entity.AcLoanLog;
import app.creditapp.acc.log.dao.AcChrgLogDao;
import app.creditapp.acc.log.dao.AcTraceLogDao;
import app.creditapp.acc.log.entity.AcChrgLog;
import app.creditapp.acc.log.entity.AcTraceLog;
import app.creditapp.acc.option.dao.AcLnRepayPlnDao;
import app.creditapp.acc.option.entity.AcLnRepayPln;
import app.creditapp.aft.dao.AftRepyClearDao;
import app.creditapp.aft.entity.AftRepyClear;
import app.creditapp.corp.dao.CorpAcctDao;
import app.creditapp.corp.entity.CorpAcct;
import app.creditapp.inf.client.QueryService;
import app.creditapp.inf.client.XMLUtil;
import app.creditapp.inf.client.ZFHead;
import app.creditapp.inf.client.ZFHeadQuery;
import app.creditapp.inf.client.ZfBodyQuery;
import app.creditapp.inf.client.zf.AccountInfo;
import app.creditapp.inf.client.zf.BodyLoan;
import app.creditapp.inf.client.zf.EntryInfo;
import app.creditapp.inf.client.zf.Exception_Exception;
import app.creditapp.inf.client.PayInfo;
import app.creditapp.inf.client.zf.SourceAccountInfo;
import app.creditapp.inf.client.zf.TargetAccountInfo;
import app.creditapp.inf.client.zf.TradeInfo;
import app.creditapp.inf.client.zf.ZfB100003;
import app.creditapp.inf.client.zf.ZfB100007;
import app.creditapp.inf.dao.WsBaseDao;
import app.creditapp.inf.dao.WsRepyClearDao;
import app.creditapp.inf.dao.WsRepyFineDao;
import app.creditapp.inf.dao.WsRepyMesDao;
import app.creditapp.inf.entity.WsBase;
import app.creditapp.inf.entity.WsIn2102;
import app.creditapp.inf.entity.WsRepyClear;
import app.creditapp.inf.entity.WsRepyMes;
import app.creditapp.ln.dao.LnAcctDao;
import app.creditapp.ln.dao.LnDueDao;
import app.creditapp.ln.entity.LnAcct;
import app.creditapp.ln.entity.LnDue;
import app.creditapp.proj.dao.ProjAcctDao;
import app.creditapp.proj.dao.ProjBaseDao;
import app.creditapp.proj.entity.ProjBase;
import app.creditapp.redis.util.RedisUtil;
import app.oscache.CachecodeUtil;
import app.util.DBUtils;
import app.util.DateUtil;
import app.util.toolkit.Ipage;

/**
 * Title: AcDebitSuspBoImplImpl.java Description:
 * 
 **/
public class AcDebitSuspBoImpl extends BaseService implements AcDebitSuspBo {
	Logger logger = Logger.getLogger(AcDebitSuspBoImpl.class);
	private AcDebitSuspDao acDebitSuspDao;
	private AcLnRepayPlnCurDao acLnRepayPlnCurDao;
	private WsRepyMesDao wsRepyMesDao;
	private AcLnMstDao acLnMstDao;
	private AcLnLoDao acLnLoDao;
	private AftRepyClearDao aftRepyClearDao;
	private AcTraceLogDao acTraceLogDao;
	private DataSource dataSource;
	private LnDueDao lnDueDao;
	private AcDebitDao acDebitDao;
	private ProjAcctDao projAcctDao;
	private AcLoanBackLogDao acLoanBackLogDao;
	private CorpAcctDao corpAcctDao;
	private LnAcctDao lnAcctDao;
	private AcLoanLogDao acLoanLogDao;
	private WsBaseDao wsBaseDao;
	private AcLnPmLogDao acLnPmLogDao;
	private AcChrgLogDao acChrgLogDao;
	private AcLnRepayPlnDao acLnRepayPlnDao;
	private AcDebit acDebit;
	private ProjBase projBase;
	private WsRepyMes wsRepyMes;
	private ProjBaseDao projBaseDao;
	private WsRepyFineDao wsRepyFineDao;
	private WsRepyFeeDao wsRepyFeeDao;
	private WsRepyClearDao wsRepyClearDao;

	/**
	 * �ۿ�ҵ�񵥱ʲ�ѯ
	 */
	public void querySingleMes(WsRepyMes wsRepyMes){
		Connection conn = DBUtils.getConn();
		try {
			wsRepyMes = wsRepyMesDao.getByBatchAndPactNo(wsRepyMes);

			// ��ѯ������ۿ���Ϣ�ϴ�
			AcDebitSusp acDebitSusp = new AcDebitSusp();
			acDebitSusp.setWsId(wsRepyMes.getWsId());
			acDebitSusp = acDebitSuspDao.getById(acDebitSusp);

			// ��ѯ������ϸ
			AcDebit acDebit = new AcDebit();
			acDebit.setDebitNo(acDebitSusp.getSerialNo());
			acDebit = acDebitDao.getByDebitNo(acDebit);

			// ��ѯ����֧����Ŀ��Ϣ
			AcLoanBackLog acLoanBackLog = new AcLoanBackLog();
			acLoanBackLog.setLoanLogNo(acDebitSusp.getSerialNo());
			acLoanBackLog.setBackType(PUBConstant.BACK_TYPE_02);
			List<AcLoanBackLog> acLoanBackLogList = acLoanBackLogDao
					.getListByLogNoAndType(acLoanBackLog);
			// ѭ������֧�����ʲ�ѯ����
			Map returnMap = null;
			for (AcLoanBackLog albl : acLoanBackLogList) {
				returnMap = sendZfB100003(acDebit.getTraceNo(), albl);
				String resultSts = (String) returnMap.get("Status");//����״̬
				String resultMessage = (String) returnMap.get("Message");//����������Ϣ
				if (resultSts != null && resultSts.length() > 0) {
				//�ֵ�ת��
				if("1".equals(resultSts)){//���سɹ�
					resultSts="01";
				}else if("0".equals(resultSts) || "6".equals(resultSts)){//δ��
					resultSts="03";
				}else{//������Ϊʧ��
					resultSts="02";
				}
				albl.setBackSts(resultSts);
				albl.setFailCaus(resultMessage);
				
				if(albl.getBackRes()==null || albl.getBackRes().length()==0){//ԭ֧��δ�ص�
					//�൱��֧��������������
					dealZfBack(albl,conn);
				}else if(albl.getBackRes().equals("03") && (resultSts.equals("01") || resultSts.equals("02"))){//ԭδ�����ֳɹ���ʧ��
					//�൱��֧��������������
					dealZfBack(albl,conn);
				}else if(albl.getBackRes().equals("02") && (resultSts.equals("01") || resultSts.equals("03"))){//ԭʧ�ܣ��ֳɹ���δ��
					//�൱��֧��������������
					dealZfBack(albl,conn);
				}else if(albl.getBackRes().equals("01") && (resultSts.equals("02") || resultSts.equals("03"))){//ԭ�ɹ�����ʧ�ܻ�δ��
					//����
					reverseZfBack(albl,resultSts,conn);
				}
				}
			}
			conn.commit();
		}  catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	

	/**
	 * ��ǰ������ʲ�ѯ
	 */
	public void querySingleClear(WsRepyClear wsRepyClear){
		Connection conn = DBUtils.getConn();
		try {
			wsRepyClear = wsRepyClearDao.getDealIngByPactno(wsRepyClear);
			if(wsRepyClear==null || "".equals(wsRepyClear)){
				
			}else{
				
				// ��ѯ��������ǰ����ۿ���Ϣ�ϴ�
				AcDebitSusp acDebitSusp = new AcDebitSusp();
				acDebitSusp.setWsId(wsRepyClear.getWsId());
				acDebitSusp = acDebitSuspDao.getById(acDebitSusp);

				// ��ѯ������ϸ
				AcDebit acDebit = new AcDebit();
				acDebit.setDebitNo(acDebitSusp.getSerialNo());
				acDebit = acDebitDao.getByDebitNo(acDebit);

				// ��ѯ����֧����Ŀ��Ϣ
				AcLoanBackLog acLoanBackLog = new AcLoanBackLog();
				acLoanBackLog.setLoanLogNo(acDebitSusp.getSerialNo());
				acLoanBackLog.setBackType(PUBConstant.BACK_TYPE_02);
				List<AcLoanBackLog> acLoanBackLogList = acLoanBackLogDao
						.getListByLogNoAndType(acLoanBackLog);
				// ѭ������֧�����ʲ�ѯ����
				Map returnMap = null;
				for (AcLoanBackLog albl : acLoanBackLogList) {
					returnMap = sendZfB100003(acDebit.getTraceNo(), albl);
					if (returnMap==null){
						System.out.println("loanLogNo=["+albl.getLoanLogNo()+"],backLogNo=["+albl.getBackLogNo()+"]");
						continue;
					}
					String resultSts = (String) returnMap.get("Status");//����״̬
					String resultMessage = (String) returnMap.get("Message");//����������Ϣ
					if (resultSts != null && resultSts.length() > 0) {
					//�ֵ�ת��
					if("1".equals(resultSts)){//���سɹ�
						resultSts="01";
					}else if("0".equals(resultSts) || "6".equals(resultSts)){//δ��
						resultSts="03";
					}else{//������Ϊʧ��
						resultSts="02";
					}
					albl.setBackSts(resultSts);
					albl.setFailCaus(resultMessage);
					
					if(albl.getBackRes()==null || albl.getBackRes().length()==0){//ԭ֧��δ�ص�
						//�൱��֧��������������
						dealZfBack(albl,conn);
					}else if(albl.getBackRes().equals("03") && (resultSts.equals("01") || resultSts.equals("02"))){//ԭδ�����ֳɹ���ʧ��
						//�൱��֧��������������
						dealZfBack(albl,conn);
					}else if(albl.getBackRes().equals("02") && (resultSts.equals("01") || resultSts.equals("03"))){//ԭʧ�ܣ��ֳɹ���δ��
						//�൱��֧��������������
						dealZfBack(albl,conn);
					}else if(albl.getBackRes().equals("01") && (resultSts.equals("02") || resultSts.equals("03"))){//ԭ�ɹ�����ʧ�ܻ�δ��
						//����
						reverseZfBack(albl,resultSts,conn);
					}
					}
				}
				conn.commit();
				
			}
			
		}  catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * �������ʲ�ѯ
	 */
	public void querySingleLoan(WsIn2102 wsIn2102){
		Connection conn = DBUtils.getConn();
		try {
			//��ȡ�������ļ�
			AcLnMst acLnMst = new AcLnMst();
			acLnMst.setPactNo(wsIn2102.getPactNo());
			acLnMst.setBrNo(wsIn2102.getBrNo());
			acLnMst = acLnMstDao.getByPactNo(acLnMst);
			//�ж����ļ��Ƿ���ڣ����˹�������ʱ�򲻻��������ļ�
			if(acLnMst == null ){
				
			}else{
				//��ȡ�ô���ſ���־
				AcTraceLog acTraceLog = new AcTraceLog();
				acTraceLog.setLoanNo(acLnMst.getLoanNo());
				acTraceLog.setTxCde("LNC3");
				acTraceLog = acTraceLogDao.getByLoanNoAndTxCde(acTraceLog);
				
				//��ȡ�ſ���ˮ
				AcLoanLog acLoanLog = new AcLoanLog();
				acLoanLog.setTraceNo(acTraceLog.getTraceNo());
				List<AcLoanLog> acLoanLogList = acLoanLogDao.getListByTraceNo(acLoanLog);
				
				for(AcLoanLog all : acLoanLogList){
				// ��ѯ����֧����Ŀ��Ϣ
				AcLoanBackLog acLoanBackLog = new AcLoanBackLog();
				acLoanBackLog.setLoanLogNo(all.getLoanLogNo());
				acLoanBackLog.setBackType(PUBConstant.BACK_TYPE_01);
				List<AcLoanBackLog> acLoanBackLogList = acLoanBackLogDao
						.getListByLogNoAndType(acLoanBackLog);
				// ѭ������֧�����ʲ�ѯ����
				Map returnMap = null;
				for (AcLoanBackLog albl : acLoanBackLogList) {
					returnMap = sendZfB100003(acLoanLog.getTraceNo(), albl);
					String resultSts = (String) returnMap.get("Status");//����״̬
					String resultMessage = (String) returnMap.get("Message");//����������Ϣ
						//�ų�֧������ϸ���
						if (resultSts != null && resultSts.length() > 0) {
							// �ֵ�ת��
							if ("1".equals(resultSts)) {// ���سɹ�
								resultSts = "01";
							} else if ("0".equals(resultSts) || "6".equals(resultSts)) {// δ��
								resultSts = "03";
							} else {// ������Ϊʧ��
								resultSts = "02";
							}
							albl.setBackSts(resultSts);
							albl.setFailCaus(resultMessage);
							if (albl.getBackRes() == null || albl.getBackRes().length() == 0) {// ԭ֧��δ�ص�
								// �൱��֧��������������
								dealZfBack(albl, conn);
							} else if (albl.getBackRes().equals("03") && (resultSts.equals("01") || resultSts.equals("02"))) {// ԭδ�����ֳɹ���ʧ��
								// �൱��֧��������������
								dealZfBack(albl, conn);
							} else if (albl.getBackRes().equals("02") && (resultSts.equals("01") || resultSts.equals("03"))) {// ԭʧ�ܣ��ֳɹ���δ��
								// �൱��֧��������������
								dealZfBack(albl, conn);
							} else if (albl.getBackRes().equals("01") && (resultSts.equals("02") || resultSts.equals("03"))) {// ԭ�ɹ�����ʧ�ܻ�δ��
								// ����
								reverseZfBack(albl, resultSts, conn);
							}
						}
				}
				}
			}
			
			
			conn.commit();
		}  catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * 
	 * @���� DHCC-LIUJ
	 * @���� 2016-9-30
	 * @����	����֧������--���ʶ���
	 */
	public void dealZfBack(AcLoanBackLog acLoanBackLog,Connection conn) throws Exception{
		if (PUBConstant.BACK_TYPE_01
				.equals(acLoanBackLog.getBackType())) {// �ſ�
			AcLoanBack acLoanBack = new AcLoanBack();
			acLoanBack.setBackLogNo(acLoanBackLog.getBackLogNo());
			acLoanBack.setBackCnt(acLoanBackLog.getBackCnt());
			acLoanBack.setBackRes(acLoanBackLog.getBackRes());
			acLoanBack.setFailCaus(acLoanBackLog.getFailCaus());
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
		} else if (PUBConstant.BACK_TYPE_02.equals(acLoanBackLog
				.getBackType())) {// �ۿ�
			OperaInfo operaInfo = new OperaInfo(conn);
			operaInfo.setTraceCnt(1);
			operaInfo.setTraceNo(ParmBiz.getTraceNo(conn));
			operaInfo.setBizDt(ParmBiz.getBizDt(conn));
			operaInfo.setTxDt(ParmBiz.getOracleTxDate(conn));
			RepayBiz.acDebitBack(acLoanBackLog.getBackLogNo(),
					acLoanBackLog.getBackCnt(), acLoanBackLog.getBackRes(), acLoanBackLog.getFailCaus(),
					operaInfo,acLoanBackLog.getStatus(),acLoanBackLog.getCardChn());
		} 
	}
	
	/**
	 * 
	 * @throws AccountingException 
	 * @���� DHCC-LIUJ
	 * @���� 2016-10-1
	 * @����	�ſ��ۿ���������в�δ����ɹ���֮ǰ���سɹ����س�
	 */
	
	public void reverseZfBack(AcLoanBackLog acLoanBackLog , String resultSts , Connection conn) throws AccountingException{
		if(PUBConstant.BACK_TYPE_02.equals(acLoanBackLog.getBackType())){//�ۿ�
			//��ѯ�ۿ��¼
			AcDebit acDebit = new AcDebit();
			acDebit.setDebitNo(acLoanBackLog.getLoanLogNo());
			acDebit = acDebitDao.getByDebitNo(acDebit);
			AcLnPmLog acLnPmLog = new AcLnPmLog();
			acLnPmLog.setTraceNo(acDebit.getTraceNo());
			acLnPmLog.setLoanNo(acDebit.getLoanNo());
			List<AcLnPmLog> acLnPmLogList = acLnPmLogDao.getListByTraceNoAndLoanNo(acLnPmLog);
			for(AcLnPmLog alpl : acLnPmLogList){
				if(alpl.getChrgId()!=null && alpl.getChrgId().length()>0){//���ڷ��ñ�ţ���˵���û����ǻ�����
					AcChrgLog acChrgLog = new AcChrgLog();
					acChrgLog.setChrgId(alpl.getChrgId());
					acChrgLog = acChrgLogDao.getById(acChrgLog);
					acChrgLog.setRepayChrgAmt(acChrgLog.getRepayChrgAmt()-alpl.getRepayFeeAmt());
					acChrgLog.setChrgSts("01");
					acChrgLogDao.update(acChrgLog);
				}else{//����Ϊ������������
					AcLnRepayPln acLnRepayPln = new AcLnRepayPln();
					acLnRepayPln.setLoanNo(alpl.getLoanNo());
					acLnRepayPln.setPerdNo(Integer.parseInt(alpl.getPerdNo()));
					acLnRepayPln = acLnRepayPlnDao.getById(acLnRepayPln);
					
					//�ع�����ƻ�ʵ��
					acLnRepayPln.setRepayPrcpAmt(acLnRepayPln.getRepayPrcpAmt()-alpl.getRepayPrcpAmt());
					acLnRepayPln.setRepayNormInt(acLnRepayPln.getRepayNormInt()-alpl.getRepayNormInt());
					acLnRepayPln.setRepayFineInt(acLnRepayPln.getRepayFineInt()-alpl.getRepayFineInt());
					acLnRepayPlnDao.update(acLnRepayPln);
					
					//�ع����ڻ���ƻ�
					AcLnRepayPlnCur acLnRepayPlnCur = new AcLnRepayPlnCur();
					acLnRepayPlnCur.setLoanNo(alpl.getLoanNo());
					acLnRepayPlnCur = acLnRepayPlnCurDao.getById(acLnRepayPlnCur);
					if(acLnRepayPlnCur != null && Integer.parseInt(alpl.getPerdNo())==acLnRepayPlnCur.getPerdNo()){
						acLnRepayPlnCur.setRepayPrcpAmt(acLnRepayPlnCur.getRepayPrcpAmt()-alpl.getRepayPrcpAmt());
						acLnRepayPlnCur.setRepayNormInt(acLnRepayPlnCur.getRepayNormInt()-alpl.getRepayNormInt());
					}
					
					//�ع�Ƿ��
					AcLnLo acLnLo = new AcLnLo();
					acLnLo.setLoanNo(alpl.getLoanNo());
					acLnLo.setPerdNo(Integer.getInteger(alpl.getPerdNo()));
					acLnLo = acLnLoDao.getById(acLnLo);
					if(acLnLo != null){
						acLnLo.setRepayPrcpAmt(acLnLo.getRepayPrcpAmt()-alpl.getRepayPrcpAmt());
						acLnLo.setRepayNormInt(acLnLo.getRepayNormInt()-alpl.getRepayNormInt());
						acLnLo.setRepayFineInt(acLnLo.getRepayFineInt()-alpl.getRepayFineInt());
						acLnLoDao.update(acLnLo);
					}
				}
			}
			//���·ſ�ۿ�֧����ϸ��
			acLoanBackLog.setBackRes(resultSts);
			acLoanBackLog.setBackSts("02");
			acLoanBackLog.setBackDate(ParmBiz.getOracleTxDate(conn));
			acLoanBackLogDao.update(acLoanBackLog);
			//���¿ۿ���Ϣ��
			if("03".equals(resultSts)){//δ��
				acDebit.setSts("06");
			}else if("02".equals(resultSts)){//����ʧ��
				acDebit.setSts("04");//�ۿ�ʧ��
			}
			acDebit.setRtnDt(ParmBiz.getOracleTxDate(conn));
			acDebit.setRtnTime(ParmBiz.getOracleTxTime(conn));
			acDebitDao.update(acDebit);
			
			AcDebitSusp acDebitSusp = new AcDebitSusp();
			acDebitSusp.setSerialNo(acDebit.getDebitNo());
			acDebitSusp = acDebitSuspDao.getBySerialNo(acDebitSusp);
			if(acDebitSusp != null){//��Ϊ��ʱ����˵���ǿۿ�ӿ��ϴ��ۿ��ļ�������¿ۿ������״̬
				if("03".equals(resultSts)){//δ��
					acDebitSusp.setDealSts("02");
				}else if("02".equals(resultSts)){//����ʧ��
					acDebitSusp.setDealSts("04");
				}
				acDebitSuspDao.update(acDebitSusp);
				
				WsRepyMes wsRepyMes = new WsRepyMes();
				wsRepyMes.setWsId(acDebitSusp.getWsId());
				wsRepyMes = wsRepyMesDao.getById(wsRepyMes);
				//�ۿ��ļ��ϴ��������
				if(wsRepyMes!=null){
					if("03".equals(resultSts)){//δ��
						wsRepyMes.setDealSts("02");
					}else if("02".equals(resultSts)){//����ʧ��
						wsRepyMes.setDealSts("04");
					}
					wsRepyMesDao.update(wsRepyMes);
				}
				
				WsRepyClear wsRepyClear = new WsRepyClear();
				wsRepyClear.setWsId(acDebitSusp.getWsId());
				wsRepyClear = wsRepyClearDao.getById(wsRepyClear);
				//��ǰ����������
				if(wsRepyClear != null){
					if("03".equals(resultSts)){//δ��
						wsRepyClear.setDealSts("02");
					}else if("02".equals(resultSts)){//����ʧ��
						wsRepyClear.setDealSts("04");
					}
					wsRepyClearDao.update(wsRepyClear);
				}
			}
		}else{//�ſ�ɹ�����
			AcLoanLog acLoanLog = new AcLoanLog();
			acLoanLog.setLoanLogNo(acLoanBackLog.getLoanLogNo());
			acLoanLog = acLoanLogDao.getById(acLoanLog);
			if("02".equals(resultSts)){//ʧ��
				acLoanLog.setLoanSts("04");
			}else if("03".equals(resultSts)){//δ��
				acLoanLog.setLoanSts("06");
			}
			acLoanLog.setUpDate(ParmBiz.getOracleTxDate(conn));
			acLoanLogDao.update(acLoanLog);
			
			AcLnMst acLnMst = new AcLnMst();
			acLnMst.setLoanNo(acLoanLog.getLoanNo());
			acLnMst = acLnMstDao.getById(acLnMst);
			
			LnDue lnDue = new LnDue();
			lnDue.setDueNo(acLnMst.getLoanNo());
			lnDue = lnDueDao.getById(lnDue);
			
			//��ȡ�ſ��˻���Ϣ
			LnAcct lnAcct = new LnAcct();
			lnAcct.setAppId(lnDue.getAppId());
			lnAcct.setAcUse("2");
			lnAcct.setAcNo(acLoanLog.getLoanNo());
			lnAcct = lnAcctDao.getById(lnAcct);
			
			if ("00101".equals(acLoanBackLog.getBusEntryType())
					|| "00201".equals(acLoanBackLog.getBusEntryType())
					|| "00301".equals(acLoanBackLog.getBusEntryType())) {// �ſ�				
				double exact = 0.0001;//��ȷС��
				if((acLnMst.getLoanBal()-acLoanLog.getLoanAmt())<exact && (acLnMst.getLoanBal()-acLoanLog.getLoanAmt())>-exact ){//
					acLnMst.setDealSts("04");
				}else{
					acLnMst.setDealSts("05");
				}
				acLnMst.setLoanBal(acLnMst.getLoanBal()-acLoanLog.getLoanAmt());
				acLnMst.setLoanSts("");
				acLnMst.setFailCaus(acLoanBackLog.getFailCaus().length()>60?acLoanBackLog.getFailCaus().substring(0,30):acLoanBackLog.getFailCaus());
				acLnMst.setUpDt(ParmBiz.getBizDt(conn));
				
				acLnMstDao.update(acLnMst);
			}else{//�ŷ�
				AcChrgLog acChrgLog = new AcChrgLog();
				acChrgLog.setTraceNo(acLoanLog.getTraceNo());
				List<AcChrgLog> acChrgLogList = acChrgLogDao.getListByTraceno(acChrgLog);
				double feeAmt = acLoanLog.getLoanAmt();
				for(AcChrgLog acl : acChrgLogList){
					if(feeAmt>0.0001 && NumberUtil.isAmtGreat(feeAmt,acl.getRepayChrgAmt())){
						acl.setPayChrgAmt(0.00);
						acl.setChrgSts("02");
						feeAmt = feeAmt - acl.getRepayChrgAmt();
					}else{
						acl.setPayChrgAmt(0.00);
						acl.setChrgSts("02");
						feeAmt = 0.00;
					}
					acChrgLogDao.update(acl);
				}
				
			}
		}
	}
	/**
	 * 
	 * @throws AccountingException 
	 * @���� DHCC-LIUJ
	 * @���� 2016-9-30
	 * @����	����֧�����ʲ�ѯ����
	 */
	public  Map sendZfB100003(String traceNo,AcLoanBackLog acLoanBackLog) throws AccountingException{
		Connection conn = DBUtils.getConn();
		//��������
		Map returnMap = null;
		try {
			ZFHead zfHead = new ZFHead();
			zfHead.setRequestType("B100003");
			zfHead.setUUID(traceNo);// ������ˮ��
			zfHead.setComId(CachecodeUtil.MFSPREFIX);
			zfHead.setComIP("11");
			zfHead.setSendTime(ParmBiz.getOracleUpDate2(conn));
			zfHead.setAsyn("0");
			zfHead.setReturnUrl("");
			zfHead.setSigned("");
			zfHead.setClientType("0");
			zfHead.setPayCount(1);
			String headXml = XMLUtil.createHead(zfHead); // ͷ�ļ�

			ZfB100003 zfB100003 = new ZfB100003();
			zfB100003.setBatchNo(traceNo);
			zfB100003.setOrderNo(acLoanBackLog.getBackLogNo());
			zfB100003.setEntryNo(acLoanBackLog.getBackCnt());
			String bodyXml = XMLUtil.createBody(zfB100003);// ת��ΪXML

			String xml = headXml + bodyXml + "</Package>";

			WsBase wsBase = new WsBase();
			wsBase.setWsDate(ParmBiz.getOracleTxDate(conn));
			wsBase.setWsTime(ParmBiz.getOracleUpDate(conn));
			wsBase.setTxCode("B100003");
			wsBase.setWsSerial(traceNo);
			wsBase.setRespDesc("���ʽ��ײ�ѯ");
			wsBase.setWsSts("01");
			wsBase.setReqContent(xml);
			wsBase.setRespContent("");
			wsBaseDao.insert(wsBase);
			
			QueryService queryService = (QueryService) SourceTemplate
					.getSpringContextInstance().getBean("queryService");
			String result = "";

			result = queryService.doAction("B100003", xml);
			
//			result = "<?xml version='1.0' encoding='UTF-8' standalone='yes'?><Package>	<Header>		<RequestType>B100003</RequestType>		<UUID>100000000010319</UUID>		<ComId>0001</ComId>		<From>null</From>		<SendTime>2016-10-19 10:38:56</SendTime>		<Signed></Signed>		<ResultCode>1</ResultCode>		<ResultMsg>success</ResultMsg>	</Header>	<Body>		<PayInfo>			<BatchNo>0001100000000010319</BatchNo>			<OrderNo>00011000009674</OrderNo>			<BusinessOrderType>004</BusinessOrderType>			<EntryNo>00011</EntryNo>			<BusinessEntryType>00401</BusinessEntryType>			<Amount>12</Amount>			<PayChannel>CL0001</PayChannel>			<TradeType>02</TradeType>			<PayTime>2016-10-16 10:49:35</PayTime>			<Status>3</Status>		</PayInfo>	</Body></Package>";
			returnMap = readZfXmlB100003(result);
			//���ݽ�����ˮ�Ų�ѯ������������
			acDebit = new AcDebit();
			acDebit.setTraceNo(traceNo);
			acDebit = acDebitDao.getById(acDebit);
			
			wsBase.setRespContent(result);
			if(acDebit!=null){
				acDebit.setBrNo(acDebit.getBrNo());//����������������
			}
			wsBaseDao.update(wsBase);
			
		} catch (Exception_Exception e) {
			e.printStackTrace();
			throw new AccountingException(e);
		} finally {
			try {
				if (conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return returnMap ;
	
	} 
	// �ۿ���ϸ ҵ���߼��ĺϷ����жϣ�sunmingyi
	public Map<String,String> validateAcDebitSusp(String wsId) {
		boolean result = false;
		Connection conn = DBUtils.getConn();
		Map<String,String> map = new HashMap<String,String>();
		try{
			WsRepyMes wsRepyMess = new WsRepyMes();
			wsRepyMess.setWsId(wsId);
			wsRepyMess = wsRepyMesDao.getById(wsRepyMess);
			AcLnMst acLnMst = new AcLnMst();
			
			String pactNo = wsRepyMess.getPactNo();// ��ͬ��
			String brNo = wsRepyMess.getBrNo();// ������

			// �ֱ�ŵ�Ƿ����ʵ�� ��ѯ��
			AcLnLo acLnLo = new AcLnLo();
			acLnLo.setPactNo(pactNo);
			acLnLo.setBrNo(brNo);

			//�ֱ�ŵ��������ļ���ʵ�� ��ѯ��
			acLnMst.setPactNo(pactNo);
			acLnMst.setBrNo(brNo);
			acLnMst = acLnMstDao.getByPactNo(acLnMst);
			if (acLnMst != null) {
				if("01".equals(acLnMst.getLoanSts()) ||"02".equals(acLnMst.getLoanSts()) 
						||"03".equals(acLnMst.getLoanSts()) ||"04".equals(acLnMst.getLoanSts())){//���ļ�״̬Ϊ01/02/03/04���ܿۿ�
					String loanNo = acLnMst.getLoanNo();
					acLnLo.setLoanNo(loanNo);
				}else{
					//����WS������ʧ��
					wsRepyMess.setDealDesc("�������ļ�������������");
					wsRepyMess.setDealSts("05");
					wsRepyMesDao.update(wsRepyMess);
					return map;
					
				}
			} else  {
				//����WS������ʧ��
				wsRepyMess.setDealDesc("�������ļ�������");
				wsRepyMess.setDealSts("05");
				wsRepyMesDao.update(wsRepyMess);
				return map;
			}
			
			//����ά�ŷְ������⣬������������֮�ʹ���0������Ҫ�ж��Ƿ����δ���ı������ۿ����������ۿ�����ڣ�ͨ��
			if(NumberUtil.amtAdd(NumberUtil.amtAdd(wsRepyMess.getRepayAmt(),wsRepyMess.getRepayInte()),wsRepyMess.getRepayOver())>0){
				//����δ���Ŀۿ�ָ��������ٴη���ۿ�
				AcDebit acDebit = new AcDebit();
				acDebit.setLoanNo(acLnMst.getLoanNo());
				acDebit = acDebitDao.getByLoanNoIng(acDebit);
				if(acDebit != null){
					wsRepyMess.setDealDesc("��ͬ��:"+acLnMst.getPactNo()+"����δ���Ŀۿ��¼,�����ٴη���ۿ");
					wsRepyMess.setDealSts("05");
					wsRepyMesDao.update(wsRepyMess);
//					continue ;
					return map;
				}
			}
			AftRepyClear aftRepyClear = new AftRepyClear();
			aftRepyClear.setPactNo(pactNo);
			aftRepyClear.setBrNo(brNo);
			aftRepyClear = aftRepyClearDao.getByPactNoIng(aftRepyClear);

			double repayAmt = wsRepyMess.getRepayAmt();// �ۿ��
			double repayInte = wsRepyMess.getRepayInte();// �ۿ���Ϣ
			double sumTxPayOver = 0;//ʵ�շ�Ϣ�ܶ�
			double repaysumTxPayOver = 0;//Ӧ�շ�Ϣ�ܶ�
			// �ֱ�ŵ����ڻ���ƻ����ʵ�� ��ѯ��
			AcLnRepayPlnCur acLnRepayPlnCur = new AcLnRepayPlnCur();
			acLnRepayPlnCur.setPactNo(pactNo);
			acLnRepayPlnCur.setBrNo(brNo);
			
			//��ѯ�����Ϣ
			LnDue lnDue = new LnDue();
			lnDue.setDueNo(acLnMst.getLoanNo());
			lnDue = lnDueDao.getById(lnDue);
			
			//���ݿۿ��˺Ų�ѯ �ۿ���Ϣ
			LnAcct lnAcct = new LnAcct();
			lnAcct.setAppId(lnDue.getAppId());
			lnAcct.setAcNo(wsRepyMess.getAcNo());
			lnAcct.setAcUse("1");//�ۿ�
			lnAcct = lnAcctDao.getById(lnAcct);
			
			if(lnAcct==null){//�ۿ��˺� ����������ոÿۿ�����
				//����WS������ʧ��
				wsRepyMess.setDealDesc("�ۿ��˺Ų�����");
				wsRepyMess.setDealSts("05");
				wsRepyMesDao.update(wsRepyMess);
				return map;
			}else if(!"01".equals(lnAcct.getAcSts())){//�ۿ��˺�δ��Ч������տۿ�����
				wsRepyMess.setDealDesc("�ۿ��˺�δ��Ч");
				wsRepyMess.setDealSts("05");
				wsRepyMesDao.update(wsRepyMess);
				return map;
			}
			//�жϴ��۷��ܶ��Ƿ����
			double feeTotal = wsRepyMess.getFeeTotal();//�����ܶ�
			double repayFeeTotal = 0;
				WsRepyFee wsRepyFee = new WsRepyFee();
				wsRepyFee.setFeeKind("02");
				wsRepyFee.setWsId(wsRepyMess.getWsId());
				repayFeeTotal = wsRepyFeeDao.getFeeAmt(wsRepyFee);//������ϸ�ܶ�
				if(!NumberUtil.isAmtEqual(feeTotal, repayFeeTotal)){
					wsRepyMess.setDealDesc("�ϴ����۷��ܶ��");
					wsRepyMess.setDealSts("05");
					wsRepyMesDao.update(wsRepyMess);
					return map;
				}

			double prcpAmt = 0.0;// Ӧ�ձ���
			double repayPrcpAmt = 0.0;// ʵ�ձ���
			double wvPrcpAmt = 0.0;// ���Ȿ��
			double normInt = 0.0;// Ӧ����Ϣ
			double repayNormInt = 0.0;// ʵ����Ϣ
			double wvNormInt = 0.0;// ������Ϣ
			double fineInt = 0.00;//Ӧ�շ�Ϣ
			double repayFineInt = 0.00;//ʵ�շ�Ϣ
			double wvFineInt = 0.00;//���ⷣϢ
			List<AcLnLo> acLnLoList = acLnLoDao.getByLoanPactBrNo(acLnLo);
			for(AcLnLo all : acLnLoList){
				prcpAmt += all.getPrcpAmt();// Ӧ�ձ���
				repayPrcpAmt += all.getRepayPrcpAmt();// ʵ�ձ���
				wvPrcpAmt += all.getWvPrcpAmt();// ���Ȿ��

				normInt += all.getNormInt();// Ӧ����Ϣ
				repayNormInt += all.getRepayNormInt();// ʵ����Ϣ
				wvNormInt += all.getWvNormInt();// ������Ϣ
				
				fineInt += all.getFineInt();//Ӧ�շ�Ϣ
				repayFineInt += all.getRepayFineInt();//ʵ�շ�Ϣ
				wvFineInt += all.getWvFineInt();//���ⷣϢ
			} 
			if (aftRepyClear == null) {// ��������ǰ�������

				// 1���ۿ�� <=
				// (ac_ln_repay_pln_cur���ڻ���ƻ����е�Ӧ�ձ���-�ѻ�����+Ƿ���ac_ln_lo��Ӧ�ձ���-ʵ�ձ���-���Ȿ��
				// PRCP_AMT- REPAY_PRCP_AMT +
				// PRCP_AMT-REPAY_PRCP_AMT-WV_PRCP_AMT)
				double prcpAmtCur = 0.0; // ���ڻ���ƻ����е�Ӧ�ձ���
				double repayPrcpAmtCur = 0.0; // ���ڻ���ƻ����е��ѻ�����
				double wvPrcpAmtCur = 0.0; // ���ڻ���ƻ����еļ��Ȿ��
				double normIntCur = 0.0; // ���ڻ���ƻ����е�Ӧ����Ϣ
				double repayNormIntCur = 0.0; // ���ڻ���ƻ����е��ѻ���Ϣ
				double wvNormIntCur = 0.0; // ���ڻ���ƻ����еļ�����Ϣ
				acLnRepayPlnCur = acLnRepayPlnCurDao.getByPactNo(acLnRepayPlnCur);
				//���ڻ���ƻ������� �ۿ����ڵ��ڻ�����֮�� �����������˵�
				if (acLnRepayPlnCur != null && !DateUtil.checkDate1BeforeDate2(DateUtil.changeToShow(ParmBiz.getBizDt(conn)), DateUtil.changeToShow(acLnRepayPlnCur.getPayDt()))) {
					prcpAmtCur = acLnRepayPlnCur.getPrcpAmt();// ���ڻ���ƻ����е�Ӧ�ձ���
					repayPrcpAmtCur = acLnRepayPlnCur.getRepayPrcpAmt();// ���ڻ���ƻ����е��ѻ�����
					wvPrcpAmtCur = acLnRepayPlnCur.getWvPrcpAmt();// ���ڻ���ƻ����еļ��Ȿ��
					
					normIntCur = acLnRepayPlnCur.getNormInt();// ���ڻ���ƻ����е�Ӧ����Ϣ
					repayNormIntCur = acLnRepayPlnCur.getRepayNormInt();// ���ڻ���ƻ����е��ѻ���Ϣ
					wvNormIntCur = acLnRepayPlnCur.getWvNormInt();// ���ڻ���ƻ����еļ�����Ϣ
				} 
				boolean amtLean = true;
				boolean normIntLean = true;
				double pcamt = NumberUtil.amtSubs(NumberUtil.amtSubs(NumberUtil.amtSubs(NumberUtil.amtSubs(NumberUtil.amtAdd(prcpAmtCur, prcpAmt),repayPrcpAmtCur),repayPrcpAmt), wvPrcpAmt),wvPrcpAmtCur);
//					boolean fineLean = true;
				if(repayAmt>0){
					if (repayAmt <= pcamt) {
						amtLean = true;
					} else {
						amtLean = false;
						//����WS������ʧ��
						wsRepyMess.setDealDesc("�ۿ�����Ӧ�ձ���,Ӧ�ձ���Ϊ��"+ pcamt +"");
						wsRepyMess.setDealSts("05");
						wsRepyMesDao.update(wsRepyMess);
//							continue ;
						return map;
					}	
				}
			
				if(repayInte>0){
					double pyinte = NumberUtil.amtSubs(NumberUtil.amtSubs(NumberUtil.amtSubs(NumberUtil.amtSubs(NumberUtil.amtAdd(normIntCur, normInt),repayNormIntCur), repayNormInt), wvNormInt),wvNormIntCur);//Ӧ����Ϣ
					if (repayInte <= pyinte) {
						normIntLean = true;
					} else {
						normIntLean = false;
						//����WS������ʧ��
						wsRepyMess.setDealDesc("�ۿ���Ϣ����Ӧ����Ϣ ��Ӧ����ϢΪ��"+pyinte+"Ԫ");
						wsRepyMess.setDealSts("05");
						wsRepyMesDao.update(wsRepyMess);
//							continue ;
						return map;
					}
				}
				
				if (amtLean && normIntLean) {
					result = true;
				} else {
					result = false;
				}
			} else {// ������ǰ�������
				// ��ǰ��� ������������۱����һֱ
				double exact = 0.0001;
				if ((acLnMst.getLoanBal()- wsRepyMess.getRepayAmt())<exact && (acLnMst.getLoanBal()- wsRepyMess.getRepayAmt())>-exact && acLnMst!=null  && wsRepyMess!=null ) {
					result = true;
				} else {
					result = false;
					//����WS������ʧ��
					wsRepyMess.setDealDesc("������ǰ������룬�۱����==������� ������");
					wsRepyMess.setDealSts("05");
					wsRepyMesDao.update(wsRepyMess);
					return map;
				}
			}
			if (result) {
				
				//����WS����������
				wsRepyMess.setDealDesc("������");
				wsRepyMess.setDealSts("02");
				wsRepyMesDao.update(wsRepyMess);
				
				AcDebitSusp acDebitSusp = new AcDebitSusp();
				acDebitSusp.setWsId(wsRepyMess.getWsId());
				acDebitSusp.setBatchNo(wsRepyMess.getBatchNo());
				acDebitSusp.setBrNo(wsRepyMess.getBrNo());
				acDebitSusp.setPactNo(wsRepyMess.getPactNo());
				acDebitSusp.setAcName(wsRepyMess.getAcName());
				acDebitSusp.setAcNo(wsRepyMess.getAcNo());
				acDebitSusp.setOpnCode(wsRepyMess.getOpnCode());
				acDebitSusp.setOpnName(wsRepyMess.getOpnName());
				acDebitSusp.setPayOver(wsRepyMess.getPayOver());
				acDebitSusp.setFeeRec(wsRepyMess.getFeeRec());
				acDebitSusp.setRepayTotal(wsRepyMess.getRepayTotal());
				acDebitSusp.setRepayAmt(wsRepyMess.getRepayAmt());
				acDebitSusp.setRepayInte(wsRepyMess.getRepayInte());
				acDebitSusp.setRepayOver(wsRepyMess.getRepayOver());
				acDebitSusp.setFeeTotal(wsRepyMess.getFeeTotal());
				acDebitSusp.setSerialNo(wsRepyMess.getSerialNo());
				acDebitSusp.setDealSts(wsRepyMess.getDealSts());
				acDebitSusp.setDealDesc(wsRepyMess.getDealDesc());
				acDebitSusp.setCardChn(wsRepyMess.getCardChn());
				acDebitSusp.setTxCde(TransCode.LNSU);//B�����������ۿ��ļ��ϴ�
				acDebitSuspDao.insert(acDebitSusp);
				
				//����ҵ����
				map = acDebitSuspExec(map ,acDebitSusp);

			}
		} catch (AccountingException e) {
			throw new ServiceException(e.getMessage());
		}finally{
			if(conn!=null)
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return map;
	}
	
	/**
	 * 
	 * @���� DHCC-LIUJ
	 * @���� 2016-8-25
	 * @����	�ۿ��ļ��ϴ��߼�����
	 */
	public Map<String,String> acDebitSuspExec(Map<String,String> map ,AcDebitSusp acDebitSusp)throws ServiceException{
		Connection conn = this.getConnection();
		AcTraceLog acTraceLog = new AcTraceLog();
		String traceNo =  acTraceLogDao.getKey();
		DecimalFormat df = new DecimalFormat("00");
		//�����Ϣ
		LnDue lnDue = new LnDue();
		lnDue.setPactNo(acDebitSusp.getPactNo());
		lnDue.setBrNo(acDebitSusp.getBrNo());
		lnDue = lnDueDao.getByPactNoAndBrNo(lnDue);
		
		LnAcct lnAcct = new LnAcct();
		lnAcct.setAppId(lnDue.getAppId());
		lnAcct.setAcUse("1");//�ۿ��˺�
		lnAcct.setAcNo(acDebitSusp.getAcNo());
		lnAcct.setAcSts("01");//״̬����
		lnAcct = lnAcctDao.getById(lnAcct);
		
		AcDebit acDebit = new AcDebit();
		acDebit.setTraceCnt(1);
		acDebit.setTraceNo(traceNo);
		
		String uUID = CreateKey.getUUID();//�ӿ���ˮ��
		try {
			List<AcLoanBackLog> acLoanBackLogList = new ArrayList<AcLoanBackLog>();

			acDebit.setDebitNo(ParmBiz.getDebitNo(conn));
//			acDebit.setDebitNo(acDebitSusp.getSerialNo());
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
			acDebit.setSts("02");
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
			
			acDebit.setCardChn(acDebitSusp.getCardChn());
			acDebit.setXtAcNo(CachecodeUtil.MFSPREFIX+"_"+PUBConstant.ACCT_TYPE_04+"_"+lnDue.getProjNo());
			acDebit.setDebitMold(PUBConstant.DEBIT_MOLD_04);
			acDebit.setCreateDt(ParmBiz.getBizDt(conn));
			
			acDebitDao.insert(acDebit);
			acDebitSusp.setSerialNo(acDebit.getDebitNo());
			acDebitSuspDao.update(acDebitSusp);
			
			AcLoanBackLog acLoanBackLog = new AcLoanBackLog();
			String backLogNo = ParmBiz.getAcLoanBackLogNo(conn) ;
			acLoanBackLog.setBackLogNo(backLogNo);
			acLoanBackLog.setBackCnt(ParmBiz.getBackCntSeq(conn));
			acLoanBackLog.setLoanLogNo(acDebit.getDebitNo());
			acLoanBackLog.setBackType(PUBConstant.BACK_TYPE_02);
			acLoanBackLog.setBackRes("");
			acLoanBackLog.setFailCaus("");
			acLoanBackLog.setBackSts(PUBConstant.BACK_STS_01);//01 ������ 02 �Ѵ���
			acLoanBackLog.setBusOrderType(busOrderType);
			acLoanBackLog.setBusEntryType(acDebit.getBusEntryType());
			acLoanBackLog.setTraceNo(acDebit.getTraceNo());//������ˮ
			acLoanBackLog.setUuid(CachecodeUtil.MFSPREFIX+uUID);
//			acLoanBackLog.setTxTime(ParmBiz.getOracleUpDate(conn));
			acLoanBackLogDao.insert(acLoanBackLog);
			acLoanBackLogList.add(acLoanBackLog);
			
			//��������
			WsRepyFee wsRepyFee = null;
			List<WsRepyFee> wsRepyFeeList = new ArrayList<WsRepyFee>();
			// ���շѴ���0 �� �轫���շѴ������˻��л�������������
			if (acDebitSusp.getFeeTotal() > 0) {
				//��ȡ���������˻���Ϣ
				CorpAcct corpAcct = new CorpAcct();
				corpAcct.setBrNo(lnDue.getBrNo());
				
//				corpAcct = corpAcctDao.getByBrNo(corpAcct);
				
				wsRepyFee = new WsRepyFee();
				wsRepyFee.setWsId(acDebitSusp.getWsId());
				wsRepyFee.setFeeKind("02");
				wsRepyFeeList = wsRepyFeeDao.getFeeType(wsRepyFee);
				int bus = 2;
				for(WsRepyFee wsRepyFe : wsRepyFeeList){
					String acNo = CachecodeUtil.MFSPREFIX+"_"+lnDue.getBrNo()+"_"+lnDue.getProjNo()+"_"+wsRepyFe.getFeeType();
//					corpAcct.setOpnAcno(acNo);
//					corpAcct = corpAcctDao.getByBrNoAndAcNo(corpAcct);
					AcLoanLog acLoanLog = new AcLoanLog();
					acLoanLog.setLoanLogNo(ParmBiz.getLoanLogNo(conn));
					acLoanLog.setTraceNo(traceNo);
					acLoanLog.setLoanNo(lnDue.getDueNo());
					acLoanLog.setPactNo(lnDue.getPactNo());
					acLoanLog.setBrNo(lnDue.getBrNo());
					acLoanLog.setLoanAmt(wsRepyFe.getFeeAmt());//���ý��
					acLoanLog.setLoanAcNo(acNo);
					acLoanLog.setLoanAcType("12");
//					acLoanLog.setLoanAcName(corpAcct.getAcName());
//					acLoanLog.setLoanBankCode(corpAcct.getExchange());
//					acLoanLog.setLoanBankProv(corpAcct.getProvince());
//					acLoanLog.setLoanBankCity(corpAcct.getCity());
//					acLoanLog.setLoanBankSite(corpAcct.getOpnBank());
					acLoanLog.setLoanSts("02");
					acLoanLog.setTxDate(ParmBiz.getBizDt(conn));
					acLoanLog.setTxTime(ParmBiz.getOracleTxTime(conn));

					acLoanLog.setCardChn(acDebitSusp.getCardChn());
					acLoanLog.setXtAcNo(CachecodeUtil.MFSPREFIX+"_"+PUBConstant.ACCT_TYPE_04+"_"+lnDue.getProjNo());
	
					acLoanLog.setBusEntryType(busOrderType+String.valueOf(df.format(bus)));
					bus+=1;
					acLoanLogDao.insert(acLoanLog);

					acLoanBackLog = new AcLoanBackLog();
					acLoanBackLog.setBackLogNo(backLogNo);
					acLoanBackLog.setBackCnt(ParmBiz.getBackCntSeq(conn));
					acLoanBackLog.setLoanLogNo(acLoanLog.getLoanLogNo());
					acLoanBackLog.setBackType(PUBConstant.BACK_TYPE_01);
					acLoanBackLog.setBackRes("");
					acLoanBackLog.setFailCaus("");
					acLoanBackLog.setBackSts(PUBConstant.BACK_STS_01);
					acLoanBackLog.setBusOrderType(busOrderType);
					acLoanBackLog.setBusEntryType(acLoanLog.getBusEntryType());
					acLoanBackLog.setTraceNo(acLoanLog.getTraceNo());//������ˮ
					acLoanBackLog.setUuid(CachecodeUtil.MFSPREFIX+uUID);
//					acLoanBackLog.setTxTime(ParmBiz.getOracleUpDate(conn));
					acLoanBackLogDao.insert(acLoanBackLog);
					acLoanBackLogList.add(acLoanBackLog);
				}

			}
			
			acTraceLog.setTraceNo(traceNo);
			acTraceLog.setTraceCnt(1);
			acTraceLog.setTxDt(ParmBiz.getBizDt(conn));
			acTraceLog.setTxTime(ParmBiz.getOracleTxTime(conn));
			acTraceLog.setTxBrNo(acDebitSusp.getBrNo());
			acTraceLog.setTxCde(TransCode.LNC4);
			acTraceLog.setSubTxCde(TransCode.LNSU);//B����������ۿ��ļ��ϴ�
			acTraceLog.setSvcInd(TransCode.LNSU);
			acTraceLog.setCurNo(lnDue.getCurNo());
			acTraceLog.setPrdtNo(lnDue.getPrdtNo());
			acTraceLog.setAmt(acDebitSusp.getRepayTotal());
			acTraceLog.setCancelInd(PUBConstant.REV_ROL_NORM);//����
			acTraceLog.setAppSts("01");//����
			acTraceLog.setBrNo(lnDue.getBrNo());
			acTraceLog.setPactNo(lnDue.getPactNo());
			acTraceLog.setLoanNo(lnDue.getDueNo());
			acTraceLog.setMemo("B����������ۿ��ļ��ϴ�");
			
			acTraceLogDao.insert(acTraceLog);
			
			//���͵�����֧��
			map = sendZfMess(map ,acLoanBackLogList, lnDue, acLoanBackLog.getTraceNo(), conn);
			
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new ServiceException(e.getMessage());
		}
		finally {
			try {
				conn.commit();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return map;
	}
	/*
	 * @���� ��װ���ͱ��� �Ͻӿ�
	 */
	public  Map<String,String> sendZfMess(Map<String,String> map ,List<AcLoanBackLog> acLoanBackLogList,LnDue lnDue,String traceNo,Connection conn) throws Exception {
		
		ZFHead zfHead = new ZFHead();
		zfHead.setRequestType("P100001");
		String uuid = acLoanBackLogList.get(0).getUuid();
		zfHead.setUUID(uuid);//�ӿ���ˮ��
		zfHead.setComId(CachecodeUtil.MFSPREFIX);
		zfHead.setComIP("11");
		zfHead.setSendTime(ParmBiz.getOracleUpDate2(conn));
		zfHead.setAsyn("0");
		Properties pathProperties = new Properties();
		pathProperties.load(Thread.currentThread().getContextClassLoader()
				.getResourceAsStream("application.properties"));
		String zfReturnUrl = pathProperties.getProperty("zfloanreturn.url");
		zfHead.setReturnUrl(zfReturnUrl);
		zfHead.setSigned("");
		zfHead.setClientType("0");
		zfHead.setPayCount(1);
		String headXml = XMLUtil.createHead(zfHead); // ͷ�ļ�
		
		BodyLoan bodyLoan = new BodyLoan();
		
		List<TradeInfo> tradeList = new ArrayList<TradeInfo>();
		
		TradeInfo tradeInfo = new TradeInfo();
		
		tradeInfo.setTradeNo(CachecodeUtil.MFSPREFIX+traceNo);
		tradeInfo.setTradeTypeNo(acLoanBackLogList.get(0).getBusOrderType());
		tradeInfo.setTotalEntryNum(acLoanBackLogList.size());
		
		EntryInfo entryInfo = null;
		List<EntryInfo> entryList = new ArrayList<EntryInfo>();

		//�ſ���Ϣ
		AcLoanLog acLoanLog = null;
		//�ſ���ϢList
		List<AcLoanLog> acLoanLogList = new ArrayList<AcLoanLog>();
		//�ۿ���Ϣ
		AcDebit acDebit = null;
		//�ۿ���Ϣlist
		List<AcDebit> acDebitList = new ArrayList<AcDebit>();
		//�˻���Ϣ
		AccountInfo accountInfo = null;
		
		SourceAccountInfo sourceAccountInfo = new SourceAccountInfo();//Դ
		TargetAccountInfo targetAccountInfo = new TargetAccountInfo();//Ŀ��
		
		for (AcLoanBackLog acLoanBackLog : acLoanBackLogList) {
			if(PUBConstant.BACK_STS_01.equals(acLoanBackLog.getBackType())){//�ſ�
				/*//��ȡ�ſ���Ϣ
				acLoanLog = new AcLoanLog();
				acLoanLog.setLoanLogNo(acLoanBackLog.getLoanLogNo());
				acLoanLog = acLoanLogDao.getById(acLoanLog);
				acLoanLogList.add(acLoanLog);
				
				entryInfo = new EntryInfo();
				
				List<SourceAccountInfo> sourceAccountInfoListfk = new ArrayList<SourceAccountInfo>();
				List<TargetAccountInfo> targetAccountInfoListfk = new ArrayList<TargetAccountInfo>();
				
				sourceAccountInfo = new SourceAccountInfo();// Դ
				targetAccountInfo = new TargetAccountInfo();// Ŀ��

				entryInfo.setEntryNo(acLoanBackLog.getBackCnt());
				entryInfo.setEnTradeType(PUBConstant.ENTRADE_TYPE_01);// �ſ�
				entryInfo.setAmount(acLoanLog.getLoanAmt());
				entryInfo.setEntryTypeNo(acLoanBackLog.getBusEntryType());
				entryInfo.setChannelNo(acLoanLog.getCardChn());

				accountInfo = new AccountInfo();
				// Դ
				accountInfo.setAccountNo(acLoanLog.getXtAcNo());
				accountInfo.setAccountType("0");
				sourceAccountInfo.setLevel("01");
				sourceAccountInfo.setAccountInfo(accountInfo);
				sourceAccountInfoListfk.add(sourceAccountInfo);

				accountInfo = new AccountInfo();//Ŀ��
				
				accountInfo.setAccountNo(acLoanLog.getLoanAcNo());
				
				if("10".equals(acLoanLog.getLoanAcType())){//���˴��ǿ�
					accountInfo.setAccountType("3");
				}else if("11".equals(acLoanLog.getLoanAcType())){//���˽�ǿ�
					accountInfo.setAccountType("1");
				}
				
				if("14".equals(acLoanLog.getLoanAcType())||"12".equals(acLoanLog.getLoanAcType())){//�̻���Թ�
					accountInfo.setAccountNo(acLoanLog.getLoanAcNo());//(�̻���Թ�)�ſ��˻�
					targetAccountInfo.setLevel("01");
					accountInfo.setAccountType("0");
					targetAccountInfo.setAccountInfo(accountInfo);
					targetAccountInfoListfk.add(targetAccountInfo);
					entryInfo.setSourceAccountList(sourceAccountInfoListfk);
					entryInfo.setTargetAccountList(targetAccountInfoListfk);
					entryInfo.setRemark1(lnDue.getBrNo());
					entryInfo.setRemark2(lnDue.getProjNo());
					entryInfo.setRemark3(lnDue.getPactNo());
					entryList.add(entryInfo);
				}else{
					accountInfo.setAccountName(acLoanLog.getLoanAcName());
					accountInfo.setChannelNo(acLoanLog.getLoanBankCode());
					accountInfo.setBankDetailNo("");
					accountInfo.setBankName(acLoanLog.getLoanBankSite());
					accountInfo.setProvince(acLoanLog.getLoanBankProv());
					accountInfo.setCity(acLoanLog.getLoanBankCity()!=null?acLoanLog.getLoanBankCity():"");
					accountInfo.setCVN2(acLoanLog.getCvvNo()!=null?acLoanLog.getCvvNo():"");
					accountInfo.setVALDATE(acLoanLog.getValidDate()!=null?acLoanLog.getValidDate():"");
					accountInfo.setPhoneNo(acLoanLog.getPhoneNo()!=null?acLoanLog.getPhoneNo():"");
					accountInfo.setEmail("");
					accountInfo.setCertificateType(acLoanLog.getIdType()!=null?acLoanLog.getIdType():"");
					accountInfo.setCertificateNo(acLoanLog.getIdNo()!=null?acLoanLog.getIdNo():"");
					targetAccountInfo.setLevel("01");
					targetAccountInfo.setAccountInfo(accountInfo);
					targetAccountInfoListfk.add(targetAccountInfo);
					entryInfo.setSourceAccountList(sourceAccountInfoListfk);
					entryInfo.setTargetAccountList(targetAccountInfoListfk);
					entryInfo.setRemark1(lnDue.getBrNo());
					entryInfo.setRemark2(lnDue.getProjNo());
					entryInfo.setRemark3(lnDue.getPactNo());
					entryList.add(entryInfo);}*/
					
			}else{
				acDebit = new AcDebit();
				acDebit.setDebitNo(acLoanBackLog.getLoanLogNo());
				acDebit = acDebitDao.getByDebitNo(acDebit);
				acDebitList.add(acDebit);

				acDebitList.add(acDebit);
				
				entryInfo = new EntryInfo();
				
				entryInfo.setEntryNo(acLoanBackLog.getBackCnt());
				entryInfo.setEnTradeType(PUBConstant.ENTRADE_TYPE_02);//�ۿ�
				entryInfo.setAmount(acDebit.getAtpyAmt());
				entryInfo.setEntryTypeNo(acDebit.getBusEntryType());
				entryInfo.setChannelNo(acDebit.getCardChn());
				
				/*accountInfo = new AccountInfo();*/
				
				List<SourceAccountInfo> sourceAccountInfoListsk = new ArrayList<SourceAccountInfo>();
				List<TargetAccountInfo> targetAccountInfoListsk = new ArrayList<TargetAccountInfo>();
				
				/*sourceAccountInfo = new SourceAccountInfo();//Դ1
*/				targetAccountInfo = new TargetAccountInfo();//Ŀ��
				//Դ���ͻ�������ɿ��˻������п��� Ŀ�ģ���Ŀ�˻�
				/*accountInfo.setAccountNo(CachecodeUtil.MFSPREFIX+"_"+acDebit.getBrNo()+"_"+acDebit.getPactNo());//֧��ƽ̨�˻�
				accountInfo.setAccountType("0");
				sourceAccountInfo.setLevel("01");
				sourceAccountInfo.setAccountInfo(accountInfo);
				sourceAccountInfoListsk.add(sourceAccountInfo);*/
				
				accountInfo = new AccountInfo();
				
				sourceAccountInfo = new SourceAccountInfo();//Դ2
				
				accountInfo.setAccountNo(acDebit.getAcNo());//���п�
				if("10".equals(acDebit.getAcType())){//���˴��ǿ�
					accountInfo.setAccountType("3");
				}else if("11".equals(acDebit.getAcType())){//���˽�ǿ�
					accountInfo.setAccountType("1");
				}else if("12".equals(acDebit.getAcType())||"13".equals(acDebit.getAcType())||"14".equals(acDebit.getAcType())){//��ҵ�˻������磩
					accountInfo.setAccountType("0");
				}
				accountInfo.setAccountName(acDebit.getAcName());
				accountInfo.setChannelNo(acDebit.getAcctBankCde());
				accountInfo.setBankDetailNo("");
				accountInfo.setBankName(acDebit.getBankSite());
				accountInfo.setProvince(acDebit.getBankProv());
				accountInfo.setCity(acDebit.getBankCity());
				accountInfo.setCVN2(acDebit.getCvvNo()!=null?acDebit.getCvvNo():"");
				accountInfo.setVALDATE(acDebit.getValidDate()!=null?acDebit.getValidDate():"");
				accountInfo.setPhoneNo(acDebit.getPhoneNo()!=null?acDebit.getPhoneNo():"");
				accountInfo.setEmail("");
				accountInfo.setCertificateType(acDebit.getIdType()!=null?acDebit.getIdType():"");
				accountInfo.setCertificateNo(acDebit.getIdNo()!=null?acDebit.getIdNo():"");
				sourceAccountInfo.setLevel("01");
				sourceAccountInfo.setAccountInfo(accountInfo);
				sourceAccountInfoListsk.add(sourceAccountInfo);
				
				accountInfo = new AccountInfo();
				
				accountInfo.setAccountNo(CachecodeUtil.MFSPREFIX+"_"+PUBConstant.ACCT_TYPE_04+"_"+lnDue.getProjNo());//��Ŀ�տ��˻�
				accountInfo.setAccountType("0");
				targetAccountInfo.setLevel("01");
				targetAccountInfo.setAccountInfo(accountInfo);
				targetAccountInfoListsk.add(targetAccountInfo);
				
				entryInfo.setRemark1(lnDue.getBrNo());
				entryInfo.setRemark2(lnDue.getProjNo());
				entryInfo.setRemark3(lnDue.getPactNo());
				entryInfo.setSourceAccountList(sourceAccountInfoListsk);
				entryInfo.setTargetAccountList(targetAccountInfoListsk);
				entryList.add(entryInfo);
			}
			
		}
		tradeInfo.setEntryList(entryList);
		tradeList.add(tradeInfo);
		bodyLoan.setTradeList(tradeList);
		String bodyXml = XMLUtil.createBody(bodyLoan);// ת��ΪXML

		String xml = headXml + bodyXml + "</Package>";

		map.put(uuid, xml);
		
		return map ;
	}
	
	/**
	 * ��ѯ����
	 */
	public void queryReconciliation() throws ServiceException {
		Properties pathProperties = new Properties();
		try {
			pathProperties.load(Thread.currentThread().getContextClassLoader()
					.getResourceAsStream("application.properties"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		String timeSec  = pathProperties.getProperty("queryReconciliation.sec");

		List<AcLoanBackLog> acLoanBackLogList = acLoanBackLogDao.reconciZf(timeSec);//��ȡ�ѷ���֧��δ�ص��Ŀۿ�ſ����Ŀ

		List<PayInfo> payInfoList = null;
		ZfB100007 zfB100007 = null;
		int count = 0;
		int pageNo = 0;
		int listSize = acLoanBackLogList.size();//���ͼ�¼������
		StringBuilder buf = new StringBuilder();
		List<String> backCntList = new ArrayList<String>();//���ڴ洢֧����������Ŀ
		try {
			for (AcLoanBackLog acLoanBackLog : acLoanBackLogList) {
				count = count + 1;
				String backCnt = acLoanBackLog.getBackCnt();// ��Ŀ��
				backCntList.add(backCnt);
				zfB100007 = new ZfB100007();
				zfB100007.setNo(backCnt);
				buf.append(zfB100007.toXml());
				if (count % 50 == 0) {//ÿ50������һ��
					pageNo = pageNo + 1;
					payInfoList = sendZfB100007(count, buf.toString());
					analyBack(payInfoList,backCntList);
					count = 0;
					buf = new StringBuilder();
					backCntList = new ArrayList<String>();
				}
				
			}
			int sendNum = pageNo*50;//�ѷ��͵�����
			if(sendNum<listSize){//����ʣ���
				buf = new StringBuilder();
				List<AcLoanBackLog> acLoanBackLogListSur = acLoanBackLogList.subList(sendNum, listSize);
				backCntList = new ArrayList<String>();
				for(AcLoanBackLog acLoanBackLog : acLoanBackLogListSur){
					String backCnt = acLoanBackLog.getBackCnt();// ��Ŀ��
					backCntList.add(backCnt);
					zfB100007 = new ZfB100007();
					zfB100007.setNo(backCnt);
					buf.append(zfB100007.toXml());
					
				}
				payInfoList = sendZfB100007(listSize-sendNum, buf.toString());
				analyBack(payInfoList,backCntList);
			}
		} catch (AccountingException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		} 
	}
	
	public  List<PayInfo> sendZfB100007(int count,String bodyXml) throws AccountingException{
		Connection conn = DBUtils.getConn();
		//��������
		List<PayInfo> payInfoList = null;
		String uuid = CreateKey.getUUID();
		try {
			ZFHeadQuery zfHeadQuery = new ZFHeadQuery();
			zfHeadQuery.setRequestType("B100007");
			zfHeadQuery.setUUID(CachecodeUtil.MFSPREFIX+uuid);// ��ˮ��
			zfHeadQuery.setComId(CachecodeUtil.MFSPREFIX);
			zfHeadQuery.setComIP("11");
			zfHeadQuery.setSendTime(ParmBiz.getOracleUpDate2(conn));
			zfHeadQuery.setAsyn("0");
			zfHeadQuery.setReturnUrl("");
			zfHeadQuery.setSigned("");
			zfHeadQuery.setClientType("0");
			zfHeadQuery.setPageSize(count);//ÿҳ����
			zfHeadQuery.setPageNo(1);//ҳ��
			String headXml = zfHeadQuery.toXml(); // ͷ�ļ�
			ZfBodyQuery zfBodyQuery = new ZfBodyQuery();
			
			zfBodyQuery.setQueryType("4");//��������Ŀ�Ų�ѯ

			String xml = headXml + zfBodyQuery.toXml()+ bodyXml + "</QueryList></Body></Package>";

			QueryService queryService = (QueryService) SourceTemplate
					.getSpringContextInstance().getBean("queryService");
			String result = "";

			result = queryService.doAction("B100007", xml);
			
			payInfoList = readZfXmlB100007(result);

			WsBase wsBase = new WsBase();
			wsBase.setWsDate(ParmBiz.getOracleTxDate(conn));
			wsBase.setWsTime(ParmBiz.getOracleUpDate(conn));
			wsBase.setTxCode("B100007");
			wsBase.setWsSerial(CachecodeUtil.MFSPREFIX+uuid);
			wsBase.setRespDesc("��ѯ���˲�ѯ");
			wsBase.setWsSts("01");
			wsBase.setReqContent(xml);
			wsBase.setRespContent(result);

			wsBaseDao.insert(wsBase);
		} catch (Exception_Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) conn.close();
			} catch (SQLException e) {
				logger.error(e.getMessage());
				e.printStackTrace();
			}
		}
		return payInfoList ;
	
	}
	
	public List<PayInfo> readZfXmlB100007(String xml) {
//		String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><Package><Header><RequestType>B100007</RequestType><UUID>��ˮ��</UUID><ComId>ҵ��ϵͳ���</ComId><SendTime>������ʱ��</SendTime><Signed></Signed><ResultCode>10000</ResultCode><ResultMsg>�ɹ�</ResultMsg><MaxPage>100</MaxPage><PageSize>50</PageSize><PageNo>1</PageNo></Header><Body><PayInfoList><PayInfo><FlowNo>0000031000000880</FlowNo><TradeNo>000003120000000055092</TradeNo><TradeTypeNo>001</TradeTypeNo><EntryNo>1000000412</EntryNo><EntryTypeNo>00101</EntryTypeNo><RpayMoney>300000</RpayMoney><PayMoney>300000</PayMoney><EnTradeType>02</EnTradeType><PayTime>2016-12-23 10:03:55</PayTime><Status>32000</Status><Message>����ʧ����</Message></PayInfo></PayInfoList></Body></Package>";
		Document doc = null;
		List<PayInfo> payInfoList = null;
		try {
			doc = DocumentHelper.parseText(xml); // ���ַ���תΪXML
			Element rootElt = doc.getRootElement(); // ��ȡ���ڵ�
			Iterator iter = rootElt.elementIterator("Body"); // ��ȡ���ڵ��µ��ӽڵ�Body
			Element recordEle = (Element) iter.next();
			Iterator iterpayInfoList = recordEle.elementIterator("PayInfoList");
			PayInfo payInfo = null;
			while(iterpayInfoList.hasNext()){
				recordEle = (Element)iterpayInfoList.next();
				Iterator iterPayInfo = recordEle.elementIterator("PayInfo"); 
				payInfoList = new ArrayList<PayInfo>();
				while(iterPayInfo.hasNext()){
					recordEle = (Element) iterPayInfo.next();
					payInfo = new PayInfo();
					payInfo.setFlowNo(recordEle.elementTextTrim("EntryInfo"));//UUID
					payInfo.setTradeNo(recordEle.elementTextTrim("TradeNo").substring(CachecodeUtil.MFSPREFIX.length()));//��ˮ��
					payInfo.setTradeChannel(recordEle.elementTextTrim("TradeChannel"));
					payInfo.setTradeTypeNo(recordEle.elementTextTrim("TradeTypeNo"));//��������
					payInfo.setEntryNo(recordEle.elementTextTrim("EntryNo").substring(CachecodeUtil.MFSPREFIX.length()));//��Ŀ��
					payInfo.setEntryTypeNo(recordEle.elementTextTrim("EntryTypeNo"));//��Ŀ����
					payInfo.setRpayMoney(Double.parseDouble(recordEle.elementTextTrim("RpayMoney"))/100);
					payInfo.setPayMoney(Double.parseDouble(recordEle.elementTextTrim("PayMoney"))/100);
					payInfo.setEnTradeType(recordEle.elementTextTrim("EnTradeType"));
					payInfo.setPayTime(recordEle.elementTextTrim("PayTime"));
					payInfo.setStatus(recordEle.elementTextTrim("Status"));
					payInfo.setMessage(recordEle.elementTextTrim("Message"));
					payInfoList.add(payInfo);
				}
			}
		} catch (DocumentException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}
		return payInfoList;
	}
	
	/**
	 * ����֧�����ر�������Ӧ����
	 * @param payInfoList
	 */
	public void analyBack(List<PayInfo> payInfoList,List<String> backCntList){
		
		Connection conn = DBUtils.getConn();
		
		AcLoanBackLog albl = null;
		try {
			if(payInfoList!=null&&payInfoList.size()>0){
				for (PayInfo PayInfo : payInfoList) {
					albl = new AcLoanBackLog();
					String entryNo = PayInfo.getEntryNo();//��Ŀ��
					backCntList.remove(entryNo);//�Ƴ�֧����ѯ������Ŀ��
					albl.setBackCnt(entryNo);
					albl = acLoanBackLogDao.getByBackCnt(albl);
					if(!PUBConstant.BACK_STS_06.equals(albl.getBackSts())){//01 ������ 02 ���ͳɹ� 03 �����쳣 04 ����ʧ�� 05 �쳣�ص� 06 �ɹ��ص�;�Ѿ��ɹ��ص����ٴ���
						//����δ����Ϊ����״̬
						int result = 0;
						String resultSts = PayInfo.getStatus();// ����״̬
						int status = Integer.parseInt(resultSts);
						String resultMessage = PayInfo.getMessage();// ����������Ϣ
						String cardChn = PayInfo.getTradeChannel();//��ȡ֧������ �ȴ�֧�����ر��ļ���֧������
						// �ų�֧������ϸ���
						if (resultSts != null && resultSts.length() > 0) {
							String sql = "UPDATE AC_LOAN_BACK_LOG SET BACK_STS = '"+PUBConstant.BACK_STS_06+"'";
							// �ֵ�ת��
							if (status >= 10000 && status < 20000) {// ����Ϊ1XXXXʱ����Ϊ���׳ɹ�
								resultSts = "01";
//								albl.setBackSts(PUBConstant.BACK_STS_06);
//								result = JdbcDao.update(albl, "back_log_no='"+albl.getBackLogNo()+"' and back_cnt='"+entryNo+"' and back_sts <> '"+PUBConstant.BACK_STS_06+"'", "ac_loan_back_log", conn);
								result = JdbcDao.updateSql(sql+" WHERE back_log_no='"+albl.getBackLogNo()+"' and back_cnt='"+entryNo+"' and back_sts <> '"+PUBConstant.BACK_STS_06+"'", conn);
								if(result>0){
									conn.commit();
								}else{
									continue;
								}
							} else if (status >= 20000 && status < 31000) {// ����Ϊ31XXXʱ����Ϊ����δ��
								resultSts = "03";
							}else if(99999==status){
								resultSts = "04";//֧������99999Ϊδ��������
							}else {// ������Ϊʧ��
								resultSts = "02";
//								albl.setBackSts(PUBConstant.BACK_STS_06);
//								result = JdbcDao.update(albl, "back_log_no='"+albl.getBackLogNo()+"' and back_cnt='"+entryNo+"' and back_sts <> '"+PUBConstant.BACK_STS_06+"'", "ac_loan_back_log", conn);
								result = JdbcDao.updateSql(sql+" WHERE back_log_no='"+albl.getBackLogNo()+"' and back_cnt='"+entryNo+"' and back_sts <> '"+PUBConstant.BACK_STS_06+"'", conn);
								if(result>0){
									conn.commit();
								}else{
									continue;
								}
							}
							albl.setBackRes(resultSts);
							albl.setFailCaus(resultMessage);
							albl.setStatus(PayInfo.getStatus());
							albl.setCardChn(cardChn);
							// �൱��֧��������������
							dealZfBack(albl, conn);
						}
					}

				}
			}
			//֧��ϵͳ��û�в�ѯ������Ŀ�ţ�Ĭ�Ϸ�����Ϊ99990
			if(backCntList!=null&&backCntList.size()>0){
				for(String backCnt : backCntList){
					albl = new AcLoanBackLog();
					albl.setBackCnt(backCnt);
					albl = acLoanBackLogDao.getByBackCnt(albl);
					if(!PUBConstant.BACK_STS_06.equals(albl.getBackSts())){
						String resultMessage = "֧����������Ŀ";// ����������Ϣ
						albl.setBackRes("02");
						albl.setFailCaus(resultMessage);
						albl.setStatus("99990");
						// �൱��֧��������������
						dealZfBack(albl, conn);
					}
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}finally {
			try {
				if (conn != null) conn.close();
			} catch (SQLException e) {
				logger.error(e.getMessage());
				e.printStackTrace();
			}
		}
	}
	
	
	
	
	/**
	 * 
	 * @throws Exception 
	 * @���� DHCC-LIUJ
	 * @���� 2016-9-14
	 * @����	���͵�����֧���ſ�
	 */
	public  Map sendZfMes(List<AcLoanBackLog> acLoanBackLogList,String projNo,String traceNo,Connection conn) throws Exception {
		ZFHead zfHead = new ZFHead();
		zfHead.setRequestType("P100001");
		String uuid = acLoanBackLogList.get(0).getUuid();
		zfHead.setUUID(uuid);//�ӿ���ˮ��
		zfHead.setComId(CachecodeUtil.MFSPREFIX);
		zfHead.setComIP("11");
		zfHead.setSendTime(ParmBiz.getOracleUpDate2(conn));
		zfHead.setAsyn("0");
		Properties pathProperties = new Properties();
		pathProperties.load(Thread.currentThread().getContextClassLoader()
				.getResourceAsStream("application.properties"));
		String zfReturnUrl = pathProperties.getProperty("zfloanreturn.url");
		zfHead.setReturnUrl(zfReturnUrl);
		zfHead.setSigned("");
		zfHead.setClientType("0");
		zfHead.setPayCount(1);
		String headXml = XMLUtil.createHead(zfHead); // ͷ�ļ�
		
		BodyLoan bodyLoan = new BodyLoan();
		
		List<TradeInfo> tradeList = new ArrayList<TradeInfo>();
		
		TradeInfo tradeInfo = new TradeInfo();
		
		tradeInfo.setTradeNo(CachecodeUtil.MFSPREFIX+traceNo);
		tradeInfo.setTradeTypeNo(acLoanBackLogList.get(0).getBusOrderType());
		tradeInfo.setTotalEntryNum(acLoanBackLogList.size());
		
		EntryInfo entryInfo = null;
		List<EntryInfo> entryList = new ArrayList<EntryInfo>();

		//�ſ���Ϣ
		AcLoanLog acLoanLog = null;
		//�ſ���ϢList
		List<AcLoanLog> acLoanLogList = new ArrayList<AcLoanLog>();
		//�ۿ���Ϣ
		AcDebit acDebit = null;
		//�ۿ���Ϣlist
		List<AcDebit> acDebitList = new ArrayList<AcDebit>();
		//�˻���Ϣ
		AccountInfo accountInfo = null;
		
		SourceAccountInfo sourceAccountInfo = new SourceAccountInfo();//Դ
		TargetAccountInfo targetAccountInfo = new TargetAccountInfo();//Ŀ��
		
		for (AcLoanBackLog acLoanBackLog : acLoanBackLogList) {
			if(PUBConstant.BACK_STS_01.equals(acLoanBackLog.getBackType())){//�ſ�
				/*//��ȡ�ſ���Ϣ
				acLoanLog = new AcLoanLog();
				acLoanLog.setLoanLogNo(acLoanBackLog.getLoanLogNo());
				acLoanLog = acLoanLogDao.getById(acLoanLog);
				acLoanLogList.add(acLoanLog);
				
				entryInfo = new EntryInfo();
				
				List<SourceAccountInfo> sourceAccountInfoListfk = new ArrayList<SourceAccountInfo>();
				List<TargetAccountInfo> targetAccountInfoListfk = new ArrayList<TargetAccountInfo>();
				
				sourceAccountInfo = new SourceAccountInfo();// Դ
				targetAccountInfo = new TargetAccountInfo();// Ŀ��

				entryInfo.setEntryNo(acLoanBackLog.getBackCnt());
				entryInfo.setEnTradeType("01");// �ſ�
				entryInfo.setAmount(acLoanLog.getLoanAmt());
				entryInfo.setEntryTypeNo(acLoanBackLog.getBusEntryType());
				entryInfo.setChannelNo(acLoanLog.getCardChn());

				accountInfo = new AccountInfo();
				// Դ
				accountInfo.setAccountNo(acLoanLog.getXtAcNo());
				accountInfo.setAccountType("0");
				sourceAccountInfo.setLevel("01");
				sourceAccountInfo.setAccountInfo(accountInfo);
				sourceAccountInfoListfk.add(sourceAccountInfo);

				accountInfo = new AccountInfo();

				// Ŀ��
				accountInfo.setAccountNo(acLoanLog.getLoanAcNo());
				accountInfo.setAccountType("0");
				targetAccountInfo.setLevel("01");
				targetAccountInfo.setAccountInfo(accountInfo);
				targetAccountInfoListfk.add(targetAccountInfo);
				entryInfo.setRemark1(acLoanLog.getBrNo());
				entryInfo.setRemark2(projNo);
				entryInfo.setRemark3(acLoanLog.getPactNo());
				entryInfo.setSourceAccountList(sourceAccountInfoListfk);
				entryInfo.setTargetAccountList(targetAccountInfoListfk);

				entryList.add(entryInfo);*/
			}else{
				acDebit = new AcDebit();
				acDebit.setDebitNo(acLoanBackLog.getLoanLogNo());
				acDebit = acDebitDao.getByDebitNo(acDebit);
				acDebitList.add(acDebit);
				
				entryInfo = new EntryInfo();
				
				entryInfo.setEntryNo(acLoanBackLog.getBackCnt());
				entryInfo.setEnTradeType("02");//�ۿ�
				entryInfo.setAmount(acDebit.getAtpyAmt());
				entryInfo.setEntryTypeNo(acDebit.getBusEntryType());
				entryInfo.setChannelNo(acDebit.getCardChn());
//				entryInfo.setChannelNo("CL0002");
				
				accountInfo = new AccountInfo();
				
				List<SourceAccountInfo> sourceAccountInfoListsk = new ArrayList<SourceAccountInfo>();
				List<TargetAccountInfo> targetAccountInfoListsk = new ArrayList<TargetAccountInfo>();
				
				/*sourceAccountInfo = new SourceAccountInfo();//Դ1
				targetAccountInfo = new TargetAccountInfo();//Ŀ��
				//Դ���ͻ�������ɿ��˻������п��� Ŀ�ģ���Ŀ�˻�
				accountInfo.setAccountNo(CachecodeUtil.MFSPREFIX+"_"+acDebit.getBrNo()+"_"+acDebit.getPactNo());//֧��ƽ̨�˻�
				accountInfo.setAccountType("0");
				sourceAccountInfo.setLevel("01");
				sourceAccountInfo.setAccountInfo(accountInfo);
				sourceAccountInfoListsk.add(sourceAccountInfo);*/
				
				accountInfo = new AccountInfo();
				
				sourceAccountInfo = new SourceAccountInfo();//Դ2
				
				accountInfo.setAccountNo(acDebit.getAcNo());//���п�
				if("10".equals(acDebit.getAcType())){//���˴��ǿ�
					accountInfo.setAccountType("3");
				}else if("11".equals(acDebit.getAcType())){//���˽�ǿ�
					accountInfo.setAccountType("1");
				}else if("12".equals(acDebit.getAcType())||"13".equals(acDebit.getAcType())||"14".equals(acDebit.getAcType())){//��ҵ�˻������磩
					accountInfo.setAccountType("0");
				}
				accountInfo.setAccountName(acDebit.getAcName());
				accountInfo.setChannelNo(acDebit.getAcctBankCde());
				accountInfo.setBankDetailNo("");
				accountInfo.setBankName(acDebit.getBankSite());
				accountInfo.setProvince(acDebit.getBankProv());
				accountInfo.setCity(acDebit.getBankCity());
				accountInfo.setCVN2(acDebit.getCvvNo()!=null?acDebit.getCvvNo():"");
				accountInfo.setVALDATE(acDebit.getValidDate()!=null?acDebit.getValidDate():"");
				accountInfo.setPhoneNo(acDebit.getPhoneNo()!=null?acDebit.getPhoneNo():"");
				accountInfo.setEmail("");
				accountInfo.setCertificateType(acDebit.getIdType()!=null?acDebit.getIdType():"");
				accountInfo.setCertificateNo(acDebit.getIdNo()!=null?acDebit.getIdNo():"");
				sourceAccountInfo.setLevel("01");
				sourceAccountInfo.setAccountInfo(accountInfo);
				sourceAccountInfoListsk.add(sourceAccountInfo);
				
				accountInfo = new AccountInfo();
				
//				accountInfo.setAccountNo(acDebit.getXtAcNo());//��Ŀ�տ��˻�
				accountInfo.setAccountNo(CachecodeUtil.MFSPREFIX+"_"+PUBConstant.ACCT_TYPE_04+"_"+projNo);//��Ŀ�տ��˻�
				accountInfo.setAccountType("0");
				targetAccountInfo.setLevel("01");
				targetAccountInfo.setAccountInfo(accountInfo);
				targetAccountInfoListsk.add(targetAccountInfo);
				
				entryInfo.setRemark1(acDebit.getBrNo());
				entryInfo.setRemark2(projNo);
				entryInfo.setRemark3(acDebit.getPactNo());
				entryInfo.setSourceAccountList(sourceAccountInfoListsk);
				entryInfo.setTargetAccountList(targetAccountInfoListsk);
				entryList.add(entryInfo);
			}
			
		}
		tradeInfo.setEntryList(entryList);
		tradeList.add(tradeInfo);
		bodyLoan.setTradeList(tradeList);
		String bodyXml = XMLUtil.createBody(bodyLoan);// ת��ΪXML

		String xml = headXml + bodyXml + "</Package>";

		Jedis jedis = RedisUtil.getJedis();
		jedis.lpush(RedisUtil.QUEUE7, xml);// 
		jedis.close();
		return null ;
	}
	public List<WsRepyMes> getByBatch(String batchNo) throws ServiceException {
		List<WsRepyMes> wsRepyMesList = new ArrayList<WsRepyMes>();
		try {
			wsRepyMesList = wsRepyMesDao.getByBatch(batchNo);
			for(WsRepyMes WsRepyMes : wsRepyMesList){
				Jedis jedis = RedisUtil.getJedis();
    			jedis.lpush(RedisUtil.QUEUE10, WsRepyMes.getWsId());// 
    			jedis.close();
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return wsRepyMesList;
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
	

	 /**

  * @description ��xml�ַ���ת����map

  * @param xml

  * @return Map

  */

	public static Map readZfXmlB100003(String xml) {

		Map map = new HashMap();

		Document doc = null;

		try {
			doc = DocumentHelper.parseText(xml); // ���ַ���תΪXML

			Element rootElt = doc.getRootElement(); // ��ȡ���ڵ�

			Iterator iter = rootElt.elementIterator("Body"); // ��ȡ���ڵ��µ��ӽڵ�Body

			Element recordEle = (Element) iter.next();
			
			Iterator iterPayInfo = recordEle.elementIterator("PayInfo"); 

			recordEle = (Element) iterPayInfo.next();

			String BatchNo = recordEle.elementTextTrim("BatchNo");
			map.put("BatchNo", BatchNo);

			String OrderNo = recordEle.elementTextTrim("OrderNo");
			map.put("OrderNo", OrderNo);

			String BusinessOrderType = recordEle.elementTextTrim("BusinessOrderType");
			map.put("BusinessOrderType", BusinessOrderType);

			String EntryNo = recordEle.elementTextTrim("EntryNo");
			map.put("EntryNo", EntryNo);

			String BusinessEntryNo = recordEle.elementTextTrim("BusinessEntryNo");
			map.put("BusinessEntryNo", BusinessEntryNo);

			String Amount = recordEle.elementTextTrim("Amount");
			map.put("Amount", Amount);

			String PayChannel = recordEle.elementTextTrim("PayChannel");
			map.put("PayChannel", PayChannel);
			
			String TradeType = recordEle.elementTextTrim("TradeType");
			map.put("TradeType", TradeType);
			
			String PayTime = recordEle.elementTextTrim("PayTime");
			map.put("PayTime", PayTime);
			
			String Status = recordEle.elementTextTrim("Status");
			map.put("Status", Status);
			
			String Message = recordEle.elementTextTrim("Message");
			map.put("Message", Message);

		} catch (DocumentException e) {

			e.printStackTrace();

		} catch (Exception e) {

			e.printStackTrace();

		}

		return map;

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
	public void del(AcDebitSusp acDebitSusp) throws ServiceException {
		try {
			acDebitSuspDao.del(acDebitSusp);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}

	public Ipage findByPage(Ipage ipg, AcDebitSusp acDebitSusp)
			throws ServiceException {
		try {
			ipg.initPageCounts(new Integer[] { (Integer) acDebitSuspDao
					.getCount(acDebitSusp) });// ��ʼ����ҳ��
			acDebitSusp.setStartNumAndEndNum(ipg);
			ipg.setResult(acDebitSuspDao.findByPage(acDebitSusp));
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return ipg;
	}

	public AcDebitSusp getById(AcDebitSusp acDebitSusp) throws ServiceException {
		try {
			acDebitSusp = acDebitSuspDao.getById(acDebitSusp);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return acDebitSusp;
	}

	public void insert(AcDebitSusp acDebitSusp) throws ServiceException {
		try {
			acDebitSuspDao.insert(acDebitSusp);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}

	public void update(AcDebitSusp acDebitSusp) throws ServiceException {
		try {
			acDebitSuspDao.update(acDebitSusp);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}

	public AcDebitSuspDao getAcDebitSuspDao() {
		return acDebitSuspDao;
	}

	public void setAcDebitSuspDao(AcDebitSuspDao acDebitSuspDao) {
		this.acDebitSuspDao = acDebitSuspDao;
	}

	public WsRepyMesDao getWsRepyMesDao() {
		return wsRepyMesDao;
	}

	public void setWsRepyMesDao(WsRepyMesDao wsRepyMesDao) {
		this.wsRepyMesDao = wsRepyMesDao;
	}

	public AcLnRepayPlnCurDao getAcLnRepayPlnCurDao() {
		return acLnRepayPlnCurDao;
	}

	public void setAcLnRepayPlnCurDao(AcLnRepayPlnCurDao acLnRepayPlnCurDao) {
		this.acLnRepayPlnCurDao = acLnRepayPlnCurDao;
	}

	public AcLnMstDao getAcLnMstDao() {
		return acLnMstDao;
	}

	public void setAcLnMstDao(AcLnMstDao acLnMstDao) {
		this.acLnMstDao = acLnMstDao;
	}

	public AcLnLoDao getAcLnLoDao() {
		return acLnLoDao;
	}

	public void setAcLnLoDao(AcLnLoDao acLnLoDao) {
		this.acLnLoDao = acLnLoDao;
	}

	public AftRepyClearDao getAftRepyClearDao() {
		return aftRepyClearDao;
	}

	public void setAftRepyClearDao(AftRepyClearDao aftRepyClearDao) {
		this.aftRepyClearDao = aftRepyClearDao;
	}

	public AcTraceLogDao getAcTraceLogDao() {
		return acTraceLogDao;
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public LnDueDao getLnDueDao() {
		return lnDueDao;
	}

	public AcDebitDao getAcDebitDao() {
		return acDebitDao;
	}

	public ProjAcctDao getProjAcctDao() {
		return projAcctDao;
	}

	public void setAcTraceLogDao(AcTraceLogDao acTraceLogDao) {
		this.acTraceLogDao = acTraceLogDao;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void setLnDueDao(LnDueDao lnDueDao) {
		this.lnDueDao = lnDueDao;
	}

	public void setAcDebitDao(AcDebitDao acDebitDao) {
		this.acDebitDao = acDebitDao;
	}

	public void setProjAcctDao(ProjAcctDao projAcctDao) {
		this.projAcctDao = projAcctDao;
	}

	public AcLoanBackLogDao getAcLoanBackLogDao() {
		return acLoanBackLogDao;
	}

	public CorpAcctDao getCorpAcctDao() {
		return corpAcctDao;
	}

	public void setAcLoanBackLogDao(AcLoanBackLogDao acLoanBackLogDao) {
		this.acLoanBackLogDao = acLoanBackLogDao;
	}

	public void setCorpAcctDao(CorpAcctDao corpAcctDao) {
		this.corpAcctDao = corpAcctDao;
	}

	public LnAcctDao getLnAcctDao() {
		return lnAcctDao;
	}

	public void setLnAcctDao(LnAcctDao lnAcctDao) {
		this.lnAcctDao = lnAcctDao;
	}

	public AcLoanLogDao getAcLoanLogDao() {
		return acLoanLogDao;
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

	public AcLnPmLogDao getAcLnPmLogDao() {
		return acLnPmLogDao;
	}

	public AcChrgLogDao getAcChrgLogDao() {
		return acChrgLogDao;
	}

	public void setAcLnPmLogDao(AcLnPmLogDao acLnPmLogDao) {
		this.acLnPmLogDao = acLnPmLogDao;
	}

	public void setAcChrgLogDao(AcChrgLogDao acChrgLogDao) {
		this.acChrgLogDao = acChrgLogDao;
	}

	public AcLnRepayPlnDao getAcLnRepayPlnDao() {
		return acLnRepayPlnDao;
	}

	public void setAcLnRepayPlnDao(AcLnRepayPlnDao acLnRepayPlnDao) {
		this.acLnRepayPlnDao = acLnRepayPlnDao;
	}

	public AcDebit getAcDebit() {
		return acDebit;
	}

	public void setAcDebit(AcDebit acDebit) {
		this.acDebit = acDebit;
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

	public void setWsRepyFineDao(WsRepyFineDao wsRepyFineDao) {
		this.wsRepyFineDao = wsRepyFineDao;
	}


	public WsRepyClearDao getWsRepyClearDao() {
		return wsRepyClearDao;
	}


	public void setWsRepyClearDao(WsRepyClearDao wsRepyClearDao) {
		this.wsRepyClearDao = wsRepyClearDao;
	}


	public WsRepyMes getWsRepyMes() {
		return wsRepyMes;
	}


	public void setWsRepyMes(WsRepyMes wsRepyMes) {
		this.wsRepyMes = wsRepyMes;
	}


	public WsRepyFeeDao getWsRepyFeeDao() {
		return wsRepyFeeDao;
	}


	public void setWsRepyFeeDao(WsRepyFeeDao wsRepyFeeDao) {
		this.wsRepyFeeDao = wsRepyFeeDao;
	}
}