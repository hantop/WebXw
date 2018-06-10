package accounting.batch.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import accounting.plat.PUBConstant;

/**
 * ��ˮ�Ź�����
 *
 */
public class KeyGen {

	private static KeyGen kg = new KeyGen();
	private long curNo = 0;		// ��ǰ��ˮ��
	private long endNo = 0;		// ���е������ˮ��
	private int cycle = 100;	// ������ˮ������
	
	private KeyGen(){}
	
	/**
	 * �õ���ˮ�Ź�������������
	 * @return ��ˮ�Ź���������
	 */
	public static KeyGen getKeyGen(){
		return kg;
	}
	
	/**
	 * ���ù�����������ˮ������,��ÿ�δ����ݿ���ȡ������ˮ������
	 * @param cycle ������ˮ������
	 */
	private void setCycle(int cycle){
		this.cycle = cycle;
	}
	
	/**
	 * �õ�������ˮ������
	 * @return ������ˮ������
	 */
	public int getCycle(){
		return cycle;
	}
	
//	/**
//	 * �õ���ˮ��
//	 * @param conn	��ȡ��ˮ�ŵ�ר������
//	 * @return	��ǰ��ˮ��
//	 * @throws Exception
//	 */
//	public synchronized String getTraceNo(Connection conn) throws Exception{
//		if(curNo==endNo){
//			curNo = getSimpleSerNum(cycle,PUBConstant.TRACENOATYPE, PUBConstant.OWNER, 18,conn) ;
//			endNo = curNo + cycle;
//		}
//		return String.valueOf(++curNo);
//	}
	
	/**
	 * �����ݿ��еõ���ˮ��,�����ݳ�����ˮ�������Ա����
	 * @param cycle	������ˮ������
	 * @param atype ��ˮ������
	 * @param owner	��ˮ��������
	 * @param length ��ˮ�ų���
	 * @param conn	���ݿ����Ӷ���
	 * @return	��ǰ��ˮ��
	 * @throws Exception
	 */
	public static long getSimpleSerNum(int cycle,String atype, String owner, int length, Connection conn) throws Exception {
		StringBuffer primaryKey = new StringBuffer() ;

		String sql = "select cur_sernum from AC_CMIS_AUTOCODE where atype='" + atype + "' and owner='" + owner + "' for update" ;

		try {
			conn.setAutoCommit(false) ;
			Statement stmt = conn.createStatement() ;
			ResultSet rs = stmt.executeQuery(sql) ;
			if (rs.next()) {
				Long curSernum=Long.valueOf(rs.getString("cur_sernum"));
				String update = "update AC_CMIS_AUTOCODE set cur_sernum=" + (curSernum+ cycle) +" where atype='" + atype + "' and owner='" + owner + "'";
				stmt.executeUpdate(update) ;
				StringBuffer temp = new StringBuffer(curSernum+"") ;
				if (temp.length() <= length) {
					int tempLength = length - temp.length() ;
					for (int i = 0 ; i <tempLength ; i++) {
						temp.insert(0, 0) ;
					}
				} else {
					temp = temp.delete(0, temp.length() - length) ;
				}
				primaryKey.append(temp) ;
			}
			conn.commit() ;
			rs.close() ;
			stmt.close() ;
			
		} catch (Exception e) {
			e.printStackTrace() ;
			try {
				conn.rollback() ;
			} catch (SQLException e1) {
				e1.printStackTrace() ;
				throw new Exception(e) ;
			}
			e.printStackTrace() ;
			throw new Exception(e) ;
		}
		return Long.valueOf(primaryKey.toString()) ;
	}
}
