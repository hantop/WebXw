package app.base;

public class PUBParm {
	
	/**
	 * �ͻ�ҵ������
	 */
	public static final String OLD_NEW_IND = "0"; // ��һ���Ŵ��͵ڶ����Ŵ���ʶ
	
	public static final String CIF_BIZ_TYPE_AFFILIATE = "6";//�ҿ���˾
	public static final String CIF_BIZ_TYPE_INVESTOR = "5";//������
	public static final String CIF_BIZ_TYPE_PARTNER = "4";//�������
	public static final String CIF_BIZ_TYPE_SUPPLIER = "3";//��Ӧ��
	public static final String CIF_BIZ_TYPE_DEALER = "2";//������
	public static final String CIF_BIZ_TYPE_CONSUMER = "1";//ҵ��ͻ�
	
	public static final String CIF_FORMAL_SEPARATOR = "|";//�ͻ���ʶ�ָ���
	
	public static final String CIF_CORP_FORMAL_LESSEE = "1";//������
	public static final String CIF_CORP_FORMAL_GUARANTOR = "2";//��֤��
	public static final String CIF_CORP_FORMAL_SUPPLIER = "3";//������
	public static final String CIF_CORP_FORMAL_DEALER = "4";//������
	public static final String CIF_CORP_FORMAL_PARTNER = "5";//�����������
	public static final String CIF_CORP_FORMAL_AFFILIATE = "6";//�ҿ���˾
	public static final String CIF_CORP_FORMAL_MORTGAGOR = "7";//��Ѻ��
	public static final String CIF_CORP_FORMAL_PLEDGOR = "8";//��Ѻ��

	public static final String CIF_PERS_FORMAL_LESSEE = "1";//������
	public static final String CIF_PERS_FORMAL_GUARANTOR = "2";//��֤��
	public static final String CIF_PERS_FORMAL_MORTGAGOR = "3";//������
	public static final String CIF_PERS_FORMAL_PLEDGOR = "4";//������
	
	
	/**
	 * ������״̬
	 */
	public static String LAM_STATUS_CODE_1ST = "1";	//������¼��           ����������״̬Ϊ1
	public static String LAM_STATUS_CODE_2ND = "2";	//�����ύ                �����ύʱ����������ӿڽ�����������������״̬��Ϊ�����ύ
	public static String LAM_STATUS_CODE_3TH = "3";	//�ſ���Ϣ���      �ſ����Ϣ�޸ı���ʱ����Ϊ3
	public static String LAM_STATUS_CODE_5TH = "5";	//��Ч                          ����ͨѶ�ſ�ɹ����޸�ҵ��̨��״̬ʱ�޸ĳ���״̬Ϊ��Ч    
	public static String LAM_STATUS_CODE_6TH = "6";	//ʧЧ                         ��Ȩת��ʱ����������ӿڽ���״̬��ΪʧЧ
	public static String LAM_STATUS_CODE_8TH = "8";	//���                          ������ʱ����������ӿڽ������������������״̬��Ϊ���
	public static String LAM_STATUS_CODE_9TH = "9";	//����                          ��������ʱ����������ӿڽ���״̬��Ϊ����
	/**
	 * ���޺�ͬ״̬
	 */
	public static final String PACT_STS_1TH = "1"; // δǩ��
	public static final String PACT_STS_2TH = "2"; // ����
	public static final String PACT_STS_3TH = "3"; // ����30������
	public static final String PACT_STS_4TH = "4"; // ����30��60
	public static final String PACT_STS_5TH = "5"; // ����60��90
	public static final String PACT_STS_6TH = "6"; // ����90������
	public static final String PACT_STS_7TH = "7"; // ��ע��
	public static final String PACT_STS_8TH = "8"; // δʹ����ע��
	
	/**
	 * ����̨��״̬
	 */
	public static final String ACC_STATUS_0TH ="0";//����δȷ��
	public static final String ACC_STATUS_1TH ="1";//����
	public static final String ACC_STATUS_2TH ="2";//����
	public static final String ACC_STATUS_8TH ="8";//����
	public static final String ACC_STATUS_9TH ="9";//�ѻ���
	
		
	public static final String CIF_PERS_CHARACTER_NORMAL = "1";//һ��ͻ�����������
	public static final String CIF_PERS_CHARACTER_HANDLER = "2";//�����̵ĸ߹ܣ���׼����
	public static final String CIF_PERS_CHARACTER_STAFF = "3";//��˾�ڲ�Ա������׼����-10%

	/**
	 * ϵͳ��¼�û���ɫ����
	 */
	public static final String ROLE_TYPE_INVESTOR = "SH100";//������
	public static final String ROLE_TYPE_PARTNER = "SH100";//�������
	public static final String ROLE_TYPE_SUPPLIER = "SH004";//��Ӧ��
	public static final String ROLE_TYPE_DEALER = "SH003";//������(����ҵ��)
	public static final String ROLE_TYPE_CONSUMER = "SH001";//ҵ��ͻ�
	public static final String ROLE_TYPE_DEALER_S = "SH005";//������(������ҵ��)
	public static final String ROLE_TYPE_ADVISERS = "SH108";//���ڹ���

	public static String CIF_TYPE_PERS = "2";//���˿ͻ�
	public static String CIF_TYPE_CORP = "1";//�Թ��ͻ�
	
	/**
	 * �ͻ�ϸ������
	 */
	public static String PJE_CUST_TYPE_STORE = "10";//��Ӫ��
	public static String PJE_CUST_TYPE_NAT = "11";//��Ȼ��
	public static String PJE_CUST_TYPE_CORP = "12";//���˿ͻ�
	
	/**
	 * ���ڲ�Ʒ����
	 */
	public static String PRD_TYPE_COMMERCIAL = "PRD0003";//���ó�
	public static String PRD_TYPE_PASSENGER = "PRD0002";//���ó�
	public static String PRD_TYPE_MACHINE = "PRD0001";//���̻�е
	
	
	public static final String AUTOCODE_TYP_LNP_LOAN = "CreateKey.LnpLoan.getKey"; // �����ͬ����
	public static final String AUTOCODE_TYP_LNP_WLOAN = "CreateKey.LnpWLoan.getKey"; // ί�д����ͬ����
	public static final String AUTOCODE_TYP_LNP_LNEX = "CreateKey.LnpLoanExtend.getKey"; // չ��Э�����
	public static final String AUTOCODE_TYP_LNP_ACCP = "CreateKey.LnpAccp.getKey"; // ����Э�����
	public static final String AUTOCODE_TYP_LNP_CVRG = "CreateKey.LnpCvrg.getKey"; // ����Э�����
	public static final String AUTOCODE_TYP_LNP_DISC = "CreateKey.LnpDisc.getKey"; // ����Э�����
	public static final String AUTOCODE_TYP_LNP_REDISCIN = "CreateKey.LnpRediscin.getKey"; // ת��������Э�����
	public static final String AUTOCODE_TYP_LNP_REDISCOUT = "CreateKey.LnpRediscout.getKey"; // ת��������Э�����
	public static final String AUTOCODE_TYP_LNP_CMT = "CreateKey.LnpCmt.getKey"; // ��ŵЭ�����
	public static final String AUTOCODE_TYP_LNP_PACK = "CreateKey.LnpPack.getKey"; // �������Э�����
	public static final String AUTOCODE_TYP_LNP_CRD = "CreateKey.LnpCrd.getKey"; // ����֤Э�����
	public static final String AUTOCODE_TYP_LNP_CRDADJUST = "CreateKey.LnpCrdAdjust.getKey"; // ����֤���Э�����
	public static final String AUTOCODE_TYP_LNP_FACTORING = "CreateKey.LnpFactoring.getKey"; // ���ڡ����ڱ���Э�����
	public static final String AUTOCODE_TYP_LNP_INFACTORING = "CreateKey.LnpInfactoring.getKey"; // ���ڱ���Э�����
	public static final String AUTOCODE_TYP_LNP_BP = "CreateKey.LnpBp.getKey"; // ����Ѻ��Э�����
	public static final String AUTOCODE_TYP_LNP_BE = "CreateKey.LnpBe.getKey"; // ����Ѻ��Э�����
	public static final String AUTOCODE_TYP_LNP_FORFEITING = "CreateKey.LnpForfeiting.getKey"; // ����͢Э�����
	public static final String AUTOCODE_TYP_LNP_DO_GTY = "CreateKey.LnpDoGty.getKey"; // �������Э�����
	public static final String AUTOCODE_TYP_LNP_PRJ = "CreateKey.LnpPrj.getKey"; // ������Э�����
	public static final String AUTOCODE_TYP_PRD = "CreateKey.prd.getKey"; // ��Ʒ����
	public static final String AUTOCODE_TYP_PRD_M = "CreateKey.prdm.getKey"; // ���۲�Ʒ
	public static final String AUTOCODE_TYP_GRT = "CreateKey.grt.getKey"; // ��������
	public static final String AUTOCODE_TYP_LAM = "CreateKey.lam.getKey"; // ���������
	public static final String AUTOCODE_TYP_AC_TRACE = "CreateKey.acTraceLog.getKey";//������ˮ
	public static final String AUTOCODE_TYP_AC_ATPY = "CreateKey.lmAtpyTraceNo.getKey";//������ˮ��
	public static final String AUTOCODE_TYP_RCL_RECALL_BASE = "CreateKey.rclRecallBase.getKey";//�����˹���������
	public static final String AUTOCODE_TYP_AUTH_SUB = "CreateKey.authSub.getKey";//������ˮ
	public static final String AUTOCODE_TYP_FUND_ID = "CreateKey.fundId.getKey";//�ʽ���ϸ��ˮ��
	public static final String AUTOCODE_TYP_ATPY_ID = "CreateKey.atpyId.getKey";//������ϸ��ˮ��
	public static final String AUTOCODE_AC_RECT_REG= "CreateKey.acRectReg.getKey"; // ����Ǽ�����
	
	/*
	 * ���ڲ�Ʒ����
	 */
	public static final String DUE_GRT_REL_1ST = "1";//�ſ�ǰ��Ѻ
	public static final String DUE_GRT_REL_2ND = "2";//�ſ���Ѻ
	
	
	/*
	 * ����״̬
	 */
	public static final String APP_STS_1TH = "1"; // ������
	public static final String APP_STS_2TH = "2"; // ������
	public static final String APP_STS_3TH = "3"; // ����ͨ��
	public static final String APP_STS_4TH = "4"; // �������
	public static final String APP_STS_5TH = "5"; // ��������

	public static final String WKF_APP_STS_ZERO = "0"; // δ�ύ
	public static final String WKF_APP_STS_1ST = "1"; // ������
	public static final String WKF_APP_STS_2ND = "2"; // �˻�
	public static final String WKF_APP_STS_3RD = "3"; // ���
	public static final String WKF_APP_STS_4TH = "4"; // ͨ��
	public static final String WKF_APP_STS_6TH = "6"; // �ϴ�����



	
			
	/*
	 * ��������
	 */
	public static final String CONT_LND_1TH = "0";// δ����
	public static final String CONT_LND_2TH = "1";// ���ֳ���
	public static final String CONT_LND_3TH = "2";// ȫ������
	/*
	 * ������ͬ����
	 */
	public static final String VOU_CONT_TYPE_1ST = "1";// һ�㵣����ͬ
	public static final String VOU_CONT_TYPE_2ND = "2";// ��߶����ͬ
	
	/*
	 * ������ͬ״̬
	 */
	public static final String PLUS_PACT_STS_1ST = "1"; // ��Ч
	public static final String PLUS_PACT_STS_2ND = "2"; // ע��
	public static final String PLUS_PACT_STS_3RD = "3"; // ��У��
	public static final String PLUS_PACT_STS_ZERO = "0"; // δ��Ч
	
	// ����Ѻ��״̬
	public static final String GP_STATUS_CODE_1ST = "10001"; // �Ǽ�
	public static final String GP_STATUS_CODE_3RD = "10003"; // ռ�ô�����
	public static final String GP_STATUS_CODE_4TH = "10004"; // ����
	public static final String GP_STATUS_CODE_5TH = "10005"; // ���δ����
	public static final String GP_STATUS_CODE_6TH = "10006"; // ����Ѽ���
	public static final String GP_STATUS_CODE_7TH = "10007"; // ����δ����
	public static final String GP_STATUS_CODE_8TH = "10008"; // �����Ѻ���
	public static final String GP_STATUS_CODE_9TH = "10009"; // δ����
	public static final String GP_STATUS_CODE_10TH = "10010"; // �����Ѳ�¼
	
	// ��Ѻ������

	public static final String GRT_P_METAL = "10011"; // �����,grt0302,grtpmetal
	public static final String GRT_P_NATIONAL_DBT = "10012"; // ծȯ,grt0310,grtpnationaldbt
	public static final String GRT_P_REAL_POLICY = "10013"; // ����,grt0309,grtppolicy
	public static final String GRT_P_BILL = "10014"; // Ʊ��,grt0307,grtpbill
	public static final String GRT_P_DEPOT = "10015"; // �ֵ�/�ᵥ,grt0312,grtpdepot
	public static final String GRT_P_STOCK = "10016"; // ��Ȩ/��Ʊ/����,grt0311,grtpstock
	public static final String GRT_P_DEPOSIT_REC = "10017"; // �浥,grt0305,grtpdepositrec
	public static final String GRT_P_ACCOUNT_REC = "10018"; // Ӧ���˿�,grt0314,grtpaccountrec
	public static final String GRT_P_STORE = "10019"; // ����ʹ��Ȩ,grt0313,grtpstore
	public static final String GRT_P_OTHER = "10021"; // ��Ѻ������,grt0317,grtpother
	public static final String GRT_P_MOVABLE = "10022"; // ������,grt0315,grtpmovable
	public static final String GRT_P_TRADEMARK = "10023"; // �̱�ʹ��Ȩ,grt0316,grtptrademark
	
	//����״̬
	public static final String DUE_APP_STS_1TH = "0"; // δ�ύ
	public static final String DUE_APP_STS_2TH = "1"; // ������
	public static final String DUE_APP_STS_3TH = "2"; // ��������
	public static final String DUE_APP_STS_4TH = "3"; // ���
	public static final String DUE_APP_STS_5TH = "4"; // ����ͨ��
	
	//�ļ�����
	public static final String FOUR_STS_1TH = "1"; // ����
	public static final String FOUR_STS_2TH = "2"; // ����
	public static final String FOUR_STS_3TH = "3"; // ����
	public static final String FOUR_STS_4TH = "4"; // ����
	//�弶����
	public static final String FIVE_STS_1TH = "1"; // ����
	public static final String FIVE_STS_2TH = "2"; // ��ע
	public static final String FIVE_STS_3TH = "3"; // �μ�
	public static final String FIVE_STS_4TH = "4"; // ����
	public static final String FIVE_STS_5TH = "5"; // ��ʧ
	
	//�Ƿ�
	public static final String YES_NO_Y = "1"; // ��
	public static final String YES_NO_N = "0"; // ����
	
	//�����̼���
	public static final String DEALER_LEV_1TH = "1"; // һ��
	public static final String DEALER_LEV_2TH = "2"; // ����
	
	//�����̼���
	public static final String PRJ_AUTH_MODE_SUP = "1"; // ����������
	//public static final String PRJ_AUTH_MODE_DEAL = "2"; // �����̷�������
	public static final String PRJ_AUTH_MODE_UNIT = "3"; // ����������
	
	
	//�����̼���
	public static final String PRJ_AUTH_ACC_MODE_SUP = "0"; // ����������
	public static final String PRJ_AUTH_ACC_MODE_DEAL = "1"; // �����̷�������
	public static final String PRJ_AUTH_ACC_MODE_UNIT = "3"; // ����������
	
	public static String AUTH_OCC_TYPE_OCC="2" ;  //ռ��
	public static String AUTH_OCC_TYPE_REBACK="9";   //�ָ�

	public static String AUTH_NORM_TYPE_Y="1";
	public static String AUTH_NORM_TYPE_N="0";
	
	
	//����/�ⶳ ��������
	public static String AUTH_HOLD_TYPE_BLOCK = "2";	//����
	public static String AUTH_HOLD_TYPE_UNBLOCK = "4";	//�ⶳ
	
	public static String AUTH_ICE_FLAG_BLOCKED = "0";	//�Ѷ���
	public static String AUTH_ICE_FLAG_UNBLOCKED = "1";	//δ����
	

	
	//����������
	public static String LAM_TYPE_1ST = "1";	//����
	public static String LAM_TYPE_8TH = "8";	//�ҳ�

	public static final String AUTH_APP_STS_ZERO = "0"; // δ����
	public static final String AUTH_APP_STS_1ST = "1"; // ������
	public static final String AUTH_APP_STS_2ND = "2"; // ��������
	public static final String AUTH_APP_STS_3RD = "3"; // �������
	public static final String AUTH_APP_STS_4TH = "4"; // ����ͨ��
	
	
	public static final String EVAL_OCC_TYPE_NORMAL = "1"; // ��ʽ����
	public static final String EVAL_OCC_TYPE_TRACK = "2"; // ��������
	public static final String EVAL_OCC_TYPE_ADJUST = "3"; // ��������
	
	/**
	 * �ͻ�����:1������,2������,3����(������),4��Ӫ��(������),5��Ȼ��(������)
	 */
	public static final String EVAL_CIF_TYPE_1ST = "1"; // 1������
	public static final String EVAL_CIF_TYPE_2ND = "2"; // 2������
	public static final String EVAL_CIF_TYPE_3RD = "3"; // 3����(������)
	public static final String EVAL_CIF_TYPE_4TH = "4"; // 4��Ӫ��(������)
	public static final String EVAL_CIF_TYPE_5TH = "5"; // 5��Ȼ��(������)
	
	public static final String QUOTA_STS_1 = "1"; //��Ч
	public static final String QUOTA_STS_2 = "2"; //����
	public static final String QUOTA_STS_3 = "3"; //ʧЧ
	public static final String QUOTA_STS_4 = "4"; //��ֹ
	
	
	public static final String TBL_DEPART_BIZ_TYPE_CORP = "1"; // ���޹�˾����
	public static final String TBL_DEPART_BIZ_TYPE_SUP = "2"; // ������
	public static final String TBL_DEPART_BIZ_TYPE_DEAL = "3"; // ������(����ҵ��)
	public static final String TBL_DEPART_BIZ_TYPE_DEAL_S = "4"; // ������(������ҵ��)
	
	public static final String CIF_WFK_APP_STS_1ST = "0"; // δ��Ч
	public static final String CIF_WFK_APP_STS_2ND = "1"; // ����ͨ��
	public static final String CIF_WFK_APP_STS_3RD = "2"; // �������
	
	/*
	 * ����������
	 */
	public static final String AFT1_CHK_TYPE_FIRST = "1"; // �״μ��
	public static final String AFT1_CHK_TYPE_FIX = "2"; // ���ڼ��
	public static final String AFT1_CHK_TYPE_UNFIX = "3"; // �����ڼ��
	
	/*
	 * ������ģ������
	 */
	public static final String AFT1_CHK_MODEL_CON = "1"; // ̨��ģ��
	public static final String AFT1_CHK_MODEL_CIF = "2"; // �ͻ�ģ��
	
	/*
	 * ��������ѡ��
	 */
	public static final String AFT1_CHK_OPT_CON = "1"; // ��̨�˼��
	public static final String AFT1_CHK_OPT_CIF = "2"; // ���û����
	
	/*
	 * ��������ѡ��
	 */
	public static final String AFT1_TASK_STS_INIT = "0"; // δָ��
	public static final String AFT1_TASK_STS_APPT = "1"; // ��ָ��
	public static final String AFT1_TASK_STS_TASK = "2"; // �����
	public static final String AFT1_TASK_STS_OVER = "3"; // �����
	
	public static final String AFT1_CHECK_INIT = "0"; 	//δ���
	public static final String AFT1_CHECK_FINE = "1";	//�Ѽ��
	
	
	public static final String AUTOCODE_CLA_TASK_APP_NO = "CreateKey.claTask.getKey"; // ���շ���������
	public static final String AUTOCODE_CLA_PARM_CONF_NO = "CreateKey.claParmConf.getKey"; // ���շ���ָ�����ñ��
	public static final String AUTOCODE_CLA_MODEL_BIZ_REL_ID = "CreateKey.claModelBizRel.getKey"; // ���շ���ģ����ҵ�����id
	public static final String AUTOCODE_CLA_MOD_LOG_ID = "CreateKey.claModLog.getKey"; // ���շ���ǿ�Ƶ���id
	public static final String AUTOCODE_IQP_PROJECT_ID = "CreateKey.IqpProject.getKey"; // ��������ID(���ó�)
	public static final String AUTOCODE_IQP_PROJECT_COM_ID = "CreateKey.IqpProjectCom.getKey"; // ��������ID(���ó�)
	public static final String AUTOCODE_PAY_FEE_NO = "CreateKey.PayFeeNo.getKey"; // �ɷѱ��
	
	/*
	 * ���շ�������ϸ��ά��
	 */
	public static final String CLA_TASK_DETAIL_TYPE_CIF = "1"; //�ͻ�
	public static final String CLA_TASK_DETAIL_TYPE_ACC = "2"; //̨��
	
	/*
	 * ���շ��࣬������Ƶ��
	 */
	public static final String CLA_CHECK_FREQ_YEAR = "1"; //��
	public static final String CLA_CHECK_FREQ_SEASON = "2"; //��
	public static final String CLA_CHECK_FREQ_MONTH = "3"; //��
	
	/*
	 * ���շ�����������
	 */
	public static final String CLA_TASK_TYPE_01 = "01"; //ϵͳ����
	public static final String CLA_TASK_TYPE_02 = "02"; //�˹�����
	public static final String CLA_TASK_TYPE_03 = "03"; //�˹�����(δ�ύ)
	/*
	 * ���շ�����Ч����
	 */
	public static final String CLA_APPLY_STATUS_0 = "0"; //δ��Ч
	public static final String CLA_APPLY_STATUS_1 = "1"; //����Ч
	
	/*
	 * ��������
	 */
	public static final String ATTRIBUTE_TYPE_1 = "1"; //���̱���
	public static final String ATTRIBUTE_TYPE_2 = "2"; //ҵ������


	//��Ч״̬
	public static String EFFECT_STS_ZERO = "0";	//δ��Ч
	public static String EFFECT_STS_1ST = "1";	//��Ч
	public static String EFFECT_STS_2ND = "2";	//ע��

	//��֤��������
	public static String CIF_SEC_KEY_NAME_1ST = "1";	//ע��
	public static String CIF_SEC_KEY_NAME_2ND = "2";	//����
	public static String CIF_SEC_KEY_NAME_3RN = "3";	//�ֿ����
	
	
	//��ȼ������
	public static String QUOTA_CHECK_TYPE_1 = "1";	//����ܶ�
	public static String QUOTA_CHECK_TYPE_2 = "2";	//�����ڳ���
	public static String QUOTA_CHECK_TYPE_3 = "3";	//�����ڵͷ���
	public static String QUOTA_CHECK_TYPE_4 = "4";	//�������ܶ�
	public static String QUOTA_CHECK_TYPE_5 = "5";	//����г��ڳ���
	public static String QUOTA_CHECK_TYPE_6 = "6";	//����г��ڵͷ���
	public static String QUOTA_CHECK_TYPE_7 = "7";	//����г����ܶ�
	
	public static String QUOTA_TYPE_01 = "01";	//���Ŷ��
	public static String QUOTA_TYPE_02 = "02";	//���������
	public static String QUOTA_TYPE_03 = "03";	//������˾���
	public static String QUOTA_TYPE_04 = "04";	//ͬҵ���
	public static String QUOTA_TYPE_05 = "05";	//�ͻ�Ⱥ���
	public static String QUOTA_TYPE_06 = "06";	//���Ŷ��
	
	public static String CL_TYPE_CREDIT = "01";//���Ŷ��		
	public static String CL_TYPE_GROUP = "02";	//���Ŷ��		
	public static String CL_TYPE_UNION = "03";	//�ͻ�ȺС����	
	public static String CL_TYPE_HOUSE = "04";	//���ز���Ŀ���	
	public static String CL_TYPE_CAR = "05";	//���������̶��	
	public static String CL_TYPE_GUAR = "06";	//������˾���	
	public static String CL_TYPE_THRID = "07";	//�������������	
	public static String CL_TYPE_INTERBANK = "08";	//ͬҵ���
	
	/**
	 * ��ͨ��ϢSCHEME_ID���
	 * REW_SCHEME_ID_1ST ���˰���ҵ��ͻ���������
	 * REW_SCHEME_ID_2ND �����˻��޸�
	 * REW_SCHEME_ID_3RN ��������
     * REW_SCHEME_ID_4ST ������Ϣ
     * REW_SCHEME_ID_5ST �ش��¼�����
	 */
	public static String REW_SCHEME_ID_1ST = "0000000000132067";	//���˰���ҵ��ͻ���������
	public static String REW_SCHEME_ID_2ND = "0000000000132068";	//��ͬ�ű������
	public static String REW_SCHEME_ID_3RN = "0000000000132069";	//��������
	public static String REW_SCHEME_ID_4ST = "0000000000132070";	//������Ϣ
	public static String REW_SCHEME_ID_5ST = "0000000000132071";	//�ش��¼�����
	
	/**
	 * �ͻ�����:�𾴵� {cifName}������ͨʢ��л�������Σ�ף�����տ��֣�
	 */
	public static String SMS_SCENE_16TH = "16";
	/**
	 * �ڼ���:�𾴵� {cifName}������ͨʢ��л�������Σ�ף��������죡
	 */
	public static String SMS_SCENE_15TH = "15";
	
	/**
	 * ���ʵ�����ǰ3��:�𾴵� {cifName}�����ڹ���ͨʢ���»������������������ʵ������ѱ�Ϊ{amt}��
	 * ������ʱ���������������µ�{phone}��
	 */
	public static String SMS_SCENE_14TH = "14";
	
	/**
	 * ���ó�ҵ������(������ҵ������):���ã���˾{year}��{month}��{day}���Ƽ��������Ϊ{appNo}������������Ϊ{cifName}�Ŀͻ���Ŀǰ�������ڻ��������
	 * ��Э����˾���ٿͻ�����򰴺�ͬ�����������������������µ�{phone}��
	 */
	public static String SMS_SCENE_13TH = "13";
	
	/**
	 * ���ó�ҵ������(�ͻ�):�𾴵� {cifName}�����ڹ���ͨʢ��{year}��{month}��{day}�յ��»����Ϊ{amt}��
	 * �����ڣ��뼰ʱ��������Ӱ�����ĸ������ã�������������µ�{phone}��
	 */
	public static String SMS_SCENE_12TH = "12";
	
	/**
	 * ��������3��:�𾴵� {cifName}����ϵظ�л���Թ���ͨʢ�����Σ����Ŀ����ѽ��壬
	 * ����Ͼ������������ļ����ա�ף������˳����������죡
	 */
	public static String SMS_SCENE_11TH = "11";
	
	/**
	 * ���������һ���»���ǰ3��:�𾴵� {cifName}�����ڹ���ͨʢ�����һ�ڻ����Ϊ{amt}���ɱ�֤���֣�
	 * ��˾���ڵ��ڻ����պ�3���������ڷ�������֤�����{secAmt}�����Ļ����˻���
	 * ��ע����գ�������������µ�{phone}��
	 */
	public static String SMS_SCENE_10TH = "10";
	
	/**
	 * �ۿ�ʧ�ܵ���:�𾴵� {cifName}�����ڹ���ͨʢ��{year}��{month}��{day}�յ��»����Ϊ{amt}��
	 * �ۿ�ʧ�ܣ��뼰ʱ����������������µ�{phone}��
	 */
	public static String SMS_SCENE_9TH = "9";
	
	/**
	 * �ۿ�ɹ�����:�𾴵� {cifName}�����ڹ���ͨʢ��{year}��{month}��{day}�յ��»����Ϊ{amt}��
	 * �����ۿ�ɹ���������������µ�{phone}��
	 */
	public static String SMS_SCENE_8TH = "8";
	
	/**
	 * ÿ�»�����ǰ3��:�𾴵� {cifName}�����ڹ���ͨʢ��{year}��{month}��{day}�յ��»����Ϊ{amt}��
	 * �뼰ʱ����������������µ�{phone}��
	 */
	public static String SMS_SCENE_7TH = "7";
	
	/**
	 * ���ͻ���ƻ���ǰ:�𾴵� {cifName}����л��ѡ�����ͨʢ�����ڹ���ͨʢ�Ļ���ƻ����Ѿ������������ʼĵ�ַ�ĳ�
	 * ����ע����գ�����ʱ���������������µ�{phone}��
	 */
	public static String SMS_SCENE_6TH = "6";
	
	/**
	 * ϵͳ�ſ�ͨ��3���:�𾴵� {cifName}����ϵظ�л��ѡ�����ͨʢ��������������µ�{phone}��
	 */
	public static String SMS_SCENE_5TH = "5";
	
	/**
	 * �ʽ�ȫ���ſ�:���ã������Ϊ{appNo}������������Ϊ{cifName}�������Ѿ���ɷſ�{amt}��������������µ�{phone}��
	 */
	public static String SMS_SCENE_4TH = "4";
	
	/**
	 * ϵͳ�ſ�ͨ��:���ã������Ϊ{appNo}������������Ϊ{cifName}�������Ѿ�ͨ���ſ���ˣ���Э���ͻ�������һ����������
	 */
	public static String SMS_SCENE_3RD = "3";
	
	/**
	 * ϵͳ�ܾ�����:���ã������Ϊ{appNo}������������Ϊ{cifName}������δ��������˾���������������л������ϣ�
	 */
	public static String SMS_SCENE_2ND = "2";
	
	/**
	 * ϵͳ��׼����:���ã������Ϊ{appNo}������������Ϊ{cifName}��������ͨ����˾������ˣ���Э���ͻ�������һ��������
	 */
	public static String SMS_SCENE_1ST = "1";
	
	
	/**
	 * �ĵ������еĿͻ�����
	 * DOC_CIF_TYPE_01 �����ޱ�֤��
	 */
	public static final String DOC_CIF_TYPE_01 = "01"; //�����ޱ�֤��
	/**
	 * �ĵ������еĿͻ�����
	 * DOC_CIF_TYPE_02 ������Ȼ�˱�֤��
	 */
	public static final String DOC_CIF_TYPE_02 = "02"; //������Ȼ�˱�֤��
	/**
	 * �ĵ������еĿͻ�����
	 * DOC_CIF_TYPE_03 ���˷��˱�֤��
	 */
	public static final String DOC_CIF_TYPE_03 = "03"; //���˷��˱�֤��
	/**
	 * �ĵ������еĿͻ�����
	 * DOC_CIF_TYPE_04 �Թ��ޱ�֤��
	 */
	public static final String DOC_CIF_TYPE_04 = "04"; //�Թ��ޱ�֤��
	/**
	 * �ĵ������еĿͻ�����
	 * DOC_CIF_TYPE_05 �Թ���Ȼ�˱�֤��
	 */
	public static final String DOC_CIF_TYPE_05 = "05"; //�Թ���Ȼ�˱�֤��
	/**
	 * �ĵ������еĿͻ�����
	 * DOC_CIF_TYPE_06 �Թ����˱�֤��
	 */
	public static final String DOC_CIF_TYPE_06 = "06"; //�Թ����˱�֤��
	/**
	 * �ĵ������еĿͻ�����
	 * DOC_CIF_TYPE_07 ���˻�ϱ�֤��
	 */
	public static final String DOC_CIF_TYPE_07 = "07"; //���˻�ϱ�֤��
	/**
	 * �ĵ������еĿͻ�����
	 * DOC_CIF_TYPE_08 �Թ���ϱ�֤��
	 */
	public static final String DOC_CIF_TYPE_08 = "08"; //�Թ���ϱ�֤��
	/**
	 * �ĵ������е��ĵ�����
	 * DOC_SCENE_01 ҵ������
	 */
	public static final String DOC_SCENE_01 = "01"; //ҵ������
	/**
	 * �ĵ������е��ĵ�����
	 * DOC_SCENE_02 �ſ�����
	 */
	public static final String DOC_SCENE_02 = "02"; //�ſ�����
	/**
	 * �ĵ������е��ĵ�����
	 * DOC_SCENE_02_01 �ſ����벹������
	 */
	public static final String DOC_SCENE_02_01 = "02_01"; //�ſ����벹������
	/**
	 * �ĵ������е��ĵ�����
	 * DOC_SCENE_03 �����̲�������
	 */
	public static final String DOC_SCENE_03 = "01_03"; //�����̲�������
	/**
	 * �ĵ������е��ĵ�����
     * DOC_SCENE_04 �ҷ�
	 */
	public static final String DOC_SCENE_04 = "01_04"; //�ҷ�
	/**
	 * �ĵ������е��ĵ�����
     * DOC_SCENE_05 ��ͬ����
	 */
	public static final String DOC_SCENE_05 = "05"; //��ͬ����
	/**
	 * �ĵ������е��ĵ�����
     * DOC_SCENE_05_01 �����̺�ͬ����
	 */
	public static final String DOC_SCENE_05_01 = "05_01"; //�����̺�ͬ����
	/**
	 * �ĵ������е��ĵ�����
     * DOC_SCENE_06 �����ϴ�
	 */
	public static final String DOC_SCENE_06 = "01_06"; //�����ϴ�
	/**
	 * �ĵ������е��ĵ�����
	 * DOC_SCENE_07 ҵ���ύ�����
	 */
	public static final String DOC_SCENE_07 = "01_07"; //ҵ���ύ�����
	/**
	 * �ĵ������е��ĵ�����
     * DOC_SCENE_21 �����̿ͻ���Ϣ
	 */
	public static final String DOC_SCENE_21 = "21"; //�����̿ͻ���Ϣ
	/**
	 * �ĵ������е��ĵ�����
     * DOC_SCENE_22 �����̿ͻ���Ϣ
	 */
	public static final String DOC_SCENE_22 = "22"; //�����̿ͻ���Ϣ
	/**
	 * �ĵ������е��ĵ�����
     * DOC_SCENE_31 ��ǰ����
	 */
	public static final String DOC_SCENE_31 = "31"; //��ǰ����
	/**
	 * �ĵ������е��ĵ�����
     * DOC_SCENE_32 �����ع�
	 */
	public static final String DOC_SCENE_32 = "32"; //�����ع�
	/**
	 * �ĵ������е��ĵ�����
     * DOC_SCENE_33 �����ع�
	 */
	public static final String DOC_SCENE_33 = "33"; //�����ع�
	/**
	 * �ĵ������е��ĵ�����
     * DOC_SCENE_34 ������ֹ
	 */
	public static final String DOC_SCENE_34 = "34"; //������ֹ
	/**
	 * �ĵ������е��ĵ�����
     * DOC_SCENE_40 ʵ�ش���1
	 */
	public static final String DOC_SCENE_40 = "40"; //ʵ�ش���1
	/**
	 * �ĵ������е��ĵ�����
     * DOC_SCENE_41 ʵ�ش���2
	 */
	public static final String DOC_SCENE_41= "41"; //ʵ�ش���2
	/**
	 * �ĵ������е��ĵ�����
     * DOC_SCENE_42 չ��
	 */
	public static final String DOC_SCENE_42 = "51"; //չ�ڹ���
	/**
	 * �ĵ������е��ĵ�����
     * DOC_SCENE_61 ��ͬ��ֹ
	 */
	public static final String DOC_SCENE_61 = "61"; //��ͬ��ֹ
	/**
	 * �ĵ������е��ϴ���־
	 * DOC_UP_STS_01 δ�ϴ�
	 */
	public static final String DOC_UP_STS_01 = "01"; //δ�ϴ�
	/**
	 * �ĵ������е��ϴ���־
	 * DOC_UP_STS_02 δ�ϴ�
	 */
	public static final String DOC_UP_STS_02 = "02"; //���ϴ�
	
	/**
	 * �ĵ������е��ϴ���־
	 * DOC_READ_STS_01 δ�Ķ�
	 */
	public static final String DOC_READ_STS_01 = "01"; //δ�Ķ�
	/**
	 * �ĵ������е��ϴ���־
	 * DOC_READ_STS_02 ���Ķ�
	 */
	public static final String DOC_READ_STS_02 = "02"; //���Ķ�

	/**
	 * �ĵ������е���ȡ��־
	 * DOC_GET_STS_01 δ��ȡ
	 */
	public static final String DOC_GET_STS_01 = "01"; //δ��ȡ
	/**
	 * �ĵ������е���ȡ��־
	 * DOC_GET_STS_02 ����ȡ
	 */
	public static final String DOC_GET_STS_02 = "02"; //����ȡ
	/**
	 * �ĵ������е���Ȩ��־
	 * DOC_AUTHORIZE_UPLOAD ֻ���ϴ�
	 */
	public static final String DOC_AUTHORIZE_UPLOAD = "UPLOAD"; //ֻ���ϴ�
	/**
	 * �ĵ������е���Ȩ��־
	 * DOC_AUTHORIZE_INSERT ֻ������(��δʹ��)
	 */
	public static final String DOC_AUTHORIZE_INSERT = "INSERT"; //ֻ������
	/**
	 * �ĵ������е���Ȩ��־
	 * DOC_AUTHORIZE_READ   ֻ���Ķ�
	 */
	public static final String DOC_AUTHORIZE_READ = "READ"; //ֻ���Ķ�
	/**
	 * �ĵ������е���Ȩ��־
	 * DOC_AUTHORIZE_VIEW   ֻ�ܲ鿴
	 */
	public static final String DOC_AUTHORIZE_VIEW = "VIEW"; //ֻ�ܲ鿴
	/**
	 * �ĵ������е���Ȩ��־
	 * DOC_AUTHORIZE_VIEW   ֻ�ܲ鿴(���з��ذ�ť)
	 */
	public static final String DOC_AUTHORIZE_VIEW_ALL = "VIEWALL"; //ֻ�ܲ鿴
	/**
	 * �ĵ������е���Ȩ��־
	 * DOC_AUTHORIZE_GET    ֻ����ȡ
	 */
	public static final String DOC_AUTHORIZE_GET = "GET"; //ֻ����ȡ
	/**
	 * �����ϴ�������
	 */
	public static final String DOC_FORBID_TYPE="exe,bat";
	/**
	 * ͼƬ����
	 */
	public static final String IMAGE_TYPE="bmp,jpg,jpeg,png,gif,tiff,pcx,tga,exif,fpx,svg,psd,cdr,pcd,dxf,ufo,eps,ai,raw";
	/**
	 * СͼƬ�̶�����xxxxsmall.xxx
	 */
	public static final String IMAGE_SMALL_NAME="SMALL";
	/**
	 * ͼƬ��С����
	 */
	public static final int IMAGE_SMALL_TIMES=100;
	/**
	 * ͼƬ����ͼ��
	 */
	public static final int IMAGE_SMALL_HEIGHT=150;
	/**
	 * ͼƬ����ͼ��
	 */
	public static final int IMAGE_SMALL_WIDTH=150;
	/**
	 * ÿ��ͼƬ�ĸ���
	 */
	public static final int ROW_IMAGE_COUNT=5;
	/**
	 * ��ע�ͻ�����:�ֶ�¼��
	 */
	public static final String ENTR_TYPE_INPUT="0";
	/**
	 * ��ע�ͻ�����:ϵͳ����
	 */
	public static final String ENTR_TYPE_SYS="0";
	
	/**
	 * ����ǩ��XMlģ��
	 */
	public static final String PDF_SIGN_STR_1ST="<?xml version='1.0' encoding='gbk' ?><SealDocRequest><BASE_DATA><SYS_ID></SYS_ID><USER_ID></USER_ID><USER_PSD></USER_PSD></BASE_DATA><FILE_LIST><TREE_NODE><OTHER_NO></OTHER_NO><FILE_NO></FILE_NO><FILE_PATH></FILE_PATH><CJ_TYPE></CJ_TYPE><APP_NO></APP_NO><IS_SEAL></IS_SEAL><APP_DATA><Info><name></name><address></address></Info></APP_DATA></TREE_NODE></FILE_LIST><RULE_LIST><RULE_NOTE><RULE_NO></RULE_NO></RULE_NOTE></RULE_LIST></SealDocRequest>";
//	public static final String PDF_SIGN_STR_1ST="<?xml version='1.0' encoding='gbk' ?><SealDocRequest><BASE_DATA><SYS_ID></SYS_ID><USER_ID></USER_ID><USER_PSD></USER_PSD></BASE_DATA><FILE_LIST><TREE_NODE><OTHER_NO></OTHER_NO><FILE_NO></FILE_NO><FILE_PATH></FILE_PATH><CJ_TYPE></CJ_TYPE><IS_SEAL></IS_SEAL><ReceiverFax></ReceiverFax><APP_NO></APP_NO><REQUEST_TYPE></REQUEST_TYPE><IS_CODEBAR></IS_CODEBAR><CODEBAR_TYPE></CODEBAR_TYPE><CODEBAR_DATA></CODEBAR_DATA><X_COORDINATE></X_COORDINATE><Y_COORDINATE></Y_COORDINATE><ftp_address></ftp_address><ftp_port></ftp_port><ftp_user></ftp_user><ftp_pwd></ftp_pwd><AREA_SEAL></AREA_SEAL><AREA_DATA><Info></Info></AREA_DATA><APP_DATA><Info><name></name><address></address></Info></APP_DATA></TREE_NODE></FILE_LIST><RULE_LIST><RULE_NOTE><RULE_NO>1</RULE_NO></RULE_NOTE></RULE_LIST></SealDocRequest>";
	/**
	 * ����ǩ�¹�����
	 * 01 ����
	 * 
	 */
	public static final String PDF_ROLE_NO_01 = "1";
	
	/**
	 * ����ǩ�³������
	 * 01  ��ӡ����
	 * 02 ҵ���׼֪ͨ��
	 * 03 ҵ��ܾ�֪ͨ��
	 * 04 �ſ�֪ͨ��
	 * 05 ҵ��ȷ��֪ͨ��
	 * 06 ��ǰ�������뺯
	 * 07 ��ǰ��������֪ͨ��
	 * 08 �����ŵ��
	 * 09 ���պ�������60�����ڣ�
	 * 10 ���պ�������60�����⣩
	 * 11 ���渶֪ͨ��
	 * 12 �ճ���Ȩί�к�����ִ
	 * 13 �����ع�֪ͨ��
	 * 14 �����������α�֤֪ͨ��
	 * 15 Ȩ��ת��ȷ�Ϻ�(������)
	 * 16 Ȩ��ת��ȷ�Ϻ�(����)
	 * 17 ��Ѻ��ͬ��ӡ
	 * 18 ���޺�ͬ��ӡ
	 * 19 ����Э��
	 * 20 ��������Ȩת��ȷ����
	 * 21 �ճ�֪ͨ��
	 * 22 �ع�������
	 * 23 ���֧����
	 */ 
	public static final String PDF_FLAG_01 = "01";//iqpProject_listAfter;iqpProjectApp*_TabFst;iqpProjectComm*_TabFst
	public static final String PDF_FLAG_02 = "02";//IqpProjectApp*_TabDueInfo;IqpProjectComm*_TabDueInfo
	public static final String PDF_FLAG_03 = "03";//IqpProjectReject_List
	public static final String PDF_FLAG_04 = "04";//IqpProject_ListForPass
	public static final String PDF_FLAG_05 = "05";//iqpprojectsup*_Tab
	public static final String PDF_FLAG_06 = "06";//AlpBaseActon tqjqsqh()
	public static final String PDF_FLAG_07 = "07";//AlpBaseActon tqjqsptzh()
	public static final String PDF_FLAG_08 = "08";//RecallBaseActon hkcns()
	public static final String PDF_FLAG_09 = "09";//RecallBaseActon csh60yn()
	public static final String PDF_FLAG_10 = "10";//RecallBaseActon csh60yw() 
	public static final String PDF_FLAG_11 = "11";//RecallBaseActon dftjz()
	public static final String PDF_FLAG_12 = "12";//AlpBaseActon scsqwthjhz()
	public static final String PDF_FLAG_13 = "13";//AlpBaseActon clhgtzh();
	public static final String PDF_FLAG_14 = "14";//AlpBaseActon lxldzrbztzh()
	public static final String PDF_FLAG_15 = "15";//AlpBaseActon qyzrqrhjxs()
	public static final String PDF_FLAG_16 = "16";//AlpBaseActon  qyzrqrhcs()
	public static final String PDF_FLAG_17 = "17";//SelectRptType.jsp
	public static final String PDF_FLAG_18 = "18";//SelectRptType.jsp
	public static final String PDF_FLAG_19 = "19";//SelectRptType.jsp
	public static final String PDF_FLAG_20 = "20";//LamTransfer_list.jsp
	public static final String PDF_FLAG_21 = "21";//RecallBaseActon sctzh()
	public static final String PDF_FLAG_22 = "22";//RecallBaseActon hgsqs()
	public static final String PDF_FLAG_23 = "23";//IqpProjectCont_ListForPrint.jsp
	/**
	 * ��������к�
	 */
	public static final String ICBC_ACC_BANK = "102100099996";
	/**
	 * �����������
	 */
	public static final String ICBC_ACC_BANK_NAME = "�й���������������������";
	
	/**
	 * �����ڵ�״̬
	 */
	public static String  NODE_STATUS_1 = "1";//δִ��
	public static String  NODE_STATUS_2 = "2";//ִ����
	public static String  NODE_STATUS_3 = "3";//ִ��ʧ��
	public static String  NODE_STATUS_4 = "4";//ִ�гɹ�
	
	/**
	 * Ӱ�񳡾�
	 */
	
	public static String  PAC_SCENE_10="10";//�ͻ�
	public static String  PAC_SCENE_20="20";//����
	public static String  PAC_SCENE_30="30";//����
	public static String  PAC_SCENE_40="40";//��ͬ
	public static String  PAC_SCENE_50="50";//���
	public static String  PAC_SCENE_60="60";//����
	public static String  PAC_SCENE_70="70";//����
	public static String  PAC_SCENE_80="80";//������
	public static String  PAC_SCENE_90="90";//����
	
	/**
	 * ����鷽������״̬	Apply_Scheme_Rel.send_flag
	 */
	public static final String SEND_FLAG_0 = "0";//δ����
	public static final String SEND_FLAG_1 = "1";//�ѷ���
	public static final String SEND_FLAG_2 = "2";//����ʧ��
	/**
	 * ����鷽��ȷ��  APPLY_CONFIRM.confirm_sts
	 */
	public static final String CONFIRM_STS_0 = "0";//δȷ��
	public static final String CONFIRM_STS_1 = "1";//ȷ��
	public static final String CONFIRM_STS_2 = "2";//���

	/**
	 * �û��Կͻ�Ȩ����Ч�� 
	 */
	public static final String EXIST_NO_0 = "0";//��
	public static final String EXIST_NO_1 = "1";//��
	
	/**
	 * Ʊ��״̬
	 */
	public static final String BILL_STS_0 = "0";//δ�ж�
	public static final String BILL_STS_1 = "1";//�ѳж�
	public static final String BILL_STS_2 = "2";//���
	

	/**
	 * ѺƷ״̬
	 */
	public static final String GAGE_STS_0 = "0";//δ���
	public static final String GAGE_STS_1 = "1";//�����
	public static final String GAGE_STS_2 = "2";//�ѳ���
	public static final String GAGE_STS_3 = "3";//�����
	public static final String GAGE_STS_4 = "4";//������
	public static final String GAGE_STS_5 = "5"; //��ʱ���
	public static final String GAGE_STS_6 = "6"; //��ʱ����
	
	/**
	 * ������ͬ�����״̬
	 */
	public static final String PLUS_CHANGE_STS_1 = "1";//��Ч
	public static final String PLUS_CHANGE_STS_2 = "2";//������
	public static final String PLUS_CHANGE_STS_3 = "3";//��ɾ��
	
	/**
	 * �������������
	 */
	public static final String APPLY_TYPE_1 = "1";//�������
	public static final String APPLY_TYPE_2 = "2";//�ٻؿ�����
	public static final String APPLY_TYPE_3 = "3";//��������
	public static final String APPLY_TYPE_4 = "4";//��ʱ����
	
	/**
	 * ������ͬ����
	 */
	public static final String PACT_PLUS_TYPE_1 = "1";//һ�㵣����ͬ
	public static final String PACT_PLUS_TYPE_2 = "2";//��߶����ͬ
	
	/**
	 * ������ͬ״̬
	 */
	public static final String PACT_PLUS_STS_1 = "1";//δǩ��
	public static final String PACT_PLUS_STS_2 = "2";//��ǩ��
	public static final String PACT_PLUS_STS_3 = "3";//��ʧЧ
	
	/**
	 * ������ͬ��Ч��
	 */
	public static final String IS_VALD_0 = "0";//ʧЧ
	public static final String IS_VALD_1 = "1";//��Ч
	
	/**
	 * ������ͬ������ʽ
4	����
3	��֤
2	��Ѻ
1	��Ѻ
	 */
	public static final String PACT_VOU_TYPE_DY = "2";//��Ѻ
	public static final String PACT_VOU_TYPE_ZY = "1";//��Ѻ
	public static final String PACT_VOU_TYPE_BZ = "3";//��֤
	public static final String PACT_VOU_TYPE_XY = "4";//����
	public static final String PACT_VOU_TYPE_BZDBGS = "331";//������˾��֤
	/**
	 * ҵ��������
	1	�·���
	2	չ��
	3	���»���
	4	�����ٴ�
	5	����
	 */
	public static final String OCCUT_TYPE_XFS = "1";
	public static final String OCCUT_TYPE_ZQ = "2";
	public static final String OCCUT_TYPE_JXHJ = "3";
	public static final String OCCUT_TYPE_HSZD = "4";
	public static final String OCCUT_TYPE_XD = "5";
	/**
	 * ��������
	 */
	public static final String CRED_TYPE_1 = "1";//��������
	public static final String CRED_TYPE_2 = "2";//�������
	
	/**
	 * �ݴ��־
	 */
	public static final String TEMP_SAVE_FLAG_1 = "1";//�ݴ�
	public static final String TEMP_SAVE_FLAG_2 = "2";//����
	
	/**
	 * �弶��������
	 */
	public static final String CLASS_TYPE_1 = "1";//�˹��϶�
	public static final String CLASS_TYPE_2 = "2";//ϵͳ�϶�
	

	/**
	 * �������ϰ�������
1	һ�㰸��
2	����ִ֤��/�ٲð���
3	�Ʋ�����
	 */
	public static final String SUIT_TYPE_YB = "1";//һ�㰸��
	public static final String SUIT_TYPE_GZ = "2";//����ִ֤��/�ٲð���
	public static final String SUIT_TYPE_PC = "3";//�Ʋ�����
	
	/**
	 * ��顢�˲��λ��ɫ��
	 */
	public static final String WKF_HC = "1005|1014|1017|2001|3002|1060";//�˲��
	public static final String WKF_SC = "1015|1018|1022|2002|2003|3007|3012|7003";//����
	
	/**
	 * ��顢�˲��ĵ�
	 */
	public static final String PAC_HC = "B0001";//�˲��ĵ�
	public static final String PAC_SC = "B0002";//����ĵ�
	
	/**
	 * Ӱ���ֻ��
	 */
	public static final String READ = "0";//Ӱ���޸�Ȩ��

}