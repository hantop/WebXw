package  app.creditapp.corp.bo.impl;

import app.base.BaseService;
import app.base.ServiceException;
import app.util.toolkit.Ipage;
import app.creditapp.corp.bo.CorpBaseBo;
import app.creditapp.corp.dao.CorpBaseDao;
import app.creditapp.corp.entity.CorpBase;
/**
* Title: CorpBaseBoImplImpl.java
* Description:
**/
public class CorpBaseBoImpl extends BaseService implements CorpBaseBo {

	private CorpBaseDao corpBaseDao;

	public void del(CorpBase corpBase) throws ServiceException {
		try {
			corpBaseDao.del(corpBase);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}

	public Ipage findByPage(Ipage ipg, CorpBase corpBase)
			throws ServiceException {
		try {
			ipg.initPageCounts(new Integer[] { (Integer) corpBaseDao
					.getCount(corpBase) });// ��ʼ����ҳ��
			corpBase.setStartNumAndEndNum (ipg);
			ipg.setResult(corpBaseDao.findByPage(corpBase));
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return ipg;
	}

	public CorpBase getById(CorpBase corpBase) throws ServiceException {
		try {
			corpBase = corpBaseDao.getById(corpBase);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return corpBase;
	}

	public void insert(CorpBase corpBase) throws ServiceException {
		try {
			/**
			 * ��������������Ϣ�Ļ�����������
			 */
			//���������Ų�ʹ�����У�����ʱ�ֶ�����
			//corpBase.setBrNo(corpBaseDao.getKey());
			
			corpBaseDao.insert(corpBase);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}

	public void update(CorpBase corpBase) throws ServiceException {
		try {
			corpBaseDao.update(corpBase);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}
	//���Ӻ������� ͨ�÷��� �ж���Ϣ �Ƿ���д����
	public int  getAllInf(String brNo) throws ServiceException {
		int count = 0;
		try {
			count = corpBaseDao.getAllInf(brNo);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return count;
	}

	public CorpBaseDao getCorpBaseDao() {
		return corpBaseDao;
	}

	public void setCorpBaseDao(CorpBaseDao corpBaseDao) {
		this.corpBaseDao = corpBaseDao;
	}

	@Override
	public CorpBase getBybrNo(String brNo) throws ServiceException{
		CorpBase corpBase = null;
		try {
			corpBase = corpBaseDao.getByBrNo(brNo);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return corpBase;
	}
}