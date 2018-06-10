package app.creditapp.acc.cancel.action;

import org.apache.struts2.ServletActionContext;

import accounting.interf.cancel.CancelTrace;
import accounting.interf.cancel.ReverseTrace;
import app.creditapp.acc.cancel.bo.CancelBo;
import app.util.User;

import com.core.domain.screen.FormData;
import com.core.service.screen.FormService;
import com.core.struts.ActionContext;
import com.core.struts.BaseFormBean;

public class CancelAction extends BaseFormBean {

	private CancelTrace cancelTrace;

	private CancelBo cancelBo;

	private String traceNo; // ������ˮ��
	private String type; // ����ʽ��������c/������r��
	private String txDt;	//��������
	private String query;
	private String view;

	private FormData formacc0201;
	private FormService formService = new FormService();

	public CancelAction() {
		formacc0201 = formService.getFormData("acc0201");
		query = "";
		view = "";
	}

	/**
	 * ����/��������
	 * 
	 * @return
	 * @throws Exception
	 */
	public String cancelTrace() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),
				ServletActionContext.getResponse());
		getFormValue(formacc0201);
		cancelTrace = new CancelTrace();
		cancelTrace.setTraceNo(traceNo);
		
		ReverseTrace reverseTrace = new ReverseTrace();
		reverseTrace.setReverseTraceNo(Long.parseLong(traceNo));
		String msg = cancelBo.reverseTrace(reverseTrace);
		if (msg != null) {
			this.addActionError(msg);
			return INPUT;
		}
		this.addActionMessage("�����ɹ���");
		return SUCCESS;
	}

	public void validateCancelTrace() {
		ActionContext.initialize(ServletActionContext.getRequest(),
				ServletActionContext.getResponse());
		getFormValue(formacc0201);
		validateFormData(formacc0201);
		if("c".equals(type)){
			if(!txDt.equals(User.getSys_date(this.getHttpRequest()))){
				this.addActionError("�������ںͽ��׷������ڲ�һ�£����ܽ��г���!");
			}
		}
		
	}

	/**
	 * ��������
	 * 
	 * @return
	 * @throws Exception
	 */
	/*public String reverseTrace() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),
				ServletActionContext.getResponse());
		getFormValue(formacc0201);
		reverseTrace = new ReverseTrace();
		reverseTrace.setReverseTraceNo(traceNo);
		reverseTrace.setBrNo(User.getBrno(ServletActionContext.getRequest()));
		reverseTrace.setUsrId(User.getTlrno(ServletActionContext.getRequest()));
		String msg = cancelBo.reverseTrace(reverseTrace);
		if (msg != null) {
			this.addActionError(msg);
			return INPUT;
		}
		this.addActionMessage("�����ɹ���");
		return SUCCESS;
	}

	public void validateReverseTrace() {
		ActionContext.initialize(ServletActionContext.getRequest(),
				ServletActionContext.getResponse());
		getFormValue(formacc0201);
		validateFormData(formacc0201);
	}*/

	public CancelTrace getCancelTrace() {
		return cancelTrace;
	}

	public void setCancelTrace(CancelTrace cancelTrace) {
		this.cancelTrace = cancelTrace;
	}

	public CancelBo getCancelBo() {
		return cancelBo;
	}

	public void setCancelBo(CancelBo cancelBo) {
		this.cancelBo = cancelBo;
	}

	public String getTraceNo() {
		return traceNo;
	}

	public void setTraceNo(String traceNo) {
		this.traceNo = traceNo;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	public FormData getFormacc0201() {
		return formacc0201;
	}

	public void setFormacc0201(FormData formacc0201) {
		this.formacc0201 = formacc0201;
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public String getView() {
		return view;
	}

	public void setView(String view) {
		this.view = view;
	}

	public String getTxDt() {
		return txDt;
	}
	public void setTxDt(String txDt) {
		this.txDt = txDt;
	}
	
}
