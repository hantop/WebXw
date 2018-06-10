package accounting.plat.core;

import java.net.URLDecoder;
import java.sql.Connection;
import java.util.HashMap;

import accounting.biz.pub.ParmBiz;
import accounting.plat.CreatePrimaryKey;
import accounting.plat.PUBConstant;

public class OperationFactory {

	/** ҵ���������ʵ�� */
	private static OperationFactory instance = new OperationFactory();
	/** ҵ��������� ��KEY��Ӧ���ID����ֵΪ��Ӧ�����������Ϣ����ʽ��ΪHashMap�� */
	private static HashMap interfaceTable = null;

	public static final String CONFIGKEY_MODULEID = "moduleid";
	public static final String CONFIGKEY_CLASSNAME = "classname";
	public static final String CONFIGKEY_DESCRIBE = "describe";
	
	
	/**
	 * <p>
	 * ȡ��ҵ���������ʵ��
	 * </p>
	 * 
	 * @return ҵ���������ʵ��
	 */
	public static OperationFactory getFactoryInstance() {
		if (instance != null) {
			return instance;
		} else {
			return new OperationFactory();
		}
	}

	/**
	 * <p>
	 * ҵ�����������ʼ��
	 * </p>
	 * <p>
	 * ������ҵ����������ļ�(componentcfg.xml)�������������������Ϣ
	 * </p>
	 * 
	 * @throws Exception
	 */
	public static void init() throws Exception {

		try {
			XMLFileUtil xmlFileUtil = new XMLFileUtil();
//			String CONFIG_FILM_DIR = PUBConstant.CONFIG_FILM_DIR;
//			String CONFIG_FILM_DIR = Thread.currentThread().getContextClassLoader().getResource(PUBConstant.CONFIG_FILM_DIR).getPath();
//			CONFIG_FILM_DIR = URLDecoder.decode(CONFIG_FILM_DIR, "UTF-8");
			interfaceTable = (HashMap) xmlFileUtil .readOperationFromXMLFile(PUBConstant.CONFIG_FILM_DIR);
			
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new Exception("��ʼ���������ʧ��" + ex.getMessage());
		}
	}
   
	/**
	 * <p>
	 * ��ҵ�����ID���ҵ�����ʵ��
	 * </p>
	 * <p>
	 * ��������ҵ�����������ʵ�������������������Ϣ���õ�ʵ����������У��÷���ֻ������op��ʹ��
	 * </p>
	 * 
	 * @param comId
	 *            ҵ�����ID
	 * @param context
	 *            EMP �ṹ
	 * @return ҵ�����ʵ��
	 */
	public Operation getOperation(String interfaceId,Connection connection) throws Exception {

		Operation op = null;
		op=this.getOperation(interfaceId,true,connection);
		return op;

	}
	/**
	 * <p>
	 * ��ҵ�����ID���ҵ�����ʵ��
	 * </p>
	 * <p>
	 * ��������ҵ�����������ʵ�������������������Ϣ���õ�ʵ����������У��÷���ֻ������op��ʹ��
	 * </p>
	 * 
	 * @param comId
	 *            ҵ�����ID
	 * @param context
	 *            EMP �ṹ
	 * @return ҵ�����ʵ��
	 */
	public Operation getOperation(String interfaceId,boolean setConnInd,Connection connection) throws Exception {

		if (interfaceTable == null || interfaceTable.size() <= 0) {
			throw new Exception("ҵ������ӿ��б���δ��ʼ�������ȵ��ó�ʼ����������ʹ��getComponentInterface����");
		}

		if (interfaceId == null || interfaceId.trim().equals("")) {
			throw new Exception("ҵ������ӿڱ��Ϊ�գ� �޷�ʵ����ҵ������ӿ�");
		}
		Operation instance = null;
		try {
			HashMap componentCfg = (HashMap) interfaceTable.get(interfaceId);
			if (componentCfg != null && componentCfg.size() > 0) {

				String st_classname = (String) componentCfg
						.get(CONFIGKEY_CLASSNAME);
				String st_describe = (String) componentCfg
						.get(CONFIGKEY_DESCRIBE);

				if (st_classname != null && !st_classname.trim().equals("")) {
					/** ʵ��������ӿ� */
					instance = (Operation) Class.forName(st_classname)
							.newInstance();
					/** ��������ӿڻ�����Ϣ */
					instance.setId(interfaceId);
					instance.setDescribe(st_describe);
				    instance.setOldAutoCommit(connection.getAutoCommit());
					if(setConnInd==true){
						instance.setConnection(connection);
					}
					// ��ȡ������ˮ��
					instance.setTraceNo(ParmBiz.getTraceNo(connection));
					
					System.err.println("����ҵ�����������Ϣ-->>>st_describe: " + st_describe +",������ˮ��:["+instance.getTraceNo()+"]");

				} else {
					throw new Exception("ҵ������ӿ�[" + interfaceId + "]û������ʵ���ࣨ"
									+ CONFIGKEY_CLASSNAME + "���� �޷�ʵ����ҵ������ӿ�");
				}
			} else {
				throw new Exception("ҵ������ӿ�[" + interfaceId + "]��δ���ã��޷�ʵ����");
			}
		} catch (InstantiationException e) {
		
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (IllegalAccessException e) {
		
			e.printStackTrace();
			throw new Exception("��ʼ��ҵ������ӿ�[" + interfaceId + "]ʧ�ܣ���Ȩ������" + e.getMessage());
		} catch (ClassNotFoundException e) {
		
			e.printStackTrace();
			throw new Exception("��ʼ��ҵ������ӿ�[" + interfaceId + "]ʧ�ܣ���Ӧ��ʵ���಻����"
							+ e.getMessage());
		}
		return instance;

	}

}
