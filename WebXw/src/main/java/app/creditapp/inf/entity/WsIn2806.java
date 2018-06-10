package app.creditapp.inf.entity;

import app.base.BaseDomain;


/**
 * @���� DHCC-WANG
 * @���� Jul 21, 2016
 * @����   ��ǰ�������--����ʵ���� ln_batch
 */
public class WsIn2806 extends BaseDomain{
	
	private String brNo; // �����������
	private String pactNo;// ��ͬ��  ����
	private String payDate; // ��������  ���ڵ��ڵ�ǰ����
	private String payType; // ��������  01-���ֻ���  02-ȫ���
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
	public String getPayType() {
		return payType;
	}
	/**
	 * @param ��������  01-���ֻ���  02-ȫ���
	 */
	public void setPayType(String payType) {
		this.payType = payType;
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
