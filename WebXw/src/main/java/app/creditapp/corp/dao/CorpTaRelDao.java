package  app.creditapp.corp.dao;

import java.util.List;
import app.base.DAOException;
import app.creditapp.corp.entity.CorpTaRel;
import app.creditapp.corp.entity.CorpTaRelforcif;
/**
* Title: CorpTaRelDao.java
* Description:
**/
public interface CorpTaRelDao {

	public CorpTaRel getById(CorpTaRel corpTaRel) throws DAOException;

	public void del(CorpTaRel corpTaRel) throws DAOException;

	public void insert(CorpTaRel corpTaRel) throws DAOException;

	public void update(CorpTaRel corpTaRel) throws DAOException;
	
	public int getCount(CorpTaRel corpTaRel) throws DAOException;

	public List<CorpTaRel > findByPage(CorpTaRel corpTaRel) throws DAOException;
	//ͨ��dblink����ͨta���������
	public void insertforCorp(CorpTaRel corpTaRel) throws DAOException;
	//ͨ��dblink����ͨta��ɾ���ظ�����
	public void deleteforDblink() throws DAOException;
	//ͨ��brNo���в�ѯ���������Ŀͻ���
	public List getCifNo(CorpTaRel corpTaRel) throws DAOException;
	//ͨ��brNo������ͼ�����з����������û���
	public List<CorpTaRelforcif> getByBrNoForDb(CorpTaRel corpTaRel) throws DAOException;

}