package accounting.domain.biz;
/**
* Title: AcComHoliday.java
* Description:
* @���� su
* @���� 2018-4-25
* @version��1.0
**/
public class AcComHoliday extends accounting.domain.sys.CMISDomain {
	private String begDt;                   //�ڼ�����ʼ����
	private String endDt;                   //�ڼ�����ֹ����
	private String days;                    //����
	private String typ;                     //����


	/**
	 * @return ���� �ڼ�����ʼ����
	 */
	public String getBegDt() {
		return begDt;
	}
	/**
	 * @���� �ڼ�����ʼ����
	 * @param begDt
	 */
	public void setBegDt(String begDt) {
		this.begDt=begDt;
	}
	/**
	 * @return ���� �ڼ�����ֹ����
	 */
	public String getEndDt() {
		return endDt;
	}
	/**
	 * @���� �ڼ�����ֹ����
	 * @param endDt
	 */
	public void setEndDt(String endDt) {
		this.endDt=endDt;
	}
	/**
	 * @return ���� ����
	 */
	public String getDays() {
		return days;
	}
	/**
	 * @���� ����
	 * @param days
	 */
	public void setDays(String days) {
		this.days=days;
	}
	/**
	 * @return ���� ����
	 */
	public String getTyp() {
		return typ;
	}
	/**
	 * @���� ����
	 * @param typ
	 */
	public void setTyp(String typ) {
		this.typ=typ;
	}
}