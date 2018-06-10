package app.util.syslog.entity;

import edu.emory.mathcs.backport.java.util.Arrays;
import app.base.BaseDomain;

/**
 * Title: SysException.java Description:
 * 
 * @version��1.0
 **/
public class SysException extends BaseDomain {
	private String expId;// ��¼ID
	private String expDate;// �쳣��������
	private String expTime;// �쳣����ʱ��
	private String expClass;// �쳣������ͷ���
	private String expInfo;// �쳣��Ϣ
	private String userId;//����Ա��
	//�����ֶ�
	private String userName;//����Ա����

	/**
	 * @return ��¼ID
	 */
	public String getExpId() {
		return expId;
	}

	/**
	 * @���� ��¼ID
	 * @param expId
	 */
	public void setExpId(String expId) {
		this.expId = expId;
	}

	/**
	 * @return �쳣��������
	 */
	public String getExpDate() {
		return expDate;
	}

	/**
	 * @���� �쳣��������
	 * @param expDate
	 */
	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}

	/**
	 * @return �쳣����ʱ��
	 */
	public String getExpTime() {
		return expTime;
	}

	/**
	 * @���� �쳣����ʱ��
	 * @param expTime
	 */
	public void setExpTime(String expTime) {
		this.expTime = expTime.trim();
	}

	/**
	 * @return �쳣������ͷ���
	 */
	public String getExpClass() {
		return expClass;
	}

	/**
	 * @���� �쳣������ͷ���
	 * @param expClass
	 */
	public void setExpClass(String expClass) {
		this.expClass = expClass;
	}

	/**
	 * @return �쳣��Ϣ
	 */
	public String getExpInfo() {
		if (expInfo != null && !"".equals(expInfo)) {
			byte[] bits = expInfo.getBytes();
			if (bits.length > 400) {
				expInfo = new String(Arrays.copyOfRange(bits, 0, 400));
			}
		}
		return expInfo;
	}

	/**
	 * @���� �쳣��Ϣ
	 * @param expInfo
	 */
	public void setExpInfo(String expInfo) {
		this.expInfo = expInfo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		if (userId == null) {
			userId = "SYS0000";
		}
		this.userId = userId;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserName() {
		return userName;
	}

}