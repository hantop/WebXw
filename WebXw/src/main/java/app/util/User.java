package app.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

public class User {

	public User() {
	}
	//��λ
	private static void CBexchange(char ac[], char ac1[]) {
		System.out.println("���볤��"+ac1.length);
		if(ac1.length==6){
			ac[0] = ac1[2];
			ac[1] = ac1[5];
			ac[2] = ac1[0];
			ac[3] = ac1[4];
			ac[4] = ac1[3];
			ac[5] = ac1[1];
		}else{
			int j=0;
			for(int i=0; i<ac1.length; i++){
				j=ac1.length-1-i;
				ac[i] = ac1[j];
			}
		}
	}

	private static void ShuffData(char ac[], int i) {
		int j = 0;
		switch (i) {			
		case 16: // '\020'
			ac[j++] ^= '\001';
			// fall through

		case 15: // '\017'
			ac[j++] ^= '\t';
			// fall through

		case 14: // '\016'
			ac[j++] ^= '\017';
			// fall through

		case 13: // '\r'
			ac[j++] ^= '\002';
			// fall through

		case 12: // '\f'
			ac[j++] ^= '\f';
			// fall through

		case 11: // '\013'
			ac[j++] ^= '\b';
			// fall through

		case 10: // '\n'
			ac[j++] ^= '\002';
			// fall through

		case 9: // '\t'
			ac[j++] ^= '\007';
			// fall through

		case 8: // '\b'
			ac[j++] ^= '\006';
			// fall through

		case 7: // '\007'
			ac[j++] ^= '\n';
			// fall through

		case 6: // '\006'
			ac[j++] ^= '\r';
			// fall through

		case 5: // '\005'
			ac[j++] ^= '\0';
			// fall through

		case 4: // '\004'
			ac[j++] ^= '\b';
			// fall through

		case 3: // '\003'
			ac[j++] ^= '\003';
			// fall through

		case 2: // '\002'
			ac[j++] ^= '\t';
			// fall through

		case 1: // '\001'
			ac[j++] ^= '\013';
			// fall through

		default:
			return;
		}
	}
	//����
	public static String CBunshuff(String s) {
		char ac[] = new char[s.length()];
		char ac1[] = s.toCharArray();
		ShuffData(ac1, s.length());
		CBexchange(ac, ac1);
		return new String(ac);
	}
	//����
	public static String CBshuff(String s) {
		char ac[] = new char[s.length()];
		char ac1[] = s.toCharArray();
		CBexchange(ac, ac1);
		ShuffData(ac, s.length());
		return new String(ac);
	}
	/**
	 * ȡ��ϵͳʱ��
	 * @return
	 */
	public static String getTime() {
		Date date = new Date();
		SimpleDateFormat simpledateformat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		return simpledateformat.format(date);
	}
	
	/**
	 * ȡ��ϵͳʱ��HH:mm:ss
	 * @return
	 */
	public static String getTime1(){
		Date date = new Date();
		SimpleDateFormat simpledateformat = new SimpleDateFormat(
				"HH:mm:ss");
		return simpledateformat.format(date);
	}
	
	/**
	 * ������Ա�Ƿ���Ȩ��
	 * @param httpservletrequest
	 * @param i
	 * @return
	 */
	public static boolean hasRight(HttpServletRequest httpservletrequest, int i) {
		String s = (String) httpservletrequest.getSession().getAttribute(
				"rights");
		if (s == null) {
			return false;
		} else {
			char ac[] = s.toCharArray();
			return ac[i] == '1';
		}
	}
	/**
	 * ������Ա�Ƿ���Ȩ��
	 * @param httpservletrequest
	 * @param i
	 * @return
	 */
	public static boolean hasRightcr(HttpServletRequest httpservletrequest,
			int i) {
		String s = (String) httpservletrequest.getSession().getAttribute(
				"rightscr");
		if (s == null) {
			return false;
		} else {
			char ac[] = s.toCharArray();
			return ac[i] == '1';
		}
	}
	/**
	 * ����ַ�תָ��λ���Ƿ�Ϊ1
	 * @param s
	 * @param i
	 * @return
	 */
	public static boolean hasRightcr(String s, int i){            
	    if(s == null)
	       return false;
	   	char ac[] = s.toCharArray();
	    return ac[i] == '1';
	 	} 
	/**
	 * ���пͻ��������ڲ���
	 * @param httpservletrequest
	 * @return
	 */
	public static String getBrDepart(HttpServletRequest httpservletrequest) {
		String s = (String) httpservletrequest.getSession().getAttribute("brDepart");
		return s == null?"":s.trim();
	}
	/**
	 * ��ҵ�����
	 * @param httpservletrequest
	 * @return
	 */
	public static String getBrno(HttpServletRequest httpservletrequest) {
//		String s = (String) httpservletrequest.getSession().getAttribute("brno");
//		return s == null?"":s.trim();
		return "";
	}
	
	/**
	 * ��ҵ�����
	 * @param httpservletrequest
	 * @return
	 */
	public static String getWfOrgNo(HttpServletRequest httpservletrequest) {
		String s = (String) httpservletrequest.getSession().getAttribute("wfOrgNo");
		return s == null?"":s.trim();
	}
	/**
	 * ��������
	 * @param httpservletrequest
	 * @return
	 */
	public static String getBrname(HttpServletRequest httpservletrequest) {
		String s = (String) httpservletrequest.getSession().getAttribute("brName");
		return (s==null||s.equals(""))?"���������������޹�˾":s;
	}
	
	public static String getParentBrno(HttpServletRequest httpservletrequest) {
		String s = (String) httpservletrequest.getSession().getAttribute("parentBrno");
		return s == null?"":s.trim();
	}
	public static String getParentBsno(HttpServletRequest httpservletrequest) {
		String s = (String) httpservletrequest.getSession().getAttribute("parentBsno");
		return s == null?"":s.trim();
	}
	/**
	 * ���ڻ�����
	 * @param httpservletrequest
	 * @return
	 */
	public static String getBsno(HttpServletRequest httpservletrequest) {
		String s = (String) httpservletrequest.getSession().getAttribute("bsno");
		return s == null?"":s.trim();
	}
	
	/**
	 * ���ڻ�����
	 * @param httpservletrequest
	 * @return
	 */
	public static String getBsname(HttpServletRequest httpservletrequest) {
		String s = (String) httpservletrequest.getSession().getAttribute("bsName");
		return s == null?"":s.trim();
	}
	
	/**
	 * ��������
	 * @param httpservletrequest
	 * @return
	 */
	public static String getDealerCifNo(HttpServletRequest httpservletrequest) {
		String s = (String) httpservletrequest.getSession().getAttribute("dealerCifNo");
		return (s==null||s.equals(""))?"":s;
	}
	/**
	 * ����Ա��¼��
	 * @param httpservletrequest
	 * @return
	 */
	public static String getLoginid(HttpServletRequest httpservletrequest) {
		String s = (String) httpservletrequest.getSession().getAttribute("loginid");
		return s == null?"":s;
	}
	
	public static String getTlrno(HttpServletRequest httpservletrequest) {
		String s = (String) httpservletrequest.getSession().getAttribute("loginid");
		return s == null?"":s;
	}
	/**
	 * ����ԱID
	 * @param httpservletrequest
	 * @return
	 */
	public static String getUserid(HttpServletRequest httpservletrequest) {
		String s = String.valueOf(httpservletrequest.getSession().getAttribute("userid"));
		return s == null?"":s;
	}
	/**
	 * ����Ա����
	 * @param httpservletrequest
	 * @return
	 */
	public static String getDisplayName(HttpServletRequest httpservletrequest) {
		String s = (String) httpservletrequest.getSession().getAttribute("displayname");
		return s == null?"":s;
	}
	
	/**
	 * 
	 * @Title: getRoleno 
	 * @Description:  ������ɫ
	 * @param httpservletrequest
	 * @return [] 
	 * @return String []
	 */
	public static String getWkfUserRoleNos(HttpServletRequest httpservletrequest) {
		String s = (String) httpservletrequest.getSession().getAttribute("wkfRoleNos");
		return s == null?"":s;
	}
	
	public static String getWkfUserRoleNames(HttpServletRequest httpservletrequest) {
		String s = (String) httpservletrequest.getSession().getAttribute("wkfrolenames");
		return s == null?"":s;
	}
	
	

	
	/**
	 * @���� DHCC-SONG
	 * @���� Aug 5, 2016
	 * @����˵�������ݽ�ɫ����ж��Ƿ���Ȩ��
	 * @���ز��� String
	 */
	public static String getLoginIdByAuth(HttpServletRequest httpservletrequest) {
		String s = (String) httpservletrequest.getSession().getAttribute("roleNos");
		String loginid = "";
		
		//1001	��Ӫ����
		//1002	��Ӫ��Ա
		//2001	ҵ����v
		//2002	ҵ����Ա
		//8888	ҵ�����Ա
		//9999	��������Ա
		//3001	�����Ա
		//0000    ϵͳ����Ա
		
		if(s.contains("0000") ){ // �ܲ�ѯ����Ȩ��
			
		}else{ // ֻ�ܲ�ѯ�Լ�
			loginid = (String) httpservletrequest.getSession().getAttribute("loginid");
		}
		
		return loginid == null?"":loginid;
	}
	
	/**
	 * �����Ƿ��зſ�Ȩ��
	 * @param httpservletrequest
	 * @return
	 */
	public static String getBoff(HttpServletRequest httpservletrequest) {
		String s = (String) httpservletrequest.getSession().getAttribute("boff");
		return s == null?"":s;
	}
	/**
	 * ��������ȡ����
	 * @param a
	 * @return
	 */
	public static String getInt(double a) {
		String s = (String.valueOf(a).substring(0, String.valueOf(a).indexOf(".")));
		return s == null?"":s;
	}
	/**
	 * ��������
	 * @param httpservletrequest
	 * @return
	 */
	public static String getFicode(HttpServletRequest httpservletrequest) {
		String s = (String) httpservletrequest.getSession().getAttribute("ficode");
		return s == null?"":s;
	}

	/**
	 * ����Ա�Զ����ҳ��ʾ������������ҳ����ѡ��
	 * @param httpservletrequest
	 * @return
	 */
	public static String getAuth(HttpServletRequest httpservletrequest) {
		String s = (String) httpservletrequest.getSession().getAttribute("auth");
		return s == null?"":s;
	}
	/**
	 * ����Ա��Ӧ�˵�
	 * @param httpservletrequest
	 * @return
	 */
	public static String getMenuStr(HttpServletRequest httpservletrequest) {
		String s = (String) httpservletrequest.getSession().getAttribute("menustr");
		return s == null?"":s;
	}
	
	public static String getTrade(HttpServletRequest httpservletrequest) {
		String s = (String) httpservletrequest.getSession().getAttribute("trade");
		return s == null?"":s;
	}
	/**
	 * ����Ա��ɫ���
	 * @param httpservletrequest
	 * @return
	 */
	public static String getRoleno(HttpServletRequest httpservletrequest) {
		String s = (String) httpservletrequest.getSession().getAttribute("roleno");
		return s == null?"":s;
	}
	
	public static String getAllRoleno(HttpServletRequest httpservletrequest) {
		String s = (String) httpservletrequest.getSession().getAttribute("allRoleNo");
		return s == null?"":s;
	}
	/**
	 * ��Ա����
	 * @param httpservletrequest
	 * @return
	 */
	public static String getOp_lev(HttpServletRequest httpservletrequest) {//����Ա����,�����������е�
		String s = (String) httpservletrequest.getSession().getAttribute("op_lev");
		return s == null?"":s;
	}
	public static String getGlobal(HttpServletRequest httpservletrequest) {//glo
		String s = (String) httpservletrequest.getSession().getAttribute("sys_date");
		return s == null?"":s;
	}
	/**
	 * 
	 * ���������� ����״̬�Ƿ�ע��
	 * @param httpservletrequest
	 * @return
	 * @�޸���־��
	 */
	public static String getState(HttpServletRequest httpservletrequest) {//glo
		String s = (String) httpservletrequest.getSession().getAttribute("state");
		return s == null?"":s;
	}
	/**
	 * 
	 * �����������Ƿ���Ȩ
	 * @param httpservletrequest
	 * @return
	 * @�޸���־��
	 */
	public static String getAccState(HttpServletRequest httpservletrequest) {//glo
		String s = (String) httpservletrequest.getSession().getAttribute("accstate");
		return s == null?"":s;
	}
	/**
	 * 
	 * ������������Ȩ�����ĸ�λ
	 * @param httpservletrequest
	 * @return
	 * @�޸���־��
	 */
	public static String getAccPost(HttpServletRequest httpservletrequest) {//glo
		String s = (String) httpservletrequest.getSession().getAttribute("accspost");
		return s == null?"":s;
	}
	/**
	 * ����Ա����������������
	 * @param httpservletrequest
	 * @return
	 */
	public static String getAreano(HttpServletRequest httpservletrequest){
		String s = (String)httpservletrequest.getSession().getAttribute("areano");
		return s == null?"":s;
	}
	/**
	 * 
	 * �������������ֻƺ����л�������������
	 * @param httpservletrequest
	 * @return
	 * @�޸���־��
	 */
	public static String getAcflg(HttpServletRequest httpservletrequest) {
		String s = (String) httpservletrequest.getSession().getAttribute("acflg");
		return s == null?"":s;
	}
	
	/**
	 * ������Ա�Ƿ�������Ȩ��
	 * @param httpservletrequest
	 * @return
	 */
	public static String getAppstate(HttpServletRequest httpservletrequest){
		String s = (String)httpservletrequest.getSession().getAttribute("appstate");
		return s == null?"":s;
	}
	/**
	 * �ͻ������Ƿ��а���������������������ĩ������ֻ����ת��������Ȩ��
	 * @param httpservletrequest
	 * @return
	 */
	public static String getNew(HttpServletRequest httpservletrequest){
		String s = (String)httpservletrequest.getSession().getAttribute("new");
		return s == null?"":s;
	}
	/**
	 * �ͻ������Ƿ��а���ת�������»��ɡ��ջ��ٴ����ʲ����飩Ȩ��
	 * @param httpservletrequest
	 * @return
	 */
	public static String getSwitch(HttpServletRequest httpservletrequest){
		String s = (String)httpservletrequest.getSession().getAttribute("switch");
		return s == null?"":s;
	}
	/**
	 * �ͻ������Ƿ��а�����Ѻ����Ȩ��
	 * @param httpservletrequest
	 * @return
	 */
	public static String getImpawn(HttpServletRequest httpservletrequest){
		String s = (String)httpservletrequest.getSession().getAttribute("impawn");
		return s == null?"":s;
	}
	/**
	 * �ͻ������Ƿ��а����Ѻ����Ȩ��
	 * @param httpservletrequest
	 * @return
	 */
	public static String getPledge(HttpServletRequest httpservletrequest){
		String s = (String)httpservletrequest.getSession().getAttribute("pledge");
		return s == null?"":s;
	}
	/**
	 * �ͻ������Ƿ��а���֤����Ȩ��
	 * @param httpservletrequest
	 * @return
	 */
	public static String getVou(HttpServletRequest httpservletrequest){
		String s = (String)httpservletrequest.getSession().getAttribute("vou");
		return s == null?"":s;
	}
	/**
	 * �ͻ������Ƿ��а������ô���Ȩ��
	 * @param httpservletrequest
	 * @return
	 */
	public static String getCredit(HttpServletRequest httpservletrequest){
		String s = (String)httpservletrequest.getSession().getAttribute("credit");
		return s == null?"":s;
	}
	/**
	 * ȡ�ͻ���
	 * @param httpservletrequest
	 * @return
	 */
	public static String getCifno(HttpServletRequest httpservletrequest){
		String s = (String)httpservletrequest.getSession().getAttribute("cifno");
		return s == null?"":s;
	}
	/**
	 * ȡ�ͻ���
	 * @param httpservletrequest
	 * @return
	 */
	public static String getCifname(HttpServletRequest httpservletrequest){
		String s = (String)httpservletrequest.getSession().getAttribute("cifname");
		return s == null?"":s;
	}
	/**
	 * ȡ֤����
	 * @param httpservletrequest
	 * @return
	 */
	public static String getIdnum(HttpServletRequest httpservletrequest){
		String s = (String)httpservletrequest.getAttribute("idnum");
		return s == null?"":s;
	}
	/**
	 * 
	 * 
	 * �������������ָ�ʽ��
	 * @param number
	 * 					����
	 * @param precision
	 * 					����
	 * @see
	 * @�޸���־��
	 *
	 */
	public static String numFormat(double number,int precision){
		DecimalFormat myformat=null;
		if(precision==2){
		myformat = new DecimalFormat("###0.00");//ʹ��ϵͳĬ�ϵĸ�ʽ
		}else if(precision==1){
			myformat = new DecimalFormat("###0.0");//ʹ��ϵͳĬ�ϵĸ�ʽ	
		}else if(precision==4){
			myformat = new DecimalFormat("###0.0000");//ʹ��ϵͳĬ�ϵĸ�ʽ	
		}else if(precision==0){
			myformat = new DecimalFormat("###0");//ʹ��ϵͳĬ�ϵĸ�ʽ	
		}
		return myformat.format(number);
	}
	public static String getBigNum(String bigNum){
		BigDecimal bd = new BigDecimal(bigNum);
		return bd.toPlainString();
	}
	/**
	 * �����������Զ���ú�ͬ��������
	 * @param month �����
	 * @param day �����
	 * @param startdate ��ʼ����
	 * @�޸���־��
	 */
//	public String setcalendar(String startdate, String month, String day) throws ParseException {
//		String r = "";
//		Calendar mycal = Calendar.getInstance();
//		// Date mydat = null;
//		Date mydate;
//		SimpleDateFormat formater = new SimpleDateFormat("yyyyMMdd");
//		try {
//			mydate = formater.parse(startdate);
//			mycal.setTime(mydate);
//			mydate.setMonth(mydate.getMonth() + Integer.parseInt(month.equals("") ? "0" : month));
//			mydate.setDate(mydate.getDate() + (Integer.parseInt(day.equals("") ? "0" : day)));
//			r = formater.format(mydate);
//		} catch (ParseException e1) {
//			e1.printStackTrace();
//		}
//		return r;
//	}
	
	/**
	 * ��������������������ڵ�ǰһ��
	 * @param curDate 	 
	 * @�޸���־��
	 */
	public static String getBhdate(String curDate) {
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
		String lastday="";
	    Calendar mycal=Calendar.getInstance();
		mycal.set(Integer.parseInt(curDate.substring(0,4)), Integer.parseInt(curDate.substring(4,6))-1, Integer.parseInt(curDate.substring(6,8))-1);
		lastday=df.format(mycal.getTime());
		return lastday;
	}
	/**
	 * 
	 * @param httpservletrequest
	 * @return  ���������·�(YYYY-MM)
	 * Jul 7, 2011
	 * @desc
	 */
	public static String getLastMonth(HttpServletRequest httpservletrequest){
		String s =   getSys_date(httpservletrequest);
		if( s == null)
			return "";
		int intMonth = Integer.valueOf(s.substring(4,6))-1;
		int intYear = Integer.valueOf(s.substring(0,4));
		if(1==intMonth){
			intMonth = 12;
			 intYear--;
		}
		return intMonth < 10? String.valueOf(intYear)+"-0"+String.valueOf(intMonth):String.valueOf(intYear)+"-"+String.valueOf(intMonth);
		
	}
	/**
	 * 
	 * @param httpservletrequest
	 * @return  �����������(YYYY)
	 * Jul 7, 2011 seasons
	 * @desc
	 */
	public static String getLastYear(HttpServletRequest httpservletrequest){
		String s =   getSys_date(httpservletrequest);
		if( s == null)
			return "";
		int intYear = Integer.valueOf(s.substring(0,4));		
		return String.valueOf(--intYear);
		
	}
	/**
	 * 
	 * @param httpservletrequest
	 * @return  �����ϼ���(YYYY-0?)?����ڼ�����
	 * Jul 7, 2011 seasons
	 * @desc
	 */
	public static String getLastseasons(HttpServletRequest httpservletrequest){
		String s =   getSys_date(httpservletrequest);
		if( s == null)
			return "";
		int intSeasons = (Integer.valueOf(s.substring(4,6))-1)/3;
		int intYear = Integer.valueOf(s.substring(0,4));
		if(0==intSeasons){
			intSeasons = 4;
			 intYear--;
		}	
		return String.valueOf(intYear)+"-0"+String.valueOf(intSeasons);
		
	}
	/**
	 * 
	 * ����������ȡ��ϵͳӪҵʱ��
	 * @param httpservletrequest
	 * @return
	 * @�޸���־��
	 */
	public static String getSys_date(HttpServletRequest httpservletrequest){
		String s = (String)httpservletrequest.getSession().getAttribute("sys_date");
		return s == null?"":s;
	}
	//�б�Ĭ����ʾ����
	public static int getPageSize(){
		return 10;
	}
	/**
	 * 
	 * ����������ȡ���ĵ��ϴ���С����
	 * @param httpservletrequest
	 * @return double
	 */
	public static double getDocSize(HttpServletRequest httpservletrequest){
		Double s = (Double)httpservletrequest.getSession().getAttribute("doc_size");//kb
		return s == null?0:s.doubleValue();
	}
	
	public static String gethnTime() {
		Date date = new Date();
		SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyyMMddHHmmss");
		return simpledateformat.format(date);
	}
}
