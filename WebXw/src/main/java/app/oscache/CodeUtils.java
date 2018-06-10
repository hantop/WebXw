package app.oscache;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import app.base.SourceTemplate;
import app.creditapp.bo.CacheService;
import app.creditapp.corp.bo.CorpParmBo;
import app.creditapp.corp.entity.CorpParm;
import app.creditapp.proj.bo.ProjParmBo;
import app.creditapp.sys.bo.SysPathBo;
import app.creditapp.sys.entity.SysPath;

/**
 * 
 * @����˵�� ����ת�������ѯ��
 * @�޸�˵��
 */
public class CodeUtils {
	
	String key;

	
	public CodeUtils() {
	}
	
	CodeUtils(String flag) {
		this.key = flag;
	}


	/**
	 * @����˵���� ȡ���棬��List<object[]>ת��ΪList<bean>
	 * @return
	 * @�޸�˵����
	 */
	public Object getBeanCache(int select){
		return this.selectCache(select);
	}
	
	private CacheService cacheService;
	
	private List<Object> getDatadict() {
		/*û��action�е��ã���Ҫ�ֶ���ע����� add by loudw*/
		cacheService = SourceTemplate.getSpringContextInstance().getBean("cacheService",CacheService.class);
		List<Object> result = cacheService.findByCondition(this.key);
		return result;
	}
	
	public  List<String> getAllKey(){
		cacheService = SourceTemplate.getSpringContextInstance().getBean("cacheService",CacheService.class);
		List<String> result = cacheService.findKeyByCondition();
		return result;
	}
	
	/**
	 * @���� DHCC-SONG
	 * @���� Jul 5, 2016
	 * @����˵�� ȡ��Ŀ��������
	 * @���ز��� 
	 */
	public List<Object> getProjParm() {
//		Map<String,Float> rgAppRageMap = new HashMap<String,Float>();
		ProjParmBo projParmBo = (ProjParmBo) SourceTemplate.getContext().getBean("projParmBo");
		List<Object> projParmList = projParmBo.findListBySts("1");
//		for (ProjParm projParm: projParmList) {
//			// rgAppRageMap.put(projParm.getProjNo(),projParm.getRgAppRate());
//		}
		return projParmList;
	}
	
	/**
	 * @���� DHCC-SONG
	 * @���� Jul 5, 2016
	 * @����˵�� ȡ����������������
	 * @���ز��� 
	 */
	public List<Object> getCorpParm() {
//		Map<String,Float> rgAppRageMap = new HashMap<String,Float>();
		CorpParmBo corpParmBo = (CorpParmBo) SourceTemplate.getContext().getBean("corpParmBo");
		List<Object> corpParmList = corpParmBo.findListBySts(null);
//		for (ProjParm projParm: projParmList) {
//			// rgAppRageMap.put(projParm.getProjNo(),projParm.getRgAppRate());
//		}
		return corpParmList;
	}
	
	/**
	 * @���� DHCC-SONG
	 * @���� Jul 5, 2016
	 * @����˵�� ȡ����������������
	 * @���ز��� 
	 */
	public Map<String,String> getSysPath() {
		//ȡ�����롢����ģ��·��
				Map<String,String> sysPathMap = new HashMap<String,String>();
				SysPathBo sysPathBo = (SysPathBo) SourceTemplate.getContext().getBean("sysPathBo");
				List<SysPath> sysPathList = sysPathBo.findList();//��ѯ���м�¼
				for (SysPath sysPath: sysPathList) {
					sysPathMap.put(sysPath.getPathId(),sysPath.getPathDir());
				}
//				this.put(CachecodeUtil.SYS_PATH_STR, sysPathMap);
		return sysPathMap;
	}
	
	
	/**
	 * @����˵���� ����ѡ��
	 * @param select
	 * @return
	 * @�޸�˵����
	 */
	private List<Object> selectCache(int select){
		switch (select){
			//�����ֵ�
		    case CachecodeUtil.CACHE_DATADICT:return this.getDatadict();
		    //������Ŀ�������ñ�
		    case CachecodeUtil.PROJ_PARM:return this.getProjParm();
		    //���������������ñ�
		    case CachecodeUtil.CORP_PARM:return this.getCorpParm();
		    //ϵͳ�������ñ�
//		    case CachecodeUtil.SYS_PATH:return this.getSysPath();
		    // �ڼ��ռ���
			//���û���
//			case 2:return this.getOrgList();
			//cms����
//			case 3:return this.getCmsOrgList();
			//�������
//			case 4:return this.getDhcOrgList();
			default: return null;
		}
	}
}
