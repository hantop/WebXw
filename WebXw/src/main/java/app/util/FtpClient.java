package app.util;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

import freemarker.core.Environment;

/**�������� 20160525 ������
 * 1.����������κţ������¼��
 * 2.��������
 * 3.�����ñ���FTP������������url�Ϳͻ��Ź���������
 * 4.�������������ݱ���
 * 5.���ɹ���ģ��
 * 6.�ϴ�����ģ����FTP������
 */

public class FtpClient {
	private FTPClient ftp;
	public boolean connect(String path, String addr, int port, String username, String password) {
		try {
			ftp = new FTPClient();
			ftp.setControlEncoding("GBK"); 
			int reply;
			ftp.connect(addr);
			System.out.println("���ӵ���" + addr + ":" + port);
			reply = ftp.getReplyCode();

			if (!FTPReply.isPositiveCompletion(reply)) {
				ftp.disconnect();
				System.err.println("FTPĿ������������ܾ�.");
				System.exit(1);
				return false;
			}else{
				ftp.login(username, password);
				ftp.enterLocalPassiveMode();
				ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
				ftp.changeWorkingDirectory(path);
				System.out.println("�����ӣ�" + addr + ":" + port);
				return true;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println(ex.getMessage());
			return false;
		}
	}
//Ȼ��������ftpclient��makeDirectory���������ļ���
	public void createDir(String username, String password,String dirname,String filename, String pc){
		try{
			boolean lool = ftp.makeDirectory(dirname);
			if(lool){
				System.out.println("��Ŀ��������ϳɹ��������ļ���: " + dirname);//   ���������õ�Ŀ¼�д����ļ���д�ļ�
				ftp.changeWorkingDirectory(dirname);
				writeFile(filename,pc);
			}else{
				ftp.changeWorkingDirectory(dirname);
				writeFile(filename,pc);
			}
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	}
//�Ͽ�host����
	public void disconnect(){
		try {
			ftp.disconnect();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//�����ļ�
	public static boolean createFile() throws IOException {
		boolean bl = false;
		File file = new File("test.txt");//����һ���ļ�
		if(!file.exists())
			bl = file.createNewFile();//����true����false�жϸ��ļ��Ƿ��Ѿ�������
		return bl;
	}
	
	//д���ļ�
	public void writeFile(String filename, String pc) {
		InputStream is = null;
//		String utf8 = new String(pc.getBytes(), "utf-8"); 
		
//		try {
//			is = new ByteArrayInputStream(pc.toString().getBytes("utf-8"));
//		} catch (UnsupportedEncodingException e1) {
//			e1.printStackTrace();
//		}
        try {
        	is = new ByteArrayInputStream(pc.getBytes("GBK"));  
			ftp.setFileType(FTPClient.BINARY_FILE_TYPE);  
			ftp.storeFile(new String(filename.getBytes("GBK"),"iso-8859-1"), is);
//			ftp.storeFile(new String(filename.getBytes("GBK"),"utf-8"), is);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

//����ǳ���ĵ��÷���
	public boolean ftpFile(String fileName,String batchNo,String pcrpcontext) {
		/*********FTP��ʼ*********/     
		String url = "10.7.53.30";
		int port = 21;
//		ftp = new FTPClient();
//		ftp.setControlEncoding("GBK"); 
		String username = "itp";
		String password = "su7U2yru";
		String filename = fileName;
		String pc = pcrpcontext;
		Properties pathProperties = new Properties();
		boolean bool = false;
		try { 
			pathProperties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("path.properties"));		 
			String path =pathProperties.getProperty("htmlPath")+File.separator+new SimpleDateFormat("yyyyMMdd").format(new Date())+File.separator+batchNo;
//		String path = File.separator+"PUB"+File.separator+batchNo+File.separator+ new SimpleDateFormat("yyyyMMdd").format(new Date());
			this.connect(path, url, port, username, password);
			ftp.enterLocalPassiveMode();
			ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
			ftp.changeWorkingDirectory(path);
			this.createDir(username, password,path,filename, pc);
			bool = true;
		} catch (RuntimeException e) {
			bool = false;
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if (ftp != null && !ftp.isConnected()) {
				try {
					ftp.logout(); 
					ftp.disconnect();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
		}
        return bool;
		/**************FTP����***************/
	}
	
	public void createDir1(String username, String password,String dirname,String filename, String pc){
		try{
			boolean lool = ftp.makeDirectory(dirname);
			if(lool){
				System.out.println("��Ŀ��������ϳɹ��������ļ���: " + dirname);//   ���������õ�Ŀ¼�д����ļ���д�ļ�
				ftp.changeWorkingDirectory(dirname);
				writeFile(filename,pc);
			}else{
				ftp.changeWorkingDirectory(dirname);
				writeFile(filename,pc);
			}
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	}
	
	public boolean saveFile(String fileName,String batchNo,String pcrpcontext) throws IOException{
		Properties pathProperties = new Properties();
		pathProperties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("path.properties"));		 
		String path =File.separator+pathProperties.getProperty("htmlPath")+File.separator+new SimpleDateFormat("yyyyMMdd").format(new Date())+File.separator+batchNo;
		String crp_report_filepath = path+File.separator+fileName; 
		boolean bool = false;

		File file =new File(path);  
		File file1 = new File(crp_report_filepath);
		try {  
			//����ļ��в������򴴽�    
			if(!file.exists() && !file.isDirectory()){
			    file.mkdirs();    
			}
			if(!file1.exists()){
				file1.createNewFile();
			}
			OutputStreamWriter write = new OutputStreamWriter(new FileOutputStream(file1),"GBK");
            BufferedWriter bufferWritter = new BufferedWriter(write);
            bufferWritter.write(pcrpcontext);
            if (bufferWritter != null) {
				bufferWritter.flush();
				write.close();
				bufferWritter.close();
			}
			bool = true;
		} catch (RuntimeException e) {
			bool = false;
			e.printStackTrace();
		} catch (IOException e) {
			bool = false;
			e.printStackTrace();
		}
        return bool;
	}
	
	public boolean saveFile2(String fileName,String batchNo,String pcrpcontext) throws IOException{
		Properties pathProperties = new Properties();
		pathProperties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("path.properties"));		 
		String path =pathProperties.getProperty("htmlPath")+File.separator+new SimpleDateFormat("yyyyMMdd").format(new Date())+File.separator+batchNo;
		String crp_report_filepath = path+File.separator+fileName; 
		boolean bool = false;

		System.out.println("pcrpcontext==>"+pcrpcontext);
		System.out.println("path:haha==>"+path);
		System.out.println("crp_report_filepath:haha==>"+crp_report_filepath);
		
		File file = new File(crp_report_filepath);
		if (!file.getParentFile().exists()) {
		    file.getParentFile().mkdirs();
		}
		try {
		    file.createNewFile();
		} catch (IOException e) {
		    e.printStackTrace();
		}

		try {
			FileWriter fw = new FileWriter(file, true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(pcrpcontext);
			bw.flush();
			bw.close();
			fw.close();
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
        return bool;
	}
	
	public boolean saveFile3(String fileName,String batchNo,String pcrpcontext) throws IOException{
		Properties pathProperties = new Properties();
		pathProperties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("path.properties"));		 
		String path =pathProperties.getProperty("htmlPath")+File.separator+new SimpleDateFormat("yyyyMMdd").format(new Date())+File.separator+batchNo;
		String crp_report_filepath = path+File.separator+fileName; 
		boolean bool = false;
        FileWriter fw = null;   
		
		File file = new File(crp_report_filepath);
		if (!file.getParentFile().exists()) {
		    file.getParentFile().mkdirs();
		    bool = true;
		}else{
			bool = false;
		}
		if(!file.exists()){
			fw = new FileWriter(crp_report_filepath); 
			bool = true;
		}else{
			bool = false;
		}
		try {
//			Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName),"GBK"));
//			writer.write(pcrpcontext);
			
			fw.write(pcrpcontext);
			
//			OutputStreamWriter write = new OutputStreamWriter(new FileOutputStream(fileName),"GBK");
//			BufferedWriter bufferWritter = new BufferedWriter(write);
//            bufferWritter.write(pcrpcontext);
//			write.write(pcrpcontext);
			fw.close(); 
//			if (bufferWritter != null) {
//				bufferWritter.flush();
//				write.close();
//				bufferWritter.close();
//			}
		} catch (IOException e) {
		    e.printStackTrace();
		    bool = false;
		}
        return bool;
	}
}
