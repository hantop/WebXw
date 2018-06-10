package app.creditapp.approve.bo.impl;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import redis.clients.jedis.Jedis;

import app.base.BaseService;
import app.base.PUBParm;
import app.base.ServiceException;
import app.base.SourceTemplate;
import app.base.httpclient.entity.SendMessageEntity;
import app.base.httpclient.entity.SendMessageType;
import app.base.httpclient.work.SendMessageMain;
import app.creditapp.aft.entity.aftMessage.PasSubTypeEntity;
import app.creditapp.approve.bo.ApproveLoanBo;
import app.creditapp.pact.dao.LnPactDao;
import app.creditapp.pact.entity.LnPact;
import app.creditapp.ln.bo.LnApprIdeaBo;
import app.creditapp.ln.bo.LnStageBo;
import app.creditapp.ln.entity.LnApprIdea;
import app.creditapp.ln.worker.WorkDforPact;
import app.creditapp.ln.worker.WorkUtils;
import app.creditapp.redis.util.RedisUtil;
import app.creditapp.sys.entity.SysUserRole;
import app.creditapp.wkf.AppConstant;
import app.creditapp.wkf.entity.Result;
import app.creditapp.wkfinterface.WkfInterface;
import app.util.DateUtil;
import app.util.User;

import com.alibaba.fastjson.JSON;
import com.dhcc.workflow.WFUtil;

/**
 * ��˵��
 */
public class ApproveLoanBoImpl extends BaseService implements
		ApproveLoanBo {
	Logger logger = Logger.getLogger(WorkDforPact.class);
	private WkfInterface wkfInterface;
	private LnPactDao lnPactDao;
	private LnApprIdeaBo lnApprIdeaBo;
	private String taskId;
	
	public Result doCommit(String taskId, String appId, String processId,
			String apprOp, LnApprIdea lnApprIdea, String apprIdea,
			String apprDesc, String transition, String tlrno, String nextUser,String roleName,String nextBranch) throws ServiceException {

		Result res = new Result();
		try {
			if (null != taskId) {
//				String[] nextRole = WFUtil.getTaskService().getNextTaskExecutor(taskId);
//				res = wkfInterface.doCommit(taskId, apprIdea, apprDesc,
//						transition, tlrno, nextUser, "",nextBranch);
				res.setProcessEnd("ended");
				res.setIsPass("pass");

				LnPact lnPact = new LnPact();

				 if (AppConstant.OPINION_TYPE_ARREE.equals(apprIdea)) {
					if (res.isProcessEnd()) {// �ɹ����������º�ͬ��Ϊ������ͨ����
						// ���º�ͬ��״̬������ͨ��
						lnPact.setAppId(appId);
						lnPact = lnPactDao.getByAppId(lnPact);
						lnPact.setApprSts("02");//����״̬Ϊͨ��
						lnPact.setPactSts("02");
						lnPactDao.updateSts(lnPact);
//						LnStageBo lnStageBo = (LnStageBo) SourceTemplate.getSpringContextInstance().getBean("lnStageBo");
//						lnStageBo.updatests(appId, "RGAPP_STS", "02");// �����˹�����״̬Ϊͨ��
						WorkUtils.getInstance().proc_up_stage(appId, "RGAPP_STS", "02","�˹�����ͨ��");
						// push��5����Ϣ����
//				    	Jedis jedis = RedisUtil.getJedis();
//				  		jedis.lpush(RedisUtil.QUEUE5, JSON.toJSONString(lnPact));
//				  		jedis.close();
				  		logger.info("�˹�����ͨ��-[��ͬ���ΪPactId=" + lnPact.getPactId()+",��ͬ��Ϊ"+lnPact.getPactNo()+"]��");
					}else{
						lnPact.setApprSts("01");//����״̬Ϊ������
						lnPactDao.updateSts(lnPact);
//						String RoleNo = nextRole[1];//��ȡ��һ�����̽ڵ��ɫ
						SendMessageEntity sendMessageEntity=new SendMessageEntity();//������Ϣ
						String title="��������";
			            String contet="�д�����ҵ��";
				    	sendMessageEntity.setTitle(title);
				    	sendMessageEntity.setContet(contet);
//				    	sendMessageEntity.setGroupNo(RoleNo);
				    	sendMessageEntity.setSendType(SendMessageType.MESSAGE);
				    	sendMessageEntity.setPasSubTypeEntity(PasSubTypeEntity.RewFundMessage);
				    	SendMessageMain.sendMessage(sendMessageEntity);	
					}
				} else if (AppConstant.OPINION_TYPE_REFUSE.equals(apprIdea)) {// ����������Ϊ���
//					LnStageBo lnStageBo = (LnStageBo) SourceTemplate.getSpringContextInstance().getBean("lnStageBo");
//					lnStageBo.updatests(appId, "RGAPP_STS", "03");// �����˹�����״̬Ϊ���
					WorkUtils.getInstance().proc_up_stage(appId, "RGAPP_STS", "03","�˹��������,"+apprDesc);
					lnPact.setApprSts("03");//����״̬Ϊ���
					lnPactDao.updateSts(lnPact);
				}
				 lnPact.setAppId(appId);
				// lnPactDao.updateSts(lnPact);
				 lnApprIdea.setAppId(appId);
				 lnApprIdea.setApprId(lnApprIdea.getBatchNo());
				 lnApprIdea.setApprType(lnPact.getApprType());
				 lnApprIdea.setApprTime(DateUtil.getDateTime());
				 lnApprIdea.setApprIdea(apprIdea);
				 lnApprIdea.setApprDesc(apprDesc);
				 lnApprIdea.setApprOp(apprOp);
				 lnApprIdea.setApprRole(User.getWkfUserRoleNos(ServletActionContext.getRequest()).split("@")[0]);
				 lnApprIdea.setApprType("02");
				 lnApprIdea.setApprKind("01");
				 lnApprIdeaBo.insert(lnApprIdea);
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return res;
	}


	private HttpServletRequest getHttpRequest() {
		// TODO Auto-generated method stub
		return null;
	}


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


	public LnPactDao getLnPactDao() {
		return lnPactDao;
	}


	public void setLnPactDao(LnPactDao lnPactDao) {
		this.lnPactDao = lnPactDao;
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


}
