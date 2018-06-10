package app.creditapp.sys.action;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.dbunit.util.Base64;

import com.alibaba.fastjson.JSON;
import com.core.struts.BaseFormBean;

import accounting.plat.PUBConstant;
import app.base.ServiceException;
import app.creditapp.aft.bo.AftMessageAlarmBo;
import app.creditapp.aft.entity.aftMessage.AjaxData;
import app.creditapp.entity.SysGlobal;
import app.creditapp.sys.bo.StudentBo;
import app.creditapp.sys.bo.SysLogBo;
import app.creditapp.sys.bo.SysMenuBo;
import app.creditapp.sys.bo.SysUserBo;
import app.creditapp.sys.bo.SysUserLogBo;
import app.creditapp.sys.bo.SysUserRoleBo;
import app.creditapp.sys.entity.SysLog;
import app.creditapp.sys.entity.SysMenu;
import app.creditapp.sys.entity.SysUser;
import app.creditapp.sys.entity.SysUserLog;
import app.creditapp.wkf.bo.WkfApprovalRoleBo;
import app.creditapp.wkf.bo.WkfApprovalUserBo;
import app.creditapp.wkf.entity.WkfApprovalRole;
import app.oscache.CachecodeUtil;
import app.oscache.MBaseCache;
import app.util.DateUtil;
import app.util.LoginSessionListener;
import app.util.User;
import app.util.json.JsonMenuUtil;

public class LoginAction extends BaseFormBean {
	private static final long serialVersionUID = 123867490237412370L;
	private String browserVersion;
	private SysUserBo sysUserBo;
	private SysUserLogBo sysUserLogBo;
	private SysLogBo sysLogBo;
	private StudentBo studentBo;
	private SysUserRoleBo sysUserRoleBo;
	private WkfApprovalUserBo wkfApprovalUserBo;
	private WkfApprovalRoleBo wkfApprovalRoleBo;
	private AftMessageAlarmBo aftMessageAlarmBo;
	private SysMenuBo sysMenuBo;
	private SysUser op;
	private List<SysMenu> sysMenuLev1List;
	private Map<String, String> menuTreeMap;
	
	private String userId;
	private String password;
	private String changeUi;

	/**
	 * ����Ա��¼����
	 * cms.action
	 * @return
	 * @throws Exception
	 */
	public String userLogin() throws Exception {
		getHttpRequest().getSession().setAttribute("browserVersion", browserVersion);
		// ȡ����Ա
		SysUser sysUser = sysUserBo.getById(op);
		// ϵͳ��־
		SysLog syslog = new SysLog();

		if (sysUser == null) {
			this.addActionError("û�д��û���!");
			return redirectPage();
		} else {
			if (!"01".equals(sysUser.getUser_sts())) {
				this.addActionError("���û���ʧЧ,�޷���½!");
				return redirectPage();
			}
			// ϵͳ��־
			syslog.setOpNo(sysUser.getUser_id());
			syslog.setOpClass(this.getClass().toString());
			syslog.setOpId(sysUser.getUser_id());
			syslog.setOpDesc("����Ա��¼");
			sysLogBo.insertOrUpdate(syslog);
			// ����Ա��¼��־
			SysUserLog sysUserLog = new SysUserLog();
			sysUserLog.setUserId(sysUser.getUser_id());
			sysUserLog = sysUserLogBo.getById(sysUserLog);

			// ��������
			String passWord = Base64.encodeString(op.getPass_word());
			if (sysUser.getPass_word().equals(passWord)) {
				// ȡ�û�Ȩ��
				String allRoleNo = getAllRoleNo(sysUser.getRoleNos());
				if (StringUtils.isBlank(allRoleNo)) {
					this.addActionError("���û�δ�����û�������ɫ��ϵ,�޷���¼,����ϵ����Ա����!");
					return redirectPage();
				}

				if (LoginSessionListener.isOnline(op.getUser_no())) {
					LoginSessionListener.kickFirstOper(this.getHttpRequest().getSession(), op.getUser_no());// �ѵ�һ���û�T����
				}
				LoginSessionListener.putSessionMap(this.getHttpRequest().getSession(), op.getUser_no());

				addUserSession(sysUser, sysUserLog, this.getHttpRequest());
				sysUserLog.setPassError(0);
				sysUserLogBo.userLogin(sysUserLog);// �ǵ�¼��־
				// �˵�����
				List<SysMenu> sysMenuList = sysMenuBo.getAllMenuByRole_no(allRoleNo);
				sysMenuLev1List = sysMenuBo.findMenuLev1ByRole(allRoleNo);
				getHttpRequest().getSession().setAttribute("sysMenuLev1List", sysMenuLev1List);
				getHttpRequest().getSession().setAttribute("allRoleNo", allRoleNo);
				menuTreeMap = JsonMenuUtil.ulist2tree(sysMenuList);
				getSession().put("menuTreeMap", menuTreeMap);
				getSession().remove("code");
				
			} else {
				sysUserLog.setPassError(sysUserLog.getPassError() + 1);
				sysUserLogBo.userLogin(sysUserLog);// �ǵ�¼��־
				this.addActionError("���������ȷ�����룡");
				return redirectPage();
			}
		}
		return getUserLoginResult();
	}
	
	public String checkUserLogin() throws UnknownHostException {
		if(op == null){
			op = new SysUser();
			op.setUser_no(userId);
			op.setPass_word(password);
		}
		if(op !=null && op.getUser_no() == null) op.setUser_no(userId);
		if(op !=null && op.getPass_word() == null) op.setPass_word(password);
		// ȡ����Ա
		SysUser sysUser = sysUserBo.getById(op);
		// ϵͳ��־
		SysLog syslog = new SysLog();

		if (sysUser == null) {
			return "error|û�д��û���!";
		} else {
			if (!"01".equals(sysUser.getUser_sts())) {
				return "error|���û���ʧЧ,�޷���½!";
			}
			// ϵͳ��־
			syslog.setOpNo(sysUser.getUser_id());
			syslog.setOpClass(this.getClass().toString());
			syslog.setOpId(sysUser.getUser_id());
			syslog.setOpDesc("����Ա��¼");
			sysLogBo.insertOrUpdate(syslog);
			// ����Ա��¼��־
			SysUserLog sysUserLog = new SysUserLog();
			sysUserLog.setUserId(sysUser.getUser_id());
			sysUserLog = sysUserLogBo.getById(sysUserLog);

			// ��������
			String passWord = Base64.encodeString(op.getPass_word());
			if (sysUser.getPass_word().equals(passWord)) {
				// ȡ�û�Ȩ��
				String allRoleNo = getAllRoleNo(sysUser.getRoleNos());
				if (StringUtils.isBlank(allRoleNo)) {
					this.addActionError("");
					return "error|���û�δ�����û�������ɫ��ϵ,�޷���¼,����ϵ����Ա����!";
				}

				if (LoginSessionListener.isOnline(op.getUser_no())) {
					LoginSessionListener.kickFirstOper(this.getHttpRequest().getSession(), op.getUser_no());// �ѵ�һ���û�T����
				}
				LoginSessionListener.putSessionMap(this.getHttpRequest().getSession(), op.getUser_no());

				addUserSession(sysUser, sysUserLog, this.getHttpRequest());
				sysUserLog.setPassError(0);
				sysUserLogBo.userLogin(sysUserLog);// �ǵ�¼��־
				// �˵�����
				List<SysMenu> sysMenuList = sysMenuBo.getAllMenuByRole_no(allRoleNo);
				sysMenuLev1List = sysMenuBo.findMenuLev1ByRole(allRoleNo);
				getHttpRequest().getSession().setAttribute("sysMenuLev1List",sysMenuLev1List);
				getHttpRequest().getSession().setAttribute("allRoleNo",allRoleNo);
				menuTreeMap = JsonMenuUtil.ulist2tree(sysMenuList);
				getSession().put("menuTreeMap", menuTreeMap);
				getSession().remove("code");
				
				AjaxData messageAjaxData = aftMessageAlarmBo.initAjaxData(User.getLoginid(getHttpRequest()),User.getSys_date(getHttpRequest()), true);
				getHttpRequest().getSession().setAttribute("messageData", "{\"ajaxData\":"+JSON.toJSONString(messageAjaxData)+"}");
//				System.out.println(JSON.toJSONString(messageAjaxData));
				getHttpRequest().getSession().setAttribute("messageSumNumber", messageAjaxData.getSumCount());
				String pushMessageServerPath = (String) MBaseCache.getCache().getBeanCache("pushMessageServerPath", CachecodeUtil.SECURITY);
				String websocketEndpointPath = (String) MBaseCache.getCache().getBeanCache("websocketEndpointPath", CachecodeUtil.SECURITY);
				String wholeRequestPath = "ws://"+pushMessageServerPath + websocketEndpointPath + "/"+User.getLoginid(getHttpRequest())+"/"+sysUser.getRoleNos()+"/"+InetAddress.getLocalHost().getHostAddress();
				getHttpRequest().getSession().setAttribute("pushMessageServerPath", wholeRequestPath);
				
				getHttpRequest().getSession().setAttribute("indexUi", sysUser.getLastUi());
				
			} else {
				sysUserLog.setPassError(sysUserLog.getPassError() + 1);
				sysUserLogBo.userLogin(sysUserLog);// �ǵ�¼��־
				this.addActionError("");
				return "error|���������ȷ�����룡";
			}
		}
		return "success";
	}
	
	public String changeSysUserUi() throws IOException{
		this.getHttpResponse().setContentType("text/html;charset=utf-8");
		HttpServletResponse response=ServletActionContext.getResponse();
		String user_no = User.getLoginid(getHttpRequest());
		SysUser sysUser = new SysUser();
		sysUser.setUser_no(user_no);
		sysUser = sysUserBo.getById(sysUser);
		sysUser.setLastUi(getChangeUi());
		sysUserBo.update(sysUser);
		getHttpRequest().getSession().setAttribute("indexUi", sysUser.getLastUi());
		response.getWriter().write("success");
		response.getWriter().close();
		return null;
	}
	
	/*
	 * cmsForAjax.action
	 */
	public String userLoginForAjax() throws Exception{
		this.getHttpResponse().setContentType("text/html;charset=utf-8");
		HttpServletResponse response=ServletActionContext.getResponse();
		String checkResult = checkUserLogin();
		response.getWriter().write(checkResult);
		response.getWriter().close();
		return null;
	}

	/*
	 * ����Ա�˳�
	 */
	public String userLogout() throws Exception {
		HttpSession session = this.getHttpRequest().getSession();
		// ����Ա�ǳ�д��־
		String user_no = (String) session.getAttribute("userId");
		if (user_no != null) {
			SysUserLog sysUserLog = new SysUserLog();
			sysUserLog.setUserId(user_no);
			sysUserLogBo.userLogout(sysUserLog);
		}
		String redirectStr = redirectPage();
		try {
			this.getHttpRequest().getSession().invalidate();// ����session
		} catch (Exception e) {
			return redirectStr;// �����session�����쳣˵��session�Ѿ�����һ�Σ���ֱ�ӷ��ص�¼����
		}
		return redirectStr;
	}

	private void addUserSession(SysUser sysUser, SysUserLog sysUserLog, HttpServletRequest request) {
		Date date = new Date();
		DateFormat df = new SimpleDateFormat("yyyyMMdd HH:mm:ss");// ����������ʾ��ʽ
		String time = df.format(date);
		String ip = getIpAddr(request);// �ͻ���IP��ַ
		String browser = request.getHeader("User-Agent");// �����������
		String clientInfo = time + "|" + ip + "|" + browser;
		sysUserLog.setClientInfo(clientInfo);
		sysUserLog.setLoginIp(ip);
		sysUserLog.setSessionId(request.getSession().getId());

		/** ������ɫ **/
		String wkfRoleNos = null;
		try {
			wkfRoleNos = wkfApprovalUserBo.getAllRoles(sysUser.getUser_no());
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		String wkfRoleNames = "";
		if (wkfRoleNos != null && !"".equals(wkfRoleNos)) {
			String[] wrs = wkfRoleNos.split("@");
			for (int i = 0; i < wrs.length; i++) {
				WkfApprovalRole wkfApprovalRole = new WkfApprovalRole();
				wkfApprovalRole.setWkfRoleNo(wrs[i]);
				wkfApprovalRole = wkfApprovalRoleBo.getById(wkfApprovalRole);
				wkfRoleNames += wkfApprovalRole.getWkfRoleName() + "|";
			}
		}

		request.getSession().setAttribute("ip", ip);
		request.getSession().setAttribute("color",sysUser.getSkin());
		request.getSession().setAttribute("browser", browser);
		request.getSession().setAttribute("userinfo", clientInfo);
		request.getSession().setAttribute("sessionID", request.getSession().getId());
		request.getSession().setAttribute("pwd", sysUser.getPass_word()); // ����
		request.getSession().setAttribute("loginid", sysUser.getUser_no()); // ����Ա����
		request.getSession().setAttribute("userId", sysUser.getUser_id()); // ����ԱID
		request.getSession().setAttribute("wfOrgNo", sysUser.getOrg_no()); // ��������

		request.getSession().setAttribute("wkfRoleNos", wkfRoleNos);// ������ɫ����
		request.getSession().setAttribute("wkfrolenames", wkfRoleNames);// ������ɫ����
		request.getSession().setAttribute("displayname", sysUser.getDisp_name());// ����Ա����
		request.getSession().setAttribute("roleNos", sysUser.getRoleNos());

		SysGlobal sg = DateUtil.getSysGlobal();
		request.getSession().setAttribute("sys_date", sg.getSys_date());
		request.getSession().setAttribute("bat_date", sg.getBat_date());
		request.getSession().setAttribute("lst_date", sg.getLst_date());
		PUBConstant.CUR_PRCS_DT = sg.getSys_date();
		request.getSession().setAttribute("frame", "");
		request.getSession().setAttribute("menuno", "");
		
		this.getSession().put("sysmenu", sysMenuBo.getmu());
		this.getSession().put("isLogin", true);
		
	}

	private String redirectPage() {
		browserVersion = (String) getHttpRequest().getSession().getAttribute("browserVersion");
		if ("old".equals(browserVersion)) {
			return "login";
		} else {
			return "newLogin";
		}
	}

	private String getUserLoginResult() {
		getSession().put("frame", "main");
		if (null == getSession().get("color")) {
			getSession().put("color", "yellow");
		}
		return (String) getSession().get("frame");
	}

	/**
	 * @���� DHCC-SONG
	 * @���� Aug 5, 2016
	 * @����˵���� �����û��н�ɫ�� ��@�� �ָ�
	 * @���ز��� String
	 */
	private String getAllRoleNo(String roleNos) {
//		List<SysUserRole> rolenolist = sysUserRoleBo.getAllRoleNo(user_no);
		String allRoleNo = "('"+ roleNos.replaceAll("@", "\',\'") +"')";
//		StringBuilder paramRoleNo = new StringBuilder();
//		if (rolenolist.size() <= 0) {
//			return paramRoleNo.toString();
//		}
//		paramRoleNo.append("(");
//		for (int i = 0; i < rolenolist.size(); i++) {
//			if (i != (rolenolist.size() - 1)) {
//				paramRoleNo.append("'").append(rolenolist.get(i).getRole_no()).append("',");
//			} else {
//				paramRoleNo.append("'").append(rolenolist.get(i).getRole_no()).append("')");
//			}
//		}
		return allRoleNo;
	}

	private String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknow".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}

	public String getBrowserVersion() {
		return browserVersion;
	}

	public void setBrowserVersion(String browserVersion) {
		this.browserVersion = browserVersion;
	}

	public SysUserBo getSysUserBo() {
		return sysUserBo;
	}

	public void setSysUserBo(SysUserBo sysUserBo) {
		this.sysUserBo = sysUserBo;
	}

	public SysUserLogBo getSysUserLogBo() {
		return sysUserLogBo;
	}

	public void setSysUserLogBo(SysUserLogBo sysUserLogBo) {
		this.sysUserLogBo = sysUserLogBo;
	}

	public SysLogBo getSysLogBo() {
		return sysLogBo;
	}

	public void setSysLogBo(SysLogBo sysLogBo) {
		this.sysLogBo = sysLogBo;
	}

	public SysUserRoleBo getSysUserRoleBo() {
		return sysUserRoleBo;
	}

	public void setSysUserRoleBo(SysUserRoleBo sysUserRoleBo) {
		this.sysUserRoleBo = sysUserRoleBo;
	}

//	public WkfApprovalUserBo getWkfApprovalUserBo() {
//		return wkfApprovalUserBo;
//	}
//
//	public void setWkfApprovalUserBo(WkfApprovalUserBo wkfApprovalUserBo) {
//		this.wkfApprovalUserBo = wkfApprovalUserBo;
//	}
//
//	public WkfApprovalRoleBo getWkfApprovalRoleBo() {
//		return wkfApprovalRoleBo;
//	}
//
//	public void setWkfApprovalRoleBo(WkfApprovalRoleBo wkfApprovalRoleBo) {
//		this.wkfApprovalRoleBo = wkfApprovalRoleBo;
//	}

	public SysMenuBo getSysMenuBo() {
		return sysMenuBo;
	}

	public void setSysMenuBo(SysMenuBo sysMenuBo) {
		this.sysMenuBo = sysMenuBo;
	}

	public SysUser getOp() {
		return op;
	}

	public void setOp(SysUser op) {
		this.op = op;
	}

	public List<SysMenu> getSysMenuLev1List() {
		return sysMenuLev1List;
	}

	public void setSysMenuLev1List(List<SysMenu> sysMenuLev1List) {
		this.sysMenuLev1List = sysMenuLev1List;
	}

	public Map<String, String> getMenuTreeMap() {
		return menuTreeMap;
	}

	public void setMenuTreeMap(Map<String, String> menuTreeMap) {
		this.menuTreeMap = menuTreeMap;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setAftMessageAlarmBo(AftMessageAlarmBo aftMessageAlarmBo) {
		this.aftMessageAlarmBo = aftMessageAlarmBo;
	}

	public String getChangeUi() {
		return changeUi;
	}

	public void setChangeUi(String changeUi) {
		this.changeUi = changeUi;
	}

	public StudentBo getStudentBo() {
		return studentBo;
	}

	public void setStudentBo(StudentBo studentBo) {
		this.studentBo = studentBo;
	}

	public WkfApprovalUserBo getWkfApprovalUserBo() {
		return wkfApprovalUserBo;
	}

	public void setWkfApprovalUserBo(WkfApprovalUserBo wkfApprovalUserBo) {
		this.wkfApprovalUserBo = wkfApprovalUserBo;
	}

	public WkfApprovalRoleBo getWkfApprovalRoleBo() {
		return wkfApprovalRoleBo;
	}

	public void setWkfApprovalRoleBo(WkfApprovalRoleBo wkfApprovalRoleBo) {
		this.wkfApprovalRoleBo = wkfApprovalRoleBo;
	}

	public AftMessageAlarmBo getAftMessageAlarmBo() {
		return aftMessageAlarmBo;
	}
}
