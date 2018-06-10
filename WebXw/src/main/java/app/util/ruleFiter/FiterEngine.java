package app.util.ruleFiter;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import app.creditapp.sys.entity.Student;
import app.util.ruleFiter.entity.ProcessedData;
import app.util.ruleFiter.entity.ValidateLog;
import app.util.ruleFiter.entity.ValidateParm;
import app.util.ruleFiter.fiter.FiterEngineInterface;

public class FiterEngine {
	/*
	 * ����Ŀ�꣺
	 * 1.ȡ�ô�ͨѶ�ӿڣ����ͷ������ݹ����ı��Ļ������ݡ�
	 * 2.ȡ�ù����ļ��ж�Ӧ�Ĺ���У��淶��
	 * 3.����У��淶ת��ΪУ�鷽��
	 * 4.�Ա������ݽ���У��
	 * 5.��У�����ͱ�������һ�����͸����ܷ���
	 */
	
	/*
	 * ע�����⣺
	 * 1.�����ļ���ʽ�����ж��ָ�ʽ��json����txt�ļ���
	 * 2.�������ݸ�ʽ���ܴ��ڶ��ָ�ʽ��json��ʽ�������Զ����ʽ�ȡ�
	 * 3.�����ļ�ҪУ����ֶκ��ֶ�ֵ�����ж�������������޶����֣��޶����ȵȡ�
	 * 4.����У����Ϊ�Σ���Ҫ���������ݺ�У�������͸����շ�
	 */
	
	/*
	 * �����е�һЩ˼·Ҫ�㣺
	 * 1.У�������Բ�������ʹ��һ��ö���࣬�Զ���һЩ�Դ���У������������֤���ֻ�����ȡ�
	 * 		���Ϊ�����������������������󳤶ȣ���С���ȣ��Ƿ�Ϊ�յȣ���������
	 * 2.У������е�Ҫ��Ϊ�ǿգ��Զ��塣
	 * 3.�������þ���ȼ���error��warning��success��
	 */
	
	/*
	 * ����ؼ�����
	 * 1.��λ�ȡ����
	 * 2.��λ�ȡ�����ļ���Ϣ
	 * 3.��ν������ļ���Ϣת��Ϊ���������У�鷽��
	 * 4.���У������
	 */
	
	
	/*
	 * ׼��Ҫ���Ĺ�����
	 * processSendData();
	 * createValidateRule();
	 */
	private FiterEngineInterface filterEngineInterface;
	
	/**
	 * ��ȡ��֤�������־��Ϣ��
	 * @param returnAtOnce ȷ���Ƿ��������ء����Ϊ�棬�������κ�һ��������߾�����Ϣ������ֹ�жϲ����ش���<br>���Ϊ�٣���ȫ��У����ɺ󷵻���־��Ϣ�б�
	 * @return ����ValidateLog�࣬��ͨ��warningList��errorList��ȡ������ߴ�����Ϣ.
	 */
	public ValidateLog getValidateLogList(boolean returnAtOnce){
		//��ȡ��ҪУ�������
		SendDataProcessEngine spEngine = new SendDataProcessEngine();
		ProcessedData processedData = spEngine.processSendDataForTest();
		
		//��ȡ�ӹ�������Ҫ��֤�ı�������
		Map<String,String> dataMap = processedData.getProcessedDataMap();
		//�Ա������ݽ���У��
		List<ValidateLog> logList = null;
		try {
			logList = 	filterEngineInterface.validateDataMap(processedData.getRuleId(), dataMap, returnAtOnce);
		} catch (IOException e) {
			e.printStackTrace();
		}

		ValidateLog log =  new ValidateLog();
		log.setResultlogList(logList);
		log.showValidateResult(false);
		return log;
	}
	
	/**
	 * ���ж��Ƿ�У��ɹ��������ھ�����Ϣһ�����سɹ���
	 * @return ����ֵΪ�棬��У��ɹ�������ͨ��������ֵΪ�٣���У��ʧ�ܡ�
	 */
	public boolean doValidateFiter(){
		return !(getValidateLogList(false).getErrorList().size()>0);
	}
	
	/**
	 * ��ȡ��֤�������־��Ϣ���ڲ����ݲ�������£�Ĭ�Ͻ�����getValidateLogList(false)���������������Ľ����
	 * @return ����ValidateLog�࣬��ͨ��warningList��errorList��ȡ������ߴ�����Ϣ.
	 */
	public ValidateLog getValidateLogList(){
		return getValidateLogList(false);
	}
	
	public List<ValidateLog> validateDataMap(Map<String,ValidateParm> rulesMap,Map<String,String> dataMap,boolean returnAtOnce){
		return filterEngineInterface.validateDataMap(rulesMap, dataMap, returnAtOnce);
	}
	
	public void setFilterEngineInterface(FiterEngineInterface filterEngineInterface) {
		this.filterEngineInterface = filterEngineInterface;
	}

	public static void main(String[] args) throws Exception {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		Student student = new Student();
//		student.setAge(23);
//		student.setCost(240.0);
//		student.setEmail("ddd123123");
//		student.setName("Tim");
		FiterEngineInterface filterEngineInterface = (FiterEngineInterface) ac.getBean("filterEngineInterface");
		ValidateLog log = filterEngineInterface.createValidateLog("101", student, false);
		log.showValidateResult(true);
//		File file = new File("C:/work/otherSpace/eclipse2015/wmxt/WebRoot/WEB-INF/classes/ruleData.xml");
//		System.out.println(file.exists());
//		FiterEngine fe = new FiterEngine();
//		fe.getValidateLogList(false);
	}
}
