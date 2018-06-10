package accounting.batch.run;

import java.io.BufferedReader;
import java.io.File;

import accounting.batch.util.FileUtil;
import accounting.plat.PUBConstant;
import accounting.plat.TransCode;
import accounting.plat.core.init.BusinessInitializer;

public class CreateLoanDownFile {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		
		BusinessInitializer buz = new BusinessInitializer();
		buz.initialize();
		
		String txDate = "2011-05-20" ;
		String loanNo="c20122";
		boolean get = false ;
		if(get){
//			getKkAmt(txDate, loanNo) ;
		}else{
			cleanFiles("E:\\batch\\");
			double amt = 0 ;
//			CreateLoanDownFile.kk(txDate,loanNo,amt);
			System.out.println("�ۿ����");
		}

	}

	/**
	 * ɾ���ļ����������ļ�
	 * @param path �ļ��о���·�� 
	 */
	public static void cleanFiles(String path) {
		File dir = new File(path);
		if(dir.isDirectory()){
			File[] files = dir.listFiles();
			for(File f:files){
				f.delete();
			}
		}

	}

//	public static void kk (String txDt,String loanNo1,double kkAmt) {
//
//		String downFileName = PUBConstant.PRE_LOAN_REPAY_BATCH_DOWN+txDt+PUBConstant.POST_BATCH_DOWN;
//		String upFileName = PUBConstant.PRE_LOAN_REPAY_BATCH_DOWN + txDt + PUBConstant.POST_BATCH_UP;
//		Connection conn =   ConnectionPool.getInstance().getConnection();
//		Connection traceNoConn =   ConnectionPool.getInstance().getConnection();
//		String seqNo = PUBConstant.BAT_LOAN_REPAY;
//		String txCode = TransCode.LNCQ; 
//		KeyGen kg = KeyGen.getKeyGen();	
//		try {
//
//
//			//ɾ���Զ��ۿ��������Ϣ
//			String deleteAcLmAtpySql="delete from AC_LM_ATPY where  tx_dt='"+txDt+"' and seq_No='"+seqNo+"'";
//			PreparedStatement deleteAcLmAtpyPst = conn.prepareStatement(deleteAcLmAtpySql);
//			deleteAcLmAtpyPst.executeUpdate();
//			deleteAcLmAtpyPst.close();
//
//			//ɾ���Զ��ۿ����ϸ����Ϣ
//			String deleteAcLmAtpyDetlSql="delete from AC_LM_ATPY_DETL where  tx_dt='"+txDt+"' and seq_No='"+seqNo+"'";
//			PreparedStatement deleteAcLmAtpyDetlPst = conn.prepareStatement(deleteAcLmAtpyDetlSql);
//			deleteAcLmAtpyDetlPst.executeUpdate();
//			deleteAcLmAtpyDetlPst.close();
//
//			// ���ڻ���ƻ������ݲ��뵽������ϸ����
//			PreparedStatement insertAcLmAtpyDetlPst = conn.prepareStatement("insert into AC_LM_ATPY_DETL (seq_no,tx_dt,ac_id,ac_seq,loan_no,prcp_amt,int_amt,create_dt,paym_amt,perd_no,cur_ind,mortgage_ind) select "+seqNo+",'"+txDt+"',ac_id,ac_seq,loan_no,prcp_amt,norm_intst,'"+txDt+"',prcp_amt+norm_intst,perd_no,'"+PUBConstant.Y+"','"+PUBConstant.Y+"' from AC_LN_PAY_PLN_CUR where end_dt = '"+txDt+"' and loan_no='"+loanNo1+"' ");
//			int countCur = insertAcLmAtpyDetlPst.executeUpdate();
//			// Ƿ������ݲ��뵽������ϸ����
//			insertAcLmAtpyDetlPst = conn.prepareStatement("insert into AC_LM_ATPY_DETL (seq_no,tx_dt,ac_id,ac_seq,loan_no,prcp_amt,int_amt,create_dt,paym_amt,perd_no,cur_ind,mortgage_ind,od_int,comp_int) select "+seqNo+",'"+txDt+"',ac_id,ac_seq,loan_no,prcp_amt,norm_intst,'"+txDt+"',prcp_amt+norm_intst+over_intst+cmpd_amt,perd_no,'"+PUBConstant.N+"','"+PUBConstant.Y+"',over_intst,cmpd_amt from AC_LN_LO where setl_sts = '"+PUBConstant.N+"' and end_dt<='"+txDt+"' and loan_no='"+loanNo1+"' ");
//			int countLo = insertAcLmAtpyDetlPst.executeUpdate();
//			insertAcLmAtpyDetlPst.close();
//
//			/**
//			 * ���ۿ���ϸ���¼����ۿ������ AC_LM_ATPY
//			 */
//			// �Ӵ�������黹���˻�
//			PreparedStatement selectAcLnMstPst = conn.prepareStatement("select repay_ac_id from AC_LN_MST where ac_id = ? and ac_seq = ?");
//			ResultSet selectAcLnMstRs;
//
//			// ����һ�����������¼
//			PreparedStatement insertAcLmAtpyPst = conn.prepareStatement("insert into ac_lm_atpy(seq_no,tx_dt,txlog_no,txlog_seq_no,ac_id,ac_seq,loan_no,repay_ac_id,paym_amt,paym_lo_amt,paym_cur_amt,create_dt,spool_dt,tx_amt,sts,mortgage_ind) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
//
//			// �ӿۿ���ϸ���в�ѯδ����Ƿ���¼���Խ�����,�鵱�ڻ����¼,�Խ��ȫ����
//			PreparedStatement selectAcLmAtpyDeltPst = conn.prepareStatement("select nvl(l.ac_id,c.ac_id)as ac_id,nvl(l.ac_seq,c.ac_seq)as ac_seq,nvl(c.loan_no,l.loan_no) as loan_no,l.paym_lo_amt,c.paym_cur_amt,nvl(l.paym_lo_amt,0)+nvl(c.paym_cur_amt,0) as paym_amt from (select loan_no,ac_id,ac_seq,sum(paym_amt) as paym_lo_amt from AC_LM_ATPY_DETL where cur_ind='N' and seq_no=? and tx_dt = ? group by ac_id,ac_seq,loan_no) l full join (select loan_no,ac_id,ac_seq,paym_amt as paym_cur_amt from AC_LM_ATPY_DETL where cur_ind='Y' and tx_dt = ? and seq_no=?) c on l.ac_id=c.ac_id and l.ac_seq=c.ac_seq");
//			selectAcLmAtpyDeltPst.setString(1, seqNo);		// �����������
//			selectAcLmAtpyDeltPst.setString(2, txDt);		// ���ý�������
//			selectAcLmAtpyDeltPst.setString(3, txDt);		// ���ý�������
//			selectAcLmAtpyDeltPst.setString(4, seqNo);		// �����������
//			//log("select nvl(l.ac_id,c.ac_id)as ac_id,nvl(l.ac_seqn,c.ac_seqn)as ac_seqn,nvl(c.loan_no,l.loan_no) as loan_no,l.paym_lo_amt,c.paym_cur_amt,nvl(l.paym_lo_amt,0)+nvl(c.paym_cur_amt,0) as paym_amt from (select loan_no,ac_id,ac_seqn,sum(paym_amt) as paym_lo_amt from AC_LM_ATPY_DETL where cur_ind='N' and seq_no='"+seqNo+"' group by ac_id,ac_seqn,loan_no) l full join (select ac_id,ac_seqn,paym_amt as paym_cur_amt from AC_LM_ATPY_DETL where cur_ind='Y' and tx_dt = '"+txDt+"' and seq_no='"+seqNo+"') c on l.ac_id=c.ac_id and l.ac_seqn=c.ac_seqn");
//			ResultSet selectAcLmAtpyDeltRs = selectAcLmAtpyDeltPst.executeQuery();
//			for(int i=1;selectAcLmAtpyDeltRs.next();i++){
//				String acId = selectAcLmAtpyDeltRs.getString("ac_id");				// �˻�id
//				String acSeq = selectAcLmAtpyDeltRs.getString("ac_seq");			// �˻����
//				String loanNo = selectAcLmAtpyDeltRs.getString("loan_no");			// ��ݺ�
//				double paymLoAmt = selectAcLmAtpyDeltRs.getDouble("paym_lo_amt");	// Ӧ��Ƿ����
//				double paymCurAmt = selectAcLmAtpyDeltRs.getDouble("paym_cur_amt");	// Ӧ�����ڽ��
//				double paymAmt = selectAcLmAtpyDeltRs.getDouble("paym_amt");		// Ӧ���ܽ��
//				String repayAcId = null;								// �����˻�id
//				String sts = PUBConstant.AC_LM_ATPY_STS_CREATE;			// ����״̬
//
//				// �Ӵ�������黹���˻�
//				selectAcLnMstPst.setString(1, acId);					// �˻�id
//				selectAcLnMstPst.setString(2, acSeq);					// �˻����
//				//log("select repay_ac_id from AC_LN_MST where ac_id = '"+acId+"' and ac_seqn = '"+acSeqn+"'");
//				selectAcLnMstRs = selectAcLnMstPst.executeQuery();		// ��ѯ��������
//				if(selectAcLnMstRs.next()) {
//					repayAcId = selectAcLnMstRs.getString("repay_ac_id"); 	// �����˻�id
//				}else {
//					throw new Exception("�Ҳ����˻�id:"+acId+" �˻����:"+acSeq+" �ļ�¼");
//				}
//				selectAcLnMstRs.close();
//
//				// ����һ�������ۼ�¼
//				long txlogNo = kg.getTraceNo(traceNoConn);		// ��ȡ������ˮ��
//				insertAcLmAtpyPst.setString(1, seqNo);		// �����������
//				insertAcLmAtpyPst.setString(2, txDt);		// ���ý�������
//				insertAcLmAtpyPst.setLong(3, txlogNo);		// ���ý�����ˮ��
//				insertAcLmAtpyPst.setInt(4, 1);				// ���ý�����ˮ�����
//				insertAcLmAtpyPst.setString(5, acId);		// �����˻�id
//				insertAcLmAtpyPst.setString(6, acSeq);		// �����˻����
//				insertAcLmAtpyPst.setString(7, loanNo);		// ���ý�ݺ�
//				insertAcLmAtpyPst.setString(8, repayAcId);	// ���ý����˻�
//				insertAcLmAtpyPst.setDouble(9, paymAmt);	// ����Ӧ���ܽ��
//				insertAcLmAtpyPst.setDouble(10, paymLoAmt);	// ����Ӧ��Ƿ����
//				insertAcLmAtpyPst.setDouble(11, paymCurAmt);// ����Ӧ�۵��ڽ��
//				insertAcLmAtpyPst.setString(12, txDt);		// ���ô�������
//				insertAcLmAtpyPst.setString(13, txDt);		// �ļ���������
//				insertAcLmAtpyPst.setDouble(14, 0);			// ����ʵ�����
//				insertAcLmAtpyPst.setString(15, sts);		// ��������״̬
//				insertAcLmAtpyPst.setString(16, PUBConstant.Y);	// ���ð��ұ�־
//				insertAcLmAtpyPst.addBatch();
//
//				insertAcLmAtpyPst.executeBatch();
//
//			}
//			insertAcLmAtpyPst.close();
//			selectAcLmAtpyDeltRs.close();
//			selectAcLmAtpyDeltPst.close();
//			selectAcLnMstPst.close();
//			
//			/**
//			 * �����ϴ��ļ�
//			 */
//			FileUtil.write(upFileName, new String[] { "" });
//			PreparedStatement selectAcLmAtpyPst = conn
//					.prepareStatement("select txlog_no,ac_id,ac_seq,loan_no,repay_ac_id,paym_amt from AC_LM_ATPY where tx_dt='"
//							+ txDt
//							+ "' and seq_no = '"
//							+ seqNo
//							+ "' and sts = '"
//							+ PUBConstant.AC_LM_ATPY_STS_CREATE
//							+ "'");
//			ResultSet selectAcLmAtpyRs = selectAcLmAtpyPst.executeQuery();
//			while (selectAcLmAtpyRs.next()) {
//				String loanTxNo = selectAcLmAtpyRs.getString("txlog_no"); // ��ˮ��
//				String acId = selectAcLmAtpyRs.getString("ac_id"); // �˻�id
//				String acSeq = selectAcLmAtpyRs.getString("ac_seq"); // �˻����
//				String loanNo = selectAcLmAtpyRs.getString("loan_no"); // ��ݺ�
//				String paymAcctNo = selectAcLmAtpyRs.getString("repay_ac_id"); // �����˻�
//				double paymAmt = selectAcLmAtpyRs.getDouble("paym_amt"); // �ۿ���
//				String drCr = PUBConstant.DC_IND_D; // �����־
//				String funID = txCode; // ���״���
//
//				FileUtil.write(upFileName, new String[] { loanTxNo, acId, acSeq, loanNo, paymAcctNo, paymAmt + "",
//						drCr, funID });
//			}
//			selectAcLmAtpyPst.close();
//			selectAcLmAtpyRs.close();
//
//
//			// �����´��ļ�
//			createDownFile(upFileName,downFileName, kkAmt);
//
//			// ��ȡ�´��ļ�
//			BufferedReader br = FileUtil.getReader(downFileName); // ��ȡ�´��ļ�������
//			String str = null;
//			// ������������
//			// PreparedStatement updateAcLmAtpy =
//			// conn.prepareStatement("update AC_LM_ATPY set hold_tx_no=?,hold_buss_typ=?,tx_amt=?,sts=? where txlog_no = ? and txlog_seq_no = ?  ");
//			PreparedStatement updateAcLmAtpy = conn
//			.prepareStatement("update AC_LM_ATPY set hold_tx_no=?,hold_buss_typ=?,tx_amt=?,sts=? where ac_id = ? and ac_seq = ? and tx_dt = ? and seq_no =?");
//
//			while ((str = br.readLine()) != null) {
//				if (str.equals("\n") || str.trim().equals("")) {
//					continue;
//				} else {
//					String arg[] = str.split("\\|");
//					String txlogNo = arg[0]; // ��ˮ��
//					String acId = arg[1]; // �˻�id
//					String acSeqn = arg[2]; // �˻����
//					String holdTxNo = arg[8]; // ������ˮ��
//					String holdTrace = arg[9]; // ����ҵ���
//					double actPaymAmt = Double.valueOf(arg[10]); // ʵ�ʿɿ۽��
//
//					// ��������������Ϣ
//					updateAcLmAtpy.setString(1, holdTxNo); // ���ö�����ˮ��
//					updateAcLmAtpy.setString(2, holdTrace); // ���ö���ҵ����
//					updateAcLmAtpy.setDouble(3, actPaymAmt); // ����ʵ�۽��
//					updateAcLmAtpy.setString(4, PUBConstant.AC_LM_ATPY_STS_FREEZE); // ��������״̬
//					// updateAcLmAtpy.setString(5, txlogNo); // ������ˮ��
//					// updateAcLmAtpy.setInt(6, 1); // ���ý�����ˮ�����
//					updateAcLmAtpy.setString(5, acId); // �����˻�id
//					updateAcLmAtpy.setString(6, acSeqn); // �����˻����
//					updateAcLmAtpy.setString(7, txDt); // ���ý�������
//					updateAcLmAtpy.setString(8, seqNo); // �����������
//					// log("update AC_LM_ATPY set hold_tx_no='"+holdTxNo+"',hold_buss_typ='"+holdTrace+"',tx_amt="+actPaymAmt+",sts='"+PUBConstant.AC_LM_ATPY_STS_FREEZE+"' where ac_id = "+acId+" and ac_seqn = "+acSeqn+" and tx_dt = '"+txDt+"' and seq_no ='"+seqNo+"'");
//					updateAcLmAtpy.executeUpdate();
//				}
//			}
//			updateAcLmAtpy.close();
//
//			conn.commit();
////			LoanRepayBatch  lr = new LoanRepayBatch();
////			lr.doBatch(null, null);
//
//		} catch (Exception e) {
//			try {
//				conn.rollback();
//			} catch (SQLException e1) {
//				e1.printStackTrace();
//			}
//		}
//
//	}
	/**
	 * �����´��ļ�
	 * 
	 * @throws Exception
	 */
	private static void createDownFile(String upFileName, String downFileName,double kkAmt) throws Exception {
		BufferedReader br = FileUtil.getReader(upFileName); // ��ȡ�´��ļ�������
		String str = null;
		FileUtil.write(downFileName, new String[] { "" });
		while ((str = br.readLine()) != null) {
			if (str.equals("\n") || str.trim().equals("")) {
				continue;
			} else {
				String arg[] = str.split("\\|");

				String loanTxNo = arg[0];                   // ��ˮ��
				String acId = arg[1]; 			            // �˻�id
				String acSeqn = arg[2]; 		            // �˻����
				String loanNo = arg[3];		                // ��ݺ�
				String paymAcctNo = arg[4];                 // �����˻�
				double paymAmt = Double.valueOf(arg[5]);; 	// �ۿ���
				String drCr = PUBConstant.DC_IND_D;			// �����־
				String funID = TransCode.LNCQ;				// ���״���

				FileUtil.write(downFileName,new String[]{loanTxNo,acId,acSeqn,loanNo,paymAcctNo,paymAmt+"",drCr,funID,"","",kkAmt+""});
			}
		}
		br.close();
	}

//	public static void getKkAmt (String txDt,String loanNo1) {
//
//
//		Connection conn =   ConnectionPool.getInstance().getConnection();
//		String seqNo = PUBConstant.BAT_LOAN_REPAY;
//		try {
//
//			//ɾ���Զ��ۿ��������Ϣ
//			String deleteAcLmAtpySql="delete from AC_LM_ATPY where  tx_dt='"+txDt+"' and seq_No='"+seqNo+"'";
//			PreparedStatement deleteAcLmAtpyPst = conn.prepareStatement(deleteAcLmAtpySql);
//			deleteAcLmAtpyPst.executeUpdate();
//			deleteAcLmAtpyPst.close();
//
//			//ɾ���Զ��ۿ����ϸ����Ϣ
//			String deleteAcLmAtpyDetlSql="delete from AC_LM_ATPY_DETL where  tx_dt='"+txDt+"' and seq_No='"+seqNo+"'";
//			PreparedStatement deleteAcLmAtpyDetlPst = conn.prepareStatement(deleteAcLmAtpyDetlSql);
//			deleteAcLmAtpyDetlPst.executeUpdate();
//			deleteAcLmAtpyDetlPst.close();
//			
//			
//			// ���ڻ���ƻ������ݲ��뵽������ϸ����
//			PreparedStatement insertAcLmAtpyDetlPst = conn.prepareStatement("insert into AC_LM_ATPY_DETL (seq_no,tx_dt,ac_id,ac_seq,loan_no,prcp_amt,int_amt,create_dt,paym_amt,perd_no,cur_ind,mortgage_ind) select "+seqNo+",'"+txDt+"',ac_id,ac_seq,loan_no,prcp_amt,norm_intst,'"+txDt+"',prcp_amt+norm_intst,perd_no,'"+PUBConstant.Y+"','"+PUBConstant.Y+"' from AC_LN_PAY_PLN_CUR where end_dt = '"+txDt+"' and loan_no='"+loanNo1+"' ");
//			int countCur = insertAcLmAtpyDetlPst.executeUpdate();
//			// Ƿ������ݲ��뵽������ϸ����
//			String str2 = "insert into AC_LM_ATPY_DETL (seq_no,tx_dt,ac_id,ac_seq,loan_no,prcp_amt,int_amt,create_dt,paym_amt,perd_no,cur_ind,mortgage_ind,od_int,comp_int) select "+seqNo+",'"+txDt+"',ac_id,ac_seq,loan_no,prcp_amt,norm_intst,'"+txDt+"',prcp_amt+norm_intst+over_intst+cmpd_amt,perd_no,'"+PUBConstant.N+"','"+PUBConstant.Y+"',over_intst,cmpd_amt from AC_LN_LO where setl_sts = '"+PUBConstant.N+"' and end_dt<='"+txDt+"' and loan_no='"+loanNo1+"' ";
//			System.out.println(str2); 
//			insertAcLmAtpyDetlPst = conn.prepareStatement(str2);
//			int countLo = insertAcLmAtpyDetlPst.executeUpdate();
//			insertAcLmAtpyDetlPst.close();
//
//			/**
//			 * ���ۿ���ϸ���¼����ۿ������ AC_LM_ATPY
//			 */
//			// �Ӵ�������黹���˻�
//			PreparedStatement selectAcLnMstPst = conn.prepareStatement("select repay_ac_id from AC_LN_MST where ac_id = ? and ac_seq = ?");
//
//			// ����һ�����������¼
//			PreparedStatement insertAcLmAtpyPst = conn.prepareStatement("insert into ac_lm_atpy(seq_no,tx_dt,txlog_no,txlog_seq_no,ac_id,ac_seq,loan_no,repay_ac_id,paym_amt,paym_lo_amt,paym_cur_amt,create_dt,spool_dt,tx_amt,sts,mortgage_ind) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
//
//			// �ӿۿ���ϸ���в�ѯδ����Ƿ���¼���Խ�����,�鵱�ڻ����¼,�Խ��ȫ����
//			PreparedStatement selectAcLmAtpyDeltPst = conn.prepareStatement("select nvl(l.ac_id,c.ac_id)as ac_id,nvl(l.ac_seq,c.ac_seq)as ac_seq,nvl(c.loan_no,l.loan_no) as loan_no,l.paym_lo_amt,c.paym_cur_amt,nvl(l.paym_lo_amt,0)+nvl(c.paym_cur_amt,0) as paym_amt from (select loan_no,ac_id,ac_seq,sum(paym_amt) as paym_lo_amt from AC_LM_ATPY_DETL where cur_ind='N' and seq_no=? and tx_dt = ? group by ac_id,ac_seq,loan_no) l full join (select loan_no,ac_id,ac_seq,paym_amt as paym_cur_amt from AC_LM_ATPY_DETL where cur_ind='Y' and tx_dt = ? and seq_no=?) c on l.ac_id=c.ac_id and l.ac_seq=c.ac_seq");
//			selectAcLmAtpyDeltPst.setString(1, seqNo);		// �����������
//			selectAcLmAtpyDeltPst.setString(2, txDt);		// ���ý�������
//			selectAcLmAtpyDeltPst.setString(3, txDt);		// ���ý�������
//			selectAcLmAtpyDeltPst.setString(4, seqNo);		// �����������
//			ResultSet selectAcLmAtpyDeltRs = selectAcLmAtpyDeltPst.executeQuery();
//			int i=1;
//			for( i=1;selectAcLmAtpyDeltRs.next();i++){
//
//				String loanNo = selectAcLmAtpyDeltRs.getString("loan_no");			// ��ݺ�
//				double paymLoAmt = selectAcLmAtpyDeltRs.getDouble("paym_lo_amt");	// Ӧ��Ƿ����
//				double paymCurAmt = selectAcLmAtpyDeltRs.getDouble("paym_cur_amt");	// Ӧ�����ڽ��
//				double paymAmt = selectAcLmAtpyDeltRs.getDouble("paym_amt");		// Ӧ���ܽ��
//				System.out.println(loanNo+"Ӧ���ܽ��Ϊ��"+paymAmt);
//				System.out.println(loanNo+"Ƿ����Ϊ��"+paymLoAmt);
//				System.out.println(loanNo+"���ڽ��Ϊ��"+paymCurAmt);
//
//			}
//			System.out.println(i-1+"����¼");
//			insertAcLmAtpyPst.close();
//			selectAcLmAtpyDeltRs.close();
//			selectAcLmAtpyDeltPst.close();
//			selectAcLnMstPst.close();
//
//
//
//			conn.commit();
//
//		} catch (Exception e) {
//			try {
//				e.printStackTrace() ;
//				conn.rollback();
//			} catch (SQLException e1) {
//				e1.printStackTrace();
//			}
//		}
//
//	}
}
