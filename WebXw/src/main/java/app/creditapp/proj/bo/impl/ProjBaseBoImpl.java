package  app.creditapp.proj.bo.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import app.base.BaseService;
import app.base.ServiceException;
import app.creditapp.corp.dao.CorpTaRelDao;
import app.creditapp.corp.entity.CorpTaRel;
import app.creditapp.corp.entity.CorpTaRelforcif;
//import app.creditapp.ln.worker.WorkUtils;
import app.creditapp.proj.bo.ProjBaseBo;
import app.creditapp.proj.dao.ProjBaseDao;
import app.creditapp.proj.dao.ProjMangDao;
import app.creditapp.proj.entity.ProjBase;
import app.util.toolkit.Ipage;
/**
* Title: ProjBaseBoImplImpl.java
* Description:
**/
public class ProjBaseBoImpl extends BaseService implements ProjBaseBo {

	private ProjBaseDao projBaseDao;
	private ProjMangDao projMangDao;
	private CorpTaRelDao corpTaRelDao;

	public void del(ProjBase projBase) throws ServiceException {
		try {
			projBaseDao.del(projBase);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}
	public List<ProjBase> getList(ProjBase projBase) throws ServiceException {
		List  list = null;
		try {
			list = projBaseDao.findpageFormer(projBase);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return list;
	}

	public Ipage findByPage(Ipage ipg, ProjBase projBase)
	
			throws ServiceException {
		try {
			ipg.initPageCounts(new Integer[] { (Integer) projBaseDao
					.getCount(projBase) });// ��ʼ����ҳ��
			projBase.setStartNumAndEndNum (ipg);
			ipg.setResult(projBaseDao.findByPage(projBase));
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return ipg;
	}
	public Ipage findByPageForUser(Ipage ipg, ProjBase projBase)
	
	throws ServiceException {
		try {
			ipg.initPageCounts(new Integer[] { (Integer) projBaseDao
					.getCountForUser(projBase) });// ��ʼ����ҳ��
			projBase.setStartNumAndEndNum (ipg);
			ipg.setResult(projBaseDao.findByPageForUser(projBase));
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return ipg;
	}
	public Ipage findByMyPage(Ipage ipg, ProjBase projBase)
	
	        throws ServiceException {
        try { 	 
        	     
	          ipg.initPageCounts(new Integer[] { (Integer) projBaseDao
			      .getCount(projBase) });// ��ʼ����ҳ��

	          projBase.setStartNumAndEndNum (ipg);
	          ipg.setResult(projBaseDao.findByMyPage(projBase));
        } catch (Exception e) {
	       throw new ServiceException(e.getMessage());
        }
        return ipg;
    }      
	public ProjBase getById(ProjBase projBase) throws ServiceException {
		try {
			projBase = projBaseDao.getById(projBase);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return projBase;
	}
	public ProjBase getByIdForProjNo(ProjBase projBase) throws ServiceException {
		try {
			projBase = projBaseDao.getByIdForProjNo(projBase);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return projBase;
	}
	//���� 5105 �ӿ� �������� �� ��Ŀ�� ��У��
	public ProjBase getByIdForBrNo(ProjBase projBase) throws ServiceException {
		try {
			projBase = projBaseDao.getByIdForBrNo(projBase);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return projBase;
	}
	public ProjBase getByIdForFlag(ProjBase projBase) throws ServiceException {
		try {
			projBase = projBaseDao.getByIdForFlag(projBase);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return projBase;
	}
	public void insert(ProjBase projBase) throws ServiceException {
		try {
			projBaseDao.insert(projBase);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}
	public void merge(ProjBase projBase) throws ServiceException {
		try {
			projBaseDao.merge(projBase);
//			WorkUtils.getInstance().proc_proj_acct();
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}
	public void update_Read(ProjBase projBase) throws ServiceException {
		try {
			projBaseDao.update_Read(projBase);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}
	public String update(ProjBase projBase) throws ServiceException {
		CorpTaRel corpTaRel = new CorpTaRel();
		corpTaRel.setBrNo(projBase.getBrNo());
		corpTaRel.setProjNo(projBase.getProjNo());
		ProjBase projBaseForSearch = new ProjBase();
		String result = "0";
		try {
			//�Ƚ����жϣ�����Ŀ�����brNo�Ƿ���ڣ������ڱ�ʾ����һ����������Ŀ�ţ���Ҫ������Ӻ�������
			projBaseForSearch = projBaseDao.getById(projBase);
			String brNo = projBaseForSearch.getBrNo();
			if(brNo!=null && (!brNo.equals(projBase.getBrNo()))){
				corpTaRel.setBrNo(brNo);
				//����brNo��corpTaRel�������еĿͻ���
				List<CorpTaRel> list = corpTaRelDao.getCifNo(corpTaRel);
				//����projNo��dblink�в������еĿͻ���
				List<CorpTaRelforcif> listm = corpTaRelDao.getByBrNoForDb(corpTaRel);
				int listsize = list.size();
				int listsizem =  listm.size();
				String[] CorpTaRelc = new String[listsize];
				for(int i=0;i<listsize;i++){
					CorpTaRelc[i]= list.get(i).getTaCifNo();
				}
				//����brNo��Corp_ta_rel���н��õ��Ŀͻ��Ž�������
				Arrays.sort(CorpTaRelc);
				String[] Listm = new String[listsizem];
				for(int i = 0;i<listsizem;i++){
					Listm[i] = listm.get(i).getTaCifNo();
				}
				//����projNo��dblink���н��õ��Ŀͻ��Ž�������
				Arrays.sort(Listm);
				if(Arrays.equals(Listm, CorpTaRelc) && listsizem!=0){
					projBaseDao.update(projBase);
					//��corp_Ta_Rel��������
					corpTaRelDao.insertforCorp(corpTaRel);
					corpTaRelDao.deleteforDblink();
					//������ȫ���ܶ�Ӧ��������ô���д洢�͸��£����ؽ��Ϊ1
					result = "1";
				}
			}else{
				//��������Ϊ�յ�ʱ����ô�Ͳ�����У�飬ֱ�ӽ��и��²���
				projBaseDao.update(projBase);
				//��corp_Ta_Rel��������
				//xbb ע���������У���Ϊ��dblink���ӵ��±�����ϵͳ�����ҵ��ϵͳ���н���
//				corpTaRelDao.insertforCorp(corpTaRel);
//				corpTaRelDao.deleteforDblink();
				//������ȫ���ܶ�Ӧ��������ô���д洢�͸��£����ؽ��Ϊ1
				result = "1";	
			}
			return result;
			
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		
	}
	//������Ŀ״̬
	public void updateSts(ProjBase projBase) throws ServiceException {
		try {
			projBaseDao.updateSts(projBase);				
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}
	public  List<ProjBase> myProj_echarts(ProjBase projBase) throws ServiceException {
		List projBaseList = null;
		try {
			projBaseList = projBaseDao.myProj_echarts(projBase);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return projBaseList;
	}
	public  List<ProjBase> myProj_day_echarts(ProjBase projBase) throws ServiceException {
		List projBaseList = null;
		try {
			projBaseList = projBaseDao.myProj_day_echarts(projBase);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return projBaseList;
	}
	public  List<ProjBase> myProj_fdtype_day_echarts(ProjBase projBase) throws ServiceException {
		List projBaseList = null;
		try {
			projBaseList = projBaseDao.myProj_fdtype_day_echarts(projBase);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return projBaseList;
	}
	/*//������������360��ͼ��Ŀ�б�չʾ
	public Ipage findByPageforCorp(Ipage ipg, ProjBase projBase)throws ServiceException {
		try {
			ipg.initPageCounts(new Integer[] { (Integer) projBaseDao.getCountforCorp(projBase)});// ��ʼ����ҳ��
			projBase.setStartNumAndEndNum (ipg);
			ipg.setResult(projBaseDao.getByIdforCorp(projBase));
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return ipg;
	}*/
	public ProjBaseDao getProjBaseDao() {
		return projBaseDao;
	}

	public void setProjBaseDao(ProjBaseDao projBaseDao) {
		this.projBaseDao = projBaseDao;
	}

	public CorpTaRelDao getCorpTaRelDao() {
		return corpTaRelDao;
	}

	public void setCorpTaRelDao(CorpTaRelDao corpTaRelDao) {
		this.corpTaRelDao = corpTaRelDao;
	}

	public ProjMangDao getProjMangDao() {
		return projMangDao;
	}

	public void setProjMangDao(ProjMangDao projMangDao) {
		this.projMangDao = projMangDao;
	}
}