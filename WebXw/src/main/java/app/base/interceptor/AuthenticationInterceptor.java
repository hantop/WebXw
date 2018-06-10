package app.base.interceptor;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;

import app.creditapp.securityinterface.SecurityInterface;
import app.creditapp.sys.bo.OperatorModelMenuBo;
import app.oscache.CachecodeUtil;
import app.oscache.MBaseCache;
import app.util.LoginSessionListener;
import app.util.User;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * session��Ȩ��������
 * 
 * @see �޸ļ�¼:
 */
public class AuthenticationInterceptor extends AbstractInterceptor {

	private static final long serialVersionUID = 1440786165985641145L;

	private SecurityInterface securityInterface;
	private OperatorModelMenuBo operatorModelMenuBo;

	/**
	 * @description ������
	 * @param ai
	 * @throws Exception
	 * @version 1.0
	 */
	public String intercept(ActionInvocation ai) throws Exception {
		String menuno = "";
		HttpServletRequest request = ServletActionContext.getRequest();
		menuno = request.getParameter("menuno");
		if (menuno != null && !"".equals(menuno)) {
			menuno = menuno.trim();
			request.getSession().setAttribute("menuno", menuno);
		}
		ActionSupport as = (ActionSupport) ai.getAction();
		if (!isUserLogined()) {
			as.addActionMessage("�û�δ��¼����ǰ�Ի��Ѿ�ʧЧ�������µ�¼�����");
			return "noLogin";
		}
		String cacheBase = (String) MBaseCache.getCache().getBeanCache("useSecurity", CachecodeUtil.SECURITY);
		String startTime = User.getTime();// ȡ����ǰ��ʱ��
		long startMillis = System.currentTimeMillis();
		String result = ai.invoke();
		String endTime = User.getTime();// ȡ���غ��ʱ��
		long endMillis = System.currentTimeMillis();
		double ce = endMillis - startMillis;
		if ("1".equals(cacheBase)) {
			getUserApptime(startTime, endTime, ce);
		}
		return result;

	}

	/**
	 * ��֤session�Ƿ���Ч
	 * 
	 * @param arg0
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unused")
	private boolean sessionIsValid(ActionInvocation arg0) throws Exception {
		String tlrno = User.getLoginid(ServletActionContext.getRequest());
		if (StringUtils.isNotBlank(tlrno)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * @description ��¼������־
	 * @param startTime
	 * @param endTime
	 * @param ce
	 * @throws Exception
	 * @version 1.0
	 */
	private void getUserApptime(String startTime, String endTime, double ce) throws Exception {
		String urlStr = (String) ServletActionContext.getRequest().getServletPath();
		String tlrno = User.getLoginid(ServletActionContext.getRequest());
		String opname = User.getDisplayName(ServletActionContext.getRequest());
		String param = "";
		Map<?, ?> map = ServletActionContext.getRequest().getParameterMap();
		Set<?> set = map.keySet();
		Iterator<?> it = set.iterator();
		while (it.hasNext()) {
			String name = it.next().toString();
			String value = ServletActionContext.getRequest().getParameter(name);
			param = param + name + "=" + value + "&";
		}
		if (param.length() > 30) {
			param = param.substring(0, 30);
		}
		securityInterface.insertUserApptime(urlStr, tlrno, opname, param, startTime, endTime, ce);
	}

	private boolean isUserLogined() {
		String loginId = User.getLoginid(ServletActionContext.getRequest());
		return LoginSessionListener.isOnline(loginId);
	}

	public SecurityInterface getSecurityInterface() {
		return securityInterface;
	}

	public void setSecurityInterface(SecurityInterface securityInterface) {
		this.securityInterface = securityInterface;
	}

	public OperatorModelMenuBo getOperatorModelMenuBo() {
		return operatorModelMenuBo;
	}

	public void setOperatorModelMenuBo(OperatorModelMenuBo operatorModelMenuBo) {
		this.operatorModelMenuBo = operatorModelMenuBo;
	}
}