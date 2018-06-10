package accounting.plat.core.init;

import java.sql.Connection;

import accounting.plat.core.OperationFactory;
import app.util.DBUtils;


/**
 * ƽ̨��ʼ��������Ϣ������
 * 
 */
public class BusinessInitializer {
	 public void initialize()throws Exception {
		//��ʼ��
		 OperationFactory.init();
		 Connection connection = DBUtils.getConn();
	  
	   SetSysInfo.init(connection);
	   connection.close();
	 }
	 public void initForOpMain() throws Exception {
		//��ʼ��
		 OperationFactory.init();
		 Connection connection = null;
		 try {
			 connection = DBUtils.getConn();
		} catch (Exception e) {
			e.printStackTrace() ;
		}
		 SetSysInfo.init(connection);
		   connection.close();
	 }
		
}
