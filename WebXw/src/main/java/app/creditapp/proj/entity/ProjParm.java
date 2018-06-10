package app.creditapp.proj.entity;
import app.base.BaseDomain;
/**
* Title: ProjParm.java
* Description:
* @version��1.0
**/
public class ProjParm extends BaseDomain {
	private String upOpno;//�޸���Ա
	private String upOpname;//�޸���Ա����
	private String upDate;//�޸�����
	private String txDate;//�Ǽ�����
	private String opNo;//����Ա
	private String opName;//����Ա����
	private String deptNo;//�Ǽǲ���
	private String filler;//��ע
	private Float leverRate;//�ʽ�ܸ˱���
	private Integer backDays;//�ع�������ֵ[���ڳ���������ϵͳ�Զ����лع�����]
	private Integer compstDays;//����������ֵ
	private Float rgAppRate;//�˹����˱�����ֵ
	private Float mangFeerate;//���й������[Ĭ��Ϊǧ��֮��]
	private String truPayType;//���б����շ�����[���й���ѡ��Ŵ�����ѡ����ʱ���,����λ�����Ʊ�ʾ������001����ֻ�����ʱ���]
	private String projName;//��Ŀ����
	private String projNo;//��Ŀ���
	//�����ֶ�
	private int overDays = 10;//��������
	private int fundEndDays = 10;//�ʽ��ڶҸ�����
	private int projEndDays = 10;//��Ŀ��������
	private int intDays = 10;//��Ϣ��������
	
	private String endDay;
	private String overDay;
	public String getEndDay() {
		return endDay;
	}
	public void setEndDay(String endDay) {
		this.endDay = endDay;
	}
	public String getOverDay() {
		return overDay;
	}
	public void setOverDay(String overDay) {
		this.overDay = overDay;
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
	 * @return �ʽ�ܸ˱���
	 */
	public Float getLeverRate() {
	 	return leverRate;
	}
	/**
	 * @���� �ʽ�ܸ˱���
	 * @param leverRate
	 */
	public void setLeverRate(Float leverRate) {
	 	this.leverRate = leverRate;
	}
	/**
	 * @return �ع�������ֵ[���ڳ���������ϵͳ�Զ����лع�����]
	 */
	public Integer getBackDays() {
	 	return backDays;
	}
	/**
	 * @���� �ع�������ֵ[���ڳ���������ϵͳ�Զ����лع�����]
	 * @param backDays
	 */
	public void setBackDays(Integer backDays) {
	 	this.backDays = backDays;
	}
	/**
	 * @return �˹����˱�����ֵ
	 */
	public Float getRgAppRate() {
	 	return rgAppRate;
	}
	/**
	 * @���� �˹����˱�����ֵ
	 * @param rgAppRate
	 */
	public void setRgAppRate(Float rgAppRate) {
	 	this.rgAppRate = rgAppRate;
	}
	
	public Float getMangFeerate() {
		return mangFeerate;
	}
	public void setMangFeerate(Float mangFeerate) {
		this.mangFeerate = mangFeerate;
	}
	/**
	 * @return ���б����շ�����[���й���ѡ��Ŵ�����ѡ����ʱ���,����λ�����Ʊ�ʾ������001����ֻ�����ʱ���]
	 */
	public String getTruPayType() {
	 	return truPayType;
	}
	/**
	 * @���� ���б����շ�����[���й���ѡ��Ŵ�����ѡ����ʱ���,����λ�����Ʊ�ʾ������001����ֻ�����ʱ���]
	 * @param truPayType
	 */
	public void setTruPayType(String truPayType) {
	 	this.truPayType = truPayType;
	}
	/**
	 * @return ��Ŀ����
	 */
	public String getProjName() {
	 	return projName;
	}
	/**
	 * @���� ��Ŀ����
	 * @param projName
	 */
	public void setProjName(String projName) {
	 	this.projName = projName;
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
	public int getOverDays() {
		return overDays;
	}
	public void setOverDays(int overDays) {
		this.overDays = overDays;
	}
	public int getFundEndDays() {
		return fundEndDays;
	}
	public void setFundEndDays(int fundEndDays) {
		this.fundEndDays = fundEndDays;
	}
	public int getProjEndDays() {
		return projEndDays;
	}
	public void setProjEndDays(int projEndDays) {
		this.projEndDays = projEndDays;
	}
	public int getIntDays() {
		return intDays;
	}
	public void setIntDays(int intDays) {
		this.intDays = intDays;
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
	public Integer getCompstDays() {
		return compstDays;
	}
	public void setCompstDays(Integer compstDays) {
		this.compstDays = compstDays;
	}
}