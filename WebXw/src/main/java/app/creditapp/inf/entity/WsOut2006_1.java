package app.creditapp.inf.entity;

import java.util.List;


/**
 * @���� DHCC-LIU
 * @���� Jun 23, 2016
 * @����   Ԥ�������β�ѯ---���ʵ����
 * <List>
 */
public class WsOut2006_1 {
	private String  appId;    //�����
	private String  brNo;     //����������
	private String  prePactNo;   //Ԥ����ID
	private String  custName; //�ͻ�����
	private String  idType;	  //֤������
	private String  idNo;     //֤������
	private String  custType; //�ͻ�����
	private String  sex;	  //�Ա�
	private String  birth;	  //��������
	private String  marriage; //����״��
	private String  children; //�Ƿ�����Ů
	private String  edu;	  //���ѧ��
	private String  degree;	  //���ѧλ
	private String  telNo;	  //��ϵ�绰
	private String  phoneNo;  //�ֻ�����
	private String  postCode; //ͨѶ�ʱ�
	private String  postAddr; //ͨѶ��ַ
	private String  homeArea; //����������
	private String  homeTel;  //סլ�绰
	private String  homeCode; //סլ�ʱ�
	private String  homeAddr; //סլ��ַ
	private String  homeSts;  //��ס״��
	private double  income;   //�����루Ԫ��
	private String  mateName; //��ż��Ϣ
	private String  mateIdtype;//��ż֤������
	private String  mateIdno;  //��ż֤������
	private String  mateWork;  //��ż������λ
	private String  mateTel;   //��ż��ϵ�绰
	private String  projNo;    //������Ŀ���
	private String  prdtNo;    //��Ʒ��
	private double  pactAmt;   //��ͬ���
	private double  feeTotal;  //�������ܶ�
	private double  lnRate;    //����(��)
	private String  appArea;   //����ص�
	private String  appUse;    //������;
	private int     termMon;   //��ͬ����(��)
	private int     termDay;   //��ͬ����(��)
	private String  vouType;   //������ʽ
	private String  endDate;   //��������
	private String  payType;   //�ۿ�������
	private Integer payDay;	   //�ۿ�����
	private String  workType;  //ְҵ
	private String  workName;  //������λ����
	private String  workWay;   //������λ������ҵ
	private String  workCode;  //������λ�ʱ�
	private String  workAddr;  //������λ��ַ
	private String  workDuty;  //ְ��
	private String  workTitle; //ְ��
	private String  workYear;  //������ʼ���
	private String  ifCar;     //�Ƿ��г�
	private String  ifCarCred; //�Ƿ��а��Ҵ���
	private String  ifRoom;    //�Ƿ��з�
	private String  ifMort;    //�Ƿ��а��ҷ���
	private String  ifCard;    //�Ƿ��д��ǿ�
	private double  cardAmt;   //���ǿ���Ͷ��
	private String  ifApp;     //�Ƿ�����д�����
	private String  ifId;      //�Ƿ������֤��Ϣ
	private String  ifPact;    //�Ƿ���ǩ����ͬ
	private String  appRersult;//������
	private String  appDesc;   //����˵��
	private String workSts; //����״̬
	
	
	public String getWorkSts() {
		return workSts;
	}
	public void setWorkSts(String workSts) {
		this.workSts = workSts;
	}
	/*listGage*/
	private List<WsOut2006_1_1> listGage;

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	

	public List<WsOut2006_1_1> getListGage() {
		return listGage;
	}

	public void setListGage(List<WsOut2006_1_1> listGage) {
		this.listGage = listGage;
	}

	public String getBrNo() {
		return brNo;
	}

	public void setBrNo(String brNo) {
		this.brNo = brNo;
	}

	public String getPrePactNo() {
		return prePactNo;
	}

	public void setPrePactNo(String prePactNo) {
		this.prePactNo = prePactNo;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getIdType() {
		return idType;
	}

	public void setIdType(String idType) {
		this.idType = idType;
	}

	public String getIdNo() {
		return idNo;
	}

	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}

	public String getCustType() {
		return custType;
	}

	public void setCustType(String custType) {
		this.custType = custType;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getMarriage() {
		return marriage;
	}

	public void setMarriage(String marriage) {
		this.marriage = marriage;
	}

	public String getChildren() {
		return children;
	}

	public void setChildren(String children) {
		this.children = children;
	}

	public String getEdu() {
		return edu;
	}

	public void setEdu(String edu) {
		this.edu = edu;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getTelNo() {
		return telNo;
	}

	public void setTelNo(String telNo) {
		this.telNo = telNo;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getPostAddr() {
		return postAddr;
	}

	public void setPostAddr(String postAddr) {
		this.postAddr = postAddr;
	}

	public String getHomeArea() {
		return homeArea;
	}

	public void setHomeArea(String homeArea) {
		this.homeArea = homeArea;
	}

	public String getHomeTel() {
		return homeTel;
	}

	public void setHomeTel(String homeTel) {
		this.homeTel = homeTel;
	}

	public String getHomeCode() {
		return homeCode;
	}

	public void setHomeCode(String homeCode) {
		this.homeCode = homeCode;
	}

	public String getHomeAddr() {
		return homeAddr;
	}

	public void setHomeAddr(String homeAddr) {
		this.homeAddr = homeAddr;
	}

	public String getHomeSts() {
		return homeSts;
	}

	public void setHomeSts(String homeSts) {
		this.homeSts = homeSts;
	}

	public double getIncome() {
		return income;
	}

	public void setIncome(double income) {
		this.income = income;
	}

	public String getMateName() {
		return mateName;
	}

	public void setMateName(String mateName) {
		this.mateName = mateName;
	}

	public String getMateIdtype() {
		return mateIdtype;
	}

	public void setMateIdtype(String mateIdtype) {
		this.mateIdtype = mateIdtype;
	}

	public String getMateIdno() {
		return mateIdno;
	}

	public void setMateIdno(String mateIdno) {
		this.mateIdno = mateIdno;
	}

	public String getMateWork() {
		return mateWork;
	}

	public void setMateWork(String mateWork) {
		this.mateWork = mateWork;
	}

	public String getMateTel() {
		return mateTel;
	}

	public void setMateTel(String mateTel) {
		this.mateTel = mateTel;
	}

	public String getProjNo() {
		return projNo;
	}

	public void setProjNo(String projNo) {
		this.projNo = projNo;
	}

	public String getPrdtNo() {
		return prdtNo;
	}

	public void setPrdtNo(String prdtNo) {
		this.prdtNo = prdtNo;
	}

	public double getPactAmt() {
		return pactAmt;
	}

	public void setPactAmt(double pactAmt) {
		this.pactAmt = pactAmt;
	}

	public double getFeeTotal() {
		return feeTotal;
	}

	public void setFeeTotal(double feeTotal) {
		this.feeTotal = feeTotal;
	}

	public double getLnRate() {
		return lnRate;
	}

	public void setLnRate(double lnRate) {
		this.lnRate = lnRate;
	}

	public String getAppArea() {
		return appArea;
	}

	public void setAppArea(String appArea) {
		this.appArea = appArea;
	}

	public String getAppUse() {
		return appUse;
	}

	public void setAppUse(String appUse) {
		this.appUse = appUse;
	}

	public int getTermMon() {
		return termMon;
	}

	public void setTermMon(int termMon) {
		this.termMon = termMon;
	}

	public int getTermDay() {
		return termDay;
	}

	public void setTermDay(int termDay) {
		this.termDay = termDay;
	}

	public String getVouType() {
		return vouType;
	}

	public void setVouType(String vouType) {
		this.vouType = vouType;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getPayType() {
		return payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}

	public Integer getPayDay() {
		return payDay;
	}

	public void setPayDay(Integer payDay) {
		this.payDay = payDay;
	}

	public String getWorkType() {
		return workType;
	}

	public void setWorkType(String workType) {
		this.workType = workType;
	}

	public String getWorkName() {
		return workName;
	}

	public void setWorkName(String workName) {
		this.workName = workName;
	}

	public String getWorkWay() {
		return workWay;
	}

	public void setWorkWay(String workWay) {
		this.workWay = workWay;
	}

	public String getWorkCode() {
		return workCode;
	}

	public void setWorkCode(String workCode) {
		this.workCode = workCode;
	}

	public String getWorkAddr() {
		return workAddr;
	}

	public void setWorkAddr(String workAddr) {
		this.workAddr = workAddr;
	}

	public String getWorkDuty() {
		return workDuty;
	}

	public void setWorkDuty(String workDuty) {
		this.workDuty = workDuty;
	}

	public String getWorkTitle() {
		return workTitle;
	}

	public void setWorkTitle(String workTitle) {
		this.workTitle = workTitle;
	}

	public String getWorkYear() {
		return workYear;
	}

	public void setWorkYear(String workYear) {
		this.workYear = workYear;
	}

	public String getIfCar() {
		return ifCar;
	}

	public void setIfCar(String ifCar) {
		this.ifCar = ifCar;
	}

	public String getIfCarCred() {
		return ifCarCred;
	}

	public void setIfCarCred(String ifCarCred) {
		this.ifCarCred = ifCarCred;
	}

	public String getIfRoom() {
		return ifRoom;
	}

	public void setIfRoom(String ifRoom) {
		this.ifRoom = ifRoom;
	}

	public String getIfMort() {
		return ifMort;
	}

	public void setIfMort(String ifMort) {
		this.ifMort = ifMort;
	}

	public String getIfCard() {
		return ifCard;
	}

	public void setIfCard(String ifCard) {
		this.ifCard = ifCard;
	}

	public double getCardAmt() {
		return cardAmt;
	}

	public void setCardAmt(double cardAmt) {
		this.cardAmt = cardAmt;
	}

	public String getIfApp() {
		return ifApp;
	}

	public void setIfApp(String ifApp) {
		this.ifApp = ifApp;
	}

	public String getIfId() {
		return ifId;
	}

	public void setIfId(String ifId) {
		this.ifId = ifId;
	}

	public String getIfPact() {
		return ifPact;
	}

	public void setIfPact(String ifPact) {
		this.ifPact = ifPact;
	}

	public String getAppRersult() {
		return appRersult;
	}

	public void setAppRersult(String appRersult) {
		this.appRersult = appRersult;
	}

	public String getAppDesc() {
		return appDesc;
	}

	public void setAppDesc(String appDesc) {
		this.appDesc = appDesc;
	}

	

	
}
