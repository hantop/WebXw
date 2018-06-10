package app.util.message.conversion.entry;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

/**
 * ��ҪĿ��Ϊ�Ա������ݲ���
 * 1.��ȡ�������ݣ�����ʵ�֣�
 * 2.������õ�����ת��Ϊ���ģ���д���ļ�
 *
 */
public interface MessageHandler {
	
	/**
	 * ���ݱ������ݻ�ȡ��������ݼ���
	 * List�д�ŵĶ�ȡ���������ݣ�ListΪ�������ֵ����˳��ġ���ת��ʱ�������˳���ӳ�������е�˳�����ƥ��
	 * @return ��������ݽ����
	 * @throws IOException 
	 */
	List<List<String>> readDataListFromMessage() throws IOException;
	List<List<String>> readDataListFromMessage(String filePath) throws FileNotFoundException, IOException;
	
	/**
	 * ����������������ֵд���ļ�����
	 * @param dataList
	 * @return
	 * @throws IOException 
	 */
	boolean writeToMessage(List<List<String>> dataList,boolean isAddContent) throws IOException;
	boolean writeToMessage(List<List<String>> dataList,boolean isAddContent,String filePath) throws IOException;
}
