package accounting.domain.auth;

import accounting.domain.sys.CMISDomain;

/**
* Title: AcAuth.java
* Description:
* @���� su
* @���� 2018-4-25
* @version��1.0
**/
public class AcAuth  extends CMISDomain  {
	private String authNo;                  //  ��Ȩ���
	private String loanNo;                  //  ��ݺ�
	private String cifNo;                   //  �ͻ���
	private String cifName;                 //  �ͻ�����
	private double txAmt;                   //  ���׽��
	private String curNo;                   //  ����
	private String typ;                     //  ҵ������
	private String txBrNo;                  //  ���׻���
	private String txDt;                    //  ��������
	private String finBrNo ;				//	�������
	private String txUsrId;                 //  ���׹�Ա��
	private String sts;                     //	��Ȩ״̬


	/**
	 * @return ����   ��Ȩ���
	 */
	public String getAuthNo() {
		return authNo;
	}
	/**
	 * @����   ��Ȩ���
	 * @param authNo
	 */
	public void setAuthNo(String authNo) {
		this.authNo=authNo;
	}
	/**
	 * @return ����   ��ݺ�
	 */
	public String getLoanNo() {
		return loanNo;
	}
	/**
	 * @����   ��ݺ�
	 * @param loanNo
	 */
	public void setLoanNo(String loanNo) {
		this.loanNo=loanNo;
	}
	/**
	 * @return ����   �ͻ���
	 */
	public String getCifNo() {
		return cifNo;
	}
	/**
	 * @����   �ͻ���
	 * @param cifNo
	 */
	public void setCifNo(String cifNo) {
		this.cifNo=cifNo;
	}
	/**
	 * @return ����   ���׽��
	 */
	public double getTxAmt() {
		return txAmt;
	}
	/**
	 * @����   ���׽��
	 * @param txAmt
	 */
	public void setTxAmt(double txAmt) {
		this.txAmt=txAmt;
	}
	/**
	 * @return ����   ����
	 */
	public String getCurNo() {
		return curNo;
	}
	/**
	 * @����   ����
	 * @param curNo
	 */
	public void setCurNo(String curNo) {
		this.curNo=curNo;
	}
	/**
	 * @return ����   ҵ������
	 */
	public String getTyp() {
		return typ;
	}
	/**
	 * @����   ҵ������
	 * @param typ
	 */
	public void setTyp(String typ) {
		this.typ=typ;
	}
	/**
	 * @return ����   ���׻���
	 */
	public String getTxBrNo() {
		return txBrNo;
	}
	/**
	 * @����   ���׻���
	 * @param txBrNo
	 */
	public void setTxBrNo(String txBrNo) {
		this.txBrNo=txBrNo;
	}
	/**
	 * @return ����   �������
	 */
	public String getFinBrNo() {
		return finBrNo;
	}
	/**
	 * @����   �������
	 * @param finBrNo
	 */
	public void setFinBrNo(String finBrNo) {
		this.finBrNo=finBrNo;
	}
	/**
	 * @return ����   ��������
	 */
	public String getTxDt() {
		return txDt;
	}
	/**
	 * @����   ��������
	 * @param txDt
	 */
	public void setTxDt(String txDt) {
		this.txDt=txDt;
	}
	/**
	 * @return ����   ���׹�Ա��
	 */
	public String getTxUsrId() {
		return txUsrId;
	}
	/**
	 * @����   ���׹�Ա��
	 * @param txUsrId
	 */
	public void setTxUsrId(String txUsrId) {
		this.txUsrId=txUsrId;
	}
	/**
	 * @return ���� 	��Ȩ״̬
	 */
	public String getSts() {
		return sts;
	}
	/**
	 * @���� 	��Ȩ״̬
	 * @param sts
	 */
	public void setSts(String sts) {
		this.sts=sts;
	}
	public String getCifName() {
		return cifName;
	}
	public void setCifName(String cifName) {
		this.cifName = cifName;
	}
	
}