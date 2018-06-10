package app.creditapp.redis.queue;

import java.util.List;
import org.apache.log4j.Logger;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.exceptions.JedisConnectionException;
import redis.clients.jedis.exceptions.JedisDataException;
import accounting.plat.PUBConstant;
import app.creditapp.ln.worker.WorkSendMsg;
import app.creditapp.redis.util.RedisUtil;
import app.util.ThreadPoolManager;

/**
 * @���� DHCC-SONG
 * @���� Jun 16, 2016
 * @����	[7����Ϣ���У���֧��ϵͳ����ͨѶ���ģ�������]
 */
public class SendMsgServer implements Runnable {
	    Logger logger = Logger.getLogger(SendMsgServer.class);
	    
		public void run() {
			Jedis jedis = RedisUtil.getThreadJedis();
			while(true){
				try {
					List<String> list = jedis.brpop(RedisUtil.BRPOP_TIMEOUT, RedisUtil.QUEUE7);
					String message = null;
					if( list != null ){
						message = list.get(1);
						if(message != null){
							WorkSendMsg msg = new WorkSendMsg(message,PUBConstant.BACK_TYPE_02);
							ThreadPoolManager.getInstance7().exec(msg); //  �����̳߳ؽ���ִ��
						}
					} else {
						logger.info("û�ж�����Ϣ��redis���ӽ���Ϣ"+RedisUtil.WHILE_WAIT+"���������������ȡ��Ϣ,�ܵ�����:"+RedisUtil.QUEUE7);
						Thread.sleep(RedisUtil.WHILE_WAIT);
					}
				}catch (JedisConnectionException e){
					logger.info("Redis�����쳣��������������磬ϵͳ��������...:"+RedisUtil.QUEUE7);
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
		public static void main(String[] args) throws Exception {
//			 Logger loggerdd = Logger.getLogger(TaskServerA.class);
			//Jedis jedis = RedisUtil.getJedis();
//			Jedis jedis = new Jedis("10.7.101.251",6379,0);
//			for(int i=0;i<10000;i++){
//				if(i%3==0){
//					Thread.sleep((i%4)*(i%2)*200);
//					loggerdd.info("д���ˡ���������");
//				}
//			    jedis.del("sendMsg");  
//				jedis.lpush("sendMsg", "DDD");// ֻд��ҵ��������
//				jedis.lpush("sendMsg", "AAA");// ֻд��ҵ��������
//				jedis.lpush("sendMsg", "BBB");// ֻд��ҵ��������
//			}
//				System.out.println("sss"+jedis.llen("sendMsg"));   
//				System.out.println(jedis.lpop("sendMsg"));   
//				List<String> list = jedis.brpop(RedisUtil.BRPOP_TIMEOUT, "sendMsg");
//				List<String> list = jedis.lrange("sendMsg", 0, -1); 
//				System.out.println("---"+list.size());
//				while(jedis.exists("sendMsg")){
//					for (String string : list) {    
//						System.out.println("==="+string);    
//					} 	
//					System.out.println(jedis.rpop("sendMsg"));
//				}
				 

//			 ResourceBundle prop = ResourceBundle.getBundle("path");
//				String pushMessageServerPath = prop.getString("pushMessageServerPath").trim();
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