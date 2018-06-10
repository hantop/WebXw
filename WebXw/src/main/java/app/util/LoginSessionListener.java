package app.util;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import app.base.SourceTemplate;
import app.creditapp.securityinterface.SecurityInterface;
import app.creditapp.sys.bo.SysUserLogBo;
import app.creditapp.sys.entity.SysUserLog;
/**
 * 
 * 
 * ���������� ʵ����session �� user����
 * @see
 * @�޸���־��
 *
 */

public class LoginSessionListener implements HttpSessionListener {
	
	// ���� sessionId��userName ��ӳ��(sessionid,userName)
	public static Map<String, String> hUserName = new ConcurrentHashMap<String, String>();
	// ���϶���,����session ���������(sessionid,session)
	public static Map<String, HttpSession> htsession = new ConcurrentHashMap<String, HttpSession>();
	// �����û�����Ա������session id �Ĺ���
	public static Map<String, Integer> mpOper = new ConcurrentHashMap<String, Integer>();

	/**
	 * 
	 * ����������������ʵ��HttpSessionListener�еķ��� 
	 * @param se
	 * @�޸���־��
	 */
	public void sessionCreated(HttpSessionEvent se) {
	}
	
/**
 * ������������¼��ʱ���̨�Զ�ִ�д˷���
 * @param se
 * @�޸���־��
 * */
	public void sessionDestroyed(HttpSessionEvent se) {
		//д�Զ��ǳ���־
		if(hUserName.get(se.getSession().getId())!=null){
			SysUserLogBo sysUserLogBo = (SysUserLogBo)SourceTemplate.getSpringContextInstance().getBean("sysUserLogBo");
			SysUserLog sysUserLog = new SysUserLog();
			sysUserLog.setUserId((String)se.getSession().getAttribute("userId"));
			sysUserLogBo.userLogout(sysUserLog);
			//securityInterface.insertNewLoginInfo(hUserName.get(se.getSession().getId()), LoginStatus.OUTBYOTHER);
		}
		hUserName.remove(se.getSession().getId());
		htsession.remove(se.getSession().getId());
		se.getSession().invalidate();
	}
	public static void putSessionMap(HttpSession session, String nUserName){
		hUserName.put(session.getId(), nUserName);
		htsession.put(session.getId(), session);
	}
	
	
	
	
    /**
     * ��������������һ���Ѿ���¼���û������ߵ��õķ���
     * @param session
     * @param nUserName
     * @return  boolean ���û��Ƿ��Ѿ���¼�ı�־
     */
	public static boolean kickFirstOper(HttpSession session, String nUserName){
		boolean flag=false;
		if (hUserName.containsValue(nUserName)) {
			flag = true;
			Iterator iter = hUserName.entrySet().iterator();
			while (iter.hasNext()) {
				Map.Entry entry = (Map.Entry) iter.next();
				Object key = entry.getKey();
				Object val = entry.getValue();
				if (((String) val).equals(nUserName)) {
					iter.remove();
					HttpSession ses = (HttpSession) htsession.get(key);
					if (session.getId().equals(((HttpSession) htsession.get(key)).getId())) {//��ͬһ̨���ӵ�¼
						 htsession.remove(key); //ֱ�ӾͰ�MAP�ĵ�ǰ��¼������
					     hUserName.remove(key);
//					     ses.invalidate();
					     hUserName.put(session.getId(), nUserName);
					     htsession.put(session.getId(), session);
					}
					else{   //����ͬһ̨���ӵ�¼ �Ȱ�ǰ����û�T�� Ȼ������û��ļ�¼�Ž�MAP
					htsession.remove(key);
					hUserName.remove(key);
					ses.invalidate(); //��ǰ����Ǹ�����Աsession����
					hUserName.put(session.getId(), nUserName);
					htsession.put(session.getId(), session);
					}
					break;
				}
			}
			
		}
		return flag;
	}
	
	
	 /**
     * ������������������ʱ�������Ѿ���¼���û�������
     * @param session
     */
	public static void kickAllOper() {
		Iterator iter = htsession.entrySet().iterator();
		while (iter.hasNext()) {
			Entry entry = (Entry) iter.next();
			((HttpSession) entry.getValue()).invalidate();
		}
	}
	
	
	/**
	 * 
	 * ����������-�����ж��û��Ƿ��Ѿ���¼�Լ���Ӧ�Ĵ�����
	 * 
	 * @param sUserName��¼���û�����
	 * @param session
	 * @return boolean-���û��Ƿ��Ѿ���¼���ı�־
	 * @�޸���־��
	 */
	
	@SuppressWarnings("unchecked")
	public static boolean isAlreadyEnter(HttpSession session, String sUserName) {
		boolean flag = false;
		if (hUserName.containsValue(sUserName)) {
			flag = true;
			Iterator iter = hUserName.entrySet().iterator();
			while (iter.hasNext()) {
				Map.Entry entry = (Map.Entry) iter.next();
				Object key = entry.getKey();
				Object val = entry.getValue();
				if (((String) val).equals(sUserName)) {
					iter.remove();
					HttpSession ses = (HttpSession) htsession.get(key);
					htsession.remove(key);
					ses.invalidate();
					break;
				}
			}
			hUserName.put(session.getId(), sUserName);
			htsession.put(session.getId(), session);
		} else {
			// ������û�û��¼����ֱ��������ڵ�sessionID��username
			flag = false;
			hUserName.put(session.getId(), sUserName);
			htsession.put(session.getId(), session);
		}
		return flag;
	}
	
/*****�����ж��û��Ƿ����ߵķ�������Ϊ��Ҫ��������������
      1.�ڲ�ͬ������ϵ�¼ͬһ���û��ж��Ƿ��ظ���¼��������HashMap���Ѿ����ڵ��û���
      2.��ͬһ̨������ϵ�¼��ͬ�û��ж��Ƿ��ظ���¼��������HashMap���Ѿ����ڵ�Session    ******/
	/**
	 * 
	 * ����������-�����ж��û��Ƿ�����
	 * 
	 * @param sUserName��¼���û�����
	 * @param session
	 * @return boolean-���û��Ƿ����ߵı�־
	 * @�޸���־��
	 */
	public static boolean isOnline(String sUserName) {
		return hUserName.containsValue(sUserName);
	}
	/**
	 * ��sessionΪ�����ж��û��Ƿ�����
	 * @param session
	 * @return boolean - ���û��Ƿ�����
	 */
	public static boolean isOnline(HttpSession session){
		return htsession.get(session.getId())!=null;
	}

	/**
	 * 
	 * ����������
	 * 
	 * @param session
	 * @param sUserName��¼���û�����
	 * @return boolean-���û��Ƿ����ߵı�־
	 * @�޸���־��
	 */

	public static boolean isAddSessionToMap(HttpSession session,
			String sUserName) {
		boolean flag = false;
		if (hUserName.containsValue(sUserName)) {
			flag = true;
		} else {
			flag = false;
			hUserName.put(session.getId(), sUserName);
			htsession.put(session.getId(), session);
		}
		return flag;
	}

	/**
	 * 
	 * ���������� ���ָ���û��ĵ�¼״̬
	 * @param sUserName ��¼���û�����
	 * 
	 * @return boolean-���û��Ƿ����ߵı�־��false������
	 * @�޸���־��
	 */

	@SuppressWarnings("unchecked")
	public static boolean doRemove(String sUserName) {
		boolean flag = false;
		if (hUserName.containsValue(sUserName)) {
			flag = true;
			Iterator iter = hUserName.entrySet().iterator();
			while (iter.hasNext()) {
				Map.Entry entry = (Map.Entry) iter.next();
				Object key = entry.getKey();
				Object val = entry.getValue();
				if (((String) val).equals(sUserName)) {
					HttpSession ses = (HttpSession) htsession.get(key);
					hUserName.remove(key);
					htsession.remove(key);
					ses.invalidate();
				}
			}
		}
		return flag;
	}

	/**
	 * 
	 * ����sessionID�õ�HASHMAP�е�session
	 * 
	 * @param sessionid
	 * @return Session
	 * @�޸���־��
	 */

	public static HttpSession getSessionBySessionId(String sessionid) {
		HttpSession session = (HttpSession) htsession.get(sessionid);
		return session;
	}
}
