<%@ page language="java" contentType="text/html; charset=GBK"
	pageEncoding="GBK"%>
<%@ include file="/include/tld.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%
String ctd=(String)request.getAttribute("ctd");
%>
<html>
	<head>
		<title>����</title>
	</head>
		<script type="text/javascript">
	function getBegDate(){
		    fPopUpCalendarDlg();
		}
	function getEndDate(){
		    fPopUpCalendarDlg();
		}		
	</script>
	<body class="body_bg">
	<s:form method="post" theme="simple" name="cms_form"
		action="LnPactActionUpdate.action">
		<div class="right_bg">
			<div class="right_w">
				<div class="from_bg">
					<div class="right_v">
						<dhcc:formTag property="formlnpact0002" mode="query" />
						<div class="from_btn">
						<s:if test="query!='query'">
							 <dhcc:button typeclass="button3" commit="true" value="����" action="����"  ></dhcc:button>
						 </s:if>
		                 <s:if test="formSts==1">
		                 </s:if>
		                 <s:else>
		                 <input type="button" value="����" onclick="javascript:window.location='LnPactAction_listQuotaForCif.action?cifNo=<%=ctd%>&query=query1'" class="button_form"/>
		                 </s:else>
						</div>
					</div>
				</div>
			</div>
		</div>
	</s:form>
	</body>
</html>