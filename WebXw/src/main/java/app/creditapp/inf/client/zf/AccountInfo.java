package app.creditapp.inf.client.zf;

import app.creditapp.inf.client.IBody;

public class AccountInfo implements IBody{

	private String AccountNo;//�˻���
	private String AccountType;//�˻�����
	private String AccountName;//�ֿ�������
	private String ChannelNo;//֧��ϵͳ���������У����
	private String BankDetailNo;//���к�
	private String BankName;//����������
	private String Province;//����������ʡ
	private String City;//������������
	private String CVN2;//���ÿ�β��
	private String VALDATE;//���ÿ���Ч��
	private String PhoneNo;//�ֻ���
	private String Email;//email
	private String CertificateType;//֤������
	private String CertificateNo;//֤����
	
	@Override
	public String toXml() {
		StringBuffer s = new StringBuffer();
		
		s.append("<AccountInfo>");
		s.append("<AccountNo>");
		s.append(this.AccountNo==null?"":this.AccountNo);
		s.append("</AccountNo>");
		s.append("<AccountType>");
		s.append(this.AccountType==null?"":this.AccountType);
		s.append("</AccountType>");
		s.append("<AccountName>");
		s.append(this.AccountName==null?"":this.AccountName);
		s.append("</AccountName>");
		s.append("<ChannelNo>");
		s.append(this.ChannelNo==null?"":this.ChannelNo);
		s.append("</ChannelNo>");
		s.append("<BankDetailNo>");
		s.append(this.BankDetailNo==null?"":this.BankDetailNo);
		s.append("</BankDetailNo>");
		s.append("<BankName>");
		s.append(this.BankName==null?"":this.BankName);
		s.append("</BankName>");
		s.append("<Province>");
		s.append(this.Province==null?"":this.Province);
		s.append("</Province>");
		s.append("<City>");
		s.append(this.City==null?"":this.City);
		s.append("</City>");
		s.append("<CVN2>");
		s.append(this.CVN2==null?"":this.CVN2);
		s.append("</CVN2>");
		s.append("<VALDATE>");
		s.append(this.VALDATE==null?"":this.VALDATE);
		s.append("</VALDATE>");
		s.append("<PhoneNo>");
		s.append(this.PhoneNo==null?"":this.PhoneNo);
		s.append("</PhoneNo>");
		s.append("<Email>");
		s.append(this.Email==null?"":this.Email);
		s.append("</Email>");
		s.append("<CertificateType>");
		s.append(this.CertificateType==null?"":this.CertificateType);
		s.append("</CertificateType>");
		s.append("<CertificateNo>");
		s.append(this.CertificateNo==null?"":this.CertificateNo);
		s.append("</CertificateNo>");
		s.append("</AccountInfo>");
		return s.toString();
	}
	
	public String getAccountNo() {
		return AccountNo;
	}
	public void setAccountNo(String accountNo) {
		AccountNo = accountNo;
	}
	public String getAccountType() {
		return AccountType;
	}
	public void setAccountType(String accountType) {
		AccountType = accountType;
	}
	public String getAccountName() {
		return AccountName;
	}
	public void setAccountName(String accountName) {
		AccountName = accountName;
	}
	public String getChannelNo() {
		return ChannelNo;
	}
	public void setChannelNo(String channelNo) {
		ChannelNo = channelNo;
	}
	public String getBankDetailNo() {
		return BankDetailNo;
	}
	public void setBankDetailNo(String bankDetailNo) {
		BankDetailNo = bankDetailNo;
	}
	public String getBankName() {
		return BankName;
	}
	public void setBankName(String bankName) {
		BankName = bankName;
	}
	public String getProvince() {
		return Province;
	}
	public void setProvince(String province) {
		Province = province;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public String getCVN2() {
		return CVN2;
	}
	public void setCVN2(String cVN2) {
		CVN2 = cVN2;
	}
	public String getVALDATE() {
		return VALDATE;
	}
	public void setVALDATE(String vALDATE) {
		VALDATE = vALDATE;
	}
	public String getPhoneNo() {
		return PhoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		PhoneNo = phoneNo;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getCertificateType() {
		return CertificateType;
	}
	public void setCertificateType(String certificateType) {
		CertificateType = certificateType;
	}
	public String getCertificateNo() {
		return CertificateNo;
	}
	public void setCertificateNo(String certificateNo) {
		CertificateNo = certificateNo;
	}
	
	
}
