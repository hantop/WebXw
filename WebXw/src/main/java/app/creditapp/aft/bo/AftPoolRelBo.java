package  app.creditapp.aft.bo;

import app.base.ServiceException;
import app.util.toolkit.Ipage;

import app.creditapp.aft.entity.AftPoolRel;

/**
* Title: AftPoolRelBo.java
**/
public interface AftPoolRelBo {

	public AftPoolRel getById(AftPoolRel aftPoolRel) throws ServiceException;

	public void del(AftPoolRel aftPoolRel) throws ServiceException;

	public void insert(AftPoolRel aftPoolRel) throws ServiceException;

	public void update(AftPoolRel aftPoolRel) throws ServiceException;

	public Ipage findByPage(Ipage ipg, AftPoolRel aftPoolRel) throws ServiceException;

	//�����ʽ��id�ͺ�ͬidɾ��
	public void delect(AftPoolRel aftPoolRel) throws ServiceException;
	
	//ͨ��fundNo��ln_due�е�������������aft_pool_rel���� 
	public void insertList(AftPoolRel aftPoolRel) throws ServiceException;
}