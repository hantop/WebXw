package  app.creditapp.inf.bo.impl;

import java.util.HashMap;
import java.util.List;

import app.base.BaseService;
import app.base.ServiceException;
import app.creditapp.inf.bo.WsRepyClearBo;
import app.creditapp.inf.dao.WsRepyClearDao;
import app.creditapp.inf.entity.ResponseParm;
import app.creditapp.inf.entity.WsIn2303;
import app.creditapp.inf.entity.WsIn2303_1;
import app.creditapp.inf.entity.WsIn2304;
import app.creditapp.inf.entity.WsOut2304;
import app.creditapp.inf.entity.WsRepyClear;
import app.util.IbatisUtils;
import app.util.ruleFiter.entity.ValidateLog;
import app.util.ruleFiter.fiter.FiterEngineInterface;
import app.util.toolkit.Ipage;
/**
* Title: WsRepyClearBoImplImpl.java
* Description:
**/
public class WsRepyClearBoImpl extends BaseService implements WsRepyClearBo {

	private WsRepyClearDao wsRepyClearDao;
	private FiterEngineInterface filterEngineInterface;

	public void del(WsRepyClear wsRepyClear) throws ServiceException {
		try {
			wsRepyClearDao.del(wsRepyClear);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}

	public Ipage findByPage(Ipage ipg, WsRepyClear wsRepyClear)
			throws ServiceException {
		try {
			ipg.initPageCounts(new Integer[] { (Integer) wsRepyClearDao
					.getCount(wsRepyClear) });// ��ʼ����ҳ��
			//			wsRepyClear.setStartNumAndEndNum (ipg);
			HashMap<String, Object> map = (HashMap<String, Object>) IbatisUtils
			.getEntityPropertyMap(ipg, wsRepyClear);
			map.put("startNum", ipg.getStartRow());
			map.put("endNum", ipg.getEndNum());
			ipg.setResult(wsRepyClearDao.findByPage(map));
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return ipg;
	}

	public WsRepyClear getById(WsRepyClear wsRepyClear) throws ServiceException {
		try {
			wsRepyClear = wsRepyClearDao.getById(wsRepyClear);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return wsRepyClear;
	}

	public void insert(WsRepyClear wsRepyClear) throws ServiceException {
		try {
			wsRepyClearDao.insert(wsRepyClear);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}

	public void update(WsRepyClear wsRepyClear) throws ServiceException {
		try {
			wsRepyClearDao.update(wsRepyClear);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}
	//ws2303�ӿ�У�鲢���д洢
	public ResponseParm getresponseParm(WsIn2303 wsIn2303) throws ServiceException{
		ResponseParm responseParm = new ResponseParm();
		List<WsIn2303_1> wsIn2303_1list = null;
		WsIn2303_1 wsIn2303_1 = null;
		ValidateLog _vlws2303;
		responseParm.setRespCode("0000");
		try {
			_vlws2303 = filterEngineInterface.createValidateLog("wsIn2303Id", wsIn2303, true);
			if(_vlws2303.isSuccess()){
				wsIn2303_1list = wsIn2303.getListPayOver();
				if(wsIn2303_1list==null || "".equals(wsIn2303_1list)){
					//��ǰ�����  ������ ��Ϣ
				}else{
					//��ǰ�����  ���� ��Ϣ
					int wsIn2303_1list_len = wsIn2303_1list.size();
					for(int j=0;j<wsIn2303_1list_len;j++){
						wsIn2303_1 = wsIn2303_1list.get(j);
						ValidateLog _vl_wsIn2303_1 = filterEngineInterface.createValidateLog("wsIn2303_1Id", wsIn2303_1, true);
						if(!_vl_wsIn2303_1.isSuccess()){
							//У��û��ͨ��������У����Ϊ0001
							responseParm.setRespCode("9004");
							//���У������
							responseParm.setRespDesc("У����ɣ��������ݸ�ʽ���ڴ���"+_vl_wsIn2303_1.getErrorMessage());
							break;
						}
					}
				}
			}else{
				//У��û��ͨ��������У����Ϊ0001
				responseParm.setRespCode("9004");
				//���У������
				responseParm.setRespDesc("У����ɣ��������ݸ�ʽ���ڴ���"+_vlws2303.getErrorMessage());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return responseParm;
	}
	//�ӿ�ws2303���ݿ�洢
	public void insertforws2303(WsIn2303 wsIn2303) throws ServiceException{
		try {
			wsRepyClearDao.insertforws2303(wsIn2303);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}
	//�ӿ�ws2303�ظ���ͬ��ɾ������
	public void delforws2303(WsRepyClear wsRepyClear) throws ServiceException{
		try {
			wsRepyClearDao.delforws2303(wsRepyClear);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}
	
	//�ӿ�ws2304 ���ڵļ�¼��
	public int  getCountFor2304(WsRepyClear wsRepyClear) throws ServiceException{
		int count = 0;
		try {
			count = wsRepyClearDao.getCountforws3204(wsRepyClear);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return count;
	}
	//ws2304�ӿ�У��
	public ResponseParm getresponseParmfor2304(WsIn2304 wsIn2304) throws ServiceException{
		ResponseParm responseParm = new ResponseParm();
		ValidateLog _vlws2304;
		//У��û��ͨ��������У����Ϊ0001
		responseParm.setRespCode("0000");
		responseParm.setRespDesc("��Ϣ��ѯ�ɹ���");
		try {
			_vlws2304 = filterEngineInterface.createValidateLog("wsIn2304Id", wsIn2304, true);
			if(!_vlws2304.isSuccess()){
				responseParm.setRespCode("9004");
				responseParm.setRespDesc(_vlws2304.getErrorMessage());
			}else{
				WsRepyClear wsIn2304forsearch = new WsRepyClear();
				String brNo = wsIn2304.getBrNo();
				String pactNo = wsIn2304.getPactNo();
				wsIn2304forsearch.setBrNo(brNo);
				int count = wsRepyClearDao.getCountforws3204(wsIn2304forsearch);
				//�ж��Ƿ���ڸ����κ�
				if(count == 0){
					responseParm.setRespCode("1004");
					responseParm.setRespDesc("����������Ϊ�� "+brNo+" �ļ�¼�����ڣ�");
				}else{
					wsIn2304forsearch.setPactNo(pactNo);
					int countforPactNo = wsRepyClearDao.getCountforws3204(wsIn2304forsearch);
					if(countforPactNo == 0){
						responseParm.setRespCode("1001");
						responseParm.setRespDesc("��ͬ��Ϊ��  "+ pactNo +"  �ļ�¼�����ڣ�");
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return responseParm;
	}
	//�ӿ�ws2304���ݺ����ṹ�ţ���ͬ�ŷ��ؽ��ֵ
	public WsOut2304 getInfo(WsIn2304 wsIn2304) throws ServiceException{
		WsOut2304 wsOut2304 = new WsOut2304();
		try {
			wsOut2304 = wsRepyClearDao.getInfo(wsIn2304);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return wsOut2304;
	}
	//�ӿ�ws2304���ݺ����ṹ�ţ���ͬ�ŷ��ؽ��ֵ
	public WsOut2304 getInfoForNew(WsIn2304 wsIn2304) throws ServiceException{
		WsOut2304 wsOut2304 = new WsOut2304();
		try {
			wsOut2304 = wsRepyClearDao.getInfoForNew(wsIn2304);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return wsOut2304;
	}


	public WsRepyClearDao getWsRepyClearDao() {
		return wsRepyClearDao;
	}

	public void setWsRepyClearDao(WsRepyClearDao wsRepyClearDao) {
		this.wsRepyClearDao = wsRepyClearDao;
	}

	public FiterEngineInterface getFilterEngineInterface() {
		return filterEngineInterface;
	}

	public void setFilterEngineInterface(FiterEngineInterface filterEngineInterface) {
		this.filterEngineInterface = filterEngineInterface;
	}

	
	
}