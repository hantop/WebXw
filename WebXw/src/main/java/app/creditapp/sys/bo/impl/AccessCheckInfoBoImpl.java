package  app.creditapp.sys.bo.impl;

import app.base.BaseService;
import app.base.DAOException;
import app.base.ServiceException;
import app.creditapp.sys.bo.AccessCheckInfoBo;
import app.creditapp.sys.dao.AccessCheckInfoDao;
import app.creditapp.sys.entity.AccessCheckInfo;
import app.util.toolkit.Ipage;
/**
* Title: AccessCheckInfoBoInpl.java
* Description:
**/
public class AccessCheckInfoBoImpl extends BaseService implements AccessCheckInfoBo {

	private AccessCheckInfoDao accessCheckInfoDao;

	public Ipage findByPage(Ipage ipg, AccessCheckInfo accessCheckInfo)
			throws ServiceException {
		try {
			ipg.initPageCounts(new Integer[] { (Integer) accessCheckInfoDao
					.countForMsg(accessCheckInfo) });// ��ʼ����ҳ��
			accessCheckInfo.setStartNumAndEndNum (ipg);
			ipg.setResult(accessCheckInfoDao.findByPage(accessCheckInfo));
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return ipg;
	}

	public AccessCheckInfo getById(AccessCheckInfo accessCheckInfo) throws ServiceException {
		try {
			accessCheckInfo = accessCheckInfoDao.getById(accessCheckInfo);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return accessCheckInfo;
	}
	//1����ǰѡ��ĺ����������Ƿ������TA�Ŀͻ���Ϣ  ����ֵ ����� > 0 �͡��ǡ������0 ���ǡ���
	public int countForMsg(AccessCheckInfo accessCheckInfo) throws DAOException {
		int count = 0;
		try {
			count = accessCheckInfoDao.countForMsg(accessCheckInfo);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return count;
	}
	
	//2����������ά�ȵ����ò����Ƿ��������  ����ֵ�����0 ���� ���� �������1 ���� ���ǡ�
	public int countForConf(AccessCheckInfo accessCheckInfo) throws DAOException {
		int count = 0;
		try {
			count = accessCheckInfoDao.countForConf(accessCheckInfo);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return count;
	}

	//3�����������Ƿ��Ѿ�����������Ŀ  ����ֵ�����0 ���� ���� �������0 ���� ���ǡ�
	public int countForRele(AccessCheckInfo accessCheckInfo) throws DAOException {
		int count = 0;
		try {
			count = accessCheckInfoDao.countForRele(accessCheckInfo);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return count;
	}
	//4��������Ŀά���Ƿ�������������
	//�������Ϊ0 ��û��������ɣ�������������ݣ���ִ�еڶ���SQL 
	public int countForParam(AccessCheckInfo accessCheckInfo) throws DAOException {
		int count = 0;
		try {
			count = accessCheckInfoDao.countForRele(accessCheckInfo);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return count;
	}
	// �������ֵΪ0����������ɣ��������ֵ����0����û���������
	public int countForParamConf(AccessCheckInfo accessCheckInfo) throws DAOException {
		int count = 0;
		try {
			count = accessCheckInfoDao.countForRele(accessCheckInfo);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return count;
	}
	//5����������������������Ŀ����Ӫ��Ա�Ƿ��Ѿ�ȫ��ָ��  ����ֵ�����0 ���Ѿ�ȫ��ָ�ɣ�����ֵ�������0 ����δָ�ɵ���Ŀ
	public int countForDesig(AccessCheckInfo accessCheckInfo) throws DAOException {
		int count = 0;
		try {
			count = accessCheckInfoDao.countForRele(accessCheckInfo);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return count;
	}
	

	public AccessCheckInfoDao getAccessCheckInfoDao() {
		return accessCheckInfoDao;
	}

	public void setAccessCheckInfoDao(AccessCheckInfoDao accessCheckInfoDao) {
		this.accessCheckInfoDao = accessCheckInfoDao;
	}
	
}