package  app.creditapp.ln.bo.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import app.base.BaseService;
import app.base.CreateKey;
import app.base.ServiceException;
import app.creditapp.inf.entity.RequestParm;
import app.creditapp.inf.entity.ResponseParm;
import app.creditapp.inf.entity.WsIn2101;
import app.creditapp.inf.entity.WsIn2101_1;
import app.creditapp.inf.entity.WsIn2101_1_1;
import app.creditapp.inf.entity.WsIn2101_1_2;
import app.creditapp.inf.entity.WsIn2101_1_3;
import app.creditapp.inf.entity.WsIn2101_1_4;
import app.creditapp.inf.entity.WsIn2103;
import app.creditapp.inf.entity.WsOut2101;
import app.creditapp.inf.entity.WsOut2101_1;
import app.creditapp.ln.bo.LnBatchBo;
import app.creditapp.ln.dao.LnApplyMidDao;
import app.creditapp.ln.dao.LnBatchDao;
import app.creditapp.ln.entity.LnBatch;
import app.util.DateUtil;
import app.util.IbatisUtils;
import app.util.ruleFiter.entity.ValidateLog;
import app.util.ruleFiter.fiter.FiterEngineInterface;
import app.util.toolkit.Ipage;
/**
* Title: LnBatchBoImplImpl.java
* Description:
**/
public class LnBatchBoImpl extends BaseService implements LnBatchBo {


	private LnApplyMidDao lnApplyMidDao; // ��ʽ������ϸ��Ϣ�־û���
	private LnBatchDao lnBatchDao;       // ��ʽ����������Ϣ�־û���
	private FiterEngineInterface filterEngineInterface;

	/**
	 * @���� DHCC-SONG
	 * @���� Jun 27, 2016
	 * @����˵����У�鲢�������α����������м��ҵ��׶α�
	 * @���ز��� ��Ӧ����ʵ��ResponseParm
	 */
	
	public List<WsOut2101_1> validateApplyMid(WsIn2101 wsIn2101) throws ServiceException{
		// ��ȡ��ʽ������ϸ��Ϣ
		WsOut2101 wsOut2101 = new WsOut2101();
		WsOut2101_1 wsOut2101_1 = new WsOut2101_1();
		List<WsIn2101_1> wsIn2101_1List =  wsIn2101.getList(); // ���������м��List -- lnApplyMidList
		List<WsOut2101_1> wsOut2101_1List = wsOut2101.getList();
//		Map<String,String> errorMap = new HashMap<String,String>();// ������Ϣ����
		try {
			String appId = null;
			for(WsIn2101_1 wsIn2101_1 : wsIn2101_1List){
				appId = CreateKey.getLnApplyId();    // ������ʽҵ������ID
				// У����ʽ����������Ϣ
				ValidateLog _vl_applyMid = filterEngineInterface.createValidateLog("wsIn2101_1Id", wsIn2101_1, true);
				boolean _success_flag = true ; // У��ɹ���־
				
				if(!_vl_applyMid.isSuccess()){
//					sealDesc.put(wsLnApplyMid.getPactNo(), _vl_applyMid.getErrorMessage());
					wsOut2101_1.setDealDesc(_vl_applyMid.getErrorMessage());
					wsOut2101_1List.add(wsOut2101_1);
					_success_flag = false;
				}
				
				// У���˻���Ϣ
				if(_success_flag){
					for(WsIn2101_1_1 wsIn2101_1_1 : wsIn2101_1.getListAc()){
//						wsLnAcctMid.setAppId(appId);
						ValidateLog _vl_acct = filterEngineInterface.createValidateLog("wsIn2101_1_1Id", wsIn2101_1_1, true);
						if(!_vl_acct.isSuccess()){
//							errorMap.put(wsLnApplyMid.getPactNo(), _vl_acct.getErrorMessage());
							wsOut2101_1.setDealDesc(_vl_acct.getErrorMessage());
							wsOut2101_1List.add(wsOut2101_1);
							_success_flag = false ;
						}
					}
				}
				
				// У��ѺƷ��Ϣ
				if(_success_flag){
					for(WsIn2101_1_2 wsIn2101_1_2 : wsIn2101_1.getListGage()){
//						wsLnGageMid.setAppId(appId);
						ValidateLog _vl_gage = filterEngineInterface.createValidateLog("wsIn2101_1_2Id", wsIn2101_1_2, true);
						if(!_vl_gage.isSuccess()){
//							errorMap.put(wsLnApplyMid.getPactNo(), _vl_gage.getErrorMessage());
							wsOut2101_1.setDealDesc(_vl_gage.getErrorMessage());
							wsOut2101_1List.add(wsOut2101_1);
							_success_flag = false ;
						}
					}
				}
				
				if(!_success_flag){
					wsIn2101_1List.remove(wsIn2101_1); // ��֤��ͨ���� �Ƴ�
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return wsOut2101_1List;
	}
	
	/**
	 * @���� DHCC-SONG
	 * @���� Jun 27, 2016
	 * @����˵�����������α����������м��ҵ��׶α�
	 * @���ز��� ��Ӧ����ʵ��ResponseParm
	 */
	public void insertBatMidAndStage(WsIn2101 wsIn2101) throws ServiceException{
		// ������������Ϣʵ�����
		LnBatch lnBatch = new LnBatch(); 
		lnBatch.setBatchNo(wsIn2101.getBatNo());   // ���α��
		lnBatch.setBatchDate(DateUtil.getDate());    // ��ǰϵͳ����
		lnBatch.setBatchTime(DateUtil.getTime());    // ��ǰϵͳʱ��
		lnBatch.setBatchNum(wsIn2101.getDataCnt());  // �����м�¼��
		lnBatch.setBatchType("01");  				   // Ĭ��Ϊ�Զ�����
		lnBatch.setBrNo(wsIn2101.getBrNo()); 	       // �����������
		lnBatch.setBatchSts("01");                   // Ĭ������״̬Ϊδ����
		// ��ȡ��ʽ������ϸ��Ϣ
		
		List<WsIn2101_1> wsIn2101_1List =  wsIn2101.getList(); //  ��ʽ����������ϸ��Ϣ
		lnBatch.setDbNum(wsIn2101_1List.size()) ; // �������ݿ����ϸ����
		// ������������
		lnBatchDao.insert(lnBatch);
		// ����������ʽ������ϸ��Ϣ ϵͳ�Զ����ô���������ln_stage�����������ƣ�TRI_LN_APPLYMID_INSERT
//		lnApplyMidDao.insertBatchWs2101_1(wsIn2101_1List);
		lnApplyMidDao.insertBatchWs2101_1(wsIn2101_1List);
	}
	
	@Override
	public ResponseParm search(RequestParm reqParm) throws ServiceException {
		ResponseParm responseParm = new ResponseParm();
		// -- ���� ��ʽ������������ѯҵ���߼�
//		Map<String, Object> map = new HashMap<String, Object>();
//			JSONObject jsonMap = JSONObject.fromObject(reqParm.getContent());
//			JSONObject jsonMap = (JSONObject)JSON.toJSON(reqParm.getContent());
//			Iterator<String> it = jsonMap.keys();
//			while(it.hasNext()) {
//				String key = (String) it.next();
//				map.put(key, jsonMap.get(key));
//			}
		//List<LnApplyMid> palist = lnApplyMidDao.findByBatchno(map);
		// preApplyDao.insertBatch(pbic.getPaList());
		
		//responseParm.setRespCode("");
		//responseParm.setContent(JSONArray.fromObject(palist).toString());
		
		return responseParm;
	}

	/**
	 * @���� DHCC-�ٿ���
	 * @���� July 12, 2016
	 * @����˵�����ӿ�ws2103����rule-WsIn2103.xmlУ�����
	 * @���ز��� ��Ӧ����ʵ��ResponseParm
	 */
	public  ResponseParm validateWsIn(WsIn2103 wsIn2103) throws ServiceException{
		ResponseParm responseParm = new ResponseParm();
		responseParm.setRespCode("0000");
		ValidateLog _vl;		
		try {
			_vl = filterEngineInterface.createValidateLog("wsIn2103Id", wsIn2103, true);
			if(!_vl.isSuccess()){ // ������
				responseParm.setRespCode("9004");
				responseParm.setRespDesc(_vl.getErrorMessage());
			}else{
				LnBatch lnBatch = new LnBatch();
				lnBatch.setBatchNo(wsIn2103.getBatNo());
				int count = lnBatchDao.getCount(lnBatch);
				if(count==0){
					responseParm.setRespCode("2990");
					responseParm.setRespDesc("���κ�Ϊ�� "+wsIn2103.getBatNo()+"  �ļ�¼�����ڣ�");
				}
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return responseParm; 
	}
	public Ipage findByPageforList(Ipage ipg, LnBatch lnBatch) throws ServiceException {
		try {
			ipg.initPageCounts(new Integer[] { (Integer) lnBatchDao.getCountforlist(lnBatch) });// ��ʼ����ҳ��
			HashMap<String, Object> map = (HashMap<String, Object>) IbatisUtils.getEntityPropertyMap(ipg, lnBatch);
			map.put("startNum", ipg.getStartRow());
			map.put("endNum", ipg.getEndNum());
			ipg.setResult(lnBatchDao.findByPageforlist(map));
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return ipg;
	}
	
	public int countforListWs(LnBatch lnBatch) throws ServiceException{
		int count = 0;
		try {
			 count = lnBatchDao.getCountforlist(lnBatch);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
		} 
	
	public void del(LnBatch lnBatch) throws ServiceException {
		try {
			lnBatchDao.del(lnBatch);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}

	public Ipage findByPage(Ipage ipg, LnBatch lnBatch)
			throws ServiceException {
		try {
			ipg.initPageCounts(new Integer[] { (Integer) lnBatchDao
					.getCount(lnBatch) });// ��ʼ����ҳ��
			lnBatch.setStartNumAndEndNum (ipg);
			ipg.setResult(lnBatchDao.findByPage(lnBatch));
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return ipg;
	}

	public LnBatch getById(LnBatch lnBatch) throws ServiceException {
		try {
			lnBatch = lnBatchDao.getById(lnBatch);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return lnBatch;
	}

	public void insert(LnBatch lnBatch) throws ServiceException {
		try {
			lnBatchDao.insert(lnBatch);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}

	public void update(LnBatch lnBatch) throws ServiceException {
		try {
			lnBatchDao.update(lnBatch);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}
	
	public void updateNum(LnBatch lnBatch) throws ServiceException {
		try {
			lnBatchDao.updateNum(lnBatch);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}

	@Override
	public LnBatch getByLnApplyMid(LnBatch lnBatch) throws ServiceException {
		try {
			lnBatch = lnBatchDao.getByLnApplyMid(lnBatch);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return lnBatch;
	}

	public  Map<String,String> validateAndSave(WsIn2101 wsIn2101) throws ServiceException{
		
		Map<String,String> pactNoRepeat = new HashMap<String,String>();// ������Ϣ����s
		Map<String,String> errorMap = new HashMap<String,String>();// ������Ϣ����s
		// ������������Ϣʵ�����
		LnBatch lnBatch = new LnBatch();
//		boolean _success_flag1 = true; //У��ɹ���־
//		//�����κ��Ƿ��Ѿ������
//		LnBatch lnBatchforhave = new LnBatch();
//		lnBatchforhave.setBatchNo(wsIn2101.getBatNo());
		// Ĭ������״̬Ϊδ����
		// ����ϸ��Ϣ����У��
		List<WsIn2101_1> wsIn2101_1list =  wsIn2101.getList(); //  Ԥ����������ϸ��Ϣ
		WsIn2101_1 wsIn2101_1 = null;
		List<WsIn2101_1_1> wsIn2101_1_1list = null;
		List<WsIn2101_1_2> wsIn2101_1_2list = null;
		List<WsIn2101_1_3> wsIn2101_1_3list = null;
		List<WsIn2101_1_4> wsIn2101_1_4list = null;
		WsIn2101_1_1 wsIn2101_1_1 = null;
		WsIn2101_1_2 wsIn2101_1_2 = null;
		WsIn2101_1_3 wsIn2101_1_3 = null;
		WsIn2101_1_4 wsIn2101_1_4 = null;
		
		try {
			ValidateLog _vl_wsIn2101 = filterEngineInterface.createValidateLog("wsIn2101Id", wsIn2101, true);
			
			if(!_vl_wsIn2101.isSuccess()){ // ��ʵ��������
				//���Ƚ��ж�wsin2001 brNo,batNo,dataCnt,����У�鲢���У����
				errorMap.put("subject", _vl_wsIn2101.getErrorMessage());
			}else if(_vl_wsIn2101.isSuccess()){
				String batchNo = wsIn2101.getBatNo();
				lnBatch.setBatchNo(batchNo);
			    int count = lnBatchDao.getCount(lnBatch);
			    if(count != 0){
			    	errorMap.put("repeat","���κ�Ϊ��"+batchNo+"�����ظ�");
			    }else{
			    	// ��ʵ��û����
			    	 int i=0;
					for(;i<wsIn2101_1list.size(); i++){
						boolean _success_flag = true ; // У��ɹ���־
						wsIn2101_1 = wsIn2101_1list.get(i);
						String appId = CreateKey.getLnApplyId(); //��������ҵ����
						wsIn2101_1.setAppId(appId);
						wsIn2101_1.setBatchNo(wsIn2101.getBatNo()); // �������α��
						wsIn2101_1.setBrNo(wsIn2101.getBrNo()); // ���ú����������
						wsIn2101_1.setAppSts("01");//����״̬[01δ����02�Ѵ���]
						wsIn2101_1.setChkRes("00");//ɸ����[00δɸ��01�ɹ�02�ļ�����03�ֶδ���04�������ͻ�05�����ܾ�06�����ܾ�07�ظ�����08��ż��Ϣ������09�������������Ч10������Ŀ�����Ч�����������������Ų���11��Ʒ�Ų����ڻ�����Ч12������ѺƷ��Ϣ13ѺƷ��Ѻ��ֵ����14�˻���Ϣ������15�˻��ſ����ܺͲ����ں�ͬ���99��������]
						wsIn2101_1.setChkDesc("δɸ��");
						wsIn2101_1.setAppDate(DateUtil.getSysDate());
						//��WsIn2001_1�����ʵ�������У��
						ValidateLog _vl_wsIn2101_1 = filterEngineInterface.createValidateLog("wsIn2101_1Id", wsIn2101_1, true);
						if(!_vl_wsIn2101_1.isSuccess()){
							if(pactNoRepeat.get(wsIn2101_1.getPactNo())==null){
								pactNoRepeat.put(wsIn2101_1.getPactNo(), "1");
								errorMap.put(wsIn2101_1.getPactNo(), _vl_wsIn2101_1.getErrorMessage());
							}else{
								errorMap.put(wsIn2101_1.getPactNo(), "��ͬ���ظ�");
							}
							_success_flag = false;
						}else{
							if(pactNoRepeat.get(wsIn2101_1.getPactNo())==null){
								pactNoRepeat.put(wsIn2101_1.getPactNo(), "1");
							}else{
								errorMap.put("error", "��ͬ��Ϊ"+wsIn2101_1.getPactNo()+"������Ϊ�ظ���ͬ��");
								_success_flag = false;
							}
						}
						//���wsIn2001_1У��ͨ��,��WsIn2001_1_1�ֶν���У��
						if(_success_flag&&wsIn2101_1.getListAc()!=null){
							wsIn2101_1_1list = wsIn2101_1.getListAc();
							int wsIn2101_1_1list_len = wsIn2101_1_1list.size();
							for(int j=0;j<wsIn2101_1_1list_len;j++){
								wsIn2101_1_1 = wsIn2101_1_1list.get(j);
								wsIn2101_1_1.setAppId(appId);
								ValidateLog _vl_wsIn2101_1_1 = filterEngineInterface.createValidateLog("wsIn2101_1_1Id", wsIn2101_1_1, true);
								if(!_vl_wsIn2101_1_1.isSuccess()){
									errorMap.put(wsIn2101_1.getPactNo(), _vl_wsIn2101_1_1.getErrorMessage());
									_success_flag = false;
								}
							}
						}else{
							_success_flag = false;
						}
						//���wsIn2001_1_1У��ͨ��,��WsIn2001_1_2�ֶν���У��
						if(_success_flag){
							if(wsIn2101_1.getListGage()!=null){
								wsIn2101_1_2list = wsIn2101_1.getListGage();
								int wsIn2101_1_2list_len = wsIn2101_1_2list.size();
								for(int j=0;j<wsIn2101_1_2list_len;j++){
									wsIn2101_1_2 = wsIn2101_1_2list.get(j);
									wsIn2101_1_2.setAppId(appId);
									ValidateLog _vl_wsIn2101_1_2 = filterEngineInterface.createValidateLog("wsIn2101_1_2Id", wsIn2101_1_2, true);
									if(!_vl_wsIn2101_1_2.isSuccess()){
										errorMap.put(wsIn2101_1.getPactNo(), _vl_wsIn2101_1_2.getErrorMessage());
										_success_flag = false;
									}
								}
							}
						}
						//���wsIn2001_1_2У��ͨ��,��WsIn2001_1_3�ֶν���У��
						if(_success_flag&&wsIn2101_1.getListCom()!=null){
							wsIn2101_1_3list = wsIn2101_1.getListCom();
							int wsIn2101_1_3list_len = wsIn2101_1_3list.size();
							for(int j=0;j<wsIn2101_1_3list_len;j++){
								wsIn2101_1_3 = wsIn2101_1_3list.get(j);
								wsIn2101_1_3.setAppId(appId);
								ValidateLog _vl_wsIn2101_1_3 = filterEngineInterface.createValidateLog("wsIn2101_1_3Id", wsIn2101_1_3, true);
								if(!_vl_wsIn2101_1_3.isSuccess()){
									errorMap.put(wsIn2101_1.getPactNo(), _vl_wsIn2101_1_3.getErrorMessage());
									_success_flag = false;
								}
							}
						}else{
							_success_flag = false;
						}
						//���wsIn2001_1_3У��ͨ��,��WsIn2001_1_4�ֶν���У��
						if(_success_flag&&wsIn2101_1.getListRel()!=null){
							wsIn2101_1_4list = wsIn2101_1.getListRel();
							int wsIn2101_1_4list_len = wsIn2101_1_4list.size();
							for(int j=0;j<wsIn2101_1_4list_len;j++){
								wsIn2101_1_4 = wsIn2101_1_4list.get(j);
								wsIn2101_1_4.setAppId(appId);
								ValidateLog _vl_wsIn2101_1_4 = filterEngineInterface.createValidateLog("wsIn2101_1_4Id", wsIn2101_1_4, true);
								if(!_vl_wsIn2101_1_4.isSuccess()){
									errorMap.put(wsIn2101_1.getPactNo(), _vl_wsIn2101_1_4.getErrorMessage());
									_success_flag = false;
								}
							}
						}else{
							_success_flag = false;
						}
						//forѭ������鲻���Ϲ�������ݣ�ֱ�Ӵ��б����Ƴ������ҷ��ش�����Ϣ
						if(!_success_flag){
							pactNoRepeat.remove(wsIn2101_1.getPactNo());
							wsIn2101_1list.remove(wsIn2101_1); // ��֤��ͨ���� �Ƴ�
							i--;
						}
			       }
					pactNoRepeat.clear();
					pactNoRepeat=null;
				// �洢
				//ֻ��ͨ��У����б�Ž������ݿ�Ĳ������
				if(wsIn2101_1list.size()!=0 ){
					//�����ݿ�д��ɹ������˶���������
					lnBatch.setDbNum(wsIn2101_1list.size()); // У��ͨ���ı���
						//����������Ϣ
						lnBatch.setBatchNo(wsIn2101.getBatNo());  // ���α��
						lnBatch.setBatchDate(DateUtil.getSysDate());    // ��ǰϵͳ����
						lnBatch.setBatchTime(DateUtil.getTime());    // ��ǰϵͳʱ��
						lnBatch.setBatchNum(wsIn2101.getDataCnt()); // �����м�¼��
						lnBatch.setBatchType("01");  				// Ĭ��Ϊ�Զ�����
						lnBatch.setBrNo(wsIn2101.getBrNo()); 	    // �����������
						lnBatch.setBatchSts("01");
						lnBatchDao.insert(lnBatch);
						// ����������ʽ������ϸ��Ϣ ϵͳ�Զ����ô���������ln_stage�����������ƣ�TRI_LN_APPLYMID_INSERT
						lnApplyMidDao.insertBatchWs2101_1(wsIn2101_1list);
				 }
			   }
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return errorMap;  // ���ش�����Ϣ
	}
	public LnBatchDao getLnBatchDao() {
		return lnBatchDao;
	}

	public void setLnBatchDao(LnBatchDao lnBatchDao) {
		this.lnBatchDao = lnBatchDao;
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