package app.creditapp.ln.worker;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

import app.util.DBUtils;

/**
 * @���� DHCC-����
 * @���� Jul 28, 2016
 * @���� ����ȫ���̹����� ���ô洢���� ����ģʽ
 */
public class WorkUtils {
	
	private static WorkUtils instance = null;
	private static Map<String,Float> rgAppRateMap = null;
	
	public static Map<String, Float> getRgAppRateMap() {
		if (rgAppRateMap != null) {
			return rgAppRateMap;
		}
		rgAppRateMap = new HashMap<String,Float>();
		return rgAppRateMap;
	}

	private static Map<String,String> rulesNameMap = null;
	
	public static Map<String, String> getRulesNameMap() {
		if (rulesNameMap != null) {
			return rulesNameMap;
		}
		rulesNameMap = new HashMap<String,String>();
		return rulesNameMap;
	}
	
	private WorkUtils() {
	}
	
	public static synchronized WorkUtils getInstance() {
		if (instance != null) {
			return instance;
		}
		instance = new WorkUtils();
		return instance;
	}
	
	/***
	 * @���� wangtao
	 * @���� Jul 11, 2016
	 * @����˵�������ô洢���̽���Ԥ�����ڲ�����ɸ��
	 * @���ز��� ɸ����
	 */
	public String proc_pre_screen(String batch_no){
		Connection conn = null;
		CallableStatement proc = null;
		String _val_result = "0"; // Ĭ��ɸ�鲻ͨ��
		try {
			conn = DBUtils.getConn();
		  	// ���ô洢���̽����ڲ�����ɸ��
	      	proc = conn.prepareCall("{ call PKG_PRE_APPLY.PROC_PRE_SCREEN(?,?) }"); //���ô洢����
	      	proc.setString(1, batch_no);//���õ�һ�������������
	      	proc.registerOutParameter(2, Types.VARCHAR);//�ڶ��������������,��VARCHAR���͵�
	      	proc.execute();// ִ��
	      	_val_result = proc.getString(2);//����������
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeStatement(proc);
			DBUtils.closeConnection(conn);
		}
	    return _val_result;
	}
	
	/***
	 * @���� wangtao
	 * @���� Jul 11, 2016
	 * @����˵�������ô洢���̽����ظ������ж�
	 * @���ز��� ɸ����
	 */
	public String proc_pact_repeat(String app_id){
		Connection conn = null;
		CallableStatement proc = null;
		String _val_result = "0"; // Ĭ��ɸ�鲻ͨ��
		try {
			conn = DBUtils.getConn();
		  	// ���ô洢���̽����ڲ�����ɸ��
	      	proc = conn.prepareCall("{ call PKG_LN_APPLY.PROC_PACT_REPEAT(?,?) }"); //���ô洢����
	      	proc.setString(1, app_id);//���õ�һ�������������
	      	proc.registerOutParameter(2, Types.VARCHAR);//�ڶ��������������,��VARCHAR���͵�
	      	proc.execute();// ִ��
	      	_val_result = proc.getString(2);//����������
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeStatement(proc);
			DBUtils.closeConnection(conn);
		}
	    return _val_result;
	}
	
	/***
	 * @���� wangtao
	 * @���� Jul 11, 2016
	 * @����˵�������ô洢���̽����ڲ�����ɸ��
	 * @���ز��� ɸ����
	 */
	public String proc_ln_screen(String app_id){
		Connection conn = null;
		CallableStatement proc = null;
		String _val_result = "0"; // Ĭ��ɸ�鲻ͨ��
		try {
			conn = DBUtils.getConn();
		  	// ���ô洢���̽����ڲ�����ɸ��
	      	proc = conn.prepareCall("{ call PKG_LN_APPLY.PROC_LN_SCREEN(?,?) }"); //���ô洢����
	      	proc.setString(1, app_id);//���õ�һ�������������
	      	proc.registerOutParameter(2, Types.VARCHAR);//�ڶ��������������,��VARCHAR���͵�
	      	proc.execute();// ִ��
	      	_val_result = proc.getString(2);//����������
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeStatement(proc);
			DBUtils.closeConnection(conn);
		}
	    return _val_result;
	}
	/***
	 * @���� wangtao
	 * @���� Jul 11, 2016
	 * @����˵�������ô洢���̽��пͻ���Ϣ���
	 * @���ز��� ɸ����
	 */
	public String proc_cif_split(String app_id){
		Connection conn = null;
		CallableStatement proc = null;
		String _split_result="0"; // ��ֳɹ���־��Ĭ��ʧ��
		try {
			conn = DBUtils.getConn();
		  	//  ���ô洢���̽��пͻ���Ϣ���
		  	proc = conn.prepareCall("{ call PKG_LN_APPLY.PROC_CIF_SPLIT(?,?) }"); //���ô洢����
    	  	proc.setString(1, app_id); // ���õ�һ�������������
	      	proc.registerOutParameter(2, Types.VARCHAR); // �ڶ��������������,��VARCHAR���͵�
	      	proc.execute(); // ִ��
	      	_split_result = proc.getString(2);//����������
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeStatement(proc);
			DBUtils.closeConnection(conn);
		}
	    return _split_result;
	}
	/***
	 * @���� wangtao
	 * @���� Jul 11, 2016
	 * @����˵�������ô洢����������ʽ���������
	 * @���ز��� ɸ����
	 */
	public String proc_mid_toreg(String app_id){
		Connection conn = null;
		CallableStatement proc = null;
		String _mid_toreg="0"; // ������ʽ���������ɹ���־��Ĭ��ʧ��
		try {
			conn = DBUtils.getConn();
			// ���ô洢����������ʽ���������
		    proc = conn.prepareCall("{ call PKG_LN_APPLY.PROC_MID_TOREG(?,?) }"); //���ô洢����
		    proc.setString(1, app_id);//���õ�һ�������������
		    proc.registerOutParameter(2, Types.VARCHAR);//�ڶ��������������,��VARCHAR���͵�
		    proc.execute();// ִ��
		    _mid_toreg = proc.getString(2);//����������
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeStatement(proc);
			DBUtils.closeConnection(conn);
		}
	    return _mid_toreg;
	}
	/***
	 * @���� wangtao
	 * @���� Jul 11, 2016
	 * @����˵�������ô洢���̽�����ʽ������Ϣ���
	 * @���ز��� ɸ����
	 */
	public String proc_apply_split(String app_id){
		Connection conn = null;
		CallableStatement proc = null;
		String _split_result="0"; // ��ֳɹ���־��Ĭ��ʧ��
		try {
			conn = DBUtils.getConn();
			//  ���ô洢���̽�����ʽ������Ϣ���
			proc = conn.prepareCall("{ call PKG_LN_APPLY.PROC_APPLY_SPLIT(?,?) }"); //���ô洢����
			proc.setString(1, app_id); // ���õ�һ�������������
			proc.registerOutParameter(2, Types.VARCHAR); // �ڶ��������������,��VARCHAR���͵�
			proc.execute(); // ִ��
			_split_result = proc.getString(2);//����������
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeStatement(proc);
			DBUtils.closeConnection(conn);
		}
	    return _split_result;
	}
	/***
	 * @���� wangtao
	 * @���� Jul 11, 2016
	 * @����˵�����Զ������� ���ô洢���� ����������� �������������״̬ ����ҵ��׶α� �������������
	 * @���ز��� ɸ����
	 */
	public String proc_up_status(String app_id,String app_sts,String app_desc){
		Connection conn = null;
		CallableStatement proc = null;
		String _up_result = "0"; // Ĭ��Ϊʧ��
		try {
			conn = DBUtils.getConn();
		  	//  �Զ������� ���ô洢���� ����������� �������������״̬ ����ҵ��׶α� �������������
		  	proc = conn.prepareCall("{ call PKG_LN_APPROVE.PROC_UP_STATUS(?,?,?,?) }"); //���ô洢����
			proc.setString(1, app_id);//���õ�1�������������
			proc.setString(2, app_sts);        //���õ�2�������������
			proc.setString(3, app_desc);        //���õ�3�������������
			proc.registerOutParameter(4, Types.VARCHAR);//��4�������������,��VARCHAR���͵�
			proc.execute();// ִ��
			_up_result = proc.getString(4);//����������
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeStatement(proc);
			DBUtils.closeConnection(conn);
		}
	    return _up_result;
	}
	/***
	 * @���� wangtao
	 * @���� Jul 11, 2016
	 * @����˵�������ô洢���� ���ɺ�ͬ
	 * @���ز��� ɸ����
	 */
	public String proc_apply_topact(String app_id,String appr_type){
		Connection conn = null;
		CallableStatement proc = null;
		String _topact_sts = "0";// ���ɺ�ͬ�ɹ���־ 1�ɹ� 0ʧ��
		try {
			conn = DBUtils.getConn();
			//  ���ô洢���� ���ɺ�ͬ
		  	proc = conn.prepareCall("{ call PKG_LN_PACT.PROC_APPLY_TOPACT(?,?,?) }"); //���ô洢����
		  	proc.setString(1, app_id); // ���õ�1������������� ҵ����
		  	proc.setString(2, appr_type); // ���õ�2������������� ��������
		  	proc.registerOutParameter(3, Types.VARCHAR);//��2�������������,��VARCHAR���͵�
		  	proc.execute();// ִ��
		  	_topact_sts = proc.getString(3);//����������
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeStatement(proc);
			DBUtils.closeConnection(conn);
		}
	    return _topact_sts;
	}
	/***
	 * @���� wangtao
	 * @���� Jul 11, 2016
	 * @����˵�������ô洢���� ���ɽ��
	 * @���ز��� ɸ����
	 */
	public String proc_pact_todue(String app_id){
		Connection conn = null;
		CallableStatement proc = null;
		String _todue_sts = "0";// ���ɽ�ݳɹ���־ 1�ɹ� 0ʧ��
		try {
			conn = DBUtils.getConn();
			// ���ô洢�������ɽ��
			proc = conn.prepareCall("{ call PKG_LN_DUE.PROC_PACT_TODUE(?,?) }");
			proc.setString(1, app_id); // ���õ�1������������� ��ͬ��
			proc.registerOutParameter(2, Types.VARCHAR);//��2�������������,��VARCHAR���͵�
			proc.execute();// ִ��
			_todue_sts = proc.getString(2);//����������
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeStatement(proc);
			DBUtils.closeConnection(conn);
		}
	    return _todue_sts;
	}
	/***
	 * @���� wangtao
	 * @���� Jul 11, 2016
	 * @����˵�������ô洢���̽��з���
	 * @���ز��� ɸ����
	 */
	public String proc_acc_fund(String due_no,String proj_no,Double due_amt,String mtr_date){
		Connection conn = null;
		CallableStatement proc = null;
		String _split_sts = "03";// ���˳ɹ���־ [02�ɹ� 03ʧ��]
		try {
			conn = DBUtils.getConn();
			// ���ô洢���̽��з���
			proc = conn.prepareCall("{ call PKG_LN_DUE.PROC_ACC_FUND(?,?,?,?) }"); //���ô洢����
			proc.setString(1, due_no); // ���õ�1������������� ��ݱ��
			proc.setString(2, proj_no); // ���õ�2������������� ������Ŀ���
			proc.setDouble(3, due_amt); // ���õ�3������������� ��ݽ��
			proc.registerOutParameter(4, Types.VARCHAR);// ��5�������������,��VARCHAR���͵�
			proc.execute();// ִ��
			_split_sts = proc.getString(4);// ���˳ɹ���־ [02�ɹ� 03ʧ��]
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeStatement(proc);
			DBUtils.closeConnection(conn);
		}
	    return _split_sts;
	}
	/***
	 * @���� wangtao
	 * @���� Jul 11, 2016
	 * @����˵�������ô洢���̸���pactIdɾ����ͬ����ݱ�������йصı�
	 * @���ز��� ɸ����
	 */
	public String proc_pact_del(String pact_id){
		Connection conn = null;
		CallableStatement proc = null;
		String _del_result = "0"; // Ĭ��ɾ��ʧ��
		try {
			conn = DBUtils.getConn();
		  	// ���ô洢���̽����ڲ�����ɸ��
	      	proc = conn.prepareCall("{ call PKG_LN_PACT.PROC_PACT_DEL(?,?) }"); //���ô洢����
	      	proc.setString(1, pact_id);//���õ�һ�������������
	      	proc.registerOutParameter(2, Types.VARCHAR);//�ڶ��������������,��VARCHAR���͵�
	      	proc.execute();// ִ��
	      	_del_result = proc.getString(2);//����������
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeStatement(proc);
			DBUtils.closeConnection(conn);
		}
	    return _del_result;
	}
	
	public void proc_up_stage(String appId,String columns,String value,String rsDesc){
		Connection conn = null;
		CallableStatement proc = null;
		try {
			  conn = DBUtils.getConn();
			  //conn = DBUtil.getConnection(); // �������ý��в�����
			  // ���ô洢���̸���ln_stageҵ��׶α�
		      proc = conn.prepareCall("{ call PKG_LN_APPLY.PROC_UP_STAGE(?,?,?,?) }"); //���ô洢����
		      proc.setString(1, appId); //���õ�1�������������
		      proc.setString(2, columns); //���õ�2�������������
		      proc.setString(3, value); //���õ�3�������������
		      proc.setString(4, rsDesc); //���õ�4�������������
		      proc.execute(); // ִ��
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeStatement(proc);
			DBUtils.closeConnection(conn);
		}
	}
	//�Զ�����ʧ��ɾ�������
	public String proc_apply_del(String appId){
		Connection conn = null;
		CallableStatement proc = null;
		String _del_result = "0"; // Ĭ��ɾ��ʧ��
		try {
			  conn = DBUtils.getConn();
			  //conn = DBUtil.getConnection(); // �������ý��в�����
			  // ���ô洢���̸���ln_stageҵ��׶α�
		      proc = conn.prepareCall("{ call PKG_LN_APPLY.PROC_APPLY_DEL(?,?) }"); //���ô洢����
		      proc.setString(1, appId); //���õ�1�������������
		      proc.registerOutParameter(2, Types.VARCHAR);//�ڶ��������������,��VARCHAR���͵�
		      proc.execute(); // ִ��
		      _del_result = proc.getString(2);//����������
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeStatement(proc);
			DBUtils.closeConnection(conn);
		}
		return _del_result;
	}
	//ͬ����Ŀ
	public void proc_proj_acct(){
		Connection conn = null;
		CallableStatement proc = null;
		try {
			  conn = DBUtils.getConn();
			  // ���ô洢����
		      proc = conn.prepareCall("{ call PKG_BAT_PATCH.PROC_PROJ_ACCT}");
		      proc.execute(); // ִ��
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeStatement(proc);
			DBUtils.closeConnection(conn);
		}
	}
}
