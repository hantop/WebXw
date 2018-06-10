package  app.creditapp.inf.bo;

import app.base.ServiceException;
import app.creditapp.inf.entity.ResponseParm;
import app.creditapp.inf.entity.WsIn2902;
import app.creditapp.inf.entity.WsRedctn;
import app.util.toolkit.Ipage;

/**
* Title: WsRedctnBo.java
* Description:
**/
public interface WsRedctnBo {

	public WsRedctn getById(WsRedctn wsRedctn) throws ServiceException;

	public void del(WsRedctn wsRedctn) throws ServiceException;

	public void insert(WsRedctn wsRedctn) throws ServiceException;

	public void update(WsRedctn wsRedctn) throws ServiceException;

	public Ipage findByPage(Ipage ipg, WsRedctn wsRedctn) throws ServiceException;
	//�˿�ws2902��У��
	public ResponseParm getresponse(WsIn2902 wsIn2902)throws ServiceException;
	//�ӿ�ws2902��ҳ����
	public Ipage findByPageforws2902(Ipage ipg,WsRedctn wsRedctn)throws ServiceException;
	//�ӿ�ws2902��������������
	public int getCountforws2902(WsRedctn wsRedctn) throws ServiceException;

}