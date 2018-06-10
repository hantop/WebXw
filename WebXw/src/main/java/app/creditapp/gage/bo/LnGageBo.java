package  app.creditapp.gage.bo;

import java.util.List;

import app.base.DAOException;
import app.base.ServiceException;
import app.util.toolkit.Ipage;

import app.creditapp.gage.entity.LnGage;

/**
* Title: LnGageBo.java
* Description:
**/
public interface LnGageBo {

	public LnGage getById(LnGage lnGage) throws ServiceException;

	public void del(LnGage lnGage) throws ServiceException;

	public void insert(LnGage lnGage) throws ServiceException;

	public void update(LnGage lnGage) throws ServiceException;
	
	public void updateSts(LnGage lnGage) throws ServiceException;
	//����ѺƷID��ѯ����ID
	public String findAppIdByGageId(LnGage lnGage) throws ServiceException;
	/**
	 * �ͻ���ѺƷ��Ϣ
	 * @param ipg
	 * @param lnGage
	 * @return
	 * @throws ServiceException
	 */
	public Ipage findByPage(Ipage ipg, LnGage lnGage) throws ServiceException;

	public Ipage findByPageQuotaForCif(Ipage ipage, LnGage lnGage) throws ServiceException;

	public Ipage findByPageQuotaForLn(Ipage ipage, LnGage lnGage)throws ServiceException;

	//��ѯ���д���Ѻ��Ʒ��Ϣ
	public Ipage findlistBygegeSts(Ipage ipage,LnGage lnGage)throws ServiceException;
}