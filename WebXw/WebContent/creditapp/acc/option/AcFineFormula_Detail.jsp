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
			document.operform.elements["bas_indic"].value="A-�������ڱ���;B-����������Ϣ;C-������������;D-��������;E-�����;F-����������;G-������";
			var customEle = new Array();
				customEle = document.operform.elements["customEle"].value.split("@");
			for(var i=0;i<customEle.length/1-1;i++){
				document.getElementsByName("customEle_parm")[i].value=customEle[i+1].split("=")[0];
				document.getElementsByName("customEleForm")[i].value=customEle[i+1].split("=")[1];
			}
		});
		
	  	/*
	  	 * ��Ϣ��ʽת��
	  	 */
	  	function getFineFormula(){
	  		document.operform.elements["fineFormula"].value = "";
	  		var fineFormulaDes = document.operform.elements["fineFormulaDes"].value;
	  		var fineFormula = fineFormulaDes;
	  		
	  		var bas_indic = new Array();
	  		bas_indic = document.operform.elements["bas_indic"].value.split(";");
	  		for(var i=0;i<bas_indic.length;i++){
	  			fineFormula = fineFormula.replace(new RegExp(bas_indic[i].split("-")[1],"gm"),bas_indic[i].split("-")[0]);
				}
	  		document.operform.elements["fineFormula"].value = fineFormula;
	  	}
	  	/**
	 	function checkRate(){
	  		var re = /^[\.\d]+$/;

	  		var overRate = document.operform.elements["overRate"].value;
	  		if(!re.test(overRate)){
				sAlert("���������������������룡");
				document.operform.elements["overRate"].value="0.00";
		  	}
		}
		*/
	  	/*
	  	 * ����
	  	 */
	  	function func_submit(frm){
	  		
	  		var fineName = document.operform.elements["fineName"].value;
	  		//var overRate = document.operform.elements["overRate"].value;
	  		var fineFormulaDes = document.operform.elements["fineFormulaDes"].value;
	  		var fineFormula = document.operform.elements["fineFormula"].value;
	  		var strExp=/^[\u4e00-\u9fa5]/;
	  		if(fineName=="" || fineName==null){
	  			sAlert("δ��д����Ϣ��ʽ���ơ���");
				return false;
		  	}
	  		if(fineFormulaDes=="" || fineFormulaDes==null){
	  			sAlert("δ��д����Ϣ��ʽ��������");
				return false;
		  	}
	  		if(strExp.test(fineFormula)){
		  		sAlert("��Ϣ��ʽ�д���δ����ָ�꣬���޸ĺ󱣴棡");
				return false;
		  	}
		  	frm.submit();
		}
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
						<s:form name="operform" action="AcFineFormulaAction_update.action" method="post" theme="simple" validate="true">
							<table  align="center" width=1200  >
								<tr>
									<td align="right" width="20%" >
										��Ϣ��ʽ���
									</td>
									<td align="left" width="30%"><s:textfield alt="��Ϣ��ʽ���" property="fineId" 
											name="fineId"  readonly="true"/>[ϵͳ�Զ�����]
									</td>
									<td align="left" width="7%">��Ϣ��ʽ����<font color="red">*</font></td>
									<td align="left" width="30%"><s:textfield alt="��Ϣ��ʽ����" property="fineName"  maxlength="50"
											name="fineName" />
									</td>
								</tr>
								<!-- 
								<tr>
									<td align="right" width="20%" >
										����������
										<font color="red">*</font>
									</td>
									<td align="left" width="30%"><s:textfield alt="��������" property="overRate"  maxlength="25"
											name="overRate"  onchange="checkRate()"/>��
									</td>
								</tr>
								 -->
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
										��Ϣ��ʽ����<font color="red">*</font>
									</td>
									<td align="left" colspan="3" >
										<s:textarea alt="��Ϣ��ʽ����" property="fineFormulaDes"  maxlength="500"
											name="fineFormulaDes" rows="3" onchange="getFineFormula();"/>
									</td>
								</tr>
								<tr>
									<td align="right" width="20%">
										��Ϣ��ʽ
									</td>
									<td align="left" colspan="3">
										<s:textarea alt="��Ϣ��ʽ" property="fineFormula"  readonly="true" maxlength="500"
											name="fineFormula" rows="3"  />
									</td>
								</tr>
								
							</table>
							<s:hidden name="customEle" ></s:hidden>
							<div class="from_btn">
								<dhcc:button typeclass="button3" value="����" action="����"
									onclick="func_submit(this.form)"></dhcc:button>
								<dhcc:button typeclass="btn_80" value="����" action="����"
									onclick="AcFineFormulaAction_findByPage.action"></dhcc:button>
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