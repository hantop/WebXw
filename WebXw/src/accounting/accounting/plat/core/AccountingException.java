package accounting.plat.core;


public class AccountingException extends Exception{
	
	/**
	 * 
	 */
	//private static final long serialVersionUID = -2332975704789408379L;
	
	private String errCode;               //�쳣��
	
	private int level=0;                  //�쳣����
	
	/**
 	 * @return level ���׻�����
 	 */
	public int getLevel() {
		return level;
	}
	/**
 	 * @����  �쳣����
 	 * @param level
 	 */

	private void setLevel(int level) {
		this.level = level;
	}

	/**
 	 * @return errCode �쳣��
 	 */
	public String getErrCode() {
		return errCode;
	}
	/**
 	 * @����  �쳣��
 	 * @param errCode
 	 */
	private void setErrCode(String errCode) {
		this.errCode = errCode;
	}

	private AccountingException() {
		super();
	}

	private AccountingException(String message, Throwable cause, String errCode) {
		super(message, cause);
		this.errCode = errCode;
	}
	private AccountingException(String message, String errCode) {
		super(message);
		this.errCode = errCode;
	}

	private AccountingException(String message, Throwable cause) {
		super(message, cause);
	}
	/**
	 *   ���췽��
	 *   �� ���� ��ʱ�򣬲�ͨ������Ҫ���쳣����ʽ���з�����
	 *   ��������������ǳ����������⣬����ҵ�������ݵ����⣬���м���level����Ϊ1
	 * @param message   ��Ҫ�׳��ķ�����Ϣ 
	 */
	public AccountingException(String message) {
		super(message);
		level=1;
	}
	/**
	 *   ���췽��
	 *   ������ĳ���������ʱ����Ϊ���÷���֪�������ԭ�����а������������Ϊ�����쳣�����弶��Ϊ 0
	 * @param cause   Throwable����������   �����е��쳣��Ķ���
	 */
	public AccountingException(Throwable cause) {
		super(cause);
		level=0;
	}
}
