package app.creditapp.fund.entity;
import app.base.BaseDomain;
/**
* Title: FundRightDetail.java
* Description:
* @version��1.0
**/
public class FundRightDetail extends BaseDomain {
	private String detailId;//�ʽ���ϸ��ˮ��
	private String projNo;//��Ŀ���
	private String buyFno;//���ʽ���
	private String saleFno;//�����ʽ���
	private Double txAmt;//����ծȨ���
	private String txTime;//����ʱ��
	private String filler;//��ע

	private String query;//ֻ��
	/**
	 * @return �ʽ���ϸ��ˮ��
	 */
	public String getDetailId() {
	 	return detailId;
	}
	/**
	 * @���� �ʽ���ϸ��ˮ��
	 * @param detailId
	 */
	public void setDetailId(String detailId) {
	 	this.detailId = detailId;
	}
	/**
	 * @return ��Ŀ���
	 */
	public String getProjNo() {
	 	return projNo;
	}
	/**
	 * @���� ��Ŀ���
	 * @param projNo
	 */
	public void setProjNo(String projNo) {
	 	this.projNo = projNo;
	}
	/**
	 * @return ���ʽ���
	 */
	public String getBuyFno() {
	 	return buyFno;
	}
	/**
	 * @���� ���ʽ���
	 * @param buyFno
	 */
	public void setBuyFno(String buyFno) {
	 	this.buyFno = buyFno;
	}
	/**
	 * @return �����ʽ���
	 */
	public String getSaleFno() {
	 	return saleFno;
	}
	/**
	 * @���� �����ʽ���
	 * @param saleFno
	 */
	public void setSaleFno(String saleFno) {
	 	this.saleFno = saleFno;
	}
	/**
	 * @return ����ծȨ���
	 */
	public Double getTxAmt() {
	 	return txAmt;
	}
	/**
	 * @���� ����ծȨ���
	 * @param txAmt
	 */
	public void setTxAmt(Double txAmt) {
	 	this.txAmt = txAmt;
	}
	/**
	 * @return ����ʱ��
	 */
	public String getTxTime() {
	 	return txTime;
	}
	/**
	 * @���� ����ʱ��
	 * @param txTime
	 */
	public void setTxTime(String txTime) {
	 	this.txTime = txTime;
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
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
}