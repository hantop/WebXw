package app.creditapp.ln.entity;
import app.base.BaseDomain;
/**
* Title: LnStage.java
* Description:
* @version��1.0
**/
public class LnStage extends BaseDomain {
	private String partSts;//���˱�־[01δ����02����ͨ��03����ʧ��]
	private String mstSts;//���ļ����ɱ�־[01δ����02������]
	private String sendSts;//����֧��ƽ̨״̬[01δ����02�ѷ���]
	private String paySts;//�ſ�״̬[01δ�ſ�02�ѷſ�]
	private String rsDesc;//���˵��
	private String txTime;//��������
	private String upTime;//��������
	private String appId;//����ID
	private String valSts;//У��״̬[01δУ��02ͨ��03δͨ��]
	private String dupSts;//�ظ�״̬[01δ���02���ظ�03�ظ�]
	private String chkSts;//ɸ��״̬[01δɸ��02ͨ��03δͨ��]
	private String evalSts;//�ͻ�����[1δ����A��B��C��]CΪ�ܾ�
	private String splitSts; //���״̬[01δ���02��ֳɹ�03���ʧ��]
	private String zdappSts;//�Զ�����״̬[01������02ͨ��03���]
	private String pactSts;//��ͬ���ɱ�־[01δ����02������]
	private String rgappSts;//�˹�����״̬[00������01������02ͨ��03���]
	private String dueSts;//������ɱ�־[01δ����02������]

	/**
	 * @return ���˱�־[01δ����02����ͨ��03����ʧ��]
	 */
	public String getPartSts() {
	 	return partSts;
	}
	/**
	 * @���� ���˱�־[01δ����02����ͨ��03����ʧ��]
	 * @param partSts
	 */
	public void setPartSts(String partSts) {
	 	this.partSts = partSts;
	}
	/**
	 * @return ���ļ����ɱ�־[01δ����02������]
	 */
	public String getMstSts() {
	 	return mstSts;
	}
	/**
	 * @���� ���ļ����ɱ�־[01δ����02������]
	 * @param mstSts
	 */
	public void setMstSts(String mstSts) {
	 	this.mstSts = mstSts;
	}
	/**
	 * @return ����֧��ƽ̨״̬[01δ����02�ѷ���]
	 */
	public String getSendSts() {
	 	return sendSts;
	}
	/**
	 * @���� ����֧��ƽ̨״̬[01δ����02�ѷ���]
	 * @param sendSts
	 */
	public void setSendSts(String sendSts) {
	 	this.sendSts = sendSts;
	}
	/**
	 * @return �ſ�״̬[01δ�ſ�02�ѷſ�]
	 */
	public String getPaySts() {
	 	return paySts;
	}
	/**
	 * @���� �ſ�״̬[01δ�ſ�02�ѷſ�]
	 * @param paySts
	 */
	public void setPaySts(String paySts) {
	 	this.paySts = paySts;
	}
	/**
	 * @return ���˵��
	 */
	public String getRsDesc() {
	 	return rsDesc;
	}
	/**
	 * @���� ���˵��
	 * @param rsDesc
	 */
	public void setRsDesc(String rsDesc) {
	 	this.rsDesc = rsDesc;
	}
	/**
	 * @return ��������
	 */
	public String getTxTime() {
	 	return txTime;
	}
	/**
	 * @���� ��������
	 * @param txTime
	 */
	public void setTxTime(String txTime) {
	 	this.txTime = txTime;
	}
	/**
	 * @return ��������
	 */
	public String getUpTime() {
	 	return upTime;
	}
	/**
	 * @���� ��������
	 * @param upTime
	 */
	public void setUpTime(String upTime) {
	 	this.upTime = upTime;
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
	 * @return У��״̬[01δУ��02ͨ��03δͨ��]
	 */
	public String getValSts() {
	 	return valSts;
	}
	/**
	 * @���� У��״̬[01δУ��02ͨ��03δͨ��]
	 * @param valSts
	 */
	public void setValSts(String valSts) {
	 	this.valSts = valSts;
	}
	/**
	 * @return �ظ�״̬[01δ���02���ظ�03�ظ�]
	 */
	public String getDupSts() {
	 	return dupSts;
	}
	/**
	 * @���� �ظ�״̬[01δ���02���ظ�03�ظ�]
	 * @param dupSts
	 */
	public void setDupSts(String dupSts) {
	 	this.dupSts = dupSts;
	}
	/**
	 * @return ɸ��״̬[01δɸ��02ͨ��03δͨ��]
	 */
	public String getChkSts() {
	 	return chkSts;
	}
	/**
	 * @���� ɸ��״̬[01δɸ��02ͨ��03δͨ��]
	 * @param chkSts
	 */
	public void setChkSts(String chkSts) {
	 	this.chkSts = chkSts;
	}
	/**
	 * @return �ͻ�����[1δ����A��B��C��]CΪ�ܾ�
	 */
	public String getEvalSts() {
	 	return evalSts;
	}
	/**
	 * @���� �ͻ�����[1δ����A��B��C��]CΪ�ܾ�
	 * @param evalSts
	 */
	public void setEvalSts(String evalSts) {
	 	this.evalSts = evalSts;
	}
	/**
	 * @return �Զ�����״̬[01������02ͨ��03���]
	 */
	public String getZdappSts() {
	 	return zdappSts;
	}
	/**
	 * @���� �Զ�����״̬[01������02ͨ��03���]
	 * @param zdappSts
	 */
	public void setZdappSts(String zdappSts) {
	 	this.zdappSts = zdappSts;
	}
	/**
	 * @return ��ͬ���ɱ�־[01δ����02������]
	 */
	public String getPactSts() {
	 	return pactSts;
	}
	/**
	 * @���� ��ͬ���ɱ�־[01δ����02������]
	 * @param pactSts
	 */
	public void setPactSts(String pactSts) {
	 	this.pactSts = pactSts;
	}
	/**
	 * @return �˹�����״̬[00������01������02ͨ��03���]
	 */
	public String getRgappSts() {
	 	return rgappSts;
	}
	/**
	 * @���� �˹�����״̬[00������01������02ͨ��03���]
	 * @param rgappSts
	 */
	public void setRgappSts(String rgappSts) {
	 	this.rgappSts = rgappSts;
	}
	/**
	 * @return ������ɱ�־[01δ����02������]
	 */
	public String getDueSts() {
	 	return dueSts;
	}
	/**
	 * @���� ������ɱ�־[01δ����02������]
	 * @param dueSts
	 */
	public void setDueSts(String dueSts) {
	 	this.dueSts = dueSts;
	}
	/**
	 *  ���״̬[01δ���02��ֳɹ�03���ʧ��]
	 */
	public String getSplitSts() {
		return splitSts;
	}
	/**
	 * ���״̬[01δ���02��ֳɹ�03���ʧ��]
	 * @param splitSts
	 */
	public void setSplitSts(String splitSts) {
		this.splitSts = splitSts;
	}
}