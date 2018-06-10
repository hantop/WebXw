package  app.creditapp.ln.bo;

import java.util.List;

import app.base.ServiceException;
import app.creditapp.inf.entity.ResponseParm;
import app.creditapp.inf.entity.WsIn2001_1;
import app.creditapp.inf.entity.WsIn2002;
import app.creditapp.inf.entity.WsIn2004;
import app.creditapp.inf.entity.WsIn2004_1;
import app.creditapp.inf.entity.WsIn2006;
import app.creditapp.inf.entity.WsOut2002_1;
import app.creditapp.ln.entity.PreApply;
import app.util.toolkit.Ipage;

/**
* Title: PreApplyBo.java
* Description:
**/
public interface PreApplyBo {

	public PreApply getById(PreApply preApply) throws ServiceException;

	public void del(PreApply preApply) throws ServiceException;

	public void insert(PreApply preApply) throws ServiceException;

	public void update(PreApply preApply) throws ServiceException;
	
	public void updateZDSP(PreApply preApply) throws ServiceException;

	public Ipage findByPage(Ipage ipg, PreApply preApply) throws ServiceException;
	
	public void pre_screen(String batch_no) throws ServiceException;

	public List<PreApply> getListByPreApply(PreApply preApply) throws ServiceException;
	
	public List<PreApply> findListByBatNo(PreApply preApply) throws ServiceException;

	public List<WsOut2002_1> findByBatchNo(PreApply preApply) throws ServiceException;

	public void insertBatch(final List<WsIn2004_1> wsIn2004_1) throws ServiceException;
	
	public void insertBatchfor2005(final List<WsIn2001_1> wsIn2001_1) throws ServiceException;
	
	public void insertforws(WsIn2004 wsIn2004) throws ServiceException;
	
	public  ResponseParm validateforws2002(WsIn2002 wsIn2002) throws ServiceException;
	
	public  ResponseParm validateforws2006(WsIn2006 wsIn2006) throws ServiceException;
	//�ӿ�ws2006 �б�wsOut2006_1�б��ҳ��ʾ
	public Ipage findByPageforws2006(Ipage ipg, PreApply preApply) throws ServiceException;
	//��ȡ�������������Ľӿ�ws2006_1������
	public int getcountforws2006 (PreApply preApply)throws ServiceException;
	//���ݺ�ͬ�Ÿ���AppId
	public void updateToAppId(PreApply preApply) throws ServiceException;
}