package app.creditapp.wkfinterface;

import java.util.List;

import app.base.ServiceException;
import app.creditapp.wkf.entity.AppWkfcfg;
import app.creditapp.wkf.entity.Result;
import app.creditapp.wkf.entity.WkfApprovalRole;
import app.creditapp.wkf.entity.WkfApprovalUser;
import app.creditapp.wkf.entity.WkfParm;

import com.dhcc.workflow.api.model.Transition;

public interface WkfInterface 
{
	/**
	 * @param processKey ����Id
	 * 
	 * @param obj ҵ�����
	 * 
	 * @param appNo ҵ������ֵ
	 * 
	 * @param primaryKeyName ҵ����������
	 * 
	 * @param opNo ����Ա
	 * 
	 * @throws ClassNotFoundException 
	 * @throws ServiceException 
	 */
	public String startProcess(String processKey,WkfParm obj,String appNo,String opNo) throws ServiceException, ClassNotFoundException;
	/**
	 * @param taskId ��ǰ����Id
	 * 
	 * @param approvalOpinion �������
	 * 
	 * @param transition ��ת·��
	 * 
	 * @param nextUser ��һ����������
	 * 
	 * @return Result
	 */
	public Result agree(String taskId,String approvalOpinion,String transition,String nextUser,String opNo,String isBatchFlag,String nextBranch)throws ServiceException;
	/**
	 * @param taskId ��ǰ����Id
	 * 
	 * @param approvalOpinion �������
	 * 
	 * @param opNo ����Ա
	 * 
	 * @return Result
	 */
	public Result refuse(String taskId,String approvalOpinion,String opNo)throws ServiceException ;
	/**
	 * @param taskId ��ǰ����Id
	 * 
	 * @param approvalOpinion �������
	 * 
	 * @param transition ��ת·��
	 * 
	 * @return Result
	 */
	public Result rollBack(String taskId,String approvalOpinion,String transition,String opNo)throws ServiceException ;
	/**
	 * @param taskId ��ǰ����Id
	 */
	public Result rollbackToDefaultNode(String taskId,String approvalOpinion,String opNo)throws ServiceException ;
	/**
	 * @see ��ǩ����
	 */
	public String getSignTask()throws ServiceException ;
	/**
	 * @see ����״̬
	 */
	public String getEndSts()throws ServiceException ;
	/**
	 * 
	 * @param taskId ��ǰ����Id
	 * 
	 * @param opinionType �������
	 * 
	 * @param approvalOpinion �������
	 * 
	 * @param transition ��ת·��
	 * 
	 * @param opNo ����Ա
	 * 
	 * @param nextUser ��һ����������
	 * 
	 * @return Result �ɹ����� Result
	 */
	public Result doCommit(String taskId,String opinionType, String approvalOpinion,String transition, String opNo, String nextUser,String isBatchFalg,String nextBranch)throws ServiceException;
	/**
	 * @param ����ID
	 */
	public List<Transition> findNextTransition(String taskId)throws ServiceException;
	/**
	 * @ ��ȡ���������û�
	 */
	public List<WkfApprovalUser> getAllList(WkfApprovalUser wkfApprovalUser)throws ServiceException;
	
	/**
	 * 
	 * ��������������������ѯ�������Ӧ��ͬҵ�����͵���������
	 * @param appWkfcfg
	 * @return
	 * @throws ServiceException
	 * @�޸���־��
	 */
	public String getWkfNo(String app_type,String prodname) throws ServiceException;
	
	
	public String getWkfNo(String app_type) throws ServiceException;
	
	public String getWkfNo(AppWkfcfg appWkfcfg) throws ServiceException;

	
	/**
	 * 
	 * �����������õ��Ƿ�����׷��
	 * @param taskId
	 * @param tlrno
	 * @return
	 * @�޸���־��
	 */
	public boolean recallTask(String taskId, String tlrno) throws ServiceException ;
	
	/**
	 * 
	 * �������������������ύ�����̱������¸�ֵ��ֻ�޸Ŀ��ܻᷢ���仯�ģ����ٽӿڵ��ã����Ч�ʣ�
	 * @param instanceId
	 * @param obj
	 * @throws ServiceException
	 * @�޸���־��
	 */
	public Result doVarReset(String instanceId,WkfParm obj) throws ServiceException;
	
	/**
	 * 
     * @description ͨ����ɫ�Ų�ѯ��ɫ����
     * @param wkfApprovalRole_parm
     * @return
     * @throws ServiceException
     * @version 1.0
	 */
	public WkfApprovalRole getWkfRoleByRoleNo(WkfApprovalRole wkfApprovalRole) throws ServiceException;

}
