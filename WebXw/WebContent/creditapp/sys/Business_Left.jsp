<%@ page language="java" contentType="text/html; charset=GBK"
	pageEncoding="GBK"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<meta http-equiv="X-UA-Compatible" content="IE=8" />
<%@ include file="/include/tld.jsp"%>
<head>
<title>ҵ��</title>
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
		window.open(src, target = "businessFrame");
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
		<td class="link360top" colspan="2" style="width:100%; padding:0;">ҵ�����</td>
	</tr>
	<tr class="bb">
		<th scope="col" nowrap="nowrap">
			<i class="clip360t1"></i>ָ��ά��
		</th>
	</tr>	
	<tr>
		<td class="linktd" nowrap="nowrap">
			<a href="#" class="checkDiv" onclick="changeframe('<%=contextpath%>/ParmRewRuleAction_findByPage.action?menuno=K0404');">ɸ��������</a>
		</td>
	</tr>
	<!--<tr class="bb">
		<th scope="col" nowrap="nowrap">
			<i class="clip360t2"></i>Ӱ�����
		</th>
	</tr>	
	<tr>
		<td class="linktd" nowrap="nowrap">
			<a href="#" onclick="changeframe('<%=contextpath%>/PacSceneAction_findByPage.action');">Ӱ�񳡾�����</a>
		</td>
	</tr>
	<tr>
		<td class="linktd" nowrap="nowrap">
			<a href="#" onclick="changeframe('<%=contextpath%>/PacTypeAction_findByPage.action');">Ӱ����������</a>
		</td>
	</tr>
	<tr>
		<td class="linktd" nowrap="nowrap">
			<a href="#" onclick="changeframe('<%=contextpath%>/PacBaseAction_findByPage.action');">Ӱ��洢��Ϣ</a>
		</td>
	</tr>
	<tr>
		<td class="linktd" nowrap="nowrap">
			<a href="#" onclick="changeframe('<%=contextpath%>/PntTmplAction_findByPage.action');">��ӡģ������</a>
		</td>
	</tr>
	<tr>
		<td class="linktd" nowrap="nowrap">
			<a href="#" onclick="changeframe('<%=contextpath%>/ProdPntRelAction_findByPage.action');">ҵ�����ӡģ���ϵ����</a>
		</td>
	</tr>-->
	<tr class="bb">
		<th scope="col" nowrap="nowrap">
			<i class="clip360t3"></i>���̹���
		</th>
	</tr>	
	<tr>
		<td class="linktd" nowrap="nowrap">
			<a href="#" onclick="changeframe('<%=contextpath%>/WkfApprovalRoleAction_findByPage.action?menuno=K0404');">������ɫά��</a>
		</td>
	</tr>
	<tr>
		<td class="linktd" nowrap="nowrap">
			<a href="#" onclick="changeframe('<%=contextpath%>/WkfApprovalUserAction_findByPage.action?menuno=K0404');">������Աά��</a>
		</td>
	</tr>
	<tr>
		<td class="linktd" nowrap="nowrap">
			<a href="#" onclick="changeframe('<%=contextpath%>/AppWkfcfgAction_findByPage.action?menuno=K0404');">�����������</a>
		</td>
	</tr>
	<!--
	<tr>
		<td class="linktd" nowrap="nowrap">
			<a href="#" onclick="changeframe('<%=contextpath%>/PntTmplAction_findByPage.action');">��ӡģ������</a>
		</td>
	</tr>
	<tr>
		<td class="linktd" nowrap="nowrap">
			<a href="#" onclick="changeframe('<%=contextpath%>/ProdPntRelAction_findByPage.action');">ҵ�����ӡģ���ϵ����</a>
		</td>
	</tr> -->
	
	<tr class="bb">
		<th scope="col" nowrap="nowrap">
			<i class="clip360t1"></i>�������
		</th>
	</tr>	
	<tr>
		<td class="linktd" nowrap="nowrap">
			<a href="#" onclick="changeframe('<%=contextpath%>/ParmRewAction_findByPage.action?menuno=K0404');">����Ԥ������</a>
		</td>
	</tr>
	<tr>
		<td class="linktd" nowrap="nowrap">
			<a href="#" onclick="changeframe('<%=contextpath%>/ParmFiveConfAction_findByPage.action?menuno=K0404');">�弶�������</a>
		</td>
	</tr>
	<!--
	<tr>
		<td class="linktd" nowrap="nowrap">
			<a href="#" onclick="changeframe('<%=contextpath%>/RiskMatrixAction_findByPage.action');">�弶����ģ��</a>
		</td>
	</tr>
	<tr>
		<td class="linktd" nowrap="nowrap">
			<a href="#" onclick="changeframe('<%=contextpath%>/AftRegularParmAction_findByPage.action');">���������</a>
		</td>
	</tr> -->
	<!--
	<tr class="bb">
		<th scope="col" nowrap="nowrap">
			<i class="clip360t2"></i>ҵ��ά��
		</th>
	</tr>	
	<tr>
		<td class="linktd" nowrap="nowrap">
			<a href="#" onclick="changeframe('<%=contextpath%>/ApplyBaseAction_findByPageAll.action?menuno=L0205');">������Ϣά��</a>
		</td>
	</tr>
	<tr>
		<td class="linktd" nowrap="nowrap">
			<a href="#" onclick="changeframe('<%=contextpath%>/MessageInfoAction_findByPage.action?menuno=L0204');">������Ϣ����</a>
		</td>
	</tr>
	<tr>
		<td class="linktd" nowrap="nowrap">
			<a href="#" onclick="changeframe('<%=contextpath%>/LnPactAction_findByPage.action?menuno=L0206');">��ͬ��Ϣά��</a>
		</td>
	</tr>
	<tr>
		<td class="linktd" nowrap="nowrap">
			<a href="#" onclick="changeframe('<%=contextpath%>/LnNoteAction_findByPageAll.action?menuno=L0207');">������Ϣά��</a>
		</td>
	</tr>
	-->
<!--
	<tr class="bb">
		<th scope="col" nowrap="nowrap">
			<i class="clip360t3"></i>��Ȩ����
		</th>
	</tr>	
	<tr>
		<td class="linktd" nowrap="nowrap">
			<a href="#" onclick="changeframe('<%=contextpath%>/ProdBrnoAction_showFrame.action');">������Ʒ��Ȩ</a>
		</td>
	</tr>
	<tr>
		<td class="linktd" nowrap="nowrap">
			<a href="#" onclick="changeframe('<%=contextpath%>/LoanLimitationAction_findByPage.action');">����Ͷ�Ŷ�ȹ���</a>
		</td>
	</tr> -->
	<tr class="bb">
		<th scope="col" nowrap="nowrap">
			<i class="clip360t2"></i>֪ʶ�����
		</th>
	</tr>	
<!--	<tr>-->
<!--		<td class="linktd" nowrap="nowrap">-->
<!--			<a href="#" onclick="changeframe('<%=contextpath%>/ParmOpinConfAction_findByPage.action?menuno=K0404');">��������</a>-->
<!--		</td>-->
<!--	</tr>-->
	<tr>
		<td class="linktd" nowrap="nowrap">
			<a href="#" onclick="changeframe('<%=contextpath%>/VersionInfoAction_findByPage.action?menuno=K0404');">�汾����</a>
		</td>
	</tr>
	<tr>
		<td class="linktd" nowrap="nowrap">
			<a href="#" onclick="changeframe('<%=contextpath%>/AcComHolidayAction_findByPage.action?menuno=K0404');">�ڼ��չ���</a>
		</td>
	</tr>
	<tr>
		<td class="linktd" nowrap="nowrap">
			<a href="#" onclick="changeframe('<%=contextpath%>/PubNoteAction_findByAll.action?menuno=K0404');">֪ʶ�����</a>
		</td>
	</tr>
	<tr class="bb">
		<th scope="col">
			<i class="clip360t2"></i>Ӱ�����
		</th>
	</tr>
	<tr>
		<td class="linktd">
			<a href="#"	onclick="changeframe('<%=contextpath%>/DocConfigAction_findByPage.action?&menuno=K0404');">Ӱ���ĵ�����</a>
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