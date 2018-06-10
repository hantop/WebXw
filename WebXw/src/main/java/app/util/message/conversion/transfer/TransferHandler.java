package app.util.message.conversion.transfer;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import app.util.message.conversion.entity.TransferResult;


/**
 * Ŀǰ�Ѿ�׼���õ�����������
 * �������ݣ�
 * ����-
 * MappingHandler����û��valueֵ��MappingEntity����ҪmappingId
 * MessageHandler�л�ȡ�������򼯺�����List<List<String>>����ҪfilePath
 * 
 * ���-
 * DataBaseHandler�з��ز����ɹ�״̬����Ҫ����valueֵ���MappingEntity
 * 
 * �������ݣ�
 * ����-
 * DataBaseHandler��exportDataFromDb�������ض���ֶ�-ֵ��Ե���������List<Map<String, String>>����Ҫsql���,���߶��󼯺�
 * MappingHandler����û��valueֵ��MappingEntity����ҪmappingId
 * 
 * ���-
 * MessageHandler��д���ļ��ķ�������Ҫ�����ı��Ľ����List<List<String>>���ļ�·��filePath
 * 
 * ������
 * ��ӿ��ؾ����Ƿ����У��ӿ�
 *
 */
public interface TransferHandler {
	
	/**
	 * ������ת��Ϊ�־û�����
	 * @param mappingId
	 * @return
	 * @throws IOException
	 */
	boolean messageToData(String mappingId) throws IOException;
	boolean messageToData(String mappingId,String filePath) throws IOException;
	
	/**
	 * ����֤�ı���-���ݿ�����ת������Ҫ�ഫ��һ��������У�����ID
	 * @param mappingId
	 * @param ruleId
	 * @return
	 * @throws IOException
	 */
	boolean messageToDataWithValidate(String mappingId, String ruleId) throws IOException;
	boolean messageToDataWithValidate(String mappingId, String ruleId,String filePth) throws IOException;
	
	/**
	 * 
	 * @���� DHCC-LIYABIN
	 * @���� 2016��7��12��
	 * @����˵����
	 * @���ز��� boolean
	 */
	boolean messageToDataWithValidate(String[] mappingIdArgs, String[] ruleIdArgs) throws Exception;
	boolean messageToDataWithValidate(String[] mappingId, String[] ruleId,String filePth) throws Exception;
	
	
	/**
	 * ���ڸ�������µ�����ת������������ͬʱ���ж��sheetҳ���ת��
	 * 1.�����mapping����Ӧ��ruleId�ĸ�����ͬ����һһ��Ӧ�������еĵ�һ��ֵҲ��Ӧ��Ҫ��ȡ���ļ��еĵ�һ��ҳ�棬������һ��Excel�ļ��еĵ�һ��sheetҳ��
	 * 2.replaceDefaultMapΪҪ�滻�Ķ�Ӧ�ֶε�ֵ������keyΪ�ֶ�����valueΪ�滻���ֵ��ע���滻Ϊȫ���滻�������β������ֶζ��ᱻ�滻Ϊvalue��һ��ֵ��
	 * @���� DHCC-LIYABIN
	 * @���� 2016��7��29��
	 * @����˵����
	 * @���ز��� List<TransferResult>
	 */
	List<TransferResult> messageToDataForComplex(String[] mappingId, String[] ruleId,String filePth) throws Exception;
	List<TransferResult> messageToDataForComplex(String[] mappingId, String[] ruleId,String filePth,Map<String,String> replaceDefaultMap) throws Exception;
	/**
	 * ���ѳ־û�����ת��Ϊ���ģ���д���ļ���
	 * @param mappingId
	 * @param sql
	 * @return
	 * @throws IOException
	 */
	boolean dataToMessage(String mappingId,String sql) throws IOException;
	boolean dataToMessage(String mappingId,String sql,String filePth) throws IOException;
	
	
	/**
	 * ��ʵ���༯��ת��Ϊ���ģ���д���ļ���
	 * @param mappingId
	 * @param objList
	 * @return
	 * @throws Exception
	 */
	public boolean objectToMessage(String mappingId, List<?> objList) throws Exception;
	public boolean objectToMessage(String mappingId, List<?> objList,String filePth) throws Exception;
	
	
	/**
	 * ˢ�»��ʼ������ӳ�������ļ�
	 * @throws IOException
	 */
	void refreshMappingConfig() throws IOException;
	
	/**
	 * �趨�Ƿ������ļ�����׷�Ӳ��������Ϊtrue������ԭ���ļ������Ͻ���׷��д�룬���Ϊfalse��������д���ļ�
	 * Ĭ��Ϊtrue;
	 * @param isAdd
	 */
	void isAddFileContent(boolean isAdd);
	
}
