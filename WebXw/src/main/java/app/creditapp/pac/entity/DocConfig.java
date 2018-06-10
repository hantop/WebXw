package app.creditapp.pac.entity;
import app.base.BaseDomain;
/**
* Title: DocConfig.java
* Description:
* @version��1.0
**/
public class DocConfig extends BaseDomain {
	private String ifStart;//�Ƿ�����1����2����
	private String ifSign;//�Ƿ���Ҫǩ��1����2����
	private String docTypeName;//�ĵ���������
	private String docTypeNo;//�ĵ����ͱ��
	private String docTypeId;//�ĵ�����ID
	private String txDate;//�Ǽ�����
	private String opNo;//�Ǽ���Ա
	private String upDate;//��������
	private String upOpno;//�޸���Ա

	/**
	 * @return �Ƿ�����1����2����
	 */
	public String getIfStart() {
	 	return ifStart;
	}
	/**
	 * @���� �Ƿ�����1����2����
	 * @param ifStart
	 */
	public void setIfStart(String ifStart) {
	 	this.ifStart = ifStart;
	}
	/**
	 * @return �Ƿ���Ҫǩ��1����2����
	 */
	public String getIfSign() {
	 	return ifSign;
	}
	/**
	 * @���� �Ƿ���Ҫǩ��1����2����
	 * @param ifSign
	 */
	public void setIfSign(String ifSign) {
	 	this.ifSign = ifSign;
	}
	/**
	 * @return �ĵ���������
	 */
	public String getDocTypeName() {
	 	return docTypeName;
	}
	/**
	 * @���� �ĵ���������
	 * @param docTypeName
	 */
	public void setDocTypeName(String docTypeName) {
	 	this.docTypeName = docTypeName;
	}
	/**
	 * @return �ĵ����ͱ��
	 */
	public String getDocTypeNo() {
	 	return docTypeNo;
	}
	/**
	 * @���� �ĵ����ͱ��
	 * @param docTypeNo
	 */
	public void setDocTypeNo(String docTypeNo) {
	 	this.docTypeNo = docTypeNo;
	}
	/**
	 * @return �ĵ�����ID
	 */
	public String getDocTypeId() {
	 	return docTypeId;
	}
	/**
	 * @���� �ĵ�����ID
	 * @param docTypeId
	 */
	public void setDocTypeId(String docTypeId) {
	 	this.docTypeId = docTypeId;
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
	 * @return �Ǽ���Ա
	 */
	public String getOpNo() {
	 	return opNo;
	}
	/**
	 * @���� �Ǽ���Ա
	 * @param opNo
	 */
	public void setOpNo(String opNo) {
	 	this.opNo = opNo;
	}
	/**
	 * @return ��������
	 */
	public String getUpDate() {
	 	return upDate;
	}
	/**
	 * @���� ��������
	 * @param upDate
	 */
	public void setUpDate(String upDate) {
	 	this.upDate = upDate;
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
}