package app.util.message.conversion.validate;

import java.util.List;

import app.util.message.conversion.mapping.entity.MappingEntity;
import app.util.ruleFiter.entity.ValidateLog;


/**
 * ������֤���Žӷ�����
 * ������֤�����뱨�ļ��ϣ�������֤������־�ļ�
 * ��õı��ļ��ϸ�ʽΪ��List<List<String>>����ȡ������Ҫ���뱨���ļ���ַfilePath
 * ��֤ʱ����Ĳ���Ϊ��У�����ã�Map<String,ValidateParm> rulesMap���������ݣ�Map<String,String> dataMap
 * rulesMap ����ͨ������ruleId��ȡ
 * dataMap��Ҫ�����ļ��Ϻ��ֶν���ӳ��
 * ��֤�󷵻أ�ÿһ��dataMap����һ��ValidateLog����
 * 
 * ת���취��
 * 1.�����ļ�����ӳ�����ý�ϳ�Ϊ�������ݸ�ʽdataMap��ʽ
 * 2.��dataMap����У�飬���Է��ص�validate���д���
 *
 */
public interface MessageValidate {
	/**
	 * @param ruleId ͨ������ID��ȡ��Ӧ��У��RuleMap��
	 * @param entityList ӦΪ������ֵ�Ժ��MappingColumn����
	 * @return
	 */
	ValidateLog validateMessage(String ruleId,List<MappingEntity> entityList);
}
