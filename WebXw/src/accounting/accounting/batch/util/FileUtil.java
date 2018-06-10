package accounting.batch.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * ����������Ľ����ļ�������
 */
public class FileUtil {
	
	/**
	 * �õ��´��ļ�������
	 */
	public static BufferedReader getReader(String downFileName)throws Exception{
		File downFile = new File(downFileName);
		BufferedReader br = null;
		if(downFile.exists()){
			br = new BufferedReader(new FileReader(downFile));
		}else{
			throw new Exception("�´��ļ�������");
		}
		return br;
	}
	
	/**
	 * ���ļ���д��һ�м�¼
	 * @param upFileName �ϴ��ļ���
	 * @param str[] �ַ�������
	 * @throws Exception
	 */
	public static void write(String upFileName, String str[]) throws Exception{
		BufferedWriter bw = null;
		try{
			bw = new BufferedWriter(new FileWriter(upFileName,true));
			for(int i=0;i<str.length;i++){
				bw.write(str[i]);
				if(i<str.length-1){
					bw.write("|");
				}
			}
			bw.newLine();
			bw.flush();
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}finally{
			bw.close();
			bw = null;
		}
	}
	
	/**
	 * ���ļ���д��һ�м�¼
	 * @param bw �ļ������
	 * @param str[] �ַ�������
	 * @throws Exception
	 */
	public static void write1(BufferedWriter bw, String[] str) throws Exception{
		try{
			for(int i=0;i<str.length;i++){
				bw.write(str[i]);
				if(i<str.length-1){
					bw.write("|");
				}
			}
			bw.newLine();
			
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}finally{
			bw.flush();
		}
	}
	
	/**
	 * ͨ���ļ���,�õ��ļ������
	 * @param uploadFileName �ϴ��ļ���
	 * @return bw �ļ������
	 * @throws Exception
	 */
	public static BufferedWriter getWriter(String uploadFileName) throws Exception{
		BufferedWriter bw = null;
		try{
			bw = new BufferedWriter(new FileWriter(uploadFileName));
		}catch(Exception e){
			e.printStackTrace();
			if(bw != null){
				bw.close();
			}
			bw = null;
			throw e;
		}
		return bw;
	}
	
	public static void main(String[] args) throws Exception {
		FileUtil.write("c:\\1.txt",new String[]{"1","2","3"});
	}
}
