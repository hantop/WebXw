package app.creditapp.acc.init;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import accounting.plat.core.init.BusinessInitializer;

public class AccountingInitServlet extends HttpServlet {

	
	public void init() throws ServletException {
		BusinessInitializer buz = new BusinessInitializer();
		try {
			System.out.println("����ϵͳ��ʼ��.............");
			buz.initialize();
			System.out.println("����ϵͳ��ʼ���ɹ�");
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("����ϵͳ��ʼ��ʧ��");
		}
		
	}

}
