package app.util.message.conversion.mapping.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import app.util.message.conversion.mapping.MappingHandler;
import app.util.message.conversion.mapping.entity.MappingColumn;
import app.util.message.conversion.mapping.entity.MappingEntity;
import app.util.message.conversion.type.DataType;

public class MappingHandlerImplForTxt extends MappingHandler{
	final static Logger logger = LoggerFactory.getLogger(MappingHandlerImplForTxt.class);
	
	private String filePath;
	private final String splitStr = "\\|\\+\\|";
	private InputStream inputStream;
	public MappingHandlerImplForTxt(){
		ClassLoader classloader = Thread.currentThread().getContextClassLoader();
		inputStream = classloader.getResourceAsStream("mappingConfig.properties");
//		if(resource!=null&& resource.exists()){
//			try {
//				filePath = resource.getFile().getAbsolutePath();
//			} catch (IOException e) {
//				filePath = "";
//			}
//		}else{
//			filePath="";
//		}
////		this.filePath = ClassLoader.getSystemResource("").getPath()+"mapingConfig.text";
	}
	
	public MappingHandlerImplForTxt(String filePath){
		this.filePath = filePath;
	}
	
	@Override
	public MappingEntity findMappingEntityById(String mappingId) {
		if(MappingHandler.mappingConfig.containsKey(mappingId))return MappingHandler.mappingConfig.get(mappingId);
		else return null;
	}

	@Override
	public Map<String, MappingEntity> initMappingConfig() throws IOException {
		// File file = new File(filePath);
		// if(!file.exists())throw new FileNotFoundException("û���ҵ����ӳ�������ļ�:"+filePath);
		ClassLoader classloader = Thread.currentThread().getContextClassLoader();
		inputStream = classloader.getResourceAsStream("mappingConfig.properties");
		   BufferedReader bReader = new BufferedReader(new InputStreamReader(inputStream)); 
		Map<String, MappingEntity> mappingMap = new HashMap<String, MappingEntity>();
		String messageForLine = null;
		List<MappingColumn> columnList = null;
		
		try {
			while((messageForLine = bReader.readLine())!=null){
				if(messageForLine.indexOf("=")==-1){
					System.out.println("��ȡ����ӳ�������ļ�ʱ���ִ���,��ʽ����ȷ��"+messageForLine);
					continue;
				}
				String[] mappingArrays = messageForLine.split("=");//=�Ż����������ߣ���߰���mapID�ͱ������ұ߰����ֶ�ƥ��͸�������
				//�Ȼ�ȡ��������
				String[] tableAttribute = mappingArrays[1].split(":");
				String returnColumnName = null;
				String sequenceName = null;
				String ignoreAll = null;
				if(tableAttribute!=null && tableAttribute.length > 1){
					mappingArrays[1] = tableAttribute[0];
					if(tableAttribute[1].indexOf("{")!=-1 && tableAttribute[1].indexOf("}")!=-1){
						tableAttribute[1] = tableAttribute[1].replaceAll("\\{", "").replaceAll("\\}", "");
						for(String entity:tableAttribute[1].split(splitStr)){
							String[] entityArrays = entity.split("-");
							if("sequenceName".equalsIgnoreCase(entityArrays[0])){
								sequenceName = entityArrays[1];
							}
							if("returnColumn".equalsIgnoreCase(entityArrays[0])){
								returnColumnName = entityArrays[1];
							}
							if("ignoreAll".equalsIgnoreCase(entityArrays[0])){
								ignoreAll = entityArrays[1];
							}
						}
					}
				}
				//�Ա���Ӧ�ֶν��н���
				columnList = new ArrayList<MappingColumn>();
				for(String entity:mappingArrays[1].split(splitStr)){
					String[] entityArrays = entity.split("-");
					if(entityArrays.length == 1){
						//Ĭ��VARCAHR����
						columnList.add(new MappingColumn(entityArrays[0],DataType.VARCHAR));
					}else{
						MappingColumn mc = new MappingColumn(entityArrays[0],DataType.getDataType(entityArrays[1]));
						if(DataType.getDataType(entityArrays[1]) == DataType.DEFAULT){
							//�����Ĭ��ֵ�������Ĭ��ֵ��
							try {
								mc.setDefaultValue(entityArrays[2]);
							} catch (ArrayIndexOutOfBoundsException e) {
								logger.error("Ĭ��ֵ�ֶΡ�"+entityArrays[0]+"��û�н�����ȷ������");
								e.printStackTrace();
							}
						}
						columnList.add(mc);
					}
					
				}
				String[] idArrays = mappingArrays[0].split(":");//�ֺ�ǰΪID���ֺź�Ϊ����
				MappingEntity entity = new MappingEntity(idArrays[1],columnList,sequenceName,returnColumnName);
				mappingMap.put(idArrays[0], entity);
			}
		} finally{
			if(bReader!=null)bReader.close();
		}
		return mappingMap;
	}
	
	
	public static void main(String[] args) throws IOException {
		String readPath = "C:/work/otherSpace/me2014/CMSWeb/src/main/java/app/util/message/conversion/test/mappingConfig1.txt";
		MappingHandler mh = new MappingHandlerImplForTxt(readPath);
		mh.refreshConfig();
		System.out.println(mh.findMappingEntityById("0001"));
	}

}
