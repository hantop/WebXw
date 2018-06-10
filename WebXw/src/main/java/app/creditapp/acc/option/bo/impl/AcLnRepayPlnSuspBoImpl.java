package  app.creditapp.acc.option.bo.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import app.base.BaseService;
import app.base.ServiceException;
import app.creditapp.acc.loan.dao.AcLnMstDao;
import app.creditapp.acc.loan.entity.AcLnMst;
import app.creditapp.acc.option.bo.AcLnRepayPlnSuspBo;
import app.creditapp.acc.option.dao.AcLnRepayPlnSuspDao;
import app.creditapp.acc.option.entity.AcLnRepayPlnSusp;
import app.creditapp.inf.dao.WsRepyPlanDao;
import app.creditapp.inf.entity.WsRepyPlan;
import app.util.toolkit.Ipage;
/**
* Title: AcLnRepayPlnSuspBoImplImpl.java
* Description:
**/
public class AcLnRepayPlnSuspBoImpl extends BaseService implements AcLnRepayPlnSuspBo {

	Logger logger = Logger.getLogger(AcLnRepayPlnSuspBoImpl.class);
	private AcLnRepayPlnSuspDao acLnRepayPlnSuspDao;
	private AcLnMstDao acLnMstDao;
	private WsRepyPlanDao wsRepyPlanDao;

	public WsRepyPlanDao getWsRepyPlanDao() {
		return wsRepyPlanDao;
	}

	public void setWsRepyPlanDao(WsRepyPlanDao wsRepyPlanDao) {
		this.wsRepyPlanDao = wsRepyPlanDao;
	}

	public void del(AcLnRepayPlnSusp acLnRepayPlnSusp) throws ServiceException {
		try {
			acLnRepayPlnSuspDao.del(acLnRepayPlnSusp);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}

	public Ipage findByPage(Ipage ipg, AcLnRepayPlnSusp acLnRepayPlnSusp)
			throws ServiceException {
		try {
			ipg.initPageCounts(new Integer[] { (Integer) acLnRepayPlnSuspDao
					.getCount(acLnRepayPlnSusp) });// ��ʼ����ҳ��
			acLnRepayPlnSusp.setStartNumAndEndNum (ipg);
			ipg.setResult(acLnRepayPlnSuspDao.findByPage(acLnRepayPlnSusp));
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return ipg;
	}

	public AcLnRepayPlnSusp getById(AcLnRepayPlnSusp acLnRepayPlnSusp) throws ServiceException {
		try {
//			System.out.println(acLnRepayPlnSuspDao+"$$$$$$$$$$$"+lnPactDao);
			acLnRepayPlnSusp = acLnRepayPlnSuspDao.getById(acLnRepayPlnSusp);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return acLnRepayPlnSusp;
	}

	public void insert(AcLnRepayPlnSusp acLnRepayPlnSusp) throws ServiceException {
		try {
			acLnRepayPlnSuspDao.insert(acLnRepayPlnSusp);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}

	public void update(AcLnRepayPlnSusp acLnRepayPlnSusp) throws ServiceException {
		try {
			acLnRepayPlnSuspDao.update(acLnRepayPlnSusp);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}
	
	public List<String> getByBatchDisPact(String wsRepyPlanBatch) throws ServiceException {
		List<String> wsRepyPlanList = null;
		try {
			wsRepyPlanList = acLnRepayPlnSuspDao.getByBatchDisPact(wsRepyPlanBatch);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return wsRepyPlanList;
	}
	
	public void delByPactnoAndBrno(AcLnRepayPlnSusp acLnRepayPlnSusp) throws ServiceException {
		
		try {
			acLnRepayPlnSuspDao.delByPactnoAndBrno(acLnRepayPlnSusp);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		
	}
	
    public List<WsRepyPlan> getListByBatchAndPactno(AcLnRepayPlnSusp acLnRepayPlnSusp) throws ServiceException {
    	List<WsRepyPlan> wsRepyPlanList = null;
		try {
			wsRepyPlanList = acLnRepayPlnSuspDao.getListByBatchAndPactno(acLnRepayPlnSusp);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return wsRepyPlanList;
	}
	

	////����ƻ� ҵ���߼��ĺϷ����ж���д��sunmingyi
	public boolean validAcLnRepayPlnSusp(String acLnRepayPlnSuspBatch,String brNo){

		boolean result = false;
		//��¼��������ĳһ��ͬ���л���ƻ�
		List<WsRepyPlan> wsRepyPlanList = new ArrayList<WsRepyPlan>();
		
		//��ѯȥ�ظ��ĺ�ͬ��
		List<String> wsRepyPlnPactList = new ArrayList<String>();
		wsRepyPlnPactList = acLnRepayPlnSuspDao.getByBatchDisPact(acLnRepayPlnSuspBatch);
		
		AcLnRepayPlnSusp acLnRepayPlnSusp = new AcLnRepayPlnSusp();
		for(String pactNos:wsRepyPlnPactList){
			boolean passFlag = true;//�Ƿ�ͨ��У��
			//��ȡ����������Ϣ
			AcLnMst acLnMst = new AcLnMst();
			acLnMst.setPactNo(pactNos);
			acLnMst.setBrNo(brNo);
			acLnMst = acLnMstDao.getByPactNo(acLnMst);
			//�ж����ļ������ڣ�״̬Ϊ�ն��Ƿſ�ʧ�����ݣ��ú�ͬ��Ӧ�Ļ���ƻ�����
			if(acLnMst==null || acLnMst.getLoanSts()==null || acLnMst.getLoanSts().length()==0) {
				logger.info("��ͬ�ţ�"+pactNos+"�������ļ�������");
				continue; 
			}
			
			WsRepyPlan wsRepyPlan = new WsRepyPlan();
			wsRepyPlan.setPactNo(pactNos);
			wsRepyPlan.setBrNo(brNo);
			wsRepyPlan.setBatchNo(acLnRepayPlnSuspBatch);
			//1��ͬһ����ͬ�е�ÿ��Ӧ������֮�� PRCP_AMT(������)Ӧ���ڴ�����
			double totalPrcpAmt = wsRepyPlanDao.getPrcpAmtCount(wsRepyPlan);
			if(totalPrcpAmt!=acLnMst.getLoanAmt()) {
				logger.info("��ͬ�ţ�"+pactNos+"�ſ����뻹��ƻ�Ӧ�ձ����ܶ��");
				continue; 
			}
			
			//��ѯ�ú�ͬ�����л���ƻ�
			acLnRepayPlnSusp = new AcLnRepayPlnSusp();
			acLnRepayPlnSusp.setBatchNo(acLnRepayPlnSuspBatch);
			acLnRepayPlnSusp.setPactNo(pactNos);
			wsRepyPlanList = acLnRepayPlnSuspDao.getListByBatchAndPactno(acLnRepayPlnSusp);
			int perdNo = 1;
			for(WsRepyPlan wsRpl : wsRepyPlanList){
				//ÿһ�ڵ���Ϣ������ڵ���0
				if(wsRpl.getNormInt()<0){
					passFlag=false;
					logger.info("��ͬ�ţ�"+pactNos+"�ϴ��Ļ���ƻ��д�����ϢС��0����Ϣ");
					break;
				}
				
				//ͬһ����ͬ���ڴκű����������ġ�
				if(perdNo!=wsRpl.getCnt()){
					passFlag=false;
					logger.info("��ͬ�ţ�"+pactNos+"�ϴ��Ļ���ƻ��ڴκŲ�����");
					break;
				}
				
				perdNo += 1;
				
//				//ͬһ����ͬ���������=��������ĵ�����end_date��
//				if(wsRepyPlanList.size()==wsRpl.getCnt()){
//					if(!wsRpl.getEndDate().equals(acLnMst.getMtrDt())){
//						passFlag=false;
//						break;
//					}
//				}
				
			}
			//�ж��Ƿ�ͨ��У�飬ͨ�����򽫻���ƻ�����ac_ln_repay_pln_susp
			if (passFlag) {
				acLnRepayPlnSusp.setBrNo(brNo);
				acLnRepayPlnSusp.setPactNo(pactNos);
				acLnRepayPlnSuspDao.delByPactnoAndBrno(acLnRepayPlnSusp);

				for (WsRepyPlan wsRpl : wsRepyPlanList) {
					acLnRepayPlnSusp = new AcLnRepayPlnSusp();
					acLnRepayPlnSusp.setWsId(wsRpl.getWsId());
					acLnRepayPlnSusp.setBatchNo(wsRpl.getBatchNo());
					acLnRepayPlnSusp.setBrNo(wsRpl.getBrNo());
					acLnRepayPlnSusp.setPactNo(wsRpl.getPactNo());
					acLnRepayPlnSusp.setCnt(wsRpl.getCnt());
					acLnRepayPlnSusp.setBegDate(wsRpl.getBegDate());
					acLnRepayPlnSusp.setEndDate(wsRpl.getEndDate());
					acLnRepayPlnSusp.setTotalAmt(wsRpl.getTotalAmt());
					acLnRepayPlnSusp.setPrcpAmt(wsRpl.getPrcpAmt());
					acLnRepayPlnSusp.setNormInt(wsRpl.getNormInt());
					acLnRepayPlnSusp.setSts(wsRpl.getSts());
					acLnRepayPlnSusp.setTxDate(wsRpl.getTxDate());
					acLnRepayPlnSusp.setDealSts("01");
					acLnRepayPlnSusp.setDealDesc("������");
					
					acLnRepayPlnSuspDao.insert(acLnRepayPlnSusp);
				}
				result = true; 
			}
		}
		return result;
	}
	
	//�ж��Ƿ�����
	private boolean IsSeries(int[] num)
    {
		boolean b = true;
        for (int i = 0; i < num.length; i++)
        {
            if (num[i] != i + 1)
            {
                b = false;
                break;
            }
        }
        return b;
    }
	
	
	
	
	public AcLnRepayPlnSuspDao getAcLnRepayPlnSuspDao() {
		return acLnRepayPlnSuspDao;
	}

	public void setAcLnRepayPlnSuspDao(AcLnRepayPlnSuspDao acLnRepayPlnSuspDao) {
		this.acLnRepayPlnSuspDao = acLnRepayPlnSuspDao;
	}

	public AcLnMstDao getAcLnMstDao() {
		return acLnMstDao;
	}

	public void setAcLnMstDao(AcLnMstDao acLnMstDao) {
		this.acLnMstDao = acLnMstDao;
	}
}