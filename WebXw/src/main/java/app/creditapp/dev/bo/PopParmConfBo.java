package  app.creditapp.dev.bo;

import java.util.Map;

import app.base.ServiceException;
import app.creditapp.dev.entity.PopParmConf;
import app.util.toolkit.Ipage;

/**
* Title: PopParmConfBo.java
* Description:
**/
public interface PopParmConfBo {

	public PopParmConf getById(PopParmConf popParmConf) throws ServiceException;

	public void del(PopParmConf popParmConf) throws ServiceException;

	public void insert(PopParmConf popParmConf) throws ServiceException;

	public void update(PopParmConf popParmConf) throws ServiceException;

	public Ipage findByPage(Ipage ipg, PopParmConf popParmConf) throws ServiceException;
	/**
	 * @description ͨ���������Լ������첽��ѯ
	 * @param scene_id
	 * @param parms
	 * @return
	 * @throws ServiceException
	 * @version 1.0
	 */
	public Map queryAjax(String scene_id,String parms) throws ServiceException;
	
	/**
	 * @description ͨ���������Լ�������̬��ȡ��ѯsql���
	 * @param scene_id
	 * @param parms
	 * @return
	 * @throws ServiceException
	 * @version 1.0
	 */
	public Map createSql(String scene_id,String parms) throws ServiceException;
	
	/**
	 * @�������� ��ҳ��ѯ
	 * @param scene_id
	 * @param parms
	 * @return
	 * @throws ServiceException
	 */
	public Map findByPop(String scene_id,String parms,String query_sql) throws ServiceException;

	public Map findByPopChB(String sceneId, String parms)throws ServiceException;
}