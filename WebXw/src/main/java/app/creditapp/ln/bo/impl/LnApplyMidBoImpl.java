package  app.creditapp.ln.bo.impl;

import java.util.HashMap;
import java.util.List;

import app.base.BaseService;
import app.base.ServiceException;
import app.creditapp.inf.entity.ResponseParm;
import app.creditapp.inf.entity.WsIn2102;
import app.creditapp.inf.entity.WsIn2104;
import app.creditapp.inf.entity.WsOut2102;
import app.creditapp.ln.bo.LnApplyMidBo;
import app.creditapp.ln.dao.LnApplyMidDao;
import app.creditapp.ln.entity.LnApplyMid;
import app.util.IbatisUtils;
import app.util.ruleFiter.entity.ValidateLog;
import app.util.ruleFiter.fiter.FiterEngineInterface;
import app.util.toolkit.Ipage;
/**
* Title: LnApplyMidBoImplImpl.java
* Description:
**/
public class LnApplyMidBoImpl extends BaseService implements LnApplyMidBo {

	private LnApplyMidDao lnApplyMidDao;
	private FiterEngineInterface filterEngineInterface;
	
	/**
	 * @���� DHCC-ZKX
	 * @���� July 12, 2016
	 * @����˵�����ӿ�ws2102����rule-WsIn2012.xmlУ�����
	 * @���ز��� ��Ӧ����ʵ��ResponseParm
	 */
	public ResponseParm validateforListWs(WsIn2102 wsIn2102) throws ServiceException{
		ResponseParm responseParm = new ResponseParm();
		responseParm.setRespCode("0000");
		ValidateLog _vl;
		try {
			_vl = filterEngineInterface.createValidateLog("wsIn2102Id", wsIn2102, true);
			if(!_vl.isSuccess()){ // ������
				responseParm.setRespCode("9004");
				responseParm.setRespDesc(_vl.getErrorMessage());
			}else{
				LnApplyMid lnApplyMid = new LnApplyMid();
				lnApplyMid.setBatchNo(wsIn2102.getBatchNo());
				int count = lnApplyMidDao.getCount(lnApplyMid);
				if(count==0){
					responseParm.setRespCode("2990");
					responseParm.setRespDesc("���κ�Ϊ�� "+wsIn2102.getBatchNo()+"  �ļ�¼�����ڣ�");
				}else{
					lnApplyMid.setPactNo(wsIn2102.getPactNo());
					count = lnApplyMidDao.getCount(lnApplyMid);
					if(count==0){
						responseParm.setRespCode("1001");
						responseParm.setRespDesc("��ͬ����Ϊ��  "+ wsIn2102.getPactNo() +"  �ļ�¼�����ڣ�");
					}					
				}
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return responseParm; 
	}
	
	/**
	 * @���� DHCC-ZKX
	 * @���� July 12, 2016
	 * @����˵����������������ѯ�������ݿ�LN_APPLY_MID���л�ȡ����
	 * @���ز��� ��Ӧ����ʵ��WsOut2102
	 */
	@Override
	public List<WsOut2102> findByWsIn(WsIn2102 wsIn2102) throws ServiceException {
		List<WsOut2102> wsOut2102 = lnApplyMidDao.findByWsIn(wsIn2102);
		return wsOut2102;
	}
	
	public void del(LnApplyMid lnApplyMid) throws ServiceException {
		try {
			lnApplyMidDao.del(lnApplyMid);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}

	public Ipage findByPage(Ipage ipg, LnApplyMid lnApplyMid)
			throws ServiceException {
		try {
			ipg.initPageCounts(new Integer[] { (Integer) lnApplyMidDao
					.getCount(lnApplyMid) });// ��ʼ����ҳ��
			lnApplyMid.setStartNumAndEndNum (ipg);
			ipg.setResult(lnApplyMidDao.findByPage(lnApplyMid));
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return ipg;
	}

	public LnApplyMid getById(LnApplyMid lnApplyMid) throws ServiceException {
		try {
			lnApplyMid = lnApplyMidDao.getById(lnApplyMid);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return lnApplyMid;
	}

	/**
	 * @���� DHCC-ZKX
	 * @���� July 12, 2016
	 * @����˵�����ӿ�ws2104����rule-WsIn2104.xmlУ�����
	 * @���ز��� ��Ӧ����ʵ��ResponseParm
	 */
	public  ResponseParm validateWsIn(WsIn2104 wsIn2104) throws ServiceException{
		ResponseParm responseParm = new ResponseParm();
		responseParm.setRespCode("0000");
		ValidateLog _vl;
		try {
			_vl = filterEngineInterface.createValidateLog("wsIn2104Id", wsIn2104, true);
			if(!_vl.isSuccess()){ // ������
				responseParm.setRespCode("0001");
				responseParm.setRespDesc(_vl.getErrorMessage());
			}else{
				LnApplyMid lnApplyMid = new LnApplyMid();
				lnApplyMid.setBatchNo(wsIn2104.getBatNo());
				int count = lnApplyMidDao.getCount(lnApplyMid);
				if(count==0){
					responseParm.setRespCode("2990");
					responseParm.setRespDesc("���κ�Ϊ�� "+wsIn2104.getBatNo()+"  �ļ�¼�����ڣ�");
				}else{
					lnApplyMid.setPactNo(wsIn2104.getPactNo());
					count = lnApplyMidDao.getCount(lnApplyMid);
					if(count==0){
						responseParm.setRespCode("1001");
						responseParm.setRespDesc("��ͬ����Ϊ��  "+ wsIn2104.getPactNo() +"  �ļ�¼�����ڣ�");
					}					
				}
			}	
			//����pageNo��pageSizeĬ��ֵ
			if(wsIn2104.getPageNo() == 0 ){
				//����������ʾ�ڼ�ҳ��ʱ��Ĭ����ʾȫ��������
				wsIn2104.setPageNo(1);
				wsIn2104.setPageSize(9999);
			}else if(wsIn2104.getPageNo() != 0 && wsIn2104.getPageSize() == 0){
				//��������ʾ�ڼ�ҳ��ʱ��Ĭ��ÿҳ��ʾ10��
				wsIn2104.setPageNo(1);
				wsIn2104.setPageSize(10);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return responseParm; 
	}
	/**
	 * @���� DHCC-ZKX
	 * @���� July 12, 2016
	 * @����˵����������������ѯ�������ݿ�LN_APPLY_MID���л�ȡ����
	 * @���ز��� ��Ӧ����ʵ��WsOut2102
	 */
	@Override
	public Ipage findByPageforList(Ipage ipg, LnApplyMid lnApplyMid) throws ServiceException {
		try {
			ipg.initPageCounts(new Integer[] { (Integer) lnApplyMidDao.getCountforlist(lnApplyMid) });// ��ʼ����ҳ��
			HashMap<String, Object> map = (HashMap<String, Object>) IbatisUtils.getEntityPropertyMap(ipg, lnApplyMid);
			map.put("startNum", ipg.getStartRow());
			map.put("endNum", ipg.getEndNum());
			ipg.setResult(lnApplyMidDao.findByPageforlist(map));
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return ipg;
	}
	
	public int countforListWs(LnApplyMid lnApplyMid) throws ServiceException{
		int count = 0;
		try {
			 count = lnApplyMidDao.getCountforlist(lnApplyMid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
		} 
	public void insert(LnApplyMid lnApplyMid) throws ServiceException {
		try {
			lnApplyMidDao.insert(lnApplyMid);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}

	public void update(LnApplyMid lnApplyMid) throws ServiceException {
		try {
			lnApplyMidDao.update(lnApplyMid);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}
	
	public List<LnApplyMid> getListByLnApplyMid(LnApplyMid lnApplyMid) throws ServiceException {
		List<LnApplyMid> list = null;
		try {
			list = lnApplyMidDao.getListByLnApplyMid(lnApplyMid);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return list;
	}

	public List<LnApplyMid> findListByBatNo(String batNo) throws ServiceException{
		List<LnApplyMid> lnApplyMidList = null;
		try {
			lnApplyMidList = lnApplyMidDao.findListByBatNo(batNo);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return lnApplyMidList;
	}
	
	public List<LnApplyMid> findListToWorkA() throws ServiceException{
		List<LnApplyMid> lnApplyMidList;
		try {
			lnApplyMidList =  lnApplyMidDao.findListToWorkA();
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return lnApplyMidList;
	}
	
	public List<LnApplyMid> findListToWorkB() throws ServiceException{
		List<LnApplyMid> lnApplyMidList;
		try {
			lnApplyMidList =  lnApplyMidDao.findListToWorkB();
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return lnApplyMidList;
	}
	
	public List<LnApplyMid> findListToWorkC() throws ServiceException{
		List<LnApplyMid> lnApplyMidList;
		try {
			lnApplyMidList =  lnApplyMidDao.findListToWorkC();
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return lnApplyMidList;
	}
	
	public List<LnApplyMid> findListToWorkD() throws ServiceException{
		List<LnApplyMid> lnApplyMidList;
		try {
			lnApplyMidList =  lnApplyMidDao.findListToWorkD();
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return lnApplyMidList;
	}
	
	//���ݺ�ͬ�Ÿ���AppId
	public void updateToAppId(LnApplyMid lnApplyMid) throws ServiceException{
		try {
			lnApplyMidDao.updateToAppId(lnApplyMid);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}
	
	public LnApplyMid getByPactNo(LnApplyMid lnApplyMid) throws ServiceException{
		try {
			lnApplyMid = lnApplyMidDao.getByPactNo(lnApplyMid);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return lnApplyMid;
	}
	
	/**
	 * ����ʧ�ܷ�ҳ��ѯ
	 */
	public Ipage findByPageToLnFail(Ipage ipg, LnApplyMid lnApplyMid)
		throws ServiceException {
		try {
			ipg.initPageCounts(new Integer[] { (Integer) lnApplyMidDao
					.getCountToLnFail(lnApplyMid) });// ��ʼ����ҳ��
			lnApplyMid.setStartNumAndEndNum (ipg);
			ipg.setResult(lnApplyMidDao.findByPageToLnFail(lnApplyMid));
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return ipg;
	}
	//�����Զ�����returnId
	public int resultIdUpdate(LnApplyMid lnApplyMid) throws ServiceException{
		int result = 0;
		try {
			result = lnApplyMidDao.resultIdUpdate(lnApplyMid);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return result;
	}
	public LnApplyMidDao getLnApplyMidDao() {
		return lnApplyMidDao;
	}

	public void setLnApplyMidDao(LnApplyMidDao lnApplyMidDao) {
		this.lnApplyMidDao = lnApplyMidDao;
	}

	public FiterEngineInterface getFilterEngineInterface() {
		return filterEngineInterface;
	}

	public void setFilterEngineInterface(FiterEngineInterface filterEngineInterface) {
		this.filterEngineInterface = filterEngineInterface;
	}


}