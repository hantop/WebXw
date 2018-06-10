package  app.creditapp.acc.chg.bo.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import accounting.biz.pub.ParmBiz;
import accounting.plat.PUBConstant;
import accounting.plat.TransCode;
import app.base.BaseService;
import app.base.ServiceException;
import app.base.httpclient.entity.SendMessageEntity;
import app.base.httpclient.entity.SendMessageType;
import app.base.httpclient.work.SendMessageMain;
import app.creditapp.acc.chg.bo.AftReliefBo;
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
import app.creditapp.inf.dao.WsRedctnDao;
import app.creditapp.inf.entity.WsRedctn;
import app.creditapp.wkf.bo.WkfApprovalUserBo;
import app.creditapp.wkf.entity.AppWkfcfg;
import app.creditapp.wkf.entity.WkfApprovalUser;
import app.creditapp.wkf.entity.WkfParm;
import app.creditapp.wkfinterface.WkfInterface;
import app.util.toolkit.Ipage;

import com.dhcc.workflow.WFUtil;
import com.dhcc.workflow.api.WorkflowException;
import com.dhcc.workflow.api.task.Task;
import com.dhcc.workflow.pvm.internal.task.TaskConstants;
/**
* Title: AftReliefBoImplImpl.java
* Description:
**/
public class AftReliefBoImpl extends BaseService implements AftReliefBo {

	private AftReliefDao aftReliefDao;
	private AcLnMstDao acLnMstDao;
	private AcChrgLogDao acChrgLogDao;
	private AcLnLoDao acLnLoDao;
	private AcTraceLogDao acTraceLogDao;
	private DataSource dataSource;
	private AftReliefDtlDao aftReliefDtlDao;
	private WkfApprovalUserBo wkfApprovalUserBo;
	private WkfInterface wkfInterface;
	private AcLnRepayPlnDao acLnRepayPlnDao;
	private WsRedctnDao wsRedctnDao;
	
	public void del(AftRelief aftRelief) throws ServiceException {
		try {
			aftReliefDao.del(aftRelief);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}

	public Ipage findByPage(Ipage ipg, AftRelief aftRelief)
			throws ServiceException {
		try {
			ipg.initPageCounts(new Integer[] { (Integer) aftReliefDao
					.getCount(aftRelief) });// ��ʼ����ҳ��
			aftRelief.setStartNumAndEndNum (ipg);
			ipg.setResult(aftReliefDao.findByPage(aftRelief));
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return ipg;
	}
	
	public Ipage findByPageForTask(Ipage ipg, AftRelief aftRelief)
			throws ServiceException {
		try {
			ipg.initPageCounts(new Integer[] { (Integer) aftReliefDao
					.getCountForTask(aftRelief) });// ��ʼ����ҳ��
			aftRelief.setStartNumAndEndNum(ipg);
			ipg.setResult(aftReliefDao.findByPageForTask(aftRelief));
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return ipg;
	}

	public AftRelief getById(AftRelief aftRelief) throws ServiceException {
		try {
			aftRelief = aftReliefDao.getById(aftRelief);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return aftRelief;
	}
	public AftRelief getByIdForTrace(AftRelief aftRelief) throws ServiceException {
		try {
			aftRelief = aftReliefDao.getByIdForTrace(aftRelief);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return aftRelief;
	}

	public void insert(AftRelief aftRelief) throws ServiceException {
		try {
			aftReliefDao.insert(aftRelief);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}

	public void update(AftRelief aftRelief) throws ServiceException {
		try {
			aftReliefDao.update(aftRelief);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}
	
	/**
	 * 
	 * @���� DHCC-LIUJ
	 * @���� 2016-9-1
	 * @����	Ϣ�Ѽ������ �߼�У��
	 */
	public void wsInsertAftRelief(AftRelief aftRelief) throws ServiceException{
		WsRedctn wsRedctn = new WsRedctn();
		wsRedctn.setWsId(aftRelief.getRefId());
		wsRedctn = wsRedctnDao.getById(wsRedctn);
		
		AcLnMst acLnMst = new AcLnMst();
		acLnMst.setPactNo(aftRelief.getPactNo());
		acLnMst.setBrNo(aftRelief.getBrNo());
		acLnMst = acLnMstDao.getByPactNo(acLnMst);
		//���������ļ������ڣ�ֱ�Ӹ���WS��Ϊʧ��
		if(acLnMst==null){
			wsRedctn.setDealSts("04");
			wsRedctn.setDealDesc("�������ļ�������");
			wsRedctnDao.update(wsRedctn);
			return ;
		}else{
			aftRelief.setCifNo(acLnMst.getCifNo());
			aftRelief.setCifName(acLnMst.getCifName());
			aftRelief.setDueAmt(acLnMst.getLoanAmt());
			aftRelief.setRefSts("01");
			aftRelief.setOpNo("SYSTEM");
			aftRelief.setAppSts("01");
			
		}
		
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
		
		//���Ȿ�����Ƿ�������账��
		if(loPrcp<aftRelief.getRefAmt()){
			wsRedctn.setDealSts("04");
			wsRedctn.setDealDesc("���Ȿ�����Ƿ��");
			wsRedctnDao.update(wsRedctn);
			return ;
		}
		//������Ϣ����ǷϢ�����账��
		if(loNorm<aftRelief.getRefIntst()){
			wsRedctn.setDealSts("04");
			wsRedctn.setDealDesc("������Ϣ����ǷϢ");
			wsRedctnDao.update(wsRedctn);
			return ;
		}//���ⷣϢ���ڷ�Ϣ�����账��
		if(loFine<aftRelief.getRefFine()){
			wsRedctn.setDealSts("04");
			wsRedctn.setDealDesc("���ⷣϢ���ڷ�Ϣ");
			wsRedctnDao.update(wsRedctn);
			return ;
		}//������ô���Ƿ�ѣ����账��
		if(loFee<aftRelief.getRefFee()){
			wsRedctn.setDealSts("04");
			wsRedctn.setDealDesc("������ô���Ƿ��");
			wsRedctnDao.update(wsRedctn);
			return ;
		}
		//���Ȿ��������Ϣ �����������
		if(aftRelief.getRefAmt()==(0.0)&&aftRelief.getRefIntst()==(0.0)){
			aftRelief.setAppSts("03");
			aftRelief.setRefSts("02");
			aftReliefDao.insert(aftRelief);
			
			//����WS��Ϊ������
			wsRedctn.setDealSts("02");
			wsRedctn.setDealDesc("������");
			wsRedctnDao.update(wsRedctn);
			
			execAftRelief(aftRelief);
		}else{
			
			aftRelief.setRefSts("02");
			aftRelief.setAppSts("02");
			aftReliefDao.insert(aftRelief);
			
			WkfParm parm = new WkfParm();
			parm.setApp_no(aftRelief.getRefId());//ID��
			parm.setApp_type("04");
			
			StringBuilder wfAppValue = new StringBuilder();
			wfAppValue.append("��ͬ��:"+aftRelief.getPactNo());
			wfAppValue.append(",������������:"+acLnMst.getBrName());
			wfAppValue.append(",�ͻ�����:"+acLnMst.getCifName());
			parm.setWf_app_value(wfAppValue.toString());//ҵ��
			
			doSubmit(parm,aftRelief,"SYSTEM", "00000");
			//����WS��Ϊ������
			wsRedctn.setDealSts("02");
			wsRedctn.setDealDesc("������");
			wsRedctnDao.update(wsRedctn);
		}
	}

	public String getRefId() throws ServiceException{
		
		String refId = aftReliefDao.getRefId();
		
		return refId;
		
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
				acLnLoDao.update(newAlo);
				acLnRepayPlnDao.update(acLnRepayPln);
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
	public String doSubmit(WkfParm parm,AftRelief aftRelief, String opNo,
			String brNo) throws ServiceException {
		String keyID="";
		String taskId = "";
		String nextDesc ="";
		String if_risk_part="0";
		try {
			String instanceId = null;
			WkfApprovalUser wkfApprovalUser = new WkfApprovalUser();
			wkfApprovalUser.setWkfUserName(opNo);
			List<WkfApprovalUser> wauList = wkfApprovalUserBo.getAllList(wkfApprovalUser);
			
			AppWkfcfg appWkfcfg = new AppWkfcfg();//����ͼ
			appWkfcfg.setAppType("04");//��������
			keyID = wkfInterface.getWkfNo(appWkfcfg);//���̱�ʾ
			
			instanceId = wkfInterface.startProcess(keyID, parm,aftRelief.getRefId(),opNo);
			//ȡtaskId ������ �ӿ�
			Task task = WFUtil.getTaskService().findTaskByProcessInstanceId(instanceId);
			if( task != null ) {
				taskId = task.getId();
				nextDesc = WFUtil.getTaskService().getNextTaskDesc(taskId);
				String[] nextRole = WFUtil.getTaskService().getNextTaskExecutor(taskId);//��ȡ��һ�����̽ڵ��ɫ
				String RoleNo = nextRole[1];
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
			//�ͻ�����Ĭ��ͬ���ύ��������������У�����ʾ����ڵ㣬�˻ؾ��˻ز����ͻ������ɹ���������ID
			String state = WFUtil.getTaskService().takeComplete(taskId,TaskConstants.PASS,"ͬ��",null,null,opNo);
			if (instanceId != null) {
				// ��������״̬
				aftRelief.setAppSts("02");
				aftRelief.setRefSts("02");
				aftRelief.setProcessId(instanceId);
				aftReliefDao.update(aftRelief);
			}
		}catch(WorkflowException e){
			e.printStackTrace();
			throw new ServiceException(e.getMessage());
		}catch (ServiceException e) {
			e.printStackTrace();
			throw new ServiceException(e.getMessage());
		}catch(Exception e){
			throw new ServiceException(e.getMessage());
		}
		return nextDesc;
	}
	public AftReliefDao getAftReliefDao() {
		return aftReliefDao;
	}

	public void setAftReliefDao(AftReliefDao aftReliefDao) {
		this.aftReliefDao = aftReliefDao;
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

	public void setAcLnMstDao(AcLnMstDao acLnMstDao) {
		this.acLnMstDao = acLnMstDao;
	}

	public void setAcChrgLogDao(AcChrgLogDao acChrgLogDao) {
		this.acChrgLogDao = acChrgLogDao;
	}

	public void setAcLnLoDao(AcLnLoDao acLnLoDao) {
		this.acLnLoDao = acLnLoDao;
	}

	public AcTraceLogDao getAcTraceLogDao() {
		return acTraceLogDao;
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setAcTraceLogDao(AcTraceLogDao acTraceLogDao) {
		this.acTraceLogDao = acTraceLogDao;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public AftReliefDtlDao getAftReliefDtlDao() {
		return aftReliefDtlDao;
	}

	public void setAftReliefDtlDao(AftReliefDtlDao aftReliefDtlDao) {
		this.aftReliefDtlDao = aftReliefDtlDao;
	}

	public WkfApprovalUserBo getWkfApprovalUserBo() {
		return wkfApprovalUserBo;
	}

	public void setWkfApprovalUserBo(WkfApprovalUserBo wkfApprovalUserBo) {
		this.wkfApprovalUserBo = wkfApprovalUserBo;
	}

	public WkfInterface getWkfInterface() {
		return wkfInterface;
	}

	public void setWkfInterface(WkfInterface wkfInterface) {
		this.wkfInterface = wkfInterface;
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