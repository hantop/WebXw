package app.creditapp.corp.entity;
import app.base.BaseDomain;
/**
* Title: CorpTaRel.java
* Description:
* @version��1.0
**/
public class CorpTaRel extends BaseDomain {
	private String relid;//������ϵID
	private String brNo;//�Ŵ������������
	private String taCifNo;//��ͨTA�ͻ����
	//�Ǳ�ʵ�����е��ֶ�
	private String projNo;//��Ŀ���

	/**
	 * @return ������ϵID
	 */
	public String getRelid() {
	 	return relid;
	}
	/**
	 * @���� ������ϵID
	 * @param relid
	 */
	public void setRelid(String relid) {
	 	this.relid = relid;
	}
	/**
	 * @return �Ŵ������������
	 */
	public String getBrNo() {
	 	return brNo;
	}
	/**
	 * @���� �Ŵ������������
	 * @param brNo
	 */
	public void setBrNo(String brNo) {
	 	this.brNo = brNo;
	}
	/**
	 * @return ��ͨTA�ͻ����
	 */
	public String getTaCifNo() {
	 	return taCifNo;
	}
	/**
	 * @���� ��ͨTA�ͻ����
	 * @param taCifNo
	 */
	public void setTaCifNo(String taCifNo) {
	 	this.taCifNo = taCifNo;
	}
	public String getProjNo() {
		return projNo;
	}
	public void setProjNo(String projNo) {
		this.projNo = projNo;
	}
	
}