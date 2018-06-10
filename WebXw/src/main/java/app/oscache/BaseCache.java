package app.oscache;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import app.base.SourceTemplate;
import app.creditapp.acc.option.bo.AcComHolidayBo;
import app.creditapp.bo.SysRoleButtonBO;
import app.creditapp.entity.CacheBase;
import app.creditapp.entity.SysGlobal;
import app.creditapp.entity.SysRoleButton;
import app.creditapp.sys.bo.SysGlobalBo;
import app.creditapp.sys.bo.SysPathBo;
import app.creditapp.sys.entity.SysPath;
import app.creditapp.sysConfig.dao.SysRequireTableDao;
import app.creditapp.sysConfig.entity.SysRequireTable;
import app.util.DateUtil;

import com.opensymphony.oscache.base.NeedsRefreshException;
import com.opensymphony.oscache.general.GeneralCacheAdministrator;

/**
 * @����˵�� ���������
 * @�޸�˵��
 */
public class BaseCache extends GeneralCacheAdministrator {
	private static final long serialVersionUID = -4397192926052141162L;
	// ����ʱ��(��λΪ��);
	private int refreshPeriod; // 60*60*5
	// �ؼ���ǰ׺�ַ�;
	private String keyPrefix; // CMSII
	
	private Map<String,String> uploadParms;
	
	public BaseCache(int refreshPeriod, String keyPrefix) {
		super();
		this.keyPrefix = keyPrefix;
		this.refreshPeriod = refreshPeriod;
	}

	// ��ӱ�����Ķ���--����
	public void put(String key, Object value, String[] groups) {
		this.putInCache(this.keyPrefix + "_" + key, value, groups);
	}

	// ��ӱ�����Ķ���;
	public void put(String key, Object value) {
		this.putInCache(this.keyPrefix + "_" + key, value,
				new String[] { "group_other" });
	}

	// ɾ��������Ķ���--��keyɾ��
	public void removeByKey(String key) {
		this.flushEntry(this.keyPrefix + "_" + key);
	}

	// ɾ�����б�����Ķ���;
	public void removeAll(Date date) {
		this.flushAll(date);
	}

	public void removeAll() {
		this.flushAll();
	}

	// ɾ��������Ķ���--����ɾ��
	public void removeByGroup(String group) {
		this.flushGroup(group);
	}
	
	/**
	 * ������а�ť����,���¼��ذ�ť����
	 * 
	 * @return
	 * @throws Exception
	 */
	public void reloadButton() throws Exception {
		this.removeByGroup(this.getGroups(5)[0]);
		this.initButton();
		this.initSecurity();
	}
	/**
	 * �����ȫ��ƻ���,���¼���
	 * 
	 * @return
	 * @throws Exception
	 */
	public void reloadSecurity() throws Exception {
		this.removeByKey("useSecurity");
		this.removeByKey("comm_flag");
		this.initSecurity();
	}

	/**
	 * 
	 * @����˵���� ȡ����ʵ��
	 * @param key
	 *            �ؼ���
	 * @param select
	 *            CachecodeUtil.CACHE_DATADICT �����ֵ� CachecodeUtil.CACHE_ORG ���û���
	 * @return ArrayList<CacheBean>
	 * @�޸�˵����
	 */ 
	public Object getBeanCache(String key, int select) {
		String _key = this.keyPrefix + "_" + key;
		Object result = null;
		try {
			result = getFromCache(_key, this.refreshPeriod);
		} catch (NeedsRefreshException e) {// ��������ڣ���ѯ���ݿ�
			boolean updated = false;
			try {
				result = new CodeUtils(key).getBeanCache(select);
				this.put(key, result, getGroups(select));
				updated = true;
			} catch (Exception exception) {
				this.removeByKey(key);
			} finally {
				if (!updated) {// ��ֹ�Ҳ������󻺴棬һֱ�ȴ���ȥ��
					this.cancelUpdate(_key);
				}
			}
		}
		return result;
	}
	
	
	public Map<String,String> getUploadParm() {
		uploadParms = new HashMap<String,String>();
		List<CacheBase> caches =(List<CacheBase>) this.getBeanCache("UPLOAD_PARM", CachecodeUtil.CACHE_DATADICT);
		for (CacheBase base: caches) {
			uploadParms.put(base.getOpt_code(), base.getOpt_name());
		}
		return uploadParms;
	}
	
	
	public Object getBeanCacheNew(String key, int select) {
		String _key = this.keyPrefix + "_" + key;
		Object result = null;
		boolean updated = false;
		try {
			result = new CodeUtils(key).getBeanCache(select);
			this.put(key, result, getGroups(select));
			updated = true;
		} catch (Exception exception) {
			this.removeByKey(key);
		} finally {
			if (!updated) {// ��ֹ�Ҳ������󻺴棬һֱ�ȴ���ȥ��
				this.cancelUpdate(_key);
			}
		}
		
		return result;
	}
	
	/**
	 * ������������ѯȨ�ް�ť�����е�ֵ
	 * @param key
	 * @param roleOrUser ϵͳȨ��ģʽ user = ��ɫ role = Ȩ��
	 * @return
	 */
	public boolean getBeanCacheForButton(String key, String orguser) {
		String _key = this.keyPrefix + "_" + key;
		Object result = "";
		boolean flag = false;
		try {
			result = getFromCache(_key, -1);
			if ("0".equals(result)) {
				flag = true;
			} else {
				flag = false;
			}
		} catch (Exception ee) {
			flag = false;
			this.cancelUpdate(_key);
		}
		return flag;
	}
	
	
	public void initSystemStatus() throws NeedsRefreshException {
		SysGlobalBo sysGlobalBo = (SysGlobalBo) SourceTemplate.getContext().getBean("sysGlobalBo");
		SysGlobal SysGlobal = sysGlobalBo.getSysGlobal();
		this.put(CachecodeUtil.SYS_GLOBAL_STATUS_STR, SysGlobal.getSys_sts(), getGroups(CachecodeUtil.SYS_GLOBAL_STATUS));
	}
	
     // ϵͳ�������� �ڼ��չ���
//	public void initHoliday() throws NeedsRefreshException {		
//		AcComHolidayBo acComHolidayBo = (AcComHolidayBo)SourceTemplate.getContext().getBean("acComHolidayBo");
//		SysGlobal sg=DateUtil.getSysGlobal();
//		this.put("holidayJson", acComHolidayBo.findHolidayBySysDate(sg.getSys_date().substring(0, 4)));//�Զ���ڼ���
//	}
	
	public int getRefreshPeriod() {
		return refreshPeriod;
	}

	public void setRefreshPeriod(int refreshPeriod) {
		this.refreshPeriod = refreshPeriod;
	}

	public String getKeyPrefix() {
		return keyPrefix;
	}

	public void setKeyPrefix(String keyPrefix) {
		this.keyPrefix = keyPrefix;
	}

	public Map<String, String> getUploadParms() {
		return uploadParms;
	}

	public void setUploadParms(Map<String, String> uploadParms) {
		this.uploadParms = uploadParms;
	}

	public void initApprover() throws NeedsRefreshException {
		this.put(CachecodeUtil.APPROVER_PAS_FST_CHECK_STR, "0", getGroups(CachecodeUtil.APPROVER_PAS_FST_CHECK));
		this.put(CachecodeUtil.APPROVER_PAS_DUE_CHECK_STR, "0", getGroups(CachecodeUtil.APPROVER_PAS_DUE_CHECK));
		this.put(CachecodeUtil.APPROVER_COM_FST_CHECK_STR, "0", getGroups(CachecodeUtil.APPROVER_COM_FST_CHECK));
		this.put(CachecodeUtil.APPROVER_COM_DUE_CHECK_STR, "0", getGroups(CachecodeUtil.APPROVER_COM_DUE_CHECK));
		this.put(CachecodeUtil.APPROVER_COM_SUP_FST_CHECK_STR, "0", getGroups(CachecodeUtil.APPROVER_COM_SUP_FST_CHECK));
		this.put(CachecodeUtil.APPROVER_COM_SUP_DUE_CHECK_STR, "0", getGroups(CachecodeUtil.APPROVER_COM_SUP_DUE_CHECK));
		this.put(CachecodeUtil.APPROVER_EXT_FST_CHECK_STR, "0", getGroups(CachecodeUtil.APPROVER_EXT_FST_CHECK));
	}
	
	/**
	 * ������������ʼ��Ȩ�ް�ť����
	 * @throws NeedsRefreshException 
	 */
	public void initButton() throws NeedsRefreshException {
		SysRoleButtonBO sysRoleButtonBO = (SysRoleButtonBO) SourceTemplate.getContext().getBean("sysRoleButtonBO");
		List<SysRoleButton> list = sysRoleButtonBO.getAll();
		for (SysRoleButton button : list) {
			String key = button.getMenu_no() + "@" + button.getButton_no() + "@" + button.getRole_no();
			this.put(key, "0", getGroups(5));
		}
	}
	/**
	 * ������������ʼ����ȫ��ƻ���
	 * @throws NeedsRefreshException 
	 */
	public void initSecurity() throws NeedsRefreshException {
//		SecurityAuditBo securityAuditBo = (SecurityAuditBo) SourceTemplate.getContext().getBean("securityAuditBo");
//		List<SecurityAudit> auditList = securityAuditBo.findAuditListByCode("PASSWORD");
//		for(SecurityAudit audit:auditList){
//			if(audit.getItemNo().equals("4")){
//				this.put("useSecurity", audit.getIsUse());//�û������ռ�
//			}
//			if(audit.getItemNo().equals("5")){
//				this.put("dataSourceLog", audit.getIsUse());//���ݿ�����ռ�
//			}
//			if(audit.getItemNo().equals("6")){
//				this.put("loginLog", audit.getIsUse());//��½�ռ�
//			}
//		}
//		List<SecurityAudit> auditList_temp = securityAuditBo.findAuditListByCode("COMM_FLAG");
//		for(SecurityAudit audit:auditList_temp){
//			if(audit.getItemNo().equals("7")){
//				this.put("comm_flag", audit.getIsUse());//ϵͳͨ�Žӿ��Ƿ�����
//			}
//		}
//		ResourceBundle prop = ResourceBundle.getBundle("path");
//		String pushMessageServerPath = prop.getString("pushMessageServerPath").trim();
//		String pushMessageRequestPath = prop.getString("pushMessageRequestPath").trim();
//		String websocketEndpointPath = prop.getString("websocketEndpointPath").trim();
//		// �������ͷ�������Ϣ�Ļ���
//		this.put("pushMessageServerPath", pushMessageServerPath);//���ͷ�������ַ
//		this.put("pushMessageRequestPath", pushMessageRequestPath);//���������ַ
//		this.put("websocketEndpointPath", websocketEndpointPath);//endpoint��������ַ��ַ
		
		//ȡ�����롢����ģ��·��
		Map<String,String> sysPathMap = new HashMap<String,String>();
		SysPathBo sysPathBo = (SysPathBo) SourceTemplate.getContext().getBean("sysPathBo");
		List<SysPath> sysPathList = sysPathBo.findList();//��ѯ���м�¼
		for (SysPath sysPath: sysPathList) {
			sysPathMap.put(sysPath.getPathId(),sysPath.getPathDir());
		}
		this.put(CachecodeUtil.SYS_PATH_STR, sysPathMap);
	}
	

	
	/**
	 * ������������ѯ�ñ��Ƿ��¼��־(����)
	 * @param key
	 * @return
	 */
	public boolean getBeanCacheForLogTable(String key) {
		String _key = this.keyPrefix + "_" + key;
		Object result = null;
		boolean flag = false;
		try {
			result = getFromCache(_key, this.refreshPeriod);
			if("0".equals(result)){
				flag = true;
			}
		} catch (NeedsRefreshException e) {
			boolean updated = false;
			try {
				SysRequireTableDao requireLogTableDao = (SysRequireTableDao) SourceTemplate
				.getContext().getBean("sysRequireTableDao");
				List<SysRequireTable> list = requireLogTableDao.getAll();
				for (SysRequireTable rlt : list) {
					if(key.equals(rlt.getTableCode())){
						this.put(rlt.getTableCode(), "0", new String[]{"0"});
						flag = true;
						updated = true;
						System.out.println("LOG��:" + rlt.getTableCode());
					}
				}
			} catch (Exception exception) {
				this.removeByKey(key);
			} finally {
				if (!updated) {// ��ֹ�Ҳ������󻺴棬һֱ�ȴ���ȥ��
					this.cancelUpdate(_key);
				}
			}
		}
		return flag;
	}
	
	/**
	 * ������������ʼ��REQUIRE_LOG_TABLE����
	 * @throws NeedsRefreshException 
	 */
	public void initRequireLogTable() throws NeedsRefreshException {
		SysRequireTableDao requireLogTableDao = (SysRequireTableDao) SourceTemplate
				.getContext().getBean("sysRequireTableDao");
		List<SysRequireTable> list = requireLogTableDao.getAll();
		for (SysRequireTable rlt : list) {
			this.put(rlt.getTableCode(), "0", new String[]{"0"});
		}
	}
	
	// Ĭ��ȡ�����ֵ�
	public Object getCache(String key) {
		// ȡ�����ֵ�
//		return getBeanCache(key, CachecodeUtil.CACHE_DATADICT);
		return getBeanCacheNew(key, CachecodeUtil.CACHE_DATADICT);
	}
	// Ĭ��ȡ�����ֵ�  
	public Object getCacheFastMenu(String key) {
		// ȡ�����ֵ�
		return getBeanCache(key, CachecodeUtil.FAST_MENU);
	}
	// Ĭ��ȡ�����ֵ�
	public void initCache() {
		// ȡ�����ֵ�
		CodeUtils util = new CodeUtils();
		for (String key : util.getAllKey()) {
			this.getCache(key);
		}
		util = null;
	}
	
	public String[] getGroups(int select) {
		String value = "";
		if (1 == select) {
			value = "group_datadict";
		} else if (2 == select) {
			value = "group_org";
		} else if (3 == select) {
			value = "group_cmsorg";
		} else if (4 == select) {
			value = "group_dhcorg";
		} else if (5 == select){
			value = "group_button";
		}else if (6 == select){
			value = "group_fastmenu";
		}else if (7 == select){
			value = "group_approvalOpSeq";
		} 
		else {
			value = "group_other";
		}
		return new String[] { value };
	}

}
