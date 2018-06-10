package app.creditapp.redis.queue;

import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.log4j.Logger;

import redis.clients.jedis.Jedis;
import app.base.SourceTemplate;
import app.creditapp.ln.bo.LnApplyMidBo;
import app.creditapp.ln.bo.LnDueBo;
import app.creditapp.ln.entity.LnApplyMid;
import app.creditapp.ln.entity.LnDue;
import app.creditapp.pact.bo.LnPactBo;
import app.creditapp.pact.entity.LnPact;
import app.creditapp.redis.daemon.ThreadDaemon;
import app.creditapp.redis.daemon.ThreadFactory;
import app.creditapp.redis.util.RedisUtil;

import com.alibaba.fastjson.JSON;

/**
 * @���� DHCC-SONG
 * @���� Jun 23, 2016
 * @���� ����web����ʱ��ͬʱ����ҵ���������
 */
public class QueueInitServlet extends HttpServlet {
	Logger logger = Logger.getLogger(QueueInitServlet.class);
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public QueueInitServlet() {
	}

	public void init(ServletConfig servletconfig) throws ServletException {
		RedisUtil.poolInit(); // ��ʼ��jedis���ӳ�
		threadCreat();
//		toWork();
	}

	public void threadCreat(){
		// �������ҵ����ڵ����
		logger.info("��ʼ��jedis����.....");
		try {
			/** ********����P�ڵ�����߳� ��ʼ**************** */
			Thread.sleep(500);
			Thread threadP = ThreadFactory.initcreate(new TaskServerP()).getThread(); // ����A����ڵ�
			logger.info("Pҵ����ڵ�����߳������ɹ�! [�߳�id=" + threadP.getId() + ",�߳�name=" + threadP.getName()+"]");
			/** ********����P�ڵ�����߳� ����**************** */
			
			/** ********����A�ڵ�����߳� ��ʼ**************** */
			Thread.sleep(500);
			Thread threadA = ThreadFactory.initcreate(new TaskServerA()).getThread(); // ����A����ڵ�
			logger.info("Aҵ����ڵ�����߳������ɹ�! [�߳�id=" + threadA.getId() + ",�߳�name=" + threadA.getName()+"]");
			/** ********����A�ڵ�����߳� ����**************** */
			
			/** ********����B�ڵ�����߳� ��ʼ**************** */
			Thread.sleep(500);
			Thread threadB = ThreadFactory.initcreate(new TaskServerB()).getThread(); // ����B�����߳�
			logger.info("Bҵ����ڵ�����߳������ɹ�! [�߳�id=" + threadB.getId() + ",�߳�name=" + threadB.getName()+"]");
			/** ********����B�ڵ�����߳� ����**************** */
			
			/** ********����C�ڵ�����߳� ��ʼ**************** */
			Thread.sleep(500);
			Thread threadC = ThreadFactory.initcreate(new TaskServerC()).getThread();// ����C�����߳�
			logger.info("Cҵ����ڵ�����߳������ɹ�! [�߳�id=" + threadC.getId() + ",�߳�name=" + threadC.getName()+"]");
			/** ********����C�ڵ�����߳� ����**************** */
			
			/** ********����D�ڵ�����߳� ��ʼ**************** */
			Thread.sleep(500);
			Thread threadD = ThreadFactory.initcreate(new TaskServerD()).getThread();  // ����D����ڵ�
			logger.info("Dҵ����ڵ�����߳������ɹ�! [�߳�id=" + threadD.getId() + ",�߳�name=" + threadD.getName()+"]");
			/** ********����D�ڵ�����߳� ����**************** */
			
			/** ********����E�ڵ�����߳� ��ʼ**************** */
			Thread.sleep(500);
			Thread threadE = ThreadFactory.initcreate(new TaskServerE()).getThread();// ����E�����߳�
			logger.info("Eҵ����ڵ�����߳������ɹ�! [�߳�id=" + threadE.getId() + ",�߳�name=" + threadE.getName()+"]");
			/** ********����E�ڵ�����߳� ����**************** */
			
			/** ********����F�ڵ�����߳� ��ʼ**************** */
			Thread.sleep(500);
			Thread threadF = ThreadFactory.initcreate(new TaskServerF()).getThread(); // ����F�����߳�
			logger.info("Fҵ����ڵ�����߳������ɹ���[�߳�id=" + threadF.getId() + ",�߳�name=" + threadF.getName()+"]");
			/** ********����F�ڵ�����߳� ����**************** */
			
			/** ********�������ͱ��ķ����߳� ��ʼ7**************** */
			Thread.sleep(500);
			Thread threadMsg = ThreadFactory.initcreate(new SendMsgServer()).getThread();
			logger.info("���ͱ��Ľڵ�����߳������ɹ�(�ۿ�)��[�߳�id=" + threadMsg.getId() + ",�߳�name=" + threadMsg.getName()+"]");
			/** ********�������ͱ��ķ����߳�  ����7**************** */
			
			/** ********�����ſ�ͱ��ķ����߳� ��ʼ8**************** */
			Thread.sleep(500);
			Thread threadMsgGrant = ThreadFactory.initcreate(new SendMsgServerGrant()).getThread(); // ����F�����߳�
			logger.info("���ͱ��Ľڵ�����߳������ɹ�(�ſ�)��[�߳�id=" + threadMsgGrant.getId() + ",�߳�name=" + threadMsgGrant.getName()+"]");
			/** ********�����ſ�ͱ��ķ����߳�  ����8**************** */
			
			/** ********�����ۿ������߳� ��ʼ10**************** */
			Thread.sleep(500);
			Thread threadMes1 = ThreadFactory.initcreate(new RepyMesServer()).getThread();
			logger.info("�ۿ��1�ڵ�����߳������ɹ���[�߳�id=" + threadMes1.getId() + ",�߳�name=" + threadMes1.getName()+"]");
			/** ********�����ۿ������߳� ����10**************** */
			
			
			/** ********�����ػ��߳� ��ʼ**************** */
			ThreadDaemon td = new ThreadDaemon();
			Thread thread = new Thread(td);
			thread.start();
			logger.info("�ػ��߳������ɹ���[�߳�id=" + thread.getId() + ",�߳�name=" + thread.getName()+"]");
			/** ********�����ػ��߳� ����**************** */
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void toWork(){
		logger.info("Ѱ��δ�������...");
		
		LnApplyMidBo lnApplyMidBo = (LnApplyMidBo) SourceTemplate.getSpringContextInstance().getBean("lnApplyMidBo");
		LnPactBo lnPactBo = (LnPactBo) SourceTemplate.getSpringContextInstance().getBean("lnPactBo");
		LnDueBo lnDueBo = (LnDueBo) SourceTemplate.getSpringContextInstance().getBean("lnDueBo");
		//��ѯδ���WorkA������
		List<LnApplyMid> lnApplyMidListA = lnApplyMidBo.findListToWorkA();
		//��ѯδ���WorkB������
		List<LnApplyMid> lnApplyMidListB = lnApplyMidBo.findListToWorkB();
		//��ѯδ���WorkC������
		List<LnApplyMid> lnApplyMidListC = lnApplyMidBo.findListToWorkC();
		//��ѯδ���WorkD������
		List<LnApplyMid> lnApplyMidListD = lnApplyMidBo.findListToWorkD();
		//��ѯδ���WorkE������
		List<LnPact> lnPactListE = lnPactBo.findListToWorkE();
		//��ѯδ���WorkF������
		List<LnDue> lnDueListF = lnDueBo.findListToWorkF();
		Jedis jedis = RedisUtil.getJedis();
		//����ѯ������δ�������push��1����Ϣ����
		for(LnApplyMid lnApplyMid:lnApplyMidListA){
			logger.info("���ڴ���A��������...");
			jedis.lpush(RedisUtil.QUEUE1, JSON.toJSONString(lnApplyMid));
		}
		//����ѯ������δ�������push��2����Ϣ����
		for(LnApplyMid lnApplyMid:lnApplyMidListB){
			logger.info("���ڴ���B��������...");
			jedis.lpush(RedisUtil.QUEUE2, JSON.toJSONString(lnApplyMid));
		}
		//����ѯ������δ�������push��3����Ϣ����
		for(LnApplyMid lnApplyMid:lnApplyMidListC){
			logger.info("���ڴ���C��������...");
			jedis.lpush(RedisUtil.QUEUE3, JSON.toJSONString(lnApplyMid));
		}
		//����ѯ������δ�������push��4����Ϣ����
		for(LnApplyMid lnApplyMid:lnApplyMidListD){
			logger.info("���ڴ���D��������...");
			jedis.lpush(RedisUtil.QUEUE4, JSON.toJSONString(lnApplyMid));
		}
		//����ѯ������δ�������push��5����Ϣ����
		for(LnPact lnPact:lnPactListE){
			logger.info("���ڴ���E��������...");
			jedis.lpush(RedisUtil.QUEUE5, JSON.toJSONString(lnPact));
		}
		//����ѯ������δ�������push��6����Ϣ����
		for(LnDue lnDue:lnDueListF){
			logger.info("���ڴ���F��������...");
			jedis.lpush(RedisUtil.QUEUE6, JSON.toJSONString(lnDue));
		}
		logger.info("δ��������ѽ��빤���������ڴ���");
	}
	
	public static void main(String[] args) throws Exception {
//		Jedis jedis = RedisUtil.getJedis();
//		Properties p = new Properties();
//	    String fileName = "/redis.properties"; // redis ͳһ�����ļ�
//		try {
//			InputStream in = RedisUtil.class.getResourceAsStream(fileName);//����������new FileInputStream(fileName),�������ַ�ʽ�Ҳ��������ļ�������˵����classes�£��ҵ����ˣ����С�
//	        p.load(in);
//	        in.close();
//	        String redisIp = p.getProperty("redis.ip");
//	        int redisProt =  Integer.parseInt(p.getProperty("redis.port"));
//	        Jedis jedis = new Jedis(redisIp,redisProt);
//			/** ********����A�ڵ�����߳� ��ʼ**************** */
//			JedisPubSub queue1Listener = new Queue1Listener(); // ����1�Ŷ��м�����
//			System.out.println("ҵ����A�ڵ�����߳���������......");
//			Thread.sleep(500);
//			Thread threadA = ThreadFactory.initcreate(new TaskServerA()).getThread(); // ����A����ڵ�
//			System.out.println("ҵ����A�ڵ�����߳�����ok [�߳�id=" + threadA.getId() + ",�߳�name=" + threadA.getName()+"]");
//			/** ********����A�ڵ�����߳� ����**************** */
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
		RedisUtil.poolInit(); // ��ʼ��jedis���ӳ�
		QueueInitServlet qi = new QueueInitServlet();
		qi.threadCreat();
		qi.toWork();
	}
}
