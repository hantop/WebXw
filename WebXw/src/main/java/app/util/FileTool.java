package app.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

public class FileTool {
	/**
	 * Description: ��FTP�������ϴ��ļ�
	 * @Version      1.0
	 * @param url FTP������hostname
	 * @param port  FTP�������˿�
	 * @param username FTP��¼�˺�
	 * @param password  FTP��¼����
	 * @param path  FTP����������Ŀ¼
	 * @param filename  �ϴ���FTP�������ϵ��ļ���
	 * @param input   ������
	 * @return �ɹ�����true�����򷵻�false *
	 */
	public static boolean uploadFile(String url,// FTP������hostname
			int port,// FTP�������˿�
			String username, // FTP��¼�˺�
			String password, // FTP��¼����
			String path, // FTP����������Ŀ¼
			String filename, // �ϴ���FTP�������ϵ��ļ���
			InputStream input // ������
	){
		boolean success = false;
		FTPClient ftp = new FTPClient();
		ftp.setControlEncoding("GBK");
		try {
			int reply;
			ftp.connect(url, port);// ����FTP������
			// �������Ĭ�϶˿ڣ�����ʹ��ftp.connect(url)�ķ�ʽֱ������FTP������
			ftp.login(username, password);// ��¼
			reply = ftp.getReplyCode();
			if (!FTPReply.isPositiveCompletion(reply)) {
				ftp.disconnect();
				return success;
			}
			ftp.setBufferSize(6020);
			ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
			ftp.makeDirectory(path);
			ftp.changeWorkingDirectory(path);
			ftp.storeFile(filename, input);
			input.close();
			ftp.logout();
			success = true;
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (ftp.isConnected()) {
				try {
					ftp.disconnect();
				} catch (IOException ioe) {
				}
			}
		}
		return success;
	}
	/**
	 * �������ļ��ϴ���FTP�������� *
	 */
	public static boolean upLoadFromProduction(String url,// FTP������hostname
			int port,// FTP�������˿�
			String username, // FTP��¼�˺�
			String password, // FTP��¼����
			String path, // FTP����������Ŀ¼
			String filename, // �ϴ���FTP�������ϵ��ļ���
//			String orginfilename // �������ļ���
			FileInputStream fileInputStream
	   ) {
		boolean flag = false;
		try {
//			FileInputStream in = new FileInputStream(new File(orginfilename));
			flag = uploadFile(url, port, username, password, path,filename, fileInputStream);
//			System.out.println(flag);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
     //����
//	public static void main(String[] args) {
//		upLoadFromProduction("10.7.53.30", 21, "MFS", "RsKBnHlj", "/PUB/knowledge", "hanshibo.doc", "C:/Users/Administrator/Desktop/Ӱ��װ��IE�����ֲ�.docx");
//		System.exit(0);
//	}
}