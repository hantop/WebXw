package app.creditapp.inf.entity;

import app.base.BaseDomain;


/**
 * @���� su
 * @���� Jan 3, 2018
 * @����   ������ǰ�������
 */
public class WsIn2806_1 extends BaseDomain{
	
	private String brNo; // �����������
	private String pactNo;// ��ͬ��  ����
	private String payDate; // ��������  ���ڵ��ڵ�ǰ����
	private String repType; // ��������  01-���ֻ���  02-ȫ���
	private Double payAmt; // ������
	
	/**
	 * @return �����������
	 */
	public String getBrNo() {
		return brNo;
	}
	/**
	 * @param �����������
	 */
	public void setBrNo(String brNo) {
		this.brNo = brNo;
	}
	/**
	 * @return ��ͬ��  ����
	 */
	public String getPactNo() {
		return pactNo;
	}
	/**
	 * @param ��ͬ��  ����
	 */
	public void setPactNo(String pactNo) {
		this.pactNo = pactNo;
	}
	/**
	 * @return ��������  ���ڵ��ڵ�ǰ����
	 */
	public String getPayDate() {
		return payDate;
	}
	/**
	 * @param ��������  ���ڵ��ڵ�ǰ����
	 */
	public void setPayDate(String payDate) {
		this.payDate = payDate;
	}
	/**
	 * @return ��������  01-���ֻ���  02-ȫ���
	 */
	public String getRepType() {
		return repType;
	}
	/**
	 * @param ��������  01-���ֻ���  02-ȫ���
	 */
	public void setRepType(String repType) {
		this.repType = repType;
	}
	/**
	 * @return ������
	 */
	public Double getPayAmt() {
		return payAmt;
	}
	/**
	 * @param ������
	 */
	public void setPayAmt(Double payAmt) {
		this.payAmt = payAmt;
	}
	
}
