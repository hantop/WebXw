package app.creditapp.redis.queue;

import java.util.List;

import org.apache.log4j.Logger;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.exceptions.JedisConnectionException;
import redis.clients.jedis.exceptions.JedisDataException;
import app.creditapp.ln.entity.LnDue;
import app.creditapp.ln.worker.WorkFforAcc;
import app.creditapp.redis.util.RedisUtil;
import app.util.ThreadPoolManager;

import com.alibaba.fastjson.JSON;

/**
 * @���� DHCC-SONG
 * @���� Jun 16, 2016
 * @���� �����������F [6����Ϣ���У������˴���������]
 */
public class TaskServerF implements Runnable {
	Logger logger = Logger.getLogger(TaskServerF.class);

	public void run() {
		Jedis jedis = RedisUtil.getThreadJedis();
		while (true) {
			try {
				List<String> list = jedis.brpop(RedisUtil.BRPOP_TIMEOUT, RedisUtil.QUEUE6);
				String message = null;
				if (list != null) {
					message = list.get(1);
					if (message != null) {
						LnDue lnDue = (LnDue) JSON.parseObject(message, LnDue.class);
						WorkFforAcc workerF = new WorkFforAcc(lnDue);
						ThreadPoolManager.getInstance6().exec(workerF); // �����̳߳ؽ���ִ��
					}
				} else {
					logger.info("û�ж�����Ϣ��redis���ӽ���Ϣ" + RedisUtil.WHILE_WAIT + "���������������ȡ��Ϣ,�ܵ�����:" + RedisUtil.QUEUE6);
					Thread.sleep(RedisUtil.WHILE_WAIT);
				}
			} catch (JedisConnectionException e) {
				// e.printStackTrace();
				logger.info("Redis�����쳣��������������磬ϵͳ��������...:" + RedisUtil.QUEUE6);
				try {
					Thread.sleep(RedisUtil.WHILE_WAIT);
					if(jedis!=null){
						jedis.close();
					}
					jedis = RedisUtil.getThreadJedis(); // ���½�������
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

	public String toString() {
		return "TaskServerF";
	}
}