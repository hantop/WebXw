package app.util.message.conversion;

import java.io.IOException;
import java.net.URL;
import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import app.util.message.conversion.transfer.TransferHandler;

import com.core.struts.BaseFormBean;

/**
 * ��ҪĿ���ǶԱ�����Ϣ����ת����
 * Ŀǰȷ������Ϣ��
 * 1.�ָ���ʹ��|+|��ʽ
 * 2.�����Ϊ�ĸ����������ݣ����ݿ��Ӧ�ı�񣬱��ֶ��뱨���ֶε�˳��ӳ�䣬ת����
 * 3.�������ݿ���ת��Ϊ���ݿ�ֵ���в��룬���ݿ�����Ҳ����ת��Ϊ���ġ�
 * 4.�ְ���ƣ�
 * 	1.�����������
 * 	2.ӳ���ļ����
 * 	3.ת�������
 * 	4.������ȡ���ݿ�
 * 5.����������̷���
 * 	1.��ȡ����-�ӿ�
 * 	2.����Լ��Ѱ�ҵ�ӳ���ϵ����
 * 	3.�������ó�ʼ��javabean����map
 * 	4.ִ�����ݿⷽ������ֵ������С�
 * 	
 * 	���룺�������ݣ�ӳ������ID
 * 	����������ݲ������ݿ��У����ش������
 * 6.����������̷���
 * 	1.����Լ������ҵ�ӳ�����ù�ϵ��
 * 	2.�������ݲ�ѯID����sql����ҵ����ݿ��񣬲���ȡ���ݡ�
 * 	3.��������map����javabean��ͨ��ӳ�����ù�ϵ����ת��
 * 	4.��ת����Ľ��д�뱨���ļ��С�
 * 
 * 	���룺ӳ������ID����ѯ���ݵ�sql����������
 * 	�����д�뱨���ļ������ش�����
 *
 */
public class ConversionHandler extends BaseFormBean{
	private TransferHandler transferHandlerExcel;
	
	public void setTransferHandler(TransferHandler transferHandlerExcel) {
		this.transferHandlerExcel = transferHandlerExcel;
	}

	public String testThAction () throws Exception{
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		
//		String mappingConifg = "C:/work/otherSpace/eclipse2015/wmxtcms/src/main/java/app/util/message/conversion/test/mappingConfig.txt";
//		String readFilePath = "C:/work/otherSpace/eclipse2015/wmxtcms/src/main/java/app/util/message/conversion/test/testData.txt";
		String readFilePath = "C:/test/text8.xlsx";
		String writeFilePath = "C:/work/otherSpace/eclipse2015/wmxtcms/src/main/java/app/util/message/conversion/test/writeData.txt";
//		TransferHandler th = (TransferHandler) ac.getBean("transferHandler");
		transferHandlerExcel.refreshMappingConfig();
//		th.messageToData("0001",readFilePath);
//		String sql = "select id,idno,name,age,salary from TESTTH";
//		th.dataToMessage("0001", sql, writeFilePath);
//		
//		List<TestTh> testTsList = new ArrayList<TestTh>();
//		testTsList.add(new TestTh("000001","idno0001","name00001",10,10.01));
//		testTsList.add(new TestTh("000002","idno0002","name00002",11,11.01));
//		testTsList.add(new TestTh("000003","idno0003","name00003",12,12.01));
//		testTsList.add(new TestTh("000004","idno0004","name00004",13,13.01));
//		testTsList.add(new TestTh("000005","idno0005","name00005",14,14.01));
//		testTsList.add(new TestTh("000006","idno0006","name00006",15,15.01));
//		th.objectToMessage("0001", testTsList, writeFilePath);
		
		//����1000�����ݵĲ���
		long starttime = new Date().getTime();
		transferHandlerExcel.messageToDataWithValidate("0001", "102", readFilePath);
		long endtime = new Date().getTime();
		System.out.println("ִ��ʱ��Ϊ:"+(endtime - starttime)+"����");
//		System.out.println(System.getProperty("webapp.root"));
//		System.out.println(ConversionHandler.class.getClass().getResource("/"));
//		System.out.println(this.getHttpRequest().getSession().getServletContext().getRealPath(""));
		URL S =this.getClass().getResource("/");
		System.out.println(S.getPath());
		return "success";
	}
	
	public void teseExcel(String readFilePath) throws IOException{
		//����1000�����ݵĲ���
		transferHandlerExcel.refreshMappingConfig();
		long starttime = new Date().getTime();
//		transferHandlerExcel.messageToData("0001", readFilePath);
		transferHandlerExcel.dataToMessage("0001", "select * from TESTTH",readFilePath);
		long endtime = new Date().getTime();
		System.out.println("ִ��ʱ��Ϊ:"+(endtime - starttime)+"����");
	}
	
	public String testExcelTrans() throws Exception{
		String readFilePath = "C:/test/test8.xlsx";
		String writeFilePath = "C:/test/test9.xlsx";
		teseExcel(writeFilePath);
		return "success";
	}
	
	public static void main(String[] args) throws IOException {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		ConversionHandler conversionHandler = (ConversionHandler) ac.getBean("conversionHandler");
		//����1000�����ݵĲ���
		long starttime = new Date().getTime();
		String readFilePath = "C:/test/test8.xlsx";
		conversionHandler.teseExcel(readFilePath);
		long endtime = new Date().getTime();
		System.out.println("ִ��ʱ��Ϊ:"+(endtime - starttime)+"����");
	}
}
