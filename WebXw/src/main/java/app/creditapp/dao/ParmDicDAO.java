package app.creditapp.dao;
import java.util.List;
import java.util.Map;
import app.base.DAOException;
import app.base.ServiceException;
import app.creditapp.entity.ParmDic;
public interface ParmDicDAO {
	/**
	 * ������ѯ
	 * @param parmdic
	 * @return
	 * @throws DAOException
	 */
  public ParmDic getById(ParmDic parmdic) throws DAOException;
	/**
	 * ��ѯOPT_NAME
	 * @param parmdic
	 * @return
	 * @throws DAOException
	 */
  public String getOptName(ParmDic parmdic) throws DAOException;
  /**
	 * ��ȡ�����ֵ��е�OPT_CODE
	 * @param parmdic
	 * @return
	 * @throws ServiceException
	 */
  public String getOptCode(ParmDic parmdic) throws DAOException;
  /**
	 * ����ɾ��
	 * @param parmdic
	 * @return
	 * @throws DAOException
	 */
  public void del(ParmDic parmdic) throws DAOException;
  /**
	 * ����ɾ��
	 * @param keyname
	 * @return
	 * @throws DAOException
	 */
  public void delte(String keyname) throws DAOException;
  /**
	 * ����
	 * @param parmdic
	 * @return
	 * @throws DAOException
	 */
  public void insert(ParmDic parmdic) throws DAOException;
  /**
	 * �޸�
	 * @param parmdic
	 * @return
	 * @throws DAOException
	 */
  public void update(ParmDic parmdic) throws DAOException;
  /**
	 * ��ȡParmDic��¼��
	 * @param parmdic
	 * @return
	 * @throws DAOException
	 */
  public int getCount(ParmDic parmdic) throws DAOException;
  /**
	 *Map����
	 * @param map
	 * @return
	 * @throws DAOException
	 */
  public List<ParmDic> findByPage(Map map) throws DAOException;
  
  public List<ParmDic> findlist(ParmDic parmDic)throws DAOException;
  /**
   * 
   * @param parmdic
   * @return  
   * @throws ServiceException
   * @desc
   * ParmDic �������Ų�ֶ�����Ͳ�ѯ���Ŷ�Ȳ��
   */
  public List<ParmDic> getBykeyname4AuthAmt(ParmDic parmdic) throws DAOException;
  /**
   * ����ҵ���������ͻ�ȡ����
   * @param busi_type
   * @return 
   * @throws DAOException
   */
  public String getBusiName(String busi_type) throws DAOException;

}