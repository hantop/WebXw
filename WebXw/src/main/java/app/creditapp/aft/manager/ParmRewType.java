package app.creditapp.aft.manager;

public enum ParmRewType {
	Cash_Not_Suff_Funds("100016","�ʽ��ֽ��˻�����"),
	Vuser_Not_Suff_Funds("100014","��Ŀ���⻧����Ԥ��"),
	Cash_Due_Audit("100015","������������"),
	Entrust_Collection("100000","ί�����Ԥ��"),
	Suser_Not_Suff_Funds("100001","��Ŀר������Ԥ��"),
	Proj_Overdue_Rate("100002","��Ŀ������Ԥ��"),
	Payback_Datum_Not_Upload("100003","����ƻ�δ�ϴ�Ԥ��"),
	Loanbefore_Datum_Not_Upload("100004","��ǰ����δ�ϴ�Ԥ��"),
	Image_Datum_Not_Upload("100005","Ӱ������δ�ϴ�����"),
	Funds_Due_Settlement("100006","�ʽ��ڽ�ϢԤ��"),
	Funds_Due_Exchange("100007","�ʽ��ڶҸ�����"),
	Proj_Overdue_Payback("100008","��Ŀ���ڻ�������"),
	Strike_Balance_Succ("100009","�����������"),
	Guar_Release("100010","ѺƷ��Ѻ����"),
	Pending_Approval("100011","��������������"),
	Buyback_Differ("100012","�ع���Ϣ���˲�������"),
	Split_Bill_Fail("100013","����ʧ��Ԥ��"),
	Proj_compensatory_Rate("100017","��Ŀ������Ԥ��"),
	Proj_buy_back_Rate("100018","��Ŀ�ع���Ԥ��"),
	Real_time_transaction_Rate("100019","ʵʱ����Ԥ��");
	
	
	private String rewName;
	private String rewNo;
	private ParmRewType(String rewNo,String rewName){
		this.rewName = rewName;
		this.rewNo = rewNo;
	}
	public String getRewName() {
		return rewName;
	}
	public void setRewName(String rewName) {
		this.rewName = rewName;
	}
	public String getRewNo() {
		return rewNo;
	}
	public void setRewNo(String rewNo) {
		this.rewNo = rewNo;
	}
	
	public static ParmRewType getByRewNo(String rewNo){
		for(ParmRewType type:values()){
			if(type.getRewNo().equals(rewNo))return type;
		}
		return null;
	}
}
