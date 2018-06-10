package app.creditapp.inf.client.zf;

import java.text.DecimalFormat;
import java.util.List;

import accounting.plat.util.NumberUtil;
import app.creditapp.inf.client.IBody;
import app.oscache.CachecodeUtil;

public class EntryInfo implements IBody{
	private String EntryNo;//��Ŀ��
	private String EnTradeType;//��Ŀ��������
	private double Amount;//���
	private String EntryTypeNo;//��Ŀ���ͱ��
	private String ChannelNo;//�������
	private List<SourceAccountInfo> SourceAccountList;//Դ�����˻���Ϣ�б�
	private List<TargetAccountInfo> TargetAccountList;//Ŀ�꽻���˻���Ϣ�б�
	private String Remark1;//��ע1
	private String Remark2;//��ע2
	private String Remark3;//��ע3
	
	//�ص�
	private String FlowNo;//�ӿ���ˮ��
	private String TradeNo;//���׺�
	private String Status;//����״̬
	private String Message;//��Ϣ����
	private double RpayMoney;//����֧�����
	private double PayMoney;//ʵ��֧�����
	private String TradeChannel;//��������
	
	@Override
	public String toXml() {
		DecimalFormat df = new DecimalFormat("#");
		StringBuffer s = new StringBuffer();
		s.append("<EntryInfo>");
		s.append("<EntryNo>"+CachecodeUtil.MFSPREFIX+this.EntryNo+"</EntryNo>");
		s.append("<EnTradeType>"+this.EnTradeType+"</EnTradeType>");
		s.append("<Amount>"+df.format(NumberUtil.amtMult(this.Amount, 100))+"</Amount>");
		s.append("<EntryTypeNo>"+this.EntryTypeNo+"</EntryTypeNo>");
		s.append("<ChannelNo>");
		s.append(this.ChannelNo==null?"":this.ChannelNo);
		s.append("</ChannelNo>");
		
		s.append("<SourceAccountList>");
		for (SourceAccountInfo sourceAccountInfo : this.SourceAccountList) {
			s.append(sourceAccountInfo.toXml());
		}
		s.append("</SourceAccountList>");
		
		s.append("<TargetAccountList>");
		for (TargetAccountInfo targetAccountInfo : this.TargetAccountList) {
			s.append(targetAccountInfo.toXml());
		}
		s.append("</TargetAccountList>");
		s.append("<Remark1>"+this.Remark1+"</Remark1>");
		s.append("<Remark2>"+this.Remark2+"</Remark2>");
		s.append("<Remark3>");
		s.append(this.Remark3==null?"":this.Remark3);
		s.append("</Remark3>");
		s.append("</EntryInfo>");

		return s.toString();
	}
	public String getEntryNo() {
		return EntryNo;
	}
	public void setEntryNo(String entryNo) {
		EntryNo = entryNo;
	}
	
	public String getEnTradeType() {
		return EnTradeType;
	}
	public void setEnTradeType(String enTradeType) {
		EnTradeType = enTradeType;
	}
	public double getAmount() {
		return Amount;
	}
	public void setAmount(double amount) {
		Amount = amount;
	}
	public String getEntryTypeNo() {
		return EntryTypeNo;
	}
	public void setEntryTypeNo(String entryTypeNo) {
		EntryTypeNo = entryTypeNo;
	}
	public List<SourceAccountInfo> getSourceAccountList() {
		return SourceAccountList;
	}
	public void setSourceAccountList(List<SourceAccountInfo> sourceAccountList) {
		SourceAccountList = sourceAccountList;
	}
	public List<TargetAccountInfo> getTargetAccountList() {
		return TargetAccountList;
	}
	public void setTargetAccountList(List<TargetAccountInfo> targetAccountList) {
		TargetAccountList = targetAccountList;
	}
	public String getRemark1() {
		return Remark1;
	}
	public void setRemark1(String remark1) {
		Remark1 = remark1;
	}
	public String getRemark2() {
		return Remark2;
	}
	public void setRemark2(String remark2) {
		Remark2 = remark2;
	}
	public String getRemark3() {
		return Remark3;
	}
	public void setRemark3(String remark3) {
		Remark3 = remark3;
	}
	public String getFlowNo() {
		return FlowNo;
	}
	public void setFlowNo(String flowNo) {
		FlowNo = flowNo;
	}
	public String getTradeNo() {
		return TradeNo;
	}
	public void setTradeNo(String tradeNo) {
		TradeNo = tradeNo;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public String getMessage() {
		return Message;
	}
	public void setMessage(String message) {
		Message = message;
	}
	public double getRpayMoney() {
		return RpayMoney;
	}
	public void setRpayMoney(double rpayMoney) {
		RpayMoney = rpayMoney;
	}
	public double getPayMoney() {
		return PayMoney;
	}
	public void setPayMoney(double payMoney) {
		PayMoney = payMoney;
	}
	public String getChannelNo() {
		return ChannelNo;
	}
	public void setChannelNo(String channelNo) {
		ChannelNo = channelNo;
	}
//	public static void main(String[] args) {
//		DecimalFormat df = new DecimalFormat("#");
//		System.out.println(df.format(NumberUtil.amtMult(111111197.11, 100)));
//	}
	public String getTradeChannel() {
		return TradeChannel;
	}
	public void setTradeChannel(String tradeChannel) {
		TradeChannel = tradeChannel;
	}
}
