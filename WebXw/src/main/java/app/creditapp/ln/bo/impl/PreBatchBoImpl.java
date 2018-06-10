package  app.creditapp.ln.bo.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import app.base.BaseService;
import app.base.CreateKey;
import app.base.ServiceException;
import app.creditapp.inf.entity.ResponseParm;
import app.creditapp.inf.entity.WsIn2001;
import app.creditapp.inf.entity.WsIn2001_1;
import app.creditapp.inf.entity.WsIn2001_1_1;
import app.creditapp.inf.entity.WsIn2004;
import app.creditapp.inf.entity.WsIn2004_1;
import app.creditapp.inf.entity.WsIn2005;
import app.creditapp.inf.entity.WsOut2004;
import app.creditapp.ln.bo.PreBatchBo;
import app.creditapp.ln.dao.PreApplyDao;
import app.creditapp.ln.dao.PreBatchDao;
import app.creditapp.ln.entity.PreBatch;
import app.util.DateUtil;
import app.util.IbatisUtils;
import app.util.ruleFiter.entity.ValidateLog;
import app.util.ruleFiter.fiter.FiterEngineInterface;
import app.util.toolkit.Ipage;
/**
* Title: PreBatchBoImplImpl.java
* Description:
**/
public class PreBatchBoImpl extends BaseService implements PreBatchBo {

	private PreBatchDao preBatchDao;
	private PreApplyDao preApplyDao;  // ��ϸ��Ϣ����־ò����
	private FiterEngineInterface filterEngineInterface;
	
	public void del(PreBatch preBatch) throws ServiceException {
		try {
			preBatchDao.del(preBatch);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}

	public Ipage findByPage(Ipage ipg, PreBatch preBatch)
			throws ServiceException {
		try {
			ipg.initPageCounts(new Integer[] { (Integer) preBatchDao
					.getCount(preBatch) });// ��ʼ����ҳ��
			HashMap<String, Object> map = (HashMap<String, Object>) IbatisUtils
					.getEntityPropertyMap(ipg, preBatch);
			map.put("startNum", ipg.getStartRow());
			map.put("endNum", ipg.getEndNum());
			ipg.setResult(preBatchDao.findByPage(map));
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return ipg;
	}

	public PreBatch getById(PreBatch preBatch) throws ServiceException {
		try {
			preBatch = preBatchDao.getById(preBatch);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return preBatch;
	}

	public void insert(PreBatch preBatch) throws ServiceException {
		try {
			preBatchDao.insert(preBatch);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}

	public void update(PreBatch preBatch) throws ServiceException {
		try {
			preBatchDao.update(preBatch);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}
	
	public void updateNum(PreBatch preBatch) throws ServiceException {
		try {
			preBatchDao.updateNum(preBatch);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}
	
	@Override
	public PreBatch getByPreApply(PreBatch preBatch) throws ServiceException {
		try {
			preBatch = preBatchDao.getByPreApply(preBatch);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return preBatch;
	}

	

	//�ӿ�ws2004����У�飬����
	public ResponseParm validateforPreApplyInsertWs(WsIn2004 wsIn2004) throws ServiceException {
		ResponseParm responseParm = new ResponseParm();
		// û�����⣬����0000��ͬʱ��У��ͨ��
		wsIn2004.setAppId(CreateKey.getPreAppId());
		wsIn2004.setBatchNo(CreateKey.getPreBatchNo());
		responseParm.setRespCode("0000");
		ValidateLog _vlwsin2004, _vlwsin2004_1;
		try {
			_vlwsin2004 = filterEngineInterface.createValidateLog("wsIn2004Id", wsIn2004, true);
			if (!_vlwsin2004.isSuccess()) { // ������
				responseParm.setRespCode("9004");
				responseParm.setRespDesc("�ӿ� 2004  " + _vlwsin2004.getErrorMessage());
			} else {
				if (wsIn2004.getListGage() != null && wsIn2004.getListGage().size()>0) {
					for (WsIn2004_1 wsIn2004_1 : wsIn2004.getListGage()) {
						wsIn2004_1.setAppId(wsIn2004.getAppId());
						_vlwsin2004_1 = filterEngineInterface.createValidateLog("wsIn2004_1Id", wsIn2004_1, true);
						if (!_vlwsin2004_1.isSuccess()) {
							responseParm.setRespCode("9004");
							responseParm.setRespDesc("�ӿ� 2004  " + _vlwsin2004_1.getErrorMessage());
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return responseParm; // ���ش�����Ϣ
	}
	
	/**
	 * У�鲢�洢
	 */
	public Map<String,String> validateAndSave(WsIn2001 wsIn2001) throws ServiceException {
		Map<String,String> errorMap = new HashMap<String,String>();// ������Ϣ����s
		Map<String,String> prePactNoRepeat = new HashMap<String,String>();// ������Ϣ����s
		// ������������Ϣʵ�����
		PreBatch preBatch = new PreBatch();
		// Ĭ������״̬Ϊδ����
		// ����ϸ��Ϣ����У��
		List<WsIn2001_1> wsIn2001_1list =  wsIn2001.getList(); //  Ԥ����������ϸ��Ϣ
		WsIn2001_1 wsIn2001_1 = new WsIn2001_1();
		List<WsIn2001_1_1> wsIn2001_1_1list = new ArrayList<WsIn2001_1_1>();
		WsIn2001_1_1 wsIn2001_1_1 = new WsIn2001_1_1();
		try {
			ValidateLog _vl_wsIn2001 = filterEngineInterface.createValidateLog("wsIn2001Id", wsIn2001, true);
			
			if(!_vl_wsIn2001.isSuccess()){ // ��ʵ��������
				//���Ƚ��ж�wsin2001 brNo,batNo,dataCnt,����У�鲢���У����
				errorMap.put("subject", _vl_wsIn2001.getErrorMessage());
			}else if(_vl_wsIn2001.isSuccess()){
				//�����κ��Ƿ��Ѿ������
				PreBatch preBatchforhave = new PreBatch();
				preBatchforhave.setBatchNo(wsIn2001.getBatNo());
				preBatchforhave = preBatchDao.getById(preBatchforhave);
				String batchNo = wsIn2001.getBatNo();
				if(preBatchforhave != null){
				errorMap.put("repeat","���κ�Ϊ�� "+batchNo+"  �����ظ�");
				}else{
			 // ��ʵ��û����
				int i=0;
				for( ;i<wsIn2001_1list.size(); i++){
					wsIn2001_1 = wsIn2001_1list.get(i);
					boolean _success_flag = true ; // У��ɹ���־
					String appId = CreateKey.getPreAppId(); //��������ҵ����
					wsIn2001_1.setAppId(appId);
					wsIn2001_1.setBatchNo(wsIn2001.getBatNo()); // �������α��
					wsIn2001_1.setBrNo(wsIn2001.getBrNo()); // ���ú����������
					//��WsIn2001_1�����ʵ�������У��
					ValidateLog _vl_wsIn2001_1 = filterEngineInterface.createValidateLog("wsIn2001_1Id", wsIn2001_1, true);
					if(!_vl_wsIn2001_1.isSuccess()){
						if(prePactNoRepeat.get(wsIn2001_1.getPrePactNo())==null){
							prePactNoRepeat.put(wsIn2001_1.getPrePactNo(), "1");
							errorMap.put(wsIn2001_1.getPrePactNo(), _vl_wsIn2001_1.getErrorMessage());
						}else{
							errorMap.put("error", "��ͬ��Ϊ"+wsIn2001_1.getPrePactNo()+"������Ϊ�ظ���ͬ��");
						}
						_success_flag = false;
					}else{
						if(prePactNoRepeat.get(wsIn2001_1.getPrePactNo())==null){
							prePactNoRepeat.put(wsIn2001_1.getPrePactNo(), "1");
						}else{
							errorMap.put("error", "��ͬ��Ϊ"+wsIn2001_1.getPrePactNo()+"������Ϊ�ظ���ͬ��");
							_success_flag = false;
						}
					}
					
					//���wsIn2001_1У��ͨ��,��WsIn2001_1_1�ֶν���У��
					if(_success_flag){
						if(wsIn2001_1.getListGage()!=null && wsIn2001_1.getListGage().size()!=0){
							wsIn2001_1_1list = wsIn2001_1.getListGage();
							int wsIn2001_1_1list_len = wsIn2001_1_1list.size();
							for(int j=0;j<wsIn2001_1_1list_len;j++){
								wsIn2001_1_1 = wsIn2001_1_1list.get(j);
								wsIn2001_1_1.setAppId(appId);
								ValidateLog _vl_wsIn2001_1_1 = filterEngineInterface.createValidateLog("wsIn2001_1_1Id", wsIn2001_1_1, true);
								if(!_vl_wsIn2001_1_1.isSuccess()){
									errorMap.put(wsIn2001_1.getPrePactNo(), _vl_wsIn2001_1_1.getErrorMessage());
									_success_flag = false;
								}
							}
						}
						
					}
					//forѭ������鲻���Ϲ�������ݣ�ֱ�Ӵ��б����Ƴ������ҷ��ش�����Ϣ
					if(!_success_flag){
						wsIn2001_1list.remove(wsIn2001_1); // ��֤��ͨ���� �Ƴ�
						i--;
					}
				}
				prePactNoRepeat.clear();
				prePactNoRepeat=null;
				// �洢
				//ֻ��ͨ��У����б�Ž������ݿ�Ĳ������
				if(wsIn2001_1list.size()!=0 ){
					//�����ݿ�д��ɹ������˶���������
					preBatch.setDbNum(wsIn2001_1list.size()); // У��ͨ���ı���
						preBatch.setBatchNo(wsIn2001.getBatNo());  // ���α��
						preBatch.setBatchDate(DateUtil.getSysDate());    // ��ǰϵͳ����
						preBatch.setBatchTime(DateUtil.getTime());    // ��ǰϵͳʱ��
						preBatch.setBatchNum(wsIn2001.getDataCnt()); // �����м�¼��
						preBatch.setBatchType("01");  				// Ĭ��Ϊ�Զ�����
						preBatch.setBrNo(wsIn2001.getBrNo()); 	    // �����������
						preBatch.setBatchSts("01");
						preBatchDao.insert(preBatch);      // ����������Ϣ
						preApplyDao.insertBatchfor2001(wsIn2001_1list);  // ��������Ԥ������ϸ��Ϣ
				}
			}
		}
	}catch(Exception e){
			e.printStackTrace();
		}
		return errorMap;  // ���ش�����Ϣ
	}
	public  void validateforlist(List<WsIn2001_1> wsIn2001_1list){
		
		
	}
	
	//�ӿ�ws2005����rule.xmlУ�����
	public ResponseParm validateforListWs(WsIn2005 wsIn2005) throws ServiceException{
		ResponseParm responseParm = new ResponseParm();
		responseParm.setRespCode("0000");
		ValidateLog _vl;
		
		try {
			_vl = filterEngineInterface.createValidateLog("wsIn2005Id", wsIn2005, true);
			if(!_vl.isSuccess()){ // ������
				responseParm.setRespCode("9004");
				responseParm.setRespDesc(_vl.getErrorMessage());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return responseParm;  // ���ش�����Ϣ
	}
	
	public int coutforListWs(PreBatch preBatch) throws ServiceException{
		int count = 0;
		try {
			 count = preBatchDao.getCountforlistWs(preBatch);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
		} 

	/**
	 * @���� DHCC-������
	 * @���� Jun 23, 2016
	 * @����˵����Ԥ�������봦������ѯ�ӿ�
	 * @���ز��� ����У�������Ϣ���� �������Ų�ѯ���
	 */
	@Override
	public List<WsOut2004> findByBatchNo(WsOut2004 wsOut2004) throws ServiceException {
		ResponseParm responseParm = new ResponseParm();   //  ��Ӧ���������
//		List<WsPubBean> wsPubBeanList = wsPreApplyDao.findByBatchNo(wsPubBean);// ��δ����
//		return wsPubBeanList;
		return null;
	}

	//�ӿ�ws2005�����������������,��ʼ
	public Ipage findByPageforListWs(Ipage ipg, PreBatch preBatch) throws ServiceException{
		try {
			
			ipg.initPageCounts(new Integer[] { (Integer) preBatchDao.getCountforlistWs(preBatch) });// ��ʼ����ҳ��
			
			HashMap<String, Object> map = (HashMap<String, Object>) IbatisUtils.getEntityPropertyMap(ipg, preBatch);
			map.put("startNum", ipg.getStartRow());
			map.put("endNum", ipg.getEndNum());
			ipg.setResult(preBatchDao.findByPageforlistWs(map));
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return ipg;
	}
	
	
	
	
	public PreBatchDao getPreBatchDao() {
		return preBatchDao;
	}

	public void setPreBatchDao(PreBatchDao preBatchDao) {
		this.preBatchDao = preBatchDao;
	}

	public PreApplyDao getPreApplyDao() {
		return preApplyDao;
	}

	public void setPreApplyDao(PreApplyDao preApplyDao) {
		this.preApplyDao = preApplyDao;
	}

	public FiterEngineInterface getFilterEngineInterface() {
		return filterEngineInterface;
	}

	public void setFilterEngineInterface(FiterEngineInterface filterEngineInterface) {
		this.filterEngineInterface = filterEngineInterface;
	}

	
}