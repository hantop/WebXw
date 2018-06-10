package app.creditapp.inf.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.SocketException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;
import org.apache.log4j.Logger;

import app.creditapp.batch.util.FTPBean;
import app.oscache.Datadict;

public class TaskIndex extends Thread {
	public static Logger logger = Logger.getLogger(TaskIndex.class.getClass());
	private static boolean isOpen = false;// ����ftp������
	private static FTPClient ftp = null;

	@Override
	public void run() {
		logger.error("����Ӱ��outĿ¼�����ļ�����");
		// ��ȡ��Ϣ
		Datadict data = new Datadict("IMG_RELATION");
		final FTPBean ftpBean = new FTPBean();
		ftpBean.setIp(data.getDatadictByCode("ADDRESS"));
		ftpBean.setPort(Integer.parseInt(data.getDatadictByCode("PORT")));
		ftpBean.setUserName(data.getDatadictByCode("USER"));
		ftpBean.setPasswd(data.getDatadictByCode("PWD"));
		final String sourceDir = data.getDatadictByCode("SOURCEDIR");
		String outDir=data.getDatadictByCode("OUTDIR");//ǩ��outĿ¼
		final String targetDir = data.getDatadictByCode("TARGETDIR");
		if (!isOpen) {
			TaskIndex.connect(ftpBean);
		}
		if (isOpen) {
			//ȡ�ļ�����
			//1.��ȡ�����е��ļ�list
			try {
				ftp.setControlEncoding("UTF-8");
				ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
				ftp.enterLocalPassiveMode();
				FTPFile[] files=ftp.listFiles(outDir);//��outĿ¼�»�ȡ
				if (files!=null && files.length!=0) {
					//�����ļ������ƶ������ƣ����������ŵ���������expĿ¼��
					for (int i = 0; i < files.length; i++) {
						String fileName=files[i].getName();//��ȡ�ļ���
						String[]imgInfo=fileName.split("\\_");
						String brNo=imgInfo[0];
						String transNo=imgInfo[1];
						String docType=imgInfo[2];
						long time=Long.parseLong(imgInfo[3].split("\\.")[0]);
						SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
						Date d = new Date(time);
						String date=sdf.format(d);
						//��ȡ��Ҫ�Żص��ĸ�Ŀ¼��
						String finalDir = targetDir + "/" + brNo
								+ "/" + date + "/"
								+ transNo;
						//�ƶ��ļ�
						String newFileName="sign_"+fileName;
						String suffix=newFileName.replace(newFileName.substring(0,newFileName.lastIndexOf(".")), "");//��׺��
						boolean flag=ftp.rename(outDir+"/"+fileName,finalDir+"/"+newFileName);
						if (flag) {//�޸�ԭ����·��ǩ��״̬������һ��·����Ϣ
//							ImgPath imgPath=new ImgPath();
//							imgPath.setDocName(fileName);
//							imgPath.setIfSign("1");
//							ImgPathDao imgPathDao=(ImgPathDao) SourceTemplate.getSpringContextInstance().getBean("imgPathDao");
//							imgPathDao.updateIfSign(imgPath);
//							//����һ��·����Ϣ
//							ImgPath imgPath2=new ImgPath();
//							imgPath2.setBrNo(brNo);
//							imgPath2.setDocName(newFileName);
//							imgPath2.setDocPath(finalDir+"/"+newFileName);
//							imgPath2.setDocType(docType);
//							imgPath2.setFileType(suffix);
//							imgPath2.setIfSign("2");
//							imgPath2.setInTime(DateUtil.getDateTime());
//							imgPath2.setTransNo(transNo);
//							imgPathDao.insertPath(imgPath2);
							
							ByteArrayInputStream in = null;  
						    ByteArrayOutputStream fos = new ByteArrayOutputStream(); 
						    
							
							//�����ļ�����������Ŀ¼��
							ftp.setBufferSize(1024 * 2);  
					        // �������·��  
							ftp.changeWorkingDirectory(finalDir);  
					        // �����Զ��������ķ�ʽ����  
							ftp.setFileType(FTP.BINARY_FILE_TYPE);  
					        // ���ļ������ڴ���  
							ftp.retrieveFile(newFileName, fos);  
					        in = new ByteArrayInputStream(fos.toByteArray());  
					        if (in != null) {  
					        	ftp.changeWorkingDirectory(sourceDir+"/"+brNo+"/exp");  
					        	boolean a=ftp.storeFile(newFileName, in);
					        }  
						}
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		//ȡ���ļ���
		//�����ļ�����֣�Ȼ���ȡ��������Ϣ����ǩ����ɵ��ļ� �����²���
		//1.�������Żص�Ŀ���ļ���
		//2.����֮ǰ���ļ�·�����Ƿ�ǩ��״̬
		//3.����һ��ǩ����ɵ�·����Ϣ
		//4���ŵ���������Ŀ¼��
	}
	/**
	 * ����ftp������
	 */
	public static void  connect(FTPBean bean){
		logger.info("FTP ����" + bean.getIp() + " " + bean.getPort() + " " + bean.getUserName());
		try {
			ftp = new FTPClient();
			ftp.connect(bean.getIp(), bean.getPort());
			ftp.login(bean.getUserName(), bean.getPasswd());
			int reply = ftp.getReplyCode();
			if (!FTPReply.isPositiveCompletion(reply)) {
				ftp.disconnect();
				logger.error("FTP ��¼�ܾ�");
				isOpen=false;
			} else {
				isOpen = true;
				//ftp.changeWorkingDirectory(bean.getReomtePath());
				ftp.setControlEncoding("GBK");
				ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
				logger.info("FTP ��¼�ɹ�");
				isOpen=true;
			}
		} catch (SocketException e) {
			logger.error("����FTPʧ��.");
			isOpen = false;
			e.printStackTrace();
		}catch (IOException ioe) {
			ioe.printStackTrace();
			logger.error("FTP ����ʧ��" + ioe.getMessage());
			isOpen=false;
		}
	} 

}
