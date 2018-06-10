package app.oscache;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


/**
 * @����˵�� ��������ͻ����ȡ����
 * @�޸�˵��
 */
public class CachecodeUtil {
	//���泣��
	public final static int REFRESHPERIOD = -1; // �������ʱ��
	public final static String KEYPREFIX = "CMSII"; //�������ڴ�������ǰ׺
	public final static String MFSPREFIX = "00003"; //�������ڴ�������ǰ׺
	
//	public static Map<String, DictNode> cacheMap = new HashMap<String, DictNode>();
	
	//���ݳ���
	public final static int CACHE_DATADICT=1;	//�����ֵ�
	public final static int CACHE_MENU=2;		//�˵�
	public final static int CACHE_CMSORG=3;		//CMS����
	public final static int CACHE_DHCORG=4;		//�������
	public final static int FAST_MENU=8;		//��ݲ˵�
	public final static int APPROVER_PAS_FST_CHECK = 10;	//���ó�-����������(����Ա)
	public final static int APPROVER_PAS_DUE_CHECK = 11;	//���ó�-����������(�ſ����)
	public final static int APPROVER_COM_FST_CHECK = 12;	//���ó�-����������(����Ա)
	public final static int APPROVER_COM_DUE_CHECK = 13;	//���ó�-����������(�ſ����)
	public final static int APPROVER_COM_SUP_FST_CHECK = 14;	//���ó�(������ģʽ)-����������(����Ա)
	public final static int APPROVER_COM_SUP_DUE_CHECK = 15;	//���ó�(������ģʽ)-����������(�ſ����)
	public final static int APPROVER_EXT_FST_CHECK = 16;	//չ������-����������(����Ա)
	public final static int MENUS = 208;
	public final static int SECURITY = 9;		//��ȫ���
	public final static int SYS_GLOBAL_STATUS = 999;	//ϵͳ״̬
	public final static int SYS_GLOBAL_DOC_SIZE = 998;	//�ļ���С����
	public final static int PROJ_PARM = 997;		// ��Ŀ��������
	public final static int CORP_PARM = 996;		// ������������
	public final static int HOLIDAY_JSON = 995;		// �ڼ���JSON
	public final static int SYS_PATH = 994;		// ϵͳ·����������
	public final static String PROJ_PARM_STR = "PROJ_PARM_STR";		// ��Ŀ���ò�����
	public final static String CORP_PARM_STR = "CORP_PARM_STR";		// �������ò�����
	public final static String SYS_PATH_STR = "SYS_PATH_STR";		// ϵͳ·����������
	public final static String FAST_MENU_STR = "FASTMENU";
	public final static String SYS_GLOBAL_DOC_SIZE_STR = "SYS_GLOBAL_DOC_SIZE_STR";
	public final static String SYS_GLOBAL_STATUS_STR = "SYS_GLOBAL_STATUS_STR";
	public final static String APPROVER_PAS_FST_CHECK_STR = "APPROVER_PAS_FST_CHECK";
	public final static String APPROVER_PAS_DUE_CHECK_STR = "APPROVER_PAS_DUE_CHECK";
	public final static String APPROVER_COM_FST_CHECK_STR = "APPROVER_COM_FST_CHECK";
	public final static String APPROVER_COM_DUE_CHECK_STR = "APPROVER_COM_DUE_CHECK";
	public final static String APPROVER_COM_SUP_FST_CHECK_STR = "APPROVER_COM_SUP_FST_CHECK";
	public final static String APPROVER_COM_SUP_DUE_CHECK_STR = "APPROVER_COM_SUP_DUE_CHECK";
	public final static String APPROVER_EXT_FST_CHECK_STR = "APPROVER_EXT_FST_CHECK";
	
	public final static String CRP_CRP_STS0 = "0";   //����û�в�ѯ
	public final static String CRP_CRP_STS1 = "1";   //���Ų�ѯ�ɹ�
	public final static String CRP_CRP_STS2 = "2";   //���Ų�ѯʧ��
	
	public final static String QUERY_TYPE1 = "1";   //���ű���
	public final static String QUERY_TYPE2 = "2";   //��������
	
	public static String getKey(int id){
		String key = "";
//		DictNode node = null;
//		Iterator<String> it=cacheMap.keySet().iterator();
//		while(it.hasNext()){
//			node = cacheMap.get(it.next());
//			if(node.getId() == id){
//				key = node.getKeyName();
//				break;
//			}
//		}
		return key.toLowerCase();
	}
	
}
