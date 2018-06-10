package app.creditapp.dev.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import app.creditapp.dev.bo.TreeConfBo;
import app.creditapp.dev.entity.TreeConf;
import app.util.toolkit.Ipage;

import com.core.domain.screen.FormData;
import com.core.service.screen.FormService;
import com.core.struts.ActionContext;
import com.core.struts.BaseFormBean;

/**
 * Title: TreeConfAction.java Description:
 * 
 **/
public class TreeConfAction extends BaseFormBean {

	// ҳ�洫ֵ
	private TreeConf treeConf;
	private List<TreeConf> treeConfList;

	// ע��TreeConfBo
	private TreeConfBo treeConfBo;

	private String query;
	private String scene_id;
	private String tri_lev;
	private String parms;
	private String tri_func;
	private String select_type;
	private String treeJson;
	private FormData formdev1001;
	private FormData formdev1002;
	private FormService formService = new FormService();

	public TreeConfAction() {
		query = "";
	}

	/**
	 * ��ҳ��ѯ
	 * 
	 * @return
	 * @throws Exception
	 */
	public String findByPage() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),
				ServletActionContext.getResponse());
		formdev1001 = formService.getFormData("dev1001");
		treeConf = new TreeConf();
		getFormValue(formdev1001);
		setObjValue(formdev1001, treeConf);
		Ipage ipage = this.getIpage();
		treeConfList = (List) treeConfBo.findByPage(ipage, treeConf).getResult();
		return "list";
	}

	public String getTree() throws Exception {
		Map<String, Object> pMap = new HashMap<String, Object>();		
		if (parms != null) {
			if (parms.contains(",")) {
				for (String s : parms.split(",")) {
					if (s.contains("=")) {
						pMap.put(s.split("=")[0].toLowerCase(), s.split("=")[1]);
					}
				}
			} else {
				if (parms.contains("=")) {
					pMap.put(parms.split("=")[0].toLowerCase(), parms.split("=")[1]);
				}
			}
		}

		Map map = treeConfBo.createSql(scene_id, pMap);
		String sql = (String) map.get("sql");
		tri_func = (String) map.get("tri_func");// ��������
		tri_lev = (String) map.get("tri_lev");// ��������
		parms = (String) map.get("rel");// ��ֵ����
		select_type = (String) map.get("select_type");// ѡ��ʽ
		treeJson = treeConfBo.getTreeJson(sql);
		return "showTree";
	}
	
	public String getTreePot() throws Exception {
		Map<String, Object> pMap = new HashMap<String, Object>();		
		if (parms != null) {
			if (parms.contains(",")) {
				for (String s : parms.split(",")) {
					if (s.contains("=")) {
						pMap.put(s.split("=")[0].toLowerCase(), s.split("=")[1]);
					}
				}
			} else {
				if (parms.contains("=")) {
					pMap.put(parms.split("=")[0].toLowerCase(), parms.split("=")[1]);
				}
			}
		}

		Map map = treeConfBo.createSqlPot(scene_id, pMap);
		String sql = (String) map.get("sql");
		tri_func = (String) map.get("tri_func");// ��������
		tri_lev = (String) map.get("tri_lev");// ��������
		parms = (String) map.get("rel");// ��ֵ����
		select_type = (String) map.get("select_type");// ѡ��ʽ
		treeJson = treeConfBo.getTreeJson(sql);
		return "showTree";
	}

	public String testTree() {
		ActionContext.initialize(ServletActionContext.getRequest(),
				ServletActionContext.getResponse());
		return "testTree";
	}

	/**
	 * ��ȡ����ҳ��
	 * 
	 * @return
	 * @throws Exception
	 */
	public String input() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),
				ServletActionContext.getResponse());
		formdev1002 = formService.getFormData("dev1002");
		return "input";
	}

	/**
	 * �����������
	 * 
	 * @return
	 * @throws Exception
	 */
	public String insert() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),
				ServletActionContext.getResponse());
		formdev1002 = formService.getFormData("dev1002");
		getFormValue(formdev1002);
		treeConf = new TreeConf();
		setObjValue(formdev1002, treeConf);
		treeConfBo.insert(treeConf);
		getObjValue(formdev1002, treeConf);
		this.addActionMessage("�����ɹ���");
		return "detail";
	}

	/**
	 * �޸ı������
	 * 
	 * @return
	 * @throws Exception
	 */
	public String update() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),
				ServletActionContext.getResponse());
		formdev1002 = formService.getFormData("dev1002");
		getFormValue(formdev1002);
		treeConf = new TreeConf();
		setObjValue(formdev1002, treeConf);
		treeConfBo.update(treeConf);
		getObjValue(formdev1002, treeConf);
		this.addActionMessage("�����ɹ���");
		return "detail";
	}

	/**
	 * ɾ������
	 * 
	 * @return
	 * @throws Exception
	 */
	public String del() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),
				ServletActionContext.getResponse());
		formdev1001 = formService.getFormData("dev1001");
		treeConf = new TreeConf();
		treeConf.setScene_id(scene_id);
		treeConfBo.del(treeConf);
		this.addActionMessage("ɾ���ɹ�");
		treeConf = new TreeConf();
		Ipage ipage = this.getIpage();
		treeConfList = (List) treeConfBo.findByPage(ipage, treeConf)
				.getResult();
		return "list";
	}

	/**
	 * ��ѯ����
	 * 
	 * @return
	 * @throws Exception
	 */
	public String getById() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),
				ServletActionContext.getResponse());
		formdev1002 = formService.getFormData("dev1002");
		treeConf = new TreeConf();
		treeConf.setScene_id(scene_id);
		treeConf = treeConfBo.getById(treeConf);
		getObjValue(formdev1002, treeConf);
		return "detail";
	}

	/**
	 * �����������У��
	 * 
	 * @return
	 * @throws Exception
	 */
	public void validateInsert() {
		ActionContext.initialize(ServletActionContext.getRequest(),
				ServletActionContext.getResponse());
		formdev1002 = formService.getFormData("dev1002");
		getFormValue(formdev1002);
		validateFormData(formdev1002);
	}

	/**
	 * �޸ı������У��
	 * 
	 * @return
	 * @throws Exception
	 */
	public void validateUpdate() {
		ActionContext.initialize(ServletActionContext.getRequest(),
				ServletActionContext.getResponse());
		formdev1002 = formService.getFormData("dev1002");
		getFormValue(formdev1002);
		validateFormData(formdev1002);
	}

	public TreeConf getTreeConf() {
		return treeConf;
	}

	public void setTreeConf(TreeConf treeConf) {
		this.treeConf = treeConf;
	}

	public List<TreeConf> getTreeConfList() {
		return treeConfList;
	}

	public void setTreeConfList(List<TreeConf> treeConfList) {
		this.treeConfList = treeConfList;
	}

	public TreeConfBo getTreeConfBo() {
		return treeConfBo;
	}

	public void setTreeConfBo(TreeConfBo treeConfBo) {
		this.treeConfBo = treeConfBo;
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public FormData getFormdev1002() {
		return formdev1002;
	}

	public void setFormdev1002(FormData formdev1002) {
		this.formdev1002 = formdev1002;
	}

	public FormData getFormdev1001() {
		return formdev1001;
	}

	public void setFormdev1001(FormData formdev1001) {
		this.formdev1001 = formdev1001;
	}

	public void setScene_id(String scene_id) {
		this.scene_id = scene_id;
	}

	public String getScene_id() {
		return scene_id;
	}

	/**
	 * @return the tri_lev
	 */
	public String getTri_lev() {
		return tri_lev;
	}

	/**
	 * @param tri_lev
	 *            the tri_lev to set
	 */
	public void setTri_lev(String tri_lev) {
		this.tri_lev = tri_lev;
	}

	/**
	 * @return the parms
	 */
	public String getParms() {
		return parms;
	}

	/**
	 * @param parms
	 *            the parms to set
	 */
	public void setParms(String parms) {
		this.parms = parms;
	}

	/**
	 * @return the tri_func
	 */
	public String getTri_func() {
		return tri_func;
	}

	/**
	 * @param tri_func
	 *            the tri_func to set
	 */
	public void setTri_func(String tri_func) {
		this.tri_func = tri_func;
	}

	/**
	 * @return the treeJson
	 */
	public String getTreeJson() {
		return treeJson;
	}

	/**
	 * @param treeJson
	 *            the treeJson to set
	 */
	public void setTreeJson(String treeJson) {
		this.treeJson = treeJson;
	}

	/**
	 * @return the select_type
	 */
	public String getSelect_type() {
		return select_type;
	}

	/**
	 * @param select_type
	 *            the select_type to set
	 */
	public void setSelect_type(String select_type) {
		this.select_type = select_type;
	}
}