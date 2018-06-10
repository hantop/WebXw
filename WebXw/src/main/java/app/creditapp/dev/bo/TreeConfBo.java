package  app.creditapp.dev.bo;

import java.util.Map;

import app.base.ServiceException;
import app.util.toolkit.Ipage;

import app.creditapp.dev.entity.TreeConf;

/**
* Title: TreeConfBo.java
* Description:
**/
public interface TreeConfBo {

	public TreeConf getById(TreeConf treeConf) throws ServiceException;

	public void del(TreeConf treeConf) throws ServiceException;

	public void insert(TreeConf treeConf) throws ServiceException;

	public void update(TreeConf treeConf) throws ServiceException;

	public Ipage findByPage(Ipage ipg, TreeConf treeConf) throws ServiceException;
	
	/**
	 * @����˵��: ͨ���������Լ�ҳ�洫���������̬���ɲ�ѯ��SQL���
	 * @param scene_id ������
	 * @param Map ����
	 * @return
	 * @throws ServiceException
	 * @return  Map
	 * @�޸�˵��:
	 */
	public Map createSql(String scene_id,Map<String,Object> parms) throws ServiceException;
	
	public Map createSqlPot(String scene_id,Map<String,Object> parms) throws ServiceException;

	/**
	 * @����˵��: ͨ����ѯsql �������װ��ztee����Ҫ�� json
	 * @param sql
	 * @return
	 * @return  String
	 * @�޸�˵��:
	 */
	public String getTreeJson(String sql) throws ServiceException;

}