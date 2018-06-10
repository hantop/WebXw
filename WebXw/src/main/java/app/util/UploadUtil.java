package app.util;

import java.io.File;
import java.io.FileInputStream;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
import app.oscache.MBaseCache;

public class UploadUtil {
	/*
	 * ·��ת�� 
	 */
	public static String getPath(String path){
		String path1=path.replace("\\", "/");
		return path1;
	}
	/*
	 * @parm �ļ�·��
	 * ȡ���ļ���С
	 */
	public static int getSize(String relpath){
		File file=new File(relpath);
         double l=file.length();
		int size=(int)(l/1024);
		return size;
	}
	/*
	 * �ļ�ɾ��
	 */
	public static void delete(String relpath){
		File file=new File(relpath);
		Boolean boolean1=file.delete();
		if (boolean1) {
			System.out.println("=====�ļ�ɾ���ɹ�");
		}
		
	}
	
	/**
	 * ������������ȡUUIDΨһ��ʶ
	 * @return
	 */
	public static String getUUIDNo(){
		return java.util.UUID.randomUUID().toString();
	}
	
	/**
	 * ��������������ת��λ����ƴ����Ӣ���ַ�����
	 * @param chines ����
	 * @return pinyinName ƴ��
	 */
	public static String converterToSpell(String chines) {
		String pinyinName = "";
		char[] nameChar = chines.toCharArray();
		HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
		defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
		defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
		for (int i = 0; i < nameChar.length; i++) {
			if (nameChar[i] > 128) {
				try {
					pinyinName += PinyinHelper.toHanyuPinyinStringArray(
							nameChar[i], defaultFormat)[0];
				} catch (BadHanyuPinyinOutputFormatCombination e) {
					e.printStackTrace();
				}
			} else {
				pinyinName += nameChar[i];
			}
		}
		return pinyinName;
	}
	
	/**
	 * @����˵��: �ļ�����
	 * @param path
	 *            ·��
	 * @param fileName
	 *            �ļ�����
	 * @return File
	 * @�޸�˵��:
	 */
	public static File createFile(String path, String fileName) {
		String[] pathArray = path.split("/");
		StringBuilder tempPath = new StringBuilder();
		if(path.startsWith("/")){
			tempPath.append("/");
		}
		for (int i = 0; i < pathArray.length; i++) {
			if(null==pathArray[i] || "".equals(pathArray[i])){
				continue;
			}
			tempPath.append(pathArray[i]+"/");
			File f = new File(tempPath.toString());
			if (!f.exists())
				f.mkdir();
		}
		File target = new File(path, fileName);
		return target;
	}
	

	/**
	 * @����˵��: ��ȡ�ļ���С
	 * @param file
	 * @throws Exception
	 * @return long
	 * @�޸�˵��:
	 */
	public static long getFileSizes(File file) throws Exception // ȡ���ļ���С
	{
		long s = 0;
		if (file.exists()) {
			FileInputStream fis = null;
			try {
				fis = new FileInputStream(file);
				s = fis.available();
			} catch (Exception e) {
				throw new Exception(e.getMessage());
			}
		}
		return s;
	}
	
	public static String getParm(String key) // ��ȡ����
	{
		return MBaseCache.getCache().getUploadParm().get(key).trim();
	}

}
