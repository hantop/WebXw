package accounting.interf.loan;

import java.sql.Connection;

import accounting.biz.pub.IntstBiz;
import accounting.domain.loan.AcLnMst;
import accounting.domain.loan.PrdtBase;
import accounting.domain.sys.AfferentDomain;
import accounting.domain.sys.OperaInfo;
import accounting.plat.PUBConstant;
import accounting.plat.core.AccountingException;
import accounting.plat.core.Operation;
import accounting.plat.dao.JdbcDao;
import accounting.plat.util.NumberUtil;

/**
 * 
 * @��Ŀ���ƣ�nxnxnew
 * @�����ƣ�CalIntstOp
 * @�������� ��ǰ������Ϣ����
 * 
 * 
 */

public class CalIntstOp extends Operation {

	@Override
	public Object doExecute(AfferentDomain afferentDomain) throws AccountingException{
		CalIntst intst;
		if (afferentDomain instanceof CalIntst) {
			// ��ȡ����ҵ�����ݵĶ���
			intst = (CalIntst) afferentDomain;
		} else {
			throw new AccountingException("�������Ͳ�ƥ��");
		}

		Connection conn = this.getConnection();
		String traceNo = this.getTraceNo() ;
		OperaInfo operaInfo = new OperaInfo(afferentDomain, traceNo, conn) ;
		
		String loanNo = intst.getLoanNo();				// ��ݺ�
		double remAmt = intst.getRemAmt();				// ��ǰ�������
		AcLnMst acLnMst = (AcLnMst)JdbcDao.query(new AcLnMst(), "loan_no='"+loanNo+"'", "ac_ln_mst", conn);
//		PrdtBase prdtBase = PUBConstant.PUB_ACCOUNT_PRAM.get(acLnMst.getPrdtNo());
		PrdtBase prdtBase =(PrdtBase)JdbcDao.query(new PrdtBase(), "prdt_no = '"+acLnMst.getPrdtNo()+"'", "prdt_base", operaInfo.getConn());
		
		IntstDetailDatas datas = new IntstDetailDatas();

		try {
			datas = IntstBiz.calculateTtlIntIsMortgage(acLnMst, remAmt, prdtBase, operaInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}

		

		System.out.println("��ǰ��������-->" + operaInfo.getBizDt());
		System.out.println("ϵͳ����-->" + operaInfo.getTxDt());
		System.out.println("Ƿ���-->" + datas.getPrcpAmt());//Ƿ��
		System.out.println("Ƿ������Ϣ-->" + datas.getNormInt());//ǷϢ
		System.out.println("���ڷ�Ϣ-->" + datas.getFineInt());
		System.out.println("��ǰ�������-->" + datas.getRemPrcpAmt());//�������
		System.out.println("���������ڵĵ�����Ϣ-->" + datas.getCurInt());//�黹��Ϣ111
		System.out.println("Ӧ����Ϣ-->" + NumberUtil.amtAdd(datas.getCurInt(), datas.getFineInt()));
		
		
		return datas;
	}

}
