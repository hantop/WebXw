package app.creditapp.redis.queue;

import java.util.List;

import org.apache.log4j.Logger;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.exceptions.JedisConnectionException;
import redis.clients.jedis.exceptions.JedisDataException;
import app.creditapp.ln.worker.WorkEforDue;
import app.creditapp.pact.entity.LnPact;
import app.creditapp.redis.util.RedisUtil;
import app.util.ThreadPoolManager;

import com.alibaba.fastjson.JSON;

/**
 * @���� DHCC-SONG
 * @���� Jun 16, 2016
 * @���� �����������E [5����Ϣ���У������˴���������]
 */
public class TaskServerE implements Runnable {
	    Logger logger = Logger.getLogger(TaskServerE.class);
	    
		public void run() {
			Jedis jedis = RedisUtil.getThreadJedis();
			while(true){
				try {
					
					List<String> list = jedis.brpop(RedisUtil.BRPOP_TIMEOUT, RedisUtil.QUEUE5);
					String message = null;
					if( list != null ){
						message = list.get(1);
						if(message != null){
							LnPact lnPact = (LnPact)JSON.parseObject(message, LnPact.class);
							WorkEforDue workerE = new WorkEforDue(lnPact);
							ThreadPoolManager.getInstance5().exec(workerE); // �����̳߳ؽ���ִ��
						}
					} else {
						logger.info("û�ж�����Ϣ��redis���ӽ���Ϣ"+RedisUtil.WHILE_WAIT+"���������������ȡ��Ϣ,�ܵ�����:"+RedisUtil.QUEUE5);
						Thread.sleep(RedisUtil.WHILE_WAIT);
					}
				}catch (JedisConnectionException e){
					//e.printStackTrace();
					logger.info("Redis�����쳣��������������磬ϵͳ��������...:"+RedisUtil.QUEUE5);
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
			return "TaskServerE";
		}
	}