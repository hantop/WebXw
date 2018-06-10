package  app.creditapp.sys.dao;

import java.util.List;
import app.base.DAOException;
import app.creditapp.sys.entity.OperatorModelMenu;
/**
* Title: OperatorModelMenuDao.java
* Description:
**/
public interface OperatorModelMenuDao {

	public OperatorModelMenu getById(OperatorModelMenu operatorModelMenu) throws DAOException;

	public void del(OperatorModelMenu operatorModelMenu) throws DAOException;

	public void insert(OperatorModelMenu operatorModelMenu) throws DAOException;

	public void update(OperatorModelMenu operatorModelMenu) throws DAOException;
	
	public int getCount(OperatorModelMenu operatorModelMenu) throws DAOException;

	public List<OperatorModelMenu > findByPage(OperatorModelMenu operatorModelMenu) throws DAOException;
	
	/**
	 * @description �������в˵�
	 * @return
	 * @throws DAOException
	 * @version 1.0
	 */
	public List<OperatorModelMenu > findAll() throws DAOException;
	
	/**
	 * @description ͨ���ͻ����Ͳ�ѯ���в˵�
	 * @return
	 * @throws DAOException
	 * @version 1.0
	 */
	public List<OperatorModelMenu > findAllByType(String cif_type) throws DAOException;
	
	/**
	 * @description ͨ�����˵�������
	 * @param menuNo
	 * @return
	 * @throws DAOException
	 * @version 1.0
	 */
	public List<OperatorModelMenu > getAllMenuByParent(String menuNo) throws DAOException;
	
	/**
	 * @description ͨ����һ����URL��ַ��ȡ�˵������Ϣ
	 * @param operatorModelMenu
	 * @return
	 * @throws DAOException
	 * @version 1.0
	 */
	public OperatorModelMenu getByLastUrl(String last_url) throws DAOException;

}