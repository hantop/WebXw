package app.creditapp.inf.entity;

import java.util.List;

/**
 * @���� DHCC-LIU
 * @���� Jun 23, 2016
 * @����   ������������--����ʵ���� ln_batch
 */
public class WsIn2101 {
	
	private String brNo; // �����������
	private int    dataCnt; //��¼��[1,1000]
	private String batNo; //���κ�
	private List<WsIn2101_1> list;
	

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

	public List<WsIn2101_1> getList() {
		return list;
	}

	public void setList(List<WsIn2101_1> list) {
		this.list = list;
	}
	
	
}
