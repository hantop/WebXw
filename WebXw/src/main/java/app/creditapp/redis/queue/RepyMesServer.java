package app.creditapp.redis.queue;

import java.util.List;

import org.apache.log4j.Logger;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.exceptions.JedisConnectionException;
import redis.clients.jedis.exceptions.JedisDataException;
import app.creditapp.ln.worker.WorkRepyMes;
import app.creditapp.redis.util.RedisUtil;
import app.util.ThreadPoolManager;

/**
 * @���� DHCC-SONG
 * @���� Jun 16, 2016
 * @����	[7����Ϣ���У���֧��ϵͳ����ͨѶ���ģ�������]
 */
public class RepyMesServer implements Runnable {
	    Logger logger = Logger.getLogger(RepyMesServer.class);
	    
		public void run() {
			Jedis jedis = RedisUtil.getThreadJedis();
			while(true){
				try {
					List<String> list = jedis.brpop(RedisUtil.BRPOP_TIMEOUT, RedisUtil.QUEUE10);
					String message = null;
					if( list != null ){
						message = list.get(1);
						if(message != null){
							WorkRepyMes msg = new WorkRepyMes(message);
							ThreadPoolManager.getInstance10().exec(msg); //  �����̳߳ؽ���ִ��
						}
					} else {
						logger.info("û�ж�����Ϣ��redis���ӽ���Ϣ"+RedisUtil.WHILE_WAIT+"���������������ȡ��Ϣ,�ܵ�����:"+RedisUtil.QUEUE10);
						Thread.sleep(RedisUtil.WHILE_WAIT);
					}
				}catch (JedisConnectionException e){
					logger.info("Redis�����쳣��������������磬ϵͳ��������...:"+RedisUtil.QUEUE10);
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
	}