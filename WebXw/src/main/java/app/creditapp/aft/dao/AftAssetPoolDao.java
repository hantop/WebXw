package  app.creditapp.aft.dao;

import java.util.List;
import app.base.DAOException;
import app.creditapp.aft.entity.AftAssetPool;
/**
* Title: AftAssetPoolDao.java
* Description:
**/
public interface AftAssetPoolDao {

	public AftAssetPool getById(AftAssetPool aftAssetPool) throws DAOException;

	public void del(AftAssetPool aftAssetPool) throws DAOException;

	public void insert(AftAssetPool aftAssetPool) throws DAOException;

	public void update(AftAssetPool aftAssetPool) throws DAOException;
	
	public int getCount(AftAssetPool aftAssetPool) throws DAOException;

	public List<AftAssetPool > findByPage(AftAssetPool aftAssetPool) throws DAOException;

	//�����ʽ�ؽ�ݹ��������ʽ�ؽ������ܶ�
	public void updateTotal(AftAssetPool aftAssetPool) throws DAOException;
}