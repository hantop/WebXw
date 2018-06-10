package  app.creditapp.acc.loan.bo;

import app.base.ServiceException;
import app.util.toolkit.Ipage;

import app.creditapp.acc.loan.entity.AcLnRepayPlnCur;

/**
* Title: AcLnRepayPlnCurBo.java
* Description:
**/
public interface AcLnRepayPlnCurBo {

	public AcLnRepayPlnCur getById(AcLnRepayPlnCur acLnRepayPlnCur) throws ServiceException;

	public void del(AcLnRepayPlnCur acLnRepayPlnCur) throws ServiceException;

	public void insert(AcLnRepayPlnCur acLnRepayPlnCur) throws ServiceException;

	public void update(AcLnRepayPlnCur acLnRepayPlnCur) throws ServiceException;

	public Ipage findByPage(Ipage ipg, AcLnRepayPlnCur acLnRepayPlnCur) throws ServiceException;

	public AcLnRepayPlnCur getCurByCnt(AcLnRepayPlnCur acLnRepayPlnCur);

	//���ݺ�ͬ�Ų� ���ڻ���ƻ����е�Ӧ�ձ���-�ѻ�����
//	public int pactAmt_repayPactAmt(AcLnRepayPlnCur acLnRepayPlnCur) throws ServiceException;
}