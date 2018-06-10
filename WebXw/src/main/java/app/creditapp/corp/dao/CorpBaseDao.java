package  app.creditapp.corp.dao;

import java.util.List;

import app.base.DAOException;
import app.creditapp.corp.entity.CorpBase;
/**
* Title: CorpBaseDao.java
* Description:
**/
public interface CorpBaseDao {

	public CorpBase getById(CorpBase corpBase) throws DAOException;

	public void del(CorpBase corpBase) throws DAOException;

	public void insert(CorpBase corpBase) throws DAOException;

	public void update(CorpBase corpBase) throws DAOException;
	
	public int getCount(CorpBase corpBase) throws DAOException;

	public List<CorpBase > findByPage(CorpBase corpBase) throws DAOException;

	public String getKey()throws DAOException;
	//���Ӻ������� ͨ�÷��� �ж���Ϣ �Ƿ���д����
	public int getAllInf(String brNo) throws DAOException;

	public CorpBase getByBrNo(String brNo);

}