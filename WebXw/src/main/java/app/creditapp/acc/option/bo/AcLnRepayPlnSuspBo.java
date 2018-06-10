package  app.creditapp.acc.option.bo;

import java.util.List;

import app.base.ServiceException;
import app.util.toolkit.Ipage;

import app.creditapp.acc.option.entity.AcLnRepayPlnSusp;
import app.creditapp.inf.entity.WsRepyPlan;

/**
* Title: AcLnRepayPlnSuspBo.java
* Description:
**/
public interface AcLnRepayPlnSuspBo {

	public AcLnRepayPlnSusp getById(AcLnRepayPlnSusp acLnRepayPlnSusp) throws ServiceException;

	public void del(AcLnRepayPlnSusp acLnRepayPlnSusp) throws ServiceException;

	public void insert(AcLnRepayPlnSusp acLnRepayPlnSusp) throws ServiceException;

	public void update(AcLnRepayPlnSusp acLnRepayPlnSusp) throws ServiceException;

	public Ipage findByPage(Ipage ipg, AcLnRepayPlnSusp acLnRepayPlnSusp) throws ServiceException;

	//����ƻ� ҵ���߼��ĺϷ����ж�
	/**
	 * �Ի�ȡ����AcLnRepayPln���Ͻ�ҵ���߼��ĺϷ����жϣ���������Ҫ��ļ��Ͻ��з��أ�������Ҫ������ݽ��ᱻ����
	1��ͬһ����ͬ�е�ÿ��Ӧ������֮��=��ͬ��ac_ln_mst���Ĵ�������ſ���loan_amt��
	2��ͬһ����ͬ���������=��ͬ��ac_ln_mst���ĵ�����end_date��
	3��ͬһ����ͬ���ڴκű����������ġ�
	5��ÿһ�ڵ���Ϣ������ڵ���0��
	 * @param acrpList
	 * @return
	 * @throws Exception
	 */
	public boolean validAcLnRepayPlnSusp(String acLnRepayPlnSuspBatch , String brNo) throws ServiceException;
	
	public List<String> getByBatchDisPact(String wsRepyPlanBatch) throws ServiceException;
	
	public void delByPactnoAndBrno(AcLnRepayPlnSusp acLnRepayPlnSusp) throws ServiceException;
	
	 public List<WsRepyPlan> getListByBatchAndPactno(AcLnRepayPlnSusp acLnRepayPlnSusp) throws ServiceException;
}