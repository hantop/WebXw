package app.creditapp.inf.client.zf;

import app.creditapp.inf.client.IBody;


public class SourceAccountInfo implements IBody{
	
	
	private String Level;//���ȼ�
	
	private AccountInfo accountInfo;//�˻���Ϣ
	
	@Override
	public String toXml() {
		StringBuffer s = new StringBuffer();
		s.append("<SourceAccountInfo>");
		s.append("<Level>");
		s.append(this.Level==null?"":this.Level);
		s.append("</Level>");
		s.append(accountInfo.toXml());
		s.append("</SourceAccountInfo>");
		
		return s.toString();
	}

	public String getLevel() {
		return Level;
	}

	public void setLevel(String level) {
		Level = level;
	}

	public AccountInfo getAccountInfo() {
		return accountInfo;
	}

	public void setAccountInfo(AccountInfo accountInfo) {
		this.accountInfo = accountInfo;
	}
	
	
}