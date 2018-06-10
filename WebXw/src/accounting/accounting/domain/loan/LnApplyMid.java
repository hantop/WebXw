package accounting.domain.loan;
/**
* Title: LnApplyMid.java
* Description:
* @���� su
* @���� 2018-3-20
* @version��1.0
**/
public class LnApplyMid extends accounting.domain.sys.CMISDomain {

	private String batchNo;//���κ���
	private String appId;//����ID
	private String cardChn;//�����˻�����[CL0001	��LnPact.java��֧��CL0002	������]
	private String brNo;//������������
	private String pactNo;//��ͬ���
	private String appDate;//��������
	private String pactXt;//���к�ͬ���
	private String brAccType;//������������[A/B]
	private String cifName;//�ͻ�����
	private String idType;//֤������
	private String idNo;//֤������
	private String cifType;//�ͻ�����[01-ũ��02-��н03-���幤�̻�04-ѧ��]
	private String sex;//�Ա�
	private String birthDay;//��������
	private String marriage;//����״��
	private String children;//�Ƿ�����Ů
	private String edu;//���ѧ��
	private String degree;//���ѧλ
	private Double income;//�����루Ԫ��
	private String commTel;//��ϵ�绰
	private String phoneNo;//�ֻ�����
	private String commCode;//ͨѶ�ʱ�
	private String commAddr;//ͨѶ��ַ
	private String cifArea;//��������
	private String resTel;//סլ�绰
	private String resCode;//סլ�ʱ�
	private String resAddr;//סլ��ַ
	private String resSts;//��ס״��
	private String workType;//ְҵ
	private String corpName;//������λ����
	private String corpWay;//������λ������ҵ
	private String corpCode;//������λ�ʱ�
	private String corpAddr;//������λ��ַ
	private String duty;//ְ��
	private String title;//ְ��
	private String workYear;//������ʼ���
	private String mateName;//��ż����
	private String mateIdtype;//��ż֤������
	private String mateIdno;//��ż֤������
	private String mateWork;//��ż������λ
	private String mateTel;//��ż��ϵ�绰
	private String projNo;//������Ŀ���
	private String prdtNo;//��Ʒ��
	private String lnType;//��������
	private String curNo;//�������
	private Double appAmt;//������
	private Double pactAmt;//��ͬ���
	private Double lnRate;//���ʣ��£�
	private Double overRate;//��Ϣ���ʣ��£�
	private Double damRate;//��ǰ����ΥԼ�����
	private String appArea;//����ص�
	private String lnUse;//������;
	private String repayType;//���ʽ
	private Integer termMon;//�������ޣ��£�
	private Integer termDay;//�������ޣ��գ�
	private String vouType;//������ʽ
	private String begDate;//�ſ�����
	private String endDate;//��������
	private String payType;//�ۿ�������
	private String payKind;//�ۿ�����𡢻���Ƶ��
	private Integer payDay;//�ۿ���
	private String feeType;//�ɷѷ�ʽ
	private String payMent;//֧����ʽ[01����02����]
	private Integer vouDays;//���е�������
	private Double feeTotal;//�������ܶ�
	private Double feeRate;//��������
	private Double feeAmt;//������
	private Double srvRate;//�������
	private Double srvAmt;//�����
	private Double vouRate;//��������
	private Double vouAmt;//������
	private Double feeAmt1;//����һ
	private Double feeAmt2;//���ö�
	private Double feeAmt3;//������
	private Double feeAmt4;//������
	private Double feeAmt5;//������
	private String ifItp;//�Ƿ����
	private String ifApp;//�Ƿ���д�����
	private String ifId;//�Ƿ������֤��Ϣ
	private String ifAuth;//�Ƿ��в�֤��Ȩ�ļ�
	private String ifPact;//�Ƿ���ǩ����ͬ
	private String ifCar;//�Ƿ��г�
	private String ifCarcred;//�Ƿ��а��ҳ���
	private String ifRoom;//�Ƿ��з�
	private String ifMort;//�Ƿ��а��ҷ���
	private String ifCard;//�Ƿ��д��ǿ�
	private Double cardAmt;//���ǿ���Ͷ��
	private String ifFlag;//���ñ�־[]
	private String appSts;//����״̬[01δ����02�Ѵ���]
	private String chkRes;//ɸ����[00δɸ��01�ɹ�02�ļ�����03�ֶδ���04�������ͻ�05�����ܾ�06�����ܾ�07�ظ�����08��ż��Ϣ������09�������������Ч10������Ŀ�����Ч�����������������Ų���11��Ʒ�Ų����ڻ�����Ч12������ѺƷ��Ϣ13ѺƷ��Ѻ��ֵ����14�˻���Ϣ������15�˻��ſ����ܺͲ����ں�ͬ���16�Զ��������17�����������˻���Ϣ18����������������Ϣ19��Ʒ�������չҵ���������������ص�99��������]
	private String chkDesc;//ɸ��������[�Զ����������Ϊ�������]
	private String txDate;//�Ǽ�ʱ��
	private String prePactNo;//Ԥ����ID
	private String czPactNo;//������ˮ��
	private String workSts;//����״̬ 01��ְ02������
	public String getBatchNo() {
		return batchNo;
	}
	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}
	public String getAppId() {
		return appId;
	}
	public void setAppId(String appId) {
		this.appId = appId;
	}
	public String getCardChn() {
		return cardChn;
	}
	public void setCardChn(String cardChn) {
		this.cardChn = cardChn;
	}
	public String getBrNo() {
		return brNo;
	}
	public void setBrNo(String brNo) {
		this.brNo = brNo;
	}
	public String getPactNo() {
		return pactNo;
	}
	public void setPactNo(String pactNo) {
		this.pactNo = pactNo;
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
	public String getCifName() {
		return cifName;
	}
	public void setCifName(String cifName) {
		this.cifName = cifName;
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
	public String getCifType() {
		return cifType;
	}
	public void setCifType(String cifType) {
		this.cifType = cifType;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
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
	public Double getIncome() {
		return income;
	}
	public void setIncome(Double income) {
		this.income = income;
	}
	public String getCommTel() {
		return commTel;
	}
	public void setCommTel(String commTel) {
		this.commTel = commTel;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getCommCode() {
		return commCode;
	}
	public void setCommCode(String commCode) {
		this.commCode = commCode;
	}
	public String getCommAddr() {
		return commAddr;
	}
	public void setCommAddr(String commAddr) {
		this.commAddr = commAddr;
	}
	public String getCifArea() {
		return cifArea;
	}
	public void setCifArea(String cifArea) {
		this.cifArea = cifArea;
	}
	public String getResTel() {
		return resTel;
	}
	public void setResTel(String resTel) {
		this.resTel = resTel;
	}
	public String getResCode() {
		return resCode;
	}
	public void setResCode(String resCode) {
		this.resCode = resCode;
	}
	public String getResAddr() {
		return resAddr;
	}
	public void setResAddr(String resAddr) {
		this.resAddr = resAddr;
	}
	public String getResSts() {
		return resSts;
	}
	public void setResSts(String resSts) {
		this.resSts = resSts;
	}
	public String getWorkType() {
		return workType;
	}
	public void setWorkType(String workType) {
		this.workType = workType;
	}
	public String getCorpName() {
		return corpName;
	}
	public void setCorpName(String corpName) {
		this.corpName = corpName;
	}
	public String getCorpWay() {
		return corpWay;
	}
	public void setCorpWay(String corpWay) {
		this.corpWay = corpWay;
	}
	public String getCorpCode() {
		return corpCode;
	}
	public void setCorpCode(String corpCode) {
		this.corpCode = corpCode;
	}
	public String getCorpAddr() {
		return corpAddr;
	}
	public void setCorpAddr(String corpAddr) {
		this.corpAddr = corpAddr;
	}
	public String getDuty() {
		return duty;
	}
	public void setDuty(String duty) {
		this.duty = duty;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWorkYear() {
		return workYear;
	}
	public void setWorkYear(String workYear) {
		this.workYear = workYear;
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
	public Double getAppAmt() {
		return appAmt;
	}
	public void setAppAmt(Double appAmt) {
		this.appAmt = appAmt;
	}
	public Double getPactAmt() {
		return pactAmt;
	}
	public void setPactAmt(Double pactAmt) {
		this.pactAmt = pactAmt;
	}
	public Double getLnRate() {
		return lnRate;
	}
	public void setLnRate(Double lnRate) {
		this.lnRate = lnRate;
	}
	public Double getOverRate() {
		return overRate;
	}
	public void setOverRate(Double overRate) {
		this.overRate = overRate;
	}
	public Double getDamRate() {
		return damRate;
	}
	public void setDamRate(Double damRate) {
		this.damRate = damRate;
	}
	public String getAppArea() {
		return appArea;
	}
	public void setAppArea(String appArea) {
		this.appArea = appArea;
	}
	public String getLnUse() {
		return lnUse;
	}
	public void setLnUse(String lnUse) {
		this.lnUse = lnUse;
	}
	public String getRepayType() {
		return repayType;
	}
	public void setRepayType(String repayType) {
		this.repayType = repayType;
	}
	public Integer getTermMon() {
		return termMon;
	}
	public void setTermMon(Integer termMon) {
		this.termMon = termMon;
	}
	public Integer getTermDay() {
		return termDay;
	}
	public void setTermDay(Integer termDay) {
		this.termDay = termDay;
	}
	public String getVouType() {
		return vouType;
	}
	public void setVouType(String vouType) {
		this.vouType = vouType;
	}
	public String getBegDate() {
		return begDate;
	}
	public void setBegDate(String begDate) {
		this.begDate = begDate;
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
	public String getPayKind() {
		return payKind;
	}
	public void setPayKind(String payKind) {
		this.payKind = payKind;
	}
	public Integer getPayDay() {
		return payDay;
	}
	public void setPayDay(Integer payDay) {
		this.payDay = payDay;
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
	public Integer getVouDays() {
		return vouDays;
	}
	public void setVouDays(Integer vouDays) {
		this.vouDays = vouDays;
	}
	public Double getFeeTotal() {
		return feeTotal;
	}
	public void setFeeTotal(Double feeTotal) {
		this.feeTotal = feeTotal;
	}
	public Double getFeeRate() {
		return feeRate;
	}
	public void setFeeRate(Double feeRate) {
		this.feeRate = feeRate;
	}
	public Double getFeeAmt() {
		return feeAmt;
	}
	public void setFeeAmt(Double feeAmt) {
		this.feeAmt = feeAmt;
	}
	public Double getSrvRate() {
		return srvRate;
	}
	public void setSrvRate(Double srvRate) {
		this.srvRate = srvRate;
	}
	public Double getSrvAmt() {
		return srvAmt;
	}
	public void setSrvAmt(Double srvAmt) {
		this.srvAmt = srvAmt;
	}
	public Double getVouRate() {
		return vouRate;
	}
	public void setVouRate(Double vouRate) {
		this.vouRate = vouRate;
	}
	public Double getVouAmt() {
		return vouAmt;
	}
	public void setVouAmt(Double vouAmt) {
		this.vouAmt = vouAmt;
	}
	public Double getFeeAmt1() {
		return feeAmt1;
	}
	public void setFeeAmt1(Double feeAmt1) {
		this.feeAmt1 = feeAmt1;
	}
	public Double getFeeAmt2() {
		return feeAmt2;
	}
	public void setFeeAmt2(Double feeAmt2) {
		this.feeAmt2 = feeAmt2;
	}
	public Double getFeeAmt3() {
		return feeAmt3;
	}
	public void setFeeAmt3(Double feeAmt3) {
		this.feeAmt3 = feeAmt3;
	}
	public Double getFeeAmt4() {
		return feeAmt4;
	}
	public void setFeeAmt4(Double feeAmt4) {
		this.feeAmt4 = feeAmt4;
	}
	public Double getFeeAmt5() {
		return feeAmt5;
	}
	public void setFeeAmt5(Double feeAmt5) {
		this.feeAmt5 = feeAmt5;
	}
	public String getIfItp() {
		return ifItp;
	}
	public void setIfItp(String ifItp) {
		this.ifItp = ifItp;
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
	public String getIfAuth() {
		return ifAuth;
	}
	public void setIfAuth(String ifAuth) {
		this.ifAuth = ifAuth;
	}
	public String getIfPact() {
		return ifPact;
	}
	public void setIfPact(String ifPact) {
		this.ifPact = ifPact;
	}
	public String getIfCar() {
		return ifCar;
	}
	public void setIfCar(String ifCar) {
		this.ifCar = ifCar;
	}
	public String getIfCarcred() {
		return ifCarcred;
	}
	public void setIfCarcred(String ifCarcred) {
		this.ifCarcred = ifCarcred;
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
	public Double getCardAmt() {
		return cardAmt;
	}
	public void setCardAmt(Double cardAmt) {
		this.cardAmt = cardAmt;
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
	public String getWorkSts() {
		return workSts;
	}
	public void setWorkSts(String workSts) {
		this.workSts = workSts;
	}

}