package app.creditapp.sys.entity;
import app.base.BaseDomain;
/**
* Title: ProdBrno.java
* Description:
* @version��1.0
**/
public class ProdBrno extends BaseDomain {
	private String pb_id;//���
	private String br_no;//����/��ҵ�����
	private String prod_no;//��Ʒ��
	private String filler;//��ע
	private String op_no;//�Ǽ���
	private String op_brno;//�Ǽǻ���
	private String tx_date;//�Ǽ�����
	private String up_date;//��������
	private String prod_name;

	/**
	 * @return ���
	 */
	public String getPb_id() {
	 	return pb_id;
	}
	/**
	 * @���� ���
	 * @param pb_id
	 */
	public void setPb_id(String pb_id) {
	 	this.pb_id = pb_id;
	}
	/**
	 * @return ����/��ҵ�����
	 */
	public String getBr_no() {
	 	return br_no;
	}
	/**
	 * @���� ����/��ҵ�����
	 * @param br_no
	 */
	public void setBr_no(String br_no) {
	 	this.br_no = br_no;
	}
	/**
	 * @return ��Ʒ��
	 */
	public String getProd_no() {
	 	return prod_no;
	}
	/**
	 * @���� ��Ʒ��
	 * @param prod_no
	 */
	public void setProd_no(String prod_no) {
	 	this.prod_no = prod_no;
	}
	/**
	 * @return ��ע
	 */
	public String getFiller() {
	 	return filler;
	}
	/**
	 * @���� ��ע
	 * @param filler
	 */
	public void setFiller(String filler) {
	 	this.filler = filler;
	}
	/**
	 * @return �Ǽ���
	 */
	public String getOp_no() {
	 	return op_no;
	}
	/**
	 * @���� �Ǽ���
	 * @param op_no
	 */
	public void setOp_no(String op_no) {
	 	this.op_no = op_no;
	}
	/**
	 * @return �Ǽǻ���
	 */
	public String getOp_brno() {
	 	return op_brno;
	}
	/**
	 * @���� �Ǽǻ���
	 * @param op_brno
	 */
	public void setOp_brno(String op_brno) {
	 	this.op_brno = op_brno;
	}
	/**
	 * @return �Ǽ�����
	 */
	public String getTx_date() {
	 	return tx_date;
	}
	/**
	 * @���� �Ǽ�����
	 * @param tx_date
	 */
	public void setTx_date(String tx_date) {
	 	this.tx_date = tx_date;
	}
	/**
	 * @return ��������
	 */
	public String getUp_date() {
	 	return up_date;
	}
	/**
	 * @���� ��������
	 * @param up_date
	 */
	public void setUp_date(String up_date) {
	 	this.up_date = up_date;
	}
	public String getProd_name() {
		return prod_name;
	}
	public void setProd_name(String prod_name) {
		this.prod_name = prod_name;
	}
}