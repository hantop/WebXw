package  app.creditapp.inf.bo;

import java.util.List;

import app.base.ServiceException;
import app.creditapp.inf.entity.ResponseParm;
import app.creditapp.inf.entity.WsIn2302;
import app.creditapp.inf.entity.WsOut2302_1;
import app.creditapp.inf.entity.WsRepyMes;
import app.creditapp.inf.entity.WsRepyMes_Count;
import app.util.toolkit.Ipage;

/**
* Title: WsRepyMesBo.java
* Description:
**/
public interface WsRepyMesBo {

	public WsRepyMes getById(WsRepyMes wsRepyMes) throws ServiceException;

	public void del(WsRepyMes wsRepyMes) throws ServiceException;

	public void insert(WsRepyMes wsRepyMes) throws ServiceException;

	public void update(WsRepyMes wsRepyMes) throws ServiceException;

	public Ipage findByPage(Ipage ipg, WsRepyMes wsRepyMes) throws ServiceException;
	//�˿�ws2302��У��
	public ResponseParm getresponse(WsIn2302 wsIn2302)throws ServiceException;
	//�ӿ�ws2302��ҳ����
	public Ipage findByPageforws2302(Ipage ipg, WsRepyMes wsRepyMes)throws ServiceException;
	//�ӿ�ws2302��������������
	public int getCountforws2302(WsRepyMes wsRepyMes) throws ServiceException;
	
	public WsOut2302_1 getByIdForNew(WsRepyMes wsRepyMes) throws ServiceException;
	//�ۿ���Ϣͳ��
	public Ipage getCountMes(Ipage ipg, WsRepyMes_Count wc) throws ServiceException;
}