package app.creditapp.inf.entity;

import app.base.BaseDomain;

/**
 * @���� DHCC-WANG
 * @���� Jul 21, 2016
 * list
 * @����   ��ǰ�������---���ʵ����
 */
public class WsOut2806 extends BaseDomain{
	
	private String brNo;     //����������
	private String pactNo;   //��ͬ��          ����
	private String payDate;  //��������
	private Double payAmt;   //������        =5+10+11+12+13
	private Double payTotal; //Ƿ��ϼ�        =6+7+8+9
	private Double payAmt2;   //Ƿ��
	private Double payInte;  //ǷϢ
	private Double payOver;  //��Ϣ
	private Double payFee;   //Ƿ���úϼ�
	private Double curInte;  //�黹��Ϣ        ����δ���˵�Ӧ����Ϣ
	private Double curAmt;   //�黹����        =4-(5+10+12+13)
	private Double curFee;   //�黹����        �ڽɷ�
	private Double payDam;   //��ǰ����ΥԼ��
	private Double bal;      //ʣ�౾��
	private Double premAmt;   //����    �����ڣ�
	private Double serAmt;   //����ѣ����ڣ�
	private Double feeTotal;//���ڷ����ܶ�
	private Double totalAmt;//�����ܶ�
	/**
	 * @return ����������   
	 */
	public String getBrNo() {
		return brNo;
	}
	/**
	 * @param ����������   
	 */
	public void setBrNo(String brNo) {
		this.brNo = brNo;
	}
	/**
	 * @return ��ͬ��    ����       
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
	 * @return ��������    
	 */
	public String getPayDate() {
		return payDate;
	}
	/**
	 * @param ��������    
	 */
	public void setPayDate(String payDate) {
		this.payDate = payDate;
	}
	/**
	 * @return ������   =5+10+11+12+13   
	 */
	public Double getPayAmt() {
		return payAmt;
	}
	/**
	 * @param ������    =5+10+11+12+13   
	 */
	public void setPayAmt(Double payAmt) {
		this.payAmt = payAmt;
	}
	/**
	 * @return Ƿ��ϼ�        =6+7+8+9       
	 */
	public Double getPayTotal() {
		return payTotal;
	}
	/**
	 * @param Ƿ��ϼ�        =6+7+8+9       
	 */
	public void setPayTotal(Double payTotal) {
		this.payTotal = payTotal;
	}
	/**
	 * @return Ƿ��
	 */
	public Double getPayAmt2() {
		return payAmt2;
	}
	/**
	 * @param Ƿ��
	 */
	public void setPayAmt2(Double payAmt2) {
		this.payAmt2 = payAmt2;
	}
	/**
	 * @return ǷϢ
	 */
	public Double getPayInte() {
		return payInte;
	}
	/**
	 * @param ǷϢ
	 */
	public void setPayInte(Double payInte) {
		this.payInte = payInte;
	}
	/**
	 * @return ��Ϣ
	 */
	public Double getPayOver() {
		return payOver;
	}
	/**
	 * @param ��Ϣ
	 */
	public void setPayOver(Double payOver) {
		this.payOver = payOver;
	}
	/**
	 * @return Ƿ���úϼ�    
	 */
	public Double getPayFee() {
		return payFee;
	}
	/**
	 * @param Ƿ���úϼ�    
	 */
	public void setPayFee(Double payFee) {
		this.payFee = payFee;
	}
	/**
	 * @return �黹��Ϣ        ����δ���˵�Ӧ����Ϣ
	 */
	public Double getCurInte() {
		return curInte;
	}
	/**
	 * @param �黹��Ϣ        ����δ���˵�Ӧ����Ϣ
	 */
	public void setCurInte(Double curInte) {
		this.curInte = curInte;
	}
	/**
	 * @return �黹����        =4-(5+10+12+13) 
	 */
	public Double getCurAmt() {
		return curAmt;
	}
	/**
	 * @param �黹����        =4-(5+10+12+13) 
	 */
	public void setCurAmt(Double curAmt) {
		this.curAmt = curAmt;
	}
	/**
	 * @return �黹����        �ڽɷ�
	 */
	public Double getCurFee() {
		return curFee;
	}
	/**
	 * @param �黹����        �ڽɷ�
	 */
	public void setCurFee(Double curFee) {
		this.curFee = curFee;
	}
	/**
	 * @return ��ǰ����ΥԼ��
	 */
	public Double getPayDam() {
		return payDam;
	}
	/**
	 * @param ��ǰ����ΥԼ��
	 */
	public void setPayDam(Double payDam) {
		this.payDam = payDam;
	}
	/**
	 * @return ʣ�౾��
	 */
	public Double getBal() {
		return bal;
	}
	/**
	 * @param ʣ�౾��
	 */
	public void setBal(Double bal) {
		this.bal = bal;
	}
	public Double getPremAmt() {
		return premAmt;
	}
	public void setPremAmt(Double premAmt) {
		this.premAmt = premAmt;
	}
	public Double getSerAmt() {
		return serAmt;
	}
	public void setSerAmt(Double serAmt) {
		this.serAmt = serAmt;
	}
	public Double getFeeTotal() {
		return feeTotal;
	}
	public void setFeeTotal(Double feeTotal) {
		this.feeTotal = feeTotal;
	}
	public Double getTotalAmt() {
		return totalAmt;
	}
	public void setTotalAmt(Double totalAmt) {
		this.totalAmt = totalAmt;
	}
	
}
