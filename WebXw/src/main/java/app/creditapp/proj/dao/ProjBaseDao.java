package  app.creditapp.proj.dao;

import java.util.List;
import app.base.DAOException;
import app.creditapp.proj.entity.ProjBase;
/**
* Title: ProjBaseDao.java
* Description:
**/
public interface ProjBaseDao {

	public ProjBase getById(ProjBase projBase) throws DAOException;
	
	public ProjBase getByIdForProjNo(ProjBase projBase) throws DAOException;
	
	public ProjBase getByIdForBrNo(ProjBase projBase) throws DAOException;
	
	public ProjBase getByIdForFlag(ProjBase projBase) throws DAOException;

	public void del(ProjBase projBase) throws DAOException;

	public void insert(ProjBase projBase) throws DAOException;

	public void merge(ProjBase projBase) throws DAOException;
	
	public void update(ProjBase projBase) throws DAOException;
	
	public void update_Read(ProjBase projBase) throws DAOException;
	
	public int getCount(ProjBase projBase) throws DAOException;
	public int getCountForUser(ProjBase projBase) throws DAOException;

	public List<ProjBase > findByPage(ProjBase projBase) throws DAOException;
	public List<ProjBase > findByPageForUser(ProjBase projBase) throws DAOException;
	public List<ProjBase > findByMyPage(ProjBase projBase) throws DAOException;
	//echartͼ��ʾ���
	public List<ProjBase > myProj_echarts(ProjBase projBase) throws DAOException;
	public List<ProjBase > myProj_day_echarts(ProjBase projBase) throws DAOException;	
	public List<ProjBase > myProj_fdtype_day_echarts(ProjBase projBase) throws DAOException;
	
	//������Ŀ״̬
	public void updateSts(ProjBase projBase) throws DAOException;
	//ͬ��ʱ ���� ר����Ϣ�� ��ȡ �û����µ�������Ŀ
	public List<ProjBase> findpageFormer(ProjBase projBase) throws DAOException;
	
/*	//������������360��ͼ��Ŀ��Ϣչʾ
	public List<ProjBase> getByIdforCorp(ProjBase projBase) throws DAOException;
	//��ȡ��������brno�����������з�ҳ����   ������������360��ͼ��Ŀ��Ϣչʾ
	public int getCountforCorp(ProjBase projBase) throws DAOException;
*/
}