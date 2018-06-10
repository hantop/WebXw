package  app.creditapp.aft.bo;

import app.base.ServiceException;
import app.creditapp.aft.entity.AftAdvpay;
import app.creditapp.inf.entity.ResponseParm;
import app.creditapp.inf.entity.WsIn2806;
import app.creditapp.inf.entity.WsIn2806_1;
import app.creditapp.inf.entity.WsOut2806;
import app.util.toolkit.Ipage;

/**
* Title: AftAdvpayBo.java
* Description:
**/
public interface AftAdvpayBo {

	public AftAdvpay getById(AftAdvpay aftAdvpay) throws ServiceException;
	public AftAdvpay getByIdForTrace(AftAdvpay aftAdvpay) throws ServiceException;

	public void del(AftAdvpay aftAdvpay) throws ServiceException;

	public void insert(AftAdvpay aftAdvpay) throws ServiceException;

	public void update(AftAdvpay aftAdvpay) throws ServiceException;

	public Ipage findByPage(Ipage ipg, AftAdvpay aftAdvpay) throws ServiceException;
	
	public WsOut2806 calcAdvpay(AftAdvpay aftAdvpay) throws ServiceException;
	
	public WsOut2806 calcu(WsIn2806_1 wsIn2806_1) throws ServiceException;
	
	public void execAdvpay(AftAdvpay aftAdvpay) throws ServiceException;
	
	//��ǰ����ӿ� AFT_ADVPAY��ҵ���߼�-sunmingyi  20160801
	public void insertAftAdvPay(String batch) throws ServiceException;
	
	//��ǰ�������ӿ� У��
	public ResponseParm validateWsIn(WsIn2806 wsIn2806) throws ServiceException;

}