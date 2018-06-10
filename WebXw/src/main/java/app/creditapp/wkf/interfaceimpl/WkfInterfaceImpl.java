package app.creditapp.wkf.interfaceimpl;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import org.apache.commons.lang.time.FastDateFormat;
import org.apache.struts2.ServletActionContext;

import com.dhcc.workflow.NodeType;
import com.dhcc.workflow.WFUtil;
import com.dhcc.workflow.api.ExecutionService;
import com.dhcc.workflow.api.TaskService;
import com.dhcc.workflow.api.WorkflowException;
import com.dhcc.workflow.api.model.Transition;
import com.dhcc.workflow.pvm.internal.task.TaskConstants;
import com.dhcc.workflow.wfdl.internal.repository.WfdlDeployer;

import app.base.ServiceException;
import app.creditapp.wkf.AppConstant;
import app.creditapp.wkf.bo.AppWkfcfgBo;
import app.creditapp.wkf.bo.WkfApprovalRoleBo;
import app.creditapp.wkf.bo.WkfApprovalUserBo;
import app.creditapp.wkf.entity.AppWkfcfg;
import app.creditapp.wkf.entity.Result;
import app.creditapp.wkf.entity.WkfApprovalRole;
import app.creditapp.wkf.entity.WkfApprovalUser;
import app.creditapp.wkf.entity.WkfParm;
import app.creditapp.wkfinterface.WkfInterface;
import app.util.User;

public class WkfInterfaceImpl implements WkfInterface {
	
	private WkfApprovalUserBo wkfApprovalUserBo;
	private AppWkfcfgBo appWkfcfgBo;
	private WkfApprovalRoleBo wkfApprovalRoleBo;

	/**
	 * �������� processKey ����key��obj �������� ��appNo ����� ��opNo ����Ա�� -- add by xrp
	 * 2013.4.2
	 */
	public String startProcess(String processKey, WkfParm obj, String appNo,
			String opNo) throws ServiceException, ClassNotFoundException {
		// ����ת��
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("wf_app_id", appNo); // ҵ��������
		map.put("wf_operator", opNo); // ����Ա���
		map.put("wf_app_value", obj.getWf_app_value());// ҵ������
		map.put("br_no", obj.getBr_no()); // ������
		map.put("cif_type", obj.getCif_type());// �ͻ�����
		map.put("prdt_no", obj.getPrdt_no());// ��Ʒ��
		map.put("grade", obj.getGrade());// ��������
		map.put("app_type", obj.getApp_type());// ��������
		map.put("amt", obj.getAmt());// ���
		map.put("five_sts", obj.getFive_sts());// �弶״̬
		map.put("vou_type", obj.getVou_type());// ������ʽ
		map.put("vou_type_sub", obj.getVou_type_sub());//����ǰ�弶״̬
		map.put("auth_true", obj.getAuth_true());// �Ƿ�����
		map.put("term_month", obj.getTerm_month());// ������
		map.put("county_max", obj.getCounty_max());// ������ֵ
		map.put("city_max", obj.getCity_max());// ������ֵ
		map.put("province_max", obj.getProvince_max());// ��ʡ��ֵ
		map.put("br_lev", obj.getBr_lev());// ��������
		map.put("adv_grade", obj.getAdv_grade());//���������ȼ�
		map.put("grade_pers", obj.getGrade_pers());//��������
		map.put("grade_corp", obj.getGrade_corp());//�Թ�
		map.put("arti_sts", obj.getArti_sts());//����ǰ�弶״̬
		map.put("bad_five_sts", obj.getBad_five_sts());//������Ǩ
		map.put("wkf_vou_type", obj.getWkf_vou_type());//�Ƿ����ô���
		map.put("br_depart", obj.getBr_depart());//���ŷ���
		map.put("occur_type", obj.getOccur_type());//��������
		map.put("wkf_cif_type", obj.getWkf_cif_type());//�ͻ�����
		map.put("prod_no", obj.getProd_no());//��Ʒ��
		
		map.put("better_five_sts", obj.getBetter_five_sts());//��ע��Ǩ����
		map.put("down_five_sts", obj.getDown_five_sts());//��ע��Ǩ����
		map.put("br_depart", obj.getBr_depart());//���в���
		map.put("occur_type", obj.getOccur_type());//��������
		map.put("loan_oper_qua", obj.getLoan_oper_qua());//��Ӫ��ʽ
		map.put("wkf_risk_type", obj.getWkf_risk_type());//���ŷ���

		
		if (obj.getApp_type().equals("01")) {
			map.put("auth_type", obj.getAuth_type());// ��������;����:�������롢���ŵ���
		} else if (obj.getApp_type().equals("5")) {
			map.put("prj_type", obj.getPrj_type());// ��������;����:����������롢������ȵ���
		}

		// �������� ��������ID����ʾ��������
		ExecutionService executionService = WFUtil.getExecutionService();
		String instanceId = null;
		try {
			if("8".equals(obj.getApp_type())){//�����������������߲������̵�ִ����
				instanceId = executionService.startByKey(processKey, opNo, false,map).getId();
			}else{
				instanceId = executionService.startByKey(processKey, opNo, true,map).getId();
			}
		} catch (WorkflowException e) {
			e.printStackTrace();
			throw new ServiceException(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return instanceId;
	}
	
	/**
	 * 
	 * �������������������ύ�����̱������¸�ֵ��ֻ�޸Ŀ��ܻᷢ���仯�ģ����ٽӿڵ��ã����Ч�ʣ�
	 * @param instanceId
	 * @param obj
	 * @throws ServiceException
	 * @author xrp
	 * @date 2013-4-24
	 * @�޸���־��
	 */
	public Result doVarReset(String instanceId,WkfParm obj) throws ServiceException{
		Result result = new Result();
		try{
			ExecutionService sevice = WFUtil.getExecutionService();
			sevice.setVariable(instanceId,"wf_app_value", obj.getWf_app_value());// ҵ������
			sevice.setVariable(instanceId,"prdt_no", obj.getPrdt_no());// ��Ʒ��
			sevice.setVariable(instanceId,"grade", obj.getGrade());// ��������
			sevice.setVariable(instanceId,"amt", obj.getAmt());// ���
			sevice.setVariable(instanceId,"five_sts", obj.getFive_sts());// �弶״̬
			sevice.setVariable(instanceId,"vou_type", obj.getVou_type());// ������ʽ
			sevice.setVariable(instanceId,"auth_true", obj.getAuth_true());// �Ƿ�����
			sevice.setVariable(instanceId,"term_month", obj.getTerm_month());// ������
			sevice.setVariable(instanceId,"br_lev", obj.getBr_lev());//��������
			sevice.setVariable(instanceId,"grade_pers", obj.getGrade_pers());// ��������
			sevice.setVariable(instanceId,"grade_corp",  obj.getGrade_corp());// �Թ�����
			sevice.setVariable(instanceId,"arti_sts", obj.getArti_sts());//����ǰ�弶
			sevice.setVariable(instanceId,"arti_sts", obj.getArti_sts());//����ǰ�弶
			sevice.setVariable(instanceId,"adv_grade", obj.getAdv_grade());//����ǰ�弶
			sevice.setVariable(instanceId,"vou_type_sub", obj.getVou_type_sub());//����ϸ��
			sevice.setVariable(instanceId,"bad_five_sts", obj.getBad_five_sts());
			sevice.setVariable(instanceId,"better_five_sts", obj.getBetter_five_sts());
			sevice.setVariable(instanceId,"down_five_sts", obj.getDown_five_sts());
			sevice.setVariable(instanceId,"br_depart", obj.getBr_depart());//���в���
			sevice.setVariable(instanceId,"occur_type", obj.getOccur_type());//��������
		}catch(Exception e){
			result.setException(e);
		}
		return result;
	}

	/**
	 * 
	 * �����������õ��Ƿ�����׷��
	 * 
	 * @param taskId
	 * @param tlrno
	 * @return
	 * @author xrp
	 * @date 2013-4-12
	 * @�޸���־��
	 */
	public boolean recallTask(String taskId, String tlrno)
			throws ServiceException {
		try {
			return WFUtil.getTaskService().recall(taskId, tlrno);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public Result doCommit(String taskId, String opinionType,
			String approvalOpinion, String transition, String opNo,
			String nextUser,String isBatchFlag,String nextBranch) throws ServiceException {
		if (AppConstant.OPINION_TYPE_ARREE.equals(opinionType))// ͬ��
			return agree(taskId, approvalOpinion, transition, nextUser, opNo,isBatchFlag,nextBranch);
		else if (AppConstant.OPINION_TYPE_DISARREE.equals(opinionType))// ��ͬ��
			return disAgree(taskId, approvalOpinion, transition, nextUser, opNo);
		else if (AppConstant.OPINION_TYPE_REFUSE.equals(opinionType))// ���
			return refuse(taskId, approvalOpinion, opNo);
		else if (AppConstant.OPINION_TYPE_ROLLBACK.equals(opinionType))// �˻�
			return rollBack(taskId, approvalOpinion, transition,opNo);
		else if (AppConstant.OPINION_TYPE_RESTART.equals(opinionType))// ��������
			return rollbackToDefaultNode(taskId, approvalOpinion,opNo);
		return null;
	}

	/**
	 * 
	 * ��������������ͬ��
	 * 
	 * @param taskId
	 * @param approvalOpinion
	 * @param transition
	 * @param nextUser
	 * @param opNo
	 * @return
	 * @throws ServiceException
	 * @author xrp
	 * @date 2013-4-17
	 * @�޸���־��
	 */
	public Result agree(String taskId, String approvalOpinion,
			String transition, String nextUser, String opNo,String isBatchFlag,String nextBranch)
			throws ServiceException {
		Result result = new Result();
		String state = "";
		TaskService service = WFUtil.getTaskService();
		try {
			if("1".equals(isBatchFlag)){
				if(null==nextBranch||nextBranch.isEmpty()){
					state  = service.takeComplete(taskId, TaskConstants.PASS, approvalOpinion, transition, nextUser, opNo);
				}else{
					state = service.takeComplete(taskId, TaskConstants.PASS, approvalOpinion, transition, nextUser, opNo, nextBranch);
				}
			}else{
				if(null==nextBranch||nextBranch.isEmpty()){
					state = service.complete(taskId, TaskConstants.PASS,approvalOpinion, transition, nextUser, opNo);
				}else{
					state = service.takeComplete(taskId, TaskConstants.PASS, approvalOpinion, transition, nextUser, opNo, nextBranch);
				}
				
			}
			result.setProcessEnd(state);
			result.setIsPass("pass");
		} catch (Exception e) {
			e.printStackTrace();
			result.setException(e);
		}
		return result;
	}

	/**
	 * 
	 * ����������������ͬ��
	 * 
	 * @param taskId
	 * @param approvalOpinion
	 * @param transition
	 * @param nextUser
	 * @param opNo
	 * @return
	 * @throws ServiceException
	 * @author xrp
	 * @date 2013-4-17
	 * @�޸���־��
	 */
	public Result disAgree(String taskId, String approvalOpinion,
			String transition, String nextUser, String opNo)
			throws ServiceException {
		Result result = new Result();
		try {
			String state = WFUtil.getTaskService().complete(taskId,
					TaskConstants.DISAGREE, approvalOpinion, transition,
					nextUser, opNo);
			result.setProcessEnd(state);

		} catch (Exception e) {
			result.setException(e);
		}
		return result;
	}

	/**
	 * 
	 * �����������������
	 * 
	 * @param taskId
	 * @param approvalOpinion
	 * @param transition
	 * @param nextUser
	 * @param opNo
	 * @return
	 * @throws ServiceException
	 * @author xrp
	 * @date 2013-4-17
	 * @�޸���־��
	 */
	public Result refuse(String taskId, String approvalOpinion, String opNo)
			throws ServiceException {
		Result result = new Result();
		try {
			WFUtil.getTaskService().refuse(taskId, approvalOpinion, opNo);
			result.setProcessEnd(AppConstant.END_STATE);
		} catch (Exception e) {
			result.setException(e);
		}
		return result;
	}
	/**
	 * 
	 * ��������������������ѯ�������Ӧ��ͬҵ�����͵��������̣�����������
	 * 
	 * @param appWkfcfg
	 * @return
	 * @throws ServiceException
	 * @author zsp
	 * @date 2013-09-26
	 * @�޸���־����ѯ�����������ʵ�� 2013-06-23
	 * @modify by sp 2013-12-3
	 */
	public String getWkfNo(String app_type, String prdt_no) throws ServiceException {
		AppWkfcfg appwkfinfo = new AppWkfcfg();
		String wkfNo = "";
		String brNo = User.getBrno(ServletActionContext.getRequest());
		try {
			appwkfinfo.setAppType(app_type);
			appwkfinfo.setPrdtNo("@"+prdt_no+"@");
			appwkfinfo.setBrNo(brNo);
			wkfNo = appWkfcfgBo.getByIdForLoan(appwkfinfo);
//			if( wkfNo != null && !"".equals(wkfNo) ) {
//				return wkfNo;
//			}else {/** ���������û�и���Ӧ�����������̣���ȡ��ѯʡ��������������õ���������**/
//				if(User.getOp_lev(ServletActionContext.getRequest()).equals("0")){//������Ƿ���
//					appwkfinfo.setBrNo(tblorgdepartmentsbo.getByBrno(brNo).getUp_two());
//				}else if(User.getOp_lev(ServletActionContext.getRequest()).equals("1")){//������ĸ���
//					appwkfinfo.setBrNo(tblorgdepartmentsbo.getByBrno(brNo).getUp_one());
//				}
//				wkfNo = appWkfcfgBo.getByIdForLoan(appwkfinfo);
//				if( wkfNo != null && !"".equals(wkfNo) ) {
//					return wkfNo;
//				}
//			}
			
			//����������ʡ���綼û���������������򷵻�"null"�ַ���
			if ( wkfNo == null || "".equals(wkfNo) ) {
				throw new ServiceException("����ϵ����Ա����-���ش���ҵ��������Ӧ���̣�");
			} 
			
		} catch (ServiceException e) {
			throw e;
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return wkfNo;
	}

	/**
	 * 
	 * ��������������������ѯ�������Ӧ��ͬҵ�����͵���������
	 * 
	 * @param appWkfcfg
	 * @return
	 * @throws ServiceException
	 * @author xrp
	 * @date 2013-4-7
	 * @�޸���־��
	 * @modify by sp 2013-12-3
	 */
	public String getWkfNo(String app_type) throws ServiceException {
		AppWkfcfg appwkfinfo = new AppWkfcfg();
		String wkfNo = "";
		String brNo = User.getBrno(ServletActionContext.getRequest());
		try {
//			String upone = tblorgdepartmentsbo.getByBrno(
//					User.getBrno(ServletActionContext.getRequest()))
//					.getUp_one(); // ��
			
			appwkfinfo.setBrNo(brNo);
			appwkfinfo.setAppType(app_type);
			wkfNo = appWkfcfgBo.getById(appwkfinfo);
//			if(wkfNo!=null&&!"".equals(wkfNo)){
//				return wkfNo;
//			}else{/** ���������û�и���Ӧ�����������̣���ȡ��ѯʡ��������������õ���������**/
//				if(User.getBrlev(ServletActionContext.getRequest()).equals("0")){//������Ƿ���
//					appwkfinfo.setBrNo(tblorgdepartmentsbo.getByBrno(brNo).getUp_two());
//				}else if(User.getBrlev(ServletActionContext.getRequest()).equals("1")){//������ĸ���
//					appwkfinfo.setBrNo(tblorgdepartmentsbo.getByBrno(brNo).getUp_one());
//				}
//				wkfNo = appWkfcfgBo.getById(appwkfinfo);
//				if(wkfNo!=null&&!"".equals(wkfNo)){
//					return wkfNo;
//				}
//			}
			if (wkfNo == null || wkfNo == "") {
				wkfNo = "null";
				// throw new Exception("����ϵ����Ա����-���ض�Ӧҵ���������̣�");
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return wkfNo;
	}

	/**
	 * 
	 * ��������������������ѯ�������Ӧ��ͬҵ�����͵���������
	 * 
	 * @param appWkfcfg
	 * @return
	 * @throws ServiceException
	 * @author xrp
	 * @date 2013-4-7
	 * @�޸���־��
	 * @modify by sp 2013-12-3
	 */
	public String getWkfNo(AppWkfcfg appWkfcfg) throws ServiceException {
		String wkfNo = "";
		try {
//			appWkfcfg.setBrNo(brNo);
			wkfNo = appWkfcfgBo.getById(appWkfcfg);
			if (wkfNo == null || wkfNo == "") {
				wkfNo = "null";
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return wkfNo;
	}

	
	/**
	 * 
	 * ���������������˻�
	 * 
	 * @param taskId
	 * @param approvalOpinion
	 * @param transition
	 * @param nextUser
	 * @param opNo
	 * @return
	 * @throws ServiceException
	 * @author xrp
	 * @date 2013-4-17
	 * @�޸���־��
	 * @modify by sp 2013-11-02
	 */
	public Result rollBack(String taskId, String approvalOpinion,
			String transition,String operator) throws ServiceException {
		Result result = new Result();
		try {
			//WFUtil.getTaskService().rollback(taskId, approvalOpinion,transition);
			WFUtil.getTaskService().rollback(taskId, null, approvalOpinion, transition, operator);
		} catch (Exception e) {
			result.setException(e);
		}
		return result; 
	}

	/**
	 * 
	 * ����������������������
	 * 
	 * @param taskId
	 * @param approvalOpinion
	 * @param transition
	 * @param nextUser
	 * @param opNo
	 * @return
	 * @throws ServiceException
	 * @�޸���־��
	 */
	public Result rollbackToDefaultNode(String taskId, String approvalOpinion,String operator)
			throws ServiceException {
		Result result = new Result();
		try {
			//WFUtil.getTaskService().rollbackToDefaultNode(taskId,approvalOpinion);
			WFUtil.getTaskService().rollbackToDefaultNode(taskId, "sendback", approvalOpinion, operator);
		} catch (Exception e) {
			result.setException(e);
		}
		return result;
	}

	public String getSignTask() throws ServiceException {
		return NodeType.SIGNTASK;
	}

	public String getEndSts() throws ServiceException {
		return AppConstant.END_STATE;
	}

	public List<Transition> findNextTransition(String taskId)
			throws ServiceException {
		List<Transition> transitionList = WFUtil.getTaskService()
				.getTransitions(taskId);
		return transitionList;
	}

	public List<WkfApprovalUser> getAllList(WkfApprovalUser wkfApprovalUser)
			throws ServiceException {
		return wkfApprovalUserBo.getAllList(wkfApprovalUser);
	}

	public WkfApprovalRole getWkfRoleByRoleNo(WkfApprovalRole wkfApprovalRole) throws ServiceException {
		
		return wkfApprovalRoleBo.getById(wkfApprovalRole);
	}
	
	public WkfApprovalUserBo getWkfApprovalUserBo() {
		return wkfApprovalUserBo;
	}

	public void setWkfApprovalUserBo(WkfApprovalUserBo wkfApprovalUserBo) {
		this.wkfApprovalUserBo = wkfApprovalUserBo;
	}

	public AppWkfcfgBo getAppWkfcfgBo() {
		return appWkfcfgBo;
	}

	public void setAppWkfcfgBo(AppWkfcfgBo appWkfcfgBo) {
		this.appWkfcfgBo = appWkfcfgBo;
	}

	public WkfApprovalRoleBo getWkfApprovalRoleBo() {
		return wkfApprovalRoleBo;
	}

	public void setWkfApprovalRoleBo(WkfApprovalRoleBo wkfApprovalRoleBo) {
		this.wkfApprovalRoleBo = wkfApprovalRoleBo;
	}
	
	/**
	 * @param oldProcessKey  ԭ��������Key,  
	 * @param oldParam       ԭ���ģ��û�,�����ţ���������
	 * @param newParam       �µ�: �û��������ţ���������, 
	 * @param templateFileName  ��ʹ�õ�����ģ���ļ�����ȫ·��
	 */
	public static void doChangeProcessDefinition(String oldProcessKey, String oldParam, String newParam, String templateFileName) {
		//Process Template File
		//String oldParam = "400001,40000,�����޸Ĳ���";//ģ���еĲ���Ա����Ա����Ա��,�����ţ���������
		//String newParams = "400001,40000,�����޸Ĳ���";//����Ա����Ա��,�����ţ���������,��ò�Ҫ����10��
		
		String[] oldParams = oldParam.split(",");
		String[] newParams = newParam.split(",");
		String operatorKey = "author=\"" + oldParams[0] + "\"";
		String newOperator = "author=\"" + newParams[0] + "\"";
		String branchKey = "branch=\"" + oldParams[1] + "\"";
		String newBranch = "branch=\"" + newParams[1] + "\"";
		String branchNameKey = "branchName=\"" + oldParams[2] + "\"";
		String newBranchName = "branchName=\"" + newParams[2] + "\"";
		String candidateBranchKey = "candidate-branch=\"" + oldParams[1] + "\"";
		String newCandidateBranch = "candidate-branch=\"" + newParams[1] + "\"";
		
		
		String newProcessKey = getProcessKey(null);
		String processKey = "key=\"" + oldProcessKey + "\"";
		String newProcessKeyValue = "key=\"" + newProcessKey + "\"";
		
		String processNameKey = "name=\"" + oldProcessKey + "\"";
		String newProcessName = "name=\"" + newProcessKey + "\"";
		
		StringBuilder sb = new StringBuilder();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(templateFileName), "UTF-8"));
			String strLine = null;
			while( (strLine = br.readLine()) != null ) {
				if( strLine.indexOf(processKey) > -1 ) {
					strLine = strLine.replaceAll(processKey, newProcessKeyValue);
				}
				if( strLine.indexOf(processNameKey) > -1 ) {
					strLine = strLine.replaceAll(processNameKey, newProcessName);
				}
				
				if( strLine.indexOf(operatorKey) > -1 ) {
					strLine = strLine.replaceAll(operatorKey, newOperator);
				}
				if( strLine.indexOf(branchKey) > -1 ) {
					strLine = strLine.replaceAll(branchKey, newBranch);				
				}
				if( strLine.indexOf(branchNameKey) > -1 ) {
					strLine = strLine.replaceAll(branchNameKey, newBranchName);
				}
				if( strLine.indexOf(candidateBranchKey) > -1 ) {
					strLine = strLine.replaceAll(candidateBranchKey, newCandidateBranch);
				}
				sb.append(strLine).append("\r");
			}
			
		} catch(Exception e) {
			
		} finally {
			if( br != null ) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		String templateProcessXML = sb.toString();
		System.out.println(templateProcessXML);
		//���沢��������
		WFUtil.getRepositoryService().create().addResourceFromString(newProcessKey + WfdlDeployer.wfdlExtension, templateProcessXML).deploy();
	}
	
	public static String getProcessKey(String name) {
		if( name == null || "".equals(name) || "null".equals(name) ) {
			return "process_" + getID();
		} else {
			return (name + "_" + getID());
		}
	}
	
	public static String getID()  {
		String value = fdf.format(calendar);
		return value;
	}

	public static void main(String[] args) {
		String[] datas = {
				"��Т��1,000001,���пƼ���1",
				"��Т��2,000002,���пƼ���2",
				"��Т��3,000003,���пƼ���3",
				"��Т��4,000004,���пƼ���4",
				"��Т��5,000005,���пƼ���5",
				"��Т��6,000006,���пƼ���6",
				"��Т��7,000007,���пƼ���7"
		};
		
		for(String value : datas) {
			doChangeProcessDefinition("process_201483017424585","����Ƽ,1628100000,�����������", value ,"f:\\template2.wfdl.xml");
		}
		
	} 
	
	private static FastDateFormat fdf = FastDateFormat.getInstance("yyMMddHHmmssSS");
	private static Calendar calendar = new GregorianCalendar(TimeZone.getDefault());
	

}
