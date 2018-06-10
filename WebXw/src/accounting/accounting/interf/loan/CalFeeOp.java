package accounting.interf.loan;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import accounting.biz.pub.FeeBiz;
import accounting.domain.fee.AcChrgLog;
import accounting.domain.sys.AfferentDomain;
import accounting.domain.sys.OperaInfo;
import accounting.plat.core.AccountingException;
import accounting.plat.core.Operation;
import accounting.plat.util.NumberUtil;

public class CalFeeOp extends Operation {

	/**
	 * ������ò�����
	 */
	public Object doExecute(AfferentDomain afferentDomain)throws AccountingException {
		
		CalFee calFee;
		
		if(afferentDomain instanceof CalFee){
			calFee = (CalFee) afferentDomain;
		}else{
			throw new AccountingException("�������Ͳ�ƥ�䣡");
		}
	
		//���÷��ض���
		CalFeeResult feeResult = new CalFeeResult();
		
		Connection conn = this.getConnection();
		
		//ҵ�����
		String traceNo = calFee.getTraceNo();
		int traceCnt = calFee.getTraceCnt();
		String loanNo = calFee.getLoanNo();
		String txCode = calFee.getTxCode();
		double txAmt = calFee.getTxAmt();
		String curNo = calFee.getCurNo();
		String saveInd = calFee.getSaveInd();
		String prdtNo = calFee.getPrdtNo();
		
		// ����ҵ���������
		OperaInfo operaInfo = new OperaInfo(afferentDomain, traceNo, conn);
		
		//���ط����ܽ��
		double actualFeeAmt = 0.00;
		
		List<AcChrgLog> acChrgLogList = new ArrayList<AcChrgLog>();
		
		FeeBiz feeBiz = new FeeBiz();
		acChrgLogList = feeBiz.getAcChrgLogListFk(traceCnt, loanNo, prdtNo, txCode, txAmt, curNo, saveInd, operaInfo);
		
		for(AcChrgLog acChrgLog : acChrgLogList){
			actualFeeAmt = NumberUtil.amtAdd(actualFeeAmt, acChrgLog.getChrgAmt());
		}
		
		feeResult.setFeeAmt(actualFeeAmt);
		feeResult.setAcChrgLogList(acChrgLogList);
		feeResult.setTraceCnt(traceCnt + acChrgLogList.size());//��ˮ����Ѿ�������ʽ����������ʱ���������ͻ���⣩
		
		return feeResult;
	}

}
