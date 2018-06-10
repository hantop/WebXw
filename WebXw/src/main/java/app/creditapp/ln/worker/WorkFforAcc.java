package app.creditapp.ln.worker;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import app.base.SourceTemplate;
import app.base.httpclient.entity.SendMessageEntity;
import app.base.httpclient.entity.SendMessageType;
import app.base.httpclient.work.SendMessageMain;
import app.creditapp.acc.loan.action.AcLoanBackLogAction;
import app.creditapp.acc.loan.bo.LoanBo;
import app.creditapp.aft.bo.AftRewPactBo;
import app.creditapp.aft.entity.AftRewPact;
import app.creditapp.aft.entity.aftMessage.PasSubTypeEntity;
import app.creditapp.corp.entity.CorpParm;
import app.creditapp.ln.bo.LnDueBo;
import app.creditapp.ln.entity.LnDue;
import app.creditapp.proj.bo.ProjMangBo;
import app.creditapp.proj.entity.ProjMang;
import app.creditapp.sys.bo.ParmRewBo;
import app.creditapp.sys.entity.ParmRew;
import app.oscache.CachecodeUtil;
import app.oscache.MBaseCache;
import app.util.syslog.bo.SysExceptionBo;

/**
 * @���� DHCC-SONG
 * @���� Jun 6, 2016
 * @���� ҵ����F�ڵ� ���˴���ҵ��
 */
public class WorkFforAcc implements Runnable {
	String _grant_result = "02"; // Ĭ�Ϸſ�ʧ��
	Logger logger = Logger.getLogger(WorkFforAcc.class);
	
	private LnDue lnDue;
	public WorkFforAcc( LnDue lnDue) {
		this.lnDue = lnDue;
	}

	public void run() {
		try {
		    if(lnDue==null){
		    	logger.error("������ʧ�ܣ�");
		    }else{
		    	// ���ô洢���̽��з���
		    	logger.info("APPID:"+lnDue.getAppId()+" WORK F ����ʼ");
				String _split_sts = WorkUtils.getInstance().proc_acc_fund(lnDue.getDueNo(), lnDue.getProjNo(), lnDue.getDueAmt(), lnDue.getMtrDate());// ���˳ɹ���־ [02�ɹ� 03ʧ��]
				if( "02".equals( _split_sts ) ) {  // ���ɴ������ļ�
					logger.info("F������-���˳ɹ�-PKG_LN_DUE.PROC_ACC_SPLIT-[��ͬ���ΪPactId=" + lnDue.getPactId()+",��ͬ��Ϊ"+lnDue.getPactNo()+"]");
					WorkUtils.getInstance().proc_up_stage(lnDue.getAppId(), "PART_STS", "02","���˳ɹ�");
					// �����жϸû����Ƿ�ʱ�ſ� �ӻ�����ȡ������C�ڵ�
					String put_type = "";
					put_type = getPutType(lnDue.getBrNo());
					logger.info("******************put_type="+put_type+"");
					if("02".equals(put_type)){
						logger.info("******************��ʱ�ſ�");
						// ����Ƕ�ʱ�ſ� ����ð���д�Ķ�ʱ������� ���ɶ�ʱ�ſ����񣬸���LN_DUE���еķſ�״̬Ϊ01���ſ��ʱֱ�ӵ��÷ſ��
//						LnDueBo lnDueBo = (LnDueBo) SourceTemplate.getSpringContextInstance().getBean("lnDueBo");
//						List<LnDue> lnDueList = lnDueBo.findList();
					}else{
//						logger.info("******************ʵʱ�ſ�");
						// �����ʵʱ�ſ��ֱ�ӵ�������д�ķſ���������ɴ������ļ����ſ�
						LoanBo loanBo = (LoanBo) SourceTemplate.getSpringContextInstance().getBean("loanBo");
//						long b = System.currentTimeMillis();
						_grant_result = loanBo.grantLoan(lnDue);
//						long e = System.currentTimeMillis();
						if("01".equals(_grant_result)){
							// �ſ�ɹ������LN_DUE���еķſ�״̬Ϊ02����
							lnDueUpdate(lnDue.getAppId(),lnDue.getDueNo(),"02");
//							WorkUtils.getInstance().proc_up_stage(lnDue.getAppId(), "PAY_STS", "02", "�ſ�ɹ�");
							logger.info("����ſ��ɹ�![�����AppId=" + lnDue.getAppId()+",��ͬ���PactNo="+lnDue.getPactNo()+"]");
						}else{
							logger.info("����ſ��ʧ��![�����AppId=" + lnDue.getAppId()+",��ͬ���PactNo="+lnDue.getPactNo()+"]");
						}
					}
				}else{
					//��������
					if("04".equals(_split_sts)){
						WorkUtils.getInstance().proc_up_stage(lnDue.getAppId(), "PART_STS", "03","����ʧ��,��������");
					}else{
						WorkUtils.getInstance().proc_up_stage(lnDue.getAppId(), "PART_STS", "03","����ʧ��");
					}
//					sendMes(lnDue);
					//������ʧ����Ϣ����AftRewPact��
					insertToAftRewPact(lnDue);
					logger.info("F������-����ʧ��-PKG_LN_DUE.PROC_ACC_FUND-[�����AppId=" + lnDue.getAppId()+",��ͬ��Ϊ"+lnDue.getPactNo()+"]");
				}
		    }
//			logger.info(message);
		} catch (Exception e) {
			SysExceptionBo sysExceptionBo = (SysExceptionBo) SourceTemplate.getSpringContextInstance().getBean("sysExceptionBo");
			sysExceptionBo.insertNewWorkExceptionLog(e, lnDue.getAppId());
			e.printStackTrace();
		}
	}
	
	public String getPutType(String brNo)
    {   
		String putType = "";
		List<CorpParm> corpParmList = (List<CorpParm>) MBaseCache.getCache().getBeanCache(CachecodeUtil.CORP_PARM_STR, CachecodeUtil.CORP_PARM);
		for(CorpParm corpParm : corpParmList){
			if(brNo.equals(corpParm.getBrNo())){
				putType = corpParm.getPutType();
				break;
			}
		}
		return putType;
    }
	public void insertToAftRewPact(LnDue lnDue){   
		AftRewPact aftRewPact = new AftRewPact();
		//�ֶ�����Ԥ������
		aftRewPact.setRewCont("����ʧ��");
		//�ӽ�ݱ����ȡ
		aftRewPact.setBal(lnDue.getBal());
		aftRewPact.setBegDate(lnDue.getBegDate());
		aftRewPact.setBrNo(lnDue.getBrNo());
		aftRewPact.setCifName(lnDue.getCifName());
		aftRewPact.setCifNo(lnDue.getCifNo());
		aftRewPact.setEndDate(lnDue.getEndDate());
		aftRewPact.setPactAmt(lnDue.getDueAmt());
		aftRewPact.setPactId(lnDue.getPactId());
		aftRewPact.setPactNo(lnDue.getPactNo());
		aftRewPact.setPrdtNo(lnDue.getPrdtNo());
		aftRewPact.setProjNo(lnDue.getProjNo());
		aftRewPact.setRelId(lnDue.getAppId());
		//��ѯԤ��������Ϣ
		ParmRew parmRew = new ParmRew();
		parmRew.setRewNo("100013");
		ParmRewBo parmRewBo = (ParmRewBo) SourceTemplate.getSpringContextInstance().getBean("parmRewBo");
		parmRew = parmRewBo.getById(parmRew);
		//��Ԥ�����ñ����ȡ
		aftRewPact.setRewName(parmRew.getRewName());
		aftRewPact.setRewValue(parmRew.getRewValue());
		aftRewPact.setRewNo(parmRew.getRewNo());
		aftRewPact.setRewSts(parmRew.getRewSts());
		aftRewPact.setRewType(parmRew.getRewType());
		AftRewPactBo aftRewPactBo = (AftRewPactBo) SourceTemplate.getSpringContextInstance().getBean("aftRewPactBo");
		aftRewPactBo.insertForSplit(aftRewPact);
    }
	// �ſ�ɹ������LN_DUE���еķſ�״̬Ϊ02����
	public int lnDueUpdate(String appId,String dueNo,String dueSts){
		LnDue lnDue = new LnDue();
		lnDue.setAppId(appId);
		lnDue.setDueNo(dueNo);
		lnDue.setDueSts(dueSts);
		//ʹ��Bo��cifEval����и���
		LnDueBo lnDueBo = (LnDueBo) SourceTemplate.getSpringContextInstance().getBean("lnDueBo");
		int result = lnDueBo.dueStsUpdate(lnDue);
		return result;
	}
	
	public void sendMes(LnDue lnDue){
		String a=lnDue.getProjNo();
//		List<String> list = new ArrayList<String>();
//    	Connection conn=DBUtil.getConnection();
//    	Statement stmt=null;
//    	ResultSet rs = null;
//    	String sql ="select login_id from proj_mang where proj_no="+a;
//    	stmt = conn.createStatement();
//    	rs = stmt.executeQuery(sql);
//    	while(rs.next()){
//      list.add(rs.getString(1));					
//    	}
//    	conn.close();
//    	rs.close();
//    	stmt.close();
		ProjMang projMang=new ProjMang();
		projMang.setProjNo(a);
		
		ProjMangBo projMangBo = (ProjMangBo) SourceTemplate.getSpringContextInstance().getBean("projMangBo");
		List<ProjMang> projMangList = null;
		
		projMangList=projMangBo.getByIdLoginId(projMang);
		if(projMangList.equals(null)){
			
		}
		else{
		List<String> list = new ArrayList<String>();
		for(int i=0;i<projMangList.size();i++){
		list.add( projMangList.get(i).getLoginId());
		}
//    	String user[] = (String[])list.toArray(new String[list.size()]);
		String user[] = (String[])list.toArray(new String[list.size()]);
		String b=lnDue.getProjName();
    	String title=b;
        String contet="��������";
    	SendMessageEntity sendMessageEntity=new SendMessageEntity();
    	sendMessageEntity.setTitle(title);
    	sendMessageEntity.setContet(contet);
    	sendMessageEntity.setReciveUserNos(user);
    	sendMessageEntity.setSendType(SendMessageType.MESSAGE);
    	sendMessageEntity.setPasSubTypeEntity(PasSubTypeEntity.RewFundMessage);
    	try {
			SendMessageMain.sendMessage(sendMessageEntity);
		} catch (Exception e) {
			e.printStackTrace();
		}	
		}
	}
	
	// ��д����ķ���
	public String toString(){
		String ret = "";
		if( lnDue != null ){
			ret = "ҵ��ID��"+ lnDue.getAppId()+",��ͬ��ţ�"+lnDue.getPactNo();
		}
		return ret;
	}
}
