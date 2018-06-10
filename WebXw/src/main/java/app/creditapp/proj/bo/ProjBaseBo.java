package  app.creditapp.proj.bo;


import java.util.List;
import app.base.ServiceException;
import app.util.toolkit.Ipage;
import app.creditapp.proj.entity.ProjBase;

/**
* Title: ProjBaseBo.java
* Description:
**/
public interface ProjBaseBo {

	public ProjBase getById(ProjBase projBase) throws ServiceException;
	
	public ProjBase getByIdForProjNo(ProjBase projBase) throws ServiceException;
	
	public ProjBase getByIdForFlag(ProjBase projBase) throws ServiceException;

	public void del(ProjBase projBase) throws ServiceException;

	public void insert(ProjBase projBase) throws ServiceException;

	public void merge(ProjBase projBase) throws ServiceException;
	
	public String update(ProjBase projBase) throws ServiceException;
	
	public void update_Read(ProjBase projBase) throws ServiceException;

	public Ipage findByPage(Ipage ipg, ProjBase projBase) throws ServiceException;
	public Ipage findByPageForUser(Ipage ipg, ProjBase projBase) throws ServiceException;
	
	public Ipage findByMyPage(Ipage ipg, ProjBase projBase) throws ServiceException;
	//��Ŀ/��ģ
	public List<ProjBase> myProj_echarts(ProjBase projBase) throws ServiceException;
	//��Ŀ/ÿ��ҵ����
	public List<ProjBase> myProj_day_echarts(ProjBase projBase) throws ServiceException;
	//��Ŀ��ÿ��ҵ����-������/��һ��
	public List<ProjBase> myProj_fdtype_day_echarts(ProjBase projBase) throws ServiceException;
	/*//������������360��ͼ��Ŀ�б�չʾ
	public Ipage findByPageforCorp(Ipage ipg, ProjBase projBase)throws ServiceException;*/
	
	//������Ŀ״̬
	public void updateSts(ProjBase projBase) throws ServiceException;
	
	public List<ProjBase> getList(ProjBase projBase) throws ServiceException;
	//���� 5105 �ӿ� �������� �� ��Ŀ�� ��У��
	public ProjBase getByIdForBrNo(ProjBase projBase) throws ServiceException;

}