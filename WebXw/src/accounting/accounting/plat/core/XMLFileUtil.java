package accounting.plat.core;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


/**
 *@Classname	XMLFileUtil.java
 *@Version 1.0	
 *@Copyright 	yuchengtech
 *@Description��������Ҫ�����XML�ļ��Ķ�д
 */
public class XMLFileUtil{
	/*
	 * �洢������Ҫ�������ļ��б�
	 */
	private ArrayList<String> al = new ArrayList<String>();
	
	private String m_fileType = ".xml";		  //�ļ�����	
	
	/*
	 * ��������ļ���xml��ǩ
	 */
	public final String  	BUILDINGELEMENT ="buildingElement";
	public final String  	DAO = "DAO";
	public final String  	OPERATION = "OPERATION";
	public final String 	ID = "id";
	public final String 	DESCRIBE = "describe";
	public final String 	COMPROPERTY = "comproperty";
	public final String 	CLASSNAME = "classname";
	
	
	/**
	 * ����������ļ���ȡ�����еĴ�����Ϣ����ŵ�һ��MAP��,
	 * �ܽ������ļ��ṹ
	 * <cmis>
	 * 		<dddd>
	 * 			<xxx></xxx>
	 * 			<ddd></ddd>
	 * 		<\dddd>
	 * 		<dddd>...</ddd>
	 * </cmis>
	 * @param path �ļ�·��
	 * @return �����Ϣ �ṹ����
	 * @throws Exception
	 */
	public Map readDaoFromXMLFile(String dir) throws Exception{
		
		this.searchFiles(dir);
		
		HashMap<String, HashMap<String, String>> infoMap = new HashMap<String, HashMap<String, String>>();
		
		//����������
		DocumentBuilderFactory doBuilderFactory= DocumentBuilderFactory.newInstance();
		DocumentBuilder doBuilder = doBuilderFactory.newDocumentBuilder();
		
		for(int k=0; k<al.size(); k++){
			String path = al.get(k);
			
			//EMPLog.log(this.getClass().getName(), EMPLog.DEBUG, 0, "start parser dao file :  path");
			
//			File file= new File(path);
//			Document doc =  doBuilder.parse(file);
			
			ClassLoader classloader = Thread.currentThread().getContextClassLoader();
			InputStream is = classloader.getResourceAsStream(path);
			Document doc =  doBuilder.parse(is);
			
			//ȡ�ø�Ŀ¼
			doc.getDocumentElement().normalize();
			
			//ȡ�����й����б�
			NodeList buildingList = doc.getElementsByTagName(BUILDINGELEMENT);
			
			for(int s=0; s<buildingList.getLength(); s++){
				//�õ����������ڵ�
				Node buildNode = buildingList.item(s);
				Element buildElement = (Element)buildNode;
				
				//�õ�������������е�agent
				NodeList agentList = buildElement.getElementsByTagName(DAO);
				/*
				 * ȡ��ÿ��agent�ڵ���Ϣ������һ��map
				 */
				for(int i=0; i<agentList.getLength(); i++){
					//��������agent��Ϣ�洢����
					HashMap<String, String> agentMap = new HashMap<String, String>();
					
					Node agentNode = agentList.item(i);
					Element agentElement  = (Element)agentNode;
					String agentId = agentElement.getAttribute(ID);
					String agentDescribe = agentElement.getAttribute(DESCRIBE);
					String agentComproperty = agentElement.getAttribute(COMPROPERTY);
					
					agentMap.put(DESCRIBE, agentDescribe);
					agentMap.put(COMPROPERTY, agentComproperty);
					
					NodeList classnameList_agent = agentElement.getChildNodes();
					String classname_agent = ((Node)classnameList_agent.item(0)).getNodeValue().trim();
					agentMap.put(CLASSNAME, classname_agent);
					
					infoMap.put(agentId, agentMap);
				}
	
			}
		}
		
		return infoMap;
	}	
	
	/**
	 * ����ĳ��Ŀ¼�������ļ��õ���Ҫ���ļ��ľ���·��
	 * @param dir �ļ�·��  �磺 c:\work
	 * @return �ļ�·��
	 * @throws Exception
	 */
    private ArrayList searchFiles(String dir) throws Exception {
        //�������
        al.clear();
        	
//		File root = new File(dir);
//		//�õ����ļ����µ����������ļ�����
//		File[] filesOrDirs = root.listFiles();
//   
//		for (int i = 0; i < filesOrDirs.length; i++){
//			/*
//			* �жϸ��ļ��Ƿ����ļ��У����������ȡ���������ȡ��Ŀ¼
//			*/
//			 if (filesOrDirs[i].isDirectory()){
//			    	
//			     searchFiles(filesOrDirs[i].getAbsolutePath());
//			        
//			  } else {
//				  
//			    //�õ��ļ���
//			    String fileName = filesOrDirs[i].getName();
//			    
//			    /*
//			    * ƥ���ļ������������ļ��Ƿ�����Ҫ�ҵ��ļ�
//			    */
//			    
//				boolean IsValidfileEnd   = m_fileType.equals(fileName.substring(fileName.length()-4, fileName.length()));
//				    	
//				//���ƥ��İѸ��ļ�·��������
//				if(IsValidfileEnd){      
//					
//				    al.add(filesOrDirs[i].getAbsolutePath()) ;  
//				    
//				}	
//			    
//			 }
//		}
        al.add(dir+File.separator+"LoanInterfConfig.xml");
	
        return al;
        
    }

	public Map readOperationFromXMLFile(String dir) throws Exception{
		
		this.searchFiles(dir);
		
		HashMap<String, HashMap<String, String>> infoMap = new HashMap<String, HashMap<String, String>>();
		
		//����������
		DocumentBuilderFactory doBuilderFactory= DocumentBuilderFactory.newInstance();
		DocumentBuilder doBuilder = doBuilderFactory.newDocumentBuilder();
		
		for(int k=0; k<al.size(); k++){
			String path = al.get(k);
//          EMPLog.log(this.getClass().getName(), EMPLog.DEBUG, 0, "start parser interface file :  path");
//			File file= new File(path);
//			Document doc =  doBuilder.parse(file);
			ClassLoader classloader = Thread.currentThread().getContextClassLoader();
			InputStream is = classloader.getResourceAsStream(path);
			Document doc =  doBuilder.parse(is);
			//ȡ�ø�Ŀ¼
			doc.getDocumentElement().normalize();
			//ȡ�����й����б�
			NodeList buildingList = doc.getElementsByTagName(BUILDINGELEMENT);
		
			for(int s=0; s<buildingList.getLength(); s++){
				//�õ����������ڵ�
				Node buildNode = buildingList.item(s);
				Element buildElement = (Element)buildNode;
				
				//�õ�������������е�interface
				NodeList interfaceList = buildElement.getElementsByTagName(OPERATION);
				
				/*
				 * ȡ��ÿ��interface�ڵ���Ϣ������һ��map
				 */
				for(int i=0; i<interfaceList.getLength(); i++){
					//��������interface��Ϣ�洢����
					HashMap<String, String> interfaceMap = new HashMap<String, String>();
					
					Node interfaceNode = interfaceList.item(i);
					Element interfaceElement  = (Element)interfaceNode;
					String interfaceId = interfaceElement.getAttribute(ID);
					String interfaceDescribe = interfaceElement.getAttribute(DESCRIBE);
					String interfaceComproperty = interfaceElement.getAttribute(COMPROPERTY);
					
					interfaceMap.put(DESCRIBE, interfaceDescribe);
					interfaceMap.put(COMPROPERTY, interfaceComproperty);
					
					NodeList classnameList = interfaceElement.getChildNodes();
					String classname = ((Node)classnameList.item(0)).getNodeValue().trim();
					interfaceMap.put(CLASSNAME, classname);
					
					infoMap.put(interfaceId, interfaceMap);
					
				}
	
			}
		}
		
		return infoMap;
	}    
    
}