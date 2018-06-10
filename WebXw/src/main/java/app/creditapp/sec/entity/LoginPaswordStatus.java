package app.creditapp.sec.entity;

public enum LoginPaswordStatus {
	
	SUCCESS("��¼�ɹ�"),
	FAIL("��¼ʧ��"),
	OVER_TIME("��ǰ����ʹ��ʱ���Ѿ���������%d��,��Ҫ�����趨����"),
	VALIDATE_FAIL("������֤ʧ��"),
	NEED_CHANGE_PASSWORD("�����״ε�¼����Ҫ������������"),
	OVER_FAULT_TOLE("���ۼ������������Ѿ������ݴ����%d�Σ��������Ա��ϵ");
	
	private final String message;
	private int time = 0;
	
	LoginPaswordStatus(String message){
		this.time = 0;
		this.message = message;
	}
	
	public String showMessage(int time){
		return String.format(message, time);
	}
	
	public String showMessage(){
		return showMessage(this.time);
	}
	
	public LoginPaswordStatus changeTime(int time){
		this.time = time;
		return this;
	}
	
	public static void main(String[] args) {
		String str  = LoginPaswordStatus.OVER_FAULT_TOLE.changeTime(5).showMessage();
		System.out.println(str);
	}
}
