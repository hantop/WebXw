package app.util.ruleFiter.fiter;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import app.util.ruleFiter.entity.ValidateLog;
import app.util.ruleFiter.entity.ValidateParm;

public interface FiterEngineInterface {
	/**
	 * ����У����־�����б�
	 * @param rulesMap ����У��Ĺ���Map
	 * @param dataMap  ��ҪУ������ݼ�ӳ��
	 * @param returnAtOnce �Ƿ���������
	 * @return
	 */
	List<ValidateLog> validateDataMap(Map<String,ValidateParm> rulesMap,Map<String,String> dataMap,boolean returnAtOnce);

	/**
	 * ����У����־�����б�
	 * @param rulesMap ����У��Ĺ���Map
	 * @param dataMap  ��ҪУ������ݼ�ӳ��
	 * @param returnAtOnce �Ƿ���������
	 * @return
	 * @throws IOException 
	 */
	List<ValidateLog> validateDataMap(String ruleId,Map<String,String> dataMap,boolean returnAtOnce) throws IOException;

	/**
	 * ���ж��Ƿ�У��ɹ��������ھ�����Ϣһ�����سɹ���
	 * @return ����ֵΪ�棬��У��ɹ�������ͨ��������ֵΪ�٣���У��ʧ�ܡ�
	 * @throws IOException 
	 */
	boolean doValidateFiter(String ruleId,Map<String,String> dataMap) throws IOException;
	
	/**
	 * ����У������־����־�а���errorList�Լ�warningList���ݡ�
	 * @param ruleId У�����ı�ʶID
	 * @param dataMap��ҪУ�����ֵ�������
	 * @return
	 * @throws IOException 
	 */
	ValidateLog createValidateLog(String ruleId,Map<String,String> dataMap) throws IOException;
	
	/**
	 * ��ͨ������ֱ�ӻ�ȡ��������Ҫ��ȡ�ļ����߲�ѯ���ݿ⡣
	 * @param ruleId ����ID��ͨ���ı�Ż�ȡ��Ӧ��У�����
	 * @return ӳ��map�У�string��Ϊ��ҪУ����ֶΣ�ValidateParmΪУ���ʽ
	 * @throws IOException 
	 */
	Map<String,ValidateParm> getRuleByIdDirectly(String ruleId);
	
	/**
	 * ������Ҫ��ȡ�ļ����߲�ѯ���ݿ⣬ͨ���÷�����ʼ�����档�����ʼ�����������ʹ��getRuleByIdFormCache������ȡ��Ӧ��У�����
	 * <br>ע�����Բ���Ҫ��ȡ����ֵ
	 * @throws IOException 
	 */
	public Map<String,ValidateParm> getRuleByIdFormCache(String ruleId) throws IOException;
	
	/**
	 * ���ݶ���ת������У��
	 * ���ݸ��ݶ������У��ʱ�������ݻ�����ж�ȡ
	 * @param ruleId
	 * @param obj
	 * @param returnAtOnce
	 * @return
	 * @throws Exception
	 */
	ValidateLog createValidateLog(String ruleId,Object obj,boolean returnAtOnce) throws Exception;
	ValidateLog createValidateLog( Map<String, ValidateParm> rulesMap,Object obj,boolean returnAtOnce) throws Exception;
}
