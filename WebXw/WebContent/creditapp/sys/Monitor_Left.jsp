<%@ page language="java" contentType="text/html; charset=GBK"
	pageEncoding="GBK"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<meta http-equiv="X-UA-Compatible" content="IE=8" />
<%@ include file="/include/tld.jsp"%>
<head>
<title>���</title>
<style>
html,body {
	margin: 0;
	padding: 0;
	overflow: hidden;
	height: 100%;
	width: 100%;
}
.checkDiv{
	color: orange !important;
	font-weight: bolder;
}
</style>
<script type="text/javascript">
$(document).ready(function(){
	$("#info_view").find("a").click(function(){
		goMenu(this);
	});
});
function getBg(num) {
	for ( var id = 0; id < 3; id++) {
		if (id == num) {
			document.getElementById("mynav" + id).className = "current";
		} else {
			document.getElementById("mynav" + id).className = "";
		}
	}
}
function changeColor(mythis){
	if(null!=document.getElementById('message')&&undefined!=document.getElementById('message')&&''!=document.getElementById('message')){
		var fuck=document.getElementById("message");
		fuck.removeAttribute('id');
		fuck.style.color='';
		mythis.style.color='#c0c0c0';
	 	mythis.setAttribute('id','message');
	}else{
		mythis.setAttribute('id','message');
	 	document.getElementById('message').style.color='#c0c0c0';
	}
}
function goMenu(obj){
	$(obj).parent().parent().parent().find(".linktd").find("a").each(function(){
	//alert($(this).text());
	$(this).removeClass("checkDiv");
	});
	$(obj).addClass("checkDiv");
}
function changeframe(src) {
	if (src != "") {
		window.open(src, target = "monitorFrame");
	}
}
function setStepNo(stepNo){
	self.parent.frames["parmsFrame_top"].curStepNo=stepNo;
	return stepNo;
}
function skipCheck() {
	changeframe('ParamIntegAction_findDetail.action?query=query&brNo='+getBrNo());
}
</script>
</head>
<body class="body_bg">
<div class="info_left">
<div style="width:100%; background-color:rgb(240,240,241)">
<div style="width:100%; background-color:transparent">
<div style="width:100%; background-color:transparent">
<div style="width:100%; text-align:center;">
<table align="left" width="100%" border="0" cellspacing="0" id="info_view"
	cellpadding="0" class="info_list">
	<tr>
		<td class="link360top" colspan="2" style="width:100%; padding:0;">���</td>
	</tr>
	<tr class="bb">
		<th scope="col" nowrap="nowrap">
			<i class="clip360t1"></i>ҵ����
		</th>
	</tr>	
	<tr>
		<td class="linktd" nowrap="nowrap">
			<a href="#" class="checkDiv" onclick="changeframe('<%=contextpath%>/LnApplyMidAction_findByPageToLnFail.action?menuno=K0404');">����ʧ��ҵ��</a>
		</td>
	</tr>
	<tr>
		<td class="linktd" nowrap="nowrap">
			<a href="#" onclick="changeframe('<%=contextpath%>/AcLnMstAction_findByPageToLoanFail.action?menuno=K0404');">�ſ�ʧ��ҵ��</a>
		</td>
	</tr>
		<tr>
		<td class="linktd" nowrap="nowrap">
			<a href="#" onclick="changeframe('http://10.7.101.38:8888/index.html');">��Ϣ���м��</a>
		</td>
	<!--</tr>
	
		<tr>
		<td class="linktd" nowrap="nowrap">
			<a href="#" onclick="changeframe('http://10.7.101.38:7001/console/');">WebLogic����̨</a>
		</td>
	</tr>-->

	<tr class="bb">
		<th scope="col" nowrap="nowrap">
			<i class="clip360t2"></i>����ƽ̨
		</th>
	</tr>	
	<tr>
		<td class="linktd" nowrap="nowrap">
			<a href="#" onclick="changeframe('<%=contextpath%>/SysGlobalAction_getSysGlobal.action?menuno=K0404');">ϵͳ״̬����</a>
			<!-- 
			<a href="#" onclick="changeframe('<%=contextpath%>/BatchGraphAction_createBatchGraph.action?menuno=K0404');">�������</a>
			 -->
		</td>
	</tr>
		<tr>
		<td class="linktd" nowrap="nowrap">
			<a href="#" onclick="changeframe('<%=contextpath%>/creditapp/batch/newGraph/showGraphIndex.jsp');">�������</a>
			<!-- 
			<a href="#" onclick="changeframe('<%=contextpath%>/BatchGraphAction_createBatchGraph.action?menuno=K0404');">�������</a>
			 -->
		</td>
	</tr>
</table>
</div>
</div>
</div>
</div>
</div>
</body>
</html>