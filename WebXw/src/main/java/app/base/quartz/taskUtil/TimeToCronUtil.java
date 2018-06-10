package app.base.quartz.taskUtil;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import org.apache.commons.lang.StringUtils;

import app.base.quartz.entity.ConExpTransType;

public class TimeToCronUtil {
	/*** 
     *  
     * @param date 
     * @param dateFormat : e.g:yyyy-MM-dd HH:mm:ss 
     * @return 
     */  
    private static String formatDateByPattern(Date date,String dateFormat){  
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);  
        String formatTimeStr = null;  
        if (date != null) {  
            formatTimeStr = sdf.format(date);  
        }  
        return formatTimeStr;  
    }  
    /**
     * convert Date to cron ,eg.  "0 06 10 15 1 ? 2014" 
     * @param date  : ʱ��� 
     * ��������
     * @return 
     */  
    public static String dayToCron(java.util.Date  date){  
        String dateFormat="ss mm HH dd MM ? yyyy";  
        return formatDateByPattern(date, dateFormat);  
    } 
    
    /**
     * ��ʱ��ڵ�ת��Ϊlong���͵�ʱ������
     * @param intervalArgsΪ������������˳��ֱ�ָ��
     * 0-��
     * 1-ʱ
     * 2-��
     * 3-��
     * 4-��
     * 5-��
     * 6-��
     *\n
     *ʱ��Ϊ�ۼӵĹ�ϵ��
     *������intervalToCron(2,3,12,4,56),�ܼ��ʱ��Ϊ2��+3��Сʱ+12����+56��+0��+0��+0��
     * @return
     */
    public static long intervalToCron(int ... intervalArgs){
    	long intervalTime = 0;
    	for(int index =0;index < intervalArgs.length;index++){
    		switch (index) {
			case 0:
				intervalTime += intervalArgs[index] *1L * 24 * 60 * 60 * 1000;
				break;
			case 1:
				intervalTime += intervalArgs[index] *1L * 60 * 60 * 1000;
				break;
			case 2:
				intervalTime += intervalArgs[index] *1L * 60 * 1000;
				break;
			case 3:
				intervalTime += intervalArgs[index] *1L * 1000;
				break;
			case 4:
				intervalTime += intervalArgs[index] *1L * 24 * 60 * 60 * 1000 * 7;
				break;
			case 5:
				intervalTime += intervalArgs[index] *1L * 24 * 60 * 60 * 1000 * 30;
				break;
			case 6:
				intervalTime += intervalArgs[index] *1L * 24 * 60 * 60 * 1000 * 365;
				break;
			default:
				break;
			}
    	}
    	return intervalTime;
    }
    
    /**
     * 
     * @����˵����
     * 1.�������������ʽӦΪ{�գ�ʱ���֣��룬�ܣ��£���}
     * 2.���������������1-7��1=�����գ����ߣ���SUN, MON, TUE, WED, THU, FRI,SAT"������
     * 3.û��ֵ�Ĳ��֣�����null��*
     * 4.transType Ϊת����ʽ��1-���죬2-���£�3-���ܣ�4-����
     * 5.������cronExpress���ʽΪ{�룬�֣�ʱ���գ��£��ܣ�[��]}
     * @���ز��� String
     */
    public static String transConExpression(String[][] dateArrays,ConExpTransType tranType){
    	StringBuilder conExpress = new StringBuilder();
    	switch (tranType) {
    	case BY_TIMES:
    		if(dateArrays[3]==null){
    			conExpress.append("0");//��
    		}else{
    			conExpress.append(wreaveNewTimeCon(transArrayToStar(dateArrays[3])));//��
    		}
    		conExpress.append(" ").append(wreaveNewTimeCon(transArrayToStar(dateArrays[2])))//��
			.append(" ").append(wreaveNewTimeCon(transArrayToStar(dateArrays[1])))//ʱ
			.append(" ").append(wreaveNewTimeCon(transArrayToStar(dateArrays[0])))//��
			.append(" ").append(wreaveNewTimeCon(transArrayToStar(dateArrays[5])));//��
			if(dateArrays[4]==null){
				conExpress.append(" ?");
			}else{
				conExpress.append(" ").append(wreaveNewTimeCon(transArrayToStar(dateArrays[4])));//��
			}
    		return conExpress.toString();
		case BY_HOUR:
			if(dateArrays[3]==null){
    			conExpress.append("0");//��
    		}else{
    			conExpress.append(wreaveNewTimeCon(transArrayToStar(dateArrays[3])));//��
    		}
			conExpress.append(" ").append(wreaveNewTimeCon(transArrayToStar(dateArrays[2])).replace("*/", "")).append(" ");//��
				if(dateArrays[1].length == 1){
					conExpress.append("*/").append(dateArrays[1][0]).append(" * * ?");//ÿ��NСʱִ��һ��
				}else{
					conExpress.append(" * * * ?");
				}
			return conExpress.toString();
		case BY_DAY:
			conExpress.append(transArrayToZero(dateArrays[3]))//��
			.append(" ").append(transArrayToZero(dateArrays[2]))//��
			.append(" ").append(transArrayToZero(dateArrays[1])).append(" ");//ʱ
			if(dateArrays[0].length == 1){
				conExpress.append("*/").append(dateArrays[0][0]).append(" * ?");//ÿ��N��ִ��һ��
			}else{
				conExpress.append(" * * ?");
			}
			return conExpress.toString();
		case BY_MONTH:
			conExpress.append(transArrayToZero(dateArrays[3]))//��
			.append(" ").append(transArrayToZero(dateArrays[2]))//��
			.append(" ").append(transArrayToZero(dateArrays[1]))//ʱ
			.append(" ").append(transArrayToZero(dateArrays[0]))//��
			.append(" * ?");
			return conExpress.toString();
		case BY_WEEK:
			conExpress.append(transArrayToZero(dateArrays[3]))//��
			.append(" ").append(transArrayToZero(dateArrays[2]))//��
			.append(" ").append(transArrayToZero(dateArrays[1]))//ʱ
			.append(" ").append(transArrayToStr(dateArrays[0], "?"))//��
			.append(" * ").append(transArrayToZero(dateArrays[4]));
			return conExpress.toString();
		case BY_YEAR:
			conExpress.append(transArrayToZero(dateArrays[3]))//��
			.append(" ").append(transArrayToZero(dateArrays[2]))//��
			.append(" ").append(transArrayToZero(dateArrays[1]))//ʱ
			.append(" ").append(transArrayToZero(dateArrays[0]))//��
			.append(" ").append(transArrayToZero(dateArrays[5]))//��
			.append(" ").append(transArrayToZero(dateArrays[4]))//��
			.append(" *");
			return conExpress.toString();
					
		default:
			return null;
		}
    }
    
    public static String transConExpression(String[] dateArrays,ConExpTransType tranType){
    	String[][] result = new String[dateArrays.length][1];
    	
    	for(int i=0;i<dateArrays.length;i++){
    		result[i][0] = dateArrays[i];
    	}
    	return transConExpression(result,tranType);
    }
    
    public static String transConExpression(String dateTime,String[][] dateArrays,ConExpTransType tranType){
    	String[][] datetimeArray = new String[2][1];
    	String[] timeArgs = dateTime.split(":");
    	datetimeArray[0][0] = String.valueOf(Integer.valueOf(timeArgs[0]));
    	datetimeArray[1][0] = String.valueOf(Integer.valueOf(timeArgs[1]));
    	String[][] result = Arrays.copyOf(datetimeArray, 2+dateArrays.length);
    	System.arraycopy(dateArrays, 0, result, 2, dateArrays.length);
    	return transConExpression(result,tranType);
    }
    
    private static String transArrayToStar(String[] arrays){
    	return transArrayToStr(arrays,"*");
    }
    
    private static String transArrayToZero(String[] arrays){
    	return transArrayToStr(arrays, "0");
    }
    
    private static String transArrayToStr(String[] arrays,String defaultValue){
    	if(arrays !=null && (arrays.length>1 || (arrays.length == 1 && arrays[0]!=null && !arrays[0].isEmpty() && StringUtils.isNumeric(arrays[0])))){
    		return Arrays.toString(arrays).replaceAll("\\[", "").replaceAll("\\]", "").replaceAll(" ", "");
    	}else{
    		return defaultValue;
    	}
    }
    
    private static String wreaveNewTimeCon(String value){
    	if(value==null || value.equals("*") || value.isEmpty() || "null".equals(value)){
    		return "*";
    	}else{
    		return "*/"+value;
    	}
    }
    
    
    public static void main(String[] args) {
//		System.out.println(TimeToCronUtil.intervalToCron(2,3,12,4,56,3));
    	String[] arrays = {"2","3","0","0",null,null,null};//ÿ����3��5��12��
    	System.out.println(transConExpression(arrays,ConExpTransType.BY_MONTH));
//    	String[] arrays = {"3","5","12"};//ÿ����3��5��12��
//    	String rs = TimeToCronUtil.transArrayToStr(arrays);
//    	System.out.println(rs);
	}
}
