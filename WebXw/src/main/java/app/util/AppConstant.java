package app.util;

public class AppConstant {
	
	/**********����Ļ�����*********/
	public final static String NC_BR_NO = "00000";//�ϳ����л�����---->������������ҵ��û����������ʱ���øû���ȥƥ�����е�����
//	public final static String AUTH_BRNO = "189000000";//�����������Ļ�����---->�����������������е������������ɸû�������Աȥ�����ַ���ȷ��
//	public final static String PUTOUT_BRNO = "190000000";//�����������Ļ�����--->���ڳ������������еĳ��������ɸû�������Աȥ����
	public final static String SIGN_ROLE_NO="0001";//�ۺϸڵĺ���
	public final static String CONFIRM_ROLE_NO="0007";//�ۺϸ�ȷ�ϵ�
	public final static String PRESIDENT_ROLE="0045";//��ҵ���ܲá��ܼ�
	public final static String BR_TYPE_JG="0";//��������:���ڻ���
	public final static String BR_TYPE_SYB="1";//��������:��ҵ��
	public final static String APPLY_FLOW="flow1000000620";//��������
	public final static String FIVE_ROLE="1111";//�弶�������Ա
	/************************ ������� ***********************/
	public final static String CACHE_DICT = "CACHE_DICT";		//�����ֵ�
	public final static String CACHE_SECU = "CACHE_SECU";		//��ȫ�����
	public final static String CACHE_PROD = "CACHE_PROD";		//��Ʒ����
	public final static String CACHE_TBLOG = "CACHE_TBLOG";		//����־�ı�
	public final static String CACHE_MENU = "CACHE_MENU";		//�˵�
	public final static String CACHE_BUTTON = "CACHE_BUTTON";	//��ť
	public final static String CACHE_ACCORG = "CACHE_ACCORG";	//�������
	public final static String CACHE_BUORG = "CACHE_BUORG";		//��ҵ������
	public final static String CACHE_SYSSTS = "CACHE_SYSSTS";	//ϵͳ״̬����
	
	public final static String SYS_STS = "SYS_STS";				//ϵͳ״̬
	
	public final  static String CHANNEL_TXFLAG_STR = "1";      //ͨ�Žӿ�����
	public final  static String CHANNEL_TXFLAG_STOP = "0";     //ͨ�Žӿ�ͣ��
	/************************ �ͻ����� ***********************/
	public final static int AFF_LEV = 3;						//�������㼶
	public final static String ADD_TYPE = "1";					//��������������(0:�ֶ�����,1:�Զ�����)
	
	public final static String ID_TYPE_A = "A";					//֤������ ��֯��������
	public final static String ID_TYPE_0 = "1";					//֤������ ���֤
	
	public final static String CIF_TYPE_CORP  = "1";			//�Թ��ͻ�
	public final static String CIF_TYPE_PERS  = "2";			//���˿ͻ�
	public final static String CIF_TYPE_GROUP = "3";			//���ſͻ�
	public final static String CIF_TYPE_UNION = "4";			//�ͻ�Ⱥ
	public final static String CIF_TYPE_BANK = "5";				//ͬҵ�ͻ�
	public final static String CIF_TYPE_HZ = "6";			//������
	public final static String CIF_TYPE_JG = "9";				//��ܹ�˾�ͻ�
	
//	public final static String CUST_TYPE_AGRI  = "1";			//ũ��
//	public final static String CUST_TYPE_UNAGRI  = "2";			//��ũ��
	
	public final static String COP_TYPE_HOU = "1";				//����������Ŀ
	public final static String COP_TYPE_CAR = "2";				//����������Ŀ
	public final static String COP_TYPE_DUR = "3";				//�������Ѻ�����Ŀ
	public final static String COP_TYPE_EDU = "4";				//��ѧ������Ŀ
	public final static String COP_TYPE_TRA = "5";				//ͨ�ú�����Ŀ--�ϳ�
	public final static String COP_TYPE_CUR = "11";				//ͨ�ú�����Ŀ--�ϳ�
	
//��������	
	public final static String VOU_TYPE_DBGS = "331";				//������˾����
	/************************ ���Ź��� ***********************/
	
	/********************** ����Ʒ����� ***********************/
	public final static String INSTORAGE = "1";                 //����Ʒ���״̬
	public final static String OUTSTORAGE = "2";				//����Ʒ����״̬
	/**********�����������̹���*********/
	public final static String SIGN_KEY_NAME = "SIGN_PARM";	//��ǩ���������ֵ�keyֵ
	public final static String FLOW_STS_ENABLE = "1";	//��������
	public final static String FLOW_STS_DISABLE = "2";//����ͣ��
	
	public final static String APPROVE_AGREE = "01";//ͬ��
	public final static String APPROVE_DISAGREE="2";//��ͬ��
	public final static String APPROVE_ROLLBACK="3";//�˻�
	public final static String APPROVE_REFUSE="04";//���
	public final static String APPROVE_SENDBACK="5";//���ز�������
	public final static String APPROVE_NEXTMOVE="6";//��һ������
	public final static String APPROVE_REFUSE_SIGN="7";
	
	public final static String APP_PENDING="1";//������
	public final static String APP_APPROVING="2";//������
	public final static String APP_APPROVED="3";//����ͨ��
	public final static String APP_REFUSEED="4";//�������
	public final static String APP_SENDBACK="5";//��������
	
	/*
	 * ����״̬
	 */
	public static final String APP_STS_1ST = "0";//δ����
	public static final String APP_STS_2ND = "1";//������
	public static final String APP_STS_3RD = "2";//��������
	public static final String APP_STS_4TH = "3";//�������
	public static final String APP_STS_5TH = "4";//����ͨ��
	public static final String APP_STS_6TH = "5";//δ��¼����
	public static final String APP_STS_7TH = "6";//�Ѳ�¼����
	
	/*
	 * �������
	 */
	public static final String APP_IDEA_1ST = "1";//ͬ��
	public static final String APP_IDEA_2ND = "3";//�˻�
	public static final String APP_IDEA_3RD = "4";//���ز���
	public static final String APP_IDEA_4TH = "6";//���
	
	public final static String TASK_ACTIVE="1";//δǩ��
	public final static String TASK_SIGNED="2";//��ǩ��
	public final static String FLOW_START="start";//���̿�ʼ�ڵ�
	public final static String FLOW_END="end";//���̽����ڵ�
	
	public final static String APP_TYPE_AUTH="1";//��������
	public final static String APP_TYPE_RISK="5";//�弶��������
	public final static String APP_TYPE_HX="3";//�����������
	public final static String APP_TYPE_LC="6";//����֤�Լ������޸�����
	public final static String APP_TYPE_BAD="4";//�����ʲ�����
	public final static String APP_TYPE_NOTE="8";//��������
	public final static String APP_TYPE_RATE="2";//���ʵ�������	
	public final static String APP_TYPE_GRP="9";//���ſͻ��϶�����
	public final static String APP_TYPE_QUT="10";//��ȵ�����������
	public final static String APP_TYPE_TY="7";//ͬҵ��������
	public final static String APP_TYPE_AFF="11";//������������
	public final static String APP_TYPE_CONFIRM="12";//��������ȷ������
	public final static String APP_TYPE_ABILL="13";//�ж���Ϣ�޸�����
	public final static String APP_TYPE_RSGST="14";//����Ԥ����������
	public final static String APP_TYPE_RSGDS="15";//����Ԥ���������
	public final static String APP_TYPE_GAGE="16";//����Ѻ����������
	public final static String APP_TYPE_LPVCG="17";//������ͬ��ֵ���
	public final static String APP_TYPE_GAGEVCG="18";//����Ѻ���ֵ�������
	public final static String APP_TYPE_LRE="19";//������ǰ�����
	public final static String APP_TYPE_CHAN="20";//���ʽ�������
	public final static String APP_TYPE_CHAN1="30";//֧����ʽ��ʽ�������
	public final static String APP_TYPE_TYTZ="21";//ͬҵͶ�ʷǱ�ҵ������
	public final static String APP_TYPE_TFER="22";//������̬�������
	public final static String APP_TYPE_ASSET="23";//�ʲ�֤��������
	public final static String APP_TYPE_PDAINFO="24";//��ծ�ʲ�����
	public final static String APP_TYPE_HXSH="31";//��������ջ�����
	public final static String APP_TYPE_PJJQ="32";//Ʊ�ݽ�������
	
	/**********�ʲ�֤��Excel������ز���*********/
	public final static int SHEET_NUM = 0;//���ڼ���sheetҳ
	public final static int ROW_NUM = 3;//Excel�ӵڼ��п�ʼ��
	public final static int CELL_DUE_NO = 2;//Excel��ݺ�Ϊ�ڼ��� ��0��ʼ
	public final static int CELL_DUE_AMT = 9;//Excel��ݽ��Ϊ�ڼ��� ��0��ʼ
	public final static int CELL_DUE_BAL = 10;//Excel������Ϊ�ڼ��� ��0��ʼ
	
	public final static int CELL_RPDUE_NO = 7;//Excel�����ݺ�Ϊ�ڼ��� ��0��ʼ
	public final static int CELL_RPDUE_AMT = 8;//Excel�����ݽ��Ϊ�ڼ��� ��0��ʼ
	public final static int CELL_RPDUE_BAL = 9;//Excel���������Ϊ�ڼ��� ��0��ʼ
	
	public static String BRNO = "100000"; 			// ����
	public final static String BRNAME = "��������ҵ����"; // ����
	
	public static String SocketUrl = "10.5.186.2";	// Socket ͨ�ŵ�ַ
	public static int SocketPort = 8010;			// Socket ͨ�Ŷ˿ڡ�
	public static int SocketTime = 0;				// Socket ͨ�Ŷ˿ڡ�
	/******************��Ʒ�ų�������***************/
	
//	public final static String PROD_PERS_TRUST = "2090";	//����ί�д��� �ϳ�
	public final static String PROD_HOUSE_AJ = "10";	//����ס������
	public final static String PROD_CORP_ZTX = "48";	//ת����
	public final static String PROD_CORP_DZTXZR = "4801";	//��Ʊת����ת��
	public final static String PROD_CORP_DZTXZC = "4802";	//��Ʊת����ת��
	public final static String PROD_PERS_TRUST = "55";	//����ί�д���
	public final static String PROD_CORP_TRUST = "5501";	//��λί�д���
	public final static String PROD_GJJ_TRUST = "95";	//ס�����������
//	public final static String PROD_CORP_TRUST = "2080";	//��λί�д��� �ϳ�
	public final static String PROD_PRJ_COP_HOU = "3020";	//���ز�������Ŀ������� 
	public final static String PROD_GUAR_COMP = "3040";		//����������������� 
	public final static String PROD_PRJ_COP_CAR = "3025";	//������Ӫ�̵������ 
	public final static String PROD_GUAR_AGEC = "3030";		//���������������
	public final static String PROD_REGULATORS = "3070";	//��ܹ�˾�������
	public final static String PROD_UNIN_GROP = "3050";		//�ͻ�ȺС�鵣�����
	public final static String PROD_PRJ_CORP_CURR = "3035";	//ͨ�ô��������Ŀ�������
	public final static String PROD_GROP = "3060";			//���ſͻ����Ŷ��
	public final static String PROD_PERS = "3005";			//���˿ͻ��ۺ�����
	public final static String PROD_CORP = "3010";			//��˾�ͻ��ۺ�����
	public final static String PROD_PRJ_COP_EDU = "3080";	//��ѧ��Ŀ����
	public final static String PROD_PRJ_COP_DUR = "3085";	//���������Ŀ����
	public final static String PROD_INT_BANK = "2011";		//ͬҵ�ͻ�����
	public final static String PROD_DKCL = "2060";			//2060-�����ŵ�� 
//	public final static String PROD_BH = "2020";			//2020-����ҵ�� �ϳ�
	public final static String PROD_BH = "53";			    //52-����ҵ��
	public final static String PROD_TYDF = "1080070";		//1080070-ͬҵ����
	public final static String PROD_BH_SUB = "202001";		//202001-��������ҵ��
//	public final static String PROD_YCTX = "1020010";		//1020010-��������  �ϳ�
	public final static String PROD_YCTX = "50";		    //50-��������    
	public final static String PROD_SCTX = "1020020";		//1020010-�̳�����
//	public final static String PROD_YCHP= "2010";			//2010-���гжһ�Ʊ  �ϳ�
	public final static String PROD_YCHP= "56";			    //56-���гжһ�Ʊ
	public final static String PROD_KLXYZ= "2030";			//2030-��������֤
	public final static String PROD_XYFXPJTX = "1020030";	//1020030-Э�鸶ϢƱ�����֣����С��̳У�
	public final static String PROD_THDB= "2040";			//2040-�������
	public final static String PROD_FIN_INV = "1140010";	//���Ͷ�ʷǱ��ʲ�
	public final static String PROD_IND_INV = "1140020";	//ͬҵͶ�ʷǱ��ʲ�(����)
	public final static String PROD_IND_INV1 = "1140021";	//ͬҵͶ�ʷǱ��ʲ�(����)
	public final static String PROD_GRBH = "2095";			//���˸����
//	public final static String PROD_PERS_ZQ = "1150010";	//����չ��
//	public final static String PROD_CORP_ZQ = "1150020";	//�Թ�չ��
	public final static String PROD_PERS_ZQ = "98";	        //����չ��
	public final static String PROD_CORP_ZQ = "9801";	    //�Թ�չ��
	public final static String PROD_BHDK = "1130010";	//�������
	public final static String PROD_CDHPDK = "1130020";	//�жһ�Ʊ���
	public final static String PROD_XYZDK = "1130030";	//����֤���
	public final static String PROD_GRXFXH = "1110050";	//��������ѭ������
	public final static String PROD_GRLHBZDK = "1115010";	//�������ϱ�֤����
	/***************��ͬ����**********************/
	public final  static String PACT_STS_PEND = "1";        //��ͬ״̬��1������
	public final  static String PACT_STS_COMP = "2";        //2	�Ǽ����
	public final  static String PACT_STS_PART = "3";        //3	���ֳ���
	public final  static String PACT_STS_OUT = "4";         //4	�ѳ���
	public final  static String PACT_TYPE_GEN = "1";        //��ͬ���ͣ�1��ͨ��ͬ
	public final  static String PACT_TYPE_CYCLE = "2";      //��ͬ���ͣ�2ѭ����ͬ
	public final  static String ICE_FLAG_NO = "0";          //��ͬ�����־��0����
	public final  static String ICE_FLAG_YES = "1";         //��ͬ�����־��1����
	public final  static String ICE_FLAG_END = "4";         //��ͬ�����־��4��ֹ
	public final  static String CHK_STS_PEND ="1";          //�����
	public final  static String CHK_STS_ING = "2";          //�����
	public final  static String CHK_STS_SEND = "3";         //�ѷ���
	public final  static String CHK_STS_SUP = "4";          //������
	public final  static String CHK_STS_REP = "5";         //���鳷��
	public final  static String CHK_STS_PASS = "6";         //���ͨ��
	public final  static String TRAN_STS_PEND = "0";         //������  ����״̬
	public final  static String TRAN_STS_SEND = "1";         //�ѷ��� ����״̬
	/***************ͨ�Žӿ��ļ�����**********************/
	public final  static String TRADEFILETYPE_YCHPQF = "0";        //���л�Ʊǩ���ļ�
	public final  static String TRADEFILETYPE_HKJHS = "1";         //����ƻ����ļ�
	public final  static String TRADEFILETYPE_ZDHKJE = "2";        //ָ���������ļ�
	public final  static String TRADEFILETYPE_DWTR = "3";          //��ί�����ļ�
	public final  static String TRADEFILETYPE_TXRZ = "4";          //ͨ����־�ļ�
	public final  static String TRADEFILETYPE_BC = "5";          //��֤�𲹴�
	public final  static String TRADEFILETYPE_SF = "6";          //��֤���ͷ�
	public final  static String TRADEFILETYPE_DKZRZC = "7";          //����ת��ת��
	public final  static String TRADEFILETYPE_DKZRZR = "8";          //����ת��ת��
	public final  static String TRADEFILETYPE_BHXXWTDK = "9";          //��������ҵ��ί�д���
	public final  static String TRADE_CHANNEL_ID = "100000";		//�Ŵ�ϵͳ�������
	
	public final  static String IF_IB1 = "1";			   //�Ƿ���� 1 ��
	public final  static String SEND_YCHT_0 = "0";			//���к�ͬ��¼�벻�ɹ���ʶ
	public final  static String SEND_YCHT_1 = "1";			//���к�ͬ��¼��ɹ���ʶ
	public final  static String BILL_FLAG_1 = "1";			//��Ʊ����1��Ʊ
	public final  static String BILL_FLAG_2 = "2";			//ֽƱ
	public final  static String BILL_APP_FLAG_1 = "1";		//�ǵ�Ʊ�����ֳ��ˡ����л�Ʊǩ���ɹ���ʶ 1
	public final  static String BILL_APP_FLAG_0 = "0";		//�ǵ�Ʊ�����л�Ʊǩ���ɹ���ʶ 0
	
	public final static String DEAL_STS_1 = "1";				//�����ɹ�
	public final static String DEAL_STS_0 = "0";				//δ����
	
	public final static String PAY_INTE_WAY_1 = "1";				//������
	public final static String PAY_INTE_WAY_2 = "2";				//����+��Ϣ
	public final static String PAY_INTE_WAY_3 = "3";				//���汾��
	
	public final static String OCCUR_TYPE_ZQ = "2";				//��������-չ��

	public final static String ASSE_TYPE_CB = "1";//�ʲ�����
	public final static String ASSE_TYPE_SH = "2";//�ʲ����
	public final static String ASSE_TYPE_BG = "3";//�ʲ����
	
	public final static String REPAY_TYPE_6 = "6";//���¸�Ϣ�����ڻ���
	public final static String REPAY_TYPE_8 = "8";//������Ϣ�����ڻ���
	
	/******************   ��ecifͨѶ���� ��0��1���� **************************/
	public final static String CHANNEL_PERS_OPEN = "0";//���˿����ӿ�
	public final static String CHANNEL_PERS_UPDATE = "0";//���˿ͻ���Ϣ�޸�
	public final static String CHANNEL_PERS_SEARCH = "0";//���˿ͻ���Ϣ��ѯ
	public final static String CHANNEL_CORP_OPEN = "0";//�Թ��ͻ�����
	public final static String CHANNEL_CORP_UPDATE = "0";//�Թ��ͻ���Ϣ�޸�
	public final static String CHANNEL_CORP_SEARCH = "0";//�Թ��ͻ���Ϣ��ѯ
	/******************   ��������������� **************************/
	public final static String LN_APPR = "00";//������
	public final static String LN_APPR_PENDING = "01";//ͬ��
	public final static String LN_APPR_AGREE = "02";//���
	public final static String LN_APPR_REFUSE = "03";//���
}
