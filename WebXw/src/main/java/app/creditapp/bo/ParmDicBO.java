package app.creditapp.bo;
import java.util.List;

import app.base.ServiceException;
import app.creditapp.entity.ParmDic;
import app.util.toolkit.Ipage;
public interface ParmDicBO {
	/**
	 * ��ȡ����
	 * @param parmdic
	 * @return
	 * @throws ServiceException
	 */
  public ParmDic getById(ParmDic parmdic) throws ServiceException;
  /**
	 * ��ȡ�����ֵ��е�OPT_NAME
	 * @param parmdic
	 * @return
	 * @throws ServiceException
	 */
  public String getOptName(ParmDic parmdic) throws ServiceException;
  /**
	 * ��ȡ�����ֵ��е�OPT_CODE
	 * @param parmdic
	 * @return
	 * @throws ServiceException
	 */
  public String getOptCode(ParmDic parmdic) throws ServiceException;
  /**
	 * ɾ��
	 * @param parmdic
	 * @return
	 * @throws ServiceException
	 */
  public void del(ParmDic parmdic) throws ServiceException;
  /**
	 * ɾ��
	 * @param keyname
	 * @return
	 * @throws ServiceException
	 */
  public void delte(String keyname) throws ServiceException;
  /**
	 * ����
	 * @param parmdic
	 * @return
	 * @throws ServiceException
	 */
  public void Insert(ParmDic parmdic) throws ServiceException;
  /**
	 * ��ҳ��ѯParmDic
	 * @param ipg
	 * @param parmdic
	 * @return
	 * @throws ServiceException
	 */
  public Ipage findByPage(Ipage ipg,ParmDic parmdic) throws ServiceException;
  /**
	 * �޸�
	 * @param parmdic
	 * @return
	 * @throws ServiceException
	 */
  public void Update(ParmDic parmdic) throws ServiceException;
  public   List<ParmDic> findlist(ParmDic parmDic)throws ServiceException; 
  /**
   * 
   * @param parmdic
   * @return  
   * @throws ServiceException
   * @desc
   * ParmDic �������Ų�ֶ�����Ͳ�ѯ���Ŷ�Ȳ��
   */
  public List<ParmDic> getBykeyname4AuthAmt(ParmDic parmdic) throws ServiceException;

}