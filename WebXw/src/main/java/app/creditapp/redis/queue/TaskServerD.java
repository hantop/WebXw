package app.creditapp.redis.queue;

import java.util.List;

import org.apache.log4j.Logger;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.exceptions.JedisConnectionException;
import redis.clients.jedis.exceptions.JedisDataException;
import app.creditapp.ln.entity.LnApplyMid;
import app.creditapp.ln.worker.WorkDforPact;
import app.creditapp.redis.util.RedisUtil;
import app.util.ThreadPoolManager;

import com.alibaba.fastjson.JSON;

/**
 * @���� DHCC-SONG
 * @���� Jun 16, 2016
 * @���� �����������D [4����Ϣ���У������ɺ�ͬ��������]
 */
public class TaskServerD implements Runnable {
	    Logger logger = Logger.getLogger(TaskServerD.class);
	    
		public void run() {
			Jedis jedis = RedisUtil.getThreadJedis();
			while(true){
				try {
					
					List<String> list = jedis.brpop(RedisUtil.BRPOP_TIMEOUT, RedisUtil.QUEUE4);
					String message = null;
					if( list != null ){
						message = list.get(1);
						if(message != null){
							LnApplyMid lnApplyMid = (LnApplyMid)JSON.parseObject(message, LnApplyMid.class);
							WorkDforPact workerD = new WorkDforPact(lnApplyMid);
							ThreadPoolManager.getInstance4().exec(workerD); // �����̳߳ؽ���ִ��
						}
					} else {
						logger.info("û�ж�����Ϣ��redis���ӽ���Ϣ"+RedisUtil.WHILE_WAIT+"���������������ȡ��Ϣ,�ܵ�����:"+RedisUtil.QUEUE4);
						Thread.sleep(RedisUtil.WHILE_WAIT);
					}
				}catch (JedisConnectionException e){
					//e.printStackTrace();
					logger.info("Redis�����쳣��������������磬ϵͳ��������...:"+RedisUtil.QUEUE4);
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
			return "TaskServerD";
		}
	}