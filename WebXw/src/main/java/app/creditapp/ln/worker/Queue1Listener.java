package app.creditapp.ln.worker;

import org.apache.log4j.Logger;

import redis.clients.jedis.JedisPubSub;

/**
 * @���� DHCC-SONG
 * @���� Jun 6, 2016
 * @���� 1����Ϣ���У���У���ɸ����У�������--����
 */
public class Queue1Listener extends JedisPubSub{
	Logger logger = Logger.getLogger(Queue1Listener.class);
	public int i = 0;
	public int j = 0;
	// ȡ�ö��ĵ���Ϣ��Ĵ���
	@Override
	 public void onMessage(String channel, String message) {
		try {
//			Message m = (Message) JsonUtil.getObject4JsonString(message, Message.class);
//			WorkAforValidate workerA = new WorkAforValidate(m);
//			int num = ThreadPoolManager.getInstance1().execute(workerA);
//			while (true) {
//				if (num == -1) {
//					logger.info("�߳�æ���Ե�2����");
//					Thread.sleep(2000);
//					num = ThreadPoolManager.getInstance1().execute(workerA);
//				} else if (num > 0) {
//					logger.info("����[" + m.getId() + "]�����Ŷ���:" + num);
//					break;
//				} else {
//					logger.info("����[" + m.getId() + "]��ʼִ��");
//					break;
//				}
//			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	 }

	 // ��ʼ������ʱ��Ĵ���
	@Override
	 public void onSubscribe(String channel, int subscribedChannels) {
	   System.out.println(channel + "=" + subscribedChannels+"���м����ɹ�....");
	 }

	 // ȡ������ʱ��Ĵ���
	@Override
	 public void onUnsubscribe(String channel, int subscribedChannels) {
	   System.out.println(channel + "=" + subscribedChannels+"#########");
	 }

	 // ��ʼ�������ʽ�ķ�ʽ����ʱ��Ĵ���
	@Override
	 public void onPSubscribe(String pattern, int subscribedChannels) {
	   System.out.println(pattern + "=" + subscribedChannels+"���ж��ĳɹ�");
	 }

	 // ȡ�������ʽ�ķ�ʽ����ʱ��Ĵ���
	@Override
	 public void onPUnsubscribe(String pattern, int subscribedChannels) {
	   System.out.println(pattern + "=" + subscribedChannels+"@@@@@@@@@");
	 }

	 // ȡ�ð����ʽ�ķ�ʽ���ĵ���Ϣ��Ĵ���
	@Override
	 public void onPMessage(String pattern, String channel, String message) {
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(pattern + "=" + channel + "=" + message);
		
//		if (pattern.equals("hello_*")) {
//			++i;
//			new Thread(new Runnable() {
//				public void run() {
//				     try {
//				    	 if(i==3){
//				    		 Thread.currentThread().sleep(2000);
//				    		 System.out.println("����2000M");
//				    	 }
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
//					System.out.println("hello_*" + "�߼�����");
//				}
//			}).start();
//		}
//		if (pattern.equals("hi_*")) {
//			++j;
//			new Thread(new Runnable() {
//				public void run() {
//					System.out.println("hi_*" + "�߼�����");
//				}
//			}).start();
//		}
//		System.out.println(i+"~~~"+j);
	}


}
