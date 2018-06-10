package  app.creditapp.cred.bo.impl;

import app.base.BaseService;
import app.base.ServiceException;
import app.util.toolkit.Ipage;
import app.creditapp.cred.bo.CorpEvalBo;
import app.creditapp.cred.dao.CorpEvalDao;
import app.creditapp.cred.entity.CorpEval;
/**
* Title: CorpEvalBoImplImpl.java
* Description:
**/
public class CorpEvalBoImpl extends BaseService implements CorpEvalBo {

	private CorpEvalDao corpEvalDao;

	public void del(CorpEval corpEval) throws ServiceException {
		try {
			corpEvalDao.del(corpEval);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}

	public Ipage findByPage(Ipage ipg, CorpEval corpEval)
			throws ServiceException {
		try {
			ipg.initPageCounts(new Integer[] { (Integer) corpEvalDao
					.getCount(corpEval) });// ��ʼ����ҳ��
			corpEval.setStartNumAndEndNum (ipg);
			ipg.setResult(corpEvalDao.findByPage(corpEval));
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return ipg;
	}

	public CorpEval getById(CorpEval corpEval) throws ServiceException {
		try {
			corpEval = corpEvalDao.getById(corpEval);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return corpEval;
	}
	//��ȡ����������Ϣ
	public CorpEval getByMaxId(CorpEval corpEval) throws ServiceException {
		try {
			corpEval = corpEvalDao.getByMaxId(corpEval);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return corpEval;
	}

	public void insert(CorpEval corpEval) throws ServiceException {
		try {
			/**
			 * ������������������Ϣ��ID��������
			 */
			corpEval.setEvalNo(corpEvalDao.getKey());
			corpEvalDao.insert(corpEval);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}

	public void update(CorpEval corpEval) throws ServiceException {
		try {
			corpEvalDao.update(corpEval);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}

	public CorpEvalDao getCorpEvalDao() {
		return corpEvalDao;
	}

	public void setCorpEvalDao(CorpEvalDao corpEvalDao) {
		this.corpEvalDao = corpEvalDao;
	}
}