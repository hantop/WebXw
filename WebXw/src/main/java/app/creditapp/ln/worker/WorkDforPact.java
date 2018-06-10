package app.creditapp.ln.worker;

import org.apache.log4j.Logger;

import redis.clients.jedis.Jedis;
import app.base.SourceTemplate;
import app.creditapp.ln.entity.LnApplyMid;
import app.creditapp.pact.bo.LnPactBo;
import app.creditapp.pact.entity.LnPact;
import app.creditapp.redis.util.RedisUtil;
import app.creditapp.wkf.entity.WkfParm;
import app.util.syslog.bo.SysExceptionBo;

import com.alibaba.fastjson.JSON;

/**
 * @���� DHCC-SONG
 * @���� Jun 6, 2016
 * @���� ҵ����D�ڵ� ���ɺ�ͬ
 */
public class WorkDforPact implements Runnable {
	Logger logger = Logger.getLogger(WorkDforPact.class);
	private LnApplyMid lnApplyMid;
	
	public WorkDforPact(LnApplyMid lnApplyMid) {
		this.lnApplyMid = lnApplyMid;
	}

	public void run() {
		try {
		    if( lnApplyMid==null ){
		    	logger.error("D������ʧ��,���յ�����Ϊ�գ�");
		    }else{
		    	// ֱ�ӵ������ɺ�ͬ�Ĵ洢����
		    	logger.info("APPID:"+lnApplyMid.getAppId()+" WORK D ����ʼ");
				String _topact_sts = WorkUtils.getInstance().proc_apply_topact(lnApplyMid.getAppId(), lnApplyMid.getApprType());// ���ɺ�ͬ�ɹ���־ 1�ɹ� 0ʧ��
				String _appr_type = lnApplyMid.getApprType(); // ��������[01�Զ�02�˹�]
				if( "1".equals(_topact_sts) ){ // ���ɺ�ͬ�ɹ�
					LnPactBo lnPactBo = (LnPactBo) SourceTemplate.getSpringContextInstance().getBean("lnPactBo");
					LnPact lnPact = new LnPact();
					lnPact.setAppId(lnApplyMid.getAppId());
					lnPact = lnPactBo.getByAppId(lnPact);
					if( "01".equals(_appr_type) ){ // �Զ�����
						// push��5����Ϣ����
				    	Jedis jedis = RedisUtil.getJedis();
				  		jedis.lpush(RedisUtil.QUEUE5, JSON.toJSONString(lnPact));
				  		jedis.close();
				  		logger.info("D������ɹ�-�Զ�����-[�����ΪappId=" + lnApplyMid.getAppId()+",��ͬ��Ϊ"+lnApplyMid.getPactNo()+"]��");
					} else {  // �˹�����
						// �Զ��ύ��ͬ���빤��������  
						//������̱�����Ȼ����������
						WkfParm parm = new WkfParm();
						parm.setApp_no(lnPact.getPactId());
						parm.setApp_type("01");//��������
						parm.setBr_no(lnPact.getBrNo());
//						parm.setBr_lev(User.getFicode(this.getHttpRequest()));
						parm.setBr_lev("1");
						StringBuilder wfAppValue = new StringBuilder();
						wfAppValue.append("�ͻ���:"+lnPact.getCifNo());
						wfAppValue.append(",�ͻ�����:"+lnPact.getCifName());
						parm.setWf_app_value(wfAppValue.toString());//ҵ��
//						long b = System.currentTimeMillis();
						String nextDesc =lnPactBo.doSubmitUpdate(parm,lnPact,"SYSTEM", lnPact.getBrNo());
//						long e = System.currentTimeMillis();
						WorkUtils.getInstance().proc_up_stage(lnApplyMid.getAppId(), "RGAPP_STS", "01", "�˹�����������");
						logger.info("D������ɹ�-�˹�����-[APPId=" + lnPact.getAppId()+",batchNo=" + lnPact.getBatchNo()+",��ͬ���ΪPactId=" + lnPact.getPactId()+",��ͬ��ΪPactNo="+lnPact.getPactNo()+"]��");
					}
				} else { // ���ɺ�ͬʧ��
					logger.info("D������ʧ��-���ɺ�ͬʧ��-PKG_LN_PACT.PROC_APPLY_TOPACT-[����IDΪAppId=" + lnApplyMid.getAppId()+"]");
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
		if( lnApplyMid != null ){
			ret = "ҵ��ID��"+ lnApplyMid.getAppId()+",��ͬ��ţ�"+lnApplyMid.getPactNo();
		}
		return ret;
	}
}
