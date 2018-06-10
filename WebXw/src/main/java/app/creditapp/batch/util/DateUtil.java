package app.creditapp.batch.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.regex.Pattern;

/**
 * 
 *
 */
public class DateUtil {
	
	/**
	 * ��ȡϵͳӪҵ����
	 * @param conn
	 * @return
	 */
	public static String getSysDate(){
		String sys_date = "";
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "SELECT SYS_DATE FROM SYS_GLOBAL WHERE GLO_NO='0000000000'";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				sys_date = rs.getString(1);
			}
			ps.close();
			rs.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sys_date;
	}
	
	
	/**
	 * ��ȡ��ǰ��������
	 * @parm connection ���ݿ�����
	 * @throws Exception
	 */
	public static String getBatchDate() throws Exception{
		String batchDate = "";
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "SELECT BAT_DATE FROM SYS_GLOBAL";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			batchDate = "";
			while(rs.next()){
				batchDate = rs.getString(1);
			}
			ps.close();
			rs.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return batchDate;
	}
	
	/**
	 * �������������ַ���ת��ΪCalendar
	 * 
	 * @param strdate
	 *            Ԥת�����ַ���
	 * @return Calendar
	 * @�޸���־��1.0
	 */
	public static Calendar parseCalendar(String strdate) {
		if (isDateStr(strdate)) {
			int year = Integer.parseInt(strdate.substring(0, 4));
			int month = Integer.parseInt(strdate.substring(4, 6)) - 1;
			int day = Integer.parseInt(strdate.substring(6, 8));
			return new GregorianCalendar(year, month, day);
		} else {
			return null;
		}
	}
	
	/**
	 * �����������ж��ַ����Ƿ����ת��Ϊ������ �ǣ�true����false
	 * 
	 * @param strdate
	 *            Ԥת���ַ���
	 * @return boolean
	 * @�޸���־��1.0
	 */
	public static boolean isDateStr(String strdate) {
		if (strdate.length() != 8) {
			return false;
		}

		String reg = "^(\\d{4})((0([1-9]{1}))|(1[012]))((0[1-9]{1})|([1-2]([0-9]{1}))|(3[0|1]))$";

		if (Pattern.matches(reg, strdate)) {
			return getDaysOfMonth(strdate) >= Integer.parseInt(strdate
					.substring(6, 8));
		} else {
			return false;
		}
	}
	
	/**
	 * ������������ȡĳһ�·ݵ�����
	 * 
	 * @param strdate
	 *            ���� ��ʽ��yyyymmdd �� yyyymm
	 * @return int
	 * @�޸���־��1.0
	 */
	public static int getDaysOfMonth(String strdate) {
		int m = Integer.parseInt(strdate.substring(4, 6));
		switch (m) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			return 31;
		case 4:
		case 6:
		case 9:
		case 11:
			return 30;
		case 2:
			if (isLeapYear(strdate)) {
				return 29;
			} else {
				return 28;
			}
		default:
			return 0;
		}
	}
	
	/**
	 * �����������ж��Ƿ������꣨����1000--9999���ǣ�true����false
	 * 
	 * @param strdate
	 *            Ԥ�ж��� ��ʽyyyymmdd �� yyyy
	 * @return boolean
	 * @�޸���־��1.0
	 */
	public static boolean isLeapYear(String strdate) {
		int y = Integer.parseInt(strdate.substring(0, 4));
		if (y <= 999) {
			return false;
		}
		if (y % 400 == 0 || (y % 4 == 0 && y % 100 != 0)) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * ���������������ڸ��������ڼ��ϻ��ȥ n ��������
	 * @param datestr
	 *            ����������
	 * @param days
	 *            �������ӣ���֮����
	 * @return String
	 * @�޸���־��
	 */
	public static String addByDay(String datestr, int days) {
		Calendar cal = parseCalendar(datestr);
		cal.add(Calendar.DATE, days);
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		Date date = cal.getTime();
		return format.format(date);
	}
	
    public static void main(String[] args) throws Exception {
	    String str="20161031";
        System.out.println(addByDay(str,1));
    }

}
