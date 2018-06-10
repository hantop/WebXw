package  app.creditapp.acc.option.dao;

import java.util.List;
import app.base.DAOException;
import app.creditapp.acc.option.entity.AcLnRepayPlnSusp;
import app.creditapp.inf.entity.WsRepyPlan;
/**
* Title: AcLnRepayPlnSuspDao.java
* Description:
**/
public interface AcLnRepayPlnSuspDao {

	public AcLnRepayPlnSusp getById(AcLnRepayPlnSusp acLnRepayPlnSusp) throws DAOException;

	public void del(AcLnRepayPlnSusp acLnRepayPlnSusp) throws DAOException;

	public void delByPactnoAndBrno(AcLnRepayPlnSusp acLnRepayPlnSusp) throws DAOException;

	public void insert(AcLnRepayPlnSusp acLnRepayPlnSusp) throws DAOException;

	public void update(AcLnRepayPlnSusp acLnRepayPlnSusp) throws DAOException;
	
	public int getCount(AcLnRepayPlnSusp acLnRepayPlnSusp) throws DAOException;

	public List<AcLnRepayPlnSusp > findByPage(AcLnRepayPlnSusp acLnRepayPlnSusp) throws DAOException;
	
	//��������ȡ��list���л���ƻ��ϴ����߼��жϣ�
	public List<WsRepyPlan> getByWsRepyPlanList(String wsRepyPlanBatch) throws DAOException;
	/**
	 * 
	 * @���� DHCC-LIUJ
	 * @���� 2016-9-8
	 * @����	�������κŲ�ѯ���к�ͬ��ȥ�أ�
	 */
	public List<String> getByBatchDisPact(String wsRepyPlanBatch) throws DAOException;
	
	/**
	 * 
	 * @���� DHCC-LIUJ
	 * @���� 2016-9-8
	 * @����	�������κ����ͬ��  ��ѯ����ƻ�
	 */
	public List<WsRepyPlan> getListByBatchAndPactno(AcLnRepayPlnSusp acLnRepayPlnSusp) throws DAOException;


}