/**
 * 
 */
package accounting.batch;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import accounting.batch.run.Main;
import accounting.biz.pub.ParmBiz;
import accounting.domain.loan.PrdtBase;
import accounting.plat.PUBConstant;
import accounting.plat.util.NumberUtil;
import accounting.plat.util.TimeUtil;

/**
 * �������ۣ�Ƿ�����׼��
 *
 */
public class LoanRepayLoAcLmAtpyBatch extends Batch {

	
	/* (non-Javadoc)
	 * @see accounting.batch.Batch#doBatch(java.lang.String, java.lang.String)
	 */
	public boolean doBatch(String startOrg, String endOrg) throws Exception {
		String step="9";//��9��

		boolean batchFlag = false;
		Connection conn = null; // ���ݿ�����
		try {
			conn = this.getConnection();
			
			String batchDt = "";//��ǰ��������
			PreparedStatement selectSysGlobalPst = conn.prepareStatement("select sys_date from sys_global ");
			
			ResultSet selectSysGlobalRs = selectSysGlobalPst.executeQuery();
			if(selectSysGlobalRs.next()){
				batchDt = selectSysGlobalRs.getString("sys_date");
			}
			
			String batchStp = "";//��ǰ�����ɹ����в���
			PreparedStatement selectAcComSysParmPst = conn.prepareStatement("select batch_stp from ac_com_sys_parm where batch_dt='"+batchDt+"'");
			
			ResultSet selectAcComSysParmRs = selectAcComSysParmPst.executeQuery();
			if(selectAcComSysParmRs.next()){
				batchStp = selectAcComSysParmRs.getString("batch_stp");
			}
			
			//����������С��10��˵����ǰ�ò��軹δ����
			if (Integer.parseInt(batchStp) < Integer.parseInt(step)) {
				
			String traceNo = "";
			String txDt = this.getTxDt(conn); // ��ȡ��ǰ����
			int num = 1;
			/*
			 * ��ѯ�ѷ������ۼ�¼ 
			 */
			PreparedStatement selectAcDebitPst = conn.prepareStatement("select loan_no from ac_debit where loan_no=? and sts='02'");
			ResultSet selectAcDebitRs = null;

			PreparedStatement deleteAcDebitPst = conn.prepareStatement("delete from ac_debit where sts='01'");
			deleteAcDebitPst.executeUpdate();
			/*
			 * ��ѯǷ���group by loan_no--����״̬Ϊ�����������ڡ����� 
			 */
			PreparedStatement selectAcLnLoTtlPst = conn.prepareStatement("select loan_no, sum(prcp_amt-repay_prcp_amt-wv_prcp_amt)+sum(norm_int-repay_norm_int-wv_norm_int)+sum(FINE_int-repay_FINE_int-wv_FINE_int) as atpy_amt from ac_ln_lo where setl_sts = '"+PUBConstant.N+"' and loan_no in(select a.loan_no from ac_ln_mst a where a.loan_sts in('01','02','03') and a.br_acc_type='A' ) group by loan_no");

			ResultSet selectAcLnLoTtlRs = selectAcLnLoTtlPst.executeQuery();
			
			//�����������м����¼
			PreparedStatement insertAcDebitPst = conn.prepareStatement("INSERT INTO AC_DEBIT (TRACE_NO,TRACE_CNT,DEBIT_NO,TX_DT,LOAN_NO,PACT_NO,BR_NO,ACCT_BANK_CDE,AC_NO,XT_AC_NO,CUR_NO,DEBIT_TYPE,ATPY_AMT,LO_AMT,CUR_AMT,MY_FEE_AMT,OTHER_FEE_AMT,STS,CREATE_DT,AC_TYPE,AC_NAME,BANK_CODE,BANK_PROV,BANK_CITY,BANK_SITE,CARD_CHN,BUS_ENTRY_TYPE,ID_TYPE,ID_NO,PHONE_NO,VALID_DATE,CVV_NO) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )");
			
			//��ѯǷ���where by loanNo
			PreparedStatement selectAcLnLoPst = conn.prepareStatement("select loan_no,pact_no,br_no, perd_no,pay_dt, (prcp_amt-repay_prcp_amt-wv_prcp_amt) as prcp_amt, (norm_int-repay_norm_int-wv_norm_int) as norm_int, (fine_int-repay_fine_int-wv_fine_int) as fine_int from AC_LN_LO where setl_sts = '"+PUBConstant.N+"' and loan_no=?");
			ResultSet selectAcLnLoRs = null;
			
			//��ѯ����������Ϣ
			PreparedStatement selectAcLnMstPst = conn.prepareStatement("select loan_no,pact_no,br_no,cur_no,proj_no,prdt_no  from ac_ln_mst where  loan_no=?");
			ResultSet selectAcLnMstRs = null;
			
			//��ѯ��ݱ���Ϣ
			PreparedStatement selectLnDuePst = conn.prepareStatement("select app_id,proj_no,cur_no from ln_due where due_no=?");
			ResultSet selectLnDueRs = null;
			
			//��ѯ�����˺ű�--�ۿ��˺�
			PreparedStatement selectLnAcctPst = conn.prepareStatement("select ac_type,ac_no,ac_name,bank_code,bank_prov,bank_city,bank_site,ac_sts,id_type,id_no,phone_no,valid_date,cvv_no from ln_acct where app_id=? and ac_use='1' and ac_sts='01' and rownum='1'");
			ResultSet selectLnAcctRs = null;
			
			//��ѯ������Ŀ���˺ű�--ר��
			PreparedStatement selectProjAcctPst = conn.prepareStatement("select acct_no from proj_acct where proj_no=?");
			ResultSet selectProjAcctRs = null;
			
			//��ѯ���������˺ű�
			PreparedStatement selectCorpAcctPst = conn.prepareStatement("select opn_bank,opn_acno,ac_name,exchange,province,city from corp_acct where br_no=?");
			ResultSet selectCorpAcctRs = null;

			//��ѯ�Ƿ��е�������
			PreparedStatement selectPlnCurByLoanNoPst = conn.prepareStatement("select pact_no,br_no,perd_no, prcp_amt, norm_int, repay_prcp_amt, repay_norm_int from AC_LN_REPAY_PLN_CUR where pay_dt<='"+txDt+"'  and end_dt>='"+txDt+"' and loan_no=?");
			ResultSet selectPlnCurByLoanNoRs = null;
			
			//��ѯ�����Ƿ��з�����Ϣ
			PreparedStatement selectAcChrgLogPst = conn.prepareStatement("select loan_no,perd_no,fee_kind,nvl(sum(chrg_amt)-sum(repay_chrg_amt),0) as fee_amt from ac_chrg_log where loan_no=? and fee_kind=? and tx_date<=? and chrg_sts in('01','02') group by loan_no,perd_no,fee_kind");
			ResultSet selectAcChrgLogRs = null;
		
			for(;selectAcLnLoTtlRs.next(); num++){ //��ѯǷ����з�����������
				traceNo = ParmBiz.getTraceNo(conn);
				double ttlAmt = 0.00;
				String loanNo = selectAcLnLoTtlRs.getString("loan_no");
				
				selectAcDebitPst.setString(1, loanNo);
				selectAcDebitRs = selectAcDebitPst.executeQuery();
				//���ñʴ�������ѷ���δ���̿ۿ���Ϣ�������ɿۿ���ϸ�������ļ�
				if (!selectAcDebitRs.next()) {
					String curNo = "";// ����
					String projNo = "";// ��Ŀ���
					String pactNo = "";
					String brNo = "";
					String appId = "";
					String prdtNo = "";// ��Ʒ��

					selectAcLnMstPst.setString(1, loanNo);
					selectAcLnMstRs = selectAcLnMstPst.executeQuery();
					if (selectAcLnMstRs.next()) {
						curNo = selectAcLnMstRs.getString("cur_no");
						projNo = selectAcLnMstRs.getString("proj_no");
						pactNo = selectAcLnMstRs.getString("pact_no");
						brNo = selectAcLnMstRs.getString("br_no");
						prdtNo = selectAcLnMstRs.getString("prdt_no");
					}
					PrdtBase prdtBase = PUBConstant.PUB_ACCOUNT_PRAM
							.get(prdtNo);

					// ��ѯ������Ŀ �˺�
					String xtAcNo = "";
					selectProjAcctPst.setString(1, projNo);
					selectProjAcctRs = selectProjAcctPst.executeQuery();
					if (selectProjAcctRs.next()) {
						xtAcNo = selectProjAcctRs.getString("acct_no");
					}

					selectLnDuePst.setString(1, loanNo);
					selectLnDueRs = selectLnDuePst.executeQuery();
					if (selectLnDueRs.next()) {
						appId = selectLnDueRs.getString("app_id");
					}
					// Ƿ����
					double loAmt = selectAcLnLoTtlRs.getDouble("atpy_amt");

					selectAcLnLoPst.setString(1, loanNo);
					selectAcLnLoRs = selectAcLnLoPst.executeQuery();
					while (selectAcLnLoRs.next()) { // ��ѯǷ����з�����������
						String payDt = selectAcLnLoRs.getString("pay_dt");// ��������
						// Ƿ�����ʧ���������ۿ� ---��Ƿ���ڿ�ʧ�����ڣ����пۿ�
						if (TimeUtil.getBetweenDays(payDt, txDt) <= prdtBase
								.getFailDays()) {
							pactNo = selectAcLnLoRs.getString("pact_no");
							brNo = selectAcLnLoRs.getString("br_no");
						}
					}

					// ��ѯ����
					double curAmt = 0.00;
					selectPlnCurByLoanNoPst.setString(1, loanNo);
					selectPlnCurByLoanNoRs = selectPlnCurByLoanNoPst
							.executeQuery(); // ��ѯ�Ƿ��е�������
					if (selectPlnCurByLoanNoRs.next()) {
						pactNo = selectPlnCurByLoanNoRs.getString("pact_no");
						brNo = selectPlnCurByLoanNoRs.getString("br_no");
						double prcpAmt = selectPlnCurByLoanNoRs
								.getDouble("prcp_amt");
						double normInt = selectPlnCurByLoanNoRs
								.getDouble("norm_int");
						double repayPrcpAmt = selectPlnCurByLoanNoRs
								.getDouble("repay_prcp_amt");
						double repayNormInt = selectPlnCurByLoanNoRs
								.getDouble("repay_norm_int");
						prcpAmt = NumberUtil.amtSubs(prcpAmt, repayPrcpAmt);
						normInt = NumberUtil.amtSubs(normInt, repayNormInt);
						curAmt = NumberUtil.amtAdd(prcpAmt, normInt);

					}

					String acctBankCde = "";//�������д���
					String acNo = "";//�˻�����
					String acType = "";//�˻�����[11�����˻�12��ҵ�˻�]
					String acNames = "";//�˻�����
					String bankProv = "";//������������ʡ
					String bankCity = "";//��������������
					String bankSite = "";//������������
					String cardChn = "";//֧������
					String busOrderType ="";//ҵ�񶩵���������
					String idType = "";//֤������
					String idNo = "";//֤������
					String phoneNo = "";//�ֻ�����
					String validDate = "";//���ÿ���Ч��
					String cvvNo = "";//���п�CVV2��
					selectLnAcctPst.setString(1, appId);
					selectLnAcctRs = selectLnAcctPst.executeQuery(); // ��ѯ�����˻�
					while (selectLnAcctRs.next()) {
						acctBankCde = selectLnAcctRs.getString("bank_code");
						acNo = selectLnAcctRs.getString("ac_no");
						acType = selectLnAcctRs.getString("ac_type");
						acNames = selectLnAcctRs.getString("ac_name");
						bankProv = selectLnAcctRs.getString("bank_prov");
						bankCity = selectLnAcctRs.getString("bank_city");
						bankSite = selectLnAcctRs.getString("bank_site");
						idType = selectLnAcctRs.getString("id_type");
						idNo = selectLnAcctRs.getString("id_no");
						phoneNo = selectLnAcctRs.getString("phone_no");
						validDate = selectLnAcctRs.getString("valid_date");
						cvvNo = selectLnAcctRs.getString("cvv_no");
					}

					// ��ѯ����Ӧ�����շѣ��������շѿۿ���ϸ
					double myFeeAmt = 0.00;//���շѺϼ�
					selectAcChrgLogPst.setString(1, loanNo);
					selectAcChrgLogPst.setString(2, PUBConstant.FEE_KIND_01);
					selectAcChrgLogPst.setString(3, txDt);
					selectAcChrgLogRs = selectAcChrgLogPst.executeQuery();
					while (selectAcChrgLogRs.next()) {
						myFeeAmt = myFeeAmt + selectAcChrgLogRs.getDouble("fee_amt");//���շѺϼ�
					}

					// ��ѯ���������˻������շ����տ��˻�
					String opnAcno = "";// ���������˻�
					String opnBank = "";//������
					String acName = "";//�˻�����
					String exchange = "";//�����д���
					String province = "";//�������ڵ�ʡ��
					String city = "";//���������ڵ�����
					selectCorpAcctPst.setString(1, brNo);
					selectCorpAcctRs = selectCorpAcctPst.executeQuery();
					if (selectCorpAcctRs.next()) {
						opnAcno = selectCorpAcctRs.getString("opn_acno");
						opnBank = selectCorpAcctRs.getString("opn_bank");
						acName = selectCorpAcctRs.getString("ac_name");
						exchange = selectCorpAcctRs.getString("exchange");
						province = selectCorpAcctRs.getString("province");
						city = selectCorpAcctRs.getString("city");

					}

					// ��ѯ����Ӧ�۴��շѣ����ɴ��շѿۿ���ϸ
					double otherFeeAmt = 0.00;//���շѺϼ�
					selectAcChrgLogPst.setString(1, loanNo);
					selectAcChrgLogPst.setString(2, PUBConstant.FEE_KIND_02);
					selectAcChrgLogPst.setString(3, txDt);
					selectAcChrgLogRs = selectAcChrgLogPst.executeQuery();
					while (selectAcChrgLogRs.next()) {
						otherFeeAmt = otherFeeAmt + selectAcChrgLogRs.getDouble("fee_amt");//���շѺϼ�
					}
					if(otherFeeAmt>0){//�����ô���0
						busOrderType="004";//������
					}else{
						busOrderType="003";//��������
					}
					ttlAmt = NumberUtil.amtAdd(loAmt, curAmt);
					insertAcDebitPst.setString(1, traceNo); // ��ˮ��
					insertAcDebitPst.setInt(2, 1); // ���
					insertAcDebitPst.setString(3, ParmBiz.getDebitNo(conn)); // ������ˮ
					insertAcDebitPst.setString(4, txDt); // ������
					insertAcDebitPst.setString(5, loanNo); // ��ݺ�
					insertAcDebitPst.setString(6, pactNo); // ��ͬ��
					insertAcDebitPst.setString(7, brNo); // ������
					insertAcDebitPst.setString(8, acctBankCde); // �ۿ��˺����д���
					insertAcDebitPst.setString(9, acNo); // �ۿ��˺�
					insertAcDebitPst.setString(10, xtAcNo); // �����˺�/���������˺�
					insertAcDebitPst.setString(11, curNo); // �ۿ����
					insertAcDebitPst.setString(12, "01"); // �ۿ����-������
					insertAcDebitPst.setDouble(13, ttlAmt); // Ӧ�۽��
					insertAcDebitPst.setDouble(14, loAmt); // Ӧ��Ƿ����
					insertAcDebitPst.setDouble(15, curAmt); // Ӧ�۱��ڽ��
					insertAcDebitPst.setDouble(16, myFeeAmt); // ���շ��ý��
					insertAcDebitPst.setDouble(17, otherFeeAmt); // ���շ��ý��
					insertAcDebitPst.setString(18, PUBConstant.DDTL_STS_PEND); // ����״̬
					insertAcDebitPst.setString(19, txDt); // ��������
					insertAcDebitPst.setString(20, acType); // �˻�����[11�����˻�12��ҵ�˻�]
					insertAcDebitPst.setString(21, acNames); // �˻�����
					insertAcDebitPst.setString(22, acctBankCde); // �ۿ��˺����д���
					insertAcDebitPst.setString(23, bankProv); // ������������ʡ
					insertAcDebitPst.setString(24, bankCity); // ��������������
					insertAcDebitPst.setString(25, bankSite); // ������������
					insertAcDebitPst.setString(26, cardChn); // ֧������
					insertAcDebitPst.setString(27, busOrderType+"01"); // ҵ�񶩵���������
					insertAcDebitPst.setString(28, idType); // ֤������
					insertAcDebitPst.setString(29, idNo); // ֤������
					insertAcDebitPst.setString(30, phoneNo); // �ֻ�����
					insertAcDebitPst.setString(31, validDate); // ���ÿ���Ч��
					insertAcDebitPst.setString(32, cvvNo); // ���п�CVV2��

					insertAcDebitPst.addBatch();
					

					if (num % 10000 == 0) {
						insertAcDebitPst.executeBatch();
					}

					num++;
				}
			}
			insertAcDebitPst.executeBatch();

			/*
			 *��ѯ���ڱ����� -- ����������
			 */
			PreparedStatement selectAcLnRepayPlnCurPst = conn.prepareStatement("select cur.loan_no, cur.pact_no, cur.br_no, cur.perd_no, cur.prcp_amt, cur.norm_int,cur.repay_prcp_amt, cur.repay_norm_int from AC_LN_REPAY_PLN_CUR cur where cur.pay_dt<='"+txDt+"' and cur.end_dt>='"+txDt+"' and loan_no not in(select loan_no from ac_ln_mst where br_acc_type='B') and not exists (SELECT 1 FROM ac_ln_lo lo WHERE cur.loan_no=lo.loan_no and lo.setl_sts='N')");
			ResultSet selectAcLnRepayPlnCurRs = selectAcLnRepayPlnCurPst.executeQuery();
			
			for(; selectAcLnRepayPlnCurRs.next(); num++){
				traceNo = ParmBiz.getTraceNo(conn);
				String loanNo = selectAcLnRepayPlnCurRs.getString("loan_no");
				
				selectAcDebitPst.setString(1, loanNo);
				selectAcDebitRs = selectAcDebitPst.executeQuery();
				if (!selectAcDebitRs.next()) {
					String pactNo = selectAcLnRepayPlnCurRs
							.getString("pact_no");
					String brNo = selectAcLnRepayPlnCurRs.getString("br_no");
					double prcpAmt = selectAcLnRepayPlnCurRs
							.getDouble("prcp_amt");
					double normInt = selectAcLnRepayPlnCurRs
							.getDouble("norm_int");
					double repayPrcpAmt = selectAcLnRepayPlnCurRs
							.getDouble("repay_prcp_amt");
					double repayNormInt = selectAcLnRepayPlnCurRs
							.getDouble("repay_norm_int");
					prcpAmt = NumberUtil.amtSubs(prcpAmt, repayPrcpAmt);
					normInt = NumberUtil.amtSubs(normInt, repayNormInt);
					double curAmt = NumberUtil.amtAdd(prcpAmt, normInt);

					String appId = "";// ������
					String projNo = "";// ��Ŀ���
					String curNo = "";// ����
					selectLnDuePst.setString(1, loanNo);
					selectLnDueRs = selectLnDuePst.executeQuery();
					if (selectLnDueRs.next()) {
						appId = selectLnDueRs.getString("app_id");
						projNo = selectLnDueRs.getString("proj_no");
						curNo = selectLnDueRs.getString("cur_no");
					}

					// ��ѯ������Ŀ �˺�
					String xtAcNo = "";
					selectProjAcctPst.setString(1, projNo);
					selectProjAcctRs = selectProjAcctPst.executeQuery();
					if (selectProjAcctRs.next()) {
						xtAcNo = selectProjAcctRs.getString("acct_no");
					}
					String acctBankCde = "";
					String acNo = "";
					String acType = "";//�˻�����[11�����˻�12��ҵ�˻�]
					String acNames = "";//�˻�����
					String bankProv = "";//������������ʡ
					String bankCity = "";//��������������
					String bankSite = "";//������������
					String cardChn = "";//֧������
					String busOrderType ="";//ҵ�񶩵���������
					String idType = "";//֤������
					String idNo = "";//֤������
					String phoneNo = "";//�ֻ�����
					String validDate = "";//���ÿ���Ч��
					String cvvNo = "";//���п�CVV2��
					selectLnAcctPst.setString(1, appId);
					selectLnAcctRs = selectLnAcctPst.executeQuery(); // ��ѯ�����˻�
					while (selectLnAcctRs.next()) {
						acctBankCde = selectLnAcctRs.getString("bank_code");
						acNo = selectLnAcctRs.getString("ac_no");
						acType = selectLnAcctRs.getString("ac_type");
						acNames = selectLnAcctRs.getString("ac_name");
						bankProv = selectLnAcctRs.getString("bank_prov");
						bankCity = selectLnAcctRs.getString("bank_city");
						bankSite = selectLnAcctRs.getString("bank_site");
						idType = selectLnAcctRs.getString("id_type");
						idNo = selectLnAcctRs.getString("id_no");
						phoneNo = selectLnAcctRs.getString("phone_no");
						validDate = selectLnAcctRs.getString("valid_date");
						cvvNo = selectLnAcctRs.getString("cvv_no");
					}

					// ��ѯ����Ӧ�����շѣ��������շѿۿ���ϸ
					double myFeeAmt = 0.00;// ���շ��ܼ�

					selectAcChrgLogPst.setString(1, loanNo);
					selectAcChrgLogPst.setString(2, PUBConstant.FEE_KIND_01);
					selectAcChrgLogPst.setString(3, txDt);
					selectAcChrgLogRs = selectAcChrgLogPst.executeQuery();
					while (selectAcChrgLogRs.next()) {
						myFeeAmt = myFeeAmt + selectAcChrgLogRs.getDouble("fee_amt");
					}

					// ��ѯ���������˻������շ����տ��˻�
					String opnAcno = "";// ���������˻�
					String opnBank = "";//������
					String acName = "";//�˻�����
					String exchange = "";//�����д���
					String province = "";//�������ڵ�ʡ��
					String city = "";//���������ڵ�����
					selectCorpAcctPst.setString(1, brNo);
					selectCorpAcctRs = selectCorpAcctPst.executeQuery();
					if (selectCorpAcctRs.next()) {
						opnAcno = selectCorpAcctRs.getString("opn_acno");
						opnBank = selectCorpAcctRs.getString("opn_bank");
						acName = selectCorpAcctRs.getString("ac_name");
						exchange = selectCorpAcctRs.getString("exchange");
						province = selectCorpAcctRs.getString("province");
						city = selectCorpAcctRs.getString("city");
					}

					// ��ѯ����Ӧ�۴��շѣ����ɴ��շѿۿ���ϸ
					double otherFeeAmt = 0.00;// ���շ��ܼ�

					selectAcChrgLogPst.setString(1, loanNo);
					selectAcChrgLogPst.setString(2, PUBConstant.FEE_KIND_02);
					selectAcChrgLogPst.setString(3, txDt);
					selectAcChrgLogRs = selectAcChrgLogPst.executeQuery();
					while (selectAcChrgLogRs.next()) {
						otherFeeAmt = otherFeeAmt+selectAcChrgLogRs.getDouble("fee_amt");
					}
					if(otherFeeAmt>0){//�����ô���0
						busOrderType="004";//������
					}else{
						busOrderType="003";//��������
					}
					insertAcDebitPst.setString(1, traceNo); // ��ˮ��
					insertAcDebitPst.setInt(2, 1); // ���
					insertAcDebitPst.setString(3, ParmBiz.getDebitNo(conn)); // ������ˮ
					insertAcDebitPst.setString(4, txDt); // ������
					insertAcDebitPst.setString(5, loanNo); // ��ݺ�
					insertAcDebitPst.setString(6, pactNo); // ��ͬ��
					insertAcDebitPst.setString(7, brNo); // ������
					insertAcDebitPst.setString(8, acctBankCde); // �ۿ��˺����д���
					insertAcDebitPst.setString(9, acNo); // �ۿ��˺�
					insertAcDebitPst.setString(10, xtAcNo); // �����˺�/���������˺�
					insertAcDebitPst.setString(11, curNo); // �ۿ����
					insertAcDebitPst.setString(12, ""); // �ۿ����-����
					insertAcDebitPst.setDouble(13, curAmt+myFeeAmt+otherFeeAmt); // Ӧ�۽��
					insertAcDebitPst.setDouble(14, 0.00); // Ӧ��Ƿ����
					insertAcDebitPst.setDouble(15, curAmt); // Ӧ�۱��ڽ��
					insertAcDebitPst.setDouble(16, myFeeAmt); // ���շѷ��ý��
					insertAcDebitPst.setDouble(17, otherFeeAmt); // ���շ�
					insertAcDebitPst.setString(18, PUBConstant.DDTL_STS_PEND); // ����״̬
					insertAcDebitPst.setString(19, this.getTxDt(conn)); // ��������
					insertAcDebitPst.setString(20, acType); //�˻�����[11�����˻�12��ҵ�˻�] 
					insertAcDebitPst.setString(21, acNames); // �˻�����
					insertAcDebitPst.setString(22, acctBankCde); // �ۿ��˺����д���
					insertAcDebitPst.setString(23, bankProv); // ������������ʡ
					insertAcDebitPst.setString(24, bankCity); // ��������������
					insertAcDebitPst.setString(25, bankSite); // ������������
					insertAcDebitPst.setString(26, cardChn); // ֧������
					insertAcDebitPst.setString(27, busOrderType+"01"); // ҵ�񶩵���������
					insertAcDebitPst.setString(28, idType); // ֤������
					insertAcDebitPst.setString(29, idNo); // ֤������
					insertAcDebitPst.setString(30, phoneNo); //�ֻ����� 
					insertAcDebitPst.setString(31, validDate); // ���ÿ���Ч��
					insertAcDebitPst.setString(32, cvvNo); // ���п�CVV2��
					
					insertAcDebitPst.addBatch();


					if (num % 10000 == 0) {
						insertAcDebitPst.executeBatch();
					}
					num++;
				}
			}
			if(null!=selectAcDebitPst){
				selectAcDebitPst.close();
			}
			if(null!=selectAcDebitRs){
				selectAcDebitRs.close();
			}
			if(null!=selectAcLnLoRs){
				selectAcLnLoRs.close();
			}
			if(null!=selectAcLnLoPst){
				selectAcLnLoPst.close();
			}
			if(null!=selectPlnCurByLoanNoRs){
				selectPlnCurByLoanNoRs.close();
			}
			if(null!=selectAcLnMstPst){
				selectAcLnMstPst.close();
			}
			if(null!=selectAcLnMstRs){
				selectAcLnMstRs.close();
			}
			if(null!=selectLnDuePst){
				selectLnDuePst.close();
			}
			if(null!=selectLnDueRs){
				selectLnDueRs.close();
			}
			if(null!=selectLnAcctPst){
				selectLnAcctPst.close();
			}
			if(null!=selectLnAcctRs){
				selectLnAcctRs.close();
			}
			if(null!=selectProjAcctPst){
				selectProjAcctPst.close();
			}
			if(null!=selectProjAcctRs){
				selectProjAcctRs.close();
			}
			if(null!=selectCorpAcctPst){
				selectCorpAcctPst.close();
			}
			if(null!=selectCorpAcctRs){
				selectCorpAcctRs.close();
			}
			if(null!=selectAcChrgLogPst){
				selectAcChrgLogPst.close();
			}
			if(null!=selectAcChrgLogRs){
				selectAcChrgLogRs.close();
			}
			if(null!=selectPlnCurByLoanNoPst){
				selectPlnCurByLoanNoPst.close();
			}
			if(null!=selectPlnCurByLoanNoRs){
				selectPlnCurByLoanNoRs.close();
			}
			if(null!=selectAcLnLoTtlRs){
				selectAcLnLoTtlRs.close();
			}
			if(null!=selectAcLnLoTtlPst){
				selectAcLnLoTtlPst.close();
			}
			
			if(null!=insertAcDebitPst){
				insertAcDebitPst.executeBatch();
			}
			if(null!=insertAcDebitPst){
				insertAcDebitPst.close();
			}
			if(null!=insertAcDebitPst){
				deleteAcDebitPst.close();
			}
			Statement updateAcComSysParmSt2 = conn.createStatement();
			String updateAcComSysParmSql2 = "update AC_COM_SYS_PARM set batch_dt='"
					+ batchDt + "',batch_stp='" + step + "'";
			updateAcComSysParmSt2.executeUpdate(updateAcComSysParmSql2);
			updateAcComSysParmSt2.close();

			conn.commit();

			}else{
				System.out.println(batchDt+"��������9��ִ��");
			}	
			
			selectSysGlobalPst.close();
			selectSysGlobalRs.close();
			selectAcComSysParmPst.close();
			selectAcComSysParmRs.close();
			
			batchFlag = true;
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			error(e);
			batchFlag = false;
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return batchFlag;
	}
	
	public static void main(String[] args) throws Exception {
		Main.initialize();
		String txDt = PUBConstant.CUR_PRCS_DT;
		LoanRepayLoAcLmAtpyBatch lrbLo2 = new LoanRepayLoAcLmAtpyBatch();
		boolean c = lrbLo2.doBatch(null, null);
	}
}
