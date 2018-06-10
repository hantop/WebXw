package app.creditapp.approve.bo.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import redis.clients.jedis.Jedis;
import accounting.biz.pub.ParmBiz;
import accounting.interf.cancel.ReverseTrace;
import accounting.plat.PUBConstant;
import accounting.plat.TransCode;
import app.base.BaseService;
import app.base.ServiceException;
import app.base.httpclient.entity.SendMessageEntity;
import app.base.httpclient.entity.SendMessageType;
import app.base.httpclient.work.SendMessageMain;
import app.creditapp.acc.chg.dao.AftReliefDao;
import app.creditapp.acc.chg.entity.AftRelief;
import app.creditapp.acc.loan.dao.AcLnLoDao;
import app.creditapp.acc.loan.dao.AcLnMstDao;
import app.creditapp.acc.loan.entity.AcLnLo;
import app.creditapp.acc.loan.entity.AcLnMst;
import app.creditapp.acc.log.dao.AcChrgLogDao;
import app.creditapp.acc.log.dao.AcTraceLogDao;
import app.creditapp.acc.log.entity.AcChrgLog;
import app.creditapp.acc.log.entity.AcTraceLog;
import app.creditapp.acc.option.dao.AcLnRepayPlnDao;
import app.creditapp.acc.option.entity.AcLnRepayPln;
import app.creditapp.aft.dao.AftReliefDtlDao;
import app.creditapp.aft.entity.AftReliefDtl;
import app.creditapp.aft.entity.aftMessage.PasSubTypeEntity;
import app.creditapp.approve.bo.ApproveAftBo;
import app.creditapp.inf.dao.WsRedctnDao;
import app.creditapp.inf.entity.WsRedctn;
import app.creditapp.ln.bo.LnApprIdeaBo;
import app.creditapp.ln.entity.LnApprIdea;
import app.creditapp.ln.worker.WorkDforPact;
import app.creditapp.redis.util.RedisUtil;
import app.creditapp.wkf.AppConstant;
import app.creditapp.wkf.entity.Result;
import app.creditapp.wkfinterface.WkfInterface;
import app.util.DateUtil;
import app.util.User;

import com.alibaba.fastjson.JSON;
import com.dhcc.workflow.WFUtil;

/**
 * ��˵��
 * 
 */
public class ApproveAftBoImpl extends BaseService implements ApproveAftBo {
	Logger logger = Logger.getLogger(WorkDforPact.class);
	private WkfInterface wkfInterface;
	private AftReliefDao aftReliefDao;
	private LnApprIdeaBo lnApprIdeaBo;
	private String taskId;
	private AcTraceLogDao acTraceLogDao;
	private AcLnMstDao acLnMstDao;
	private AcChrgLogDao acChrgLogDao;
	private AcLnLoDao acLnLoDao;
	private AftReliefDtlDao aftReliefDtlDao;
	private DataSource dataSource;
	private AcLnRepayPlnDao acLnRepayPlnDao;
	private WsRedctnDao wsRedctnDao ;

	public Result doCommit(String taskId, String refId, String processId,
			String apprOp, LnApprIdea lnApprIdea, String apprIdea,
			String apprDesc, String transition, String tlrno, String nextUser,
			String roleName, String nextBranch) throws ServiceException {

		Result res = null;
		try {
			if (null != taskId) {
				String[] nextRole = WFUtil.getTaskService().getNextTaskExecutor(taskId);
				res = wkfInterface.doCommit(taskId, apprIdea, apprDesc,
						transition, tlrno, nextUser, "", nextBranch);

				AftRelief aftRelief = new AftRelief();

				if (AppConstant.OPINION_TYPE_ARREE.equals(apprIdea)) {
					if (res.isProcessEnd()) {// �ɹ����������º�ͬ��Ϊ������ͨ����
						// ���º�ͬ��״̬������ͨ��
						aftRelief.setRefId(refId);
						aftRelief = aftReliefDao.getById(aftRelief);
						aftRelief.setAppSts("03");// ����״̬Ϊͨ��
						aftRelief.setRefSts("03");// ״̬Ϊͨ��
						aftReliefDao.update(aftRelief);
						this.execAftRelief(aftRelief);
//						ReverseTrace reverseTrace = new ReverseTrace();
//						reverseTrace.setReverseTraceNo(Long.parseLong(aftRelief.getTraceNo()));
						// push��5����Ϣ����
						Jedis jedis = RedisUtil.getJedis();
						jedis.lpush(RedisUtil.QUEUE5, JSON
								.toJSONString(aftRelief));
						logger.info("�˹�����ͨ��-[����IdΪBlkId=" + aftRelief.getRefId()
								+ "]��");

					} else {
						aftRelief.setRefId(refId);
						aftRelief = aftReliefDao.getById(aftRelief);
						aftRelief.setAppSts("02");// ����״̬Ϊ������
						aftReliefDao.update(aftRelief);
						String RoleNo = nextRole[1];//��ȡ��һ�����̽ڵ��ɫ
						SendMessageEntity sendMessageEntity=new SendMessageEntity();//������Ϣ
						String title="Ϣ�Ѽ���";
			            String contet="�д�����ҵ��";
				    	sendMessageEntity.setTitle(title);
				    	sendMessageEntity.setContet(contet);
				    	sendMessageEntity.setGroupNo(RoleNo);
				    	sendMessageEntity.setSendType(SendMessageType.MESSAGE);
				    	sendMessageEntity.setPasSubTypeEntity(PasSubTypeEntity.RewFundMessage);
				    	SendMessageMain.sendMessage(sendMessageEntity);	
					}
				} else if (AppConstant.OPINION_TYPE_REFUSE.equals(apprIdea)) {// ����������Ϊ���
					aftRelief.setRefId(refId);
					aftRelief = aftReliefDao.getById(aftRelief);
					aftRelief.setRefSts("04");
					aftRelief.setAppSts("04");// ����״̬Ϊ���
					aftReliefDao.update(aftRelief);
				}
				// lnPactDao.updateSts(lnPact);
				lnApprIdea.setAppId(refId);
				lnApprIdea.setApprTime(DateUtil.getDateTime());
				lnApprIdea.setApprIdea(apprIdea);
				lnApprIdea.setApprDesc(apprDesc);
				lnApprIdea.setApprOp(apprOp);
				lnApprIdea.setApprRole(User.getWkfUserRoleNos(ServletActionContext.getRequest()).split("@")[0]);
				// //������ȡ������½Ա��ɫ��
//				lnApprIdea.setApprRole(apprOp);
				lnApprIdea.setApprType("02");
				lnApprIdea.setApprKind("04");
				lnApprIdeaBo.insert(lnApprIdea);
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return res;
	}

	/**
	 * Ϣ�Ѽ��� ȷ�ϲ���
	 */
	public void execAftRelief(AftRelief aftRelief) throws ServiceException {
		Connection conn = this.getConnection();

		try {
			AcTraceLog acTraceLog = new AcTraceLog();
			String traceNo =  acTraceLogDao.getKey();
			
			AcLnMst acLnMst = new AcLnMst();
			acLnMst.setPactNo(aftRelief.getPactNo());
			acLnMst.setBrNo(aftRelief.getBrNo());
			acLnMst = acLnMstDao.getByPactNo(acLnMst);
			AcChrgLog acChrgLog = new AcChrgLog();
			acChrgLog.setLoanNo(acLnMst.getLoanNo());
			//Ƿ��
			double loFee = acChrgLogDao.getLoFeeAmt(acChrgLog);
			aftRelief.setLoFee(loFee);
			AcLnLo acLnLo = new AcLnLo();
			
			acLnLo.setLoanNo(acLnMst.getLoanNo());
			acLnLo = acLnLoDao.getLoAmt(acLnLo);
			//Ƿ��
			double loPrcp = acLnLo.getPrcpAmt();
			aftRelief.setLoAmt(loPrcp);
			//ǷϢ
			double loNorm = acLnLo.getNormInt();
			aftRelief.setLoIntst(loNorm);
			//Ƿ��
			double loFine = acLnLo.getFineInt();
			aftRelief.setLoFine(loFine);
			
			//���Ȿ��
			double refAmt = aftRelief.getRefAmt();
			//������Ϣ
			double refIntst = aftRelief.getRefIntst();
			//���ⷣϢ
			double refFine = aftRelief.getRefFine();
			//�������
			double refFee = aftRelief.getRefFee();
			
			//��ȡÿ��Ƿ���¼
			List<AcLnLo> acLnLoList = new ArrayList<AcLnLo>();
			acLnLo.setLoanNo(acLnMst.getLoanNo());
			acLnLoList = acLnLoDao.getListByLoanNo(acLnLo);
			
			//��ȡÿ��Ƿ�Ѽ�¼
			List<AcChrgLog> acChrgLogList = acChrgLogDao.getLoFeeList(acChrgLog);
			
			for(AcLnLo alo : acLnLoList){
				AftReliefDtl aftReliefDtl = new AftReliefDtl();
				aftReliefDtl.setTraceNo(traceNo);
				aftReliefDtl.setLoanNo(acLnMst.getLoanNo());
				aftReliefDtl.setPactNo(acLnMst.getPactNo());
				aftReliefDtl.setBrNo(acLnMst.getBrNo());
				aftReliefDtl.setReliefType("01");
				aftReliefDtl.setRefFee(0.00);
				aftReliefDtl.setTxDt(ParmBiz.getOracleTxDate(conn));
				//��ȡǷ����Ϣ
				AcLnLo newAlo = acLnLoDao.getById(alo);
				aftReliefDtl.setPerdNo(String.valueOf(newAlo.getPerdNo()));
				
				//��ȡ����ƻ�
				AcLnRepayPln acLnRepayPln = new AcLnRepayPln();
				acLnRepayPln.setLoanNo(newAlo.getLoanNo());
				acLnRepayPln.setPerdNo(newAlo.getPerdNo());
				acLnRepayPln = acLnRepayPlnDao.getById(acLnRepayPln);
				
				//�жϱ��μ��Ȿ���Ƿ���ڱ���Ƿ���������ڼ��Ȿ����Ƿ����Ϣ�еļ�����+����Ƿ�����������Ȿ����٣��������ڼ���
				if (refAmt > 0) {
					if ((refAmt - alo.getPrcpAmt()) >= 0) {
						newAlo.setWvPrcpAmt(newAlo.getWvPrcpAmt()
								+ alo.getPrcpAmt());
						acLnRepayPln.setWvPrcpAmt(acLnRepayPln.getWvPrcpAmt()+alo.getPrcpAmt());
						aftReliefDtl.setRefAmt(alo.getPrcpAmt());
						refAmt = refAmt - alo.getPrcpAmt();
					} else {
						newAlo.setWvPrcpAmt(newAlo.getWvPrcpAmt() + refAmt);
						acLnRepayPln.setWvPrcpAmt(acLnRepayPln.getWvPrcpAmt() + refAmt);
						aftReliefDtl.setRefAmt(refAmt);
						refAmt = 0.00;
					}
				}
				//������Ϣ����
				if (refIntst > 0) {
					if ((refIntst - alo.getNormInt()) >= 0) {
						newAlo.setWvNormInt(newAlo.getWvNormInt()
								+ alo.getNormInt());
						acLnRepayPln.setWvNormInt(acLnRepayPln.getWvNormInt() + alo.getNormInt());
						aftReliefDtl.setRefIntst(alo.getNormInt());

						refIntst = refIntst - alo.getNormInt();
					} else {
						newAlo.setWvNormInt(newAlo.getWvNormInt() + refIntst);
						acLnRepayPln.setWvNormInt(acLnRepayPln.getWvNormInt() + refIntst);

						aftReliefDtl.setRefIntst(refIntst);

						refIntst = 0.00;
					}
				}
				//���ⷣϢ����
				if (refFine > 0) {
					if ((refFine - alo.getFineInt()) >= 0) {
						newAlo.setWvFineInt(newAlo.getWvFineInt()
								+ alo.getFineInt());
						acLnRepayPln.setWvFineInt(acLnRepayPln.getWvFineInt() + alo.getFineInt());
						aftReliefDtl.setRefFine(alo.getFineInt());

						refFine = refFine - alo.getFineInt();
					} else {
						newAlo.setWvFineInt(newAlo.getWvFineInt() + refFine);
						acLnRepayPln.setWvFineInt(acLnRepayPln.getWvFineInt() + refFine);
						aftReliefDtl.setRefFine(refFine);

						refFine = 0.00;
					}
				}
				acLnRepayPlnDao.update(acLnRepayPln);
				acLnLoDao.update(newAlo);
				aftReliefDtlDao.insert(aftReliefDtl);
			}
			
			for(AcChrgLog acl : acChrgLogList){
				AftReliefDtl aftReliefDtl = new AftReliefDtl();
				aftReliefDtl.setTraceNo(traceNo);
				aftReliefDtl.setLoanNo(acLnMst.getLoanNo());
				aftReliefDtl.setPactNo(acLnMst.getPactNo());
				aftReliefDtl.setBrNo(acLnMst.getBrNo());
				aftReliefDtl.setReliefType("02");
				aftReliefDtl.setRefAmt(0.00);
				aftReliefDtl.setRefIntst(0.00);
				aftReliefDtl.setRefFine(0.00);
				aftReliefDtl.setTxDt(ParmBiz.getOracleTxDate(conn));
				
				AcChrgLog newAcl = acChrgLogDao.getById(acl);
				aftReliefDtl.setPerdNo(newAcl.getPerdNo());
				if (refFee > 0) {
					if ((refFee - acl.getChrgAmt()) >= 0) {
						newAcl.setWvChrgAmt(newAcl.getWvChrgAmt()
								+ acl.getChrgAmt());
						aftReliefDtl.setRefFee(acl.getChrgAmt());
						refFee = refFee - acl.getChrgAmt();
					} else {
						newAcl.setWvChrgAmt(newAcl.getWvChrgAmt() + refFee);
						aftReliefDtl.setRefFee(refFee);
						refFee = 0.00;
					}
				}
				
				acChrgLogDao.update(newAcl);
				aftReliefDtlDao.insert(aftReliefDtl);
			}
			
			acTraceLog.setTraceNo(traceNo);
			acTraceLog.setTraceCnt(1);
			acTraceLog.setTxDt(ParmBiz.getOracleTxDate(conn));
			acTraceLog.setTxTime(ParmBiz.getOracleTxTime(conn));
			acTraceLog.setTxBrNo(aftRelief.getBrNo());
			acTraceLog.setTxCde(TransCode.LNWV);
			acTraceLog.setSubTxCde(TransCode.LNWV);
			acTraceLog.setSvcInd(TransCode.LNWV);
			acTraceLog.setCurNo(acLnMst.getCurNo());
			acTraceLog.setPrdtNo(acLnMst.getPrdtNo());
			acTraceLog.setAmt(aftRelief.getRefAmt()+aftRelief.getRefFee()+aftRelief.getRefFine()+aftRelief.getRefIntst());
			acTraceLog.setCancelInd(PUBConstant.REV_ROL_NORM);//����
			acTraceLog.setAppSts("01");//����
			acTraceLog.setBrNo(aftRelief.getBrNo());
			acTraceLog.setPactNo(aftRelief.getPactNo());
			acTraceLog.setLoanNo(acLnMst.getLoanNo());
			acTraceLog.setMemo("Ϣ�Ѽ���");
			
			acTraceLogDao.insert(acTraceLog);
			
			//Ϣ�Ѽ��� ��������������ļ����
			acLnMst.setLoanBal(acLnMst.getLoanBal()-aftRelief.getRefAmt());
			acLnMst.setUpDt(ParmBiz.getOracleTxDate(conn));
			acLnMstDao.update(acLnMst);
			
			//�Ѵ���
			aftRelief.setRefSts("03");
			aftRelief.setTraceNo(traceNo);
			aftReliefDao.update(aftRelief);
			
			if(aftRelief.getRefId().length()>10){//��Ŵ���10����˵���ü���Ϊ�������������
				WsRedctn wsRedctn = new WsRedctn();
				wsRedctn.setWsId(aftRelief.getRefId());
				wsRedctn = wsRedctnDao.getById(wsRedctn);
				wsRedctn.setDealSts("03");
				wsRedctn.setDealDesc("����ɹ�");
				wsRedctnDao.update(wsRedctn);
			}
			
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
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
	
//	private HttpServletRequest getHttpRequest() {
//		return null;
//	}

	public WkfInterface getWkfInterface() {
		return wkfInterface;
	}

	public void setWkfInterface(WkfInterface wkfInterface) {
		this.wkfInterface = wkfInterface;
	}

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public LnApprIdeaBo getLnApprIdeaBo() {
		return lnApprIdeaBo;
	}

	public void setLnApprIdeaBo(LnApprIdeaBo lnApprIdeaBo) {
		this.lnApprIdeaBo = lnApprIdeaBo;
	}

	public Logger getLogger() {
		return logger;
	}

	public void setLogger(Logger logger) {
		this.logger = logger;
	}

	public AftReliefDao getAftReliefDao() {
		return aftReliefDao;
	}

	public void setAftReliefDao(AftReliefDao aftReliefDao) {
		this.aftReliefDao = aftReliefDao;
	}

	public AcTraceLogDao getAcTraceLogDao() {
		return acTraceLogDao;
	}

	public AcLnMstDao getAcLnMstDao() {
		return acLnMstDao;
	}

	public AcChrgLogDao getAcChrgLogDao() {
		return acChrgLogDao;
	}

	public AcLnLoDao getAcLnLoDao() {
		return acLnLoDao;
	}

	public AftReliefDtlDao getAftReliefDtlDao() {
		return aftReliefDtlDao;
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setAcTraceLogDao(AcTraceLogDao acTraceLogDao) {
		this.acTraceLogDao = acTraceLogDao;
	}

	public void setAcLnMstDao(AcLnMstDao acLnMstDao) {
		this.acLnMstDao = acLnMstDao;
	}

	public void setAcChrgLogDao(AcChrgLogDao acChrgLogDao) {
		this.acChrgLogDao = acChrgLogDao;
	}

	public void setAcLnLoDao(AcLnLoDao acLnLoDao) {
		this.acLnLoDao = acLnLoDao;
	}

	public void setAftReliefDtlDao(AftReliefDtlDao aftReliefDtlDao) {
		this.aftReliefDtlDao = aftReliefDtlDao;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public AcLnRepayPlnDao getAcLnRepayPlnDao() {
		return acLnRepayPlnDao;
	}

	public void setAcLnRepayPlnDao(AcLnRepayPlnDao acLnRepayPlnDao) {
		this.acLnRepayPlnDao = acLnRepayPlnDao;
	}

	public WsRedctnDao getWsRedctnDao() {
		return wsRedctnDao;
	}

	public void setWsRedctnDao(WsRedctnDao wsRedctnDao) {
		this.wsRedctnDao = wsRedctnDao;
	}

}
