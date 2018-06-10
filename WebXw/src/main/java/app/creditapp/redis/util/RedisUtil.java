package app.creditapp.redis.util;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.exceptions.JedisConnectionException;
import redis.clients.jedis.exceptions.JedisDataException;
import redis.clients.jedis.exceptions.JedisException;
/**
 * ���Ӻ�ʹ��redis��Դ�Ĺ�����
 * @version 0.5
 */
public class RedisUtil {
	private static Logger logger = Logger.getLogger(RedisUtil.class);
    //Redis������IP
    private static String IP_ADDR;
    //Redis�Ķ˿ں�
    private static int PORT;
    //��������
    private static String PASSWORD;
    //��������ʵ���������Ŀ��Ĭ��ֵΪ8
    //�����ֵΪ-1�����ʾ�����ƣ����pool�Ѿ�������maxActive��jedisʵ�������ʱpool��״̬Ϊexhausted(�ľ�)��
    private static int MAX_TOTAL;
    //����һ��pool����ж��ٸ�״̬Ϊidle(���е�)��jedisʵ����Ĭ��ֵҲ��8��
    private static int MAX_IDLE;
    //�ȴ��������ӵ����ʱ�䣬��λ���룬Ĭ��ֵΪ-1����ʾ������ʱ����������ȴ�ʱ�䣬��ֱ���׳�JedisConnectionException��
    private static int MAX_WAITMILLIS;
    //��ʱʱ��
    private static int TIMEOUT;
    //��borrowһ��jedisʵ��ʱ���Ƿ���ǰ����validate���������Ϊtrue����õ���jedisʵ�����ǿ��õģ�
    private static boolean TEST_ON_BORROW;
    // �ػ����̶೤ʱ����һ��redis�����̵߳�״̬
    public static long CHECK_TIME;
    // redis�����߳̽��ղ�������֮��ĳ�ʱʱ�䣬��ȡ�೤ʱ�� Ĭ������5����
    public static int BRPOP_TIMEOUT;
    // �೤ʱ���ٴ���������redis��������ȡ���ݣ���������ѯ��� 15��
    public static long WHILE_WAIT;
    // 
    public static String QUEUE0;
    public static String QUEUE1;
    public static String QUEUE2;
    public static String QUEUE3;
    public static String QUEUE4;
    public static String QUEUE5;
    public static String QUEUE6;
    public static String QUEUE7;
    public static String QUEUE8;
    public static String QUEUE10;
    /**
     * redis����ʱ��,����Ϊ��λ
     */
    public final static int EXRP_HOUR = 60*60;          //һСʱ
    public final static int EXRP_DAY = 60*60*24;        //һ��
    public final static int EXRP_MONTH = 60*60*24*30;   //һ����
    private static JedisPool jedisPool = null;
    
    private static void initProperties(){
    	ResourceBundle prop = ResourceBundle.getBundle("redis");
	    IP_ADDR = prop.getString("redis.ip").trim();
		PORT = Integer.parseInt(prop.getString("redis.port").trim());
		PASSWORD = null;
		MAX_TOTAL = Integer.parseInt(prop.getString("redis.pool.maxTotal").trim());
		MAX_IDLE = Integer.parseInt(prop.getString("redis.pool.maxIdle").trim());
		MAX_WAITMILLIS = Integer.parseInt(prop.getString("redis.pool.maxWaitMillis").trim());
		TIMEOUT = Integer.parseInt(prop.getString("redis.pool.timeOut").trim());
		TEST_ON_BORROW = Boolean.parseBoolean(prop.getString("redis.pool.testOnBorrow").trim());
		CHECK_TIME =  Long.parseLong(prop.getString("redis.thread.checkTime").trim());
		BRPOP_TIMEOUT =  Integer.parseInt(prop.getString("redis.brpop.timeOut").trim());
		WHILE_WAIT =  Integer.parseInt(prop.getString("redis.while.wait").trim());
		QUEUE0 = prop.getString("redis.queue0").trim();
		QUEUE1 = prop.getString("redis.queue1").trim();
		QUEUE2 = prop.getString("redis.queue2").trim();
		QUEUE3 = prop.getString("redis.queue3").trim();
		QUEUE4 = prop.getString("redis.queue4").trim();
		QUEUE5 = prop.getString("redis.queue5").trim();
		QUEUE6 = prop.getString("redis.queue6").trim();
		QUEUE7 = prop.getString("redis.queue7").trim();
		QUEUE8 = prop.getString("redis.queue8").trim();
		QUEUE10 = prop.getString("redis.queue10").trim();
    }

    /**
     * ��ʼ��Redis���ӳ�
     */
    private static void initialPool(){
    	logger.info("Resis���ӳس�ʼ��......");
        try {
        	initProperties();
            JedisPoolConfig config = new JedisPoolConfig();
            config.setMaxTotal(MAX_TOTAL);
            config.setMaxIdle(MAX_IDLE);
            config.setMaxWaitMillis(MAX_WAITMILLIS);
            config.setTestOnBorrow(TEST_ON_BORROW);
            jedisPool = new JedisPool(config, IP_ADDR, PORT, TIMEOUT);
        } catch (Exception e) {
        	logger.error("First create JedisPool error : "+e);
            try{
                //�����һ��IP�쳣������ʵڶ���IP
                JedisPoolConfig config = new JedisPoolConfig();
                config.setMaxTotal(MAX_TOTAL);
                config.setMaxIdle(MAX_IDLE);
                config.setMaxWaitMillis(MAX_WAITMILLIS);
                config.setTestOnBorrow(TEST_ON_BORROW);
                jedisPool = new JedisPool(config, IP_ADDR, PORT, TIMEOUT);
            }catch(Exception e2){
            	logger.error("Second create JedisPool error : "+e2);
            	e2.printStackTrace();
            }
        }
    }
    
    // �ڲ���ʵ�ֵ���ģʽ
//    private static class JedisPoolHolder {
//        private static final JedisPool jedisPool = initialPool() ;
//    }

//    public static JedisPool getJedisPool() { 
//        return JedisPoolHolder.jedisPool ;
//    }
    
//    /**
//     * �ͷ�jedis��Դ
//     * @param jedis
//     */
//    public static void returnResource(final Jedis jedis) {
//        if (jedis != null ) {
//        	JedisPoolHolder.jedisPool.returnResource(jedis);
//        }
//    }
    
//    public synchronized static Jedis getJedis() {
//      Jedis jedis = null;
//      try {
//           jedis = JedisPoolHolder.jedisPool.getResource();
//      } catch (Exception e) {
//      	e.printStackTrace();
//          //logger.error("Get jedis error : "+e);
//      }finally{
//          returnResource(jedis);
//      }
//      return jedis;
//  }
    /**
     * ͬ����ȡJedisʵ��
     */
    public synchronized static Jedis getThreadJedis() {
    	Jedis jedis = new Jedis(IP_ADDR, PORT, TIMEOUT);
        return jedis;
    }
    
    
    
    /**
     * �ڶ��̻߳���ͬ����ʼ��
     */
    public static synchronized void poolInit() {
        if (jedisPool == null) {
            initialPool();
        }
    }

    /**
     * ͬ����ȡJedisʵ��
     * @return Jedis
     */
    public synchronized static Jedis getJedis() {
//        if (jedisPool == null) {
//        	initialPool();
//        }
//        boolean broken = false;
//        Jedis jedis = null;
//        try {
//            if (jedisPool != null) {
//                jedis = jedisPool.getResource();
//                System.out.println("jedis���Ӵ����ɹ�.....");
//            }
//        } catch (JedisException e) {
//        	broken = handleJedisException(e);
//        	e.printStackTrace();
//            throw e;
//            //logger.error("Get jedis error : "+e);
//        }finally{
//        	 closeResource(jedis, broken);
//        }
//        return jedis;
    	
    	Jedis jedis = new Jedis(IP_ADDR, PORT, TIMEOUT);
    	return jedis;
    }
    
    /**
     * �ͷ�jedis��Դ
     * @param jedis
     */
    public static void returnResource(final Jedis jedis) {
        if (jedis != null && jedisPool !=null) {
            jedisPool.returnResource(jedis);
        }
    }

    /**
     * ���� String
     * @param key
     * @param value
     */
    public static void setString(String key ,String value){
        try {
            value = (value==null) ? "" : value;
            getJedis().set(key,value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * ���� ����ʱ��
     * @param key
     * @param seconds ����Ϊ��λ
     * @param value
     */
    public static void setString(String key ,int seconds,String value){
        try {
        	value = (value==null) ? "" : value;
            getJedis().setex(key, seconds, value);
        } catch (Exception e) {
        	 e.printStackTrace();
        }
    }

    /**
     * ��ȡStringֵ
     * @param key
     * @return value
     */
    public static String getString(String key){
        if(getJedis() == null || !getJedis().exists(key)){
            return null;
        }
        return getJedis().get(key);
    }
    
    /**
     * Handle jedisException, write log and return whether the connection is broken.
     */
    public static boolean handleJedisException(JedisException jedisException) {
        if (jedisException instanceof JedisConnectionException) {
        	System.err.println("Redis connection lost.");
        } else if (jedisException instanceof JedisDataException) {
            if ((jedisException.getMessage() != null) && (jedisException.getMessage().indexOf("READONLY") != -1)) {
            	System.err.println("Redis connection are read-only slave.");
            } else {
                // dataException, isBroken=false
                return false;
            }
        } else {
        	System.err.println("Jedis exception happen.");
        }
        return true;
    }
    /**
     * Return jedis connection to the pool, call different return methods depends on the conectionBroken status.
     */
    public static void closeResource(Jedis jedis, boolean conectionBroken) {
        try {
            if (conectionBroken) {
                jedisPool.returnBrokenResource(jedis);
            } else {
                jedisPool.returnResource(jedis);
            }
        } catch (Exception e) {
        	System.err.println("return back jedis failed, will fore close the jedis.");
            jedis.disconnect();
        }
    }
}