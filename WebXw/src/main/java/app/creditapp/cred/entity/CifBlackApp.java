package app.creditapp.cred.entity;
import app.base.BaseDomain;
/**
* Title: CifBlackApp.java
* Description:
* @version��1.0
**/
public class CifBlackApp extends BaseDomain {
	private String blkId;//������ID
	private String appId;//����ID
	private String cifNo;//�ͻ���
	private String cifName;//�ͻ�����
	private String idType;//֤������
	private String idNo;//֤����
	private String blkLevel;//�������ȼ�[01�ܾ���02Ԥ����03��ʾ��]
	private String appType;//��������[01����02����]
	private String appReason;//����ԭ��
	private String appSts;//����״̬[00δ�ύ04������01ͬ��02���]
	private String txDate;//�Ǽ�����
	private String opNo;//����Ա
	private String opName;//����Ա

	/**
	 * @return ������ID
	 */
	public String getBlkId() {
	 	return blkId;
	}
	/**
	 * @���� ������ID
	 * @param blkId
	 */
	public void setBlkId(String blkId) {
	 	this.blkId = blkId;
	}
	/**
	 * @return ����ID
	 */
	public String getAppId() {
	 	return appId;
	}
	/**
	 * @���� ����ID
	 * @param appId
	 */
	public void setAppId(String appId) {
	 	this.appId = appId;
	}
	/**
	 * @return �ͻ���
	 */
	public String getCifNo() {
	 	return cifNo;
	}
	/**
	 * @���� �ͻ���
	 * @param cifNo
	 */
	public void setCifNo(String cifNo) {
	 	this.cifNo = cifNo;
	}
	/**
	 * @return �ͻ�����
	 */
	public String getCifName() {
	 	return cifName;
	}
	/**
	 * @���� �ͻ�����
	 * @param cifName
	 */
	public void setCifName(String cifName) {
	 	this.cifName = cifName;
	}
	/**
	 * @return ֤������
	 */
	public String getIdType() {
	 	return idType;
	}
	/**
	 * @���� ֤������
	 * @param idType
	 */
	public void setIdType(String idType) {
	 	this.idType = idType;
	}
	/**
	 * @return ֤����
	 */
	public String getIdNo() {
	 	return idNo;
	}
	/**
	 * @���� ֤����
	 * @param idNo
	 */
	public void setIdNo(String idNo) {
	 	this.idNo = idNo;
	}
	/**
	 * @return �������ȼ�[01�ܾ���02Ԥ����03��ʾ��]
	 */
	public String getBlkLevel() {
	 	return blkLevel;
	}
	/**
	 * @���� �������ȼ�[01�ܾ���02Ԥ����03��ʾ��]
	 * @param blkLevel
	 */
	public void setBlkLevel(String blkLevel) {
	 	this.blkLevel = blkLevel;
	}
	/**
	 * @return ��������[01����02����]
	 */
	public String getAppType() {
	 	return appType;
	}
	/**
	 * @���� ��������[01����02����]
	 * @param appType
	 */
	public void setAppType(String appType) {
	 	this.appType = appType;
	}
	/**
	 * @return ����ԭ��
	 */
	public String getAppReason() {
	 	return appReason;
	}
	/**
	 * @���� ����ԭ��
	 * @param appReason
	 */
	public void setAppReason(String appReason) {
	 	this.appReason = appReason;
	}
	/**
	 * @return ����״̬[00δ�ύ04������01ͬ��02���]
	 */
	public String getAppSts() {
	 	return appSts;
	}
	/**
	 * @���� ����״̬[00δ�ύ04������01ͬ��02���]
	 * @param appSts
	 */
	public void setAppSts(String appSts) {
	 	this.appSts = appSts;
	}
	/**
	 * @return �Ǽ�����
	 */
	public String getTxDate() {
	 	return txDate;
	}
	/**
	 * @���� �Ǽ�����
	 * @param txDate
	 */
	public void setTxDate(String txDate) {
	 	this.txDate = txDate;
	}
	/**
	 * @return ����Ա
	 */
	public String getOpNo() {
	 	return opNo;
	}
	/**
	 * @���� ����Ա
	 * @param opNo
	 */
	public void setOpNo(String opNo) {
	 	this.opNo = opNo;
	}
	public String getOpName() {
		return opName;
	}
	public void setOpName(String opName) {
		this.opName = opName;
	}
}