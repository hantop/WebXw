<%@ page language="java" contentType="text/html; charset=GBK" pageEncoding="GBK"%>

<%@ page import="app.creditapp.sys.entity.*"%>
<%@ page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ include file="/include/tld.jsp"%>
<%@ taglib uri="/WEB-INF/tld/dict.tld" prefix="dict"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" >
<html>
<head>
	<title></title>
	
	<style type="text/css">
#formula_columns {
	width: 250px;
	BORDER-BOTTOM: #4692ae 1px solid;
	BORDER-LEFT: #4692ae 1px solid;
	BORDER-TOP: #4692ae 1px solid;
	BORDER-RIGHT: #4692ae 1px solid
}

#formula_operator {
	width: 150px;
	BORDER-BOTTOM: #4692ae 1px solid;
	BORDER-LEFT: #4692ae 1px solid;
	BORDER-TOP: #4692ae 1px solid;
	BORDER-RIGHT: #4692ae 1px solid
}

textarea {
	width: 400px;
	BORDER-BOTTOM: #4692ae 1px solid;
	BORDER-LEFT: #4692ae 1px solid;
	BORDER-TOP: #4692ae 1px solid;
	BORDER-RIGHT: #4692ae 1px solid
}
</style>
<script type="text/javascript">
		/*
		 * ��ʼ������ָ��
		 */
		$(document).ready(function(){
			document.operform.elements["bas_indic"].value="A-�����;B-��ǰ������;C-����";
			var customEle = new Array();
				customEle = document.operform.elements["customEle"].value.split("@");
			for(var i=0;i<customEle.length/1-1;i++){
				document.getElementsByName("customEle_parm")[i].value=customEle[i+1].split("=")[0];
				document.getElementsByName("customEleForm")[i].value=customEle[i+1].split("=")[1];
			}
		});
		
	  	/*
	  	 * ��ǰ����ΥԼ��ʽת��
	  	 */
	  	function getDamFormula(){
	  		document.operform.elements["damFormula"].value = "";
	  		var damFormulaDes = document.operform.elements["damFormulaDes"].value;
	  		var damFormula = damFormulaDes;
	  		
	  		var bas_indic = new Array();
	  		bas_indic = document.operform.elements["bas_indic"].value.split(";");
	  		for(var i=0;i<bas_indic.length;i++){
	  			damFormula = damFormula.replace(new RegExp(bas_indic[i].split("-")[1],"gm"),bas_indic[i].split("-")[0]);
				}
	  		document.operform.elements["damFormula"].value = damFormula;
	  	}
	  	/*
	  	 * ����
	  	 */
	  	function func_submit(frm){
	  		
	  		var damName = document.operform.elements["damName"].value;
	  		var damFormulaDes = document.operform.elements["damFormulaDes"].value;
	  		var damFormula = document.operform.elements["damFormula"].value;
	  		var strExp=/^[\u4e00-\u9fa5]/;
	  		if(damName=="" || damName==null){
	  			sAlert("δ��д��ΥԼ��ʽ���ơ���");
				return false;
		  	}
	  		if(damFormulaDes=="" || damFormulaDes==null){
	  			sAlert("δ��д����ǰ����ΥԼ��ʽ��������");
				return false;
		  	}
	  		if(strExp.test(damFormula)){
		  		sAlert("��ǰ����ΥԼ��ʽ�д���δ����ָ�꣬���޸ĺ󱣴棡");
				return false;
		  	}
		  	frm.submit();
		}
	  //��ȡ���ʱ��
	  /*
	  	function func_getFeeId(){
	  		var feeId = document.getElementsByName('feeId')[0].value;
	  		var url ="AcFeeRateAction_findByPop.action?longFeeId="+feeId ;
	  		showDialog(url);
	  	}
	  	*/
</script>
</head>
<body leftmargin="0" topmargin="0" class="body_bg">
	<div class="right_bg">
		<div class="right_w">
			<div class="from_bg">
				<div class="right_v">
			<s:actionerror />
		<s:actionmessage />
		<s:fielderror />
		<div>
			<div>
				<div>
				</div>
				<br>
				<div>
					<div  class="tabs-container" />
						<s:form name="operform" action="AcDamFormulaAction_update.action" method="post" theme="simple" validate="true">
							<table  align="center" width=1200  >
								<tr>
									<td align="right" width="20%" >
										��ǰ����ΥԼ��ʽ���
									</td>
									<td align="left" width="30%"><s:textfield alt="��ǰ����ΥԼ��ʽ���" property="damId" 
											name="damId"  readonly="true"/>[ϵͳ�Զ�����]
									</td>
									<td align="left" width="7%">ΥԼ��ʽ����<font color="red">*</font></td>
									<td align="left" width="30%"><s:textfield alt="��ǰ����ΥԼ��ʽ����" property="damName" maxlength="50" 
											name="damName" />
									</td>
								</tr>
								<tr>
									<td align="right" width="20%" >
										���ʶ�����
									</td>
									<td align="left" width="30%" ><s:textfield alt="���ʱ��" property="frId" 
											name="frId" readonly="false"/>
										<input type="button" value="&nbsp" name="&nbsp"  class="btn_50" 
											onclick="func_popCheckbox('CBPOP012','');"/>
									</td>
								</tr>
								<tr></tr>
								<tr>
									<td align="right" width="20%">
										����ָ��<font color="red"></font>
									</td>
									<td align="left" colspan="3">
										<s:textarea alt="����ָ��" property="bas_indic" readonly="true"
											name="bas_indic" rows="3"  />
									</td>
								</tr>
								<tr></tr>
								
								<tr>
									<td align="right" width="20%">
										��ǰ����ΥԼ��ʽ����<font color="red">*</font>
									</td>
									<td align="left" colspan="3" >
										<s:textarea alt="��ǰ����ΥԼ��ʽ����" property="damFormulaDes"  maxlength="500"
											name="damFormulaDes" rows="3" onchange="getDamFormula();"/>
									</td>
								</tr>
								<tr>
									<td align="right" width="20%">
										��ǰ����ΥԼ��ʽ
									</td>
									<td align="left" colspan="3">
										<s:textarea alt="��ǰ����ΥԼ��ʽ" property="damFormula"  readonly="true"
											name="damFormula" rows="3"  />
									</td>
								</tr>
								
							</table>
							<s:hidden name="customEle" ></s:hidden>
							<div class="from_btn">
								<dhcc:button typeclass="button3" value="����" action="����"
									onclick="func_submit(this.form)"></dhcc:button>
						<!--		<dhcc:button typeclass="btn_80" value="����" action="����"
									onclick="AcDamFormulaAction_findByPage.action"></dhcc:button> -->
									 <input type="button" name="back" value="����" onClick="javascript:window.location='AcDamFormulaAction_findByPage.action'" class="button_form" />
							</div>
								</s:form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>