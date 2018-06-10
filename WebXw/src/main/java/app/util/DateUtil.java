package app.util;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Pattern;

import app.base.ServiceException;
import app.base.SourceTemplate;
import app.creditapp.dao.SysGlobalDAO;
import app.creditapp.entity.SysGlobal;

/**
 * �������������ڴ������ࣨ����Calendar�� ��Ҫ���ܣ�����У�飻��ȡϵͳ��ǰ���ڣ����Զ���ϵͳ���ڣ����ж����ꣻ��ȡ��������֮���������������
 * �ж����ڵ�ǰ�󣻽��ַ���ת��ΪDate��Calendar��... ���ڸ�ʽĬ�ϣ�yyyyMMdd
 * 
 * @see null
 * @�޸���־��1.0
 */
public class DateUtil extends Object {

	/**
	 * ��ǰ����ϵͳ���� Calendar
	 */
	private static Calendar calendar = new GregorianCalendar(
			TimeZone.getDefault());
	/**
	 * ���ڸ�ʽ Ĭ�ϣ�yyyyMMdd
	 */
	private static String pattern = "yyyyMMdd";
	/**
	 * ʱ���ʽ Ĭ�ϣ�HH:mm:ss
	 */
	private static String timePattern = "HH:mm:ss";

	/**
	 * ��
	 */
	private static int year = 0;
	/**
	 * ��
	 */
	private static int month = 0;
	/**
	 * ��
	 */
	private static int day = 0;
	/**
	 * ʱ
	 */
	private static int hour = 0;
	/**
	 * ��
	 */
	private static int minute = 0;
	/**
	 * ��
	 */
	private static int second = 0;

	/**
	 * ��̬��ʼ����Ĭ��ϵͳ��ǰ���ں�ʱ�䣩
	 */
	static {
		year = calendar.get(Calendar.YEAR);
		month = calendar.get(Calendar.MONTH) + 1;
		day = calendar.get(Calendar.DAY_OF_MONTH);
		hour = calendar.get(Calendar.HOUR_OF_DAY);
		minute = calendar.get(Calendar.MINUTE);
		second = calendar.get(Calendar.SECOND);
	}

	/**
	 * ���췽��
	 */
	private DateUtil() {
		// Do Nothing
	}

	/**
	 * ȡϵͳӪҵ����
	 * 
	 * @return
	 */
	public static String getSysDate() {
		SysGlobalDAO dao = SourceTemplate.getSpringContextInstance().getBean(
				"sysGlobalDAO", SysGlobalDAO.class);
		SysGlobal sysGlobal = dao.getSysGlobal();
		return sysGlobal.getSys_date();
	}

	/**
	 * ȡϵͳ��Ϣ
	 * 
	 * @return
	 */
	public static SysGlobal getSysGlobal() {
		SysGlobalDAO dao = SourceTemplate.getSpringContextInstance().getBean(
				"sysGlobalDAO", SysGlobalDAO.class);
		SysGlobal sysGlobal = dao.getSysGlobal();
		return sysGlobal;
	}

	/**
	 * �����������Զ���ϵͳʱ�䡣������ʹ�ã�
	 * 
	 * @param strdate
	 *            �Զ��������ַ�������ʽ��yyyymmdd
	 * @�޸���־��1.0
	 */
	public static void setSysDate(String strdate) {
		if (isDateStr(strdate)) {
			calendar = parseCalendar(strdate);

			year = calendar.get(Calendar.YEAR);
			month = calendar.get(Calendar.MONTH) + 1;
			day = calendar.get(Calendar.DAY_OF_MONTH);
			hour = calendar.get(Calendar.HOUR_OF_DAY);
			minute = calendar.get(Calendar.MINUTE);
			second = calendar.get(Calendar.SECOND);
		}
	}

	/**
	 * ���������� ��ʼ��ϵͳ����(��ǰϵͳ����)����setSysDate()����õ��η������³�ʼ��ϵͳ����ʱ�� Ϊ��ǰ����ʱ��
	 * 
	 * @�޸���־��1.0
	 */
	public static void initSys() {
		calendar = new GregorianCalendar(TimeZone.getDefault());

		year = calendar.get(Calendar.YEAR);
		month = calendar.get(Calendar.MONTH) + 1;
		day = calendar.get(Calendar.DAY_OF_MONTH);
		hour = calendar.get(Calendar.HOUR_OF_DAY);
		minute = calendar.get(Calendar.MINUTE);
		second = calendar.get(Calendar.SECOND);
	}

	/**
	 * ������������ȡϵͳ��ǰ����---��
	 * 
	 * @return int ��
	 * @�޸���־��1.0
	 */
	public static int getYear() {
		return year;
	}

	/**
	 * ������������ȡϵͳ��ǰ����---��
	 * 
	 * @return String ��
	 * @�޸���־��1.0
	 */
	public static String getStrYear() {
		return String.valueOf(year);
	}

	/**
	 * ������������ȡϵͳ��ǰ����---��
	 * 
	 * @return int ��
	 * @�޸���־��1.0
	 */
	public static int getMonth() {
		return month;
	}

	/**
	 * ������������ȡϵͳ��ǰ����---��
	 * 
	 * @return String ��
	 * @�޸���־��1.0
	 */
	public static String getStrMonth() {
		return month >= 10 ? String.valueOf(month) : "0"
				+ String.valueOf(month);
	}

	/**
	 * ������������ȡϵͳ��ǰ����---��
	 * 
	 * @return int ��
	 * @�޸���־��1.0
	 */
	public static int getDay() {
		return day;
	}

	/**
	 * ������������ȡϵͳ��ǰ����---��
	 * 
	 * @return String ��
	 * @�޸���־��1.0
	 */
	public static String getStrDay() {
		return day < 10 ? "0" + String.valueOf(day) : String.valueOf(day);
	}

	/**
	 * 
	 * ������������ȡϵͳʱ��--Сʱ
	 * 
	 * @return int
	 * @�޸���־��1.0
	 */
	public static int getHour() {
		return hour;
	}

	/**
	 * 
	 * ������������ȡϵͳʱ��--����
	 * 
	 * @return int
	 * @�޸���־��
	 */
	public static int getMinute() {
		return minute;
	}

	/**
	 * 
	 * ������������ȡϵͳʱ��--��
	 * 
	 * @return int
	 * @�޸���־��
	 */
	public static int getSecond() {
		return second;
	}

	/**
	 * ������������ȡϵͳ��ǰ����---������ ����ʽ��yyyymmdd��
	 * 
	 * @return String ������
	 * @�޸���־��1.0
	 */
	public static String getDate() {
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		Date date = calendar.getTime();
		return format.format(date);
	}
	/**
	 * ������������ȡϵͳ��ǰ����---������ ����ʽ��yyyymmdd��
	 * 
	 * @return String ʱ����
	 * @�޸���־��1.0
	 */
	public static String getTime() {
		Calendar calendarTime = new GregorianCalendar(TimeZone.getDefault());
		SimpleDateFormat format = new SimpleDateFormat(timePattern);
		Date date = calendarTime.getTime();
		return format.format(date);
	}

	/**
	 * ��������������Ԥ����ʽȡϵͳ��ǰ����---������
	 * 
	 * @param ptn
	 *            ���ڸ�ʽ
	 * @return String
	 * @�޸���־��1.0
	 */
	public static String getDate(String ptn) {
		SimpleDateFormat format = new SimpleDateFormat(ptn);
		Date date = calendar.getTime();
		return format.format(date);
	}

	/**
	 * ������������ȡϵͳʱ�� ��ʽ��yyyymmdd hh:mm:ss
	 * 
	 * @return String
	 * @�޸���־��1.0
	 */
	public static String getDateTime() {
		Calendar calendarTime = new GregorianCalendar(TimeZone.getDefault());
		SimpleDateFormat format = new SimpleDateFormat(pattern + " "
				+ timePattern);
		Date date = calendarTime.getTime();
		return format.format(date);
	}

	/**
	 * 
	 * ������������ȡԤ�����ʽ��ϵͳʱ��
	 * 
	 * @param datePtn
	 *            ���ڸ�ʽ
	 * @param timePtn
	 *            ʱ���ʽ
	 * @return String
	 * @�޸���־��1.0
	 */
	public static String getDateTime(String datePtn, String timePtn) {
		SimpleDateFormat format = new SimpleDateFormat(datePtn + " " + timePtn);
		Date date = calendar.getTime();
		return format.format(date);
	}

	/**
	 * �����������жϸ������ڣ���ʽyyyymmdd���Ƿ���ϵͳ����֮ǰ���ǣ�����ڣ���true����false
	 * 
	 * @param strdate
	 *            ��������
	 * @return boolean
	 * @�޸���־��1.0
	 */
	public static boolean isBefore(String strdate) {
		Calendar cal = parseCalendar(strdate);
		return cal.before(calendar);
	}
	/**
	 * �����������жϸ������ڣ���ʽyyyymmdd���Ƿ���ϵͳ����֮ǰ���ǣ�����ڣ���true����false
	 * 
	 * @param strdate
	 *            ��������
	 * @return boolean
	 * @�޸���־��1.0
	 */
	public static boolean isBeforeSydate(String strdate) {
		Calendar cal1 = parseCalendar(strdate);//921
		Calendar cal2 =   parseCalendar(getSysDate());//920
		return cal2.before(cal1);
	}
	/**
	 * 
	 * �����������жϸ������������ڵ�ǰ��strdate1��strdate2֮ǰ����ͬһ�죩������true����֮��false
	 * 
	 * @param strdate1
	 *            ����1
	 * @param strdate2
	 *            ����2
	 * @return boolean
	 * @�޸���־��1.0
	 */
	public static boolean isBefore(String strdate1, String strdate2) {
		Calendar cal1 = parseCalendar(strdate1);
		Calendar cal2 = parseCalendar(strdate2);
		return cal1.before(cal2);
	}

	/**
	 * 
	 * ���������������ڵ�ǰϵͳ�������ӻ���� n ��������
	 * 
	 * @param days
	 *            ���ӻ���ٵ��������������ӣ���֮����
	 * @�޸���־��
	 */
	public static String addByDay(int days) {
		initSys();
		calendar.add(Calendar.DATE, days);
		return getDate();
	}

	/**
	 * 
	 * ���������������ڸ��������ڼ��ϻ��ȥ n ��������
	 * 
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
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		Date date = cal.getTime();
		return format.format(date);
	}
	/**
	 * ��������������ʱ���һ�£���ʽΪ   yyyyMMdd
	 * @param time ����ʱ��
	 * @return ����֮���ʱ��
	 * @throws ParseException 
	 */
	public static String addBMonth(String time) throws ParseException{
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
		java.util.Date date=sdf.parse(time); 
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.MONTH, -1);
		return sdf.format(c.getTime());
	}
	/**
	 * 
	 * ������������ø���������ϵͳ��ǰ����֮�������
	 * 
	 * @param strdate
	 *            �����������ַ���
	 * @return long ����
	 * @�޸���־��1.0
	 */
	public static long getDays(String strdate) {
		Calendar cal = parseCalendar(strdate);
		Calendar cal1 = parseCalendar(getDate());
		long millis = Math.abs(cal.getTimeInMillis() - cal1.getTimeInMillis());
		return millis / (24 * 60 * 60 * 1000);
	}

	/**
	 * 
	 * ������������ø�������������֮���������������ڲ���ǰ��
	 * 
	 * @param fromdate
	 *            �����ַ��� ��ʽ��yyyymmdd
	 * @param todate
	 *            �����ַ��� ��ʽ��yyyymmdd
	 * @return long
	 * @�޸���־��1.0
	 */
	public static long getDaysBetween(String fromdate, String todate) {
		Calendar from = parseCalendar(fromdate);
		Calendar to = parseCalendar(todate);
		long millis = Math.abs(from.getTimeInMillis() - to.getTimeInMillis());
		return millis / (24 * 60 * 60 * 1000);
	}

	/**
	 * ����Date *
	 * 
	 * @param str
	 *            yyyy-MM-dd String
	 * @return Date
	 */
	public static Date parseTenStrToDate(String str) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date d = null;
		try {
			d = df.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return d;
	}

	/**
	 * ����Date *
	 * 
	 * @param str
	 *            yyyyMMdd String
	 * @return Date
	 */
	public static Date parseEightStrToDate(String str) {
		DateFormat df = new SimpleDateFormat("yyyyMMdd");
		Date d = null;
		try {
			d = df.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return d;
	}

	/**
	 * ����String *
	 * 
	 * @param date
	 *            Date
	 * @return String yyyyMMdd
	 */
	public static String parseDateToEightStr(Date date) {
		DateFormat df = new SimpleDateFormat("yyyyMMdd");
		return df.format(date);
	}

	/**
	 * ����String *
	 * 
	 * @param date
	 *            Date
	 * @return String yyyy-MM-dd
	 */
	public static String parseDateToTenStr(Date date) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		return df.format(date);
	}

	/**
	 * 
	 * ������������ø���������ϵͳ��ǰ����֮�����������������
	 * 
	 * @param strdate
	 *            �����������ַ���
	 * @return long ����
	 * @�޸���־������
	 */
	private static long getMonths(String strdate) {
		long months = getMonth() - Integer.parseInt(strdate.substring(4, 6));
		long years = getYear() - Integer.parseInt(strdate.substring(0, 4));
		if (!isBefore(strdate)) {
			months = -months;
			years = -years;
		}
		if (months >= 0) {
			return years * 12 + months;
		} else {
			return (years - 1) * 12 + months + 12;
		}
	}

	/**
	 * 
	 * ���������������������֮����²�������������
	 * 
	 * @param strdate1
	 * @param strdate2
	 * @return long
	 * @�޸���־������
	 */
	public static long getMonths(String strdate1, String strdate2) {
		long m = 0;
		setSysDate(strdate1);
		m = getMonths(strdate2);
		initSys();
		return m;
	}

	/**
	 * 
	 * ������������ø���������ϵͳ��ǰ����֮�������������
	 * 
	 * @param strdate
	 *            �����������ַ���
	 * @return long[] �±�0������1����
	 * @�޸���־������
	 */
	public static long[] getMonthsAndDays(String strdate) {
		long m = getMonths(strdate);
		int d = getDay() - Integer.parseInt(strdate.substring(6, 8));
		String date = "";
		if (!isBefore(strdate)) {
			d = -d;
			date = strdate;
		} else {
			date = getDate();
		}
		while (d < 0) {
			m--;
			d += getDaysOfMonth(date);
		}
		long[] md = { m, d };
		return md;
	}

	/**
	 * 
	 * ������������ø�����������֮�������������
	 * 
	 * @param strdate1
	 * @param strdate2
	 * @return long[] �±�0������1����
	 * @�޸���־��
	 */
	public static long[] getMonthsAndDays(String strdate1, String strdate2) {
		long m = getMonths(strdate1, strdate2);
		int d = Integer.parseInt(strdate1.substring(6, 8))
				- Integer.parseInt(strdate2.substring(6, 8));
		String date = "";
		if (!isBefore(strdate1, strdate2)) {
			date = strdate1;
		} else {
			d = -d;
			date = strdate2;
		}
		while (d < 0) {
			m--;
			d += getDaysOfMonth(date);
		}
		long[] md = { m, d };
		return md;
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
	 * �õ�ĳ��ĳ�µ����� *
	 * 
	 * @param year
	 *            int
	 * @param month
	 *            int
	 * @return int
	 */
	public static int getMonthDays(int year, int month) {
		int days = 1;
		boolean isrn = (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)) ? true
				: false;
		switch (month) {
		case 1:
			days = 31;
			break;
		case 2:
			if (isrn)
				days = 29;
			else
				days = 28;
			break;
		case 3:
			days = 31;
			break;
		case 4:
			days = 30;
			break;
		case 5:
			days = 31;
			break;
		case 6:
			days = 30;
			break;
		case 7:
			days = 31;
			break;
		case 8:
			days = 31;
			break;
		case 9:
			days = 30;
			break;
		case 10:
			days = 31;
			break;
		case 11:
			days = 30;
			break;
		case 12:
			days = 31;
		}
		return days;
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
	 * �������������ַ���ת��ΪDate������ ���ڸ�ʽyyyymmdd
	 * 
	 * @param strdate
	 *            Ԥת�����ַ���
	 * @return Date
	 * @�޸���־��1.0
	 */
	public static Date parseDate(String strdate) {
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		Date d = null;
		try {
			d = format.parse(strdate);
		} catch (Exception pe) {
			pe.printStackTrace();
		}
		return d;
	}

	public static final String getDateTime(Date aDate) {
		SimpleDateFormat df = null;
		String returnValue = "";
		if (aDate != null) {
			df = new SimpleDateFormat(pattern);
			returnValue = df.format(aDate);
		}

		return (returnValue);
	}

	/**
	 * ��������ȡ�����ڼ�
	 * 
	 * @param DateStr yyyyMMdd
	 * @return
	 */
	public static String getWeekDay(String DateStr) {
		SimpleDateFormat formatYMD = new SimpleDateFormat("yyyyMMdd");// formatYMD��ʾ����yyyyMMdd��ʽ
		SimpleDateFormat formatD = new SimpleDateFormat("E");// "E"��ʾ"day in week"
		Date d = null;
		String weekDay = "";
		try {
			d = formatYMD.parse(DateStr);// ��String ת��Ϊ���ϸ�ʽ������
			weekDay = formatD.format(d);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return weekDay;
	}

	/**
	 * ����ÿ�µ�һ�����ڼ���һ������ȷ������
	 * 
	 * @param week
	 * @param days
	 * @return
	 */
	public static int line(String week, int days) {
		int line = 0;
		if (week.equals("������")) {
			if (days >= 29) {
				line = 5;
			} else {
				line = 4;
			}
		} else if (week.equals("����һ")) {
			line = 5;
		} else if (week.equals("���ڶ�")) {
			line = 5;
		} else if (week.equals("������")) {
			line = 5;
		} else if (week.equals("������")) {
			line = 5;
		} else if (week.equals("������")) {
			if (days >= 31) {
				line = 6;
			} else {
				line = 5;
			}
		} else if (week.equals("������")) {
			if (days >= 30) {
				line = 6;
			} else {
				line = 5;
			}
		}
		return line;
	}

	/**
	 * ���ݲ���busidate������һ�·ݵ�6λ����(YYYYMM��ʽ)
	 * 
	 * @param busidate yyyyMM
	 * @return
	 */
	public static String getLastMonth(String busidate) {
		String last_month = null;
		if (busidate == null || busidate.length() < 6)
			return null;
		int month = Integer.parseInt(busidate.substring(4));
		int year = Integer.parseInt(busidate.substring(0, 4));
		if (month == 1) {
			last_month = (year - 1) + "12";
		} else {
			month--;
			if (month > 9) {
				last_month = year + String.valueOf(month);
			} else {
				last_month = year + "0" + String.valueOf(month);
			}
		}
		return last_month;
	}

	/**
	 * �������ھ��������º������(���뼸λ���ڱ㷵�ض���λ�ĸ�ʽ)
	 * 
	 * @param dateStr yyyy-MM-dd
	 * @param hkm
	 *            int
	 * @return String
	 */
	public static String getDateStr(String dateStr, int hkm) {
		String st_return = "";
		boolean isEight = true;
		if (dateStr.split("-").length == 3) {
			isEight = false;
		} else {
			dateStr = dateStr.substring(0, 4) + "-" + dateStr.substring(4, 6)
					+ "-" + dateStr.substring(6, 8);
		}
		try {
			DateFormat daf_date = DateFormat.getDateInstance(DateFormat.MEDIUM,
					Locale.CHINA);
			daf_date.parse(dateStr);
			Calendar calendar = daf_date.getCalendar();
			calendar.add(Calendar.MONTH, hkm);
			String st_m = "";
			String st_d = "";
			int y = calendar.get(Calendar.YEAR);
			int m = calendar.get(Calendar.MONTH)+1;
			int d = calendar.get(Calendar.DAY_OF_MONTH);
			if (m <= 9) {
				st_m = "0" + m;
			} else {
				st_m = "" + m;
			}
			if (d <= 9) {
				st_d = "0" + d;
			} else {
				st_d = "" + d;
			}
			if (isEight) {
				st_return = y + "" + st_m + "" + st_d;
			} else {
				st_return = y + "-" + st_m + "-" + st_d;
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return st_return;
	}

	/**
	 * ������λ�����ִ� *
	 * 
	 * @param sz
	 *            int
	 * @return String
	 */
	public static String bZero(int sz) {
		return (sz < 10 ? ("0" + String.valueOf(sz)) : String.valueOf(sz));
	}

	/**
	 * ��YYYYMMDDת����YYYY-MM-DD
	 * 
	 * @param date
	 * @return
	 */
	public static String getStr(String date) {
		if (null == date || "".equals(date))
			return "";
		String dateStr = "";
		try {
			Date d = parseEightStrToDate(date);
			dateStr = parseDateToTenStr(d);
		} catch (Exception e) {
			dateStr = date;
		}
		return dateStr;
	}

	/**
	 * ��YYYYMMDDת����YYYY-MM-DD
	 * 
	 * @param date
	 * @return
	 */
	public static String changeToShow(String date) {
		return date != null && date.length() == 8 ? date.substring(0, 4) + "-"
				+ date.substring(4, 6) + "-" + date.substring(6, 8) : "";
	}
	/**
	 * ��YYYY-MM-DDת����YYYYMMDD
	 * 
	 * @param date
	 * @return
	 */
	public static String changeToDB(String date) {
		return date == null ? "" : date.replaceAll("-", "");

	}
	/**
	 * ��������ת�����ַ����� *
	 * 
	 * @param date
	 *            Date
	 * @return String
	 */
	public static String dateToStr(Date date) {
		String str = "";
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			str = sdf.format(date);
		} catch (Exception ex) {
			str = "";
		}
		return str;
	}

	/**
	 * �Ƚ����ڴ�С *
	 * 
	 * @param date1
	 *            String yyyy-MM-dd
	 * @param date2
	 *            String yyyy-MM-dd
	 * @return int date1>date2 return 1 date1==date2 return 0 date1<date2 return
	 *         -1
	 */
	public static int compareDate(String date1, String date2) {
		Date date11 = parseTenStrToDate(date1);
		Date date22 = parseTenStrToDate(date2);
		return date11.compareTo(date22);
	}

	/**
	 * �����������ڼ�������� *
	 * 
	 * @param beginDate
	 *            String yyyy-MM-dd
	 * @param endDate
	 *            String yyyy-MM-dd
	 * @return int
	 */
	public static int getBetweenDays(String beginDate, String endDate) {
		boolean exchangeFlag = false;
		if (DateUtil.compareDate(beginDate, endDate) == 1) {
			String temp = beginDate;
			beginDate = endDate;
			endDate = temp;
			exchangeFlag = true;
		}
		int sum = 0;
		int beginYear = getCurrentYear(beginDate);
		int beginMonth = getCurrentMonth(beginDate);
		int beginDay = getCurrentDay(beginDate);
		int endYear = getCurrentYear(endDate);
		int endMonth = getCurrentMonth(endDate);
		int endDay = getCurrentDay(endDate);
		String startDateStr = String.valueOf(beginYear) + "-"
				+ bZero(beginMonth) + "-01";

		int sumMonth = (endYear - beginYear + 1) * 12 - (beginMonth)
				- (12 - endMonth);
		for (int i = 0; i < sumMonth; i++) {
			String dateStr = getDateStr(startDateStr, i);
			sum = sum + getMonthDays(getCurrentYear(dateStr),
							getCurrentMonth(dateStr));
		}

		sum = sum - beginDay + endDay;
		if (exchangeFlag) {
			sum = -sum;
		}
		return sum;
	}
	/**
	 * ��YYYY-MM-DDת����YYYYMMDD
	 * 
	 * @param date
	 * @return
	 */
	public static String getYYYYMMDD(String date) {
		if (date == null) {
			return "";
		} else if (date.length() == 8) {
			return date;
		} else {
			return date.replace("-", "");
		}
	}
	/**
	 * �õ��������ڵ���� ����ȡyyyy-MM-dd�е�yyyy��
	 * 
	 * @param dateStr
	 *            String
	 * @return int
	 */
	public static int getCurrentYear(String dateStr) {
		String date[] = dateStr.split("-");
		return Integer.parseInt(date[0], 10);
	}
	/**
	 * �õ��������ڵ��·� ����ȡyyyy-MM-dd�е�MM��
	 * 
	 * @param dateStr
	 *            String
	 * @return int
	 */
	public static int getCurrentMonth(String dateStr) {
		String date[] = dateStr.split("-");
		return Integer.parseInt(date[1], 10);
	}
	/**
	 * �õ��������ڵ����� ����ȡyyyy-MM-dd�е�dd��
	 * 
	 * @param dateStr
	 *            String
	 * @return int
	 */
	public static int getCurrentDay(String dateStr) {
		String date[] = dateStr.split("-");
		return Integer.parseInt(date[2], 10);
	}

	/**
	 * �ж�date1�Ƿ��date2�� date1<date2 --true date1>=date2 --false ���ڸ�ʽ:yyyy-MM-dd
	 * 
	 * @param date1
	 * @param date2
	 * @return true/false
	 */
	public static boolean checkDate1BeforeDate2(String date1, String date2) {
		Date d1 = parseTenStrToDate(date1);
		Date d2 = parseTenStrToDate(date2);
		if (d1.before(d2)) {
			return true;
		}
		return false;
	}
	/**
	 * ��ȡ�������ڵ�ǰһ��
	 * 
	 * @param date
	 *            ��ʽyyyy-MM-dd
	 * @return
	 */
	public static String getYesterday(String date) {
		try {
			SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar cal = Calendar.getInstance();
			Date d = sf.parse(date);
			cal.setTime(d);
			cal.set(Calendar.DAY_OF_MONTH, cal.get(Calendar.DAY_OF_MONTH) - 1);
			date = sf.format(cal.getTime());
		} catch (Exception e) {
		}
		return date;
	}
	public static Calendar getCalendar() {
		return calendar;
	}
	
	public static int hnline(String week, int days) {
		int line = 0;
		if (week.equals("������") || week.equals("����") || week.startsWith("Sun")) {
			if (days >= 29) {
				line = 5;
			} else {
				line = 4;
			}
		} else if (week.equals("����һ") || week.equals("��һ")
				|| week.startsWith("Mon")) {
			line = 5;
		} else if (week.equals("���ڶ�") || week.equals("�ܶ�")
				|| week.startsWith("Tue")) {
			line = 5;
		} else if (week.equals("������") || week.equals("����")
				|| week.startsWith("Wed")) {
			line = 5;
		} else if (week.equals("������") || week.equals("����")
				|| week.startsWith("Thu")) {
			line = 5;
		} else if (week.equals("������") || week.equals("����")
				|| week.startsWith("Fri")) {
			if (days >= 31) {
				line = 6;
			} else {
				line = 5;
			}
		} else if (week.equals("������") || week.equals("����")
				|| week.startsWith("Sat")) {
			if (days >= 30) {
				line = 6;
			} else {
				line = 5;
			}
		}
		return line;
	}
	
	/**
	 * 
	 * @���� DHCC-ZLC
	 * @���� 2016-6-27
	 * @����˵����floatת decimal
	 * @���ز��� BigDecimal
	 */
	public static BigDecimal FoDcm(Float value)throws ServiceException {
		BigDecimal decimal = new BigDecimal(Float.toString(value));
       return decimal;
    }
	/**
	 * 
	 * @���� DHCC-ZLC
	 * @���� 2016-6-27
	 * @����˵����Doubleת decimal
	 * @���ز��� BigDecimal
	 */
	public static BigDecimal DoDcm(Double value)throws ServiceException {
		BigDecimal decimal = new BigDecimal(Double.toString(value));
       return decimal;
    }
	/**
	 * @���� DHCC-ZLC
	 * @���� 2016-6-28
	 * @����˵����integer תdecimal
	 * @���ز��� BigDecimal
	 */
	public static BigDecimal IoDcm(Integer value)throws ServiceException {
		BigDecimal decimal = new BigDecimal(Integer.toString(value));
       return decimal;
    }
}
