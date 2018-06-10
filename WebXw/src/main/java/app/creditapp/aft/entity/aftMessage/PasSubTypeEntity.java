package app.creditapp.aft.entity.aftMessage;

import com.opensymphony.xwork2.conversion.TypeConversionException;

public enum PasSubTypeEntity {
	RewPactMessage(1,"1","101","ҵ����Ϣ����"),
	RewPactAlert(2,"2","201","ҵ�����Ԥ��"),
	RewProjMessage(3,"1","102","��Ŀ��Ϣ����"),
	RewProjAlert(4,"2","202","��Ŀ����Ԥ��"),
	RewFundMessage(5,"1","103","�ʽ���Ϣ����"),
	RewFundAlert(6,"2","203","�ʽ���ϢԤ��"),
	ToApproveWork(7,"3","301","������ҵ��"),
	CashNoEffectWork(8,"3","302","�ʽ�δ��Ч����"),
	RewRealMessage(9,"1","104","ʵʱ��Ϣ����"),
	RewRealAlert(10,"2","204","ʵʱ��ϢԤ��"),
	OtherWork(0,"0","000","��������");
	
	private int seqNo;
	private String subTypeNo;
	private String showName;
	private String bigTypeNo;
	
	private PasSubTypeEntity(int seqNo,String bigTypeNo,String subTypeNo,String showName){
		this.seqNo = seqNo;
		this.showName = showName;
		this.subTypeNo = subTypeNo;
	}
	
	public static PasSubTypeEntity getTypeNameByNo(String subTypeNo){
		for(PasSubTypeEntity type:values()){
			if(type.getSubTypeNo().equals(subTypeNo))return type;
		}
		throw new TypeConversionException("ӳ����������ƥ�䲻��ȷ");
	}
	
	public static PasSubTypeEntity getTypeBySeqNo(int typeSeqNo){
		for(PasSubTypeEntity type:values()){
			if(type.getSeqNo() == typeSeqNo)return type;
		}
		throw new TypeConversionException("�޷���������ҵ���Ӧ������");
	}
	
	public int getSeqNo() {
		return seqNo;
	}

	public String getSubTypeNo() {
		return subTypeNo;
	}

	public String getShowName() {
		return showName;
	}

	public String getBigTypeNo() {
		return bigTypeNo;
	}
}
