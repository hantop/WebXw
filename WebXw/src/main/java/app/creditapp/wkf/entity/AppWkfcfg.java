package app.creditapp.wkf.entity;
import app.base.BaseDomain;
/**
* Title: AppWkfcfg.java
* Description:
* @version��1.0
**/
public class AppWkfcfg extends BaseDomain {
	private String id;//
	private String brNo;//������
	private String appType;//�������� 1���� 2���� 3���� 4�弶 5������
//	private String wkfNo;//���̱��
	//private String wkfName;//��������
	private String prdtNo;//��Ʒ��
	private String brName;//��������
	private String prdtName;
//	private String wkfDisc;
	private String txBrno;//�Ǽǻ���
	private String txDate;//�Ǽ�����
	private String txUserId;//�Ǽ���
	private String txModifyDate;//�޸�����
	private String txBrnoName;
	
	/**workflow property**/
	private String processKey;//���̱�ʾ
	private String processId;//����dbid
	private String processDesc;//��������
	private String remark;//����˵��
	private String processDefId;//���̶�����
	private String processSts;//����״̬0-����1-δ����
	private String beiZhu;//��ע
	private String checkManager;//���˹���Ա
	private String managerPass;//��������
	
	private String bs_no;//��ѯ����-�������
	
	
	
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getPrdtName() {
		return prdtName;
	}
	public String getTxBrnoName() {
		return txBrnoName;
	}
	public void setTxBrnoName(String txBrnoName) {
		this.txBrnoName = txBrnoName;
	}
	public void setPrdtName(String prdtName) {
		this.prdtName = prdtName;
	}
	public String getProcessId() {
		return processId;
	}
	public void setProcessId(String processId) {
		this.processId = processId;
	}
	public String getBrName() {
		return brName;
	}
	public void setBrName(String brName) {
		this.brName = brName;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPrdtNo() {
		return prdtNo;
	}
	public void setPrdtNo(String prdtNo) {
		this.prdtNo = prdtNo;
	}
	/**
	 * @return ������
	 */
	 public String getBrNo() {
	 	return brNo;
	 }
	 /**
	 * @���� ������
	 * @param brNo
	 */
	 public void setBrNo(String brNo) {
	 	this.brNo = brNo;
	 }
	/**
	 * @return �������� 1���� 2���� 3���� 4�弶 5������
	 */
	 public String getAppType() {
	 	return appType;
	 }
	 /**
	 * @���� �������� 1���� 2���� 3���� 4�弶 5������
	 * @param appType
	 */
	 public void setAppType(String appType) {
	 	this.appType = appType;
	 }
	/**
	 * @return ���̱��
	 */
	 public String getProcessKey() {
	 	return processKey;
	 }
	 /**
	 * @���� ���̱��
	 * @param wkfNo
	 */
	 public void setProcessKey(String processKey) {
	 	this.processKey = processKey;
	 }
	/**
	 * @return ��������
	 */
	 public String getProcessDesc() {
	 	return processDesc;
	 }
	 /**
	 * @���� ��������
	 * @param wkfName
	 */
	 public void setProcessDesc(String processDesc) {
	 	this.processDesc = processDesc;
	 }
	public String getTxBrno() {
		return txBrno;
	}
	public void setTxBrno(String txBrno) {
		this.txBrno = txBrno;
	}
	public String getTxDate() {
		return txDate;
	}
	public void setTxDate(String txDate) {
		this.txDate = txDate;
	}
	public String getProcessDefId() {
		return processDefId;
	}
	public void setProcessDefId(String processDefId) {
		this.processDefId = processDefId;
	}
	public String getProcessSts() {
		return processSts;
	}
	public void setProcessSts(String processSts) {
		this.processSts = processSts;
	}
	public String getTxUserId() {
		return txUserId;
	}
	public void setTxUserId(String txUserId) {
		this.txUserId = txUserId;
	}
	public String getTxModifyDate() {
		return txModifyDate;
	}
	public void setTxModifyDate(String txModifyDate) {
		this.txModifyDate = txModifyDate;
	}
	public String getBeiZhu() {
		return beiZhu;
	}
	public void setBeiZhu(String beiZhu) {
		this.beiZhu = beiZhu;
	}
	public String getCheckManager() {
		return checkManager;
	}
	public void setCheckManager(String checkManager) {
		this.checkManager = checkManager;
	}
	public String getManagerPass() {
		return managerPass;
	}
	public void setManagerPass(String managerPass) {
		this.managerPass = managerPass;
	}
	public String getBs_no() {
		return bs_no;
	}
	public void setBs_no(String bsNo) {
		bs_no = bsNo;
	}
}