package app.creditapp.corp.entity;
import app.base.BaseDomain;
/**
* Title: CorpFin.java
* Description:
* @version��1.0
**/
public class CorpFin extends BaseDomain {
	private Double saleIncome;//��������
	private Double syzqyVal;//������Ȩ��
	private Double loanAmt;//���
	private Double debtTot;//�ܸ�ծ
	private Double assstTot;//���ʲ�
	private Double floDebt;//������ծ
	private Double floAsset;//�����ʲ�
	private Double cashSave;//�ֽ�����д��
	private String finId;//������ϢID
	private String brName;//������������
	private String brNo;//�����������
	private String upOpno;//�޸���Ա
	private String upOpname;//�޸���Ա����
	private String upDate;//�޸�����
	private String txDate;//�Ǽ�����
	private String opNo;//����Ա
	private String opName;//����Ա����
	private String deptNo;//�Ǽǲ���
	private String filler;//��ע
	private String endDate;//���񱨱��ֹ����
	private Double netCash;//��Ӫ��������ֽ���
	private Double gaAddRate;//�������󸴺�������(%)
	private Double siAddRate;//�������븴��������(%)
	private Double assDebtRate;//�ʲ���ծ��(%)
	private Double netAsset;//���ʲ���ģ(��Ԫ)
	private Double netGain;//������
	private Double incomeTax;//����˰
	private Double payInt;//��Ϣ֧��
	private Double saleCost;//���۳ɱ�

	/**
	 * @return ��������
	 */
	public Double getSaleIncome() {
	 	return saleIncome;
	}
	/**
	 * @���� ��������
	 * @param sale income
	 */
	public void setSalIncome(Double saleIncome) {
	 	this.saleIncome = saleIncome;
	}
	/**
	 * @return ������Ȩ��
	 */
	public Double getSyzqyVal() {
	 	return syzqyVal;
	}
	/**
	 * @���� ������Ȩ��
	 * @param syzqyVal
	 */
	public void setSyzqyVal(Double syzqyVal) {
	 	this.syzqyVal = syzqyVal;
	}
	/**
	 * @return ���
	 */
	public Double getLoanAmt() {
	 	return loanAmt;
	}
	/**
	 * @���� ���
	 * @param loanAmt
	 */
	public void setLoanAmt(Double loanAmt) {
	 	this.loanAmt = loanAmt;
	}
	/**
	 * @return �ܸ�ծ
	 */
	public Double getDebtTot() {
	 	return debtTot;
	}
	/**
	 * @���� �ܸ�ծ
	 * @param debtTot
	 */
	public void setDebtTot(Double debtTot) {
	 	this.debtTot = debtTot;
	}
	/**
	 * @return ���ʲ�
	 */
	public Double getAssstTot() {
	 	return assstTot;
	}
	/**
	 * @���� ���ʲ�
	 * @param assstTot
	 */
	public void setAssstTot(Double assstTot) {
	 	this.assstTot = assstTot;
	}
	/**
	 * @return ������ծ
	 */
	public Double getFloDebt() {
	 	return floDebt;
	}
	/**
	 * @���� ������ծ
	 * @param floDebt
	 */
	public void setFloDebt(Double floDebt) {
	 	this.floDebt = floDebt;
	}
	/**
	 * @return �����ʲ�
	 */
	public Double getFloAsset() {
	 	return floAsset;
	}
	/**
	 * @���� �����ʲ�
	 * @param floAsset
	 */
	public void setFloAsset(Double floAsset) {
	 	this.floAsset = floAsset;
	}
	/**
	 * @return �ֽ�����д��
	 */
	public Double getCashSave() {
	 	return cashSave;
	}
	/**
	 * @���� �ֽ�����д��
	 * @param cashSave
	 */
	public void setCashSave(Double cashSave) {
	 	this.cashSave = cashSave;
	}
	/**
	 * @return ������ϢID
	 */
	public String getFinId() {
	 	return finId;
	}
	/**
	 * @���� ������ϢID
	 * @param finId
	 */
	public void setFinId(String finId) {
	 	this.finId = finId;
	}
	/**
	 * @return ������������
	 */
	public String getBrName() {
	 	return brName;
	}
	/**
	 * @���� ������������
	 * @param brName
	 */
	public void setBrName(String brName) {
	 	this.brName = brName;
	}
	/**
	 * @return �����������
	 */
	public String getBrNo() {
	 	return brNo;
	}
	/**
	 * @���� �����������
	 * @param brNo
	 */
	public void setBrNo(String brNo) {
	 	this.brNo = brNo;
	}
	/**
	 * @return �޸���Ա
	 */
	public String getUpOpno() {
	 	return upOpno;
	}
	/**
	 * @���� �޸���Ա
	 * @param upOpno
	 */
	public void setUpOpno(String upOpno) {
	 	this.upOpno = upOpno;
	}
	/**
	 * @return �޸�����
	 */
	public String getUpDate() {
	 	return upDate;
	}
	/**
	 * @���� �޸�����
	 * @param upDate
	 */
	public void setUpDate(String upDate) {
	 	this.upDate = upDate;
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
	/**
	 * @return �Ǽǲ���
	 */
	public String getDeptNo() {
	 	return deptNo;
	}
	/**
	 * @���� �Ǽǲ���
	 * @param deptNo
	 */
	public void setDeptNo(String deptNo) {
	 	this.deptNo = deptNo;
	}
	/**
	 * @return ��ע
	 */
	public String getFiller() {
	 	return filler;
	}
	/**
	 * @���� ��ע
	 * @param filler
	 */
	public void setFiller(String filler) {
	 	this.filler = filler;
	}
	/**
	 * @return ���񱨱��ֹ����
	 */
	public String getEndDate() {
	 	return endDate;
	}
	/**
	 * @���� ���񱨱��ֹ����
	 * @param endDate
	 */
	public void setEndDate(String endDate) {
	 	this.endDate = endDate;
	}
	/**
	 * @return ��Ӫ��������ֽ���
	 */
	public Double getNetCash() {
	 	return netCash;
	}
	/**
	 * @���� ��Ӫ��������ֽ���
	 * @param netCash
	 */
	public void setNetCash(Double netCash) {
	 	this.netCash = netCash;
	}
	/**
	 * @return �������󸴺�������(%)
	 */
	public Double getGaAddRate() {
	 	return gaAddRate;
	}
	/**
	 * @���� �������󸴺�������(%)
	 * @param gaAddRate
	 */
	public void setGaAddRate(Double gaAddRate) {
	 	this.gaAddRate = gaAddRate;
	}
	/**
	 * @return �������븴��������(%)
	 */
	public Double getSiAddRate() {
	 	return siAddRate;
	}
	/**
	 * @���� �������븴��������(%)
	 * @param siAddRate
	 */
	public void setSiAddRate(Double siAddRate) {
	 	this.siAddRate = siAddRate;
	}
	/**
	 * @return �ʲ���ծ��(%)
	 */
	public Double getAssDebtRate() {
	 	return assDebtRate;
	}
	/**
	 * @���� �ʲ���ծ��(%)
	 * @param assDebtRate
	 */
	public void setAssDebtRate(Double assDebtRate) {
	 	this.assDebtRate = assDebtRate;
	}
	/**
	 * @return ���ʲ���ģ(��Ԫ)
	 */
	public Double getNetAsset() {
	 	return netAsset;
	}
	/**
	 * @���� ���ʲ���ģ(��Ԫ)
	 * @param netAsset
	 */
	public void setNetAsset(Double netAsset) {
	 	this.netAsset = netAsset;
	}
	/**
	 * @return ������
	 */
	public Double getNetGain() {
	 	return netGain;
	}
	/**
	 * @���� ������
	 * @param netGain
	 */
	public void setNetGain(Double netGain) {
	 	this.netGain = netGain;
	}
	/**
	 * @return ����˰
	 */
	public Double getIncomeTax() {
	 	return incomeTax;
	}
	/**
	 * @���� ����˰
	 * @param incomeTax
	 */
	public void setIncomeTax(Double incomeTax) {
	 	this.incomeTax = incomeTax;
	}
	/**
	 * @return ��Ϣ֧��
	 */
	public Double getPayInt() {
	 	return payInt;
	}
	/**
	 * @���� ��Ϣ֧��
	 * @param payInt
	 */
	public void setPayInt(Double payInt) {
	 	this.payInt = payInt;
	}
	/**
	 * @return ���۳ɱ�
	 */
	public Double getSaleCost() {
	 	return saleCost;
	}
	/**
	 * @���� ���۳ɱ�
	 * @param saleCost
	 */
	public void setSaleCost(Double saleCost) {
	 	this.saleCost = saleCost;
	}
	public String getUpOpname() {
		return upOpname;
	}
	public void setUpOpname(String upOpname) {
		this.upOpname = upOpname;
	}
	public String getOpName() {
		return opName;
	}
	public void setOpName(String opName) {
		this.opName = opName;
	}
	public void setSaleIncome(Double saleIncome) {
		this.saleIncome = saleIncome;
	}
}