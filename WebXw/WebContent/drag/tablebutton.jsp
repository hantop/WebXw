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

<script language="javascript">
function openDivLeft(parm){
	var frames=window.parent.window.document.getElementById("p2");
	frames.contentWindow.fun13(parm); 

}
function reloadTableXmlInCache(){
	if(confirm("�Ƿ�ͬ������?")){
	  location.href = 'TableForToolBean_reloadTableXmlInCache.action';
	}
}
</script>
</head>

<body >
	<div class="tab_w" style="width:758px;_width:760px;">
	<ul>
	<li class="tab_mid"><a href="javaScript:openDivLeft('searchTableDiv')">��ѯ�б�</a></li>
	<li class="tab_line"></li>
	<li class="tab_mid"><a href="javaScript:openDivLeft('addTable')">�����б�</a></li>
	<li class="tab_line"></li>
	<li class="tab_mid"><a href="javaScript:reloadTableXmlInCache()">ͬ������</a></li>
	</ul>
	</div>
</body>
</html>