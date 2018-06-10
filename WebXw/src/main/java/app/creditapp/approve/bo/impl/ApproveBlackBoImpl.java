package app.creditapp.approve.bo.impl;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import redis.clients.jedis.Jedis;
import app.base.BaseService;
import app.base.ServiceException;
import app.base.httpclient.entity.SendMessageEntity;
import app.base.httpclient.entity.SendMessageType;
import app.base.httpclient.work.SendMessageMain;
import app.creditapp.aft.entity.aftMessage.PasSubTypeEntity;
import app.creditapp.approve.bo.ApproveBlackBo;
import app.creditapp.cif.dao.CifBlackDao;
import app.creditapp.cif.entity.CifBlack;
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
public class ApproveBlackBoImpl extends BaseService implements ApproveBlackBo {
	Logger logger = Logger.getLogger(WorkDforPact.class);
	private WkfInterface wkfInterface;
	private CifBlackDao cifBlackDao;
	private LnApprIdeaBo lnApprIdeaBo;
	private String taskId;

	public Result doCommit(String taskId, String blkId, String processId,
			String apprOp, LnApprIdea lnApprIdea, String apprIdea,
			String apprDesc, String transition, String tlrno, String nextUser,
			String roleName, String nextBranch) throws ServiceException {

		Result res = null;
		try {
			if (null != taskId) {

				String[] nextRole = WFUtil.getTaskService().getNextTaskExecutor(taskId);
					
				res = wkfInterface.doCommit(taskId, apprIdea, apprDesc,
						transition, tlrno, nextUser, "", nextBranch);

				CifBlack cifBlack = new CifBlack();

				if (AppConstant.OPINION_TYPE_ARREE.equals(apprIdea)) {
					if (res.isProcessEnd()) {// �ɹ����������º�ͬ��Ϊ������ͨ����
						// ���º�ͬ��״̬������ͨ��
						cifBlack.setBlkId(blkId);
						cifBlack = cifBlackDao.getById(cifBlack);
						if(cifBlack.getBlkFlag().equals("02")){
							cifBlack.setBlkFlag("01");
						}else{
							cifBlack.setBlkFlag("02");
						}
						cifBlack.setBlkSts("03");// ����״̬Ϊͨ��
						cifBlackDao.update(cifBlack);
						// push��5����Ϣ����
						Jedis jedis = RedisUtil.getJedis();
						jedis.lpush(RedisUtil.QUEUE5, JSON
								.toJSONString(cifBlack));
						logger.info("�˹�����ͨ��-[����IdΪBlkId=" + cifBlack.getBlkId()
								+ "]��");

					} else {
						cifBlack.setBlkId(blkId);
						cifBlack = cifBlackDao.getById(cifBlack);
						cifBlack.setBlkSts("02");// ����״̬Ϊ������
						cifBlackDao.update(cifBlack);
						
						String RoleNo = nextRole[1];//��ȡ��һ�����̽ڵ��ɫ
						SendMessageEntity sendMessageEntity=new SendMessageEntity();//������Ϣ
						String title="������";
			            String contet="�д�����ҵ��";
				    	sendMessageEntity.setTitle(title);
				    	sendMessageEntity.setContet(contet);
				    	sendMessageEntity.setGroupNo(RoleNo);
				    	sendMessageEntity.setSendType(SendMessageType.MESSAGE);
				    	sendMessageEntity.setPasSubTypeEntity(PasSubTypeEntity.RewFundMessage);
				    	SendMessageMain.sendMessage(sendMessageEntity);	
					}
				} else if (AppConstant.OPINION_TYPE_REFUSE.equals(apprIdea)) {// ����������Ϊ���
					cifBlack.setBlkId(blkId);
					cifBlack = cifBlackDao.getById(cifBlack);
					cifBlack.setBlkSts("04");// ����״̬Ϊ���
					cifBlackDao.update(cifBlack);
				}
				// lnPactDao.updateSts(lnPact);
				lnApprIdea.setAppId(blkId);
				lnApprIdea.setApprTime(DateUtil.getDateTime());
				lnApprIdea.setApprIdea(apprIdea);
				lnApprIdea.setApprDesc(apprDesc);
				lnApprIdea.setApprOp(apprOp);
				lnApprIdea.setApprRole(User.getWkfUserRoleNos(ServletActionContext.getRequest()).split("@")[0]);
				lnApprIdea.setApprType("02");
				lnApprIdea.setApprKind("03");
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

	public CifBlackDao getCifBlackDao() {
		return cifBlackDao;
	}

	public void setCifBlackDao(CifBlackDao cifBlackDao) {
		this.cifBlackDao = cifBlackDao;
	}

}
