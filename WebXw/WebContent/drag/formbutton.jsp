<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<meta http-equiv="X-UA-Compatible" content="IE=7" />
<title>�ޱ����ĵ�</title>
<link id="css" rel="stylesheet" href="<%=request.getContextPath()%>/drag/css/style.css" type="text/css" />
<style type="text/css">
body{
margin:0; 
padding:0;
font-family:Verdana, Arial, Helvetica, sans-serif,"";
font-size:12px;
background-color:#FFFFFF;
filter:progid:DXImageTransform.Microsoft.Gradient(gradientType=1,startColorStr=#b8c4cb,endColorStr=#f6f6f8);
}
</style>
<%
    Object value = request.getAttribute("cpuId");
    if(value!=null){
     value=value.toString();
     
    }
   
 %>

<script language="javascript">

 var cpuId = "<%=value%>"; 
 if(cpuId!=null&& cpuId!='null'){
    alert(cpuId);
 }
 
function openDivLeft(parm){
	var frames=window.parent.window.document.getElementById("p2");
	frames.contentWindow.fun16(parm); 
}
function reloadFormXmlInCache(){
	if(confirm("�Ƿ�ͬ������?")){
	  location.href = 'FormForToolBean_reloadFormXmlInCache.action';
	}
}
function readId(){
	if(confirm("�Ƿ��ȡ������?")){
	  location.href = 'FormForToolBean_readId.action';
	}
}
</script>
</head>
<body>
	<div class="tab_w">
		<ul>
			<li class="tab_mid"><a href="javaScript:openDivLeft('searchFormDiv')">�򿪱�</a></li>
			<li class="tab_line"></li>
			<li class="tab_mid"><a href="javaScript:openDivLeft('addForm')">������</a></li>
			<li class="tab_line"></li>
			<li class="tab_mid"><a href="javaScript:reloadFormXmlInCache()">ͬ������</a></li>
			<li class="tab_line"></li>
			<li class="tab_mid"><a href="javaScript:readId()">�������ѯ</a></li>
		</ul>
	</div>
</body>
</html>





