package accounting.plat;

import java.util.HashMap;
import java.util.Map;

import accounting.domain.loan.CorpParm;
import accounting.domain.loan.PrdtBase;

public class PUBConstant {

	/**
	 * ϵͳ������ϵͳ����ʱ��ֵ
	 */
	public static String CUR_PRCS_DT;    // ��ǰӪҵ����
	public static String NEXT_PRCS_DT; // ��һ��Ӫҵ����
	public static String LAST_PRCS_DT;   // ��һ��Ӫҵ����
	public static String SYS_STS;        // ϵͳ״̬
	public static String CUR_DEF = "CNY" ;	//����ϵͳĬ�ϱ���Ϊ"�����"
	public static String NEW_ACC_IND;	// �»��׼���־
	
	public static Boolean DEAL_ACC_IND = false; // �Ƿ���л�Ʒ�¼�ͼ���
	public static Boolean LOAN_END_DT_PERDAY = true;// ��������Ƿ���ǰһ��

	
	/*
	 * ����״̬
	 */
	public static final String CHRG_STS_01="01";//����
	public static final String CHRG_STS_02="02";//��Ƿ
	public static final String CHRG_STS_03="03";//����
	
	/**
	 * ���������ӳ��Map
	 */
	public static final Map<String, PrdtBase> PUB_ACCOUNT_PRAM = new HashMap<String, PrdtBase>();
	
	/**
	 * ��������������Ϣӳ��Map
	 */
	public static final Map<String, CorpParm> PUB_CORP_PRAM = new HashMap<String, CorpParm>();
	
	/**
	 * ע���ļ�·��
	 */
	public static String CONFIG_FILM_DIR = "accounting/config";
	public static String COMMON_ALL = "ALL";

	/*
	 * ��ȡ��ˮ�Ų�������
	 */
	public static String TRACENOATYPE = "TRACE_NO";
	public static String OWNER = "ALL";

	/*
	 * ��ȡAC_ID��������
	 */
	public static String ACIDOATYPE = "AC_ID";

	/*
	 * �Ƿ��ʶ
	 */
	public static final String Y = "Y"; // ��
	public static final String N = "N"; // ��


	
	/*
	 * ʹ�ñ�ʶ
	 */
	public static final String USE = "USE"; // ʹ��
	public static final String UNUSE = "UNSE"; // δʹ��

	/*
	 * �״λ�����ȷ����ʽ
	 */
	// 
	public static final String FST_PAY_IND_M = "M"; // ָ��������
	public static final String FST_PAY_IND_F = "F"; // ���ջ���
	
	public static final String PAY_DAY_COMM = "21";

	/*
	 * ��������
	 */
	// 
	public static final String TERM_TYP_DAY = "1"; // ��
	public static final String TERM_TYP_WEEK = "2"; // ��
	public static final String TERM_TYP_MONTH = "3"; // ��
	public static final String TERM_TYP_SEASON = "4"; // ��
	public static final String TERM_TYP_YEAR = "5"; // ��
	public static final String TERM_TYP_ALL = "9"; // ���汾��

	/*
	 * ����С���㷽ʽ
	 */
	public static final String ROUNDING_HALF_UP = "R"; // ��������
	public static final String ROUNDING_UP = "H"; // ��ȡ��
	public static final String ROUNDING_DOWN = "L"; // ��ȡ��

	/*
	 * ����ѡ��
	 */
	public static final String REPAY_OPT_IO = "IO"; // ����Ϣ
	public static final String REPAY_OPT_PO = "PO"; // ������
	public static final String REPAY_OPT_IP = "IP"; // �������Ϣ
	public static final String REPAY_OPT_NO = "NONE"; // ʲô������

	/*
	 * ����ѡ��
	 */
	public static final String REPAY_ADV_OPT_AMT = "AMT"; 	// �ı����������
	public static final String REPAY_ADV_OPT_PERD = "PERD"; // �����������ڹ�����
	/*
	 * ��Ŀ��������
	 */
	public static final String ENTRADE_TYPE_01 = "01"; //�ſ�
	public static final String ENTRADE_TYPE_02 = "02"; //�ۿ�
	public static final String ENTRADE_TYPE_03 = "03"; //��ֵ
	public static final String ENTRADE_TYPE_04 = "04"; //����
	public static final String ENTRADE_TYPE_05 = "05"; //���˳�ֵ
	public static final String ENTRADE_TYPE_06 = "06"; //��������
	/*
	 * �˻�״̬
	 */
	public static final String AC_STS_NORMAL = "1"; 		// ����
	public static final String AC_STS_IN90DAYS = "2"; 		// ����90����
	public static final String AC_STS_SLACK = "3"; 			// ����
	public static final String AC_STS_BADDEBTS = "4"; 		// ����
	public static final String AC_STS_OUT90DAYS = "5"; 		// ����90����
	public static final String AC_STS_CANCEL = "0"; 		// ����
	public static final String AC_STS_UNAUDITED = "8"; 		// ����δ���
	public static final String AC_STS_REPEAL = "10"; 		// ��������
	public static final String AC_STS_GRANT_CANCEL = "12"; 	// �ſ��
	
	/*
	 * �˻���̬ת��
	 */
	public static final String AC_STS_NORMAL_TO_OVER = "1"; // ����ת����
	public static final String AC_STS_NORMAL_TO_SLACK = "2"; // ����ת����
	public static final String AC_STS_NORMAL_TO_BADDEBTS = "3"; // ����ת����
	public static final String AC_STS_OVER_TO_SLACK = "4"; // ����ת����
	public static final String AC_STS_OVER_TO_BADDEBTS = "5"; // ����ת����
	public static final String AC_STS_SLACK_TO_BADDEBTS = "6"; // ����ת����

	/*
	 * ����״̬
	 */
	public static final String LOAN_NORMAL = "0"; // ����

	/*
	 * �������
	 */
	public static final String BR_ACC_TYPE_A = "A"; // A�����
	public static final String BR_ACC_TYPE_B = "B"; // B�����

	
	/*
	 * ��Ϣ�ձ�־
	 */
	public static final String INTST_IND_Y = "1"; // ��Ϣ��
	public static final String INTST_IND_N = "0"; // �ǽ�Ϣ��
	
	/*
	 * ��Ϣ״̬
	 */
	public static final String INT_STS_10 = "10"; // ����
	public static final String INT_STS_20 = "20"; // ��Ƿ
	public static final String INT_STS_30 = "30"; // ����
	public static final String INT_STS_40 = "40"; // ����

	
	/*
	 * ����״̬
	 */
	public static final String CHRG_STS_10="10";//����
	public static final String CHRG_STS_20="20";//��Ƿ
	public static final String CHRG_STS_30="30";//����
	public static final String CHRG_STS_40="40";//����

	/*
	 * ����״̬
	 */
	public static final String SETL_STS_Y = "Y"; // �ѽ���
	public static final String SETL_STS_N = "N"; // δ����
	
	/*
	 * �������ļ�״̬
	 */
	public static final String LOAN_STS_01="01";//����
	public static final String LOAN_STS_02="02";//������
	public static final String LOAN_STS_03="03";//����
	public static final String LOAN_STS_04="04";//����
	public static final String LOAN_STS_05="05";//�ѻع�
	public static final String LOAN_STS_06="06";//��ȡ��
	public static final String LOAN_STS_07="07";//���ع�
	public static final String LOAN_STS_08="08";//�ع���
	
	/*
	 * �ۿ�״̬
	 */
	public static final String DDTL_STS_PEND = "01";//������
	public static final String DDTL_STS_SEND = "02";//�ѷ���
	public static final String DDTL_STS_SUCC = "03";//�ۿ�ɹ�
	public static final String DDTL_STS_FAIL = "04";//�ۿ�ʧ��

	/*
	 * ��������
	 */
	public static final String BACK_STS_01="01";//�ſ�
	public static final String BACK_STS_02="02";//�ۿ�
	public static final String BACK_STS_03="03";//�����쳣
	public static final String BACK_STS_04="04";//����ʧ��
	public static final String BACK_STS_05="05";//�쳣�ص�/��ѯ
	public static final String BACK_STS_06="06";//�ɹ��ص�/��ѯ
	
	/*
	 * ����״̬
	 */
	public static final String COMPST_STS_01 = "01";//������
	public static final String COMPST_STS_02 = "02";//�Ѵ���
	
	/*
	 * �ع�״̬
	 */
	public static final String REBUY_STS_01 = "01";//���ع�
	public static final String REBUY_STS_02 = "02";//�ѻع�
	
	/*
	 * �ۿ�����
	 */
	public static final String DEBIT_TYPE_01="01";//������
	public static final String DEBIT_TYPE_02="02";//����

	/*
	 * ������־
	 */
	public static final String DEC = "DEC"; // ����
	public static final String INC = "INC"; // ����

	/*
	 * ת�˱�־
	 */
	public static final String CASH = "1"; // �ֽ�
	public static final String TRANS = "2"; // ת��

	/*
	 * �Ƿ������ϸ
	 */

	public static final String ACCOUNTED = "0"; // ����
	public static final String ONE_TRADE = "1"; // ���յ���
	public static final String GATHER_TRADE = "2";// ���л���

	/*
	 * ������־
	 */
	public static final String ROL_IND_NORMAL = "0"; // ����
	public static final String ROL_IND_CANCEL = "1"; // ����

	/*
	 * ����������
	 */
	public static final String LOAN_AMT_TYP_P01 = "P01";// ��������
	/*
	 * �˻�����
	 */
	public static final String ACCT_TYPE_03 = "03";// �ſ��˻�
	public static final String ACCT_TYPE_04 = "04";// �տ��˻�
	/*
	 * �״λ�����ȷ����ʽ
	 */ 
	public static final String REM_DEAL_TYP_PERD = "1"; // ����
	public static final String REM_DEAL_TYP_AMT = "2"; 	// �ı��ڹ�
	
	/*
	 * ������ϸ,����˳���еĽ������
	 */
	public static final String LN_AMT_TYP_PRCP = "PRCP"; // ����
	public static final String LN_AMT_TYP_CRI = "CRI"; 	 // ��Ϣ
	public static final String LN_AMT_TYP_ODI = "ODI";   // ��Ϣ
	public static final String LN_AMT_TYP_FEE = "FEE";	 //	����


	/*
	 * ����˳����еĽ�������
	 */
	public static final String REPAY_TX_TYPE_REPAY = "01"; // ����
	public static final String REPAY_TX_TYPE_WVI = "02"; // ��Ϣ����
	public static final String REPAY_TX_TYPE_WVL = "03"; // �������
	public static final String REPAY_TX_TYPE_DEI = "04"; // ��Ϣ����
	public static final String REPAY_TX_TYPE_WVB = "05"; // ��������
	

	/*
	 * �����弶����
	 */
	public static final String FIVE_STS_1ST = "1"; // ����
	public static final String FIVE_STS_2ND = "2"; // �μ�
	public static final String FIVE_STS_3RD = "3"; // ��ע
	public static final String FIVE_STS_4TH = "4"; // ����
	public static final String FIVE_STS_5TH = "5"; // ��ʧ
	
	/*
	 * ��������
	 */
	public static final String FEE_KIND_01 = "01";//����
	public static final String FEE_KIND_02 = "02";//����

	/*
	 * �ո���־
	 */
	public static final String PYCL_RECV = "R"; 	// ��
	public static final String PYCL_PAY = "P";	 	// ��

	// ����Ƿ���,�ƻ���ı���״̬����Ϣ״̬
	public static final String AMT_STS_NORMAL = "10"; // ����
	public static final String AMT_STS_DELQ = "20";	// ��Ƿ
	public static final String AMT_STS_OVER = "30"; // ����
	public static final String AMT_STS_SETL = "40"; // ����

	// ��������״̬
	public static final String STS_REVOKE = "0"; // �ѳ���
	public static final String STS_UNDO = "1"; // δ����
	public static final String STS_OPEN = "2"; // �ѿ��������ſ
	public static final String STS_CANCEL = "5"; // ��Ȩ��ֹ
	public static final String STS_DEAL = "9"; // �Ѵ���

	/*
	 * ����������־
	 */
	public static final String REV_ROL_NORM = "NORM"; 	// ����
	public static final String REV_ROL_REV = "REV"; 	// ����
	
	/*
	 * �������������˻�����
	 */
	public static final String FEE_TYPE_01 = "01"; //�����
	public static final String FEE_TYPE_02 = "02"; //����
	public static final String FEE_TYPE_03 = "03"; //�Թ��˻�
	public static final String FEE_TYPE_04 = "04"; //չ�ڷ�
	public static final String FEE_TYPE_05 = "05"; //������
	public static final String FEE_TYPE_06 = "06"; //ΥԼ��

	

	/*
	 * ֧����������
	 */
	public static final String BACK_TYPE_01 = "01";//�ſ�
	public static final String BACK_TYPE_02 = "02";//�ۿ�
	/*
	 * �����������
	 */
	public static final String BAT_INIT = "100"; // ���ճ�ʼ��
	public static final String BAT_EXPAND = "120"; // ����չ��
	public static final String BAT_LOAN_REPAY_CUR = "140"; // �����Զ��ۿ�(�ճ��۵���)
	public static final String BAT_STS_TRAN = "220"; // ��̬ת��
	public static final String BAT_UPDATE = "360"; // �����ڲ���Ϣ����
	public static final String BAT_CHECK = "380"; // ����ϵͳ�����ϵͳ����
	public static final String BAT_CHECK_DETL = "400"; // ����ϵͳ�����ϵͳ����ϸ��
	public static final String BAT_CHANGE_DATE = "500"; // ����ϵͳ����
	public static final String BAT_INTST_SETTLE = "600"; // �����Ϣ
	public static final String BAT_LOAN_REPAY_LO = "620";//�����Զ��ۿ���տ�Ƿ�
	public static final String BAT_DATA_CLEAR = "680	"; // ��������
	public static final String BAT_END = "999"; // �������

	/*
	 * ���������´��ļ���
	 */
	public static final String POST_BATCH_UP = "_up.txt"; // �ϴ��ļ���׺
	public static final String POST_BATCH_UP_END = "_up.end";//�ϴ������ļ���׺
	public static final String POST_BATCH_DOWN = "_down.txt"; // �´��ļ���׺
	public static final String POST_BATCH_DOWN_END = "_down.end";//�´������ļ���׺
	public static final String PRE_CVRG_BATCH = "E:\\batch\\cvrg_"; // �������ڴ����ϴ��ļ�ǰ׺
	public static final String PRE_ACCP_BATCH = "E:\\batch\\accp_"; // �����Զ��ۿ��ϴ��ļ�ǰ׺
	public static final String PRE_CHECK_BATCH_DOWN = "E:\\batch\\check_"; // �����������ʻ����ļ��������´��ļ�ǰ׺
	public static final String PRE_CHECK_DETAIL_BATCH_DOWN = "E:\\batch\\checkDetail_"; // ��������������ϸ�ļ��������´��ļ�ǰ׺
	public static final String PRE_LOAN_REPAY_CUR_BATCH = "E:\\batch\\loanCur_"; // �����Զ��۵����������ļ�ǰ׺
	public static final String PRE_LOAN_REPAY_LO_BATCH="E:\\batch\\loanLo_";// �����Զ���Ƿ���������ļ�ǰ׺
	
	
	
	public static final String FILE_FLODER_BATCH = "F:\\batch\\";//�ϴ��ļ�
	public static final String FILE_UP_FLODER_BATCH = "_UP\\";
	public static final String FILE_DOWN_FLODER_BATCH ="_DOWN\\";
	
	public static final String SYS_INFO_UP_BATCH="0101up.txt";			// ϵͳ��Ϣ�ϴ��ļ�
	public static final String LOAN_RECOVERY_BAIL_UP_BATCH="0201up.txt";// ���֤��ָ��ϴ��ļ�
	public static final String LOAN_REPAY_UP_BATCH="0301up.txt";		// ���տۿ��ϴ��ļ�
	public static final String CVRG_UP_BATCH="0302up.txt";				// ���е��ڴ����ϴ��ļ�
	public static final String ACCP_UP_BATCH="0303up.txt";				// �������ڴ����ϴ��ļ�
	public static final String QRY_BAL_UP_BATCH="0401up.txt";			// ��ѯ�˻�����ϴ��ļ�
	public static final String LOAN_SBSY_UP_BATCH="0501up.txt";			// ��ѯ��Ϣ�˻��ϴ��ļ�
	
	public static final String SYS_INFO_DOWN_BATCH="0101down.txt";			// ϵͳ��Ϣ�´��ļ�
	public static final String LOAN_RECOVERY_BAIL_DOWN_BATCH="0201down.txt";// ���֤��ָ��´��ļ�
	public static final String LOAN_REPAY_DOWN_BATCH="0301down.txt";		// ���տۿ��´��ļ�
	public static final String CVRG_DOWN_BATCH="0302down.txt";				// ���е��ڴ����´��ļ�
	public static final String ACCP_DOWN_BATCH="0303down.txt";				// �������ڴ����´��ļ�
	public static final String QRY_BAL_DOWN_BATCH="0401down.txt";			// ��ѯ�˻�����´��ļ�
	public static final String LOAN_SBSY_DOWN_BATCH="0501down.txt";			// ��ѯ��Ϣ�˻��´��ļ�
	
	
	

	/*
	 * �Զ��ۿ����������״̬
	 */
	public static final String AC_LM_ATPY_STS_CREATE = "SU"; // ���ɿۿ�׼����¼
	public static final String AC_LM_ATPY_STS_SEND = "SP"; // �ۿ��ļ������ɣ��ѷ�����
	public static final String AC_LM_ATPY_STS_FREEZE = "FZ"; // ����
	public static final String AC_LM_ATPY_STS_CREATEDC = "CP"; // ��ʾ�����Ѿ����ɷ�¼
	
	/*
	 * ��������
	 */
	public static final String BATCH_REPAY_LOAN_CUR = "CUR";	//�ճ��۵���
	public static final String BATCH_REPAY_LOAN_LO = "LO";		//���տ�Ƿ��

	/*
	 * �����־
	 */
	public static final String DC_IND_D = "D"; // ��
	public static final String DC_IND_C = "C"; // ��
	public static final String DC_IND_ANY="*"; //����
	
	/*
	 * ��Ƿ��ʶ
	 */
	public static final String DELQ_IND_YES = "Y"; // ����Ƿ
	public static final String DELQ_IND_NO = "N"; // δ��Ƿ
	
	/*
	 * �����ŵ״̬
	 */
	public static final String PROV_STS_NORM = "NORM" ;				//����
	public static final String PROV_STS_DS = "DS" ;					//�����Զ�����
	public static final String PROV_STS_MS = "MS" ;					//�������

	/*
	 * ������������
	 */
	public static final String LOAN_PERD_ST = "ST";					//����
	public static final String LOAN_PERD_LT = "LT";					//�г���
	public static final String LOAN_PERD_ALL="ALL";					//����
	
	/*
	 * ��ǰ������Ϣ�������
	 */
	public static final String AC_FDRP_INTST_BASE_NO="NO";			//����Ϣ
	public static final String AC_FDRP_INTST_BASE_OSP="OSP";		//����ʣ�౾��
	public static final String AC_FDRP_INTST_BASE_PPP="PPP";		//��ǰ�������
	
	/*
	 * ��������־
	 */
	public static final String AC_ZERO_FLAG_DAY="D";		//ÿ��
	public static final String AC_ZERO_FLAG_MON="M";		//ÿ��
	public static final String AC_ZERO_FLAG_SEA="S";		//ÿ��
	public static final String AC_ZERO_FLAG_YEAR="Y";		//ÿ��
	
	/*
	 * ����״̬
	 */
	public static final String LOAN_STS_NBAP="01";		//δ�ſ�
	public static final String LOAN_STS_ACTV="02";		//�ѷ���
	public static final String LOAN_STS_SETL="03";		//�ѽ���
	public static final String LOAN_STS_OPEN_CANCEL="04";	//��������
	public static final String LOAN_STS_GRANT_CANCEL="05";	//�ſ��
	
	/*
	 * �����״̬
	 */
	public static final String DEAL_STS_PEND="01";	//������
	public static final String DEAL_STS_ACTV="02";	//�ѷ���
	public static final String LOAN_STS_SUCC="03";	//�ſ�ɹ�
	public static final String LOAN_STS_FAIL="04";	//�ſ�ʧ��
	
	
	
	/*
	 * ��ֵ��־
	 */
	public static final String DEVA_IND_Y="Y";		//��
	public static final String DEVA_IND_N="N";		//��
	
	public static final String ACCT_INFO_OS="OS";		//ʣ����
	public static final String ACCT_INFO_SETL="SETL";	//�ѻ����
	
	/*
	 * ��̬ת������
	 */
	public static final String STS_NORM_TO_OVER_DAYS="0";	//����ת��������
	public static final String STS_IN_TO_OUT_DAYS="90";		//ת��������
	public static final String STS_IN_TO_OUT_OPT=PUBConstant.AMT_STS_NORMAL+","+PUBConstant.AMT_STS_OVER+","+PUBConstant.AMT_STS_DELQ;//ת��������
	public static final String STS_NORM_TO_OVER_OPT=PUBConstant.AMT_STS_NORMAL+","+PUBConstant.AMT_STS_DELQ;//ת��������
	
	/*
	 * ��Ŀ����
	 */
	public static final String ACC_DC_IND_D="1";	//��
	public static final String ACC_DC_IND_C="2";	//��
	public static final String ACC_DC_IND_ANY="0";	//����
	
	
	/*
	 * ��ֵ��ʾ
	 */
	public static final String DEVA_TYP_COMBIN = "C" ;	//��ϼ�ֵ
	public static final String DEVA_TYP_SINGLE = "S" ;  //���ʼ�ֵ
	
	/*
	 * ʵ�����ʾ�ȷλ��
	 */
	public static final int ACCURATE_DIGITS = 5;	//ʵ�����ʾ�ȷλ��
	
	/*
	 * ���ڲ����ڴ���ʽ
	 */
	public static final String AC_FST_PERD_OPT_INTST = "1";//������Ϣ
	public static final String AC_FST_PERD_OPT_DELAY = "2";//ʲô�����գ�����һ��
	public static final String AC_FST_PERD_OPT_PI = "3";//�������Ϣ��Ҫ��
	
	/**
	 * �����ʺ�����
	 */
	public static final String ACCT_TYP_REPAY = "1"; // �����ʺ�
	
	
	/**
	 * ��������
	 */
	public static final String ATPY_TYPE_LOAN = "01";	//����ۿ�

	/*
	 * ��������
	 */
	public static final String AC_TRANTP_TR="TR";		//TR:ת��
	public static final String AC_TRANTP_CS="CS";		//CS:�ֽ�
	
	/*
	 * ����
	 */
	public static final String AC_CRCYCD_01="01";		//01�������
	
	/*
	 * ϵͳID
	 */
	public static final String AC_SYSTID_02="02";		//02
	
	/*
	 * ����
	 */
	 public static final String AC_AMNTCD_D="C10001002";		//��
	 public static final String AC_AMNTCD_C="C10001001";		//��
	/*
	 * ��������
	 */
	public static final String DEBIT_MOLD_01="01";		//�����ۿ�
	public static final String DEBIT_MOLD_02="02";		//������ǰ���
	public static final String DEBIT_MOLD_03="03";		//���ڻ���
	public static final String DEBIT_MOLD_04="04";		//�ֹ�����
	public static final String DEBIT_MOLD_05="05";		//������ǰ����
	public static final String DEBIT_MOLD_06="06";		//ȫ����ǰ����
	public static final String DEBIT_MOLD_07="07";		//��ͬȡ��
	public static final String DEBIT_MOLD_08="08";		//��ɿ��ֵ
	public static final String DEBIT_MOLD_09="09";		//�Զ�������ǰ���ʵ��
}
