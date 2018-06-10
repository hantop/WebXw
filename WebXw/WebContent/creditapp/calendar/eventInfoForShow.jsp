<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@page import="app.creditapp.sys.entity.DailyEvent" %>

<%
DailyEvent dailyEvent = (DailyEvent)request.getAttribute("dailyEvent");

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<meta http-equiv="X-UA-Compatible" content="IE=11" />
<link rel='stylesheet' href='<%=request.getContextPath()%>/creditapp/calendar/css/jquery-ui.css' />
<title>������</title>
<style type="text/css">
	input,textarea,select { display:inline-block; margin-right:3px; vertical-align:middle;}
	body table{font-size: 13px;}
	table td{min-height: 25px;vertical-align: middle;}
</style>
<script src='<%=request.getContextPath()%>/creditapp/calendar/js/jquery-form.js'></script>
</head>
<body>
<div class="fancy2" id="rootDiv">
	<h3 style="font-size: 16px;margin-bottom: 5px;margin-top: 5px;" id="htitle"><%= dailyEvent.getTitle() %> �鿴 </h3>
    <form id="add_form" action="insertNewEvent.action" method="post">
    <hr>
	    <table width="100%" height="100%" border="0">
	    	<tr>
	    	<td valign="middle" width="25%"><span class="spanTitle" style="font-weight: bold;color: gray;" >Ԥ��ʱ��:</span></td>
	    	<td><%= dailyEvent.getStartTime() %></td>
	    	</tr>
	    	<tr>
	    	<td valign="middle"><span class="spanTitle" style="font-weight: bold;color: gray;" >Ԥ����Ϣ����:</span></td>
	    	<td><%= dailyEvent.getEventdesc() %></td>
	    	</tr>
	    </table>
	    <div class="sub_btn" style="margin-top: 15px">
	    	<input type="button" class="btn btn_cancel" value="ȡ��" onClick="$.fancybox.close()">
	    </div>
	   	<br/>
    </form>
</div>
<script type="text/javascript">
$(function(){
	//$("#rootDiv").height(200);	
	$.fancybox.resize();//�����߶�����Ӧ
});

</script>

</body>
</html>