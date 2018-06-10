package app.creditapp.fund.entity;
import app.base.BaseDomain;
/**
* Title: FundProvService.java
* Description:
* @version��1.0
**/
public class FundProvService extends BaseDomain {
	private String provServiceNo;//�������Ŵ�����ѱ��
	private String provProjNo;//��Ŀ���������
	private String projNo;//��Ŀ���
	private String stepNo;//���ݱ��
	private Double minAmt;//���ݷŴ���ģ����
	private Double maxAmt;//���ݷŴ���ģ����
	private Float  svRate;//�������
	private Double servicefee;//�����
	private String jtBegDate;//������ʼ����
	private String jtEndDate;//���ᵽ������
	private String prdtNo;//��Ʒ���
	private String prdtName;//��Ʒ����
	private Float  offRate;//�ۿ���
	private Double prdtDueAmt;//��Ʒ�ڱ����ݶ��ڷŴ���ģ
	private Double prdtServicefee;//��Ʒ�ڱ����ݶ��ڷ����
	private String opNo;//������Ա
	private String txDate;//��������
	private String filler;//��ע

	/**
	 * @return �������Ŵ�����ѱ��
	 */
	public String getProvServiceNo() {
	 	return provServiceNo;
	}
	/**
	 * @���� �������Ŵ�����ѱ��
	 * @param provServiceNo
	 */
	public void setProvServiceNo(String provServiceNo) {
	 	this.provServiceNo = provServiceNo;
	}
	/**
	 * @return ��Ŀ���������
	 */
	public String getProvProjNo() {
	 	return provProjNo;
	}
	/**
	 * @���� ��Ŀ���������
	 * @param provProjNo
	 */
	public void setProvProjNo(String provProjNo) {
	 	this.provProjNo = provProjNo;
	}
	/**
	 * @return ��Ŀ���
	 */
	public String getProjNo() {
	 	return projNo;
	}
	/**
	 * @���� ��Ŀ���
	 * @param projNo
	 */
	public void setProjNo(String projNo) {
	 	this.projNo = projNo;
	}
	/**
	 * @return ���ݱ��
	 */
	public String getStepNo() {
	 	return stepNo;
	}
	/**
	 * @���� ���ݱ��
	 * @param stepNo
	 */
	public void setStepNo(String stepNo) {
	 	this.stepNo = stepNo;
	}
	/**
	 * @return ���ݷŴ���ģ����
	 */
	public Double getMinAmt() {
	 	return minAmt;
	}
	/**
	 * @���� ���ݷŴ���ģ����
	 * @param minAmt
	 */
	public void setMinAmt(Double minAmt) {
	 	this.minAmt = minAmt;
	}
	/**
	 * @return ���ݷŴ���ģ����
	 */
	public Double getMaxAmt() {
	 	return maxAmt;
	}
	/**
	 * @���� ���ݷŴ���ģ����
	 * @param maxAmt
	 */
	public void setMaxAmt(Double maxAmt) {
	 	this.maxAmt = maxAmt;
	}
	/**
	 * @return �������
	 */
	public Float getSvRate() {
	 	return svRate;
	}
	/**
	 * @���� �������
	 * @param svRate
	 */
	public void setSvRate(Float svRate) {
	 	this.svRate = svRate;
	}
	/**
	 * @return �����
	 */
	public Double getServicefee() {
	 	return servicefee;
	}
	/**
	 * @���� �����
	 * @param servicefee
	 */
	public void setServicefee(Double servicefee) {
	 	this.servicefee = servicefee;
	}
	/**
	 * @return ������ʼ����
	 */
	public String getJtBegDate() {
	 	return jtBegDate;
	}
	/**
	 * @���� ������ʼ����
	 * @param jtBegDate
	 */
	public void setJtBegDate(String jtBegDate) {
	 	this.jtBegDate = jtBegDate;
	}
	/**
	 * @return ���ᵽ������
	 */
	public String getJtEndDate() {
	 	return jtEndDate;
	}
	/**
	 * @���� ���ᵽ������
	 * @param jtEndDate
	 */
	public void setJtEndDate(String jtEndDate) {
	 	this.jtEndDate = jtEndDate;
	}
	/**
	 * @return ��Ʒ���
	 */
	public String getPrdtNo() {
	 	return prdtNo;
	}
	/**
	 * @���� ��Ʒ���
	 * @param prdtNo
	 */
	public void setPrdtNo(String prdtNo) {
	 	this.prdtNo = prdtNo;
	}
	/**
	 * @return ��Ʒ����
	 */
	public String getPrdtName() {
	 	return prdtName;
	}
	/**
	 * @���� ��Ʒ����
	 * @param prdtName
	 */
	public void setPrdtName(String prdtName) {
	 	this.prdtName = prdtName;
	}
	/**
	 * @return �ۿ���
	 */
	public Float getOffRate() {
	 	return offRate;
	}
	/**
	 * @���� �ۿ���
	 * @param offRate
	 */
	public void setOffRate(Float offRate) {
	 	this.offRate = offRate;
	}
	/**
	 * @return ��Ʒ�ڱ����ݶ��ڷŴ���ģ
	 */
	public Double getPrdtDueAmt() {
	 	return prdtDueAmt;
	}
	/**
	 * @���� ��Ʒ�ڱ����ݶ��ڷŴ���ģ
	 * @param prdtDueAmt
	 */
	public void setPrdtDueAmt(Double prdtDueAmt) {
	 	this.prdtDueAmt = prdtDueAmt;
	}
	/**
	 * @return ��Ʒ�ڱ����ݶ��ڷ����
	 */
	public Double getPrdtServicefee() {
	 	return prdtServicefee;
	}
	/**
	 * @���� ��Ʒ�ڱ����ݶ��ڷ����
	 * @param prdtServicefee
	 */
	public void setPrdtServicefee(Double prdtServicefee) {
	 	this.prdtServicefee = prdtServicefee;
	}
	/**
	 * @return ������Ա
	 */
	public String getOpNo() {
	 	return opNo;
	}
	/**
	 * @���� ������Ա
	 * @param opNo
	 */
	public void setOpNo(String opNo) {
	 	this.opNo = opNo;
	}
	/**
	 * @return ��������
	 */
	public String getTxDate() {
	 	return txDate;
	}
	/**
	 * @���� ��������
	 * @param txDate
	 */
	public void setTxDate(String txDate) {
	 	this.txDate = txDate;
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
}