package app.creditapp.corp.entity;
public class RptCorpDaily {
	private String rptDate;//��������
	private String rptType;//��������01-�³�04-�µ�05-��
	private String brNo;//�����������
	private int cifNum;//�����
	private int lnCnt;//δ�������
	private double lnBal;//�������
	private double overBal;//�����������
	private double intstBal;//ǷϢ
	private double fineBal;//Ƿ��Ϣ
	private double mtrAmt;//���µ��ڱ���
	private double mtrIntst;//���µ�����Ϣ
	private int cntYear;//���귢�ű���
	private int cntMon;//���·��ű���
	private int cntDay;//���շ��ű���
	private int cntAvg;//�վ����ű���
	private double amtTot;//�۷Ž��
	private double amtYear;//�����۷�
	private double amtMon;//�����۷�
	private double amtDay;//�����۷�
	private double amtAvg;//�վ��ſ�
	private int repayDaycnt;//���ջ��ձ���
	private int repayMoncnt;//���»��ձ���
	private int repayYearcnt;//������ձ���
	private int repayTotcnt;//�ۼƻ��ձ���
	private int repayAvgcnt;//�վ����ձ���
	private double repayTot;//�ۼƻ��ձ���
	private double repayYear;//������ձ���
	private double repayMon;//���»��ձ���
	private double repayDay;//���ջ��ձ���
	private double intstTot;//�ۼƻ�����Ϣ
	private double intstYear;//���������Ϣ
	private double intstMon;//���»�����Ϣ
	private double intstDay;//���ջ�����Ϣ
	private double fineTot;//�ۼƻ��շ�Ϣ
	private double fineYear;//������շ�Ϣ
	private double fineMon;//���»��շ�Ϣ
	private double fineDay;//���ջ��շ�Ϣ
	private double repayAvg;//�վ����գ�����+��Ϣ��
	private double rebuyAmt;//�ۼƻع����
	private double compAmt;//�ۼƴ������
	private double passDayrate;//����ͨ����
	private double passMonrate;//����ͨ����
	private double failDayrate;//���տ�ʧ��
	private double failMonrate;//���¿�ʧ��
	public String getRptDate(){
		return rptDate;
	}

	public void setRptDate(String rptDate){
		this.rptDate = rptDate;
	}

	public String getRptType(){
		return rptType;
	}

	public void setRptType(String rptType){
		this.rptType = rptType;
	}

	public String getBrNo(){
		return brNo;
	}

	public void setBrNo(String brNo){
		this.brNo = brNo;
	}

	public int getCifNum(){
		return cifNum;
	}

	public void setCifNum(int cifNum){
		this.cifNum = cifNum;
	}

	public int getLnCnt(){
		return lnCnt;
	}

	public void setLnCnt(int lnCnt){
		this.lnCnt = lnCnt;
	}

	public double getLnBal(){
		return lnBal;
	}

	public void setLnBal(double lnBal){
		this.lnBal = lnBal;
	}

	public double getOverBal(){
		return overBal;
	}

	public void setOverBal(double overBal){
		this.overBal = overBal;
	}

	public double getIntstBal(){
		return intstBal;
	}

	public void setIntstBal(double intstBal){
		this.intstBal = intstBal;
	}

	public double getFineBal(){
		return fineBal;
	}

	public void setFineBal(double fineBal){
		this.fineBal = fineBal;
	}

	public double getMtrAmt(){
		return mtrAmt;
	}

	public void setMtrAmt(double mtrAmt){
		this.mtrAmt = mtrAmt;
	}

	public double getMtrIntst(){
		return mtrIntst;
	}

	public void setMtrIntst(double mtrIntst){
		this.mtrIntst = mtrIntst;
	}

	public int getCntYear(){
		return cntYear;
	}

	public void setCntYear(int cntYear){
		this.cntYear = cntYear;
	}

	public int getCntMon(){
		return cntMon;
	}

	public void setCntMon(int cntMon){
		this.cntMon = cntMon;
	}

	public int getCntDay(){
		return cntDay;
	}

	public void setCntDay(int cntDay){
		this.cntDay = cntDay;
	}

	public int getCntAvg(){
		return cntAvg;
	}

	public void setCntAvg(int cntAvg){
		this.cntAvg = cntAvg;
	}

	public double getAmtTot(){
		return amtTot;
	}

	public void setAmtTot(double amtTot){
		this.amtTot = amtTot;
	}

	public double getAmtYear(){
		return amtYear;
	}

	public void setAmtYear(double amtYear){
		this.amtYear = amtYear;
	}

	public double getAmtMon(){
		return amtMon;
	}

	public void setAmtMon(double amtMon){
		this.amtMon = amtMon;
	}

	public double getAmtDay(){
		return amtDay;
	}

	public void setAmtDay(double amtDay){
		this.amtDay = amtDay;
	}

	public double getAmtAvg(){
		return amtAvg;
	}

	public void setAmtAvg(double amtAvg){
		this.amtAvg = amtAvg;
	}

	public int getRepayDaycnt(){
		return repayDaycnt;
	}

	public void setRepayDaycnt(int repayDaycnt){
		this.repayDaycnt = repayDaycnt;
	}

	public int getRepayMoncnt(){
		return repayMoncnt;
	}

	public void setRepayMoncnt(int repayMoncnt){
		this.repayMoncnt = repayMoncnt;
	}

	public int getRepayYearcnt(){
		return repayYearcnt;
	}

	public void setRepayYearcnt(int repayYearcnt){
		this.repayYearcnt = repayYearcnt;
	}

	public int getRepayTotcnt(){
		return repayTotcnt;
	}

	public void setRepayTotcnt(int repayTotcnt){
		this.repayTotcnt = repayTotcnt;
	}

	public int getRepayAvgcnt(){
		return repayAvgcnt;
	}

	public void setRepayAvgcnt(int repayAvgcnt){
		this.repayAvgcnt = repayAvgcnt;
	}

	public double getRepayTot(){
		return repayTot;
	}

	public void setRepayTot(double repayTot){
		this.repayTot = repayTot;
	}

	public double getRepayYear(){
		return repayYear;
	}

	public void setRepayYear(double repayYear){
		this.repayYear = repayYear;
	}

	public double getRepayMon(){
		return repayMon;
	}

	public void setRepayMon(double repayMon){
		this.repayMon = repayMon;
	}

	public double getRepayDay(){
		return repayDay;
	}

	public void setRepayDay(double repayDay){
		this.repayDay = repayDay;
	}

	public double getIntstTot(){
		return intstTot;
	}

	public void setIntstTot(double intstTot){
		this.intstTot = intstTot;
	}

	public double getIntstYear(){
		return intstYear;
	}

	public void setIntstYear(double intstYear){
		this.intstYear = intstYear;
	}

	public double getIntstMon(){
		return intstMon;
	}

	public void setIntstMon(double intstMon){
		this.intstMon = intstMon;
	}

	public double getIntstDay(){
		return intstDay;
	}

	public void setIntstDay(double intstDay){
		this.intstDay = intstDay;
	}

	public double getFineTot(){
		return fineTot;
	}

	public void setFineTot(double fineTot){
		this.fineTot = fineTot;
	}

	public double getFineYear(){
		return fineYear;
	}

	public void setFineYear(double fineYear){
		this.fineYear = fineYear;
	}

	public double getFineMon(){
		return fineMon;
	}

	public void setFineMon(double fineMon){
		this.fineMon = fineMon;
	}

	public double getFineDay(){
		return fineDay;
	}

	public void setFineDay(double fineDay){
		this.fineDay = fineDay;
	}

	public double getRepayAvg(){
		return repayAvg;
	}

	public void setRepayAvg(double repayAvg){
		this.repayAvg = repayAvg;
	}

	public double getRebuyAmt(){
		return rebuyAmt;
	}

	public void setRebuyAmt(double rebuyAmt){
		this.rebuyAmt = rebuyAmt;
	}

	public double getCompAmt(){
		return compAmt;
	}

	public void setCompAmt(double compAmt){
		this.compAmt = compAmt;
	}

	public double getPassDayrate(){
		return passDayrate;
	}

	public void setPassDayrate(double passDayrate){
		this.passDayrate = passDayrate;
	}

	public double getPassMonrate(){
		return passMonrate;
	}

	public void setPassMonrate(double passMonrate){
		this.passMonrate = passMonrate;
	}

	public double getFailDayrate(){
		return failDayrate;
	}

	public void setFailDayrate(double failDayrate){
		this.failDayrate = failDayrate;
	}

	public double getFailMonrate(){
		return failMonrate;
	}

	public void setFailMonrate(double failMonrate){
		this.failMonrate = failMonrate;
	}


}
