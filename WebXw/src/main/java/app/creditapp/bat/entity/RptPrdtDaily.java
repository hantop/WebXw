package app.creditapp.bat.entity;
import app.base.BaseDomain;
/**
* Title: RptPrdtDaily.java
* Description:
* @version��1.0
**/
public class RptPrdtDaily extends BaseDomain {
	private String rptDate;//��������
	private String rptType;//��������[01-�³�02-��Ѯ03-��Ѯ04-�µ�05-��]
	private String projNo;//��Ŀ���
	private String prdtType;//��Ʒ����
	private String prdtNo;//��Ʒ��
	private Integer cifNum;//����
	private Integer lnCnt;//����
	private Double lnBal;//���
	private Double overBal;//�������
	private Double intstBal;//ǷϢ
	private Double cntYear;//���귢�ű���
	private Double cntMon;//���·��ű���
	private Double cntDay;//���շ��ű���
	private Double cntAvg;//�վ�����
	private Double amtTot;//�۷Ž��
	private Double amtYear;//�����۷�
	private Double amtMon;//�����۷�
	private Double amtDay;//�����۷�
	private Double amtAvg;//�վ��Ŵ�
	
	//֮�����
	private Double maxAmt;//���ݷŴ���ģ����
	private Float offRate;//��Ʒ�ۿ���
	
	private String lnType;//��Ʒ����

	/**
	 * @return ��������
	 */
	public String getRptDate() {
	 	return rptDate;
	}
	/**
	 * @���� ��������
	 * @param rptDate
	 */
	public void setRptDate(String rptDate) {
	 	this.rptDate = rptDate;
	}
	/**
	 * @return ��������[01-�³�02-��Ѯ03-��Ѯ04-�µ�05-��]
	 */
	public String getRptType() {
	 	return rptType;
	}
	/**
	 * @���� ��������[01-�³�02-��Ѯ03-��Ѯ04-�µ�05-��]
	 * @param rptType
	 */
	public void setRptType(String rptType) {
	 	this.rptType = rptType;
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
	 * @return ��Ʒ��
	 */
	public String getPrdtNo() {
	 	return prdtNo;
	}
	/**
	 * @���� ��Ʒ��
	 * @param prdtNo
	 */
	public void setPrdtNo(String prdtNo) {
	 	this.prdtNo = prdtNo;
	}
	/**
	 * @return �ܴ������
	 */
	/**
	 * @return �۷Ž��
	 */
	public Double getAmtTot() {
	 	return amtTot;
	}
	/**
	 * @���� �۷Ž��
	 * @param amtTot
	 */
	public void setAmtTot(Double amtTot) {
	 	this.amtTot = amtTot;
	}
	/**
	 * @return �����۷�
	 */
	public Double getAmtYear() {
	 	return amtYear;
	}
	/**
	 * @���� �����۷�
	 * @param amtYear
	 */
	public void setAmtYear(Double amtYear) {
	 	this.amtYear = amtYear;
	}
	/**
	 * @return �����۷�
	 */
	public Double getAmtMon() {
	 	return amtMon;
	}
	/**
	 * @���� �����۷�
	 * @param amtMon
	 */
	public void setAmtMon(Double amtMon) {
	 	this.amtMon = amtMon;
	}
	/**
	 * @return �����۷�
	 */
	public Double getAmtDay() {
	 	return amtDay;
	}
	/**
	 * @���� �����۷�
	 * @param amtDay
	 */
	public void setAmtDay(Double amtDay) {
	 	this.amtDay = amtDay;
	}
	/**
	 * @return Ӧ��δ����Ϣ
	 */
	public Double getIntstBal() {
	 	return intstBal;
	}
	/**
	 * @���� Ӧ��δ����Ϣ
	 * @param intstBal
	 */
	public void setIntstBal(Double intstBal) {
	 	this.intstBal = intstBal;
	}
	public Double getMaxAmt() {
		return maxAmt;
	}
	//֮�����
	public void setMaxAmt(Double maxAmt) {
		this.maxAmt = maxAmt;
	}
	public Float getOffRate() {
		return offRate;
	}
	public void setOffRate(Float offRate) {
		this.offRate = offRate;
	}
	public String getPrdtType() {
		return prdtType;
	}
	public void setPrdtType(String prdtType) {
		this.prdtType = prdtType;
	}
	public Double getLnBal() {
		return lnBal;
	}
	public void setLnBal(Double lnBal) {
		this.lnBal = lnBal;
	}
	public Double getOverBal() {
		return overBal;
	}
	public void setOverBal(Double overBal) {
		this.overBal = overBal;
	}
	public String getLnType() {
		return lnType;
	}
	public void setLnType(String lnType) {
		this.lnType = lnType;
	}
	public Integer getCifNum() {
		return cifNum;
	}
	public void setCifNum(Integer cifNum) {
		this.cifNum = cifNum;
	}
	public Integer getLnCnt() {
		return lnCnt;
	}
	public void setLnCnt(Integer lnCnt) {
		this.lnCnt = lnCnt;
	}
	public Double getCntYear() {
		return cntYear;
	}
	public void setCntYear(Double cntYear) {
		this.cntYear = cntYear;
	}
	public Double getCntMon() {
		return cntMon;
	}
	public void setCntMon(Double cntMon) {
		this.cntMon = cntMon;
	}
	public Double getCntDay() {
		return cntDay;
	}
	public void setCntDay(Double cntDay) {
		this.cntDay = cntDay;
	}
	public Double getCntAvg() {
		return cntAvg;
	}
	public void setCntAvg(Double cntAvg) {
		this.cntAvg = cntAvg;
	}
	public Double getAmtAvg() {
		return amtAvg;
	}
	public void setAmtAvg(Double amtAvg) {
		this.amtAvg = amtAvg;
	}
}