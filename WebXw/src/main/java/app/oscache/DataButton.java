package app.oscache;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;

import app.util.User;
/**
 * ����������ȡȨ�ް�ť������
 *
 */
public class DataButton {
	
	private boolean flag = true; // Ĭ��ֵΪ��Ȩ��
	
	/**
	 * �������������췽����ʼ�� flag ֵ
	 * @param info ��ѯ��������ʽ menu_no@button_no@role/user_id
	 * @param roleOrUser ϵͳȨ��ģʽ user = ��ɫ role = Ȩ��
	 */
	public DataButton(String info,String roleOrUser){
		if(StringUtils.isNotBlank(info)){
			flag = MBaseCache.getCache().getBeanCacheForButton(info,roleOrUser);
			// ��������ȥ��Ȩ�����ã�������������
//			flag = true;
		}
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	/**
	 * �������������췽����ʼ�� flag ֵ
	 * @param info ��ѯ��������ʽ menu_no@button_no@role/user_id
	 * @param roleOrUser ϵͳȨ��ģʽ user = ��ɫ role = Ȩ��
	 * @throws Exception 
	 */
	public DataButton(String fieldName) {
		flag = false;
		StringBuffer strBuf = new StringBuffer("");
		String stats = "@";
		String menuno = ""; 
		try{
		     menuno =  ServletActionContext.getRequest().getSession().getAttribute("menuno").toString().trim();
		}catch (Exception e) {
			//throw new Exception("menunoû��ȡ��!������");
			System.out.println("menunoû��ȡ��!������");
		}
		strBuf.append(menuno);
		strBuf.append(stats);
		strBuf.append(fieldName);
		strBuf.append(stats);
		try{
			if(menuno==null || menuno.equals("")){ // �������ȡ�����˵���ŵ����� �Ͳ���Ҫ���ư�ť��Ȩ�ޣ�
				flag = true; 
			}else{
				String[] rolenos = User.getAllRoleno(ServletActionContext.getRequest()).replaceAll("\\(", "").replaceAll("\\)", "").replaceAll("\\'", "").split(",");
				String roleNoBuf = "";
				for(String role_no:rolenos){
					roleNoBuf = strBuf.toString()+role_no;
					flag = MBaseCache.getCache().getBeanCacheForButton(roleNoBuf,"role");
					if(flag)break;
				}
			}
			
//		   strBuf.append("SH001");
//		   flag = MBaseCache.getCache().getBeanCacheForButton(strBuf.toString(),"role");
		}catch (Exception e) {
			
		}
		
		if(flag){
			if("query".equals(ServletActionContext.getRequest().getParameter("query"))){
				if("��ѯ".equals(fieldName) || "�����б�".equals(fieldName) ||"����".equals(fieldName)){
					flag = true;
				}else{
					flag = false;
				}
			}
		}
	}
}
