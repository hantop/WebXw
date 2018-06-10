package app.creditapp.cred.action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import app.creditapp.corp.entity.RptParams;
import app.creditapp.cred.bo.PcrpQueryInfoBo;
import app.creditapp.cred.entity.PcrpQueryInfo;
import com.alibaba.fastjson.JSON;
import com.core.struts.ActionContext;
import com.core.struts.BaseFormBean;

/**
 * 
 * �����ƣ�pcrpQueryInfoAction ���������������ñ���ҵ��  ���Ž����ѯ����
 * �����ˣ������� dhcc ����ʱ�䣺2016-6-25
 * ����01:07:30 �޸��ˣ�Administrator
 * 
 * @version
 */
public class PcrpQueryInfoAction extends BaseFormBean{

	private PcrpQueryInfo		pcrpQueryInfo;
	private String				CRP_ID;
	private String				CERT_TYPE;							// ֤������
	private String				CERT_NUM;							// ֤������
	private String				CUST_NAME;							// �ͻ�����
	private String				CRP_REASON;						// ��ѯԭ��
	private String				REPORT_TYPE;						// ���ñ����ʽ
	private String				CUST_NO;
	private String				CRP_EXPDATE;
	private String				idauthflag;						// ��ѯ����
	private String				AFT_ID;
	private String				CRP_FILEPATH;
	private PcrpQueryInfoBo		pcrpQueryInfoBo;
	private PcrpQueryInfo pcrpQueryInfoRep;
	private HttpServletRequest	request;

	private List tabList;
	private String query;
	private String brNo;
	private RptParams rptParams;
	/**
	 * 
	 * 
	 * @return
	 * @throws Exception
	 *             2016-6-24 �����ˣ�sunmingyi dhcc
	 */
	public String reportSearchUrl() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(), ServletActionContext.getResponse());
		request = ServletActionContext.getRequest();
		request.setAttribute("url", CRP_FILEPATH);
		return "url";
	}

	/**
	 * �������ñ�������ѯ
	 * 
	 * @return
	 * @throws Exception
	 *             2016-6-24 �����ˣ�sunmingyi dhcc
	 */
	@SuppressWarnings("unchecked")
	public String searchPcrpDetailById() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),ServletActionContext.getResponse());
		request= ServletActionContext.getRequest();
		pcrpQueryInfoRep = new PcrpQueryInfo();
		pcrpQueryInfoRep.setCustName(CUST_NAME);
		pcrpQueryInfoRep.setCertType(CERT_TYPE);
		pcrpQueryInfoRep.setCertNum(CERT_NUM);
		pcrpQueryInfoRep.setCrpReason(CRP_REASON);
		//���÷����������Ž����ѯ��
		System.out.println("��ʼ���ÿͻ��ˡ�����������������������������������������������������������������");
		String byCrp = pcrpQueryInfoBo.getByCrp(pcrpQueryInfoRep);
		PcrpQueryInfo pcrpQueryinfoCrp=new PcrpQueryInfo();
		//��json��תΪ����
//		pcrpQueryinfoCrp = (PcrpQueryInfo) JsonUtil.getObject4JsonString(byCrp, PcrpQueryInfo.class);
		pcrpQueryinfoCrp = (PcrpQueryInfo) JSON.parseObject(byCrp, PcrpQueryInfo.class);
		//������ŵ�json��
		request.setAttribute("pcrpQueryinfoCrp",pcrpQueryinfoCrp); 
		request.setAttribute("AFT_ID",AFT_ID);
		request.setAttribute("CRP_ID",CRP_ID);
		request.setAttribute("REPORT_TYPE",REPORT_TYPE);
		request.setAttribute("CRP_EXPDATE",CRP_EXPDATE);
		request.setAttribute("CUST_NAME",CUST_NAME);
		request.setAttribute("CRP_REASON",CRP_REASON);
		request.setAttribute("REPORT_TYPE",REPORT_TYPE);
		request.setAttribute("CERT_TYPE",CERT_TYPE);
		request.setAttribute("CERT_NUM",CERT_NUM);
		request.setAttribute("CUST_NO",CUST_NO);
		request.setAttribute("CRP_FILEPATH",pcrpQueryinfoCrp.getCrpFilePath());
		return "CustQueryInfoListSC" ;

	}
	//������Ϣͼ��
	public String getViewTab() throws Exception{
		ActionContext.initialize(ServletActionContext.getRequest(),
				ServletActionContext.getResponse());
		tabList = new ArrayList();
		String[] tab = null;
		tab = new String[2];
		tab[0] = "��������";
		tab[1] = "PcrpQueryInfoAction_showActionNum.action?brNo=" + brNo+ "&query="+ query + "";
		tabList.add(tab);
		
		tab = new String[2];
		tab[0] = "�����ֲ�";
		tab[1] = "PcrpQueryInfoAction_showChart.action?brNo=" + brNo+ "&query="+ query + "";
		tabList.add(tab);
		
		return "tab";
	}
	/**
	 * ��ʾ�ֲ�ͼ
	 * @return
	 * @throws Exception
	 */
	public String showChart() throws Exception {
		ActionContext.initialize(ServletActionContext.getRequest(),ServletActionContext.getResponse());

		String data = "";
		String xStr = "";
		pcrpQueryInfo = new PcrpQueryInfo();
		pcrpQueryInfo.setBrNo(brNo);
		int bank = pcrpQueryInfoBo.getBankCount(pcrpQueryInfo);
		pcrpQueryInfo = new PcrpQueryInfo();
		pcrpQueryInfo.setBrNo(brNo);
		int loc = pcrpQueryInfoBo.getBatchCount(pcrpQueryInfo)-bank;
		if(loc+bank > 0){
			data = "{name:'���ز�ѯ',value:"+loc+"}";
			xStr = "'���ز�ѯ'";
			data += ",{name:'���в�ѯ',value:"+bank+"}";
			xStr += ",'���в�ѯ'";			
		}
		rptParams = new RptParams();
		rptParams.setData1(xStr);
		rptParams.setData2(data);
		return "viewChart";
	}
	public String showActionNum() throws Exception{
		ActionContext.initialize(ServletActionContext.getRequest(), 
				ServletActionContext.getResponse());
		
		String xStr = "";
		String data = "";
		String[] months = this.getMonths();
		pcrpQueryInfo = new PcrpQueryInfo();
		pcrpQueryInfo.setBrNo(brNo);
		int count = pcrpQueryInfoBo.getBatchCount(pcrpQueryInfo);
		if(count > 0){
			for(int i=0; i<months.length; i++){
				pcrpQueryInfo = new PcrpQueryInfo();
				pcrpQueryInfo.setBrNo(brNo);
				pcrpQueryInfo.setCrpTime(months[i].replace("-", ""));
				
				xStr += ",'"+months[i]+"'";
				data += ","+pcrpQueryInfoBo.getBatchCount(pcrpQueryInfo);
			}
			if(xStr.length()>0){
				xStr = xStr.substring(1);
				data = data.substring(1);
			}
		}
		rptParams = new RptParams();
		rptParams.setData1(xStr);
		rptParams.setData2(data);
		return "viewNum";
	}
	//��ȡ��ȥ�������·�
	public String[] getMonths(){        
		String[] months = new String[6];
        Calendar cal = Calendar.getInstance();  
        DateFormat df = new SimpleDateFormat("yyyy-MM");
        cal.set(Calendar.MONTH, cal.get(Calendar.MONTH)+1); //Ҫ��+1,���ܰѱ��µ����ȥ</span>  
        for(int i=0; i<6; i++){  
            cal.set(Calendar.MONTH, cal.get(Calendar.MONTH)-1); //�����ǰ��1����  
            Date dtFrom=cal.getTime();
            months[5-i] = df.format(dtFrom);
        }       
        return months;
    }  
//	public static String getMACAddress() throws Exception {
//		// ��ȡ����IP����
//		InetAddress ia = InetAddress.getLocalHost();
//		// �������ӿڶ��󣨼������������õ�mac��ַ��mac��ַ������һ��byte�����С�
//		byte[] mac = NetworkInterface.getByInetAddress(ia).getHardwareAddress();
//		// ��������ǰ�mac��ַƴװ��String
//		StringBuffer sb = new StringBuffer();
//		for (int i = 0; i < mac.length; i++) {
//			if (i != 0) {
//				sb.append("-");
//			}
//			// mac[i] & 0xFF ��Ϊ�˰�byteת��Ϊ������
//			String s = Integer.toHexString(mac[i] & 0xFF);
//			sb.append(s.length() == 1 ? 0 + s : s);
//		}
//		// ���ַ�������Сд��ĸ��Ϊ��д��Ϊ�����mac��ַ������
//		return sb.toString().toUpperCase();
//	}

	public PcrpQueryInfo getPcrpQueryInfo() {
		return pcrpQueryInfo;
	}

	public void setPcrpQueryInfo(PcrpQueryInfo pcrpQueryInfo) {
		this.pcrpQueryInfo = pcrpQueryInfo;
	}

	public String getCRP_ID() {
		return CRP_ID;
	}

	public void setCRP_ID(String cRPID) {
		CRP_ID = cRPID;
	}

	public String getCERT_TYPE() {
		return CERT_TYPE;
	}

	public void setCERT_TYPE(String cERTTYPE) {
		CERT_TYPE = cERTTYPE;
	}

	public String getCERT_NUM() {
		return CERT_NUM;
	}

	public void setCERT_NUM(String cERTNUM) {
		CERT_NUM = cERTNUM;
	}

	public String getCUST_NAME() {
		return CUST_NAME;
	}

	public void setCUST_NAME(String cUSTNAME) {
		CUST_NAME = cUSTNAME;
	}

	public String getCRP_REASON() {
		return CRP_REASON;
	}

	public void setCRP_REASON(String cRPREASON) {
		CRP_REASON = cRPREASON;
	}

	public String getREPORT_TYPE() {
		return REPORT_TYPE;
	}

	public void setREPORT_TYPE(String rEPORTTYPE) {
		REPORT_TYPE = rEPORTTYPE;
	}

	public String getIdauthflag() {
		return idauthflag;
	}

	public void setIdauthflag(String idauthflag) {
		this.idauthflag = idauthflag;
	}

	public PcrpQueryInfoBo getPcrpQueryInfoBo() {
		return pcrpQueryInfoBo;
	}

	public void setPcrpQueryInfoBo(PcrpQueryInfoBo pcrpQueryInfoBo) {
		this.pcrpQueryInfoBo = pcrpQueryInfoBo;
	}

	public String getAFT_ID() {
		return AFT_ID;
	}

	public void setAFT_ID(String aFTID) {
		AFT_ID = aFTID;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public String getCUST_NO() {
		return CUST_NO;
	}

	public void setCUST_NO(String cust_no) {
		CUST_NO = cust_no;
	}

	public String getCRP_EXPDATE() {
		return CRP_EXPDATE;
	}

	public void setCRP_EXPDATE(String crp_expdate) {
		CRP_EXPDATE = crp_expdate;
	}

	public String getCRP_FILEPATH() {
		return CRP_FILEPATH;
	}

	public void setCRP_FILEPATH(String crp_filepath) {
		CRP_FILEPATH = crp_filepath;
	}

	public List getTabList() {
		return tabList;
	}

	public void setTabList(List tabList) {
		this.tabList = tabList;
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public String getBrNo() {
		return brNo;
	}

	public void setBrNo(String brNo) {
		this.brNo = brNo;
	}

	public RptParams getRptParams() {
		return rptParams;
	}

	public void setRptParams(RptParams rptParams) {
		this.rptParams = rptParams;
	}

}