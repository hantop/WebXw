package app.creditapp.inf.entity;

import java.util.List;

/**
 * @���� DHCC-ZKX
 * @���� July 22, 2016
 * @����   B����ǰ������������[2804] �������� 
 */
public class WsIn2804 {
	
	private String brNo;//����������
	private String batNo;//���κ�
	private int dataCnt;//��¼��
	
	List<WsIn2804_1> list;
	List<WsIn2804_2> listPlan;
	
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
	public List<WsIn2804_1> getList() {
		return list;
	}
	public void setList(List<WsIn2804_1> list) {
		this.list = list;
	}
	public List<WsIn2804_2> getListPlan() {
		return listPlan;
	}
	public void setListPlan(List<WsIn2804_2> listPlan) {
		this.listPlan = listPlan;
	}	
}
