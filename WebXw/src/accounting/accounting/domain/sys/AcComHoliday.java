package accounting.domain.sys;
/**
* Title: AcComHoliday.java
* Description:
* @���� su
* @���� 2018-3-20
* @version��1.0
**/
public class AcComHoliday extends accounting.domain.sys.CMISDomain {
	private String begDt;                   //�ڼ�����ʼ����
	private String endDt;                   //�ڼ�����ֹ����
	private String days;                    //����
	private String typ; 
	private String hoId; //�ڼ���Id

	/**
	 * @return ���� �ڼ���Id
	 */
	public String getHoId() {
		return hoId;
	}
	/**
	 * @���� �ڼ���Id
	 * @param hoId
	 */
	public void setHoId(String hoId) {
		this.hoId = hoId;
	}
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