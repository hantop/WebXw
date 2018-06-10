package app.creditapp.cred.bo.impl;

import java.util.List;

import com.alibaba.fastjson.JSON;

import app.base.BaseService;
import app.base.ServiceException;
import app.creditapp.cred.bo.PcrpQueryInfoBo;
import app.creditapp.cred.dao.PcrpQueryInfoDao;
import app.creditapp.cred.dao.PcrpQueryInfoWebService;
import app.creditapp.cred.entity.PcrpQueryInfo;
import app.creditapp.inf.entity.WsIn4103;
import app.util.toolkit.Ipage;
/**
 * 
  * �����ƣ�PcrpQueryInfoBoImpl
  * �������� 
  *�����ˣ�lidong dhcc
  * ����ʱ�䣺2015-7-15 ����01:30:19
  * �޸��ˣ�Administrator  
 * @version
 */
public class PcrpQueryInfoBoImpl extends BaseService implements PcrpQueryInfoBo {
	private PcrpQueryInfoDao pcrpQueryInfoDao;
//	private CreditSelService creditSelResultDao;
	private PcrpQueryInfoWebService pcrpQueryInfoWebService;
	
	public PcrpQueryInfoWebService getPcrpQueryInfoWebService() {
		return pcrpQueryInfoWebService;
	}


	public void setPcrpQueryInfoWebService(
			PcrpQueryInfoWebService pcrpQueryInfoWebService) {
		this.pcrpQueryInfoWebService = pcrpQueryInfoWebService;
	}


	/**
	 * ��ҳ��ѯȫ���Ǽ���Ϣ
	 * �����ˣ�lidong dhcc
	 */
	
	public Ipage findByPage(Ipage ipg, PcrpQueryInfo pcrpQueryInfo) throws ServiceException {
		try {
			ipg.initPageCounts(new Integer[] { (Integer) pcrpQueryInfoDao.getCount(pcrpQueryInfo) });// ��ʼ����ҳ��
			pcrpQueryInfo.setStartNumAndEndNum(ipg);
			ipg.setResult(pcrpQueryInfoDao.findByPage(pcrpQueryInfo));
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException(e.getMessage());
		}
		return ipg;

	}
	

	public List ExportDate( PcrpQueryInfo pcrpQueryInfo) throws ServiceException {
		List PcrpQueryInfoList=pcrpQueryInfoDao.ExportDate(pcrpQueryInfo);
		return PcrpQueryInfoList;
	}

	
	/**
	 * ���˵��ʷ�ҳ��ѯ�Ǽ���Ϣ
	 * �����ˣ�lidong dhcc
	 */
	
	public Ipage singleSearch(Ipage ipg,PcrpQueryInfo pcrpQueryInfo) throws ServiceException {
		try {
			ipg.initPageCounts(new Integer[] { (Integer) pcrpQueryInfoDao.singleGetCount(pcrpQueryInfo) });// ��ʼ����ҳ��
			pcrpQueryInfo.setStartNumAndEndNum(ipg);
			ipg.setResult(pcrpQueryInfoDao.singleFindByPage(pcrpQueryInfo));
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException(e.getMessage());
		}
		return ipg;
	}
	//����������ѯ�������ű���
	public int getBankCount(PcrpQueryInfo pcrpQueryInfo) throws ServiceException{
		int count = 0;
		try {
			count = (Integer) pcrpQueryInfoDao.getBankCount(pcrpQueryInfo);
		}catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException(e.getMessage());
		}
		return count;
	}
	//����������ѯ���ű���
	public int getBatchCount(PcrpQueryInfo pcrpQueryInfo) throws ServiceException{
		int count = 0;
		try {
			count = (Integer) pcrpQueryInfoDao.getBatchCount(pcrpQueryInfo);
		}catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException(e.getMessage());
		}
		return count;
	}
	
	public void insert(PcrpQueryInfo pcrpQueryInfo) throws ServiceException {
		
		try {
			pcrpQueryInfoDao.insert(pcrpQueryInfo);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException(e.getMessage());
		}
	}
	
	
	public PcrpQueryInfo getByCrpId(PcrpQueryInfo pcrpQueryInfo) throws ServiceException {
		try {
		pcrpQueryInfo=(PcrpQueryInfo) pcrpQueryInfoDao.getByCrpId(pcrpQueryInfo);
		return pcrpQueryInfo;
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException(e.getMessage());
		}
	}
	
	//���ݿͻ���Ϣ��ѯ�������ñ���
//	public List<PcrpQueryInfo> getByCrp(PcrpQueryInfo pcrpQueryInfo) throws ServiceException {
//		try {
//			List<PcrpQueryInfo> list =(List<PcrpQueryInfo>) pcrpQueryInfoDao.getByCrp(pcrpQueryInfo);
//		return list;
//		} catch (Exception e) {
//			e.printStackTrace();
//			throw new ServiceException(e.getMessage());
//		}
//	}
	/**
	 * ���ʲ�ѯ���Ž������ ������
	 */
	public String getByCrp(PcrpQueryInfo pcrpQueryInfo) throws ServiceException {
		try {
			//������תjson
//			String selBatchJson = JsonUtil.getJsonString4JavaPOJO(pcrpQueryInfo);
			String selBatchJson = JSON.toJSONString(pcrpQueryInfo);
			//���÷���˽ӿ�
			String selBatch = null;
//			String selBatch = creditSelResultDao.analyticForOneOnLocal(selBatchJson);
		return selBatch;
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException(e.getMessage());
		}
	}
	
	/**
	 * ������ѯ���Ž������ ������
	 */
	public String analyticForResult(WsIn4103 wsIn4103) throws ServiceException {
		try {
			//������תjson
//			String selBatchCrpJson = JsonUtil.getJsonString4JavaPOJO(wsQueryCreditBean);
//			ipg.initPageCounts(new Integer[] { (Integer) creditSelResultDao.getCount(wsQueryCreditBean) });// ��ʼ����ҳ��
//			wsQueryCreditBean.setStartNumAndEndNum (ipg);
			
			String selBatchCrpJson = JSON.toJSONString(wsIn4103);
			//���÷���˽ӿ�
			String selBatchCrp = null;
//			String selBatchCrp = creditSelResultDao.analyticForResult(selBatchCrpJson);
			
		return selBatchCrp;
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException(e.getMessage());
		}
	}
	
	//���ݿͻ���Ϣ����URL
	public String getByUrl(PcrpQueryInfo pcrpQueryInfo) throws ServiceException {
		String url="";
		try {
			url= pcrpQueryInfoDao.getByUrl(pcrpQueryInfo);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException(e.getMessage());
		}
		return url;
	}
	
	
	public PcrpQueryInfoDao getPcrpQueryInfoDao() {
		return pcrpQueryInfoDao;
	}


	public void setPcrpQueryInfoDao(PcrpQueryInfoDao pcrpQueryInfoDao) {
		this.pcrpQueryInfoDao = pcrpQueryInfoDao;
	}

	//���ݿͻ�֤�����룬��ѯ������Ϣ������������
	public PcrpQueryInfo existValid(PcrpQueryInfo pcrpQueryInfo) throws ServiceException {
		// TODO Auto-generated method stub
//		PcrpQueryInfo pcrpQueryInfo = new PcrpQueryInfo();
		try {
			pcrpQueryInfo = pcrpQueryInfoDao.existValid(pcrpQueryInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pcrpQueryInfo;
	}
	
	////���ݿͻ�֤�����룬����״̬
	public void update(PcrpQueryInfo pcrpQueryInfo) throws ServiceException {
		try {
			pcrpQueryInfoDao.update(pcrpQueryInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}



}
