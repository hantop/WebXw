package accounting.domain.sys;

import java.sql.Connection;

import accounting.plat.PUBConstant;

public class OperaInfo {

	private String txBrNo ;		// ���㽻�׻�����
	private String bizDt ;		// ҵ��������
	private String txDt ;		// ϵͳ��������
	private String traceNo ;		// ������ˮ��
	private int traceCnt=1 ;	// ������ˮ�ʴ�
	private Connection conn ;	// ���ݿ�����

	public OperaInfo(Connection conn){
		this.conn = conn ;
		this.txDt = PUBConstant.CUR_PRCS_DT ;		// ϵͳ��������
		this.bizDt = PUBConstant.CUR_PRCS_DT ;		// Ӫҵ����
	}
	
	public OperaInfo(AfferentDomain afferentDomain){
		this.txBrNo = afferentDomain.getBrNo() ;	// ���㽻�׻�����
		this.txDt = PUBConstant.CUR_PRCS_DT ;		// ϵͳ��������
		this.bizDt = PUBConstant.CUR_PRCS_DT ;		// Ӫҵ����
	}
	
	public OperaInfo(AfferentDomain afferentDomain, String traceNo, Connection conn){
		this.txBrNo = afferentDomain.getBrNo() ;	// ���㽻�׻�����
		this.txDt = afferentDomain.getTxDt() ;		// ϵͳ����
		this.bizDt = afferentDomain.getBizDt();		// ��������
		this.traceNo = traceNo ;					// ҵ����ˮ��
		this.conn = conn ;							// ���ݿ�����
	}
	
	
	/**
	 * ��� ���㽻�׻�����
	 * @return ���㽻�׻�����
	 */
	public String getTxBrNo() {
		return txBrNo;
	}
	
	/**
	 * ���� ���㽻�׻�����
	 * @param brNo	
	 */
	public void setTxBrNo(String txBrNo) {
		this.txBrNo = txBrNo;
	}
	
	/**
	 * ��� ҵ��������
	 * @return ҵ��������
	 */
	public String getBizDt() {
		return bizDt;
	}
	
	/**
	 * ���� ҵ��������
	 * @param bizDt
	 */
	public void setBizDt(String bizDt) {
		this.bizDt = bizDt;
	}
	
	/**
	 * ��� ϵͳ��������
	 * @return ϵͳ��������
	 */
	public String getTxDt() {
		return txDt;
	}
	
	/**
	 * ���� ϵͳ��������
	 * @param txDt
	 */
	public void setTxDt(String txDt) {
		this.txDt = txDt;
	}

	/**
	 * ��� ������ˮ��
	 * @return ������ˮ��
	 */
	public String getTraceNo() {
		return traceNo;
	}

	/**
	 * ���� ������ˮ��
	 * @param traceNo
	 */
	public void setTraceNo(String traceNo) {
		this.traceNo = traceNo;
	}

	/**
	 * ��� ���ݿ�����
	 * @return ���ݿ�����
	 */
	public Connection getConn() {
		return conn;
	}

	/**
	 * ���� ���ݿ�����
	 * @param conn
	 */
	public void setConn(Connection conn) {
		this.conn = conn;
	}

	/**
	 * �����ˮ�ʴ�
	 * @return ��ˮ�ʴ�
	 */
	public int getTraceCnt() {
		return traceCnt;
	}

	/**
	 * ���� ��ˮ�ʴ�
	 * @param ��ˮ�ʴ�
	 */
	public void setTraceCnt(int traceCnt) {
		this.traceCnt = traceCnt;
	}
	
}