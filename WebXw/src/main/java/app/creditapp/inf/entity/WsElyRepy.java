package app.creditapp.inf.entity;
import java.util.List;

import app.base.BaseDomain;
import app.creditapp.corp.entity.CorpBase;
/**
* Title: WsElyRepy.java
* Description:
* @version��1.0
**/
public class WsElyRepy extends accounting.domain.sys.CMISDomain {
	private String wsId;//��������ID
	private String batchNo;//���α��
	private String brNo;//����������
	private String pactNo;//��ͬ��:����
	private Double payTotal;//������:=4+5+6+7
	private Double payAmt;//�����
	private Double payInte;//������Ϣ
	private Double payOver;//��Ϣ
	private Double feeTotal;//����
	private Double feeDam;//ΥԼ��
	private String dealSts;//������[01δ����02������03����ɹ�04����ʧ��]
	private String dealDesc;//��������
	private String txDate;//������������
	
	private String debitType; // ��������  01-ȫ������  02-���ֻ���
	private String onlinOff;//���� 01 ���� 02
	
	private String brName;  //������������
	private String cifName;  //�ͻ�����
	private String projName;  //��Ŀ��
	private String dueSts;   //����״̬
	private String loginid;//��¼��Ա
	
	public String getLoginid() {
		return loginid;
	}
	public void setLoginid(String loginid) {
		this.loginid = loginid;
	}
	public String getDebitType() {
		return debitType;
	}
	public void setDebitType(String debitType) {
		this.debitType = debitType;
	}
	public String getOnlinOff() {
		return onlinOff;
	}
	public void setOnlinOff(String onlinOff) {
		this.onlinOff = onlinOff;
	}
	public String getCifName() {
		return cifName;
	}
	public void setCifName(String cifName) {
		this.cifName = cifName;
	}

	public String getProjName() {
		return projName;
	}
	public void setProjName(String projName) {
		this.projName = projName;
	}
	public String getBrName() {
		return brName;
	}
	public void setBrName(String brName) {
		this.brName = brName;
	}
	/**
	 * @return ��������ID
	 */
	public String getWsId() {
	 	return wsId;
	}
	/**
	 * @���� ��������ID
	 * @param wsId
	 */
	public void setWsId(String wsId) {
	 	this.wsId = wsId;
	}
	/**
	 * @return ���α��
	 */
	public String getBatchNo() {
	 	return batchNo;
	}
	/**
	 * @���� ���α��
	 * @param batchNo
	 */
	public void setBatchNo(String batchNo) {
	 	this.batchNo = batchNo;
	}
	/**
	 * @return ����������
	 */
	public String getBrNo() {
	 	return brNo;
	}
	/**
	 * @���� ����������
	 * @param brNo
	 */
	public void setBrNo(String brNo) {
	 	this.brNo = brNo;
	}
	/**
	 * @return ��ͬ��:����
	 */
	public String getPactNo() {
	 	return pactNo;
	}
	/**
	 * @���� ��ͬ��:����
	 * @param pactNo
	 */
	public void setPactNo(String pactNo) {
	 	this.pactNo = pactNo;
	}
	/**
	 * @return ������:=4+5+6+7
	 */
	public Double getPayTotal() {
	 	return payTotal;
	}
	/**
	 * @���� ������:=4+5+6+7
	 * @param payTotal
	 */
	public void setPayTotal(Double payTotal) {
	 	this.payTotal = payTotal;
	}
	/**
	 * @return �����
	 */
	public Double getPayAmt() {
	 	return payAmt;
	}
	/**
	 * @���� �����
	 * @param payAmt
	 */
	public void setPayAmt(Double payAmt) {
	 	this.payAmt = payAmt;
	}
	/**
	 * @return ������Ϣ
	 */
	public Double getPayInte() {
	 	return payInte;
	}
	/**
	 * @���� ������Ϣ
	 * @param payInte
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
	 * @���� ��Ϣ
	 * @param payOver
	 */
	public void setPayOver(Double payOver) {
	 	this.payOver = payOver;
	}
	/**
	 * @return ����
	 */
	public Double getFeeTotal() {
	 	return feeTotal;
	}
	/**
	 * @���� ����
	 * @param feeTotal
	 */
	public void setFeeTotal(Double feeTotal) {
	 	this.feeTotal = feeTotal;
	}
	/**
	 * @return ΥԼ��
	 */
	public Double getFeeDam() {
	 	return feeDam;
	}
	/**
	 * @���� ΥԼ��
	 * @param feeDam
	 */
	public void setFeeDam(Double feeDam) {
	 	this.feeDam = feeDam;
	}
	/**
	 * @return ������[01δ����02������03����ɹ�04����ʧ��]
	 */
	public String getDealSts() {
	 	return dealSts;
	}
	/**
	 * @���� ������[01δ����02������03����ɹ�04����ʧ��]
	 * @param dealSts
	 */
	public void setDealSts(String dealSts) {
	 	this.dealSts = dealSts;
	}
	/**
	 * @return ��������
	 */
	public String getDealDesc() {
	 	return dealDesc;
	}
	/**
	 * @���� ��������
	 * @param dealDesc
	 */
	public void setDealDesc(String dealDesc) {
	 	this.dealDesc = dealDesc;
	}
	/**
	 * @return ������������
	 */
	public String getTxDate() {
	 	return txDate;
	}
	/**
	 * @���� ������������
	 * @param txDate
	 */
	public void setTxDate(String txDate) {
	 	this.txDate = txDate;
	}
	public String getDueSts() {
		return dueSts;
	}
	public void setDueSts(String dueSts) {
		this.dueSts = dueSts;
	}

}