<%@ page language="java" contentType="text/html; charset=GBK"
	pageEncoding="GBK"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<meta http-equiv="X-UA-Compatible" content="IE=8" />
<%@ include file="/include/tld.jsp"%>
<head>
<title>����һ�廯</title>
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
<%
	String brNo = request.getParameter("brNo");
	String isQuery = request.getParameter("query");
	String ecif_no = request.getParameter("ecif_no");
	
%>
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
		window.open(src, target = "parmsFrame");
	}
}
function getBrNo(){
	var brNo = self.parent.frames["parmsFrame_top"].setBrNo();
	return brNo;
}
function setStepNo(stepNo){
	self.parent.frames["parmsFrame_top"].curStepNo=stepNo;
	return stepNo;
}
function skipCheck() {
	if (getBrNo()=="") {
		changeframe('/WebXw/creditapp/welcome.jsp');
	} else {
		changeframe('<%=contextpath%>/ParamIntegAction_findDetail.action?query=query&brNo='+getBrNo());
	}	
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
		<td class="link360top" colspan="2" style="width:100%; padding:0;">����һ�廯</td>
	</tr>
	<tr class="bb">
		<th scope="col" nowrap="nowrap">
			<i class="clip360t1"></i>׼����Ϣ
		</th>
	</tr>	
	<tr>
		<td class="linktd" nowrap="nowrap">
			<a href="#" class="checkDiv" onclick="changeframe('/WebXw/creditapp/welcome.jsp');">׼����Ϣ����</a>
		</td>
	</tr>
	<tr class="bb">
		<th scope="col">
			<i class="clip360t2"></i>���㷽ʽ����
		</th>
	</tr>
	<tr>
		<td class="linktd">
			<a href="#" onclick="changeframe('<%=contextpath%>/AcFineFormulaAction_findByPage.action?menuno=K0404');setStepNo(1)">��Ϣ��ʽ����</a>
		</td>
	</tr>
	<tr>
		<td class="linktd">
			<a href="#" onclick="changeframe('<%=contextpath%>/AcDamFormulaAction_findByPage.action?menuno=K0404');setStepNo(2)">��ǰ����ΥԼ������</a>
		</td>
	</tr>
	<tr>
		<td class="linktd">
			<a href="#" onclick="changeframe('<%=contextpath%>/AcFeeParmAction_findByPage.action?menuno=K0404');setStepNo(3)">���ö�������</a>
		</td>
	</tr>
	<tr>
		<td class="linktd">
			<a href="#" onclick="changeframe('<%=contextpath%>/AcFeeFormulaAction_findByPage.action?menuno=K0404');setStepNo(4)">���ù�ʽ����</a>
		</td>
	</tr>
	<tr>
		<td class="linktd">
			<a href="#" onclick="changeframe('<%=contextpath%>/AcFeeRateAction_findByPage.action');setStepNo(5)">������������</a>
		</td>
	</tr>
	<tr class="bb">
		<th scope="col">
			<i class="clip360t3"></i>���������
		</th>
	</tr>
	<tr>
		<td class="linktd">
			<a href="#" onclick="changeframe('<%=contextpath%>/AcReplanFormulaAction_findByPage.action?menuno=K0404');setStepNo(6)">����ƻ���ʽ����</a>
		</td>
	</tr>
	<tr>
		<td class="linktd">
			<a href="#" onclick="changeframe('<%=contextpath%>/AcReplanParmAction_findByPage.action?menuno=K0404');setStepNo(7)">���������</a>
		</td>
	</tr>
	<tr class="bb">
		<th scope="col">
			<i class="clip360t2"></i>��Ʒ����
		</th>
	</tr>
	<tr>
		<td class="linktd">
			<a href="#"	onclick="changeframe('<%=contextpath%>/ParamIntegAction_getPrdtList.action?brNo='+getBrNo()+'&menuno=K0404');setStepNo(8)">��Ʒ����</a>
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