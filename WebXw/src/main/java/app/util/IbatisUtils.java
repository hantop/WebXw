package app.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import app.util.toolkit.Ipage;

import com.ibatis.sqlmap.engine.impl.SqlMapClientImpl;
import com.ibatis.sqlmap.engine.mapping.parameter.ParameterMap;
import com.ibatis.sqlmap.engine.mapping.parameter.ParameterMapping;
import com.ibatis.sqlmap.engine.mapping.sql.Sql;
import com.ibatis.sqlmap.engine.mapping.statement.MappedStatement;
import com.ibatis.sqlmap.engine.scope.SessionScope;
import com.ibatis.sqlmap.engine.scope.StatementScope;

/**
 * ibatis����������
 *
 * @see 
 * �޸ļ�¼:
 */
public class IbatisUtils {
	private static Logger logger = Logger.getLogger(IbatisUtils.class);
	
	/**
	 * ������ʵ����ʵ���еķǿ�����ӳ�䵽Map.
	 * @param ipage
	 * @param entity
	 * @return
	 */
	public static Map<String,Object>  getEntityPropertyMap(Ipage ipage,Object entity){
		Map<String,Object> paramMap = ipage.getParams();
		paramMap.put("startNum", ipage.getStartRow());
		paramMap.put("endNum", ipage.getEndNum());
		if(entity==null){
			return paramMap;
		}
		try {
			Field[] fields = entity.getClass().getDeclaredFields();   //��ǰ��
			Field[] fieldsfather = entity.getClass().getSuperclass().getDeclaredFields();   //ȡ����
			Field[] fieldsall = new Field[fields.length+fieldsfather.length];     //����ĳ��ȵ���   ��ǰ�� + ����ĳ���
			for(int i=0;i<fieldsall.length;i++){
				if(i<fields.length){
					fieldsall[i] = fields[i];   //��ǰ���ȷŵ�������
				}else{
						fieldsall[i] = fieldsfather[i-fields.length];    //�Ѹ������������
				}
			}
			for (Field field : fieldsall) {
				if(StringUtils.equals(field.getName(), "serialVersionUID")){
					continue;
				}
				String methodName = "get"+StringUtils.capitalize(field.getName());
				Method method = entity.getClass().getMethod(methodName);
				Object propertyValue = method.invoke(entity);
				if(propertyValue!=null){
					paramMap.put(field.getName(), propertyValue);
				}
			}
			
			
		} catch (Exception e) {
			logger.error(e);
			e.printStackTrace();
		}
		return paramMap;
	}
	/**
	 * ������ʵ����ʵ���еķǿ�����ӳ�䵽Map,��������ӳ�䵽Map
	 * @param tableName
	 * @param entity
	 * @return
	 */
	public static Map<String,Object>  getEntityPropertyMap1(String tableName,Object entity){
		Map<String,Object> paramMap = new HashMap<String, Object>();
		try {
			Field[] fields = entity.getClass().getDeclaredFields();
			Field[] fieldsfather = entity.getClass().getSuperclass().getDeclaredFields();
			Field[] fieldsall = new Field[fields.length+fieldsfather.length];
			for(int i=0;i<fieldsall.length;i++){
				if(i<fields.length){
					fieldsall[i] = fields[i];
				}else{
						fieldsall[i] = fieldsfather[i-fields.length];
				}
			}
			for (Field field : fieldsall) {
				if(StringUtils.equals(field.getName(), "serialVersionUID")){
					continue;
				}
				String methodName = "get"+StringUtils.capitalize(field.getName());
				Method method = entity.getClass().getMethod(methodName);
				Object propertyValue = method.invoke(entity);
				if(propertyValue!=null){
					paramMap.put(field.getName(), propertyValue);
				}
			}
			paramMap.put("tableName", tableName);
		} catch (Exception e) {
			logger.error(e);
			e.printStackTrace();
		}
		return paramMap;
	}
	
	/**  
     * ���Ibatis ����ִ��sql (gaobing@dhcc.com)
     *   
     * @param id  
     *            SQL��ID  
     * @param sqlMapClient  
     *            com.ibatis.sqlmap.client.SqlMapClient;  
     * @param parameterObject  
     *            ��������  
     * @return IbatisSql  
     */  
	  //Dao���ø�ʽ	
		//    SqlMapClientImpl sqlimp=(SqlMapClientImpl)getSqlMapClientTemplate().getSqlMapClient();
		//    String execSql=IbatisUtils.getIbatisSql("ZcPlasset.findPage.count", sqlimp, zcplasset);
		//    sqlimp=null;
    public static final String getIbatisSql(String id,   
    		SqlMapClientImpl sqlMapClient, Object parameterObject){   
        MappedStatement mappedStatement = sqlMapClient  
                .getMappedStatement(id);   
        Sql sql = mappedStatement.getSql();
        SessionScope sessionScope = new SessionScope();   
//        sessionScope.incrementRequestStackDepth();   
        StatementScope statementScope = new StatementScope(sessionScope);   
        mappedStatement.initRequest(statementScope); 
        
        String strSql = sql.getSql(statementScope, parameterObject);   
        ParameterMap m=sql.getParameterMap(statementScope, parameterObject);
        ParameterMapping[] map=m.getParameterMappings();//����ӳ�伯
        
        Object[] parmvals=m.getParameterObjectValues(statementScope, parameterObject);//����ֵ
        int type=0;//�жϴ���Ĳ�������
        if(parameterObject instanceof Integer||parameterObject instanceof Float||parameterObject instanceof Double){
        	type=1;
        }else if(parameterObject instanceof String||parameterObject instanceof Character){
        	type=2;
        }else if(parameterObject instanceof Map){
        	type=3;
        }else{
        	type=4;
        }
        strSql = strSql != null ? strSql.trim().toLowerCase() : strSql; //��ִ̨�е�sql  
        if(type==1){//��ֵ��
        	strSql=strSql.replaceAll("\\?", parameterObject+"");
        }else if(type==2){//�ַ���
        	strSql=strSql.replaceAll("\\?", "'"+parameterObject+""+"'");
        }else if(type==3){//map��
        	int j=parmvals.length; 
        	for(int i=0;i<j;i++){//map��ͨ������string
        		strSql=strSql.replaceFirst("\\?", "'"+parmvals[i]+"'");
        	}
        }else if(type==4){//ʵ����
        	int j=map.length;//��������
        	for(int i=0;i<j;i++){
        		Object fieldType;
        		Field field;
				try {
					field = parameterObject.getClass().getDeclaredField(map[i].getPropertyName());
					fieldType=field.getType();
			        if(fieldType!=null&&(fieldType==Integer.class||fieldType==Float.class||fieldType==Double.class)){
			        	strSql=strSql.replaceFirst("\\?", parmvals[i]+"");
			        }else if(fieldType!=null&&(fieldType==Character.class||fieldType==String.class)){
			        	strSql=strSql.replaceFirst("\\?", "'"+parmvals[i]+"'");
			        }
				} catch (SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NoSuchFieldException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        	}
        }
        sql.cleanup(statementScope);   
        sessionScope.cleanup();   
        mappedStatement = null;   
        sql = null;   
        sessionScope = null;   
        statementScope = null;   
        id = null;   
        parameterObject = null;   
        return strSql;   
    }   

}
