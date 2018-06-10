package app.creditapp.redis.daemon;

import java.util.Vector;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;

import app.creditapp.redis.util.RedisUtil;


public class ThreadDaemon implements Runnable {
	Logger logger = Logger.getLogger(ThreadDaemon.class);
	@Override
	public void run() {
		while(true){
			Vector<ThreadBean> tlist = ThreadFactory.tlist;
			if(tlist.size()==0){return;}
			for(int i=0; i<tlist.size(); i++){
				ThreadBean tb = tlist.get(i);
				if(!tb.getThread().isAlive()){
                    logger.error("***************�̣߳�"+tb.getThread().getId()+":"+tb.getThreadDesc()+"�������У�");
					ThreadBean ttb = ThreadFactory.create(tb.getRun());
					tlist.set(i, ttb);
					ttb.getThread().start();
				}
			}
			try {
	            TimeUnit.SECONDS.sleep(RedisUtil.CHECK_TIME); // 200����һ��
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	        logger.error("�ػ��̼߳��ҵ��ڵ�����߳���ɣ��߳�������"+tlist.size()+"��");
//	        System.out.println("�߳�������"+tlist.size()+"��");
//	        for(ThreadBean tb : tlist)
//	        	System.out.println("�߳�id��"+tb.getThread().getId());
		}
	}
}
