package  app.creditapp.inf.bo;

import app.base.ServiceException;
import app.creditapp.inf.entity.ReqData;

/**
 * @���� DHCC-ZLC
 * @���� 2016-8-24
 * @����
 */
public interface AllocateRegServiceBo {

	/**
	 * �����ղ���ӿڵ���
	 */
	public String saveActTransactionInfos(ReqData reqData)  throws ServiceException;
	
}