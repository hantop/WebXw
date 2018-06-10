package accounting.biz.pub;

import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import accounting.plat.CreatePrimaryKey;
import accounting.plat.PUBConstant;
import accounting.plat.core.AccountingException;
import accounting.plat.dao.JdbcDao;
import accounting.plat.util.NumberUtil;
import accounting.plat.util.TransUtil;
import app.util.DBUtils;

public class ParmBiz {
	
	/**
	 * ����˻�ID
	 * 
	 * @return �˻�ID
	 * @throws AccountingException
	 */
	public static String getAcId() throws AccountingException {
		return CreatePrimaryKey.getSimpleSerNum(PUBConstant.ACIDOATYPE, PUBConstant.OWNER, 10);
	}

	/**
	 * ���oracle���ݿ��ʱ��,��ʽΪ20180705
	 * 
	 * @return ���ݿ�ʱ��
	 * @throws AccountingException
	 */
	public static String getOracleTxDate(Connection conn) throws AccountingException {
		ResultSet rs = null;
		Statement st = null;
		String time = null; 
		try {
			rs = JdbcDao.executeQuery(st,rs,"select TO_CHAR(SYSDATE, 'YYYYMMDD HH24:MI:SS') from dual ", conn);
			if (rs.next()) {
				time = rs.getString(1);
				time = time.split(" ")[0];
				// System.out.println(time);
				time = time.substring(0, time.length());
			}
			st = rs.getStatement();
		} catch (SQLException e) {
			throw new AccountingException(e);
		}finally{
			JdbcDao.close(st, rs);
		}
		return time;
	}

	/**
	 * ���oracle���ݿ��ʱ��,��ʽΪ10:34:06
	 * 
	 * @return ���ݿ�ʱ��
	 * @throws AccountingException
	 */
	public static String getOracleTxTime(Connection conn) throws AccountingException {
		ResultSet rs = null;
		Statement st = null;
		String time = null;
		try {
			rs = JdbcDao.executeQuery(st,rs,"select TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') from dual  ", conn);
			if (rs.next()) {
				time = rs.getString(1);
				time = time.split(" ")[1];
				// System.out.println(time);
				time = time.substring(0, time.length());
			}
			st = rs.getStatement();
		} catch (SQLException e) {
			throw new AccountingException(e);
		}finally{
			JdbcDao.close(st, rs);
		}
		return time;
	}
	
	/**
	 * ���oracle���ݿ��ʱ��,��ʽΪ2018-07-01 10:34:06
	 * 
	 * @return ���ݿ�ʱ��
	 * @throws AccountingException
	 */
	public static String getOracleUpDate2(Connection conn) throws AccountingException {
		ResultSet rs = null;
		Statement st = null;
		String time = null;
		try {
			rs = JdbcDao.executeQuery(st,rs,"select TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') from dual ", conn);
			if (rs.next()) {
				time = rs.getString(1);
			}
			st = rs.getStatement();
		} catch (SQLException e) {
			throw new AccountingException(e);
		}finally{
			JdbcDao.close(st, rs);
		}
		return time;
	}
	
	/**
	 * ���oracle���ݿ��ʱ��,��ʽΪ2018-07-01 10:34:06
	 * 
	 * @return ���ݿ�ʱ��
	 * @throws AccountingException
	 */
	public static String getProjIdByProjNo(String projNo,Connection conn) throws AccountingException {

		String projId = null;
		ResultSet rs = null;
		Statement st = null;
		try {
			rs = JdbcDao.executeQuery(st,rs,"select proj_id from proj_base where proj_no='"+projNo+"'", conn);
			if (rs.next()) {
				projId = rs.getString("proj_id");
			}
			st = rs.getStatement();
		} catch (SQLException e) {
			throw new AccountingException(e);
		}finally{
			JdbcDao.close(st, rs);
		}

		return projId;
	}
	
	public static void main(String[] args) {
		try {
			String projId = getProjIdByProjNo("28946",DBUtils.getConn());
			System.out.println(projId);
		} catch (AccountingException e) {
			e.printStackTrace();
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
	}
	/**
	 * ���oracle���ݿ��ʱ��,��ʽΪ20180701 10:34:06
	 * 
	 * @return ���ݿ�ʱ��
	 * @throws AccountingException
	 */
	public static String getOracleUpDate(Connection conn) throws AccountingException {
		ResultSet rs = null;
		Statement st = null;
		String time = null;
		try {
			rs = JdbcDao.executeQuery(st,rs,"select TO_CHAR(SYSDATE, 'YYYYMMDD HH24:MI:SS') from dual ", conn);
			if (rs.next()) {
				time = rs.getString(1);
			}
			st = rs.getStatement();
		} catch (SQLException e) {
			throw new AccountingException(e);
		}finally{
			JdbcDao.close(st, rs);
		}
		return time;
	}

	/**
	 * 
	 * @throws SQLException 
	 * @���� DHCC-LIUJ
	 * @���� 2018-4-25
	 * @����	��ȡ���㽻������
	 */
	public static String getBizDt(Connection conn) throws AccountingException{
		ResultSet rs = null;
		Statement st = null;
		String time = null;
		try {
			rs = JdbcDao.executeQuery(st,rs,"select sys_dt from ac_com_sys_parm ", conn);
			if (rs.next()) {
				time = rs.getString(1);
			}
			st = rs.getStatement();
		} catch (SQLException e) {
			throw new AccountingException(e);
		}finally{
			JdbcDao.close(st, rs);
		}
		return time;
	}

	/**
	 * �Խ�����������
	 * 
	 * @param acm
	 *            ���
	 * @param intUnit
	 *            ��������λ����
	 * @param intTyp
	 *            ����������
	 * @return ��������Ľ��
	 * @throws AccountingException
	 */
	public static double parseAmt(double amt, int intUnit, String intTyp) throws AccountingException {
		if (intTyp == null || intTyp.equals("")) {
			throw new AccountingException("����������е�����������Ϊ��!");
		}
		RoundingMode roundingMode = TransUtil.transRounding(intTyp); // �������������
		if (roundingMode == null) {
			throw new AccountingException("����������е��������������ò���ȷ!");
		}
		// ����������
		amt = NumberUtil.getDouble(amt, intUnit, roundingMode);

		return amt;
	}
	
	/**
	 * �õ�WsBaseSeq 
	 * @param conn
	 * @return
	 * @throws AccountingException
	 */
	public static String getWsBaseSeq(Connection conn)throws AccountingException{
		String wsBaseSeq = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT WS_BASE_SEQ.NEXTVAL FROM DUAL";
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {
				wsBaseSeq = rs.getString(1);
			}
			stmt.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new AccountingException(e);
		} finally{
			try{
				if(rs!=null){rs.close();}
				if(stmt!=null){stmt.close();}
			}catch (Exception e) {
				e.printStackTrace();
				throw new AccountingException(e);
			}
		}
		return wsBaseSeq;
	}
	
	/**
	 * �õ��ۿ���ϸ��ˮ��
	 * @param conn
	 * @return
	 * @throws AccountingException
	 */
	public static String getAcDebitDtlNo(Connection conn)throws AccountingException{
		String acLoanLogNo = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT AC_DEBIT_DTL_SEQ.NEXTVAL FROM DUAL";
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {
				acLoanLogNo = rs.getString(1);
			}
			stmt.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new AccountingException(e);
		} finally{
			try{
				if(rs!=null){rs.close();}
				if(stmt!=null){stmt.close();}
			}catch (Exception e) {
				e.printStackTrace();
				throw new AccountingException(e);
			}
		}
		return acLoanLogNo;
	}
	
	/**
	 * �õ��ۿ�/�ſ� ������ˮ��
	 * @param conn
	 * @return
	 * @throws AccountingException
	 */
	public static String getBackLoanNo(Connection conn)throws AccountingException{
		String backLoanNo = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT AC_LOAN_BACK_LOG_SEQ.NEXTVAL FROM DUAL";
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {
				backLoanNo = rs.getString(1);
			}
			stmt.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new AccountingException(e);
		} finally{
			try{
				if(rs!=null){rs.close();}
				if(stmt!=null){stmt.close();}
			}catch (Exception e) {
				e.printStackTrace();
				throw new AccountingException(e);
			}
		}
		return backLoanNo;
	}
	
	/**
	 * �õ��ſ���ˮ��
	 * @param conn
	 * @return
	 * @throws AccountingException
	 */
	public static String getAcLoanLogNo(Connection conn)throws AccountingException{
		String acLoanLogNo = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT AC_LOAN_LOG_SEQ.NEXTVAL FROM DUAL";
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {
				acLoanLogNo = rs.getString(1);
			}
			stmt.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new AccountingException(e);
		} finally{
			try{
				if(rs!=null){rs.close();}
				if(stmt!=null){stmt.close();}
			}catch (Exception e) {
				e.printStackTrace();
				throw new AccountingException(e);
			}
		}
		return acLoanLogNo;
	}
	
	/**
	 * �õ�������ˮ��
	 * @param conn
	 * @return
	 * @throws AccountingException
	 */
	public static String getTraceNo(Connection conn)throws AccountingException{
		String dcNo = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT AC_TRACE_LOG_SEQ.NEXTVAL FROM DUAL";
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			if (rs.next()) {
				dcNo = rs.getString(1);
			}
			stmt.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new AccountingException(e);
		} finally{
			try{
				if(rs!=null){rs.close();}
				if(stmt!=null){stmt.close();}
			}catch (Exception e) {
				e.printStackTrace();
				throw new AccountingException(e);
			}
		}
		return dcNo;
	}
	
	/**
	 * �õ�������ˮ��
	 * @param conn
	 * @return
	 * @throws AccountingException
	 */
	public static String getDebitNo(Connection conn)throws AccountingException{
		String dcNo = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT AC_DEBIT_SEQ.NEXTVAL FROM DUAL";
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {
				dcNo = rs.getString(1);
			}
			stmt.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new AccountingException(e);
		} finally{
			try{
				if(rs!=null){rs.close();}
				if(stmt!=null){stmt.close();}
			}catch (Exception e) {
				e.printStackTrace();
				throw new AccountingException(e);
			}
		}
		return dcNo;
	}
	/**
	 * �õ���������¼ID
	 * @param conn
	 * @return
	 * @throws AccountingException
	 */
	public static String getAftCompstId(Connection conn)throws AccountingException{
		String compstId = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT AFT_COMPST_SEQ.NEXTVAL FROM DUAL";
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {
				compstId = rs.getString(1);
			}
			stmt.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new AccountingException(e);
		} finally{
			try{
				if(rs!=null){rs.close();}
				if(stmt!=null){stmt.close();}
			}catch (Exception e) {
				e.printStackTrace();
				throw new AccountingException(e);
			}
		}
		return compstId;
	}
	
	/**
	 * �õ����ع���¼ID
	 * @param conn
	 * @return
	 * @throws AccountingException
	 */
	public static String getAftRebuyId(Connection conn)throws AccountingException{
		String rebuyId = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT AFT_REBUY_SEQ.NEXTVAL FROM DUAL";
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {
				rebuyId = rs.getString(1);
			}
			stmt.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new AccountingException(e);
		} finally{
			try{
				if(rs!=null){rs.close();}
				if(stmt!=null){stmt.close();}
			}catch (Exception e) {
				e.printStackTrace();
				throw new AccountingException(e);
			}
		}
		return rebuyId;
	}
	
	/**
	 * �õ�����ID
	 * @param conn
	 * @return
	 * @throws AccountingException
	 */
	public static String getAcChrgLogId(Connection conn)throws AccountingException{
		String rebuyId = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT AC_CHRG_LOG_SEQ.NEXTVAL FROM DUAL";
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {
				rebuyId = rs.getString(1);
			}
			stmt.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new AccountingException(e);
		} finally{
			try{
				if(rs!=null){rs.close();}
				if(stmt!=null){stmt.close();}
			}catch (Exception e) {
				e.printStackTrace();
				throw new AccountingException(e);
			}
		}
		return rebuyId;
	}
	/**
	 * �õ��ۿ�/�ſ� ������ˮ��
	 * @param conn
	 * @return
	 * @throws AccountingException
	 */
	public static String getAcLoanBackLogNo(Connection conn)throws AccountingException{
		String backLoanNo = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT AC_LOAN_BACK_LOG_SEQ.NEXTVAL FROM DUAL";
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {
				backLoanNo = rs.getString(1);
			}
			stmt.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new AccountingException(e);
		} finally{
			try{
				if(rs!=null){rs.close();}
				if(stmt!=null){stmt.close();}
			}catch (Exception e) {
				e.printStackTrace();
				throw new AccountingException(e);
			}
		}
		return backLoanNo;
	}
	
	/**
	 * �õ��ſ���ˮ��
	 * @param conn
	 * @return
	 * @throws AccountingException
	 */
	public static String getLoanLogNo(Connection conn)throws AccountingException{
		String acLoanLogNo = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
//		String sql = "SELECT AC_LOAN_LOG_SEQ.NEXTVAL FROM DUAL";
		String sql = "SELECT LOAN_LOG_NO_SEQ.NEXTVAL FROM DUAL";
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {
				acLoanLogNo = rs.getString(1);
			}
			stmt.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new AccountingException(e);
		} finally{
			try{
				if(rs!=null){rs.close();}
				if(stmt!=null){stmt.close();}
			}catch (Exception e) {
				e.printStackTrace();
				throw new AccountingException(e);
			}
		}
		return acLoanLogNo;
	}
	/**
	 * �õ�backCntSeq 
	 * @param conn
	 * @return
	 * @throws AccountingException
	 */
	public static String getBackCntSeq(Connection conn)throws AccountingException{
		String backCntSeq = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT BACK_CNT_SEQ.NEXTVAL FROM DUAL";
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {
				backCntSeq = rs.getString(1);
			}
			stmt.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new AccountingException(e);
		} finally{
			try{
				if(rs!=null){rs.close();}
				if(stmt!=null){stmt.close();}
			}catch (Exception e) {
				e.printStackTrace();
				throw new AccountingException(e);
			}
		}
		return backCntSeq;
	}
}
