package app.creditapp.inf.entity;

import java.util.List;


/**
 * @���� DHCC-LIU
 * @���� Jun 23, 2016
 * list
 * @����   Ԥ������Ϣ��ѯ---���ʵ����
 */
public class WsOut2101 {
	
	private String batNo; //���α��
	private int    dataCnt; //���ռ�¼��
	
	private List<WsOut2101_1> list;

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

	public List<WsOut2101_1> getList() {
		return list;
	}

	public void setList(List<WsOut2101_1> list) {
		this.list = list;
	}

	
	
	

}
