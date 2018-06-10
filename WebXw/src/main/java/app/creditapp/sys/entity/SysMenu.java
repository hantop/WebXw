package app.creditapp.sys.entity;
import java.io.Serializable;
import java.util.ArrayList;

import app.base.BaseDomain;
/**
* Title: SysMenu.java
* Description:
* @version��1.0
**/

public class SysMenu extends BaseDomain implements Serializable {
	private String  menuNo;//�˵����
	private String  menuName;//�˵�����
	private String  menuUrl;//�˵�url
	private String  menuParent;//���˵����
	private String  menuLvl;//�˵�����
	private String  menuSts;//�˵�״̬ ����01��ͣ��02
	private String menuShape;//��ǩ��״
	
	private Integer  menuSeq;//�������

	private ArrayList<SysMenu> children;//�Ӳ˵�
	
	
	public SysMenu() {
		this.menuName = "";
		this.menuNo = "";
		this.menuUrl = "";
		this.menuParent = "";
		this.menuLvl = "0";
		this.menuSts = "0";
		this.children = new ArrayList<SysMenu>();
	}
	
	public String getMenuSts() {
		return menuSts;
	}

	public void setMenuSts(String menuSts) {
		this.menuSts = menuSts;
	}


	public SysMenu(String menuName, String menuNo, String menuUrl, String menuParent, String menuLvl,String menuSts, ArrayList<SysMenu> children) {
		this.menuName = menuName;
		this.menuNo = menuNo;
		this.menuUrl = menuUrl;
		this.menuParent = menuParent;
		if(children!=null){
			this.children = children;
		}else{
			this.children = new ArrayList<SysMenu>();
		}
		this.menuLvl=menuLvl;
		this.menuSts = menuSts;
	}
	
	
	public void reInit(SysMenu node){
		this.menuName = node.getMenuName();
		this.menuNo=node.getMenuNo();
		this.menuParent=node.getMenuParent();
		this.menuUrl = node.getMenuUrl();
		this.children = node.getChildren();
		this.menuSts = node.getmenuSts();
		this.menuLvl = node.getMenuLvl();
	}
	
	public void addChildren(SysMenu child){
		this.children.add(child);
	}
	
	public String toJson(){
		StringBuffer str = new StringBuffer();
		if(this.children!=null && this.children.size()>=1){
			for(int i=0;i<this.children.size();i++){
				str.append(this.children.get(i).toJson());
				if(i+1<this.children.size()){
					str.append(",");
				}
			}
		}
		String result = "";
		if("0".equals(menuLvl)){
			return "{'checked':"+true+",'text':'"+menuName+"','id':'"+menuNo+"','url':'"+menuUrl+"','stats':'"+menuSts+"','lvl':'"+menuLvl+"','parent':'"+menuParent+"','open':'true','children':["+str.toString()+"]}";
		}
		return "{'checked':"+true+",'text':'"+menuName+"','id':'"+menuNo+"','url':'"+menuUrl+"','stats':'"+menuSts+"','lvl':'"+menuLvl+"','parent':'"+menuParent+"','children':["+str.toString()+"]}";
	}
	/**
	 * @return �˵����
	 */
	 public String getMenuNo() {
	 	return menuNo;
	 }
	 /**
	 * @���� �˵����
	 * @param menuNo
	 */
	 public void setMenuNo(String menuNo) {
	 	this.menuNo = menuNo;
	 }
	/**
	 * @return �˵�����
	 */
	 public String getMenuName() {
	 	return menuName;
	 }
	 /**
	 * @���� �˵�����
	 * @param menuName
	 */
	 public void setMenuName(String menuName) {
	 	this.menuName = menuName;
	 }
	/**
	 * @return �˵�url
	 */
	 public String getMenuUrl() {
	 	return menuUrl;
	 }
	 /**
	 * @���� �˵�url
	 * @param menuUrl
	 */
	 public void setMenuUrl(String menuUrl) {
	 	this.menuUrl = menuUrl;
	 }
	/**
	 * @return ���˵����
	 */
	 public String getMenuParent() {
	 	return menuParent;
	 }
	 /**
	 * @���� ���˵����
	 * @param menuParent
	 */
	 public void setMenuParent(String menuParent) {
	 	this.menuParent = menuParent;
	 }
	/**
	 * @return �˵�����
	 */
	 public String getMenuLvl() {
	 	return menuLvl;
	 }
	 /**
	 * @���� �˵�����
	 * @param menuLvl
	 */
	 public void setMenuLvl(String menuLvl) {
	 	this.menuLvl = menuLvl;
	 }
	/**
	 * @return �˵�״̬ ����1��ͣ��0
	 */
	 public String getmenuSts() {
	 	return menuSts;
	 }
	 /**
	 * @���� �˵�״̬ ����1��ͣ��0
	 * @param menuSts
	 */
	 public void setmenuSts(String menuSts) {
	 	this.menuSts = menuSts;
	 }

	public ArrayList<SysMenu> getChildren() {
		return children;
	}

	public void setChildren(ArrayList<SysMenu> children) {
		this.children = children;
	}

	public String getMenuShape() {
		return menuShape;
	}

	public void setMenuShape(String menuShape) {
		this.menuShape = menuShape;
	}

	public Integer getMenuSeq() {
		return menuSeq;
	}

	public void setMenuSeq(Integer menuSeq) {
		this.menuSeq = menuSeq;
	}
	 
}
