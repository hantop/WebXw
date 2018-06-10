package accounting.interf.loan;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import accounting.biz.pub.ParmBiz;
import accounting.domain.fee.AcChrgLog;
import accounting.domain.loan.AcCorpParm;
import accounting.domain.loan.AcDebit;
import accounting.domain.loan.AcDebitDtl;
import accounting.domain.loan.AcLnDue;
import accounting.domain.loan.AcLnMst;
import accounting.domain.loan.AcLoanBackLog;
import accounting.domain.loan.AcLoanLog;
import accounting.domain.loan.AcTraceLog;
import accounting.domain.loan.LnAcct;
import accounting.domain.loan.LnStage;
import accounting.domain.loan.PrdtBase;
import accounting.domain.loan.ProjAcct;
import accounting.domain.sys.AfferentDomain;
import accounting.domain.sys.OperaInfo;
import accounting.plat.PUBConstant;
import accounting.plat.TransCode;
import accounting.plat.core.AccountingException;
import accounting.plat.core.Operation;
import accounting.plat.dao.JdbcDao;
import app.base.CreateKey;
import app.base.SourceTemplate;
import app.creditapp.acc.loan.action.AcLoanBackLogAction;
import app.creditapp.inf.client.XMLUtil;
import app.creditapp.inf.client.ZFHead;
import app.creditapp.inf.client.zf.AccountInfo;
import app.creditapp.inf.client.zf.BodyLoan;
import app.creditapp.inf.client.zf.EntryInfo;
import app.creditapp.inf.client.zf.Exception_Exception;
import app.creditapp.inf.client.zf.SourceAccountInfo;
import app.creditapp.inf.client.zf.TargetAccountInfo;
import app.creditapp.inf.client.zf.TradeInfo;
import app.creditapp.ln.bo.LnDueBo;
import app.creditapp.ln.entity.LnDue;
import app.creditapp.redis.util.RedisUtil;
import app.oscache.CachecodeUtil;
import redis.clients.jedis.Jedis;


public class GrantLoanOp extends Operation {
	/**
	 * ����ſ������ 
	 * @param afferentDomain     ����ſ����ݶ���
	 * @return  
	 */
	public Object doExecute(AfferentDomain afferentDomain)throws AccountingException{
		GrantLoan gl;
		if (afferentDomain instanceof GrantLoan) {
			gl = (GrantLoan) afferentDomain;
		} else {
			throw new AccountingException("�������Ͳ�ƥ�䣡");
		}
		
		Connection conn = this.getConnection();
		GrantLoanBackResult grantLoanBackResult = new GrantLoanBackResult();
		//��ȡ�ſ�֧������
		PreparedStatement queryLnApplyMidPst = null;
		ResultSet queryLnApplyMidRs = null;
		try {
		//�õ�ҵ�����
		String traceNo = ParmBiz.getTraceNo(conn);
		String loanNo = gl.getLoanNo();	
//		List<AcChrgLog> acChrgLogList = gl.getAcChrgLogList();
		
		// ����ҵ���������
		OperaInfo operaInfo = new OperaInfo(afferentDomain, traceNo, conn);
		operaInfo.setBizDt(ParmBiz.getBizDt(conn));//���㽻������
		
		// ���ɴ���������Ϣ
//		AcLnDue acLnDue = (AcLnDue)JdbcDao.query(new AcLnDue(), "due_no='"+loanNo+"'", "ln_due", operaInfo.getConn());
		LnDueBo lnDueBo = (LnDueBo) SourceTemplate.getContext().getBean("lnDueBo");
		LnDue acLnDue = new LnDue();
		acLnDue.setDueNo(loanNo);
		acLnDue =lnDueBo.getById(acLnDue);
		//������������ɴ������ļ���Ҫ����mst_sts�ֶ�
		LnStage lnStage = (LnStage)JdbcDao.query(new LnStage(), "app_id='"+acLnDue.getAppId()+"'", "ln_stage", operaInfo.getConn());
		
		String cardChn = "";//���⻧֧������
		
		queryLnApplyMidPst = conn.prepareStatement("select card_chn from ln_apply_mid where app_id=?");
		queryLnApplyMidPst.setString(1, acLnDue.getAppId());
		queryLnApplyMidRs = queryLnApplyMidPst.executeQuery();
		if(queryLnApplyMidRs.next()){
		cardChn = queryLnApplyMidRs.getString("card_chn");			
		}
		PrdtBase prdtBase = (PrdtBase) JdbcDao.query(new PrdtBase(), "prdt_no='"+acLnDue.getPrdtNo()+"'", "PRDT_BASE", conn);

		if (prdtBase == null) {
			throw new AccountingException("��ѯ������Ӧ��Ʒ����Ϣ!");
		}
		// ���ɴ���������Ϣ
		AcLnMst acLnMst = this.getLnMst(prdtBase, acLnDue, operaInfo);
		
		//ҵ��������
		String busOrderType = "001";

		//���ɷſ���Ϣ
		List<AcLoanLog> acLoanLogList = this.getAcLoanLogList(acLnDue,cardChn,operaInfo,busOrderType,acLnDue.getProjNo());
		JdbcDao.insertList(acLoanLogList, "ac_loan_log", conn);
		
		//���ɷ���֧����������Ϣ
		List<AcLoanBackLog> acLoanBackLogList = new ArrayList<AcLoanBackLog>();
		
//		String backLogNo = ParmBiz.getBackLoanNo(conn);//����֧����������ˮ��
		String backLogNo = ParmBiz.getAcLoanBackLogNo(conn);//����֧����������ˮ��
		
		String uUID = CreateKey.getUUID();//�ӿ���ˮ��uUID
		//ÿ���ſ���Ϣ��Ӧһ��֧����ˮ
		
		for(AcLoanLog acLoanLog : acLoanLogList){
			AcLoanBackLog acLoanBackLog = new AcLoanBackLog();
			acLoanBackLog.setBackLogNo(backLogNo);
			acLoanBackLog.setBackCnt(ParmBiz.getBackCntSeq(conn));
			acLoanBackLog.setLoanLogNo(acLoanLog.getLoanLogNo());
			acLoanBackLog.setBackType(PUBConstant.BACK_TYPE_01);//�ſ�
			acLoanBackLog.setBackRes("");
			acLoanBackLog.setFailCaus("");
			acLoanBackLog.setBackSts(PUBConstant.BACK_STS_01);//������
			acLoanBackLog.setBusOrderType(busOrderType);
			acLoanBackLog.setBusEntryType(acLoanLog.getBusEntryType());
			acLoanBackLog.setTraceNo(acLoanLog.getTraceNo());
			acLoanBackLog.setUuid(CachecodeUtil.MFSPREFIX+uUID);
			acLoanBackLogList.add(acLoanBackLog);
		}

		acLnMst.setLstDt(operaInfo.getBizDt());			//�����ϱʷ������ڡ���ǰӪҵ���ڡ�

 		JdbcDao.insert(acLnMst, "ac_ln_mst", conn);
 		
 		//���½��������
 		lnStage.setMstSts("02");
 		lnStage.setUpTime(ParmBiz.getOracleUpDate(conn));
 		JdbcDao.update(lnStage, "app_id='"+lnStage.getAppId()+"'", "ln_stage", conn);
 		JdbcDao.insertList(acLoanBackLogList, "ac_loan_back_log", conn);
		//��õǼǽ�����ˮ
		AcTraceLog traceLog = this.getTraceLog(operaInfo, acLnMst);
		JdbcDao.insert(traceLog, "AC_TRACE_LOG", conn);
		try {
			conn.commit();
		} catch (Exception e) {
			conn.rollback();
		}

		acLnMst.setDealSts("02");
		JdbcDao.update(acLnMst, "loan_no='"+acLnMst.getLoanNo()+"' and deal_sts='01'", "ac_ln_mst", conn);
			
		//���½׶α�Ϊ�ѷ���
		lnStage.setSendSts("02");
		lnStage.setRsDesc("�ѷ���֧�����ȴ��ſ�");
		JdbcDao.update(lnStage, "app_id='"+lnStage.getAppId()+"' and send_sts='01'", "ln_stage", conn);		

		grantLoanBackResult.setAcLoanBackLogList(acLoanBackLogList);
		grantLoanBackResult.setUuid(CachecodeUtil.MFSPREFIX+uUID);
		
		try {
			conn.commit();
		} catch (Exception e) {
			conn.rollback();
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return grantLoanBackResult;
	}
	/**
	 * ��ô���������Ϣ
	 * 
	 * @throws AccountingException
	 */
	private AcLnMst getLnMst(PrdtBase prdtBase,LnDue acLnDue,OperaInfo operaInfo) throws AccountingException {
		AcLnMst lnMst = new AcLnMst();
		
		AcCorpParm acCorpParm = (AcCorpParm)JdbcDao.query(new AcCorpParm(), "br_no='"+acLnDue.getBrNo()+"'", "corp_parm", operaInfo.getConn());

		lnMst.setLoanNo(acLnDue.getDueNo());
		lnMst.setBrNo(acLnDue.getBrNo());
		lnMst.setPactNo(acLnDue.getPactNo());
		lnMst.setBrNo(acLnDue.getBrNo());
		lnMst.setProjNo(acLnDue.getProjNo());
		lnMst.setBatchNo(acLnDue.getBatchNo());
		lnMst.setPrdtNo(acLnDue.getPrdtNo());
		lnMst.setBrAccType(acLnDue.getBrAccType());
		lnMst.setCifNo(acLnDue.getCifNo());
		lnMst.setCifName(acLnDue.getCifName());
		lnMst.setLoanTyp(acLnDue.getLnType());
		lnMst.setAssureMeans(acLnDue.getVouType());
		//�����������ղ�����0������������趨Ϊ ����������+1 ���������յ���0������������趨Ϊ����������
		lnMst.setLoanTerm(acLnDue.getTermDay()==0?acLnDue.getTermMon():(acLnDue.getTermMon()+1));
//		lnMst.setOpnDt(acLnDue.getBegDate());
//		lnMst.setMtrDt(acLnDue.getEndDate());
		lnMst.setTermDay(acLnDue.getTermDay());
		lnMst.setTermMon(acLnDue.getTermMon());
		lnMst.setTermTyp(acLnDue.getTermType());
		lnMst.setCurNo(acLnDue.getCurNo());
		lnMst.setLoanAmt(acLnDue.getDueAmt());
		lnMst.setLoanBal(0.00);//δ�ſ�ɹ������ô������Ϊ0
		lnMst.setLnRate(acLnDue.getLnRate());
		lnMst.setLnRateYear(acLnDue.getLnRateYear());
		lnMst.setOverRate(prdtBase.getOverRate());
//		lnMst.setIcDt(acLnDue.getBegDate());
		lnMst.setRepayDay(acLnDue.getPayDay());
		lnMst.setExpInd("0");
		
		lnMst.setGraceDay(acCorpParm.getGraceDay());
		
		lnMst.setDelqInd(PUBConstant.DELQ_IND_NO); 
		lnMst.setDevaInd(PUBConstant.DEVA_IND_N); 
		lnMst.setDealSts(PUBConstant.DEAL_STS_PEND);
		lnMst.setIntToStpInd(PUBConstant.N);
		lnMst.setFiveSts(PUBConstant.FIVE_STS_1ST); 
		lnMst.setYsBal(0.00);
		lnMst.setHstBal(0.00);
		lnMst.setTtlPrvdAmt(acLnDue.getDueAmt());
		lnMst.setUpDt(operaInfo.getTxDt());
		return lnMst;
	}
	/**
	 *  
	 * @����	��ȡ�ſ���Ϣ�����ݽ�ݺŲ�ѯ�˻����˻���;Ϊ�ſ��˻��ļ�¼�����ݸü�¼���ɷſ���Ϣ
	 */
	private List<AcLoanLog> getAcLoanLogList(LnDue acLnDue ,String cardChn, OperaInfo operaInfo,String busOrderType,String projNo) throws AccountingException{
		Connection conn = operaInfo.getConn() ;
		DecimalFormat df = new DecimalFormat("00");
		//�˻���Ϣ���˻���;Ϊ�ſ�ģ�
		List<LnAcct> lnAcctList = (ArrayList) JdbcDao.queryList(new LnAcct(), "app_id='"+acLnDue.getAppId()+"' and ac_use='2' order by ac_type desc" , "ln_acct", operaInfo.getConn());
		int bus = 1;
		List<AcLoanLog> acLoanLogList = new ArrayList<AcLoanLog>();
		for(int i=0;i<lnAcctList.size();i++){
			AcLoanLog acLoanLog = new AcLoanLog();
			acLoanLog.setTraceNo(operaInfo.getTraceNo());
			acLoanLog.setLoanLogNo(ParmBiz.getLoanLogNo(conn));
			acLoanLog.setLoanNo(acLnDue.getDueNo());
			acLoanLog.setPactNo(acLnDue.getPactNo());
			acLoanLog.setBrNo(acLnDue.getBrNo());
			acLoanLog.setLoanAmt(lnAcctList.get(i).getAcAmt());
//			if(projAcct == null){
////				acLoanLog.setXtAcNo("");
//				acLoanLog.setCardChn("");
//			}else{
			acLoanLog.setCardChn(cardChn);
//			}
			acLoanLog.setXtAcNo(CachecodeUtil.MFSPREFIX+"_"+PUBConstant.ACCT_TYPE_03+"_"+projNo);
			acLoanLog.setLoanAcNo(lnAcctList.get(i).getAcNo());
			acLoanLog.setLoanAcType(lnAcctList.get(i).getAcType());
			acLoanLog.setLoanAcName(lnAcctList.get(i).getAcName());
			acLoanLog.setLoanBankCode(lnAcctList.get(i).getBankCode());
			acLoanLog.setLoanBankProv(lnAcctList.get(i).getBankProv());
			acLoanLog.setLoanBankCity(lnAcctList.get(i).getBankCity());
			acLoanLog.setLoanBankSite(lnAcctList.get(i).getBankSite());
			acLoanLog.setLoanSts("02");//�ѷ���
			acLoanLog.setTxDate(operaInfo.getTxDt());
			acLoanLog.setTxTime(ParmBiz.getOracleTxTime(conn));
			acLoanLog.setBusEntryType(busOrderType+String.valueOf(df.format(bus)));
			bus+=1;
			acLoanLog.setIdType(lnAcctList.get(i).getIdType());
			acLoanLog.setIdNo(lnAcctList.get(i).getIdNo());
			acLoanLog.setPhoneNo(lnAcctList.get(i).getPhoneNo());
			acLoanLog.setValidDate(lnAcctList.get(i).getValidDate());
			acLoanLog.setCvvNo(lnAcctList.get(i).getCvvNo());
			acLoanLogList.add(acLoanLog);
		}
		return acLoanLogList;
	}
	/**
	 * 
	 * @throws AccountingException 
	 * @throws Exception_Exception 
	 * @throws IOException 
	 * @throws SQLException 
	 * 
	 * @����	���͵�����֧���ſ�
	 */
	private Map sendZfMes(List<AcLoanBackLog> acLoanBackLogList,String projNo,String traceNo,Connection conn) throws AccountingException, Exception_Exception, IOException, SQLException {
//		String backLogNo = acLoanBackLogList.get(0).getBackLogNo();
		ZFHead zfHead = new ZFHead();
		zfHead.setRequestType("P100001");
		String uuid = acLoanBackLogList.get(0).getUuid();
		zfHead.setUUID(uuid);//�ӿ���ˮ��
		zfHead.setComId(CachecodeUtil.MFSPREFIX);
		zfHead.setComIP("11");
		zfHead.setSendTime(ParmBiz.getOracleUpDate2(conn));
		zfHead.setAsyn("0");
		Properties pathProperties = new Properties();
		pathProperties.load(Thread.currentThread().getContextClassLoader()
				.getResourceAsStream("application.properties"));
		String zfReturnUrl = pathProperties.getProperty("zfloanreturn.url");
		zfHead.setReturnUrl(zfReturnUrl);
		zfHead.setSigned("");
		zfHead.setClientType("0");
		zfHead.setPayCount(1);

		String headXml = XMLUtil.createHead(zfHead); // ͷ�ļ�
//		ProjAcct projAcct = (ProjAcct)JdbcDao.query(domain, condition, tableName, conn)
		
		BodyLoan bodyLoan = new BodyLoan();
		
		TradeInfo tradeInfo = new TradeInfo();
//		String TradeNo = ParmBiz.getOrderNoSeq(conn);
		tradeInfo.setTradeNo(CachecodeUtil.MFSPREFIX+traceNo);//���׺�
		tradeInfo.setTradeTypeNo(acLoanBackLogList.get(0).getBusOrderType());//����ҵ������
		tradeInfo.setTotalEntryNum(acLoanBackLogList.size());//��Ŀ����
		
		List<TradeInfo> tradeList = new ArrayList<TradeInfo>();
		EntryInfo entryInfo = null;
		List<EntryInfo> entryList = new ArrayList<EntryInfo>();
		
		//�ſ���Ϣ
		AcLoanLog acLoanLog = null;
		//�ſ���ϢList
		List<AcLoanLog> acLoanLogList = new ArrayList<AcLoanLog>();
		//�ۿ���Ϣ
		AcDebit acDebit = null;
		//�ۿ���Ϣlist
		List<AcDebit> acDebitList = new ArrayList<AcDebit>();
		//�˻���Ϣ
		AccountInfo accountInfo = null;
		
		SourceAccountInfo sourceAccountInfo = null;//Դ
		TargetAccountInfo targetAccountInfo = null;//Ŀ��
		
		for (AcLoanBackLog acLoanBackLog : acLoanBackLogList) {
			if(PUBConstant.BACK_STS_01.equals(acLoanBackLog.getBackType())){//�ſ�
				//��ȡ�ſ���Ϣ
				acLoanLog = (AcLoanLog) JdbcDao.query(new AcLoanLog(), "loan_log_no='"+acLoanBackLog.getLoanLogNo()+"'", "ac_loan_log", conn);
				acLoanLogList.add(acLoanLog);
				
				entryInfo = new EntryInfo();
				
				entryInfo.setEntryNo(acLoanBackLog.getBackCnt());//��Ŀ��
				entryInfo.setEnTradeType("01");
				entryInfo.setAmount(acLoanLog.getLoanAmt());
				entryInfo.setEntryTypeNo(acLoanBackLog.getBusEntryType());
				entryInfo.setChannelNo(acLoanLog.getCardChn());
				
				List<SourceAccountInfo> sourceAccountInfoListfk = new ArrayList<SourceAccountInfo>();
				List<TargetAccountInfo> targetAccountInfoListfk = new ArrayList<TargetAccountInfo>();
				
				sourceAccountInfo = new SourceAccountInfo();//Դ1
				
				accountInfo = new AccountInfo();
				accountInfo.setAccountNo(acLoanLog.getXtAcNo());//�ſ� 03���տ� 04
				accountInfo.setAccountType("0");
				
				sourceAccountInfo.setLevel("01");
				sourceAccountInfo.setAccountInfo(accountInfo);
				sourceAccountInfoListfk.add(sourceAccountInfo);
				
				targetAccountInfo = new TargetAccountInfo();//Ŀ��
				
				accountInfo = new AccountInfo();
				accountInfo.setAccountNo(acLoanLog.getLoanAcNo());
				if("10".equals(acLoanLog.getLoanAcType())){//���˴��ǿ�
					accountInfo.setAccountType("3");
				}else if("11".equals(acLoanLog.getLoanAcType())){//���˽�ǿ�
					accountInfo.setAccountType("1");
				}
//				else if("12".equals(acLoanLog.getLoanAcType())){//��ҵ�˻�
//					accountInfo.setAccountType("2");
//				}
//				else if("14".equals(acLoanLog.getLoanAcType())){//�̻�
//					accountInfo.setAccountType("0");
//				}
				if("14".equals(acLoanLog.getLoanAcType())||"12".equals(acLoanLog.getLoanAcType())){//�̻���Թ�
					accountInfo.setAccountNo(acLoanLog.getLoanAcNo());//(�̻���Թ�)�ſ��˻�
					targetAccountInfo.setLevel("01");
					accountInfo.setAccountType("0");
					targetAccountInfo.setAccountInfo(accountInfo);
					targetAccountInfoListfk.add(targetAccountInfo);
					entryInfo.setSourceAccountList(sourceAccountInfoListfk);
					entryInfo.setTargetAccountList(targetAccountInfoListfk);
					entryInfo.setRemark1(acLoanLog.getBrNo());
					entryInfo.setRemark2(projNo);
					entryInfo.setRemark3(acLoanLog.getPactNo());
					entryList.add(entryInfo);
				}else{
					accountInfo.setAccountName(acLoanLog.getLoanAcName());
					accountInfo.setChannelNo(acLoanLog.getLoanBankCode());
					accountInfo.setBankDetailNo("");
					accountInfo.setBankName(acLoanLog.getLoanBankSite());
					accountInfo.setProvince(acLoanLog.getLoanBankProv());
					accountInfo.setCity(acLoanLog.getLoanBankCity()!=null?acLoanLog.getLoanBankCity():"");
					accountInfo.setCVN2(acLoanLog.getCvvNo()!=null?acLoanLog.getCvvNo():"");
					accountInfo.setVALDATE(acLoanLog.getValidDate()!=null?acLoanLog.getValidDate():"");
					accountInfo.setPhoneNo(acLoanLog.getPhoneNo()!=null?acLoanLog.getPhoneNo():"");
					accountInfo.setEmail("");
					accountInfo.setCertificateType(acLoanLog.getIdType()!=null?acLoanLog.getIdType():"");
					accountInfo.setCertificateNo(acLoanLog.getIdNo()!=null?acLoanLog.getIdNo():"");
					targetAccountInfo.setLevel("01");
					targetAccountInfo.setAccountInfo(accountInfo);
					targetAccountInfoListfk.add(targetAccountInfo);
					entryInfo.setSourceAccountList(sourceAccountInfoListfk);
					entryInfo.setTargetAccountList(targetAccountInfoListfk);
					entryInfo.setRemark1(acLoanLog.getBrNo());
					entryInfo.setRemark2(projNo);
					entryInfo.setRemark3(acLoanLog.getPactNo());
					entryList.add(entryInfo);
				}	
			}else{
				acDebit = (AcDebit)JdbcDao.query(new AcDebit(), "debit_no='"+acLoanBackLog.getLoanLogNo()+"'", "ac_debit", conn);
				acDebitList.add(acDebit);
				
				entryInfo = new EntryInfo();
				
				entryInfo.setEntryNo(acLoanBackLog.getBackCnt());//��Ŀ��
				entryInfo.setEnTradeType("02");//�ۿ�
				entryInfo.setAmount(acDebit.getAtpyAmt());
				entryInfo.setEntryTypeNo(acDebit.getBusEntryType());
				entryInfo.setChannelNo(acDebit.getCardChn());
				
				List<SourceAccountInfo> sourceAccountInfoListsk = new ArrayList<SourceAccountInfo>();
				List<TargetAccountInfo> targetAccountInfoListsk = new ArrayList<TargetAccountInfo>();
				
				sourceAccountInfo = new SourceAccountInfo();//Դ1
				targetAccountInfo = new TargetAccountInfo();//Ŀ��
				
				accountInfo = new AccountInfo();
				
				accountInfo.setAccountNo(CachecodeUtil.MFSPREFIX+"_"+acDebit.getBrNo()+"_"+acDebit.getPactNo());//֧��ƽ̨�˻�
				accountInfo.setAccountType("0");
				sourceAccountInfo.setLevel("01");//���ȼ�
				sourceAccountInfo.setAccountInfo(accountInfo);
				sourceAccountInfoListsk.add(sourceAccountInfo);
				
				sourceAccountInfo = new SourceAccountInfo();//Դ2
				
				accountInfo = new AccountInfo();
				
				accountInfo.setAccountNo(acDebit.getAcNo());
				if("10".equals(acDebit.getAcType())){//���˴��ǿ�
					accountInfo.setAccountType("3");
				}else if("11".equals(acDebit.getAcType())){//���˽�ǿ�
					accountInfo.setAccountType("1");
				}else if("12".equals(acDebit.getAcType())||"13".equals(acDebit.getAcType())||"14".equals(acDebit.getAcType())){//��ҵ�˻������磩
					accountInfo.setAccountType("0");
				}
				accountInfo.setAccountName(acDebit.getAcName());
				accountInfo.setChannelNo(acDebit.getAcctBankCde());
				accountInfo.setBankDetailNo("");
				accountInfo.setBankName(acDebit.getBankSite());
				accountInfo.setProvince(acDebit.getBankProv());
				accountInfo.setCity(acDebit.getBankCity());
				accountInfo.setCVN2(acDebit.getCvvNo()!=null?acDebit.getCvvNo():"");
				accountInfo.setVALDATE(acDebit.getValidDate()!=null?acDebit.getValidDate():"");
				accountInfo.setPhoneNo(acDebit.getPhoneNo()!=null?acDebit.getPhoneNo():"");
				accountInfo.setEmail("");
				accountInfo.setCertificateType(acDebit.getIdType()!=null?acDebit.getIdType():"");
				accountInfo.setCertificateNo(acDebit.getIdNo()!=null?acDebit.getIdNo():"");
				sourceAccountInfo.setLevel("02");
				sourceAccountInfo.setAccountInfo(accountInfo);
				sourceAccountInfoListsk.add(sourceAccountInfo);
				
				accountInfo = new AccountInfo();
				
				accountInfo.setAccountNo(CachecodeUtil.MFSPREFIX+"_"+PUBConstant.ACCT_TYPE_04+"_"+projNo);//��Ŀ�տ��˻�
				accountInfo.setAccountType("0");
				targetAccountInfo.setLevel("01");
				targetAccountInfo.setAccountInfo(accountInfo);
				targetAccountInfoListsk.add(targetAccountInfo);
				entryInfo.setSourceAccountList(sourceAccountInfoListsk);
				entryInfo.setTargetAccountList(targetAccountInfoListsk);
				entryInfo.setRemark1(acDebit.getBrNo());
				entryInfo.setRemark2(projNo);
				entryInfo.setRemark3(acDebit.getPactNo());
				entryList.add(entryInfo);
			}
			
		}
		tradeInfo.setEntryList(entryList);
		tradeList.add(tradeInfo);

		bodyLoan.setTradeList(tradeList);
		String bodyXml = XMLUtil.createBody(bodyLoan);// ת��ΪXML

		String xml = headXml + bodyXml + "</Package>";
		
		Jedis jedis = RedisUtil.getJedis();
		jedis.lpush(RedisUtil.QUEUE8, xml);// 
		jedis.close();
		
		return null ;
	}
	
	 /**

     * @description ��xml�ַ���ת����map

     * @param xml

     * @return Map

     */

	public static Map readStringXmlOut(String xml) {

		Map map = new HashMap();

		Document doc = null;

		try {
			doc = DocumentHelper.parseText(xml); // ���ַ���תΪXML

			Element rootElt = doc.getRootElement(); // ��ȡ���ڵ�

			Iterator iter = rootElt.elementIterator("Header"); // ��ȡ���ڵ��µ��ӽڵ�header

			Element recordEle = (Element) iter.next();

			String RequestType = recordEle.elementTextTrim("RequestType");
			map.put("RequestType", RequestType);

			String UUID = recordEle.elementTextTrim("UUID");
			map.put("UUID", UUID);

			String ComId = recordEle.elementTextTrim("ComId");
			map.put("ComId", ComId);

			String SendTime = recordEle.elementTextTrim("SendTime");
			map.put("SendTime", SendTime);

			String Signed = recordEle.elementTextTrim("Signed");
			map.put("Signed", Signed);

			String ResultCode = recordEle.elementTextTrim("ResultCode");
			map.put("ResultCode", ResultCode);

			String ResultMsg = recordEle.elementTextTrim("ResultMsg");
			map.put("ResultMsg", ResultMsg);

		} catch (DocumentException e) {

			e.printStackTrace();

		} catch (Exception e) {

			e.printStackTrace();

		}

		return map;

	}


	/**
	 *  
	 * 
	 * @����	��ȡ�ſ���Ϣ�����ݽ�ݺŲ�ѯ�˻����˻���;Ϊ�ſ��˻��ļ�¼�����ݸü�¼���ɷſ���Ϣ
	 */
	private List<AcLoanLog> getAcLoanLogList(AcLnDue acLnDue ,ProjAcct projAcct, OperaInfo operaInfo,String busOrderType) throws AccountingException{
		Connection conn = operaInfo.getConn() ;
		//�˻���Ϣ���˻���;Ϊ�ſ�ģ�
		List<LnAcct> lnAcctList = (ArrayList) JdbcDao.queryList(new LnAcct(), "app_id='"+acLnDue.getAppId()+"' and ac_use='2'" , "ln_acct", operaInfo.getConn());
		
		List<AcLoanLog> acLoanLogList = new ArrayList<AcLoanLog>();
		for(int i=0;i<lnAcctList.size();i++){
			AcLoanLog acLoanLog = new AcLoanLog();
			acLoanLog.setTraceNo(operaInfo.getTraceNo());
			acLoanLog.setLoanLogNo(ParmBiz.getAcLoanLogNo(conn));
			acLoanLog.setLoanNo(acLnDue.getDueNo());
			acLoanLog.setPactNo(acLnDue.getPactNo());
			acLoanLog.setBrNo(acLnDue.getBrNo());
			acLoanLog.setLoanAmt(lnAcctList.get(i).getAcAmt());
			if(projAcct == null){
				acLoanLog.setXtAcNo("");
				acLoanLog.setCardChn("");
			}else{
				acLoanLog.setXtAcNo(projAcct.getAcctNo());
				acLoanLog.setCardChn(projAcct.getCardChn());
			}
			acLoanLog.setLoanAcNo(lnAcctList.get(i).getAcNo());
			acLoanLog.setLoanAcType(lnAcctList.get(i).getAcType());
			acLoanLog.setLoanAcName(lnAcctList.get(i).getAcName());
			acLoanLog.setLoanBankCode(lnAcctList.get(i).getBankCode());
			acLoanLog.setLoanBankProv(lnAcctList.get(i).getBankProv());
			acLoanLog.setLoanBankCity(lnAcctList.get(i).getBankCity());
			acLoanLog.setLoanBankSite(lnAcctList.get(i).getBankSite());
			acLoanLog.setLoanSts("01");//������
			acLoanLog.setTxDate(operaInfo.getTxDt());
			acLoanLog.setTxTime(ParmBiz.getOracleTxTime(conn));
			acLoanLog.setBusEntryType(busOrderType+"01");
			acLoanLog.setIdType(lnAcctList.get(i).getIdType());
			acLoanLog.setIdNo(lnAcctList.get(i).getIdNo());
			acLoanLog.setPhoneNo(lnAcctList.get(i).getPhoneNo());
			acLoanLog.setValidDate(lnAcctList.get(i).getValidDate());
			acLoanLog.setCvvNo(lnAcctList.get(i).getCvvNo());
			
			acLoanLogList.add(acLoanLog);
		}
		return acLoanLogList;
	}
	/**
	 * ��ô���������Ϣ
	 * 
	 * @throws AccountingException
	 */
	private AcLnMst getLnMst(PrdtBase prdtBase,AcLnDue acLnDue,OperaInfo operaInfo) throws AccountingException {
		AcLnMst lnMst = new AcLnMst();
		
		AcCorpParm acCorpParm = (AcCorpParm)JdbcDao.query(new AcCorpParm(), "br_no='"+acLnDue.getBrNo()+"'", "corp_parm", operaInfo.getConn());

		lnMst.setLoanNo(acLnDue.getDueNo());
		lnMst.setBrNo(acLnDue.getBrNo());
		lnMst.setPactNo(acLnDue.getPactNo());
		lnMst.setBrNo(acLnDue.getBrNo());
		lnMst.setProjNo(acLnDue.getProjNo());
		lnMst.setBatchNo(acLnDue.getBatchNo());
		lnMst.setPrdtNo(acLnDue.getPrdtNo());
		lnMst.setBrAccType(acLnDue.getBrAccType());
		lnMst.setCifNo(acLnDue.getCifNo());
		lnMst.setCifName(acLnDue.getCifName());
		lnMst.setLoanTyp(acLnDue.getLnType());
		lnMst.setAssureMeans(acLnDue.getVouType());
		//�����������ղ�����0������������趨Ϊ ����������+1 ���������յ���0������������趨Ϊ����������
		lnMst.setLoanTerm(acLnDue.getTermDay()==0?acLnDue.getTermMon():(acLnDue.getTermMon()+1));
//		lnMst.setOpnDt(acLnDue.getBegDate());
//		lnMst.setMtrDt(acLnDue.getEndDate());
		lnMst.setTermDay(acLnDue.getTermDay());
		lnMst.setTermMon(acLnDue.getTermMon());
		lnMst.setTermTyp(acLnDue.getTermType());
		lnMst.setCurNo(acLnDue.getCurNo());
		lnMst.setLoanAmt(acLnDue.getDueAmt());
		lnMst.setLoanBal(0.00);//δ�ſ�ɹ������ô������Ϊ0
		lnMst.setLnRate(acLnDue.getLnRate());
		lnMst.setOverRate(prdtBase.getOverRate());
//		lnMst.setIcDt(acLnDue.getBegDate());
		lnMst.setRepayDay(acLnDue.getPayDay());
		lnMst.setExpInd("0");
		if(acCorpParm != null){
			lnMst.setGraceDay(acCorpParm.getGraceDay());
		}
		lnMst.setDelqInd(PUBConstant.DELQ_IND_NO); 
		lnMst.setDevaInd(PUBConstant.DEVA_IND_N); 
		lnMst.setDealSts(PUBConstant.DEAL_STS_PEND);
//		lnMst.setLoanSts(PUBConstant.LOAN_STS_ACTV); 
		lnMst.setIntToStpInd(PUBConstant.N);
		lnMst.setFiveSts(PUBConstant.FIVE_STS_1ST); 
		lnMst.setYsBal(0.00);
		lnMst.setHstBal(0.00);
		lnMst.setTtlPrvdAmt(acLnDue.getDueAmt());
		lnMst.setUpDt(operaInfo.getTxDt());

		return lnMst;
	}
	
	/**
	 * �õ��Ǽǽ�����ˮ����Ϣ
	 * @param operaInfo ҵ���������
	 * @param lnMst �����������
	 * 
	 * @return traceLog    �Ǽǽ�����ˮ�����
	 * @throws AccountingException
	 */
	private AcTraceLog getTraceLog(OperaInfo operaInfo,AcLnMst lnMst)throws AccountingException {
		AcTraceLog traceLog = new AcTraceLog();
		
		Connection conn = operaInfo.getConn() ;

		traceLog.setTraceNo(operaInfo.getTraceNo());//������ˮ��
		traceLog.setTraceCnt(1);					//������ˮ�ʴ�
		traceLog.setTxDt(operaInfo.getTxDt());		//���ý�������
    	traceLog.setTxTime(ParmBiz.getOracleTxTime(conn)) ;	//���ý���ʱ��
		traceLog.setTxBrNo(operaInfo.getTxBrNo());	//���ý��׻�����
		traceLog.setTxCde(TransCode.LNC3);			//���ý��״���
		traceLog.setSubTxCde(TransCode.LNC3);		//�����ӽ��״���
		traceLog.setCurNo(lnMst.getCurNo());		//���ñ���
		traceLog.setPrdtNo(lnMst.getPrdtNo());		//���ò�Ʒ���
		traceLog.setLoanNo(lnMst.getLoanNo());		//���ý�ݺ�
		traceLog.setPactNo(lnMst.getPactNo());		//���ú�ͬ��
		traceLog.setBrNo(lnMst.getBrNo());			//���û�����
		traceLog.setAddInd(PUBConstant.INC);		//����������־Ϊ�����ӡ�
		traceLog.setCtInd(PUBConstant.TRANS);		//������ת��־Ϊ��ת�ˡ�
		traceLog.setCancelInd(PUBConstant.REV_ROL_NORM);// ���ó�����־		
		traceLog.setAmt(lnMst.getLoanAmt());		//���÷�����
		traceLog.setMemo("����ſ�");					//����ժҪ
		
		return traceLog;
	}
	
	/**
	 * 
	 * @throws AccountingException 
	 * 
	 * @����	���ݷ�����ϸ ���ɿۿ���Ϣ����Ҫ�ڷſ�� ����������Ϣ������Ҫ���Ϳۿ�ָ��
	 */
	public Map<String,Object>  getAcDDL(AcLnMst acLnMst,List<AcChrgLog> acChrgLogList,ProjAcct virProjAcct,OperaInfo operaInfo) throws AccountingException{
		List<AcDebitDtl> acDebitDtlList = new ArrayList<AcDebitDtl>();
		
		Connection conn = operaInfo.getConn();
		
	 	Map<String,Object> acDebitDtlMap = new HashMap<String, Object>();

		//�����Ϣ
		AcLnDue acLnDue = (AcLnDue) JdbcDao.query(new AcLnDue(), "due_no='"+acLnMst.getLoanNo()+"'", "ln_due", operaInfo.getConn());

		//�ۿ��˻���Ϣ��
		List<LnAcct> lnAcctList = (ArrayList) JdbcDao.queryList(new LnAcct(), "app_id='"+acLnDue.getAppId()+"' and ac_use='1'", "ln_acct", operaInfo.getConn());
		
		double myFeeAmt = 0.00;//���շ�
		double otherFeeAmt = 0.00;//���շ�

		for(int i=0;i<acChrgLogList.size();i++){
			AcDebitDtl acDebitDtl = new AcDebitDtl();
			//����������Ϣ
			if("01".equals(acChrgLogList.get(i).getFeeKind())){//���շ���
				myFeeAmt = myFeeAmt+acChrgLogList.get(i).getChrgAmt();
			}else if("02".equals(acChrgLogList.get(i).getFeeKind())){//���շ���
				otherFeeAmt = otherFeeAmt+acChrgLogList.get(i).getChrgAmt();
			}
			if(virProjAcct!=null){
				acDebitDtl.setXtAcNo(virProjAcct.getAcctNo());//�����˺�
			}

			acDebitDtl.setTraceNo(operaInfo.getTraceNo());//������ˮ��
			acDebitDtl.setDdtlNo(ParmBiz.getAcDebitDtlNo(conn));//�ۿ���ϸ��ˮ��
			acDebitDtl.setLoanNo(acLnMst.getLoanNo());//��ݺ�
			acDebitDtl.setPactNo(acLnMst.getPactNo());//��ͬ��
			acDebitDtl.setBrNo(acLnMst.getBrNo());//������
			acDebitDtl.setPerdNo(acChrgLogList.get(i).getPerdNo());
			acDebitDtl.setDdtlPrcpAmt(0.00);//ʵ�۱���
			acDebitDtl.setDdtlNormInt(0.00);//ʵ����Ϣ
			acDebitDtl.setDdtlFineInt(0.00);//ʵ�۷�Ϣ
			acDebitDtl.setDdtlFeeAmt(acChrgLogList.get(i).getChrgAmt());//ʵ�۷����ܼ�
			acDebitDtl.setDdtlAmt(acChrgLogList.get(i).getChrgAmt());//ʵ���ܽ��
			if(lnAcctList.size()>0){
				acDebitDtl.setDdtlAcNo(lnAcctList.get(0).getAcNo());//�ۿ��˺�
				acDebitDtl.setDdtlAcName(lnAcctList.get(0).getAcName());//�˻�����
				acDebitDtl.setDdtlBankCode(lnAcctList.get(0).getBankCode());//�������д���
				acDebitDtl.setDdtlBankProv(lnAcctList.get(0).getBankProv());//������������ʡ
				acDebitDtl.setDdtlBankCity(lnAcctList.get(0).getBankCity());//��������������
				acDebitDtl.setDdtlBankSite(lnAcctList.get(0).getBankSite());//������������
				acDebitDtl.setDdtlSts(PUBConstant.DDTL_STS_PEND);//������
				acDebitDtl.setTxDate(operaInfo.getTxDt());//�Ǽ�����
				acDebitDtl.setTxTime(ParmBiz.getOracleTxTime(conn));//�Ǽ�ʱ��
			}else{
				throw new AccountingException("��ѯ������ݺ�Ϊ:"+acLnMst.getLoanNo()+"�Ŀۿ��˻���");
			}
			acDebitDtlList.add(acDebitDtl);
		}
		
		acDebitDtlMap.put("acDebitDtlList", acDebitDtlList);
		acDebitDtlMap.put("myFeeAmt", myFeeAmt);
		acDebitDtlMap.put("otherFeeAmt", otherFeeAmt);
		
		return acDebitDtlMap ;
	}
}