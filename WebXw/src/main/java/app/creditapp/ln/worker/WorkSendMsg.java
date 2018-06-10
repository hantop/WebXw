package app.creditapp.ln.worker;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import accounting.biz.pub.ParmBiz;
import accounting.plat.PUBConstant;
import app.base.SourceTemplate;
import app.creditapp.batch.util.DBUtil;
import app.creditapp.inf.client.ZfTradeInf;
/**
 * @���� DHCC-SONG
 * @���� Jun 6, 2016
 * @���� ҵ����A�ڵ� �Ƿ��ظ� ɸ�� ��ֿͻ� ���� ׼��
 */
public class WorkSendMsg implements Runnable {
	Logger logger = Logger.getLogger(WorkSendMsg.class);
	private String message;
	private String backType;
	
	public WorkSendMsg(String message,String backType) {
		this.message = message;
		this.backType = backType;
	}
	/***
	 * @���� DHCC-SONG
	 * @���� Jun 29, 2016
	 * @����˵����֧�����ķ���
	 * @���ز��� void
	 */
	public void run() {
		Connection conn = null;
		try {
		    if(message==null||"".equals(message)){
		    	  logger.error("���յ�����Ϊ�գ�");
		    }else{
		    	conn = DBUtil.getConnection();
		    	String uuid = "";
		    	String brNo = "";
		    	PreparedStatement insertWsBase = null;
				PreparedStatement updateWsBase = null;
				PreparedStatement updateAcLoanBackLoag = null;
				String wsBaseId = "";
				insertWsBase = conn.prepareStatement("INSERT INTO WS_BASE (RESP_DESC, WS_DATE, REQ_CONTENT, WS_TIME, WS_STS,TX_CODE, WS_BASE_ID) VALUES(?,?,?,?,?,?,?)");
				updateWsBase = conn.prepareStatement("UPDATE WS_BASE SET RESP_CONTENT = ? , BR_NO = ? ,WS_SERIAL = ? ,RESP_TIME = ? WHERE WS_BASE_ID = ?");
				updateAcLoanBackLoag = conn.prepareStatement("UPDATE AC_LOAN_BACK_LOG SET BACK_STS = ? , TX_TIME = ?  WHERE UUID = ? AND BACK_STS = '01'");
				
				wsBaseId = ParmBiz.getWsBaseSeq(conn);
				
				insertWsBase.setString(1, "֧�����״���ص����ͳɹ�");
				insertWsBase.setString(2, ParmBiz.getBizDt(conn));
				insertWsBase.setString(3, message);
				insertWsBase.setString(4, ParmBiz.getOracleUpDate(conn));
				insertWsBase.setString(5, "01");
				insertWsBase.setString(6, "P100001");
				insertWsBase.setString(7, wsBaseId);
				insertWsBase.execute();
				if(null!=insertWsBase){
					insertWsBase.close();
				}
				conn.commit();
				
				ZfTradeInf ZfTradeService = (ZfTradeInf) SourceTemplate.getSpringContextInstance().getBean("zfTradeInf");
				String result = null;//��Ӧ���
				String respTime = "";//��Ӧʱ��
				try {
					result = ZfTradeService.doAction("P100001", message);
					respTime = ParmBiz.getOracleUpDate(conn);
				}catch (RuntimeException a){ 
					logger.error(a.getMessage());
					logger.error("��֧��ϵͳͨѶ�쳣");
					respTime = ParmBiz.getOracleUpDate(conn);
//					Map<String,String> returnMap = SendZF.readStringXmlHeader(message); 
//					uuid = returnMap.get("UUID").toString();
					//�ǼǷ��ͱ���ʱ��
					updateAcLoanBackLoag.setString(1, PUBConstant.BACK_STS_03);
					updateAcLoanBackLoag.setString(2, ParmBiz.getOracleUpDate(conn));
					updateAcLoanBackLoag.setString(3, uuid);
					updateAcLoanBackLoag.executeUpdate();
					if(null!=updateAcLoanBackLoag){
						updateAcLoanBackLoag.close();
					}
					conn.commit();
//					List<AcLoanBackLog> acLoanBackLogList = (ArrayList)JdbcDao.queryList(new AcLoanBackLog(), "uuid='"+ uuid + "' and back_sts = '03'","ac_loan_back_log", conn);
					//����֧������״̬���¶�Ӧ�ı�
//					brNo = updateBack(99999, "��֧��ϵͳͨѶ�쳣��Ĭ�Ϸ��ͳɹ�", message,acLoanBackLogList, conn);
				}catch (Exception e) {
					logger.error(e.getMessage());
					logger.error("��֧��ϵͳͨѶ�쳣");
					respTime = ParmBiz.getOracleUpDate(conn);
//					Map<String,String> returnMap = SendZF.readStringXmlHeader(message); 
//					uuid = returnMap.get("UUID").toString();
					//�ǼǷ��ͱ���ʱ��
					updateAcLoanBackLoag.setString(1, PUBConstant.BACK_STS_03);
					updateAcLoanBackLoag.setString(2, ParmBiz.getOracleUpDate(conn));
					updateAcLoanBackLoag.setString(3, uuid);
					updateAcLoanBackLoag.executeUpdate();
					if(null!=updateAcLoanBackLoag){
						updateAcLoanBackLoag.close();
					}
					conn.commit();
//					List<AcLoanBackLog> acLoanBackLogList = (ArrayList)JdbcDao.queryList(new AcLoanBackLog(), "uuid='"+ uuid + "' and back_sts = '03'","ac_loan_back_log", conn);
//					//����֧������״̬���¶�Ӧ�ı�
//					brNo = updateBack(10000, "��֧��ϵͳͨѶ�쳣��Ĭ�Ϸ��ͳɹ�", message,acLoanBackLogList, conn);
				}
				
				if(result!=null){
					//��ȡ����ֵ
//					Map<String,String> returnMap = SendZF.readStringXmlOut(result); 
//					String payStatus = returnMap.get("ResultCode").toString();
//					int status = Integer.parseInt(payStatus);
//					uuid = returnMap.get("UUID").toString();
//					if(88888 == status){//֧��ͣ�������������ٴη���
//						Jedis jedis = RedisUtil.getJedis();
//						if(PUBConstant.BACK_TYPE_01.equals(backType)){
//							jedis.lpush(RedisUtil.QUEUE8, message);// 
//						}else{
//							jedis.lpush(RedisUtil.QUEUE7, message);// 
//						}
//						jedis.close();
					}else{
						
//						String dealDesc = returnMap.get("ResultMsg");
//						dealDesc = dealDesc.getBytes("GB2312").length>300?dealDesc.substring(0,150):dealDesc;
//						//�ǼǷ��ͱ���ʱ��
//						updateAcLoanBackLoag.setString(1, PUBConstant.BACK_STS_02);
//						updateAcLoanBackLoag.setString(2, ParmBiz.getOracleUpDate(conn));
//						updateAcLoanBackLoag.setString(3, uuid);
//						updateAcLoanBackLoag.executeUpdate();
//						if(null!=updateAcLoanBackLoag){
//							updateAcLoanBackLoag.close();
//						}
//						conn.commit();
//						List<AcLoanBackLog> acLoanBackLogList = (ArrayList)JdbcDao.queryList(new AcLoanBackLog(), "uuid='"+ uuid + "' and back_sts = '02'","ac_loan_back_log", conn);
//						//����֧������״̬���¶�Ӧ�ı�
//						brNo = updateBack(status, dealDesc, message,acLoanBackLogList, conn);
					}
					
				}
//				updateWsBase.setString(1, result);
//				updateWsBase.setString(2, brNo);
//				updateWsBase.setString(3, uuid);
//				updateWsBase.setString(4, respTime);
//				updateWsBase.setString(5, wsBaseId);
//				updateWsBase.executeUpdate();
//				if(null!=updateWsBase){
//					updateWsBase.close();
//				}
//				conn.commit();
//		    	logger.info(backType+"���ͱ���UUID--->>>"+uuid);
//		    }
		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}finally {
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					logger.error(e.getMessage());
				}
			}
		}
	}
	/**
	 * @���� DHCC-WXK
	 * @���� 2017-5-2
	 * @param status
	 * @param dealDesc
	 * @param message
	 * @param acLoanBackLogList
	 * @param conn
	 * @return
	 * @���� ����֧�����ݷ��ر��Ľ�����Ӧ���ݴ���
	 */
//	private String updateBack(int status,String dealDesc,String message,List<AcLoanBackLog> acLoanBackLogList,Connection conn){
//		String brNo = "";
//		if(acLoanBackLogList!=null&&acLoanBackLogList.size()>0){
//			if(status>=10000&&status<20000){
//			}else{
//				//�ſ���Ϣ
//				AcLoanLog acLoanLog = null;
//				//�ſ���ϢList
//				List<AcLoanLog> acLoanLogList = new ArrayList<AcLoanLog>();
//				//�ۿ���Ϣ
//				AcDebit acDebit = null;
//				//�ۿ���Ϣlist
//				List<AcDebit> acDebitList = new ArrayList<AcDebit>();
//				try {
//					for (AcLoanBackLog acLoanBackLog : acLoanBackLogList) {
//						if(PUBConstant.BACK_TYPE_01.equals(acLoanBackLog.getBackType())){//�ſ�
//							acLoanLog = new AcLoanLog();
//							acLoanLog = (AcLoanLog)JdbcDao.query(new AcLoanLog(), "loan_log_no='"+acLoanBackLog.getLoanLogNo()+"'", "ac_loan_log", conn);
//							brNo = acLoanLog.getBrNo();
//							acLoanLogList.add(acLoanLog);
//						}else{
//							acDebit = new AcDebit();
//							acDebit = (AcDebit)JdbcDao.query(new AcDebit(), "debit_no='"+acLoanBackLog.getLoanLogNo()+"'", "ac_debit", conn);
//							brNo = acDebit.getBrNo();
//							acDebitList.add(acDebit);
//						}
//					}
//					SendZF.updateBack(status, dealDesc, acLoanLogList, acDebitList, acLoanBackLogList, conn);
//				} catch (Exception e) {
//					logger.error(e.getMessage());
//				}
//			}
//		}
//		return brNo;
//		
//	}
}
