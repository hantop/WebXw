package app.base.quartz.job.test;

import java.util.Date;

public class DoMyWork {
	public void doWork(){
		System.out.println("��ȥ�ɻ��ȥ�ɻ��ȥ�ɻ����棡������"+new Date().toString());
	}
	
	public void doWork2(String name,int number){
		System.out.println("�����������֣�"+name+",�����������֣�"+number);
	}
}
