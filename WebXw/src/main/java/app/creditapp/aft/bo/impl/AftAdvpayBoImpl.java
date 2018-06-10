package  app.creditapp.aft.bo.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import accounting.biz.loan.RepayBiz;
import accounting.biz.pub.AcLnRepayPlnBiz;
import accounting.biz.pub.ParmBiz;
import accounting.domain.fee.AcChrgLog;
import accounting.domain.sys.OperaInfo;
import accounting.interf.loan.CalIntst;
import accounting.interf.loan.IntstDetailDatas;
import accounting.plat.PUBConstant;
import accounting.plat.TransCode;
import accounting.plat.core.Operation;
import accounting.plat.core.OperationFactory;
import accounting.plat.util.NumberUtil;
import accounting.plat.util.TimeUtil;
import app.base.BaseService;
import app.base.CreateKey;
import app.base.ServiceException;
import app.creditapp.acc.loan.bo.AcDebitSuspBo;
import app.creditapp.acc.loan.dao.AcDebitDao;
import app.creditapp.acc.loan.dao.AcLnMstDao;
import app.creditapp.acc.loan.dao.AcLnRepayPlnCurDao;
import app.creditapp.acc.loan.dao.AcLoanBackLogDao;
import app.creditapp.acc.loan.dao.AcLoanLogDao;
import app.creditapp.acc.loan.entity.AcDebit;
import app.creditapp.acc.loan.entity.AcLnMst;
import app.creditapp.acc.loan.entity.AcLnRepayPlnCur;
import app.creditapp.acc.loan.entity.AcLoanBackLog;
import app.creditapp.acc.loan.entity.AcLoanLog;
import app.creditapp.acc.log.dao.AcChrgLogDao;
import app.creditapp.acc.log.dao.AcTraceLogDao;
import app.creditapp.acc.log.entity.AcTraceLog;
import app.creditapp.acc.option.bo.AcDamFormulaBo;
import app.creditapp.acc.option.dao.AcLnSetlmtLogDao;
import app.creditapp.acc.option.entity.AcLnSetlmtLog;
import app.creditapp.aft.bo.AftAdvpayBo;
import app.creditapp.aft.dao.AftAdvpayDao;
import app.creditapp.aft.entity.AftAdvpay;
import app.creditapp.corp.dao.CorpAcctDao;
import app.creditapp.inf.dao.WsElyRepyDao;
import app.creditapp.inf.entity.ResponseParm;
import app.creditapp.inf.entity.WsElyRepy;
import app.creditapp.inf.entity.WsIn2806;
import app.creditapp.inf.entity.WsIn2806_1;
import app.creditapp.inf.entity.WsOut2806;
import app.creditapp.ln.dao.LnAcctDao;
import app.creditapp.ln.dao.LnDueDao;
import app.creditapp.ln.entity.LnAcct;
import app.creditapp.ln.entity.LnDue;
import app.creditapp.proj.dao.ProjAcctDao;
import app.oscache.CachecodeUtil;
import app.util.ruleFiter.entity.ValidateLog;
import app.util.ruleFiter.fiter.FiterEngineInterface;
import app.util.toolkit.Ipage;
/**
* Title: AftAdvpayBoImplImpl.java
* Description:
**/
public class AftAdvpayBoImpl extends BaseService implements AftAdvpayBo {

	private AftAdvpayDao aftAdvpayDao;
	private AcLnMstDao acLnMstDao;
	private DataSource dataSource;
	private AcDamFormulaBo acDamFormulaBo;
	private AcTraceLogDao acTraceLogDao;
	private AcLnSetlmtLogDao acLnSetlmtLogDao;
	private AcLnRepayPlnCurDao acLnRepayPlnCurDao;
	private FiterEngineInterface fiterEngineInterface;
	private WsElyRepyDao wsElyRepyDao;
	private AcDebitDao acDebitDao;
	private LnDueDao lnDueDao;
	private ProjAcctDao projAcctDao;
	private LnAcctDao lnAcctDao;
	private AcLoanBackLogDao acLoanBackLogDao;
	private CorpAcctDao corpAcctDao;
	private AcLoanLogDao acLoanLogDao;
	private AcDebitSuspBo acDebitSuspBo;
	private AcChrgLogDao acChrgLogDao;

	public AcLnRepayPlnCurDao getAcLnRepayPlnCurDao() {
		return acLnRepayPlnCurDao;
	}

	public void setAcLnRepayPlnCurDao(AcLnRepayPlnCurDao acLnRepayPlnCurDao) {
		this.acLnRepayPlnCurDao = acLnRepayPlnCurDao;
	}

	/*
	 * ��ǰ���� ȷ��
	 * (non-Javadoc)
	 * @see app.creditapp.aft.bo.AftAdvpayBo#execAdvpay(app.creditapp.aft.entity.AftAdvpay)
	 */
	public void execAdvpay(AftAdvpay aftAdvpay) throws ServiceException{
		System.out.println("������ǰ���� ȷ�Ϸ���execAdvpay()");
		Connection conn = this.getConnection();
		List<AcChrgLog> acChrgLogList = new ArrayList<AcChrgLog>();
		DecimalFormat df  = new DecimalFormat("00");
		try {
			String bizDt = aftAdvpay.getPayDate();//��������
			String txDt = ParmBiz.getBizDt(conn);//ϵͳ����
			if(aftAdvpay.getPayDate()==null || aftAdvpay.getPayDate().length()==0){//������Ϊ��,��Ĭ�ϵ��컹��
				aftAdvpay.setPayDate(bizDt);
			}
			// ��Ϣ����
			AcLnMst acLnMst = new AcLnMst();
			acLnMst.setPactNo(aftAdvpay.getPactNo());
			acLnMst.setBrNo(aftAdvpay.getBrNo());
			acLnMst = acLnMstDao.getByPactNo(acLnMst);
			CalIntst calIntst = new CalIntst();
			calIntst.setLoanNo(acLnMst.getLoanNo());
			
			//ȫ���
			if("01".equals(aftAdvpay.getRepType())){
				aftAdvpay.setPayAmt(acLnMst.getLoanBal());
				calIntst.setRemAmt(acLnMst.getLoanBal());
				//�����Ϣ
				LnDue lnDue = new LnDue();
				lnDue.setPactNo(aftAdvpay.getPactNo());
				lnDue.setBrNo(aftAdvpay.getBrNo());
				lnDue = lnDueDao.getByPactNoAndBrNo(lnDue);
				lnDue.setDueSts("07");
				lnDueDao.dueStsUpdate(lnDue); //���·ſ��ݱ�Ľ��״̬-su
			}else{//���ֻ���
				calIntst.setRemAmt(aftAdvpay.getPayAmt());
				
			}
			calIntst.setTxDt(txDt);  //ϵͳʱ��
			calIntst.setBizDt(bizDt);  //��������
			
			String traceNo = acTraceLogDao.getKey();
			
			Operation op = (Operation) OperationFactory.getFactoryInstance().getOperation(TransCode.XROR, conn);
			IntstDetailDatas datas = (IntstDetailDatas) op.execute(calIntst);
			//Ƿ��+ǷϢ+��Ϣ+0��ac_ln_lo�������ڵĻ����ڴ�
			double sumLoAmt = NumberUtil.amtAdd(NumberUtil.amtAdd(datas.getPrcpAmt(), NumberUtil.amtAdd(datas.getNormInt(), datas.getFineInt())),datas.getLoFeeAmt());
			// ΥԼ�����
//			double damAmt = acDamFormulaBo.getDamAmtInAftAdvpay(aftAdvpay,acLnMst,conn,traceNo);
			acChrgLogList = acDamFormulaBo.getDamAmtInAftAdvpay(aftAdvpay,acLnMst,traceNo);
			double feeTotal = 0;//���úϼ�
			double damAmt = 0;// ΥԼ�����
			double premAmt = 0;//����
			double serAmt = 0;//�����
			for(AcChrgLog acChrgLog :acChrgLogList){
				if(PUBConstant.FEE_TYPE_06.equals(acChrgLog.getFeeType())){
					damAmt = NumberUtil.amtAdd(damAmt, acChrgLog.getChrgAmt());
				}
				if(PUBConstant.FEE_TYPE_01.equals(acChrgLog.getFeeType())){
					serAmt = NumberUtil.amtAdd(serAmt, acChrgLog.getChrgAmt());
				}
				if(PUBConstant.FEE_TYPE_02.equals(acChrgLog.getFeeType())){
					premAmt = NumberUtil.amtAdd(premAmt, acChrgLog.getChrgAmt());
				}
				feeTotal = NumberUtil.amtAdd(feeTotal, acChrgLog.getChrgAmt()); //1150��
			}

			AcLnRepayPlnCur acCur = new AcLnRepayPlnCur();
			acCur.setLoanNo(acLnMst.getLoanNo());
			acCur = acLnRepayPlnCurDao.getById(acCur);
			//���ڹ黹��Ϣ
			double norm = NumberUtil.amtSubs(NumberUtil.amtSubs(acCur.getNormInt(), acCur.getRepayNormInt()),acCur.getWvNormInt());
			
			double normInt = NumberUtil.isAmtGreatAndEqual(datas.getCurInt(), norm)?datas.getCurInt():norm;
//			normInt = NumberUtil.amtSubs(normInt, acCur.getRepayNormInt());
			AcTraceLog acTraceLog = new AcTraceLog();
			//Ƿ��������+���ڷ���+���ڻ�����+���ڻ���Ϣ
			double sumAmt = NumberUtil.amtAdd(NumberUtil.amtAdd(NumberUtil.amtAdd(sumLoAmt, feeTotal),norm),datas.getRemPrcpAmt());

			AcLnSetlmtLog acLnSetlmtLog = new AcLnSetlmtLog();
			acLnSetlmtLog.setTraceNo(traceNo);
			acLnSetlmtLog.setLoanNo(acLnMst.getLoanNo());
			acLnSetlmtLog.setPactNo(acLnMst.getPactNo());
			acLnSetlmtLog.setBrNo(acLnMst.getBrNo());
			acLnSetlmtLog.setRecvAmt(sumAmt);
			acLnSetlmtLog.setRecvDt(aftAdvpay.getPayDate());
			acLnSetlmtLog.setDamAmt(damAmt);
			acLnSetlmtLog.setCurInt(norm);
			acLnSetlmtLog.setRemPrcpAmt(aftAdvpay.getPayAmt());
			acLnSetlmtLog.setRepayType(aftAdvpay.getRepayType());
			// ����ƻ�����б��
			OperaInfo operaInfo = new OperaInfo(conn);
			operaInfo.setTraceNo(traceNo);
			AcLnRepayPlnBiz.aftAdvpayChangeRepln(acLnSetlmtLog, operaInfo);
			operaInfo.getConn().commit();

			acLnSetlmtLogDao.insert(acLnSetlmtLog);

			if("01".equals(aftAdvpay.getOnlinOff())){//����
				System.out.println("���ϻ���ȴ���������������");
			}else if("02".equals(aftAdvpay.getOnlinOff())){//���� 184��
				accounting.domain.loan.AcDebit acd = new accounting.domain.loan.AcDebit();
				acd.setLoanNo(acLnMst.getLoanNo());
				acd.setRepayAmt(sumAmt);//��ǰ����Ӧ�۽��
				acd.setLoAmt(sumLoAmt);
				acd.setTraceNo(traceNo);
//				acd.setCurAmt(acDebit.getCurAmt());
				operaInfo.setTraceCnt(1);
				operaInfo.setBizDt(bizDt);  //����ʱ��
				operaInfo.setTxDt(txDt);  //ϵͳʱ��
				
				//��ȡ���ڻ���
				AcLnRepayPlnCur acLnRepayPlnCur = new AcLnRepayPlnCur();
				acLnRepayPlnCur.setLoanNo(acLnMst.getLoanNo());
				acLnRepayPlnCur = acLnRepayPlnCurDao.getById(acLnRepayPlnCur);
				
				accounting.domain.loan.AcLnRepayPlnCur acLC = new accounting.domain.loan.AcLnRepayPlnCur();
				acLC.setPrcpAmt(acLnRepayPlnCur.getPrcpAmt());
				acLC.setRepayPrcpAmt(acLnRepayPlnCur.getRepayPrcpAmt());
				acLC.setNormInt(acLnRepayPlnCur.getNormInt());
				acLC.setRepayNormInt(acLnRepayPlnCur.getRepayNormInt());
				acLC.setWvPrcpAmt(acLnRepayPlnCur.getWvPrcpAmt());
				acLC.setWvNormInt(acLnRepayPlnCur.getWvNormInt());
				RepayBiz.repayAmtOrder(acLC, acd, operaInfo, conn);
				
				//453
				aftAdvpay.setTraceNo(traceNo);
				aftAdvpay.setIntst(datas.getFineInt());
//				aftAdvpay.setAcName(lnAcct.getAcName());
//				aftAdvpay.setAcNo(lnAcct.getAcNo());
//				aftAdvpay.setAcType(lnAcct.getAcType());
				aftAdvpay.setPactAmt(acLnMst.getLoanAmt());
				aftAdvpay.setRepSts("02");
				aftAdvpay.setTxDate(ParmBiz.getBizDt(conn));
				aftAdvpayDao.update(aftAdvpay);
				
				WsElyRepy wsElyRepy = new WsElyRepy();
				wsElyRepy.setWsId(aftAdvpay.getRepId());
				wsElyRepy = wsElyRepyDao.getById(wsElyRepy);
				wsElyRepy.setDealDesc("����ɹ�");
				wsElyRepy.setDealSts("03");
				
				wsElyRepyDao.updateStsAndDesc(wsElyRepy);
				
				
				AcDebit acDebit1 = new AcDebit();
				acDebit1.setLoanNo(acLnMst.getLoanNo());
				acDebit1.setSts("01");
				
				acDebitDao.delByLoanNoAndSts(acDebit1);//������ǰ�����ɾ��δ��������
				System.out.println("�Ѿ��ߵ������");
			}
			
			acTraceLog.setTraceNo(traceNo);
			acTraceLog.setTraceCnt(1);
			acTraceLog.setTxDt(bizDt);
			acTraceLog.setTxTime(ParmBiz.getOracleUpDate(conn));
			acTraceLog.setTxBrNo(aftAdvpay.getBrNo());
			acTraceLog.setTxCde("01".equals(aftAdvpay.getOnlinOff())?TransCode.LNAD:TransCode.LNRP);
			acTraceLog.setSubTxCde(TransCode.LNAD);
			acTraceLog.setSvcInd(TransCode.LNAD);
			acTraceLog.setBrNo(aftAdvpay.getBrNo());
			acTraceLog.setPactNo(aftAdvpay.getPactNo());
			acTraceLog.setLoanNo(acLnMst.getLoanNo());
			acTraceLog.setMemo("��ǰ����");
			acTraceLogDao.insert(acTraceLog);
			
			
			
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		} finally {
            try {
                if(conn!=null) conn.close();
            } catch (SQLException e) {
            	throw new ServiceException(e.getMessage());
            }
        }
		
		
	}
	
	/*
	 *	��ǰ���� ���� 
	 */
	@Override
	public WsOut2806 calcAdvpay(AftAdvpay aftAdvpay) throws ServiceException{
		System.out.println("������ǰ���� ���㷽��calcAdvpay()");
		Connection conn = this.getConnection();
		WsOut2806 wsOut = new WsOut2806();
		try {
			String bizDt = ParmBiz.getBizDt(conn);//��������
			List<AcChrgLog> acChrgLogList = new ArrayList<AcChrgLog>();
			//��Ϣ����
			AcLnMst acLnMst = new AcLnMst();
			acLnMst.setPactNo(aftAdvpay.getPactNo());
			acLnMst.setBrNo(aftAdvpay.getBrNo());
			acLnMst = acLnMstDao.getByPactNo(acLnMst);
			CalIntst calIntst = new CalIntst();
			//ȫ���
			if("01".equals(aftAdvpay.getRepType())){
				calIntst.setRemAmt(acLnMst.getLoanBal());
				aftAdvpay.setPayAmt(acLnMst.getLoanBal());
			}else{//���ֻ���
				calIntst.setRemAmt(aftAdvpay.getPayAmt()); //�������
			}
			calIntst.setLoanNo(acLnMst.getLoanNo());
			
			calIntst.setTxDt(bizDt);//ϵͳ����
			calIntst.setBizDt(aftAdvpay.getPayDate());  //�������ڣ���ҳ���ύ������
			Operation op = (Operation) OperationFactory.getFactoryInstance()
					.getOperation(TransCode.XROR, conn);
//			long days = DateUtil.getDaysBetween(acLnMst.getOpnDt(), aftAdvpay.getPayDate());
			String betwDays = String.valueOf(TimeUtil.getBetweenDays(acLnMst
					.getOpnDt(), aftAdvpay.getPayDate()));
			long day = Integer.parseInt(betwDays);
			if(day < 0){
				throw new ServiceException("��������С�ڷſ��������ڣ��޷�����");
			}
			IntstDetailDatas datas = (IntstDetailDatas) op.execute(calIntst);
			//Ƿ��ϼ� 6+7+8+9
			double sumLoAmt = NumberUtil.amtAdd(NumberUtil.amtAdd(datas.getPrcpAmt(), NumberUtil.amtAdd(datas.getNormInt(), datas.getFineInt())),datas.getLoFeeAmt());
			//ΥԼ�� �����ü��㣨���ڣ�
			acChrgLogList = acDamFormulaBo.getDamAmtInAftAdvpay(aftAdvpay,acLnMst,null);
			double feeTotal = 0;//���úϼ�
			double damAmt = 0;// ΥԼ�����
			double premAmt = 0;//����
			double serAmt = 0;//�����
		
			for(AcChrgLog acChrgLog :acChrgLogList){
				if(PUBConstant.FEE_TYPE_06.equals(acChrgLog.getFeeType())){
					damAmt = NumberUtil.amtAdd(damAmt, acChrgLog.getChrgAmt());
				}
				if(PUBConstant.FEE_TYPE_01.equals(acChrgLog.getFeeType())){
					serAmt = NumberUtil.amtAdd(serAmt, acChrgLog.getChrgAmt());
				}
				if(PUBConstant.FEE_TYPE_02.equals(acChrgLog.getFeeType())){
					premAmt = NumberUtil.amtAdd(premAmt, acChrgLog.getChrgAmt());
				}
				feeTotal = NumberUtil.amtAdd(feeTotal, acChrgLog.getChrgAmt());
			}
			
			AcLnRepayPlnCur acCur = new AcLnRepayPlnCur();
			acCur.setLoanNo(acLnMst.getLoanNo());
			acCur = acLnRepayPlnCurDao.getById(acCur);
			//������Ϣ
			double norm = NumberUtil.amtSubs(NumberUtil.amtSubs(acCur.getNormInt(), acCur.getRepayNormInt()),acCur.getWvNormInt());
			
			double normInt = NumberUtil.isAmtGreatAndEqual(datas.getCurInt(), norm)?datas.getCurInt():norm;
//			normInt = NumberUtil.amtSubs(normInt, acCur.getRepayNormInt());
			
			wsOut.setBrNo(acLnMst.getBrNo());
			wsOut.setPactNo(acLnMst.getPactNo());
			wsOut.setPayDate(aftAdvpay.getPayDate());
			wsOut.setPayAmt(aftAdvpay.getPayAmt());//�����
			wsOut.setPayTotal(sumLoAmt);//Ƿ��������
			wsOut.setPayAmt2(datas.getPrcpAmt());//Ƿ��
			wsOut.setPayInte(datas.getNormInt());//ǷϢ
			wsOut.setPayOver(datas.getFineInt());//��Ϣ
			wsOut.setPayFee(datas.getLoFeeAmt());
			wsOut.setCurInte(norm);//�黹��Ϣ        ����δ���˵�Ӧ����Ϣ
			wsOut.setPremAmt(premAmt);//����  	����δ���˵�Ӧ����
			wsOut.setSerAmt(serAmt);//�����  	����δ���˵�Ӧ�����
			wsOut.setPayDam(damAmt);//��ǰ����ΥԼ��
			wsOut.setFeeTotal(feeTotal);//���ڷ����ܶ� 	����δ���˵�Ӧ�շ����+����+ΥԼ��
			wsOut.setCurAmt(datas.getCurPrcpAmt());//�黹����        ����δ���˵�Ӧ�ձ���
			wsOut.setBal(NumberUtil.amtSubs(acLnMst.getLoanBal(), aftAdvpay.getPayAmt()));//ʣ�౾��
			wsOut.setTotalAmt(NumberUtil.amtAdd(NumberUtil.amtAdd(NumberUtil.amtAdd(sumLoAmt, feeTotal),normInt),aftAdvpay.getPayAmt()));//��ǰ�����軹�ܽ��
		
			System.out.println("��������-->" + aftAdvpay.getPayDate());
			System.out.println("��ǰ��������-->" + ParmBiz.getBizDt(conn));
			System.out.println("�����軹���ܶ�-->" + NumberUtil.amtAdd(NumberUtil.amtAdd(NumberUtil.amtAdd(sumLoAmt, feeTotal),normInt),aftAdvpay.getPayAmt()));
			System.out.println("Ƿ���ܶ�-->" + sumLoAmt);
			System.out.println("Ƿ���-->" + datas.getPrcpAmt());
			System.out.println("Ƿ������Ϣ-->" + datas.getNormInt());
			System.out.println("������Ϣ-->" + datas.getFineInt());
			System.out.println("Ƿ����-->" + datas.getLoFeeAmt());
			System.out.println("��ǰ�������-->" + datas.getRemPrcpAmt());
			System.out.println("���������ڵĵ�����Ϣ-->" + norm);
			System.out.println("ΥԼ��-->" + damAmt);
			System.out.println("�����-->" + serAmt);
			System.out.println("����-->" + premAmt);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		} finally {
            try {
                if(conn!=null) conn.close();
            } catch (SQLException e) {
            	throw new ServiceException(e.getMessage());
            }
        }
		
		return wsOut;
	}
	
	@Override
	public WsOut2806 calcu(WsIn2806_1 wsIn2806_1) throws ServiceException {
		ValidateLog _vl;
		AftAdvpay aftAdvaday = new AftAdvpay();
		WsOut2806 wsOut2806 = new WsOut2806();

		try {
			if(wsIn2806_1.getPayDate().equals("")||wsIn2806_1.getPayDate() == null){
				throw new ServiceException("��������Ϊ�գ���������д��");
			}
			
//			_vl = fiterEngineInterface.createValidateLog("wsIn2806Id", wsIn2806_1, true);	
//			if(!_vl.isSuccess()){
//				throw new ServiceException("����У��ʧ�ܣ���������д");
//			}
			aftAdvaday.setPayDate(wsIn2806_1.getPayDate());
			aftAdvaday.setBrNo(wsIn2806_1.getBrNo());
			aftAdvaday.setPactNo(wsIn2806_1.getPactNo());
			aftAdvaday.setRepType(wsIn2806_1.getRepType());
			aftAdvaday.setPayAmt(wsIn2806_1.getPayAmt());
			AcLnMst aclnmst1 = new AcLnMst();
			aclnmst1.setPactNo(wsIn2806_1.getPactNo());
			aclnmst1.setBrNo(wsIn2806_1.getBrNo());
			AcLnMst aclnmst = acLnMstDao.getByPactNo(aclnmst1);
			if(aclnmst == null){
				throw new ServiceException(wsIn2806_1.getPactNo()+"��ͬ��Ϣ�����ڣ�");
			}
			wsOut2806 = calcAdvpay(aftAdvaday);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}	
		return wsOut2806;
	}

	//��ǰ����ӿ� AFT_ADVPAY��ҵ���߼�-sunmingyi  20160801
	public void insertAftAdvPay(String BatchNo) throws ServiceException {
		Connection conn = this.getConnection();
		int count = 0;
		try {
			
			WsElyRepy wsElyRepy = new WsElyRepy();
			wsElyRepy.setBatchNo(BatchNo);
			wsElyRepy = wsElyRepyDao.getByBatchNo(wsElyRepy);
			
			//�������ļ�ac_ln_mst�����Ҵ���״̬Ϊ01,02,03
			AcLnMst acLnMst = new AcLnMst();
			acLnMst.setBrNo(wsElyRepy.getBrNo());
			acLnMst.setPactNo(wsElyRepy.getPactNo());
			acLnMst = acLnMstDao.getByPactNo(acLnMst);
			
			AftAdvpay aft = new AftAdvpay();
			aft.setPactNo(wsElyRepy.getPactNo());
			aft.setTxDate(ParmBiz.getBizDt(conn));
			count = aftAdvpayDao.getSucByTxDate(aft);
			if(NumberUtil.isAmtGreatThanZero(count)){
				//����WS������ʧ��
				throw new ServiceException("���캬�д���ɹ�����ǰ����");

			}
			
			if (acLnMst != null) {
				if("01".equals(acLnMst.getLoanSts()) ||"02".equals(acLnMst.getLoanSts()) 
						||"03".equals(acLnMst.getLoanSts())){//���ļ�״̬Ϊ01/02/03���ܿۿ�
				}else{
					//����WS������ʧ��
					throw new ServiceException("�������ļ�������������");

					
				}
				//������ǰ����02
				if("02".equals(wsElyRepy.getDebitType())){
					if(NumberUtil.isAmtGreat(wsElyRepy.getPayAmt(), acLnMst.getLoanBal())||NumberUtil.isAmtLessThanOrEqualZero(wsElyRepy.getPayAmt())){
						//����WS������ʧ��
						throw new ServiceException("��ǰ����������С�ڵ��ڴ�������Ҵ���0���������Ϊ:"+acLnMst.getLoanBal());

					}
				}				
				AcLnRepayPlnCur acCur = new AcLnRepayPlnCur();
				acCur.setLoanNo(acLnMst.getLoanNo());
				acCur = acLnRepayPlnCurDao.getById(acCur);
				if(acCur==null){
					//����WS������ʧ��
					throw new ServiceException("��ͬ:"+acLnMst.getPactNo()+"���һ�ڻ���ƻ��Ѿ����ڲ��ܷ�����ǰ���");
				}
			} else  {
				//����WS������ʧ��
				throw new ServiceException("�������ļ�������");
			}

			//�ۿ��ļ������ж�
			AcDebit acDebit = new AcDebit();
			acDebit.setLoanNo(acLnMst.getLoanNo());
			acDebit = acDebitDao.getByLoanNoIng(acDebit);
			if(acDebit != null){
				throw new ServiceException("��ͬ��:"+acLnMst.getPactNo()+"����δ���Ŀۿ��¼,�����ٴη���ۿ");
			}
			
			wsElyRepy.setDealDesc("������");
			wsElyRepy.setDealSts("02");
			wsElyRepyDao.update(wsElyRepy);
			
			AftAdvpay aftAdvpay = new AftAdvpay();
			aftAdvpay.setRepId(wsElyRepy.getWsId());  //����20
			aftAdvpay.setPactNo(wsElyRepy.getPactNo());
			aftAdvpay.setBrNo(wsElyRepy.getBrNo());
			aftAdvpay.setPayAmt(wsElyRepy.getPayAmt());
			aftAdvpay.setOnlinOff(wsElyRepy.getOnlinOff());  //02
			aftAdvpay.setRepType(wsElyRepy.getDebitType());  //02
			aftAdvpay.setRepSts(wsElyRepy.getDealSts());
			aftAdvpay.setPayDate(wsElyRepy.getTxDate());
			aftAdvpayDao.insert(aftAdvpay);
			
			//ɾ���ý�ݴ����������ļ�,A���������ɾ��,B����������޴���������
			AcDebit ac = new AcDebit();
			ac.setLoanNo(acLnMst.getLoanNo());
			ac.setSts("01");
			acDebitDao.delByLoanNoAndSts(ac);
			
			//ִ��ҵ����
			execAdvpay(aftAdvpay);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}finally {
            try {
                if(conn!=null) conn.close();
            } catch (SQLException e) {
            	throw new ServiceException(e.getMessage());
            }
        }
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
	
	/**
	 * @���� DHCC-ZKX
	 * @���� July 20, 2016
	 * @����˵�����ӿ�ws2806����rule-WsIn2806.xmlУ�����
	 * @���ز��� ��Ӧ����ʵ��ResponseParm
	 */
	public ResponseParm validateWsIn(WsIn2806 wsIn2806) throws ServiceException{
		ResponseParm responseParm = new ResponseParm();
		responseParm.setRespCode("0000");
		ValidateLog _vl;
		try {
			_vl = fiterEngineInterface.createValidateLog("wsIn2806Id", wsIn2806, true);	
			if(!_vl.isSuccess()){
				responseParm.setRespCode("9004");
				responseParm.setRespDesc(_vl.getErrorMessage());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return responseParm; 
	}
	
	public void del(AftAdvpay aftAdvpay) throws ServiceException {
		try {
			aftAdvpayDao.del(aftAdvpay);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}

	public Ipage findByPage(Ipage ipg, AftAdvpay aftAdvpay)
			throws ServiceException {
		try {
			ipg.initPageCounts(new Integer[] { (Integer) aftAdvpayDao
					.getCount(aftAdvpay) });// ��ʼ����ҳ��
			aftAdvpay.setStartNumAndEndNum (ipg);
			ipg.setResult(aftAdvpayDao.findByPage(aftAdvpay));
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return ipg;
	}

	public AftAdvpay getById(AftAdvpay aftAdvpay) throws ServiceException {
		try {
			aftAdvpay = aftAdvpayDao.getById(aftAdvpay);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return aftAdvpay;
	}
	public AftAdvpay getByIdForTrace(AftAdvpay aftAdvpay) throws ServiceException {
		try {
			aftAdvpay = aftAdvpayDao.getByIdForTrace(aftAdvpay);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return aftAdvpay;
	}

	public void insert(AftAdvpay aftAdvpay) throws ServiceException {
		try {
			/**
			 * 
			 * ���������˻�����ı��ID������
			 */
			aftAdvpay.setRepId(aftAdvpayDao.getKey());
			aftAdvpayDao.insert(aftAdvpay);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}

	public void update(AftAdvpay aftAdvpay) throws ServiceException {
		try {
			aftAdvpayDao.update(aftAdvpay);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}

	public AftAdvpayDao getAftAdvpayDao() {
		return aftAdvpayDao;
	}

	public void setAftAdvpayDao(AftAdvpayDao aftAdvpayDao) {
		this.aftAdvpayDao = aftAdvpayDao;
	}

	public AcLnMstDao getAcLnMstDao() {
		return acLnMstDao;
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public AcDamFormulaBo getAcDamFormulaBo() {
		return acDamFormulaBo;
	}

	public void setAcLnMstDao(AcLnMstDao acLnMstDao) {
		this.acLnMstDao = acLnMstDao;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void setAcDamFormulaBo(AcDamFormulaBo acDamFormulaBo) {
		this.acDamFormulaBo = acDamFormulaBo;
	}

	public AcTraceLogDao getAcTraceLogDao() {
		return acTraceLogDao;
	}

	public void setAcTraceLogDao(AcTraceLogDao acTraceLogDao) {
		this.acTraceLogDao = acTraceLogDao;
	}

	public AcLnSetlmtLogDao getAcLnSetlmtLogDao() {
		return acLnSetlmtLogDao;
	}

	public void setAcLnSetlmtLogDao(AcLnSetlmtLogDao acLnSetlmtLogDao) {
		this.acLnSetlmtLogDao = acLnSetlmtLogDao;
	}

	public FiterEngineInterface getFiterEngineInterface() {
		return fiterEngineInterface;
	}

	public void setFiterEngineInterface(FiterEngineInterface fiterEngineInterface) {
		this.fiterEngineInterface = fiterEngineInterface;
	}

	public WsElyRepyDao getWsElyRepyDao() {
		return wsElyRepyDao;
	}

	public void setWsElyRepyDao(WsElyRepyDao wsElyRepyDao) {
		this.wsElyRepyDao = wsElyRepyDao;
	}

	public AcDebitDao getAcDebitDao() {
		return acDebitDao;
	}

	public void setAcDebitDao(AcDebitDao acDebitDao) {
		this.acDebitDao = acDebitDao;
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

	public AcLoanBackLogDao getAcLoanBackLogDao() {
		return acLoanBackLogDao;
	}

	public void setAcLoanBackLogDao(AcLoanBackLogDao acLoanBackLogDao) {
		this.acLoanBackLogDao = acLoanBackLogDao;
	}

	public CorpAcctDao getCorpAcctDao() {
		return corpAcctDao;
	}

	public void setCorpAcctDao(CorpAcctDao corpAcctDao) {
		this.corpAcctDao = corpAcctDao;
	}

	public AcLoanLogDao getAcLoanLogDao() {
		return acLoanLogDao;
	}

	public void setAcLoanLogDao(AcLoanLogDao acLoanLogDao) {
		this.acLoanLogDao = acLoanLogDao;
	}

	public AcDebitSuspBo getAcDebitSuspBo() {
		return acDebitSuspBo;
	}

	public void setAcDebitSuspBo(AcDebitSuspBo acDebitSuspBo) {
		this.acDebitSuspBo = acDebitSuspBo;
	}

	public AcChrgLogDao getAcChrgLogDao() {
		return acChrgLogDao;
	}

	public void setAcChrgLogDao(AcChrgLogDao acChrgLogDao) {
		this.acChrgLogDao = acChrgLogDao;
	}

}