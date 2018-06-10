package  app.creditapp.fund.bo;

import java.util.List;

import app.base.ServiceException;
import app.util.toolkit.Ipage;

import app.creditapp.fund.entity.FundBase;

/**
* Title: FundBaseBo.java
* Description:
**/
public interface FundBaseBo {

	public FundBase getById(FundBase fundBase) throws ServiceException;
	
	public void del(FundBase fundBase) throws ServiceException;

	public void insert(FundBase fundBase) throws ServiceException;

	public void updateBytransts(FundBase fundBase) throws ServiceException;
	
	public void update(FundBase fundBase) throws ServiceException;

	public Ipage findByPage(Ipage ipg, FundBase fundBase) throws ServiceException;
	
	public Ipage sync(Ipage ipg, FundBase fundBase) throws ServiceException;
	
	public void syncSingle(FundBase fundBase) throws ServiceException;
	
	public int getCountunmatched(FundBase fundBase) throws ServiceException;
	
	public int getCountunmatcheds(FundBase fundBase) throws ServiceException;
	//�ʽ���������
	public int getFundRepayRemind(FundBase fundBase)throws ServiceException;
	
//	public void insertadd() throws ServiceException;
	//��ѯ�����־��Ч֮ǰ�Ҹ���ˮ
	public void reDeem(FundBase fundBase) throws ServiceException;
	
	//��ѯʧЧ���ʽ�
	public List<FundBase> findByFdflag(String op_no) throws ServiceException;

}