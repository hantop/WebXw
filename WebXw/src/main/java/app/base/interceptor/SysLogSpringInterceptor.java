package app.base.interceptor;

import java.lang.reflect.Method;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.aop.AfterReturningAdvice;

import app.base.SourceTemplate;
import app.creditapp.sys.bo.SysLogBo;
import app.creditapp.sys.entity.SysLog;
import app.util.DateUtil;
import app.util.User;

import com.opensymphony.xwork2.ActionContext;

/**
 * ϵͳ��־������
 *
 * @see 
 * �޸ļ�¼:
 */
public class SysLogSpringInterceptor implements AfterReturningAdvice {

	public void afterReturning(Object returnValue, Method method,Object[] args, Object target) throws Throwable {
		//��ʼ��־��Ϣ
		SysLog sysLog = constructSysLog(method,args);
		if(sysLog==null)return;
		//������־��Ϣ
		SysLogBo sysLogBo = SourceTemplate.getSpringContextInstance().getBean("sysLogBo",SysLogBo.class);
		if(sysLog.getOpId().length()>200)
			sysLog.setOpId(sysLog.getOpId().substring(0,200));
		sysLogBo.insertOrUpdate(sysLog);
	}
	
	/**
	 * ����SysLog
	 * @param method
	 * @param args
	 * @return
	 * @throws Exception
	 */
	private SysLog constructSysLog(Method method,Object[] args) throws Exception{
		SysLog sysLog = new SysLog();
		//��������
		if(StringUtils.startsWithAny(method.getName(), new String[]{"save","Save","insert","Insert"})){
			sysLog.setOpDesc("������¼");
		}else if(StringUtils.startsWithAny(method.getName(), new String[]{"update","Update"})){
			sysLog.setOpDesc("�޸ļ�¼");
		}else if(StringUtils.startsWithAny(method.getName(), new String[]{"del","delete"})){
			sysLog.setOpDesc("ɾ����¼");
		}else{
			return null;
		}
		if("SYS_LOG".equals(getTableName(method))){
			return null;
		}
		
		//������Ա
		if(ActionContext.getContext()==null){
//			sysLog.setOpNo(User.getTlrno(WebContextFactory.get().getHttpServletRequest()));
//			sysLog.setBrNo(User.getBrno(WebContextFactory.get().getHttpServletRequest()));
		}else{
			sysLog.setOpNo(User.getLoginid(ServletActionContext.getRequest()));
		}
		//����ʱ��
		sysLog.setLogDate(DateUtil.getDate());
		sysLog.setLogTime(DateUtil.getTime());
		//����������
		if(args[0] instanceof String || args[0] instanceof Integer){
			sysLog.setOpId(String.valueOf(args[0]));
		}else{
			if(args[0] instanceof java.util.List){
				//TODO: ���β���List���� Leopard
				return null;
			}else{
				String keyName1 = args[0].getClass().getDeclaredFields()[0].getName();	//Ψһ����1
			//	String keyName2 = args[0].getClass().getDeclaredFields()[1].getName();  //��������2
				if(StringUtils.equalsIgnoreCase(keyName1, "serialVersionUID")){
					keyName1 = args[0].getClass().getDeclaredFields()[1].getName();
				//	keyName2 = args[0].getClass().getDeclaredFields()[2].getName();
				}
				sysLog.setOpId(String.valueOf(PropertyUtils.getProperty(args[0], keyName1)));
				//sysLog.setOp_seqn(String.valueOf(PropertyUtils.getProperty(args[0], keyName2)));
			}
		}
		return sysLog;
	}
	/**
	 * ���ݷ���ǩ����ô��»��ߵı���
	 * @param method ����
	 * @return
	 */
	private String getTableName(Method method){
		String classSimpleName = method.getDeclaringClass().getSimpleName();
		String entityname_u = classSimpleName.substring(0, classSimpleName.length()-3);
		String entityname_l = StringUtils.uncapitalize(entityname_u);
		String tableName = "";
		for(int i=0;i<entityname_l.length();i++){
			if(entityname_l.charAt(i)<='Z' && entityname_l.charAt(i)>='A'){
				tableName = tableName+"_"+entityname_l.charAt(i);
			}else{
				tableName = tableName+entityname_l.charAt(i);
			}
		}
		return StringUtils.upperCase(tableName);
	}
	

}
