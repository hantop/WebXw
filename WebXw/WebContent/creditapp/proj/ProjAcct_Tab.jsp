<%@ page language="java" contentType="text/html; charset=GBK"
	pageEncoding="GBK"%>
<meta http-equiv="X-UA-Compatible" content="IE=Edge,IE=IE9" >
<%@ include file="/include/tld.jsp"%>
<%@ include file="/include/incTab.jsp"%>
<%String dataType =(String) request.getAttribute("dataType"); %>
<html>
<head>
<title>С΢�����˹�ƽ̨����ϵͳ</title>
<script type="text/javascript">
var dataType="<%=dataType%>";
if(dataType!=null&&dataType!=""&&dataType!="null"){
	if(dataType=="success"){
		parent.opener.location="ProjAcctAction_findByPage.action";
	}
	/*if(parent.opener.location.href.indexOf("ProjAcctAction_findByPage")){
		parent.opener.location.reload();
	}else{
		parent.opener.location.href="<%=contextpath%>/ProjAcctAction_findByPage.action";
	}*/
}
</script>
</head>
<body class="body_bg">
<div class="right_bg">
<div class="right_w">
<div class="from_bg">
<div class="right_v">
<form action="#">
<table width="100%" align="center" height="100%">
	<tr>
		<td>
			<div class="tab_btn_div">
						<!-- ��back=1ʱ����ʾ���� ��Ϊ�ڴ���������̨--��������ʱҪ���ø�ҳ��鿴���˿ͻ���Ϣ����ʱ���÷��ذ�ť -->
						<s:if test="backSts!=1">
						<dhcc:button typeclass="button3" value="�����˻�" action="����"
							onclick="ProjBaseAction_account_getAllDetail.action" param="projNo=projNo" >
						</dhcc:button>
						</s:if>
			</div>
		</td>
	</tr>
	<input name="acctId" value="<s:property value="acctId"/>" type="hidden"/>
							<input name="projNo" value="<s:property value="projNo"/>" type="hidden"/>	
	<tr>
		<td>
		<dhcc:tabTag tabList="tabList"></dhcc:tabTag>
		</td>
	</tr>
</table>		
</form>
</div>
</div>
</div>
</div>
</body>
<script type="text/javascript">
if (window.dialogArguments) {
	var inputs = document.getElementsByTagName("input");
	var b = inputs[inputs.length - 1];
	b.onclick = function click() {
		window.close();
	};
}
</script>
</html>