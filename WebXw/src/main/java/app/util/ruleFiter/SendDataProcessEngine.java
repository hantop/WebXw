package app.util.ruleFiter;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;

import app.creditapp.sys.entity.Student;
import app.util.ruleFiter.clientPort.SenderInterface;
import app.util.ruleFiter.entity.ProcessedData;
import app.util.ruleFiter.entity.SendData;
import app.util.ruleFiter.type.FileType;

public class SendDataProcessEngine {
	private SenderInterface senderInterface;

	/**
	 * �趨��ȡ���ݵķ�ʽ���ӿ�����Ҫʵ��sendDataByFile�����������ݵ����ݸ�ʽ��ΪsendData���ʽ�����п��԰���file�ļ�����json���ݴ���<br>������Ҫ�����ļ������Ա��ڽ�����ѡ�������ʽ��
	 * @param senderInterface
	 */
	public void setSenderInterface(SenderInterface senderInterface) {
		this.senderInterface = senderInterface;
	}
	
	/**
	 * ͨ��senderInterface���趨��ȡ��������ݣ�����ʽ��ΪProcessedData�࣬�����䷵�ء�<br>
	 * ���������Ӧ�������ļ���ʽ���ͣ�����xml����json�����ø�ʽ������ѡ���Ӧ�ĸ�ʽ��������
	 * @return ProcessedData���а�����Ҫ��У��ID-ruleId���Լ���ʽ���õ�Map��ֵӳ��
	 */
	public ProcessedData processSendData(){
		SendData sendData = senderInterface.sendDataByFile();
		return transferSendData(sendData);
	}
	
	public ProcessedData processSendData(String ruleId,String filePath){
		SendData sendData = new SendData();
		sendData.setSendRuleId(ruleId);
		sendData.setFileType(FileType.TXT);
		sendData.setSendFileData(new File(filePath));
		return transferSendData(sendData);
	}
	
	private ProcessedData transferSendData(SendData sendData){
		ProcessedData pData = new ProcessedData();
		pData.setRuleId(sendData.getSendRuleId());
		//TODO �Դ��������ļ��������ݽ��д���
		/*
		 * �������ݿ��ܴ���txt,excel,json,xml�ȸ�ʽ
		 */
		if(sendData.getFileType() == FileType.JSON){
			pData.setProcessedDataMap(transferDataForJson(sendData.getSendStringData()));
		}
		
		return pData;
	}
	
	private Map<String, String> transferDataForJson(String jsonStr) {
		Map<String, String> valueMap = new HashMap<String, String>();
//		JSONObject jsonObject = JSONObject.fromObject(jsonStr);
//		JSONObject jsonObject = JSONObject.fromObject(jsonStr);
//		Iterator<?> it = jsonObject.keys();
//		String key = null;
//		String value = null;
//		while (it.hasNext()) {
//			key = String.valueOf(it.next());
//			value = String.valueOf(jsonObject.get(key));
//			valueMap.put(key, value);
//		}
		return valueMap;
	}
	
	private List<Map<String, String>> transferDataForTxt(String jsonStr) {
		List<Map<String, String>> resultMapList = new ArrayList<Map<String, String>>();
		Map<String, String> valueMap = new HashMap<String, String>();
		//TODO ���������ȡ�������ݵĽ����
		return resultMapList;
	}
	
	private Map<String, String> transferDataForXML(String jsonStr) {
		Map<String, String> valueMap = new HashMap<String, String>();
		return valueMap;
	}
	
	
	/**
	 * ��Ҫ���ڲ��ԣ�����һ��ѧ���ࣨStudent����ProcessedData����
	 * @return
	 */
	public ProcessedData processSendDataForTest(){
		SendData sendData = testCreateSendData();
		return transferSendData(sendData);
	}
	
	private SendData testCreateSendData(){
		Student student = new Student();
//		student.setAge(23);
//		student.setCost(240.0);
//		student.setEmail("ddd123123");
//		student.setName("Tim");
		
//		String jsonStr = JSONObject.fromObject(student).toString();
		String jsonStr = JSON.toJSONString(student);
		System.out.println(jsonStr);
		SendData sendData = new SendData();
		sendData.setFileType(FileType.JSON);
		sendData.setSendStringData(jsonStr);
		sendData.setSendRuleId("101");
		return sendData;
	}
}
