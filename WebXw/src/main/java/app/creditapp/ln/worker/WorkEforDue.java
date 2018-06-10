package app.creditapp.ln.worker;

import org.apache.log4j.Logger;

import redis.clients.jedis.Jedis;
import app.base.SourceTemplate;
import app.creditapp.ln.bo.LnDueBo;
import app.creditapp.ln.entity.LnDue;
import app.creditapp.ln.entity.Message;
import app.creditapp.pact.entity.LnPact;
import app.creditapp.redis.util.RedisUtil;
import app.util.syslog.bo.SysExceptionBo;

import com.alibaba.fastjson.JSON;

/**
 * @���� DHCC-SONG
 * @���� Jun 6, 2016
 * @���� ҵ����E�ڵ� ���ɽ����Ϣ
 */
public class WorkEforDue implements Runnable {
	Logger logger = Logger.getLogger(WorkEforDue.class);
	
	private LnPact lnPact;
	public WorkEforDue(LnPact lnPact) {
		this.lnPact = lnPact;
	}

	public void run() {
		try {
		    if( lnPact==null ){
		    	logger.error("E������ʧ��,���յ�����Ϊ�գ�");
		    }else{
		    	// ���ô洢�������ɽ��
//		    	try{
//		    		System.out.println("************��50ms");
//					Thread.sleep(50);
//				}
//					catch(InterruptedException e){
//				}
				logger.info("APPID:"+lnPact.getAppId()+" WORK E ����ʼ");
				String _todue_sts = WorkUtils.getInstance().proc_pact_todue(lnPact.getPactId()); //����������
				if( "1".equals( _todue_sts ) ){  // ���ɽ�ݳɹ��Ĳ�push��6����Ϣ����
					LnDue lnDue = this.getLnDueByPactId(lnPact.getPactId());  // ��ѯ�������Ϣ
					// push��6����Ϣ����
			    	Jedis jedis = RedisUtil.getJedis();
			  		jedis.lpush(RedisUtil.QUEUE6, JSON.toJSONString(lnDue));
			  		jedis.close();
			  		logger.info("E������ɹ�-[��ͬ���ΪPactId=" + lnPact.getPactId()+",��ͬ��Ϊ"+lnPact.getPactNo()+"]��");
				}else{
					logger.info("E������-δ���ɴ�����-PKG_LN_DUE.PROC_PACT_TODUE[��ͬ���ΪPactId=" + lnPact.getPactId()+",��ͬ��Ϊ"+lnPact.getPactNo()+"]");
				}
		    }
		} catch (Exception e) {
			SysExceptionBo sysExceptionBo = (SysExceptionBo) SourceTemplate.getSpringContextInstance().getBean("sysExceptionBo");
			sysExceptionBo.insertNewWorkExceptionLog(e, lnPact.getAppId());
			e.printStackTrace();
		}
	}
	
	/**
	 * @���� DHCC-SONG
	 * @���� Jul 1, 2016
	 * @����˵��������ҵ���ͬ��Ų�ѯ�����Ϣ
	 * @���ز��� LnDue
	 */
	public LnDue getLnDueByPactId(String pactId){
		LnDueBo lnDueBo = (LnDueBo) SourceTemplate.getSpringContextInstance().getBean("lnDueBo");
		LnDue lnDue = lnDueBo.getByPactId(pactId);
		return lnDue;
	}
	
	// ��д����ķ���
	public String toString(){
		String ret = "";
		if( lnPact != null ){
			ret = "ҵ��ID��"+ lnPact.getAppId()+",��ͬ��ţ�"+lnPact.getPactNo();
		}
		return ret;
	}
	
	public static void main(String[] args) throws Exception {
		Jedis jedis = RedisUtil.getJedis();
		//Jedis jedis = new Jedis("10.7.101.38",6379,0);
		Message m = null;
		try {
			while(true){
				System.out.println("len-->"+jedis.llen("wangtao5"));
				System.out.println("message-->" + jedis.brpop(0, RedisUtil.QUEUE5).get(1));
			}
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
}
