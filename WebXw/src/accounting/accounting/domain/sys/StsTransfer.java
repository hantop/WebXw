package accounting.domain.sys;

import java.util.Map;

public class StsTransfer {
	private String prcpStp;	//����ת�����־
	private String devi;	//��ֵ��־
	private String prcpOver;//�������ڱ�־
	private String isOver;	//�������ڱ�־
	private String stpInd;//��Ϣת�����־
	private double delqPrcp;//��Ƿ����
	private double odPrcp;//���ڱ���
	private double normInt;//������Ϣ
	private double odInt;//������Ϣ
	
	/**
	 * @return the prcpStp
	 */
	public String getPrcpStp() {
		return prcpStp;
	}
	/**
	 * @param prcpStp the prcpStp to set
	 */
	public void setPrcpStp(String prcpStp) {
		this.prcpStp = prcpStp;
	}

	/**
	 * @return the odPrcp
	 */
	public double getOdPrcp() {
		return odPrcp;
	}
	/**
	 * @param odPrcp the odPrcp to set
	 */
	public void setOdPrcp(double odPrcp) {
		this.odPrcp = odPrcp;
	}
	/**
	 * @return the normInt
	 */
	public double getNormInt() {
		return normInt;
	}
	/**
	 * @param normInt the normInt to set
	 */
	public void setNormInt(double normInt) {
		this.normInt = normInt;
	}
	/**
	 * @return the odInt
	 */
	public double getOdInt() {
		return odInt;
	}
	/**
	 * @param odInt the odInt to set
	 */
	public void setOdInt(double odInt) {
		this.odInt = odInt;
	}
	/**
	 * @return the stpInd
	 */
	public String getStpInd() {
		return stpInd;
	}
	/**
	 * @param stpInd the stpInd to set
	 */
	public void setStpInd(String stpInd) {
		this.stpInd = stpInd;
	}



	/**
	 * @return the delqPrcp
	 */
	public double getDelqPrcp() {
		return delqPrcp;
	}
	/**
	 * @param delqPrcp the delqPrcp to set
	 */
	public void setDelqPrcp(double delqPrcp) {
		this.delqPrcp = delqPrcp;
	}

	/**
	 * @return devi ��ֵ��־
	 */
	public String getDevi() {
		return devi;
	}
	/**
	 * @���� ��ֵ��־
	 * @param devi ��ֵ��־
	 */
	public void setDevi(String devi) {
		this.devi = devi;
	}
	/**
	 * @return prcpOver �������ڱ�־
	 */
	public String getPrcpOver() {
		return prcpOver;
	}
	/**
	 * @���� �������ڱ�־
	 * @param prcpOver �������ڱ�־
	 */
	public void setPrcpOver(String prcpOver) {
		this.prcpOver = prcpOver;
	}
	/**
	 * @return isOver �������ڱ�־
	 */
	public String getIsOver() {
		return isOver;
	}
	/**
	 * @���� �������ڱ�־
	 * @param isOver �������ڱ�־
	 */
	public void setIsOver(String isOver) {
		this.isOver = isOver;
	}

	
	
}
