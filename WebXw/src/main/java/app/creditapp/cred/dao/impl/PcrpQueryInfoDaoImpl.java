package app.creditapp.cred.dao.impl;

import java.util.List;

import app.base.BaseIbatisDao;
import app.base.DAOException;
import app.creditapp.cred.dao.PcrpQueryInfoDao;
import app.creditapp.cred.entity.PcrpQueryInfo;
import app.oscache.CachecodeUtil;

/**
 * 
  * ʵ�������ƣ�PcrpQueryInfoDaoImpl
  * ����������������ʵ�ַ��� 
  * �����ˣ�lidong dhcc 
  * ����ʱ�䣺2015-7-15 ����01:13:33
  * �޸��ˣ�Administrator  
 * @version
 */
public class PcrpQueryInfoDaoImpl extends BaseIbatisDao implements PcrpQueryInfoDao {

	/**
	 * ��ѯ�Ǽ���Ϣ
	 * �����ˣ�lidong dhcc
	 */
	public List<PcrpQueryInfo> findByPage(PcrpQueryInfo pcrpDocInfo) throws DAOException {
		List CrpDocInfoList = null;
		try {
			CrpDocInfoList = getSqlMapClientTemplate().queryForList("PcrpQueryInfo.selectAll", pcrpDocInfo);
		} catch (Exception e) {
			log.error(e);
			throw new DAOException("��ѯʧ��");
		}
		return CrpDocInfoList;
	}
	public List ExportDate(PcrpQueryInfo pcrpQueryInfo) throws DAOException {
		List pcrpQueryInfoList = null;
		try {
			pcrpQueryInfoList = getSqlMapClientTemplate().queryForList("PcrpQueryInfo.selectExportDate", pcrpQueryInfo);
		} catch (Exception e) {
			log.error(e);
			throw new DAOException("��ѯʧ��");
		}
		return pcrpQueryInfoList;
	}
	
	/**
	 * ͳ���ܵĵǼ���Ϣ����
	 * �����ˣ�lidong dhcc
	 */
	public int getCount(PcrpQueryInfo pcrpDocInfo) throws DAOException {
		int count = 0;
		try {
			count = (Integer) getSqlMapClientTemplate().queryForObject("PcrpQueryInfo.findPage.count",pcrpDocInfo);
		} catch (Exception e) {
			log.error(e);
			throw new DAOException("��ѯͳ��ʧ��");
		}
		return count;
	}

	/**
	 * ͳ��������ѯ�Ǽ���Ϣ����
	 * �����ˣ�lidong dhcc
	 */
	
	public int singleGetCount(PcrpQueryInfo pcrpDocInfo) throws DAOException {
		int count = 0;
		try {
			count = (Integer) getSqlMapClientTemplate().queryForObject(
						"PcrpQueryInfo.singleFindPage.count",pcrpDocInfo);
		} catch (Exception e) {
			log.error(e);
			throw new DAOException("��ѯͳ��ʧ��");
		}
		return count;
	}
	
	//���ݲ�ѯ�����������в���������ѯ
	public int getBankCount(PcrpQueryInfo pcrpQueryInfo) throws DAOException{
		int count = 0;
		try {
			count = (Integer) getSqlMapClientTemplate().queryForObject(
						"PcrpQueryInfo.getBankCount.count",pcrpQueryInfo);
		} catch (Exception e) {
			log.error(e);
			throw new DAOException("��ѯͳ��ʧ��");
		}
		return count;
	}
	//���ݲ�ѯ��������������ѯ
	public int getBatchCount(PcrpQueryInfo pcrpQueryInfo) throws DAOException{
		int count = 0;
		try {
			count = (Integer) getSqlMapClientTemplate().queryForObject(
					"PcrpQueryInfo.getBatchCount.count",pcrpQueryInfo);
		} catch (Exception e) {
			log.error(e);
			throw new DAOException("��ѯͳ��ʧ��");
		}
		return count;
	}
	/**
	 * ���˵���������ѯ�Ǽ���Ϣ
	 * �����ˣ�lidong dhcc
	 */
	public List<PcrpQueryInfo> singleFindByPage(PcrpQueryInfo pcrpDocInfo)
			throws DAOException {
		List CrpDocInfoList = null;
		try {
			CrpDocInfoList = getSqlMapClientTemplate().queryForList("PcrpQueryInfo.singleFindByPage", pcrpDocInfo);
		} catch (Exception e) {
			log.error(e);
			throw new DAOException("��ҳ��ѯʧ��");
		}
		return CrpDocInfoList;
	}


	public void insert(PcrpQueryInfo pcrpDocInfo) throws DAOException {
		try {
			getSqlMapClientTemplate().insert("PcrpQueryInfo.insert",pcrpDocInfo);
			//������Ȩ�ļ�ʹ��״̬
//			if(pcrpDocInfo.getCrpSts().equals(CachecodeUtil.CRP_CRP_STS1)&&pcrpDocInfo.getCrpReason().equals(CachecodeUtil.CRP_TYPE0_REASON_CREDLAT)){
//				String aftid= pcrpDocInfo.getAft_id();
//		    getSqlMapClientTemplate().update("PcrpQueryInfoAFT.updateaftloanuseflag",aftid);
//			}else{
//			getSqlMapClientTemplate().update("PcrpGrantFileInfo.updateuseflag",pcrpDocInfo.getGrandId());
//			}
		} catch (Exception e) {
			log.error(e);
			throw new DAOException("����ʧ��");
		}
	}


	public PcrpQueryInfo getByCrpId(PcrpQueryInfo pcrpQueryInfo) {
		try {
			pcrpQueryInfo = (PcrpQueryInfo) getSqlMapClientTemplate().queryForObject("PcrpQueryInfo.getByCrpId", pcrpQueryInfo);
		} catch (Exception e) {
			log.error(e);
			throw new DAOException("��ҳ��ѯʧ��");
		}
		return pcrpQueryInfo;
	}
	
	//���ݿͻ���Ϣ��ѯ�������ñ���
	public List<PcrpQueryInfo> getByCrp(PcrpQueryInfo pcrpQueryInfo) {
		List<PcrpQueryInfo> list = null;
		try {
			list = (List<PcrpQueryInfo>) getSqlMapClientTemplate().queryForObject("PcrpQueryInfo.getByCrp", pcrpQueryInfo);
		} catch (Exception e) {
			log.error(e);
			throw new DAOException("���ز�ѯ�ͻ����ñ���ʧ��");
		}
		return list;
	}
	
	//���ݿͻ���Ϣ��ѯ�������ñ���
	public String getByUrl(PcrpQueryInfo pcrpQueryInfo) {
		String url = "";
		try {
			url = (String)getSqlMapClientTemplate().queryForObject("PcrpQueryInfo.getByUrl", pcrpQueryInfo);
		} catch (Exception e) {
			log.error(e);
			throw new DAOException("���ز�ѯ�ͻ����ñ���ʧ��");
		}
		return url;
	}
	
	//���ݿͻ�֤�����룬��ѯ������Ϣ������������
	public PcrpQueryInfo existValid(PcrpQueryInfo pcrpQueryInfo) throws DAOException {
		try {
			pcrpQueryInfo = (PcrpQueryInfo) getSqlMapClientTemplate().queryForObject("pcrpQueryInfo.existValid", pcrpQueryInfo);
		} catch (Exception e) {
			log.error(e);
			throw new DAOException(e.getMessage());
		}
		return pcrpQueryInfo;
	}
	
	//���ݿͻ�֤�����룬����״̬
	public void update(PcrpQueryInfo pcrpQueryInfo) throws DAOException {
		try {
			 getSqlMapClientTemplate().update(
					"pcrpQueryInfo.update", pcrpQueryInfo);
		} catch (Exception e) {
			log.error(e);
			throw new DAOException(e.getMessage());
		}
	}

}
