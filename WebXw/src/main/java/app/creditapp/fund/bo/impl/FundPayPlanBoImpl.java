package app.creditapp.fund.bo.impl;

import java.math.BigDecimal;
import java.util.UUID;

import app.base.BaseService;
import app.base.ServiceException;
import app.util.toolkit.Ipage;
import app.creditapp.fund.bo.FundPayPlanBo;
import app.creditapp.fund.dao.FundPayPlanDao;
import app.creditapp.fund.entity.FundPayPlan;
import app.creditapp.fund.entity.FundSplit;
import app.util.DateUtil;

/**
 * Title: FundPayPlanBoImplImpl.java Description:
 **/
public class FundPayPlanBoImpl extends BaseService implements FundPayPlanBo {

	private FundPayPlanDao fundPayPlanDao;

	public void del(FundPayPlan fundPayPlan) throws ServiceException {
		try {
			fundPayPlanDao.del(fundPayPlan);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}

	public Ipage findByPage(Ipage ipg, FundPayPlan fundPayPlan)
			throws ServiceException {
		try {
			ipg.initPageCounts(new Integer[] { (Integer) fundPayPlanDao
					.getCount(fundPayPlan) });// ��ʼ����ҳ��
			fundPayPlan.setStartNumAndEndNum(ipg);
			ipg.setResult(fundPayPlanDao.findByPage(fundPayPlan));
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return ipg;
	}

	public int findBycount(FundPayPlan fundPayPlan) throws ServiceException {
		int count = 0;
		try {
			count = (Integer) fundPayPlanDao.getCountForAmt(fundPayPlan);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return count;
	}

	public Ipage findByPageForAmt(Ipage ipg, FundPayPlan fundPayPlan)
			throws ServiceException {
		try {
			ipg.initPageCounts(new Integer[] { (Integer) fundPayPlanDao
					.getCountForAmt(fundPayPlan) });// ��ʼ����ҳ��
			fundPayPlan.setStartNumAndEndNum(ipg);
			ipg.setResult(fundPayPlanDao.findByPageForAmt(fundPayPlan));
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return ipg;
	}

	public FundPayPlan getById(FundPayPlan fundPayPlan) throws ServiceException {
		try {
			fundPayPlan = fundPayPlanDao.getById(fundPayPlan);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return fundPayPlan;
	}

	public void insert(FundPayPlan fundPayPlan) throws ServiceException {
		try {
			fundPayPlanDao.insert(fundPayPlan);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}

	public double getBalByDate(FundPayPlan fundPayPlan) throws ServiceException {
		double bal = 0.00;
		try {
			bal = fundPayPlanDao.getBalByDate(fundPayPlan);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return bal;
	}

	// ���䷽������ʱ�����ɶҸ��ƻ�
	public void auto_insert(FundSplit fundSplit) throws ServiceException {
		try {
			// ����Ϣ��ʽ��ͬ���ӵ��·�
			int hkm;
			// ָ����Ϣ��
			String pay_day = fundSplit.getPayDay();
			// �Ҹ��������Ƿ���ڽ������ڵı�־
			int flag = -1;
			int days;
			// �ڴ�
			int payIssue = 0;
			// �����Ҹ��ƻ����
			String payPlanNo;
			// �Ҹ����
			Double PayAmt;
			// �Ҹ�����
			String dateStr = null;
			String begDate1;
			String payType = fundSplit.getPayType();
			String begDate = fundSplit.getBegDate();
			String endDate = fundSplit.getEndDate();
			String txDate = fundSplit.getTxDate();
			// �ж��Ƿ���ڶҸ��ƻ���Ϣ�������ɾ��
			FundPayPlan fundPayPlan = new FundPayPlan();
			fundPayPlan.setPartNo(fundSplit.getPartNo());
			int count = fundPayPlanDao.getCount(fundPayPlan);
			if (count > 0) {
				fundPayPlanDao.delByPartNo(fundPayPlan);
			}
			// �ж϶Ҹ���ʽ��Ӧ���ӵ��·�
			if (("10").equals(payType)) {
				hkm = 1;
			} else if (("20").equals(payType)) {
				hkm = 1;
			} else if (("11").equals(payType)) {
				hkm = 3;
			} else if (("21").equals(payType)) {
				hkm = 3;
			} else if (("12").equals(payType)) {
				hkm = 6;
			} else if (("22").equals(payType)) {
				hkm = 6;
			} else if (("13").equals(payType)) {
				hkm = 12;
			} else if (("23").equals(payType)) {
				hkm = 12;
			} else if (("30").equals(payType)) {
				hkm = 99;
			} else {
				flag = 1;
				hkm = 99;
			}
			while (flag == -1) {
				// ��ȡ�Ҹ�����
				if (hkm == 99) {
					dateStr = endDate;
				} else {
					if (payIssue == 0) {
						begDate1 = begDate;
						if (pay_day.length() > 0) {
							while(begDate1.compareTo(txDate)<=0){
								begDate1 = DateUtil.getDateStr(begDate1, hkm);
							}
							dateStr = begDate1.substring(0, 6) + pay_day;
							//�����ʼ���ڰ��Ҹ�����ָ����Ϣ��С�ڵǼ����ڣ���һ�ڶҸ��ƻ���ʼ����Ϊ�Ǽ�����
							if(dateStr.compareTo(txDate)<=0){
								dateStr = DateUtil.getDateStr(dateStr, hkm);
							}
							begDate = txDate;
						}else{
							// ��ʼ����С�ڸ�������
							if (begDate.compareTo(txDate) <= 0) {
								dateStr = DateUtil.getDateStr(begDate, hkm);
								while(dateStr.compareTo(txDate)<0){
									dateStr = DateUtil.getDateStr(dateStr, hkm);
								}
								begDate = txDate;
							}else{
								dateStr = DateUtil.getDateStr(begDate, hkm);
							}
						}
					} else {
						dateStr = DateUtil.getDateStr(begDate, hkm);
					}
				}
				// �ڴ�
				payIssue++;
				// ��������payPlanNo
				payPlanNo = UUID.randomUUID().toString().replaceAll("-", "");
				// dateStr>date2 return flag=1
				flag = DateUtil.compareDate(DateUtil.changeToShow(dateStr),
						DateUtil.changeToShow(endDate));
				// �ڴ�������
				if (flag == 1) {
					days = DateUtil.getBetweenDays(DateUtil
							.changeToShow(begDate), DateUtil
							.changeToShow(endDate));
					dateStr = endDate;
				} else {
					days = DateUtil.getBetweenDays(DateUtil
							.changeToShow(begDate), DateUtil
							.changeToShow(dateStr));
				}
				// ����Ҹ����recPayAmt=���*�Ҹ�����*����/������
				PayAmt = ((DateUtil.DoDcm(fundSplit.getPartAmt()).multiply(DateUtil.FoDcm(fundSplit.getInvRate())).multiply(DateUtil.IoDcm(days))).divide(DateUtil.IoDcm(fundSplit.getYearDays()), 3,BigDecimal.ROUND_HALF_UP)).doubleValue();
				int d = DateUtil.getBetweenDays(DateUtil.changeToShow(dateStr), DateUtil.changeToShow(endDate));
				//�һ�ڹ黹����+�Ҹ����
				if(d == 0){
					PayAmt = PayAmt + fundSplit.getPartAmt();
				}
				fundPayPlan.setPayPlanNo(payPlanNo);
				fundPayPlan.setFundNo(fundSplit.getFundNo());
				fundPayPlan.setPartNo(fundSplit.getPartNo());
				fundPayPlan.setPayIssue(payIssue);
				fundPayPlan.setPayDate(dateStr);
				fundPayPlan.setPayAmt(PayAmt);
				fundPayPlanDao.insert(fundPayPlan);
				begDate = dateStr;
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}

	}

	public void update(FundPayPlan fundPayPlan) throws ServiceException {
		try {
			fundPayPlanDao.update(fundPayPlan);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}

	public FundPayPlanDao getFundPayPlanDao() {
		return fundPayPlanDao;
	}

	public void setFundPayPlanDao(FundPayPlanDao fundPayPlanDao) {
		this.fundPayPlanDao = fundPayPlanDao;
	}

}