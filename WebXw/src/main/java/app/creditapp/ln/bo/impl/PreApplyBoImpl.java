package  app.creditapp.ln.bo.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import app.base.BaseService;
import app.base.ServiceException;
import app.creditapp.inf.entity.ResponseParm;
import app.creditapp.inf.entity.WsIn2001_1;
import app.creditapp.inf.entity.WsIn2002;
import app.creditapp.inf.entity.WsIn2004;
import app.creditapp.inf.entity.WsIn2004_1;
import app.creditapp.inf.entity.WsIn2006;
import app.creditapp.inf.entity.WsOut2002_1;
import app.creditapp.inf.entity.WsOut2006_1;
import app.creditapp.inf.entity.WsOut2006_1_1;
import app.creditapp.ln.bo.PreApplyBo;
import app.creditapp.ln.dao.PreApplyDao;
import app.creditapp.ln.dao.PreGageDao;
import app.creditapp.ln.entity.PreApply;
import app.creditapp.ln.entity.PreGage;
import app.util.DBUtils;
import app.util.ruleFiter.entity.ValidateLog;
import app.util.ruleFiter.fiter.FiterEngineInterface;
import app.util.toolkit.Ipage;
/**
* Title: PreApplyBoImplImpl.java
* Description:
**/
public class PreApplyBoImpl extends BaseService implements PreApplyBo {

	private PreApplyDao preApplyDao;
	private PreGageDao preGageDao;
	private FiterEngineInterface filterEngineInterface;

	public void del(PreApply preApply) throws ServiceException {
		try {
			preApplyDao.del(preApply);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}

	public Ipage findByPage(Ipage ipg, PreApply preApply)
			throws ServiceException {
		try {
			ipg.initPageCounts(new Integer[] { (Integer) preApplyDao
					.getCount(preApply) });// ��ʼ����ҳ��
			preApply.setStartNumAndEndNum (ipg);
			ipg.setResult(preApplyDao.findByPage(preApply));
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return ipg;
	}

	public PreApply getById(PreApply preApply) throws ServiceException {
		try {
			preApply = preApplyDao.getById(preApply);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return preApply;
	}

	public void insert(PreApply preApply) throws ServiceException {
		try {
			/**
			 * ����Ԥ����������Ϣ������ID������
			 */
			preApply.setAppId(preApplyDao.getKey());
			preApplyDao.insert(preApply);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}

	public void update(PreApply preApply) throws ServiceException {
		try {
			preApplyDao.update(preApply);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}
	public void updateZDSP(PreApply preApply) throws ServiceException {
		try {
			preApplyDao.updateZDSP(preApply);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}
	//ws2006 �ӿ� wsout2006_1 list��ҳ��ʾ
	public Ipage findByPageforws2006(Ipage ipg, PreApply preApply)
			throws ServiceException {
		try {
			ipg.initPageCounts(new Integer[] { (Integer) preApplyDao.getCountforws2006(preApply) });// ��ʼ����ҳ��
			preApply.setStartNumAndEndNum(ipg);
			List<WsOut2006_1> wsOut2006_1list = preApplyDao.findByPageforws2006(preApply);
			List<WsOut2006_1_1> wsOut2006_1_1list = new ArrayList<WsOut2006_1_1>();
			PreGage preGage = new PreGage();
			for(int i = 0;i<wsOut2006_1list.size();i++){
				//����app_id����ȡ��app_id���е�ѺƷ�����б�wsOut2006_1_1list�ķ�ʽ����
				preGage.setAppId(wsOut2006_1list.get(i).getAppId());
				wsOut2006_1_1list = preGageDao.getws2006_1_1list(preGage);
				//ΪwsOut2006_1list�б��е�wsOut2006_1_1list�б����ֵ
				wsOut2006_1list.get(i).setListGage(wsOut2006_1_1list);
			}
			
			
			//��ȡ��ҳ����б���ɷ�ҳ����
			ipg.setResult(wsOut2006_1list);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return ipg;
	}
	//�ӿ�ws2006 ���ط��ϲ�ѯ��������������count
	public int getcountforws2006 (PreApply preApply)throws ServiceException{
		int count = 0;
		count = preApplyDao.getCountforws2006(preApply);
		return count;
	}
	
	public void insertBatch(List<WsIn2004_1> wsIn2004_1) throws ServiceException {
		try {
			preApplyDao.insertBatch(wsIn2004_1);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}
	//�ӿ�ws2001�б�������ݿⷽ��
	public void insertBatchfor2005(List<WsIn2001_1> wsIn2001_1) throws ServiceException {
		try {
			preApplyDao.insertBatchfor2001(wsIn2001_1);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}
	public void insertforws(WsIn2004 wsIn2004) throws ServiceException {
		try {
			/**
			 * ����Ԥ����������Ϣ������ID������
			 */
			preApplyDao.insertforws(wsIn2004);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}
	//У��ws2002�ӿ�����ֵ wsin2002
	public  ResponseParm validateforws2002(WsIn2002 wsIn2002) throws ServiceException{
		ResponseParm responseParm = new ResponseParm();
		//Ĭ�Ϸ��ش���Ϊ0000��Ϊͨ��״̬
		responseParm.setRespCode("0000");
		responseParm.setRespDesc("��������У��ͨ����");
		PreApply wsIn2002forsearch = new PreApply();
		ValidateLog _vlwsin2002;
		try {
			_vlwsin2002 = filterEngineInterface.createValidateLog("wsIn2002Id",wsIn2002, true);
			if(!_vlwsin2002.isSuccess()){
				responseParm.setRespCode("9004");
				responseParm.setRespDesc(_vlwsin2002.getErrorMessage());
			}else{
				String batchNo = wsIn2002.getBatchNo();
				String prePactNo = wsIn2002.getPrePactNo();
				wsIn2002forsearch.setBatchNo(batchNo);
				int count = preApplyDao.getCount(wsIn2002forsearch);
				//�ж��Ƿ���ڸ����κ�
				if(count == 0){
					responseParm.setRespCode("2990");
					responseParm.setRespDesc("���κ�Ϊ�� "+batchNo+"  �ļ�¼�����ڣ�");
				}else{
					wsIn2002forsearch.setPrePactNo(prePactNo);
					int countforPactNo = preApplyDao.getCount(wsIn2002forsearch);
					if(countforPactNo == 0){
						responseParm.setRespCode("1001");
						responseParm.setRespDesc("Ԥ����IDΪ��"+prePactNo+"  �ļ�¼�����ڣ�");
					}
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return  responseParm;
	}
	//У��ws2006�ӿ�����ֵ wsin2006
	public  ResponseParm validateforws2006(WsIn2006 wsIn2006) throws ServiceException{
		ResponseParm responseParm = new ResponseParm();
		//Ĭ�Ϸ��ش���Ϊ0000��Ϊͨ��״̬
		responseParm.setRespCode("0000");
		responseParm.setRespDesc("��������У��ͨ����");
		ValidateLog _vlwsin2002;
		try {
			_vlwsin2002 = filterEngineInterface.createValidateLog("wsIn2006Id",wsIn2006, true);
			if(!_vlwsin2002.isSuccess()){
				responseParm.setRespCode("9004");
				responseParm.setRespDesc(_vlwsin2002.getErrorMessage());
			}else{
				PreApply wsIn2006forsearch = new PreApply();
				String batchNo = wsIn2006.getBatNo();
				String prepactNo = wsIn2006.getPrePactNo();
				wsIn2006forsearch.setBatchNo(batchNo);
				int count = preApplyDao.getCount(wsIn2006forsearch);
				//�ж��Ƿ���ڸ����κ�
				if(count == 0){
					responseParm.setRespCode("2990");
					responseParm.setRespDesc("���κ�Ϊ�� "+batchNo+"  �ļ�¼�����ڣ�");
				}else{
					wsIn2006forsearch.setPrePactNo(prepactNo);
					int countforPactNo = preApplyDao.getCount(wsIn2006forsearch);
					if(countforPactNo == 0){
						responseParm.setRespCode("1001");
						responseParm.setRespDesc("Ԥ����IDΪ��  "+ prepactNo +"  �ļ�¼�����ڣ�");
					}
				}
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return  responseParm;
		
	}
	
	/**
	 * ws2002�ӿڲ�ѯ������ط���
	 */
	public List<WsOut2002_1> findByBatchNo(PreApply preApply) throws ServiceException{
		List<WsOut2002_1> wsOut2002_1list = new ArrayList<WsOut2002_1>();
		wsOut2002_1list = preApplyDao.findByBatchNo(preApply);
		return wsOut2002_1list;
	}
	/*public List<WsOut2004> findByBatchNo(WsIn2004 wsIn2004) throws ServiceException{
		List<PreApply> preApplyList = new ArrayList<PreApply>();
		List<WsOut2004> wsOut2004List = new ArrayList<WsOut2004>();
		try {
			PreApply preApply = new PreApply();
			preApply.setBatchNo(wsIn2004.getBatchNo());
			preApply.setBrNo(wsIn2004.getBrNo());
			preApplyList = preApplyDao.findByBatchNo(preApply);
			//��ȡ�б�Ĵ�С
			int Num = preApplyList.size();
			for(int i = 0;i < Num;i++){
				//��ȡ�б��ʵ����ֵ
				preApply = preApplyList.get(i);
				//ΪwsPubBean��ֵ
				WsOut2004 wsOut2004 = new WsOut2004();
				wsOut2004.setAppSts(preApply.getAppSts());
				wsOut2004.setBrNo(preApply.getBrNo());
				wsOut2004.setBatchNo(preApply.getBatchNo());
				wsOut2004.setPactNo(preApply.getPactNo());
				wsOut2004.setBatchNo(preApply.getBatchNo());
				wsOut2004.setDealRes(preApply.getChkRes());
				wsOut2004.setDealDesc(preApply.getChkDesc());
				//����wsPubBeanʵ����� list
				wsOut2004List.add(wsOut2004);
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		
		return wsOut2004List;
	}
	
	/**
	 * @���� DHCC-SONG
	 * @���� Jun 22, 2016
	 * @����˵����Ԥ�����ڲ�����ɸ�鴦��
	 * @���ز����������д�����Ϣ�б�
	 */
	public void pre_screen(String batch_no) throws ServiceException {
		Connection conn = null;
		CallableStatement proc = null;
		ResultSet cursor = null;
		try {
			  conn = DBUtils.getConn();
			  //conn = DBUtil.getConnection();
		      proc = conn.prepareCall("{ call PKG_PRE_APPLY.PROC_PRE_SCREEN(?,?) }"); //���ô洢����
		      proc.setString(1, batch_no);//���õ�һ�������������
		      proc.registerOutParameter(2, Types.VARCHAR);//�ڶ��������������,��VARCHAR���͵�
		     // proc.registerOutParameter(2, OracleTypes.CURSOR);//�ڶ��������������,���α����͵�
		      proc.execute();// ִ��
		     // cursor = proc.getString(2);//���������� 
		      
		      /** 2016��6��28����ά��̸�꣬��Ϊ�첽������Ҫʵʱ����ɸ����
		       * 
		       * CREATE OR REPLACE PACKAGE BODY PKG_PRE_APPLY IS
				  ------------------------------------------------------------------
				  -- ����������Ԥ�������������ڲ�����ɸ�鴦��
				  -- �������ڣ�ÿ��Ԥ������������
				  -- ��д��Ա��DHCC-SONG
					-- ���ڣ�2016��6��21��
				  ------------------------------------------------------------------
				  PROCEDURE PROC_PRE_SCREEN(P_BATNO VARCHAR2, P_RESULT OUT sys_refcursor) IS
				    --APPLY_REC LN_APPLY_REG%ROWTYPE;
				    --V_CIFNO   VARCHAR2(12);
				    --V_EXISTS  BOOLEAN := TRUE;
				    --V_APPSTS  VARCHAR2(2);  
				  BEGIN
		      cursor = ((OracleCallableStatement)proc).getCursor(2);
		      ErrorMessage em  = null;
		      while(cursor.next()){
		    	  em = new ErrorMessage();
		    	  em.setBatchNo(cursor.getString(1));
		    	  em.setPactNo(cursor.getString(2));
		    	  em.setMessage(cursor.getString(3));
		    	  emList.add(em);
		    	  System.out.println("Ԥ����ҵ���ͬ�ţ�"+cursor.getString(2) + 
		    	  "ɸ��δͨ����ԭ��"+cursor.getString(3));
		      }**/
		      //System.out.println("=testPrint=is="+testPrint);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		} finally {
			DBUtils.closeConnection(conn);
			DBUtils.closeStatement(proc);
			DBUtils.closeResultset(cursor);
		}
	}
	
	 public static void main(String[] args) {
		 new PreApplyBoImpl().pre_screen("1111111");
	 }

	public PreApplyDao getPreApplyDao() {
		return preApplyDao;
	}

	public void setPreApplyDao(PreApplyDao preApplyDao) {
		this.preApplyDao = preApplyDao;
	}

	@Override
	public List<PreApply> getListByPreApply(PreApply preApply)
			throws ServiceException {
		List<PreApply> list = null;
		try {
			
			list = preApplyDao.getListByPreApply(preApply);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return list;
	}
	public List<PreApply> findListByBatNo(PreApply preApply) throws ServiceException{
		List<PreApply> list = null;
		try {
			
			list = preApplyDao.findListByBatNo(preApply);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return list;
	}
	//���ݺ�ͬ�Ÿ���AppId
	public void updateToAppId(PreApply preApply) throws ServiceException{
		try {
			preApplyDao.updateToAppId(preApply);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}
	public PreGageDao getPreGageDao() {
		return preGageDao;
	}

	public void setPreGageDao(PreGageDao preGageDao) {
		this.preGageDao = preGageDao;
	}

	public FiterEngineInterface getFilterEngineInterface() {
		return filterEngineInterface;
	}

	public void setFilterEngineInterface(FiterEngineInterface filterEngineInterface) {
		this.filterEngineInterface = filterEngineInterface;
	}
	
}