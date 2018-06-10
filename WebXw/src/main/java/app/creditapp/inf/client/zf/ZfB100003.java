package app.creditapp.inf.client.zf;

import app.creditapp.inf.client.IBody;

public class ZfB100003 implements IBody{
	private String BatchNo;//���κ�
	private String OrderNo;//������
	private String EntryNo;//��Ŀ��
	
public String toXml() {
		
		StringBuffer s = new StringBuffer();

		s.append("<BatchNo>"+this.BatchNo+"</BatchNo>");
		s.append("<OrderNo>"+this.OrderNo+"</OrderNo>");
		s.append("<EntryNo>"+this.EntryNo+"</EntryNo>");

		return s.toString();
	}

public String getBatchNo() {
	return BatchNo;
}

public String getOrderNo() {
	return OrderNo;
}

public String getEntryNo() {
	return EntryNo;
}

public void setBatchNo(String batchNo) {
	BatchNo = batchNo;
}

public void setOrderNo(String orderNo) {
	OrderNo = orderNo;
}

public void setEntryNo(String entryNo) {
	EntryNo = entryNo;
}
}
