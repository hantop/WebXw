package  app.creditapp.acc.loan.bo.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import accounting.biz.pub.ParmBiz;
import accounting.domain.fee.AcChrgLog;
import accounting.plat.PUBConstant;
import accounting.plat.TransCode;
import accounting.plat.core.AccountingException;
import accounting.plat.dao.JdbcDao;
import accounting.plat.util.NumberUtil;
import app.base.BaseService;
import app.base.CreateKey;
import app.base.ServiceException;
import app.creditapp.acc.loan.bo.AcDebitBo;
import app.creditapp.acc.loan.dao.AcDebitDao;
import app.creditapp.acc.loan.dao.AcLoanBackLogDao;
import app.creditapp.acc.loan.dao.AcLoanLogDao;
import app.creditapp.acc.loan.entity.AcDebit;
import app.creditapp.acc.loan.entity.AcLoanBackLog;
import app.creditapp.acc.loan.entity.AcLoanLog;
import app.creditapp.acc.log.dao.AcTraceLogDao;
import app.creditapp.acc.log.entity.AcTraceLog;
import app.creditapp.corp.dao.CorpAcctDao;
import app.creditapp.corp.entity.CorpAcct;
import app.creditapp.inf.entity.ResponseParm;
import app.creditapp.inf.entity.WsIn2305;
import app.creditapp.inf.entity.WsOut2305_1;
import app.creditapp.ln.dao.LnAcctDao;
import app.creditapp.ln.dao.LnDueDao;
import app.creditapp.ln.entity.LnDue;
import app.creditapp.proj.dao.ProjAcctDao;
import app.oscache.CachecodeUtil;
import app.util.DateUtil;
import app.util.ruleFiter.entity.ValidateLog;
import app.util.ruleFiter.fiter.FiterEngineInterface;
import app.util.toolkit.Ipage;
/**
* Title: AcDebitBoImplImpl.java
* Description:
**/
public class AcDebitBoImpl extends BaseService implements AcDebitBo {

	private AcDebitDao acDebitDao;
	private AcLoanBackLogDao acLoanBackLogDao;
	private DataSource dataSource;
	private CorpAcctDao corpAcctDao;
	private AcTraceLogDao acTraceLogDao;
	private AcLoanLogDao acLoanLogDao;
	private LnDueDao lnDueDao;
	private ProjAcctDao projAcctDao;
	private LnAcctDao lnAcctDao;
	private FiterEngineInterface filterEngineInterface;

	public void del(AcDebit acDebit) throws ServiceException {
		try {
			acDebitDao.del(acDebit);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}

	public Ipage findByPage(Ipage ipg, AcDebit acDebit)
			throws ServiceException {
		try {
			ipg.initPageCounts(new Integer[] { (Integer) acDebitDao
					.getCount(acDebit) });// ��ʼ����ҳ��
			acDebit.setStartNumAndEndNum (ipg);
			ipg.setResult(acDebitDao.findByPage(acDebit));
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return ipg;
	}

	public AcDebit getById(AcDebit acDebit) throws ServiceException {
		try {
			acDebit = acDebitDao.getById(acDebit);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return acDebit;
	}
	
	public AcDebit getByDebitNo(AcDebit acDebit) throws ServiceException {
		try {
			acDebit = acDebitDao.getByDebitNo(acDebit);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return acDebit;
	}
	
	public void insert(AcDebit acDebit) throws ServiceException {
		try {
			acDebitDao.insert(acDebit);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}

	public void update(AcDebit acDebit) throws ServiceException {
		try {
			acDebitDao.update(acDebit);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}
	//��ʱ�ۿ�
		@Override
		public List<AcDebit> timDebit() throws ServiceException {
			Connection conn = this.getConnection();
			List<AcDebit> acDebitList = new ArrayList<AcDebit>();
			AcDebit acDebit = null;
			try {
				acDebit = new AcDebit();
				acDebit.setCreateDt(DateUtil.getSysDate());
				acDebitList = acDebitDao.timDebit(acDebit);
				for(AcDebit acDebitt:acDebitList){
					acDebitExec(acDebitt,conn);
				}	
			} catch (Exception e) {
				e.printStackTrace();
//				acDebitList = null;
				throw new ServiceException("��ʱ�ۿ���쳣");
			}finally{
				try {
					if(conn!=null) conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return acDebitList;
		}
		public void acDebitExec(AcDebit acDebit,Connection conn) throws ServiceException, AccountingException{
//			Connection conn = this.getConnection();
			//ҵ����ˮ
					AcTraceLog acTraceLog = new AcTraceLog();
					String traceNo =  acDebit.getTraceNo();
					//�ſ����Ϣ��
					AcLoanBackLog acLoanBackLog = new AcLoanBackLog();
					DecimalFormat df = new DecimalFormat("00");
					//�����Ϣ
					LnDue lnDue = new LnDue();
					lnDue.setPactNo(acDebit.getPactNo());
					lnDue.setBrNo(acDebit.getBrNo());
					lnDue = lnDueDao.getByPactNoAndBrNo(lnDue);
					
					List<AcChrgLog> acChrgLogList = (ArrayList)JdbcDao.queryList(new AcChrgLog(), "LOAN_NO='"+lnDue.getDueNo()+"' AND chrg_sts in ('01','02') and fee_kind = '"+PUBConstant.FEE_KIND_02+"'","ac_chrg_log", conn);
					
					List<AcLoanBackLog> acLoanBackLogList = new ArrayList<AcLoanBackLog>();
					
					String UUID  = CreateKey.getUUID();
					
					String backLogNo = ParmBiz.getAcLoanBackLogNo(conn) ;
					acLoanBackLog.setBackLogNo(backLogNo);
					acLoanBackLog.setBackCnt(ParmBiz.getBackCntSeq(conn));
					acLoanBackLog.setLoanLogNo(acDebit.getDebitNo());
					acLoanBackLog.setBackType(PUBConstant.BACK_TYPE_02);//�ۿ�
					acLoanBackLog.setBackRes("");
					acLoanBackLog.setFailCaus("");
					acLoanBackLog.setBackSts(PUBConstant.BACK_STS_01);//����״̬
					acLoanBackLog.setBusOrderType(acDebit.getBusEntryType().substring(0,3));
					acLoanBackLog.setBusEntryType(acDebit.getBusEntryType());
					acLoanBackLog.setTraceNo(acDebit.getTraceNo());//������ˮ
					acLoanBackLog.setUuid(CachecodeUtil.MFSPREFIX+UUID);
//					acLoanBackLog.setTxTime(ParmBiz.getOracleUpDate(conn));
					acLoanBackLogDao.insert(acLoanBackLog);
					acLoanBackLogList.add(acLoanBackLog);
					
					String busOrderType="";//ҵ�񶩵���������
					
					if(acDebit.getOtherFeeAmt()>0){//�����ô���0
						busOrderType="004";//������
					}else{
						busOrderType="003";//��������
					}
					
					//������շѽ�����0
					if(acDebit.getOtherFeeAmt()>0){
						CorpAcct corpAcct = new CorpAcct();
						corpAcct.setBrNo(lnDue.getBrNo());
						int bus = 2;
						for (AcChrgLog acChrgLog : acChrgLogList){
							String acNo = CachecodeUtil.MFSPREFIX+"_"+lnDue.getBrNo()+"_"+lnDue.getProjNo()+"_"+acChrgLog.getFeeType();
							corpAcct.setOpnAcno(acNo);
							corpAcct = corpAcctDao.getByBrNoAndAcNo(corpAcct);
							
							AcLoanLog acLoanLog = new AcLoanLog();
							acLoanLog.setLoanLogNo(ParmBiz.getLoanLogNo(conn));
							acLoanLog.setTraceNo(traceNo);
							acLoanLog.setLoanNo(lnDue.getDueNo());
							acLoanLog.setPactNo(lnDue.getPactNo());
							acLoanLog.setBrNo(lnDue.getBrNo());
//							acLoanLog.setLoanAmt(acDebit.getOtherFeeAmt());
							acLoanLog.setLoanAmt(NumberUtil.amtSubs(NumberUtil.amtSubs(acChrgLog.getChrgAmt(), acChrgLog.getRepayChrgAmt()),acChrgLog.getWvChrgAmt()));
							acLoanLog.setLoanAcNo(corpAcct.getOpnAcno());
							acLoanLog.setLoanAcType("12");
							acLoanLog.setLoanAcName(corpAcct.getAcName());
							acLoanLog.setLoanBankCode(corpAcct.getExchange());
							acLoanLog.setLoanBankProv(corpAcct.getProvince());
							acLoanLog.setLoanBankCity(corpAcct.getCity());
							acLoanLog.setLoanBankSite(corpAcct.getOpnBank());
							acLoanLog.setLoanSts("02");
							acLoanLog.setTxDate(ParmBiz.getBizDt(conn));
							acLoanLog.setTxTime(ParmBiz.getOracleTxTime(conn));
							acLoanLog.setCardChn("");
							acLoanLog.setXtAcNo(CachecodeUtil.MFSPREFIX+"_"+PUBConstant.ACCT_TYPE_04+"_"+lnDue.getProjNo());
							acLoanLog.setBusEntryType(busOrderType+String.valueOf(df.format(bus)));
							bus+=1;
							acLoanLogDao.insert(acLoanLog);
							
							acLoanBackLog = new AcLoanBackLog();
							acLoanBackLog.setBackLogNo(backLogNo);
							acLoanBackLog.setBackCnt(ParmBiz.getBackCntSeq(conn));
							acLoanBackLog.setLoanLogNo(acLoanLog.getLoanLogNo());
							acLoanBackLog.setBackType(PUBConstant.BACK_TYPE_01);//�ſ�
							acLoanBackLog.setBackRes("");
							acLoanBackLog.setFailCaus("");
							acLoanBackLog.setBackSts(PUBConstant.BACK_STS_01);
							acLoanBackLog.setBusOrderType(busOrderType);
							acLoanBackLog.setBusEntryType(acLoanLog.getBusEntryType());
							acLoanBackLog.setTraceNo(traceNo);//������ˮ
							acLoanBackLog.setUuid(CachecodeUtil.MFSPREFIX+UUID);
//							acLoanBackLog.setTxTime(ParmBiz.getOracleUpDate(conn));
							acLoanBackLogDao.insert(acLoanBackLog);
							acLoanBackLogList.add(acLoanBackLog);
						}
						
						
					}
					acTraceLog.setTraceNo(traceNo);
					acTraceLog.setTraceCnt(1);
					acTraceLog.setTxDt(ParmBiz.getBizDt(conn));
					acTraceLog.setTxTime(ParmBiz.getOracleUpDate(conn));
					acTraceLog.setTxBrNo(acDebit.getBrNo());
					acTraceLog.setTxCde(TransCode.LNC4);
					acTraceLog.setSubTxCde(TransCode.LNC4);
					acTraceLog.setSvcInd(TransCode.LNC4);
					acTraceLog.setCurNo(lnDue.getCurNo());
					acTraceLog.setPrdtNo(lnDue.getPrdtNo());
					acTraceLog.setAmt(acDebit.getAtpyAmt());
					acTraceLog.setCancelInd(PUBConstant.REV_ROL_NORM);//����
					acTraceLog.setAppSts("01");//����
					acTraceLog.setBrNo(lnDue.getBrNo());
					acTraceLog.setPactNo(lnDue.getPactNo());
					acTraceLog.setLoanNo(lnDue.getDueNo());
					acTraceLog.setMemo("A�ඨʱ�ۿ�");
					acTraceLogDao.insert(acTraceLog);
					
					acDebit.setSts("02");
					acDebitDao.update(acDebit);
						
//						Map returnMap = acDebitSuspBo.sendZfMes(acLoanBackLogList,lnDue.getProjNo(), traceNo, conn);
//						String payStatus = returnMap.get("ResultCode").toString();
//						int status = Integer.parseInt(payStatus);
//						if(status>=10000&&status<20000){
//						}else{//����ʧ����������һ������
//							createAcDebit(acDebit, conn);
//						}
		}
	private Connection getConnection() {

		Connection conn = null;
		try {
			conn = dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ServiceException(e);
		}
		return conn;
	}
	
	//�ӿ�ws2305У��
	public ResponseParm getresponse(WsIn2305 wsIn2305)throws ServiceException{
		ResponseParm responseParm = new ResponseParm();
		responseParm.setRespCode("0000");
		responseParm.setRespDesc("��������У��ͨ����");
		ValidateLog _vlws2305;
		//�ж� �������Ϣ 
		int countForW = 0;
		try {
			_vlws2305 = filterEngineInterface.createValidateLog("wsIn2305Id", wsIn2305,true);
			if(!_vlws2305.isSuccess()){
				responseParm.setRespCode("9004");
				responseParm.setRespDesc("У����ɣ��������ݸ�ʽ���ڴ���"+_vlws2305.getErrorMessage());
			}else{
				AcDebit wsIn2305forsearch = new AcDebit();
				//�ж� ��������  �� ��ͬ�� ����ͬʱΪ��
				if(wsIn2305.getTxDate()==0 && (wsIn2305.getPactNo()==null || "".equals(wsIn2305.getPactNo()))){
					responseParm.setRespCode("9004");
					responseParm.setRespDesc("�������ݱ��� ���� ��������(txDate) �� ��ͬ��(pactNo)");
				}else if(wsIn2305.getPactNo()!=null && !"".equals(wsIn2305.getPactNo())){
					//������� ��ͬ�� ��Ϊ�գ�ֱ������ �������ڵ�У��
					wsIn2305forsearch.setPactNo(wsIn2305.getPactNo());
					wsIn2305forsearch.setBrNo(wsIn2305.getBrNo());
					countForW = 1;
				}else if(wsIn2305.getTxDate()!=0){
					//�� ���� ��Ϣ�� ������ ��ͬ��ʱ����Ҫ������� �������� ��ʽ����У��
					int leng = String.valueOf(wsIn2305.getTxDate()).trim().length();
					if(leng!=8){
						responseParm.setRespCode("9004");
						responseParm.setRespDesc("��������(txDate) ���Ȳ�Ϊ8λ��");
					}else{
						wsIn2305forsearch.setTxDt(String.valueOf(wsIn2305.getTxDate()).trim());
						wsIn2305forsearch.setBrNo(wsIn2305.getBrNo());
						countForW = 2;
					}
				}
				//������ ��ͬ��  �� �������� ����һ��
				if(countForW != 0 ){
					int count = acDebitDao.getCountFor2305(wsIn2305forsearch);	
					if(count == 0 ){
						responseParm.setRespCode("2990");
						if(countForW == 2){
							responseParm.setRespDesc("��������Ϊ�� "+wsIn2305.getTxDate()+"  �ļ�¼�����ڣ�");
						}else{
							responseParm.setRespDesc("��ͬ��Ϊ�� "+wsIn2305.getPactNo()+"  �ļ�¼�����ڣ�");
						}
					}else{
						
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return responseParm;
	}
	//�ӿ�ws2302��ҳ��ѯʵ�ַ���
	public Ipage findByPageforws2305(Ipage ipg, AcDebit acDebit)throws ServiceException {
		try {
			ipg.initPageCounts(new Integer[] { (Integer) acDebitDao.getCountFor2305(acDebit) });// ��ʼ����ҳ��
			acDebit.setStartNumAndEndNum(ipg);
			List<WsOut2305_1> wsOut2305_1list = acDebitDao.findByPageFor2305(acDebit);
			WsOut2305_1 wsOut2305_1 = new WsOut2305_1();
			
			for(int i=0;i<wsOut2305_1list.size();i++){
				wsOut2305_1 = wsOut2305_1list.get(i);
				String dealDesc = wsOut2305_1.getDealSts();
					if(dealDesc == null || "".equals(dealDesc)){
						wsOut2305_1list.get(i).setDealSts("");	
					}
				}
			//��ȡ��ҳ����б���ɷ�ҳ����
			ipg.setResult(wsOut2305_1list);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	return ipg;
	}
	//�ӿ�ws2305��ȡ��������������
	public int getCountforws2305(AcDebit acDebit) throws ServiceException {
		int count = 0;
		try {
			count = acDebitDao.getCountFor2305(acDebit);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return count;
	}
	
	public AcDebitDao getAcDebitDao() {
		return acDebitDao;
	}

	public void setAcDebitDao(AcDebitDao acDebitDao) {
		this.acDebitDao = acDebitDao;
	}

	public AcLoanBackLogDao getAcLoanBackLogDao() {
		return acLoanBackLogDao;
	}

	public void setAcLoanBackLogDao(AcLoanBackLogDao acLoanBackLogDao) {
		this.acLoanBackLogDao = acLoanBackLogDao;
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public CorpAcctDao getCorpAcctDao() {
		return corpAcctDao;
	}

	public void setCorpAcctDao(CorpAcctDao corpAcctDao) {
		this.corpAcctDao = corpAcctDao;
	}

	public AcTraceLogDao getAcTraceLogDao() {
		return acTraceLogDao;
	}

	public void setAcTraceLogDao(AcTraceLogDao acTraceLogDao) {
		this.acTraceLogDao = acTraceLogDao;
	}

	public AcLoanLogDao getAcLoanLogDao() {
		return acLoanLogDao;
	}

	public void setAcLoanLogDao(AcLoanLogDao acLoanLogDao) {
		this.acLoanLogDao = acLoanLogDao;
	}

	public LnDueDao getLnDueDao() {
		return lnDueDao;
	}

	public void setLnDueDao(LnDueDao lnDueDao) {
		this.lnDueDao = lnDueDao;
	}

	public ProjAcctDao getProjAcctDao() {
		return projAcctDao;
	}

	public void setProjAcctDao(ProjAcctDao projAcctDao) {
		this.projAcctDao = projAcctDao;
	}

	public LnAcctDao getLnAcctDao() {
		return lnAcctDao;
	}

	public void setLnAcctDao(LnAcctDao lnAcctDao) {
		this.lnAcctDao = lnAcctDao;
	}

	public FiterEngineInterface getFilterEngineInterface() {
		return filterEngineInterface;
	}

	public void setFilterEngineInterface(FiterEngineInterface filterEngineInterface) {
		this.filterEngineInterface = filterEngineInterface;
	}
	
}