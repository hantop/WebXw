<%@ page language="java" contentType="text/html; charset=GBK"
	pageEncoding="GBK"%>
<%@ include file="/include/tld.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%
String  projNo = (String)request.getAttribute("projNo");
%>
<html>
	<head>
		<title>�б�</title>
		<script>
		function func_br(url){
		//ProjAcctAction_active.action;acctId-acctId;flag-'1';cardSts-cardSts;projNo-projNo;projId-projId;onClick-func_br
			var acctId = url.split("?")[1].split("&")[0].split("=")[1];
			var flag = url.split("?")[1].split("&")[1].split("=")[1];
			var cardSts = url.split("?")[1].split("&")[2].split("=")[1];
			var projNo = url.split("?")[1].split("&")[3].split("=")[1];
			var projId = url.split("?")[1].split("&")[4].split("=")[1];
			
			
			if(cardSts=="02"){
			    //ͣ��״̬ ��Ϊ ����
			    var d = confirm("��ȷ��Ҫ���ø���Ŀ�˻���");
				if(d==true){
				   var d = confirm("���˻�����֧��ƽ̨������ȷ����");
				   if(d==true){
				      window.location='ProjAcctAction_active.action?acctId='+acctId+'&flag='+flag+'&cardSts='+cardSts+'&projNo='+projNo+'&projId='+projId;
				   }
				}
		    }else{
		    	//����״̬ ��Ϊ ֹͣ״̬
			    var d = confirm("��ȷ��Ҫע������Ŀ�˻���");
				if(d==true){
				   var d = confirm("���˻�����֧��ƽ̨ע�������ȷ����");
				   if(d==true){
				      window.location='ProjAcctAction_active.action?acctId='+acctId+'&flag='+flag+'&cardSts='+cardSts+'&projNo='+projNo+'&projId='+projId;
				   }
				}
			}
		}
		</script>
	</head>
	<body class="body_bg">
	<s:form method="post" theme="simple" name="cms_form"
		action="ProjAcctAction_findByPageToProj_Read.action">
		<p class="p_blank">&nbsp;</p>
		
		<div class="right_bg">
			<div class="right_w">
				<div class="from_bg">
					<div class="right_v">
						<div class="tabCont">
							<!--<div class="tabTitle">���⻧�б�</div>-->
							<div class="tabTitle">�˻��б�</div>
							<input value="<s:property value="projNo"/>" name="projNo" type="hidden"> 
							<dhcc:button value="����" action="����" typeclass="t_ico_tj"
								onclick="ProjAcctAction_inputAcct.action" param="projNo=projNo"></dhcc:button>
						</div>
						<input value="<s:property value="query"/>" name="query" type="hidden"> 
				<!--		<input value="<s:property value="projNo"/>" name="projNo" type="hidden">   -->
							<input name="acctType" value="<s:property value="acctType"/>" type="hidden"/>
						<dhcc:tableTag paginate="projAcctList" property="tableproj0012"
									head="true" />
					</div>
				</div>
			</div>
		</div>
	</s:form>
	</body>
</html>