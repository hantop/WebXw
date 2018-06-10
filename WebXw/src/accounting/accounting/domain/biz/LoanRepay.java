package accounting.domain.biz;

import java.util.Map;

/**
 * ����������ڱ��淽���䴫�����ݵĶ���
 * 
 *
 */
public class LoanRepay {

	private Map<String, Double> dcMap ; 	//<������ͣ� ���>
	private double remainAmt ;		//�ɿۿ���
	private double repayedAmt ;		//�����ܿۿ���
	private boolean batchInd ;		//���յ��ñ�ʶ
	
	/**
	 * 
	 * @return <������ͣ� ���>
	 */
	public Map<String, Double> getDcMap() {
		return dcMap;
	}
	
	/**
	 * ���� <������ͣ� ���>
	 * @param dcMap
	 */
	public void setDcMap(Map<String, Double> dcMap) {
		this.dcMap = dcMap;
	}
	
	/**
	 * @return  �ɿۿ���
	 */
	public double getRemainAmt() {
		return remainAmt;
	}
	
	/**
	 * 
	 * @param remainAmt �ɿۿ���
	 */
	public void setRemainAmt(double remainAmt) {
		this.remainAmt = remainAmt;
	}

	/**
	 * @return  �����ܻ�����
	 */
	public double getRepayedAmt() {
		return repayedAmt;
	}

	/**
	 * 
	 * @param remainAmt �����ܻ�����
	 */
	public void setRepayedAmt(double repayedAmt) {
		this.repayedAmt = repayedAmt;
	}

	/**
	 * 
	 * @return ���յ��ñ�ʶ
	 */
	public boolean getBatchInd() {
		return batchInd;
	}

	/**
	 * 
	 * @param batchInd ���յ��ñ�ʶ
	 */
	public void setBatchInd(boolean batchInd) {
		this.batchInd = batchInd;
	}
	
}
