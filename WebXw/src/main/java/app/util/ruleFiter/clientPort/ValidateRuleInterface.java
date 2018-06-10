package app.util.ruleFiter.clientPort;

import java.io.IOException;
import java.util.Map;

import app.util.ruleFiter.entity.ValidateParm;
import app.util.ruleFiter.entity.ValidateRuleEntity;

/**
 * �ֱ�����·�ʽ��ȡУ�����
 * xml-�����
 * excel
 * txt
 * ���ݿ�
 *
 */
public interface ValidateRuleInterface {
	
	
	/**
	 * ��ͨ������ֱ�ӻ�ȡ��������Ҫ��ȡ�ļ����߲�ѯ���ݿ⡣
	 * @param ruleId ����ID��ͨ���ı�Ż�ȡ��Ӧ��У�����
	 * @return ӳ��map�У�string��Ϊ��ҪУ����ֶΣ�ValidateParmΪУ���ʽ
	 * @throws IOException 
	 */
	public Map<String,ValidateParm> getRuleByIdDirectly(String ruleId) throws IOException;
	
	/**
	 * �ӻ�����ͨ��ruleId��ȡ����.���У��������ݷ����仯������Ҫˢ�»����¼��ػ���
	 * @param ruleId ����ID��ͨ���ı�Ż�ȡ��Ӧ��У�����
	 * @return ӳ��map�У�string��Ϊ��ҪУ����ֶΣ�ValidateParmΪУ���ʽ
	 * @throws IOException 
	 */
	public Map<String,ValidateParm> getRuleByIdFromCache(String ruleId) throws IOException;
	
	/**
	 * ������Ҫ��ȡ�ļ����߲�ѯ���ݿ⣬ͨ���÷�����ʼ�����档�����ʼ�����������ʹ��getRuleByIdFromCache������ȡ��Ӧ��У�����
	 * <br>ע�����Բ���Ҫ��ȡ����ֵ
	 * @return ValidateRuleEntity���з�װ��У������һЩ˵���ͻ������ԡ�ͬ��ͨ��ruleId��ȡ��Ӧ�Ĺ�����Ϣ
	 * @throws IOException 
	 */
	public Map<String,ValidateRuleEntity> initValidateRuleEntityForCache() throws IOException;
}
