package app.creditapp.redis.queue;

import java.util.List;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.exceptions.JedisConnectionException;
import redis.clients.jedis.exceptions.JedisDataException;
import app.creditapp.ln.entity.LnApplyMid;
import app.creditapp.ln.worker.WorkAforValidate;
import app.creditapp.redis.util.RedisUtil;
import app.util.ThreadPoolManager;

import com.alibaba.fastjson.JSON;

/**
 * @���� DHCC-SONG
 * @���� Jun 16, 2016
 * @���� �����������A [1����Ϣ���У�����֤���������У�������]
 */
public class TaskServerA implements Runnable {
	    Logger logger = Logger.getLogger(TaskServerA.class);
	    
		public void run() {
			Jedis jedis = RedisUtil.getThreadJedis();
			while(true){
				try {
	//				System.out.println("����"+channel+"����len-->"+jedis.llen(channel));
					List<String> list = jedis.brpop(RedisUtil.BRPOP_TIMEOUT, RedisUtil.QUEUE1);
					String message = null;
					if( list != null ){
						message = list.get(1);
						if(message != null){
							LnApplyMid lnApplyMid = (LnApplyMid)JSON.parseObject(message, LnApplyMid.class);
							WorkAforValidate workerA = new WorkAforValidate(lnApplyMid);
							ThreadPoolManager.getInstance1().exec(workerA); //  �����̳߳ؽ���ִ��
						}
					} else {
						logger.info("û�ж�����Ϣ��redis���ӽ���Ϣ"+RedisUtil.WHILE_WAIT+"���������������ȡ��Ϣ,�ܵ�����:"+RedisUtil.QUEUE1);
						Thread.sleep(RedisUtil.WHILE_WAIT);
					}
				}catch (JedisConnectionException e){
					//e.printStackTrace();
					logger.info("Redis�����쳣��������������磬ϵͳ��������...:"+RedisUtil.QUEUE1);
					try {
						Thread.sleep(RedisUtil.WHILE_WAIT);
						jedis = RedisUtil.getThreadJedis();  // ���½�������
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				} catch (JedisDataException de) {
					try {
						Thread.sleep(RedisUtil.WHILE_WAIT);
					} catch (Exception e) {
						e.printStackTrace();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		public String toString(){
			return "TaskServerA";
		}
	
		public static void main(String[] args) throws Exception {
			 Logger loggerdd = Logger.getLogger(TaskServerA.class);
			//Jedis jedis = RedisUtil.getJedis();
			Jedis jedis = new Jedis("10.7.101.38",6379,0);
//			for(int i=0;i<10000;i++){
//				if(i%3==0){
//					Thread.sleep((i%4)*(i%2)*200);
//					loggerdd.info("д���ˡ���������");
//				}
				jedis.lpush("songqishuai1", "DDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD");// ֻд��ҵ��������
//			}
			 
			 ResourceBundle prop = ResourceBundle.getBundle("path");
				String pushMessageServerPath = prop.getString("pushMessageServerPath").trim();
//			
//			Message m = null;
//			try {
//				while(true){
//					//System.out.println("len-->"+jedis.llen("xiaosong1"));
//					System.out.println("message-->" + jedis.brpop(0, "wangtao1").get(1));
//				}
//	        } catch (Exception e) {
//	            e.printStackTrace();
//	        }
		}
	}