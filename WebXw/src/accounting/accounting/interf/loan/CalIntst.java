/**
 * 
 */
package accounting.interf.loan;

import accounting.domain.sys.AfferentDomain;

/**   
 *    
 * @��Ŀ���ƣ�nxnxnew   
 * @�����ƣ�Intst   
 * @��������   
 * 
 *    
 */

public class CalIntst extends AfferentDomain {
	private String loanNo;	    //��ݺ�
	private String setlMode;	//����ģʽ
	private double remAmt;      //������
	private String fdrpIntstOpt;//��Ϣ���㵽
	private String fdrpIntBase; //��Ϣ�������
	
	
	
	/**
	 * �����
	 * @return �����
	 */
	public double getRemAmt() {
		return remAmt;
	}
	/**
	 * �����
	 * @param remAmt
	 */
	public void setRemAmt(double remAmt) {
		this.remAmt = remAmt;
	}
	
	/**
	 * ��ݺ�
	 * @return the loanNo
	 */
	public String getLoanNo() {
		return loanNo;
	}
	/**
	 * ��ݺ�
	 * @param loanNo
	 */
	public void setLoanNo(String loanNo) {
		this.loanNo = loanNo;
	}
	/**
	 * ����ģʽ
	 * @return ����ģʽ
	 */
	public String getSetlMode() {
		return setlMode;
	}
	/**
	 * ����ģʽ
	 * @param setlMode
	 */
	public void setSetlMode(String setlMode) {
		this.setlMode = setlMode;
	}
	/**
	 * ��ǰ������Ϣ���㵽
	 * @return ��ǰ������Ϣ���㵽
	 */
	public String getFdrpIntstOpt() {
		return fdrpIntstOpt;
	}
	/**
	 * ��ǰ������Ϣ���㵽
	 * @param fdrpIntstOpt
	 */
	public void setFdrpIntstOpt(String fdrpIntstOpt) {
		this.fdrpIntstOpt = fdrpIntstOpt;
	}
	/**
	 * ��ǰ������Ϣ�������
	 * @return ��ǰ������Ϣ�������
	 */
	public String getFdrpIntBase() {
		return fdrpIntBase;
	}
	/**
	 * ��ǰ������Ϣ�������
	 * @param fdrpIntBase
	 */
	public void setFdrpIntBase(String fdrpIntBase) {
		this.fdrpIntBase = fdrpIntBase;
	}
	
	
}
