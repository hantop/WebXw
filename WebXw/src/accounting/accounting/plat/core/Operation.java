package accounting.plat.core;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.sql.Connection;
import java.sql.SQLException;

import accounting.domain.sys.AcSysLog;
import accounting.domain.sys.AfferentDomain;
import accounting.plat.PUBConstant;
import accounting.plat.dao.JdbcDao;

public abstract class Operation {

	private String id;                       // OPע��XML�еı�ʾOP��Ψһ��ʶ�� Ҳ�ǽ�����
	private String describe;                 // OPע��XML�е�������Ϣ
	private Connection connection;           // ����
	private AfferentDomain afferentDomain;   // ����ҵ�����ݶ���
	private String traceNo;                    // ������ˮ��
	private boolean oldAutoCommit;           // ���洫�ݹ������ӵ��Զ��ύ����ֵ�����ں���ģ��ʹ�ú��ٰ����ӵ��Զ��ύ����ֵ��ԭ
	//private HashMap<String, String> configTable = new HashMap<String, String>();

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	protected Connection getConnection() throws AccountingException {

		if (connection == null) {
			throw new AccountingException("����Ϊ��");
		}
		return connection;
	}

	public String getDescribe() {
		return this.describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

	public AfferentDomain getAfferentDomain() {
		return afferentDomain;
	}

	public void setAfferentDomain(AfferentDomain afferentDomain) {
		this.afferentDomain = afferentDomain;
	}

	public String getTraceNo() {
		return traceNo;
	}

	protected void setTraceNo(String traceNo) {
		this.traceNo = traceNo;
	}

	public boolean isOldAutoCommit() {
		return oldAutoCommit;
	}

	public void setOldAutoCommit(boolean oldAutoCommit) {
		this.oldAutoCommit = oldAutoCommit;
	}

	/** 
	 * ����OP����ڷ���
	 * @param afferentDomain ����ҵ�����ݶ���
	 * 
	 */
	public final Object execute(AfferentDomain afferentDomain)
			throws AccountingException {
		String message=null;	// ����״̬��Ϣ
		String flag=null;		// ���гɹ���־
		if(!PUBConstant.SYS_STS.equals("0")){
			throw new AccountingException("ϵͳ��ǰ״̬����\"����\",���ܽ��н���");
		}
		try {
			this.connection.setAutoCommit(false);
		} catch (SQLException e1) {
			e1.printStackTrace();
			throw new AccountingException(e1);
		}
		Object ob = null;
		try {
			ob = doExecute(afferentDomain);
			try {
				connection.commit();
				message = "ִ�гɹ�";
				flag = "Y";
			} catch (SQLException e) {
				e.printStackTrace();
				throw new AccountingException(e);
			}
		} catch(AccountingException e) {
			try {
				message = e.getMessage();
				flag = "N";
				connection.rollback();
				
			} catch (SQLException e1) {
				e1.printStackTrace();
				throw new AccountingException(e1);
			}
			throw e;
		}catch (Exception e) {
			try {
				message = e.getMessage();
				flag = "N";
				connection.rollback();
				
			} catch (SQLException e1) {
				e1.printStackTrace();
				throw new AccountingException(e1);
			}
			throw new AccountingException(e);
		} finally {
			try {
				insertSysLog(afferentDomain,message,flag,connection);		// ����ִ�м�¼
				this.connection.setAutoCommit(this.oldAutoCommit);
			} catch (SQLException e) {
				e.printStackTrace();
				throw new AccountingException(e);
			}
		}
		return ob;
	}

	/**
	 * ����ִ�м�¼
	 * @param afferentDomain ����ҵ�����ݶ���
	 * @param message ��������״̬��Ϣ
	 * @param flag �������гɹ���־
	 * @throws AccountingException
	 */
	private void insertSysLog(AfferentDomain afferentDomain, String reason, String flag,Connection conn)
			throws AccountingException {
		try {
			StringBuffer message = new StringBuffer();
			AcSysLog acSysLog = new AcSysLog();
			acSysLog.setTraceNo(traceNo);					// ������ˮ��
			acSysLog.setTxDt(PUBConstant.CUR_PRCS_DT);		// ���ý�������
			acSysLog.setExecInd(flag);						// ���ý������гɹ���־ 
			acSysLog.setReason(reason);				    	// ���ý���ִ��״̬��Ϣ
			acSysLog.setTxBrNo(afferentDomain.getBrNo());	// ���ý��׻�����
			acSysLog.setTxCde(id);							// ���ý��״���
			acSysLog.setUsrId(afferentDomain.getUsrId());	// ���ù�Ա��
			
			/**
			 * ���ý��ײ����б�
			 */
			BeanInfo beanInfo = Introspector.getBeanInfo(afferentDomain.getClass());
			PropertyDescriptor[] des = beanInfo.getPropertyDescriptors();
			for (PropertyDescriptor pro : des) {
				if(pro.getName().equals("class")){
					continue;
				}
				message.append(pro.getName()+"="+(pro.getReadMethod().invoke(afferentDomain)==null?"":pro.getReadMethod().invoke(afferentDomain).toString())+"&");
				if (pro.getName().equals("loanNo")) {
					// ���ý�ݺ�
					acSysLog.setLoanNo(pro.getReadMethod().invoke(afferentDomain)==null?"":pro.getReadMethod().invoke(afferentDomain).toString());
				}
			}
			acSysLog.setTraceValue01(message.substring(0, message.length()-3));
			JdbcDao.insert(acSysLog, "ac_sys_log", connection);
			connection.commit();
		} catch (Exception e1) {
			try {
				connection.rollback();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
			e1.printStackTrace();
			throw new AccountingException(e1);
		}
	}

	/**
	 * �������ʵ�ֵķ������ڸ÷����ڽ���ҵ���߼�����
	 * @param afferentDomain ����ҵ�����ݶ���
	 * 
	 */
	public abstract Object doExecute(AfferentDomain afferentDomain)
			throws AccountingException;

}
