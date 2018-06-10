package  app.creditapp.fund.bo.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import app.base.BaseService;
import app.base.ServiceException;
import app.util.DateUtil;
import app.util.toolkit.Ipage;
import app.creditapp.fund.bo.FundRepayPlanBo;
import app.creditapp.fund.dao.FundRepayPlanDao;
import app.creditapp.fund.entity.FundRepayPlan;


import app.creditapp.fund.entity.FundBase;
import app.creditapp.fund.dao.FundSplitTermDao;
import app.creditapp.fund.entity.FundSplitTerm;

/**
* Title: FundRepayPlanBoImplImpl.java
* Description:
**/
public class FundRepayPlanBoImpl extends BaseService implements FundRepayPlanBo {

	private FundRepayPlanDao fundRepayPlanDao;
	private FundSplitTermDao fundSplitTermDao;
	
	public void del(FundRepayPlan fundRepayPlan) throws ServiceException {
		try {
			fundRepayPlanDao.del(fundRepayPlan);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}

	public Ipage findByPage(Ipage ipg, FundRepayPlan fundRepayPlan)
			throws ServiceException {
		try {
			ipg.initPageCounts(new Integer[] { (Integer) fundRepayPlanDao
					.getCount(fundRepayPlan) });// ��ʼ����ҳ��
			fundRepayPlan.setStartNumAndEndNum (ipg);
			ipg.setResult(fundRepayPlanDao.findByPage(fundRepayPlan));
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return ipg;
	}

	public FundRepayPlan getById(FundRepayPlan fundRepayPlan) throws ServiceException {
		try {
			fundRepayPlan = fundRepayPlanDao.getById(fundRepayPlan);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return fundRepayPlan;
	}

	public void insert(FundRepayPlan fundRepayPlan) throws ServiceException {
		try {
			fundRepayPlanDao.insert(fundRepayPlan);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}

	public void update(FundRepayPlan fundRepayPlan) throws ServiceException {
		try {
			fundRepayPlanDao.update(fundRepayPlan);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}
	public double getBalByDate(FundRepayPlan fundRepayPlan) throws ServiceException {
		double sumbal = 0.00;
		try {
			sumbal = fundRepayPlanDao.getBalByDate(fundRepayPlan);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return sumbal;
	}	
	//�Զ������ʽ������ƻ�
	public void auto_insert(FundBase fundBase) throws ServiceException {
		try {
			//����Ϣ��ʽ��ͬ���ӵ��·�
			int hkm ;
			//ָ����Ϣ��
			String repay_day = fundBase.getRepayDay();
			//�����������Ƿ���ڽ������ڵı�־��1-����
			int flag = -1;
			int days;
			//�ڴ�
			int repayIssue=0;
			//�����Ҹ��ƻ����
			String repayPlanNo;
			//��������
			String dateStr;
			//�ʽ���ʼ����
			String begDate = fundBase.getBegDate();
			String endDate = fundBase.getEndDate();
			//������ʼ����
			String begtermDate;
			String endtermDate;		

			//��Ϣ�ƻ���ʽ
			String payType = fundBase.getRepayType();
			
			FundSplitTerm fundSplitTerm = new FundSplitTerm();
			fundSplitTerm.setFundNo(fundBase.getFundNo());
			Ipage ipage = new Ipage();
			ipage.setPageSize(100);
			fundSplitTerm.setStartNumAndEndNum(ipage);
			List<FundSplitTerm> fundSplitTermList=  fundSplitTermDao.findByPage(fundSplitTerm);
			//�ж��Ƿ���ڶҸ��ƻ���Ϣ�������ɾ��
			FundRepayPlan fundRepayPlan = new FundRepayPlan();
			fundRepayPlan.setFundNo(fundBase.getFundNo());
			int count = fundRepayPlanDao.getCount(fundRepayPlan);
			if(count > 0){ 
				fundRepayPlanDao.delByFunoNo(fundRepayPlan);
			}
			//�ж϶Ҹ���ʽ��Ӧ���ӵ��·�
			if(("10").equals(payType)){
				 hkm=1;
			 }else if (("20").equals(payType)) {
				 hkm=1;
			 }else if (("11").equals(payType)) {
				 hkm=3;
			 }else if (("21").equals(payType)) {
				 hkm=3;
			 }else if (("12").equals(payType)) {
				 hkm=6;
			 }else if (("22").equals(payType)) {
				 hkm=6;
			 }else if (("13").equals(payType)) {
				 hkm=12;	 
			 }else if (("23").equals(payType)) {
				 hkm=12;
			 }else if (("30").equals(payType)) {
				 hkm=99;
			 }else {
				 flag = 1;
				 hkm=99;
			 };
			while(flag == -1){
				//�ж��Ƿ���һ�θ���
				if(hkm==99){
				//�������ڵ��ڽ�������
				dateStr=endDate;	
				}else {
				//��ȡ�״���������
				dateStr=DateUtil.getDateStr(begDate, hkm);
				//�ж�ָ����Ϣ���Ƿ�Ϊ�գ���Ϊ�գ��������ڵ�ddΪָ����Ϣ�յ�dd
				  if(repay_day.length()>0){
					  dateStr=dateStr.substring(0,6)+repay_day;
				  }
				}
				//������
				Double repayAmt=0.0;
				//�ڴκ�
				repayIssue++;
				//��������repayPlanNo
				repayPlanNo = UUID.randomUUID().toString().replaceAll("-", "");
				//dateStr>date2 return flag=1 dateStr=date2 return flag=0 dateStr<date2 flag=-1
				flag=DateUtil.compareDate(DateUtil.changeToShow(dateStr), DateUtil.changeToShow(endDate));

				//ѭ��������¼����ȡ������ʱ���������������
				for(int i=0;i<fundSplitTermList.size();i++){
					// ���ʼ����
					String maxbegDate;
					// ��С��������
					String minendDate;
					//��������������
					Double termrepayAmt;
					fundSplitTerm=fundSplitTermList.get(i);
					begtermDate = fundSplitTerm.getBegDate(); 
					endtermDate = fundSplitTerm.getEndDate();

					//�ж���������ʱ����Ƿ���ڽ���������ڣ��ҳ����ʼ���ڣ���С��������
					if(((begtermDate.compareTo(begDate) <=0) && begDate.compareTo(endtermDate) < 0) || 
						((begtermDate.compareTo(begDate) > 0) && (begtermDate.compareTo(dateStr)) < 0)	){
						if(begtermDate.compareTo(begDate) > 0){
							maxbegDate = begtermDate ;
						}else {
							maxbegDate = begDate ;
						}
						if(endtermDate.compareTo(dateStr) > 0){
							minendDate = dateStr;
						}else{
							minendDate = endtermDate;
						}
						//����һ��������¼��һ�����������ڵ�����
						days=DateUtil.getBetweenDays(DateUtil.changeToShow(maxbegDate), DateUtil.changeToShow(minendDate));
						//����������repayAmt=���*��������*����/���������ʽ�ģ�
						termrepayAmt= (DateUtil.DoDcm(fundSplitTerm.getTermAmt()).multiply(DateUtil.FoDcm(fundBase.getFinanceRate())).multiply(DateUtil.IoDcm(days))).divide(DateUtil.IoDcm(fundBase.getYearDays()),3,BigDecimal.ROUND_HALF_UP).doubleValue();

						System.out.println("termrepayAmt="+termrepayAmt);
					}else{
						termrepayAmt = 0.0;
					}
					repayAmt =repayAmt+termrepayAmt;
					System.out.println("repayAmt="+repayAmt);
				}
				//�������ƻ�Ϊ���һ�ڣ����һ������Ϊ��������
				if(flag==1){
					dateStr = endDate;
				}
				fundRepayPlan.setFundNo(fundBase.getFundNo());
				fundRepayPlan.setRepayPlanNo(repayPlanNo);
				fundRepayPlan.setRepayAmt(repayAmt);
				fundRepayPlan.setRepayDate(dateStr);
				fundRepayPlan.setRepayIssue(repayIssue);
				fundRepayPlanDao.insert(fundRepayPlan);
				begDate=dateStr;
                
			}
		
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}

	public FundRepayPlanDao getFundRepayPlanDao() {
		return fundRepayPlanDao;
	}

	public void setFundRepayPlanDao(FundRepayPlanDao fundRepayPlanDao) {
		this.fundRepayPlanDao = fundRepayPlanDao;
	}
	//����
	public FundSplitTermDao getFundSplitTermDao() {
		return fundSplitTermDao;
	}

	public void setFundSplitTermDao(FundSplitTermDao fundSplitTermDao) {
		this.fundSplitTermDao = fundSplitTermDao;
	}

}