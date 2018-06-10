package app.creditapp.redis.queue;

import redis.clients.jedis.Jedis;
import app.creditapp.ln.entity.Message;
import app.creditapp.ln.worker.Queue1Listener;
import app.creditapp.redis.util.RedisUtil;

/**
 * ������Ϣ����
 */
public class TaskServerTest implements Runnable{
	public void run() {
		Jedis jedis = RedisUtil.getJedis();
		final Queue1Listener listener = new Queue1Listener();
		//���Զ��Ķ��Ƶ��  
		//���ĵõ���Ϣ��lister��onMessage(...)�����н��д���  
		//jedis.subscribe(listener, "foo", "watson");  
		jedis.subscribe(listener, "xiaosong");
		//Ҳ������ķ�ʽ���ö��Ƶ��  
		//jedis.subscribe(listener, new String[]{"hello_foo","hello_test"});  
		  
		//���������˶��ļ������߳̽������ﱻ����  
		//���ĵõ���Ϣ��lister��onPMessage(...)�����н��д���  
		//jedis.psubscribe(listener, new String[]{"hello_*"});//ʹ��ģʽƥ��ķ�ʽ����Ƶ��  
	}
	
	public static void main(String[] args) throws Exception {
		Jedis jedis = RedisUtil.getJedis();
		//Jedis jedis = new Jedis("10.7.101.38",6379);
		Message m = null;
		try {
			for(int i = 1;i<=10;i++){
				m = new Message();
				m.setId(i);
				m.setContent("����JEDIS"+i);
				//new String(SerializeUtil.serialize(m));
				//jedis.publish("queue1","����JEDIS"+i);
				//jedis.publish("xiaosong1",JsonUtil.getJsonString4JavaPOJO(m));
				jedis.lpush("xiaosong1", "fgdgfdasfdsfdas");
				System.out.println(i+"��Ϣ�Ѿ�����");
			}
        } catch (Exception e) {
            e.printStackTrace();
        }
		
	}
}
