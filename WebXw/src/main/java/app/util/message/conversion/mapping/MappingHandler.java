package app.util.message.conversion.mapping;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

import app.util.message.conversion.mapping.entity.MappingEntity;

/**
 * ��ҪĿ��Ϊ���ɱ����ֶε�ӳ������
 * ��ȡ�����ļ�������һ��ӳ������
 * ӳ������Ӧ��Ϊһ��������ֶμ��ϡ����ϳ���Ӧ���ڱ�����ÿ����¼���ֶθ�����
 * �����ļ�����Ϊ���֣�����xml����txt
 * 
 * ���ü���Ӧ�������ڻ����У���һ��ӳ�伯�ϡ�
 *
 */
public abstract class MappingHandler {
	protected static Map<String,MappingEntity> mappingConfig = null;
	
	/**
	 * ����ӳ����ȡ���ֶ����򼯺�
	 * @param mappingId
	 * @return
	 */
	public abstract MappingEntity findMappingEntityById(String mappingId);
	
	/**
	 * ����ӳ���ļ���ʼ��ӳ�伯�ϻ���
	 * @return
	 * @throws FileNotFoundException 
	 * @throws IOException 
	 */
	public abstract Map<String,MappingEntity> initMappingConfig() throws IOException ;
	
	/**
	 * ˢ�»���
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public void refreshConfig() throws IOException{
		if(mappingConfig!=null)mappingConfig.clear();
		mappingConfig = initMappingConfig();
	}
}
