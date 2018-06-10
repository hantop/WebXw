package  app.creditapp.corp.bo.impl;

import app.base.BaseService;
import app.base.ServiceException;
import app.util.toolkit.Ipage;
import app.creditapp.corp.bo.CorpFinBo;
import app.creditapp.corp.dao.CorpFinDao;
import app.creditapp.corp.entity.CorpFin;
/**
* Title: CorpFinBoImplImpl.java
* Description:
**/
public class CorpFinBoImpl extends BaseService implements CorpFinBo {

	private CorpFinDao corpFinDao;

	public void del(CorpFin corpFin) throws ServiceException {
		try {
			corpFinDao.del(corpFin);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}

	public Ipage findByPage(Ipage ipg, CorpFin corpFin)
			throws ServiceException {
		try {
			ipg.initPageCounts(new Integer[] { (Integer) corpFinDao
					.getCount(corpFin) });// ��ʼ����ҳ��
			corpFin.setStartNumAndEndNum (ipg);
			ipg.setResult(corpFinDao.findByPage(corpFin));
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return ipg;
	}

	public CorpFin getById(CorpFin corpFin) throws ServiceException {
		try {
			corpFin = corpFinDao.getById(corpFin);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return corpFin;
	}

	public void insert(CorpFin corpFin) throws ServiceException {
		try {
			/**
			 * ��������������Ϣ���˻���������
			 */
			corpFin.setFinId(corpFinDao.getKey());
			corpFinDao.insert(corpFin);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}

	public void update(CorpFin corpFin) throws ServiceException {
		try {
			corpFinDao.update(corpFin);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}

	public CorpFinDao getCorpFinDao() {
		return corpFinDao;
	}

	public void setCorpFinDao(CorpFinDao corpFinDao) {
		this.corpFinDao = corpFinDao;
	}

	@Override
	public Ipage findByPageQuotaForCorp(Ipage ipage, CorpFin corpFin)
			throws ServiceException {
		try {
			ipage.initPageCounts(new Integer[] { (Integer) corpFinDao
					.getCountQuotaForCorp(corpFin) });// ��ʼ����ҳ��
			corpFin.setStartNumAndEndNum(ipage);
			ipage.setResult(corpFinDao.findByPageQuotaForCorp(corpFin));
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return ipage;
	}
}