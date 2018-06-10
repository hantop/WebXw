package app.creditapp.redis.queue;

import java.util.List;

import org.apache.log4j.Logger;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.exceptions.JedisConnectionException;
import redis.clients.jedis.exceptions.JedisDataException;
import app.creditapp.inf.entity.WsIn2001;
import app.creditapp.ln.worker.WorkPforPreScree;
import app.creditapp.redis.util.RedisUtil;
import app.util.ThreadPoolManager;

import com.alibaba.fastjson.JSON;

/**
 * @���� DHCC-SONG
 * @���� Jun 16, 2016
 * @���� �����������A [1����Ϣ���У�����֤���������У�������]
 */
public class TaskServerP implements Runnable {
	    Logger logger = Logger.getLogger(TaskServerP.class);
	    
		public void run() {
			Jedis jedis = RedisUtil.getThreadJedis();
			while(true){
				try {
	//				System.out.println("����"+channel+"����len-->"+jedis.llen(channel));
					List<String> list = jedis.brpop(RedisUtil.BRPOP_TIMEOUT, RedisUtil.QUEUE0);
					String message = null;
					if( list != null ){
						message = list.get(1);
						if(message != null){
//							String batchNo = (WsIn2001)JSON.parseObject(message, WsIn2001.class);
							WorkPforPreScree workerP = new WorkPforPreScree(message);
							ThreadPoolManager.getInstance1().exec(workerP); //  �����̳߳ؽ���ִ��
						}
					} else {
						logger.info("û�ж�����Ϣ��redis���ӽ���Ϣ"+RedisUtil.WHILE_WAIT+"���������������ȡ��Ϣ,�ܵ�����:"+RedisUtil.QUEUE0);
						Thread.sleep(RedisUtil.WHILE_WAIT);
					}
				}catch (JedisConnectionException e){
					//e.printStackTrace();
					logger.info("Redis�����쳣��������������磬ϵͳ��������...:"+RedisUtil.QUEUE0);
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
			return "TaskServerP";
		}
	}