package  app.creditapp.fund.bo;

import app.base.ServiceException;
import app.util.toolkit.Ipage;

import app.creditapp.fund.entity.FundDetail;

/**
* Title: FundDetailBo.java
* Description:
**/
public interface FundDetailBo {

	public FundDetail getById(FundDetail fundDetail) throws ServiceException;

	public void del(FundDetail fundDetail) throws ServiceException;

	public void insert(FundDetail fundDetail) throws ServiceException;

	public void update(FundDetail fundDetail) throws ServiceException;

	public Ipage findByPage(Ipage ipg, FundDetail fundDetail) throws ServiceException;

	public double getBalBytradeType(FundDetail fundDetail) throws ServiceException;
	
	//��ȡ��ϸ����������
	public String getMaxDate(FundDetail fundDetail) throws ServiceException;
	
	//����У�����У���ʽ���ϸ��Ϣ
	public String validate(FundDetail fundDetail) throws ServiceException;

}