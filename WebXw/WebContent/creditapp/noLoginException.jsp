<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=GBK" %>
<%@ include file="/include/tld.jsp"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head><title>һ���쳣</title>
<script type="text/javascript" language="javascript">
   funcExit();
		function funcExit(){		
		 //parent.location.href='login.jsp';
		 alert("�Բ���������δ��¼��ʱ��δ���в������Ự�Ѿ�ʧЧ�������µ�¼ϵͳ��")
		 window.top.location.href='<%=basePath %>cmsindex.jsp';
		}
</script>
</head>
<body>
    
    <br/>
    <br/>
    
	<!--<s:actionmessage/>-->
	  
    <!--<input type="button"  value=" �� �� " onclick="javascript:funcExit()"/>-->
</body>
</html>
