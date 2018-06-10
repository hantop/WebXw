package app.creditapp.wkf.entity;
import app.base.BaseDomain;
/**
* Title: WkfApprovalRole.java
* Description:
* @version1.0
**/
public class WkfApprovalRole extends BaseDomain 
{
	private String wkfRoleNo;   //������ɫ���
	private String wkfRoleName; //������ɫ����
	private String wkfrolelev;  //������ɫ����
	private String wkfbrno;		//������
	private String br_no;    	//�Ǽǻ���
	private String op_no;		//�Ǽ���
	private String tx_date;		//�Ǽ�����
	private String up_date;		//��������

	/**
	 * @return ������ɫ���
	 */
	 public String getWkfRoleNo() {
	 	return wkfRoleNo;
	 }
	 /**
	 * @ ������ɫ���
	 * @param wkfRoleNo
	 */
	 public void setWkfRoleNo(String wkfRoleNo) {
	 	this.wkfRoleNo = wkfRoleNo;
	 }
	/**
	 * @return ������ɫ����
	 */
	 public String getWkfRoleName() {
	 	return wkfRoleName;
	 }
	 /**
	 * @������ɫ����
	 * @param wkfRoleName
	 */
	 public void setWkfRoleName(String wkfRoleName) {
	 	this.wkfRoleName = wkfRoleName;
	 }
	public String getWkfrolelev() {
		return wkfrolelev;
	}
	public String getWkfbrno() {
		return wkfbrno;
	}
	public void setWkfrolelev(String wkfrolelev) {
		this.wkfrolelev = wkfrolelev;
	}
	public void setWkfbrno(String wkfbrno) {
		this.wkfbrno = wkfbrno;
	}
	public String getBr_no() {
		return br_no;
	}
	public void setBr_no(String brNo) {
		br_no = brNo;
	}
	public String getOp_no() {
		return op_no;
	}
	public void setOp_no(String opNo) {
		op_no = opNo;
	}
	public String getTx_date() {
		return tx_date;
	}
	public void setTx_date(String txDate) {
		tx_date = txDate;
	}
	public String getUp_date() {
		return up_date;
	}
	public void setUp_date(String upDate) {
		up_date = upDate;
	}
	
}