package  app.creditapp.sys.bo.impl;
import app.base.BaseService;
import app.base.ServiceException;
import app.creditapp.dao.SysGlobalDAO;
import app.creditapp.entity.SysGlobal;
import app.creditapp.sys.bo.SysGlobalBo;
import app.oscache.CachecodeUtil;
import app.oscache.MBaseCache;
/**
* Title: SysAreaBoImplImpl.java
* Description:
**/

public class SysGlobalBoImpl extends BaseService implements SysGlobalBo {
	  private SysGlobalDAO sysGlobalDAO; 
	  public SysGlobal getSysGlobal() throws ServiceException { 
		  SysGlobal sysGlobal = null;
	    try {
	    	sysGlobal = sysGlobalDAO.getSysGlobal(); 
	    } catch (Exception e) {
	      throw new ServiceException(e.getMessage());
	    }
	    return sysGlobal;
	  }
	  
	 public SysGlobalDAO getSysGlobalDAO() {
		return sysGlobalDAO;
	}

	public void setSysGlobalDAO(SysGlobalDAO sysGlobalDAO) {
		this.sysGlobalDAO = sysGlobalDAO;
	}

	public void updateSts(SysGlobal sysGlobal)  throws ServiceException { 
	    try {
	    	//ϵͳ״̬Ϊ������ɣ�3��ʱ��������
	    	if("1".equals(sysGlobal.getSys_sts())){
	    		String sysSts = getSysGlobal().getSys_sts();
	    		if("1".equals(sysSts)){
	    			throw new ServiceException("ϵͳ�Ѿ����ã�");
	    		} else if("2".equals(sysSts)){
	    			throw new ServiceException("ϵͳ���ڽ������ս���,���Ժ������ã�");
	    		}
	    	}
	    	sysGlobalDAO.updateSts(sysGlobal);
	    	MBaseCache.getCache().put(CachecodeUtil.SYS_GLOBAL_STATUS_STR, sysGlobal.getSys_sts()
	    			, MBaseCache.getCache().getGroups(CachecodeUtil.SYS_GLOBAL_STATUS));
	    } catch (Exception e) {
	      throw new ServiceException(e.getMessage());
	    }
	  }
	public void updateDocSize(SysGlobal sysGlobal)  throws ServiceException { 
		try {
			sysGlobalDAO.update(sysGlobal);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}
}
