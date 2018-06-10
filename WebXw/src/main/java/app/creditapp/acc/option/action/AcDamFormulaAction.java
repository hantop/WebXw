package  app.creditapp.acc.option.action;
import java.util.List;
import app.util.User;
import org.apache.struts2.ServletActionContext;
import app.util.toolkit.Ipage;
import app.creditapp.acc.option.bo.AcDamFormulaBo;
import app.creditapp.acc.option.entity.AcDamFormula;

import com.core.domain.screen.FormData;
import com.core.service.screen.FormService;
import com.core.struts.ActionContext;
import com.core.struts.BaseFormBean;

/**
 * Title: AcDamFormulaAction.java
 * Description:
 **/
public class AcDamFormulaAction extends BaseFormBean {

	//ҳ�洫ֵ
	private AcDamFormula acDamFormula;
	private List<AcDamFormula> acDamFormulaList;

	//ע��AcDamFormulaBo
	private AcDamFormulaBo acDamFormulaBo;

	private String query;
	private String damId;
	private String damName;//��ǰ����ΥԼ��ʽ����
	private String damFormulaDes;//��ǰ����ΥԼ��ʽ����
	private String damFormula;//��ǰ����ΥԼ��ʽ
	private String frId;//���ʶ�����
	private FormData formdam001;
	private FormData formdam002;
	private FormService formService = new FormService();
	
	public AcDamFormulaAction() {
		query = "";
	}
	/**
	 * ��ҳ��ѯ
	 * @return
	 * @throws Exception
	 */
	public String findByPage() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),ServletActionContext.getResponse());
		formdam001 = formService.getFormData("dam001");
		acDamFormula = new AcDamFormula();
		getFormValue(formdam001);
		setObjValue(formdam001, acDamFormula);
		Ipage ipage = this.getIpage();
		acDamFormulaList = (List) acDamFormulaBo.findByPage(ipage, acDamFormula).getResult();
		return "list";
	}
	
	
	/**
	 * ��ȡ����ҳ��
	 * @return
	 * @throws Exception
	 */
	public String input() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formdam002 = formService.getFormData("dam002");
		return "input";
	}
	
	/**
	 * �����������
	 * @return
	 * @throws Exception
	 */
	public String insert() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formdam002 = formService.getFormData("dam002");
		getFormValue(formdam002);
		acDamFormula = new AcDamFormula();
		setObjValue(formdam002, acDamFormula);
		acDamFormula.setDamSts("0");//����Ĭ��ΪʧЧ
		acDamFormula.setOpNo(User.getLoginid(this.getHttpRequest()));
		acDamFormula.setTxDate(User.getSys_date(this.getHttpRequest()));
		acDamFormulaBo.insert(acDamFormula);
		getObjValue(formdam002, acDamFormula);
		this.addActionMessage("�����ɹ���");
		return "detail";
	}
	
	
	/**
	 * �޸ı������
	 * @return
	 * @throws Exception
	 */
	public String update() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formdam002 = formService.getFormData("dam002");
		getFormValue(formdam002);
		acDamFormula = new AcDamFormula();
		setObjValue(formdam002, acDamFormula);
		acDamFormula.setUpDate(User.getSys_date(this.getHttpRequest()));
		acDamFormulaBo.update(acDamFormula);
		getObjValue(formdam002, acDamFormula);
		this.addActionMessage("�����ɹ���");
		return "detail";
	}
	
	/**
	 * ��������
	 * @return
	 * @throws Exception
	 */
	public String openReplan() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formdam001 = formService.getFormData("dam001");
		acDamFormula = new AcDamFormula();
		acDamFormula.setDamId(damId);
		acDamFormula.setDamSts("1");
		acDamFormulaBo.updateSts(acDamFormula);
		this.addActionMessage("�����ɹ���");
		acDamFormula = new AcDamFormula();
		Ipage ipage = this.getIpage();
		acDamFormulaList = (List) acDamFormulaBo.findByPage(ipage, acDamFormula).getResult();
		return "list";
	}
	/**
	 * �رղ���
	 * @return
	 * @throws Exception
	 */
	public String closeReplan() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formdam001 = formService.getFormData("dam001");
		acDamFormula = new AcDamFormula();
		acDamFormula.setDamId(damId);
		acDamFormula.setDamSts("0");
		acDamFormulaBo.updateSts(acDamFormula);
		this.addActionMessage("�����ɹ���");
		acDamFormula = new AcDamFormula();
		Ipage ipage = this.getIpage();
		acDamFormulaList = (List) acDamFormulaBo.findByPage(ipage, acDamFormula).getResult();
		return "list";
	}
	
	/**
	 * ɾ������
	 * @return
	 * @throws Exception
	 */
	public String del() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		formdam001 = formService.getFormData("dam001");
		acDamFormula = new AcDamFormula();
		acDamFormula.setDamId(damId);
		acDamFormulaBo.del(acDamFormula);
		this.addActionMessage("ɾ���ɹ�");
		acDamFormula = new AcDamFormula();
		Ipage ipage = this.getIpage();
		acDamFormulaList = (List) acDamFormulaBo.findByPage(ipage, acDamFormula).getResult();
		return "list";
	}

	
	/**
	 * ��ѯ����
	 * @return
	 * @throws Exception
	 */
	public String getById() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),ServletActionContext.getResponse());
		formdam002 = formService.getFormData("dam002");
		acDamFormula = new AcDamFormula();
		acDamFormula.setDamId(damId);
		acDamFormula = acDamFormulaBo.getById(acDamFormula);
		damName = acDamFormula.getDamName();
		damFormulaDes = acDamFormula.getDamFormulaDes();
		damFormula = acDamFormula.getDamFormula();
		frId = acDamFormula.getFrId();
		getObjValue(formdam002, acDamFormula);
		return "detail";
	}
	
	/**
	 * �����������У��
	 * @return
	 * @throws Exception
	 */
	public void validateInsert(){
		 ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		 formdam002 = formService.getFormData("dam002");
		 getFormValue(formdam002);
		 validateFormData(formdam002);
   	}
   
	/**
	 * �޸ı������У��
	 * @return
	 * @throws Exception
	 */
	public void validateUpdate(){
		 ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		 formdam002 = formService.getFormData("dam002");
		 getFormValue(formdam002);
		 validateFormData(formdam002);
  	}
	public AcDamFormula getAcDamFormula() {
		return acDamFormula;
	}
	public void setAcDamFormula(AcDamFormula  acDamFormula) {
		this.acDamFormula = acDamFormula;
	}
	public List<AcDamFormula> getAcDamFormulaList() {
		return acDamFormulaList;
	}
	public void setAcDamFormulaList(List<AcDamFormula> acDamFormulaList) {
		this.acDamFormulaList = acDamFormulaList;
	}
	public AcDamFormulaBo getAcDamFormulaBo() {
		return acDamFormulaBo;
	}
	public void setAcDamFormulaBo(AcDamFormulaBo acDamFormulaBo) {
		this.acDamFormulaBo = acDamFormulaBo;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public FormData getFormdam002() {
		return formdam002;
	}
	public void setFormdam002(FormData formdam002) {
		this.formdam002 = formdam002;
	}
	public FormData getFormdam001() {
		return formdam001;
	}
	public void setFormdam001(FormData formdam001) {
		this.formdam001 = formdam001;
	}
	public void setDamId(String damId){
		this.damId = damId;
	}		
	public String getDamId(){
		return damId;
	}
	public String getDamName() {
		return damName;
	}
	public void setDamName(String damName) {
		this.damName = damName;
	}
	public String getDamFormulaDes() {
		return damFormulaDes;
	}
	public void setDamFormulaDes(String damFormulaDes) {
		this.damFormulaDes = damFormulaDes;
	}
	public String getDamFormula() {
		return damFormula;
	}
	public void setDamFormula(String damFormula) {
		this.damFormula = damFormula;
	}
	public String getFrId() {
		return frId;
	}
	public void setFrId(String frId) {
		this.frId = frId;
	}
}