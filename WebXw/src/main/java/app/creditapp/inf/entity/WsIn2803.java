package app.creditapp.inf.entity;

import java.util.List;

/**
 * A����ǰ������������[2803]
 *��������ʵ����
 */
public class WsIn2803 {

	private String brNo;//����������
	private int dataCnt;//��¼��
	private String batNo;//���κ�
	
	private List<WsIn2803_1> list;

	public String getBrNo() {
		return brNo;
	}

	public void setBrNo(String brNo) {
		this.brNo = brNo;
	}

	public int getDataCnt() {
		return dataCnt;
	}

	public void setDataCnt(int dataCnt) {
		this.dataCnt = dataCnt;
	}

	public String getBatNo() {
		return batNo;
	}

	public void setBatNo(String batNo) {
		this.batNo = batNo;
	}

	public List<WsIn2803_1> getList() {
		return list;
	}

	public void setList(List<WsIn2803_1> list) {
		this.list = list;
	}

}
