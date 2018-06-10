package  app.creditapp.inf.dao;

import java.util.List;
import java.util.Map;

import app.base.DAOException;
import app.creditapp.inf.entity.WsIn2303;
import app.creditapp.inf.entity.WsIn2304;
import app.creditapp.inf.entity.WsOut2304;
import app.creditapp.inf.entity.WsRepyClear;
/**
* Title: WsRepyClearDao.java
* Description:
**/
public interface WsRepyClearDao {

	public WsRepyClear getById(WsRepyClear wsRepyClear) throws DAOException;
	
	public WsRepyClear getDealIngByPactno(WsRepyClear wsRepyClear) throws DAOException;

	public void del(WsRepyClear wsRepyClear) throws DAOException;

	public void insert(WsRepyClear wsRepyClear) throws DAOException;

	public void update(WsRepyClear wsRepyClear) throws DAOException;
	
	public void updateSts(WsRepyClear wsRepyClear) throws DAOException;
	
	public int getCount(WsRepyClear wsRepyClear) throws DAOException;
	public List<WsRepyClear > findByPage(Map map) throws DAOException;

//	public List<WsRepyClear > findByPage(WsRepyClear wsRepyClear) throws DAOException;
	//�ӿ�ws2303���ݿ���뷽��
	public void insertforws2303(WsIn2303 wsIn2303) throws DAOException;
	//�ӿ�ws2303�����ͬ���ظ�ɾ������
	public void delforws2303(WsRepyClear wsRepyClear) throws DAOException;
	//�ӿ�ws2304 ���ݺ����ṹ�ţ���ͬ�ŷ��ؽ��ֵ
	public WsOut2304 getInfo(WsIn2304 wsIn2304) throws DAOException;
	//�ӿ�ws2304 ���ݺ����ṹ�ţ���ͬ�ŷ��ؽ��ֵ
	public WsOut2304 getInfoForNew(WsIn2304 wsIn2304) throws DAOException;
	//�ӿ�ws2304��ѯ���������ļ�¼��
	public int getCountforws3204(WsRepyClear wsRepyClear) throws DAOException;
	
	//�ӿ�ws2304 ���ݺ����ṹ�ţ���ͬ�ŷ��ؽ��ֵ
	//public WsRepyClear getbyIdForall(WsIn2304 wsIn2304) throws DAOException;

}