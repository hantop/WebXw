package app.creditapp.inf.entity;


/**
 * Title: AllocateReg.java Description:
 * 
 * @version��1.0
 **/
public class ResData{

	private String status;// ״̬1:�ɹ� -1:ʧ��
	private String transID;// ���ɵĲ�����ID statusΪ1ʱ����
	private String errorCopeType;// ��������0:ϵͳ����1:����Ϣ��������2:��ϸ��Ϣ��������
	private String id;// ���ʱ��IDֵ��֧����������ʱ��λ�����¼
	private String errorCode;// ������

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the transID
	 */
	public String getTransID() {
		return transID;
	}

	/**
	 * @param transID
	 *            the transID to set
	 */
	public void setTransID(String transID) {
		this.transID = transID;
	}

	/**
	 * @return the errorCopeType
	 */
	public String getErrorCopeType() {
		return errorCopeType;
	}

	/**
	 * @param errorCopeType
	 *            the errorCopeType to set
	 */
	public void setErrorCopeType(String errorCopeType) {
		this.errorCopeType = errorCopeType;
	}

	/**
	 * @return the errorMsgDTO
	 */
	// public ErrorMsgDTO getErrorMsgDTO() {
	// return errorMsgDTO;
	// }
	// /**
	// * @param errorMsgDTO the errorMsgDTO to set
	// */
	// public void setErrorMsgDTO(ErrorMsgDTO errorMsgDTO) {
	// this.errorMsgDTO = errorMsgDTO;
	// }
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
}