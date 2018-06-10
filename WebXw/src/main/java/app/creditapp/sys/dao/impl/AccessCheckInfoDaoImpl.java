package  app.creditapp.sys.dao.impl;

import java.util.List;
import app.base.BaseIbatisDao;
import app.base.DAOException;
import app.creditapp.sys.dao.AccessCheckInfoDao;
import app.creditapp.sys.entity.AccessCheckInfo;
/**
* Title: AccessCheckInfoDaoImpl.java
* Description:
**/
public class AccessCheckInfoDaoImpl extends BaseIbatisDao implements AccessCheckInfoDao {

	public List<AccessCheckInfo> findByPage(AccessCheckInfo accessCheckInfo) throws DAOException {
		List accessCheckInfoList = null;
		try {
			accessCheckInfoList = getSqlMapClientTemplate().queryForList(
					"AccessCheckInfo.findByPage", accessCheckInfo);
		} catch (Exception e) {
			log.error(e);
			throw new DAOException(e.getMessage());
		}
		return accessCheckInfoList;
	}

	public AccessCheckInfo getById(AccessCheckInfo accessCheckInfo) throws DAOException {
		try {
			accessCheckInfo = (AccessCheckInfo) getSqlMapClientTemplate()
					.queryForObject("AccessCheckInfo.getById", accessCheckInfo);
		} catch (Exception e) {
			log.error(e);
			throw new DAOException(e.getMessage());
		}
		return accessCheckInfo;
	}

	//1����ǰѡ��ĺ����������Ƿ������TA�Ŀͻ���Ϣ  ����ֵ ����� > 0 �͡��ǡ������0 ���ǡ���
	public int countForMsg(AccessCheckInfo accessCheckInfo) throws DAOException {
		int count = 0;
		try {
			count = (Integer) getSqlMapClientTemplate().queryForObject(
					"AccessCheckInfo.countForMsg.count", accessCheckInfo);
		} catch (Exception e) {
			log.error(e);
			throw new DAOException(e.getMessage());
		}
		return count;
	}
	//2����������ά�ȵ����ò����Ƿ��������  ����ֵ�����0 ���� ���� �������1 ���� ���ǡ�
	public int countForConf(AccessCheckInfo accessCheckInfo) throws DAOException {
		int count = 0;
		try {
			count = (Integer) getSqlMapClientTemplate().queryForObject(
					"AccessCheckInfo.countForConf.count", accessCheckInfo);
		} catch (Exception e) {
			log.error(e);
			throw new DAOException(e.getMessage());
		}
		return count;
	}
	//3�����������Ƿ��Ѿ�����������Ŀ  ����ֵ�����0 ���� ���� �������0 ���� ���ǡ�
	public int countForRele(AccessCheckInfo accessCheckInfo) throws DAOException {
		int count = 0;
		try {
			count = (Integer) getSqlMapClientTemplate().queryForObject(
					"AccessCheckInfo.countForRele.count", accessCheckInfo);
		} catch (Exception e) {
			log.error(e);
			throw new DAOException(e.getMessage());
		}
		return count;
	}
	//4��������Ŀά���Ƿ�������������
	//�������Ϊ0 ��û��������ɣ�������������ݣ���ִ�еڶ���SQL 
	public int countForParam(AccessCheckInfo accessCheckInfo) throws DAOException {
		int count = 0;
		try {
			count = (Integer) getSqlMapClientTemplate().queryForObject(
					"AccessCheckInfo.countForParam.count", accessCheckInfo);
		} catch (Exception e) {
			log.error(e);
			throw new DAOException(e.getMessage());
		}
		return count;
	}
	// �������ֵΪ0����������ɣ��������ֵ����0����û���������
	public int countForParamConf(AccessCheckInfo accessCheckInfo) throws DAOException {
		int count = 0;
		try {
			count = (Integer) getSqlMapClientTemplate().queryForObject(
					"AccessCheckInfo.countForParamConf.count", accessCheckInfo);
		} catch (Exception e) {
			log.error(e);
			throw new DAOException(e.getMessage());
		}
		return count;
	}
	//5����������������������Ŀ����Ӫ��Ա�Ƿ��Ѿ�ȫ��ָ��  ����ֵ�����0 ���Ѿ�ȫ��ָ�ɣ�����ֵ�������0 ����δָ�ɵ���Ŀ
	public int countForDesig(AccessCheckInfo accessCheckInfo) throws DAOException {
		int count = 0;
		try {
			count = (Integer) getSqlMapClientTemplate().queryForObject(
					"AccessCheckInfo.countForDesig.count", accessCheckInfo);
		} catch (Exception e) {
			log.error(e);
			throw new DAOException(e.getMessage());
		}
		return count;
	}


}