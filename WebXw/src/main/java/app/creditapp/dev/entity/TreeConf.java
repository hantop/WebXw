package app.creditapp.dev.entity;
import app.base.BaseDomain;
/**
* Title: TreeConf.java
* Description:
* @version��1.0
**/
public class TreeConf extends BaseDomain {
	private String tri_lev;//�ڵ㴥������
	private String select_type;//ѡ��ģʽ[1��ѡ2��ѡ]
	private String sql;//��ѯSQL���
	private String scene_desc;//��������
	private String scene_id;//�������
	private String params;//����
	private String tri_func;//��������

	/**
	 * @return �ڵ㴥������
	 */
	public String getTri_lev() {
	 	return tri_lev;
	}
	/**
	 * @���� �ڵ㴥������
	 * @param tri_lev
	 */
	public void setTri_lev(String tri_lev) {
	 	this.tri_lev = tri_lev;
	}
	/**
	 * @return ѡ��ģʽ[1��ѡ2��ѡ]
	 */
	public String getSelect_type() {
	 	return select_type;
	}
	/**
	 * @���� ѡ��ģʽ[1��ѡ2��ѡ]
	 * @param select_type
	 */
	public void setSelect_type(String select_type) {
	 	this.select_type = select_type;
	}
	/**
	 * @return ��ѯSQL���
	 */
	public String getSql() {
	 	return sql;
	}
	/**
	 * @���� ��ѯSQL���
	 * @param sql
	 */
	public void setSql(String sql) {
	 	this.sql = sql;
	}
	/**
	 * @return ��������
	 */
	public String getScene_desc() {
	 	return scene_desc;
	}
	/**
	 * @���� ��������
	 * @param scene_desc
	 */
	public void setScene_desc(String scene_desc) {
	 	this.scene_desc = scene_desc;
	}
	/**
	 * @return �������
	 */
	public String getScene_id() {
	 	return scene_id;
	}
	/**
	 * @���� �������
	 * @param scene_id
	 */
	public void setScene_id(String scene_id) {
	 	this.scene_id = scene_id;
	}
	/**
	 * @return ����
	 */
	public String getParams() {
	 	return params;
	}
	/**
	 * @���� ����
	 * @param params
	 */
	public void setParams(String params) {
	 	this.params = params;
	}
	/**
	 * @return ��������
	 */
	public String getTri_func() {
	 	return tri_func;
	}
	/**
	 * @���� ��������
	 * @param tri_func
	 */
	public void setTri_func(String tri_func) {
	 	this.tri_func = tri_func;
	}
}