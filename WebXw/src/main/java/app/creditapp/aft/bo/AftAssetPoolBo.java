package  app.creditapp.aft.bo;

import app.base.ServiceException;
import app.util.toolkit.Ipage;

import app.creditapp.aft.entity.AftAssetPool;

/**
* Title: AftAssetPoolBo.java
**/
public interface AftAssetPoolBo {

	public AftAssetPool getById(AftAssetPool aftAssetPool) throws ServiceException;

	public void del(AftAssetPool aftAssetPool) throws ServiceException;

	public void insert(AftAssetPool aftAssetPool) throws ServiceException;

	public void update(AftAssetPool aftAssetPool) throws ServiceException;

	public Ipage findByPage(Ipage ipg, AftAssetPool aftAssetPool) throws ServiceException;
	
	////�����ʽ�ؽ�ݹ��������ʽ�ؽ������ܶ�
	public void updateTotal(AftAssetPool aftAssetPool) throws ServiceException;

}