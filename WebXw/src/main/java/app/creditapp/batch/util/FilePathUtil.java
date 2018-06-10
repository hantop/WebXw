package app.creditapp.batch.util;

import java.io.IOException;
import java.util.Properties;

public class FilePathUtil {
	
		private static Properties pathProperties;
		
		static {
			 pathProperties = new Properties();
			try {
				pathProperties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("path.properties"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		//�����ڵ���õ�shell·��
		public static String getShellPath(){
			return pathProperties.getProperty("shellPath");
		}
		
		//��ȡ�����ļ�����·��
		public static String getdataFileBakPath(){
			return pathProperties.getProperty("dataFileBakPath");
		}
		
}
