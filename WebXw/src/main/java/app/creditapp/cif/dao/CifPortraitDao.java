package  app.creditapp.cif.dao;

import java.util.List;
import app.base.DAOException;
import app.creditapp.cif.entity.CifPortrait;
/**
* Title: CifPortraitDao.java
* Description:
**/
public interface CifPortraitDao {

	public CifPortrait getById(CifPortrait cifPortrait) throws DAOException;

	public void del(CifPortrait cifPortrait) throws DAOException;

	public void insert(CifPortrait cifPortrait) throws DAOException;

	public void update(CifPortrait cifPortrait) throws DAOException;
	
	public int getCount(CifPortrait cifPortrait) throws DAOException;

	public List<CifPortrait > findByPage(CifPortrait cifPortrait) throws DAOException;
	//��ѯ�ͻ�����
//	public String getCifType(CifPortrait cifPortrait) throws DAOException;
	//��ѯ���ڴ���
	public int getRepdNum(CifPortrait cifPortrait) throws DAOException;
	//��ѯͬ��ͻ��ٷֱ�
	public double getPercent(CifPortrait cifPortrait) throws DAOException;
	//��ѯ��������
	public String getWorkType(CifPortrait cifPortrait) throws DAOException ;
	//��ѯ�Ƿ��г�
	public String getIfCar(CifPortrait cifPortrait) throws DAOException ;
	//��ѯ�Ƿ��з�
	public String getIfRoom(CifPortrait cifPortrait) throws DAOException ;
	
	public int getCifBlackNum(CifPortrait cifPortrait) throws DAOException;
	
	public int getIfDC(CifPortrait cifPortrait) throws DAOException;
	
	public int getIfHG(CifPortrait cifPortrait) throws DAOException;
	
	public List<CifPortrait > getCifGroup(CifPortrait cifPortrait) throws DAOException;
	//���汾�źͿͻ��Ų�ѯ���°汾�Ŀͻ�������Ϣ
	public CifPortrait getCifPortraitByVersion(String cifno,String version) throws DAOException;
	
	public String getMaxVersion(CifPortrait cifPortrait) throws DAOException;
}