package app.creditapp.sys.entity;
import app.base.BaseDomain;
/**
* Title: InterfaceBackMeg.java
* Description:
* @version��1.0
**/
public class InterfaceBackMeg extends BaseDomain {
	private String backMegKey;//������Ϣ����
	private String interfaceName;//�ӿ�����
	private String backMegDes;//������Ϣ����

	/**
	 * @return ������Ϣ����
	 */
	public String getBackMegKey() {
	 	return backMegKey;
	}
	/**
	 * @���� ������Ϣ����
	 * @param backMegKey
	 */
	public void setBackMegKey(String backMegKey) {
	 	this.backMegKey = backMegKey;
	}
	/**
	 * @return �ӿ�����
	 */
	public String getInterfaceName() {
	 	return interfaceName;
	}
	/**
	 * @���� �ӿ�����
	 * @param interfaceName
	 */
	public void setInterfaceName(String interfaceName) {
	 	this.interfaceName = interfaceName;
	}
	/**
	 * @return ������Ϣ����
	 */
	public String getBackMegDes() {
	 	return backMegDes;
	}
	/**
	 * @���� ������Ϣ����
	 * @param backMegDes
	 */
	public void setBackMegDes(String backMegDes) {
	 	this.backMegDes = backMegDes;
	}
}