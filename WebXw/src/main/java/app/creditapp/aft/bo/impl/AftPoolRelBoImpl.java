package  app.creditapp.aft.bo.impl;

import app.base.BaseService;
import app.base.ServiceException;
import app.util.toolkit.Ipage;
import app.creditapp.aft.bo.AftPoolRelBo;
import app.creditapp.aft.dao.AftPoolRelDao;
import app.creditapp.aft.entity.AftPoolRel;
/**
* Title: AftPoolRelBoImplImpl.java
* Description:
**/
public class AftPoolRelBoImpl extends BaseService implements AftPoolRelBo {

	private AftPoolRelDao aftPoolRelDao;

	public void del(AftPoolRel aftPoolRel) throws ServiceException {
		try {
			aftPoolRelDao.del(aftPoolRel);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}
	//�����ʽ��id�ͺ�ͬidɾ��
	public void delect(AftPoolRel aftPoolRel) throws ServiceException {
		try {
			aftPoolRelDao.delect(aftPoolRel);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}
	
	//ͨ��fundNo��ln_due�е�������������aft_pool_rel���� 
	public void insertList(AftPoolRel aftPoolRel) throws ServiceException{
		try {
			aftPoolRelDao.insertList(aftPoolRel);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}

	public Ipage findByPage(Ipage ipg, AftPoolRel aftPoolRel)
			throws ServiceException {
		try {
			ipg.initPageCounts(new Integer[] { (Integer) aftPoolRelDao
					.getCount(aftPoolRel) });// ��ʼ����ҳ��
			aftPoolRel.setStartNumAndEndNum (ipg);
			ipg.setResult(aftPoolRelDao.findByPage(aftPoolRel));
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return ipg;
	}

	public AftPoolRel getById(AftPoolRel aftPoolRel) throws ServiceException {
		try {
			aftPoolRel = aftPoolRelDao.getById(aftPoolRel);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return aftPoolRel;
	}

	public void insert(AftPoolRel aftPoolRel) throws ServiceException {
		try {
			aftPoolRelDao.insert(aftPoolRel);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}

	public void update(AftPoolRel aftPoolRel) throws ServiceException {
		try {
			aftPoolRelDao.update(aftPoolRel);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}

	public AftPoolRelDao getAftPoolRelDao() {
		return aftPoolRelDao;
	}

	public void setAftPoolRelDao(AftPoolRelDao aftPoolRelDao) {
		this.aftPoolRelDao = aftPoolRelDao;
	}
}