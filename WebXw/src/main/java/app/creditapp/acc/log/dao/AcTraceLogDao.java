package  app.creditapp.acc.log.dao;

import java.util.List;

import app.base.DAOException;
import app.creditapp.acc.log.entity.AcTraceLog;
import app.creditapp.inf.entity.WsOut3202_1;
/**
* Title: AcTraceLogDao.java
* Description:
**/
public interface AcTraceLogDao {

	public AcTraceLog getById(AcTraceLog acTraceLog) throws DAOException;

	public AcTraceLog getByLoanNoAndTxCde(AcTraceLog acTraceLog) throws DAOException;

	public AcTraceLog getRecentTraceLog(AcTraceLog acTraceLog) throws DAOException;

	public void del(AcTraceLog acTraceLog) throws DAOException;

	public void insert(AcTraceLog acTraceLog) throws DAOException;

	public void update(AcTraceLog acTraceLog) throws DAOException;
	
	public int getCount(AcTraceLog acTraceLog) throws DAOException;

	public int getCountForTask(AcTraceLog acTraceLog) throws DAOException;
	
	public int getCountForRead(AcTraceLog acTraceLog) throws DAOException;

	public List<AcTraceLog > findByPage(AcTraceLog acTraceLog) throws DAOException;
	
	public List<AcTraceLog > findByPage_Read(AcTraceLog acTraceLog) throws DAOException;
	
	public List<AcTraceLog > findByPageForTask(AcTraceLog acTraceLog) throws DAOException;

	public String getKey()throws DAOException;
	//�ӿ�ws3202��ѯ�����б�
	public List<WsOut3202_1> getlistforws3202(AcTraceLog acTraceLog) throws DAOException;
	//�ӿ�ws3202��ѯ���ط�����������Ϣ����
	public int getCountforws3202(AcTraceLog acTraceLog) throws DAOException;


}