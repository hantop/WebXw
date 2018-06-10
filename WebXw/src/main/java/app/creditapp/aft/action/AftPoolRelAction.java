package  app.creditapp.aft.action;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import app.creditapp.aft.bo.AftAssetPoolBo;
import app.creditapp.aft.bo.AftPoolRelBo;
import app.creditapp.aft.entity.AftAssetPool;
import app.creditapp.aft.entity.AftPoolRel;
import app.util.User;
import app.util.toolkit.Ipage;

import com.alibaba.fastjson.JSON;
import com.core.domain.screen.FormData;
import com.core.service.screen.FormService;
import com.core.struts.ActionContext;
import com.core.struts.BaseFormBean;

/**
 * Title: AftPoolRelAction.java
 * Description:
 **/
public class AftPoolRelAction extends BaseFormBean {

	//ҳ�洫ֵ
	private AftPoolRel aftPoolRel;
	private List<AftPoolRel> aftPoolRelList;
	
	private AftAssetPool aftAssetPool;
	//ע��AftPoolRelBo
	private AftPoolRelBo aftPoolRelBo;
	//ע��AftAssetPoolBo
	private AftAssetPoolBo aftAssetPoolBo;
	
	private String pactId;

	private String query;
	private String poolId;		
	private FormData formaft0007;
	private FormData formaft0008;
	private FormService formService = new FormService();
	
	public AftPoolRelAction() {
		query = "";
	}
	/**
	 * ��ҳ��ѯ
	 * @return
	 * @throws Exception
	 */
	public String findByPage() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),ServletActionContext.getResponse());
		formaft0007 = formService.getFormData("aft0007");
		aftPoolRel = new AftPoolRel();
		getFormValue(formaft0007);
		setObjValue(formaft0007, aftPoolRel);
		if(aftPoolRel.getPoolId()==null){
			aftPoolRel.setPoolId(poolId);
		}
		Ipage ipage = this.getIpage();
		aftPoolRelList = (List) aftPoolRelBo.findByPage(ipage, aftPoolRel).getResult();
		return "list";
	}
	
	
	/**
	 * ��ȡ����ҳ��
	 * @return
	 * @throws Exception
	 */
	public String input() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formaft0008 = formService.getFormData("aft0008");
		aftPoolRel = new AftPoolRel();
		aftPoolRel.setPoolId(poolId);
		getObjValue(formaft0008, aftPoolRel);
		return "input";
	}
	
	/**
	 * �����������
	 * @return
	 * @throws Exception
	 */
	public String insert() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formaft0008 = formService.getFormData("aft0008");
		getFormValue(formaft0008);
		aftPoolRel = new AftPoolRel();
		setObjValue(formaft0008, aftPoolRel);
		aftPoolRel.setTxDate(User.getSys_date(this.getHttpRequest()));
		aftPoolRel.setPoolDate(User.getSys_date(this.getHttpRequest()));
		aftPoolRel.setOpNo(User.getTlrno(this.getHttpRequest()));
		aftPoolRel.setPoolSts("02");
		aftPoolRelBo.insert(aftPoolRel);
		this.addActionMessage("����ɹ�");
		getObjValue(formaft0008, aftPoolRel);
		this.changeFormProperty(formaft0008,"poolId","readonly","1");
		//�����ʲ��ؽ�ݹ��������ʽ�ؽ������ܶ�
		aftAssetPool = new AftAssetPool();
		aftAssetPool.setPoolId(poolId);
		aftAssetPoolBo.updateTotal(aftAssetPool);
		query="query";
		return "detail";
	}
	
	
	/**
	 * �޸ı������
	 * @return
	 * @throws Exception
	 */
	public String update() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formaft0008 = formService.getFormData("aft0008");
		getFormValue(formaft0008);
		aftPoolRel = new AftPoolRel();
		setObjValue(formaft0008, aftPoolRel);
		aftPoolRel.setUpDate(User.getSys_date(this.getHttpRequest()));
		aftPoolRelBo.update(aftPoolRel);
		this.addActionMessage("����ɹ�");
		getObjValue(formaft0008, aftPoolRel);
		this.changeFormProperty(formaft0008,"poolId","readonly","1");
		return "detail";
	}
	
	
	
	/**
	 * ɾ������
	 * @return
	 * @throws Exception
	 */
	public String del() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formaft0007 = formService.getFormData("aft0007");
		aftPoolRel = new AftPoolRel();
		aftPoolRel.setPoolId(poolId);
		aftPoolRel.setPactId(pactId);
		aftPoolRelBo.delect(aftPoolRel);
		//�����ʲ��ؽ�ݹ��������ʽ�ؽ������ܶ�
		aftAssetPool = new AftAssetPool();
		aftAssetPool.setPoolId(poolId);
		aftAssetPoolBo.updateTotal(aftAssetPool);
		
		aftPoolRel = new AftPoolRel();
		aftPoolRel.setPoolId(poolId);
		Ipage ipage = this.getIpage();
		aftPoolRelList = (List) aftPoolRelBo.findByPage(ipage, aftPoolRel).getResult();
		return "list";
	}

	
	/**
	 * ��ѯ����
	 * @return
	 * @throws Exception
	 */
	public String getById() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),ServletActionContext.getResponse());
		formaft0008 = formService.getFormData("aft0008");
		aftPoolRel = new AftPoolRel();
		aftPoolRel.setPoolId(poolId);
		aftPoolRel = aftPoolRelBo.getById(aftPoolRel);
		getObjValue(formaft0008, aftPoolRel);
		this.changeFormProperty(formaft0008,"poolId","readonly","1");
		return "detail";
	}
	
	/**
	 * �����������У��
	 * @return
	 * @throws Exception
	 */
	public void validateInsert(){
		 ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		 formaft0008 = formService.getFormData("aft0008");
		 getFormValue(formaft0008);
		 validateFormData(formaft0008);
		 aftPoolRel = new AftPoolRel();
		 aftPoolRel.setPoolId(poolId);
		 aftPoolRel.setPactId(pactId);
		 Ipage ipage = this.getIpage();
		 List<AftPoolRel> aftPoolRelList = (List) aftPoolRelBo.findByPage(ipage, aftPoolRel).getResult();		
		 if(aftPoolRelList.size()>0){   
				this.addActionError("���ʲ��ر�ŵĺ�ͬ���Ѵ���!");
		 }
   	}
   
	/**
	 * �޸ı������У��
	 * @return
	 * @throws Exception
	 */
	public void validateUpdate(){
		 ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		 formaft0008 = formService.getFormData("aft0008");
		 getFormValue(formaft0008);
		 validateFormData(formaft0008);
  	}
	public AftPoolRel getAftPoolRel() {
		return aftPoolRel;
	}
	public void setAftPoolRel(AftPoolRel  aftPoolRel) {
		this.aftPoolRel = aftPoolRel;
	}
	public List<AftPoolRel> getAftPoolRelList() {
		return aftPoolRelList;
	}
	public void setAftPoolRelList(List<AftPoolRel> aftPoolRelList) {
		this.aftPoolRelList = aftPoolRelList;
	}
	public AftPoolRelBo getAftPoolRelBo() {
		return aftPoolRelBo;
	}
	public void setAftPoolRelBo(AftPoolRelBo aftPoolRelBo) {
		this.aftPoolRelBo = aftPoolRelBo;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public FormData getFormaft0008() {
		return formaft0008;
	}
	public void setFormaft0008(FormData formaft0008) {
		this.formaft0008 = formaft0008;
	}
	public FormData getFormaft0007() {
		return formaft0007;
	}
	public void setFormaft0007(FormData formaft0007) {
		this.formaft0007 = formaft0007;
	}
	public void setPoolId(String poolId){
		this.poolId = poolId;
	}		
	public String getPoolId(){
		return poolId;
	}
	public String getPactId() {
		return pactId;
	}
	public void setPactId(String pactId) {
		this.pactId = pactId;
	}
	public AftAssetPool getAftAssetPool() {
		return aftAssetPool;
	}
	public void setAftAssetPool(AftAssetPool aftAssetPool) {
		this.aftAssetPool = aftAssetPool;
	}
	public AftAssetPoolBo getAftAssetPoolBo() {
		return aftAssetPoolBo;
	}
	public void setAftAssetPoolBo(AftAssetPoolBo aftAssetPoolBo) {
		this.aftAssetPoolBo = aftAssetPoolBo;
	}
}