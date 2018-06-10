package app.util;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import app.base.SourceTemplate;
import app.oscache.BaseCache;
import app.oscache.MBaseCache;


public class CacheInitServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CacheInitServlet() {
	}

	public void init(ServletConfig servletconfig) throws ServletException {
		super.init(servletconfig);
		ApplicationContext applicationContext = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
		SourceTemplate.setContext(applicationContext);
		try {
			System.out.println("****************��ʼ���������ֵ� ***************");
			BaseCache bc = MBaseCache.getCache();
			bc.initCache();
			System.out.println("****************���� ***************");
			
			System.out.println("************��ʼ��ʼ��ϵͳ״̬**************");
			bc.initSystemStatus();
//			bc.initHoliday();
			System.out.println("****************���� ***************");
			
			//System.out.println("************��ʼ��ʼ��������Ա**************");
			//bc.initApprover();
			//System.out.println("****************���� ***************");
			
			System.out.println("************��ʼ���ذ�ťȨ��**************");
			bc.initButton();
			System.out.println("****************���� ***************");
			
			System.out.println("**************��ʼ���ذ�ȫ���**************");
			bc.initSecurity();
			System.out.println("****************���� ***************");
			
			System.out.println("**************����REQUIRE_LOG_TABLE**************");
			//bc.initRequireLogTable();
			System.out.println("****************���� ***************");
		} catch (Exception w) {
			w.printStackTrace();
			System.out.println("CACHE-INIT----�����ֵ���ص��������");
			throw new ServletException("Unable to open datasource.");
		}
	}
}