package app.util.ruleFiter.entity;

import java.util.Map;

public class ProcessedData {
	private String ruleId;
	/**
	 * ��������ӹ���ļ�ֵ����
	 * key���ֶ�������Ҫ��У���е��ֶ�����ͬ
	 * value:���ֶ����µ�ֵ
	 */
	private Map<String,String> processedDataMap;
//	private List<Map<String,String>> allDataMapList;
	public String getRuleId() {
		return ruleId;
	}
	public void setRuleId(String ruleId) {
		this.ruleId = ruleId;
	}
	public Map<String, String> getProcessedDataMap() {
		return processedDataMap;
	}
	public void setProcessedDataMap(Map<String, String> processedDataMap) {
		this.processedDataMap = processedDataMap;
	}
//	public List<Map<String, String>> getAllDataMapList() {
//		return allDataMapList;
//	}
//	public void setAllDataMapList(List<Map<String, String>> allDataMapList) {
//		this.allDataMapList = allDataMapList;
//	}
	
}
