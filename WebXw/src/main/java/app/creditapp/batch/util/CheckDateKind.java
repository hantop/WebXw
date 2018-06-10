package app.creditapp.batch.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;



/**
 * 
 *
 */
public class CheckDateKind {	
		//�жϴ�������ʱ�����Ͳ������ڱȽ��Ƿ�����Ҫ��
	public static boolean checkKind(String dateType, String dateDesc, String barchDate) {
		Date date = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		boolean flag = false;
		try {
			date = sdf.parse(barchDate);
			System.out.println(date);
			if ("1".equals(dateType)) {// ÿ��
				flag = checkday(date);
			} else if ("2".equals(dateType)) {// ��ĩ
				flag = checkendMonth(date);
			} else if ("3".equals(dateType)) {// ��ĩ
				flag = checkendseason(date);
			} else if ("4".equals(dateType)) {// ��ĩ
				flag =  checkendyear(date);
			} else if ("5".equals(dateType)) {// ����
				flag = checkMonthbasis(dateDesc, date);
			} else if ("7".equals(dateType)) {// ����ĩ
				flag = checkHalfYear(barchDate);
			} else {
				flag = checkFreeTime(dateDesc, date);// ����  ִ��ʱ����ϸ2-11,4-30
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return flag;
	}
		//ÿ��
		public static boolean checkday(Date date){			
			return true;
		}
		public static Calendar date2calendar(Date date){
			Calendar calendar = Calendar.getInstance(); 
	        calendar.setTime(date);
	        return calendar;
		}
		//��ĩ
		public static boolean checkendMonth(Date date){
			Calendar calendar = CheckDateKind.date2calendar(date); 
			calendar.set(Calendar.DATE, (calendar.get(Calendar.DATE) + 1)); 
			if (calendar.get(Calendar.DAY_OF_MONTH) == 1) { 
			    return true; 
			} 
			return false; 
		}
		//��ĩ
		public static boolean checkendseason(Date date){
			Calendar calendar = CheckDateKind.date2calendar(date); 
	        int month=calendar.get(Calendar.MONTH)+1;//�õ��£���Ϊ��0��ʼ�ģ�����Ҫ��1
	        int day=calendar.get(Calendar.DAY_OF_MONTH);//�õ���
	        if(month==3||month==12){
	        	if(day==31){
	        		return true;
	        	}
	        }else if(month==6||month==9){
	        	if(day==30){
	        		return true;
	        	}
	        }
			return false;
		}
		
		//����ĩ
		public static boolean checkHalfYear(String batchDate){
			if(batchDate.endsWith("0630")||batchDate.endsWith("1231")){
				return true;
			}
			return false;
		}
		
		//��ĩ
		public static boolean checkendyear(Date date){
			Calendar calendar = CheckDateKind.date2calendar(date); 
	        int month=calendar.get(Calendar.MONTH)+1;//�õ��£���Ϊ��0��ʼ�ģ�����Ҫ��1
	        int day=calendar.get(Calendar.DAY_OF_MONTH);//�õ���
	        if(month==12&&day==31){
	        	return true;
	        }
			return false;
		}
		//����1-28
		public static boolean checkMonthbasis(String dataDesc, Date date){
			Calendar calendar = CheckDateKind.date2calendar(date); 
	        int day=calendar.get(Calendar.DAY_OF_MONTH);//�õ���
	        if(day>=1&&day<=28 && dataDesc.equals(String.valueOf(day))){
	        	return true;
	        }
			return false;
		}
		//���ɶ��� ִ��ʱ����ϸ2-11,4-30
		public static boolean checkFreeTime(String dataDesc, Date date){
			Calendar calendar = CheckDateKind.date2calendar(date); 
	        int month=calendar.get(Calendar.MONTH)+1;//�õ��£���Ϊ��0��ʼ�ģ�����Ҫ��1
	        int day=calendar.get(Calendar.DAY_OF_MONTH);//�õ���
	        String[] ddArr = dataDesc.split(",");
	        for(String dds : ddArr){
	        	String[] dArr = dds.split("-");
	        	if(dArr[0].equals(String.valueOf(month)) && dArr[1].equals(String.valueOf(day))){
	        		return true;
	        	}
	        }
			return false;
		}
		
		public static void main(String[] args) {
			boolean f = CheckDateKind.checkKind("7","3-28","20150328");
			System.out.println(f);
		}
		
}
