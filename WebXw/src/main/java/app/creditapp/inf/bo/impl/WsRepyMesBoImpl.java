package  app.creditapp.inf.bo.impl;

import java.util.HashMap;
import java.util.List;

import app.base.BaseService;
import app.base.ServiceException;
import app.creditapp.inf.bo.WsRepyMesBo;
import app.creditapp.inf.dao.WsRepyMesDao;
import app.creditapp.inf.entity.ResponseParm;
import app.creditapp.inf.entity.WsIn2302;
import app.creditapp.inf.entity.WsOut2302_1;
import app.creditapp.inf.entity.WsRepyMes;
import app.creditapp.inf.entity.WsRepyMes_Count;
import app.creditapp.ln.entity.PreApply;
import app.util.IbatisUtils;
import app.util.ruleFiter.entity.ValidateLog;
import app.util.ruleFiter.fiter.FiterEngineInterface;
import app.util.toolkit.Ipage;
/**
* Title: WsRepyMesBoImplImpl.java
* Description:
**/
public class WsRepyMesBoImpl extends BaseService implements WsRepyMesBo {

	private WsRepyMesDao wsRepyMesDao;
	private FiterEngineInterface filterEngineInterface;

	public void del(WsRepyMes wsRepyMes) throws ServiceException {
		try {
			wsRepyMesDao.delete(wsRepyMes);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}

	public Ipage findByPage(Ipage ipg, WsRepyMes wsRepyMes)
			throws ServiceException {
		try {
			ipg.initPageCounts(new Integer[] { (Integer) wsRepyMesDao.getCount(wsRepyMes) });// ��ʼ����ҳ��
			 HashMap<String,Object> map = (HashMap<String,Object>)IbatisUtils.getEntityPropertyMap(ipg, wsRepyMes);
			 map.put("startNum", ipg.getStartRow());
		      map.put("endNum", ipg.getEndNum());
		      ipg.setResult(wsRepyMesDao.findByPage(map)); 
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return ipg;
	}

	public WsOut2302_1 getByIdForNew(WsRepyMes wsRepyMes) throws ServiceException {
		WsOut2302_1 wsOut2302_1 = new WsOut2302_1();
		try {
			wsOut2302_1 = wsRepyMesDao.getByIdForNew(wsRepyMes);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return wsOut2302_1;
	}
	
	public WsRepyMes getById(WsRepyMes wsRepyMes) throws ServiceException {
		try {
			wsRepyMes = wsRepyMesDao.getById(wsRepyMes);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return wsRepyMes;
	}

	public void insert(WsRepyMes wsRepyMes) throws ServiceException {
		try {
			wsRepyMesDao.insert(wsRepyMes);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}

	public void update(WsRepyMes wsRepyMes) throws ServiceException {
		try {
			wsRepyMesDao.update(wsRepyMes);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}
	//�ӿ�ws2302У��
	public ResponseParm getresponse(WsIn2302 wsIn2302)throws ServiceException{
		ResponseParm responseParm = new ResponseParm();
		responseParm.setRespCode("0000");
		responseParm.setRespDesc("��������У��ͨ����");
		ValidateLog _vlws2302;
		try {
			_vlws2302 = filterEngineInterface.createValidateLog("wsIn2302Id", wsIn2302,true);
			if(!_vlws2302.isSuccess()){
				responseParm.setRespCode("9004");
				responseParm.setRespDesc("У����ɣ��������ݸ�ʽ���ڴ���"+_vlws2302.getErrorMessage());
			}else{
				WsRepyMes wsIn2302forsearch = new WsRepyMes();
				String batchNo = wsIn2302.getBatNo();
				String pactNo = wsIn2302.getPactNo();
				wsIn2302forsearch.setBatchNo(batchNo);
				int count = wsRepyMesDao.getCountforws2302(wsIn2302forsearch);
				//�ж��Ƿ���ڸ����κ�
				if(count == 0){
					responseParm.setRespCode("2990");
					responseParm.setRespDesc("���κ�Ϊ�� "+batchNo+"  �ļ�¼�����ڣ�");
				}else{
					wsIn2302forsearch.setPactNo(pactNo);
					int countforPactNo = wsRepyMesDao.getCount(wsIn2302forsearch);
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
	//�ӿ�ws2302��ҳ��ѯʵ�ַ���
	public Ipage findByPageforws2302(Ipage ipg, WsRepyMes wsRepyMes)throws ServiceException {
		try {
			ipg.initPageCounts(new Integer[] { (Integer) wsRepyMesDao.getCountforws2302(wsRepyMes) });// ��ʼ����ҳ��
			wsRepyMes.setStartNumAndEndNum(ipg);
			List<WsOut2302_1> wsOut2301_1list = wsRepyMesDao.findByPageforws2302(wsRepyMes);
			WsOut2302_1 wsOut2302_1 = new WsOut2302_1();
			
			for(int i=0;i<wsOut2301_1list.size();i++){
				wsOut2302_1 = wsOut2301_1list.get(i);
				String dealSts = wsOut2302_1.getDealSts();
				//�� ����ɹ� ��ʵ����Ϣ ��� ������0
				if(!"03".equals(dealSts)){
					wsOut2301_1list.get(i).setFeeTotal(0);
					wsOut2301_1list.get(i).setRepayAmt(0);
					wsOut2301_1list.get(i).setRepayInte(0);
					wsOut2301_1list.get(i).setRepayOver(0);
					wsOut2301_1list.get(i).setRepayTotal(0);
					if(wsOut2301_1list.get(i).getDealDesc()==null){
						wsOut2301_1list.get(i).setDealDesc("");
					}else{
						wsOut2301_1list.get(i).setDealDesc(wsOut2301_1list.get(i).getDealDesc());
					}
					if(dealSts==null){
						wsOut2301_1list.get(i).setDealSts("");	
					}else{
						wsOut2301_1list.get(i).setDealSts(dealSts);	
					}
				}
			}
			//��ȡ��ҳ����б���ɷ�ҳ����
			ipg.setResult(wsOut2301_1list);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	return ipg;
	}
	//�ӿ�ws2302��ȡ����
	public int getCountforws2302(WsRepyMes wsRepyMes) throws ServiceException {
		int count = 0;
		try {
			count = wsRepyMesDao.getCountforws2302(wsRepyMes);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return count;
	}
	//�ۿ���Ϣͳ��
	public Ipage getCountMes(Ipage ipg, WsRepyMes_Count wc) throws ServiceException{
		try {
			ipg.initPageCounts(new Integer[] { (Integer) wsRepyMesDao.getMesCount(wc) });// ��ʼ����ҳ��
			 HashMap<String,Object> map = (HashMap<String,Object>)IbatisUtils.getEntityPropertyMap(ipg, wc);
			 map.put("startNum", ipg.getStartRow());
		      map.put("endNum", ipg.getEndNum());
		      ipg.setResult(wsRepyMesDao.getCountMes(map)); 
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return ipg;
	}
	
	public FiterEngineInterface getFilterEngineInterface() {
		return filterEngineInterface;
	}

	public void setFilterEngineInterface(FiterEngineInterface filterEngineInterface) {
		this.filterEngineInterface = filterEngineInterface;
	}

	public WsRepyMesDao getWsRepyMesDao() {
		return wsRepyMesDao;
	}

	public void setWsRepyMesDao(WsRepyMesDao wsRepyMesDao) {
		this.wsRepyMesDao = wsRepyMesDao;
	}
	
}