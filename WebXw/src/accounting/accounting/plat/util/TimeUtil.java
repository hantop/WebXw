package accounting.plat.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

public class TimeUtil {

	private static final String SEPARATELine = "-";

	private static final String SEPARATEAT = "@";

	private static final String SEPARATEPOINT = ".";

	private static final String SEPARATECOLON = ":";

	 
	/**
	 * �ж�date2�Ƿ��date1��,date2��date1֮���Ҳ�����date1����true
	 *    date2<date1  --true
	 *    date2>=date1 --false
	 *    ���ڸ�ʽ:yyyy-MM-dd
	 * @param date1 
	 * @param date2
	 * @return true/false
	 */
	public static boolean checkDate2AfterDate1(String date1,String date2){
		Date d1 = strToDate(date1);
		Date d2 = strToDate(date2);
		if(d1.after(d2)||d1.equals(d2)){
			return false;
		}
		return true;
	}
	
	/**
	 * ��ȡ����
	 * 
	 * @param date
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
	
	/**
	 * ȡ��ϵͳʱ��HH:mm:ss
	 * @return
	 */
	public static String getTime(){
		Date date = new Date();
		SimpleDateFormat simpledateformat = new SimpleDateFormat(
				"HH:mm:ss");
		return simpledateformat.format(date);
	}
	
	/**
	 * �õ����ڲ�ֵ *
	 * 
	 * @param dateStr
	 *            String
	 * @param cz
	 *            int
	 * @return String
	 */
	public static String getDate(String dateStr, int cz) {
		int yy = Integer.parseInt(dateStr.substring(0, 4), 10);
		int mm = Integer.parseInt(dateStr.substring(4, 6), 10);
		int dd = Integer.parseInt(dateStr.substring(6, 8), 10);
		java.sql.Date d = new java.sql.Date(yy - 1900, mm - 1, dd + cz);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		return sdf.format(d);
	}
	
	/**
	 * �õ���ǰ�� ��ʽ��yyyyMMdd *
	 * 
	 * @param dateStr
	 *            String
	 * @return int
	 */
	public static int getCurrentYear(String dateStr) {
		return Integer.parseInt(dateStr.substring(0, 4), 10);
	}

	/**
	 * �õ���ǰ�� ��ʽ��yyyyMMdd *
	 * 
	 * @param dateStr
	 *            String
	 * @return int
	 */
	public static int getCurrentMonth(String dateStr) {
		return Integer.parseInt(dateStr.substring(4, 6), 10);
	}
	
	/**
	 * �õ���ǰ���� ��ʽ��yyyyMMdd *
	 * 
	 * @param dateStr
	 *            String
	 * @return int
	 */
	public static int getCurrentDay(String dateStr) {
		return Integer.parseInt(dateStr.substring(6, 8), 10);
	}
	
	/**
	 * �õ���ǰ���� ��ʽ��yyyyMMdd *
	 * 
	 * @param dateStr
	 *            String
	 * @return String
	 */
	public static String getCurrentYM(String dateStr){
		return dateStr.substring(0, 6);
	}
	
	/**
	 * �õ���ǰ�� ��ʽ��20080901*
	 * 
	 * @param dateStr
	 *            String
	 * @return String
	 */
	public static String getCurMonth(String dateStr) {
		
		return dateStr.substring(4, 6);
	}

	/**
	 * �õ���ǰ�� ��ʽ��20080901*
	 * 
	 * @param dateStr
	 *            String
	 * @return String
	 */
	public static String getCurDay(String dateStr) {
		
		return dateStr.substring(6);
	}
	
	/**
	 * �õ���ǰ�� ��ʽ��20080901*
	 * 
	 * @param dateStr
	 *            String
	 * @return String
	 */
	public static String getCurYear(String dateStr) {
		
		return dateStr.substring(0, 4);
	}
	
	 /** �õ���ǰ���� ��ʽ��20080901 *
	 * 
	 * @param dateStr
	 *            String
	 * @return String
	 */
	public static String getCurYM(String dateStr) {
		
		return dateStr.substring(0, 6);
	}
	
	/**
	 * ��200809�е�09��0ȥ��
	 * @param dateStr
	 * @return
	 */
	public static String removeZero (String dateStr) {
		String rv=dateStr;
		if (rv.indexOf("0")==0){
			rv=rv.substring(1);
		}
		
		return rv;
	}
	
	/**
	 * �õ��µ����� *
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
	 * �õ��µ�������������ǰ�¹���������
	 * 
	 * @param currDate
	 *            String
	 * @param year
	 *            int
	 * @param month
	 *            int
	 * @return int
	 */
	public static int getMonthDays(String currDate, int year, int month) {
		int days = 1;
		int curYear = getCurrentYear(currDate);
		int curMonth = getCurrentMonth(currDate);
		int curDay = getCurrentDay(currDate);
		if (curYear == year
				&& curMonth == month) {
			days = curDay;
		} else {
			days = getMonthDays(year, month);
		}
		return days;
	}
	
	/**
	 * �����������ڵĲ�ֵ
	 * @param args
	 * Date1 - Date2
	 * if Date1>Date2 return ***
	 * else return -***
	 */
	
	public static int getIntBetDays(String Date1,String Date2){
		TimeUtil TU = new TimeUtil();
		int rt;
		if(TU.checkDate1BeforeDate2(Date1, Date2)){
			rt = TU.getBetweenDays(Date1, Date2);
			rt = rt *-1;
		}else{
			rt = TU.getBetweenDays(Date2, Date1);

		}
		return rt;
		
	}
	
	/**
	 * �õ����ȵ����ڵ����� ��ʽ��2008-9-25 *
	 * 
	 * @param dateStr
	 *            String
	 * @return int
	 */
	public static int getJiDuDays(String dateStr) {
		int days = 0;
		int day = getCurrentDay(dateStr);
		int yy = getCurrentYear(dateStr);
		int month = getCurrentMonth(dateStr);
		
		boolean isrn = (((yy % 4 == 0) && (yy % 100 != 0)) || (yy % 400 == 0)) ? true
				: false;
		switch (month) {
		case 1:
			days = day;
			break;
		case 2:
			days = 31 + day;
			break;
		case 3:
			if (isrn)
				days = 31 + 29 + day;
			else
				days = 31 + 28 + day;
			break;
		case 4:
			days = day;
			break;
		case 5:
			days = 30 + day;
			break;
		case 6:
			days = 61 + day;
			break;
		case 7:
			days = day;
			break;
		case 8:
			days = 31 + day;
			break;
		case 9:
			days = 62 + day;
			break;
		case 10:
			days = day;
			break;
		case 11:
			days = 31 + day;
			break;
		case 12:
			days = 61 + day;
			break;
		}
		return days;
	}

	/**
	 * �����������ڼ�������� *
	 * 
	 * @param beginDate
	 *            String
	 * @param endDate
	 *            String
	 * @return int
	 */
	public static int getBetweenDays(String beginDate, String endDate) {
		boolean exchangeFlag = false;
		if(TimeUtil.compareDate(beginDate, endDate)==1){
			String temp = beginDate ;
			beginDate = endDate ;
			endDate = temp ;
			exchangeFlag = true;
		}
		int sum = 0;
		int beginYear = getCurrentYear(beginDate);
		int beginMonth = getCurrentMonth(beginDate);
		int beginDay = getCurrentDay(beginDate);
		int endYear = getCurrentYear(endDate);
		int endMonth = getCurrentMonth(endDate);
		int endDay = getCurrentDay(endDate);
		String startDateStr = String.valueOf(beginYear) + bZero(beginMonth) + "01";

		int sumMonth = (endYear - beginYear + 1) * 12 - (beginMonth)
				- (12 - endMonth);
		for (int i = 0; i < sumMonth; i++) {
			String dateStr = getDateStr(startDateStr, i);
			sum = sum + getMonthDays(getCurrentYear(dateStr),getCurrentMonth(dateStr));
		}

		sum = sum - beginDay + endDay;
		if(exchangeFlag){
			sum = -sum;
		}
		return sum;
	}

	/**
	 * �������ھ��������º������ *20100302
	 * 
	 * @param dateStr
	 *            String YYYY-MM-DD
	 * @param hkm
	 *            int
	 * @return String
	 */
	public  static String getDateStr(String dateStr, int hkm) {
		String reDateStr = "";
		int yy = Integer.parseInt(dateStr.substring(0, 4), 10);
		int mm = Integer.parseInt(dateStr.substring(4, 6), 10);
		int dd = Integer.parseInt(dateStr.substring(6), 10);

		// int yy1=0,mm1=0,dd1=dd;
		int yy2 = 0, mm2 = 0, dd2 = dd;
		if ((mm + hkm) % 12 == 0) {
			yy2 = yy + (mm + hkm) / 12 - 1;
			mm2 = 12;
		} else {
			if ((mm + hkm) % 12 == 1) {
				yy2 = yy + (mm + hkm) / 12;
				mm2 = 1;
			} else {
				yy2 = yy + (mm + hkm) / 12;
				mm2 = (mm + hkm) % 12;
			}
		}
		reDateStr = String.valueOf(yy2) + bZero(mm2) + bZero(dd2);
		return reDateStr;
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
	 * �Ƚ����ڴ�С *
	 * 
	 * @param date1
	 *            String
	 * @param date2
	 *            String
	 * @return int  date1>date2  return 1
	 * 				date1==date2  return 0
	 * 				date1<date2  return -1
	 */
	public static int compareDate(String date1, String date2) {
		DateFormat df = new SimpleDateFormat("yyyyMMdd");
		Date date11 = null;
		Date date22 = null;
		try {
			date11 = df.parse(date1);
			date22 = df.parse(date2);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date11.compareTo(date22);
	}

	/**
	 * ���ַ��� ��ʽת���������� *
	 * 
	 * @param dateStr
	 *            String
	 * @return Date
	 */
	public static Date strToDate(String dateStr) {
		
		DateFormat df = new SimpleDateFormat("yyyyMMdd");
		Date d = null;
		try {
			d = df.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return d;
	}

	/**
	 * ��������ת�����ַ����� yyyyMMdd
	 * 
	 * @param date
	 *            Date
	 * @return String
	 */
	public static String dateToStr(java.util.Date date) {
		String str = "";
		try {
			java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyyMMdd");
			str = sdf.format(date);
		} catch (Exception ex) {
			str = "";
		}
		return str;
	}

	/**
	 * �����Ŵ��涨ʱ���ʽ�����ַ��� YYYY-MM-DD
	 * @param
	 * @return 
	 * @throws
	 */
	public static String getCurDate() {
		Date date=new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd"); 
		String strDate=sdf.format(date);
	
		
		return strDate;

	}
	
//	public static void main(String[] args) {
//		System.out.println(TimeUtil.getCurDate());
//	}
	
	/**
	 * @param
	 * @return �����Ŵ��涨ʱ���ʽ�����ַ��� YYYY-MM-DD@hh:mm:ss.mmm
	 * @throws
	 */
	public static String getCurTimeStamp() {
		Date date=new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmmssZ"); 
		String strStamp=sdf.format(date);
		return strStamp;
	}
	
	private static String getCurTimeStamp2() {
		
		Calendar rightNow = Calendar.getInstance();
		/**
		 * ������
		 */
		int DD = rightNow.get(Calendar.DAY_OF_MONTH);
		/**
		 * ������
		 */
		int YYYY = rightNow.get(Calendar.YEAR);
		/**
		 * ����Сʱ
		 */
		int hh = rightNow.get(Calendar.HOUR_OF_DAY);
		/**
		 * ���ڷ���
		 */
		int mm = rightNow.get(Calendar.MINUTE);
		/**
		 * ��ǰ��
		 */
		int ss = rightNow.get(Calendar.SECOND);
		/**
		 * ��ǰ����
		 */
		int ms = rightNow.get(Calendar.MILLISECOND);

		String strTimeStamp = null;
		String strYYYY = null;
		String strMM = null;
		String strDD = null;
		String strhh = null;
		String strmm = null;
		String strss = null;
		String strms = null;
		
		if (YYYY < 10) {
			strYYYY = "000" + String.valueOf(YYYY);
		} else if (YYYY < 100 && YYYY >= 10) {
			strYYYY = "00" + String.valueOf(YYYY);
		} else if (YYYY < 1000 && YYYY >= 100) {
			strYYYY ="0"+ String.valueOf(YYYY);
		}else if (YYYY < 10000 && YYYY >= 1000) {
			strYYYY = String.valueOf(YYYY);
		}

		if (String.valueOf(DD).length() == 1) {
			strDD = "0" + String.valueOf(DD);
		} else {
			strDD = String.valueOf(DD);
		}

		if (String.valueOf(hh).length() == 1) {
			strhh = "0" + String.valueOf(hh);
		} else {
			strhh = String.valueOf(hh);
		}

		if (String.valueOf(mm).length() == 1) {
			strmm = "0" + String.valueOf(mm);
		} else {
			strmm = String.valueOf(mm);
		}

		if (String.valueOf(ss).length() == 1) {
			strss = "0" + String.valueOf(ss);
		} else {
			strss = String.valueOf(ss);
		}

		if (ms < 10) {
			strms = "00" + String.valueOf(ms);
		} else if (ms < 100 && ms >= 10) {
			strms = "0" + String.valueOf(ms);
		} else if (ms < 1000 && ms >= 100) {
			strms = String.valueOf(ms);

		}
		
		strTimeStamp = strYYYY + TimeUtil.SEPARATELine + strMM + TimeUtil.SEPARATELine + TimeUtil.SEPARATELine + strDD;
		strTimeStamp = strTimeStamp + TimeUtil.SEPARATEAT;
		strTimeStamp = strTimeStamp+ strhh + TimeUtil.SEPARATECOLON + strmm + TimeUtil.SEPARATECOLON + strss;
		strTimeStamp = strTimeStamp + TimeUtil.SEPARATEPOINT + strms;
		return strTimeStamp;

	}
	
	/**
	 * @param
	 * @return ����ָ�����ڶ�Ӧ�ļ���ĩ�µ����� YYYY-MM-DD
	 * @throws
	 */
	public static String getLastDateOfQuarter(String date) {
		String year = date.substring(0, 4) ;
		String month = date.substring(4, 6) ;
		String day = date.substring(6) ;
		String quarter ="" ;

		switch(Integer.parseInt(month)){
		  case 1:
		  case 2:
		  case 3:
			  quarter = "03";
			  break;
		  case 4:
		  case 5:
		  case 6:
			  quarter = "06";
			  break;			  
		  case 7:
		  case 8:
		  case 9:		  
			  quarter = "09";
			  break;
		  case 10:
		  case 11:
		  case 12:
			  quarter = "12";
			  break;
		}
		return year+quarter+day ;
	}

	/**
	 * <p>�õ�ָ�����ڵĵ�����ĩ�µ�����</p>
	 * @param date YYYY-MM-DD
	 * @return
	 */
	public static String getLastDateOfYear(String date){

		String year = Integer.parseInt(date.substring(0, 4))+"" ;
		String day = date.substring(6) ;
		
		return year+"12"+day; 
	}

	/**
	 * �ж�date1�Ƿ��date2��
	 *    date1<date2  --true
	 *    date1>=date2 --false
	 *    ���ڸ�ʽ:yyyy-MM-dd
	 * @param date1 
	 * @param date2
	 * @return true/false
	 */
	public static boolean checkDate1BeforeDate2(String date1,String date2){
		Date d1 = strToDate(date1);
		Date d2 = strToDate(date2);
		if(d1.before(d2)){
			return true;
		}
		return false;
	}
	public static void main(String[] args) {
		boolean flag = checkDate1BeforeDate2("20181016","20180920");
		System.out.println(flag);
		
	}
	/**
	 * ��ü���
	 * @param str
	 * @return
	 */
	public static String getQuarter(String str){
		String rv="";
		switch (Integer.parseInt(str)){
		case 1:
		case 2:
		case 3:
			rv="1";
		break;
		case 4:
		case 5:
		case 6:
			rv="2";
		break;	
		case 7:
		case 8:
		case 9:
			rv="3";
		break;	
		case 10:
		case 11:
		case 12:
			rv="4";
		break;	
		}
		return rv;
	}
	
	/**
	 * ��ð���
	 * @param str
	 * @return
	 */
	public static String getHelfYear(String str){
		String rv="";
		switch (Integer.parseInt(str)){
		case 1:
		case 2:
		case 3:
		case 4:
		case 5:
		case 6:
			rv="1";
		break;	
		case 7:
		case 8:
		case 9:
		case 10:
		case 11:
		case 12:
			rv="2";
		break;	
		}
		return rv;
	}
	
	private static String ADD_DATE(int optype,String date,int num){
		String st_return = "";  
		 try {
			DateFormat daf_date = DateFormat.getDateInstance(DateFormat.MEDIUM,Locale.CHINA);
			daf_date.parse(date);
			Calendar  calendar= daf_date.getCalendar();
			calendar.add(optype, num); 
				String st_m = "";
				String st_d = "";
			    int y = calendar.get(Calendar.YEAR);
			    int m = calendar.get(Calendar.MONTH) + 1;
			    int d = calendar.get(Calendar.DAY_OF_MONTH); 
			    if (m <= 9) {
			      st_m = "0" + m;
			    }
			    else {
			      st_m = "" + m;
			    }
			    if (d <= 9) {
			      st_d = "0" + d;
			    }
			    else {
			      st_d = "" + d;
			    }
			    st_return = y + st_m + st_d;
		} catch (ParseException e) { 
			e.printStackTrace();
		}
		return st_return;
	}
	
	/**
	 * ��������
	 * @param date
	 * @param n
	 * @return
	 */
	 public static String ADD_DAY(String date,int n){
		 if(date.length()==8){
			 date = getStr(date);
		 }
		 return TimeUtil.ADD_DATE(Calendar.DATE, date, n);
	 }
	 /**
	  * ��������
	  * @param date
	  * @param n
	  * @return
	  */
	 public static String ADD_MONTH(String date,int n){
		 if(date.length()==8){
			 date = getStr(date);
		 }
		 return TimeUtil.ADD_DATE(Calendar.MONTH, date, n);
	 }
	 /**
	  * ��������
	  * @param date
	  * @param n
	  * @return
	  */
	public static String ADD_YEAR(String date,int n){ 
		 if(date.length()==8){
			 date = getStr(date);
		 }
		return TimeUtil.ADD_DATE(Calendar.YEAR, date, n);
	}
   

	
	/**
	 * ȡ����ʱ��
	 * @param yyMMdd
	 * @return
	 */
	public static String getPeryyMMdd(String yyMMdd,String termType){
		String rv=yyMMdd;
		
		Calendar  calendar=Calendar.getInstance();
		
		String m = TimeUtil.getCurMonth(yyMMdd);
		String y = TimeUtil.getCurYear(yyMMdd);
		String d = TimeUtil.getCurDay(yyMMdd);
		
		int year=Integer.parseInt(y);
		int month=Integer.parseInt(TimeUtil.removeZero(m));
		int date=Integer.parseInt(TimeUtil.removeZero(d));
			
		calendar.set(year, month, date);
		
		switch (Integer.parseInt(termType)) {
		case 1:// ��
			calendar.add(Calendar.MONTH, -2);
			break;
		case 2:// ��
			calendar.add(Calendar.MONTH, -4);
			break;
		case 3:// ����
			calendar.add(Calendar.MONTH, -7);			
			break;
		case 4:// ��
			calendar.add(Calendar.MONTH, -13);
			break;
		default:
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd"); 
		rv=sdf.format(calendar.getTime());
		return rv;
	}
	
	
	/**
	 * ȡ��N-1��+����ʱ������
	 * @param yyMMdd
	 * @return
	 */
	public static String[] getPerNyyMMdd(String yyMMdd,String termType,int term){
		String[] rv=new String[term];
		
		Calendar  calendar=Calendar.getInstance();
		
		String m = TimeUtil.getCurMonth(yyMMdd);
		String y = TimeUtil.getCurYear(yyMMdd);
		String d = TimeUtil.getCurDay(yyMMdd);
		
		int year=Integer.parseInt(y);
		int month=Integer.parseInt(TimeUtil.removeZero(m));
		int date=Integer.parseInt(TimeUtil.removeZero(d));
			
		
		rv[0]=yyMMdd;
		for(int i=0;i<term-1;i++){
			calendar.set(year, month, date);
			switch (Integer.parseInt(termType)) {
			case 1:// ��
				calendar.add(Calendar.MONTH, -(2+i));
				break;
			case 2:// ��
				calendar.add(Calendar.MONTH, -(4+(i*3)));
				break;
			case 3:// ����
				calendar.add(Calendar.MONTH, -(7+(i*6)));			
				break;
			case 4:// ��
				calendar.add(Calendar.MONTH, -(13+(i*12)));
				break;
			default:
			}
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd"); 
			rv[i+1]=sdf.format(calendar.getTime());
		}
	
		return rv;
	}
	

	/**
	 * ȡ����ʱ�������
	 * @param yyMMdd
	 * @return
	 */
	public static int countMonth(String yyMMdd1,String yyMMdd2){
		String startDate =yyMMdd1.replace("-", "");
		String endDate =yyMMdd2.replace("-", "");
		
		int rv=0	;
		
		if (Long.parseLong(startDate)>Long.parseLong(endDate)){
			String tmp=endDate;
			endDate=startDate;
			startDate=tmp;
		}
		
		int yy1=Integer.parseInt(startDate.substring(0,4));
		int mm1=Integer.parseInt(startDate.substring(4,6));
		int dd1=Integer.parseInt(startDate.substring(6));
		
		int yy2=Integer.parseInt(endDate.substring(0,4));
		int mm2=Integer.parseInt(endDate.substring(4,6));
		int dd2=Integer.parseInt(endDate.substring(6));
		
		rv=(yy2-yy1)*12+(mm2-mm1);
		
	/*	if(dd1>dd2){
			rv=rv-1;
		}*/
		return rv;
	}
	
	
	/**
	 * ���Nλ�������
	 * @param n
	 * @return
	 */
	public static String getRandomNum(int length){
		String rt="";
		for(int i=0;i<length;i++){
			Random r=new Random();
			rt=rt+String.valueOf(r.nextInt(9));
		}
		
		return rt;
	}
	
	/**
	 * ����Nλ�ַ�����ֻ����ĸ�����֣�
	 * @param length
	 * @return
	 */
	public static String getCharacterAndNumber(int length)   
	{   
	    String rt = "";   
	           
	    Random random = new Random();   
	    for(int i = 0; i < length; i++)   
	    {   
	        String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num"; // �����ĸ��������   
	               
	        if("char".equalsIgnoreCase(charOrNum)) // �ַ���   
	        {   
	            int choice = random.nextInt(2) % 2 == 0 ? 65 : 97; //ȡ�ô�д��ĸ����Сд��ĸ   
	            rt += (char) (choice + random.nextInt(26));   
	        }   
	        else if("num".equalsIgnoreCase(charOrNum)) // ����   
	        {   
	            rt += String.valueOf(random.nextInt(10));   
	        }   
	    }   
	           
	    return rt;   
	}  

	/**
	 * ����32λ���� Ϊʱ��������루17λ��+��Сд�����ֵ��������15λ��62��15����=768909704948766668552634368��֮һ���ظ����ʣ�
	 * @return
	 */
	public static String getPK(){
		String rt="";
		rt=rt+TimeUtil.getCurTimeStamp4PK();
		rt=rt+TimeUtil.getCharacterAndNumber(15);
		return rt;
	}
	
	public static String getCurTimeStamp4PK() {
		Date date=new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddkkmmssSSS"); 
		String strStamp=sdf.format(date);
	
		
		return strStamp;
	}
	
	/**
	 * ȡ��������֮�������
	 * ����һ�°�һ������
	 * ��5������5��  =   6����
	 * @param yyyy-mm-dd
	 * @return
	 */
	public static int countMonthByDate(String startDate,String endDate){
		//��������֮�������
		int dayNum = getBetweenDays(startDate,endDate);
		int monthNum = dayNum/30;
		if(dayNum%30!=0){
			monthNum+=1;
		}
		return monthNum;
	}
	
	/*
	 * �ж��Ƿ�Ϊ��ĩ(�������һ��)
	 * wuwh
	 * param: curDate : YYYY-MM-DD
	 * return:
	 *    0:��
	 *    1:��
	 */
	public int isLastMonthDay(String curDate){
		String tDate=this.getMonthLLastDay(curDate);
		if(tDate.equals(curDate)){
			return 0;
		}else{
			return 1;
		}
	}
	/**
	 * �õ�������ĩ���һ������ *
	 * wuwh
	 * @param inDate YYYYMMDD
	 * @return int
	 */
	public String getMonthLLastDay(String inDate) {
		int days = 1;
		int year=Integer.parseInt(inDate.substring(0,4));
		
		int month=Integer.parseInt(inDate.substring(4,6));
		
		
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
		return  inDate.substring(0,4)+"-"+inDate.substring(5,7)+"-"+days;
	}
	
	/**
	 * �ж�date1��date2�Ƿ��������ͬ,�����ͬ�ͷ���date2�����򷵻�date1
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static Date isEqualsYM(Date date1, Date date2) {
		Calendar date1Temp = Calendar.getInstance();
		Calendar date2Temp = Calendar.getInstance();
		date1Temp.setTime(date1);
		date2Temp.setTime(date2);
		if((date1Temp.get(Calendar.YEAR) == date2Temp.get(Calendar.YEAR)) 
				&& date1Temp.get(Calendar.MONTH) == date2Temp.get(Calendar.MONTH)){
			date1 = date2;
		}
		return date1;
	}

	/**
	 * ��YYYY-MM-DDת����YYYYMMDD
	 * 
	 * @param date
	 * @return
	 */
	public static String getYYYYMMDD(String date) {
		if(date==null){
			return "";
		}else{
		    return date.replace("-", "");
		}
	}
	
	/**
	 * ��YYYYMMDDת����YYYY-MM-DD
	 * @param date
	 * @return
	 */
	public static String getStr(String date) {
		
		String str = "";
		
		int year = Integer.valueOf(date.substring(0,4))-1900;
		int month = Integer.valueOf(date.substring(4,6))-1;
		int day = Integer.valueOf(date.substring(6,8));
		Date d = new Date(year,month,day);
		try {
			java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
			str = sdf.format(d);
		} catch (Exception ex) {
			str = "";
		}
		return str;
		
		
	}
}
