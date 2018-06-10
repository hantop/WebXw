package app.util.message.conversion.db;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

import app.util.message.conversion.mapping.entity.MappingEntity;

/**
 * ��Ҫ���������ݿ�Ľ���
 * 1.����Ϻõ����ݣ�javabean��map������ӿ��У����������ݿ���
 * 2.��������������sql������ѯ�����ݣ�ƴ�ճ�Map����javabean���ء�
 * @param <E>
 *
 */
public interface DataBaseHandler{
	/**
	 * �����ݲ�������ݿ���
	 * 
	 * @param table
	 * @param valueMap
	 * @return
	 */
	public boolean insertDataIntoDb(MappingEntity entity);
	public boolean insertDataIntoDb(List<MappingEntity> entityList);
	public String insertDataIntoDbStr(List<MappingEntity> entityList,String str);
	
	/**
	 * ����ѯ���������ݷ�װ��Mapӳ����
	 * @param sql
	 * @return
	 */
	public List<Map<String, String>> exportDataFromDb(String sql);
	
	public List<Map<String, String>> exportDataFromDb(List<?> objList) throws SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException;
	
	/**
	 * ����ѯ���������ݷ�װ��ʵ������
	 * @param sql
	 * @param clazz
	 * @return
	 */
//	public <T> List<T>  exportDataFromDbToObjet(String sql, T clazz);
	
	/**
	 * ���������У��������ݸ�ʽ����ȷ�ȴ��󣬰�ln_acct_mid,ln_gage_mid,ln_rel_mid����app_idΪ�յ�����ɾ��
	 */
	public boolean del(String tableName);
	
}
