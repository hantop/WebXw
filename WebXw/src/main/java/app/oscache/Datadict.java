package app.oscache;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import app.creditapp.entity.CacheBase;

/**
 * @����˵�� �����ֵ仺�洦��
 * ��eadis_sys_datadict code,name,status ��Ӧ name0,name1,name2
 * ��eadis_sys_datadictrel status��Ӧname3
 * @�޸�˵��
 */
public class Datadict {

	private List<CacheBase> datacache = new ArrayList<CacheBase>();// ������

	public Datadict(ArrayList<CacheBase> list) {
		if (list != null) {
			this.datacache = list;
		}
	}

	@SuppressWarnings("unchecked")
	public Datadict(String ddname) {
		if (StringUtils.isNotBlank(ddname)) {
			List<CacheBase> list = (List<CacheBase>) MBaseCache
					.getCache().getBeanCache(ddname,CachecodeUtil.CACHE_DATADICT);
			if (list != null) {
				this.datacache = list;
			}
		}
	}
	
	public String getDatadictByCode(String code) {
		if (code == null) {
			return null;
		}
		String mess="";
		for (int i = 0; i < this.datacache.size(); i++) {
			if (code.equals(this.datacache.get(i).getOpt_code())) {
				mess=this.datacache.get(i).getOpt_name();
				break;
			}
		}
		return mess;
	}
	/**
	 * 
	 * @����˵���� ����levelȡ����
	 * @param level ���� ���==null���ѯ��ͼ���
	 * @return
	 * @�޸�˵����
	 */
	public List<CacheBase> getDatadictByLevel() {		
		return this.datacache;
	}

}
