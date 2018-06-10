package app.creditapp.inf.entity;

import app.base.BaseDomain;

/**
 * Title: AllocateRegWsIn.java Description:
 * 
 * @version��1.0
 **/
public class AllocateRegWsIn extends BaseDomain {
	// ����Ϣ����
	private String id;// Ψһ��ʶ������¼(Ψһ��ʶ����Χϵͳͨ����ID�ɻ�����ɵĲ���̨������Ϣ)
	private String businessflag;// ҵ���ʾ1:�˻����2:���и���Ӫ��3:�˻��տ4:��Ӫ���棬5:���и����ϻ���6:���˻�����
	private String  autoSyncFlag ;//�Զ�ͬ�����������ʾ
	private String projectid;// ��ĿID
	private String ddtype;// ��������(������������������Ϊ��Ӫ��������� 1:��Ӫҵ˰������2:���)
	private String transdate;// ҵ������(��������) yyyy-MM-dd
	private String transreason;// ��������
	private String purpose;// ��;
	private String memo;// ժҪ
	// private String userid;//������ID
	// private String submituserid;//�ύ��ID (��������Զ��ύ����ʱ������)
	private String userCode;// ������CODE
	private String staffapp;// ������� (��Ӫ������0���ⲿ�˻� 1������Ա����2�����л�)
	// ��ϸ��Ϣ����
	private String amount;// ���׽��(2λС��)
	private String bktranstypecode;// ����Ľ������ͱ���(����ʱ����)
	private String sktranstypecode;// �տ�Ľ������ͱ��� (����������и���Ӫ�����տ��ʱ����)
	private String feetypecode;// �������ͱ���(��������,�����ཻ������ʱ�����)
	private String taxtypecode;// ˰Ŀ���ͱ���(��������,˰Ŀ�ཻ��ʱ������ )
	private String customid;// �տ���ID
	private String accountid;// �ʽ����÷��˺�ID/���ID(�����������ϸ�������ʹ����˻��ཻ������ʱ�����)
	// private String opbankacntid ;//�Է�����ID
	private String opbankacntno;// �Է������˺�
	private String opbankname;// �Է������˺ſ�����
	private String opbankacntname;// �Է������˺Ż���
	private String opbankprovince;// ����������ʡ
	private String opbankcity;// ������������
	private String repaytypeid;// ���ʽ
								// ����������ڲ��˻��е�ҵ�����Ϊ����ģ�����ϸ����������Ϊ����ģ�01�����ջأ�02�ʲ����飬03�ʲ����룬04���ʵ�ծ��05����������06���������07�����Ի��08ծת�ɡ�09ת����
	private String appusercode;// �ڲ���Ա(��������:��Ӫ���沦�����Ϊ����ʱ�����)

	// ��������Ϊ������������
	private String personnel;// ��Ա(����)
	private String project;// ��Ŀ(����)
	private String customer;// �ͻ�(����)
	private String cashflow;// �ֽ�����
	private String virtualaccount;// �����˻�
	private String contractnumber;// ���ú�ͬ��
	private String stockcode;// ��Ʊ����
	private String fundaccount;// �ʽ��˺�
	private String salesdepartment;// Ӫҵ��
	private String checknumber;// ֧Ʊ��
	private String businesstype;// ҵ������
	private String cashflowstatement;// �ֽ���������
	private String taxcategory;// ˰��
	private String interestrate;// ����
	private String industry;// ��ҵ
	private String stock;// �ɱ�
	private String assetname;// �ʲ�����
	private String productname;// ��Ʒ����
	private String clientorbeneficiary;// ί����/������
	private String shareholder;// �ɶ�
	private String entrustcontractnumber;// ί�к�ͬ��
	private String tradingpurpose;// ����Ŀ��
	private String contractvariety;// ��ԼƷ��
	private String dateofreceipt;// �ո�������
	private String interestdate;// ��Ϣ��
	private String duedate;// ������
	private String inorout;// ϵͳ����
	private String billnumber;// Ʊ�ݱ��
	// ����
	private String acctId;
	private String wssts;
	private String txtime;
	private String sdtime;
	private String transid;
	private String workflowstate;
	private String remarks;

	/**
	 * @return Ψһ��ʶ������¼(Ψһ��ʶ����Χϵͳͨ����ID�ɻ�����ɵĲ���̨������Ϣ)
	 */
	public String getId() {
		return id;
	}

	/**
	 * @���� Ψһ��ʶ������¼(Ψһ��ʶ����Χϵͳͨ����ID�ɻ�����ɵĲ���̨������Ϣ)
	 * @param id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return ҵ���ʾ1:�˻����2:���и���Ӫ��3:�˻��տ4:��Ӫ���棬5:���и����ϻ���6:���˻�����
	 */
	public String getBusinessflag() {
		return businessflag;
	}

	/**
	 * @���� ҵ���ʾ1:�˻����2:���и���Ӫ��3:�˻��տ4:��Ӫ���棬5:���и����ϻ���6:���˻�����
	 * @param businessflag
	 */
	public void setBusinessflag(String businessflag) {
		this.businessflag = businessflag;
	}

	/**
	 * @return ��ĿID
	 */
	public String getProjectid() {
		return projectid;
	}

	/**
	 * @���� ��ĿID
	 * @param projectid
	 */
	public void setProjectid(String projectid) {
		this.projectid = projectid;
	}

	/**
	 * @return ��������(������������������Ϊ��Ӫ��������� 1:��Ӫҵ˰������2:���)
	 */
	public String getDdtype() {
		return ddtype;
	}

	/**
	 * @���� ��������(������������������Ϊ��Ӫ��������� 1:��Ӫҵ˰������2:���)
	 * @param ddtype
	 */
	public void setDdtype(String ddtype) {
		this.ddtype = ddtype;
	}

	/**
	 * @return ҵ������(��������) yyyy-MM-dd
	 */
	public String getTransdate() {
		return transdate;
	}

	/**
	 * @���� ҵ������(��������) yyyy-MM-dd
	 * @param transdate
	 */
	public void setTransdate(String transdate) {
		this.transdate = transdate;
	}

	/**
	 * @return ��������
	 */
	public String getTransreason() {
		return transreason;
	}

	/**
	 * @���� ��������
	 * @param transreason
	 */
	public void setTransreason(String transreason) {
		this.transreason = transreason;
	}

	/**
	 * @return ��;
	 */
	public String getPurpose() {
		return purpose;
	}

	/**
	 * @���� ��;
	 * @param purpose
	 */
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	/**
	 * @return ժҪ
	 */
	public String getMemo() {
		return memo;
	}

	/**
	 * @���� ժҪ
	 * @param memo
	 */
	public void setMemo(String memo) {
		this.memo = memo;
	}

	/**
	 * @return ���׽��(2λС��)
	 */
	public String getAmount() {
		if(amount.indexOf(".")<0){
			amount=amount+".00";
		}else{
			amount =amount+"0000";
			amount = amount.substring(0, amount.indexOf(".")+3);
		}
		return amount;
	}

	/**
	 * @���� ���׽��(2λС��)
	 * @param amount
	 */
	public void setAmount(String amount) {
		this.amount = amount;
	}

	/**
	 * @return ����Ľ������ͱ���(����ʱ����)
	 */
	public String getBktranstypecode() {
		return bktranstypecode;
	}

	/**
	 * @���� ����Ľ������ͱ���(����ʱ����)
	 * @param bktranstypecode
	 */
	public void setBktranstypecode(String bktranstypecode) {
		this.bktranstypecode = bktranstypecode;
	}

	/**
	 * @return �տ�Ľ������ͱ��� (����������и���Ӫ�����տ��ʱ����)
	 */
	public String getSktranstypecode() {
		return sktranstypecode;
	}

	/**
	 * @���� �տ�Ľ������ͱ��� (����������и���Ӫ�����տ��ʱ����)
	 * @param sktranstypecode
	 */
	public void setSktranstypecode(String sktranstypecode) {
		this.sktranstypecode = sktranstypecode;
	}

	/**
	 * @return �������ͱ���(��������,�����ཻ������ʱ�����)
	 */
	public String getFeetypecode() {
		return feetypecode;
	}

	/**
	 * @���� �������ͱ���(��������,�����ཻ������ʱ�����)
	 * @param feetypecode
	 */
	public void setFeetypecode(String feetypecode) {
		this.feetypecode = feetypecode;
	}

	/**
	 * @return ˰Ŀ���ͱ���(��������,˰Ŀ�ཻ��ʱ������ )
	 */
	public String getTaxtypecode() {
		return taxtypecode;
	}

	/**
	 * @���� ˰Ŀ���ͱ���(��������,˰Ŀ�ཻ��ʱ������ )
	 * @param taxtypecode
	 */
	public void setTaxtypecode(String taxtypecode) {
		this.taxtypecode = taxtypecode;
	}

	/**
	 * @return �տ���ID
	 */
	public String getCustomid() {
		return customid;
	}

	/**
	 * @���� �տ���ID
	 * @param customid
	 */
	public void setCustomid(String customid) {
		this.customid = customid;
	}

	/**
	 * @return �ʽ����÷��˺�ID/���ID(�����������ϸ�������ʹ����˻��ཻ������ʱ�����)
	 */
	public String getAccountid() {
		return accountid;
	}

	/**
	 * @���� �ʽ����÷��˺�ID/���ID(�����������ϸ�������ʹ����˻��ཻ������ʱ�����)
	 * @param accountid
	 */
	public void setAccountid(String accountid) {
		this.accountid = accountid;
	}

	/**
	 * @return �Է������˺�
	 */
	public String getOpbankacntno() {
		return opbankacntno;
	}

	/**
	 * @���� �Է������˺�
	 * @param opbankacntno
	 */
	public void setOpbankacntno(String opbankacntno) {
		this.opbankacntno = opbankacntno;
	}

	/**
	 * @return �Է������˺ſ�����
	 */
	public String getOpbankname() {
		return opbankname;
	}

	/**
	 * @���� �Է������˺ſ�����
	 * @param opbankname
	 */
	public void setOpbankname(String opbankname) {
		this.opbankname = opbankname;
	}

	/**
	 * @return �Է������˺Ż���
	 */
	public String getOpbankacntname() {
		return opbankacntname;
	}

	/**
	 * @���� �Է������˺Ż���
	 * @param opbankacntname
	 */
	public void setOpbankacntname(String opbankacntname) {
		this.opbankacntname = opbankacntname;
	}

	/**
	 * @return ����������ʡ
	 */
	public String getOpbankprovince() {
		return opbankprovince;
	}

	/**
	 * @���� ����������ʡ
	 * @param opbankprovince
	 */
	public void setOpbankprovince(String opbankprovince) {
		this.opbankprovince = opbankprovince;
	}

	/**
	 * @return ������������
	 */
	public String getOpbankcity() {
		return opbankcity;
	}

	/**
	 * @���� ������������
	 * @param opbankcity
	 */
	public void setOpbankcity(String opbankcity) {
		this.opbankcity = opbankcity;
	}

	/**
	 * @return ��Ա(����)
	 */
	public String getPersonnel() {
		return personnel;
	}

	/**
	 * @���� ��Ա(����)
	 * @param personnel
	 */
	public void setPersonnel(String personnel) {
		this.personnel = personnel;
	}

	/**
	 * @return ��Ŀ(����)
	 */
	public String getProject() {
		return project;
	}

	/**
	 * @���� ��Ŀ(����)
	 * @param project
	 */
	public void setProject(String project) {
		this.project = project;
	}

	/**
	 * @return �ͻ�(����)
	 */
	public String getCustomer() {
		return customer;
	}

	/**
	 * @���� �ͻ�(����)
	 * @param customer
	 */
	public void setCustomer(String customer) {
		this.customer = customer;
	}

	/**
	 * @return �ֽ�����
	 */
	public String getCashflow() {
		return cashflow;
	}

	/**
	 * @���� �ֽ�����
	 * @param cashflow
	 */
	public void setCashflow(String cashflow) {
		this.cashflow = cashflow;
	}

	/**
	 * @return �����˻�
	 */
	public String getVirtualaccount() {
		return virtualaccount;
	}

	/**
	 * @���� �����˻�
	 * @param virtualaccount
	 */
	public void setVirtualaccount(String virtualaccount) {
		this.virtualaccount = virtualaccount;
	}

	/**
	 * @return ���ú�ͬ��
	 */
	public String getContractnumber() {
		return contractnumber;
	}

	/**
	 * @���� ���ú�ͬ��
	 * @param contractnumber
	 */
	public void setContractnumber(String contractnumber) {
		this.contractnumber = contractnumber;
	}

	/**
	 * @return ��Ʊ����
	 */
	public String getStockcode() {
		return stockcode;
	}

	/**
	 * @���� ��Ʊ����
	 * @param stockcode
	 */
	public void setStockcode(String stockcode) {
		this.stockcode = stockcode;
	}

	/**
	 * @return �ʽ��˺�
	 */
	public String getFundaccount() {
		return fundaccount;
	}

	/**
	 * @���� �ʽ��˺�
	 * @param fundaccount
	 */
	public void setFundaccount(String fundaccount) {
		this.fundaccount = fundaccount;
	}

	/**
	 * @return Ӫҵ��
	 */
	public String getSalesdepartment() {
		return salesdepartment;
	}

	/**
	 * @���� Ӫҵ��
	 * @param salesdepartment
	 */
	public void setSalesdepartment(String salesdepartment) {
		this.salesdepartment = salesdepartment;
	}

	/**
	 * @return ֧Ʊ��
	 */
	public String getChecknumber() {
		return checknumber;
	}

	/**
	 * @���� ֧Ʊ��
	 * @param checknumber
	 */
	public void setChecknumber(String checknumber) {
		this.checknumber = checknumber;
	}

	/**
	 * @return ҵ������
	 */
	public String getBusinesstype() {
		return businesstype;
	}

	/**
	 * @���� ҵ������
	 * @param businesstype
	 */
	public void setBusinesstype(String businesstype) {
		this.businesstype = businesstype;
	}

	/**
	 * @return �ֽ���������
	 */
	public String getCashflowstatement() {
		return cashflowstatement;
	}

	/**
	 * @���� �ֽ���������
	 * @param cashflowstatement
	 */
	public void setCashflowstatement(String cashflowstatement) {
		this.cashflowstatement = cashflowstatement;
	}

	/**
	 * @return ˰��
	 */
	public String getTaxcategory() {
		return taxcategory;
	}

	/**
	 * @���� ˰��
	 * @param taxcategory
	 */
	public void setTaxcategory(String taxcategory) {
		this.taxcategory = taxcategory;
	}

	/**
	 * @return ����
	 */
	public String getInterestrate() {
		return interestrate;
	}

	/**
	 * @���� ����
	 * @param interestrate
	 */
	public void setInterestrate(String interestrate) {
		this.interestrate = interestrate;
	}

	/**
	 * @return ��ҵ
	 */
	public String getIndustry() {
		return industry;
	}

	/**
	 * @���� ��ҵ
	 * @param industry
	 */
	public void setIndustry(String industry) {
		this.industry = industry;
	}

	/**
	 * @return �ɱ�
	 */
	public String getStock() {
		return stock;
	}

	/**
	 * @���� �ɱ�
	 * @param stock
	 */
	public void setStock(String stock) {
		this.stock = stock;
	}

	/**
	 * @return �ʲ�����
	 */
	public String getAssetname() {
		return assetname;
	}

	/**
	 * @���� �ʲ�����
	 * @param assetname
	 */
	public void setAssetname(String assetname) {
		this.assetname = assetname;
	}

	/**
	 * @return ��Ʒ����
	 */
	public String getProductname() {
		return productname;
	}

	/**
	 * @���� ��Ʒ����
	 * @param productname
	 */
	public void setProductname(String productname) {
		this.productname = productname;
	}

	/**
	 * @return ί����/������
	 */
	public String getClientorbeneficiary() {
		return clientorbeneficiary;
	}

	/**
	 * @���� ί����/������
	 * @param clientorbeneficiary
	 */
	public void setClientorbeneficiary(String clientorbeneficiary) {
		this.clientorbeneficiary = clientorbeneficiary;
	}

	/**
	 * @return �ɶ�
	 */
	public String getShareholder() {
		return shareholder;
	}

	/**
	 * @���� �ɶ�
	 * @param shareholder
	 */
	public void setShareholder(String shareholder) {
		this.shareholder = shareholder;
	}

	/**
	 * @return ί�к�ͬ��
	 */
	public String getEntrustcontractnumber() {
		return entrustcontractnumber;
	}

	/**
	 * @���� ί�к�ͬ��
	 * @param entrustcontractnumber
	 */
	public void setEntrustcontractnumber(String entrustcontractnumber) {
		this.entrustcontractnumber = entrustcontractnumber;
	}

	/**
	 * @return ����Ŀ��
	 */
	public String getTradingpurpose() {
		return tradingpurpose;
	}

	/**
	 * @���� ����Ŀ��
	 * @param tradingpurpose
	 */
	public void setTradingpurpose(String tradingpurpose) {
		this.tradingpurpose = tradingpurpose;
	}

	/**
	 * @return ��ԼƷ��
	 */
	public String getContractvariety() {
		return contractvariety;
	}

	/**
	 * @���� ��ԼƷ��
	 * @param contractvariety
	 */
	public void setContractvariety(String contractvariety) {
		this.contractvariety = contractvariety;
	}

	/**
	 * @return �ո�������
	 */
	public String getDateofreceipt() {
		return dateofreceipt;
	}

	/**
	 * @���� �ո�������
	 * @param dateofreceipt
	 */
	public void setDateofreceipt(String dateofreceipt) {
		this.dateofreceipt = dateofreceipt;
	}

	/**
	 * @return ��Ϣ��
	 */
	public String getInterestdate() {
		return interestdate;
	}

	/**
	 * @���� ��Ϣ��
	 * @param interestdate
	 */
	public void setInterestdate(String interestdate) {
		this.interestdate = interestdate;
	}

	/**
	 * @return ������
	 */
	public String getDuedate() {
		return duedate;
	}

	/**
	 * @���� ������
	 * @param duedate
	 */
	public void setDuedate(String duedate) {
		this.duedate = duedate;
	}

	/**
	 * @return ϵͳ����
	 */
	public String getInorout() {
		return inorout;
	}

	/**
	 * @���� ϵͳ����
	 * @param inorout
	 */
	public void setInorout(String inorout) {
		this.inorout = inorout;
	}

	/**
	 * @return Ʊ�ݱ��
	 */
	public String getBillnumber() {
		return billnumber;
	}

	/**
	 * @���� Ʊ�ݱ��
	 * @param billnumber
	 */
	public void setBillnumber(String billnumber) {
		this.billnumber = billnumber;
	}

	/**
	 * @return the acctId
	 */
	public String getAcctId() {
		return acctId;
	}

	/**
	 * @param acctId
	 *            the acctId to set
	 */
	public void setAcctId(String acctId) {
		this.acctId = acctId;
	}


	/**
	 * @return the staffapp
	 */
	public String getStaffapp() {
		return staffapp;
	}

	/**
	 * @param staffapp
	 *            the staffapp to set
	 */
	public void setStaffapp(String staffapp) {
		this.staffapp = staffapp;
	}

	/**
	 * @return the repaytypeid
	 */
	public String getRepaytypeid() {
		return repaytypeid;
	}

	/**
	 * @param repaytypeid
	 *            the repaytypeid to set
	 */
	public void setRepaytypeid(String repaytypeid) {
		this.repaytypeid = repaytypeid;
	}

	/**
	 * @return the appUserCode
	 */
	public String getAppusercode() {
		return appusercode;
	}

	/**
	 * @param appUserCode
	 *            the appUserCode to set
	 */
	public void setAppusercode(String appusercode) {
		this.appusercode = appusercode;
	}

	public String getWssts() {
		return wssts;
	}

	public void setWssts(String wssts) {
		this.wssts = wssts;
	}

	public String getTxtime() {
		return txtime;
	}

	public void setTxtime(String txtime) {
		this.txtime = txtime;
	}

	public String getSdtime() {
		return sdtime;
	}

	public void setSdtime(String sdtime) {
		this.sdtime = sdtime;
	}

	public String getTransid() {
		return transid;
	}

	public void setTransid(String transid) {
		this.transid = transid;
	}

	public String getWorkflowstate() {
		return workflowstate;
	}

	public void setWorkflowstate(String workflowstate) {
		this.workflowstate = workflowstate;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getAutoSyncFlag() {
		return autoSyncFlag;
	}

	public void setAutoSyncFlag(String autoSyncFlag) {
		this.autoSyncFlag = autoSyncFlag;
	}
}