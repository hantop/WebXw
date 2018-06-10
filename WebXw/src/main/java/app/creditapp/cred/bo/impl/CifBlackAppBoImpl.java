package  app.creditapp.cred.bo.impl;

import java.util.List;

import com.dhcc.workflow.WFUtil;
import com.dhcc.workflow.api.WorkflowException;
import com.dhcc.workflow.api.task.Task;
import com.dhcc.workflow.pvm.internal.task.TaskConstants;

import app.base.BaseService;
import app.base.ServiceException;
import app.base.httpclient.entity.SendMessageEntity;
import app.base.httpclient.entity.SendMessageType;
import app.base.httpclient.work.SendMessageMain;
import app.util.AppConstant;
import app.util.toolkit.Ipage;
import app.creditapp.aft.entity.aftMessage.PasSubTypeEntity;
import app.creditapp.cif.dao.CifBlackDao;
import app.creditapp.cif.entity.CifBlack;
import app.creditapp.cred.bo.CifBlackAppBo;
import app.creditapp.cred.dao.CifBlackAppDao;
import app.creditapp.cred.entity.CifBlackApp;
import app.creditapp.pact.entity.LnPact;
import app.creditapp.wkf.bo.WkfApprovalUserBo;
import app.creditapp.wkf.entity.AppWkfcfg;
import app.creditapp.wkf.entity.WkfApprovalUser;
import app.creditapp.wkf.entity.WkfParm;
import app.creditapp.wkfinterface.WkfInterface;
/**
* Title: CifBlackAppBoImplImpl.java
* Description:
**/
public class CifBlackAppBoImpl extends BaseService implements CifBlackAppBo {

	private CifBlackAppDao cifBlackAppDao;
	private WkfApprovalUserBo wkfApprovalUserBo;
	private WkfInterface wkfInterface;
	private CifBlack cifBlack;
	private CifBlackDao cifBlackDao;

	public void del(CifBlackApp cifBlackApp) throws ServiceException {
		try {
			cifBlackAppDao.del(cifBlackApp);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}

	public Ipage findByPage(Ipage ipg, CifBlackApp cifBlackApp)
			throws ServiceException {
		try {
			ipg.initPageCounts(new Integer[] { (Integer) cifBlackAppDao
					.getCount(cifBlackApp) });// ��ʼ����ҳ��
			cifBlackApp.setStartNumAndEndNum (ipg);
			ipg.setResult(cifBlackAppDao.findByPage(cifBlackApp));
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return ipg;
	}

	public CifBlackApp getById(CifBlackApp cifBlackApp) throws ServiceException {
		try {
			cifBlackApp = cifBlackAppDao.getById(cifBlackApp);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return cifBlackApp;
	}

	public void insert(CifBlackApp cifBlackApp) throws ServiceException {
		try {
			/**
			 * ��������������ID��Ϣ,������ID��ID��dou������
			 */
			cifBlackApp.setAppId(cifBlackAppDao.getAppKey());
			cifBlackAppDao.insert(cifBlackApp);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}

	public void update(CifBlackApp cifBlackApp) throws ServiceException {
		try {
			cifBlackAppDao.update(cifBlackApp);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}
	public String doSubmit(WkfParm parm,CifBlackApp cifBlackApp, String opNo,
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
			appWkfcfg.setAppType("03");//��������
			keyID = wkfInterface.getWkfNo(appWkfcfg);//���̱�ʾ
			
			instanceId = wkfInterface.startProcess(keyID, parm,cifBlackApp.getBlkId(),opNo);
			//ȡtaskId ������ �ӿ�
			Task task = WFUtil.getTaskService().findTaskByProcessInstanceId(instanceId);
			if( task != null ) {
				taskId = task.getId();
				nextDesc = WFUtil.getTaskService().getNextTaskDesc(taskId);
				String[] nextRole = WFUtil.getTaskService().getNextTaskExecutor(taskId);//��ȡ��һ�����̽ڵ��ɫ
				String RoleNo = nextRole[1];
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
			//�ͻ�����Ĭ��ͬ���ύ��������������У�����ʾ����ڵ㣬�˻ؾ��˻ز����ͻ������ɹ���������ID
			String state = WFUtil.getTaskService().takeComplete(taskId,TaskConstants.PASS,"ͬ��",null,null,opNo);
			if (instanceId != null) {
				// ��������״̬
				cifBlackApp.setAppSts("02");
				cifBlackAppDao.update(cifBlackApp);
				cifBlack = new CifBlack();
				cifBlack.setBlkId(cifBlackApp.getBlkId());
				cifBlack = cifBlackDao.getById(cifBlack);
				cifBlack.setBlkSts("02");
				cifBlack.setProcessId(instanceId);
				cifBlackDao.update(cifBlack);
			}
		}catch(WorkflowException e){
			e.printStackTrace();
			throw new ServiceException(e.getMessage());
		}catch (ServiceException e) {
			e.printStackTrace();
			throw new ServiceException(e.getMessage());
		}catch(Exception e){
			e.printStackTrace();
			throw new ServiceException(e.getMessage());
		}
		return nextDesc;
	}
	public CifBlackAppDao getCifBlackAppDao() {
		return cifBlackAppDao;
	}

	public void setCifBlackAppDao(CifBlackAppDao cifBlackAppDao) {
		this.cifBlackAppDao = cifBlackAppDao;
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

	public CifBlack getCifBlack() {
		return cifBlack;
	}

	public void setCifBlack(CifBlack cifBlack) {
		this.cifBlack = cifBlack;
	}

	public CifBlackDao getCifBlackDao() {
		return cifBlackDao;
	}

	public void setCifBlackDao(CifBlackDao cifBlackDao) {
		this.cifBlackDao = cifBlackDao;
	}
}