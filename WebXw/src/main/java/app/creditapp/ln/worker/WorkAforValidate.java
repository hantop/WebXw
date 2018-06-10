package app.creditapp.ln.worker;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import redis.clients.jedis.Jedis;
import app.base.SourceTemplate;
import app.creditapp.cred.bo.CifEvalBo;
import app.creditapp.cred.entity.CifEval;
import app.creditapp.inf.client.RulesService;
import app.creditapp.inf.client.entity.Request;
import app.creditapp.inf.client.entity.RequestObj;
import app.creditapp.inf.client.entity.ReturnObj;
import app.creditapp.inf.client.entity.RuleFact;
import app.creditapp.ln.entity.LnApplyMid;
import app.creditapp.redis.util.RedisUtil;
import app.util.syslog.bo.SysExceptionBo;

import com.alibaba.fastjson.JSON;

/**
 * @���� DHCC-SONG
 * @���� Jun 6, 2016
 * @���� ҵ����A�ڵ� �Ƿ��ظ� ɸ�� ��ֿͻ� ���� ׼��
 */
public class WorkAforValidate implements Runnable {
	Logger logger = Logger.getLogger(WorkAforValidate.class);
	private LnApplyMid lnApplyMid;
	
	public WorkAforValidate(LnApplyMid lnApplyMid) {
		this.lnApplyMid = lnApplyMid;
	}
	/***
	 * @���� DHCC-SONG
	 * @���� Jun 29, 2016
	 * @����˵�����ж��Ƿ��ظ�������ɸ�顢��ֿͻ���������׼��
	 * @���ز��� void
	 */
	public void run() {
		String _val_result = "0"; // Ĭ��ɸ�鲻ͨ��
		String _split_result = "0"; // ��ֳɹ���־��Ĭ��ʧ��
		String _repeat_result = "0";
		try {
		    if(lnApplyMid==null){
		    	  logger.error("A������ʧ��,���յ�����Ϊ�գ�");
		    }else{
		    	  logger.info("APPID:"+lnApplyMid.getAppId()+" WORK A ����ʼ");
				  // ���ô洢���̽����ڲ�����ɸ��
		    	  _repeat_result = WorkUtils.getInstance().proc_pact_repeat(lnApplyMid.getAppId());
		    	  if("0".equals(_repeat_result)){
		    		  //�������ظ��������ڲ�����ɸ��
		    		  _val_result = WorkUtils.getInstance().proc_ln_screen(lnApplyMid.getAppId());//����������
				      if("1".equals( _val_result )){  // ɸ��û�����⣬����в��
				    	  // ���ô洢���̽��пͻ���Ϣ���
					      _split_result = WorkUtils.getInstance().proc_cif_split(lnApplyMid.getAppId()); // ����������
					      if("1".equals( _split_result )){  // �ͻ���Ϣ���û�����⣬���������
					    	  //  ���ù���������пͻ���������json��
//					    	  ReturnObj ro = cifScore(lnApplyMid);
					    	  String sRo = "0000";
					    	  //ȡ���÷�������Id
					    	  if(sRo!=null&&"0000".equals(sRo)){
						    	  int score = 100;
						    	  String resultId = "1000001";
						    	  //���������������CIF_EVAL���� ��������ID�����֤�Ÿ���.0
						    	  int result = cifEvalUpdate(lnApplyMid.getAppId(),lnApplyMid.getIdNo(),score,resultId);
						    	  //����ҵ��׶α��е�EVAL_STSΪ02������
						    	  if( result!=0 ){
						    		  WorkUtils.getInstance().proc_up_stage(lnApplyMid.getAppId(), "EVAL_STS", "02", "�ͻ�������");
						    	  }
					    	  }else{
					    		  WorkUtils.getInstance().proc_up_stage(lnApplyMid.getAppId(), "EVAL_STS", "01", "�ͻ�δ����");
					    		  logger.info("���ù���������пͻ����ֳ����ͻ�δ������-[������AppId=" + lnApplyMid.getAppId()+",��ͬ��PactNo="+lnApplyMid.getPactNo()+"]");
					    	  }
					    	  //  �����������C ��push��2����Ϣ����
					    	  Jedis jedis = RedisUtil.getJedis();
					  		  jedis.lpush(RedisUtil.QUEUE2, JSON.toJSONString(lnApplyMid));// ֻд��ҵ��������
					  		  jedis.close();
					  		  logger.info("A������ɹ�-[������AppId=" + lnApplyMid.getAppId()+",��ͬ��PactNo="+lnApplyMid.getPactNo()+"]");
					      }else{
					    	  logger.info("A������ʧ��-�ͻ����ʧ��-PKG_LN_APPLY.PROC_CIF_SPLIT-[������AppId=" + lnApplyMid.getAppId()+",��ͬ��PactNo="+lnApplyMid.getPactNo()+"]");
					      }
				      }else{
				    	  logger.info("A������ʧ��-ɸ��ʧ��-PKG_LN_APPLY.PROC_LN_SCREEN-[������AppId=" + lnApplyMid.getAppId()+",��ͬ��PactNo="+lnApplyMid.getPactNo()+"]");
				      }
		    	  }else{
		    		  logger.info("A������ʧ��-�����ظ�-PKG_LN_APPLY.PACT_REPEAT-[������AppId=" + lnApplyMid.getAppId()+",��ͬ��PactNo="+lnApplyMid.getPactNo()+"]");
		    	  } 
		    }
//			logger.info(message);
		} catch (Exception e) {
			SysExceptionBo sysExceptionBo = (SysExceptionBo) SourceTemplate.getSpringContextInstance().getBean("sysExceptionBo");
			sysExceptionBo.insertNewWorkExceptionLog(e, lnApplyMid.getAppId());
			e.printStackTrace();
		}
	}
	
	/***
	 * @���� wangtao
	 * @���� Jul 11, 2016
	 * @����˵�������ù������� ���ݿͻ����� ���пͻ�����
	 * @���ز��� �����÷�
	 */
	public ReturnObj cifScore(LnApplyMid ln){
		//ƴ�Ӵ�������
		RequestObj requestObj = new RequestObj();
		Request request = new Request();
		RuleFact ruleFact = new RuleFact();
		ruleFact.setCifName(ln.getCifName());
		ruleFact.setAge(birthToAge(ln.getBirthDay()));
		ruleFact.setCifNameScore(0);
		ruleFact.setAgeScore(0);
		List<RuleFact> list = new ArrayList<RuleFact>();
		list.add(0, ruleFact);
		request.setRuleName("cifEval");
		request.setRuleFact(list);
		requestObj.setUser("1001");
		requestObj.setPassword("1");
		requestObj.setRequest(request);
		ReturnObj ro = null;
		try {
			//���ӹ�������
			RulesService rs = (RulesService) SourceTemplate.getSpringContextInstance().getBean("RulesService");
			//���ù�������õ����ص��ַ���
			String strout = rs.executeRule(JSON.toJSONString(requestObj));
			ro = (ReturnObj) JSON.parseObject(strout, ReturnObj.class);
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("�ͻ��������ù�������ʧ��");
		}
	    return ro;
	}
	
	/***
	 * @���� wangtao
	 * @���� Jul 11, 2016
	 * @����˵�������������������CIF_EVAL���� ��������ID�����֤�Ÿ���
	 * @���ز��� ��
	 */
	public int cifEvalUpdate(String appId,String idNo,int score,String resultId){
		//��ȡ��ǰ���ڲ�ͳһ��ʽ��ʽ
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
		String evalDate = df.format(new Date()).toString();
		//�����ֶε�ֵ
		String evalSts = "01";
		String grade = "A";
		String evalDesc = "���ü���";
		if(score<60){
			grade = "C";
			evalDesc = "���ü���";
		}
		//������Ҫ���µ��ֶ�ֵ
		CifEval cifEval = new CifEval();
		cifEval.setEvalDate(evalDate);
		cifEval.setEvalSts(evalSts);
		cifEval.setGrade(grade);
		cifEval.setScore(score);
		cifEval.setIdNo(idNo);
		cifEval.setAppId(appId);
		cifEval.setEvalDesc(evalDesc);
		cifEval.setResultId(resultId);
		//ʹ��Bo��cifEval����и���
		CifEvalBo cifEvalBo = (CifEvalBo) SourceTemplate.getSpringContextInstance().getBean("cifEvalBo");
		int result = cifEvalBo.cifScoreUpdate(cifEval);
		return result;
	}
	/***
	 * @���� wangtao
	 * @���� Jul 12, 2016
	 * @����˵����������ת��Ϊ����
	 * @���ز��� ����
	 */
	public int birthToAge(String birth) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		String dateString = formatter.format(new Date());
		Date birthDate = null;
		Date currentTime = null;
		int year=0;
		try {
			birthDate = formatter.parse(birth);
			currentTime = formatter.parse(dateString);
			long day = (currentTime.getTime() - birthDate.getTime()) / (24 * 60 * 60 * 1000);
			year = (int) day / 365;
		} catch (Exception e) {
		}		
		return year;
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
