package app.creditapp.inf.entity;

import java.util.List;


/**
 * @���� DHCC-LIU
 * @���� Jun 23, 2016
 * @����  Ԥ������������[2001] ������Ϣ
 */
public class WsIn2001 {
	
	private String brNo; // �����������
	private String batNo; // ���κ�
	private int    dataCnt; //��¼��
	
	private List<WsIn2001_1> list;
	
	
	public String getBrNo() {
		return brNo;
	}
	public void setBrNo(String brNo) {
		this.brNo = brNo;
	}
	public String getBatNo() {
		return batNo;
	}
	public void setBatNo(String batNo) {
		this.batNo = batNo;
	}
	public int getDataCnt() {
		return dataCnt;
	}
	public void setDataCnt(int dataCnt) {
		this.dataCnt = dataCnt;
	}
	public List<WsIn2001_1> getList() {
		return list;
	}
	public void setList(List<WsIn2001_1> list) {
		this.list = list;
	}
	
	
}
