package app.creditapp.ln.entity;
import app.base.BaseDomain;
/**
* Title: LnApplyReg.java
* Description:
* @version��1.0
**/
public class LnApplyReg extends BaseDomain {
	private String batchNo;//���κ���
	private String appId;//����ID
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
	private String ifFlag;//���ñ�־
	private String ifCar;//�Ƿ��г�
	private String ifCarcred;//�Ƿ��а��ҳ���
	private String ifRoom;//�Ƿ��з�
	private String ifMort;//�Ƿ��а��ҷ���
	private String ifCard;//�Ƿ��д��ǿ�
	private Integer cardAmt;//���ǿ���Ͷ��
	private String appSts;//����״̬[02ͨ��]
	private String splitSts;//���״̬[01δ���02�Ѳ��]
	private String apprSts;//����״̬[01δ����02ͨ��03���]
	private String brNo;//������������
	private String pactNo;//��ͬ���
	private String appDate;//��������
	private String pactXt;//���к�ͬ���
	private String brAccType;//������������[A/B]
	private String cifName;//�ͻ�����
	private String idType;//֤������
	private String idNo;//֤������
	private String cifType;//�ͻ�����
	private String sex;//�Ա�
	private String birthDay;//��������
	private String marriage;//����״��
	private String children; //�Ƿ�����Ů
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
	
	private String prdtName;//�������
	private String czPactNo;//������ˮ��
	private String workSts; //����״̬
	private String txdate;
	private String loginid;
	
	public String getLoginid() {
		return loginid;
	}
	public void setLoginid(String loginid) {
		this.loginid = loginid;
	}
	public String getTxdate() {
		return txdate;
	}
	public void setTxdate(String txdate) {
		this.txdate = txdate;
	}
	public String getWorkSts() {
		return workSts;
	}
	public void setWorkSts(String workSts) {
		this.workSts = workSts;
	}
	public String getPrdtName() {
		return prdtName;
	}
	public void setPrdtName(String prdtName) {
		this.prdtName = prdtName;
	}
	/**
	 * @return ���κ���
	 */
	public String getBatchNo() {
	 	return batchNo;
	}
	/**
	 * @���� ���κ���
	 * @param batchNo
	 */
	public void setBatchNo(String batchNo) {
	 	this.batchNo = batchNo;
	}
	/**
	 * @return ����ID
	 */
	public String getAppId() {
	 	return appId;
	}
	/**
	 * @���� ����ID
	 * @param appId
	 */
	public void setAppId(String appId) {
	 	this.appId = appId;
	}
	/**
	 * @return ������
	 */
	public Double getAppAmt() {
	 	return appAmt;
	}
	/**
	 * @���� ������
	 * @param appAmt
	 */
	public void setAppAmt(Double appAmt) {
	 	this.appAmt = appAmt;
	}
	/**
	 * @return ��ͬ���
	 */
	public Double getPactAmt() {
	 	return pactAmt;
	}
	/**
	 * @���� ��ͬ���
	 * @param pactAmt
	 */
	public void setPactAmt(Double pactAmt) {
	 	this.pactAmt = pactAmt;
	}
	/**
	 * @return ���ʣ��£�
	 */
	public Double getLnRate() {
	 	return lnRate;
	}
	/**
	 * @���� ���ʣ��£�
	 * @param lnRate
	 */
	public void setLnRate(Double lnRate) {
	 	this.lnRate = lnRate;
	}
	/**
	 * @return ��Ϣ���ʣ��£�
	 */
	public Double getOverRate() {
	 	return overRate;
	}
	/**
	 * @���� ��Ϣ���ʣ��£�
	 * @param overRate
	 */
	public void setOverRate(Double overRate) {
	 	this.overRate = overRate;
	}
	/**
	 * @return ��ǰ����ΥԼ�����
	 */
	public Double getDamRate() {
	 	return damRate;
	}
	/**
	 * @���� ��ǰ����ΥԼ�����
	 * @param damRate
	 */
	public void setDamRate(Double damRate) {
	 	this.damRate = damRate;
	}
	/**
	 * @return ����ص�
	 */
	public String getAppArea() {
	 	return appArea;
	}
	/**
	 * @���� ����ص�
	 * @param appArea
	 */
	public void setAppArea(String appArea) {
	 	this.appArea = appArea;
	}
	/**
	 * @return ������;
	 */
	public String getLnUse() {
	 	return lnUse;
	}
	/**
	 * @���� ������;
	 * @param lnUse
	 */
	public void setLnUse(String lnUse) {
	 	this.lnUse = lnUse;
	}
	/**
	 * @return ���ʽ
	 */
	public String getRepayType() {
	 	return repayType;
	}
	/**
	 * @���� ���ʽ
	 * @param repayType
	 */
	public void setRepayType(String repayType) {
	 	this.repayType = repayType;
	}
	/**
	 * @return �������ޣ��£�
	 */
	public Integer getTermMon() {
	 	return termMon;
	}
	/**
	 * @���� �������ޣ��£�
	 * @param termMon
	 */
	public void setTermMon(Integer termMon) {
	 	this.termMon = termMon;
	}
	/**
	 * @return �������ޣ��գ�
	 */
	public Integer getTermDay() {
	 	return termDay;
	}
	/**
	 * @���� �������ޣ��գ�
	 * @param termDay
	 */
	public void setTermDay(Integer termDay) {
	 	this.termDay = termDay;
	}
	/**
	 * @return ������ʽ
	 */
	public String getVouType() {
	 	return vouType;
	}
	/**
	 * @���� ������ʽ
	 * @param vouType
	 */
	public void setVouType(String vouType) {
	 	this.vouType = vouType;
	}
	/**
	 * @return �ſ�����
	 */
	public String getBegDate() {
	 	return begDate;
	}
	/**
	 * @���� �ſ�����
	 * @param begDate
	 */
	public void setBegDate(String begDate) {
	 	this.begDate = begDate;
	}
	/**
	 * @return ��������
	 */
	public String getEndDate() {
	 	return endDate;
	}
	/**
	 * @���� ��������
	 * @param endDate
	 */
	public void setEndDate(String endDate) {
	 	this.endDate = endDate;
	}
	/**
	 * @return �ۿ�������
	 */
	public String getPayType() {
	 	return payType;
	}
	/**
	 * @���� �ۿ�������
	 * @param payType
	 */
	public void setPayType(String payType) {
	 	this.payType = payType;
	}
	/**
	 * @return �ۿ�����𡢻���Ƶ��
	 */
	public String getPayKind() {
	 	return payKind;
	}
	/**
	 * @���� �ۿ�����𡢻���Ƶ��
	 * @param payKind
	 */
	public void setPayKind(String payKind) {
	 	this.payKind = payKind;
	}
	/**
	 * @return �ۿ���
	 */
	public Integer getPayDay() {
	 	return payDay;
	}
	/**
	 * @���� �ۿ���
	 * @param payDay
	 */
	public void setPayDay(Integer payDay) {
	 	this.payDay = payDay;
	}
	/**
	 * @return �ɷѷ�ʽ
	 */
	public String getFeeType() {
	 	return feeType;
	}
	/**
	 * @���� �ɷѷ�ʽ
	 * @param feeType
	 */
	public void setFeeType(String feeType) {
	 	this.feeType = feeType;
	}
	/**
	 * @return ֧����ʽ[01����02����]
	 */
	public String getPayMent() {
	 	return payMent;
	}
	/**
	 * @���� ֧����ʽ[01����02����]
	 * @param payMent
	 */
	public void setPayMent(String payMent) {
	 	this.payMent = payMent;
	}
	/**
	 * @return ���е�������
	 */
	public Integer getVouDays() {
	 	return vouDays;
	}
	/**
	 * @���� ���е�������
	 * @param vouDays
	 */
	public void setVouDays(Integer vouDays) {
	 	this.vouDays = vouDays;
	}
	/**
	 * @return �������ܶ�
	 */
	public Double getFeeTotal() {
	 	return feeTotal;
	}
	/**
	 * @���� �������ܶ�
	 * @param feeTotal
	 */
	public void setFeeTotal(Double feeTotal) {
	 	this.feeTotal = feeTotal;
	}
	/**
	 * @return ��������
	 */
	public Double getFeeRate() {
	 	return feeRate;
	}
	/**
	 * @���� ��������
	 * @param feeRate
	 */
	public void setFeeRate(Double feeRate) {
	 	this.feeRate = feeRate;
	}
	/**
	 * @return ������
	 */
	public Double getFeeAmt() {
	 	return feeAmt;
	}
	/**
	 * @���� ������
	 * @param feeAmt
	 */
	public void setFeeAmt(Double feeAmt) {
	 	this.feeAmt = feeAmt;
	}
	/**
	 * @return �������
	 */
	public Double getSrvRate() {
	 	return srvRate;
	}
	/**
	 * @���� �������
	 * @param srvRate
	 */
	public void setSrvRate(Double srvRate) {
	 	this.srvRate = srvRate;
	}
	/**
	 * @return �����
	 */
	public Double getSrvAmt() {
	 	return srvAmt;
	}
	/**
	 * @���� �����
	 * @param srvAmt
	 */
	public void setSrvAmt(Double srvAmt) {
	 	this.srvAmt = srvAmt;
	}
	/**
	 * @return ��������
	 */
	public Double getVouRate() {
	 	return vouRate;
	}
	/**
	 * @���� ��������
	 * @param vouRate
	 */
	public void setVouRate(Double vouRate) {
	 	this.vouRate = vouRate;
	}
	/**
	 * @return ������
	 */
	public Double getVouAmt() {
	 	return vouAmt;
	}
	/**
	 * @���� ������
	 * @param vouAmt
	 */
	public void setVouAmt(Double vouAmt) {
	 	this.vouAmt = vouAmt;
	}
	/**
	 * @return ����һ
	 */
	public Double getFeeAmt1() {
	 	return feeAmt1;
	}
	/**
	 * @���� ����һ
	 * @param feeAmt1
	 */
	public void setFeeAmt1(Double feeAmt1) {
	 	this.feeAmt1 = feeAmt1;
	}
	/**
	 * @return ���ö�
	 */
	public Double getFeeAmt2() {
	 	return feeAmt2;
	}
	/**
	 * @���� ���ö�
	 * @param feeAmt2
	 */
	public void setFeeAmt2(Double feeAmt2) {
	 	this.feeAmt2 = feeAmt2;
	}
	/**
	 * @return ������
	 */
	public Double getFeeAmt3() {
	 	return feeAmt3;
	}
	/**
	 * @���� ������
	 * @param feeAmt3
	 */
	public void setFeeAmt3(Double feeAmt3) {
	 	this.feeAmt3 = feeAmt3;
	}
	/**
	 * @return ������
	 */
	public Double getFeeAmt4() {
	 	return feeAmt4;
	}
	/**
	 * @���� ������
	 * @param feeAmt4
	 */
	public void setFeeAmt4(Double feeAmt4) {
	 	this.feeAmt4 = feeAmt4;
	}
	/**
	 * @return ������
	 */
	public Double getFeeAmt5() {
	 	return feeAmt5;
	}
	/**
	 * @���� ������
	 * @param feeAmt5
	 */
	public void setFeeAmt5(Double feeAmt5) {
	 	this.feeAmt5 = feeAmt5;
	}
	/**
	 * @return �Ƿ����
	 */
	public String getIfItp() {
	 	return ifItp;
	}
	/**
	 * @���� �Ƿ����
	 * @param ifItp
	 */
	public void setIfItp(String ifItp) {
	 	this.ifItp = ifItp;
	}
	/**
	 * @return �Ƿ���д�����
	 */
	public String getIfApp() {
	 	return ifApp;
	}
	/**
	 * @���� �Ƿ���д�����
	 * @param ifApp
	 */
	public void setIfApp(String ifApp) {
	 	this.ifApp = ifApp;
	}
	/**
	 * @return �Ƿ������֤��Ϣ
	 */
	public String getIfId() {
	 	return ifId;
	}
	/**
	 * @���� �Ƿ������֤��Ϣ
	 * @param ifId
	 */
	public void setIfId(String ifId) {
	 	this.ifId = ifId;
	}
	/**
	 * @return �Ƿ��в�֤��Ȩ�ļ�
	 */
	public String getIfAuth() {
	 	return ifAuth;
	}
	/**
	 * @���� �Ƿ��в�֤��Ȩ�ļ�
	 * @param ifAuth
	 */
	public void setIfAuth(String ifAuth) {
	 	this.ifAuth = ifAuth;
	}
	/**
	 * @return �Ƿ���ǩ����ͬ
	 */
	public String getIfPact() {
	 	return ifPact;
	}
	/**
	 * @���� �Ƿ���ǩ����ͬ
	 * @param ifPact
	 */
	public void setIfPact(String ifPact) {
	 	this.ifPact = ifPact;
	}
	/**
	 * @return ���ñ�־
	 */
	public String getIfFlag() {
	 	return ifFlag;
	}
	/**
	 * @���� ���ñ�־
	 * @param ifFlag
	 */
	public void setIfFlag(String ifFlag) {
	 	this.ifFlag = ifFlag;
	}
	/**
	 * @return �Ƿ��г�
	 */	
	public String getIfCar() {
		return ifCar;
	}
	/**
	 * @���� �Ƿ��г�
	 * @param ifCar
	 */
	public void setIfCar(String ifCar) {
		this.ifCar = ifCar;
	}
	/**
	 * @return �Ƿ��а��ҳ���
	 */
	public String getIfCarcred() {
		return ifCarcred;
	}
	/**
	 * @���� �Ƿ��а��ҳ���
	 * @param ifCarcred
	 */
	public void setIfCarcred(String ifCarcred) {
		this.ifCarcred = ifCarcred;
	}
	/**
	 * @return �Ƿ��з�
	 */
	public String getIfRoom() {
		return ifRoom;
	}
	/**
	 * @���� �Ƿ��з�
	 * @param ifRoom
	 */
	public void setIfRoom(String ifRoom) {
		this.ifRoom = ifRoom;
	}
	/**
	 * @return �Ƿ��а��ҷ���
	 */
	public String getIfMort() {
		return ifMort;
	}
	/**
	 * @���� �Ƿ��а��ҷ���
	 * @param ifMort
	 */
	public void setIfMort(String ifMort) {
		this.ifMort = ifMort;
	}
	/**
	 * @return �Ƿ��д��ǿ�
	 */
	public String getIfCard() {
		return ifCard;
	}
	/**
	 * @���� �Ƿ��д��ǿ�
	 * @param ifCard
	 */
	public void setIfCard(String ifCard) {
		this.ifCard = ifCard;
	}
	/**
	 * @return ���ǿ���Ͷ��
	 */
	public Integer getCardAmt() {
		return cardAmt;
	}
	/**
	 * @���� ���ǿ���Ͷ��
	 * @param ifCard
	 */
	public void setCardAmt(Integer cardAmt) {
		this.cardAmt = cardAmt;
	}
	/**
	 * @return ����״̬[02ͨ��]
	 */
	public String getAppSts() {
	 	return appSts;
	}
	/**
	 * @���� ����״̬[02ͨ��]
	 * @param appSts
	 */
	public void setAppSts(String appSts) {
	 	this.appSts = appSts;
	}
	/**
	 * @return ���״̬[01δ���02�Ѳ��]
	 */
	public String getSplitSts() {
	 	return splitSts;
	}
	/**
	 * @���� ���״̬[01δ���02�Ѳ��]
	 * @param splitSts
	 */
	public void setSplitSts(String splitSts) {
	 	this.splitSts = splitSts;
	}
	/**
	 * @return ����״̬[01δ����02ͨ��03���]
	 */
	public String getApprSts() {
	 	return apprSts;
	}
	/**
	 * @���� ����״̬[01δ����02ͨ��03���]
	 * @param apprSts
	 */
	public void setApprSts(String apprSts) {
	 	this.apprSts = apprSts;
	}
	/**
	 * @return ������������
	 */
	public String getBrNo() {
	 	return brNo;
	}
	/**
	 * @���� ������������
	 * @param brNo
	 */
	public void setBrNo(String brNo) {
	 	this.brNo = brNo;
	}
	/**
	 * @return ��ͬ���
	 */
	public String getPactNo() {
	 	return pactNo;
	}
	/**
	 * @���� ��ͬ���
	 * @param pactNo
	 */
	public void setPactNo(String pactNo) {
	 	this.pactNo = pactNo;
	}
	/**
	 * @return ��������
	 */
	public String getAppDate() {
	 	return appDate;
	}
	/**
	 * @���� ��������
	 * @param appDate
	 */
	public void setAppDate(String appDate) {
	 	this.appDate = appDate;
	}
	/**
	 * @return ���к�ͬ���
	 */
	public String getPactXt() {
	 	return pactXt;
	}
	/**
	 * @���� ���к�ͬ���
	 * @param pactXt
	 */
	public void setPactXt(String pactXt) {
	 	this.pactXt = pactXt;
	}
	/**
	 * @return ������������[A/B]
	 */
	public String getBrAccType() {
	 	return brAccType;
	}
	/**
	 * @���� ������������[A/B]
	 * @param brAccType
	 */
	public void setBrAccType(String brAccType) {
	 	this.brAccType = brAccType;
	}
	/**
	 * @return �ͻ�����
	 */
	public String getCifName() {
	 	return cifName;
	}
	/**
	 * @���� �ͻ�����
	 * @param cifName
	 */
	public void setCifName(String cifName) {
	 	this.cifName = cifName;
	}
	/**
	 * @return ֤������
	 */
	public String getIdType() {
	 	return idType;
	}
	/**
	 * @���� ֤������
	 * @param idType
	 */
	public void setIdType(String idType) {
	 	this.idType = idType;
	}
	/**
	 * @return ֤������
	 */
	public String getIdNo() {
	 	return idNo;
	}
	/**
	 * @���� ֤������
	 * @param idNo
	 */
	public void setIdNo(String idNo) {
	 	this.idNo = idNo;
	}
	/**
	 * @return �ͻ�����
	 */
	public String getCifType() {
	 	return cifType;
	}
	/**
	 * @���� �ͻ�����
	 * @param cifType
	 */
	public void setCifType(String cifType) {
	 	this.cifType = cifType;
	}
	/**
	 * @return �Ա�
	 */
	public String getSex() {
	 	return sex;
	}
	/**
	 * @���� �Ա�
	 * @param sex
	 */
	public void setSex(String sex) {
	 	this.sex = sex;
	}
	/**
	 * @return ��������
	 */
	public String getBirthDay() {
	 	return birthDay;
	}
	/**
	 * @���� ��������
	 * @param birthDay
	 */
	public void setBirthDay(String birthDay) {
	 	this.birthDay = birthDay;
	}
	/**
	 * @return ����״��
	 */
	public String getMarriage() {
	 	return marriage;
	}
	/**
	 * @����  �Ƿ�����Ů
	 * @param children
	 */
	public void setChildren(String children) {
	 	this.children = children;
	}
	/**
	 * @return �Ƿ�����Ů
	 */
	public String getChildren() {
	 	return children;
	}
	/**
	 * @���� ����״��
	 * @param marriage
	 */
	public void setMarriage(String marriage) {
	 	this.marriage = marriage;
	}
	/**
	 * @return ���ѧ��
	 */
	public String getEdu() {
	 	return edu;
	}
	/**
	 * @���� ���ѧ��
	 * @param edu
	 */
	public void setEdu(String edu) {
	 	this.edu = edu;
	}
	/**
	 * @return ���ѧλ
	 */
	public String getDegree() {
	 	return degree;
	}
	/**
	 * @���� ���ѧλ
	 * @param degree
	 */
	public void setDegree(String degree) {
	 	this.degree = degree;
	}
	/**
	 * @return �����루Ԫ��
	 */
	public Double getIncome() {
	 	return income;
	}
	/**
	 * @���� �����루Ԫ��
	 * @param income
	 */
	public void setIncome(Double income) {
	 	this.income = income;
	}
	/**
	 * @return ��ϵ�绰
	 */
	public String getCommTel() {
	 	return commTel;
	}
	/**
	 * @���� ��ϵ�绰
	 * @param commTel
	 */
	public void setCommTel(String commTel) {
	 	this.commTel = commTel;
	}
	/**
	 * @return �ֻ�����
	 */
	public String getPhoneNo() {
	 	return phoneNo;
	}
	/**
	 * @���� �ֻ�����
	 * @param phoneNo
	 */
	public void setPhoneNo(String phoneNo) {
	 	this.phoneNo = phoneNo;
	}
	/**
	 * @return ͨѶ�ʱ�
	 */
	public String getCommCode() {
	 	return commCode;
	}
	/**
	 * @���� ͨѶ�ʱ�
	 * @param commCode
	 */
	public void setCommCode(String commCode) {
	 	this.commCode = commCode;
	}
	/**
	 * @return ͨѶ��ַ
	 */
	public String getCommAddr() {
	 	return commAddr;
	}
	/**
	 * @���� ͨѶ��ַ
	 * @param commAddr
	 */
	public void setCommAddr(String commAddr) {
	 	this.commAddr = commAddr;
	}
	/**
	 * @return ��������
	 */
	public String getCifArea() {
	 	return cifArea;
	}
	/**
	 * @���� ��������
	 * @param cifArea
	 */
	public void setCifArea(String cifArea) {
	 	this.cifArea = cifArea;
	}
	/**
	 * @return סլ�绰
	 */
	public String getResTel() {
	 	return resTel;
	}
	/**
	 * @���� סլ�绰
	 * @param resTel
	 */
	public void setResTel(String resTel) {
	 	this.resTel = resTel;
	}
	/**
	 * @return סլ�ʱ�
	 */
	public String getResCode() {
	 	return resCode;
	}
	/**
	 * @���� סլ�ʱ�
	 * @param resCode
	 */
	public void setResCode(String resCode) {
	 	this.resCode = resCode;
	}
	/**
	 * @return סլ��ַ
	 */
	public String getResAddr() {
	 	return resAddr;
	}
	/**
	 * @���� סլ��ַ
	 * @param resAddr
	 */
	public void setResAddr(String resAddr) {
	 	this.resAddr = resAddr;
	}
	/**
	 * @return ��ס״��
	 */
	public String getResSts() {
	 	return resSts;
	}
	/**
	 * @���� ��ס״��
	 * @param resSts
	 */
	public void setResSts(String resSts) {
	 	this.resSts = resSts;
	}
	/**
	 * @return ְҵ
	 */
	public String getWorkType() {
	 	return workType;
	}
	/**
	 * @���� ְҵ
	 * @param workType
	 */
	public void setWorkType(String workType) {
	 	this.workType = workType;
	}
	/**
	 * @return ������λ����
	 */
	public String getCorpName() {
	 	return corpName;
	}
	/**
	 * @���� ������λ����
	 * @param corpName
	 */
	public void setCorpName(String corpName) {
	 	this.corpName = corpName;
	}
	/**
	 * @return ������λ������ҵ
	 */
	public String getCorpWay() {
	 	return corpWay;
	}
	/**
	 * @���� ������λ������ҵ
	 * @param corpWay
	 */
	public void setCorpWay(String corpWay) {
	 	this.corpWay = corpWay;
	}
	/**
	 * @return ������λ�ʱ�
	 */
	public String getCorpCode() {
	 	return corpCode;
	}
	/**
	 * @���� ������λ�ʱ�
	 * @param corpCode
	 */
	public void setCorpCode(String corpCode) {
	 	this.corpCode = corpCode;
	}
	/**
	 * @return ������λ��ַ
	 */
	public String getCorpAddr() {
	 	return corpAddr;
	}
	/**
	 * @���� ������λ��ַ
	 * @param corpAddr
	 */
	public void setCorpAddr(String corpAddr) {
	 	this.corpAddr = corpAddr;
	}
	/**
	 * @return ְ��
	 */
	public String getDuty() {
	 	return duty;
	}
	/**
	 * @���� ְ��
	 * @param duty
	 */
	public void setDuty(String duty) {
	 	this.duty = duty;
	}
	/**
	 * @return ְ��
	 */
	public String getTitle() {
	 	return title;
	}
	/**
	 * @���� ְ��
	 * @param title
	 */
	public void setTitle(String title) {
	 	this.title = title;
	}
	/**
	 * @return ������ʼ���
	 */
	public String getWorkYear() {
	 	return workYear;
	}
	/**
	 * @���� ������ʼ���
	 * @param workYear
	 */
	public void setWorkYear(String workYear) {
	 	this.workYear = workYear;
	}
	/**
	 * @return ��ż����
	 */
	public String getMateName() {
	 	return mateName;
	}
	/**
	 * @���� ��ż����
	 * @param mateName
	 */
	public void setMateName(String mateName) {
	 	this.mateName = mateName;
	}
	/**
	 * @return ��ż֤������
	 */
	public String getMateIdtype() {
	 	return mateIdtype;
	}
	/**
	 * @���� ��ż֤������
	 * @param mateIdtype
	 */
	public void setMateIdtype(String mateIdtype) {
	 	this.mateIdtype = mateIdtype;
	}
	/**
	 * @return ��ż֤������
	 */
	public String getMateIdno() {
	 	return mateIdno;
	}
	/**
	 * @���� ��ż֤������
	 * @param mateIdno
	 */
	public void setMateIdno(String mateIdno) {
	 	this.mateIdno = mateIdno;
	}
	/**
	 * @return ��ż������λ
	 */
	public String getMateWork() {
	 	return mateWork;
	}
	/**
	 * @���� ��ż������λ
	 * @param mateWork
	 */
	public void setMateWork(String mateWork) {
	 	this.mateWork = mateWork;
	}
	/**
	 * @return ��ż��ϵ�绰
	 */
	public String getMateTel() {
	 	return mateTel;
	}
	/**
	 * @���� ��ż��ϵ�绰
	 * @param mateTel
	 */
	public void setMateTel(String mateTel) {
	 	this.mateTel = mateTel;
	}
	/**
	 * @return ������Ŀ���
	 */
	public String getProjNo() {
	 	return projNo;
	}
	/**
	 * @���� ������Ŀ���
	 * @param projNo
	 */
	public void setProjNo(String projNo) {
	 	this.projNo = projNo;
	}
	/**
	 * @return ��Ʒ��
	 */
	public String getPrdtNo() {
	 	return prdtNo;
	}
	/**
	 * @���� ��Ʒ��
	 * @param prdtNo
	 */
	public void setPrdtNo(String prdtNo) {
	 	this.prdtNo = prdtNo;
	}
	/**
	 * @return ��������
	 */
	public String getLnType() {
	 	return lnType;
	}
	/**
	 * @���� ��������
	 * @param lnType
	 */
	public void setLnType(String lnType) {
	 	this.lnType = lnType;
	}
	/**
	 * @return �������
	 */
	public String getCurNo() {
	 	return curNo;
	}
	/**
	 * @���� �������
	 * @param curNo
	 */
	public void setCurNo(String curNo) {
	 	this.curNo = curNo;
	}
	public String getCzPactNo() {
		return czPactNo;
	}
	public void setCzPactNo(String czPactNo) {
		this.czPactNo = czPactNo;
	}
}