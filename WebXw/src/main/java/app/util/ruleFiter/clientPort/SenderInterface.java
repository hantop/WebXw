package app.util.ruleFiter.clientPort;

import app.util.ruleFiter.entity.SendData;

/**
 * ��Ϣ���ͷ�
 * <br>
 * ����У��������Ӵ˽ӿڻ����ҪУ��������ļ�
 * <br>
 * �����ļ����ܴ��ڶ����ļ���ʽ��txt,excel,json��xml�ȵ�
 * <br>
 * 
 *
 */
public interface SenderInterface {
	/**
	 * ��Ҫʵ�ֱ��ӿڽ��б������ݵĻ�ȡ��
	 * <br>
	 * �������ݿ��ܴ��ڶ������ݸ�ʽ������txt,json�ַ�����xml��ʽ�ȣ�����̶�һ�ַ�ʽ��ȡ��Ҳ������ͬ���ķ�����ͨ������ģʽ��ȡ��ͬ���͵�����
	 * <br>
	 * 
	 * @return ��װ������ݸ�ʽΪSendData����Ҫ��������У��Ĺ���ID�������ļ����ͣ��Լ���������������ݣ��ַ��������ļ���
	 */
	public SendData sendDataByFile();
	
}
