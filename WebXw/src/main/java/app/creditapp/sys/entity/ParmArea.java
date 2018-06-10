package app.creditapp.sys.entity;
import app.base.BaseDomain;
/**
* Title: ParmArea.java
* Description:
* @version��1.0
**/
public class ParmArea extends BaseDomain {
	private String areaNo;//�����������
	private String areaName;//������������
	private String areaLev;//��������
	private String areaUp;//�ϼ���������
	private String postCode;//��������
	private String areaSts;//״̬

	/**
	 * @return �����������
	 */
	public String getAreaNo() {
	 	return areaNo;
	}
	/**
	 * @���� �����������
	 * @param areaNo
	 */
	public void setAreaNo(String areaNo) {
	 	this.areaNo = areaNo;
	}
	/**
	 * @return ������������
	 */
	public String getAreaName() {
	 	return areaName;
	}
	/**
	 * @���� ������������
	 * @param areaName
	 */
	public void setAreaName(String areaName) {
	 	this.areaName = areaName;
	}
	/**
	 * @return ��������
	 */
	public String getAreaLev() {
	 	return areaLev;
	}
	/**
	 * @���� ��������
	 * @param areaLev
	 */
	public void setAreaLev(String areaLev) {
	 	this.areaLev = areaLev;
	}
	/**
	 * @return �ϼ���������
	 */
	public String getAreaUp() {
	 	return areaUp;
	}
	/**
	 * @���� �ϼ���������
	 * @param areaUp
	 */
	public void setAreaUp(String areaUp) {
	 	this.areaUp = areaUp;
	}
	/**
	 * @return ��������
	 */
	public String getPostCode() {
	 	return postCode;
	}
	/**
	 * @���� ��������
	 * @param postCode
	 */
	public void setPostCode(String postCode) {
	 	this.postCode = postCode;
	}
	/**
	 * @return ״̬
	 */
	public String getAreaSts() {
	 	return areaSts;
	}
	/**
	 * @���� ״̬
	 * @param areaSts
	 */
	public void setAreaSts(String areaSts) {
	 	this.areaSts = areaSts;
	}
}