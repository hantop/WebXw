package accounting.interf.loan;

import accounting.domain.sys.AfferentDomain ;

public class IntstDetailDatas extends AfferentDomain {
	
	//���ļ�ֱ��ȡֵ
	private double prcpAmt ;								//����
	private double normInt ;								//��Ϣ
	private double fineInt ;								//��Ϣ
	
	private double repayAmt;						//�յ������ܽ��
	
	private double curInt;							//������Ϣ
	private double remPrcpAmt;						//��ǰ�������
	private double curPrcpAmt;	//�����ڽ��
	
	private double feeAmt;							//����
	private double loFeeAmt;						//Ƿ��
	
	
	/**
	 * @return feeAmt
	 */
	public double getFeeAmt() {
		return feeAmt;
	}
	/**
	 * @param feeAmt
	 */
	public void setFeeAmt(double feeAmt) {
		this.feeAmt = feeAmt;
	}

	/**
	 * @return  ����
	 */
	public double getPrcpAmt() {
		return prcpAmt ;
	}
	/**
	 * @����  ����
	 * @param ����
	 */
	
	public void setPrcpAmt(double prcpAmt) {
		this.prcpAmt = prcpAmt ;
	}

	/**
	 * @return  �յ������ܽ��
	 */
	public double getRepayAmt() {
		return repayAmt;
	}
	/**
	 * @����  �յ������ܽ��
	 * @param �յ������ܽ�� 
	 */
	
	public void setRepayAmt(double repayAmt) {
		this.repayAmt = repayAmt;
	}
	/**
	 * @return  ������Ϣ
	 */
	public double getCurInt() {
		return curInt;
	}
	/**
	 * @���� ������Ϣ
	 * @param ������Ϣ
	 */
	
	public void setCurInt(double curInt) {
		this.curInt = curInt;
	}
	/**
	 * @return  ��ǰ�������
	 */
	public double getRemPrcpAmt() {
		return remPrcpAmt;
	}
	/**
	 * @����  ��ǰ�������
	 * @param ��ǰ������� 
	 */
	
	public void setRemPrcpAmt(double remPrcpAmt) {
		this.remPrcpAmt = remPrcpAmt;
	}
	public double getFineInt() {
		return fineInt;
	}
	public void setFineInt(double fineInt) {
		this.fineInt = fineInt;
	}
	public double getNormInt() {
		return normInt;
	}
	public void setNormInt(double normInt) {
		this.normInt = normInt;
	}
	public double getLoFeeAmt() {
		return loFeeAmt;
	}
	public void setLoFeeAmt(double loFeeAmt) {
		this.loFeeAmt = loFeeAmt;
	}
	public double getCurPrcpAmt() {
		return curPrcpAmt;
	}
	public void setCurPrcpAmt(double curPrcpAmt) {
		this.curPrcpAmt = curPrcpAmt;
	}
	
	
	
}
