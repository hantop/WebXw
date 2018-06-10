package app.creditapp.inf.entity;

import java.util.List;

/**
 * @���� DHCC-LIU
 * @���� Jun 23, 2016 list
 * @���� ������������--����ʵ���� LN_APPLY_MID
 */
public class WsIn2101_1 {
	
	private String pactNo;// ��ͬ����
	private String custName;// �ͻ�����
	private String idType;// ֤������
	private String idNo;// ֤������
	private String custType;// �ͻ�����
	private String sex;// �Ա�
	private String birth;// ��������
	private String marriage;// ����״��
	private String children;// �Ƿ�����Ů
	private String edu;// ���ѧ��
	private String degree;// ���ѧλ
	private String telNo;// ��ϵ�绰
	private String phoneNo;// �ֻ�����
	private String postCode;// ͨѶ�ʱ�
	private String postAddr;// ͨѶ��ַ
	private String homeArea;// ����������
	private String homeTel;// סլ�绰
	private String homeCode;// סլ�ʱ�
	private String homeAddr;// סլ��ַ
	private String homeSts;// ��ס״��
	private double income;// �����루Ԫ��
	private String mateName;// ��ż����
	private String mateIdtype;// ��ż֤������
	private String mateIdno;// ��ż֤������
	private String mateWork;// ��ż������λ
	private String mateTel;// ��ż��ϵ�绰
	private String projNo;// ������Ŀ���
	private String prdtNo;// ��Ʒ��
	private double pactAmt;// ��ͬ���
	private double feeTotal;// �������ܶ�
	private double lnRate;// ���ʣ��£�
	private double lnRateYear;// ���ʣ��꣩
	private String appArea;// ����ص�
	private String appUse;// ������;
	private int    termMon;// ��ͬ���ޣ��£�
	private int    termDay;// ��ͬ���ޣ��գ�
	private String vouType;// ������ʽ
	private String endDate;// ��������
	private String payType;// �ۿ�������
	private Integer  payDay;// �ۿ�����
	private String workType;// ְҵ
	private String workName;// ������λ����
	private String workWay;// ������λ������ҵ
	private String workCode;// ������λ�ʱ�
	private String workAddr;// ������λ��ַ
	private String workDuty;// ְ��
	private String workTitle;// ְ��
	private String workYear;// ������ʼ���
	private String ifCar;// �Ƿ��г�
	private String ifCarCred;// �Ƿ��а��ҳ���
	private String ifRoom;// �Ƿ��з�
	private String ifMort;// �Ƿ��а��ҷ���
	private String ifCard;// �Ƿ��д��ǿ�
	private double cardAmt;// ���ǿ���Ͷ��
	private String ifApp;// �Ƿ���д�����
	private String ifId;// �Ƿ������֤��Ϣ
	private String ifPact;// �Ƿ���ǩ����ͬ
	private String cardChn;// �Ƿ���ǩ����ͬ
	
	//���
	private String appId;//����ID
	private String batchNo;//���κ���
	private String brNo; //������������
	private String appDate;//��������
	private String pactXt;//���к�ͬ���
	private String brAccType;//������������[A/B]
	private String lnType;//��������
	private String curNo;//�������
	private String appAmt;//������
	private String overRate;//��Ϣ����
	private String damRate;//��ǰ����ΥԼ�����
	private String repayType;//���ʽ
	private String begDate;//�ſ�����
	private String payKind;//�ۿ�����𡢻���Ƶ��
	private String feeType;//�ɷѷ�ʽ
	private String payMent;//֧����ʽ[01����02����]
	private String vouDays;//���е�������
	private String feeRate;//��������
	private String feeAmt;//������
	private String srvRate;//�������
	private String srvAmt;//�����
	private String vouRate;//��������
	private double vouAmt;//������
	private String feeAmt1;//������1
	private String feeAmt2;//������2
	private String feeAmt3;//������3
	private String feeAmt4;//������4
	private String feeAmt5;//������5
	private String ifItp;//�Ƿ����
	private String ifAuth;//�Ƿ��в�֤��Ȩ�ļ�
	private String ifFlag;//���ñ�־
	private String appSts;//����״̬[01δ����02�Ѵ���]
	private String chkRes;//ɸ����[00δɸ��01�ɹ�02�ļ�����03�ֶδ���04�������ͻ�05�����ܾ�06�����ܾ�07�ظ�����08��ż��Ϣ������09�������������Ч10������Ŀ�����Ч�����������������Ų���11��Ʒ�Ų����ڻ�����Ч12������ѺƷ��Ϣ13ѺƷ��Ѻ��ֵ����14�˻���Ϣ������15�˻��ſ����ܺͲ����ں�ͬ���99��������]
	private String chkDesc;//ɸ��������
	private String txDate;//�Ǽ�ʱ��
	private String prePactNo;//�Ǽ�ʱ��
	private String czPactNo;//�Ǽ�ʱ��
	private String workSts; //����״̬
	private String args; //����
	
	
	public double getLnRateYear() {
		return lnRateYear;
	}
	public void setLnRateYear(double lnRateYear) {
		this.lnRateYear = lnRateYear;
	}
	public String getWorkSts() {
		return workSts;
	}
	public void setWorkSts(String workSts) {
		this.workSts = workSts;
	}
	private List<WsIn2101_1_1> listAc; //listAc
	private List<WsIn2101_1_2> listGage; //listGage
	private List<WsIn2101_1_3> listCom; //listCom
	private List<WsIn2101_1_4> listRel; //listRel
	
	
	public String getPactNo() {
		return pactNo;
	}
	public void setPactNo(String pactNo) {
		this.pactNo = pactNo;
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
	public List<WsIn2101_1_1> getListAc() {
		return listAc;
	}
	public void setListAc(List<WsIn2101_1_1> listAc) {
		this.listAc = listAc;
	}
	public List<WsIn2101_1_2> getListGage() {
		return listGage;
	}
	public void setListGage(List<WsIn2101_1_2> listGage) {
		this.listGage = listGage;
	}
	public List<WsIn2101_1_3> getListCom() {
		return listCom;
	}
	public void setListCom(List<WsIn2101_1_3> listCom) {
		this.listCom = listCom;
	}
	public List<WsIn2101_1_4> getListRel() {
		return listRel;
	}
	public void setListRel(List<WsIn2101_1_4> listRel) {
		this.listRel = listRel;
	}
	public String getAppId() {
		return appId;
	}
	public void setAppId(String appId) {
		this.appId = appId;
	}
	public String getBatchNo() {
		return batchNo;
	}
	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}
	public String getBrNo() {
		return brNo;
	}
	public void setBrNo(String brNo) {
		this.brNo = brNo;
	}
	public String getAppDate() {
		return appDate;
	}
	public void setAppDate(String appDate) {
		this.appDate = appDate;
	}
	public String getPactXt() {
		return pactXt;
	}
	public void setPactXt(String pactXt) {
		this.pactXt = pactXt;
	}
	public String getBrAccType() {
		return brAccType;
	}
	public void setBrAccType(String brAccType) {
		this.brAccType = brAccType;
	}
	public String getLnType() {
		return lnType;
	}
	public void setLnType(String lnType) {
		this.lnType = lnType;
	}
	public String getCurNo() {
		return curNo;
	}
	public void setCurNo(String curNo) {
		this.curNo = curNo;
	}
	public String getAppAmt() {
		return appAmt;
	}
	public void setAppAmt(String appAmt) {
		this.appAmt = appAmt;
	}
	public String getOverRate() {
		return overRate;
	}
	public void setOverRate(String overRate) {
		this.overRate = overRate;
	}
	public String getDamRate() {
		return damRate;
	}
	public void setDamRate(String damRate) {
		this.damRate = damRate;
	}
	public String getRepayType() {
		return repayType;
	}
	public void setRepayType(String repayType) {
		this.repayType = repayType;
	}
	public String getBegDate() {
		return begDate;
	}
	public void setBegDate(String begDate) {
		this.begDate = begDate;
	}
	public String getPayKind() {
		return payKind;
	}
	public void setPayKind(String payKind) {
		this.payKind = payKind;
	}
	public String getFeeType() {
		return feeType;
	}
	public void setFeeType(String feeType) {
		this.feeType = feeType;
	}
	public String getPayMent() {
		return payMent;
	}
	public void setPayMent(String payMent) {
		this.payMent = payMent;
	}
	public String getVouDays() {
		return vouDays;
	}
	public void setVouDays(String vouDays) {
		this.vouDays = vouDays;
	}
	public String getFeeRate() {
		return feeRate;
	}
	public void setFeeRate(String feeRate) {
		this.feeRate = feeRate;
	}
	public String getFeeAmt() {
		return feeAmt;
	}
	public void setFeeAmt(String feeAmt) {
		this.feeAmt = feeAmt;
	}
	public String getSrvRate() {
		return srvRate;
	}
	public void setSrvRate(String srvRate) {
		this.srvRate = srvRate;
	}
	public String getSrvAmt() {
		return srvAmt;
	}
	public void setSrvAmt(String srvAmt) {
		this.srvAmt = srvAmt;
	}
	public String getVouRate() {
		return vouRate;
	}
	public void setVouRate(String vouRate) {
		this.vouRate = vouRate;
	}
	
	public double getVouAmt() {
		return vouAmt;
	}
	public void setVouAmt(double vouAmt) {
		this.vouAmt = vouAmt;
	}
	public String getFeeAmt1() {
		return feeAmt1;
	}
	public void setFeeAmt1(String feeAmt1) {
		this.feeAmt1 = feeAmt1;
	}
	public String getFeeAmt2() {
		return feeAmt2;
	}
	public void setFeeAmt2(String feeAmt2) {
		this.feeAmt2 = feeAmt2;
	}
	public String getFeeAmt3() {
		return feeAmt3;
	}
	public void setFeeAmt3(String feeAmt3) {
		this.feeAmt3 = feeAmt3;
	}
	public String getFeeAmt4() {
		return feeAmt4;
	}
	public void setFeeAmt4(String feeAmt4) {
		this.feeAmt4 = feeAmt4;
	}
	public String getFeeAmt5() {
		return feeAmt5;
	}
	public void setFeeAmt5(String feeAmt5) {
		this.feeAmt5 = feeAmt5;
	}
	public String getIfItp() {
		return ifItp;
	}
	public void setIfItp(String ifItp) {
		this.ifItp = ifItp;
	}
	public String getIfAuth() {
		return ifAuth;
	}
	public void setIfAuth(String ifAuth) {
		this.ifAuth = ifAuth;
	}
	public String getIfFlag() {
		return ifFlag;
	}
	public void setIfFlag(String ifFlag) {
		this.ifFlag = ifFlag;
	}
	public String getAppSts() {
		return appSts;
	}
	public void setAppSts(String appSts) {
		this.appSts = appSts;
	}
	public String getChkRes() {
		return chkRes;
	}
	public void setChkRes(String chkRes) {
		this.chkRes = chkRes;
	}
	public String getChkDesc() {
		return chkDesc;
	}
	public void setChkDesc(String chkDesc) {
		this.chkDesc = chkDesc;
	}
	public String getTxDate() {
		return txDate;
	}
	public void setTxDate(String txDate) {
		this.txDate = txDate;
	}
	public String getPrePactNo() {
		return prePactNo;
	}
	public void setPrePactNo(String prePactNo) {
		this.prePactNo = prePactNo;
	}
	public String getCzPactNo() {
		return czPactNo;
	}
	public void setCzPactNo(String czPactNo) {
		this.czPactNo = czPactNo;
	}
	public String getCardChn() {
		return cardChn;
	}
	public void setCardChn(String cardChn) {
		this.cardChn = cardChn;
	}
	public String getArgs() {
		return args;
	}
	public void setArgs(String args) {
		this.args = args;
	}

	
}
