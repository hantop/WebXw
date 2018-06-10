package app.creditapp.ln.worker;
import org.apache.log4j.Logger;

import redis.clients.jedis.Jedis;
import app.base.SourceTemplate;
import app.creditapp.ln.entity.LnApplyMid;
import app.creditapp.redis.util.RedisUtil;
import app.util.syslog.bo.SysExceptionBo;

import com.alibaba.fastjson.JSON;

/**
 * @���� DHCC-SONG
 * @���� Jun 6, 2016
 * @���� ҵ����B�ڵ� ������ʽ���������ֳɿͻ���Ϣ���˻���Ϣ��ѺƷ��Ϣ��
 */
public class WorkBforSplit implements Runnable {
	Logger logger = Logger.getLogger(WorkBforSplit.class);
	private LnApplyMid lnApplyMid;
	public WorkBforSplit(LnApplyMid lnApplyMid) {
		this.lnApplyMid = lnApplyMid;
	}
	
	public void run() {
		String _mid_toreg = "0"; //������ʽ���������ɹ���־��Ĭ��ʧ��
		String _split_result="0"; // ��ֳɹ���־��Ĭ��ʧ��
		try {
		    if(lnApplyMid==null){
		    	logger.error("B������ʧ��,���յ�����Ϊ�գ�");
		    }else{
		    	logger.info("APPID:"+lnApplyMid.getAppId()+" WORK B ����ʼ");
				  // ���ô洢����������ʽ���������
			      _mid_toreg = WorkUtils.getInstance().proc_mid_toreg(lnApplyMid.getAppId());//����������
			      if("1".equals( _mid_toreg )){  // ������ʽ���������ɹ�
			    	  // ���ô洢���̽�����ʽ������Ϣ���
				      _split_result = WorkUtils.getInstance().proc_apply_split(lnApplyMid.getAppId()); // ����������
				      if("1".equals( _split_result )){  // ��ʽ�������ֳɹ�
				    	  //  push��3����Ϣ����
				    	  Jedis jedis = RedisUtil.getJedis();
				  		  jedis.lpush(RedisUtil.QUEUE3, JSON.toJSONString(lnApplyMid));
				  		  jedis.close();
				  		  logger.info("B������ɹ�-[������AppId=" + lnApplyMid.getAppId()+",��ͬ��PactNo="+lnApplyMid.getPactNo()+"]");
				      }else{
				    	  logger.info("B������ʧ��-��ʽ��������ʧ��-PKG_LN_APPLY.PROC_APPLY_SPLIT-[������AppId=" + lnApplyMid.getAppId()+",��ͬ��PactNo="+lnApplyMid.getPactNo()+"]");
				      }
			      }else{			    	  
			    	  logger.info("B������ʧ��-������ʽ���������ʧ��-PKG_LN_APPLY.PROC_MID_TOREG-[������AppId=" + lnApplyMid.getAppId()+",��ͬ��PactNo="+lnApplyMid.getPactNo()+"]");
			      }
		    }
		} catch (Exception e) {
			SysExceptionBo sysExceptionBo = (SysExceptionBo) SourceTemplate.getSpringContextInstance().getBean("sysExceptionBo");
			sysExceptionBo.insertNewWorkExceptionLog(e, lnApplyMid.getAppId());
			e.printStackTrace();
		}
	}
	// ��д����ķ���
	public String toString(){
		String ret = "";
		if( lnApplyMid!=null ){
			ret = "ҵ��ID��"+ lnApplyMid.getAppId()+",��ͬ��ţ�"+lnApplyMid.getPactNo();
		}
		return ret;
	}
}
