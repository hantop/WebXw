package app.creditapp.batch.util;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StrDealUtil {
    /**
     * @��������: �����滻�ַ����б���
     * @date 20150420
     * @�޸�˵��
     * */
    public static String getWantStr(String str, Map<String, Object> params) {
    
	Pattern pattern = Pattern.compile("\\$[\\w\\d]+\\$");
	Matcher matcher = pattern.matcher(str);
	while (matcher.find()) {
	    String vari = matcher.group();
	    String parm = vari.substring(1, vari.length() - 1);
	    String value = (String) params.get(parm);
	    str = str.replace(vari, value);
	}
	return str;
    }
}
