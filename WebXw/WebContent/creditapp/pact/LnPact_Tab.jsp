<%@ page language="java" contentType="text/html; charset=GBK"
	pageEncoding="GBK"%>
<!--<meta http-equiv="X-UA-Compatible" content="IE=Edge,IE=IE8">-->
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8"/>

<%@ include file="/include/tld.jsp"%>
<%@ include file="/include/incTab.jsp"%>
<%
 String dataType =(String) request.getAttribute("dataType"); 
 String cifNo =(String) request.getParameter("cifNo"); 
 String query1 =(String) request.getParameter("query"); 
 System.out.println("query1="+query1);
%>
<html>
<head>
<title>С΢�����˹�ƽ̨����ϵͳ</title>
</head>
<body class="body_bg" style="overflow-y: visible">
<div class="right_bg">
<div class="right_w">
<div class="from_bg">
<div class="right_v">
<form action="#">
<table width="100%" align="center" height="100%">
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
</html>