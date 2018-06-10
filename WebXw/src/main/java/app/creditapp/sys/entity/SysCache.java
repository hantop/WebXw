package app.creditapp.sys.entity;
import app.base.BaseDomain;
/**
* Title: SysCache.java
* Description:
* @version��1.0
**/
public class SysCache extends BaseDomain {
	private String cache_no;//�������к�
	private String cache_name;//��������
	private String cache_chn_name;//��������
	private String cache_type;//��������(0ʹ��ʱ���أ�1��������)
	private String cache_desc;//����

	/**
	 * @return �������к�
	 */
	public String getCache_no() {
	 	return cache_no;
	}
	/**
	 * @���� �������к�
	 * @param cache_no
	 */
	public void setCache_no(String cache_no) {
	 	this.cache_no = cache_no;
	}
	/**
	 * @return ��������
	 */
	public String getCache_name() {
	 	return cache_name;
	}
	/**
	 * @���� ��������
	 * @param cache_name
	 */
	public void setCache_name(String cache_name) {
	 	this.cache_name = cache_name;
	}
	/**
	 * @return ��������
	 */
	public String getCache_chn_name() {
	 	return cache_chn_name;
	}
	/**
	 * @���� ��������
	 * @param cache_chn_name
	 */
	public void setCache_chn_name(String cache_chn_name) {
	 	this.cache_chn_name = cache_chn_name;
	}
	/**
	 * @return ��������(0ʹ��ʱ���أ�1��������)
	 */
	public String getCache_type() {
	 	return cache_type;
	}
	/**
	 * @���� ��������(0ʹ��ʱ���أ�1��������)
	 * @param cache_type
	 */
	public void setCache_type(String cache_type) {
	 	this.cache_type = cache_type;
	}
	/**
	 * @return ����
	 */
	public String getCache_desc() {
	 	return cache_desc;
	}
	/**
	 * @���� ����
	 * @param cache_desc
	 */
	public void setCache_desc(String cache_desc) {
	 	this.cache_desc = cache_desc;
	}
}