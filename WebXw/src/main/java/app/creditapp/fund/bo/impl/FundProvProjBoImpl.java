package  app.creditapp.fund.bo.impl;

import java.math.BigDecimal;
import java.util.List;

import app.base.BaseService;
import app.base.ServiceException;
import app.creditapp.bat.entity.RptPrdtDaily;
import app.creditapp.fund.bo.FundProvProjBo;
import app.creditapp.fund.dao.FundBaseDao;
import app.creditapp.fund.dao.FundProvDao;
import app.creditapp.fund.dao.FundProvProjDao;
import app.creditapp.fund.dao.FundProvServiceDao;
import app.creditapp.fund.dao.FundProvSplitTermDao;
import app.creditapp.fund.dao.FundSplitDao;
import app.creditapp.fund.dao.FundSplitTermDao;
import app.creditapp.fund.entity.FundBase;
import app.creditapp.fund.entity.FundProv;
import app.creditapp.fund.entity.FundProvProj;
import app.creditapp.fund.entity.FundProvService;
import app.creditapp.fund.entity.FundProvSplitTerm;
import app.creditapp.fund.entity.FundSplit;
import app.creditapp.fund.entity.FundSplitTerm;
import app.creditapp.proj.dao.ProjParmDao;
import app.creditapp.proj.entity.ProjParm;
import app.creditapp.sys.dao.FundServiceRateDao;
import app.creditapp.sys.dao.PrdtBaseDao;
import app.creditapp.sys.entity.FundServiceRate;
import app.util.DateUtil;
import app.util.User;
import app.util.toolkit.Ipage;
import flex.messaging.io.ArrayList;
/**
* Title: FundProvProjBoImplImpl.java
* Description:
**/
public class FundProvProjBoImpl extends BaseService implements FundProvProjBo {

	private FundProvProjDao fundProvProjDao;
	private FundProvDao fundProvDao;
	private ProjParmDao projParmDao;
	private FundBaseDao fundBaseDao;
	private FundSplitTermDao fundSplitTermDao;
	private FundSplitDao fundSplitDao;
	private FundServiceRateDao fundServiceRateDao;
	private PrdtBaseDao prdtBaseDao;
	private FundProvSplitTermDao fundProvSplitTermDao;
	private FundProvServiceDao fundProvServiceDao;

	public void del(FundProvProj fundProvProj) throws ServiceException {
		try {
			fundProvProjDao.del(fundProvProj);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}

	public Ipage findByPage(Ipage ipg, FundProvProj fundProvProj)
			throws ServiceException {
		try {
			ipg.initPageCounts(new Integer[] { (Integer) fundProvProjDao
					.getCount(fundProvProj) });// ��ʼ����ҳ��
			fundProvProj.setStartNumAndEndNum (ipg);
			ipg.setResult(fundProvProjDao.findByPage(fundProvProj));
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return ipg;
	}
	public FundProvProj getById(FundProvProj fundProvProj) throws ServiceException {
		try {
			fundProvProj = fundProvProjDao.getById(fundProvProj);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return fundProvProj;
	}
	
	public List<FundProvProj> findAll(FundProvProj fundProvProj) throws ServiceException {
		List<FundProvProj> list = null;
		try {
			list = fundProvProjDao.findAll(fundProvProj);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return list;
	}
	
	/**
	 * @���� DHCC-ZLC
	 * @���� 2016-6-22
	 * @����˵��������������
	 * @���ز���: ���������Ŀ���ܱ�FundProvProj����
	 */
	public FundProvProj insert(FundProvProj fundProvProj) throws ServiceException {
		try {
			//��ȡid
			String provProjNo = fundProvProjDao.getProvProjNo();
			//��Ŀ����ɱ�
			BigDecimal finCost = DoDcm(0.00);
			//��Ŀ������������
			BigDecimal payAmt = DoDcm(0.00);
			//��Ŀ�����(���ȼ����μ�)
			BigDecimal managerFee = DoDcm(0.00);
			BigDecimal managerFee_super = DoDcm(0.00);
			BigDecimal managerFee_less = DoDcm(0.00);
			//��Ŀ����ѻ���(���ȼ����μ�)
			BigDecimal managerFee_super_parm = DoDcm(0.00);
			BigDecimal managerFee_less_parm = DoDcm(0.00);
			//�Ŵ������
			BigDecimal serviceFee = DoDcm(0.00) ;
			//������ʼ����
			String begDate = fundProvProj.getBegDate();
			String endDate = fundProvProj.getEndDate();
			//��ȡ��Ŀ���ñ��е���Ŀ�շ����ࣨ���ʱ��꣬���й���ѣ��Ŵ������3�еļ��֣�
			ProjParm projParm = new ProjParm();			
			projParm.setProjNo(fundProvProj.getProjNo());
			projParm = projParmDao.getById(projParm);
			//��Ŀ���շ�����
			String payType;
			
			if(projParm==null ){

			}
			payType = projParm.getTruPayType();
			//��ȡ���й������
			BigDecimal mangFeerate = new BigDecimal(Float.toString(projParm.getMangFeerate()));		
	/**************************�Ŵ�����Ѽ��㷽��start******************************************************/
//			if( "1".equals(payType.substring(2, 3))){
			if(payType.contains("3")){
				//����ͳ����ʼ��ǰһ������
				String before_Date = DateUtil.addByDay(fundProvProj.getBegDate(), -1);
		        //�Ŵ�����ѷ�ʽ���̶������ݣ��Լ����ʻ�ȡ
				FundServiceRate fundServiceRate = new FundServiceRate();
				fundServiceRate.setProjNo(fundProvProj.getProjNo());
				//ͳ�Ʒ���������0-û�У�1-�̶����ʣ�>1���ݷ���
				int fundServiceRate_count = (Integer) fundServiceRateDao.getCount(fundServiceRate);
				Ipage ipage = new Ipage();
				ipage.setPageSize(fundServiceRate_count);	
				fundServiceRate.setStartNumAndEndNum(ipage);
				List<FundServiceRate> fundServiceRateList = fundServiceRateDao.findByPage(fundServiceRate);
				RptPrdtDaily rptPrdtDaily= new RptPrdtDaily();
				rptPrdtDaily.setProjNo(fundProvProj.getProjNo());
				if(fundServiceRate_count == 0){
					serviceFee = DoDcm(0.00);
				}else if(fundServiceRate_count == 1){
					//ͳ�������ڣ���Ŀ����ͳ�Ʋ�Ʒ����ķŴ����ͬ��Ʒ��Ӧ���ۿ��ʲ�ͬ
					//��ȡ�Ŵ��������
					fundServiceRate = fundServiceRateList.get(0);
					//��ȡ����Ʒ�ķŴ��� (���ᵽ�����ۼƷŴ���-���Ὺʼǰһ��ķŴ���)
					//�����ڷŴ�������ۼ�
					String startdate=fundProvProj.getBegDate();
               	    while(fundProvProj.getEndDate().compareTo(startdate) > 0){
               	    	BigDecimal day_amt = new BigDecimal("0.00");
               	    	rptPrdtDaily.setRptDate(startdate);
               	    	day_amt = get_dayamt(rptPrdtDaily,fundServiceRate.getSvRate());
               	    	//���ڼ�1
               	    	startdate = DateUtil.addByDay(startdate, 1);
               	        //�����ڿ�ʼ���ڵ��������ڵķŴ������
               	    	serviceFee = serviceFee.add(day_amt);
               	    }  
               	    //������������Ŵ��������ϸ��FUND_PROV_SERVICE
               	    rptPrdtDaily.setRptDate(DateUtil.addByDay(begDate, -1));
               	    //rptPrdtDaily.setRptDate(begDate);
               	    //���õ�������
               	    rptPrdtDaily.setPrdtNo(endDate);
        		    List<RptPrdtDaily> rptPrdtDailyList = fundProvProjDao.RptRrdtDailygetByprdtno( rptPrdtDaily);
        		    BigDecimal Rate = FoDcm(fundServiceRate.getSvRate());
        		    BigDecimal amt = new BigDecimal("0.00");
        	        for(int i=0;i<rptPrdtDailyList.size();i++){
        		    //����Ʒ����Ŵ������
        	        BigDecimal Prdt_amt = new BigDecimal("0.00");
        		    rptPrdtDaily = rptPrdtDailyList.get(i);
        		    //һ����Ʒ���ۼƷŴ������
        		    BigDecimal AmtTot = DoDcm(rptPrdtDaily.getAmtTot());
        		    BigDecimal OffRate = FoDcm(rptPrdtDaily.getOffRate());
        		    Prdt_amt = AmtTot.multiply(Rate).multiply(OffRate);
        		    amt = amt.add(Prdt_amt);
        		    
                   	FundProvService fundProvService = new FundProvService();
                   	fundProvService.setProvProjNo(provProjNo);
                   	fundProvService.setProjNo(fundProvProj.getProjNo());
                   	fundProvService.setStepNo(fundServiceRate.getStepNo());
                   	fundProvService.setMaxAmt(fundServiceRate.getMaxAmt());
                   	fundProvService.setMinAmt(fundServiceRate.getMinAmt());
                   	fundProvService.setSvRate(fundServiceRate.getSvRate());
                   	fundProvService.setJtBegDate(begDate);
                   	fundProvService.setJtEndDate(endDate);
                   	fundProvService.setPrdtNo(rptPrdtDaily.getPrdtNo());
                   	fundProvService.setPrdtDueAmt(rptPrdtDaily.getAmtTot());
                   	fundProvService.setPrdtName("");
                   	fundProvService.setPrdtServicefee(Prdt_amt.doubleValue());
                   	fundProvService.setServicefee(amt.doubleValue());
                   	fundProvService.setOffRate(rptPrdtDaily.getOffRate());
                   	fundProvService.setOpNo(fundProvProj.getOpNo());
                   	fundProvService.setTxDate((User.getTime().replace("-", "")).substring(0, 8));

                   	fundProvServiceDao.insert(fundProvService);
        	         }                  	    
					}else{
					//��ʷ�Ŵ���ģ
					rptPrdtDaily.setRptDate(before_Date);
					Double before_amt = fundProvProjDao.RptRrdtDailygetByProjNoamt(rptPrdtDaily);
					//��������ն�Ӧ�Ŵ���ģ
					rptPrdtDaily.setRptDate(fundProvProj.getEndDate());
					Double end_amt = fundProvProjDao.RptRrdtDailygetByProjNoamt(rptPrdtDaily);					
					//��ʷ�Ŵ���ģ���ݱ��
					String min_stepNo = null;
					//��������շŴ���ģ���ݱ��
					String now_stepNo = null;
					//1.��ȡ�ۼƵ����Ὺʼ��֮ǰ�ķŴ���ٱ����Ŵ�������ʵķ��ʽ׶�(n1)����ȡ�ۼƵ������յ��ۼƷŴ���ٱ����Ŵ�������ʵķ��ʽ׶�(nn)
					FundServiceRate min_fundServiceRate = null;
					FundServiceRate max_fundServiceRate = null;
					for(int i=0;i<fundServiceRateList.size();i++){
						FundServiceRate fundServiceRate1 = fundServiceRateList.get(i);
						if((fundServiceRate1.getMinAmt()<before_amt && before_amt<=fundServiceRate1.getMaxAmt())||
								(fundServiceRate1.getMinAmt()<before_amt && fundServiceRate1.getMaxAmt()== 0)){
							min_stepNo = fundServiceRate1.getStepNo();
							min_fundServiceRate = fundServiceRate1;
							
						}
						if((fundServiceRate1.getMinAmt()<end_amt && end_amt<=fundServiceRate1.getMaxAmt())||
								(fundServiceRate1.getMinAmt()<end_amt && fundServiceRate1.getMaxAmt()== 0)){
							now_stepNo = fundServiceRate1.getStepNo();
							max_fundServiceRate = fundServiceRate1;
						}
					}
                    //2.�ж�n1��nn�Ƿ���һ���׶�:
					if(min_fundServiceRate == max_fundServiceRate){
						//3.1.n1=nn�����ǿ�׶�
						//��ȡ����Ʒ�ķŴ��� (���ᵽ�����ۼƷŴ���-���Ὺʼǰһ��ķŴ���)
    						//�����ڷŴ�������ۼ�
						     String now_date = begDate;
                       	    while(fundProvProj.getEndDate().compareTo(now_date) >= 0){
                       	    	BigDecimal day_amt ;
                       	    	rptPrdtDaily.setRptDate(now_date);
                       	    	day_amt = get_dayamt(rptPrdtDaily,min_fundServiceRate.getSvRate());
                       	    	//���ڼ�1
                       	    	now_date = DateUtil.addByDay(now_date, 1);
                       	        //�����ڿ�ʼ���ڵ��������ڵķŴ������
                       	    	serviceFee = serviceFee.add(day_amt);
                       	    }    
                       	 //������������Ŵ��������ϸ��FUND_PROV_SERVICE
                       	    rptPrdtDaily.setRptDate(DateUtil.addByDay(begDate, -1));
                       	    //���õ�������
                       	    rptPrdtDaily.setPrdtNo(endDate);
                		    List<RptPrdtDaily> rptPrdtDailyList = fundProvProjDao.RptRrdtDailygetByprdtno( rptPrdtDaily);
                		    BigDecimal Rate = FoDcm(min_fundServiceRate.getSvRate());
                		    BigDecimal amt = new BigDecimal("0.00");
                	        for(int i=0;i<rptPrdtDailyList.size();i++){
                		    //����Ʒ����Ŵ������
                	        BigDecimal Prdt_amt = new BigDecimal("0.00");
                		    rptPrdtDaily = rptPrdtDailyList.get(i);
                		    //һ����Ʒ���ۼƷŴ������
                		    BigDecimal AmtTot = DoDcm(rptPrdtDaily.getAmtTot());
                		    BigDecimal OffRate = FoDcm(rptPrdtDaily.getOffRate());
                		    Prdt_amt = AmtTot.multiply(Rate).multiply(OffRate);
                		    amt = amt.add(Prdt_amt);
                		    
                           	FundProvService fundProvService = new FundProvService();

                           	fundProvService.setProjNo(fundProvProj.getProjNo());
                           	fundProvService.setProvProjNo(provProjNo);
                           	fundProvService.setStepNo(min_fundServiceRate.getStepNo());
                           	fundProvService.setMaxAmt(min_fundServiceRate.getMaxAmt());
                           	fundProvService.setMinAmt(min_fundServiceRate.getMinAmt());
                           	fundProvService.setSvRate(min_fundServiceRate.getSvRate());
                           	fundProvService.setJtBegDate(begDate);
                           	fundProvService.setJtEndDate(endDate);
                           	fundProvService.setPrdtNo(rptPrdtDaily.getPrdtNo());
                           	fundProvService.setPrdtDueAmt(rptPrdtDaily.getAmtTot());
                           	fundProvService.setPrdtName("");
                           	fundProvService.setPrdtServicefee(Prdt_amt.doubleValue());
                           	fundProvService.setServicefee(amt.doubleValue());
                           	fundProvService.setOffRate(rptPrdtDaily.getOffRate());
                           	fundProvService.setOpNo(fundProvProj.getOpNo());
                           	fundProvService.setTxDate((User.getTime().replace("-", "")).substring(0, 8));

                           	fundProvServiceDao.insert(fundProvService);
                	         }          
					}else{
						//3.2.nn <> n1��nn��n1֮���ʱ��ڵ㣨�ۼƵ�ÿ�׶����ֵʱ������n1�׶�date_1,...,n(n-1)�׶�date_(n-1)��
						
						fundServiceRate = min_fundServiceRate;
						//��ʼʱ��
						String begin_date = begDate;
 					    //���ò���--������������Ŵ��������ϸ��FUND_PROV_SERVICE
						List<FundProvService> fundProvServicelist = new ArrayList() ;
						List<FundProvService> fundProvServicelist_next = new ArrayList() ;
						//�жϵ�ǰ���ݵ����ֵ�Ƿ���������ݵ����ֵ
                         while(fundServiceRate.getMaxAmt()<=max_fundServiceRate.getMaxAmt()){
                        	 //�ۼƴ�������������޵��������
                        	String stage_max_date ;
                        	//�ۼƵ����ݽڵ������
     						String date = null;
     						//������һ�׶εķ������ʵ����
    						FundServiceRate next_fundServiceRate = new FundServiceRate();
  					    	next_fundServiceRate.setProjNo(fundProvProj.getProjNo());
 					    	next_fundServiceRate.setMinAmt(fundServiceRate.getMaxAmt());
 					    	next_fundServiceRate = fundServiceRateDao.getByProjAndMinamt(next_fundServiceRate);
                        	//��ȡ��ǰ�������޶�Ӧ���ۼƷŴ���С�ڽ������޵����ڣ�stage_max_date
 					    	RptPrdtDaily rptPrdtDaily1 = new RptPrdtDaily();
 					    	rptPrdtDaily1.setProjNo(fundProvProj.getProjNo());
 					    	rptPrdtDaily1.setAmtTot(fundServiceRate.getMaxAmt());
 					    	rptPrdtDaily1 = fundProvProjDao.RptRrdtDailygetBymaxDate(rptPrdtDaily1);
 					    	//�жϽ�����������ڣ�����������ݣ�������ھ��Ǽ���������ڣ�
 					    	Double reult = fundServiceRate.getMaxAmt()-max_fundServiceRate.getMaxAmt();
 					    	if(reult == 0 ){
 					    		stage_max_date = fundProvProj.getEndDate();	
 					    		date = DateUtil.addByDay(stage_max_date, 1);
 					    	}else{
 					    		stage_max_date = rptPrdtDaily1.getRptDate();	
 	                       	//------start�ۼƵ��������޵����ڼ��㷽��start---------
         						//��������
         						date = DateUtil.addByDay(stage_max_date, 1);
         						//��������ǰһ����ۼƷŴ����
         						Double amt = fundProvProjDao.RptRrdtDailygetByProjNoamt(rptPrdtDaily1);
         						BigDecimal less_date_amt = DoDcm(amt);
         						//���㵽�ڵ㻹����ٽ��
         						BigDecimal less_amt = DoDcm(fundServiceRate.getMaxAmt()).subtract(less_date_amt);
         						//��ȡ�����յĵ��ղ�Ʒ������
         						rptPrdtDaily.setRptDate(date);
    						   
         						List<RptPrdtDaily> rptPrdtDailyList = fundProvProjDao.RptRrdtDailygetByPrdtNoamt(rptPrdtDaily);
         				        for(int i=0;i<rptPrdtDailyList.size();i++){
         					    //����һ���ݷŴ������
         				        BigDecimal PrdtNoamt_down = DoDcm(0.00);
         					    //����һ���ݷŴ������
         				        BigDecimal PrdtNoamt_up = DoDcm(0.00);
         					    //���μ���Ŵ������
         				        BigDecimal PrdtNoamt = DoDcm(0.00);
         					    RptPrdtDaily rptPrdtDaily2 = rptPrdtDailyList.get(i);
     					    
         					    if(less_amt.compareTo(DoDcm(rptPrdtDaily2.getAmtTot()))>=0){
         						    //����һ����Ʒ�Ŵ������       					    	
         						    PrdtNoamt = DoDcm(rptPrdtDaily2.getAmtTot()).multiply(FoDcm(fundServiceRate.getSvRate())).multiply(FoDcm(rptPrdtDaily2.getOffRate()));
         						    PrdtNoamt_down = PrdtNoamt_down.add(PrdtNoamt);
         						    less_amt= less_amt.subtract(DoDcm(rptPrdtDaily2.getAmtTot()));
         						    
             					    //���ò���--������������Ŵ��������ϸ��FUND_PROV_SERVICE
         						    FundProvService fundProvService = new FundProvService();
         						    fundProvService.setProjNo(fundProvProj.getProjNo());
         						    fundProvService.setPrdtNo(rptPrdtDaily2.getPrdtNo());
         						    fundProvService.setPrdtDueAmt(rptPrdtDaily2.getAmtTot());
         						    fundProvService.setStepNo(fundServiceRate.getStepNo());
         						    fundProvService.setSvRate(fundServiceRate.getSvRate());
         						    fundProvService.setOffRate(rptPrdtDaily2.getOffRate());
         						    fundProvServicelist.add(fundProvService);
         						   
         					    }else{
         					    	//����һ����Ʒ������һ���ݲ��ֹ�ģ
         					    	BigDecimal less_prdtbal = DoDcm(rptPrdtDaily2.getAmtTot()).subtract(less_amt);
         					    	
         					    	//���ò���--������������Ŵ��������ϸ��FUND_PROV_SERVICE
         					    	if(less_prdtbal.doubleValue()>0){
             						    FundProvService fundProvService = new FundProvService();
             						    fundProvService.setProjNo(fundProvProj.getProjNo());
             						    fundProvService.setPrdtNo(rptPrdtDaily2.getPrdtNo());
             						    fundProvService.setPrdtDueAmt(less_prdtbal.doubleValue());
             						    fundProvService.setStepNo(next_fundServiceRate.getStepNo());
             						    fundProvService.setOffRate(rptPrdtDaily2.getOffRate());
             						    fundProvService.setSvRate(next_fundServiceRate.getSvRate());
             						    fundProvServicelist_next.add(fundProvService);
         					    	}
         					    	//����һ����Ʒ����һ���ݲ��ַŴ������
         					    	PrdtNoamt = less_prdtbal.multiply(FoDcm(next_fundServiceRate.getSvRate())).multiply(FoDcm(rptPrdtDaily2.getOffRate()));
         					    	PrdtNoamt_up = PrdtNoamt_up.add(PrdtNoamt);
         					    	//����һ����Ʒ����һ���ݲ��ַŴ������
         					    	PrdtNoamt = less_amt.multiply(FoDcm(fundServiceRate.getSvRate())).multiply(FoDcm(rptPrdtDaily2.getOffRate()));
         					    	
         					    	//���ò���--������������Ŵ��������ϸ��FUND_PROV_SERVICE
         					    	if(less_amt.doubleValue()>0){
             						    FundProvService fundProvService = new FundProvService();
             						    fundProvService.setProjNo(fundProvProj.getProjNo());
             						    fundProvService.setPrdtNo(rptPrdtDaily2.getPrdtNo());
             						    fundProvService.setPrdtDueAmt(less_amt.doubleValue());
             						    fundProvService.setOffRate(rptPrdtDaily2.getOffRate());
             						    fundProvService.setStepNo(fundServiceRate.getStepNo());
             						    fundProvService.setSvRate(fundServiceRate.getSvRate());
             						    fundProvServicelist.add(fundProvService);
         					    	}
         					    	PrdtNoamt_down = PrdtNoamt_down.add(PrdtNoamt);
         					    	less_amt = DoDcm(0.00);
         					    }
         					    serviceFee = serviceFee.add(PrdtNoamt_down.add(PrdtNoamt_up));
         				       }
         				      //------���ݽڵ��ռ��㷽��end---------
 					    	}
     				     
                        //���㲻�ǽ��ݵ����ڵķŴ������	 
 					    	
 					    	if(stage_max_date.compareTo(begin_date)>=0){
 					    		rptPrdtDaily.setRptDate(DateUtil.addByDay(begin_date, -1));
 					    	//������������Ŵ��������ϸ��FUND_PROV_SERVICE--start
                     	    //���õ�������
                     	    rptPrdtDaily.setPrdtNo(stage_max_date);
              		        List<RptPrdtDaily> rptPrdtDailyList = fundProvProjDao.RptRrdtDailygetByprdtno(rptPrdtDaily);
              		        BigDecimal Rate = FoDcm(fundServiceRate.getSvRate());
              		        BigDecimal amt = new BigDecimal("0.00");
              	            for(int i=0;i<rptPrdtDailyList.size();i++){
              		        //����Ʒ����Ŵ������
              	            BigDecimal Prdt_amt = new BigDecimal("0.00");
              	            RptPrdtDaily rptPrdtDaily3 = rptPrdtDailyList.get(i);
              		        //һ����Ʒ���ۼƷŴ������
              		        BigDecimal amtTot = DoDcm(rptPrdtDaily3.getAmtTot());
              		        BigDecimal OffRate = FoDcm(rptPrdtDaily3.getOffRate());
              		       
              		        //ѭ������������dateʱ��ͬ��Ʒ�ڱ������ڽ��
              		          for(int j=0;j<fundProvServicelist.size();j++){
              		        	 if(rptPrdtDaily3.getPrdtNo().equals(fundProvServicelist.get(j).getPrdtNo())){
              		        		amtTot = amtTot.add(DoDcm(fundProvServicelist.get(j).getPrdtDueAmt()));
              		        		Prdt_amt = amtTot.multiply(Rate).multiply(OffRate);
                       		        amt = amt.add(Prdt_amt);
              		        	 }
              		          }
            		         
                         	FundProvService fundProvService = new FundProvService();
                         	fundProvService.setProvProjNo(provProjNo);
                           	fundProvService.setProjNo(fundProvProj.getProjNo());
                           	fundProvService.setStepNo(fundServiceRate.getStepNo());
                           	fundProvService.setMaxAmt(fundServiceRate.getMaxAmt());
                           	fundProvService.setMinAmt(fundServiceRate.getMinAmt());
                           	fundProvService.setSvRate(fundServiceRate.getSvRate());
                           	fundProvService.setJtBegDate(begDate);
                           	fundProvService.setJtEndDate(endDate);
                           	fundProvService.setPrdtNo(rptPrdtDaily3.getPrdtNo());
                        	fundProvService.setPrdtName("");
                           	fundProvService.setPrdtDueAmt(amtTot.doubleValue());
                           	fundProvService.setPrdtServicefee(Prdt_amt.doubleValue());
                           	fundProvService.setServicefee(amt.doubleValue());
                           	fundProvService.setOffRate(rptPrdtDaily3.getOffRate());
                           	fundProvService.setOpNo(fundProvProj.getOpNo());
                           	fundProvService.setTxDate((User.getTime().replace("-", "")).substring(0, 8));

                           	fundProvServiceDao.insert(fundProvService);
                           	//�����Ŀ����ķ����
              	            }
                           }else{
                        	 //������������Ŵ��������ϸ��FUND_PROV_SERVICE--start 
                        	   BigDecimal amt = new BigDecimal("0.00");
                        	   for(int j=0;j<fundProvServicelist.size();j++){    
                 		        	fundProvServicelist.get(j).getPrdtNo();
                      		        //һ����Ʒ���ۼƷŴ������
                 		        	 BigDecimal Prdt_amt = DoDcm(fundProvServicelist.get(j).getPrdtDueAmt()).multiply(FoDcm(fundServiceRate.getSvRate())).multiply(FoDcm(fundProvServicelist.get(j).getOffRate()));
                 		        	 amt = amt.add(Prdt_amt);
                      		        
                            	FundProvService fundProvService = new FundProvService();
                            	fundProvService.setProvProjNo(provProjNo);
                               	fundProvService.setProjNo(fundProvProj.getProjNo());
                               	fundProvService.setStepNo(fundServiceRate.getStepNo());
                               	fundProvService.setMaxAmt(fundServiceRate.getMaxAmt());
                               	fundProvService.setMinAmt(fundServiceRate.getMinAmt());
                               	fundProvService.setSvRate(fundServiceRate.getSvRate());
                               	fundProvService.setJtBegDate(begDate);
                               	fundProvService.setJtEndDate(endDate);
                               	fundProvService.setPrdtNo(fundProvServicelist.get(j).getPrdtNo());
                            	fundProvService.setPrdtName("");
                               	fundProvService.setPrdtDueAmt(fundProvServicelist.get(j).getPrdtDueAmt());
                               	fundProvService.setPrdtServicefee(Prdt_amt.doubleValue());
                               	fundProvService.setServicefee(amt.doubleValue());
                               	fundProvService.setOffRate(fundProvServicelist.get(j).getOffRate());
                               	fundProvService.setOpNo(fundProvProj.getOpNo());
                               	fundProvService.setTxDate((User.getTime().replace("-", "")).substring(0, 8));

                               	fundProvServiceDao.insert(fundProvService);
                        	   }
                           };
                          //������������Ŵ��������ϸ��FUND_PROV_SERVICE--end
              	            
    						//�����ڷŴ�������ۼ�
                       	    while(stage_max_date.compareTo(begin_date) >= 0){
                       	    	BigDecimal day_amt = DoDcm(0.00);
                       	    	rptPrdtDaily.setRptDate(begin_date);
                       	    	day_amt = get_dayamt(rptPrdtDaily,fundServiceRate.getSvRate());
                       	    	//���ڼ�1
                       	    	begin_date = DateUtil.addByDay(begin_date, 1);
                       	        //�����ڿ�ʼ���ڵ��������ڵķŴ������
                       	    	serviceFee = serviceFee.add(day_amt);
                       	    }
                       	  //�ж������һ��Ϊ�յ��������  
                       	  if(fundProvServicelist_next.size()<1){
                       		fundServiceRate.setMaxAmt(fundServiceRate.getMaxAmt()+1); 
                       	  }else{
                       		fundProvServicelist.clear();
                       		fundProvServicelist.addAll(fundProvServicelist_next);
                       		fundProvServicelist_next.clear();
                       		fundServiceRate = next_fundServiceRate;
                       	  }
       				      begin_date = DateUtil.addByDay(date, 1);
                         }						
					}
				}
			}
	/**************************�Ŵ�����Ѽ��㷽��end******************************************************/
			
	/**************************���ʱ�����㷽��end*******************************************************/
				 //���ʽ������л�ȡ��Ŀ��Ӧ���ʽ���Ϣ
				FundBase fundBase = new FundBase();
				fundBase.setProjNo(fundProvProj.getProjNo());
				    //����ʽ�������
				int fund_base_count = fundBaseDao.getCount(fundBase);
				Ipage ipage = new Ipage();
				ipage.setPageSize(fund_base_count);		
				fundBase.setStartNumAndEndNum(ipage);
				  //��������ʽ�����
				List<FundBase> fundBaseList= fundBaseDao.findByPage(fundBase);
				 //����ÿ���ʽ�����
				for(int i=0;i<fundBaseList.size();i++){
					  //�ʽ����ʳɱ�
					BigDecimal fund_fineCost =  DoDcm(0.00);
					  // �ʽ�����������ʹ�ģ��������
					BigDecimal fund_fineCost_parm = DoDcm(0.00);
					  //�ʽ�ά������������
					BigDecimal fund_payAmt =  DoDcm(0.00);
					  //��ȡ�ʽ������Ϣ
					fundBase = fundBaseList.get(i);
					//�������ʳɱ�
					BigDecimal financerate = FoDcm(fundBase.getFinanceRate());
					  //�ӷ��䷽���������л�ȡ����
					FundSplitTerm fundSplitTerm = new FundSplitTerm();
					//�ʽ��Ÿ�ֵ
					fundSplitTerm.setFundNo(fundBase.getFundNo());

				    //����ʽ�������
					int fund_plitterm_count = fundSplitTermDao.getCount(fundSplitTerm);
					Ipage ipage1 = new Ipage();
					ipage1.setPageSize(fund_plitterm_count);
					fundSplitTerm.setStartNumAndEndNum(ipage1);
					List<FundSplitTerm> fundSplitTermList= fundSplitTermDao.findByPage(fundSplitTerm);
 					for(int j=0;j<fundSplitTermList.size();j++){
						// ���ʼ����
						String maxbegDate;
						// ��С��������
						String minendDate;
						//�����������ʹ�ģ��������
						BigDecimal term_fineCost_parm ;
						//�������������������ģ
						BigDecimal term_payAmt;						
						
						fundSplitTerm=fundSplitTermList.get(j);
						String begtermDate = fundSplitTerm.getBegDate(); 
						String endtermDate = fundSplitTerm.getEndDate();

						//�ж���������ʱ����Ƿ���ڽ���������ڣ��ҳ����ʼ���ڣ���С��������
						if(((begtermDate.compareTo(begDate) <=0) && begDate.compareTo(endtermDate) < 0) || 
							((begtermDate.compareTo(begDate) > 0) && (begtermDate.compareTo(endDate)) < 0)	){
							if(begtermDate.compareTo(begDate) > 0){
								maxbegDate = begtermDate ;
							}else {
								maxbegDate = begDate ;
							}
							if(endtermDate.compareTo(endDate) > 0 ){
								minendDate = endDate;
							}else{
								minendDate = endtermDate;
							}
							//����һ��������¼��һ�����������ڵ�����
							int days=DateUtil.getBetweenDays(DateUtil.changeToShow(maxbegDate), DateUtil.changeToShow(minendDate));
							//����ñʶ�Ӧ�����ʳɱ�=���*��������*����/���������ʽ�ģ�
							//term_fineCost=(fundSplitTerm.getTermAmt())*(fundBase.getFinanceRate())*days/(fundBase.getYearDays());
							//�����������ʹ�ģ��������
                            term_fineCost_parm=DoDcm(fundSplitTerm.getTermAmt()).multiply(IoDcm(days)).divide(IoDcm(fundBase.getYearDays()),3,BigDecimal.ROUND_HALF_UP);
							//�ӷ��䷽����ȡ������
							FundSplit fundSplit = new FundSplit();
							fundSplit.setPartNo(fundSplitTerm.getPartNo());
							fundSplit = fundSplitDao.getById(fundSplit);
	
							//����ñʶ�Ӧ������������payAmt=���*������*����/�����������䷽���ģ�
							BigDecimal invRate = FoDcm(fundSplitTerm.getInvRate());
							BigDecimal termAmt = DoDcm(fundSplitTerm.getTermAmt());
							term_payAmt=(invRate.multiply(termAmt)).multiply(IoDcm(days)).divide(IoDcm(fundBase.getYearDays()),3,BigDecimal.ROUND_HALF_UP);
						    
							//��������������ʱ��꣬�������ϸ�ǼǱ�FUND_PROV_SPLIT_TERM
							FundProvSplitTerm fundProvSplitTerm = new FundProvSplitTerm();
							fundProvSplitTerm.setProvProjNo(provProjNo);
							fundProvSplitTerm.setProjNo(fundProvProj.getProjNo());
							fundProvSplitTerm.setFundNo(fundBase.getFundNo());
							fundProvSplitTerm.setPartNo(fundSplitTerm.getPartNo());
							fundProvSplitTerm.setTermNo(fundSplitTerm.getTermNo());
							fundProvSplitTerm.setTermAmt(fundSplitTerm.getTermAmt());
							fundProvSplitTerm.setBegDate(fundSplitTerm.getBegDate());
							fundProvSplitTerm.setEndDate(fundSplitTerm.getEndDate());
							fundProvSplitTerm.setJtBegDate(begDate);
							fundProvSplitTerm.setJtEndDate(endDate);
							fundProvSplitTerm.setDays(days);
							fundProvSplitTerm.setYearDays(fundBase.getYearDays());
							fundProvSplitTerm.setFinanceRate(fundBase.getFinanceRate());
							fundProvSplitTerm.setFinCost(financerate.multiply(term_fineCost_parm).doubleValue());
							fundProvSplitTerm.setInvRate(fundSplitTerm.getInvRate());
							fundProvSplitTerm.setPayAmt(term_payAmt.doubleValue());
							fundProvSplitTerm.setFinlIncome(financerate.multiply(term_fineCost_parm).subtract(term_payAmt).doubleValue());
							fundProvSplitTerm.setManagerRate(mangFeerate.floatValue());
							fundProvSplitTerm.setManagerFee(mangFeerate.multiply(term_fineCost_parm).doubleValue());
							fundProvSplitTerm.setOpNo(fundProvProj.getOpNo());
							fundProvSplitTerm.setTxDate((User.getTime().replace("-", "")).substring(0, 8));
							fundProvSplitTermDao.insert(fundProvSplitTerm);
						}else{
							term_fineCost_parm = DoDcm(0.00);
							term_payAmt = DoDcm(0.00);
						}
						fund_fineCost_parm =fund_fineCost_parm.add(term_fineCost_parm);
						fund_payAmt =fund_payAmt.add(term_payAmt);
					}
    /************************************************************************************************/ 					
 	/**##########�ж��ʽ�����Ϊ���ȼ��ʽ������ʱ���############ **/
					if("01".equals(fundBase.getFdType())){
	/**##########���ʱ�����㷽��############ **/
//						if("1".equals(payType.substring(3, 4))){
						if(payType.contains("4")){
							BigDecimal fundfineCostparm = fund_fineCost_parm;
							fund_fineCost = financerate.multiply(fundfineCostparm);
							//�ʽ�ά�ȵ����ʳɱ������ʽ�ά�ȵ����������治Ϊ��
                            if(fund_fineCost.doubleValue() != 0 || fund_payAmt.doubleValue()!=0){
    							FundProv fundProv = new FundProv();		

    							fundProv.setProvProjNo(provProjNo);
    							fundProv.setProjNo(fundProvProj.getProjNo());	
    							fundProv.setFundNo(fundBase.getFundNo());
    							fundProv.setFundName(fundBase.getFundName());
    							fundProv.setBegDate(begDate);
    							fundProv.setEndDate(endDate);
    							fundProv.setFdAmt(fundBase.getFdAmt());
    							fundProv.setFinRate(fundBase.getFinanceRate());
    							fundProv.setFineCost(fund_fineCost.doubleValue());
    							fundProv.setPayAmt(fund_payAmt.doubleValue());
    							fundProv.setFinIncome(fund_fineCost.subtract(fund_payAmt).doubleValue());
    							fundProv.setOpNo(fundProvProj.getOpNo());
    							fundProv.setTxDate((User.getTime().replace("-", "")).substring(0, 8));					
    							//�����ʽ�����ʱ�������
    							fundProvDao.insert(fundProv);                            	
                            }

						}
						//��Ŀ�ۼ����ʳɱ���������������
						finCost=finCost.add(fund_fineCost);
						payAmt=payAmt.add(fund_payAmt);
						//��Ŀ�ۼƼ������й���ѵĻ���
						managerFee_super_parm=managerFee_super_parm.add(fund_fineCost_parm);
					}else{
						managerFee_less_parm=managerFee_less_parm.add(fund_fineCost_parm);
					}
					
				}
	/*********************************������Ŀ�������***************************************************/ 	
			   //2.������Ŀ������ã�managerFee_parm*mangFeerate
//				if( "1".equals(payType.substring(0, 1))){
				if(payType.contains("1")){
					//2.1���й���Ѽ��㷽��-���ȼ�
					managerFee_super = managerFee_super_parm.multiply(mangFeerate);
				}
//				if( "1".equals(payType.substring(1, 2))){
				if(payType.contains("2")){
					//2.2���й���Ѽ��㷽��-�μ�
					managerFee_less = managerFee_less_parm.multiply(mangFeerate);
				}
				managerFee=managerFee_super.add(managerFee_less);
	/*********************************������Ŀ�������***************************************************/ 	
	/********************���ܸ����ò������������ܱ�*********************/ 

			   //�ܽ��drawingAmt
			Double drawingAmt = managerFee.add(serviceFee).add(finCost.subtract(payAmt)).doubleValue();
			fundProvProj.setProvProjNo(provProjNo);
			fundProvProj.setProjName(projParm.getProjName());
			fundProvProj.setFinCost(finCost.doubleValue());
			fundProvProj.setPayAmt(payAmt.doubleValue());
			fundProvProj.setFinlIncome(finCost.subtract(payAmt).doubleValue());
			fundProvProj.setManagerFee(managerFee.doubleValue());
			fundProvProj.setServiceFee(serviceFee.doubleValue());
			fundProvProj.setDrawingAmt(drawingAmt);
			fundProvProj.setTxDate((User.getTime().replace("-", "")).substring(0, 8));
			fundProvProjDao.insert(fundProvProj);
			fundProvProj=fundProvProjDao.getById(fundProvProj);

		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return fundProvProj;
	}
	/**
	 * @���� DHCC-ZLC
	 * @���� 2016-6-27
	 * @����˵����һ��Ŵ������
	 * @���ز��� BigDecimal
	 */
	public BigDecimal get_dayamt(RptPrdtDaily rptPrdtDaily,Float SvRate)throws ServiceException {
		BigDecimal amt = new BigDecimal("0.00") ;
		BigDecimal Rate = FoDcm(SvRate);
       try {
		    List<RptPrdtDaily> rptPrdtDailyList = fundProvProjDao.RptRrdtDailygetByPrdtNoamt( rptPrdtDaily);
	        for(int i=0;i<rptPrdtDailyList.size();i++){
		    //����Ʒ����Ŵ������
	        BigDecimal Prdt_amt = new BigDecimal("0.00");
		    rptPrdtDaily = rptPrdtDailyList.get(i);
		    //һ����Ʒ���ۼƷŴ������
		    BigDecimal AmtTot = DoDcm(rptPrdtDaily.getAmtTot());
		    BigDecimal OffRate = FoDcm(rptPrdtDaily.getOffRate());
		    Prdt_amt = AmtTot.multiply(Rate).multiply(OffRate);
		    amt = amt.add(Prdt_amt);
	       }
         } catch (Exception e) {
	         throw new ServiceException(e.getMessage());
        }
            return amt;
    }
	/**
	 * 
	 * @���� DHCC-ZLC
	 * @���� 2016-6-27
	 * @����˵����floatת decimal
	 * @���ز��� BigDecimal
	 */
	public  BigDecimal FoDcm(Float value)throws ServiceException {
		BigDecimal decimal = new BigDecimal(Float.toString(value));
       return decimal;
    }
	/**
	 * 
	 * @���� DHCC-ZLC
	 * @���� 2016-6-27
	 * @����˵����Doubleת decimal
	 * @���ز��� BigDecimal
	 */
	public static BigDecimal DoDcm(Double value)throws ServiceException {
		BigDecimal decimal = new BigDecimal(Double.toString(value));
       return decimal;
    }
	/**
	 * @���� DHCC-ZLC
	 * @���� 2016-6-28
	 * @����˵����int תdecimal
	 * @���ز��� BigDecimal
	 */
	public static BigDecimal IoDcm(Integer value)throws ServiceException {
		BigDecimal decimal = new BigDecimal(Integer.toString(value));
       return decimal;
    }	
	public void update(FundProvProj fundProvProj) throws ServiceException {
		try {
			fundProvProjDao.update(fundProvProj);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}
	@Override
	public String getProjNameByProjNo(String projNo) throws ServiceException {
		String projName="";
		try {
			projName = fundProvProjDao.getProjNameByProjNo(projNo);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return projName;
	}
	public FundProvProjDao getFundProvProjDao() {
		return fundProvProjDao;
	}

	public void setFundProvProjDao(FundProvProjDao fundProvProjDao) {
		this.fundProvProjDao = fundProvProjDao;
	}
	//����
	public FundProvDao getFundProvDao() {
		return fundProvDao;
	}
	public void setFundProvDao(FundProvDao fundProvDao) {
		this.fundProvDao = fundProvDao;
	}
	public ProjParmDao getProjParmDao() {
		return projParmDao;
	}
	public void setProjParmDao(ProjParmDao projParmDao) {
		this.projParmDao = projParmDao;
	}
	public FundBaseDao getFundBaseDao() {
		return fundBaseDao;
	}
	public void setFundBaseDao(FundBaseDao fundBaseDao) {
		this.fundBaseDao = fundBaseDao;
	}
	public FundSplitTermDao getFundSplitTermDao() {
		return fundSplitTermDao;
	}
	public void setFundSplitTermDao(FundSplitTermDao fundSplitTermDao) {
		this.fundSplitTermDao = fundSplitTermDao;
	}
	public FundSplitDao getFundSplitDao() {
		return fundSplitDao;
	}
	public void setFundSplitDao(FundSplitDao fundSplitDao) {
		this.fundSplitDao = fundSplitDao;
	}
	public FundServiceRateDao getFundServiceRateDao() {
		return fundServiceRateDao;
	}
	public void setFundServiceRateDao(FundServiceRateDao fundServiceRateDao) {
		this.fundServiceRateDao = fundServiceRateDao;
	}
	public PrdtBaseDao getPrdtBaseDao() {
		return prdtBaseDao;
	}
	public void setPrdtBaseDao(PrdtBaseDao prdtBaseDao) {
		this.prdtBaseDao = prdtBaseDao;
	}
	public FundProvSplitTermDao getFundProvSplitTermDao() {
		return fundProvSplitTermDao;
	}
	public void setFundProvSplitTermDao(FundProvSplitTermDao fundProvSplitTermDao) {
		this.fundProvSplitTermDao = fundProvSplitTermDao;
	}
	public FundProvServiceDao getFundProvServiceDao() {
		return fundProvServiceDao;
	}
	public void setFundProvServiceDao(FundProvServiceDao fundProvServiceDao) {
		this.fundProvServiceDao = fundProvServiceDao;
	}

	
}