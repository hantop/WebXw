package accounting.domain.sys;

public class AfferentDomain {
	
	
	private String txDt;		// ��ǰ����
	private String bizDt;		// ��������
	private String usrId;       // ��Ա��
	private String brNo;        // ���׻�����
	private String finBrNo;		// ���������
	
	/**
 	 * @return brNo ���׻�����
 	 */
	public String getBrNo() {
		return brNo;
	}
	/**
 	 * @����  ���׻�����
 	 * @param brNo
 	 */
	public void setBrNo(String brNo) {
		this.brNo = brNo;
	}
	/**
 	 * @return usrId  ��Ա��
 	 */
	public String getUsrId() {
		return usrId;
	}
	/**
 	 * @����   ��Ա��
 	 * @param tel
 	 */
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	/**
	 * ���������
	 * @return
	 */
	public String getFinBrNo() {
		return finBrNo;
	}
	/**
	 * ���������
	 * @param finBrNo
	 */
	public void setFinBrNo(String finBrNo) {
		this.finBrNo = finBrNo;
	}
	/**
	 * ��ǰ����
	 * @return
	 */
	public String getTxDt() {
		return txDt;
	}
	/**
	 * ��ǰ����
	 * @param txDt
	 */
	public void setTxDt(String txDt) {
		this.txDt = txDt;
	}
	/**
	 * ��������
	 * @return
	 */
	public String getBizDt() {
		return bizDt;
	}
	/**
	 * ��������
	 * @param bizDt
	 */
	public void setBizDt(String bizDt) {
		this.bizDt = bizDt;
	}
	
	
}
