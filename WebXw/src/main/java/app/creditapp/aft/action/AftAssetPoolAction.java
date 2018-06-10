package  app.creditapp.aft.action;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import app.base.CreateKey;
import app.creditapp.aft.bo.AftAssetPoolBo;
import app.creditapp.aft.bo.AftPoolRelBo;
import app.creditapp.aft.entity.AftAssetPool;
import app.creditapp.aft.entity.AftPoolRel;
import app.util.User;
import app.util.toolkit.Ipage;

import com.core.domain.screen.FormData;
import com.core.service.screen.FormService;
import com.core.struts.ActionContext;
import com.core.struts.BaseFormBean;

/**
 * Title: AftAssetPoolAction.java
 * Description:
 **/
public class AftAssetPoolAction extends BaseFormBean {

	//ҳ�洫ֵ
	private AftAssetPool aftAssetPool;
	private List<AftAssetPool> aftAssetPoolList;
	
	private AftPoolRel aftPoolRel;

	//ע��AftAssetPoolBo
	private AftAssetPoolBo aftAssetPoolBo;
	//ע��AftPoolRelBo
	private AftPoolRelBo aftPoolRelBo;
	private String query;
	private String poolId;		
	private FormData formaft0077;
	private FormData formaft0078;
	private FormService formService = new FormService();
	
	public AftAssetPoolAction() {
		query = "";
	}
	/**
	 * ��ҳ��ѯ
	 * @return
	 * @throws Exception
	 */
	public String findByPage() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),ServletActionContext.getResponse());
		formaft0077 = formService.getFormData("aft0077");
		aftAssetPool = new AftAssetPool();
		getFormValue(formaft0077);
		setObjValue(formaft0077, aftAssetPool);
		String loginIdByAuth = User.getLoginIdByAuth(this.getHttpRequest());
		aftAssetPool.setLoginid(loginIdByAuth); // ��session�л�ȡȨ��
		Ipage ipage = this.getIpage();
		aftAssetPoolList = (List) aftAssetPoolBo.findByPage(ipage, aftAssetPool).getResult();
		return "list";
	}
	
	
	/**
	 * ��ȡ����ҳ��
	 * @return
	 * @throws Exception
	 */
	public String input() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formaft0078 = formService.getFormData("aft0078");
		this.changeFormProperty(formaft0078, "poolSts", "initValue","02");
		return "input";
	}
	
	/**
	 * �����������
	 * @return
	 * @throws Exception
	 */
	public String insert() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formaft0078 = formService.getFormData("aft0078");
		getFormValue(formaft0078);
		aftAssetPool = new AftAssetPool();
		setObjValue(formaft0078, aftAssetPool);
		aftAssetPool.setPoolId(CreateKey.getPoolId());
		aftAssetPool.setOpNo(User.getTlrno(this.getHttpRequest()));	
		aftAssetPool.setBegDate(User.getSys_date(this.getHttpRequest()));
		aftAssetPool.setTxDate(User.getSys_date(this.getHttpRequest()));	
		aftAssetPoolBo.insert(aftAssetPool);
		this.addActionMessage("����ɹ�");
		aftAssetPool = aftAssetPoolBo.getById(aftAssetPool);
		getObjValue(formaft0078, aftAssetPool);
		return "detail";
	}
	
	
	/**
	 * �޸ı������
	 * @return
	 * @throws Exception
	 */
	public String update() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formaft0078 = formService.getFormData("aft0078");
		getFormValue(formaft0078);
		aftAssetPool = new AftAssetPool();
		setObjValue(formaft0078, aftAssetPool);
		aftAssetPool.setUpDate(User.getSys_date(this.getHttpRequest()));
		aftAssetPoolBo.update(aftAssetPool);
		this.addActionMessage("�޸ĳɹ�");
		getObjValue(formaft0078, aftAssetPool);
		return "detail";
	}
	
	
	
	/**
	 * ɾ������
	 * @return
	 * @throws Exception
	 */
	public String del() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formaft0077 = formService.getFormData("aft0077");
		aftAssetPool = new AftAssetPool();
		aftAssetPool.setPoolId(poolId);
		aftAssetPoolBo.del(aftAssetPool);
		//ͬʱɾ�����ʽ�ر���ڹ������м�¼
		aftPoolRel = new AftPoolRel();
		aftPoolRel.setPoolId(poolId);
		aftPoolRelBo.del(aftPoolRel);
		this.addActionMessage("ɾ���ɹ�");
		aftAssetPool = new AftAssetPool();
		Ipage ipage = this.getIpage();
		aftAssetPoolList = (List) aftAssetPoolBo.findByPage(ipage, aftAssetPool).getResult();
		return "list";
	}

	
	/**
	 * ��ѯ����
	 * @return
	 * @throws Exception
	 */
	public String getById() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),ServletActionContext.getResponse());
		formaft0078 = formService.getFormData("aft0078");
		aftAssetPool = new AftAssetPool();
		aftAssetPool.setPoolId(poolId);
		aftAssetPool = aftAssetPoolBo.getById(aftAssetPool);
		getObjValue(formaft0078, aftAssetPool);
		return "detail";
	}
	
	/**
	 * �����������У��
	 * @return
	 * @throws Exception
	 */
	public void validateInsert(){
		 ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		 formaft0078 = formService.getFormData("aft0078");
		 getFormValue(formaft0078);
		 validateFormData(formaft0078);
   	}
   
	/**
	 * �޸ı������У��
	 * @return
	 * @throws Exception
	 */
	public void validateUpdate(){
		 ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		 formaft0078 = formService.getFormData("aft0078");
		 getFormValue(formaft0078);
		 validateFormData(formaft0078);
  	}
	public AftAssetPool getAftAssetPool() {
		return aftAssetPool;
	}
	public void setAftAssetPool(AftAssetPool  aftAssetPool) {
		this.aftAssetPool = aftAssetPool;
	}
	public List<AftAssetPool> getAftAssetPoolList() {
		return aftAssetPoolList;
	}
	public void setAftAssetPoolList(List<AftAssetPool> aftAssetPoolList) {
		this.aftAssetPoolList = aftAssetPoolList;
	}
	public AftAssetPoolBo getAftAssetPoolBo() {
		return aftAssetPoolBo;
	}
	public void setAftAssetPoolBo(AftAssetPoolBo aftAssetPoolBo) {
		this.aftAssetPoolBo = aftAssetPoolBo;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public FormData getFormaft0078() {
		return formaft0078;
	}
	public void setFormaft0078(FormData formaft0078) {
		this.formaft0078 = formaft0078;
	}
	public FormData getFormaft0077() {
		return formaft0077;
	}
	public void setFormaft0077(FormData formaft0077) {
		this.formaft0077 = formaft0077;
	}
	public void setPoolId(String poolId){
		this.poolId = poolId;
	}		
	public String getPoolId(){
		return poolId;
	}
	public AftPoolRel getAftPoolRel() {
		return aftPoolRel;
	}
	public void setAftPoolRel(AftPoolRel aftPoolRel) {
		this.aftPoolRel = aftPoolRel;
	}
	public AftPoolRelBo getAftPoolRelBo() {
		return aftPoolRelBo;
	}
	public void setAftPoolRelBo(AftPoolRelBo aftPoolRelBo) {
		this.aftPoolRelBo = aftPoolRelBo;
	}
}