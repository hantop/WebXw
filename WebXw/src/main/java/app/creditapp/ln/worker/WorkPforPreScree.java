package app.creditapp.ln.worker;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import app.base.SourceTemplate;
import app.creditapp.inf.client.RuleTrans;
import app.creditapp.inf.client.RulesService;
import app.creditapp.inf.client.entity.Request;
import app.creditapp.inf.client.entity.RequestObj;
import app.creditapp.inf.client.entity.ReturnObj;
import app.creditapp.inf.client.entity.RuleFact;
import app.creditapp.inf.entity.WsIn2001;
import app.creditapp.ln.bo.PreApplyBo;
import app.creditapp.ln.entity.PreApply;
import app.util.syslog.bo.SysExceptionBo;

import com.alibaba.fastjson.JSON;

/**
 * @���� DHCC-SONG
 * @���� Jun 6, 2016
 * @���� ҵ����P�ڵ� �ж��Ƿ��ظ�������ɸ�顢�Զ�����
 */
public class WorkPforPreScree implements Runnable {
	Logger logger = Logger.getLogger(WorkPforPreScree.class);
	private String batchNo;
	
	public WorkPforPreScree(String batchNo) {
		this.batchNo = batchNo;
	}
	/***
	 * @���� DHCC-SONG
	 * @���� Jun 29, 2016
	 * @����˵�����ж��Ƿ��ظ�������ɸ�顢�Զ�����
	 * @���ز��� void
	 */
	public void run() {
		
		String _val_result = "0"; // �Ƿ������ɸ��0�����쳣1ɸ�����
		try {
		    if(batchNo==null||"".equals(batchNo)){
		    	  logger.error("P������ʧ��,���յ�����Ϊ�գ�");
		    }else{
		    	_val_result = WorkUtils.getInstance().proc_pre_screen(batchNo);//����������
		    	if("1".equals(_val_result)){
		    		PreApply preApply = new PreApply();
					String reError = null;
					RuleTrans ru = new RuleTrans();
					preApply.setBatchNo(batchNo);
					PreApplyBo preApplyBo = (PreApplyBo)SourceTemplate.getSpringContextInstance().getBean("preApplyBo");
					List<PreApply> preApplyList = preApplyBo.findListByBatNo(preApply);
					for(PreApply preA:preApplyList){
						//�ж�ɸ���Ƿ�ͨ����ͨ��������Զ�����
						if("01".equals(preA.getChkRes())){
							ReturnObj re = appAuto(preA);
							reError = ru.resultError(re.getResponse().getRuleFact().get(0));
							if(reError != null){
								preApply.setAppId(preA.getAppId());
								preApply.setIfFlag(re.getResponse().getResultId());
								preApply.setChkRes("16");
								preApply.setChkDesc(reError);
								preApply.setAppSts("03");
								preApplyBo.updateZDSP(preApply);
								logger.info("P���������,Ԥ�����Զ��������,���ԭ��:["+reError+"],���κ�batch_no="+batchNo+",�����app_id="+preA.getAppId());
							}else{
								preApply.setAppId(preA.getAppId());
								preApply.setIfFlag(re.getResponse().getResultId());
								preApply.setChkRes(preA.getChkRes());
								preApply.setChkDesc(preA.getChkDesc());
								preApply.setAppSts("02");
								preApplyBo.updateZDSP(preApply);
								logger.info("P���������,Ԥ�����Զ�����ͨ��,���κ�batch_no="+batchNo+",�����app_id="+preA.getAppId());
							}
						}else{
							preA.setAppSts("03");
							preApplyBo.updateZDSP(preA);
							logger.info("P������ʧ��,Ԥ����ɸ��δͨ��,���κ�batch_no="+batchNo);
						}
					}
		    	}else{
		    		logger.info("P������ʧ��,Ԥ����ɸ���쳣,���κ�batch_no="+batchNo);
		    	}
		    }
//			logger.info(message);
		} catch (Exception e) {
			SysExceptionBo sysExceptionBo = (SysExceptionBo) SourceTemplate.getSpringContextInstance().getBean("sysExceptionBo");
			sysExceptionBo.insertNewWorkExceptionLog(e, batchNo);
			e.printStackTrace();
		}
	}
	
	/***
	 * @���� wangtao
	 * @���� Jul 12, 2016
	 * @����˵�������ù�������ӿڽ����Զ�����[��ͬ�Ĳ�Ʒ�����Ų�ͬ]
	 * @���ز��� 02ͨ��03���
	 */
	public ReturnObj appAuto(PreApply ln){
		//���ӹ�������
//		RulesServiceService factory = new RulesServiceService();
//		RulesService rs = factory.getRulesServicePort();
		RulesService rs = (RulesService) SourceTemplate.getSpringContextInstance().getBean("RulesService");
		//ƴ�Ӵ�������
		RequestObj requestObj = new RequestObj();
		Request request = new Request();
		RuleFact ruleFact = new RuleFact();
		
		ruleFact.setPrdtNo(ln.getPrdtNo());
		ruleFact.setAge(birthToAge(ln.getBirthDay()));
		ruleFact.setEdu(ln.getEdu());
		ruleFact.setCifType(ln.getCifType());
		if(ln.getWorkSts()==null||"".equals(ln.getWorkSts())){
			ruleFact.setIfWork("99");
		}else{
			ruleFact.setIfWork(ln.getWorkSts());
		}
		ruleFact.setIfRoom(ln.getIfRoom());
		ruleFact.setIfBlack(ln.getChkRes());
		ruleFact.setIfPhone("");
		if(!(ln.getResTel()==null||"".equals(ln.getResTel()))){
			ruleFact.setIfPhone(ln.getResTel());
		}
		if(!(ln.getPhoneNo()==null||"".equals(ln.getPhoneNo()))){
			ruleFact.setIfPhone(ln.getPhoneNo());
		}
		ruleFact.setAgeRes("");
		ruleFact.setEduRes("");
		ruleFact.setCifTypeRes("");
		ruleFact.setIfWorkRes("");
		ruleFact.setIfBendiRes("");
		ruleFact.setIfRoomRes("");
		ruleFact.setIfBlackRes("");
		ruleFact.setIfPhoneRes("");
		ruleFact.setAppRes("");
		
		ruleFact.setSex(ln.getSex());
		ruleFact.setWorkYear(dateToYear(ln.getWorkYear())+"");
		ruleFact.setMarriage(ln.getMarriage());
		ruleFact.setChildren(ln.getChildren());
		ruleFact.setIncome(ln.getIncome());
		ruleFact.setIfBendi("");
		if((ln.getAppArea().equals(ln.getCifArea()))){
			ruleFact.setIfBendi("01");
		}
		ruleFact.setIfCar(ln.getIfCar());
		ruleFact.setIfCard(ln.getIfCard());
		ruleFact.setCardAmt(ln.getCardAmt());
		ruleFact.setIfCarcred(ln.getIfCarcred());
		ruleFact.setIfMort(ln.getIfMort());
		
		List<RuleFact> list = new ArrayList<RuleFact>();
		list.add(0, ruleFact);
//		request.setRuleName("appAutoWeiXin");
		request.setRuleName("appAuto"+ln.getPrdtNo());
		request.setRuleFact(list);
		requestObj.setUser("1001");
		requestObj.setPassword("1");
		requestObj.setRequest(request);
		//�����ַ���
//		String str1= JSON.toJSONString(requestObj);
		//���ù�������õ����ص��ַ���
		String str= rs.executeRule(JSON.toJSONString(requestObj));
		//�����ص��ַ���תΪObject��ȡ���������
		return (ReturnObj) JSON.parseObject(str, ReturnObj.class);
	}
	/***
	 * @���� wangtao
	 * @���� Jul 12, 2016
	 * @����˵����������ת��Ϊ����
	 * @���ز��� ����
	 */
	public int birthToAge(String birth){
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        String dateString = formatter.format(new Date());
        Date birthDate = null;
        Date currentTime = null;
        try {
        	birthDate = formatter.parse(birth);
        	currentTime = formatter.parse(dateString);
        } catch (Exception e) {
        }
        long day = (currentTime.getTime() - birthDate.getTime()) / (24 * 60 * 60 * 1000);
        int year=(int)day/365;
        return year;
	}
	/***
	 * @���� wangtao
	 * @���� Jul 12, 2016
	 * @����˵����������ת��Ϊ����
	 * @���ز��� ����
	 */
	public int dateToYear(String da){
		if("".equals(da)||da==null){
			return 0;
		}else{
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy");
	        String dateString = formatter.format(new Date());
	        int year = Integer.parseInt(dateString)-Integer.parseInt(da);
	        return year;
		}
		
	}
	
	// ��д����ķ���
	public String toString(){
		String ret = "";
		if( !(batchNo==null||"".equals(batchNo)) ){
			ret = "���κţ�"+ batchNo+"";
		}
		return ret;
	}
}
