package  app.creditapp.fund.bo.impl;

import java.util.UUID;

import app.base.BaseService;
import app.base.ServiceException;
import app.util.DateUtil;
import app.util.toolkit.Ipage;
import app.creditapp.fund.bo.FundSplitTermBo;
import app.creditapp.fund.dao.FundSplitTermDao;
import app.creditapp.fund.entity.FundSplitTerm;

import app.creditapp.fund.entity.FundSplitDetail;
import app.creditapp.fund.entity.FundSplit;
import app.creditapp.fund.dao.FundSplitDao;


/**
* Title: FundSplitTermBoImplImpl.java
* Description:
**/
public class FundSplitTermBoImpl extends BaseService implements FundSplitTermBo {

	private FundSplitTermDao fundSplitTermDao;
	private FundSplitDao fundSplitDao;
	private FundSplitTerm fundSplitTerm;
	
	public void del(FundSplitTerm fundSplitTerm) throws ServiceException {
		try {
			fundSplitTermDao.del(fundSplitTerm);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}

	public Ipage findByPage(Ipage ipg, FundSplitTerm fundSplitTerm)
			throws ServiceException {
		try {
			ipg.initPageCounts(new Integer[] { (Integer) fundSplitTermDao
					.getCount(fundSplitTerm) });// ��ʼ����ҳ��
			fundSplitTerm.setStartNumAndEndNum (ipg);
			ipg.setResult(fundSplitTermDao.findByPage(fundSplitTerm));
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return ipg;
	}

	public FundSplitTerm getById(FundSplitTerm fundSplitTerm) throws ServiceException {
		try {
			fundSplitTerm = fundSplitTermDao.getById(fundSplitTerm);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return fundSplitTerm;
	}

	public void insert(FundSplitTerm fundSplitTerm) throws ServiceException {
		try {
			//��������payPlanNo
			String termNo = UUID.randomUUID().toString().replaceAll("-", "");
			//��������
			int days=DateUtil.getBetweenDays(DateUtil.changeToShow(fundSplitTerm.getBegDate()), DateUtil.changeToShow(fundSplitTerm.getEndDate()));

			fundSplitTerm.setTermNo(termNo);
			fundSplitTerm.setDays(days);
			fundSplitTermDao.insert(fundSplitTerm);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}

	public void update(FundSplitTerm fundSplitTerm) throws ServiceException {
		try {
			fundSplitTermDao.update(fundSplitTerm);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}

	//�Զ�����
	public void auto_insert(FundSplitDetail fundSplitDetail) throws ServiceException {
		try {
			FundSplit fundSplit = new FundSplit();
			fundSplit.setPartNo(fundSplitDetail.getPartNo());
			fundSplit = fundSplitDao.getById(fundSplit);		
			//��ֵ�ʽ��ţ�������ţ��������ڣ���ֵ�������ڣ�
			fundSplitTerm = new FundSplitTerm();
			fundSplitTerm.setFundNo(fundSplit.getFundNo());
			fundSplitTerm.setPartNo(fundSplit.getPartNo());
			fundSplitTerm.setEndDate(fundSplitDetail.getTxDate());
			//���䷽���ڴ����ڵ�����
			fundSplitTerm = fundSplitTermDao.getByTxdate(fundSplitTerm);
			
			//��������
			int days;
			//�����������
			String termNo;
		
			//�жϴ�������û��ֵ��ֱ�Ӳ������ݣ�
			//�����ֵ�ҽ���������׷��,����ԭ������¼����������=��������,����������������һ����ǰ��¼����ģ=֮ǰ��ģ+���׹�ģ,��ʼ����=�������ڣ���������=ԭ�������ڣ���
			//�����������ػ�Ҹ�������ԭ������¼����ģ=ԭ��ģ-���׹�ģ��������һ���Ҹ���Ӧ������¼����ģ=���׹�ģ����ʼ����=ԭ��ʼ���ڣ���������=�������ڣ���
			if(fundSplitTerm == null){
				//�����¼�¼
				fundSplitTerm = new FundSplitTerm();
			        //��������termNo
			    termNo = UUID.randomUUID().toString().replaceAll("-", "");
			        //�������������
			    days=DateUtil.getBetweenDays(DateUtil.changeToShow(fundSplit.getBegDate()), DateUtil.changeToShow(fundSplit.getEndDate()));
			    fundSplitTerm.setTermNo(termNo);
				fundSplitTerm.setFundNo(fundSplit.getFundNo());
				fundSplitTerm.setPartNo(fundSplit.getPartNo());
			    fundSplitTerm.setTermAmt(fundSplitDetail.getTxAmt());
		    	fundSplitTerm.setInvRate(fundSplitDetail.getInvRate());
		        fundSplitTerm.setBegDate(fundSplit.getBegDate());
		        fundSplitTerm.setEndDate(fundSplit.getEndDate());
			    fundSplitTerm.setDays(days);
				fundSplitTermDao.insert(fundSplitTerm);
			}else if ("01".equals(fundSplitDetail.getTradeType())){
				//����ԭ��¼���������ڣ�����������
				    //�������������
				days=DateUtil.getBetweenDays(DateUtil.changeToShow(fundSplitTerm.getBegDate()), DateUtil.changeToShow(fundSplitDetail.getTxDate()));
				fundSplitTerm.setEndDate(fundSplitDetail.getTxDate());
				fundSplitTerm.setDays(days);
				fundSplitTermDao.update(fundSplitTerm);
				//�����¼�¼
				    //��������termNo
				termNo = UUID.randomUUID().toString().replaceAll("-", "");
				   //�������������
				days=DateUtil.getBetweenDays(DateUtil.changeToShow(fundSplitDetail.getTxDate()), DateUtil.changeToShow(fundSplit.getEndDate()));
				   //��ģ=ԭ��ģ-���׹�ģ
				Double termAmt = fundSplitTerm.getTermAmt()+fundSplitDetail.getTxAmt();
				fundSplitTerm.setTermNo(termNo);
				fundSplitTerm.setTermAmt(termAmt);
				fundSplitTerm.setInvRate(fundSplitDetail.getInvRate());
				fundSplitTerm.setBegDate(fundSplitDetail.getTxDate());
				fundSplitTerm.setEndDate(fundSplit.getEndDate());
				fundSplitTerm.setDays(days);
				fundSplitTermDao.insert(fundSplitTerm);
			}else{
				//����ԭ��¼
				   //��ģ=ԭ��ģ-���׹�ģ
				Double termAmt = fundSplitTerm.getTermAmt()-fundSplitDetail.getTxAmt();
				fundSplitTerm.setTermAmt(termAmt);
				fundSplitTermDao.update(fundSplitTerm);
				//�����¼�¼
				   //��������termNo
				termNo = UUID.randomUUID().toString().replaceAll("-", "");
				   //�������������
				days=DateUtil.getBetweenDays(DateUtil.changeToShow(fundSplitTerm.getBegDate()), DateUtil.changeToShow(fundSplitDetail.getTxDate()));		
				fundSplitTerm.setTermNo(termNo);
				fundSplitTerm.setTermAmt(fundSplitDetail.getTxAmt());
				fundSplitTerm.setInvRate(fundSplitDetail.getInvRate());
				fundSplitTerm.setBegDate(fundSplit.getBegDate());
				fundSplitTerm.setEndDate(fundSplitDetail.getTxDate());
				fundSplitTerm.setDays(days);
				fundSplitTermDao.insert(fundSplitTerm);
			}
			
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}
	
	public FundSplitTermDao getFundSplitTermDao() {
		return fundSplitTermDao;
	}

	public void setFundSplitTermDao(FundSplitTermDao fundSplitTermDao) {
		this.fundSplitTermDao = fundSplitTermDao;
	}
	
	//����
	public FundSplitDao getFundSplitDao() {
		return fundSplitDao;
	}

	public void setFundSplitDao(FundSplitDao fundSplitDao) {
		this.fundSplitDao = fundSplitDao;
	}
	public FundSplitTerm getFundSplitTerm() {
		return fundSplitTerm;
	}
	public void setFundSplitTerm(FundSplitTerm  fundSplitTerm) {
		this.fundSplitTerm = fundSplitTerm;
	}

}