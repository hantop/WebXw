package app.creditapp.inf.utils;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
/**
 * Ӱ���out��ȡ�ļ�����
 *
 */
public class ImgListener implements ServletContextListener {
	TaskIndex taskIndex=null;
	private ScheduledExecutorService	scheduExec=Executors.newScheduledThreadPool(2);
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		/*if (taskIndex!=null){
			taskIndex.interrupt();
			taskIndex.stop();
        }*/

	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		//Datadict data = new Datadict("IMG_RELATION");
		//int second=Integer.parseInt(data.new Datadict("IMG_RELATION"));//�����ѯһ��
		//int start=Integer.parseInt(data.getDatadictByCode("START"));//�����ѯһ��
		//scheduExec.scheduleAtFixedRate(new TaskIndex(),60000, 300000, TimeUnit.MILLISECONDS);
		
		//����һ�������ljx ע�͵��� ����out �ļ� ����
	//	scheduExec.scheduleAtFixedRate(new TaskIndex(),120000, 300000, TimeUnit.MILLISECONDS);
	}

}
