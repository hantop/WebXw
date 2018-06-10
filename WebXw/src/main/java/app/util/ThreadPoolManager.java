package app.util;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;

/*
 * �̹߳�����
 */
public class ThreadPoolManager {
	private static final Logger logger = Logger.getLogger(ThreadPoolManager.class);
	private ThreadPoolExecutor executor = null;
	private int maxThread = 0; // ����̳߳ش�С
	
	private static ThreadPoolManager instance0 = null; // 0���̳߳�
	private static ThreadPoolManager instance1 = null; // 1���̳߳�
	private static ThreadPoolManager instance2 = null; // 2���̳߳�
	private static ThreadPoolManager instance3 = null; // 3���̳߳�
	private static ThreadPoolManager instance4 = null; // 4���̳߳�
	private static ThreadPoolManager instance5 = null; // 5���̳߳�
	private static ThreadPoolManager instance6 = null; // 6���̳߳�
	private static ThreadPoolManager instance7 = null; // 6���̳߳�
	private static ThreadPoolManager instance8 = null; // 6���̳߳�
	private static ThreadPoolManager instance10 = null; // 6���̳߳�
	private static ThreadPoolManager pubInstance = null; // �����̳߳�
	private static String threadPoolName = null; // �̳߳�����

	private ThreadPoolManager(int maxThread, int maxQueue,String threadPoolName) {
		this.threadPoolName = threadPoolName;
		this.maxThread = maxThread;
		BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<Runnable>(maxQueue);// ����δ���Ĵ�С��֪�rʹ��
		this.executor = new ThreadPoolExecutor(maxThread, maxThread, 60L, TimeUnit.SECONDS, workQueue);
		logger.info("�̳߳س�ʼ�����̳߳ش�С��" + maxThread + " ���д�С��" + maxQueue);
	}

	/**
	 * @���� DHCC-SONG
	 * @���� Jun 6, 2016
	 * @����˵����0���̳߳س�ʼ��-Ԥ����ɸ����Զ�����
	 * @���ز��� ThreadPoolManager
	 */
	public static synchronized ThreadPoolManager getInstance0() {
		if (instance0 != null) {
			return instance0;
		}
		instance0 = new ThreadPoolManager(15, 100,"0���̳߳�");// ����̳߳ش�С �������д�С
		return instance0;
	}
	
	/**
	 * @���� DHCC-SONG
	 * @���� Jun 6, 2016
	 * @����˵����1���̳߳س�ʼ��-У��ɸ��
	 * @���ز��� ThreadPoolManager
	 */
	public static synchronized ThreadPoolManager getInstance1() {
		if (instance1 != null) {
			return instance1;
		}
		instance1 = new ThreadPoolManager(15, 100,"1���̳߳�");// ����̳߳ش�С �������д�С
		return instance1;
	}
	
	/**
	 * @���� DHCC-SONG
	 * @���� Jun 6, 2016
	 * @����˵����2���̳߳س�ʼ��-�������
	 * @���ز��� ThreadPoolManager
	 */
	public static synchronized ThreadPoolManager getInstance2() {
		if (instance2 != null) {
			return instance2;
		}
		instance2 = new ThreadPoolManager(15, 100,"2���̳߳�");// ����̳߳ش�С �������д�С
		return instance2;
	}
	
	/**
	 * @���� DHCC-SONG
	 * @���� Jun 6, 2016
	 * @����˵����3���̳߳س�ʼ��-�Զ�����
	 * @���ز��� ThreadPoolManager
	 */
	public static synchronized ThreadPoolManager getInstance3() {
		if (instance3 != null) {
			return instance3;
		}
		instance3 = new ThreadPoolManager(15, 100,"3���̳߳�");// ����̳߳ش�С �������д�С
		return instance3;
	}
	
	/**
	 * @���� DHCC-SONG
	 * @���� Jun 6, 2016
	 * @����˵����4���̳߳س�ʼ��-���ɺ�ͬ
	 * @���ز��� ThreadPoolManager
	 */
	public static synchronized ThreadPoolManager getInstance4() {
		if (instance4 != null) {
			return instance4;
		}
		instance4 = new ThreadPoolManager(15, 100,"4���̳߳�");// ����̳߳ش�С �������д�С
		return instance4;
	}
	
	/**
	 * @���� DHCC-SONG
	 * @���� Jun 6, 2016
	 * @����˵����5���̳߳س�ʼ��-���ɽ��
	 * @���ز��� ThreadPoolManager
	 */
	public static synchronized ThreadPoolManager getInstance5() {
		if (instance5 != null) {
			return instance5;
		}
		instance5 = new ThreadPoolManager(15, 100,"5���̳߳�");// ����̳߳ش�С �������д�С
		return instance5;
	}
	/**
	 * @���� DHCC-SONG
	 * @���� Jun 6, 2016
	 * @����˵����5���̳߳س�ʼ��-���˴���
	 * @���ز��� ThreadPoolManager
	 */
	public static synchronized ThreadPoolManager getInstance6() {
		if (instance6 != null) {
			return instance6;
		}
		instance6 = new ThreadPoolManager(15, 100,"6���̳߳�");// ����̳߳ش�С �������д�С
		return instance6;
	}
	/**
	 * @���� DHCC-SONG
	 * @���� Jun 6, 2016
	 * @����˵����10���̳߳�-�ۿ�
	 * @���ز��� ThreadPoolManager
	 */
	public static synchronized ThreadPoolManager getInstance7() {
		if (instance7 != null) {
			return instance7;
		}
		instance7 = new ThreadPoolManager(15, 100,"7���̳߳�");// ����̳߳ش�С �������д�С
		return instance7;
	}	/**
	 * @���� DHCC-SONG
	 * @���� Jun 6, 2016
	 * @����˵����10���̳߳�-�ۿ�
	 * @���ز��� ThreadPoolManager
	 */
	public static synchronized ThreadPoolManager getInstance8() {
		if (instance8 != null) {
			return instance8;
		}
		instance8 = new ThreadPoolManager(15, 100,"8���̳߳�");// ����̳߳ش�С �������д�С
		return instance8;
	}
	/**
	 * @���� DHCC-SONG
	 * @���� Jun 6, 2016
	 * @����˵����10���̳߳�-�ۿ�
	 * @���ز��� ThreadPoolManager
	 */
	public static synchronized ThreadPoolManager getInstance10() {
		if (instance10 != null) {
			return instance10;
		}
		instance10 = new ThreadPoolManager(15, 100,"10���̳߳�");// ����̳߳ش�С �������д�С
		return instance10;
	}
	
	/**
	 * @���� DHCC-SONG
	 * @���� Jun 6, 2016
	 * @����˵���������̳߳س�ʼ��
	 * @���ز��� ThreadPoolManager
	 */
	public static synchronized ThreadPoolManager getPubInstance() {
		if (pubInstance != null) {
			return pubInstance;
		}
		pubInstance = new ThreadPoolManager(15, 100,"�����̳߳�");// ����̳߳ش�С �������д�С
		return pubInstance;
	}
	
	
	/**
	 * �߳�ִ��
	 * @param runnable ����
	 * @return -1 �������� 0 ����ִ�� >0�Ŷ���
	 */
	public void exec(Runnable runnable) {
		try {
			executor.execute(runnable);// �����̳߳ز�ִ��
			int count = executor.getActiveCount();
			if (count >= maxThread) {
				count = executor.getQueue().size();
				logger.info("����[" + runnable.toString() + "]�����Ŷ���:" + count);
			} else {
				logger.info("����[" + runnable.toString() + "]��ʼִ��");
			}
		} catch (Exception e) {
			logger.info(threadPoolName+"�߳�æ���Ե�10ms");
			try {
				Thread.sleep(10);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			exec(runnable);  // ��������
		}
	}
	

	/**
	 * �߳�ִ��
	 * 
	 * @param runnable
	 *            ����
	 * @return -1 �������� 0 ����ִ�� >0�Ŷ���
	 */
	public int execute(Runnable runnable) {
		try {
			executor.execute(runnable);// �����̳߳ز�ִ��
			int count = executor.getActiveCount();
			if (count >= maxThread) {
				count = executor.getQueue().size();
			} else {
				count = 0;
			}
			return count;
		} catch (Exception e) {
			return -1;
		}
	}

	public boolean isRunning() {
		int count = executor.getActiveCount();
		return count >= 1;
	}

	public void shutdown() {
		if (executor != null && !executor.isShutdown()) {
			executor.shutdown();
			logger.info("�̳߳عر�");
		}
	}
}