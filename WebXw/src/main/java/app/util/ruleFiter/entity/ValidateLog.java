package app.util.ruleFiter.entity;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import accounting.plat.dao.JdbcDao;
import app.creditapp.ln.entity.LnApplyMidParm;
import app.util.DBUtils;
import app.util.ruleFiter.type.ResultType;
import app.util.ruleFiter.type.ValidateParmType;

public class ValidateLog {
	private ResultType resultType;
	private String resultLog;
	private List<ValidateLog> resultlogList;
	
	private List<ValidateLog> warnningList;
	private List<ValidateLog> errorList;
	private String errorMessage;
	
	public ValidateLog() {
		super();
	}
	
	public ValidateLog(ResultType resultType, String resultLog) {
		super();
		this.resultType = resultType;
		this.resultLog = resultLog;
	}

	public ResultType getResultType() {
		return resultType;
	}
	public void setResultType(ResultType resultType) {
		this.resultType = resultType;
	}
	public String getResultLog() {
		return resultLog;
	}
	public void setResultLog(String resultLog) {
		this.resultLog = resultLog;
	}
	public List<ValidateLog> getResultlogList() {
		return resultlogList;
	}
	public void setResultlogList(List<ValidateLog> resultlogList) {
		this.resultlogList = resultlogList;
	}
	
	public List<ValidateLog> getWarnningList() {
		return warnningList;
	}

	public List<ValidateLog> getErrorList() {
		return errorList;
	}

	/**
	 * ��ʾ��־�д��ڵ�У����־��Ϣ��
	 * @param isShow ���Ϊ�棬����ڿ���̨��У�����;�����Ϣ�ֱ���ʾ�����Ϊ�٣��򲻻���ʾ����;�����Ϣ�б�
	 */
	public void showValidateResult(boolean isShow){
		warnningList= new ArrayList<ValidateLog>();
		errorList = new ArrayList<ValidateLog>();
		for(ValidateLog vl:resultlogList){
			switch (vl.resultType) {
			case SUCCESS:
				break;
			case WARNING:
				if(isShow)System.out.println("WARNING: "+vl.getResultLog());
				warnningList.add(vl);
				break;
			case ERROR:
				if(isShow)System.out.println("ERROR: "+vl.getResultLog());
				errorList.add(vl);
				errorMessage= errorMessage == null?"":errorMessage;
				errorMessage += " "+ vl.getResultLog();
				break;
			}
		}
//		if(errorList.size() == 0){
//			System.out.println("����У��ɹ�");
//		}
	}
	
	/**
	 * У�����ϸ���̣���У�����淽������Բ��ع��Ļ���ô˷�����У�齫������趨��У�����ValidateParm������жϣ������ش���򾯸���Ϣ
	 * @param paramName ҪУ����ֶ���
	 * @param value У���ʵ��ֵ
	 * @param vParm У��������ϸ����
	 * @return У������־�б�
	 * @throws  
	 * @throws AccountingException 
	 */
	public static List<ValidateLog> validateService(String paramName,String value,ValidateParm vParm){
		LnApplyMidParm lnApplyMidParm = null;
		Connection conn = DBUtils.getConn();
		try {
			lnApplyMidParm = (LnApplyMidParm)JdbcDao.query(new LnApplyMidParm(), "field_name='"+paramName+"'", "ln_apply_mid_parm", conn);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtils.closeConnection(conn);
		}
		if (lnApplyMidParm != null)paramName = lnApplyMidParm.getNoteName();
		List<ValidateLog> logList = new ArrayList<ValidateLog>();
		if(!vParm.isCanNull()){
			if(value==null || value.isEmpty()){
				logList.add(new ValidateLog(getResultLevel(vParm,ValidateParmType.isNull),paramName + "�ֶβ���Ϊ��"));
			}
		}
		
		if(vParm.isCanNull() && (value == null || "".equals(value)))return logList;
		
		if(vParm.getMaxLength()!=null){
			if(value.length()>vParm.getMaxLength()){
				logList.add(new ValidateLog(getResultLevel(vParm,ValidateParmType.maxLength),paramName + "�ֶ�ֵ���Ȳ�Ӧ����"+vParm.getMaxLength()));
			}
		}
		
		if(vParm.getMinLength()!=null){
			if(value.length()<vParm.getMinLength()){
				logList.add(new ValidateLog(getResultLevel(vParm,ValidateParmType.minLength),paramName + "�ֶ�ֵ���Ȳ�ӦС��"+vParm.getMinLength()));
			}
		}
		
		if(vParm.getMaxValue()!=null){
			if(isNumber(value) && Double.valueOf(value)>vParm.getMaxValue()){
				logList.add(new ValidateLog(getResultLevel(vParm,ValidateParmType.maxValue),paramName + "�ֶ�ֵ��Ӧ����"+vParm.getMaxValue()));
			}
		}
		
		if(vParm.getMinValue()!=null){
			if(isNumber(value) && Double.valueOf(value) < vParm.getMinValue()){
				logList.add(new ValidateLog(getResultLevel(vParm,ValidateParmType.minValue),paramName + "�ֶ�ֵ��ӦС��"+vParm.getMinValue()));
			}
		}
		if(vParm.getComplexNumber()!=null){
			boolean isValidate = true;
			isValidate = isNumber(value);
			if(isValidate){
				String[] formartPart = vParm.getComplexNumber().split(",");
				if(value.indexOf(".") == -1){
					if(value.length() > Integer.valueOf(formartPart[0]) )isValidate = false;
				}else{
					String[] valuePart = value.split("\\.");
					//�������ĳ��Ȳ��ó�����һ������ || С�����ֳ����ڶ�������
					if(valuePart.length != 2)isValidate = false;
					else if((valuePart[0].length() + valuePart[1].length()) > Integer.valueOf(formartPart[0]) || valuePart[1].length() > Integer.valueOf(formartPart[1]))isValidate = false;
//					if(valuePart.length == 2 &&  valuePart[0].length()> Integer.valueOf(formartPart[0]) || valuePart[1].length() > Integer.valueOf(formartPart[1]) )
				}
			}
			if(!isValidate)logList.add(new ValidateLog(getResultLevel(vParm,ValidateParmType.minValue),paramName + "�ֶ�ֵ���Ȳ����Ϲ涨��ʽ��"+vParm.getComplexNumber()));
		}
		
		if(vParm.getStartStr()!=null){
			if(!value.startsWith(vParm.getStartStr())){
				logList.add(new ValidateLog(getResultLevel(vParm,ValidateParmType.startStr),paramName + "�ֶ�Ӧ��"+vParm.getStartStr()+"��Ϊ��ʼ�ַ�"));
			}
		}
		
		if(vParm.getEndStr()!=null){
			if(!value.endsWith(vParm.getEndStr())){
				logList.add(new ValidateLog(getResultLevel(vParm,ValidateParmType.endStr),paramName + "�ֶ�Ӧ��"+vParm.getEndStr()+"��Ϊ�����ַ�"));
			}
		}
		
		if(vParm.getContainStr()!=null){
			if(value.indexOf(vParm.getContainStr())==-1){
				logList.add(new ValidateLog(getResultLevel(vParm,ValidateParmType.containStr),paramName + "�ֶ�Ӧ����'"+vParm.getContainStr()+"'�ַ�"));
			}
		}
		
		if(vParm.isOnlyNumber()){
			if(!isNumber(value)){
				logList.add(new ValidateLog(getResultLevel(vParm,ValidateParmType.onlyNumber),paramName + "�ֶ�Ӧֻ�������֣����ܳ��������ַ�"));
			}
		}
		
		if(vParm.getRegexpType()!=null){
			if(!vParm.getRegexpType().validate(value)){
				logList.add(new ValidateLog(getResultLevel(vParm,ValidateParmType.regexpType),paramName + "Ϊ"+vParm.getRegexpType().getZnName()+",��ʽ����ȷ"));
			}
		}
//		System.out.println("������¼����"+logList.size()+"��������Ϣ");
		return logList;
	}
	
	private static boolean isNumber(String value){
		if(value == null || value.isEmpty())return false;
		return value.matches("^[-+]?(([0-9]+)([.]([0-9]+))?|([.]([0-9]+))?)$");
	}
	private static ResultType getResultLevel(ValidateParm vParm,ValidateParmType type){
		if(vParm.getWarningTypeList()==null || vParm.getWarningTypeList().size()==0)return ResultType.ERROR;
		if(vParm.getWarningTypeList().contains(type))return ResultType.WARNING;
		return ResultType.ERROR;	
	}
	
	/**
	 * ִ�����У��󷵻��Ƿ�ɹ�
	 * @return
	 */
	public boolean isSuccess() {
		if(null == this.getErrorList() || this.getErrorList().size()==0){
			return true;
		}
		return false;
	}
	
	/**
	 * ִ�����У��󷵻�У��ͳ�ƽ��
	 * @return
	 */
	public String getResult() {
		String rlt = "";
		rlt += "��������"+this.getErrorList().size();
		rlt += " ��������"+this.getWarnningList().size();
		return rlt;
	}
	

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}
