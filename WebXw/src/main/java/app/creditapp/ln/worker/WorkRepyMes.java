package app.creditapp.ln.worker;
import java.util.Map;

import org.apache.log4j.Logger;

import redis.clients.jedis.Jedis;
import app.base.SourceTemplate;
import app.creditapp.acc.loan.bo.AcDebitSuspBo;
import app.creditapp.redis.util.RedisUtil;
/**
 * @���� DHCC-SONG
 * @���� Jun 6, 2016
 * @���� ҵ����A�ڵ� �Ƿ��ظ� ɸ�� ��ֿͻ� ���� ׼��
 */
public class WorkRepyMes implements Runnable {
	Logger logger = Logger.getLogger(WorkRepyMes.class);
	private String message;
	
	public WorkRepyMes(String message) {
		this.message = message;
	}
	/***
	 * @���� DHCC-SONG
	 * @���� Jun 29, 2016
	 * @����˵����֧�����ķ���
	 * @���ز��� void
	 */
	public void run() {
		try {
		    if(message==null||"".equals(message)){
		    	  logger.error("���յ�����Ϊ�գ�");
		    }else{
		    	AcDebitSuspBo acDebitSuspBo = (AcDebitSuspBo) SourceTemplate.getContext().getBean("acDebitSuspBo");

		    	Map<String,String> map = acDebitSuspBo.validateAcDebitSusp(message);
		    	for(String wsId : map.keySet()){
	    			Jedis jedis = RedisUtil.getJedis();
	    			jedis.lpush(RedisUtil.QUEUE7, map.get(wsId));// 
	    			jedis.close();
	    		}
		    }
		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}
	}
}
