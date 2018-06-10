package  app.creditapp.inf.bo;

import app.base.ServiceException;
import app.creditapp.inf.entity.ResponseParm;
import app.creditapp.inf.entity.WsIn2303;
import app.creditapp.inf.entity.WsIn2304;
import app.creditapp.inf.entity.WsOut2304;
import app.creditapp.inf.entity.WsRepyClear;
import app.util.toolkit.Ipage;

/**
* Title: WsRepyClearBo.java
* Description:
**/
public interface WsRepyClearBo {

	public WsRepyClear getById(WsRepyClear wsRepyClear) throws ServiceException;

	public void del(WsRepyClear wsRepyClear) throws ServiceException;

	public void insert(WsRepyClear wsRepyClear) throws ServiceException;

	public void update(WsRepyClear wsRepyClear) throws ServiceException;

	public Ipage findByPage(Ipage ipg, WsRepyClear wsRepyClear) throws ServiceException;
	//ws2303�ӿ�У��
	public ResponseParm getresponseParm(WsIn2303 wsIn2303) throws ServiceException;
	//�ӿ�ws2303���ݿ�洢
	public void insertforws2303(WsIn2303 wsIn2303) throws ServiceException;
	//�ӿ�ws2303�ظ���ͬ��ɾ������
	public void delforws2303(WsRepyClear wsRepyClear) throws ServiceException;
	//ws2304�ӿ�У��
	public ResponseParm getresponseParmfor2304(WsIn2304 wsIn2304) throws ServiceException;
	//�ӿ�ws2304���ݺ����ṹ�ţ���ͬ�ŷ��ؽ��ֵ
	public WsOut2304 getInfo(WsIn2304 wsIn2304) throws ServiceException;
	//�ӿ�ws2304���ݺ����ṹ�ţ���ͬ�ŷ��ؽ��ֵ
	public WsOut2304 getInfoForNew(WsIn2304 wsIn2304) throws ServiceException;
	//�ӿ�ws2304 ���ڵļ�¼��
	public int  getCountFor2304(WsRepyClear wsRepyClear) throws ServiceException;
}