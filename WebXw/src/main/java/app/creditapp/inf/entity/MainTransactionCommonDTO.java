package app.creditapp.inf.entity;

/**
 * Title: AllocateReg.java Description:
 * 
 * @version��1.0
 **/
public class MainTransactionCommonDTO {

	private String id;// Ψһ��ʶ������¼
	private String projectID;// ��ĿID
	private String ddType;// ��������
	private String transDate;// ҵ������(��������)
	private String transReason;// ��������
	private String purpose;// ��;
	private String memo;// ժҪ
	// private String userID ;//������ID
	// private String submitUserID ;//�ύ��ID
	private String userCode;// ������CODE
	private String staffApp;// ������� (��Ӫ������0���ⲿ�˻� 1������Ա����2�����л�)

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id == null ? "" : id;
	}

	/**
	 * @return the projectID
	 */
	public String getProjectID() {
		return projectID;
	}

	/**
	 * @param projectID
	 *            the projectID to set
	 */
	public void setProjectID(String projectID) {
		this.projectID = projectID == null ? "" : projectID;
	}

	/**
	 * @return the ddType
	 */
	public String getDdType() {
		return ddType;
	}

	/**
	 * @param ddType
	 *            the ddType to set
	 */
	public void setDdType(String ddType) {
		this.ddType = ddType == null ? "" : ddType;
	}

	/**
	 * @return the transDate
	 */
	public String getTransDate() {
		return transDate;
	}

	/**
	 * @param transDate
	 *            the transDate to set
	 */
	public void setTransDate(String transDate) {
		this.transDate = transDate == null ? "" : transDate;
	}

	/**
	 * @return the transReason
	 */
	public String getTransReason() {
		return transReason;
	}

	/**
	 * @param transReason
	 *            the transReason to set
	 */
	public void setTransReason(String transReason) {
		this.transReason = transReason == null ? "" : transReason;
	}

	/**
	 * @return the purpose
	 */
	public String getPurpose() {
		return purpose;
	}

	/**
	 * @param purpose
	 *            the purpose to set
	 */
	public void setPurpose(String purpose) {
		this.purpose = purpose == null ? "" : purpose;
	}

	/**
	 * @return the memo
	 */
	public String getMemo() {
		return memo;
	}

	/**
	 * @param memo
	 *            the memo to set
	 */
	public void setMemo(String memo) {
		this.memo = memo == null ? "" : memo;
	}

	/**
	 * @return the staffapp
	 */
	public String getStaffApp() {
		return staffApp;
	}

	/**
	 * @param staffapp
	 *            the staffapp to set
	 */
	public void setStaffApp(String staffApp) {
		this.staffApp = staffApp == null ? "" : staffApp;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode == null ? "" : userCode;
	}

}