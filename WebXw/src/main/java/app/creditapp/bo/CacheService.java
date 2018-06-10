package app.creditapp.bo;

import java.util.List;

import app.base.ServiceException;
import app.creditapp.sys.entity.SysCache;

public interface CacheService {
	/**
	 * ������ѯ
	 * @return
	 * @throws ServiceException
	 */
	public List<Object> findByCondition(Object object) throws ServiceException;
	public List<String> findKeyByCondition() throws ServiceException;

	/**
	 * @����˵����
	 * @�޸�˵������ȡ
	 */
	public List<Object> getCacheValue(String cache_name, String cache_key) throws ServiceException;
	/**
	 * @����˵�������ݻ�������ȡ�����ֵkey
	 * @�޸�˵����
	 */
	public List<String> getCacheKey(String cache_name) throws ServiceException;
	/**
	 * @����˵������ȡϵͳ�Զ����صĻ���
	 * @�޸�˵����
	 */
	public List<SysCache> getSysCache() throws ServiceException;
}
