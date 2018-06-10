package app.oscache;
/**
 * 
 * @����˵�� ���浥����
 * @�޸�˵��
 */
public class MBaseCache {
	
	private static BaseCache instance;
	/**
	 * 
	 * @����˵���� ���浥��
	 * @return
	 * @�޸�˵����
	 */
	public static BaseCache getCache() {
		if (instance == null) {
			return getInstance();
		}
		return instance;
	}
	
	private synchronized static BaseCache getInstance() {

		if (instance == null) {
			instance = new BaseCache(CachecodeUtil.REFRESHPERIOD,CachecodeUtil.KEYPREFIX);
		}
		return instance;
	}
	//˽�й���
	private MBaseCache(){
		
	}
}
